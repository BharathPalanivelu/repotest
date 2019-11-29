package com.shopee.app.data.viewmodel.order;

public class OrderListItem {
    private int distinctItemCount;
    private int firstBuyCount;
    private String firstItemImage;
    private String firstItemName;
    private long firstItemPrice;
    private long firstOrderPrice;
    private boolean isRated;
    private long orderId;
    private int orderStatus;
    private String portrait;
    private int totalCount;
    private long totalPrice;
    private int type;
    private int userId;
    private String username;

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public boolean isRated() {
        return this.isRated;
    }

    public void setRated(boolean z) {
        this.isRated = z;
    }

    public String getFirstItemName() {
        return this.firstItemName;
    }

    public void setFirstItemName(String str) {
        this.firstItemName = str;
    }

    public String getFirstItemImage() {
        return this.firstItemImage;
    }

    public void setFirstItemImage(String str) {
        this.firstItemImage = str;
    }

    public long getFirstItemPrice() {
        return this.firstItemPrice;
    }

    public void setFirstItemPrice(long j) {
        this.firstItemPrice = j;
    }

    public long getFirstOrderPrice() {
        return this.firstOrderPrice;
    }

    public void setFirstOrderPrice(long j) {
        this.firstOrderPrice = j;
    }

    public int getFirstBuyCount() {
        return this.firstBuyCount;
    }

    public void setFirstBuyCount(int i) {
        this.firstBuyCount = i;
    }

    public int getDistinctItemCount() {
        return this.distinctItemCount;
    }

    public void setDistinctItemCount(int i) {
        this.distinctItemCount = i;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public long getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(long j) {
        this.totalPrice = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
