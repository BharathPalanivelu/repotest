package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class ShopExtInfo extends Message {
    public static final f DEFAULT_AUTO_REPLY_MSG = f.f32736b;
    public static final Integer DEFAULT_AUTO_REPLY_MTIME = 0;
    public static final Boolean DEFAULT_AUTO_REPLY_ON = false;
    public static final Boolean DEFAULT_BLOCK_CB_USER = false;
    public static final Double DEFAULT_CANCELLATION_RATE;
    public static final Integer DEFAULT_CB_RETURN_ADDRESS_ID = 0;
    public static final Boolean DEFAULT_CHAT_DISABLED = false;
    public static final Integer DEFAULT_COMM_GROUP_ID = 0;
    public static final List<String> DEFAULT_COVERS = Collections.emptyList();
    public static final Boolean DEFAULT_COVERS_BANNED = false;
    public static final f DEFAULT_DEFAULT_ITEM_LOGISTICS_INFO = f.f32736b;
    public static final Boolean DEFAULT_DESCRIPTION_BANNED = false;
    public static final Integer DEFAULT_DISABLE_MAKE_OFFER = 0;
    public static final String DEFAULT_DISPLAY_DEFAULT_SHIPPING_INFO = "";
    public static final Integer DEFAULT_DISPLAY_RESPONSE_RATE = 0;
    public static final Boolean DEFAULT_ENABLE_DISPLAY_UNITNO = false;
    public static final Double DEFAULT_FULFILLMENT_RATE;
    public static final Integer DEFAULT_FULFILLMENT_RATE_FLAG = 0;
    public static final Boolean DEFAULT_HAD_ORDER = false;
    public static final Boolean DEFAULT_HAS_DECORATION = false;
    public static final Boolean DEFAULT_IS_SHIP_FROM_OVERSEAS = false;
    public static final Boolean DEFAULT_IS_SIP_AFFILIATED = false;
    public static final Boolean DEFAULT_IS_SIP_PRIMARY = false;
    public static final List<Long> DEFAULT_LABEL_IDS = Collections.emptyList();
    public static final Integer DEFAULT_LAST_CHANGE_SHOPNAME = 0;
    public static final Integer DEFAULT_LAST_UPDATE_TIME = 0;
    public static final Double DEFAULT_LATE_SHIPMENT_RATE;
    public static final Integer DEFAULT_LATE_SHIPMENT_RATE_FLAG = 0;
    public static final Long DEFAULT_LOGISTICS_FLAG = 0L;
    public static final f DEFAULT_LOGISTICS_INFO = f.f32736b;
    public static final Integer DEFAULT_MAX_VARIATIONS_COUNT = 0;
    public static final Double DEFAULT_NON_FULFILLMENT_RATE;
    public static final Integer DEFAULT_PICKUP_ADDRESS_ID = 0;
    public static final Integer DEFAULT_PREORDER_LISTING_TARGET = 0;
    public static final Double DEFAULT_RATING_STAR;
    public static final Integer DEFAULT_RESPONSE_RATE = 0;
    public static final Integer DEFAULT_RESPONSE_TIME = 0;
    public static final Integer DEFAULT_RETURN_ADDRESS_ID = 0;
    public static final Integer DEFAULT_SELLER_PENALTY_FLAG = 0;
    public static final Integer DEFAULT_SELLER_PENALTY_SCORE = 0;
    public static final Integer DEFAULT_SELLER_PENALTY_TIER = 0;
    public static final Integer DEFAULT_SHOPEE_VERIFIED_FLAG = 0;
    public static final List<ShopCover> DEFAULT_SHOP_COVERS = Collections.emptyList();
    public static final Boolean DEFAULT_STAR_SELLER = false;
    public static final Boolean DEFAULT_STOCK_ALERT_ALLOW = false;
    public static final Boolean DEFAULT_STOCK_ALERT_ON = false;
    public static final Integer DEFAULT_SUSTAIN_DAYS_THRESHOLD = 0;
    public static final Boolean DEFAULT_SYNC_STOCK_FROM_WMS = false;
    public static final Boolean DEFAULT_UPDATE_SHOP_COVERS = false;
    public static final String DEFAULT_VISIBLE_REGIONS = "";
    public static final Integer DEFAULT_WEBCHAT_RESPONSE_RATE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final BuyerAddress address;
    @ProtoField(tag = 18)
    public final ShopAdminInfo admininfo;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f auto_reply_msg;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer auto_reply_mtime;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean auto_reply_on;
    @ProtoField(tag = 60, type = Message.Datatype.BOOL)
    public final Boolean block_cb_user;
    @ProtoField(tag = 53, type = Message.Datatype.DOUBLE)
    public final Double cancellation_rate;
    @ProtoField(tag = 38)
    public final ShopCardTxnFeeSetting card_txn_fee_setting;
    @ProtoField(tag = 46, type = Message.Datatype.INT32)
    public final Integer cb_return_address_id;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean chat_disabled;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer comm_group_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.STRING)
    public final List<String> covers;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean covers_banned;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f default_item_logistics_info;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean description_banned;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer disable_make_offer;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String display_default_shipping_info;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer display_response_rate;
    @ProtoField(tag = 23, type = Message.Datatype.BOOL)
    public final Boolean enable_display_unitno;
    @ProtoField(tag = 35, type = Message.Datatype.DOUBLE)
    public final Double fulfillment_rate;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer fulfillment_rate_flag;
    @ProtoField(tag = 31, type = Message.Datatype.BOOL)
    public final Boolean had_order;
    @ProtoField(tag = 54, type = Message.Datatype.BOOL)
    public final Boolean has_decoration;
    @ProtoField(tag = 58, type = Message.Datatype.BOOL)
    public final Boolean is_ship_from_overseas;
    @ProtoField(tag = 57, type = Message.Datatype.BOOL)
    public final Boolean is_sip_affiliated;
    @ProtoField(tag = 56, type = Message.Datatype.BOOL)
    public final Boolean is_sip_primary;
    @ProtoField(label = Message.Label.REPEATED, tag = 48, type = Message.Datatype.INT64)
    public final List<Long> label_ids;
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer last_change_shopname;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer last_update_time;
    @ProtoField(tag = 44, type = Message.Datatype.DOUBLE)
    public final Double late_shipment_rate;
    @ProtoField(tag = 43, type = Message.Datatype.INT32)
    public final Integer late_shipment_rate_flag;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long logistics_flag;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f logistics_info;
    @ProtoField(tag = 51, type = Message.Datatype.INT32)
    public final Integer max_variations_count;
    @ProtoField(tag = 34, type = Message.Datatype.DOUBLE)
    public final Double non_fulfillment_rate;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer pickup_address_id;
    @ProtoField(tag = 55, type = Message.Datatype.INT32)
    public final Integer preorder_listing_target;
    @ProtoField(tag = 30)
    public final PreparationTime preparation_time;
    @ProtoField(tag = 20, type = Message.Datatype.DOUBLE)
    public final Double rating_star;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer response_rate;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer response_time;
    @ProtoField(tag = 39, type = Message.Datatype.INT32)
    public final Integer return_address_id;
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer seller_penalty_flag;
    @ProtoField(tag = 41, type = Message.Datatype.INT32)
    public final Integer seller_penalty_score;
    @ProtoField(tag = 42, type = Message.Datatype.INT32)
    public final Integer seller_penalty_tier;
    @ProtoField(tag = 27)
    public final SellerRating seller_rating;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopCover.class, tag = 24)
    public final List<ShopCover> shop_covers;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer shopee_verified_flag;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean star_seller;
    @ProtoField(tag = 49, type = Message.Datatype.BOOL)
    public final Boolean stock_alert_allow;
    @ProtoField(tag = 50, type = Message.Datatype.BOOL)
    public final Boolean stock_alert_on;
    @ProtoField(tag = 52, type = Message.Datatype.INT32)
    public final Integer sustain_days_threshold;
    @ProtoField(tag = 47, type = Message.Datatype.BOOL)
    public final Boolean sync_stock_from_wms;
    @ProtoField(tag = 25, type = Message.Datatype.BOOL)
    public final Boolean update_shop_covers;
    @ProtoField(tag = 59, type = Message.Datatype.STRING)
    public final String visible_regions;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer webchat_response_rate;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_RATING_STAR = valueOf;
        DEFAULT_NON_FULFILLMENT_RATE = valueOf;
        DEFAULT_FULFILLMENT_RATE = valueOf;
        DEFAULT_LATE_SHIPMENT_RATE = valueOf;
        DEFAULT_CANCELLATION_RATE = valueOf;
    }

    public ShopExtInfo(BuyerAddress buyerAddress, Integer num, f fVar, Integer num2, String str, Long l, f fVar2, List<String> list, Boolean bool, Boolean bool2, f fVar3, Integer num3, Boolean bool3, Boolean bool4, Integer num4, ShopAdminInfo shopAdminInfo, Integer num5, Double d2, Boolean bool5, Integer num6, Boolean bool6, List<ShopCover> list2, Boolean bool7, Integer num7, SellerRating sellerRating, Integer num8, Integer num9, PreparationTime preparationTime, Boolean bool8, Integer num10, Double d3, Double d4, Integer num11, ShopCardTxnFeeSetting shopCardTxnFeeSetting, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Double d5, Integer num17, Integer num18, Boolean bool9, List<Long> list3, Boolean bool10, Boolean bool11, Integer num19, Integer num20, Double d6, Boolean bool12, Integer num21, Boolean bool13, Boolean bool14, Boolean bool15, String str2, Boolean bool16) {
        this.address = buyerAddress;
        this.disable_make_offer = num;
        this.logistics_info = fVar;
        this.pickup_address_id = num2;
        this.display_default_shipping_info = str;
        this.logistics_flag = l;
        this.default_item_logistics_info = fVar2;
        this.covers = immutableCopyOf(list);
        this.star_seller = bool;
        this.auto_reply_on = bool2;
        this.auto_reply_msg = fVar3;
        this.response_rate = num3;
        this.description_banned = bool3;
        this.covers_banned = bool4;
        this.display_response_rate = num4;
        this.admininfo = shopAdminInfo;
        this.auto_reply_mtime = num5;
        this.rating_star = d2;
        this.chat_disabled = bool5;
        this.response_time = num6;
        this.enable_display_unitno = bool6;
        this.shop_covers = immutableCopyOf(list2);
        this.update_shop_covers = bool7;
        this.last_update_time = num7;
        this.seller_rating = sellerRating;
        this.webchat_response_rate = num8;
        this.shopee_verified_flag = num9;
        this.preparation_time = preparationTime;
        this.had_order = bool8;
        this.fulfillment_rate_flag = num10;
        this.non_fulfillment_rate = d3;
        this.fulfillment_rate = d4;
        this.comm_group_id = num11;
        this.card_txn_fee_setting = shopCardTxnFeeSetting;
        this.return_address_id = num12;
        this.seller_penalty_flag = num13;
        this.seller_penalty_score = num14;
        this.seller_penalty_tier = num15;
        this.late_shipment_rate_flag = num16;
        this.late_shipment_rate = d5;
        this.last_change_shopname = num17;
        this.cb_return_address_id = num18;
        this.sync_stock_from_wms = bool9;
        this.label_ids = immutableCopyOf(list3);
        this.stock_alert_allow = bool10;
        this.stock_alert_on = bool11;
        this.max_variations_count = num19;
        this.sustain_days_threshold = num20;
        this.cancellation_rate = d6;
        this.has_decoration = bool12;
        this.preorder_listing_target = num21;
        this.is_sip_primary = bool13;
        this.is_sip_affiliated = bool14;
        this.is_ship_from_overseas = bool15;
        this.visible_regions = str2;
        this.block_cb_user = bool16;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ShopExtInfo(com.shopee.protocol.shop.ShopExtInfo.Builder r60) {
        /*
            r59 = this;
            r0 = r60
            r1 = r59
            com.shopee.protocol.shop.BuyerAddress r2 = r0.address
            java.lang.Integer r3 = r0.disable_make_offer
            e.f r4 = r0.logistics_info
            java.lang.Integer r5 = r0.pickup_address_id
            java.lang.String r6 = r0.display_default_shipping_info
            java.lang.Long r7 = r0.logistics_flag
            e.f r8 = r0.default_item_logistics_info
            java.util.List<java.lang.String> r9 = r0.covers
            java.lang.Boolean r10 = r0.star_seller
            java.lang.Boolean r11 = r0.auto_reply_on
            e.f r12 = r0.auto_reply_msg
            java.lang.Integer r13 = r0.response_rate
            java.lang.Boolean r14 = r0.description_banned
            java.lang.Boolean r15 = r0.covers_banned
            r58 = r1
            java.lang.Integer r1 = r0.display_response_rate
            r16 = r1
            com.shopee.protocol.shop.ShopAdminInfo r1 = r0.admininfo
            r17 = r1
            java.lang.Integer r1 = r0.auto_reply_mtime
            r18 = r1
            java.lang.Double r1 = r0.rating_star
            r19 = r1
            java.lang.Boolean r1 = r0.chat_disabled
            r20 = r1
            java.lang.Integer r1 = r0.response_time
            r21 = r1
            java.lang.Boolean r1 = r0.enable_display_unitno
            r22 = r1
            java.util.List<com.shopee.protocol.shop.ShopCover> r1 = r0.shop_covers
            r23 = r1
            java.lang.Boolean r1 = r0.update_shop_covers
            r24 = r1
            java.lang.Integer r1 = r0.last_update_time
            r25 = r1
            com.shopee.protocol.shop.SellerRating r1 = r0.seller_rating
            r26 = r1
            java.lang.Integer r1 = r0.webchat_response_rate
            r27 = r1
            java.lang.Integer r1 = r0.shopee_verified_flag
            r28 = r1
            com.shopee.protocol.shop.PreparationTime r1 = r0.preparation_time
            r29 = r1
            java.lang.Boolean r1 = r0.had_order
            r30 = r1
            java.lang.Integer r1 = r0.fulfillment_rate_flag
            r31 = r1
            java.lang.Double r1 = r0.non_fulfillment_rate
            r32 = r1
            java.lang.Double r1 = r0.fulfillment_rate
            r33 = r1
            java.lang.Integer r1 = r0.comm_group_id
            r34 = r1
            com.shopee.protocol.shop.ShopCardTxnFeeSetting r1 = r0.card_txn_fee_setting
            r35 = r1
            java.lang.Integer r1 = r0.return_address_id
            r36 = r1
            java.lang.Integer r1 = r0.seller_penalty_flag
            r37 = r1
            java.lang.Integer r1 = r0.seller_penalty_score
            r38 = r1
            java.lang.Integer r1 = r0.seller_penalty_tier
            r39 = r1
            java.lang.Integer r1 = r0.late_shipment_rate_flag
            r40 = r1
            java.lang.Double r1 = r0.late_shipment_rate
            r41 = r1
            java.lang.Integer r1 = r0.last_change_shopname
            r42 = r1
            java.lang.Integer r1 = r0.cb_return_address_id
            r43 = r1
            java.lang.Boolean r1 = r0.sync_stock_from_wms
            r44 = r1
            java.util.List<java.lang.Long> r1 = r0.label_ids
            r45 = r1
            java.lang.Boolean r1 = r0.stock_alert_allow
            r46 = r1
            java.lang.Boolean r1 = r0.stock_alert_on
            r47 = r1
            java.lang.Integer r1 = r0.max_variations_count
            r48 = r1
            java.lang.Integer r1 = r0.sustain_days_threshold
            r49 = r1
            java.lang.Double r1 = r0.cancellation_rate
            r50 = r1
            java.lang.Boolean r1 = r0.has_decoration
            r51 = r1
            java.lang.Integer r1 = r0.preorder_listing_target
            r52 = r1
            java.lang.Boolean r1 = r0.is_sip_primary
            r53 = r1
            java.lang.Boolean r1 = r0.is_sip_affiliated
            r54 = r1
            java.lang.Boolean r1 = r0.is_ship_from_overseas
            r55 = r1
            java.lang.String r1 = r0.visible_regions
            r56 = r1
            java.lang.Boolean r1 = r0.block_cb_user
            r57 = r1
            r1 = r58
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57)
            r59.setBuilder(r60)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ShopExtInfo.<init>(com.shopee.protocol.shop.ShopExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopExtInfo)) {
            return false;
        }
        ShopExtInfo shopExtInfo = (ShopExtInfo) obj;
        if (!equals((Object) this.address, (Object) shopExtInfo.address) || !equals((Object) this.disable_make_offer, (Object) shopExtInfo.disable_make_offer) || !equals((Object) this.logistics_info, (Object) shopExtInfo.logistics_info) || !equals((Object) this.pickup_address_id, (Object) shopExtInfo.pickup_address_id) || !equals((Object) this.display_default_shipping_info, (Object) shopExtInfo.display_default_shipping_info) || !equals((Object) this.logistics_flag, (Object) shopExtInfo.logistics_flag) || !equals((Object) this.default_item_logistics_info, (Object) shopExtInfo.default_item_logistics_info) || !equals((List<?>) this.covers, (List<?>) shopExtInfo.covers) || !equals((Object) this.star_seller, (Object) shopExtInfo.star_seller) || !equals((Object) this.auto_reply_on, (Object) shopExtInfo.auto_reply_on) || !equals((Object) this.auto_reply_msg, (Object) shopExtInfo.auto_reply_msg) || !equals((Object) this.response_rate, (Object) shopExtInfo.response_rate) || !equals((Object) this.description_banned, (Object) shopExtInfo.description_banned) || !equals((Object) this.covers_banned, (Object) shopExtInfo.covers_banned) || !equals((Object) this.display_response_rate, (Object) shopExtInfo.display_response_rate) || !equals((Object) this.admininfo, (Object) shopExtInfo.admininfo) || !equals((Object) this.auto_reply_mtime, (Object) shopExtInfo.auto_reply_mtime) || !equals((Object) this.rating_star, (Object) shopExtInfo.rating_star) || !equals((Object) this.chat_disabled, (Object) shopExtInfo.chat_disabled) || !equals((Object) this.response_time, (Object) shopExtInfo.response_time) || !equals((Object) this.enable_display_unitno, (Object) shopExtInfo.enable_display_unitno) || !equals((List<?>) this.shop_covers, (List<?>) shopExtInfo.shop_covers) || !equals((Object) this.update_shop_covers, (Object) shopExtInfo.update_shop_covers) || !equals((Object) this.last_update_time, (Object) shopExtInfo.last_update_time) || !equals((Object) this.seller_rating, (Object) shopExtInfo.seller_rating) || !equals((Object) this.webchat_response_rate, (Object) shopExtInfo.webchat_response_rate) || !equals((Object) this.shopee_verified_flag, (Object) shopExtInfo.shopee_verified_flag) || !equals((Object) this.preparation_time, (Object) shopExtInfo.preparation_time) || !equals((Object) this.had_order, (Object) shopExtInfo.had_order) || !equals((Object) this.fulfillment_rate_flag, (Object) shopExtInfo.fulfillment_rate_flag) || !equals((Object) this.non_fulfillment_rate, (Object) shopExtInfo.non_fulfillment_rate) || !equals((Object) this.fulfillment_rate, (Object) shopExtInfo.fulfillment_rate) || !equals((Object) this.comm_group_id, (Object) shopExtInfo.comm_group_id) || !equals((Object) this.card_txn_fee_setting, (Object) shopExtInfo.card_txn_fee_setting) || !equals((Object) this.return_address_id, (Object) shopExtInfo.return_address_id) || !equals((Object) this.seller_penalty_flag, (Object) shopExtInfo.seller_penalty_flag) || !equals((Object) this.seller_penalty_score, (Object) shopExtInfo.seller_penalty_score) || !equals((Object) this.seller_penalty_tier, (Object) shopExtInfo.seller_penalty_tier) || !equals((Object) this.late_shipment_rate_flag, (Object) shopExtInfo.late_shipment_rate_flag) || !equals((Object) this.late_shipment_rate, (Object) shopExtInfo.late_shipment_rate) || !equals((Object) this.last_change_shopname, (Object) shopExtInfo.last_change_shopname) || !equals((Object) this.cb_return_address_id, (Object) shopExtInfo.cb_return_address_id) || !equals((Object) this.sync_stock_from_wms, (Object) shopExtInfo.sync_stock_from_wms) || !equals((List<?>) this.label_ids, (List<?>) shopExtInfo.label_ids) || !equals((Object) this.stock_alert_allow, (Object) shopExtInfo.stock_alert_allow) || !equals((Object) this.stock_alert_on, (Object) shopExtInfo.stock_alert_on) || !equals((Object) this.max_variations_count, (Object) shopExtInfo.max_variations_count) || !equals((Object) this.sustain_days_threshold, (Object) shopExtInfo.sustain_days_threshold) || !equals((Object) this.cancellation_rate, (Object) shopExtInfo.cancellation_rate) || !equals((Object) this.has_decoration, (Object) shopExtInfo.has_decoration) || !equals((Object) this.preorder_listing_target, (Object) shopExtInfo.preorder_listing_target) || !equals((Object) this.is_sip_primary, (Object) shopExtInfo.is_sip_primary) || !equals((Object) this.is_sip_affiliated, (Object) shopExtInfo.is_sip_affiliated) || !equals((Object) this.is_ship_from_overseas, (Object) shopExtInfo.is_ship_from_overseas) || !equals((Object) this.visible_regions, (Object) shopExtInfo.visible_regions) || !equals((Object) this.block_cb_user, (Object) shopExtInfo.block_cb_user)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        BuyerAddress buyerAddress = this.address;
        int i2 = 0;
        int hashCode = (buyerAddress != null ? buyerAddress.hashCode() : 0) * 37;
        Integer num = this.disable_make_offer;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.logistics_info;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.pickup_address_id;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.display_default_shipping_info;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.logistics_flag;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        f fVar2 = this.default_item_logistics_info;
        int hashCode7 = (hashCode6 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        List<String> list = this.covers;
        int i3 = 1;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.star_seller;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.auto_reply_on;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        f fVar3 = this.auto_reply_msg;
        int hashCode11 = (hashCode10 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num3 = this.response_rate;
        int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool3 = this.description_banned;
        int hashCode13 = (hashCode12 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.covers_banned;
        int hashCode14 = (hashCode13 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num4 = this.display_response_rate;
        int hashCode15 = (hashCode14 + (num4 != null ? num4.hashCode() : 0)) * 37;
        ShopAdminInfo shopAdminInfo = this.admininfo;
        int hashCode16 = (hashCode15 + (shopAdminInfo != null ? shopAdminInfo.hashCode() : 0)) * 37;
        Integer num5 = this.auto_reply_mtime;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Double d2 = this.rating_star;
        int hashCode18 = (hashCode17 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Boolean bool5 = this.chat_disabled;
        int hashCode19 = (hashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Integer num6 = this.response_time;
        int hashCode20 = (hashCode19 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool6 = this.enable_display_unitno;
        int hashCode21 = (hashCode20 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        List<ShopCover> list2 = this.shop_covers;
        int hashCode22 = (hashCode21 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Boolean bool7 = this.update_shop_covers;
        int hashCode23 = (hashCode22 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Integer num7 = this.last_update_time;
        int hashCode24 = (hashCode23 + (num7 != null ? num7.hashCode() : 0)) * 37;
        SellerRating sellerRating = this.seller_rating;
        int hashCode25 = (hashCode24 + (sellerRating != null ? sellerRating.hashCode() : 0)) * 37;
        Integer num8 = this.webchat_response_rate;
        int hashCode26 = (hashCode25 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.shopee_verified_flag;
        int hashCode27 = (hashCode26 + (num9 != null ? num9.hashCode() : 0)) * 37;
        PreparationTime preparationTime = this.preparation_time;
        int hashCode28 = (hashCode27 + (preparationTime != null ? preparationTime.hashCode() : 0)) * 37;
        Boolean bool8 = this.had_order;
        int hashCode29 = (hashCode28 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Integer num10 = this.fulfillment_rate_flag;
        int hashCode30 = (hashCode29 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Double d3 = this.non_fulfillment_rate;
        int hashCode31 = (hashCode30 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.fulfillment_rate;
        int hashCode32 = (hashCode31 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num11 = this.comm_group_id;
        int hashCode33 = (hashCode32 + (num11 != null ? num11.hashCode() : 0)) * 37;
        ShopCardTxnFeeSetting shopCardTxnFeeSetting = this.card_txn_fee_setting;
        int hashCode34 = (hashCode33 + (shopCardTxnFeeSetting != null ? shopCardTxnFeeSetting.hashCode() : 0)) * 37;
        Integer num12 = this.return_address_id;
        int hashCode35 = (hashCode34 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.seller_penalty_flag;
        int hashCode36 = (hashCode35 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.seller_penalty_score;
        int hashCode37 = (hashCode36 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.seller_penalty_tier;
        int hashCode38 = (hashCode37 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.late_shipment_rate_flag;
        int hashCode39 = (hashCode38 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Double d5 = this.late_shipment_rate;
        int hashCode40 = (hashCode39 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Integer num17 = this.last_change_shopname;
        int hashCode41 = (hashCode40 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.cb_return_address_id;
        int hashCode42 = (hashCode41 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Boolean bool9 = this.sync_stock_from_wms;
        int hashCode43 = (hashCode42 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        List<Long> list3 = this.label_ids;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode43 + i3) * 37;
        Boolean bool10 = this.stock_alert_allow;
        int hashCode44 = (i4 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
        Boolean bool11 = this.stock_alert_on;
        int hashCode45 = (hashCode44 + (bool11 != null ? bool11.hashCode() : 0)) * 37;
        Integer num19 = this.max_variations_count;
        int hashCode46 = (hashCode45 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.sustain_days_threshold;
        int hashCode47 = (hashCode46 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Double d6 = this.cancellation_rate;
        int hashCode48 = (hashCode47 + (d6 != null ? d6.hashCode() : 0)) * 37;
        Boolean bool12 = this.has_decoration;
        int hashCode49 = (hashCode48 + (bool12 != null ? bool12.hashCode() : 0)) * 37;
        Integer num21 = this.preorder_listing_target;
        int hashCode50 = (hashCode49 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Boolean bool13 = this.is_sip_primary;
        int hashCode51 = (hashCode50 + (bool13 != null ? bool13.hashCode() : 0)) * 37;
        Boolean bool14 = this.is_sip_affiliated;
        int hashCode52 = (hashCode51 + (bool14 != null ? bool14.hashCode() : 0)) * 37;
        Boolean bool15 = this.is_ship_from_overseas;
        int hashCode53 = (hashCode52 + (bool15 != null ? bool15.hashCode() : 0)) * 37;
        String str2 = this.visible_regions;
        int hashCode54 = (hashCode53 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool16 = this.block_cb_user;
        if (bool16 != null) {
            i2 = bool16.hashCode();
        }
        int i5 = hashCode54 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ShopExtInfo> {
        public BuyerAddress address;
        public ShopAdminInfo admininfo;
        public f auto_reply_msg;
        public Integer auto_reply_mtime;
        public Boolean auto_reply_on;
        public Boolean block_cb_user;
        public Double cancellation_rate;
        public ShopCardTxnFeeSetting card_txn_fee_setting;
        public Integer cb_return_address_id;
        public Boolean chat_disabled;
        public Integer comm_group_id;
        public List<String> covers;
        public Boolean covers_banned;
        public f default_item_logistics_info;
        public Boolean description_banned;
        public Integer disable_make_offer;
        public String display_default_shipping_info;
        public Integer display_response_rate;
        public Boolean enable_display_unitno;
        public Double fulfillment_rate;
        public Integer fulfillment_rate_flag;
        public Boolean had_order;
        public Boolean has_decoration;
        public Boolean is_ship_from_overseas;
        public Boolean is_sip_affiliated;
        public Boolean is_sip_primary;
        public List<Long> label_ids;
        public Integer last_change_shopname;
        public Integer last_update_time;
        public Double late_shipment_rate;
        public Integer late_shipment_rate_flag;
        public Long logistics_flag;
        public f logistics_info;
        public Integer max_variations_count;
        public Double non_fulfillment_rate;
        public Integer pickup_address_id;
        public Integer preorder_listing_target;
        public PreparationTime preparation_time;
        public Double rating_star;
        public Integer response_rate;
        public Integer response_time;
        public Integer return_address_id;
        public Integer seller_penalty_flag;
        public Integer seller_penalty_score;
        public Integer seller_penalty_tier;
        public SellerRating seller_rating;
        public List<ShopCover> shop_covers;
        public Integer shopee_verified_flag;
        public Boolean star_seller;
        public Boolean stock_alert_allow;
        public Boolean stock_alert_on;
        public Integer sustain_days_threshold;
        public Boolean sync_stock_from_wms;
        public Boolean update_shop_covers;
        public String visible_regions;
        public Integer webchat_response_rate;

        public Builder() {
        }

        public Builder(ShopExtInfo shopExtInfo) {
            super(shopExtInfo);
            if (shopExtInfo != null) {
                this.address = shopExtInfo.address;
                this.disable_make_offer = shopExtInfo.disable_make_offer;
                this.logistics_info = shopExtInfo.logistics_info;
                this.pickup_address_id = shopExtInfo.pickup_address_id;
                this.display_default_shipping_info = shopExtInfo.display_default_shipping_info;
                this.logistics_flag = shopExtInfo.logistics_flag;
                this.default_item_logistics_info = shopExtInfo.default_item_logistics_info;
                this.covers = ShopExtInfo.copyOf(shopExtInfo.covers);
                this.star_seller = shopExtInfo.star_seller;
                this.auto_reply_on = shopExtInfo.auto_reply_on;
                this.auto_reply_msg = shopExtInfo.auto_reply_msg;
                this.response_rate = shopExtInfo.response_rate;
                this.description_banned = shopExtInfo.description_banned;
                this.covers_banned = shopExtInfo.covers_banned;
                this.display_response_rate = shopExtInfo.display_response_rate;
                this.admininfo = shopExtInfo.admininfo;
                this.auto_reply_mtime = shopExtInfo.auto_reply_mtime;
                this.rating_star = shopExtInfo.rating_star;
                this.chat_disabled = shopExtInfo.chat_disabled;
                this.response_time = shopExtInfo.response_time;
                this.enable_display_unitno = shopExtInfo.enable_display_unitno;
                this.shop_covers = ShopExtInfo.copyOf(shopExtInfo.shop_covers);
                this.update_shop_covers = shopExtInfo.update_shop_covers;
                this.last_update_time = shopExtInfo.last_update_time;
                this.seller_rating = shopExtInfo.seller_rating;
                this.webchat_response_rate = shopExtInfo.webchat_response_rate;
                this.shopee_verified_flag = shopExtInfo.shopee_verified_flag;
                this.preparation_time = shopExtInfo.preparation_time;
                this.had_order = shopExtInfo.had_order;
                this.fulfillment_rate_flag = shopExtInfo.fulfillment_rate_flag;
                this.non_fulfillment_rate = shopExtInfo.non_fulfillment_rate;
                this.fulfillment_rate = shopExtInfo.fulfillment_rate;
                this.comm_group_id = shopExtInfo.comm_group_id;
                this.card_txn_fee_setting = shopExtInfo.card_txn_fee_setting;
                this.return_address_id = shopExtInfo.return_address_id;
                this.seller_penalty_flag = shopExtInfo.seller_penalty_flag;
                this.seller_penalty_score = shopExtInfo.seller_penalty_score;
                this.seller_penalty_tier = shopExtInfo.seller_penalty_tier;
                this.late_shipment_rate_flag = shopExtInfo.late_shipment_rate_flag;
                this.late_shipment_rate = shopExtInfo.late_shipment_rate;
                this.last_change_shopname = shopExtInfo.last_change_shopname;
                this.cb_return_address_id = shopExtInfo.cb_return_address_id;
                this.sync_stock_from_wms = shopExtInfo.sync_stock_from_wms;
                this.label_ids = ShopExtInfo.copyOf(shopExtInfo.label_ids);
                this.stock_alert_allow = shopExtInfo.stock_alert_allow;
                this.stock_alert_on = shopExtInfo.stock_alert_on;
                this.max_variations_count = shopExtInfo.max_variations_count;
                this.sustain_days_threshold = shopExtInfo.sustain_days_threshold;
                this.cancellation_rate = shopExtInfo.cancellation_rate;
                this.has_decoration = shopExtInfo.has_decoration;
                this.preorder_listing_target = shopExtInfo.preorder_listing_target;
                this.is_sip_primary = shopExtInfo.is_sip_primary;
                this.is_sip_affiliated = shopExtInfo.is_sip_affiliated;
                this.is_ship_from_overseas = shopExtInfo.is_ship_from_overseas;
                this.visible_regions = shopExtInfo.visible_regions;
                this.block_cb_user = shopExtInfo.block_cb_user;
            }
        }

        public Builder address(BuyerAddress buyerAddress) {
            this.address = buyerAddress;
            return this;
        }

        public Builder disable_make_offer(Integer num) {
            this.disable_make_offer = num;
            return this;
        }

        public Builder logistics_info(f fVar) {
            this.logistics_info = fVar;
            return this;
        }

        public Builder pickup_address_id(Integer num) {
            this.pickup_address_id = num;
            return this;
        }

        public Builder display_default_shipping_info(String str) {
            this.display_default_shipping_info = str;
            return this;
        }

        public Builder logistics_flag(Long l) {
            this.logistics_flag = l;
            return this;
        }

        public Builder default_item_logistics_info(f fVar) {
            this.default_item_logistics_info = fVar;
            return this;
        }

        public Builder covers(List<String> list) {
            this.covers = checkForNulls(list);
            return this;
        }

        public Builder star_seller(Boolean bool) {
            this.star_seller = bool;
            return this;
        }

        public Builder auto_reply_on(Boolean bool) {
            this.auto_reply_on = bool;
            return this;
        }

        public Builder auto_reply_msg(f fVar) {
            this.auto_reply_msg = fVar;
            return this;
        }

        public Builder response_rate(Integer num) {
            this.response_rate = num;
            return this;
        }

        public Builder description_banned(Boolean bool) {
            this.description_banned = bool;
            return this;
        }

        public Builder covers_banned(Boolean bool) {
            this.covers_banned = bool;
            return this;
        }

        public Builder display_response_rate(Integer num) {
            this.display_response_rate = num;
            return this;
        }

        public Builder admininfo(ShopAdminInfo shopAdminInfo) {
            this.admininfo = shopAdminInfo;
            return this;
        }

        public Builder auto_reply_mtime(Integer num) {
            this.auto_reply_mtime = num;
            return this;
        }

        public Builder rating_star(Double d2) {
            this.rating_star = d2;
            return this;
        }

        public Builder chat_disabled(Boolean bool) {
            this.chat_disabled = bool;
            return this;
        }

        public Builder response_time(Integer num) {
            this.response_time = num;
            return this;
        }

        public Builder enable_display_unitno(Boolean bool) {
            this.enable_display_unitno = bool;
            return this;
        }

        public Builder shop_covers(List<ShopCover> list) {
            this.shop_covers = checkForNulls(list);
            return this;
        }

        public Builder update_shop_covers(Boolean bool) {
            this.update_shop_covers = bool;
            return this;
        }

        public Builder last_update_time(Integer num) {
            this.last_update_time = num;
            return this;
        }

        public Builder seller_rating(SellerRating sellerRating) {
            this.seller_rating = sellerRating;
            return this;
        }

        public Builder webchat_response_rate(Integer num) {
            this.webchat_response_rate = num;
            return this;
        }

        public Builder shopee_verified_flag(Integer num) {
            this.shopee_verified_flag = num;
            return this;
        }

        public Builder preparation_time(PreparationTime preparationTime) {
            this.preparation_time = preparationTime;
            return this;
        }

        public Builder had_order(Boolean bool) {
            this.had_order = bool;
            return this;
        }

        public Builder fulfillment_rate_flag(Integer num) {
            this.fulfillment_rate_flag = num;
            return this;
        }

        public Builder non_fulfillment_rate(Double d2) {
            this.non_fulfillment_rate = d2;
            return this;
        }

        public Builder fulfillment_rate(Double d2) {
            this.fulfillment_rate = d2;
            return this;
        }

        public Builder comm_group_id(Integer num) {
            this.comm_group_id = num;
            return this;
        }

        public Builder card_txn_fee_setting(ShopCardTxnFeeSetting shopCardTxnFeeSetting) {
            this.card_txn_fee_setting = shopCardTxnFeeSetting;
            return this;
        }

        public Builder return_address_id(Integer num) {
            this.return_address_id = num;
            return this;
        }

        public Builder seller_penalty_flag(Integer num) {
            this.seller_penalty_flag = num;
            return this;
        }

        public Builder seller_penalty_score(Integer num) {
            this.seller_penalty_score = num;
            return this;
        }

        public Builder seller_penalty_tier(Integer num) {
            this.seller_penalty_tier = num;
            return this;
        }

        public Builder late_shipment_rate_flag(Integer num) {
            this.late_shipment_rate_flag = num;
            return this;
        }

        public Builder late_shipment_rate(Double d2) {
            this.late_shipment_rate = d2;
            return this;
        }

        public Builder last_change_shopname(Integer num) {
            this.last_change_shopname = num;
            return this;
        }

        public Builder cb_return_address_id(Integer num) {
            this.cb_return_address_id = num;
            return this;
        }

        public Builder sync_stock_from_wms(Boolean bool) {
            this.sync_stock_from_wms = bool;
            return this;
        }

        public Builder label_ids(List<Long> list) {
            this.label_ids = checkForNulls(list);
            return this;
        }

        public Builder stock_alert_allow(Boolean bool) {
            this.stock_alert_allow = bool;
            return this;
        }

        public Builder stock_alert_on(Boolean bool) {
            this.stock_alert_on = bool;
            return this;
        }

        public Builder max_variations_count(Integer num) {
            this.max_variations_count = num;
            return this;
        }

        public Builder sustain_days_threshold(Integer num) {
            this.sustain_days_threshold = num;
            return this;
        }

        public Builder cancellation_rate(Double d2) {
            this.cancellation_rate = d2;
            return this;
        }

        public Builder has_decoration(Boolean bool) {
            this.has_decoration = bool;
            return this;
        }

        public Builder preorder_listing_target(Integer num) {
            this.preorder_listing_target = num;
            return this;
        }

        public Builder is_sip_primary(Boolean bool) {
            this.is_sip_primary = bool;
            return this;
        }

        public Builder is_sip_affiliated(Boolean bool) {
            this.is_sip_affiliated = bool;
            return this;
        }

        public Builder is_ship_from_overseas(Boolean bool) {
            this.is_ship_from_overseas = bool;
            return this;
        }

        public Builder visible_regions(String str) {
            this.visible_regions = str;
            return this;
        }

        public Builder block_cb_user(Boolean bool) {
            this.block_cb_user = bool;
            return this;
        }

        public ShopExtInfo build() {
            return new ShopExtInfo(this);
        }
    }
}
