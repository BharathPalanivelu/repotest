package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VoucherIdentity extends Message {
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_SIGNATURE = "";
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String voucher_code;

    public VoucherIdentity(Long l, String str, String str2) {
        this.promotionid = l;
        this.voucher_code = str;
        this.signature = str2;
    }

    private VoucherIdentity(Builder builder) {
        this(builder.promotionid, builder.voucher_code, builder.signature);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherIdentity)) {
            return false;
        }
        VoucherIdentity voucherIdentity = (VoucherIdentity) obj;
        if (!equals((Object) this.promotionid, (Object) voucherIdentity.promotionid) || !equals((Object) this.voucher_code, (Object) voucherIdentity.voucher_code) || !equals((Object) this.signature, (Object) voucherIdentity.signature)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.promotionid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.voucher_code;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.signature;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherIdentity> {
        public Long promotionid;
        public String signature;
        public String voucher_code;

        public Builder() {
        }

        public Builder(VoucherIdentity voucherIdentity) {
            super(voucherIdentity);
            if (voucherIdentity != null) {
                this.promotionid = voucherIdentity.promotionid;
                this.voucher_code = voucherIdentity.voucher_code;
                this.signature = voucherIdentity.signature;
            }
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public VoucherIdentity build() {
            return new VoucherIdentity(this);
        }
    }
}
