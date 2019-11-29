package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemSimpleInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemSearchInfo extends Message {
    public static final Double DEFAULT_DISTANCE = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double distance;
    @ProtoField(tag = 3)
    public final ItemSearchId itemid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final ItemSimpleInfo simple_item;

    public ItemSearchInfo(ItemSimpleInfo itemSimpleInfo, Double d2, ItemSearchId itemSearchId) {
        this.simple_item = itemSimpleInfo;
        this.distance = d2;
        this.itemid = itemSearchId;
    }

    private ItemSearchInfo(Builder builder) {
        this(builder.simple_item, builder.distance, builder.itemid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemSearchInfo)) {
            return false;
        }
        ItemSearchInfo itemSearchInfo = (ItemSearchInfo) obj;
        if (!equals((Object) this.simple_item, (Object) itemSearchInfo.simple_item) || !equals((Object) this.distance, (Object) itemSearchInfo.distance) || !equals((Object) this.itemid, (Object) itemSearchInfo.itemid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ItemSimpleInfo itemSimpleInfo = this.simple_item;
        int i2 = 0;
        int hashCode = (itemSimpleInfo != null ? itemSimpleInfo.hashCode() : 0) * 37;
        Double d2 = this.distance;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        ItemSearchId itemSearchId = this.itemid;
        if (itemSearchId != null) {
            i2 = itemSearchId.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemSearchInfo> {
        public Double distance;
        public ItemSearchId itemid;
        public ItemSimpleInfo simple_item;

        public Builder() {
        }

        public Builder(ItemSearchInfo itemSearchInfo) {
            super(itemSearchInfo);
            if (itemSearchInfo != null) {
                this.simple_item = itemSearchInfo.simple_item;
                this.distance = itemSearchInfo.distance;
                this.itemid = itemSearchInfo.itemid;
            }
        }

        public Builder simple_item(ItemSimpleInfo itemSimpleInfo) {
            this.simple_item = itemSimpleInfo;
            return this;
        }

        public Builder distance(Double d2) {
            this.distance = d2;
            return this;
        }

        public Builder itemid(ItemSearchId itemSearchId) {
            this.itemid = itemSearchId;
            return this;
        }

        public ItemSearchInfo build() {
            checkRequiredFields();
            return new ItemSearchInfo(this);
        }
    }
}
