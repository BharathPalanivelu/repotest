package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetVoucherPromotion extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<VoucherPromotion> DEFAULT_VOUCHER_PROMOTIONS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherPromotion.class, tag = 3)
    public final List<VoucherPromotion> voucher_promotions;

    public ResponseGetVoucherPromotion(String str, Integer num, List<VoucherPromotion> list) {
        this.requestid = str;
        this.errcode = num;
        this.voucher_promotions = immutableCopyOf(list);
    }

    private ResponseGetVoucherPromotion(Builder builder) {
        this(builder.requestid, builder.errcode, builder.voucher_promotions);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetVoucherPromotion)) {
            return false;
        }
        ResponseGetVoucherPromotion responseGetVoucherPromotion = (ResponseGetVoucherPromotion) obj;
        if (!equals((Object) this.requestid, (Object) responseGetVoucherPromotion.requestid) || !equals((Object) this.errcode, (Object) responseGetVoucherPromotion.errcode) || !equals((List<?>) this.voucher_promotions, (List<?>) responseGetVoucherPromotion.voucher_promotions)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<VoucherPromotion> list = this.voucher_promotions;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetVoucherPromotion> {
        public Integer errcode;
        public String requestid;
        public List<VoucherPromotion> voucher_promotions;

        public Builder() {
        }

        public Builder(ResponseGetVoucherPromotion responseGetVoucherPromotion) {
            super(responseGetVoucherPromotion);
            if (responseGetVoucherPromotion != null) {
                this.requestid = responseGetVoucherPromotion.requestid;
                this.errcode = responseGetVoucherPromotion.errcode;
                this.voucher_promotions = ResponseGetVoucherPromotion.copyOf(responseGetVoucherPromotion.voucher_promotions);
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

        public Builder voucher_promotions(List<VoucherPromotion> list) {
            this.voucher_promotions = checkForNulls(list);
            return this;
        }

        public ResponseGetVoucherPromotion build() {
            return new ResponseGetVoucherPromotion(this);
        }
    }
}
