package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopContact extends Message {
    public static final String DEFAULT_ACCOUNT = "";
    public static final String DEFAULT_PLATFORM = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String account;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String platform;

    public ShopContact(String str, String str2) {
        this.platform = str;
        this.account = str2;
    }

    private ShopContact(Builder builder) {
        this(builder.platform, builder.account);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopContact)) {
            return false;
        }
        ShopContact shopContact = (ShopContact) obj;
        if (!equals((Object) this.platform, (Object) shopContact.platform) || !equals((Object) this.account, (Object) shopContact.account)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.platform;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.account;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopContact> {
        public String account;
        public String platform;

        public Builder() {
        }

        public Builder(ShopContact shopContact) {
            super(shopContact);
            if (shopContact != null) {
                this.platform = shopContact.platform;
                this.account = shopContact.account;
            }
        }

        public Builder platform(String str) {
            this.platform = str;
            return this;
        }

        public Builder account(String str) {
            this.account = str;
            return this;
        }

        public ShopContact build() {
            return new ShopContact(this);
        }
    }
}
