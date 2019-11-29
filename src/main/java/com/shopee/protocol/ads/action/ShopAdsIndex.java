package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopAdsIndex extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ShopAdsIndex(Long l, Integer num, Long l2, Long l3, Integer num2) {
        this.id = l;
        this.shopid = num;
        this.adsid = l2;
        this.campaignid = l3;
        this.placement = num2;
    }

    private ShopAdsIndex(Builder builder) {
        this(builder.id, builder.shopid, builder.adsid, builder.campaignid, builder.placement);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopAdsIndex)) {
            return false;
        }
        ShopAdsIndex shopAdsIndex = (ShopAdsIndex) obj;
        if (!equals((Object) this.id, (Object) shopAdsIndex.id) || !equals((Object) this.shopid, (Object) shopAdsIndex.shopid) || !equals((Object) this.adsid, (Object) shopAdsIndex.adsid) || !equals((Object) this.campaignid, (Object) shopAdsIndex.campaignid) || !equals((Object) this.placement, (Object) shopAdsIndex.placement)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.adsid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.campaignid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.placement;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopAdsIndex> {
        public Long adsid;
        public Long campaignid;
        public Long id;
        public Integer placement;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ShopAdsIndex shopAdsIndex) {
            super(shopAdsIndex);
            if (shopAdsIndex != null) {
                this.id = shopAdsIndex.id;
                this.shopid = shopAdsIndex.shopid;
                this.adsid = shopAdsIndex.adsid;
                this.campaignid = shopAdsIndex.campaignid;
                this.placement = shopAdsIndex.placement;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public ShopAdsIndex build() {
            return new ShopAdsIndex(this);
        }
    }
}
