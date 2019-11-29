package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VoucherAudit extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USAGE_TIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    public static final Integer DEFAULT_VOUCHER_MARKET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer usage_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String voucher_code;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer voucher_market_type;

    public VoucherAudit(Integer num, String str, Long l, Long l2, Integer num2, Integer num3, Integer num4) {
        this.userid = num;
        this.voucher_code = str;
        this.promotionid = l;
        this.checkoutid = l2;
        this.usage_time = num2;
        this.status = num3;
        this.voucher_market_type = num4;
    }

    private VoucherAudit(Builder builder) {
        this(builder.userid, builder.voucher_code, builder.promotionid, builder.checkoutid, builder.usage_time, builder.status, builder.voucher_market_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherAudit)) {
            return false;
        }
        VoucherAudit voucherAudit = (VoucherAudit) obj;
        if (!equals((Object) this.userid, (Object) voucherAudit.userid) || !equals((Object) this.voucher_code, (Object) voucherAudit.voucher_code) || !equals((Object) this.promotionid, (Object) voucherAudit.promotionid) || !equals((Object) this.checkoutid, (Object) voucherAudit.checkoutid) || !equals((Object) this.usage_time, (Object) voucherAudit.usage_time) || !equals((Object) this.status, (Object) voucherAudit.status) || !equals((Object) this.voucher_market_type, (Object) voucherAudit.voucher_market_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.voucher_code;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.checkoutid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.usage_time;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.voucher_market_type;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherAudit> {
        public Long checkoutid;
        public Long promotionid;
        public Integer status;
        public Integer usage_time;
        public Integer userid;
        public String voucher_code;
        public Integer voucher_market_type;

        public Builder() {
        }

        public Builder(VoucherAudit voucherAudit) {
            super(voucherAudit);
            if (voucherAudit != null) {
                this.userid = voucherAudit.userid;
                this.voucher_code = voucherAudit.voucher_code;
                this.promotionid = voucherAudit.promotionid;
                this.checkoutid = voucherAudit.checkoutid;
                this.usage_time = voucherAudit.usage_time;
                this.status = voucherAudit.status;
                this.voucher_market_type = voucherAudit.voucher_market_type;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder usage_time(Integer num) {
            this.usage_time = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder voucher_market_type(Integer num) {
            this.voucher_market_type = num;
            return this;
        }

        public VoucherAudit build() {
            return new VoucherAudit(this);
        }
    }
}
