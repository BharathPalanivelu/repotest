package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VoucherWalletGetVouchers extends Message {
    public static final Boolean DEFAULT_COUNT_ONLY = false;
    public static final Boolean DEFAULT_FREE_SHIPPING_ONLY = false;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean count_only;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean free_shipping_only;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public VoucherWalletGetVouchers(String str, String str2, Integer num, Boolean bool, Integer num2, Integer num3, Boolean bool2) {
        this.requestid = str;
        this.token = str2;
        this.type = num;
        this.count_only = bool;
        this.offset = num2;
        this.limit = num3;
        this.free_shipping_only = bool2;
    }

    private VoucherWalletGetVouchers(Builder builder) {
        this(builder.requestid, builder.token, builder.type, builder.count_only, builder.offset, builder.limit, builder.free_shipping_only);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherWalletGetVouchers)) {
            return false;
        }
        VoucherWalletGetVouchers voucherWalletGetVouchers = (VoucherWalletGetVouchers) obj;
        if (!equals((Object) this.requestid, (Object) voucherWalletGetVouchers.requestid) || !equals((Object) this.token, (Object) voucherWalletGetVouchers.token) || !equals((Object) this.type, (Object) voucherWalletGetVouchers.type) || !equals((Object) this.count_only, (Object) voucherWalletGetVouchers.count_only) || !equals((Object) this.offset, (Object) voucherWalletGetVouchers.offset) || !equals((Object) this.limit, (Object) voucherWalletGetVouchers.limit) || !equals((Object) this.free_shipping_only, (Object) voucherWalletGetVouchers.free_shipping_only)) {
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
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.count_only;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool2 = this.free_shipping_only;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherWalletGetVouchers> {
        public Boolean count_only;
        public Boolean free_shipping_only;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(VoucherWalletGetVouchers voucherWalletGetVouchers) {
            super(voucherWalletGetVouchers);
            if (voucherWalletGetVouchers != null) {
                this.requestid = voucherWalletGetVouchers.requestid;
                this.token = voucherWalletGetVouchers.token;
                this.type = voucherWalletGetVouchers.type;
                this.count_only = voucherWalletGetVouchers.count_only;
                this.offset = voucherWalletGetVouchers.offset;
                this.limit = voucherWalletGetVouchers.limit;
                this.free_shipping_only = voucherWalletGetVouchers.free_shipping_only;
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

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder count_only(Boolean bool) {
            this.count_only = bool;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder free_shipping_only(Boolean bool) {
            this.free_shipping_only = bool;
            return this;
        }

        public VoucherWalletGetVouchers build() {
            return new VoucherWalletGetVouchers(this);
        }
    }
}
