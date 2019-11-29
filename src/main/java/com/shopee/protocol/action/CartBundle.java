package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CartBundle extends Message {
    public static final List<CartBundleItem> DEFAULT_BUNDLE_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CartBundleItem.class, tag = 1)
    public final List<CartBundleItem> bundle_items;

    public CartBundle(List<CartBundleItem> list) {
        this.bundle_items = immutableCopyOf(list);
    }

    private CartBundle(Builder builder) {
        this(builder.bundle_items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartBundle)) {
            return false;
        }
        return equals((List<?>) this.bundle_items, (List<?>) ((CartBundle) obj).bundle_items);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<CartBundleItem> list = this.bundle_items;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CartBundle> {
        public List<CartBundleItem> bundle_items;

        public Builder() {
        }

        public Builder(CartBundle cartBundle) {
            super(cartBundle);
            if (cartBundle != null) {
                this.bundle_items = CartBundle.copyOf(cartBundle.bundle_items);
            }
        }

        public Builder bundle_items(List<CartBundleItem> list) {
            this.bundle_items = checkForNulls(list);
            return this;
        }

        public CartBundle build() {
            return new CartBundle(this);
        }
    }
}
