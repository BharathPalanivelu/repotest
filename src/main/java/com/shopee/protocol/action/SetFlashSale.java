package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SetFlashSale extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_FLASH_SALE_TYPE = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer flash_sale_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;

    public SetFlashSale(String str, Long l, Integer num, Integer num2, String str2, f fVar, Integer num3, Integer num4) {
        this.requestid = str;
        this.promotionid = l;
        this.start_time = num;
        this.end_time = num2;
        this.country = str2;
        this.extinfo = fVar;
        this.status = num3;
        this.flash_sale_type = num4;
    }

    private SetFlashSale(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.start_time, builder.end_time, builder.country, builder.extinfo, builder.status, builder.flash_sale_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetFlashSale)) {
            return false;
        }
        SetFlashSale setFlashSale = (SetFlashSale) obj;
        if (!equals((Object) this.requestid, (Object) setFlashSale.requestid) || !equals((Object) this.promotionid, (Object) setFlashSale.promotionid) || !equals((Object) this.start_time, (Object) setFlashSale.start_time) || !equals((Object) this.end_time, (Object) setFlashSale.end_time) || !equals((Object) this.country, (Object) setFlashSale.country) || !equals((Object) this.extinfo, (Object) setFlashSale.extinfo) || !equals((Object) this.status, (Object) setFlashSale.status) || !equals((Object) this.flash_sale_type, (Object) setFlashSale.flash_sale_type)) {
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
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.start_time;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.flash_sale_type;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetFlashSale> {
        public String country;
        public Integer end_time;
        public f extinfo;
        public Integer flash_sale_type;
        public Long promotionid;
        public String requestid;
        public Integer start_time;
        public Integer status;

        public Builder() {
        }

        public Builder(SetFlashSale setFlashSale) {
            super(setFlashSale);
            if (setFlashSale != null) {
                this.requestid = setFlashSale.requestid;
                this.promotionid = setFlashSale.promotionid;
                this.start_time = setFlashSale.start_time;
                this.end_time = setFlashSale.end_time;
                this.country = setFlashSale.country;
                this.extinfo = setFlashSale.extinfo;
                this.status = setFlashSale.status;
                this.flash_sale_type = setFlashSale.flash_sale_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder flash_sale_type(Integer num) {
            this.flash_sale_type = num;
            return this;
        }

        public SetFlashSale build() {
            return new SetFlashSale(this);
        }
    }
}
