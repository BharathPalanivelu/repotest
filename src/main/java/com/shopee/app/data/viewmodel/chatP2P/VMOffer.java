package com.shopee.app.data.viewmodel.chatP2P;

import com.shopee.app.database.orm.bean.chatP2P.DBOffer;

public class VMOffer {
    private int buyCount;
    private int buyerUserid;
    private long chatid;
    private int ctime;
    private long itemid;
    private long modelid;
    private int mtime;
    private long offerPrice;
    private int offerStatus;
    private long offerid;
    private long pchatid;
    private int sellerUserid;
    private int shopid;

    public final long getOfferid() {
        return this.offerid;
    }

    public void setOfferid(long j) {
        this.offerid = j;
    }

    public final long getPchatid() {
        return this.pchatid;
    }

    public void setPchatid(long j) {
        this.pchatid = j;
    }

    public final long getChatid() {
        return this.chatid;
    }

    public void setChatid(long j) {
        this.chatid = j;
    }

    public final int getBuyerUserid() {
        return this.buyerUserid;
    }

    public void setBuyerUserid(int i) {
        this.buyerUserid = i;
    }

    public final int getSellerUserid() {
        return this.sellerUserid;
    }

    public void setSellerUserid(int i) {
        this.sellerUserid = i;
    }

    public final int getShopid() {
        return this.shopid;
    }

    public void setShopid(int i) {
        this.shopid = i;
    }

    public final long getItemid() {
        return this.itemid;
    }

    public void setItemid(long j) {
        this.itemid = j;
    }

    public final long getModelid() {
        return this.modelid;
    }

    public void setModelid(long j) {
        this.modelid = j;
    }

    public final int getBuyCount() {
        return this.buyCount;
    }

    public void setBuyCount(int i) {
        this.buyCount = i;
    }

    public final long getOfferPrice() {
        return this.offerPrice;
    }

    public void setOfferPrice(long j) {
        this.offerPrice = j;
    }

    public final int getOfferStatus() {
        return this.offerStatus;
    }

    public void setOfferStatus(int i) {
        this.offerStatus = i;
    }

    public final int getCtime() {
        return this.ctime;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public final int getMtime() {
        return this.mtime;
    }

    public void setMtime(int i) {
        this.mtime = i;
    }

    public static void map(DBOffer dBOffer, VMOffer vMOffer) {
        vMOffer.setOfferid(dBOffer.a());
        vMOffer.setPchatid(dBOffer.b());
        vMOffer.setChatid(dBOffer.c());
        vMOffer.setBuyerUserid(dBOffer.d());
        vMOffer.setSellerUserid(dBOffer.e());
        vMOffer.setShopid(dBOffer.f());
        vMOffer.setItemid(dBOffer.g());
        vMOffer.setModelid(dBOffer.h());
        vMOffer.setBuyCount(dBOffer.i());
        vMOffer.setOfferPrice(dBOffer.j());
        vMOffer.setOfferStatus(dBOffer.k());
        vMOffer.setCtime(dBOffer.l());
        vMOffer.setMtime(dBOffer.m());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VMOffer)) {
            return false;
        }
        VMOffer vMOffer = (VMOffer) obj;
        if (this.offerid == vMOffer.offerid && this.pchatid == vMOffer.pchatid && this.chatid == vMOffer.chatid && this.buyerUserid == vMOffer.buyerUserid && this.sellerUserid == vMOffer.sellerUserid && this.shopid == vMOffer.shopid && this.itemid == vMOffer.itemid && this.modelid == vMOffer.modelid && this.buyCount == vMOffer.buyCount && this.offerPrice == vMOffer.offerPrice && this.offerStatus == vMOffer.offerStatus && this.ctime == vMOffer.ctime && this.mtime == vMOffer.mtime) {
            return true;
        }
        return false;
    }
}
