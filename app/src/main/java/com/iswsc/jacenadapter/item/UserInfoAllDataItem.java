package com.iswsc.jacenadapter.item;

import com.iswsc.jacenadapter.R;
import com.iswsc.jacenadapter.bean.UserInfoBean;
import com.iswsc.jacenmultiadapter.AbsBaseAllDataViewItem;
import com.iswsc.jacenmultiadapter.BaseViewHolder;

/**
 * @author jacen
 * @date 2021/3/31 16:29
 * @email jacen@iswsc.com
 */
public class UserInfoAllDataItem extends AbsBaseAllDataViewItem<UserInfoBean, BaseViewHolder> {
    @Override
    public int getViewHolderLayoutId() {
        return R.layout.item_text;
    }

    @Override
    public void onAllDataBindViewHolder(BaseViewHolder holder, UserInfoBean data, int position) {
        holder.setText(R.id.content, position + "");
    }
}
