package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WalletPayCheck extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public WalletPayCheck(String str, Integer num, Long l, String str2) {
        this.requestid = str;
        this.userid = num;
        this.amount = l;
        this.country = str2;
    }

    private WalletPayCheck(Builder builder) {
        this(builder.requestid, builder.userid, builder.amount, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletPayCheck)) {
            return false;
        }
        WalletPayCheck walletPayCheck = (WalletPayCheck) obj;
        if (!equals((Object) this.requestid, (Object) walletPayCheck.requestid) || !equals((Object) this.userid, (Object) walletPayCheck.userid) || !equals((Object) this.amount, (Object) walletPayCheck.amount) || !equals((Object) this.country, (Object) walletPayCheck.country)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.amount;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletPayCheck> {
        public Long amount;
        public String country;
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(WalletPayCheck walletPayCheck) {
            super(walletPayCheck);
            if (walletPayCheck != null) {
                this.requestid = walletPayCheck.requestid;
                this.userid = walletPayCheck.userid;
                this.amount = walletPayCheck.amount;
                this.country = walletPayCheck.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public WalletPayCheck build() {
            return new WalletPayCheck(this);
        }
    }
}
