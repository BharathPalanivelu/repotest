package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetWelcomePackage extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public GetWelcomePackage(String str, String str2, Integer num) {
        this.requestid = str;
        this.country = str2;
        this.type = num;
    }

    private GetWelcomePackage(Builder builder) {
        this(builder.requestid, builder.country, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetWelcomePackage)) {
            return false;
        }
        GetWelcomePackage getWelcomePackage = (GetWelcomePackage) obj;
        if (!equals((Object) this.requestid, (Object) getWelcomePackage.requestid) || !equals((Object) this.country, (Object) getWelcomePackage.country) || !equals((Object) this.type, (Object) getWelcomePackage.type)) {
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
        Integer num = this.type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetWelcomePackage> {
        public String country;
        public String requestid;
        public Integer type;

        public Builder() {
        }

        public Builder(GetWelcomePackage getWelcomePackage) {
            super(getWelcomePackage);
            if (getWelcomePackage != null) {
                this.requestid = getWelcomePackage.requestid;
                this.country = getWelcomePackage.country;
                this.type = getWelcomePackage.type;
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

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public GetWelcomePackage build() {
            return new GetWelcomePackage(this);
        }
    }
}
