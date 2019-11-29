package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ResponseCentralSession extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final f DEFAULT_VALUE = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f value;

    public ResponseCentralSession(String str, Integer num, f fVar) {
        this.requestid = str;
        this.errcode = num;
        this.value = fVar;
    }

    private ResponseCentralSession(Builder builder) {
        this(builder.requestid, builder.errcode, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCentralSession)) {
            return false;
        }
        ResponseCentralSession responseCentralSession = (ResponseCentralSession) obj;
        if (!equals((Object) this.requestid, (Object) responseCentralSession.requestid) || !equals((Object) this.errcode, (Object) responseCentralSession.errcode) || !equals((Object) this.value, (Object) responseCentralSession.value)) {
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
        f fVar = this.value;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCentralSession> {
        public Integer errcode;
        public String requestid;
        public f value;

        public Builder() {
        }

        public Builder(ResponseCentralSession responseCentralSession) {
            super(responseCentralSession);
            if (responseCentralSession != null) {
                this.requestid = responseCentralSession.requestid;
                this.errcode = responseCentralSession.errcode;
                this.value = responseCentralSession.value;
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

        public Builder value(f fVar) {
            this.value = fVar;
            return this;
        }

        public ResponseCentralSession build() {
            return new ResponseCentralSession(this);
        }
    }
}
