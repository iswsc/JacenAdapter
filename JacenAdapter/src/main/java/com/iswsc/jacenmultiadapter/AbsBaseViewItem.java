package com.iswsc.jacenmultiadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * please use {@link BaseViewItem}
 * @author jacen
 * @date 2018/6/5 22:12
 * @email jacen@iswsc.com
 */
@Deprecated
public abstract class AbsBaseViewItem<D, H extends BaseViewHolder> {

    protected Context context;

    private int itemCount;
    private List<D> mList;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<D> getList() {
        return mList;
    }

    public void setList(List<D> mList) {
        this.mList = mList;
    }

    /**
     * @param context
     * @param parent
     * @return
     */
    public  BaseViewHolder onCreateViewHolder(Context context, ViewGroup parent){
        this.context = context;
        return new BaseViewHolder(LayoutInflater.from(context).inflate(getViewHolderLayoutId(), parent, false));
    }

    public abstract int getViewHolderLayoutId();

    public abstract void onBindViewHolder(H holder, D data,int position);


}