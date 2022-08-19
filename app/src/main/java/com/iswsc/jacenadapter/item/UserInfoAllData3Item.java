package com.iswsc.jacenadapter.item;

import android.view.View;
import android.widget.Toast;

import com.iswsc.jacenadapter.R;
import com.iswsc.jacenadapter.bean.UserInfoBean;
import com.iswsc.jacenadapter.bean.UserInfoBean3;
import com.iswsc.jacenmultiadapter.BaseAllViewItem;
import com.iswsc.jacenmultiadapter.BaseViewHolder;

/**
 * @author jacen
 * @date 2021/3/31 16:29
 * @email jacen@iswsc.com
 */
public class UserInfoAllData3Item extends BaseAllViewItem<UserInfoBean3, BaseViewHolder> {
    @Override
    public int getViewHolderLayoutId() {
        return R.layout.item_text;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, UserInfoBean3 data, int position) {
        holder.setText(R.id.content, position + "");

    }
    @Override
    public int[] addOnClickViewIds() {
        return new int[]{R.id.content};
    }

    @Override
    public void onViewClick(View view, UserInfoBean3 data, int position) {
        super.onViewClick(view, data, position);
        Toast.makeText(context," name = " + data.getClass().getName() + " position = " + position,Toast.LENGTH_SHORT).show();
    }
}
