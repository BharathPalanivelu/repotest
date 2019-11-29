package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResultUser extends Message {
    public static final String DEFAULT_ABTEST_SIGN = "";
    public static final Long DEFAULT_ADSID = 0L;
    public static final String DEFAULT_ADS_KEYWORD = "";
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_DEDUCTION_INFO = "";
    public static final String DEFAULT_JSON_DATA = "";
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String abtest_sign;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String ads_keyword;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String deduction_info;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer match_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public ResultUser(Integer num, Long l, Long l2, String str, Integer num2, String str2, String str3, String str4) {
        this.userid = num;
        this.campaignid = l;
        this.adsid = l2;
        this.ads_keyword = str;
        this.match_type = num2;
        this.deduction_info = str2;
        this.abtest_sign = str3;
        this.json_data = str4;
    }

    private ResultUser(Builder builder) {
        this(builder.userid, builder.campaignid, builder.adsid, builder.ads_keyword, builder.match_type, builder.deduction_info, builder.abtest_sign, builder.json_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResultUser)) {
            return false;
        }
        ResultUser resultUser = (ResultUser) obj;
        if (!equals((Object) this.userid, (Object) resultUser.userid) || !equals((Object) this.campaignid, (Object) resultUser.campaignid) || !equals((Object) this.adsid, (Object) resultUser.adsid) || !equals((Object) this.ads_keyword, (Object) resultUser.ads_keyword) || !equals((Object) this.match_type, (Object) resultUser.match_type) || !equals((Object) this.deduction_info, (Object) resultUser.deduction_info) || !equals((Object) this.abtest_sign, (Object) resultUser.abtest_sign) || !equals((Object) this.json_data, (Object) resultUser.json_data)) {
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
        Long l = this.campaignid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.adsid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.ads_keyword;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.match_type;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.deduction_info;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.abtest_sign;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.json_data;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResultUser> {
        public String abtest_sign;
        public String ads_keyword;
        public Long adsid;
        public Long campaignid;
        public String deduction_info;
        public String json_data;
        public Integer match_type;
        public Integer userid;

        public Builder() {
        }

        public Builder(ResultUser resultUser) {
            super(resultUser);
            if (resultUser != null) {
                this.userid = resultUser.userid;
                this.campaignid = resultUser.campaignid;
                this.adsid = resultUser.adsid;
                this.ads_keyword = resultUser.ads_keyword;
                this.match_type = resultUser.match_type;
                this.deduction_info = resultUser.deduction_info;
                this.abtest_sign = resultUser.abtest_sign;
                this.json_data = resultUser.json_data;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder ads_keyword(String str) {
            this.ads_keyword = str;
            return this;
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public Builder deduction_info(String str) {
            this.deduction_info = str;
            return this;
        }

        public Builder abtest_sign(String str) {
            this.abtest_sign = str;
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public ResultUser build() {
            return new ResultUser(this);
        }
    }
}
