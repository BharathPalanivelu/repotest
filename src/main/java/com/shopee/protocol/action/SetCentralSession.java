package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SetCentralSession extends Message {
    public static final String DEFAULT_CLIENT_ID = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TTL = 0;
    public static final f DEFAULT_VALUE = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String client_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ttl;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f value;

    public SetCentralSession(String str, String str2, f fVar, Integer num, String str3) {
        this.requestid = str;
        this.key = str2;
        this.value = fVar;
        this.ttl = num;
        this.client_id = str3;
    }

    private SetCentralSession(Builder builder) {
        this(builder.requestid, builder.key, builder.value, builder.ttl, builder.client_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCentralSession)) {
            return false;
        }
        SetCentralSession setCentralSession = (SetCentralSession) obj;
        if (!equals((Object) this.requestid, (Object) setCentralSession.requestid) || !equals((Object) this.key, (Object) setCentralSession.key) || !equals((Object) this.value, (Object) setCentralSession.value) || !equals((Object) this.ttl, (Object) setCentralSession.ttl) || !equals((Object) this.client_id, (Object) setCentralSession.client_id)) {
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
        f fVar = this.value;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.ttl;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.client_id;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCentralSession> {
        public String client_id;
        public String key;
        public String requestid;
        public Integer ttl;
        public f value;

        public Builder() {
        }

        public Builder(SetCentralSession setCentralSession) {
            super(setCentralSession);
            if (setCentralSession != null) {
                this.requestid = setCentralSession.requestid;
                this.key = setCentralSession.key;
                this.value = setCentralSession.value;
                this.ttl = setCentralSession.ttl;
                this.client_id = setCentralSession.client_id;
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

        public Builder value(f fVar) {
            this.value = fVar;
            return this;
        }

        public Builder ttl(Integer num) {
            this.ttl = num;
            return this;
        }

        public Builder client_id(String str) {
            this.client_id = str;
            return this;
        }

        public SetCentralSession build() {
            return new SetCentralSession(this);
        }
    }
}
