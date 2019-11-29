package com.shopee.app.data.viewmodel;

import java.util.List;
import org.apache.commons.c.d;

public class SearchProductItem extends UserBriefInfo {
    public static final int ITEM_TYPE_CLEAR = 5;
    public static final int ITEM_TYPE_DEFAULT_LIST_ITEM = 8;
    public static final int ITEM_TYPE_DIVIDER_ITEM = 7;
    public static final int ITEM_TYPE_PREFILL_FIRST_ITEM = 12;
    public static final int ITEM_TYPE_PRODUCT_CURATED_HINT = 14;
    public static final int ITEM_TYPE_PRODUCT_HOT_GRID = 13;
    public static final int ITEM_TYPE_PRODUCT_HOT_KEYWORD = 1;
    public static final int ITEM_TYPE_SCOPE_ITEM = 6;
    public static final int ITEM_TYPE_SEARCH_HISTORY = 4;
    public static final int ITEM_TYPE_SEARCH_PRODUCT_HINT = 0;
    public static final int ITEM_TYPE_SHOW_MORE = 3;
    public static final int ITEM_TYPE_SHOW_MORE_ITEMS = 11;
    public static final int ITEM_TYPE_USER = 2;
    public static final int ITEM_TYPE_USER_HINT = 9;
    public static final int ITEM_TYPE_USER_ITEM = 10;
    private int cateId;
    private String categoryName;
    private int count;
    private Object data;
    private boolean hashTagHint;
    private int hintSourceType;
    private String keyword;
    private List<String> keywords;
    private String logoUrl;
    private List<HotWordData> mHotwordsData;
    private String originalKeyword;
    private String trackingId;
    private int type;

    public static SearchProductItem create(int i) {
        SearchProductItem searchProductItem = new SearchProductItem();
        if (2 == i) {
            searchProductItem.setHashTagHint(true);
        } else {
            searchProductItem.setHashTagHint(false);
        }
        return searchProductItem;
    }

    public static SearchProductItem from(String str, int i) {
        SearchProductItem create = create(i);
        create.setKeyword(str);
        return create;
    }

    public void setHashTagHint(boolean z) {
        this.hashTagHint = z;
    }

    public boolean isHashTagHint() {
        return this.hashTagHint;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String getOriginalKeyword() {
        return this.originalKeyword;
    }

    public void setOriginalKeyword(String str) {
        this.originalKeyword = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public boolean isFromHistory() {
        return this.type == 4;
    }

    public List<String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(List<String> list) {
        this.keywords = list;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public int getExtraAsInt() {
        Object obj = this.data;
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public Object getExtra() {
        return this.data;
    }

    public void setExtra(Object obj) {
        this.data = obj;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public List<HotWordData> getKeywordsTrackingData() {
        return this.mHotwordsData;
    }

    public void setKeywordsTrackingData(List<HotWordData> list) {
        this.mHotwordsData = list;
    }

    public String getTrackingId() {
        return this.trackingId;
    }

    public void setTrackingId(String str) {
        this.trackingId = str;
    }

    public int getHintSourceType() {
        return this.hintSourceType;
    }

    public void setHintSourceType(int i) {
        this.hintSourceType = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SearchProductItem)) {
            return false;
        }
        SearchProductItem searchProductItem = (SearchProductItem) obj;
        if (!d.b(this.keyword, searchProductItem.getKeyword()) || this.hashTagHint != searchProductItem.hashTagHint || !d.b(this.categoryName, searchProductItem.getCategoryName())) {
            return false;
        }
        return true;
    }

    public int getCateId() {
        return this.cateId;
    }

    public void setCateId(int i) {
        this.cateId = i;
    }
}
