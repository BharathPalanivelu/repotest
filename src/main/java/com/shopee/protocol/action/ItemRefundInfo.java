package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemRefundInfo extends Message {
    public static final Integer DEFAULT_AMOUNT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_GROUP_ID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_REFUND_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer amount;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long item_group_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long refund_price;

    public ItemRefundInfo(Long l, Integer num, Long l2, Long l3, Long l4) {
        this.itemid = l;
        this.amount = num;
        this.refund_price = l2;
        this.modelid = l3;
        this.item_group_id = l4;
    }

    private ItemRefundInfo(Builder builder) {
        this(builder.itemid, builder.amount, builder.refund_price, builder.modelid, builder.item_group_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemRefundInfo)) {
            return false;
        }
        ItemRefundInfo itemRefundInfo = (ItemRefundInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemRefundInfo.itemid) || !equals((Object) this.amount, (Object) itemRefundInfo.amount) || !equals((Object) this.refund_price, (Object) itemRefundInfo.refund_price) || !equals((Object) this.modelid, (Object) itemRefundInfo.modelid) || !equals((Object) this.item_group_id, (Object) itemRefundInfo.item_group_id)) {
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
        Integer num = this.amount;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.refund_price;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.item_group_id;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemRefundInfo> {
        public Integer amount;
        public Long item_group_id;
        public Long itemid;
        public Long modelid;
        public Long refund_price;

        public Builder() {
        }

        public Builder(ItemRefundInfo itemRefundInfo) {
            super(itemRefundInfo);
            if (itemRefundInfo != null) {
                this.itemid = itemRefundInfo.itemid;
                this.amount = itemRefundInfo.amount;
                this.refund_price = itemRefundInfo.refund_price;
                this.modelid = itemRefundInfo.modelid;
                this.item_group_id = itemRefundInfo.item_group_id;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder amount(Integer num) {
            this.amount = num;
            return this;
        }

        public Builder refund_price(Long l) {
            this.refund_price = l;
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

        public ItemRefundInfo build() {
            return new ItemRefundInfo(this);
        }
    }
}
