package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetSlashPriceRule extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetSlashPriceRule(String str, String str2) {
        this.requestid = str;
        this.country = str2;
    }

    private GetSlashPriceRule(Builder builder) {
        this(builder.requestid, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSlashPriceRule)) {
            return false;
        }
        GetSlashPriceRule getSlashPriceRule = (GetSlashPriceRule) obj;
        if (!equals((Object) this.requestid, (Object) getSlashPriceRule.requestid) || !equals((Object) this.country, (Object) getSlashPriceRule.country)) {
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
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetSlashPriceRule> {
        public String country;
        public String requestid;

        public Builder() {
        }

        public Builder(GetSlashPriceRule getSlashPriceRule) {
            super(getSlashPriceRule);
            if (getSlashPriceRule != null) {
                this.requestid = getSlashPriceRule.requestid;
                this.country = getSlashPriceRule.country;
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

        public GetSlashPriceRule build() {
            return new GetSlashPriceRule(this);
        }
    }
}
