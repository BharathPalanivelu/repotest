package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartOrderExtraInfo extends Message {
    public static final String DEFAULT_BANK_ACCOUNT = "";
    public static final String DEFAULT_BANK_NAME = "";
    public static final Integer DEFAULT_CARRIERID = 0;
    public static final Integer DEFAULT_COLLECT_TYPE = 0;
    public static final Long DEFAULT_ESCROW_FEE = 0L;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final String DEFAULT_REMARK = "";
    public static final String DEFAULT_SHIPMENT_CURRENCY = "";
    public static final String DEFAULT_SHIPMENT_NAME = "";
    public static final Long DEFAULT_SHIPPING_FEE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String bank_account;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String bank_name;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer carrierid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer collect_type;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long escrow_fee;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer payment_method;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String remark;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String shipment_currency;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String shipment_name;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long shipping_fee;

    public CartOrderExtraInfo(String str, Integer num, Integer num2, String str2, String str3, Integer num3, Long l, String str4, String str5, Long l2) {
        this.remark = str;
        this.collect_type = num;
        this.payment_method = num2;
        this.bank_name = str2;
        this.bank_account = str3;
        this.carrierid = num3;
        this.shipping_fee = l;
        this.shipment_currency = str4;
        this.shipment_name = str5;
        this.escrow_fee = l2;
    }

    private CartOrderExtraInfo(Builder builder) {
        this(builder.remark, builder.collect_type, builder.payment_method, builder.bank_name, builder.bank_account, builder.carrierid, builder.shipping_fee, builder.shipment_currency, builder.shipment_name, builder.escrow_fee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartOrderExtraInfo)) {
            return false;
        }
        CartOrderExtraInfo cartOrderExtraInfo = (CartOrderExtraInfo) obj;
        if (!equals((Object) this.remark, (Object) cartOrderExtraInfo.remark) || !equals((Object) this.collect_type, (Object) cartOrderExtraInfo.collect_type) || !equals((Object) this.payment_method, (Object) cartOrderExtraInfo.payment_method) || !equals((Object) this.bank_name, (Object) cartOrderExtraInfo.bank_name) || !equals((Object) this.bank_account, (Object) cartOrderExtraInfo.bank_account) || !equals((Object) this.carrierid, (Object) cartOrderExtraInfo.carrierid) || !equals((Object) this.shipping_fee, (Object) cartOrderExtraInfo.shipping_fee) || !equals((Object) this.shipment_currency, (Object) cartOrderExtraInfo.shipment_currency) || !equals((Object) this.shipment_name, (Object) cartOrderExtraInfo.shipment_name) || !equals((Object) this.escrow_fee, (Object) cartOrderExtraInfo.escrow_fee)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.remark;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.collect_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.payment_method;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.bank_name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.bank_account;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num3 = this.carrierid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.shipping_fee;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        String str4 = this.shipment_currency;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.shipment_name;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l2 = this.escrow_fee;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartOrderExtraInfo> {
        public String bank_account;
        public String bank_name;
        public Integer carrierid;
        public Integer collect_type;
        public Long escrow_fee;
        public Integer payment_method;
        public String remark;
        public String shipment_currency;
        public String shipment_name;
        public Long shipping_fee;

        public Builder() {
        }

        public Builder(CartOrderExtraInfo cartOrderExtraInfo) {
            super(cartOrderExtraInfo);
            if (cartOrderExtraInfo != null) {
                this.remark = cartOrderExtraInfo.remark;
                this.collect_type = cartOrderExtraInfo.collect_type;
                this.payment_method = cartOrderExtraInfo.payment_method;
                this.bank_name = cartOrderExtraInfo.bank_name;
                this.bank_account = cartOrderExtraInfo.bank_account;
                this.carrierid = cartOrderExtraInfo.carrierid;
                this.shipping_fee = cartOrderExtraInfo.shipping_fee;
                this.shipment_currency = cartOrderExtraInfo.shipment_currency;
                this.shipment_name = cartOrderExtraInfo.shipment_name;
                this.escrow_fee = cartOrderExtraInfo.escrow_fee;
            }
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public Builder collect_type(Integer num) {
            this.collect_type = num;
            return this;
        }

        public Builder payment_method(Integer num) {
            this.payment_method = num;
            return this;
        }

        public Builder bank_name(String str) {
            this.bank_name = str;
            return this;
        }

        public Builder bank_account(String str) {
            this.bank_account = str;
            return this;
        }

        public Builder carrierid(Integer num) {
            this.carrierid = num;
            return this;
        }

        public Builder shipping_fee(Long l) {
            this.shipping_fee = l;
            return this;
        }

        public Builder shipment_currency(String str) {
            this.shipment_currency = str;
            return this;
        }

        public Builder shipment_name(String str) {
            this.shipment_name = str;
            return this;
        }

        public Builder escrow_fee(Long l) {
            this.escrow_fee = l;
            return this;
        }

        public CartOrderExtraInfo build() {
            return new CartOrderExtraInfo(this);
        }
    }
}
