package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReferralRule extends Message {
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_IMAGE_FB = "";
    public static final String DEFAULT_IMAGE_SQUARE = "";
    public static final Integer DEFAULT_MAX_REFERRAL_USER = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_REFERRAL_VOUCHER_USAGE = 0;
    public static final Integer DEFAULT_RULE_ID = 0;
    public static final Boolean DEFAULT_SEND_SMS = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String image_fb;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String image_square;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer max_referral_user;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer referral_voucher_usage;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean send_sms;

    public ReferralRule(Integer num, Long l, Long l2, Integer num2, String str, Boolean bool, Integer num3, Integer num4, Integer num5, String str2, String str3) {
        this.rule_id = num;
        this.promotionid = l;
        this.coin_earn = l2;
        this.max_referral_user = num2;
        this.country = str;
        this.send_sms = bool;
        this.ctime = num3;
        this.mtime = num4;
        this.referral_voucher_usage = num5;
        this.image_square = str2;
        this.image_fb = str3;
    }

    private ReferralRule(Builder builder) {
        this(builder.rule_id, builder.promotionid, builder.coin_earn, builder.max_referral_user, builder.country, builder.send_sms, builder.ctime, builder.mtime, builder.referral_voucher_usage, builder.image_square, builder.image_fb);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReferralRule)) {
            return false;
        }
        ReferralRule referralRule = (ReferralRule) obj;
        if (!equals((Object) this.rule_id, (Object) referralRule.rule_id) || !equals((Object) this.promotionid, (Object) referralRule.promotionid) || !equals((Object) this.coin_earn, (Object) referralRule.coin_earn) || !equals((Object) this.max_referral_user, (Object) referralRule.max_referral_user) || !equals((Object) this.country, (Object) referralRule.country) || !equals((Object) this.send_sms, (Object) referralRule.send_sms) || !equals((Object) this.ctime, (Object) referralRule.ctime) || !equals((Object) this.mtime, (Object) referralRule.mtime) || !equals((Object) this.referral_voucher_usage, (Object) referralRule.referral_voucher_usage) || !equals((Object) this.image_square, (Object) referralRule.image_square) || !equals((Object) this.image_fb, (Object) referralRule.image_fb)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.rule_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.coin_earn;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.max_referral_user;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.send_sms;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.referral_voucher_usage;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.image_square;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.image_fb;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReferralRule> {
        public Long coin_earn;
        public String country;
        public Integer ctime;
        public String image_fb;
        public String image_square;
        public Integer max_referral_user;
        public Integer mtime;
        public Long promotionid;
        public Integer referral_voucher_usage;
        public Integer rule_id;
        public Boolean send_sms;

        public Builder() {
        }

        public Builder(ReferralRule referralRule) {
            super(referralRule);
            if (referralRule != null) {
                this.rule_id = referralRule.rule_id;
                this.promotionid = referralRule.promotionid;
                this.coin_earn = referralRule.coin_earn;
                this.max_referral_user = referralRule.max_referral_user;
                this.country = referralRule.country;
                this.send_sms = referralRule.send_sms;
                this.ctime = referralRule.ctime;
                this.mtime = referralRule.mtime;
                this.referral_voucher_usage = referralRule.referral_voucher_usage;
                this.image_square = referralRule.image_square;
                this.image_fb = referralRule.image_fb;
            }
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
            return this;
        }

        public Builder max_referral_user(Integer num) {
            this.max_referral_user = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder send_sms(Boolean bool) {
            this.send_sms = bool;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder referral_voucher_usage(Integer num) {
            this.referral_voucher_usage = num;
            return this;
        }

        public Builder image_square(String str) {
            this.image_square = str;
            return this;
        }

        public Builder image_fb(String str) {
            this.image_fb = str;
            return this;
        }

        public ReferralRule build() {
            return new ReferralRule(this);
        }
    }
}
