package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetGroupBuyCampaign extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetGroupBuyCampaign(String str, String str2) {
        this.requestid = str;
        this.country = str2;
    }

    private GetGroupBuyCampaign(Builder builder) {
        this(builder.requestid, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetGroupBuyCampaign)) {
            return false;
        }
        GetGroupBuyCampaign getGroupBuyCampaign = (GetGroupBuyCampaign) obj;
        if (!equals((Object) this.requestid, (Object) getGroupBuyCampaign.requestid) || !equals((Object) this.country, (Object) getGroupBuyCampaign.country)) {
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

    public static final class Builder extends Message.Builder<GetGroupBuyCampaign> {
        public String country;
        public String requestid;

        public Builder() {
        }

        public Builder(GetGroupBuyCampaign getGroupBuyCampaign) {
            super(getGroupBuyCampaign);
            if (getGroupBuyCampaign != null) {
                this.requestid = getGroupBuyCampaign.requestid;
                this.country = getGroupBuyCampaign.country;
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

        public GetGroupBuyCampaign build() {
            return new GetGroupBuyCampaign(this);
        }
    }
}
