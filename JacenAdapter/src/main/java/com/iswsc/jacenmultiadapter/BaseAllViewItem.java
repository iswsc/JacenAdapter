package com.iswsc.jacenmultiadapter;

/**
 * 支持所有实现 IViewItem的数据源
 * @author jacen
 * @date 2022/8/11 1:25 下午
 * @email jacen@iswsc.com
 */
public abstract class BaseAllViewItem<D extends IViewItem,VH extends BaseViewHolder> extends BaseViewItem<D, VH> {}
