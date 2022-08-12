package com.iswsc.jacenmultiadapter;

import android.content.Context;

import java.util.ArrayList;
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

    /**
     * please use {@link this#updateList2}
     * @param mList 数据源
     */
    @Override
    @Deprecated
    public void updateList(List<IViewItem> mList) {
        super.updateList(mList);
    }

    public <T extends IViewItem> void updateList2(List<T> list){
        updateList(new ArrayList<IViewItem>(list));
    }
    /**
     * please use {@link this#updateList2}
     * @param datas 数据源
     */
    @Override
    @Deprecated
    public void addData(List<IViewItem> datas, int position) {
        super.addData(datas, position);
    }

    public <T extends IViewItem> void addData2(List<T> list,int position){
        if(list== null || list.isEmpty()){
            return;
        }
        addData(new ArrayList<IViewItem>(list),position);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener clickListener) {
        throw new RuntimeException("please use BaseViewItem#onViewLongClick");
    }

    @Override
    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        throw  new RuntimeException("please use BaseViewItem#onViewClick");

    }
}