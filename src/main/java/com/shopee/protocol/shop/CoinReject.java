package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinReject extends Message {
    public static final Integer DEFAULT_ACTION = 0;
    public static final Integer DEFAULT_BUYERID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_OPERATOR = "";
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_SELLERID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer action;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer buyerid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer sellerid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public CoinReject(Long l, Integer num, Integer num2, String str, Integer num3, Integer num4, Integer num5, String str2) {
        this.orderid = l;
        this.buyerid = num;
        this.sellerid = num2;
        this.country = str;
        this.action = num3;
        this.status = num4;
        this.mtime = num5;
        this.operator = str2;
    }

    private CoinReject(Builder builder) {
        this(builder.orderid, builder.buyerid, builder.sellerid, builder.country, builder.action, builder.status, builder.mtime, builder.operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinReject)) {
            return false;
        }
        CoinReject coinReject = (CoinReject) obj;
        if (!equals((Object) this.orderid, (Object) coinReject.orderid) || !equals((Object) this.buyerid, (Object) coinReject.buyerid) || !equals((Object) this.sellerid, (Object) coinReject.sellerid) || !equals((Object) this.country, (Object) coinReject.country) || !equals((Object) this.action, (Object) coinReject.action) || !equals((Object) this.status, (Object) coinReject.status) || !equals((Object) this.mtime, (Object) coinReject.mtime) || !equals((Object) this.operator, (Object) coinReject.operator)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.orderid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.buyerid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.sellerid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.action;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.operator;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinReject> {
        public Integer action;
        public Integer buyerid;
        public String country;
        public Integer mtime;
        public String operator;
        public Long orderid;
        public Integer sellerid;
        public Integer status;

        public Builder() {
        }

        public Builder(CoinReject coinReject) {
            super(coinReject);
            if (coinReject != null) {
                this.orderid = coinReject.orderid;
                this.buyerid = coinReject.buyerid;
                this.sellerid = coinReject.sellerid;
                this.country = coinReject.country;
                this.action = coinReject.action;
                this.status = coinReject.status;
                this.mtime = coinReject.mtime;
                this.operator = coinReject.operator;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
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

        public Builder action(Integer num) {
            this.action = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public CoinReject build() {
            return new CoinReject(this);
        }
    }
}
