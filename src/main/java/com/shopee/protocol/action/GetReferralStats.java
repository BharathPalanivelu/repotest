package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetReferralStats extends Message {
    public static final String DEFAULT_REFERRAL_CODE = "";
    public static final Integer DEFAULT_REFERRER_USERID = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String referral_code;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer referrer_userid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetReferralStats(String str, Integer num, String str2) {
        this.requestid = str;
        this.referrer_userid = num;
        this.referral_code = str2;
    }

    private GetReferralStats(Builder builder) {
        this(builder.requestid, builder.referrer_userid, builder.referral_code);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetReferralStats)) {
            return false;
        }
        GetReferralStats getReferralStats = (GetReferralStats) obj;
        if (!equals((Object) this.requestid, (Object) getReferralStats.requestid) || !equals((Object) this.referrer_userid, (Object) getReferralStats.referrer_userid) || !equals((Object) this.referral_code, (Object) getReferralStats.referral_code)) {
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
        Integer num = this.referrer_userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.referral_code;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetReferralStats> {
        public String referral_code;
        public Integer referrer_userid;
        public String requestid;

        public Builder() {
        }

        public Builder(GetReferralStats getReferralStats) {
            super(getReferralStats);
            if (getReferralStats != null) {
                this.requestid = getReferralStats.requestid;
                this.referrer_userid = getReferralStats.referrer_userid;
                this.referral_code = getReferralStats.referral_code;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder referrer_userid(Integer num) {
            this.referrer_userid = num;
            return this;
        }

        public Builder referral_code(String str) {
            this.referral_code = str;
            return this;
        }

        public GetReferralStats build() {
            return new GetReferralStats(this);
        }
    }
}
