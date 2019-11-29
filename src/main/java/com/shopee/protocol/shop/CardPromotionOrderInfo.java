package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CardPromotionOrderInfo extends Message {
    public static final Integer DEFAULT_CARD_PROMOTION_ID = 0;
    public static final Long DEFAULT_DISCOUNT_BANK = 0L;
    public static final Long DEFAULT_DISCOUNT_SHOPEE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer card_promotion_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long discount_bank;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long discount_shopee;

    public CardPromotionOrderInfo(Integer num, Long l, Long l2) {
        this.card_promotion_id = num;
        this.discount_bank = l;
        this.discount_shopee = l2;
    }

    private CardPromotionOrderInfo(Builder builder) {
        this(builder.card_promotion_id, builder.discount_bank, builder.discount_shopee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPromotionOrderInfo)) {
            return false;
        }
        CardPromotionOrderInfo cardPromotionOrderInfo = (CardPromotionOrderInfo) obj;
        if (!equals((Object) this.card_promotion_id, (Object) cardPromotionOrderInfo.card_promotion_id) || !equals((Object) this.discount_bank, (Object) cardPromotionOrderInfo.discount_bank) || !equals((Object) this.discount_shopee, (Object) cardPromotionOrderInfo.discount_shopee)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.card_promotion_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.discount_bank;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.discount_shopee;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CardPromotionOrderInfo> {
        public Integer card_promotion_id;
        public Long discount_bank;
        public Long discount_shopee;

        public Builder() {
        }

        public Builder(CardPromotionOrderInfo cardPromotionOrderInfo) {
            super(cardPromotionOrderInfo);
            if (cardPromotionOrderInfo != null) {
                this.card_promotion_id = cardPromotionOrderInfo.card_promotion_id;
                this.discount_bank = cardPromotionOrderInfo.discount_bank;
                this.discount_shopee = cardPromotionOrderInfo.discount_shopee;
            }
        }

        public Builder card_promotion_id(Integer num) {
            this.card_promotion_id = num;
            return this;
        }

        public Builder discount_bank(Long l) {
            this.discount_bank = l;
            return this;
        }

        public Builder discount_shopee(Long l) {
            this.discount_shopee = l;
            return this;
        }

        public CardPromotionOrderInfo build() {
            return new CardPromotionOrderInfo(this);
        }
    }
}
