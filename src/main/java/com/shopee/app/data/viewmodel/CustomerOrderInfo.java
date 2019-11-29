package com.shopee.app.data.viewmodel;

import java.util.List;

public class CustomerOrderInfo {
    private List<OrderDetail> orderDetailList;
    private int totalCount;
    private String userAvatar;
    private String userName;
    private String userNickName;

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserNickName() {
        return this.userNickName;
    }

    public void setUserNickName(String str) {
        this.userNickName = str;
    }

    public List<OrderDetail> getOrderDetailList() {
        return this.orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> list) {
        this.orderDetailList = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public int getTotalCount() {
        return this.totalCount;
    }
}
