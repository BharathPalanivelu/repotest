package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Gid extends Message {
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String type;

    public Gid(Long l, String str) {
        this.id = l;
        this.type = str;
    }

    private Gid(Builder builder) {
        this(builder.id, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Gid)) {
            return false;
        }
        Gid gid = (Gid) obj;
        if (!equals((Object) this.id, (Object) gid.id) || !equals((Object) this.type, (Object) gid.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.type;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Gid> {
        public Long id;
        public String type;

        public Builder() {
        }

        public Builder(Gid gid) {
            super(gid);
            if (gid != null) {
                this.id = gid.id;
                this.type = gid.type;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public Gid build() {
            return new Gid(this);
        }
    }
}
