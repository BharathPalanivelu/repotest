package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetTimelineAd extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public GetTimelineAd(String str, Integer num, Integer num2, String str2, String str3) {
        this.requestid = str;
        this.offset = num;
        this.limit = num2;
        this.token = str2;
        this.country = str3;
    }

    private GetTimelineAd(Builder builder) {
        this(builder.requestid, builder.offset, builder.limit, builder.token, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTimelineAd)) {
            return false;
        }
        GetTimelineAd getTimelineAd = (GetTimelineAd) obj;
        if (!equals((Object) this.requestid, (Object) getTimelineAd.requestid) || !equals((Object) this.offset, (Object) getTimelineAd.offset) || !equals((Object) this.limit, (Object) getTimelineAd.limit) || !equals((Object) this.token, (Object) getTimelineAd.token) || !equals((Object) this.country, (Object) getTimelineAd.country)) {
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
        Integer num = this.offset;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetTimelineAd> {
        public String country;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetTimelineAd getTimelineAd) {
            super(getTimelineAd);
            if (getTimelineAd != null) {
                this.requestid = getTimelineAd.requestid;
                this.offset = getTimelineAd.offset;
                this.limit = getTimelineAd.limit;
                this.token = getTimelineAd.token;
                this.country = getTimelineAd.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public GetTimelineAd build() {
            return new GetTimelineAd(this);
        }
    }
}
