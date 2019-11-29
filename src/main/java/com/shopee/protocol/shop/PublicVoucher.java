package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PublicVoucher extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USAGE_LIMIT = 0;
    public static final Integer DEFAULT_USED_COUNT = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer usage_limit;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer used_count;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String voucher_code;

    public PublicVoucher(String str, Long l, Integer num, Integer num2, Integer num3, Integer num4, String str2) {
        this.voucher_code = str;
        this.promotionid = l;
        this.usage_limit = num;
        this.used_count = num2;
        this.status = num3;
        this.ctime = num4;
        this.country = str2;
    }

    private PublicVoucher(Builder builder) {
        this(builder.voucher_code, builder.promotionid, builder.usage_limit, builder.used_count, builder.status, builder.ctime, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PublicVoucher)) {
            return false;
        }
        PublicVoucher publicVoucher = (PublicVoucher) obj;
        if (!equals((Object) this.voucher_code, (Object) publicVoucher.voucher_code) || !equals((Object) this.promotionid, (Object) publicVoucher.promotionid) || !equals((Object) this.usage_limit, (Object) publicVoucher.usage_limit) || !equals((Object) this.used_count, (Object) publicVoucher.used_count) || !equals((Object) this.status, (Object) publicVoucher.status) || !equals((Object) this.ctime, (Object) publicVoucher.ctime) || !equals((Object) this.country, (Object) publicVoucher.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.voucher_code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.usage_limit;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.used_count;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PublicVoucher> {
        public String country;
        public Integer ctime;
        public Long promotionid;
        public Integer status;
        public Integer usage_limit;
        public Integer used_count;
        public String voucher_code;

        public Builder() {
        }

        public Builder(PublicVoucher publicVoucher) {
            super(publicVoucher);
            if (publicVoucher != null) {
                this.voucher_code = publicVoucher.voucher_code;
                this.promotionid = publicVoucher.promotionid;
                this.usage_limit = publicVoucher.usage_limit;
                this.used_count = publicVoucher.used_count;
                this.status = publicVoucher.status;
                this.ctime = publicVoucher.ctime;
                this.country = publicVoucher.country;
            }
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder usage_limit(Integer num) {
            this.usage_limit = num;
            return this;
        }

        public Builder used_count(Integer num) {
            this.used_count = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public PublicVoucher build() {
            return new PublicVoucher(this);
        }
    }
}
