package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TierProperty extends Message {
    public static final String DEFAULT_COLOR = "";
    public static final String DEFAULT_IMAGE = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String color;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;

    public TierProperty(String str, String str2, String str3) {
        this.name = str;
        this.image = str2;
        this.color = str3;
    }

    private TierProperty(Builder builder) {
        this(builder.name, builder.image, builder.color);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TierProperty)) {
            return false;
        }
        TierProperty tierProperty = (TierProperty) obj;
        if (!equals((Object) this.name, (Object) tierProperty.name) || !equals((Object) this.image, (Object) tierProperty.image) || !equals((Object) this.color, (Object) tierProperty.color)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.color;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TierProperty> {
        public String color;
        public String image;
        public String name;

        public Builder() {
        }

        public Builder(TierProperty tierProperty) {
            super(tierProperty);
            if (tierProperty != null) {
                this.name = tierProperty.name;
                this.image = tierProperty.image;
                this.color = tierProperty.color;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder image(String str) {
            this.image = str;
            return this;
        }

        public Builder color(String str) {
            this.color = str;
            return this;
        }

        public TierProperty build() {
            return new TierProperty(this);
        }
    }
}
