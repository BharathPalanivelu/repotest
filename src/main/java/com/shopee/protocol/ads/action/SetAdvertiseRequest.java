package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAdvertiseRequest extends Message {
    public static final Integer DEFAULT_ADS_AUDIT_EVENT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ads_audit_event;
    @ProtoField(tag = 2)
    public final Advertisement advertisement;
    @ProtoField(tag = 3)
    public final Campaign campaign;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetAdvertiseRequest(RequestHeader requestHeader, Advertisement advertisement2, Campaign campaign2, Integer num) {
        this.header = requestHeader;
        this.advertisement = advertisement2;
        this.campaign = campaign2;
        this.ads_audit_event = num;
    }

    private SetAdvertiseRequest(Builder builder) {
        this(builder.header, builder.advertisement, builder.campaign, builder.ads_audit_event);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAdvertiseRequest)) {
            return false;
        }
        SetAdvertiseRequest setAdvertiseRequest = (SetAdvertiseRequest) obj;
        if (!equals((Object) this.header, (Object) setAdvertiseRequest.header) || !equals((Object) this.advertisement, (Object) setAdvertiseRequest.advertisement) || !equals((Object) this.campaign, (Object) setAdvertiseRequest.campaign) || !equals((Object) this.ads_audit_event, (Object) setAdvertiseRequest.ads_audit_event)) {
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
        Advertisement advertisement2 = this.advertisement;
        int hashCode2 = (hashCode + (advertisement2 != null ? advertisement2.hashCode() : 0)) * 37;
        Campaign campaign2 = this.campaign;
        int hashCode3 = (hashCode2 + (campaign2 != null ? campaign2.hashCode() : 0)) * 37;
        Integer num = this.ads_audit_event;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAdvertiseRequest> {
        public Integer ads_audit_event;
        public Advertisement advertisement;
        public Campaign campaign;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetAdvertiseRequest setAdvertiseRequest) {
            super(setAdvertiseRequest);
            if (setAdvertiseRequest != null) {
                this.header = setAdvertiseRequest.header;
                this.advertisement = setAdvertiseRequest.advertisement;
                this.campaign = setAdvertiseRequest.campaign;
                this.ads_audit_event = setAdvertiseRequest.ads_audit_event;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder advertisement(Advertisement advertisement2) {
            this.advertisement = advertisement2;
            return this;
        }

        public Builder campaign(Campaign campaign2) {
            this.campaign = campaign2;
            return this;
        }

        public Builder ads_audit_event(Integer num) {
            this.ads_audit_event = num;
            return this;
        }

        public SetAdvertiseRequest build() {
            return new SetAdvertiseRequest(this);
        }
    }
}
