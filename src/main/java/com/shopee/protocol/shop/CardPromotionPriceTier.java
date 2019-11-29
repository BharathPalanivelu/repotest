package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CardPromotionPriceTier extends Message {
    public static final Long DEFAULT_DISCOUNT_FIX_VALUE = 0L;
    public static final Long DEFAULT_DISCOUNT_MAX_VALUE = 0L;
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Long DEFAULT_DISCOUNT_SHOPEE_VALUE = 0L;
    public static final Long DEFAULT_MAX_PRICE = 0L;
    public static final Long DEFAULT_MIN_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long discount_fix_value;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long discount_max_value;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long discount_shopee_value;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long max_price;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long min_price;

    public CardPromotionPriceTier(Long l, Long l2, Long l3, Integer num, Long l4, Long l5) {
        this.min_price = l;
        this.max_price = l2;
        this.discount_fix_value = l3;
        this.discount_percentage = num;
        this.discount_max_value = l4;
        this.discount_shopee_value = l5;
    }

    private CardPromotionPriceTier(Builder builder) {
        this(builder.min_price, builder.max_price, builder.discount_fix_value, builder.discount_percentage, builder.discount_max_value, builder.discount_shopee_value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPromotionPriceTier)) {
            return false;
        }
        CardPromotionPriceTier cardPromotionPriceTier = (CardPromotionPriceTier) obj;
        if (!equals((Object) this.min_price, (Object) cardPromotionPriceTier.min_price) || !equals((Object) this.max_price, (Object) cardPromotionPriceTier.max_price) || !equals((Object) this.discount_fix_value, (Object) cardPromotionPriceTier.discount_fix_value) || !equals((Object) this.discount_percentage, (Object) cardPromotionPriceTier.discount_percentage) || !equals((Object) this.discount_max_value, (Object) cardPromotionPriceTier.discount_max_value) || !equals((Object) this.discount_shopee_value, (Object) cardPromotionPriceTier.discount_shopee_value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.min_price;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.max_price;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.discount_fix_value;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.discount_percentage;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l4 = this.discount_max_value;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.discount_shopee_value;
        if (l5 != null) {
            i2 = l5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CardPromotionPriceTier> {
        public Long discount_fix_value;
        public Long discount_max_value;
        public Integer discount_percentage;
        public Long discount_shopee_value;
        public Long max_price;
        public Long min_price;

        public Builder() {
        }

        public Builder(CardPromotionPriceTier cardPromotionPriceTier) {
            super(cardPromotionPriceTier);
            if (cardPromotionPriceTier != null) {
                this.min_price = cardPromotionPriceTier.min_price;
                this.max_price = cardPromotionPriceTier.max_price;
                this.discount_fix_value = cardPromotionPriceTier.discount_fix_value;
                this.discount_percentage = cardPromotionPriceTier.discount_percentage;
                this.discount_max_value = cardPromotionPriceTier.discount_max_value;
                this.discount_shopee_value = cardPromotionPriceTier.discount_shopee_value;
            }
        }

        public Builder min_price(Long l) {
            this.min_price = l;
            return this;
        }

        public Builder max_price(Long l) {
            this.max_price = l;
            return this;
        }

        public Builder discount_fix_value(Long l) {
            this.discount_fix_value = l;
            return this;
        }

        public Builder discount_percentage(Integer num) {
            this.discount_percentage = num;
            return this;
        }

        public Builder discount_max_value(Long l) {
            this.discount_max_value = l;
            return this;
        }

        public Builder discount_shopee_value(Long l) {
            this.discount_shopee_value = l;
            return this;
        }

        public CardPromotionPriceTier build() {
            return new CardPromotionPriceTier(this);
        }
    }
}
