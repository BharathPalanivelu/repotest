package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FlashSaleOutOfStockItem extends Message {
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STOCK = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer stock;

    public FlashSaleOutOfStockItem(Integer num, Long l, Long l2, Integer num2, Integer num3, Long l3, Long l4) {
        this.shopid = num;
        this.itemid = l;
        this.modelid = l2;
        this.stock = num2;
        this.end_time = num3;
        this.price = l3;
        this.price_before_discount = l4;
    }

    private FlashSaleOutOfStockItem(Builder builder) {
        this(builder.shopid, builder.itemid, builder.modelid, builder.stock, builder.end_time, builder.price, builder.price_before_discount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlashSaleOutOfStockItem)) {
            return false;
        }
        FlashSaleOutOfStockItem flashSaleOutOfStockItem = (FlashSaleOutOfStockItem) obj;
        if (!equals((Object) this.shopid, (Object) flashSaleOutOfStockItem.shopid) || !equals((Object) this.itemid, (Object) flashSaleOutOfStockItem.itemid) || !equals((Object) this.modelid, (Object) flashSaleOutOfStockItem.modelid) || !equals((Object) this.stock, (Object) flashSaleOutOfStockItem.stock) || !equals((Object) this.end_time, (Object) flashSaleOutOfStockItem.end_time) || !equals((Object) this.price, (Object) flashSaleOutOfStockItem.price) || !equals((Object) this.price_before_discount, (Object) flashSaleOutOfStockItem.price_before_discount)) {
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
        Integer num2 = this.stock;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l3 = this.price;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.price_before_discount;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FlashSaleOutOfStockItem> {
        public Integer end_time;
        public Long itemid;
        public Long modelid;
        public Long price;
        public Long price_before_discount;
        public Integer shopid;
        public Integer stock;

        public Builder() {
        }

        public Builder(FlashSaleOutOfStockItem flashSaleOutOfStockItem) {
            super(flashSaleOutOfStockItem);
            if (flashSaleOutOfStockItem != null) {
                this.shopid = flashSaleOutOfStockItem.shopid;
                this.itemid = flashSaleOutOfStockItem.itemid;
                this.modelid = flashSaleOutOfStockItem.modelid;
                this.stock = flashSaleOutOfStockItem.stock;
                this.end_time = flashSaleOutOfStockItem.end_time;
                this.price = flashSaleOutOfStockItem.price;
                this.price_before_discount = flashSaleOutOfStockItem.price_before_discount;
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

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public FlashSaleOutOfStockItem build() {
            return new FlashSaleOutOfStockItem(this);
        }
    }
}
