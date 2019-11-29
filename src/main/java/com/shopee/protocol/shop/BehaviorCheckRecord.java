package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class BehaviorCheckRecord extends Message {
    public static final Integer DEFAULT_BUYERID = 0;
    public static final f DEFAULT_BUYER_DEVICEID = f.f32736b;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_METHOD = 0;
    public static final Integer DEFAULT_SELLERID = 0;
    public static final f DEFAULT_SELLER_DEVICEID = f.f32736b;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f buyer_deviceid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer buyerid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer method;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f seller_deviceid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer sellerid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String voucher_code;

    public BehaviorCheckRecord(Integer num, Integer num2, Integer num3, String str, Integer num4, Integer num5, String str2, f fVar, f fVar2, f fVar3, Integer num6, Integer num7) {
        this.id = num;
        this.buyerid = num2;
        this.sellerid = num3;
        this.country = str;
        this.ctime = num4;
        this.type = num5;
        this.voucher_code = str2;
        this.extinfo = fVar;
        this.buyer_deviceid = fVar2;
        this.seller_deviceid = fVar3;
        this.status = num6;
        this.method = num7;
    }

    private BehaviorCheckRecord(Builder builder) {
        this(builder.id, builder.buyerid, builder.sellerid, builder.country, builder.ctime, builder.type, builder.voucher_code, builder.extinfo, builder.buyer_deviceid, builder.seller_deviceid, builder.status, builder.method);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BehaviorCheckRecord)) {
            return false;
        }
        BehaviorCheckRecord behaviorCheckRecord = (BehaviorCheckRecord) obj;
        if (!equals((Object) this.id, (Object) behaviorCheckRecord.id) || !equals((Object) this.buyerid, (Object) behaviorCheckRecord.buyerid) || !equals((Object) this.sellerid, (Object) behaviorCheckRecord.sellerid) || !equals((Object) this.country, (Object) behaviorCheckRecord.country) || !equals((Object) this.ctime, (Object) behaviorCheckRecord.ctime) || !equals((Object) this.type, (Object) behaviorCheckRecord.type) || !equals((Object) this.voucher_code, (Object) behaviorCheckRecord.voucher_code) || !equals((Object) this.extinfo, (Object) behaviorCheckRecord.extinfo) || !equals((Object) this.buyer_deviceid, (Object) behaviorCheckRecord.buyer_deviceid) || !equals((Object) this.seller_deviceid, (Object) behaviorCheckRecord.seller_deviceid) || !equals((Object) this.status, (Object) behaviorCheckRecord.status) || !equals((Object) this.method, (Object) behaviorCheckRecord.method)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.buyerid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.sellerid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.type;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.voucher_code;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.buyer_deviceid;
        int hashCode9 = (hashCode8 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.seller_deviceid;
        int hashCode10 = (hashCode9 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.method;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BehaviorCheckRecord> {
        public f buyer_deviceid;
        public Integer buyerid;
        public String country;
        public Integer ctime;
        public f extinfo;
        public Integer id;
        public Integer method;
        public f seller_deviceid;
        public Integer sellerid;
        public Integer status;
        public Integer type;
        public String voucher_code;

        public Builder() {
        }

        public Builder(BehaviorCheckRecord behaviorCheckRecord) {
            super(behaviorCheckRecord);
            if (behaviorCheckRecord != null) {
                this.id = behaviorCheckRecord.id;
                this.buyerid = behaviorCheckRecord.buyerid;
                this.sellerid = behaviorCheckRecord.sellerid;
                this.country = behaviorCheckRecord.country;
                this.ctime = behaviorCheckRecord.ctime;
                this.type = behaviorCheckRecord.type;
                this.voucher_code = behaviorCheckRecord.voucher_code;
                this.extinfo = behaviorCheckRecord.extinfo;
                this.buyer_deviceid = behaviorCheckRecord.buyer_deviceid;
                this.seller_deviceid = behaviorCheckRecord.seller_deviceid;
                this.status = behaviorCheckRecord.status;
                this.method = behaviorCheckRecord.method;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder buyerid(Integer num) {
            this.buyerid = num;
            return this;
        }

        public Builder sellerid(Integer num) {
            this.sellerid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder buyer_deviceid(f fVar) {
            this.buyer_deviceid = fVar;
            return this;
        }

        public Builder seller_deviceid(f fVar) {
            this.seller_deviceid = fVar;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder method(Integer num) {
            this.method = num;
            return this;
        }

        public BehaviorCheckRecord build() {
            return new BehaviorCheckRecord(this);
        }
    }
}
