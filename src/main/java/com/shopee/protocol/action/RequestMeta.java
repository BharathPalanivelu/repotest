package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestMeta extends Message {
    public static final String DEFAULT_CLIENT_TYPE = "";
    public static final String DEFAULT_DEVICE_FINGERPRINT = "";
    public static final String DEFAULT_IP = "";
    public static final String DEFAULT_SYSTEM_VERSION = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String client_type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String device_fingerprint;
    @ProtoField(tag = 2)
    public final GPS gps;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String ip;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String system_version;

    public RequestMeta(String str, GPS gps2, String str2, String str3, String str4) {
        this.ip = str;
        this.gps = gps2;
        this.device_fingerprint = str2;
        this.client_type = str3;
        this.system_version = str4;
    }

    private RequestMeta(Builder builder) {
        this(builder.ip, builder.gps, builder.device_fingerprint, builder.client_type, builder.system_version);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestMeta)) {
            return false;
        }
        RequestMeta requestMeta = (RequestMeta) obj;
        if (!equals((Object) this.ip, (Object) requestMeta.ip) || !equals((Object) this.gps, (Object) requestMeta.gps) || !equals((Object) this.device_fingerprint, (Object) requestMeta.device_fingerprint) || !equals((Object) this.client_type, (Object) requestMeta.client_type) || !equals((Object) this.system_version, (Object) requestMeta.system_version)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.ip;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        GPS gps2 = this.gps;
        int hashCode2 = (hashCode + (gps2 != null ? gps2.hashCode() : 0)) * 37;
        String str2 = this.device_fingerprint;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.client_type;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.system_version;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestMeta> {
        public String client_type;
        public String device_fingerprint;
        public GPS gps;
        public String ip;
        public String system_version;

        public Builder() {
        }

        public Builder(RequestMeta requestMeta) {
            super(requestMeta);
            if (requestMeta != null) {
                this.ip = requestMeta.ip;
                this.gps = requestMeta.gps;
                this.device_fingerprint = requestMeta.device_fingerprint;
                this.client_type = requestMeta.client_type;
                this.system_version = requestMeta.system_version;
            }
        }

        public Builder ip(String str) {
            this.ip = str;
            return this;
        }

        public Builder gps(GPS gps2) {
            this.gps = gps2;
            return this;
        }

        public Builder device_fingerprint(String str) {
            this.device_fingerprint = str;
            return this;
        }

        public Builder client_type(String str) {
            this.client_type = str;
            return this;
        }

        public Builder system_version(String str) {
            this.system_version = str;
            return this;
        }

        public RequestMeta build() {
            return new RequestMeta(this);
        }
    }
}
