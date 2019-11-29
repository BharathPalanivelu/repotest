package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexPromotionSearchCache extends Message {
    public static final List<Integer> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISABLE_CATEGORIES = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISABLE_PRODUCTLABELS = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISABLE_SHOPIDS = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISABLE_SHOP_TYPES = Collections.emptyList();
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Boolean DEFAULT_HAS_ITEMS = false;
    public static final List<Integer> DEFAULT_PRODUCTLABELS = Collections.emptyList();
    public static final Long DEFAULT_PROMOTION_ID = 0L;
    public static final List<Integer> DEFAULT_SHOPIDS = Collections.emptyList();
    public static final List<Integer> DEFAULT_SHOP_TYPES = Collections.emptyList();
    public static final Long DEFAULT_START_TIME = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> categories;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.INT32)
    public final List<Integer> disable_categories;
    @ProtoField(label = Message.Label.REPEATED, tag = 13, type = Message.Datatype.INT32)
    public final List<Integer> disable_productlabels;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT32)
    public final List<Integer> disable_shop_types;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT32)
    public final List<Integer> disable_shopids;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean has_items;
    @ProtoField(label = Message.Label.REPEATED, tag = 12, type = Message.Datatype.INT32)
    public final List<Integer> productlabels;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotion_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT32)
    public final List<Integer> shop_types;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> shopids;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long start_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public SearchIndexPromotionSearchCache(Long l, Long l2, Long l3, Integer num, List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4, List<Integer> list5, List<Integer> list6, Boolean bool, List<Integer> list7, List<Integer> list8) {
        this.promotion_id = l;
        this.start_time = l2;
        this.end_time = l3;
        this.status = num;
        this.categories = immutableCopyOf(list);
        this.shopids = immutableCopyOf(list2);
        this.shop_types = immutableCopyOf(list3);
        this.disable_categories = immutableCopyOf(list4);
        this.disable_shopids = immutableCopyOf(list5);
        this.disable_shop_types = immutableCopyOf(list6);
        this.has_items = bool;
        this.productlabels = immutableCopyOf(list7);
        this.disable_productlabels = immutableCopyOf(list8);
    }

    private SearchIndexPromotionSearchCache(Builder builder) {
        this(builder.promotion_id, builder.start_time, builder.end_time, builder.status, builder.categories, builder.shopids, builder.shop_types, builder.disable_categories, builder.disable_shopids, builder.disable_shop_types, builder.has_items, builder.productlabels, builder.disable_productlabels);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexPromotionSearchCache)) {
            return false;
        }
        SearchIndexPromotionSearchCache searchIndexPromotionSearchCache = (SearchIndexPromotionSearchCache) obj;
        if (!equals((Object) this.promotion_id, (Object) searchIndexPromotionSearchCache.promotion_id) || !equals((Object) this.start_time, (Object) searchIndexPromotionSearchCache.start_time) || !equals((Object) this.end_time, (Object) searchIndexPromotionSearchCache.end_time) || !equals((Object) this.status, (Object) searchIndexPromotionSearchCache.status) || !equals((List<?>) this.categories, (List<?>) searchIndexPromotionSearchCache.categories) || !equals((List<?>) this.shopids, (List<?>) searchIndexPromotionSearchCache.shopids) || !equals((List<?>) this.shop_types, (List<?>) searchIndexPromotionSearchCache.shop_types) || !equals((List<?>) this.disable_categories, (List<?>) searchIndexPromotionSearchCache.disable_categories) || !equals((List<?>) this.disable_shopids, (List<?>) searchIndexPromotionSearchCache.disable_shopids) || !equals((List<?>) this.disable_shop_types, (List<?>) searchIndexPromotionSearchCache.disable_shop_types) || !equals((Object) this.has_items, (Object) searchIndexPromotionSearchCache.has_items) || !equals((List<?>) this.productlabels, (List<?>) searchIndexPromotionSearchCache.productlabels) || !equals((List<?>) this.disable_productlabels, (List<?>) searchIndexPromotionSearchCache.disable_productlabels)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.promotion_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.start_time;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.end_time;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        List<Integer> list = this.categories;
        int i3 = 1;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.shopids;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.shop_types;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Integer> list4 = this.disable_categories;
        int hashCode8 = (hashCode7 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<Integer> list5 = this.disable_shopids;
        int hashCode9 = (hashCode8 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<Integer> list6 = this.disable_shop_types;
        int hashCode10 = (hashCode9 + (list6 != null ? list6.hashCode() : 1)) * 37;
        Boolean bool = this.has_items;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i4 = (hashCode10 + i2) * 37;
        List<Integer> list7 = this.productlabels;
        int hashCode11 = (i4 + (list7 != null ? list7.hashCode() : 1)) * 37;
        List<Integer> list8 = this.disable_productlabels;
        if (list8 != null) {
            i3 = list8.hashCode();
        }
        int i5 = hashCode11 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchIndexPromotionSearchCache> {
        public List<Integer> categories;
        public List<Integer> disable_categories;
        public List<Integer> disable_productlabels;
        public List<Integer> disable_shop_types;
        public List<Integer> disable_shopids;
        public Long end_time;
        public Boolean has_items;
        public List<Integer> productlabels;
        public Long promotion_id;
        public List<Integer> shop_types;
        public List<Integer> shopids;
        public Long start_time;
        public Integer status;

        public Builder() {
        }

        public Builder(SearchIndexPromotionSearchCache searchIndexPromotionSearchCache) {
            super(searchIndexPromotionSearchCache);
            if (searchIndexPromotionSearchCache != null) {
                this.promotion_id = searchIndexPromotionSearchCache.promotion_id;
                this.start_time = searchIndexPromotionSearchCache.start_time;
                this.end_time = searchIndexPromotionSearchCache.end_time;
                this.status = searchIndexPromotionSearchCache.status;
                this.categories = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.categories);
                this.shopids = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.shopids);
                this.shop_types = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.shop_types);
                this.disable_categories = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.disable_categories);
                this.disable_shopids = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.disable_shopids);
                this.disable_shop_types = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.disable_shop_types);
                this.has_items = searchIndexPromotionSearchCache.has_items;
                this.productlabels = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.productlabels);
                this.disable_productlabels = SearchIndexPromotionSearchCache.copyOf(searchIndexPromotionSearchCache.disable_productlabels);
            }
        }

        public Builder promotion_id(Long l) {
            this.promotion_id = l;
            return this;
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder end_time(Long l) {
            this.end_time = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder categories(List<Integer> list) {
            this.categories = checkForNulls(list);
            return this;
        }

        public Builder shopids(List<Integer> list) {
            this.shopids = checkForNulls(list);
            return this;
        }

        public Builder shop_types(List<Integer> list) {
            this.shop_types = checkForNulls(list);
            return this;
        }

        public Builder disable_categories(List<Integer> list) {
            this.disable_categories = checkForNulls(list);
            return this;
        }

        public Builder disable_shopids(List<Integer> list) {
            this.disable_shopids = checkForNulls(list);
            return this;
        }

        public Builder disable_shop_types(List<Integer> list) {
            this.disable_shop_types = checkForNulls(list);
            return this;
        }

        public Builder has_items(Boolean bool) {
            this.has_items = bool;
            return this;
        }

        public Builder productlabels(List<Integer> list) {
            this.productlabels = checkForNulls(list);
            return this;
        }

        public Builder disable_productlabels(List<Integer> list) {
            this.disable_productlabels = checkForNulls(list);
            return this;
        }

        public SearchIndexPromotionSearchCache build() {
            return new SearchIndexPromotionSearchCache(this);
        }
    }
}
