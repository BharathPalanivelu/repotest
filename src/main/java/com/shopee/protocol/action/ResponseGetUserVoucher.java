package com.shopee.protocol.action;

import com.shopee.protocol.shop.Voucher;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetUserVoucher extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Voucher> DEFAULT_VOUCHERS = Collections.emptyList();
    public static final List<VoucherWalletVoucher> DEFAULT_VOUCHER_WALLET_VOUCHERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherWalletVoucher.class, tag = 4)
    public final List<VoucherWalletVoucher> voucher_wallet_vouchers;
    @ProtoField(label = Message.Label.REPEATED, messageType = Voucher.class, tag = 3)
    public final List<Voucher> vouchers;

    public ResponseGetUserVoucher(String str, Integer num, List<Voucher> list, List<VoucherWalletVoucher> list2) {
        this.requestid = str;
        this.errcode = num;
        this.vouchers = immutableCopyOf(list);
        this.voucher_wallet_vouchers = immutableCopyOf(list2);
    }

    private ResponseGetUserVoucher(Builder builder) {
        this(builder.requestid, builder.errcode, builder.vouchers, builder.voucher_wallet_vouchers);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetUserVoucher)) {
            return false;
        }
        ResponseGetUserVoucher responseGetUserVoucher = (ResponseGetUserVoucher) obj;
        if (!equals((Object) this.requestid, (Object) responseGetUserVoucher.requestid) || !equals((Object) this.errcode, (Object) responseGetUserVoucher.errcode) || !equals((List<?>) this.vouchers, (List<?>) responseGetUserVoucher.vouchers) || !equals((List<?>) this.voucher_wallet_vouchers, (List<?>) responseGetUserVoucher.voucher_wallet_vouchers)) {
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
        List<Voucher> list = this.vouchers;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<VoucherWalletVoucher> list2 = this.voucher_wallet_vouchers;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode2 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseGetUserVoucher> {
        public Integer errcode;
        public String requestid;
        public List<VoucherWalletVoucher> voucher_wallet_vouchers;
        public List<Voucher> vouchers;

        public Builder() {
        }

        public Builder(ResponseGetUserVoucher responseGetUserVoucher) {
            super(responseGetUserVoucher);
            if (responseGetUserVoucher != null) {
                this.requestid = responseGetUserVoucher.requestid;
                this.errcode = responseGetUserVoucher.errcode;
                this.vouchers = ResponseGetUserVoucher.copyOf(responseGetUserVoucher.vouchers);
                this.voucher_wallet_vouchers = ResponseGetUserVoucher.copyOf(responseGetUserVoucher.voucher_wallet_vouchers);
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

        public Builder vouchers(List<Voucher> list) {
            this.vouchers = checkForNulls(list);
            return this;
        }

        public Builder voucher_wallet_vouchers(List<VoucherWalletVoucher> list) {
            this.voucher_wallet_vouchers = checkForNulls(list);
            return this;
        }

        public ResponseGetUserVoucher build() {
            return new ResponseGetUserVoucher(this);
        }
    }
}
