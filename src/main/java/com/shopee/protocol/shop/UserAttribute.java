package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UserAttribute extends Message {
    public static final String DEFAULT_KEY = "";
    public static final f DEFAULT_VALUE = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f value;

    public UserAttribute(String str, f fVar) {
        this.key = str;
        this.value = fVar;
    }

    private UserAttribute(Builder builder) {
        this(builder.key, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAttribute)) {
            return false;
        }
        UserAttribute userAttribute = (UserAttribute) obj;
        if (!equals((Object) this.key, (Object) userAttribute.key) || !equals((Object) this.value, (Object) userAttribute.value)) {
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
        f fVar = this.value;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserAttribute> {
        public String key;
        public f value;

        public Builder() {
        }

        public Builder(UserAttribute userAttribute) {
            super(userAttribute);
            if (userAttribute != null) {
                this.key = userAttribute.key;
                this.value = userAttribute.value;
            }
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder value(f fVar) {
            this.value = fVar;
            return this;
        }

        public UserAttribute build() {
            return new UserAttribute(this);
        }
    }
}
