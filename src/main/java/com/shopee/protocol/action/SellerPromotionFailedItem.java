package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerPromotionFailedItem extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public SellerPromotionFailedItem(Integer num, Long l, Long l2, Integer num2, String str) {
        this.shopid = num;
        this.itemid = l;
        this.modelid = l2;
        this.errcode = num2;
        this.debug_msg = str;
    }

    private SellerPromotionFailedItem(Builder builder) {
        this(builder.shopid, builder.itemid, builder.modelid, builder.errcode, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerPromotionFailedItem)) {
            return false;
        }
        SellerPromotionFailedItem sellerPromotionFailedItem = (SellerPromotionFailedItem) obj;
        if (!equals((Object) this.shopid, (Object) sellerPromotionFailedItem.shopid) || !equals((Object) this.itemid, (Object) sellerPromotionFailedItem.itemid) || !equals((Object) this.modelid, (Object) sellerPromotionFailedItem.modelid) || !equals((Object) this.errcode, (Object) sellerPromotionFailedItem.errcode) || !equals((Object) this.debug_msg, (Object) sellerPromotionFailedItem.debug_msg)) {
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
        Integer num2 = this.errcode;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.debug_msg;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerPromotionFailedItem> {
        public String debug_msg;
        public Integer errcode;
        public Long itemid;
        public Long modelid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(SellerPromotionFailedItem sellerPromotionFailedItem) {
            super(sellerPromotionFailedItem);
            if (sellerPromotionFailedItem != null) {
                this.shopid = sellerPromotionFailedItem.shopid;
                this.itemid = sellerPromotionFailedItem.itemid;
                this.modelid = sellerPromotionFailedItem.modelid;
                this.errcode = sellerPromotionFailedItem.errcode;
                this.debug_msg = sellerPromotionFailedItem.debug_msg;
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

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public SellerPromotionFailedItem build() {
            return new SellerPromotionFailedItem(this);
        }
    }
}
