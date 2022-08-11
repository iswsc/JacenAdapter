package com.iswsc.jacenmultiadapter;

import android.content.Context;

import java.util.List;

/**
 * @author jacen
 * @date 2022/8/11 5:10 下午
 * @email jacen@iswsc.com
 */
public class JacenAdapter<D> extends BaseAdapter<D,BaseViewHolder>{

    @SafeVarargs
    public JacenAdapter(Context context, BaseViewItem<D, BaseViewHolder>... item) {
        super(context, item);
    }
    @SafeVarargs
    public JacenAdapter(Context context, List<D> mList, BaseViewItem<D, BaseViewHolder>... item) {
        super(context, mList, item);
    }

    @SafeVarargs
    public JacenAdapter(Context context, List<D> mList, int[] keys, BaseViewItem<D, BaseViewHolder>... item) {
        super(context, mList, keys, item);
    }
}
