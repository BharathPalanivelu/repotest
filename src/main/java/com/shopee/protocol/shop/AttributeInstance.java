package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AttributeInstance extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final List<String> DEFAULT_VALUES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> values;

    public AttributeInstance(Integer num, List<String> list) {
        this.attr_id = num;
        this.values = immutableCopyOf(list);
    }

    private AttributeInstance(Builder builder) {
        this(builder.attr_id, builder.values);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeInstance)) {
            return false;
        }
        AttributeInstance attributeInstance = (AttributeInstance) obj;
        if (!equals((Object) this.attr_id, (Object) attributeInstance.attr_id) || !equals((List<?>) this.values, (List<?>) attributeInstance.values)) {
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
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<String> list = this.values;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<AttributeInstance> {
        public Integer attr_id;
        public List<String> values;

        public Builder() {
        }

        public Builder(AttributeInstance attributeInstance) {
            super(attributeInstance);
            if (attributeInstance != null) {
                this.attr_id = attributeInstance.attr_id;
                this.values = AttributeInstance.copyOf(attributeInstance.values);
            }
        }

        public Builder attr_id(Integer num) {
            this.attr_id = num;
            return this;
        }

        public Builder values(List<String> list) {
            this.values = checkForNulls(list);
            return this;
        }

        public AttributeInstance build() {
            return new AttributeInstance(this);
        }
    }
}
