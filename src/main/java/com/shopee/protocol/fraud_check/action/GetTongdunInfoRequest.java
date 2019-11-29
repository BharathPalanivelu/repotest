package com.shopee.protocol.fraud_check.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetTongdunInfoRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TONGDUN_BLACKBOX = "";
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String tongdun_blackbox;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer user_agent_type;

    public GetTongdunInfoRequest(String str, String str2, String str3, Integer num) {
        this.requestid = str;
        this.tongdun_blackbox = str2;
        this.country = str3;
        this.user_agent_type = num;
    }

    private GetTongdunInfoRequest(Builder builder) {
        this(builder.requestid, builder.tongdun_blackbox, builder.country, builder.user_agent_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTongdunInfoRequest)) {
            return false;
        }
        GetTongdunInfoRequest getTongdunInfoRequest = (GetTongdunInfoRequest) obj;
        if (!equals((Object) this.requestid, (Object) getTongdunInfoRequest.requestid) || !equals((Object) this.tongdun_blackbox, (Object) getTongdunInfoRequest.tongdun_blackbox) || !equals((Object) this.country, (Object) getTongdunInfoRequest.country) || !equals((Object) this.user_agent_type, (Object) getTongdunInfoRequest.user_agent_type)) {
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
        String str2 = this.tongdun_blackbox;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.user_agent_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetTongdunInfoRequest> {
        public String country;
        public String requestid;
        public String tongdun_blackbox;
        public Integer user_agent_type;

        public Builder() {
        }

        public Builder(GetTongdunInfoRequest getTongdunInfoRequest) {
            super(getTongdunInfoRequest);
            if (getTongdunInfoRequest != null) {
                this.requestid = getTongdunInfoRequest.requestid;
                this.tongdun_blackbox = getTongdunInfoRequest.tongdun_blackbox;
                this.country = getTongdunInfoRequest.country;
                this.user_agent_type = getTongdunInfoRequest.user_agent_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder tongdun_blackbox(String str) {
            this.tongdun_blackbox = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder user_agent_type(Integer num) {
            this.user_agent_type = num;
            return this;
        }

        public GetTongdunInfoRequest build() {
            return new GetTongdunInfoRequest(this);
        }
    }
}
