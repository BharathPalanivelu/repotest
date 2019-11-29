package com.shopee.protocol.ads.action;

import com.shopee.protocol.action.BackendParam;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestHeader extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public RequestHeader(String str, BackendParam backendParam, String str2, Integer num, String str3, Integer num2) {
        this.requestid = str;
        this.bparam = backendParam;
        this.token = str2;
        this.userid = num;
        this.country = str3;
        this.shopid = num2;
    }

    private RequestHeader(Builder builder) {
        this(builder.requestid, builder.bparam, builder.token, builder.userid, builder.country, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestHeader)) {
            return false;
        }
        RequestHeader requestHeader = (RequestHeader) obj;
        if (!equals((Object) this.requestid, (Object) requestHeader.requestid) || !equals((Object) this.bparam, (Object) requestHeader.bparam) || !equals((Object) this.token, (Object) requestHeader.token) || !equals((Object) this.userid, (Object) requestHeader.userid) || !equals((Object) this.country, (Object) requestHeader.country) || !equals((Object) this.shopid, (Object) requestHeader.shopid)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestHeader> {
        public BackendParam bparam;
        public String country;
        public String requestid;
        public Integer shopid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(RequestHeader requestHeader) {
            super(requestHeader);
            if (requestHeader != null) {
                this.requestid = requestHeader.requestid;
                this.bparam = requestHeader.bparam;
                this.token = requestHeader.token;
                this.userid = requestHeader.userid;
                this.country = requestHeader.country;
                this.shopid = requestHeader.shopid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public RequestHeader build() {
            return new RequestHeader(this);
        }
    }
}
