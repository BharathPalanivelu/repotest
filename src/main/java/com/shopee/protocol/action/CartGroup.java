package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartGroup extends Message {
    public static final Long DEFAULT_ITEM_GROUP_ID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long item_group_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public CartGroup(Integer num, Long l) {
        this.shopid = num;
        this.item_group_id = l;
    }

    private CartGroup(Builder builder) {
        this(builder.shopid, builder.item_group_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartGroup)) {
            return false;
        }
        CartGroup cartGroup = (CartGroup) obj;
        if (!equals((Object) this.shopid, (Object) cartGroup.shopid) || !equals((Object) this.item_group_id, (Object) cartGroup.item_group_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.item_group_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartGroup> {
        public Long item_group_id;
        public Integer shopid;

        public Builder() {
        }

        public Builder(CartGroup cartGroup) {
            super(cartGroup);
            if (cartGroup != null) {
                this.shopid = cartGroup.shopid;
                this.item_group_id = cartGroup.item_group_id;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder item_group_id(Long l) {
            this.item_group_id = l;
            return this;
        }

        public CartGroup build() {
            return new CartGroup(this);
        }
    }
}
