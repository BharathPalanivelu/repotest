package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackingQuery extends Message {
    public static final List<String> DEFAULT_COLORFUL_BLOCKS = Collections.emptyList();
    public static final List<TrackingFilter> DEFAULT_FILTERS = Collections.emptyList();
    public static final Integer DEFAULT_FILTER_ATTRIBUTE = 0;
    public static final Integer DEFAULT_FILTER_INCLUDE_SF = 0;
    public static final Integer DEFAULT_FILTER_ITEM_CONDITION = 0;
    public static final Integer DEFAULT_FILTER_PRICE_MAX = 0;
    public static final Integer DEFAULT_FILTER_PRICE_MIN = 0;
    public static final Integer DEFAULT_FILTER_USER_VERIFIED = 0;
    public static final Integer DEFAULT_FILTER_WITH_DISCOUNT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SORTTYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> colorful_blocks;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer filter_attribute;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer filter_include_sf;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer filter_item_condition;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer filter_price_max;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer filter_price_min;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer filter_user_verified;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer filter_with_discount;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingFilter.class, tag = 11)
    public final List<TrackingFilter> filters;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer sorttype;

    public TrackingQuery(String str, Integer num, List<String> list, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, List<TrackingFilter> list2, Long l, Integer num9) {
        this.keyword = str;
        this.sorttype = num;
        this.colorful_blocks = immutableCopyOf(list);
        this.filter_price_min = num2;
        this.filter_price_max = num3;
        this.filter_include_sf = num4;
        this.filter_with_discount = num5;
        this.filter_attribute = num6;
        this.filter_item_condition = num7;
        this.filter_user_verified = num8;
        this.filters = immutableCopyOf(list2);
        this.itemid = l;
        this.shopid = num9;
    }

    private TrackingQuery(Builder builder) {
        this(builder.keyword, builder.sorttype, builder.colorful_blocks, builder.filter_price_min, builder.filter_price_max, builder.filter_include_sf, builder.filter_with_discount, builder.filter_attribute, builder.filter_item_condition, builder.filter_user_verified, builder.filters, builder.itemid, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingQuery)) {
            return false;
        }
        TrackingQuery trackingQuery = (TrackingQuery) obj;
        if (!equals((Object) this.keyword, (Object) trackingQuery.keyword) || !equals((Object) this.sorttype, (Object) trackingQuery.sorttype) || !equals((List<?>) this.colorful_blocks, (List<?>) trackingQuery.colorful_blocks) || !equals((Object) this.filter_price_min, (Object) trackingQuery.filter_price_min) || !equals((Object) this.filter_price_max, (Object) trackingQuery.filter_price_max) || !equals((Object) this.filter_include_sf, (Object) trackingQuery.filter_include_sf) || !equals((Object) this.filter_with_discount, (Object) trackingQuery.filter_with_discount) || !equals((Object) this.filter_attribute, (Object) trackingQuery.filter_attribute) || !equals((Object) this.filter_item_condition, (Object) trackingQuery.filter_item_condition) || !equals((Object) this.filter_user_verified, (Object) trackingQuery.filter_user_verified) || !equals((List<?>) this.filters, (List<?>) trackingQuery.filters) || !equals((Object) this.itemid, (Object) trackingQuery.itemid) || !equals((Object) this.shopid, (Object) trackingQuery.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keyword;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.sorttype;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<String> list = this.colorful_blocks;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.filter_price_min;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.filter_price_max;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.filter_include_sf;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.filter_with_discount;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.filter_attribute;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.filter_item_condition;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.filter_user_verified;
        int hashCode10 = (hashCode9 + (num8 != null ? num8.hashCode() : 0)) * 37;
        List<TrackingFilter> list2 = this.filters;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode10 + i3) * 37;
        Long l = this.itemid;
        int hashCode11 = (i4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num9 = this.shopid;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i5 = hashCode11 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<TrackingQuery> {
        public List<String> colorful_blocks;
        public Integer filter_attribute;
        public Integer filter_include_sf;
        public Integer filter_item_condition;
        public Integer filter_price_max;
        public Integer filter_price_min;
        public Integer filter_user_verified;
        public Integer filter_with_discount;
        public List<TrackingFilter> filters;
        public Long itemid;
        public String keyword;
        public Integer shopid;
        public Integer sorttype;

        public Builder() {
        }

        public Builder(TrackingQuery trackingQuery) {
            super(trackingQuery);
            if (trackingQuery != null) {
                this.keyword = trackingQuery.keyword;
                this.sorttype = trackingQuery.sorttype;
                this.colorful_blocks = TrackingQuery.copyOf(trackingQuery.colorful_blocks);
                this.filter_price_min = trackingQuery.filter_price_min;
                this.filter_price_max = trackingQuery.filter_price_max;
                this.filter_include_sf = trackingQuery.filter_include_sf;
                this.filter_with_discount = trackingQuery.filter_with_discount;
                this.filter_attribute = trackingQuery.filter_attribute;
                this.filter_item_condition = trackingQuery.filter_item_condition;
                this.filter_user_verified = trackingQuery.filter_user_verified;
                this.filters = TrackingQuery.copyOf(trackingQuery.filters);
                this.itemid = trackingQuery.itemid;
                this.shopid = trackingQuery.shopid;
            }
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder sorttype(Integer num) {
            this.sorttype = num;
            return this;
        }

        public Builder colorful_blocks(List<String> list) {
            this.colorful_blocks = checkForNulls(list);
            return this;
        }

        public Builder filter_price_min(Integer num) {
            this.filter_price_min = num;
            return this;
        }

        public Builder filter_price_max(Integer num) {
            this.filter_price_max = num;
            return this;
        }

        public Builder filter_include_sf(Integer num) {
            this.filter_include_sf = num;
            return this;
        }

        public Builder filter_with_discount(Integer num) {
            this.filter_with_discount = num;
            return this;
        }

        public Builder filter_attribute(Integer num) {
            this.filter_attribute = num;
            return this;
        }

        public Builder filter_item_condition(Integer num) {
            this.filter_item_condition = num;
            return this;
        }

        public Builder filter_user_verified(Integer num) {
            this.filter_user_verified = num;
            return this;
        }

        public Builder filters(List<TrackingFilter> list) {
            this.filters = checkForNulls(list);
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public TrackingQuery build() {
            return new TrackingQuery(this);
        }
    }
}
