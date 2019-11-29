package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.shopee.protocol.shop.AttributeModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAttributeModel extends Message {
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final RequestHeader header;
    @ProtoField(tag = 3)
    public final AttributeModel model;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetAttributeModel(String str, RequestHeader requestHeader, AttributeModel attributeModel, String str2) {
        this.requestid = str;
        this.header = requestHeader;
        this.model = attributeModel;
        this.operator = str2;
    }

    private SetAttributeModel(Builder builder) {
        this(builder.requestid, builder.header, builder.model, builder.operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAttributeModel)) {
            return false;
        }
        SetAttributeModel setAttributeModel = (SetAttributeModel) obj;
        if (!equals((Object) this.requestid, (Object) setAttributeModel.requestid) || !equals((Object) this.header, (Object) setAttributeModel.header) || !equals((Object) this.model, (Object) setAttributeModel.model) || !equals((Object) this.operator, (Object) setAttributeModel.operator)) {
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
        AttributeModel attributeModel = this.model;
        int hashCode3 = (hashCode2 + (attributeModel != null ? attributeModel.hashCode() : 0)) * 37;
        String str2 = this.operator;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAttributeModel> {
        public RequestHeader header;
        public AttributeModel model;
        public String operator;
        public String requestid;

        public Builder() {
        }

        public Builder(SetAttributeModel setAttributeModel) {
            super(setAttributeModel);
            if (setAttributeModel != null) {
                this.requestid = setAttributeModel.requestid;
                this.header = setAttributeModel.header;
                this.model = setAttributeModel.model;
                this.operator = setAttributeModel.operator;
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

        public Builder model(AttributeModel attributeModel) {
            this.model = attributeModel;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public SetAttributeModel build() {
            return new SetAttributeModel(this);
        }
    }
}
