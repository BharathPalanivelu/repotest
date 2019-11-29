package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderItemIds extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_GROUP_ID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long item_group_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;

    public OrderItemIds(Long l, Long l2, Long l3) {
        this.itemid = l;
        this.modelid = l2;
        this.item_group_id = l3;
    }

    private OrderItemIds(Builder builder) {
        this(builder.itemid, builder.modelid, builder.item_group_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderItemIds)) {
            return false;
        }
        OrderItemIds orderItemIds = (OrderItemIds) obj;
        if (!equals((Object) this.itemid, (Object) orderItemIds.itemid) || !equals((Object) this.modelid, (Object) orderItemIds.modelid) || !equals((Object) this.item_group_id, (Object) orderItemIds.item_group_id)) {
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
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.item_group_id;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderItemIds> {
        public Long item_group_id;
        public Long itemid;
        public Long modelid;

        public Builder() {
        }

        public Builder(OrderItemIds orderItemIds) {
            super(orderItemIds);
            if (orderItemIds != null) {
                this.itemid = orderItemIds.itemid;
                this.modelid = orderItemIds.modelid;
                this.item_group_id = orderItemIds.item_group_id;
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

        public Builder item_group_id(Long l) {
            this.item_group_id = l;
            return this;
        }

        public OrderItemIds build() {
            return new OrderItemIds(this);
        }
    }
}
