package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class WsaR extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_PAYLOAD = f.f32736b;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SALT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f payload;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String salt;

    public WsaR(String str, f fVar, Integer num, String str2, String str3, f fVar2) {
        this.requestid = str;
        this.deviceid = fVar;
        this.appversion = num;
        this.country = str2;
        this.salt = str3;
        this.payload = fVar2;
    }

    private WsaR(Builder builder) {
        this(builder.requestid, builder.deviceid, builder.appversion, builder.country, builder.salt, builder.payload);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WsaR)) {
            return false;
        }
        WsaR wsaR = (WsaR) obj;
        if (!equals((Object) this.requestid, (Object) wsaR.requestid) || !equals((Object) this.deviceid, (Object) wsaR.deviceid) || !equals((Object) this.appversion, (Object) wsaR.appversion) || !equals((Object) this.country, (Object) wsaR.country) || !equals((Object) this.salt, (Object) wsaR.salt) || !equals((Object) this.payload, (Object) wsaR.payload)) {
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
        f fVar = this.deviceid;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.appversion;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.salt;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar2 = this.payload;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WsaR> {
        public Integer appversion;
        public String country;
        public f deviceid;
        public f payload;
        public String requestid;
        public String salt;

        public Builder() {
        }

        public Builder(WsaR wsaR) {
            super(wsaR);
            if (wsaR != null) {
                this.requestid = wsaR.requestid;
                this.deviceid = wsaR.deviceid;
                this.appversion = wsaR.appversion;
                this.country = wsaR.country;
                this.salt = wsaR.salt;
                this.payload = wsaR.payload;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder salt(String str) {
            this.salt = str;
            return this;
        }

        public Builder payload(f fVar) {
            this.payload = fVar;
            return this;
        }

        public WsaR build() {
            return new WsaR(this);
        }
    }
}
