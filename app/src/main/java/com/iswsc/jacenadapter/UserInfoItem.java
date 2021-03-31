package com.iswsc.jacenadapter;

import com.iswsc.jacenmultiadapter.AbsBaseViewItem;
import com.iswsc.jacenmultiadapter.BaseViewHolder;

/**
 * @author jacen
 * @date 2021/3/31 16:29
 * @email jacen@iswsc.com
 */
public class UserInfoItem extends AbsBaseViewItem<UserInfoBean, BaseViewHolder> {
    @Override
    public int getViewHolderLayoutId() {
        return R.layout.item_text;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, UserInfoBean data, int position) {
        holder.setText(R.id.content, position + "");

    }
}
