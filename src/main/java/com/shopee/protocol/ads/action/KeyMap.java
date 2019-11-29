package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class KeyMap extends Message {
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final FieldSumMap field_map;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String key;

    public KeyMap(String str, FieldSumMap fieldSumMap) {
        this.key = str;
        this.field_map = fieldSumMap;
    }

    private KeyMap(Builder builder) {
        this(builder.key, builder.field_map);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyMap)) {
            return false;
        }
        KeyMap keyMap = (KeyMap) obj;
        if (!equals((Object) this.key, (Object) keyMap.key) || !equals((Object) this.field_map, (Object) keyMap.field_map)) {
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
        FieldSumMap fieldSumMap = this.field_map;
        if (fieldSumMap != null) {
            i2 = fieldSumMap.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<KeyMap> {
        public FieldSumMap field_map;
        public String key;

        public Builder() {
        }

        public Builder(KeyMap keyMap) {
            super(keyMap);
            if (keyMap != null) {
                this.key = keyMap.key;
                this.field_map = keyMap.field_map;
            }
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder field_map(FieldSumMap fieldSumMap) {
            this.field_map = fieldSumMap;
            return this;
        }

        public KeyMap build() {
            return new KeyMap(this);
        }
    }
}
