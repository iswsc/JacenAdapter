package com.iswsc.jacenadapter.item;

import com.iswsc.jacenadapter.R;
import com.iswsc.jacenadapter.bean.UserInfoBean2;
import com.iswsc.jacenmultiadapter.AbsBaseAllDataViewItem;
import com.iswsc.jacenmultiadapter.BaseViewHolder;

/**
 * @author jacen
 * @date 2021/3/31 16:29
 * @email jacen@iswsc.com
 */
public class UserInfoAllData2Item extends AbsBaseAllDataViewItem<UserInfoBean2, BaseViewHolder> {
    @Override
    public int getViewHolderLayoutId() {
        return R.layout.item_text;
    }

    @Override
    public void onAllDataBindViewHolder(BaseViewHolder holder, UserInfoBean2 data, int position) {
        holder.setText(R.id.content, position + "");
    }
}