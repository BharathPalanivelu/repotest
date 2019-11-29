package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReturnVoucher extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_VOUCHER_CODE = "";
    public static final Integer DEFAULT_VOUCHER_MARKET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String voucher_code;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer voucher_market_type;

    public ReturnVoucher(String str, BackendParam backendParam, Long l, String str2, Long l2, Integer num) {
        this.requestid = str;
        this.bparam = backendParam;
        this.promotionid = l;
        this.voucher_code = str2;
        this.orderid = l2;
        this.voucher_market_type = num;
    }

    private ReturnVoucher(Builder builder) {
        this(builder.requestid, builder.bparam, builder.promotionid, builder.voucher_code, builder.orderid, builder.voucher_market_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReturnVoucher)) {
            return false;
        }
        ReturnVoucher returnVoucher = (ReturnVoucher) obj;
        if (!equals((Object) this.requestid, (Object) returnVoucher.requestid) || !equals((Object) this.bparam, (Object) returnVoucher.bparam) || !equals((Object) this.promotionid, (Object) returnVoucher.promotionid) || !equals((Object) this.voucher_code, (Object) returnVoucher.voucher_code) || !equals((Object) this.orderid, (Object) returnVoucher.orderid) || !equals((Object) this.voucher_market_type, (Object) returnVoucher.voucher_market_type)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.voucher_code;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.voucher_market_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReturnVoucher> {
        public BackendParam bparam;
        public Long orderid;
        public Long promotionid;
        public String requestid;
        public String voucher_code;
        public Integer voucher_market_type;

        public Builder() {
        }

        public Builder(ReturnVoucher returnVoucher) {
            super(returnVoucher);
            if (returnVoucher != null) {
                this.requestid = returnVoucher.requestid;
                this.bparam = returnVoucher.bparam;
                this.promotionid = returnVoucher.promotionid;
                this.voucher_code = returnVoucher.voucher_code;
                this.orderid = returnVoucher.orderid;
                this.voucher_market_type = returnVoucher.voucher_market_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder voucher_market_type(Integer num) {
            this.voucher_market_type = num;
            return this;
        }

        public ReturnVoucher build() {
            return new ReturnVoucher(this);
        }
    }
}
