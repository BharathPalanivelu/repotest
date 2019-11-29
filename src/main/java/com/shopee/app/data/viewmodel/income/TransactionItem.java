package com.shopee.app.data.viewmodel.income;

import java.util.ArrayList;
import java.util.List;

public class TransactionItem {
    public static final int TIME_NOT_SET = -1;
    private long amount;
    private String customerName;
    private List<String> image = new ArrayList();
    private int maxTime = -1;
    private int minTime = -1;
    private long orderId;
    private String orderTitle;
    private int releaseTime;
    private int shopId;
    private int status;
    private int time;
    private boolean usingWallet;

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String str) {
        this.customerName = str;
    }

    public List<String> getImage() {
        return this.image;
    }

    public void setImage(List<String> list) {
        this.image = list;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public long getAmount() {
        return this.amount;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setReleaseTime(int i) {
        this.releaseTime = i;
    }

    public int getReleaseTime() {
        return this.releaseTime;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isVerified() {
        return this.status == 3;
    }

    public String getOrderTitle() {
        return this.orderTitle;
    }

    public void setOrderTitle(String str) {
        this.orderTitle = str;
    }

    public int getMinTime() {
        return this.minTime;
    }

    public void setMinTime(int i) {
        this.minTime = i;
    }

    public int getMaxTime() {
        return this.maxTime;
    }

    public void setMaxTime(int i) {
        this.maxTime = i;
    }

    public String toString() {
        return "TransactionItem{customerName='" + this.customerName + '\'' + ", orderTitle='" + this.orderTitle + '\'' + ", image=" + this.image + ", amount=" + this.amount + ", time=" + this.time + ", releaseTime=" + this.releaseTime + ", shopId=" + this.shopId + ", orderId=" + this.orderId + ", status=" + this.status + ", minTime=" + this.minTime + ", maxTime=" + this.maxTime + ", usingWallet=" + this.usingWallet + '}';
    }

    public void setUsingWallet(boolean z) {
        this.usingWallet = z;
    }

    public boolean isUsingWallet() {
        return this.usingWallet;
    }
}
