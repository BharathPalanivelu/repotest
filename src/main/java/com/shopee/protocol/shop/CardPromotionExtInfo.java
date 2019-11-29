package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CardPromotionExtInfo extends Message {
    public static final Boolean DEFAULT_CAN_USE_BUYER_PROMOTION = false;
    public static final List<String> DEFAULT_CARD_BIN_NUMBERS = Collections.emptyList();
    public static final List<Integer> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final Integer DEFAULT_CREDIT_CARD_USAGE_CYCLE_LIMIT = 0;
    public static final Integer DEFAULT_CREDIT_CARD_USAGE_DAILY_LIMIT = 0;
    public static final Integer DEFAULT_CREDIT_CARD_USAGE_MONTHLY_LIMIT = 0;
    public static final Integer DEFAULT_CREDIT_CARD_USAGE_WEEKLY_LIMIT = 0;
    public static final List<Integer> DEFAULT_DISABLE_CATEGORIES = Collections.emptyList();
    public static final List<PromotionItem> DEFAULT_DISABLE_ITEMS = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISABLE_SHOPIDS = Collections.emptyList();
    public static final List<PromotionItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Boolean DEFAULT_LIMIT_ON_CREDIT_CARD = false;
    public static final List<CardPromotionPriceTier> DEFAULT_PRICE_TIERS = Collections.emptyList();
    public static final List<Integer> DEFAULT_SHOPIDS = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL_USAGE_CYCLE_LIMIT = 0;
    public static final Integer DEFAULT_TOTAL_USAGE_DAILY_LIMIT = 0;
    public static final Integer DEFAULT_TOTAL_USAGE_LIMIT = 0;
    public static final Integer DEFAULT_TOTAL_USAGE_WEEKLY_LIMIT = 0;
    public static final Integer DEFAULT_USER_USAGE_CYCLE_LIMIT = 0;
    public static final Integer DEFAULT_USER_USAGE_DAILY_LIMIT = 0;
    public static final Integer DEFAULT_USER_USAGE_LIMIT = 0;
    public static final Integer DEFAULT_USER_USAGE_WEEKLY_LIMIT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean can_use_buyer_promotion;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.STRING)
    public final List<String> card_bin_numbers;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> categories;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer credit_card_usage_cycle_limit;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer credit_card_usage_daily_limit;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer credit_card_usage_monthly_limit;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer credit_card_usage_weekly_limit;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> disable_categories;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromotionItem.class, tag = 6)
    public final List<PromotionItem> disable_items;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> disable_shopids;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromotionItem.class, tag = 3)
    public final List<PromotionItem> items;
    @ProtoField(tag = 22, type = Message.Datatype.BOOL)
    public final Boolean limit_on_credit_card;
    @ProtoField(label = Message.Label.REPEATED, messageType = CardPromotionPriceTier.class, tag = 7)
    public final List<CardPromotionPriceTier> price_tiers;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> shopids;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer total_usage_cycle_limit;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer total_usage_daily_limit;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer total_usage_limit;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer total_usage_weekly_limit;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer user_usage_cycle_limit;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer user_usage_daily_limit;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer user_usage_limit;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer user_usage_weekly_limit;

    public CardPromotionExtInfo(List<Integer> list, List<Integer> list2, List<PromotionItem> list3, List<Integer> list4, List<Integer> list5, List<PromotionItem> list6, List<CardPromotionPriceTier> list7, Boolean bool, List<String> list8, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Boolean bool2) {
        this.categories = immutableCopyOf(list);
        this.shopids = immutableCopyOf(list2);
        this.items = immutableCopyOf(list3);
        this.disable_categories = immutableCopyOf(list4);
        this.disable_shopids = immutableCopyOf(list5);
        this.disable_items = immutableCopyOf(list6);
        this.price_tiers = immutableCopyOf(list7);
        this.can_use_buyer_promotion = bool;
        this.card_bin_numbers = immutableCopyOf(list8);
        this.total_usage_limit = num;
        this.user_usage_limit = num2;
        this.total_usage_daily_limit = num3;
        this.user_usage_daily_limit = num4;
        this.total_usage_weekly_limit = num5;
        this.user_usage_weekly_limit = num6;
        this.total_usage_cycle_limit = num7;
        this.user_usage_cycle_limit = num8;
        this.credit_card_usage_daily_limit = num9;
        this.credit_card_usage_weekly_limit = num10;
        this.credit_card_usage_monthly_limit = num11;
        this.credit_card_usage_cycle_limit = num12;
        this.limit_on_credit_card = bool2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CardPromotionExtInfo(com.shopee.protocol.shop.CardPromotionExtInfo.Builder r26) {
        /*
            r25 = this;
            r0 = r26
            r1 = r25
            java.util.List<java.lang.Integer> r2 = r0.categories
            java.util.List<java.lang.Integer> r3 = r0.shopids
            java.util.List<com.shopee.protocol.shop.PromotionItem> r4 = r0.items
            java.util.List<java.lang.Integer> r5 = r0.disable_categories
            java.util.List<java.lang.Integer> r6 = r0.disable_shopids
            java.util.List<com.shopee.protocol.shop.PromotionItem> r7 = r0.disable_items
            java.util.List<com.shopee.protocol.shop.CardPromotionPriceTier> r8 = r0.price_tiers
            java.lang.Boolean r9 = r0.can_use_buyer_promotion
            java.util.List<java.lang.String> r10 = r0.card_bin_numbers
            java.lang.Integer r11 = r0.total_usage_limit
            java.lang.Integer r12 = r0.user_usage_limit
            java.lang.Integer r13 = r0.total_usage_daily_limit
            java.lang.Integer r14 = r0.user_usage_daily_limit
            java.lang.Integer r15 = r0.total_usage_weekly_limit
            r24 = r1
            java.lang.Integer r1 = r0.user_usage_weekly_limit
            r16 = r1
            java.lang.Integer r1 = r0.total_usage_cycle_limit
            r17 = r1
            java.lang.Integer r1 = r0.user_usage_cycle_limit
            r18 = r1
            java.lang.Integer r1 = r0.credit_card_usage_daily_limit
            r19 = r1
            java.lang.Integer r1 = r0.credit_card_usage_weekly_limit
            r20 = r1
            java.lang.Integer r1 = r0.credit_card_usage_monthly_limit
            r21 = r1
            java.lang.Integer r1 = r0.credit_card_usage_cycle_limit
            r22 = r1
            java.lang.Boolean r1 = r0.limit_on_credit_card
            r23 = r1
            r1 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.setBuilder(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.CardPromotionExtInfo.<init>(com.shopee.protocol.shop.CardPromotionExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPromotionExtInfo)) {
            return false;
        }
        CardPromotionExtInfo cardPromotionExtInfo = (CardPromotionExtInfo) obj;
        if (!equals((List<?>) this.categories, (List<?>) cardPromotionExtInfo.categories) || !equals((List<?>) this.shopids, (List<?>) cardPromotionExtInfo.shopids) || !equals((List<?>) this.items, (List<?>) cardPromotionExtInfo.items) || !equals((List<?>) this.disable_categories, (List<?>) cardPromotionExtInfo.disable_categories) || !equals((List<?>) this.disable_shopids, (List<?>) cardPromotionExtInfo.disable_shopids) || !equals((List<?>) this.disable_items, (List<?>) cardPromotionExtInfo.disable_items) || !equals((List<?>) this.price_tiers, (List<?>) cardPromotionExtInfo.price_tiers) || !equals((Object) this.can_use_buyer_promotion, (Object) cardPromotionExtInfo.can_use_buyer_promotion) || !equals((List<?>) this.card_bin_numbers, (List<?>) cardPromotionExtInfo.card_bin_numbers) || !equals((Object) this.total_usage_limit, (Object) cardPromotionExtInfo.total_usage_limit) || !equals((Object) this.user_usage_limit, (Object) cardPromotionExtInfo.user_usage_limit) || !equals((Object) this.total_usage_daily_limit, (Object) cardPromotionExtInfo.total_usage_daily_limit) || !equals((Object) this.user_usage_daily_limit, (Object) cardPromotionExtInfo.user_usage_daily_limit) || !equals((Object) this.total_usage_weekly_limit, (Object) cardPromotionExtInfo.total_usage_weekly_limit) || !equals((Object) this.user_usage_weekly_limit, (Object) cardPromotionExtInfo.user_usage_weekly_limit) || !equals((Object) this.total_usage_cycle_limit, (Object) cardPromotionExtInfo.total_usage_cycle_limit) || !equals((Object) this.user_usage_cycle_limit, (Object) cardPromotionExtInfo.user_usage_cycle_limit) || !equals((Object) this.credit_card_usage_daily_limit, (Object) cardPromotionExtInfo.credit_card_usage_daily_limit) || !equals((Object) this.credit_card_usage_weekly_limit, (Object) cardPromotionExtInfo.credit_card_usage_weekly_limit) || !equals((Object) this.credit_card_usage_monthly_limit, (Object) cardPromotionExtInfo.credit_card_usage_monthly_limit) || !equals((Object) this.credit_card_usage_cycle_limit, (Object) cardPromotionExtInfo.credit_card_usage_cycle_limit) || !equals((Object) this.limit_on_credit_card, (Object) cardPromotionExtInfo.limit_on_credit_card)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Integer> list = this.categories;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Integer> list2 = this.shopids;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<PromotionItem> list3 = this.items;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Integer> list4 = this.disable_categories;
        int hashCode4 = (hashCode3 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<Integer> list5 = this.disable_shopids;
        int hashCode5 = (hashCode4 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<PromotionItem> list6 = this.disable_items;
        int hashCode6 = (hashCode5 + (list6 != null ? list6.hashCode() : 1)) * 37;
        List<CardPromotionPriceTier> list7 = this.price_tiers;
        int hashCode7 = (hashCode6 + (list7 != null ? list7.hashCode() : 1)) * 37;
        Boolean bool = this.can_use_buyer_promotion;
        int i3 = 0;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<String> list8 = this.card_bin_numbers;
        if (list8 != null) {
            i2 = list8.hashCode();
        }
        int i4 = (hashCode8 + i2) * 37;
        Integer num = this.total_usage_limit;
        int hashCode9 = (i4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.user_usage_limit;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.total_usage_daily_limit;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.user_usage_daily_limit;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.total_usage_weekly_limit;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.user_usage_weekly_limit;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.total_usage_cycle_limit;
        int hashCode15 = (hashCode14 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.user_usage_cycle_limit;
        int hashCode16 = (hashCode15 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.credit_card_usage_daily_limit;
        int hashCode17 = (hashCode16 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.credit_card_usage_weekly_limit;
        int hashCode18 = (hashCode17 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.credit_card_usage_monthly_limit;
        int hashCode19 = (hashCode18 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.credit_card_usage_cycle_limit;
        int hashCode20 = (hashCode19 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Boolean bool2 = this.limit_on_credit_card;
        if (bool2 != null) {
            i3 = bool2.hashCode();
        }
        int i5 = hashCode20 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<CardPromotionExtInfo> {
        public Boolean can_use_buyer_promotion;
        public List<String> card_bin_numbers;
        public List<Integer> categories;
        public Integer credit_card_usage_cycle_limit;
        public Integer credit_card_usage_daily_limit;
        public Integer credit_card_usage_monthly_limit;
        public Integer credit_card_usage_weekly_limit;
        public List<Integer> disable_categories;
        public List<PromotionItem> disable_items;
        public List<Integer> disable_shopids;
        public List<PromotionItem> items;
        public Boolean limit_on_credit_card;
        public List<CardPromotionPriceTier> price_tiers;
        public List<Integer> shopids;
        public Integer total_usage_cycle_limit;
        public Integer total_usage_daily_limit;
        public Integer total_usage_limit;
        public Integer total_usage_weekly_limit;
        public Integer user_usage_cycle_limit;
        public Integer user_usage_daily_limit;
        public Integer user_usage_limit;
        public Integer user_usage_weekly_limit;

        public Builder() {
        }

        public Builder(CardPromotionExtInfo cardPromotionExtInfo) {
            super(cardPromotionExtInfo);
            if (cardPromotionExtInfo != null) {
                this.categories = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.categories);
                this.shopids = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.shopids);
                this.items = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.items);
                this.disable_categories = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.disable_categories);
                this.disable_shopids = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.disable_shopids);
                this.disable_items = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.disable_items);
                this.price_tiers = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.price_tiers);
                this.can_use_buyer_promotion = cardPromotionExtInfo.can_use_buyer_promotion;
                this.card_bin_numbers = CardPromotionExtInfo.copyOf(cardPromotionExtInfo.card_bin_numbers);
                this.total_usage_limit = cardPromotionExtInfo.total_usage_limit;
                this.user_usage_limit = cardPromotionExtInfo.user_usage_limit;
                this.total_usage_daily_limit = cardPromotionExtInfo.total_usage_daily_limit;
                this.user_usage_daily_limit = cardPromotionExtInfo.user_usage_daily_limit;
                this.total_usage_weekly_limit = cardPromotionExtInfo.total_usage_weekly_limit;
                this.user_usage_weekly_limit = cardPromotionExtInfo.user_usage_weekly_limit;
                this.total_usage_cycle_limit = cardPromotionExtInfo.total_usage_cycle_limit;
                this.user_usage_cycle_limit = cardPromotionExtInfo.user_usage_cycle_limit;
                this.credit_card_usage_daily_limit = cardPromotionExtInfo.credit_card_usage_daily_limit;
                this.credit_card_usage_weekly_limit = cardPromotionExtInfo.credit_card_usage_weekly_limit;
                this.credit_card_usage_monthly_limit = cardPromotionExtInfo.credit_card_usage_monthly_limit;
                this.credit_card_usage_cycle_limit = cardPromotionExtInfo.credit_card_usage_cycle_limit;
                this.limit_on_credit_card = cardPromotionExtInfo.limit_on_credit_card;
            }
        }

        public Builder categories(List<Integer> list) {
            this.categories = checkForNulls(list);
            return this;
        }

        public Builder shopids(List<Integer> list) {
            this.shopids = checkForNulls(list);
            return this;
        }

        public Builder items(List<PromotionItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder disable_categories(List<Integer> list) {
            this.disable_categories = checkForNulls(list);
            return this;
        }

        public Builder disable_shopids(List<Integer> list) {
            this.disable_shopids = checkForNulls(list);
            return this;
        }

        public Builder disable_items(List<PromotionItem> list) {
            this.disable_items = checkForNulls(list);
            return this;
        }

        public Builder price_tiers(List<CardPromotionPriceTier> list) {
            this.price_tiers = checkForNulls(list);
            return this;
        }

        public Builder can_use_buyer_promotion(Boolean bool) {
            this.can_use_buyer_promotion = bool;
            return this;
        }

        public Builder card_bin_numbers(List<String> list) {
            this.card_bin_numbers = checkForNulls(list);
            return this;
        }

        public Builder total_usage_limit(Integer num) {
            this.total_usage_limit = num;
            return this;
        }

        public Builder user_usage_limit(Integer num) {
            this.user_usage_limit = num;
            return this;
        }

        public Builder total_usage_daily_limit(Integer num) {
            this.total_usage_daily_limit = num;
            return this;
        }

        public Builder user_usage_daily_limit(Integer num) {
            this.user_usage_daily_limit = num;
            return this;
        }

        public Builder total_usage_weekly_limit(Integer num) {
            this.total_usage_weekly_limit = num;
            return this;
        }

        public Builder user_usage_weekly_limit(Integer num) {
            this.user_usage_weekly_limit = num;
            return this;
        }

        public Builder total_usage_cycle_limit(Integer num) {
            this.total_usage_cycle_limit = num;
            return this;
        }

        public Builder user_usage_cycle_limit(Integer num) {
            this.user_usage_cycle_limit = num;
            return this;
        }

        public Builder credit_card_usage_daily_limit(Integer num) {
            this.credit_card_usage_daily_limit = num;
            return this;
        }

        public Builder credit_card_usage_weekly_limit(Integer num) {
            this.credit_card_usage_weekly_limit = num;
            return this;
        }

        public Builder credit_card_usage_monthly_limit(Integer num) {
            this.credit_card_usage_monthly_limit = num;
            return this;
        }

        public Builder credit_card_usage_cycle_limit(Integer num) {
            this.credit_card_usage_cycle_limit = num;
            return this;
        }

        public Builder limit_on_credit_card(Boolean bool) {
            this.limit_on_credit_card = bool;
            return this;
        }

        public CardPromotionExtInfo build() {
            return new CardPromotionExtInfo(this);
        }
    }
}
