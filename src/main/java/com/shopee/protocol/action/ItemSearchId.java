package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemSearchId extends Message {
    public static final Double DEFAULT_DISTANCE = Double.valueOf(0.0d);
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double distance;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ItemSearchId(Long l, Integer num, Double d2) {
        this.itemid = l;
        this.shopid = num;
        this.distance = d2;
    }

    private ItemSearchId(Builder builder) {
        this(builder.itemid, builder.shopid, builder.distance);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemSearchId)) {
            return false;
        }
        ItemSearchId itemSearchId = (ItemSearchId) obj;
        if (!equals((Object) this.itemid, (Object) itemSearchId.itemid) || !equals((Object) this.shopid, (Object) itemSearchId.shopid) || !equals((Object) this.distance, (Object) itemSearchId.distance)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Double d2 = this.distance;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemSearchId> {
        public Double distance;
        public Long itemid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ItemSearchId itemSearchId) {
            super(itemSearchId);
            if (itemSearchId != null) {
                this.itemid = itemSearchId.itemid;
                this.shopid = itemSearchId.shopid;
                this.distance = itemSearchId.distance;
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

        public Builder distance(Double d2) {
            this.distance = d2;
            return this;
        }

        public ItemSearchId build() {
            return new ItemSearchId(this);
        }
    }
}
