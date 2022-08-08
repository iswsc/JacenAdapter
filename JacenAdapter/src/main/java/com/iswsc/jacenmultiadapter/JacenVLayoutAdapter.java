//package com.iswsc.jacenmultiadapter;
//
//import android.content.Context;
//import android.util.SparseArray;
//import android.view.ViewGroup;
//
//import com.alibaba.android.vlayout.DelegateAdapter;
//import com.alibaba.android.vlayout.LayoutHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @version 1.0
// * @email jacen@iswsc.com
// * @author Jacen on 2017/12/31 0:51.
// */
//public class JacenVLayoutAdapter<T extends IViewItem> extends DelegateAdapter.Adapter<BaseViewHolder> {
//
//    protected Context context;
//    protected OnItemClickListener clickListener;
//    protected OnItemLongClickListener longClickListener;
//    protected List<T> mList;
//    /**
//     *  适配vLayout 不同Adapter相同itemType引起的ClassCastException
//     */
//    protected int startItemType = 0;
//
//    protected SparseArray<AbsBaseViewItem<T,BaseViewHolder>> sparseArray;
//
//    protected LayoutHelper layoutHelper;
//    /**
//     *  适配vLayout 不同Adapter相同itemType引起的ClassCastException
//     */
//    public void setStartItemType(int startItemType) {
//        this.startItemType = startItemType;
//    }
//
//    public void setOnClickListener(OnItemClickListener clickListener) {
//        this.clickListener = clickListener;
//    }
//
//    public void setOnLongClickListener(OnItemLongClickListener longClickListener) {
//        this.longClickListener = longClickListener;
//    }
//
//    /**
//     * 如果是单布局 则sparseArray.put(0,IViewItemImpl);
//     * 否则复写getItemViewType(int position)方法 对应的布局 对应的key
//     * @param context
//     * @param mList
//     * @param item 多布局 单布局key为0 多布局 请实现{@link IViewItem}
//     */
//    public JacenVLayoutAdapter(Context context, List<T> mList, LayoutHelper layoutHelper, AbsBaseViewItem<T,BaseViewHolder>...item) {
//        this.context = context;
//        this.mList = mList;
//        this.layoutHelper = layoutHelper;
//        sparseArray = new SparseArray<>(item.length);
//        for (int i = 0; i < item.length; i++) {
//            sparseArray.put(i,item[i]);
//        }
//    }
//
//    /**
//     * 如果是单布局 则sparseArray.put(0,IViewItemImpl);
//     * 否则复写getItemViewType(int position)方法 对应的布局 对应的key
//     * @param context
//     * @param mList
//     * @param item 多布局 单布局key为0 多布局 请实现{@link IViewItem}
//     */
//    public JacenVLayoutAdapter(Context context, List<T> mList,LayoutHelper layoutHelper, int[] keys, AbsBaseViewItem<T,BaseViewHolder>...item) {
//        this.context = context;
//        this.mList = mList;
//        this.layoutHelper = layoutHelper;
//
//        if(keys.length != item.length){
//            throw new ArrayIndexOutOfBoundsException(String.format("keys.length != item.length %d!=%d",keys.length,item.length));
//        }
//        sparseArray = new SparseArray<>(item.length);
//        for (int i = 0; i < item.length; i++) {
//            sparseArray.put(keys[i],item[i]);
//        }
//    }
//
//
//    @Override
//    public LayoutHelper onCreateLayoutHelper() {
//        return layoutHelper;
//    }
//
//    @Override
//    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        BaseViewHolder holder = sparseArray.get(viewType - startItemType).onCreateViewHolder(context,parent);
//        holder.setOnClickListener(clickListener);
//        holder.setOnLongClickListener(longClickListener);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(BaseViewHolder holder, int position) {
//        sparseArray.get(getItemViewType(position) - startItemType).onBindViewHolder(holder,mList.get(position),position);
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return mList.get(position).getIViewItemType() + startItemType;
//    }
//
//    @Override
//    public int getItemCount() {
//        return mList == null ? 0 : mList.size();
//    }
//
//    public void updateList(List<T> mList) {
//        this.mList = mList;
//        notifyDataSetChanged();
//    }
//
//    public void addData(T data,int position){
//        if(data == null){
//            return;
//        }
//        if(mList == null){
//            mList = new ArrayList<T>();
//        }
//        mList.add(position,data);
//
//        notifyItemInserted(position);
//        notifyItemChanged(position,"add");
//        if (position != mList.size()) {
//            notifyItemRangeChanged(position, mList.size() - position);
//        }
//    }
//
//    public void addData(T data){
//        addData(data,getItemCount());
//    }
//
//    public void addData(List<T> datas,int position){
//        if(datas == null || datas.isEmpty()){
//            return;
//        }
//        if(mList == null){
//            mList = new ArrayList<T>();
//        }
//        mList.addAll(position,datas);
//        notifyItemRangeInserted(position,datas.size());
//        notifyItemRangeChanged(position,datas.size(),"adds");
//    }
//
//    public void updateData(T data, int position){
//        if(mList == null){
//            mList = new ArrayList<T>();
//        }
//        if(!mList.isEmpty()){
//            mList.remove(position);
//        }
//        mList.add(position,data);
//        notifyItemChanged(position,"update");
//    }
//
//
//
//    public T getData(int position){
//        return mList != null ? mList.get(position) : null ;
//    }
//
//    public List<T> getList(){
//        return mList;
//    }
//
//    public void removeData(int position){
//        mList.remove(position);
//        notifyItemRemoved(position);
//        if (position != mList.size()) {
//            notifyItemRangeChanged(position, mList.size() - position);
//        }
//    }
//
//    public void removeDataNoAnim(int position){
//        mList.remove(position);
//        notifyDataSetChanged();
//    }
//}