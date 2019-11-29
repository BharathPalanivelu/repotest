package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReqCheckToken extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public ReqCheckToken(String str, String str2) {
        this.requestid = str;
        this.token = str2;
    }

    private ReqCheckToken(Builder builder) {
        this(builder.requestid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReqCheckToken)) {
            return false;
        }
        ReqCheckToken reqCheckToken = (ReqCheckToken) obj;
        if (!equals((Object) this.requestid, (Object) reqCheckToken.requestid) || !equals((Object) this.token, (Object) reqCheckToken.token)) {
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
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReqCheckToken> {
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ReqCheckToken reqCheckToken) {
            super(reqCheckToken);
            if (reqCheckToken != null) {
                this.requestid = reqCheckToken.requestid;
                this.token = reqCheckToken.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public ReqCheckToken build() {
            return new ReqCheckToken(this);
        }
    }
}
