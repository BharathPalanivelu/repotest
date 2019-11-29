package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class ItemExtInfo extends Message {
    public static final Long DEFAULT_ADD_ON_DEAL_ID = 0L;
    public static final Integer DEFAULT_ATTR_STATUS = 0;
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final Boolean DEFAULT_CAN_USE_BUNDLE_SALE = false;
    public static final Boolean DEFAULT_CAN_USE_WHOLESALE = false;
    public static final List<SubCategory> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final List<CategoryPath> DEFAULT_CATS = Collections.emptyList();
    public static final List<CategoryPath> DEFAULT_CATS_RECOMMEND = Collections.emptyList();
    public static final Integer DEFAULT_CAT_STATUS = 0;
    public static final Integer DEFAULT_CURRENT_ALLOCATED_STOCK = 0;
    public static final String DEFAULT_DIMENSION = "";
    public static final String DEFAULT_DISPLAY_DIMENSION = "";
    public static final String DEFAULT_DISPLAY_SHIPPING_FEE = "";
    public static final String DEFAULT_DISPLAY_WEIGHT = "";
    public static final Integer DEFAULT_ESTIMATED_DAYS = 0;
    public static final Boolean DEFAULT_FOR_NEW_USER_ONLY = false;
    public static final Integer DEFAULT_FS_STOCKOUT_TIME = 0;
    public static final String DEFAULT_GTIN = "";
    public static final Boolean DEFAULT_HAS_LOWEST_PRICE_GUARANTEE = false;
    public static final Boolean DEFAULT_HAS_SHOPEE_PROMO = false;
    public static final Integer DEFAULT_HOLIDAY_MODE_OLD_STOCK = 0;
    public static final String DEFAULT_INSTAGRAM_MEDIA_ID = "";
    public static final Boolean DEFAULT_IS_PRE_ORDER = false;
    public static final Boolean DEFAULT_IS_SLASH_PRICE = false;
    public static final Integer DEFAULT_ITEM_QC_STATUS = 0;
    public static final Integer DEFAULT_ITEM_TYPE = 0;
    public static final List<Long> DEFAULT_LABEL_IDS = Collections.emptyList();
    public static final f DEFAULT_LOGISTICS_INFO = f.f32736b;
    public static final Integer DEFAULT_LOW_STOCK_THRESHOLD = 0;
    public static final Integer DEFAULT_MODEL_DISCOUNT = 0;
    public static final Boolean DEFAULT_NON_RESTOCK = false;
    public static final Integer DEFAULT_PREVIEW_END_TIME = 0;
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Long DEFAULT_PRICE_MAX_BEFORE_DISCOUNT = 0L;
    public static final Long DEFAULT_PRICE_MIN_BEFORE_DISCOUNT = 0L;
    public static final Long DEFAULT_PRICE_MIN_BEFORE_DISCOUNT_SP = 0L;
    public static final Long DEFAULT_PRICE_MIN_SP = 0L;
    public static final Integer DEFAULT_PROMO_SOURCE = 0;
    public static final Long DEFAULT_REBATE_PRICE = 0L;
    public static final String DEFAULT_REFERENCE_ITEM_ID = "";
    public static final RequestSource DEFAULT_REQUEST_SOURCE = RequestSource.FROM_UNKNOWN;
    public static final Long DEFAULT_SELLER_PROMOTIONID = 0L;
    public static final Integer DEFAULT_SELLER_PROMOTION_LIMIT = 0;
    public static final Integer DEFAULT_SELLER_PROMOTION_REFRESH_TIME = 0;
    public static final Integer DEFAULT_SHOW_DISCOUNT = 0;
    public static final String DEFAULT_SIZE_CHART = "";
    public static final Integer DEFAULT_STOCK_BEFORE_DISCOUNT = 0;
    public static final Integer DEFAULT_SUSTAIN_DAYS_THRESHOLD = 0;
    public static final List<TierVariation> DEFAULT_TIER_VARIATION = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL_STOCK_FOR_DISCOUNT = 0;
    public static final String DEFAULT_TRANSPARENT_BACKGROUND_IMAGE = "";
    public static final Long DEFAULT_UPCOMING_FS_PROMO_ID = 0L;
    public static final List<VideoInfo> DEFAULT_VIDEO_INFO_LIST = Collections.emptyList();
    public static final Long DEFAULT_WEIGHT = 0L;
    public static final Integer DEFAULT_WELCOME_PACKAGE_TYPE = 0;
    public static final List<WholesaleTier> DEFAULT_WHOLESALE_TIER_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 55, type = Message.Datatype.UINT64)
    public final Long add_on_deal_id;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer attr_status;
    @ProtoField(tag = 19)
    public final AttributeSnapshot attributes;
    @ProtoField(tag = 39, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 40, type = Message.Datatype.BOOL)
    public final Boolean can_use_bundle_sale;
    @ProtoField(tag = 25, type = Message.Datatype.BOOL)
    public final Boolean can_use_wholesale;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer cat_status;
    @ProtoField(label = Message.Label.REPEATED, messageType = SubCategory.class, tag = 8)
    public final List<SubCategory> categories;
    @ProtoField(label = Message.Label.REPEATED, messageType = CategoryPath.class, tag = 14)
    public final List<CategoryPath> cats;
    @ProtoField(label = Message.Label.REPEATED, messageType = CategoryPath.class, tag = 37)
    public final List<CategoryPath> cats_recommend;
    @ProtoField(tag = 61, type = Message.Datatype.UINT32)
    public final Integer current_allocated_stock;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String dimension;
    @ProtoField(tag = 32)
    public final ItemDimensions dimensions;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String display_dimension;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String display_shipping_fee;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String display_weight;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer estimated_days;
    @ProtoField(tag = 48, type = Message.Datatype.BOOL)
    public final Boolean for_new_user_only;
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer fs_stockout_time;
    @ProtoField(tag = 44)
    public final GroupBuyInfo group_buy_info;
    @ProtoField(tag = 56, type = Message.Datatype.STRING)
    public final String gtin;
    @ProtoField(tag = 38, type = Message.Datatype.BOOL)
    public final Boolean has_lowest_price_guarantee;
    @ProtoField(tag = 20, type = Message.Datatype.BOOL)
    public final Boolean has_shopee_promo;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer holiday_mode_old_stock;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String instagram_media_id;
    @ProtoField(tag = 27, type = Message.Datatype.BOOL)
    public final Boolean is_pre_order;
    @ProtoField(tag = 54, type = Message.Datatype.BOOL)
    public final Boolean is_slash_price;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer item_qc_status;
    @ProtoField(tag = 16)
    public final ItemRating item_rating;
    @ProtoField(tag = 57, type = Message.Datatype.UINT32)
    public final Integer item_type;
    @ProtoField(label = Message.Label.REPEATED, tag = 50, type = Message.Datatype.INT64)
    public final List<Long> label_ids;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f logistics_info;
    @ProtoField(tag = 52, type = Message.Datatype.INT32)
    public final Integer low_stock_threshold;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer model_discount;
    @ProtoField(tag = 46, type = Message.Datatype.BOOL)
    public final Boolean non_restock;
    @ProtoField(tag = 47, type = Message.Datatype.INT32)
    public final Integer preview_end_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long price_max_before_discount;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long price_min_before_discount;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long price_min_before_discount_sp;
    @ProtoField(tag = 21, type = Message.Datatype.INT64)
    public final Long price_min_sp;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer promo_source;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long rebate_price;
    @ProtoField(tag = 58, type = Message.Datatype.STRING)
    public final String reference_item_id;
    @ProtoField(tag = 41, type = Message.Datatype.ENUM)
    public final RequestSource request_source;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer seller_promotion_limit;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer seller_promotion_refresh_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long seller_promotionid;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer show_discount;
    @ProtoField(tag = 49, type = Message.Datatype.STRING)
    public final String size_chart;
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer stock_before_discount;
    @ProtoField(tag = 53, type = Message.Datatype.INT32)
    public final Integer sustain_days_threshold;
    @ProtoField(label = Message.Label.REPEATED, messageType = TierVariation.class, tag = 42)
    public final List<TierVariation> tier_variation;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer total_stock_for_discount;
    @ProtoField(tag = 60, type = Message.Datatype.STRING)
    public final String transparent_background_image;
    @ProtoField(tag = 43, type = Message.Datatype.INT64)
    public final Long upcoming_fs_promo_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = VideoInfo.class, tag = 18)
    public final List<VideoInfo> video_info_list;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long weight;
    @ProtoField(tag = 51, type = Message.Datatype.INT32)
    public final Integer welcome_package_type;
    @ProtoField(label = Message.Label.REPEATED, messageType = WholesaleTier.class, tag = 24)
    public final List<WholesaleTier> wholesale_tier_list;

    public ItemExtInfo(Integer num, Long l, f fVar, Long l2, String str, String str2, Long l3, List<SubCategory> list, Long l4, Long l5, Integer num2, Integer num3, Integer num4, List<CategoryPath> list2, Long l6, ItemRating itemRating, Integer num5, List<VideoInfo> list3, AttributeSnapshot attributeSnapshot, Boolean bool, Long l7, Long l8, Integer num6, List<WholesaleTier> list4, Boolean bool2, String str3, Boolean bool3, Integer num7, String str4, String str5, Integer num8, ItemDimensions itemDimensions, Integer num9, Integer num10, Integer num11, Integer num12, List<CategoryPath> list5, Boolean bool4, Long l9, Boolean bool5, RequestSource requestSource, List<TierVariation> list6, Long l10, GroupBuyInfo groupBuyInfo, Integer num13, Boolean bool6, Integer num14, Boolean bool7, String str6, List<Long> list7, Integer num15, Integer num16, Integer num17, Boolean bool8, Long l11, String str7, Integer num18, String str8, String str9, Integer num19) {
        this.estimated_days = num;
        this.price_before_discount = l;
        this.logistics_info = fVar;
        this.seller_promotionid = l2;
        this.display_shipping_fee = str;
        this.instagram_media_id = str2;
        this.rebate_price = l3;
        this.categories = immutableCopyOf(list);
        this.price_min_before_discount = l4;
        this.price_max_before_discount = l5;
        this.seller_promotion_limit = num2;
        this.model_discount = num3;
        this.seller_promotion_refresh_time = num4;
        this.cats = immutableCopyOf(list2);
        this.weight = l6;
        this.item_rating = itemRating;
        this.holiday_mode_old_stock = num5;
        this.video_info_list = immutableCopyOf(list3);
        this.attributes = attributeSnapshot;
        this.has_shopee_promo = bool;
        this.price_min_sp = l7;
        this.price_min_before_discount_sp = l8;
        this.show_discount = num6;
        this.wholesale_tier_list = immutableCopyOf(list4);
        this.can_use_wholesale = bool2;
        this.display_weight = str3;
        this.is_pre_order = bool3;
        this.attr_status = num7;
        this.dimension = str4;
        this.display_dimension = str5;
        this.item_qc_status = num8;
        this.dimensions = itemDimensions;
        this.promo_source = num9;
        this.stock_before_discount = num10;
        this.total_stock_for_discount = num11;
        this.cat_status = num12;
        this.cats_recommend = immutableCopyOf(list5);
        this.has_lowest_price_guarantee = bool4;
        this.bundle_deal_id = l9;
        this.can_use_bundle_sale = bool5;
        this.request_source = requestSource;
        this.tier_variation = immutableCopyOf(list6);
        this.upcoming_fs_promo_id = l10;
        this.group_buy_info = groupBuyInfo;
        this.fs_stockout_time = num13;
        this.non_restock = bool6;
        this.preview_end_time = num14;
        this.for_new_user_only = bool7;
        this.size_chart = str6;
        this.label_ids = immutableCopyOf(list7);
        this.welcome_package_type = num15;
        this.low_stock_threshold = num16;
        this.sustain_days_threshold = num17;
        this.is_slash_price = bool8;
        this.add_on_deal_id = l11;
        this.gtin = str7;
        this.item_type = num18;
        this.reference_item_id = str8;
        this.transparent_background_image = str9;
        this.current_allocated_stock = num19;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ItemExtInfo(com.shopee.protocol.shop.ItemExtInfo.Builder r64) {
        /*
            r63 = this;
            r0 = r64
            r1 = r63
            java.lang.Integer r2 = r0.estimated_days
            java.lang.Long r3 = r0.price_before_discount
            e.f r4 = r0.logistics_info
            java.lang.Long r5 = r0.seller_promotionid
            java.lang.String r6 = r0.display_shipping_fee
            java.lang.String r7 = r0.instagram_media_id
            java.lang.Long r8 = r0.rebate_price
            java.util.List<com.shopee.protocol.shop.SubCategory> r9 = r0.categories
            java.lang.Long r10 = r0.price_min_before_discount
            java.lang.Long r11 = r0.price_max_before_discount
            java.lang.Integer r12 = r0.seller_promotion_limit
            java.lang.Integer r13 = r0.model_discount
            java.lang.Integer r14 = r0.seller_promotion_refresh_time
            java.util.List<com.shopee.protocol.shop.CategoryPath> r15 = r0.cats
            r62 = r1
            java.lang.Long r1 = r0.weight
            r16 = r1
            com.shopee.protocol.shop.ItemRating r1 = r0.item_rating
            r17 = r1
            java.lang.Integer r1 = r0.holiday_mode_old_stock
            r18 = r1
            java.util.List<com.shopee.protocol.shop.VideoInfo> r1 = r0.video_info_list
            r19 = r1
            com.shopee.protocol.shop.AttributeSnapshot r1 = r0.attributes
            r20 = r1
            java.lang.Boolean r1 = r0.has_shopee_promo
            r21 = r1
            java.lang.Long r1 = r0.price_min_sp
            r22 = r1
            java.lang.Long r1 = r0.price_min_before_discount_sp
            r23 = r1
            java.lang.Integer r1 = r0.show_discount
            r24 = r1
            java.util.List<com.shopee.protocol.shop.WholesaleTier> r1 = r0.wholesale_tier_list
            r25 = r1
            java.lang.Boolean r1 = r0.can_use_wholesale
            r26 = r1
            java.lang.String r1 = r0.display_weight
            r27 = r1
            java.lang.Boolean r1 = r0.is_pre_order
            r28 = r1
            java.lang.Integer r1 = r0.attr_status
            r29 = r1
            java.lang.String r1 = r0.dimension
            r30 = r1
            java.lang.String r1 = r0.display_dimension
            r31 = r1
            java.lang.Integer r1 = r0.item_qc_status
            r32 = r1
            com.shopee.protocol.shop.ItemDimensions r1 = r0.dimensions
            r33 = r1
            java.lang.Integer r1 = r0.promo_source
            r34 = r1
            java.lang.Integer r1 = r0.stock_before_discount
            r35 = r1
            java.lang.Integer r1 = r0.total_stock_for_discount
            r36 = r1
            java.lang.Integer r1 = r0.cat_status
            r37 = r1
            java.util.List<com.shopee.protocol.shop.CategoryPath> r1 = r0.cats_recommend
            r38 = r1
            java.lang.Boolean r1 = r0.has_lowest_price_guarantee
            r39 = r1
            java.lang.Long r1 = r0.bundle_deal_id
            r40 = r1
            java.lang.Boolean r1 = r0.can_use_bundle_sale
            r41 = r1
            com.shopee.protocol.shop.RequestSource r1 = r0.request_source
            r42 = r1
            java.util.List<com.shopee.protocol.shop.TierVariation> r1 = r0.tier_variation
            r43 = r1
            java.lang.Long r1 = r0.upcoming_fs_promo_id
            r44 = r1
            com.shopee.protocol.shop.GroupBuyInfo r1 = r0.group_buy_info
            r45 = r1
            java.lang.Integer r1 = r0.fs_stockout_time
            r46 = r1
            java.lang.Boolean r1 = r0.non_restock
            r47 = r1
            java.lang.Integer r1 = r0.preview_end_time
            r48 = r1
            java.lang.Boolean r1 = r0.for_new_user_only
            r49 = r1
            java.lang.String r1 = r0.size_chart
            r50 = r1
            java.util.List<java.lang.Long> r1 = r0.label_ids
            r51 = r1
            java.lang.Integer r1 = r0.welcome_package_type
            r52 = r1
            java.lang.Integer r1 = r0.low_stock_threshold
            r53 = r1
            java.lang.Integer r1 = r0.sustain_days_threshold
            r54 = r1
            java.lang.Boolean r1 = r0.is_slash_price
            r55 = r1
            java.lang.Long r1 = r0.add_on_deal_id
            r56 = r1
            java.lang.String r1 = r0.gtin
            r57 = r1
            java.lang.Integer r1 = r0.item_type
            r58 = r1
            java.lang.String r1 = r0.reference_item_id
            r59 = r1
            java.lang.String r1 = r0.transparent_background_image
            r60 = r1
            java.lang.Integer r1 = r0.current_allocated_stock
            r61 = r1
            r1 = r62
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61)
            r63.setBuilder(r64)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ItemExtInfo.<init>(com.shopee.protocol.shop.ItemExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemExtInfo)) {
            return false;
        }
        ItemExtInfo itemExtInfo = (ItemExtInfo) obj;
        if (!equals((Object) this.estimated_days, (Object) itemExtInfo.estimated_days) || !equals((Object) this.price_before_discount, (Object) itemExtInfo.price_before_discount) || !equals((Object) this.logistics_info, (Object) itemExtInfo.logistics_info) || !equals((Object) this.seller_promotionid, (Object) itemExtInfo.seller_promotionid) || !equals((Object) this.display_shipping_fee, (Object) itemExtInfo.display_shipping_fee) || !equals((Object) this.instagram_media_id, (Object) itemExtInfo.instagram_media_id) || !equals((Object) this.rebate_price, (Object) itemExtInfo.rebate_price) || !equals((List<?>) this.categories, (List<?>) itemExtInfo.categories) || !equals((Object) this.price_min_before_discount, (Object) itemExtInfo.price_min_before_discount) || !equals((Object) this.price_max_before_discount, (Object) itemExtInfo.price_max_before_discount) || !equals((Object) this.seller_promotion_limit, (Object) itemExtInfo.seller_promotion_limit) || !equals((Object) this.model_discount, (Object) itemExtInfo.model_discount) || !equals((Object) this.seller_promotion_refresh_time, (Object) itemExtInfo.seller_promotion_refresh_time) || !equals((List<?>) this.cats, (List<?>) itemExtInfo.cats) || !equals((Object) this.weight, (Object) itemExtInfo.weight) || !equals((Object) this.item_rating, (Object) itemExtInfo.item_rating) || !equals((Object) this.holiday_mode_old_stock, (Object) itemExtInfo.holiday_mode_old_stock) || !equals((List<?>) this.video_info_list, (List<?>) itemExtInfo.video_info_list) || !equals((Object) this.attributes, (Object) itemExtInfo.attributes) || !equals((Object) this.has_shopee_promo, (Object) itemExtInfo.has_shopee_promo) || !equals((Object) this.price_min_sp, (Object) itemExtInfo.price_min_sp) || !equals((Object) this.price_min_before_discount_sp, (Object) itemExtInfo.price_min_before_discount_sp) || !equals((Object) this.show_discount, (Object) itemExtInfo.show_discount) || !equals((List<?>) this.wholesale_tier_list, (List<?>) itemExtInfo.wholesale_tier_list) || !equals((Object) this.can_use_wholesale, (Object) itemExtInfo.can_use_wholesale) || !equals((Object) this.display_weight, (Object) itemExtInfo.display_weight) || !equals((Object) this.is_pre_order, (Object) itemExtInfo.is_pre_order) || !equals((Object) this.attr_status, (Object) itemExtInfo.attr_status) || !equals((Object) this.dimension, (Object) itemExtInfo.dimension) || !equals((Object) this.display_dimension, (Object) itemExtInfo.display_dimension) || !equals((Object) this.item_qc_status, (Object) itemExtInfo.item_qc_status) || !equals((Object) this.dimensions, (Object) itemExtInfo.dimensions) || !equals((Object) this.promo_source, (Object) itemExtInfo.promo_source) || !equals((Object) this.stock_before_discount, (Object) itemExtInfo.stock_before_discount) || !equals((Object) this.total_stock_for_discount, (Object) itemExtInfo.total_stock_for_discount) || !equals((Object) this.cat_status, (Object) itemExtInfo.cat_status) || !equals((List<?>) this.cats_recommend, (List<?>) itemExtInfo.cats_recommend) || !equals((Object) this.has_lowest_price_guarantee, (Object) itemExtInfo.has_lowest_price_guarantee) || !equals((Object) this.bundle_deal_id, (Object) itemExtInfo.bundle_deal_id) || !equals((Object) this.can_use_bundle_sale, (Object) itemExtInfo.can_use_bundle_sale) || !equals((Object) this.request_source, (Object) itemExtInfo.request_source) || !equals((List<?>) this.tier_variation, (List<?>) itemExtInfo.tier_variation) || !equals((Object) this.upcoming_fs_promo_id, (Object) itemExtInfo.upcoming_fs_promo_id) || !equals((Object) this.group_buy_info, (Object) itemExtInfo.group_buy_info) || !equals((Object) this.fs_stockout_time, (Object) itemExtInfo.fs_stockout_time) || !equals((Object) this.non_restock, (Object) itemExtInfo.non_restock) || !equals((Object) this.preview_end_time, (Object) itemExtInfo.preview_end_time) || !equals((Object) this.for_new_user_only, (Object) itemExtInfo.for_new_user_only) || !equals((Object) this.size_chart, (Object) itemExtInfo.size_chart) || !equals((List<?>) this.label_ids, (List<?>) itemExtInfo.label_ids) || !equals((Object) this.welcome_package_type, (Object) itemExtInfo.welcome_package_type) || !equals((Object) this.low_stock_threshold, (Object) itemExtInfo.low_stock_threshold) || !equals((Object) this.sustain_days_threshold, (Object) itemExtInfo.sustain_days_threshold) || !equals((Object) this.is_slash_price, (Object) itemExtInfo.is_slash_price) || !equals((Object) this.add_on_deal_id, (Object) itemExtInfo.add_on_deal_id) || !equals((Object) this.gtin, (Object) itemExtInfo.gtin) || !equals((Object) this.item_type, (Object) itemExtInfo.item_type) || !equals((Object) this.reference_item_id, (Object) itemExtInfo.reference_item_id) || !equals((Object) this.transparent_background_image, (Object) itemExtInfo.transparent_background_image) || !equals((Object) this.current_allocated_stock, (Object) itemExtInfo.current_allocated_stock)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.estimated_days;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.price_before_discount;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        f fVar = this.logistics_info;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l2 = this.seller_promotionid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.display_shipping_fee;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.instagram_media_id;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l3 = this.rebate_price;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        List<SubCategory> list = this.categories;
        int i3 = 1;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        Long l4 = this.price_min_before_discount;
        int hashCode9 = (hashCode8 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.price_max_before_discount;
        int hashCode10 = (hashCode9 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num2 = this.seller_promotion_limit;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.model_discount;
        int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.seller_promotion_refresh_time;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 37;
        List<CategoryPath> list2 = this.cats;
        int hashCode14 = (hashCode13 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Long l6 = this.weight;
        int hashCode15 = (hashCode14 + (l6 != null ? l6.hashCode() : 0)) * 37;
        ItemRating itemRating = this.item_rating;
        int hashCode16 = (hashCode15 + (itemRating != null ? itemRating.hashCode() : 0)) * 37;
        Integer num5 = this.holiday_mode_old_stock;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<VideoInfo> list3 = this.video_info_list;
        int hashCode18 = (hashCode17 + (list3 != null ? list3.hashCode() : 1)) * 37;
        AttributeSnapshot attributeSnapshot = this.attributes;
        int hashCode19 = (hashCode18 + (attributeSnapshot != null ? attributeSnapshot.hashCode() : 0)) * 37;
        Boolean bool = this.has_shopee_promo;
        int hashCode20 = (hashCode19 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l7 = this.price_min_sp;
        int hashCode21 = (hashCode20 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.price_min_before_discount_sp;
        int hashCode22 = (hashCode21 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Integer num6 = this.show_discount;
        int hashCode23 = (hashCode22 + (num6 != null ? num6.hashCode() : 0)) * 37;
        List<WholesaleTier> list4 = this.wholesale_tier_list;
        int hashCode24 = (hashCode23 + (list4 != null ? list4.hashCode() : 1)) * 37;
        Boolean bool2 = this.can_use_wholesale;
        int hashCode25 = (hashCode24 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str3 = this.display_weight;
        int hashCode26 = (hashCode25 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_pre_order;
        int hashCode27 = (hashCode26 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num7 = this.attr_status;
        int hashCode28 = (hashCode27 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str4 = this.dimension;
        int hashCode29 = (hashCode28 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.display_dimension;
        int hashCode30 = (hashCode29 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num8 = this.item_qc_status;
        int hashCode31 = (hashCode30 + (num8 != null ? num8.hashCode() : 0)) * 37;
        ItemDimensions itemDimensions = this.dimensions;
        int hashCode32 = (hashCode31 + (itemDimensions != null ? itemDimensions.hashCode() : 0)) * 37;
        Integer num9 = this.promo_source;
        int hashCode33 = (hashCode32 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.stock_before_discount;
        int hashCode34 = (hashCode33 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.total_stock_for_discount;
        int hashCode35 = (hashCode34 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.cat_status;
        int hashCode36 = (hashCode35 + (num12 != null ? num12.hashCode() : 0)) * 37;
        List<CategoryPath> list5 = this.cats_recommend;
        int hashCode37 = (hashCode36 + (list5 != null ? list5.hashCode() : 1)) * 37;
        Boolean bool4 = this.has_lowest_price_guarantee;
        int hashCode38 = (hashCode37 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Long l9 = this.bundle_deal_id;
        int hashCode39 = (hashCode38 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Boolean bool5 = this.can_use_bundle_sale;
        int hashCode40 = (hashCode39 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        RequestSource requestSource = this.request_source;
        int hashCode41 = (hashCode40 + (requestSource != null ? requestSource.hashCode() : 0)) * 37;
        List<TierVariation> list6 = this.tier_variation;
        int hashCode42 = (hashCode41 + (list6 != null ? list6.hashCode() : 1)) * 37;
        Long l10 = this.upcoming_fs_promo_id;
        int hashCode43 = (hashCode42 + (l10 != null ? l10.hashCode() : 0)) * 37;
        GroupBuyInfo groupBuyInfo = this.group_buy_info;
        int hashCode44 = (hashCode43 + (groupBuyInfo != null ? groupBuyInfo.hashCode() : 0)) * 37;
        Integer num13 = this.fs_stockout_time;
        int hashCode45 = (hashCode44 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Boolean bool6 = this.non_restock;
        int hashCode46 = (hashCode45 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num14 = this.preview_end_time;
        int hashCode47 = (hashCode46 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Boolean bool7 = this.for_new_user_only;
        int hashCode48 = (hashCode47 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        String str6 = this.size_chart;
        int hashCode49 = (hashCode48 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<Long> list7 = this.label_ids;
        if (list7 != null) {
            i3 = list7.hashCode();
        }
        int i4 = (hashCode49 + i3) * 37;
        Integer num15 = this.welcome_package_type;
        int hashCode50 = (i4 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.low_stock_threshold;
        int hashCode51 = (hashCode50 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.sustain_days_threshold;
        int hashCode52 = (hashCode51 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Boolean bool8 = this.is_slash_price;
        int hashCode53 = (hashCode52 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Long l11 = this.add_on_deal_id;
        int hashCode54 = (hashCode53 + (l11 != null ? l11.hashCode() : 0)) * 37;
        String str7 = this.gtin;
        int hashCode55 = (hashCode54 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num18 = this.item_type;
        int hashCode56 = (hashCode55 + (num18 != null ? num18.hashCode() : 0)) * 37;
        String str8 = this.reference_item_id;
        int hashCode57 = (hashCode56 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.transparent_background_image;
        int hashCode58 = (hashCode57 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num19 = this.current_allocated_stock;
        if (num19 != null) {
            i2 = num19.hashCode();
        }
        int i5 = hashCode58 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ItemExtInfo> {
        public Long add_on_deal_id;
        public Integer attr_status;
        public AttributeSnapshot attributes;
        public Long bundle_deal_id;
        public Boolean can_use_bundle_sale;
        public Boolean can_use_wholesale;
        public Integer cat_status;
        public List<SubCategory> categories;
        public List<CategoryPath> cats;
        public List<CategoryPath> cats_recommend;
        public Integer current_allocated_stock;
        public String dimension;
        public ItemDimensions dimensions;
        public String display_dimension;
        public String display_shipping_fee;
        public String display_weight;
        public Integer estimated_days;
        public Boolean for_new_user_only;
        public Integer fs_stockout_time;
        public GroupBuyInfo group_buy_info;
        public String gtin;
        public Boolean has_lowest_price_guarantee;
        public Boolean has_shopee_promo;
        public Integer holiday_mode_old_stock;
        public String instagram_media_id;
        public Boolean is_pre_order;
        public Boolean is_slash_price;
        public Integer item_qc_status;
        public ItemRating item_rating;
        public Integer item_type;
        public List<Long> label_ids;
        public f logistics_info;
        public Integer low_stock_threshold;
        public Integer model_discount;
        public Boolean non_restock;
        public Integer preview_end_time;
        public Long price_before_discount;
        public Long price_max_before_discount;
        public Long price_min_before_discount;
        public Long price_min_before_discount_sp;
        public Long price_min_sp;
        public Integer promo_source;
        public Long rebate_price;
        public String reference_item_id;
        public RequestSource request_source;
        public Integer seller_promotion_limit;
        public Integer seller_promotion_refresh_time;
        public Long seller_promotionid;
        public Integer show_discount;
        public String size_chart;
        public Integer stock_before_discount;
        public Integer sustain_days_threshold;
        public List<TierVariation> tier_variation;
        public Integer total_stock_for_discount;
        public String transparent_background_image;
        public Long upcoming_fs_promo_id;
        public List<VideoInfo> video_info_list;
        public Long weight;
        public Integer welcome_package_type;
        public List<WholesaleTier> wholesale_tier_list;

        public Builder() {
        }

        public Builder(ItemExtInfo itemExtInfo) {
            super(itemExtInfo);
            if (itemExtInfo != null) {
                this.estimated_days = itemExtInfo.estimated_days;
                this.price_before_discount = itemExtInfo.price_before_discount;
                this.logistics_info = itemExtInfo.logistics_info;
                this.seller_promotionid = itemExtInfo.seller_promotionid;
                this.display_shipping_fee = itemExtInfo.display_shipping_fee;
                this.instagram_media_id = itemExtInfo.instagram_media_id;
                this.rebate_price = itemExtInfo.rebate_price;
                this.categories = ItemExtInfo.copyOf(itemExtInfo.categories);
                this.price_min_before_discount = itemExtInfo.price_min_before_discount;
                this.price_max_before_discount = itemExtInfo.price_max_before_discount;
                this.seller_promotion_limit = itemExtInfo.seller_promotion_limit;
                this.model_discount = itemExtInfo.model_discount;
                this.seller_promotion_refresh_time = itemExtInfo.seller_promotion_refresh_time;
                this.cats = ItemExtInfo.copyOf(itemExtInfo.cats);
                this.weight = itemExtInfo.weight;
                this.item_rating = itemExtInfo.item_rating;
                this.holiday_mode_old_stock = itemExtInfo.holiday_mode_old_stock;
                this.video_info_list = ItemExtInfo.copyOf(itemExtInfo.video_info_list);
                this.attributes = itemExtInfo.attributes;
                this.has_shopee_promo = itemExtInfo.has_shopee_promo;
                this.price_min_sp = itemExtInfo.price_min_sp;
                this.price_min_before_discount_sp = itemExtInfo.price_min_before_discount_sp;
                this.show_discount = itemExtInfo.show_discount;
                this.wholesale_tier_list = ItemExtInfo.copyOf(itemExtInfo.wholesale_tier_list);
                this.can_use_wholesale = itemExtInfo.can_use_wholesale;
                this.display_weight = itemExtInfo.display_weight;
                this.is_pre_order = itemExtInfo.is_pre_order;
                this.attr_status = itemExtInfo.attr_status;
                this.dimension = itemExtInfo.dimension;
                this.display_dimension = itemExtInfo.display_dimension;
                this.item_qc_status = itemExtInfo.item_qc_status;
                this.dimensions = itemExtInfo.dimensions;
                this.promo_source = itemExtInfo.promo_source;
                this.stock_before_discount = itemExtInfo.stock_before_discount;
                this.total_stock_for_discount = itemExtInfo.total_stock_for_discount;
                this.cat_status = itemExtInfo.cat_status;
                this.cats_recommend = ItemExtInfo.copyOf(itemExtInfo.cats_recommend);
                this.has_lowest_price_guarantee = itemExtInfo.has_lowest_price_guarantee;
                this.bundle_deal_id = itemExtInfo.bundle_deal_id;
                this.can_use_bundle_sale = itemExtInfo.can_use_bundle_sale;
                this.request_source = itemExtInfo.request_source;
                this.tier_variation = ItemExtInfo.copyOf(itemExtInfo.tier_variation);
                this.upcoming_fs_promo_id = itemExtInfo.upcoming_fs_promo_id;
                this.group_buy_info = itemExtInfo.group_buy_info;
                this.fs_stockout_time = itemExtInfo.fs_stockout_time;
                this.non_restock = itemExtInfo.non_restock;
                this.preview_end_time = itemExtInfo.preview_end_time;
                this.for_new_user_only = itemExtInfo.for_new_user_only;
                this.size_chart = itemExtInfo.size_chart;
                this.label_ids = ItemExtInfo.copyOf(itemExtInfo.label_ids);
                this.welcome_package_type = itemExtInfo.welcome_package_type;
                this.low_stock_threshold = itemExtInfo.low_stock_threshold;
                this.sustain_days_threshold = itemExtInfo.sustain_days_threshold;
                this.is_slash_price = itemExtInfo.is_slash_price;
                this.add_on_deal_id = itemExtInfo.add_on_deal_id;
                this.gtin = itemExtInfo.gtin;
                this.item_type = itemExtInfo.item_type;
                this.reference_item_id = itemExtInfo.reference_item_id;
                this.transparent_background_image = itemExtInfo.transparent_background_image;
                this.current_allocated_stock = itemExtInfo.current_allocated_stock;
            }
        }

        public Builder estimated_days(Integer num) {
            this.estimated_days = num;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder logistics_info(f fVar) {
            this.logistics_info = fVar;
            return this;
        }

        public Builder seller_promotionid(Long l) {
            this.seller_promotionid = l;
            return this;
        }

        public Builder display_shipping_fee(String str) {
            this.display_shipping_fee = str;
            return this;
        }

        public Builder instagram_media_id(String str) {
            this.instagram_media_id = str;
            return this;
        }

        public Builder rebate_price(Long l) {
            this.rebate_price = l;
            return this;
        }

        public Builder categories(List<SubCategory> list) {
            this.categories = checkForNulls(list);
            return this;
        }

        public Builder price_min_before_discount(Long l) {
            this.price_min_before_discount = l;
            return this;
        }

        public Builder price_max_before_discount(Long l) {
            this.price_max_before_discount = l;
            return this;
        }

        public Builder seller_promotion_limit(Integer num) {
            this.seller_promotion_limit = num;
            return this;
        }

        public Builder model_discount(Integer num) {
            this.model_discount = num;
            return this;
        }

        public Builder seller_promotion_refresh_time(Integer num) {
            this.seller_promotion_refresh_time = num;
            return this;
        }

        public Builder cats(List<CategoryPath> list) {
            this.cats = checkForNulls(list);
            return this;
        }

        public Builder weight(Long l) {
            this.weight = l;
            return this;
        }

        public Builder item_rating(ItemRating itemRating) {
            this.item_rating = itemRating;
            return this;
        }

        public Builder holiday_mode_old_stock(Integer num) {
            this.holiday_mode_old_stock = num;
            return this;
        }

        public Builder video_info_list(List<VideoInfo> list) {
            this.video_info_list = checkForNulls(list);
            return this;
        }

        public Builder attributes(AttributeSnapshot attributeSnapshot) {
            this.attributes = attributeSnapshot;
            return this;
        }

        public Builder has_shopee_promo(Boolean bool) {
            this.has_shopee_promo = bool;
            return this;
        }

        public Builder price_min_sp(Long l) {
            this.price_min_sp = l;
            return this;
        }

        public Builder price_min_before_discount_sp(Long l) {
            this.price_min_before_discount_sp = l;
            return this;
        }

        public Builder show_discount(Integer num) {
            this.show_discount = num;
            return this;
        }

        public Builder wholesale_tier_list(List<WholesaleTier> list) {
            this.wholesale_tier_list = checkForNulls(list);
            return this;
        }

        public Builder can_use_wholesale(Boolean bool) {
            this.can_use_wholesale = bool;
            return this;
        }

        public Builder display_weight(String str) {
            this.display_weight = str;
            return this;
        }

        public Builder is_pre_order(Boolean bool) {
            this.is_pre_order = bool;
            return this;
        }

        public Builder attr_status(Integer num) {
            this.attr_status = num;
            return this;
        }

        public Builder dimension(String str) {
            this.dimension = str;
            return this;
        }

        public Builder display_dimension(String str) {
            this.display_dimension = str;
            return this;
        }

        public Builder item_qc_status(Integer num) {
            this.item_qc_status = num;
            return this;
        }

        public Builder dimensions(ItemDimensions itemDimensions) {
            this.dimensions = itemDimensions;
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

        public Builder cat_status(Integer num) {
            this.cat_status = num;
            return this;
        }

        public Builder cats_recommend(List<CategoryPath> list) {
            this.cats_recommend = checkForNulls(list);
            return this;
        }

        public Builder has_lowest_price_guarantee(Boolean bool) {
            this.has_lowest_price_guarantee = bool;
            return this;
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder can_use_bundle_sale(Boolean bool) {
            this.can_use_bundle_sale = bool;
            return this;
        }

        public Builder request_source(RequestSource requestSource) {
            this.request_source = requestSource;
            return this;
        }

        public Builder tier_variation(List<TierVariation> list) {
            this.tier_variation = checkForNulls(list);
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

        public Builder fs_stockout_time(Integer num) {
            this.fs_stockout_time = num;
            return this;
        }

        public Builder non_restock(Boolean bool) {
            this.non_restock = bool;
            return this;
        }

        public Builder preview_end_time(Integer num) {
            this.preview_end_time = num;
            return this;
        }

        public Builder for_new_user_only(Boolean bool) {
            this.for_new_user_only = bool;
            return this;
        }

        public Builder size_chart(String str) {
            this.size_chart = str;
            return this;
        }

        public Builder label_ids(List<Long> list) {
            this.label_ids = checkForNulls(list);
            return this;
        }

        public Builder welcome_package_type(Integer num) {
            this.welcome_package_type = num;
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

        public Builder is_slash_price(Boolean bool) {
            this.is_slash_price = bool;
            return this;
        }

        public Builder add_on_deal_id(Long l) {
            this.add_on_deal_id = l;
            return this;
        }

        public Builder gtin(String str) {
            this.gtin = str;
            return this;
        }

        public Builder item_type(Integer num) {
            this.item_type = num;
            return this;
        }

        public Builder reference_item_id(String str) {
            this.reference_item_id = str;
            return this;
        }

        public Builder transparent_background_image(String str) {
            this.transparent_background_image = str;
            return this;
        }

        public Builder current_allocated_stock(Integer num) {
            this.current_allocated_stock = num;
            return this;
        }

        public ItemExtInfo build() {
            return new ItemExtInfo(this);
        }
    }
}
