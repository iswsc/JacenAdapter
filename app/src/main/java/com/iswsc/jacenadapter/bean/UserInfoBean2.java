package com.iswsc.jacenadapter.bean;

import com.iswsc.jacenmultiadapter.IViewItem;

/**
 * @author jacen
 * @date 2021/3/31 15:59
 * @email jacen@iswsc.com
 */
public class UserInfoBean2 implements IViewItem{
    private String userInfo2;

    public UserInfoBean2(String userInfo) {
        this.userInfo2 = userInfo;
    }

    public String getUserInfo2() {
        return userInfo2;
    }

    public void setUserInfo2(String userInfo2) {
        this.userInfo2 = userInfo2;
    }

    @Override
    public int getIViewItemType() {
        return 1;
    }
}
