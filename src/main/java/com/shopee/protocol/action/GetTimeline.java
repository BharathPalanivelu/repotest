package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetTimeline extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_LAST_TIMESTAMP = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long last_timestamp;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public GetTimeline(String str, Long l, Integer num, String str2, String str3) {
        this.requestid = str;
        this.last_timestamp = l;
        this.limit = num;
        this.token = str2;
        this.country = str3;
    }

    private GetTimeline(Builder builder) {
        this(builder.requestid, builder.last_timestamp, builder.limit, builder.token, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTimeline)) {
            return false;
        }
        GetTimeline getTimeline = (GetTimeline) obj;
        if (!equals((Object) this.requestid, (Object) getTimeline.requestid) || !equals((Object) this.last_timestamp, (Object) getTimeline.last_timestamp) || !equals((Object) this.limit, (Object) getTimeline.limit) || !equals((Object) this.token, (Object) getTimeline.token) || !equals((Object) this.country, (Object) getTimeline.country)) {
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
        Long l = this.last_timestamp;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.limit;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
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

    public static final class Builder extends Message.Builder<GetTimeline> {
        public String country;
        public Long last_timestamp;
        public Integer limit;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetTimeline getTimeline) {
            super(getTimeline);
            if (getTimeline != null) {
                this.requestid = getTimeline.requestid;
                this.last_timestamp = getTimeline.last_timestamp;
                this.limit = getTimeline.limit;
                this.token = getTimeline.token;
                this.country = getTimeline.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder last_timestamp(Long l) {
            this.last_timestamp = l;
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

        public GetTimeline build() {
            return new GetTimeline(this);
        }
    }
}
