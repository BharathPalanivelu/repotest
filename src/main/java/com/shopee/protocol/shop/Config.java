package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Config extends Message {
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;

    public Config(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    private Config(Builder builder) {
        this(builder.name, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        if (!equals((Object) this.name, (Object) config.name) || !equals((Object) this.value, (Object) config.value)) {
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
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Config> {
        public String name;
        public String value;

        public Builder() {
        }

        public Builder(Config config) {
            super(config);
            if (config != null) {
                this.name = config.name;
                this.value = config.value;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
