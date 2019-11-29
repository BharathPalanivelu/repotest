package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AttributeAlias extends Message {
    public static final List<AttributeAliasEntry> DEFAULT_ENTRY = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeAliasEntry.class, tag = 1)
    public final List<AttributeAliasEntry> entry;

    public AttributeAlias(List<AttributeAliasEntry> list) {
        this.entry = immutableCopyOf(list);
    }

    private AttributeAlias(Builder builder) {
        this(builder.entry);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeAlias)) {
            return false;
        }
        return equals((List<?>) this.entry, (List<?>) ((AttributeAlias) obj).entry);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<AttributeAliasEntry> list = this.entry;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<AttributeAlias> {
        public List<AttributeAliasEntry> entry;

        public Builder() {
        }

        public Builder(AttributeAlias attributeAlias) {
            super(attributeAlias);
            if (attributeAlias != null) {
                this.entry = AttributeAlias.copyOf(attributeAlias.entry);
            }
        }

        public Builder entry(List<AttributeAliasEntry> list) {
            this.entry = checkForNulls(list);
            return this;
        }

        public AttributeAlias build() {
            return new AttributeAlias(this);
        }
    }
}
