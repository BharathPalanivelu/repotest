package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetToken extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetToken(String str, Integer num, Integer num2, String str2) {
        this.requestid = str;
        this.userid = num;
        this.shopid = num2;
        this.country = str2;
    }

    private GetToken(Builder builder) {
        this(builder.requestid, builder.userid, builder.shopid, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetToken)) {
            return false;
        }
        GetToken getToken = (GetToken) obj;
        if (!equals((Object) this.requestid, (Object) getToken.requestid) || !equals((Object) this.userid, (Object) getToken.userid) || !equals((Object) this.shopid, (Object) getToken.shopid) || !equals((Object) this.country, (Object) getToken.country)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetToken> {
        public String country;
        public String requestid;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetToken getToken) {
            super(getToken);
            if (getToken != null) {
                this.requestid = getToken.requestid;
                this.userid = getToken.userid;
                this.shopid = getToken.shopid;
                this.country = getToken.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public GetToken build() {
            return new GetToken(this);
        }
    }
}
