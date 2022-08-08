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
 * @author jacen
 * @date 2022/8/2 2:00 下午
 * @email jacen@iswsc.com
 */
public class JacenAllDataAdapter extends JacenAdapter<IViewItem,BaseViewHolder>{
    public JacenAllDataAdapter(Context context, AbsBaseViewItem<IViewItem, BaseViewHolder>... item) {
        super(context, item);
    }

    public JacenAllDataAdapter(Context context, List<IViewItem> mList, AbsBaseViewItem<IViewItem, BaseViewHolder>... item) {
        super(context, mList, item);
    }

    public JacenAllDataAdapter(Context context, int[] keys, AbsBaseViewItem<IViewItem, BaseViewHolder>... item) {
        super(context, keys, item);
    }

    public JacenAllDataAdapter(Context context, List<IViewItem> mList, int[] keys, AbsBaseViewItem<IViewItem, BaseViewHolder>... item) {
        super(context, mList, keys, item);
    }
}
