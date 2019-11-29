package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VoucherWalletSaveVoucher extends Message {
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SIGNATURE = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String voucher_code;

    public VoucherWalletSaveVoucher(String str, String str2, String str3, Long l, String str4) {
        this.requestid = str;
        this.token = str2;
        this.voucher_code = str3;
        this.promotionid = l;
        this.signature = str4;
    }

    private VoucherWalletSaveVoucher(Builder builder) {
        this(builder.requestid, builder.token, builder.voucher_code, builder.promotionid, builder.signature);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherWalletSaveVoucher)) {
            return false;
        }
        VoucherWalletSaveVoucher voucherWalletSaveVoucher = (VoucherWalletSaveVoucher) obj;
        if (!equals((Object) this.requestid, (Object) voucherWalletSaveVoucher.requestid) || !equals((Object) this.token, (Object) voucherWalletSaveVoucher.token) || !equals((Object) this.voucher_code, (Object) voucherWalletSaveVoucher.voucher_code) || !equals((Object) this.promotionid, (Object) voucherWalletSaveVoucher.promotionid) || !equals((Object) this.signature, (Object) voucherWalletSaveVoucher.signature)) {
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
        String str3 = this.voucher_code;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str4 = this.signature;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherWalletSaveVoucher> {
        public Long promotionid;
        public String requestid;
        public String signature;
        public String token;
        public String voucher_code;

        public Builder() {
        }

        public Builder(VoucherWalletSaveVoucher voucherWalletSaveVoucher) {
            super(voucherWalletSaveVoucher);
            if (voucherWalletSaveVoucher != null) {
                this.requestid = voucherWalletSaveVoucher.requestid;
                this.token = voucherWalletSaveVoucher.token;
                this.voucher_code = voucherWalletSaveVoucher.voucher_code;
                this.promotionid = voucherWalletSaveVoucher.promotionid;
                this.signature = voucherWalletSaveVoucher.signature;
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

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public VoucherWalletSaveVoucher build() {
            return new VoucherWalletSaveVoucher(this);
        }
    }
}
