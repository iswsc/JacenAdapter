package com.iswsc.jacenadapter.item;

import android.view.View;
import android.widget.Toast;

import com.iswsc.jacenadapter.R;
import com.iswsc.jacenadapter.bean.UserInfoBean;
import com.iswsc.jacenmultiadapter.BaseViewHolder;
import com.iswsc.jacenmultiadapter.BaseViewItem;

/**
 * @author jacen
 * @date 2022/8/19 3:06 下午
 * @email jacen@iswsc.com
 */
public class UserItem extends BaseViewItem<UserInfoBean, BaseViewHolder> {
    @Override
    public int getViewHolderLayoutId() {
        return R.layout.item_text;
    }

    @Override
    public int[] addOnClickViewIds() {
        return new int[]{R.id.content};
    }

    @Override
    public int[] addOnLongClickViewIds() {
        return new int[]{R.id.content};
    }

    @Override
    public void onViewClick(View view, UserInfoBean data, int position) {
        super.onViewClick(view, data, position);
        Toast.makeText(context,"onViewClick position = " + position + " userInfo = " + data.getUserInfo(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onViewLongClick(View view, UserInfoBean data, int position) {
        Toast.makeText(context,"onViewLongClick position = " + position + " userInfo = " + data.getUserInfo(),Toast.LENGTH_SHORT).show();
        return super.onViewLongClick(view, data, position);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, UserInfoBean data, int position) {
        holder.setText(R.id.content,data.getUserInfo());
    }
}
