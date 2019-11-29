package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CallBackend extends Message {
    public static final String DEFAULT_PAYLOAD = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SUBCMD = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String payload;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer subcmd;

    public CallBackend(String str, Integer num, String str2) {
        this.requestid = str;
        this.subcmd = num;
        this.payload = str2;
    }

    private CallBackend(Builder builder) {
        this(builder.requestid, builder.subcmd, builder.payload);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CallBackend)) {
            return false;
        }
        CallBackend callBackend = (CallBackend) obj;
        if (!equals((Object) this.requestid, (Object) callBackend.requestid) || !equals((Object) this.subcmd, (Object) callBackend.subcmd) || !equals((Object) this.payload, (Object) callBackend.payload)) {
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
        Integer num = this.subcmd;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.payload;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CallBackend> {
        public String payload;
        public String requestid;
        public Integer subcmd;

        public Builder() {
        }

        public Builder(CallBackend callBackend) {
            super(callBackend);
            if (callBackend != null) {
                this.requestid = callBackend.requestid;
                this.subcmd = callBackend.subcmd;
                this.payload = callBackend.payload;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder subcmd(Integer num) {
            this.subcmd = num;
            return this;
        }

        public Builder payload(String str) {
            this.payload = str;
            return this;
        }

        public CallBackend build() {
            return new CallBackend(this);
        }
    }
}
