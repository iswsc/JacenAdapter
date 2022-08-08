package com.iswsc.jacenmultiadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author jacen
 * @date 2018/6/5 22:12
 * @email jacen@iswsc.com
 */
public abstract class AbsBaseViewItem<D, VH extends BaseViewHolder> {

    protected Context context;

    private JacenAdapter<D,VH> mAdapter;
    private int itemCount = 0;
    private List<D> mList;

    protected void setAdapter(JacenAdapter<D,VH> mAdapter) {
        this.mAdapter = mAdapter;
    }

    public int getItemCount() {
        if(mAdapter != null){
            return mAdapter.getItemCount();
        }else {
            return itemCount;
        }
    }
    protected void setItemCount(int itemCount){
        this.itemCount = itemCount;
    }

    public List<D> getList() {
        return mAdapter == null ? mList:mAdapter.getList();
    }

    protected void setList(List<D> mList){
        this.mList = mList;
    }

    /**
     * @param context
     * @param parent
     * @return
     */
    public  VH onCreateViewHolder(Context context, ViewGroup parent){
        this.context = context;
        View view= null;
        if(getViewHolderLayoutId() > 0){
            view = LayoutInflater.from(context).inflate(getViewHolderLayoutId(), parent, false);
        }else{
            view = getItemView();
        }
        VH holder = createBaseViewHolder(view);
        return holder;
    }

    protected VH createBaseViewHolder(View view){
        Class temp = getClass();
        Class z = null;
        while (z == null && null != temp) {
            z = getInstancedGenericVhClass(temp);
            temp = temp.getSuperclass();
        }
        VH vh;
        // 泛型擦除会导致z为null
        if (z == null) {
            vh = (VH) new BaseViewHolder(view);
        } else {
            vh = createGenericVhInstance(z, view);
        }
        return vh != null ? vh : (VH) new BaseViewHolder(view);
    }
    /**
     * try to create Generic VH instance
     *
     * @param z
     * @param view
     * @return
     */
    private VH createGenericVhInstance(Class z, View view) {
        try {
            Constructor constructor;
            // inner and unstatic class
            if (z.isMemberClass() && !Modifier.isStatic(z.getModifiers())) {
                constructor = z.getDeclaredConstructor(getClass(), View.class);
                constructor.setAccessible(true);
                return (VH) constructor.newInstance(this, view);
            } else {
                constructor = z.getDeclaredConstructor(View.class);
                constructor.setAccessible(true);
                return (VH) constructor.newInstance(view);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * get generic parameter VH
     *
     * @param z
     * @return
     */
    private Class getInstancedGenericVhClass(Class z) {
        try {
            Type type = z.getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                for (Type temp : types) {
                    if (temp instanceof Class) {
                        Class tempClass = (Class) temp;
                        if (BaseViewHolder.class.isAssignableFrom(tempClass)) {
                            return tempClass;
                        }
                    } else if (temp instanceof ParameterizedType) {
                        Type rawType = ((ParameterizedType) temp).getRawType();
                        if (rawType instanceof Class && BaseViewHolder.class.isAssignableFrom((Class<?>) rawType)) {
                            return (Class<?>) rawType;
                        }
                    }
                }
            }
        } catch (java.lang.reflect.GenericSignatureFormatError e) {
            e.printStackTrace();
        } catch (TypeNotPresentException e) {
            e.printStackTrace();
        } catch (java.lang.reflect.MalformedParameterizedTypeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载xml布局 优先于{@link this#getItemView}
     * @return
     */
    public abstract int getViewHolderLayoutId();

    /**
     * 使用自定义View 不使用xml{@link this#getViewHolderLayoutId} 加载布局
     * @return
     */
    public View getItemView(){
        return null;
    }

    public abstract void onBindViewHolder(VH holder, D data,int position);


}