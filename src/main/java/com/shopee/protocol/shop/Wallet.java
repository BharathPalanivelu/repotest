package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Wallet extends Message {
    public static final Long DEFAULT_AVAILABLE = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_OUTGOING = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long available;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long outgoing;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public Wallet(Integer num, Integer num2, String str, Long l, Long l2, Integer num3, Integer num4) {
        this.userid = num;
        this.shopid = num2;
        this.country = str;
        this.available = l;
        this.outgoing = l2;
        this.mtime = num3;
        this.status = num4;
    }

    private Wallet(Builder builder) {
        this(builder.userid, builder.shopid, builder.country, builder.available, builder.outgoing, builder.mtime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Wallet)) {
            return false;
        }
        Wallet wallet = (Wallet) obj;
        if (!equals((Object) this.userid, (Object) wallet.userid) || !equals((Object) this.shopid, (Object) wallet.shopid) || !equals((Object) this.country, (Object) wallet.country) || !equals((Object) this.available, (Object) wallet.available) || !equals((Object) this.outgoing, (Object) wallet.outgoing) || !equals((Object) this.mtime, (Object) wallet.mtime) || !equals((Object) this.status, (Object) wallet.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.available;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.outgoing;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Wallet> {
        public Long available;
        public String country;
        public Integer mtime;
        public Long outgoing;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(Wallet wallet) {
            super(wallet);
            if (wallet != null) {
                this.userid = wallet.userid;
                this.shopid = wallet.shopid;
                this.country = wallet.country;
                this.available = wallet.available;
                this.outgoing = wallet.outgoing;
                this.mtime = wallet.mtime;
                this.status = wallet.status;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder available(Long l) {
            this.available = l;
            return this;
        }

        public Builder outgoing(Long l) {
            this.outgoing = l;
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

        public Wallet build() {
            return new Wallet(this);
        }
    }
}
