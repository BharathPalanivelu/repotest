package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeValue extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;

    public AttributeValue(Integer num, String str, Integer num2) {
        this.attr_id = num;
        this.value = str;
        this.status = num2;
    }

    private AttributeValue(Builder builder) {
        this(builder.attr_id, builder.value, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeValue)) {
            return false;
        }
        AttributeValue attributeValue = (AttributeValue) obj;
        if (!equals((Object) this.attr_id, (Object) attributeValue.attr_id) || !equals((Object) this.value, (Object) attributeValue.value) || !equals((Object) this.status, (Object) attributeValue.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.attr_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.value;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeValue> {
        public Integer attr_id;
        public Integer status;
        public String value;

        public Builder() {
        }

        public Builder(AttributeValue attributeValue) {
            super(attributeValue);
            if (attributeValue != null) {
                this.attr_id = attributeValue.attr_id;
                this.value = attributeValue.value;
                this.status = attributeValue.status;
            }
        }

        public Builder attr_id(Integer num) {
            this.attr_id = num;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public AttributeValue build() {
            return new AttributeValue(this);
        }
    }
}
