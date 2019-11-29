package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FlashSaleBrief extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_FLASH_SALE_TYPE = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer flash_sale_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public FlashSaleBrief(Long l, Integer num, Integer num2, Integer num3, String str, Integer num4) {
        this.promotionid = l;
        this.start_time = num;
        this.end_time = num2;
        this.status = num3;
        this.country = str;
        this.flash_sale_type = num4;
    }

    private FlashSaleBrief(Builder builder) {
        this(builder.promotionid, builder.start_time, builder.end_time, builder.status, builder.country, builder.flash_sale_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlashSaleBrief)) {
            return false;
        }
        FlashSaleBrief flashSaleBrief = (FlashSaleBrief) obj;
        if (!equals((Object) this.promotionid, (Object) flashSaleBrief.promotionid) || !equals((Object) this.start_time, (Object) flashSaleBrief.start_time) || !equals((Object) this.end_time, (Object) flashSaleBrief.end_time) || !equals((Object) this.status, (Object) flashSaleBrief.status) || !equals((Object) this.country, (Object) flashSaleBrief.country) || !equals((Object) this.flash_sale_type, (Object) flashSaleBrief.flash_sale_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.promotionid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.start_time;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.flash_sale_type;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FlashSaleBrief> {
        public String country;
        public Integer end_time;
        public Integer flash_sale_type;
        public Long promotionid;
        public Integer start_time;
        public Integer status;

        public Builder() {
        }

        public Builder(FlashSaleBrief flashSaleBrief) {
            super(flashSaleBrief);
            if (flashSaleBrief != null) {
                this.promotionid = flashSaleBrief.promotionid;
                this.start_time = flashSaleBrief.start_time;
                this.end_time = flashSaleBrief.end_time;
                this.status = flashSaleBrief.status;
                this.country = flashSaleBrief.country;
                this.flash_sale_type = flashSaleBrief.flash_sale_type;
            }
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder flash_sale_type(Integer num) {
            this.flash_sale_type = num;
            return this;
        }

        public FlashSaleBrief build() {
            return new FlashSaleBrief(this);
        }
    }
}
