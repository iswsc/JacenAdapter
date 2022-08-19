package com.iswsc.jacenmultiadapter;

import android.view.View;

/**
 * 简单实现item
 * @author jacen
 * @date 2021/3/31 16:36
 * @email jacen@iswsc.com
 */
public abstract  class SimpleViewItem<D> extends BaseViewItem<D,BaseViewHolder>  {
    private View itemView;
    public SimpleViewItem(View itemView) {
        this.itemView = itemView;
    }

    @Override
    public View getViewHolderItemView() {
        return itemView;
    }
}
