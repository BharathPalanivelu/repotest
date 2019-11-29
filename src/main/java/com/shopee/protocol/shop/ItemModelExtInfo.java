package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemModelExtInfo extends Message {
    public static final Integer DEFAULT_CURRENT_ALLOCATED_STOCK = 0;
    public static final String DEFAULT_GTIN = "";
    public static final Boolean DEFAULT_HAS_SHOPEE_PROMO = false;
    public static final Integer DEFAULT_HOLIDAY_MODE_OLD_STOCK = 0;
    public static final Integer DEFAULT_LOW_STOCK_THRESHOLD = 0;
    public static final Integer DEFAULT_PROMO_SOURCE = 0;
    public static final Integer DEFAULT_SELLER_PROMOTION_LIMIT = 0;
    public static final Integer DEFAULT_SELLER_PROMOTION_REFRESH_TIME = 0;
    public static final Integer DEFAULT_SHOP_ID = 0;
    public static final Integer DEFAULT_STOCKOUT_TIME = 0;
    public static final Integer DEFAULT_STOCK_BEFORE_DISCOUNT = 0;
    public static final Integer DEFAULT_SUSTAIN_DAYS_THRESHOLD = 0;
    public static final List<Integer> DEFAULT_TIER_INDEX = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL_STOCK_FOR_DISCOUNT = 0;
    public static final Long DEFAULT_UPCOMING_FS_PROMO_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 16, type = Message.Datatype.UINT32)
    public final Integer current_allocated_stock;
    @ProtoField(tag = 11)
    public final GroupBuyInfo group_buy_info;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String gtin;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean has_shopee_promo;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer holiday_mode_old_stock;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer low_stock_threshold;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer promo_source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer seller_promotion_limit;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer seller_promotion_refresh_time;
    @ProtoField(tag = 15, type = Message.Datatype.UINT32)
    public final Integer shop_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer stock_before_discount;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer stockout_time;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer sustain_days_threshold;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT32)
    public final List<Integer> tier_index;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer total_stock_for_discount;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long upcoming_fs_promo_id;

    public ItemModelExtInfo(Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, Integer num5, Integer num6, Integer num7, List<Integer> list, Long l, GroupBuyInfo groupBuyInfo, Integer num8, Integer num9, String str, Integer num10, Integer num11) {
        this.seller_promotion_limit = num;
        this.seller_promotion_refresh_time = num2;
        this.holiday_mode_old_stock = num3;
        this.has_shopee_promo = bool;
        this.promo_source = num4;
        this.stock_before_discount = num5;
        this.total_stock_for_discount = num6;
        this.stockout_time = num7;
        this.tier_index = immutableCopyOf(list);
        this.upcoming_fs_promo_id = l;
        this.group_buy_info = groupBuyInfo;
        this.low_stock_threshold = num8;
        this.sustain_days_threshold = num9;
        this.gtin = str;
        this.shop_id = num10;
        this.current_allocated_stock = num11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ItemModelExtInfo(com.shopee.protocol.shop.ItemModelExtInfo.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.Integer r2 = r0.seller_promotion_limit
            java.lang.Integer r3 = r0.seller_promotion_refresh_time
            java.lang.Integer r4 = r0.holiday_mode_old_stock
            java.lang.Boolean r5 = r0.has_shopee_promo
            java.lang.Integer r6 = r0.promo_source
            java.lang.Integer r7 = r0.stock_before_discount
            java.lang.Integer r8 = r0.total_stock_for_discount
            java.lang.Integer r9 = r0.stockout_time
            java.util.List<java.lang.Integer> r10 = r0.tier_index
            java.lang.Long r11 = r0.upcoming_fs_promo_id
            com.shopee.protocol.shop.GroupBuyInfo r12 = r0.group_buy_info
            java.lang.Integer r13 = r0.low_stock_threshold
            java.lang.Integer r14 = r0.sustain_days_threshold
            java.lang.String r15 = r0.gtin
            r18 = r1
            java.lang.Integer r1 = r0.shop_id
            r16 = r1
            java.lang.Integer r1 = r0.current_allocated_stock
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ItemModelExtInfo.<init>(com.shopee.protocol.shop.ItemModelExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemModelExtInfo)) {
            return false;
        }
        ItemModelExtInfo itemModelExtInfo = (ItemModelExtInfo) obj;
        if (!equals((Object) this.seller_promotion_limit, (Object) itemModelExtInfo.seller_promotion_limit) || !equals((Object) this.seller_promotion_refresh_time, (Object) itemModelExtInfo.seller_promotion_refresh_time) || !equals((Object) this.holiday_mode_old_stock, (Object) itemModelExtInfo.holiday_mode_old_stock) || !equals((Object) this.has_shopee_promo, (Object) itemModelExtInfo.has_shopee_promo) || !equals((Object) this.promo_source, (Object) itemModelExtInfo.promo_source) || !equals((Object) this.stock_before_discount, (Object) itemModelExtInfo.stock_before_discount) || !equals((Object) this.total_stock_for_discount, (Object) itemModelExtInfo.total_stock_for_discount) || !equals((Object) this.stockout_time, (Object) itemModelExtInfo.stockout_time) || !equals((List<?>) this.tier_index, (List<?>) itemModelExtInfo.tier_index) || !equals((Object) this.upcoming_fs_promo_id, (Object) itemModelExtInfo.upcoming_fs_promo_id) || !equals((Object) this.group_buy_info, (Object) itemModelExtInfo.group_buy_info) || !equals((Object) this.low_stock_threshold, (Object) itemModelExtInfo.low_stock_threshold) || !equals((Object) this.sustain_days_threshold, (Object) itemModelExtInfo.sustain_days_threshold) || !equals((Object) this.gtin, (Object) itemModelExtInfo.gtin) || !equals((Object) this.shop_id, (Object) itemModelExtInfo.shop_id) || !equals((Object) this.current_allocated_stock, (Object) itemModelExtInfo.current_allocated_stock)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.seller_promotion_limit;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.seller_promotion_refresh_time;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.holiday_mode_old_stock;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.has_shopee_promo;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num4 = this.promo_source;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.stock_before_discount;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.total_stock_for_discount;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.stockout_time;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        List<Integer> list = this.tier_index;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.upcoming_fs_promo_id;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
        GroupBuyInfo groupBuyInfo = this.group_buy_info;
        int hashCode11 = (hashCode10 + (groupBuyInfo != null ? groupBuyInfo.hashCode() : 0)) * 37;
        Integer num8 = this.low_stock_threshold;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.sustain_days_threshold;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str = this.gtin;
        int hashCode14 = (hashCode13 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num10 = this.shop_id;
        int hashCode15 = (hashCode14 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.current_allocated_stock;
        if (num11 != null) {
            i2 = num11.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemModelExtInfo> {
        public Integer current_allocated_stock;
        public GroupBuyInfo group_buy_info;
        public String gtin;
        public Boolean has_shopee_promo;
        public Integer holiday_mode_old_stock;
        public Integer low_stock_threshold;
        public Integer promo_source;
        public Integer seller_promotion_limit;
        public Integer seller_promotion_refresh_time;
        public Integer shop_id;
        public Integer stock_before_discount;
        public Integer stockout_time;
        public Integer sustain_days_threshold;
        public List<Integer> tier_index;
        public Integer total_stock_for_discount;
        public Long upcoming_fs_promo_id;

        public Builder() {
        }

        public Builder(ItemModelExtInfo itemModelExtInfo) {
            super(itemModelExtInfo);
            if (itemModelExtInfo != null) {
                this.seller_promotion_limit = itemModelExtInfo.seller_promotion_limit;
                this.seller_promotion_refresh_time = itemModelExtInfo.seller_promotion_refresh_time;
                this.holiday_mode_old_stock = itemModelExtInfo.holiday_mode_old_stock;
                this.has_shopee_promo = itemModelExtInfo.has_shopee_promo;
                this.promo_source = itemModelExtInfo.promo_source;
                this.stock_before_discount = itemModelExtInfo.stock_before_discount;
                this.total_stock_for_discount = itemModelExtInfo.total_stock_for_discount;
                this.stockout_time = itemModelExtInfo.stockout_time;
                this.tier_index = ItemModelExtInfo.copyOf(itemModelExtInfo.tier_index);
                this.upcoming_fs_promo_id = itemModelExtInfo.upcoming_fs_promo_id;
                this.group_buy_info = itemModelExtInfo.group_buy_info;
                this.low_stock_threshold = itemModelExtInfo.low_stock_threshold;
                this.sustain_days_threshold = itemModelExtInfo.sustain_days_threshold;
                this.gtin = itemModelExtInfo.gtin;
                this.shop_id = itemModelExtInfo.shop_id;
                this.current_allocated_stock = itemModelExtInfo.current_allocated_stock;
            }
        }

        public Builder seller_promotion_limit(Integer num) {
            this.seller_promotion_limit = num;
            return this;
        }

        public Builder seller_promotion_refresh_time(Integer num) {
            this.seller_promotion_refresh_time = num;
            return this;
        }

        public Builder holiday_mode_old_stock(Integer num) {
            this.holiday_mode_old_stock = num;
            return this;
        }

        public Builder has_shopee_promo(Boolean bool) {
            this.has_shopee_promo = bool;
            return this;
        }

        public Builder promo_source(Integer num) {
            this.promo_source = num;
            return this;
        }

        public Builder stock_before_discount(Integer num) {
            this.stock_before_discount = num;
            return this;
        }

        public Builder total_stock_for_discount(Integer num) {
            this.total_stock_for_discount = num;
            return this;
        }

        public Builder stockout_time(Integer num) {
            this.stockout_time = num;
            return this;
        }

        public Builder tier_index(List<Integer> list) {
            this.tier_index = checkForNulls(list);
            return this;
        }

        public Builder upcoming_fs_promo_id(Long l) {
            this.upcoming_fs_promo_id = l;
            return this;
        }

        public Builder group_buy_info(GroupBuyInfo groupBuyInfo) {
            this.group_buy_info = groupBuyInfo;
            return this;
        }

        public Builder low_stock_threshold(Integer num) {
            this.low_stock_threshold = num;
            return this;
        }

        public Builder sustain_days_threshold(Integer num) {
            this.sustain_days_threshold = num;
            return this;
        }

        public Builder gtin(String str) {
            this.gtin = str;
            return this;
        }

        public Builder shop_id(Integer num) {
            this.shop_id = num;
            return this;
        }

        public Builder current_allocated_stock(Integer num) {
            this.current_allocated_stock = num;
            return this;
        }

        public ItemModelExtInfo build() {
            return new ItemModelExtInfo(this);
        }
    }
}
