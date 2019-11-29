package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FlashSale extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_FLASH_SALE_TYPE = 0;
    public static final f DEFAULT_LOGICINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_SHOP_ID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TIMESLOT_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer flash_sale_type;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f logicinfo;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer shop_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long timeslot_id;

    public FlashSale(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, String str, f fVar, f fVar2, Integer num6, Long l2, Integer num7) {
        this.promotionid = l;
        this.start_time = num;
        this.end_time = num2;
        this.ctime = num3;
        this.mtime = num4;
        this.status = num5;
        this.country = str;
        this.extinfo = fVar;
        this.logicinfo = fVar2;
        this.flash_sale_type = num6;
        this.timeslot_id = l2;
        this.shop_id = num7;
    }

    private FlashSale(Builder builder) {
        this(builder.promotionid, builder.start_time, builder.end_time, builder.ctime, builder.mtime, builder.status, builder.country, builder.extinfo, builder.logicinfo, builder.flash_sale_type, builder.timeslot_id, builder.shop_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlashSale)) {
            return false;
        }
        FlashSale flashSale = (FlashSale) obj;
        if (!equals((Object) this.promotionid, (Object) flashSale.promotionid) || !equals((Object) this.start_time, (Object) flashSale.start_time) || !equals((Object) this.end_time, (Object) flashSale.end_time) || !equals((Object) this.ctime, (Object) flashSale.ctime) || !equals((Object) this.mtime, (Object) flashSale.mtime) || !equals((Object) this.status, (Object) flashSale.status) || !equals((Object) this.country, (Object) flashSale.country) || !equals((Object) this.extinfo, (Object) flashSale.extinfo) || !equals((Object) this.logicinfo, (Object) flashSale.logicinfo) || !equals((Object) this.flash_sale_type, (Object) flashSale.flash_sale_type) || !equals((Object) this.timeslot_id, (Object) flashSale.timeslot_id) || !equals((Object) this.shop_id, (Object) flashSale.shop_id)) {
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
        Integer num3 = this.ctime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.logicinfo;
        int hashCode9 = (hashCode8 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num6 = this.flash_sale_type;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.timeslot_id;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num7 = this.shop_id;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FlashSale> {
        public String country;
        public Integer ctime;
        public Integer end_time;
        public f extinfo;
        public Integer flash_sale_type;
        public f logicinfo;
        public Integer mtime;
        public Long promotionid;
        public Integer shop_id;
        public Integer start_time;
        public Integer status;
        public Long timeslot_id;

        public Builder() {
        }

        public Builder(FlashSale flashSale) {
            super(flashSale);
            if (flashSale != null) {
                this.promotionid = flashSale.promotionid;
                this.start_time = flashSale.start_time;
                this.end_time = flashSale.end_time;
                this.ctime = flashSale.ctime;
                this.mtime = flashSale.mtime;
                this.status = flashSale.status;
                this.country = flashSale.country;
                this.extinfo = flashSale.extinfo;
                this.logicinfo = flashSale.logicinfo;
                this.flash_sale_type = flashSale.flash_sale_type;
                this.timeslot_id = flashSale.timeslot_id;
                this.shop_id = flashSale.shop_id;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
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

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder logicinfo(f fVar) {
            this.logicinfo = fVar;
            return this;
        }

        public Builder flash_sale_type(Integer num) {
            this.flash_sale_type = num;
            return this;
        }

        public Builder timeslot_id(Long l) {
            this.timeslot_id = l;
            return this;
        }

        public Builder shop_id(Integer num) {
            this.shop_id = num;
            return this;
        }

        public FlashSale build() {
            return new FlashSale(this);
        }
    }
}
