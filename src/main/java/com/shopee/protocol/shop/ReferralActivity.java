package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReferralActivity extends Message {
    public static final Integer DEFAULT_ACTIVITY_ID = 0;
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_REFERRAL_ID = 0;
    public static final Integer DEFAULT_REFERRAL_USERID = 0;
    public static final Integer DEFAULT_REFERRER_USERID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer activity_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer referral_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer referral_userid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer referrer_userid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public ReferralActivity(Integer num, Integer num2, Integer num3, Integer num4, Long l, Integer num5, Integer num6, Integer num7) {
        this.activity_id = num;
        this.referral_id = num2;
        this.referral_userid = num3;
        this.referrer_userid = num4;
        this.coin_earn = l;
        this.status = num5;
        this.ctime = num6;
        this.mtime = num7;
    }

    private ReferralActivity(Builder builder) {
        this(builder.activity_id, builder.referral_id, builder.referral_userid, builder.referrer_userid, builder.coin_earn, builder.status, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReferralActivity)) {
            return false;
        }
        ReferralActivity referralActivity = (ReferralActivity) obj;
        if (!equals((Object) this.activity_id, (Object) referralActivity.activity_id) || !equals((Object) this.referral_id, (Object) referralActivity.referral_id) || !equals((Object) this.referral_userid, (Object) referralActivity.referral_userid) || !equals((Object) this.referrer_userid, (Object) referralActivity.referrer_userid) || !equals((Object) this.coin_earn, (Object) referralActivity.coin_earn) || !equals((Object) this.status, (Object) referralActivity.status) || !equals((Object) this.ctime, (Object) referralActivity.ctime) || !equals((Object) this.mtime, (Object) referralActivity.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.activity_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.referral_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.referral_userid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.referrer_userid;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l = this.coin_earn;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReferralActivity> {
        public Integer activity_id;
        public Long coin_earn;
        public Integer ctime;
        public Integer mtime;
        public Integer referral_id;
        public Integer referral_userid;
        public Integer referrer_userid;
        public Integer status;

        public Builder() {
        }

        public Builder(ReferralActivity referralActivity) {
            super(referralActivity);
            if (referralActivity != null) {
                this.activity_id = referralActivity.activity_id;
                this.referral_id = referralActivity.referral_id;
                this.referral_userid = referralActivity.referral_userid;
                this.referrer_userid = referralActivity.referrer_userid;
                this.coin_earn = referralActivity.coin_earn;
                this.status = referralActivity.status;
                this.ctime = referralActivity.ctime;
                this.mtime = referralActivity.mtime;
            }
        }

        public Builder activity_id(Integer num) {
            this.activity_id = num;
            return this;
        }

        public Builder referral_id(Integer num) {
            this.referral_id = num;
            return this;
        }

        public Builder referral_userid(Integer num) {
            this.referral_userid = num;
            return this;
        }

        public Builder referrer_userid(Integer num) {
            this.referrer_userid = num;
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
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

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public ReferralActivity build() {
            return new ReferralActivity(this);
        }
    }
}
