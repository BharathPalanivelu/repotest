package com.shopee.app.data.viewmodel;

import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.ui.product.b.a.d;
import com.shopee.app.util.af;
import java.util.ArrayList;
import java.util.List;

public class AddProductInfo {
    private int attributeStatus;
    private List<u> attributeValues;
    private String bannedReason;
    private String brand;
    private ArrayList<Integer> catRecommendationIds = new ArrayList<>();
    private String category;
    private int categoryId;
    private List<Integer> categoryIdPath;
    private String condition;
    private int conditionId;
    private boolean deListProduct;
    private String description;
    private String displayLogisticInfo;
    private String displayWeight;
    private d.b dtsConstraint;
    private String images;
    private boolean invalidCategory;
    private String logisticInfo;
    private Dimension mDimension;
    private List<Variation> mTierVariations;
    private int modelId;
    private String name;
    private boolean preOrder;
    private String price;
    private int shippingDays;
    private int status;
    private String stock;
    private int subCategoryId;
    private MediaData video;
    private long weight;

    public List<Variation> getTierVariations() {
        return this.mTierVariations;
    }

    public void setTierVariations(List<Variation> list) {
        this.mTierVariations = list;
    }

    public String getBannedReason() {
        return this.bannedReason;
    }

    public void setBannedReason(String str) {
        this.bannedReason = str;
    }

    public boolean isDeListProduct() {
        return this.deListProduct;
    }

    public void setDeListProduct(boolean z) {
        this.deListProduct = z;
    }

    public static class Dimension {
        public final String displayDimension;
        public final long height;
        public final long length;
        public final int unit;
        public final long width;

        public Dimension(long j, long j2, long j3, int i, String str) {
            this.width = j;
            this.length = j2;
            this.height = j3;
            this.unit = i;
            this.displayDimension = str;
        }

        public boolean isValid() {
            return (this.width == -1 || this.height == -1 || this.length == -1 || this.unit == -1) ? false : true;
        }
    }

    public ArrayList<Integer> getCatRecommendationIds() {
        return this.catRecommendationIds;
    }

    public void setCatRecommendationIds(ArrayList<Integer> arrayList) {
        this.catRecommendationIds = arrayList;
    }

    public boolean isInvalidCategory() {
        return this.invalidCategory;
    }

    public void setInvalidCategory(boolean z) {
        this.invalidCategory = z;
    }

    public int getSubCategoryId() {
        return this.subCategoryId;
    }

    public void setSubCategoryId(int i) {
        this.subCategoryId = i;
    }

    public int getAttributeStatus() {
        return this.attributeStatus;
    }

    public void setAttributeStatus(int i) {
        this.attributeStatus = i;
    }

    public Dimension getDimension() {
        return this.mDimension;
    }

    public void setDimension(Dimension dimension) {
        this.mDimension = dimension;
    }

    public int getShippingDays() {
        return this.shippingDays;
    }

    public void setShippingDays(int i) {
        this.shippingDays = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getLogisticInfo() {
        return this.logisticInfo;
    }

    public void setLogisticInfo(String str) {
        this.logisticInfo = str;
    }

    public String getDisplayLogisticInfo() {
        return this.displayLogisticInfo;
    }

    public void setDisplayLogisticInfo(String str) {
        this.displayLogisticInfo = str;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getStock() {
        return this.stock;
    }

    public void setStock(String str) {
        this.stock = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String str) {
        this.condition = str;
    }

    public int getConditionId() {
        return this.conditionId;
    }

    public void setConditionId(int i) {
        this.conditionId = i;
    }

    public String getImages() {
        return this.images;
    }

    public void setImages(String str) {
        this.images = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setVideo(MediaData mediaData) {
        this.video = mediaData;
    }

    public MediaData getVideo() {
        return this.video;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AddProductInfo)) {
            return false;
        }
        AddProductInfo addProductInfo = (AddProductInfo) obj;
        boolean z = this.name.equals(addProductInfo.name) && this.description.equals(addProductInfo.description) && this.categoryId == addProductInfo.categoryId && this.price.equals(addProductInfo.price) && this.stock.equals(addProductInfo.stock) && this.brand.equals(addProductInfo.brand) && this.conditionId == addProductInfo.conditionId && this.images.equals(addProductInfo.images) && this.preOrder == addProductInfo.preOrder && this.shippingDays == addProductInfo.shippingDays && this.status == addProductInfo.status && this.modelId == addProductInfo.modelId;
        if (!af.a(this.attributeValues) && !af.a(addProductInfo.attributeValues)) {
            if (this.attributeValues.size() == addProductInfo.attributeValues.size()) {
                int i = 0;
                while (true) {
                    if (i >= this.attributeValues.size()) {
                        break;
                    } else if (!this.attributeValues.get(i).equals(addProductInfo.attributeValues.get(i))) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            z = false;
        }
        if (this.video == null && addProductInfo.video == null) {
            return z;
        }
        MediaData mediaData = this.video;
        if (mediaData == null) {
            return false;
        }
        MediaData mediaData2 = addProductInfo.video;
        if (mediaData2 == null || !z || !mediaData.equals(mediaData2)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "AddProductInfo{attributeValues=" + this.attributeValues + ", name='" + this.name + '\'' + ", description='" + this.description + '\'' + ", category='" + this.category + '\'' + ", subCategoryId=" + this.subCategoryId + ", categoryId=" + this.categoryId + ", price='" + this.price + '\'' + ", stock='" + this.stock + '\'' + ", brand='" + this.brand + '\'' + ", condition='" + this.condition + '\'' + ", conditionId=" + this.conditionId + ", images='" + this.images + '\'' + ", shippingDays=" + this.shippingDays + ", status=" + this.status + ", logisticInfo='" + this.logisticInfo + '\'' + ", displayLogisticInfo='" + this.displayLogisticInfo + '\'' + ", video=" + this.video + ", categoryIdPath=" + this.categoryIdPath + ", modelId=" + this.modelId + ", displayWeight='" + this.displayWeight + '\'' + ", weight=" + this.weight + '}';
    }

    public boolean isSameImage(List<String> list) {
        return this.images.equals(com.shopee.app.g.d.a(list));
    }

    public void setCategoryIdPath(List<Integer> list) {
        this.categoryIdPath = list;
    }

    public List<Integer> getCategoryIdPath() {
        return this.categoryIdPath;
    }

    public void setModelId(int i) {
        this.modelId = i;
    }

    public int getModelId() {
        return this.modelId;
    }

    public void setAttributeValues(List<u> list) {
        this.attributeValues = list;
    }

    public List<u> getAttributeValues() {
        List<u> list = this.attributeValues;
        return list == null ? new ArrayList() : list;
    }

    public String getDisplayWeight() {
        return this.displayWeight;
    }

    public void setDisplayWeight(String str) {
        this.displayWeight = str;
    }

    public void setWeight(long j) {
        this.weight = j;
    }

    public long getWeight() {
        return this.weight;
    }

    public boolean isPreOrder() {
        return this.preOrder;
    }

    public void setPreOrder(boolean z) {
        this.preOrder = z;
    }
}
