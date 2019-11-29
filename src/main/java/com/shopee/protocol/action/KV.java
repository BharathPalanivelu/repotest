package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class KV extends Message {
    public static final String DEFAULT_K = "";
    public static final String DEFAULT_V = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String k;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String v;

    public KV(String str, String str2) {
        this.k = str;
        this.v = str2;
    }

    private KV(Builder builder) {
        this(builder.k, builder.v);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KV)) {
            return false;
        }
        KV kv = (KV) obj;
        if (!equals((Object) this.k, (Object) kv.k) || !equals((Object) this.v, (Object) kv.v)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.k;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.v;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<KV> {
        public String k;
        public String v;

        public Builder() {
        }

        public Builder(KV kv) {
            super(kv);
            if (kv != null) {
                this.k = kv.k;
                this.v = kv.v;
            }
        }

        public Builder k(String str) {
            this.k = str;
            return this;
        }

        public Builder v(String str) {
            this.v = str;
            return this;
        }

        public KV build() {
            return new KV(this);
        }
    }
}
