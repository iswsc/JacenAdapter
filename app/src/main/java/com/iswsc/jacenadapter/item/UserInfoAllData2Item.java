package com.iswsc.jacenadapter.item;

import android.view.View;
import android.widget.Toast;

import com.iswsc.jacenadapter.R;
import com.iswsc.jacenadapter.bean.UserInfoBean2;
import com.iswsc.jacenadapter.bean.UserInfoBean3;
import com.iswsc.jacenmultiadapter.BaseAllViewItem;
import com.iswsc.jacenmultiadapter.BaseViewHolder;

/**
 * @author jacen
 * @date 2021/3/31 16:29
 * @email jacen@iswsc.com
 */
public class UserInfoAllData2Item extends BaseAllViewItem<UserInfoBean2, BaseViewHolder> {
    @Override
    public int getViewHolderLayoutId() {
        return R.layout.item_text;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, UserInfoBean2 data, int position) {
        holder.setText(R.id.content, position + "");

    }
    @Override
    public int[] addOnClickViewIds() {
        return new int[]{R.id.content};
    }

    @Override
    public void onViewClick(View view, UserInfoBean2 data, int position) {
        super.onViewClick(view, data, position);
        Toast.makeText(context," name = " + data.getClass().getName() + " position = " + position,Toast.LENGTH_SHORT).show();
    }
}
