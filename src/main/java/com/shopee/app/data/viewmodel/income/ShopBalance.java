package com.shopee.app.data.viewmodel.income;

public class ShopBalance {
    private long available;
    private String currency;
    private long currentMonth;
    private long currentWeek;
    private long frozen;
    private int lastWithdrawTime;
    private long other;
    private long processing;
    private int shopId;
    private long totalWithdrawn;
    private int userId;
    private long withdrawLimit;

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public long getAvailable() {
        return this.available;
    }

    public void setAvailable(long j) {
        this.available = j;
    }

    public long getFrozen() {
        return this.frozen;
    }

    public void setFrozen(long j) {
        this.frozen = j;
    }

    public long getTotalWithdrawn() {
        return this.totalWithdrawn;
    }

    public void setTotalWithdrawn(long j) {
        this.totalWithdrawn = j;
    }

    public int getLastWithdrawTime() {
        return this.lastWithdrawTime;
    }

    public void setLastWithdrawTime(int i) {
        this.lastWithdrawTime = i;
    }

    public long getProcessing() {
        return this.processing;
    }

    public void setProcessing(long j) {
        this.processing = j;
    }

    public long getOther() {
        return this.other;
    }

    public void setOther(long j) {
        this.other = j;
    }

    public long getWithdrawLimit() {
        return this.withdrawLimit;
    }

    public void setWithdrawLimit(long j) {
        this.withdrawLimit = j;
    }

    public long getCurrentMonth() {
        return this.currentMonth;
    }

    public void setCurrentMonth(long j) {
        this.currentMonth = j;
    }

    public long getCurrentWeek() {
        return this.currentWeek;
    }

    public void setCurrentWeek(long j) {
        this.currentWeek = j;
    }
}
