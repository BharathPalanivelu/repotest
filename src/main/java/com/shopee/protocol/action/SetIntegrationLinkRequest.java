package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetIntegrationLinkRequest extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final IntegrationLink link;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetIntegrationLinkRequest(String str, IntegrationLink integrationLink) {
        this.requestid = str;
        this.link = integrationLink;
    }

    private SetIntegrationLinkRequest(Builder builder) {
        this(builder.requestid, builder.link);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetIntegrationLinkRequest)) {
            return false;
        }
        SetIntegrationLinkRequest setIntegrationLinkRequest = (SetIntegrationLinkRequest) obj;
        if (!equals((Object) this.requestid, (Object) setIntegrationLinkRequest.requestid) || !equals((Object) this.link, (Object) setIntegrationLinkRequest.link)) {
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
        IntegrationLink integrationLink = this.link;
        if (integrationLink != null) {
            i2 = integrationLink.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetIntegrationLinkRequest> {
        public IntegrationLink link;
        public String requestid;

        public Builder() {
        }

        public Builder(SetIntegrationLinkRequest setIntegrationLinkRequest) {
            super(setIntegrationLinkRequest);
            if (setIntegrationLinkRequest != null) {
                this.requestid = setIntegrationLinkRequest.requestid;
                this.link = setIntegrationLinkRequest.link;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder link(IntegrationLink integrationLink) {
            this.link = integrationLink;
            return this;
        }

        public SetIntegrationLinkRequest build() {
            return new SetIntegrationLinkRequest(this);
        }
    }
}
