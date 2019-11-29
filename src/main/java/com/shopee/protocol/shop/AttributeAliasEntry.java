package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeAliasEntry extends Message {
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String language;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;

    public AttributeAliasEntry(String str, String str2) {
        this.language = str;
        this.value = str2;
    }

    private AttributeAliasEntry(Builder builder) {
        this(builder.language, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeAliasEntry)) {
            return false;
        }
        AttributeAliasEntry attributeAliasEntry = (AttributeAliasEntry) obj;
        if (!equals((Object) this.language, (Object) attributeAliasEntry.language) || !equals((Object) this.value, (Object) attributeAliasEntry.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.language;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeAliasEntry> {
        public String language;
        public String value;

        public Builder() {
        }

        public Builder(AttributeAliasEntry attributeAliasEntry) {
            super(attributeAliasEntry);
            if (attributeAliasEntry != null) {
                this.language = attributeAliasEntry.language;
                this.value = attributeAliasEntry.value;
            }
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public AttributeAliasEntry build() {
            return new AttributeAliasEntry(this);
        }
    }
}
