package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetMinAppversion extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_MACHINE_CODE = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String machine_code;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetMinAppversion(String str, String str2, String str3) {
        this.requestid = str;
        this.machine_code = str2;
        this.country = str3;
    }

    private GetMinAppversion(Builder builder) {
        this(builder.requestid, builder.machine_code, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetMinAppversion)) {
            return false;
        }
        GetMinAppversion getMinAppversion = (GetMinAppversion) obj;
        if (!equals((Object) this.requestid, (Object) getMinAppversion.requestid) || !equals((Object) this.machine_code, (Object) getMinAppversion.machine_code) || !equals((Object) this.country, (Object) getMinAppversion.country)) {
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
        String str2 = this.machine_code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetMinAppversion> {
        public String country;
        public String machine_code;
        public String requestid;

        public Builder() {
        }

        public Builder(GetMinAppversion getMinAppversion) {
            super(getMinAppversion);
            if (getMinAppversion != null) {
                this.requestid = getMinAppversion.requestid;
                this.machine_code = getMinAppversion.machine_code;
                this.country = getMinAppversion.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder machine_code(String str) {
            this.machine_code = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public GetMinAppversion build() {
            return new GetMinAppversion(this);
        }
    }
}
