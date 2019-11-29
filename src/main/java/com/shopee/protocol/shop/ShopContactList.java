package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopContactList extends Message {
    public static final List<ShopContact> DEFAULT_CONTACT = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopContact.class, tag = 1)
    public final List<ShopContact> contact;

    public ShopContactList(List<ShopContact> list) {
        this.contact = immutableCopyOf(list);
    }

    private ShopContactList(Builder builder) {
        this(builder.contact);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopContactList)) {
            return false;
        }
        return equals((List<?>) this.contact, (List<?>) ((ShopContactList) obj).contact);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ShopContact> list = this.contact;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ShopContactList> {
        public List<ShopContact> contact;

        public Builder() {
        }

        public Builder(ShopContactList shopContactList) {
            super(shopContactList);
            if (shopContactList != null) {
                this.contact = ShopContactList.copyOf(shopContactList.contact);
            }
        }

        public Builder contact(List<ShopContact> list) {
            this.contact = checkForNulls(list);
            return this;
        }

        public ShopContactList build() {
            return new ShopContactList(this);
        }
    }
}
