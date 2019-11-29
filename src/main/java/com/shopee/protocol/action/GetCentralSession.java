package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCentralSession extends Message {
    public static final String DEFAULT_CLIENT_ID = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String client_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCentralSession(String str, String str2, String str3) {
        this.requestid = str;
        this.key = str2;
        this.client_id = str3;
    }

    private GetCentralSession(Builder builder) {
        this(builder.requestid, builder.key, builder.client_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCentralSession)) {
            return false;
        }
        GetCentralSession getCentralSession = (GetCentralSession) obj;
        if (!equals((Object) this.requestid, (Object) getCentralSession.requestid) || !equals((Object) this.key, (Object) getCentralSession.key) || !equals((Object) this.client_id, (Object) getCentralSession.client_id)) {
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
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.client_id;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCentralSession> {
        public String client_id;
        public String key;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCentralSession getCentralSession) {
            super(getCentralSession);
            if (getCentralSession != null) {
                this.requestid = getCentralSession.requestid;
                this.key = getCentralSession.key;
                this.client_id = getCentralSession.client_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder client_id(String str) {
            this.client_id = str;
            return this;
        }

        public GetCentralSession build() {
            return new GetCentralSession(this);
        }
    }
}
