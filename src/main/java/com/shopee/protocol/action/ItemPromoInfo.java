package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemPromoInfo extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Long DEFAULT_PROMOTION_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long promotion_price;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;

    public ItemPromoInfo(Long l, Long l2, Long l3, Long l4) {
        this.itemid = l;
        this.modelid = l2;
        this.promotionid = l3;
        this.promotion_price = l4;
    }

    private ItemPromoInfo(Builder builder) {
        this(builder.itemid, builder.modelid, builder.promotionid, builder.promotion_price);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemPromoInfo)) {
            return false;
        }
        ItemPromoInfo itemPromoInfo = (ItemPromoInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemPromoInfo.itemid) || !equals((Object) this.modelid, (Object) itemPromoInfo.modelid) || !equals((Object) this.promotionid, (Object) itemPromoInfo.promotionid) || !equals((Object) this.promotion_price, (Object) itemPromoInfo.promotion_price)) {
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
        Long l3 = this.promotionid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.promotion_price;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemPromoInfo> {
        public Long itemid;
        public Long modelid;
        public Long promotion_price;
        public Long promotionid;

        public Builder() {
        }

        public Builder(ItemPromoInfo itemPromoInfo) {
            super(itemPromoInfo);
            if (itemPromoInfo != null) {
                this.itemid = itemPromoInfo.itemid;
                this.modelid = itemPromoInfo.modelid;
                this.promotionid = itemPromoInfo.promotionid;
                this.promotion_price = itemPromoInfo.promotion_price;
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

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder promotion_price(Long l) {
            this.promotion_price = l;
            return this;
        }

        public ItemPromoInfo build() {
            return new ItemPromoInfo(this);
        }
    }
}
