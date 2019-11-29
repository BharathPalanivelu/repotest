package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AttributeModelInstanceData extends Message {
    public static final List<AttributeInstance> DEFAULT_ID_ATTRS = Collections.emptyList();
    public static final List<AttributeInstance> DEFAULT_VALUE_ATTRS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeInstance.class, tag = 1)
    public final List<AttributeInstance> id_attrs;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeInstance.class, tag = 2)
    public final List<AttributeInstance> value_attrs;

    public AttributeModelInstanceData(List<AttributeInstance> list, List<AttributeInstance> list2) {
        this.id_attrs = immutableCopyOf(list);
        this.value_attrs = immutableCopyOf(list2);
    }

    private AttributeModelInstanceData(Builder builder) {
        this(builder.id_attrs, builder.value_attrs);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeModelInstanceData)) {
            return false;
        }
        AttributeModelInstanceData attributeModelInstanceData = (AttributeModelInstanceData) obj;
        if (!equals((List<?>) this.id_attrs, (List<?>) attributeModelInstanceData.id_attrs) || !equals((List<?>) this.value_attrs, (List<?>) attributeModelInstanceData.value_attrs)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<AttributeInstance> list = this.id_attrs;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<AttributeInstance> list2 = this.value_attrs;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeModelInstanceData> {
        public List<AttributeInstance> id_attrs;
        public List<AttributeInstance> value_attrs;

        public Builder() {
        }

        public Builder(AttributeModelInstanceData attributeModelInstanceData) {
            super(attributeModelInstanceData);
            if (attributeModelInstanceData != null) {
                this.id_attrs = AttributeModelInstanceData.copyOf(attributeModelInstanceData.id_attrs);
                this.value_attrs = AttributeModelInstanceData.copyOf(attributeModelInstanceData.value_attrs);
            }
        }

        public Builder id_attrs(List<AttributeInstance> list) {
            this.id_attrs = checkForNulls(list);
            return this;
        }

        public Builder value_attrs(List<AttributeInstance> list) {
            this.value_attrs = checkForNulls(list);
            return this;
        }

        public AttributeModelInstanceData build() {
            return new AttributeModelInstanceData(this);
        }
    }
}
