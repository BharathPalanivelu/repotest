package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartRemoveItemInfo extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_GROUP_ID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long item_group_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public CartRemoveItemInfo(Integer num, Long l, Long l2, Long l3) {
        this.shopid = num;
        this.itemid = l;
        this.modelid = l2;
        this.item_group_id = l3;
    }

    private CartRemoveItemInfo(Builder builder) {
        this(builder.shopid, builder.itemid, builder.modelid, builder.item_group_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartRemoveItemInfo)) {
            return false;
        }
        CartRemoveItemInfo cartRemoveItemInfo = (CartRemoveItemInfo) obj;
        if (!equals((Object) this.shopid, (Object) cartRemoveItemInfo.shopid) || !equals((Object) this.itemid, (Object) cartRemoveItemInfo.itemid) || !equals((Object) this.modelid, (Object) cartRemoveItemInfo.modelid) || !equals((Object) this.item_group_id, (Object) cartRemoveItemInfo.item_group_id)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.item_group_id;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartRemoveItemInfo> {
        public Long item_group_id;
        public Long itemid;
        public Long modelid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(CartRemoveItemInfo cartRemoveItemInfo) {
            super(cartRemoveItemInfo);
            if (cartRemoveItemInfo != null) {
                this.shopid = cartRemoveItemInfo.shopid;
                this.itemid = cartRemoveItemInfo.itemid;
                this.modelid = cartRemoveItemInfo.modelid;
                this.item_group_id = cartRemoveItemInfo.item_group_id;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder item_group_id(Long l) {
            this.item_group_id = l;
            return this;
        }

        public CartRemoveItemInfo build() {
            return new CartRemoveItemInfo(this);
        }
    }
}
