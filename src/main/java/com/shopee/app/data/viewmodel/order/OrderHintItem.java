package com.shopee.app.data.viewmodel.order;

import com.shopee.app.data.viewmodel.OrderDetail;

public class OrderHintItem {
    private OrderDetail orderInfo;
    private String prefix;

    public OrderHintItem(String str, OrderDetail orderDetail) {
        this.prefix = str;
        this.orderInfo = orderDetail;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public OrderDetail getOrderInfo() {
        return this.orderInfo;
    }

    public void setOrderInfo(OrderDetail orderDetail) {
        this.orderInfo = orderDetail;
    }
}
