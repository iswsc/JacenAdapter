package com.iswsc.jacenadapter.item

import com.iswsc.jacenadapter.R
import com.iswsc.jacenadapter.bean.UserInfoBean
import com.iswsc.jacenmultiadapter.AbsBaseViewItem
import com.iswsc.jacenmultiadapter.BaseViewHolder
import com.iswsc.jacenmultiadapter.IViewItem

/**
 * @author jacen
 * @date 2021/3/31 16:29
 * @email jacen@iswsc.com
 */
class UserInfoAllDataItem : AbsBaseViewItem<UserInfoBean, BaseViewHolder?>() {
    override fun getViewHolderLayoutId(): Int {
        return R.layout.item_text
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, data: UserInfoBean?, position: Int) {
        holder?.setText(R.id.content, position.toString() + "")

    }

}