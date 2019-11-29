package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetReferralRule extends Message {
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_IMAGE_FB = "";
    public static final String DEFAULT_IMAGE_SQUARE = "";
    public static final Integer DEFAULT_MAX_REFERRAL_USER = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_REFERRAL_VOUCHER_USAGE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_SEND_SMS = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String image_fb;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String image_square;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer max_referral_user;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer referral_voucher_usage;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean send_sms;

    public SetReferralRule(String str, Long l, Long l2, String str2, Integer num, Boolean bool, Integer num2, String str3, String str4) {
        this.requestid = str;
        this.promotionid = l;
        this.coin_earn = l2;
        this.country = str2;
        this.max_referral_user = num;
        this.send_sms = bool;
        this.referral_voucher_usage = num2;
        this.image_square = str3;
        this.image_fb = str4;
    }

    private SetReferralRule(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.coin_earn, builder.country, builder.max_referral_user, builder.send_sms, builder.referral_voucher_usage, builder.image_square, builder.image_fb);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetReferralRule)) {
            return false;
        }
        SetReferralRule setReferralRule = (SetReferralRule) obj;
        if (!equals((Object) this.requestid, (Object) setReferralRule.requestid) || !equals((Object) this.promotionid, (Object) setReferralRule.promotionid) || !equals((Object) this.coin_earn, (Object) setReferralRule.coin_earn) || !equals((Object) this.country, (Object) setReferralRule.country) || !equals((Object) this.max_referral_user, (Object) setReferralRule.max_referral_user) || !equals((Object) this.send_sms, (Object) setReferralRule.send_sms) || !equals((Object) this.referral_voucher_usage, (Object) setReferralRule.referral_voucher_usage) || !equals((Object) this.image_square, (Object) setReferralRule.image_square) || !equals((Object) this.image_fb, (Object) setReferralRule.image_fb)) {
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
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.coin_earn;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.max_referral_user;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.send_sms;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.referral_voucher_usage;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.image_square;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.image_fb;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetReferralRule> {
        public Long coin_earn;
        public String country;
        public String image_fb;
        public String image_square;
        public Integer max_referral_user;
        public Long promotionid;
        public Integer referral_voucher_usage;
        public String requestid;
        public Boolean send_sms;

        public Builder() {
        }

        public Builder(SetReferralRule setReferralRule) {
            super(setReferralRule);
            if (setReferralRule != null) {
                this.requestid = setReferralRule.requestid;
                this.promotionid = setReferralRule.promotionid;
                this.coin_earn = setReferralRule.coin_earn;
                this.country = setReferralRule.country;
                this.max_referral_user = setReferralRule.max_referral_user;
                this.send_sms = setReferralRule.send_sms;
                this.referral_voucher_usage = setReferralRule.referral_voucher_usage;
                this.image_square = setReferralRule.image_square;
                this.image_fb = setReferralRule.image_fb;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder max_referral_user(Integer num) {
            this.max_referral_user = num;
            return this;
        }

        public Builder send_sms(Boolean bool) {
            this.send_sms = bool;
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

        public SetReferralRule build() {
            return new SetReferralRule(this);
        }
    }
}
