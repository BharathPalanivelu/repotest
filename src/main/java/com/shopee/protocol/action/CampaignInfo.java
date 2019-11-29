package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CampaignInfo extends Message {
    public static final Integer DEFAULT_CAMPAIGN_TYPE = 0;
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Integer DEFAULT_FLASH_SALE_TYPE = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_PROMO_SOURCE = 0;
    public static final Long DEFAULT_START_TIME = 0L;
    public static final Integer DEFAULT_STOCK = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer campaign_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer flash_sale_type;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer promo_source;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long start_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer stock;

    public CampaignInfo(Integer num, Integer num2, Long l, Long l2, Long l3, Integer num3, Long l4, Long l5, Integer num4) {
        this.campaign_type = num;
        this.promo_source = num2;
        this.start_time = l;
        this.end_time = l2;
        this.price = l3;
        this.stock = num3;
        this.itemid = l4;
        this.modelid = l5;
        this.flash_sale_type = num4;
    }

    private CampaignInfo(Builder builder) {
        this(builder.campaign_type, builder.promo_source, builder.start_time, builder.end_time, builder.price, builder.stock, builder.itemid, builder.modelid, builder.flash_sale_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CampaignInfo)) {
            return false;
        }
        CampaignInfo campaignInfo = (CampaignInfo) obj;
        if (!equals((Object) this.campaign_type, (Object) campaignInfo.campaign_type) || !equals((Object) this.promo_source, (Object) campaignInfo.promo_source) || !equals((Object) this.start_time, (Object) campaignInfo.start_time) || !equals((Object) this.end_time, (Object) campaignInfo.end_time) || !equals((Object) this.price, (Object) campaignInfo.price) || !equals((Object) this.stock, (Object) campaignInfo.stock) || !equals((Object) this.itemid, (Object) campaignInfo.itemid) || !equals((Object) this.modelid, (Object) campaignInfo.modelid) || !equals((Object) this.flash_sale_type, (Object) campaignInfo.flash_sale_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.campaign_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.promo_source;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.start_time;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.end_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.price;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num3 = this.stock;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l4 = this.itemid;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.modelid;
        int hashCode8 = (hashCode7 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num4 = this.flash_sale_type;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CampaignInfo> {
        public Integer campaign_type;
        public Long end_time;
        public Integer flash_sale_type;
        public Long itemid;
        public Long modelid;
        public Long price;
        public Integer promo_source;
        public Long start_time;
        public Integer stock;

        public Builder() {
        }

        public Builder(CampaignInfo campaignInfo) {
            super(campaignInfo);
            if (campaignInfo != null) {
                this.campaign_type = campaignInfo.campaign_type;
                this.promo_source = campaignInfo.promo_source;
                this.start_time = campaignInfo.start_time;
                this.end_time = campaignInfo.end_time;
                this.price = campaignInfo.price;
                this.stock = campaignInfo.stock;
                this.itemid = campaignInfo.itemid;
                this.modelid = campaignInfo.modelid;
                this.flash_sale_type = campaignInfo.flash_sale_type;
            }
        }

        public Builder campaign_type(Integer num) {
            this.campaign_type = num;
            return this;
        }

        public Builder promo_source(Integer num) {
            this.promo_source = num;
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

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder flash_sale_type(Integer num) {
            this.flash_sale_type = num;
            return this;
        }

        public CampaignInfo build() {
            return new CampaignInfo(this);
        }
    }
}
