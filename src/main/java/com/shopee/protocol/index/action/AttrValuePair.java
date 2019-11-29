package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttrValuePair extends Message {
    public static final Long DEFAULT_ATTR_ID = 0L;
    public static final Long DEFAULT_VALUE_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long attr_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long value_id;

    public AttrValuePair(Long l, Long l2) {
        this.attr_id = l;
        this.value_id = l2;
    }

    private AttrValuePair(Builder builder) {
        this(builder.attr_id, builder.value_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttrValuePair)) {
            return false;
        }
        AttrValuePair attrValuePair = (AttrValuePair) obj;
        if (!equals((Object) this.attr_id, (Object) attrValuePair.attr_id) || !equals((Object) this.value_id, (Object) attrValuePair.value_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.attr_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.value_id;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttrValuePair> {
        public Long attr_id;
        public Long value_id;

        public Builder() {
        }

        public Builder(AttrValuePair attrValuePair) {
            super(attrValuePair);
            if (attrValuePair != null) {
                this.attr_id = attrValuePair.attr_id;
                this.value_id = attrValuePair.value_id;
            }
        }

        public Builder attr_id(Long l) {
            this.attr_id = l;
            return this;
        }

        public Builder value_id(Long l) {
            this.value_id = l;
            return this;
        }

        public AttrValuePair build() {
            return new AttrValuePair(this);
        }
    }
}
