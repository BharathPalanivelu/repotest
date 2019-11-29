package com.shopee.app.data.viewmodel;

public class OfferListItem {
    private long chatId;
    private int flag;
    private boolean isSelling;
    private long itemId;
    private String messageText;
    private int messageTime;
    private long offerPrice;
    private int offerQuantity;
    private int offerStatus;
    private int sellerId;
    private int shopId;
    private int unreadCount;
    private String userAvatar;
    private int userId;
    private String username;

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public int getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(int i) {
        this.sellerId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public boolean isSelling() {
        return this.isSelling;
    }

    public void setSelling(boolean z) {
        this.isSelling = z;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public int getMessageTime() {
        return this.messageTime;
    }

    public void setMessageTime(int i) {
        this.messageTime = i;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String str) {
        this.messageText = str;
    }

    public long getOfferPrice() {
        return this.offerPrice;
    }

    public void setOfferPrice(long j) {
        this.offerPrice = j;
    }

    public int getOfferQuantity() {
        return this.offerQuantity;
    }

    public void setOfferQuantity(int i) {
        this.offerQuantity = i;
    }

    public int getOfferStatus() {
        return this.offerStatus;
    }

    public void setOfferStatus(int i) {
        this.offerStatus = i;
    }

    public long getChatId() {
        return this.chatId;
    }

    public void setChatId(long j) {
        this.chatId = j;
    }

    public boolean offerNew() {
        return this.offerStatus == 1;
    }

    public boolean offerAccepted() {
        return this.offerStatus == 2;
    }

    public boolean offerRejected() {
        return this.offerStatus == 3;
    }

    public boolean offerCancel() {
        return this.offerStatus == 4;
    }

    public boolean offerNone() {
        return this.offerStatus == 0;
    }

    public long getRootId() {
        return this.itemId;
    }

    public void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public boolean isUnread() {
        return this.unreadCount > 0;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }
}
