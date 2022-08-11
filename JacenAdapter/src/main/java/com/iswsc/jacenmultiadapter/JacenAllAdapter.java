package com.iswsc.jacenmultiadapter;

import android.content.Context;

import java.util.List;

/**
 * 全数据类型支持适配器 所有数据源必须 实现{@link IViewItem} 这个接口类
 * @data 2022/8/8 2:59 下午
 * @email jacen@iswsc.com
 * @author Jacen
 */
public class JacenAllAdapter extends JacenAdapter<IViewItem> {

    public JacenAllAdapter(Context context, BaseAllViewItem... item) {
        super(context, item);
    }

    public JacenAllAdapter(Context context, List<IViewItem> mList, BaseAllViewItem... item) {
        super(context, mList, item);
    }

    public JacenAllAdapter(Context context, List<IViewItem> mList, int[] keys, BaseAllViewItem... item) {
        super(context, mList, keys, item);
    }
}