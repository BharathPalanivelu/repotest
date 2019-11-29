package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.shopee.protocol.shop.AttributeModelInstance;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAttributeModelInstance extends Message {
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final RequestHeader header;
    @ProtoField(tag = 3)
    public final AttributeModelInstance instance;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetAttributeModelInstance(String str, RequestHeader requestHeader, AttributeModelInstance attributeModelInstance, String str2) {
        this.requestid = str;
        this.header = requestHeader;
        this.instance = attributeModelInstance;
        this.operator = str2;
    }

    private SetAttributeModelInstance(Builder builder) {
        this(builder.requestid, builder.header, builder.instance, builder.operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAttributeModelInstance)) {
            return false;
        }
        SetAttributeModelInstance setAttributeModelInstance = (SetAttributeModelInstance) obj;
        if (!equals((Object) this.requestid, (Object) setAttributeModelInstance.requestid) || !equals((Object) this.header, (Object) setAttributeModelInstance.header) || !equals((Object) this.instance, (Object) setAttributeModelInstance.instance) || !equals((Object) this.operator, (Object) setAttributeModelInstance.operator)) {
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
        RequestHeader requestHeader = this.header;
        int hashCode2 = (hashCode + (requestHeader != null ? requestHeader.hashCode() : 0)) * 37;
        AttributeModelInstance attributeModelInstance = this.instance;
        int hashCode3 = (hashCode2 + (attributeModelInstance != null ? attributeModelInstance.hashCode() : 0)) * 37;
        String str2 = this.operator;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAttributeModelInstance> {
        public RequestHeader header;
        public AttributeModelInstance instance;
        public String operator;
        public String requestid;

        public Builder() {
        }

        public Builder(SetAttributeModelInstance setAttributeModelInstance) {
            super(setAttributeModelInstance);
            if (setAttributeModelInstance != null) {
                this.requestid = setAttributeModelInstance.requestid;
                this.header = setAttributeModelInstance.header;
                this.instance = setAttributeModelInstance.instance;
                this.operator = setAttributeModelInstance.operator;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder instance(AttributeModelInstance attributeModelInstance) {
            this.instance = attributeModelInstance;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public SetAttributeModelInstance build() {
            return new SetAttributeModelInstance(this);
        }
    }
}
