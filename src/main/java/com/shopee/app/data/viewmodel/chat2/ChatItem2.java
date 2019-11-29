package com.shopee.app.data.viewmodel.chat2;

import java.util.ArrayList;
import java.util.List;

public class ChatItem2 {
    public static final String BANNED_IMAGE = "BANNED_IMAGE";
    private String avatar;
    private List<String> images = new ArrayList();
    private long itemId;
    private long lastMsgId;
    private int lastMsgTime;
    private int offerCount;
    private long orderId;
    private long pChatId;
    private String previewImage;
    private int previewStatus;
    private String previewText;
    private String searchKeyword;
    private int shopId;
    private int shopeeVerifiedFlag;
    private String timestamp;
    private int unreadCount;
    private int userId;
    private int userStatus = 1;
    private String username;

    public String getPreviewImage() {
        return this.previewImage;
    }

    public void setPreviewImage(String str) {
        this.previewImage = str;
    }

    public String getPreviewText() {
        return this.previewText;
    }

    public void setPreviewText(String str) {
        this.previewText = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public long getPChatId() {
        return this.pChatId;
    }

    public void setPChatId(long j) {
        this.pChatId = j;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public void setOfferCount(int i) {
        this.offerCount = i;
    }

    public int getOfferCount() {
        return this.offerCount;
    }

    public boolean isUserBanned() {
        return this.userStatus == 2;
    }

    public boolean isUserDeleted() {
        return this.userStatus == 0;
    }

    public void setUserStatus(int i) {
        this.userStatus = i;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public void setSearchKeyword(String str) {
        this.searchKeyword = str;
    }

    public String getSearchKeyword() {
        return this.searchKeyword;
    }

    public int getLastMsgTime() {
        return this.lastMsgTime;
    }

    public void setLastMsgTime(int i) {
        this.lastMsgTime = i;
    }

    public void setLastMsgId(long j) {
        this.lastMsgId = j;
    }

    public long getLastMsgId() {
        return this.lastMsgId;
    }

    public void setPreviewStatus(int i) {
        this.previewStatus = i;
    }

    public int getPreviewStatus() {
        return this.previewStatus;
    }

    public void setShopeeVerifiedFlag(int i) {
        this.shopeeVerifiedFlag = i;
    }

    public boolean isShopVerified() {
        return this.shopeeVerifiedFlag == 1;
    }
}
