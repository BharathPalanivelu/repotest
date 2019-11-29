package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class NamedVariant extends Message {
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(tag = 2)
    public final Variant Value;

    public NamedVariant(String str, Variant variant) {
        this.Name = str;
        this.Value = variant;
    }

    private NamedVariant(Builder builder) {
        this(builder.Name, builder.Value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NamedVariant)) {
            return false;
        }
        NamedVariant namedVariant = (NamedVariant) obj;
        if (!equals((Object) this.Name, (Object) namedVariant.Name) || !equals((Object) this.Value, (Object) namedVariant.Value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.Name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Variant variant = this.Value;
        if (variant != null) {
            i2 = variant.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NamedVariant> {
        public String Name;
        public Variant Value;

        public Builder() {
        }

        public Builder(NamedVariant namedVariant) {
            super(namedVariant);
            if (namedVariant != null) {
                this.Name = namedVariant.Name;
                this.Value = namedVariant.Value;
            }
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public Builder Value(Variant variant) {
            this.Value = variant;
            return this;
        }

        public NamedVariant build() {
            return new NamedVariant(this);
        }
    }
}
