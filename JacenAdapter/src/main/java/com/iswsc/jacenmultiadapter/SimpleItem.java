package com.iswsc.jacenmultiadapter;

/**
 * 简单实现item
 * @author jacen
 * @date 2021/3/31 16:36
 * @email jacen@iswsc.com
 */
public abstract  class SimpleItem<D> extends BaseViewItem<D,BaseViewHolder>  {
    int layoutId;
    public SimpleItem(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public int getViewHolderLayoutId() {
        return layoutId;
    }
}
