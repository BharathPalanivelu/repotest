package com.shopee.app.data.viewmodel;

import com.facebook.common.time.Clock;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.h.m;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.util.af;
import com.shopee.app.util.au;
import com.shopee.id.R;
import com.shopee.protocol.shop.TierVariation;
import java.util.ArrayList;
import java.util.List;

public class ItemDetail {
    public static final int FAKE_STATUS = -228;
    private int attributeStatus;
    private String bannedReason;
    private String brand;
    private int cTime;
    private boolean canUseWholesale;
    private int catId;
    private int cmtCount;
    private int condition;
    private String currency;
    private String description;
    private String displayWeight;
    private byte[] extendedInfo;
    private int flag;
    private long id;
    private String images;
    private boolean invalidCategory;
    private boolean isOfferItem = false;
    private String itemName;
    private int likedCount;
    private int mTime;
    private List<ModelDetail> modelDetails = new ArrayList();
    private VMOfferHistory offer;
    private String ownerAvatar;
    private String ownerName;
    private boolean preOder;
    private long price;
    private long priceBeforeDiscount;
    private int recommend;
    private int shopId;
    private String sizeChart;
    private int sold;
    private int status = 1;
    private int stock;
    private List<TierVariation> tierVariations;
    private long viewCount;
    private List<WholesaleTierModel> wholesaleTiers;

    public byte[] getExtendedInfo() {
        return this.extendedInfo;
    }

