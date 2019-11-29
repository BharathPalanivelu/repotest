package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ContactMeta extends Message {
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String name;

    public ContactMeta(String str, String str2) {
        this.key = str;
        this.name = str2;
    }

    private ContactMeta(Builder builder) {
        this(builder.key, builder.name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContactMeta)) {
            return false;
        }
        ContactMeta contactMeta = (ContactMeta) obj;
        if (!equals((Object) this.key, (Object) contactMeta.key) || !equals((Object) this.name, (Object) contactMeta.name)) {
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
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ContactMeta> {
        public String key;
        public String name;

        public Builder() {
        }

        public Builder(ContactMeta contactMeta) {
            super(contactMeta);
            if (contactMeta != null) {
                this.key = contactMeta.key;
                this.name = contactMeta.name;
            }
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public ContactMeta build() {
            checkRequiredFields();
            return new ContactMeta(this);
        }
    }
}
