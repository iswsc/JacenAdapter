package com.iswsc.jacenmultiadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * base
 * @data 2022/8/8 2:59 下午
 * @email jacen@iswsc.com
 * @author Jacen
 */
public class JacenAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    protected Context context;
    protected OnItemClickListener clickListener;
    protected OnItemLongClickListener longClickListener;
    protected List<T> mList;

    protected SparseArray<BaseViewItem<T, BaseViewHolder>> sparseArray;

    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener){
        this.longClickListener = longClickListener;
    }

    public JacenAdapter(Context context, BaseViewItem<T, BaseViewHolder>...item) {
        this(context, null, null, item);
    }

    public JacenAdapter(Context context, List<T> mList, BaseViewItem<T, BaseViewHolder>... item) {
        this(context, mList, null, item);
    }

    /**
     *
     * @param context 上下文
     * @param mList 数据源
     * @param keys 多类型布局使用 viewTypeIds 不传 默认与item个数一致 自动生成 0,1,2,3
     * @param item 多布局 item
     */
    public JacenAdapter(Context context, List<T> mList, int[] keys, BaseViewItem<T, BaseViewHolder>... item) {
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
            item[i].setAdapter(this);
        }
    }

    @Override
    @NonNull
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final BaseViewItem<T, BaseViewHolder> viewItem = sparseArray.get(viewType);
        checkViewItemIsNull(viewItem, viewType);
        final BaseViewHolder holder = viewItem.onCreateViewHolder(context, parent);
        bindViewClickListener(viewItem, holder);
        bindViewLongClickListener(viewItem, holder);
        holder.setOnClickListener(clickListener);
        holder.setOnLongClickListener(longClickListener);
        return holder;
    }

    /**
     * 点击事件
     * @param viewItem
     * @param holder
     */
    private void bindViewClickListener(final BaseViewItem<T, BaseViewHolder> viewItem, final BaseViewHolder holder) {
        int[] clickIds = viewItem.addOnClickViewIds();
        if(clickIds != null){
            for (int clickId : clickIds) {
                holder.getView(clickId).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition();
                        viewItem.onViewClick(v,mList.get(position),position);
                    }
                });
            }
        }
    }

    /**
     * 长按点击事件
     * @param viewItem
     * @param holder
     */
    private void bindViewLongClickListener(final BaseViewItem<T, BaseViewHolder> viewItem, final BaseViewHolder holder) {
        int[] clickIds = viewItem.addOnLongClickViewIds();
        if(clickIds != null){
            for (int clickId : clickIds) {
                holder.getView(clickId).setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int position = holder.getLayoutPosition();
                        return viewItem.onViewLongClick(v,mList.get(position),position);
                    }
                });
            }
        }
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        BaseViewItem<T, BaseViewHolder> viewItem = sparseArray.get(itemViewType);
        checkViewItemIsNull(viewItem, itemViewType);
        viewItem.onBindViewHolder(holder, mList.get(position), position);
    }

    private void checkViewItemIsNull(BaseViewItem<T, BaseViewHolder> viewItem, int itemViewType) {
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