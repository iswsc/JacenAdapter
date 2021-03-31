package com.iswsc.jacenadapter;

import com.iswsc.jacenmultiadapter.IViewItem;

/**
 * @author jacen
 * @date 2021/3/31 15:59
 * @email jacen@iswsc.com
 */
public class UserInfoBean implements IViewItem{
    private String userInfo;

    public UserInfoBean(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public int getIViewItemType() {
        return 0;
    }
}
