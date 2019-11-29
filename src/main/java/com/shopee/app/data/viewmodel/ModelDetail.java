package com.shopee.app.data.viewmodel;

import java.util.List;

public class ModelDetail {
    public static final int MODEL_ID_NOT_SET = 0;
    private String currency;
    private String displayPrice;
    private String displayStock;
    private long itemId = 0;
    private long modelId = 0;
    private String name;
    private long price;
    private long priceBeforeDiscount;
    private long promotionid;
    private long rebatePrice;
    private int sold;
    private int status;
    private int stock;
    private List<Integer> tierIndexes;

    public long getModelId() {
        return this.modelId;
    }

    public void setModelId(long j) {
        this.modelId = j;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(long j) {
        this.price = j;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int i) {
        this.stock = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getDisplayPrice() {
        return this.displayPrice;
    }

    public void setDisplayPrice(String str) {
        this.displayPrice = str;
    }

    public String getDisplayStock() {
        return this.displayStock;
    }

    public void setDisplayStock(String str) {
        this.displayStock = str;
    }

    public final long getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public void setPriceBeforeDiscount(long j) {
        this.priceBeforeDiscount = j;
    }

    public final long getPromotionid() {
        return this.promotionid;
    }

    public void setPromotionid(long j) {
        this.promotionid = j;
    }

    public final long getRebatePrice() {
        return this.rebatePrice;
    }

    public void setRebatePrice(long j) {
        this.rebatePrice = j;
    }

    public final int getSold() {
        return this.sold;
    }

    public void setSold(int i) {
        this.sold = i;
    }

    public void setTierIndexes(List<Integer> list) {
        this.tierIndexes = list;
    }

    public List<Integer> getTierIndexes() {
        return this.tierIndexes;
    }
}
