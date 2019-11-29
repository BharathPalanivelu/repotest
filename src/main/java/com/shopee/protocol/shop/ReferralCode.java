package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReferralCode extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String voucher_code;

    public ReferralCode(Long l, Integer num, String str, String str2, Integer num2, Long l2) {
        this.id = l;
        this.userid = num;
        this.voucher_code = str;
        this.country = str2;
        this.ctime = num2;
        this.promotionid = l2;
    }

    private ReferralCode(Builder builder) {
        this(builder.id, builder.userid, builder.voucher_code, builder.country, builder.ctime, builder.promotionid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReferralCode)) {
            return false;
        }
        ReferralCode referralCode = (ReferralCode) obj;
        if (!equals((Object) this.id, (Object) referralCode.id) || !equals((Object) this.userid, (Object) referralCode.userid) || !equals((Object) this.voucher_code, (Object) referralCode.voucher_code) || !equals((Object) this.country, (Object) referralCode.country) || !equals((Object) this.ctime, (Object) referralCode.ctime) || !equals((Object) this.promotionid, (Object) referralCode.promotionid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.voucher_code;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.promotionid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReferralCode> {
        public String country;
        public Integer ctime;
        public Long id;
        public Long promotionid;
        public Integer userid;
        public String voucher_code;

        public Builder() {
        }

        public Builder(ReferralCode referralCode) {
            super(referralCode);
            if (referralCode != null) {
                this.id = referralCode.id;
                this.userid = referralCode.userid;
                this.voucher_code = referralCode.voucher_code;
                this.country = referralCode.country;
                this.ctime = referralCode.ctime;
                this.promotionid = referralCode.promotionid;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
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

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public ReferralCode build() {
            return new ReferralCode(this);
        }
    }
}
