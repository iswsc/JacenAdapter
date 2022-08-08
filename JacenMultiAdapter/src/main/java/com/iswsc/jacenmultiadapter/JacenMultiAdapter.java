package com.iswsc.jacenmultiadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacen on 2017/12/31 0:51.
 * @version 1.0
 * @email jacen@iswsc.com
 */
@Deprecated
public class JacenMultiAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    protected Context context;
    protected OnItemClickListener clickListener;
    protected OnItemLongClickListener longClickListener;
    protected List<T> mList;

    protected SparseArray<AbsBaseViewItem<T, BaseViewHolder>> sparseArray;

    @Deprecated
    public void setOnClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Deprecated
    public void setOnLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener){
        this.longClickListener = longClickListener;
    }

    /**
     * 如果是单布局 则sparseArray.put(0,IViewItemImpl);
     *
     * @param context 上下文
     * @param item    多布局 单布局key为0 多布局 请实现{@link IViewItem}
     */
    public JacenMultiAdapter(Context context, AbsBaseViewItem<T, BaseViewHolder> item) {
        this(context, null, new int[]{0}, item);
    }

    /**
     * 如果是单布局 则sparseArray.put(0,IViewItemImpl);
     *
     * @param context 上下文
     * @param mList   数据源
     * @param item    多布局 单布局key为0 多布局 请实现{@link IViewItem}
     */
    public JacenMultiAdapter(Context context, List<T> mList, AbsBaseViewItem<T, BaseViewHolder>... item) {
        this(context, mList, null, item);
    }

    /**
     * 如果是单布局 则sparseArray.put(0,IViewItemImpl);
     *
     * @param context 上下文
     * @param mList   数据源
     * @param item    多布局 单布局key为0 多布局 请实现{@link IViewItem}
     */
    public JacenMultiAdapter(Context context, List<T> mList, AbsBaseViewItem<T, BaseViewHolder> item) {
        this(context, mList, new int[]{0}, item);
    }

    /**
     * 如果是单布局 则sparseArray.put(0,IViewItemImpl);
     *
     * @param context 上下文
     * @param mList   数据源
     * @param item    多布局 单布局key为0 多布局 请实现{@link IViewItem}
     */
    public JacenMultiAdapter(Context context, List<T> mList, int[] keys, AbsBaseViewItem<T, BaseViewHolder>... item) {
        this.context = context;
        this.mList = mList;
        if(keys == null){
            keys = new int[item.length];
            for (int i = 0; i < item.length; i++) {
                keys[i] = i;
            }
        }
        if (keys.length != item.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("keys.length != item.length %d!=%d", keys.length, item.length));
        }
        sparseArray = new SparseArray<>(item.length);
        for (int i = 0; i < item.length; i++) {
            sparseArray.put(keys[i], item[i]);
        }
    }

    @Override
    @NonNull
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AbsBaseViewItem<T, BaseViewHolder> viewItem = sparseArray.get(viewType);
        checkViewItemIsNull(viewItem, viewType);
        BaseViewHolder holder = viewItem.onCreateViewHolder(context, parent);
        holder.setOnClickListener(clickListener);
        holder.setOnLongClickListener(longClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        AbsBaseViewItem<T, BaseViewHolder> viewItem = sparseArray.get(itemViewType);
        checkViewItemIsNull(viewItem, itemViewType);
        viewItem.onBindViewHolder(holder, mList.get(position), position);
    }

    private void checkViewItemIsNull(AbsBaseViewItem<T, BaseViewHolder> viewItem, int itemViewType) {
        if (viewItem == null) {
            throw new NullPointerException(String.format("itemViewType = %s is not implement", itemViewType));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof IViewItem) {
            return ((IViewItem) mList.get(position)).getIViewItemType();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void updateList(List<T> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void addData(T data, int position) {
        if (mList == null) {
            mList = new ArrayList<T>();
        }
        mList.add(position, data);

        notifyItemInserted(position);
        notifyItemChanged(position, "add");
        if (position != mList.size()) {
            notifyItemRangeChanged(position, mList.size() - position);
        }
    }

    public void addData(T data) {
        addData(data, getItemCount());
    }

    public void addData(List<T> datas, int position) {
        if (datas == null || datas.isEmpty()) {
            return;
        }
        if (mList == null) {
            mList = new ArrayList<T>();
        }
        mList.addAll(position, datas);
        notifyItemRangeInserted(position, datas.size());
//        notifyItemInserted(position,datas.size());
//        notifyItemChanged(position,"adds");
        notifyItemRangeChanged(position, datas.size(), "adds");
    }

    public void updateData(T data, int position) {
        if (mList == null) {
            return;
        }
        mList.remove(position);
        mList.add(position, data);
        notifyItemChanged(position, "update");
    }


    public T getData(int position) {
        return mList != null ? mList.get(position) : null;
    }

    public List<T> getList() {
        return mList;
    }

    public void removeData(int position) {
        mList.remove(position);

        notifyItemRemoved(position);
        if (position != mList.size()) {
            notifyItemRangeChanged(position, mList.size() - position);
        }
    }

    public void removeDataNoAnim(int position) {
        mList.remove(position);
        notifyDataSetChanged();
    }
}