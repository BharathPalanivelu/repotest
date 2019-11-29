package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingItem extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final String DEFAULT_ADS_KEYWORD = "";
    public static final String DEFAULT_ALGORITHM = "";
    public static final Integer DEFAULT_DISCOUNT = 0;
    public static final Boolean DEFAULT_FREE_SHIPPING = false;
    public static final Boolean DEFAULT_IS_PREFERED = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIKES = 0;
    public static final Integer DEFAULT_LOCATION = 0;
    public static final Integer DEFAULT_LOCATION_IN_ADS = 0;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_RATING = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String ads_keyword;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer discount;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean free_shipping;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_prefered;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer likes;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer location;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer location_in_ads;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer rating;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;

    public TrackingItem(Long l, Long l2, Boolean bool, Integer num, Integer num2, Boolean bool2, Integer num3, Integer num4, String str, Long l3, Integer num5, Integer num6, String str2) {
        this.itemid = l;
        this.modelid = l2;
        this.free_shipping = bool;
        this.discount = num;
        this.shopid = num2;
        this.is_prefered = bool2;
        this.location = num3;
        this.location_in_ads = num4;
        this.ads_keyword = str;
        this.adsid = l3;
        this.likes = num5;
        this.rating = num6;
        this.algorithm = str2;
    }

    private TrackingItem(Builder builder) {
        this(builder.itemid, builder.modelid, builder.free_shipping, builder.discount, builder.shopid, builder.is_prefered, builder.location, builder.location_in_ads, builder.ads_keyword, builder.adsid, builder.likes, builder.rating, builder.algorithm);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingItem)) {
            return false;
        }
        TrackingItem trackingItem = (TrackingItem) obj;
        if (!equals((Object) this.itemid, (Object) trackingItem.itemid) || !equals((Object) this.modelid, (Object) trackingItem.modelid) || !equals((Object) this.free_shipping, (Object) trackingItem.free_shipping) || !equals((Object) this.discount, (Object) trackingItem.discount) || !equals((Object) this.shopid, (Object) trackingItem.shopid) || !equals((Object) this.is_prefered, (Object) trackingItem.is_prefered) || !equals((Object) this.location, (Object) trackingItem.location) || !equals((Object) this.location_in_ads, (Object) trackingItem.location_in_ads) || !equals((Object) this.ads_keyword, (Object) trackingItem.ads_keyword) || !equals((Object) this.adsid, (Object) trackingItem.adsid) || !equals((Object) this.likes, (Object) trackingItem.likes) || !equals((Object) this.rating, (Object) trackingItem.rating) || !equals((Object) this.algorithm, (Object) trackingItem.algorithm)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.modelid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool = this.free_shipping;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.discount;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_prefered;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num3 = this.location;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.location_in_ads;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.ads_keyword;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.adsid;
        int hashCode10 = (hashCode9 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num5 = this.likes;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.rating;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.algorithm;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingItem> {
        public String ads_keyword;
        public Long adsid;
        public String algorithm;
        public Integer discount;
        public Boolean free_shipping;
        public Boolean is_prefered;
        public Long itemid;
        public Integer likes;
        public Integer location;
        public Integer location_in_ads;
        public Long modelid;
        public Integer rating;
        public Integer shopid;

        public Builder() {
        }

        public Builder(TrackingItem trackingItem) {
            super(trackingItem);
            if (trackingItem != null) {
                this.itemid = trackingItem.itemid;
                this.modelid = trackingItem.modelid;
                this.free_shipping = trackingItem.free_shipping;
                this.discount = trackingItem.discount;
                this.shopid = trackingItem.shopid;
                this.is_prefered = trackingItem.is_prefered;
                this.location = trackingItem.location;
                this.location_in_ads = trackingItem.location_in_ads;
                this.ads_keyword = trackingItem.ads_keyword;
                this.adsid = trackingItem.adsid;
                this.likes = trackingItem.likes;
                this.rating = trackingItem.rating;
                this.algorithm = trackingItem.algorithm;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder free_shipping(Boolean bool) {
            this.free_shipping = bool;
            return this;
        }

        public Builder discount(Integer num) {
            this.discount = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder is_prefered(Boolean bool) {
            this.is_prefered = bool;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public Builder location_in_ads(Integer num) {
            this.location_in_ads = num;
            return this;
        }

        public Builder ads_keyword(String str) {
            this.ads_keyword = str;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder likes(Integer num) {
            this.likes = num;
            return this;
        }

        public Builder rating(Integer num) {
            this.rating = num;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public TrackingItem build() {
            return new TrackingItem(this);
        }
    }
}
