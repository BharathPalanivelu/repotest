package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class IntegrationLink extends Message {
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_THIRD_PARTY_IDENTITY = "";
    public static final Integer DEFAULT_THIRD_PARTY_TYPE = 0;
    public static final Long DEFAULT_USER_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String third_party_identity;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer third_party_type;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long user_id;

    public IntegrationLink(Long l, String str, Integer num, Integer num2) {
        this.user_id = l;
        this.third_party_identity = str;
        this.third_party_type = num;
        this.status = num2;
    }

    private IntegrationLink(Builder builder) {
        this(builder.user_id, builder.third_party_identity, builder.third_party_type, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntegrationLink)) {
            return false;
        }
        IntegrationLink integrationLink = (IntegrationLink) obj;
        if (!equals((Object) this.user_id, (Object) integrationLink.user_id) || !equals((Object) this.third_party_identity, (Object) integrationLink.third_party_identity) || !equals((Object) this.third_party_type, (Object) integrationLink.third_party_type) || !equals((Object) this.status, (Object) integrationLink.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.user_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.third_party_identity;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.third_party_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<IntegrationLink> {
        public Integer status;
        public String third_party_identity;
        public Integer third_party_type;
        public Long user_id;

        public Builder() {
        }

        public Builder(IntegrationLink integrationLink) {
            super(integrationLink);
            if (integrationLink != null) {
                this.user_id = integrationLink.user_id;
                this.third_party_identity = integrationLink.third_party_identity;
                this.third_party_type = integrationLink.third_party_type;
                this.status = integrationLink.status;
            }
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public IntegrationLink build() {
            return new IntegrationLink(this);
        }
    }
}
