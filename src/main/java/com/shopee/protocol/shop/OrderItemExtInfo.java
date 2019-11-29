package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderItemExtInfo extends Message {
    public static final Long DEFAULT_ADD_ON_DEAL_ID = 0L;
    public static final Long DEFAULT_CARD_PROMOTION_DISCOUNT_BANK = 0L;
    public static final Long DEFAULT_CARD_PROMOTION_DISCOUNT_SHOPEE = 0L;
    public static final Long DEFAULT_CARD_TXN_FEE = 0L;
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final Long DEFAULT_COIN_EARN_BY_RULE = 0L;
    public static final Integer DEFAULT_COIN_EARN_RULE_ID = 0;
    public static final Long DEFAULT_COIN_OFFSET = 0L;
    public static final Integer DEFAULT_COIN_TYPE = 0;
    public static final Long DEFAULT_COIN_USED = 0L;
    public static final Long DEFAULT_COMM_BASE_AMOUNT = 0L;
    public static final Long DEFAULT_COMM_FEE = 0L;
    public static final Integer DEFAULT_COMM_RULE_ID = 0;
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final Long DEFAULT_DISCOUNT = 0L;
    public static final Integer DEFAULT_FREE_RETURN_DAY = 0;
    public static final Boolean DEFAULT_IS_ADD_ON_SUB_ITEM = false;
    public static final Boolean DEFAULT_IS_ONE_DOLLAR_GAME_ORDER = false;
    public static final Boolean DEFAULT_IS_WHOLESALE = false;
    public static final Long DEFAULT_ORDER_ITEM_ID = 0L;
    public static final Long DEFAULT_REBATE_PRICE = 0L;
    public static final Long DEFAULT_SLASH_PRICE_ACTIVITY_ID = 0L;
    public static final Integer DEFAULT_WHOLESALE_AMOUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 20, type = Message.Datatype.UINT64)
    public final Long add_on_deal_id;
    @ProtoField(tag = 17)
    public final BundleOrderItem bundle_order_item;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long card_promotion_discount_bank;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long card_promotion_discount_shopee;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long card_txn_fee;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long coin_earn_by_rule;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer coin_earn_rule_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long coin_offset;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer coin_type;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long coin_used;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long comm_base_amount;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long comm_fee;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer comm_rule_id;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer create_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long discount;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer free_return_day;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean is_add_on_sub_item;
    @ProtoField(tag = 23, type = Message.Datatype.BOOL)
    public final Boolean is_one_dollar_game_order;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean is_wholesale;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long order_item_id;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long rebate_price;
    @ProtoField(tag = 25)
    public final ServiceFeeOrderItemInfo service_fee_info;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long slash_price_activity_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer wholesale_amount;

    public OrderItemExtInfo(Long l, Long l2, Long l3, Integer num, Long l4, Long l5, Boolean bool, Integer num2, Long l6, Long l7, Integer num3, Long l8, Long l9, Long l10, Long l11, Integer num4, BundleOrderItem bundleOrderItem, Integer num5, Long l12, Long l13, Boolean bool2, Long l14, Boolean bool3, Integer num6, ServiceFeeOrderItemInfo serviceFeeOrderItemInfo) {
        this.discount = l;
        this.coin_offset = l2;
        this.coin_used = l3;
        this.coin_earn_rule_id = num;
        this.coin_earn_by_rule = l4;
        this.coin_earn = l5;
        this.is_wholesale = bool;
        this.wholesale_amount = num2;
        this.card_promotion_discount_bank = l6;
        this.card_promotion_discount_shopee = l7;
        this.comm_rule_id = num3;
        this.comm_fee = l8;
        this.card_txn_fee = l9;
        this.comm_base_amount = l10;
        this.rebate_price = l11;
        this.free_return_day = num4;
        this.bundle_order_item = bundleOrderItem;
        this.coin_type = num5;
        this.slash_price_activity_id = l12;
        this.add_on_deal_id = l13;
        this.is_add_on_sub_item = bool2;
        this.order_item_id = l14;
        this.is_one_dollar_game_order = bool3;
        this.create_time = num6;
        this.service_fee_info = serviceFeeOrderItemInfo;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderItemExtInfo(com.shopee.protocol.shop.OrderItemExtInfo.Builder r29) {
        /*
            r28 = this;
            r0 = r29
            r1 = r28
            java.lang.Long r2 = r0.discount
            java.lang.Long r3 = r0.coin_offset
            java.lang.Long r4 = r0.coin_used
            java.lang.Integer r5 = r0.coin_earn_rule_id
            java.lang.Long r6 = r0.coin_earn_by_rule
            java.lang.Long r7 = r0.coin_earn
            java.lang.Boolean r8 = r0.is_wholesale
            java.lang.Integer r9 = r0.wholesale_amount
            java.lang.Long r10 = r0.card_promotion_discount_bank
            java.lang.Long r11 = r0.card_promotion_discount_shopee
            java.lang.Integer r12 = r0.comm_rule_id
            java.lang.Long r13 = r0.comm_fee
            java.lang.Long r14 = r0.card_txn_fee
            java.lang.Long r15 = r0.comm_base_amount
            r27 = r1
            java.lang.Long r1 = r0.rebate_price
            r16 = r1
            java.lang.Integer r1 = r0.free_return_day
            r17 = r1
            com.shopee.protocol.shop.BundleOrderItem r1 = r0.bundle_order_item
            r18 = r1
            java.lang.Integer r1 = r0.coin_type
            r19 = r1
            java.lang.Long r1 = r0.slash_price_activity_id
            r20 = r1
            java.lang.Long r1 = r0.add_on_deal_id
            r21 = r1
            java.lang.Boolean r1 = r0.is_add_on_sub_item
            r22 = r1
            java.lang.Long r1 = r0.order_item_id
            r23 = r1
            java.lang.Boolean r1 = r0.is_one_dollar_game_order
            r24 = r1
            java.lang.Integer r1 = r0.create_time
            r25 = r1
            com.shopee.protocol.shop.ServiceFeeOrderItemInfo r1 = r0.service_fee_info
            r26 = r1
            r1 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r28.setBuilder(r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderItemExtInfo.<init>(com.shopee.protocol.shop.OrderItemExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderItemExtInfo)) {
            return false;
        }
        OrderItemExtInfo orderItemExtInfo = (OrderItemExtInfo) obj;
        if (!equals((Object) this.discount, (Object) orderItemExtInfo.discount) || !equals((Object) this.coin_offset, (Object) orderItemExtInfo.coin_offset) || !equals((Object) this.coin_used, (Object) orderItemExtInfo.coin_used) || !equals((Object) this.coin_earn_rule_id, (Object) orderItemExtInfo.coin_earn_rule_id) || !equals((Object) this.coin_earn_by_rule, (Object) orderItemExtInfo.coin_earn_by_rule) || !equals((Object) this.coin_earn, (Object) orderItemExtInfo.coin_earn) || !equals((Object) this.is_wholesale, (Object) orderItemExtInfo.is_wholesale) || !equals((Object) this.wholesale_amount, (Object) orderItemExtInfo.wholesale_amount) || !equals((Object) this.card_promotion_discount_bank, (Object) orderItemExtInfo.card_promotion_discount_bank) || !equals((Object) this.card_promotion_discount_shopee, (Object) orderItemExtInfo.card_promotion_discount_shopee) || !equals((Object) this.comm_rule_id, (Object) orderItemExtInfo.comm_rule_id) || !equals((Object) this.comm_fee, (Object) orderItemExtInfo.comm_fee) || !equals((Object) this.card_txn_fee, (Object) orderItemExtInfo.card_txn_fee) || !equals((Object) this.comm_base_amount, (Object) orderItemExtInfo.comm_base_amount) || !equals((Object) this.rebate_price, (Object) orderItemExtInfo.rebate_price) || !equals((Object) this.free_return_day, (Object) orderItemExtInfo.free_return_day) || !equals((Object) this.bundle_order_item, (Object) orderItemExtInfo.bundle_order_item) || !equals((Object) this.coin_type, (Object) orderItemExtInfo.coin_type) || !equals((Object) this.slash_price_activity_id, (Object) orderItemExtInfo.slash_price_activity_id) || !equals((Object) this.add_on_deal_id, (Object) orderItemExtInfo.add_on_deal_id) || !equals((Object) this.is_add_on_sub_item, (Object) orderItemExtInfo.is_add_on_sub_item) || !equals((Object) this.order_item_id, (Object) orderItemExtInfo.order_item_id) || !equals((Object) this.is_one_dollar_game_order, (Object) orderItemExtInfo.is_one_dollar_game_order) || !equals((Object) this.create_time, (Object) orderItemExtInfo.create_time) || !equals((Object) this.service_fee_info, (Object) orderItemExtInfo.service_fee_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.discount;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.coin_offset;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.coin_used;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.coin_earn_rule_id;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l4 = this.coin_earn_by_rule;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.coin_earn;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Boolean bool = this.is_wholesale;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.wholesale_amount;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l6 = this.card_promotion_discount_bank;
        int hashCode9 = (hashCode8 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.card_promotion_discount_shopee;
        int hashCode10 = (hashCode9 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num3 = this.comm_rule_id;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l8 = this.comm_fee;
        int hashCode12 = (hashCode11 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.card_txn_fee;
        int hashCode13 = (hashCode12 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.comm_base_amount;
        int hashCode14 = (hashCode13 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Long l11 = this.rebate_price;
        int hashCode15 = (hashCode14 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Integer num4 = this.free_return_day;
        int hashCode16 = (hashCode15 + (num4 != null ? num4.hashCode() : 0)) * 37;
        BundleOrderItem bundleOrderItem = this.bundle_order_item;
        int hashCode17 = (hashCode16 + (bundleOrderItem != null ? bundleOrderItem.hashCode() : 0)) * 37;
        Integer num5 = this.coin_type;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l12 = this.slash_price_activity_id;
        int hashCode19 = (hashCode18 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Long l13 = this.add_on_deal_id;
        int hashCode20 = (hashCode19 + (l13 != null ? l13.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_add_on_sub_item;
        int hashCode21 = (hashCode20 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Long l14 = this.order_item_id;
        int hashCode22 = (hashCode21 + (l14 != null ? l14.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_one_dollar_game_order;
        int hashCode23 = (hashCode22 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num6 = this.create_time;
        int hashCode24 = (hashCode23 + (num6 != null ? num6.hashCode() : 0)) * 37;
        ServiceFeeOrderItemInfo serviceFeeOrderItemInfo = this.service_fee_info;
        if (serviceFeeOrderItemInfo != null) {
            i2 = serviceFeeOrderItemInfo.hashCode();
        }
        int i3 = hashCode24 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderItemExtInfo> {
        public Long add_on_deal_id;
        public BundleOrderItem bundle_order_item;
        public Long card_promotion_discount_bank;
        public Long card_promotion_discount_shopee;
        public Long card_txn_fee;
        public Long coin_earn;
        public Long coin_earn_by_rule;
        public Integer coin_earn_rule_id;
        public Long coin_offset;
        public Integer coin_type;
        public Long coin_used;
        public Long comm_base_amount;
        public Long comm_fee;
        public Integer comm_rule_id;
        public Integer create_time;
        public Long discount;
        public Integer free_return_day;
        public Boolean is_add_on_sub_item;
        public Boolean is_one_dollar_game_order;
        public Boolean is_wholesale;
        public Long order_item_id;
        public Long rebate_price;
        public ServiceFeeOrderItemInfo service_fee_info;
        public Long slash_price_activity_id;
        public Integer wholesale_amount;

        public Builder() {
        }

        public Builder(OrderItemExtInfo orderItemExtInfo) {
            super(orderItemExtInfo);
            if (orderItemExtInfo != null) {
                this.discount = orderItemExtInfo.discount;
                this.coin_offset = orderItemExtInfo.coin_offset;
                this.coin_used = orderItemExtInfo.coin_used;
                this.coin_earn_rule_id = orderItemExtInfo.coin_earn_rule_id;
                this.coin_earn_by_rule = orderItemExtInfo.coin_earn_by_rule;
                this.coin_earn = orderItemExtInfo.coin_earn;
                this.is_wholesale = orderItemExtInfo.is_wholesale;
                this.wholesale_amount = orderItemExtInfo.wholesale_amount;
                this.card_promotion_discount_bank = orderItemExtInfo.card_promotion_discount_bank;
                this.card_promotion_discount_shopee = orderItemExtInfo.card_promotion_discount_shopee;
                this.comm_rule_id = orderItemExtInfo.comm_rule_id;
                this.comm_fee = orderItemExtInfo.comm_fee;
                this.card_txn_fee = orderItemExtInfo.card_txn_fee;
                this.comm_base_amount = orderItemExtInfo.comm_base_amount;
                this.rebate_price = orderItemExtInfo.rebate_price;
                this.free_return_day = orderItemExtInfo.free_return_day;
                this.bundle_order_item = orderItemExtInfo.bundle_order_item;
                this.coin_type = orderItemExtInfo.coin_type;
                this.slash_price_activity_id = orderItemExtInfo.slash_price_activity_id;
                this.add_on_deal_id = orderItemExtInfo.add_on_deal_id;
                this.is_add_on_sub_item = orderItemExtInfo.is_add_on_sub_item;
                this.order_item_id = orderItemExtInfo.order_item_id;
                this.is_one_dollar_game_order = orderItemExtInfo.is_one_dollar_game_order;
                this.create_time = orderItemExtInfo.create_time;
                this.service_fee_info = orderItemExtInfo.service_fee_info;
            }
        }

        public Builder discount(Long l) {
            this.discount = l;
            return this;
        }

        public Builder coin_offset(Long l) {
            this.coin_offset = l;
            return this;
        }

        public Builder coin_used(Long l) {
            this.coin_used = l;
            return this;
        }

        public Builder coin_earn_rule_id(Integer num) {
            this.coin_earn_rule_id = num;
            return this;
        }

        public Builder coin_earn_by_rule(Long l) {
            this.coin_earn_by_rule = l;
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
            return this;
        }

        public Builder is_wholesale(Boolean bool) {
            this.is_wholesale = bool;
            return this;
        }

        public Builder wholesale_amount(Integer num) {
            this.wholesale_amount = num;
            return this;
        }

        public Builder card_promotion_discount_bank(Long l) {
            this.card_promotion_discount_bank = l;
            return this;
        }

        public Builder card_promotion_discount_shopee(Long l) {
            this.card_promotion_discount_shopee = l;
            return this;
        }

        public Builder comm_rule_id(Integer num) {
            this.comm_rule_id = num;
            return this;
        }

        public Builder comm_fee(Long l) {
            this.comm_fee = l;
            return this;
        }

        public Builder card_txn_fee(Long l) {
            this.card_txn_fee = l;
            return this;
        }

        public Builder comm_base_amount(Long l) {
            this.comm_base_amount = l;
            return this;
        }

        public Builder rebate_price(Long l) {
            this.rebate_price = l;
            return this;
        }

        public Builder free_return_day(Integer num) {
            this.free_return_day = num;
            return this;
        }

        public Builder bundle_order_item(BundleOrderItem bundleOrderItem) {
            this.bundle_order_item = bundleOrderItem;
            return this;
        }

        public Builder coin_type(Integer num) {
            this.coin_type = num;
            return this;
        }

        public Builder slash_price_activity_id(Long l) {
            this.slash_price_activity_id = l;
            return this;
        }

        public Builder add_on_deal_id(Long l) {
            this.add_on_deal_id = l;
            return this;
        }

        public Builder is_add_on_sub_item(Boolean bool) {
            this.is_add_on_sub_item = bool;
            return this;
        }

        public Builder order_item_id(Long l) {
            this.order_item_id = l;
            return this;
        }

        public Builder is_one_dollar_game_order(Boolean bool) {
            this.is_one_dollar_game_order = bool;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder service_fee_info(ServiceFeeOrderItemInfo serviceFeeOrderItemInfo) {
            this.service_fee_info = serviceFeeOrderItemInfo;
            return this;
        }

        public OrderItemExtInfo build() {
            return new OrderItemExtInfo(this);
        }
    }
}
