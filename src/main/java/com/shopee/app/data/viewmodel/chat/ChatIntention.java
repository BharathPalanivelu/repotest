package com.shopee.app.data.viewmodel.chat;

import android.os.Parcel;
import android.os.Parcelable;

public class ChatIntention implements Parcelable {
    public static final Parcelable.Creator<ChatIntention> CREATOR = new Parcelable.Creator<ChatIntention>() {
        public ChatIntention createFromParcel(Parcel parcel) {
            return new ChatIntention(parcel);
        }

        public ChatIntention[] newArray(int i) {
            return new ChatIntention[i];
        }
    };
    private long attachedId;
    private long itemId;
    private String message;
    private long orderId;
    private int shopId;

    public int describeContents() {
        return 0;
    }

    public ChatIntention(long j, int i, long j2) {
        this.itemId = j;
        this.shopId = i;
        this.orderId = j2;
        this.message = "";
    }

    public ChatIntention(long j, int i, long j2, String str) {
        this.itemId = j;
        this.shopId = i;
        this.orderId = j2;
        this.message = str;
    }

    public ChatIntention(ChatIntention chatIntention) {
        if (chatIntention == null) {
            this.itemId = 0;
            this.shopId = 0;
            this.orderId = 0;
            this.message = "";
            return;
        }
        this.itemId = chatIntention.getItemId();
        this.shopId = chatIntention.getShopId();
        this.orderId = chatIntention.getOrderId();
        this.message = chatIntention.getMessage();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
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

    public long getAttachedId() {
        return this.attachedId;
    }

    public void setAttachedId(long j) {
        this.attachedId = j;
    }

    public boolean isEmpty() {
        return this.orderId <= 0 && this.itemId <= 0 && this.shopId <= 0;
    }

    public boolean forItem() {
        return this.itemId > 0 && this.shopId > 0;
    }

    public boolean forOrder() {
        return this.orderId > 0 && this.shopId > 0;
    }

    public void clear() {
        this.itemId = 0;
        this.shopId = 0;
        this.orderId = 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.itemId);
        parcel.writeInt(this.shopId);
        parcel.writeLong(this.orderId);
        parcel.writeString(this.message);
    }

    protected ChatIntention(Parcel parcel) {
        this.itemId = parcel.readLong();
        this.shopId = parcel.readInt();
        this.orderId = parcel.readLong();
        this.message = parcel.readString();
    }
}
