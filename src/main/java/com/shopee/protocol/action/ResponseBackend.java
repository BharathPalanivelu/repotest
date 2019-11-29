package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseBackend extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_RESPONSE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String response;

    public ResponseBackend(String str, Integer num, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.response = str2;
    }

    private ResponseBackend(Builder builder) {
        this(builder.requestid, builder.errcode, builder.response);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseBackend)) {
            return false;
        }
        ResponseBackend responseBackend = (ResponseBackend) obj;
        if (!equals((Object) this.requestid, (Object) responseBackend.requestid) || !equals((Object) this.errcode, (Object) responseBackend.errcode) || !equals((Object) this.response, (Object) responseBackend.response)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.response;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseBackend> {
        public Integer errcode;
        public String requestid;
        public String response;

        public Builder() {
        }

        public Builder(ResponseBackend responseBackend) {
            super(responseBackend);
            if (responseBackend != null) {
                this.requestid = responseBackend.requestid;
                this.errcode = responseBackend.errcode;
                this.response = responseBackend.response;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder response(String str) {
            this.response = str;
            return this;
        }

        public ResponseBackend build() {
            checkRequiredFields();
            return new ResponseBackend(this);
        }
    }
}
