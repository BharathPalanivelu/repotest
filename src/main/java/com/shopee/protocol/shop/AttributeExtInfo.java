package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeExtInfo extends Message {
    public static final Integer DEFAULT_INPUT_TYPE = 0;
    public static final Integer DEFAULT_INPUT_VALIDATOR = 0;
    public static final Long DEFAULT_IS_MANDATORY = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer input_type;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer input_validator;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long is_mandatory;

    public AttributeExtInfo(Long l, Integer num, Integer num2) {
        this.is_mandatory = l;
        this.input_type = num;
        this.input_validator = num2;
    }

    private AttributeExtInfo(Builder builder) {
        this(builder.is_mandatory, builder.input_type, builder.input_validator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeExtInfo)) {
            return false;
        }
        AttributeExtInfo attributeExtInfo = (AttributeExtInfo) obj;
        if (!equals((Object) this.is_mandatory, (Object) attributeExtInfo.is_mandatory) || !equals((Object) this.input_type, (Object) attributeExtInfo.input_type) || !equals((Object) this.input_validator, (Object) attributeExtInfo.input_validator)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.is_mandatory;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.input_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.input_validator;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeExtInfo> {
        public Integer input_type;
        public Integer input_validator;
        public Long is_mandatory;

        public Builder() {
        }

        public Builder(AttributeExtInfo attributeExtInfo) {
            super(attributeExtInfo);
            if (attributeExtInfo != null) {
                this.is_mandatory = attributeExtInfo.is_mandatory;
                this.input_type = attributeExtInfo.input_type;
                this.input_validator = attributeExtInfo.input_validator;
            }
        }

        public Builder is_mandatory(Long l) {
            this.is_mandatory = l;
            return this;
        }

        public Builder input_type(Integer num) {
            this.input_type = num;
            return this;
        }

        public Builder input_validator(Integer num) {
            this.input_validator = num;
            return this;
        }

        public AttributeExtInfo build() {
            return new AttributeExtInfo(this);
        }
    }
}
