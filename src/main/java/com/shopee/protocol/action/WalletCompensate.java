package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WalletCompensate extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Boolean DEFAULT_IS_MYINCOME_COMPENSATE = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REASON = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_TRANS_TYPE = 0;
    public static final Integer DEFAULT_WALLET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean is_myincome_compensate;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer trans_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer wallet_type;

    public WalletCompensate(String str, Long l, Integer num, String str2, Integer num2, Long l2, Boolean bool, Integer num3) {
        this.requestid = str;
        this.orderid = l;
        this.shopid = num;
        this.reason = str2;
        this.trans_type = num2;
        this.amount = l2;
        this.is_myincome_compensate = bool;
        this.wallet_type = num3;
    }

    private WalletCompensate(Builder builder) {
        this(builder.requestid, builder.orderid, builder.shopid, builder.reason, builder.trans_type, builder.amount, builder.is_myincome_compensate, builder.wallet_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletCompensate)) {
            return false;
        }
        WalletCompensate walletCompensate = (WalletCompensate) obj;
        if (!equals((Object) this.requestid, (Object) walletCompensate.requestid) || !equals((Object) this.orderid, (Object) walletCompensate.orderid) || !equals((Object) this.shopid, (Object) walletCompensate.shopid) || !equals((Object) this.reason, (Object) walletCompensate.reason) || !equals((Object) this.trans_type, (Object) walletCompensate.trans_type) || !equals((Object) this.amount, (Object) walletCompensate.amount) || !equals((Object) this.is_myincome_compensate, (Object) walletCompensate.is_myincome_compensate) || !equals((Object) this.wallet_type, (Object) walletCompensate.wallet_type)) {
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
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.reason;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.trans_type;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.amount;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool = this.is_myincome_compensate;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.wallet_type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletCompensate> {
        public Long amount;
        public Boolean is_myincome_compensate;
        public Long orderid;
        public String reason;
        public String requestid;
        public Integer shopid;
        public Integer trans_type;
        public Integer wallet_type;

        public Builder() {
        }

        public Builder(WalletCompensate walletCompensate) {
            super(walletCompensate);
            if (walletCompensate != null) {
                this.requestid = walletCompensate.requestid;
                this.orderid = walletCompensate.orderid;
                this.shopid = walletCompensate.shopid;
                this.reason = walletCompensate.reason;
                this.trans_type = walletCompensate.trans_type;
                this.amount = walletCompensate.amount;
                this.is_myincome_compensate = walletCompensate.is_myincome_compensate;
                this.wallet_type = walletCompensate.wallet_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder trans_type(Integer num) {
            this.trans_type = num;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder is_myincome_compensate(Boolean bool) {
            this.is_myincome_compensate = bool;
            return this;
        }

        public Builder wallet_type(Integer num) {
            this.wallet_type = num;
            return this;
        }

        public WalletCompensate build() {
            checkRequiredFields();
            return new WalletCompensate(this);
        }
    }
}
