package com.iswsc.jacenadapter.bean;

import com.iswsc.jacenmultiadapter.IViewItem;

/**
 * @author jacen
 * @date 2021/3/31 15:59
 * @email jacen@iswsc.com
 */
public class UserInfoBean3 implements IViewItem{
    private String userInfo3;

    public UserInfoBean3(String userInfo) {
        this.userInfo3 = userInfo;
    }

    public String getUserInfo3() {
        return userInfo3;
    }

    public void setUserInfo3(String userInfo3) {
        this.userInfo3 = userInfo3;
    }

    @Override
    public int getIViewItemType() {
        return 2;
    }
}
