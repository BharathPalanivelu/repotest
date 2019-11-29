package com.shopee.app.data.viewmodel.chat;

import com.facebook.common.internal.Objects;
import com.shopee.app.util.au;
import java.util.List;

public class ChatOrderMessage extends ChatMessage {
    private long checkoutId;
    private String currency;
    private List<String> imageList;
    private int listType;
    private String orderSN;
    private String orderStatus;
    private int returnRequested;
    private long totalPrice;

    public long getCheckoutId() {
        return this.checkoutId;
    }

    public void setCheckoutId(long j) {
        this.checkoutId = j;
    }

    public long getTotalPrice() {
        return this.totalPrice;
    }

    public String getTotalPriceStr() {
        return au.a(this.totalPrice, this.currency);
    }

    public void setTotalPrice(long j) {
        this.totalPrice = j;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public List<String> getImageList() {
        return this.imageList;
    }

    public void setImageList(List<String> list) {
        this.imageList = list;
    }

    public int getListType() {
        return this.listType;
    }

    public void setListType(int i) {
        this.listType = i;
    }

    public String getOrderSN() {
        return this.orderSN;
    }

    public void setOrderSN(String str) {
        this.orderSN = str;
    }

    public void setReturnRequested(int i) {
        this.returnRequested = i;
    }

    public int isReturnRequested() {
        return this.returnRequested;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatOrderMessage) || !super.equals(obj)) {
            return false;
        }
        ChatOrderMessage chatOrderMessage = (ChatOrderMessage) obj;
        if (this.checkoutId != chatOrderMessage.checkoutId || this.totalPrice != chatOrderMessage.totalPrice || this.listType != chatOrderMessage.listType || this.returnRequested != chatOrderMessage.returnRequested || !Objects.equal(this.orderSN, chatOrderMessage.orderSN) || !Objects.equal(this.currency, chatOrderMessage.currency) || !Objects.equal(this.orderStatus, chatOrderMessage.orderStatus) || !Objects.equal(this.imageList, chatOrderMessage.imageList)) {
            return false;
        }
        return true;
    }
}
