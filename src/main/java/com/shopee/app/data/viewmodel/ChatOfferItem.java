package com.shopee.app.data.viewmodel;

import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.ak;
import com.shopee.app.util.au;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class ChatOfferItem extends ChatItem {
    private List<String> buyerAvatars;
    private boolean isSelling;
    private long itemId;
    private String messageText;
    private int messageUserId;
    private int newOfferCount;
    private int offerCount;
    private long offerPrice;
    private int offerQuantity;
    private int offerStatus;
    private String productImage;
    private String productName;
    private int sellerId;
    private int shopId;
    private List<Long> subChatIdList;
    private int unreadCount;
    private String userAvatar;
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

    public long getOfferPrice() {
        return this.offerPrice;
    }

    public String getOfferPriceString() {
        return au.b(this.offerPrice);
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

    public String getOfferStatusString() {
        int i = this.offerStatus;
        if (i == 2) {
            return b.e(R.string.sp_offer_accepted);
        }
        if (i == 3) {
            return b.e(R.string.sp_offer_rejected);
        }
        return i == 4 ? b.e(R.string.sp_label_order_status_canceled) : "";
    }

    public void setOfferStatus(int i) {
        this.offerStatus = i;
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

    public int getOfferCount() {
        return this.offerCount;
    }

    public void setOfferCount(int i) {
        this.offerCount = i;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String str) {
        this.messageText = str;
    }

    public int getMessageUserId() {
        return this.messageUserId;
    }

    public void setMessageUserId(int i) {
        this.messageUserId = i;
    }

    public boolean isMessageUserMe() {
        return this.messageUserId == ((Integer) ak.a().d().b(-1)).intValue();
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

    public void setSubChatIdList(List<Long> list) {
        this.subChatIdList = list;
    }

    public List<Long> getSubChatIdList() {
        return this.subChatIdList;
    }

    public void setBuyerAvatars(List<String> list) {
        this.buyerAvatars = list;
    }

    public List<String> getBuyerAvatars() {
        List<String> list = this.buyerAvatars;
        return list == null ? new ArrayList() : list;
    }

    public void setNewOfferCount(int i) {
        this.newOfferCount = i;
    }

    public int getNewOfferCount() {
        return this.newOfferCount;
    }
}
