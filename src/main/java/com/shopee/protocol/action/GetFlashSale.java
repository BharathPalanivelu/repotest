package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetFlashSale extends Message {
    public static final Boolean DEFAULT_BRIEF = false;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CUTOFF_TIME = 0;
    public static final Integer DEFAULT_FLASH_SALE_TYPE = 0;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_BRAND_SALE_META = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean brief;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer cutoff_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer flash_sale_type;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean need_brand_sale_meta;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetFlashSale(String str, String str2, Boolean bool, Integer num, Long l, Integer num2, Integer num3, Boolean bool2) {
        this.requestid = str;
        this.country = str2;
        this.brief = bool;
        this.cutoff_time = num;
        this.promotionid = l;
        this.limit = num2;
        this.flash_sale_type = num3;
        this.need_brand_sale_meta = bool2;
    }

    private GetFlashSale(Builder builder) {
        this(builder.requestid, builder.country, builder.brief, builder.cutoff_time, builder.promotionid, builder.limit, builder.flash_sale_type, builder.need_brand_sale_meta);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetFlashSale)) {
            return false;
        }
        GetFlashSale getFlashSale = (GetFlashSale) obj;
        if (!equals((Object) this.requestid, (Object) getFlashSale.requestid) || !equals((Object) this.country, (Object) getFlashSale.country) || !equals((Object) this.brief, (Object) getFlashSale.brief) || !equals((Object) this.cutoff_time, (Object) getFlashSale.cutoff_time) || !equals((Object) this.promotionid, (Object) getFlashSale.promotionid) || !equals((Object) this.limit, (Object) getFlashSale.limit) || !equals((Object) this.flash_sale_type, (Object) getFlashSale.flash_sale_type) || !equals((Object) this.need_brand_sale_meta, (Object) getFlashSale.need_brand_sale_meta)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.brief;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.cutoff_time;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.flash_sale_type;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_brand_sale_meta;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetFlashSale> {
        public Boolean brief;
        public String country;
        public Integer cutoff_time;
        public Integer flash_sale_type;
        public Integer limit;
        public Boolean need_brand_sale_meta;
        public Long promotionid;
        public String requestid;

        public Builder() {
        }

        public Builder(GetFlashSale getFlashSale) {
            super(getFlashSale);
            if (getFlashSale != null) {
                this.requestid = getFlashSale.requestid;
                this.country = getFlashSale.country;
                this.brief = getFlashSale.brief;
                this.cutoff_time = getFlashSale.cutoff_time;
                this.promotionid = getFlashSale.promotionid;
                this.limit = getFlashSale.limit;
                this.flash_sale_type = getFlashSale.flash_sale_type;
                this.need_brand_sale_meta = getFlashSale.need_brand_sale_meta;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder brief(Boolean bool) {
            this.brief = bool;
            return this;
        }

        public Builder cutoff_time(Integer num) {
            this.cutoff_time = num;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder flash_sale_type(Integer num) {
            this.flash_sale_type = num;
            return this;
        }

        public Builder need_brand_sale_meta(Boolean bool) {
            this.need_brand_sale_meta = bool;
            return this;
        }

        public GetFlashSale build() {
            return new GetFlashSale(this);
        }
    }
}
