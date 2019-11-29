package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GlobalVoucher extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_REWARD_TYPE = 0;
    public static final Integer DEFAULT_USE_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer reward_type;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer use_type;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String voucher_code;

    public GlobalVoucher(Long l, String str, Integer num, String str2, Integer num2, Integer num3) {
        this.promotionid = l;
        this.country = str;
        this.ctime = num;
        this.voucher_code = str2;
        this.use_type = num2;
        this.reward_type = num3;
    }

    private GlobalVoucher(Builder builder) {
        this(builder.promotionid, builder.country, builder.ctime, builder.voucher_code, builder.use_type, builder.reward_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GlobalVoucher)) {
            return false;
        }
        GlobalVoucher globalVoucher = (GlobalVoucher) obj;
        if (!equals((Object) this.promotionid, (Object) globalVoucher.promotionid) || !equals((Object) this.country, (Object) globalVoucher.country) || !equals((Object) this.ctime, (Object) globalVoucher.ctime) || !equals((Object) this.voucher_code, (Object) globalVoucher.voucher_code) || !equals((Object) this.use_type, (Object) globalVoucher.use_type) || !equals((Object) this.reward_type, (Object) globalVoucher.reward_type)) {
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
        String str = this.country;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.ctime;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.voucher_code;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.use_type;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.reward_type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GlobalVoucher> {
        public String country;
        public Integer ctime;
        public Long promotionid;
        public Integer reward_type;
        public Integer use_type;
        public String voucher_code;

        public Builder() {
        }

        public Builder(GlobalVoucher globalVoucher) {
            super(globalVoucher);
            if (globalVoucher != null) {
                this.promotionid = globalVoucher.promotionid;
                this.country = globalVoucher.country;
                this.ctime = globalVoucher.ctime;
                this.voucher_code = globalVoucher.voucher_code;
                this.use_type = globalVoucher.use_type;
                this.reward_type = globalVoucher.reward_type;
            }
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder use_type(Integer num) {
            this.use_type = num;
            return this;
        }

        public Builder reward_type(Integer num) {
            this.reward_type = num;
            return this;
        }

        public GlobalVoucher build() {
            return new GlobalVoucher(this);
        }
    }
}
