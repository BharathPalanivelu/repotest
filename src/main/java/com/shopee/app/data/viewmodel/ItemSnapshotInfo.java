package com.shopee.app.data.viewmodel;

import com.shopee.app.h.m;
import com.shopee.app.util.au;
import java.util.List;

public class ItemSnapshotInfo {
    private String brand;
    private int cTime;
    private int catId;
    private int cmtCount;
    private String collectAddress;
    private int condition;
    private long curId;
    private String currency;
    private String description;
    private long id;
    private String images;
    private String itemName;
    private int likedCount;
    private int mTime;
    private List<ModelDetail> models;
    private int offerCount;
    private int pop;
    private long price;
    private long priceBeforeDiscount;
    private long priceMax;
    private long priceMin;
    private int ratingBad;
    private int ratingGood;
    private int ratingNormal;
    private int recommend;
    private int shopId;
    private long snapshotId;
    private int sold;
    private int status;
    private int stock;

    public ModelDetail getVariation(long j) {
        List<ModelDetail> list = this.models;
        if (list != null && !list.isEmpty()) {
            for (ModelDetail next : this.models) {
                if (next.getModelId() == j) {
                    return next;
                }
            }
        }
        return null;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImages(String str) {
        this.images = str;
    }

    public void setPrice(long j) {
        this.price = j;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setStock(int i) {
        this.stock = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setcTime(int i) {
        this.cTime = i;
    }

    public void setmTime(int i) {
        this.mTime = i;
    }

    public void setCurId(long j) {
        this.curId = j;
    }

    public void setSold(int i) {
        this.sold = i;
    }

    public void setPriceMin(long j) {
        this.priceMin = j;
    }

    public void setPriceMax(long j) {
        this.priceMax = j;
    }

    public void setRecommend(int i) {
        this.recommend = i;
    }

    public void setCollectAddress(String str) {
        this.collectAddress = str;
    }

    public void setCatId(int i) {
        this.catId = i;
    }

    public void setPop(int i) {
        this.pop = i;
    }

    public void setLikedCount(int i) {
        this.likedCount = i;
    }

    public void setOfferCount(int i) {
        this.offerCount = i;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCondition(int i) {
        this.condition = i;
    }

    public void setRatingGood(int i) {
        this.ratingGood = i;
    }

    public void setRatingNormal(int i) {
        this.ratingNormal = i;
    }

    public void setRatingBad(int i) {
        this.ratingBad = i;
    }

    public void setCmtCount(int i) {
        this.cmtCount = i;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getShopId() {
        return this.shopId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImages() {
        return this.images;
    }

    public String getPriceString() {
        return au.a(this.price, this.currency);
    }

    public long getPrice() {
        return this.price;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getStock() {
        return this.stock;
    }

    public int getStatus() {
        return this.status;
    }

    public int getcTime() {
        return this.cTime;
    }

    public int getmTime() {
        return this.mTime;
    }

    public long getRootId() {
        return this.id;
    }

    public long getCurId() {
        return this.curId;
    }

    public int getSold() {
        return this.sold;
    }

    public long getPriceMin() {
        return this.priceMin;
    }

    public long getPriceMax() {
        return this.priceMax;
    }

    public int getRecommend() {
        return this.recommend;
    }

    public String getCollectAddress() {
        return this.collectAddress;
    }

    public int getCatId() {
        return this.catId;
    }

    public int getPop() {
        return this.pop;
    }

    public int getLikedCount() {
        return this.likedCount;
    }

    public int getOfferCount() {
        return this.offerCount;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getCondition() {
        return this.condition;
    }

    public int getRatingGood() {
        return this.ratingGood;
    }

    public int getRatingNormal() {
        return this.ratingNormal;
    }

    public int getRatingBad() {
        return this.ratingBad;
    }

    public int getCmtCount() {
        return this.cmtCount;
    }

    public boolean isValid() {
        return (this.itemName == null || this.shopId == 0) ? false : true;
    }

    public void setId(Long l) {
        this.id = l.longValue();
    }

    public long getId() {
        return this.id;
    }

    public String getThumbUrl() {
        return "http://cf.shopee.co.id/file/" + this.images.split(",")[0] + "_tn";
    }

    public boolean isSelling() {
        return m.a(this.shopId);
    }

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public void setSnapshotId(long j) {
        this.snapshotId = j;
    }

    public void setModels(List<ModelDetail> list) {
        this.models = list;
    }

    public List<ModelDetail> getModels() {
        return this.models;
    }

    public void setPriceBeforeDiscount(long j) {
        this.priceBeforeDiscount = j;
    }

    public long getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public String getModelName(long j) {
        if (j <= 0) {
            return "";
        }
        for (ModelDetail next : this.models) {
            if (next.getModelId() == j) {
                return next.getName();
            }
        }
        return "";
    }
}
