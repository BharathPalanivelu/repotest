package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartBundleItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;

    public CartBundleItem(Long l, Long l2) {
        this.itemid = l;
        this.modelid = l2;
    }

    private CartBundleItem(Builder builder) {
        this(builder.itemid, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartBundleItem)) {
            return false;
        }
        CartBundleItem cartBundleItem = (CartBundleItem) obj;
        if (!equals((Object) this.itemid, (Object) cartBundleItem.itemid) || !equals((Object) this.modelid, (Object) cartBundleItem.modelid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.modelid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartBundleItem> {
        public Long itemid;
        public Long modelid;

        public Builder() {
        }

        public Builder(CartBundleItem cartBundleItem) {
            super(cartBundleItem);
            if (cartBundleItem != null) {
                this.itemid = cartBundleItem.itemid;
                this.modelid = cartBundleItem.modelid;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public CartBundleItem build() {
            return new CartBundleItem(this);
        }
    }
}
