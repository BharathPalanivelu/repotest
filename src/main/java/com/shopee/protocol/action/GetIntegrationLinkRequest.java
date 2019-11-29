package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetIntegrationLinkRequest extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_THIRD_PARTY_IDENTITY = "";
    public static final Integer DEFAULT_THIRD_PARTY_TYPE = 0;
    public static final Long DEFAULT_USER_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String third_party_identity;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer third_party_type;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long user_id;

    public GetIntegrationLinkRequest(String str, Long l, String str2, Integer num) {
        this.requestid = str;
        this.user_id = l;
        this.third_party_identity = str2;
        this.third_party_type = num;
    }

    private GetIntegrationLinkRequest(Builder builder) {
        this(builder.requestid, builder.user_id, builder.third_party_identity, builder.third_party_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetIntegrationLinkRequest)) {
            return false;
        }
        GetIntegrationLinkRequest getIntegrationLinkRequest = (GetIntegrationLinkRequest) obj;
        if (!equals((Object) this.requestid, (Object) getIntegrationLinkRequest.requestid) || !equals((Object) this.user_id, (Object) getIntegrationLinkRequest.user_id) || !equals((Object) this.third_party_identity, (Object) getIntegrationLinkRequest.third_party_identity) || !equals((Object) this.third_party_type, (Object) getIntegrationLinkRequest.third_party_type)) {
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
        Long l = this.user_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.third_party_identity;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.third_party_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetIntegrationLinkRequest> {
        public String requestid;
        public String third_party_identity;
        public Integer third_party_type;
        public Long user_id;

        public Builder() {
        }

        public Builder(GetIntegrationLinkRequest getIntegrationLinkRequest) {
            super(getIntegrationLinkRequest);
            if (getIntegrationLinkRequest != null) {
                this.requestid = getIntegrationLinkRequest.requestid;
                this.user_id = getIntegrationLinkRequest.user_id;
                this.third_party_identity = getIntegrationLinkRequest.third_party_identity;
                this.third_party_type = getIntegrationLinkRequest.third_party_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder third_party_identity(String str) {
            this.third_party_identity = str;
            return this;
        }

        public Builder third_party_type(Integer num) {
            this.third_party_type = num;
            return this;
        }

        public GetIntegrationLinkRequest build() {
            return new GetIntegrationLinkRequest(this);
        }
    }
}
