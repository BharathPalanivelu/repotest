package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class WalletTopup extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_INIT_AMOUNT = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_PAID_AMOUNT = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TOPUP_ID = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long init_amount;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long paid_amount;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long topup_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public WalletTopup(Long l, Integer num, Integer num2, Integer num3, Integer num4, Long l2, Long l3, String str, f fVar) {
        this.topup_id = l;
        this.userid = num;
        this.status = num2;
        this.ctime = num3;
        this.mtime = num4;
        this.init_amount = l2;
        this.paid_amount = l3;
        this.country = str;
        this.extinfo = fVar;
    }

    private WalletTopup(Builder builder) {
        this(builder.topup_id, builder.userid, builder.status, builder.ctime, builder.mtime, builder.init_amount, builder.paid_amount, builder.country, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTopup)) {
            return false;
        }
        WalletTopup walletTopup = (WalletTopup) obj;
        if (!equals((Object) this.topup_id, (Object) walletTopup.topup_id) || !equals((Object) this.userid, (Object) walletTopup.userid) || !equals((Object) this.status, (Object) walletTopup.status) || !equals((Object) this.ctime, (Object) walletTopup.ctime) || !equals((Object) this.mtime, (Object) walletTopup.mtime) || !equals((Object) this.init_amount, (Object) walletTopup.init_amount) || !equals((Object) this.paid_amount, (Object) walletTopup.paid_amount) || !equals((Object) this.country, (Object) walletTopup.country) || !equals((Object) this.extinfo, (Object) walletTopup.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.topup_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.init_amount;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.paid_amount;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletTopup> {
        public String country;
        public Integer ctime;
        public f extinfo;
        public Long init_amount;
        public Integer mtime;
        public Long paid_amount;
        public Integer status;
        public Long topup_id;
        public Integer userid;

        public Builder() {
        }

        public Builder(WalletTopup walletTopup) {
            super(walletTopup);
            if (walletTopup != null) {
                this.topup_id = walletTopup.topup_id;
                this.userid = walletTopup.userid;
                this.status = walletTopup.status;
                this.ctime = walletTopup.ctime;
                this.mtime = walletTopup.mtime;
                this.init_amount = walletTopup.init_amount;
                this.paid_amount = walletTopup.paid_amount;
                this.country = walletTopup.country;
                this.extinfo = walletTopup.extinfo;
            }
        }

        public Builder topup_id(Long l) {
            this.topup_id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Builder init_amount(Long l) {
            this.init_amount = l;
            return this;
        }

        public Builder paid_amount(Long l) {
            this.paid_amount = l;
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

        public WalletTopup build() {
            return new WalletTopup(this);
        }
    }
}
