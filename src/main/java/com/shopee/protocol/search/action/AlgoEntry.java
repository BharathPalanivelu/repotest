package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AlgoEntry extends Message {
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;

    public AlgoEntry(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    private AlgoEntry(Builder builder) {
        this(builder.key, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlgoEntry)) {
            return false;
        }
        AlgoEntry algoEntry = (AlgoEntry) obj;
        if (!equals((Object) this.key, (Object) algoEntry.key) || !equals((Object) this.value, (Object) algoEntry.value)) {
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

    public static final class Builder extends Message.Builder<AlgoEntry> {
        public String key;
        public String value;

        public Builder() {
        }

        public Builder(AlgoEntry algoEntry) {
            super(algoEntry);
            if (algoEntry != null) {
                this.key = algoEntry.key;
                this.value = algoEntry.value;
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

        public AlgoEntry build() {
            return new AlgoEntry(this);
        }
    }
}
