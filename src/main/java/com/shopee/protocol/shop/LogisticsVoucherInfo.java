package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LogisticsVoucherInfo extends Message {
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String voucher_code;

    public LogisticsVoucherInfo(Long l, String str) {
        this.promotionid = l;
        this.voucher_code = str;
    }

    private LogisticsVoucherInfo(Builder builder) {
        this(builder.promotionid, builder.voucher_code);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogisticsVoucherInfo)) {
            return false;
        }
        LogisticsVoucherInfo logisticsVoucherInfo = (LogisticsVoucherInfo) obj;
        if (!equals((Object) this.promotionid, (Object) logisticsVoucherInfo.promotionid) || !equals((Object) this.voucher_code, (Object) logisticsVoucherInfo.voucher_code)) {
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
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LogisticsVoucherInfo> {
        public Long promotionid;
        public String voucher_code;

        public Builder() {
        }

        public Builder(LogisticsVoucherInfo logisticsVoucherInfo) {
            super(logisticsVoucherInfo);
            if (logisticsVoucherInfo != null) {
                this.promotionid = logisticsVoucherInfo.promotionid;
                this.voucher_code = logisticsVoucherInfo.voucher_code;
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

        public LogisticsVoucherInfo build() {
            return new LogisticsVoucherInfo(this);
        }
    }
}
