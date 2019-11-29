package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetIntegrationLinkResponse extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 2)
    public final IntegrationLink link;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetIntegrationLinkResponse(String str, IntegrationLink integrationLink, Integer num, String str2) {
        this.requestid = str;
        this.link = integrationLink;
        this.errcode = num;
        this.debug_msg = str2;
    }

    private GetIntegrationLinkResponse(Builder builder) {
        this(builder.requestid, builder.link, builder.errcode, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetIntegrationLinkResponse)) {
            return false;
        }
        GetIntegrationLinkResponse getIntegrationLinkResponse = (GetIntegrationLinkResponse) obj;
        if (!equals((Object) this.requestid, (Object) getIntegrationLinkResponse.requestid) || !equals((Object) this.link, (Object) getIntegrationLinkResponse.link) || !equals((Object) this.errcode, (Object) getIntegrationLinkResponse.errcode) || !equals((Object) this.debug_msg, (Object) getIntegrationLinkResponse.debug_msg)) {
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
        int hashCode2 = (hashCode + (integrationLink != null ? integrationLink.hashCode() : 0)) * 37;
        Integer num = this.errcode;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetIntegrationLinkResponse> {
        public String debug_msg;
        public Integer errcode;
        public IntegrationLink link;
        public String requestid;

        public Builder() {
        }

        public Builder(GetIntegrationLinkResponse getIntegrationLinkResponse) {
            super(getIntegrationLinkResponse);
            if (getIntegrationLinkResponse != null) {
                this.requestid = getIntegrationLinkResponse.requestid;
                this.link = getIntegrationLinkResponse.link;
                this.errcode = getIntegrationLinkResponse.errcode;
                this.debug_msg = getIntegrationLinkResponse.debug_msg;
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

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public GetIntegrationLinkResponse build() {
            return new GetIntegrationLinkResponse(this);
        }
    }
}
