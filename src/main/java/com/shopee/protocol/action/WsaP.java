package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class WsaP extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final f DEFAULT_PAYLOAD = f.f32736b;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f payload;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public WsaP(String str, Integer num, String str2, f fVar) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.payload = fVar;
    }

    private WsaP(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.payload);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WsaP)) {
            return false;
        }
        WsaP wsaP = (WsaP) obj;
        if (!equals((Object) this.requestid, (Object) wsaP.requestid) || !equals((Object) this.errcode, (Object) wsaP.errcode) || !equals((Object) this.debug_msg, (Object) wsaP.debug_msg) || !equals((Object) this.payload, (Object) wsaP.payload)) {
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
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.payload;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WsaP> {
        public String debug_msg;
        public Integer errcode;
        public f payload;
        public String requestid;

        public Builder() {
        }

        public Builder(WsaP wsaP) {
            super(wsaP);
            if (wsaP != null) {
                this.requestid = wsaP.requestid;
                this.errcode = wsaP.errcode;
                this.debug_msg = wsaP.debug_msg;
                this.payload = wsaP.payload;
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder payload(f fVar) {
            this.payload = fVar;
            return this;
        }

        public WsaP build() {
            return new WsaP(this);
        }
    }
}
