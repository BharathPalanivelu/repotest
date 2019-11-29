package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShopPenaltyHistoricalLog extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_LOGID = 0L;
    public static final Integer DEFAULT_OFFENCE_TYPE = 0;
    public static final Integer DEFAULT_PENALTY_POINT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOURCE_TYPE = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long logid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offence_type;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer penalty_point;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer source_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;

    public ShopPenaltyHistoricalLog(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, String str, Integer num6, f fVar) {
        this.logid = l;
        this.shopid = num;
        this.offence_type = num2;
        this.source_type = num3;
        this.ctime = num4;
        this.penalty_point = num5;
        this.country = str;
        this.status = num6;
        this.extinfo = fVar;
    }

    private ShopPenaltyHistoricalLog(Builder builder) {
        this(builder.logid, builder.shopid, builder.offence_type, builder.source_type, builder.ctime, builder.penalty_point, builder.country, builder.status, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopPenaltyHistoricalLog)) {
            return false;
        }
        ShopPenaltyHistoricalLog shopPenaltyHistoricalLog = (ShopPenaltyHistoricalLog) obj;
        if (!equals((Object) this.logid, (Object) shopPenaltyHistoricalLog.logid) || !equals((Object) this.shopid, (Object) shopPenaltyHistoricalLog.shopid) || !equals((Object) this.offence_type, (Object) shopPenaltyHistoricalLog.offence_type) || !equals((Object) this.source_type, (Object) shopPenaltyHistoricalLog.source_type) || !equals((Object) this.ctime, (Object) shopPenaltyHistoricalLog.ctime) || !equals((Object) this.penalty_point, (Object) shopPenaltyHistoricalLog.penalty_point) || !equals((Object) this.country, (Object) shopPenaltyHistoricalLog.country) || !equals((Object) this.status, (Object) shopPenaltyHistoricalLog.status) || !equals((Object) this.extinfo, (Object) shopPenaltyHistoricalLog.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.logid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offence_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.source_type;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.penalty_point;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopPenaltyHistoricalLog> {
        public String country;
        public Integer ctime;
        public f extinfo;
        public Long logid;
        public Integer offence_type;
        public Integer penalty_point;
        public Integer shopid;
        public Integer source_type;
        public Integer status;

        public Builder() {
        }

        public Builder(ShopPenaltyHistoricalLog shopPenaltyHistoricalLog) {
            super(shopPenaltyHistoricalLog);
            if (shopPenaltyHistoricalLog != null) {
                this.logid = shopPenaltyHistoricalLog.logid;
                this.shopid = shopPenaltyHistoricalLog.shopid;
                this.offence_type = shopPenaltyHistoricalLog.offence_type;
                this.source_type = shopPenaltyHistoricalLog.source_type;
                this.ctime = shopPenaltyHistoricalLog.ctime;
                this.penalty_point = shopPenaltyHistoricalLog.penalty_point;
                this.country = shopPenaltyHistoricalLog.country;
                this.status = shopPenaltyHistoricalLog.status;
                this.extinfo = shopPenaltyHistoricalLog.extinfo;
            }
        }

        public Builder logid(Long l) {
            this.logid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder offence_type(Integer num) {
            this.offence_type = num;
            return this;
        }

        public Builder source_type(Integer num) {
            this.source_type = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder penalty_point(Integer num) {
            this.penalty_point = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public ShopPenaltyHistoricalLog build() {
            return new ShopPenaltyHistoricalLog(this);
        }
    }
}
