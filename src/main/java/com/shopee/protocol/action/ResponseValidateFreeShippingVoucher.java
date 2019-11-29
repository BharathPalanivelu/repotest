package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseValidateFreeShippingVoucher extends Message {
    public static final List<String> DEFAULT_CREDIT_CARD_BINS = Collections.emptyList();
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_INVALID_MESSAGE_CODE = 0;
    public static final Boolean DEFAULT_IS_VALID = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Long> DEFAULT_SHIPPING_PROMOTION_RULES = Collections.emptyList();
    public static final List<Long> DEFAULT_SPM_CHANNELS = Collections.emptyList();
    public static final List<Integer> DEFAULT_VOUCHER_PAYMENT_TYPES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.STRING)
    public final List<String> credit_card_bins;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer invalid_message_code;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean is_valid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT64)
    public final List<Long> shipping_promotion_rules;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT64)
    public final List<Long> spm_channels;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> voucher_payment_types;

    public ResponseValidateFreeShippingVoucher(String str, Integer num, String str2, Boolean bool, List<Long> list, List<Integer> list2, List<String> list3, Integer num2, List<Long> list4) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.is_valid = bool;
        this.spm_channels = immutableCopyOf(list);
        this.voucher_payment_types = immutableCopyOf(list2);
        this.credit_card_bins = immutableCopyOf(list3);
        this.invalid_message_code = num2;
        this.shipping_promotion_rules = immutableCopyOf(list4);
    }

    private ResponseValidateFreeShippingVoucher(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.is_valid, builder.spm_channels, builder.voucher_payment_types, builder.credit_card_bins, builder.invalid_message_code, builder.shipping_promotion_rules);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseValidateFreeShippingVoucher)) {
            return false;
        }
        ResponseValidateFreeShippingVoucher responseValidateFreeShippingVoucher = (ResponseValidateFreeShippingVoucher) obj;
        if (!equals((Object) this.requestid, (Object) responseValidateFreeShippingVoucher.requestid) || !equals((Object) this.errcode, (Object) responseValidateFreeShippingVoucher.errcode) || !equals((Object) this.debug_msg, (Object) responseValidateFreeShippingVoucher.debug_msg) || !equals((Object) this.is_valid, (Object) responseValidateFreeShippingVoucher.is_valid) || !equals((List<?>) this.spm_channels, (List<?>) responseValidateFreeShippingVoucher.spm_channels) || !equals((List<?>) this.voucher_payment_types, (List<?>) responseValidateFreeShippingVoucher.voucher_payment_types) || !equals((List<?>) this.credit_card_bins, (List<?>) responseValidateFreeShippingVoucher.credit_card_bins) || !equals((Object) this.invalid_message_code, (Object) responseValidateFreeShippingVoucher.invalid_message_code) || !equals((List<?>) this.shipping_promotion_rules, (List<?>) responseValidateFreeShippingVoucher.shipping_promotion_rules)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.is_valid;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<Long> list = this.spm_channels;
        int i3 = 1;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.voucher_payment_types;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<String> list3 = this.credit_card_bins;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 1)) * 37;
        Integer num2 = this.invalid_message_code;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i4 = (hashCode7 + i2) * 37;
        List<Long> list4 = this.shipping_promotion_rules;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseValidateFreeShippingVoucher> {
        public List<String> credit_card_bins;
        public String debug_msg;
        public Integer errcode;
        public Integer invalid_message_code;
        public Boolean is_valid;
        public String requestid;
        public List<Long> shipping_promotion_rules;
        public List<Long> spm_channels;
        public List<Integer> voucher_payment_types;

        public Builder() {
        }

        public Builder(ResponseValidateFreeShippingVoucher responseValidateFreeShippingVoucher) {
            super(responseValidateFreeShippingVoucher);
            if (responseValidateFreeShippingVoucher != null) {
                this.requestid = responseValidateFreeShippingVoucher.requestid;
                this.errcode = responseValidateFreeShippingVoucher.errcode;
                this.debug_msg = responseValidateFreeShippingVoucher.debug_msg;
                this.is_valid = responseValidateFreeShippingVoucher.is_valid;
                this.spm_channels = ResponseValidateFreeShippingVoucher.copyOf(responseValidateFreeShippingVoucher.spm_channels);
                this.voucher_payment_types = ResponseValidateFreeShippingVoucher.copyOf(responseValidateFreeShippingVoucher.voucher_payment_types);
                this.credit_card_bins = ResponseValidateFreeShippingVoucher.copyOf(responseValidateFreeShippingVoucher.credit_card_bins);
                this.invalid_message_code = responseValidateFreeShippingVoucher.invalid_message_code;
                this.shipping_promotion_rules = ResponseValidateFreeShippingVoucher.copyOf(responseValidateFreeShippingVoucher.shipping_promotion_rules);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder is_valid(Boolean bool) {
            this.is_valid = bool;
            return this;
        }

        public Builder spm_channels(List<Long> list) {
            this.spm_channels = checkForNulls(list);
            return this;
        }

        public Builder voucher_payment_types(List<Integer> list) {
            this.voucher_payment_types = checkForNulls(list);
            return this;
        }

        public Builder credit_card_bins(List<String> list) {
            this.credit_card_bins = checkForNulls(list);
            return this;
        }

        public Builder invalid_message_code(Integer num) {
            this.invalid_message_code = num;
            return this;
        }

        public Builder shipping_promotion_rules(List<Long> list) {
            this.shipping_promotion_rules = checkForNulls(list);
            return this;
        }

        public ResponseValidateFreeShippingVoucher build() {
            return new ResponseValidateFreeShippingVoucher(this);
        }
    }
}
