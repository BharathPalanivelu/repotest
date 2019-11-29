package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetCampaignRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final Campaign campaign;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetCampaignRequest(RequestHeader requestHeader, Campaign campaign2) {
        this.header = requestHeader;
        this.campaign = campaign2;
    }

    private SetCampaignRequest(Builder builder) {
        this(builder.header, builder.campaign);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCampaignRequest)) {
            return false;
        }
        SetCampaignRequest setCampaignRequest = (SetCampaignRequest) obj;
        if (!equals((Object) this.header, (Object) setCampaignRequest.header) || !equals((Object) this.campaign, (Object) setCampaignRequest.campaign)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        Campaign campaign2 = this.campaign;
        if (campaign2 != null) {
            i2 = campaign2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCampaignRequest> {
        public Campaign campaign;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetCampaignRequest setCampaignRequest) {
            super(setCampaignRequest);
            if (setCampaignRequest != null) {
                this.header = setCampaignRequest.header;
                this.campaign = setCampaignRequest.campaign;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder campaign(Campaign campaign2) {
            this.campaign = campaign2;
            return this;
        }

        public SetCampaignRequest build() {
            return new SetCampaignRequest(this);
        }
    }
}
