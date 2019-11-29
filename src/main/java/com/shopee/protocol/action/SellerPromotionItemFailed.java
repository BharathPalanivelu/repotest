package com.shopee.protocol.action;

import com.shopee.protocol.shop.SellerPromotionItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerPromotionItemFailed extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REASON = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1)
    public final SellerPromotionItem item_promotion;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String reason;

    public SellerPromotionItemFailed(SellerPromotionItem sellerPromotionItem, Integer num, String str) {
        this.item_promotion = sellerPromotionItem;
        this.errcode = num;
        this.reason = str;
    }

    private SellerPromotionItemFailed(Builder builder) {
        this(builder.item_promotion, builder.errcode, builder.reason);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerPromotionItemFailed)) {
            return false;
        }
        SellerPromotionItemFailed sellerPromotionItemFailed = (SellerPromotionItemFailed) obj;
        if (!equals((Object) this.item_promotion, (Object) sellerPromotionItemFailed.item_promotion) || !equals((Object) this.errcode, (Object) sellerPromotionItemFailed.errcode) || !equals((Object) this.reason, (Object) sellerPromotionItemFailed.reason)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        SellerPromotionItem sellerPromotionItem = this.item_promotion;
        int i2 = 0;
        int hashCode = (sellerPromotionItem != null ? sellerPromotionItem.hashCode() : 0) * 37;
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.reason;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerPromotionItemFailed> {
        public Integer errcode;
        public SellerPromotionItem item_promotion;
        public String reason;

        public Builder() {
        }

        public Builder(SellerPromotionItemFailed sellerPromotionItemFailed) {
            super(sellerPromotionItemFailed);
            if (sellerPromotionItemFailed != null) {
                this.item_promotion = sellerPromotionItemFailed.item_promotion;
                this.errcode = sellerPromotionItemFailed.errcode;
                this.reason = sellerPromotionItemFailed.reason;
            }
        }

        public Builder item_promotion(SellerPromotionItem sellerPromotionItem) {
            this.item_promotion = sellerPromotionItem;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public SellerPromotionItemFailed build() {
            return new SellerPromotionItemFailed(this);
        }
    }
}
