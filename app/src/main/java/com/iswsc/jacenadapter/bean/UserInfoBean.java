package com.iswsc.jacenadapter.bean;

import com.iswsc.jacenmultiadapter.IViewItem;

/**
 * @author jacen
 * @date 2021/3/31 15:59
 * @email jacen@iswsc.com
 */
public class UserInfoBean implements IViewItem{
    private String userInfo;
    private Class clazz;

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public UserInfoBean(String userInfo) {
        this.userInfo = userInfo;
    }
    public UserInfoBean(String userInfo,Class clazz) {
        this.clazz = clazz;
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
