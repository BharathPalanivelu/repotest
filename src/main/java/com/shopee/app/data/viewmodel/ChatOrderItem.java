package com.shopee.app.data.viewmodel;

import com.shopee.app.data.store.ak;
import java.util.List;

public class ChatOrderItem extends ChatItem {
    private long amount;
    private List<String> images;
    private boolean isSelling;
    private int itemCount;
    private long itemId;
    private String messageText;
    private int messageUserId;
    private long orderId;
    private String productImage;
    private String productName;
    private int shopId;
    private int toUserId;
    private int unreadCount;
    private String userAvatar;
    private String username;

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public int getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(int i) {
        this.toUserId = i;
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

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String str) {
        this.messageText = str;
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

    public int getMessageUserId() {
        return this.messageUserId;
    }

    public void setMessageUserId(int i) {
        this.messageUserId = i;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(int i) {
        this.itemCount = i;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public boolean isMessageUserMe() {
        return this.messageUserId == ((Integer) ak.a().d().b(-1)).intValue();
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

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public List<String> getImages() {
        return this.images;
    }
}
