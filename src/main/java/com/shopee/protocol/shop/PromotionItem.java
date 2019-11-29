package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PromotionItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public PromotionItem(Integer num, Long l, Long l2) {
        this.shopid = num;
        this.itemid = l;
        this.modelid = l2;
    }

    private PromotionItem(Builder builder) {
        this(builder.shopid, builder.itemid, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromotionItem)) {
            return false;
        }
        PromotionItem promotionItem = (PromotionItem) obj;
        if (!equals((Object) this.shopid, (Object) promotionItem.shopid) || !equals((Object) this.itemid, (Object) promotionItem.itemid) || !equals((Object) this.modelid, (Object) promotionItem.modelid)) {
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
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PromotionItem> {
        public Long itemid;
        public Long modelid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(PromotionItem promotionItem) {
            super(promotionItem);
            if (promotionItem != null) {
                this.shopid = promotionItem.shopid;
                this.itemid = promotionItem.itemid;
                this.modelid = promotionItem.modelid;
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

        public PromotionItem build() {
            return new PromotionItem(this);
        }
    }
}
