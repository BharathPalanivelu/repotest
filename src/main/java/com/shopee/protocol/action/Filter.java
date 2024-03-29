package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Filter extends Message {
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;

    public Filter(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    private Filter(Builder builder) {
        this(builder.key, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        if (!equals((Object) this.key, (Object) filter.key) || !equals((Object) this.value, (Object) filter.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.key;
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

    public static final class Builder extends Message.Builder<Filter> {
        public String key;
        public String value;

        public Builder() {
        }

        public Builder(Filter filter) {
            super(filter);
            if (filter != null) {
                this.key = filter.key;
                this.value = filter.value;
            }
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Filter build() {
            return new Filter(this);
        }
    }
}
