package com.shopee.protocol.action;

import com.shopee.protocol.shop.AttributeInstance;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckMatchAttribute extends Message {
    public static final List<AttributeInstance> DEFAULT_NARROW_DOWN = Collections.emptyList();
    public static final List<AttributeInstance> DEFAULT_SUGGEST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeInstance.class, tag = 2)
    public final List<AttributeInstance> narrow_down;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeInstance.class, tag = 1)
    public final List<AttributeInstance> suggest;

    public CheckMatchAttribute(List<AttributeInstance> list, List<AttributeInstance> list2) {
        this.suggest = immutableCopyOf(list);
        this.narrow_down = immutableCopyOf(list2);
    }

    private CheckMatchAttribute(Builder builder) {
        this(builder.suggest, builder.narrow_down);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckMatchAttribute)) {
            return false;
        }
        CheckMatchAttribute checkMatchAttribute = (CheckMatchAttribute) obj;
        if (!equals((List<?>) this.suggest, (List<?>) checkMatchAttribute.suggest) || !equals((List<?>) this.narrow_down, (List<?>) checkMatchAttribute.narrow_down)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<AttributeInstance> list = this.suggest;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<AttributeInstance> list2 = this.narrow_down;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckMatchAttribute> {
        public List<AttributeInstance> narrow_down;
        public List<AttributeInstance> suggest;

        public Builder() {
        }

        public Builder(CheckMatchAttribute checkMatchAttribute) {
            super(checkMatchAttribute);
            if (checkMatchAttribute != null) {
                this.suggest = CheckMatchAttribute.copyOf(checkMatchAttribute.suggest);
                this.narrow_down = CheckMatchAttribute.copyOf(checkMatchAttribute.narrow_down);
            }
        }

        public Builder suggest(List<AttributeInstance> list) {
            this.suggest = checkForNulls(list);
            return this;
        }

        public Builder narrow_down(List<AttributeInstance> list) {
            this.narrow_down = checkForNulls(list);
            return this;
        }

        public CheckMatchAttribute build() {
            return new CheckMatchAttribute(this);
        }
    }
}
