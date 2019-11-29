package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetOnlineUsernum extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SOURCE = "";
    public static final Boolean DEFAULT_TOTAL = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean total;

    public GetOnlineUsernum(String str, String str2, Boolean bool, String str3) {
        this.requestid = str;
        this.country = str2;
        this.total = bool;
        this.source = str3;
    }

    private GetOnlineUsernum(Builder builder) {
        this(builder.requestid, builder.country, builder.total, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOnlineUsernum)) {
            return false;
        }
        GetOnlineUsernum getOnlineUsernum = (GetOnlineUsernum) obj;
        if (!equals((Object) this.requestid, (Object) getOnlineUsernum.requestid) || !equals((Object) this.country, (Object) getOnlineUsernum.country) || !equals((Object) this.total, (Object) getOnlineUsernum.total) || !equals((Object) this.source, (Object) getOnlineUsernum.source)) {
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
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.total;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.source;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetOnlineUsernum> {
        public String country;
        public String requestid;
        public String source;
        public Boolean total;

        public Builder() {
        }

        public Builder(GetOnlineUsernum getOnlineUsernum) {
            super(getOnlineUsernum);
            if (getOnlineUsernum != null) {
                this.requestid = getOnlineUsernum.requestid;
                this.country = getOnlineUsernum.country;
                this.total = getOnlineUsernum.total;
                this.source = getOnlineUsernum.source;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder total(Boolean bool) {
            this.total = bool;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public GetOnlineUsernum build() {
            return new GetOnlineUsernum(this);
        }
    }
}
