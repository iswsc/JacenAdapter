package com.iswsc.jacenmultiadapter;

/**
 * 支持多种数据源 所有的数据源必须实现{@link IViewItem}
 * @author jacen
 * @date 2022/8/2 2:42 下午
 * @email jacen@iswsc.com
 */
public abstract class AbsBaseAllDataViewItem<D extends IViewItem,VH extends BaseViewHolder>  extends AbsBaseViewItem<IViewItem,VH> {

    @Override
    public void onBindViewHolder(BaseViewHolder holder, IViewItem data, int position) {
        onAllDataBindViewHolder(holder, (D) data,position);
    }
    public abstract void onAllDataBindViewHolder(BaseViewHolder holder, D data, int position);

}
