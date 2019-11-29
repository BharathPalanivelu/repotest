package com.shopee.app.data.viewmodel;

import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.h.m;

public class OrderKey {
    public final int listType;
    public final int uType;

    public OrderKey(int i, int i2) {
        this.uType = i;
        this.listType = i2;
    }

    public OrderKey(boolean z, int i) {
        this.uType = z ? 1 : 0;
        this.listType = i;
    }

    public OrderKey(DBOrderDetail dBOrderDetail) {
        this.uType = m.a(dBOrderDetail.b()) ? 1 : 0;
        this.listType = dBOrderDetail.N();
    }

    public static OrderKey with(int i, int i2) {
        return new OrderKey(m.a(i) ? 1 : 0, i2);
    }

    public String getKey() {
        return encodeType(this.uType, this.listType);
    }

    private String encodeType(int i, int i2) {
        return String.valueOf((i * 10000) + i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OrderKey)) {
            return false;
        }
        OrderKey orderKey = (OrderKey) obj;
        if (this.uType == orderKey.uType && this.listType == orderKey.listType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.uType * 10000) + this.listType;
    }
}
