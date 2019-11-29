package com.shopee.app.data.store;

import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.id.R;

public class SearchHistoryData {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_SHOP_HINT = 1;
    public static final int TYPE_USER = 2;
    private int cateId;
    private String categoryName;
    private boolean hashTagHint;
    private int hintSourceType;
    /* access modifiers changed from: private */
    public String keyword;
    private boolean mShowType;
    private int shopId;
    private long timestamp;
    private String trackingId;
    /* access modifiers changed from: private */
    public int type;
    /* access modifiers changed from: private */
    public int userId;

    private SearchHistoryData(Builder builder) {
        this.keyword = builder.keyword;
        this.timestamp = a.b();
        this.type = builder.type;
        this.userId = builder.userId;
        this.categoryName = builder.categoryName;
        this.cateId = builder.cateId;
        this.mShowType = false;
        this.hashTagHint = builder.hashTagHint;
        this.trackingId = builder.trackingId;
        this.hintSourceType = builder.hintSourceType;
        this.shopId = builder.shopId;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getType() {
        return this.type;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getCateId() {
        return this.cateId;
    }

    public int getShopId() {
        return this.shopId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchHistoryData)) {
            return false;
        }
        SearchHistoryData searchHistoryData = (SearchHistoryData) obj;
        if (this.type != searchHistoryData.type || this.userId != searchHistoryData.userId || this.cateId != searchHistoryData.cateId || this.shopId != searchHistoryData.shopId || this.hashTagHint != searchHistoryData.hashTagHint) {
            return false;
        }
        String str = this.keyword;
        if (str != null) {
            return str.equals(searchHistoryData.keyword);
        }
        if (searchHistoryData.keyword == null) {
            return true;
        }
        return false;
    }

    public String getKeywordDisplay() {
        if (this.type != 1) {
            return this.keyword;
        }
        return b.a(R.string.sp_xx_keyword_shop, this.keyword);
    }

    public SearchProductItem toSearchProductItem(String str, boolean z) {
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setKeyword(this.keyword);
        searchProductItem.setCategoryName(this.categoryName);
        searchProductItem.setCateId(this.cateId);
        searchProductItem.setType(4);
        searchProductItem.setOriginalKeyword(str);
        searchProductItem.setHashTagHint(z);
        return searchProductItem;
    }

    public void setShowType(boolean z) {
        this.mShowType = z;
    }

    public boolean showType() {
        return this.mShowType;
    }

    public boolean isHashTagHint() {
        return this.hashTagHint;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int cateId;
        /* access modifiers changed from: private */
        public String categoryName;
        /* access modifiers changed from: private */
        public boolean hashTagHint;
        /* access modifiers changed from: private */
        public int hintSourceType = -1;
        /* access modifiers changed from: private */
        public String keyword;
        /* access modifiers changed from: private */
        public int shopId;
        /* access modifiers changed from: private */
        public String trackingId;
        /* access modifiers changed from: private */
        public int type;
        /* access modifiers changed from: private */
        public int userId;

        public Builder() {
        }

        public Builder(SearchHistoryData searchHistoryData) {
            this.keyword = searchHistoryData.keyword;
            this.type = searchHistoryData.type;
            this.userId = searchHistoryData.userId;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder type(int i) {
            this.type = i;
            return this;
        }

        public Builder userId(int i) {
            this.userId = i;
            return this;
        }

        public Builder shopId(int i) {
            this.shopId = i;
            return this;
        }

        public Builder cateId(int i) {
            this.cateId = i;
            return this;
        }

        public Builder categoryName(String str) {
            this.categoryName = str;
            return this;
        }

        public Builder hashTagHint(boolean z) {
            this.hashTagHint = z;
            return this;
        }

        public Builder trackingId(String str) {
            this.trackingId = str;
            return this;
        }

        public Builder hintSourceType(int i) {
            this.hintSourceType = i;
            return this;
        }

        public SearchHistoryData build() {
            return new SearchHistoryData(this);
        }
    }
}
