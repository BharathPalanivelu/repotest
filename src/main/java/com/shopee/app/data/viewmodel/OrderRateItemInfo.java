package com.shopee.app.data.viewmodel;

public class OrderRateItemInfo {
    private String comment = "";
    private OrderItemInfo orderItemInfo;
    private int rate;

    public OrderItemInfo getOrderItemInfo() {
        return this.orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo2) {
        this.orderItemInfo = orderItemInfo2;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(int i) {
        this.rate = i;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public boolean isRatingGood() {
        return getRate() == 1;
    }
}
