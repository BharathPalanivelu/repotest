package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemId extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ItemId(Long l, Integer num) {
        this.itemid = l;
        this.shopid = num;
    }

    private ItemId(Builder builder) {
        this(builder.itemid, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemId)) {
            return false;
        }
        ItemId itemId = (ItemId) obj;
        if (!equals((Object) this.itemid, (Object) itemId.itemid) || !equals((Object) this.shopid, (Object) itemId.shopid)) {
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
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemId> {
        public Long itemid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ItemId itemId) {
            super(itemId);
            if (itemId != null) {
                this.itemid = itemId.itemid;
                this.shopid = itemId.shopid;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public ItemId build() {
            return new ItemId(this);
        }
    }
}
