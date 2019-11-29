package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AttributeSnapshot extends Message {
    public static final Integer DEFAULT_MODELID = 0;
    public static final List<AttributeValue> DEFAULT_VALUES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer modelid;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeValue.class, tag = 1)
    public final List<AttributeValue> values;

    public AttributeSnapshot(List<AttributeValue> list, Integer num) {
        this.values = immutableCopyOf(list);
        this.modelid = num;
    }

    private AttributeSnapshot(Builder builder) {
        this(builder.values, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeSnapshot)) {
            return false;
        }
        AttributeSnapshot attributeSnapshot = (AttributeSnapshot) obj;
        if (!equals((List<?>) this.values, (List<?>) attributeSnapshot.values) || !equals((Object) this.modelid, (Object) attributeSnapshot.modelid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<AttributeValue> list = this.values;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.modelid;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<AttributeSnapshot> {
        public Integer modelid;
        public List<AttributeValue> values;

        public Builder() {
        }

        public Builder(AttributeSnapshot attributeSnapshot) {
            super(attributeSnapshot);
            if (attributeSnapshot != null) {
                this.values = AttributeSnapshot.copyOf(attributeSnapshot.values);
                this.modelid = attributeSnapshot.modelid;
            }
        }

        public Builder values(List<AttributeValue> list) {
            this.values = checkForNulls(list);
            return this;
        }

        public Builder modelid(Integer num) {
            this.modelid = num;
            return this;
        }

        public AttributeSnapshot build() {
            return new AttributeSnapshot(this);
        }
    }
}