    public void setExtendedInfo(byte[] bArr) {
        this.extendedInfo = bArr;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public boolean isPreOder() {
        return this.preOder;
    }

    public void setPreOder(boolean z) {
        this.preOder = z;
    }

    public boolean isCanUseWholesale() {
        return this.canUseWholesale;
    }

    public List<WholesaleTierModel> getWholesaleTiers() {
        return this.wholesaleTiers;
    }

    public void setCanUseWholesale(boolean z) {
        this.canUseWholesale = z;
    }

    public void setWholesaleTiers(List<WholesaleTierModel> list) {
        this.wholesaleTiers = list;
    }

    public ModelDetail getVariation(long j) {
        List<ModelDetail> list = this.modelDetails;
        if (list != null && !list.isEmpty()) {
            for (ModelDetail next : this.modelDetails) {
                if (next.getModelId() == j) {
                    return next;
                }
            }
        }
        return null;
    }

    public boolean isFakeItem() {
        return this.status == -228;
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

    public void setSold(int i) {
        this.sold = i;
    }

    public void setRecommend(int i) {
        this.recommend = i;
    }

    public void setCatId(int i) {
        this.catId = i;
    }

    public void setLikedCount(int i) {
        this.likedCount = i;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCondition(int i) {
        this.condition = i;
    }

    public boolean isOutStock() {
        return this.stock <= 0;
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

    private boolean hasItemPromotion() {
        long j = this.priceBeforeDiscount;
        return j > 0 && j != this.price;
    }

    private boolean hasVariationPromotion() {
        if (af.a(this.modelDetails)) {
            return false;
        }
        for (ModelDetail next : this.modelDetails) {
            if (next.getPriceBeforeDiscount() > 0 && next.getPriceBeforeDiscount() != next.getPrice()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPromotion() {
        return hasItemPromotion() || hasVariationPromotion();
    }

    public String getVariationNoOOSPriceString() {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        int size = af.a(this.modelDetails) ? 0 : this.modelDetails.size();
        if (size == 0) {
            sb.append(au.a(this.price, this.currency));
        } else if (size != 1) {
            for (ModelDetail stock2 : this.modelDetails) {
                if (stock2.getStock() > 0) {
                    i++;
                }
            }
            long j = Clock.MAX_TIME;
            long j2 = 0;
            if (i != 0) {
                for (ModelDetail next : this.modelDetails) {
                    if (next.getStock() > 0) {
                        j = Math.min(j, next.getPrice());
                        j2 = Math.max(j2, next.getPrice());
                    }
                }
                sb.append(au.a(j, this.currency));
                if (j != j2) {
                    sb.append(" - ");
                    sb.append(au.a(j2, this.currency));
                }
            } else {
                for (ModelDetail next2 : this.modelDetails) {
                    j = Math.min(j, next2.getPrice());
                    j2 = Math.max(j2, next2.getPrice());
                }
                sb.append(au.a(j, this.currency));
                if (j != j2) {
                    sb.append(" - ");
                    sb.append(au.a(j2, this.currency));
                }
            }
        } else {
            sb.append(au.a(this.modelDetails.get(0).getPrice(), this.currency));
        }
        return sb.toString();
    }

    public String getVariationPriceString(long j) {
        StringBuilder sb = new StringBuilder("");
        if (!af.a(this.modelDetails)) {
            for (ModelDetail next : this.modelDetails) {
                if (next.getModelId() == j) {
                    sb.append(au.a(next.getPrice(), this.currency));
                    return sb.toString();
                }
            }
            sb.append(au.a(this.price, this.currency));
        } else {
            sb.append(au.a(this.price, this.currency));
        }
        return sb.toString();
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

    public int getSold() {
        return this.sold;
    }

    public int getRecommend() {
        return this.recommend;
    }

    public int getCatId() {
        return this.catId;
    }

    public String getLikedString() {
        int i = this.likedCount;
        if (i < 1000) {
            return String.valueOf(i);
        }
        return roundNum2Kilo(this.likedCount) + "k";
    }

    private int roundNum2Kilo(int i) {
        if (i < 1000) {
            return 0;
        }
        int i2 = i / 1000;
        return ((double) (i % 1000)) > 500.0d ? i2 + 1 : i2;
    }

    public int getLikedCount() {
        return this.likedCount;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getCondition() {
        return this.condition;
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

    public void setPriceBeforeDiscount(long j) {
        this.priceBeforeDiscount = j;
    }

    public String getPromotionString(String str) {
        int i;
        long j = this.priceBeforeDiscount;
        float f2 = (((float) (j - this.price)) * 100.0f) / ((float) j);
        if (((double) Math.abs(f2 - ((float) Math.round(f2)))) < 0.001d) {
            i = Math.round(f2);
        } else {
            i = (int) Math.floor((double) f2);
        }
        if (!str.equals("zh-Hant")) {
            return b.a(R.string.sp_percent_off, i + "%");
        }
        return b.a(R.string.sp_percent_off_tw, String.valueOf(((float) (100 - i)) / 10.0f));
    }

    public String getVariationNoOOSBeforeDiscountPriceString() {
        if (!hasPromotion()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        int size = af.a(this.modelDetails) ? 0 : this.modelDetails.size();
        if (size == 0) {
            sb.append(au.a(this.priceBeforeDiscount, this.currency));
        } else if (size != 1) {
            for (ModelDetail stock2 : this.modelDetails) {
                if (stock2.getStock() > 0) {
                    i++;
                }
            }
            long j = Clock.MAX_TIME;
            if (i != 0) {
                long j2 = 0;
                for (ModelDetail next : this.modelDetails) {
                    if (next.getStock() > 0) {
                        long priceBeforeDiscount2 = next.getPriceBeforeDiscount();
                        if (priceBeforeDiscount2 <= 0 && hasPromotion()) {
                            priceBeforeDiscount2 = next.getPrice();
                        }
                        j = Math.min(j, priceBeforeDiscount2);
                        j2 = Math.max(j2, priceBeforeDiscount2);
                    }
                }
                sb.append(au.a(j, this.currency));
                if (j != j2) {
                    sb.append(" - ");
                    sb.append(au.a(j2, this.currency));
                }
            } else {
                long j3 = 0;
                for (ModelDetail next2 : this.modelDetails) {
                    long priceBeforeDiscount3 = next2.getPriceBeforeDiscount();
                    if (priceBeforeDiscount3 <= 0 && hasPromotion()) {
                        priceBeforeDiscount3 = next2.getPrice();
                    }
                    j = Math.min(j, priceBeforeDiscount3);
                    j3 = Math.max(j3, priceBeforeDiscount3);
                }
                sb.append(au.a(j, this.currency));
                if (j != j3) {
                    sb.append(" - ");
                    sb.append(au.a(j3, this.currency));
                }
            }
        } else {
            sb.append(au.a(this.modelDetails.get(0).getPriceBeforeDiscount(), this.currency));
        }
        return sb.toString();
    }

    public long getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public List<ModelDetail> getModelDetails() {
        return this.modelDetails;
    }

    public void setModelDetails(List<ModelDetail> list) {
        this.modelDetails = list;
    }

    public String getModelName(long j) {
        if (j <= 0) {
            return "";
        }
        for (ModelDetail next : this.modelDetails) {
            if (next.getModelId() == j) {
                return next.getName();
            }
        }
        return "";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemDetail)) {
            return false;
        }
        ItemDetail itemDetail = (ItemDetail) obj;
        if (itemDetail.getId() == this.id && itemDetail.getShopId() == this.shopId) {
            return true;
        }
        return false;
    }

    public String getOwnerAvatar() {
        return this.ownerAvatar;
    }

    public void setOwnerAvatar(String str) {
        this.ownerAvatar = str;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public VMOfferHistory getOffer() {
        return this.offer;
    }

    public void setOffer(VMOfferHistory vMOfferHistory) {
        this.offer = vMOfferHistory;
    }

    public void setViewCount(long j) {
        this.viewCount = j;
    }

    public long getViewCount() {
        return this.viewCount;
    }

    public void setDisplayWeight(String str) {
        this.displayWeight = str;
    }

    public String getDisplayWeight() {
        return this.displayWeight;
    }

    public int getAttributeStatus() {
        return this.attributeStatus;
    }

    public boolean hasInvalidAttribute() {
        return this.attributeStatus == 0;
    }

    public void setAttributeStatus(int i) {
        this.attributeStatus = i;
    }

    public boolean isInvalidCategory() {
        return this.invalidCategory;
    }

    public void setInvalidCategory(boolean z) {
        this.invalidCategory = z;
    }

    public void setTierVariation(List<TierVariation> list) {
        this.tierVariations = list;
    }

    public List<TierVariation> getTierVariations() {
        return this.tierVariations;
    }

    public String getSizeChart() {
        return this.sizeChart;
    }

    public void setSizeChart(String str) {
        this.sizeChart = str;
    }

    public String getBannedReason() {
        return this.bannedReason;
    }

    public void setBannedReason(String str) {
        this.bannedReason = str;
    }

    public boolean isDeList() {
        return ItemExtData.Companion.isDeList(this.flag);
    }

    public boolean isDeListBySystem() {
        return ItemExtData.Companion.isDeListBySystem(this.flag);
    }
}
