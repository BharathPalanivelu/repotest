package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AttributeModelData extends Message {
    public static final List<Integer> DEFAULT_ID_ATTRIBUTES = Collections.emptyList();
    public static final List<Integer> DEFAULT_VALUE_ATTRIBUTES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> id_attributes;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> value_attributes;

    public AttributeModelData(List<Integer> list, List<Integer> list2) {
        this.id_attributes = immutableCopyOf(list);
        this.value_attributes = immutableCopyOf(list2);
    }

    private AttributeModelData(Builder builder) {
        this(builder.id_attributes, builder.value_attributes);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeModelData)) {
            return false;
        }
        AttributeModelData attributeModelData = (AttributeModelData) obj;
        if (!equals((List<?>) this.id_attributes, (List<?>) attributeModelData.id_attributes) || !equals((List<?>) this.value_attributes, (List<?>) attributeModelData.value_attributes)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Integer> list = this.id_attributes;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Integer> list2 = this.value_attributes;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeModelData> {
        public List<Integer> id_attributes;
        public List<Integer> value_attributes;

        public Builder() {
        }

        public Builder(AttributeModelData attributeModelData) {
            super(attributeModelData);
            if (attributeModelData != null) {
                this.id_attributes = AttributeModelData.copyOf(attributeModelData.id_attributes);
                this.value_attributes = AttributeModelData.copyOf(attributeModelData.value_attributes);
            }
        }

        public Builder id_attributes(List<Integer> list) {
            this.id_attributes = checkForNulls(list);
            return this;
        }

        public Builder value_attributes(List<Integer> list) {
            this.value_attributes = checkForNulls(list);
            return this;
        }

        public AttributeModelData build() {
            return new AttributeModelData(this);
        }
    }
}
