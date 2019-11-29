package com.shopee.protocol.action;

import com.shopee.protocol.shop.CheckoutPaymentInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ValidateFreeShippingVoucher extends Message {
    public static final String DEFAULT_CARD_BIN_NUMBER = "";
    public static final Boolean DEFAULT_CHECK_VOUCHER_PAYMENT_CRITERIA = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String card_bin_number;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean check_voucher_payment_criteria;
    @ProtoField(tag = 5)
    public final CheckoutPaymentInfo checkout_payment_info;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public ValidateFreeShippingVoucher(String str, String str2, Long l, Boolean bool, CheckoutPaymentInfo checkoutPaymentInfo, String str3) {
        this.requestid = str;
        this.token = str2;
        this.promotionid = l;
        this.check_voucher_payment_criteria = bool;
        this.checkout_payment_info = checkoutPaymentInfo;
        this.card_bin_number = str3;
    }

    private ValidateFreeShippingVoucher(Builder builder) {
        this(builder.requestid, builder.token, builder.promotionid, builder.check_voucher_payment_criteria, builder.checkout_payment_info, builder.card_bin_number);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValidateFreeShippingVoucher)) {
            return false;
        }
        ValidateFreeShippingVoucher validateFreeShippingVoucher = (ValidateFreeShippingVoucher) obj;
        if (!equals((Object) this.requestid, (Object) validateFreeShippingVoucher.requestid) || !equals((Object) this.token, (Object) validateFreeShippingVoucher.token) || !equals((Object) this.promotionid, (Object) validateFreeShippingVoucher.promotionid) || !equals((Object) this.check_voucher_payment_criteria, (Object) validateFreeShippingVoucher.check_voucher_payment_criteria) || !equals((Object) this.checkout_payment_info, (Object) validateFreeShippingVoucher.checkout_payment_info) || !equals((Object) this.card_bin_number, (Object) validateFreeShippingVoucher.card_bin_number)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.check_voucher_payment_criteria;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        CheckoutPaymentInfo checkoutPaymentInfo = this.checkout_payment_info;
        int hashCode5 = (hashCode4 + (checkoutPaymentInfo != null ? checkoutPaymentInfo.hashCode() : 0)) * 37;
        String str3 = this.card_bin_number;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ValidateFreeShippingVoucher> {
        public String card_bin_number;
        public Boolean check_voucher_payment_criteria;
        public CheckoutPaymentInfo checkout_payment_info;
        public Long promotionid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ValidateFreeShippingVoucher validateFreeShippingVoucher) {
            super(validateFreeShippingVoucher);
            if (validateFreeShippingVoucher != null) {
                this.requestid = validateFreeShippingVoucher.requestid;
                this.token = validateFreeShippingVoucher.token;
                this.promotionid = validateFreeShippingVoucher.promotionid;
                this.check_voucher_payment_criteria = validateFreeShippingVoucher.check_voucher_payment_criteria;
                this.checkout_payment_info = validateFreeShippingVoucher.checkout_payment_info;
                this.card_bin_number = validateFreeShippingVoucher.card_bin_number;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder check_voucher_payment_criteria(Boolean bool) {
            this.check_voucher_payment_criteria = bool;
            return this;
        }

        public Builder checkout_payment_info(CheckoutPaymentInfo checkoutPaymentInfo) {
            this.checkout_payment_info = checkoutPaymentInfo;
            return this;
        }

        public Builder card_bin_number(String str) {
            this.card_bin_number = str;
            return this;
        }

        public ValidateFreeShippingVoucher build() {
            return new ValidateFreeShippingVoucher(this);
        }
    }
}
