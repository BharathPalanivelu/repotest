package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class OrderExtInfo extends Message {
    public static final Long DEFAULT_ACTUAL_BUYER_PAID_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_ARRANGE_PICKUP_BY_DATE = 0;
    public static final Integer DEFAULT_AUTO_CANCEL_3PL_ACK_DATE = 0;
    public static final Integer DEFAULT_AUTO_CANCEL_ARRANGE_SHIP_DATE = 0;
    public static final Long DEFAULT_BANK_TRANSFER_TIME = 0L;
    public static final Integer DEFAULT_BATCHID = 0;
    public static final Integer DEFAULT_BUYERCANCEL_PENDING_TIME = 0;
    public static final Integer DEFAULT_BUYER_CANCEL_REASON = 0;
    public static final Boolean DEFAULT_BUYER_CONFIRM_ORDER = false;
    public static final Integer DEFAULT_BUYER_IS_RATED = 0;
    public static final Long DEFAULT_BUYER_RATE_CMTID = 0L;
    public static final Long DEFAULT_BUYER_USER_LOCATION_SNAPSHOT_ID = 0L;
    public static final Integer DEFAULT_BUY_COUNT = 0;
    public static final Integer DEFAULT_CANCEL_REASON = 0;
    public static final Integer DEFAULT_CANCEL_USERID = 0;
    public static final Long DEFAULT_CARRIER_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_CDT_WITH_EXT = 0;
    public static final Long DEFAULT_CHANNEL_PAYEE_ACCOUNT_ID = 0L;
    public static final Integer DEFAULT_COD_PROCESS_BY_DATE = 0;
    public static final Long DEFAULT_COMM_FEE = 0L;
    public static final Long DEFAULT_CONTRACTUAL_CARRIER_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_DAYS_CAN_EXTEND = 0;
    public static final Integer DEFAULT_DAYS_EXTENDED = 0;
    public static final Integer DEFAULT_DAYS_TOSHIP_EXTENDED = 0;
    public static final Integer DEFAULT_DAYS_TO_CONFIRM = 0;
    public static final Integer DEFAULT_DAYS_TO_DELIVERY = 0;
    public static final Integer DEFAULT_DAYS_TO_PAY = 0;
    public static final Integer DEFAULT_DAYS_TO_SHIP = 0;
    public static final Integer DEFAULT_DB_VERSION = 0;
    public static final List<OrderDetailedStatus> DEFAULT_DETAILED_STATUSES = Collections.emptyList();
    public static final Long DEFAULT_DETAIL_FLAG = 0L;
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Long DEFAULT_DISCOUNT_SHIPPING_FEE = 0L;
    public static final Long DEFAULT_ESCROW_SHIPPING_FEE = 0L;
    public static final Long DEFAULT_ESCROW_TO_SELLER = 0L;
    public static final Long DEFAULT_ESTIMATED_ESCROW = 0L;
    public static final Integer DEFAULT_FE_RECEIVE_TIME = 0;
    public static final Long DEFAULT_FIRST_ITEMID = 0L;
    public static final Integer DEFAULT_FIRST_ITEM_FREE_RETURN_DAY = 0;
    public static final Boolean DEFAULT_FIRST_ITEM_IS_BUNDLE = false;
    public static final Boolean DEFAULT_FIRST_ITEM_IS_WHOLESALE = false;
    public static final Boolean DEFAULT_FIRST_ITEM_RETURN = false;
    public static final List<FraudInfo> DEFAULT_FRAUD_INFO = Collections.emptyList();
    public static final Long DEFAULT_GROUP_BUY_GROUPID = 0L;
    public static final Integer DEFAULT_GROUP_BUY_PAYMENT_END_TIME = 0;
    public static final Long DEFAULT_GROUP_SHIPPING_ID = 0L;
    public static final Boolean DEFAULT_INSTANT_BUYERCANCEL_TOSHIP = false;
    public static final Boolean DEFAULT_IS_AD_ORDER = false;
    public static final Boolean DEFAULT_IS_BUYERCANCEL_TOSHIP = false;
    public static final Integer DEFAULT_IS_FROM_WEBCHECKOUT = 0;
    public static final Boolean DEFAULT_IS_GROUP_BUY_ONGOING = false;
    public static final Boolean DEFAULT_IS_SHIP_FROM_OVERSEAS = false;
    public static final Boolean DEFAULT_IS_SLASH_PRICE = false;
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final List<String> DEFAULT_ITEM_IMAGE = Collections.emptyList();
    public static final String DEFAULT_ITEM_NAME = "";
    public static final Long DEFAULT_ITEM_PRICE = 0L;
    public static final Long DEFAULT_ITEM_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Integer DEFAULT_LAST_CHANGE_ADDRESS_TIME = 0;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_MODEL_NAME = "";
    public static final Boolean DEFAULT_NOT_STATS = false;
    public static final Boolean DEFAULT_OFFICIAL_SHOP = false;
    public static final Long DEFAULT_ORDER_EXT_DATA_REF = 0L;
    public static final Long DEFAULT_ORDER_PRICE = 0L;
    public static final Long DEFAULT_ORIGIN_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_PAYBY_DATE = 0;
    public static final String DEFAULT_PAYER_VERI_FAIL_REASON = "";
    public static final String DEFAULT_PAYMENT_CHANNEL_NAME = "";
    public static final Long DEFAULT_PAYMENT_FLAG = 0L;
    public static final Boolean DEFAULT_POST_RETURN_COMPLETED_STEPS_NOT_EXECUTED = false;
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Integer DEFAULT_RATECANCEL_BY_DATE = 0;
    public static final Integer DEFAULT_RATE_BY_DATE = 0;
    public static final Long DEFAULT_REBATE_PRICE = 0L;
    public static final Long DEFAULT_REBATE_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_RELEASE_TIME = 0;
    public static final Integer DEFAULT_SELLER_DUE_DATE = 0;
    public static final Integer DEFAULT_SELLER_IS_RATED = 0;
    public static final f DEFAULT_SELLER_NOTE = f.f32736b;
    public static final Long DEFAULT_SELLER_RATE_CMTID = 0L;
    public static final Integer DEFAULT_SELLER_USERID = 0;
    public static final Long DEFAULT_SELLER_USER_LOCATION_SNAPSHOT_ID = 0L;
    public static final Long DEFAULT_SHIPPING_FEE_MAX_DISCOUNT = 0L;
    public static final Integer DEFAULT_SHIP_BY_DATE = 0;
    public static final Long DEFAULT_SHOP_SNAPSHOT_ID = 0L;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    public static final f DEFAULT_TRANS_DETAIL_SHIPPING_FEE = f.f32736b;
    public static final Boolean DEFAULT_USING_WALLET = false;
    public static final Long DEFAULT_WALLET_TRANSACTION_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 102, type = Message.Datatype.INT64)
    public final Long actual_buyer_paid_shipping_fee;
    @ProtoField(tag = 96)
    public final CardTxnFeeOrderInfo admin_fee;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer arrange_pickup_by_date;
    @ProtoField(tag = 85, type = Message.Datatype.INT32)
    public final Integer auto_cancel_3pl_ack_date;
    @ProtoField(tag = 84, type = Message.Datatype.INT32)
    public final Integer auto_cancel_arrange_ship_date;
    @ProtoField(tag = 92, type = Message.Datatype.INT64)
    public final Long bank_transfer_time;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer batchid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer buy_count;
    @ProtoField(tag = 28)
    public final BuyerAddress buyer_address;
    @ProtoField(tag = 77, type = Message.Datatype.INT32)
    public final Integer buyer_cancel_reason;
    @ProtoField(tag = 39, type = Message.Datatype.BOOL)
    public final Boolean buyer_confirm_order;
    @ProtoField(tag = 53, type = Message.Datatype.INT32)
    public final Integer buyer_is_rated;
    @ProtoField(tag = 56, type = Message.Datatype.INT64)
    public final Long buyer_rate_cmtid;
    @ProtoField(tag = 87)
    public final CardTxnFeeOrderInfo buyer_txn_fee_info;
    @ProtoField(tag = 98, type = Message.Datatype.UINT64)
    public final Long buyer_user_location_snapshot_id;
    @ProtoField(tag = 74, type = Message.Datatype.INT32)
    public final Integer buyercancel_pending_time;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer cancel_reason;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer cancel_userid;
    @ProtoField(tag = 68)
    public final CardPromotionOrderInfo card_promotion_info;
    @ProtoField(tag = 70)
    public final CardTxnFeeOrderInfo card_txn_fee_info;
    @ProtoField(tag = 35, type = Message.Datatype.INT64)
    public final Long carrier_shipping_fee;
    @ProtoField(tag = 40)
    public final CartPriceInfo cart_price_info;
    @ProtoField(tag = 107, type = Message.Datatype.INT32)
    public final Integer cdt_with_ext;
    @ProtoField(tag = 97, type = Message.Datatype.INT64)
    public final Long channel_payee_account_id;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer cod_process_by_date;
    @ProtoField(tag = 62)
    public final CoinInfo coin_info;
    @ProtoField(tag = 69, type = Message.Datatype.INT64)
    public final Long comm_fee;
    @ProtoField(tag = 61, type = Message.Datatype.INT64)
    public final Long contractual_carrier_shipping_fee;
    @ProtoField(tag = 50, type = Message.Datatype.INT32)
    public final Integer days_can_extend;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer days_extended;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer days_to_confirm;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer days_to_delivery;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer days_to_pay;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer days_to_ship;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer days_toship_extended;
    @ProtoField(tag = 86, type = Message.Datatype.INT32)
    public final Integer db_version;
    @ProtoField(tag = 58, type = Message.Datatype.INT64)
    public final Long detail_flag;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderDetailedStatus.class, tag = 59)
    public final List<OrderDetailedStatus> detailed_statuses;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(tag = 33, type = Message.Datatype.INT64)
    public final Long discount_shipping_fee;
    @ProtoField(tag = 82)
    public final OrderDropshippingInfo dropshipping_info;
    @ProtoField(tag = 44, type = Message.Datatype.INT64)
    public final Long escrow_shipping_fee;
    @ProtoField(tag = 60, type = Message.Datatype.INT64)
    public final Long escrow_to_seller;
    @ProtoField(tag = 71, type = Message.Datatype.INT64)
    public final Long estimated_escrow;
    @ProtoField(tag = 108, type = Message.Datatype.INT32)
    public final Integer fe_receive_time;
    @ProtoField(tag = 79, type = Message.Datatype.INT32)
    public final Integer first_item_free_return_day;
    @ProtoField(tag = 83, type = Message.Datatype.BOOL)
    public final Boolean first_item_is_bundle;
    @ProtoField(tag = 66, type = Message.Datatype.BOOL)
    public final Boolean first_item_is_wholesale;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean first_item_return;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long first_itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = FraudInfo.class, tag = 65)
    public final List<FraudInfo> fraud_info;
    @ProtoField(tag = 94)
    public final LogisticsVoucherInfo free_shipping_voucher;
    @ProtoField(tag = 89, type = Message.Datatype.INT64)
    public final Long group_buy_groupid;
    @ProtoField(tag = 91, type = Message.Datatype.INT32)
    public final Integer group_buy_payment_end_time;
    @ProtoField(tag = 90, type = Message.Datatype.INT64)
    public final Long group_shipping_id;
    @ProtoField(tag = 78, type = Message.Datatype.BOOL)
    public final Boolean instant_buyercancel_toship;
    @ProtoField(tag = 67, type = Message.Datatype.BOOL)
    public final Boolean is_ad_order;
    @ProtoField(tag = 75, type = Message.Datatype.BOOL)
    public final Boolean is_buyercancel_toship;
    @ProtoField(tag = 38, type = Message.Datatype.INT32)
    public final Integer is_from_webcheckout;
    @ProtoField(tag = 93, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy_ongoing;
    @ProtoField(tag = 101, type = Message.Datatype.BOOL)
    public final Boolean is_ship_from_overseas;
    @ProtoField(tag = 100, type = Message.Datatype.BOOL)
    public final Boolean is_slash_price;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> item_image;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String item_name;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long item_price;
    @ProtoField(tag = 27, type = Message.Datatype.INT64)
    public final Long item_price_before_discount;
    @ProtoField(tag = 103)
    public final JkoAccountSeller jko_seller_info;
    @ProtoField(tag = 95, type = Message.Datatype.INT32)
    public final Integer last_change_address_time;
    @ProtoField(tag = 30)
    public final OrderLogisticsInfo logistics_info;
    @ProtoField(tag = 43, type = Message.Datatype.STRING)
    public final String model_name;
    @ProtoField(tag = 45, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 63, type = Message.Datatype.BOOL)
    public final Boolean not_stats;
    @ProtoField(tag = 76, type = Message.Datatype.BOOL)
    public final Boolean official_shop;
    @ProtoField(tag = 88, type = Message.Datatype.INT64)
    public final Long order_ext_data_ref;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long order_price;
    @ProtoField(tag = 34, type = Message.Datatype.INT64)
    public final Long origin_shipping_fee;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer payby_date;
    @ProtoField(tag = 64, type = Message.Datatype.STRING)
    public final String payer_veri_fail_reason;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String payment_channel_name;
    @ProtoField(tag = 42, type = Message.Datatype.INT64)
    public final Long payment_flag;
    @ProtoField(tag = 104, type = Message.Datatype.BOOL)
    public final Boolean post_return_completed_steps_not_executed;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 26)
    public final PromotionInfo promotion_info;
    @ProtoField(tag = 54, type = Message.Datatype.INT32)
    public final Integer rate_by_date;
    @ProtoField(tag = 80, type = Message.Datatype.INT32)
    public final Integer ratecancel_by_date;
    @ProtoField(tag = 72, type = Message.Datatype.INT64)
    public final Long rebate_price;
    @ProtoField(tag = 47, type = Message.Datatype.INT64)
    public final Long rebate_shipping_fee;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer release_time;
    @ProtoField(tag = 29)
    public final BuyerAddress seller_address;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer seller_due_date;
    @ProtoField(tag = 55, type = Message.Datatype.INT32)
    public final Integer seller_is_rated;
    @ProtoField(tag = 51, type = Message.Datatype.BYTES)
    public final f seller_note;
    @ProtoField(tag = 57, type = Message.Datatype.INT64)
    public final Long seller_rate_cmtid;
    @ProtoField(tag = 99, type = Message.Datatype.UINT64)
    public final Long seller_user_location_snapshot_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer seller_userid;
    @ProtoField(tag = 106)
    public final ServiceFeeOrderInfo service_fee_info;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer ship_by_date;
    @ProtoField(tag = 48, type = Message.Datatype.INT64)
    public final Long shipping_fee_max_discount;
    @ProtoField(tag = 41)
    public final Shop shop_snapshot;
    @ProtoField(tag = 52, type = Message.Datatype.INT64)
    public final Long shop_snapshot_id;
    @ProtoField(tag = 46, type = Message.Datatype.INT64)
    public final Long snapshotid;
    @ProtoField(tag = 81)
    public final OrderTaxInfo tax_info;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer total_count;
    @ProtoField(tag = 49, type = Message.Datatype.BYTES)
    public final f trans_detail_shipping_fee;
    @ProtoField(tag = 105, type = Message.Datatype.BOOL)
    public final Boolean using_wallet;
    @ProtoField(tag = 73, type = Message.Datatype.INT64)
    public final Long wallet_transaction_id;

    public OrderExtInfo(List<String> list, String str, Long l, Long l2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Long l3, Boolean bool, Integer num11, Integer num12, Integer num13, String str2, Integer num14, Integer num15, Long l4, Integer num16, PromotionInfo promotionInfo, Long l5, BuyerAddress buyerAddress, BuyerAddress buyerAddress2, OrderLogisticsInfo orderLogisticsInfo, Integer num17, Integer num18, Long l6, Long l7, Long l8, Integer num19, Integer num20, Integer num21, Boolean bool2, CartPriceInfo cartPriceInfo, Shop shop, Long l9, String str3, Long l10, Long l11, Long l12, Long l13, Long l14, f fVar, Integer num22, f fVar2, Long l15, Integer num23, Integer num24, Integer num25, Long l16, Long l17, Long l18, List<OrderDetailedStatus> list2, Long l19, Long l20, CoinInfo coinInfo, Boolean bool3, String str4, List<FraudInfo> list3, Boolean bool4, Boolean bool5, CardPromotionOrderInfo cardPromotionOrderInfo, Long l21, CardTxnFeeOrderInfo cardTxnFeeOrderInfo, Long l22, Long l23, Long l24, Integer num26, Boolean bool6, Boolean bool7, Integer num27, Boolean bool8, Integer num28, Integer num29, OrderTaxInfo orderTaxInfo, OrderDropshippingInfo orderDropshippingInfo, Boolean bool9, Integer num30, Integer num31, Integer num32, CardTxnFeeOrderInfo cardTxnFeeOrderInfo2, Long l25, Long l26, Long l27, Integer num33, Long l28, Boolean bool10, LogisticsVoucherInfo logisticsVoucherInfo, Integer num34, CardTxnFeeOrderInfo cardTxnFeeOrderInfo3, Long l29, Long l30, Long l31, Boolean bool11, Boolean bool12, Long l32, JkoAccountSeller jkoAccountSeller, Boolean bool13, Boolean bool14, ServiceFeeOrderInfo serviceFeeOrderInfo, Integer num35, Integer num36) {
        this.item_image = immutableCopyOf(list);
        this.item_name = str;
        this.item_price = l;
        this.order_price = l2;
        this.buy_count = num;
        this.item_count = num2;
        this.total_count = num3;
        this.seller_userid = num4;
        this.days_to_ship = num5;
        this.days_to_delivery = num6;
        this.days_to_confirm = num7;
        this.days_extended = num8;
        this.days_to_pay = num9;
        this.cancel_reason = num10;
        this.first_itemid = l3;
        this.first_item_return = bool;
        this.release_time = num11;
        this.cancel_userid = num12;
        this.batchid = num13;
        this.payment_channel_name = str2;
        this.seller_due_date = num14;
        this.payby_date = num15;
        this.price_before_discount = l4;
        this.discount_percentage = num16;
        this.promotion_info = promotionInfo;
        this.item_price_before_discount = l5;
        this.buyer_address = buyerAddress;
        this.seller_address = buyerAddress2;
        this.logistics_info = orderLogisticsInfo;
        this.arrange_pickup_by_date = num17;
        this.ship_by_date = num18;
        this.discount_shipping_fee = l6;
        this.origin_shipping_fee = l7;
        this.carrier_shipping_fee = l8;
        this.cod_process_by_date = num19;
        this.days_toship_extended = num20;
        this.is_from_webcheckout = num21;
        this.buyer_confirm_order = bool2;
        this.cart_price_info = cartPriceInfo;
        this.shop_snapshot = shop;
        this.payment_flag = l9;
        this.model_name = str3;
        this.escrow_shipping_fee = l10;
        this.modelid = l11;
        this.snapshotid = l12;
        this.rebate_shipping_fee = l13;
        this.shipping_fee_max_discount = l14;
        this.trans_detail_shipping_fee = fVar;
        this.days_can_extend = num22;
        this.seller_note = fVar2;
        this.shop_snapshot_id = l15;
        this.buyer_is_rated = num23;
        this.rate_by_date = num24;
        this.seller_is_rated = num25;
        this.buyer_rate_cmtid = l16;
        this.seller_rate_cmtid = l17;
        this.detail_flag = l18;
        this.detailed_statuses = immutableCopyOf(list2);
        this.escrow_to_seller = l19;
        this.contractual_carrier_shipping_fee = l20;
        this.coin_info = coinInfo;
        this.not_stats = bool3;
        this.payer_veri_fail_reason = str4;
        this.fraud_info = immutableCopyOf(list3);
        this.first_item_is_wholesale = bool4;
        this.is_ad_order = bool5;
        this.card_promotion_info = cardPromotionOrderInfo;
        this.comm_fee = l21;
        this.card_txn_fee_info = cardTxnFeeOrderInfo;
        this.estimated_escrow = l22;
        this.rebate_price = l23;
        this.wallet_transaction_id = l24;
        this.buyercancel_pending_time = num26;
        this.is_buyercancel_toship = bool6;
        this.official_shop = bool7;
        this.buyer_cancel_reason = num27;
        this.instant_buyercancel_toship = bool8;
        this.first_item_free_return_day = num28;
        this.ratecancel_by_date = num29;
        this.tax_info = orderTaxInfo;
        this.dropshipping_info = orderDropshippingInfo;
        this.first_item_is_bundle = bool9;
        this.auto_cancel_arrange_ship_date = num30;
        this.auto_cancel_3pl_ack_date = num31;
        this.db_version = num32;
        this.buyer_txn_fee_info = cardTxnFeeOrderInfo2;
        this.order_ext_data_ref = l25;
        this.group_buy_groupid = l26;
        this.group_shipping_id = l27;
        this.group_buy_payment_end_time = num33;
        this.bank_transfer_time = l28;
        this.is_group_buy_ongoing = bool10;
        this.free_shipping_voucher = logisticsVoucherInfo;
        this.last_change_address_time = num34;
        this.admin_fee = cardTxnFeeOrderInfo3;
        this.channel_payee_account_id = l29;
        this.buyer_user_location_snapshot_id = l30;
        this.seller_user_location_snapshot_id = l31;
        this.is_slash_price = bool11;
        this.is_ship_from_overseas = bool12;
        this.actual_buyer_paid_shipping_fee = l32;
        this.jko_seller_info = jkoAccountSeller;
        this.post_return_completed_steps_not_executed = bool13;
        this.using_wallet = bool14;
        this.service_fee_info = serviceFeeOrderInfo;
        this.cdt_with_ext = num35;
        this.fe_receive_time = num36;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderExtInfo(com.shopee.protocol.shop.OrderExtInfo.Builder r111) {
        /*
            r110 = this;
            r0 = r111
            r1 = r110
            java.util.List<java.lang.String> r2 = r0.item_image
            java.lang.String r3 = r0.item_name
            java.lang.Long r4 = r0.item_price
            java.lang.Long r5 = r0.order_price
            java.lang.Integer r6 = r0.buy_count
            java.lang.Integer r7 = r0.item_count
            java.lang.Integer r8 = r0.total_count
            java.lang.Integer r9 = r0.seller_userid
            java.lang.Integer r10 = r0.days_to_ship
            java.lang.Integer r11 = r0.days_to_delivery
            java.lang.Integer r12 = r0.days_to_confirm
            java.lang.Integer r13 = r0.days_extended
            java.lang.Integer r14 = r0.days_to_pay
            java.lang.Integer r15 = r0.cancel_reason
            r109 = r1
            java.lang.Long r1 = r0.first_itemid
            r16 = r1
            java.lang.Boolean r1 = r0.first_item_return
            r17 = r1
            java.lang.Integer r1 = r0.release_time
            r18 = r1
            java.lang.Integer r1 = r0.cancel_userid
            r19 = r1
            java.lang.Integer r1 = r0.batchid
            r20 = r1
            java.lang.String r1 = r0.payment_channel_name
            r21 = r1
            java.lang.Integer r1 = r0.seller_due_date
            r22 = r1
            java.lang.Integer r1 = r0.payby_date
            r23 = r1
            java.lang.Long r1 = r0.price_before_discount
            r24 = r1
            java.lang.Integer r1 = r0.discount_percentage
            r25 = r1
            com.shopee.protocol.shop.PromotionInfo r1 = r0.promotion_info
            r26 = r1
            java.lang.Long r1 = r0.item_price_before_discount
            r27 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.buyer_address
            r28 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.seller_address
            r29 = r1
            com.shopee.protocol.shop.OrderLogisticsInfo r1 = r0.logistics_info
            r30 = r1
            java.lang.Integer r1 = r0.arrange_pickup_by_date
            r31 = r1
            java.lang.Integer r1 = r0.ship_by_date
            r32 = r1
            java.lang.Long r1 = r0.discount_shipping_fee
            r33 = r1
            java.lang.Long r1 = r0.origin_shipping_fee
            r34 = r1
            java.lang.Long r1 = r0.carrier_shipping_fee
            r35 = r1
            java.lang.Integer r1 = r0.cod_process_by_date
            r36 = r1
            java.lang.Integer r1 = r0.days_toship_extended
            r37 = r1
            java.lang.Integer r1 = r0.is_from_webcheckout
            r38 = r1
            java.lang.Boolean r1 = r0.buyer_confirm_order
            r39 = r1
            com.shopee.protocol.shop.CartPriceInfo r1 = r0.cart_price_info
            r40 = r1
            com.shopee.protocol.shop.Shop r1 = r0.shop_snapshot
            r41 = r1
            java.lang.Long r1 = r0.payment_flag
            r42 = r1
            java.lang.String r1 = r0.model_name
            r43 = r1
            java.lang.Long r1 = r0.escrow_shipping_fee
            r44 = r1
            java.lang.Long r1 = r0.modelid
            r45 = r1
            java.lang.Long r1 = r0.snapshotid
            r46 = r1
            java.lang.Long r1 = r0.rebate_shipping_fee
            r47 = r1
            java.lang.Long r1 = r0.shipping_fee_max_discount
            r48 = r1
            e.f r1 = r0.trans_detail_shipping_fee
            r49 = r1
            java.lang.Integer r1 = r0.days_can_extend
            r50 = r1
            e.f r1 = r0.seller_note
            r51 = r1
            java.lang.Long r1 = r0.shop_snapshot_id
            r52 = r1
            java.lang.Integer r1 = r0.buyer_is_rated
            r53 = r1
            java.lang.Integer r1 = r0.rate_by_date
            r54 = r1
            java.lang.Integer r1 = r0.seller_is_rated
            r55 = r1
            java.lang.Long r1 = r0.buyer_rate_cmtid
            r56 = r1
            java.lang.Long r1 = r0.seller_rate_cmtid
            r57 = r1
            java.lang.Long r1 = r0.detail_flag
            r58 = r1
            java.util.List<com.shopee.protocol.shop.OrderDetailedStatus> r1 = r0.detailed_statuses
            r59 = r1
            java.lang.Long r1 = r0.escrow_to_seller
            r60 = r1
            java.lang.Long r1 = r0.contractual_carrier_shipping_fee
            r61 = r1
            com.shopee.protocol.shop.CoinInfo r1 = r0.coin_info
            r62 = r1
            java.lang.Boolean r1 = r0.not_stats
            r63 = r1
            java.lang.String r1 = r0.payer_veri_fail_reason
            r64 = r1
            java.util.List<com.shopee.protocol.shop.FraudInfo> r1 = r0.fraud_info
            r65 = r1
            java.lang.Boolean r1 = r0.first_item_is_wholesale
            r66 = r1
            java.lang.Boolean r1 = r0.is_ad_order
            r67 = r1
            com.shopee.protocol.shop.CardPromotionOrderInfo r1 = r0.card_promotion_info
            r68 = r1
            java.lang.Long r1 = r0.comm_fee
            r69 = r1
            com.shopee.protocol.shop.CardTxnFeeOrderInfo r1 = r0.card_txn_fee_info
            r70 = r1
            java.lang.Long r1 = r0.estimated_escrow
            r71 = r1
            java.lang.Long r1 = r0.rebate_price
            r72 = r1
            java.lang.Long r1 = r0.wallet_transaction_id
            r73 = r1
            java.lang.Integer r1 = r0.buyercancel_pending_time
            r74 = r1
            java.lang.Boolean r1 = r0.is_buyercancel_toship
            r75 = r1
            java.lang.Boolean r1 = r0.official_shop
            r76 = r1
            java.lang.Integer r1 = r0.buyer_cancel_reason
            r77 = r1
            java.lang.Boolean r1 = r0.instant_buyercancel_toship
            r78 = r1
            java.lang.Integer r1 = r0.first_item_free_return_day
            r79 = r1
            java.lang.Integer r1 = r0.ratecancel_by_date
            r80 = r1
            com.shopee.protocol.shop.OrderTaxInfo r1 = r0.tax_info
            r81 = r1
            com.shopee.protocol.shop.OrderDropshippingInfo r1 = r0.dropshipping_info
            r82 = r1
            java.lang.Boolean r1 = r0.first_item_is_bundle
            r83 = r1
            java.lang.Integer r1 = r0.auto_cancel_arrange_ship_date
            r84 = r1
            java.lang.Integer r1 = r0.auto_cancel_3pl_ack_date
            r85 = r1
            java.lang.Integer r1 = r0.db_version
            r86 = r1
            com.shopee.protocol.shop.CardTxnFeeOrderInfo r1 = r0.buyer_txn_fee_info
            r87 = r1
            java.lang.Long r1 = r0.order_ext_data_ref
            r88 = r1
            java.lang.Long r1 = r0.group_buy_groupid
            r89 = r1
            java.lang.Long r1 = r0.group_shipping_id
            r90 = r1
            java.lang.Integer r1 = r0.group_buy_payment_end_time
            r91 = r1
            java.lang.Long r1 = r0.bank_transfer_time
            r92 = r1
            java.lang.Boolean r1 = r0.is_group_buy_ongoing
            r93 = r1
            com.shopee.protocol.shop.LogisticsVoucherInfo r1 = r0.free_shipping_voucher
            r94 = r1
            java.lang.Integer r1 = r0.last_change_address_time
            r95 = r1
            com.shopee.protocol.shop.CardTxnFeeOrderInfo r1 = r0.admin_fee
            r96 = r1
            java.lang.Long r1 = r0.channel_payee_account_id
            r97 = r1
            java.lang.Long r1 = r0.buyer_user_location_snapshot_id
            r98 = r1
            java.lang.Long r1 = r0.seller_user_location_snapshot_id
            r99 = r1
            java.lang.Boolean r1 = r0.is_slash_price
            r100 = r1
            java.lang.Boolean r1 = r0.is_ship_from_overseas
            r101 = r1
            java.lang.Long r1 = r0.actual_buyer_paid_shipping_fee
            r102 = r1
            com.shopee.protocol.shop.JkoAccountSeller r1 = r0.jko_seller_info
            r103 = r1
            java.lang.Boolean r1 = r0.post_return_completed_steps_not_executed
            r104 = r1
            java.lang.Boolean r1 = r0.using_wallet
            r105 = r1
            com.shopee.protocol.shop.ServiceFeeOrderInfo r1 = r0.service_fee_info
            r106 = r1
            java.lang.Integer r1 = r0.cdt_with_ext
            r107 = r1
            java.lang.Integer r1 = r0.fe_receive_time
            r108 = r1
            r1 = r109
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108)
            r110.setBuilder(r111)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderExtInfo.<init>(com.shopee.protocol.shop.OrderExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderExtInfo)) {
            return false;
        }
        OrderExtInfo orderExtInfo = (OrderExtInfo) obj;
        if (!equals((List<?>) this.item_image, (List<?>) orderExtInfo.item_image) || !equals((Object) this.item_name, (Object) orderExtInfo.item_name) || !equals((Object) this.item_price, (Object) orderExtInfo.item_price) || !equals((Object) this.order_price, (Object) orderExtInfo.order_price) || !equals((Object) this.buy_count, (Object) orderExtInfo.buy_count) || !equals((Object) this.item_count, (Object) orderExtInfo.item_count) || !equals((Object) this.total_count, (Object) orderExtInfo.total_count) || !equals((Object) this.seller_userid, (Object) orderExtInfo.seller_userid) || !equals((Object) this.days_to_ship, (Object) orderExtInfo.days_to_ship) || !equals((Object) this.days_to_delivery, (Object) orderExtInfo.days_to_delivery) || !equals((Object) this.days_to_confirm, (Object) orderExtInfo.days_to_confirm) || !equals((Object) this.days_extended, (Object) orderExtInfo.days_extended) || !equals((Object) this.days_to_pay, (Object) orderExtInfo.days_to_pay) || !equals((Object) this.cancel_reason, (Object) orderExtInfo.cancel_reason) || !equals((Object) this.first_itemid, (Object) orderExtInfo.first_itemid) || !equals((Object) this.first_item_return, (Object) orderExtInfo.first_item_return) || !equals((Object) this.release_time, (Object) orderExtInfo.release_time) || !equals((Object) this.cancel_userid, (Object) orderExtInfo.cancel_userid) || !equals((Object) this.batchid, (Object) orderExtInfo.batchid) || !equals((Object) this.payment_channel_name, (Object) orderExtInfo.payment_channel_name) || !equals((Object) this.seller_due_date, (Object) orderExtInfo.seller_due_date) || !equals((Object) this.payby_date, (Object) orderExtInfo.payby_date) || !equals((Object) this.price_before_discount, (Object) orderExtInfo.price_before_discount) || !equals((Object) this.discount_percentage, (Object) orderExtInfo.discount_percentage) || !equals((Object) this.promotion_info, (Object) orderExtInfo.promotion_info) || !equals((Object) this.item_price_before_discount, (Object) orderExtInfo.item_price_before_discount) || !equals((Object) this.buyer_address, (Object) orderExtInfo.buyer_address) || !equals((Object) this.seller_address, (Object) orderExtInfo.seller_address) || !equals((Object) this.logistics_info, (Object) orderExtInfo.logistics_info) || !equals((Object) this.arrange_pickup_by_date, (Object) orderExtInfo.arrange_pickup_by_date) || !equals((Object) this.ship_by_date, (Object) orderExtInfo.ship_by_date) || !equals((Object) this.discount_shipping_fee, (Object) orderExtInfo.discount_shipping_fee) || !equals((Object) this.origin_shipping_fee, (Object) orderExtInfo.origin_shipping_fee) || !equals((Object) this.carrier_shipping_fee, (Object) orderExtInfo.carrier_shipping_fee) || !equals((Object) this.cod_process_by_date, (Object) orderExtInfo.cod_process_by_date) || !equals((Object) this.days_toship_extended, (Object) orderExtInfo.days_toship_extended) || !equals((Object) this.is_from_webcheckout, (Object) orderExtInfo.is_from_webcheckout) || !equals((Object) this.buyer_confirm_order, (Object) orderExtInfo.buyer_confirm_order) || !equals((Object) this.cart_price_info, (Object) orderExtInfo.cart_price_info) || !equals((Object) this.shop_snapshot, (Object) orderExtInfo.shop_snapshot) || !equals((Object) this.payment_flag, (Object) orderExtInfo.payment_flag) || !equals((Object) this.model_name, (Object) orderExtInfo.model_name) || !equals((Object) this.escrow_shipping_fee, (Object) orderExtInfo.escrow_shipping_fee) || !equals((Object) this.modelid, (Object) orderExtInfo.modelid) || !equals((Object) this.snapshotid, (Object) orderExtInfo.snapshotid) || !equals((Object) this.rebate_shipping_fee, (Object) orderExtInfo.rebate_shipping_fee) || !equals((Object) this.shipping_fee_max_discount, (Object) orderExtInfo.shipping_fee_max_discount) || !equals((Object) this.trans_detail_shipping_fee, (Object) orderExtInfo.trans_detail_shipping_fee) || !equals((Object) this.days_can_extend, (Object) orderExtInfo.days_can_extend) || !equals((Object) this.seller_note, (Object) orderExtInfo.seller_note) || !equals((Object) this.shop_snapshot_id, (Object) orderExtInfo.shop_snapshot_id) || !equals((Object) this.buyer_is_rated, (Object) orderExtInfo.buyer_is_rated) || !equals((Object) this.rate_by_date, (Object) orderExtInfo.rate_by_date) || !equals((Object) this.seller_is_rated, (Object) orderExtInfo.seller_is_rated) || !equals((Object) this.buyer_rate_cmtid, (Object) orderExtInfo.buyer_rate_cmtid) || !equals((Object) this.seller_rate_cmtid, (Object) orderExtInfo.seller_rate_cmtid) || !equals((Object) this.detail_flag, (Object) orderExtInfo.detail_flag) || !equals((List<?>) this.detailed_statuses, (List<?>) orderExtInfo.detailed_statuses) || !equals((Object) this.escrow_to_seller, (Object) orderExtInfo.escrow_to_seller) || !equals((Object) this.contractual_carrier_shipping_fee, (Object) orderExtInfo.contractual_carrier_shipping_fee) || !equals((Object) this.coin_info, (Object) orderExtInfo.coin_info) || !equals((Object) this.not_stats, (Object) orderExtInfo.not_stats) || !equals((Object) this.payer_veri_fail_reason, (Object) orderExtInfo.payer_veri_fail_reason) || !equals((List<?>) this.fraud_info, (List<?>) orderExtInfo.fraud_info) || !equals((Object) this.first_item_is_wholesale, (Object) orderExtInfo.first_item_is_wholesale) || !equals((Object) this.is_ad_order, (Object) orderExtInfo.is_ad_order) || !equals((Object) this.card_promotion_info, (Object) orderExtInfo.card_promotion_info) || !equals((Object) this.comm_fee, (Object) orderExtInfo.comm_fee) || !equals((Object) this.card_txn_fee_info, (Object) orderExtInfo.card_txn_fee_info) || !equals((Object) this.estimated_escrow, (Object) orderExtInfo.estimated_escrow) || !equals((Object) this.rebate_price, (Object) orderExtInfo.rebate_price) || !equals((Object) this.wallet_transaction_id, (Object) orderExtInfo.wallet_transaction_id) || !equals((Object) this.buyercancel_pending_time, (Object) orderExtInfo.buyercancel_pending_time) || !equals((Object) this.is_buyercancel_toship, (Object) orderExtInfo.is_buyercancel_toship) || !equals((Object) this.official_shop, (Object) orderExtInfo.official_shop) || !equals((Object) this.buyer_cancel_reason, (Object) orderExtInfo.buyer_cancel_reason) || !equals((Object) this.instant_buyercancel_toship, (Object) orderExtInfo.instant_buyercancel_toship) || !equals((Object) this.first_item_free_return_day, (Object) orderExtInfo.first_item_free_return_day) || !equals((Object) this.ratecancel_by_date, (Object) orderExtInfo.ratecancel_by_date) || !equals((Object) this.tax_info, (Object) orderExtInfo.tax_info) || !equals((Object) this.dropshipping_info, (Object) orderExtInfo.dropshipping_info) || !equals((Object) this.first_item_is_bundle, (Object) orderExtInfo.first_item_is_bundle) || !equals((Object) this.auto_cancel_arrange_ship_date, (Object) orderExtInfo.auto_cancel_arrange_ship_date) || !equals((Object) this.auto_cancel_3pl_ack_date, (Object) orderExtInfo.auto_cancel_3pl_ack_date) || !equals((Object) this.db_version, (Object) orderExtInfo.db_version) || !equals((Object) this.buyer_txn_fee_info, (Object) orderExtInfo.buyer_txn_fee_info) || !equals((Object) this.order_ext_data_ref, (Object) orderExtInfo.order_ext_data_ref) || !equals((Object) this.group_buy_groupid, (Object) orderExtInfo.group_buy_groupid) || !equals((Object) this.group_shipping_id, (Object) orderExtInfo.group_shipping_id) || !equals((Object) this.group_buy_payment_end_time, (Object) orderExtInfo.group_buy_payment_end_time) || !equals((Object) this.bank_transfer_time, (Object) orderExtInfo.bank_transfer_time) || !equals((Object) this.is_group_buy_ongoing, (Object) orderExtInfo.is_group_buy_ongoing) || !equals((Object) this.free_shipping_voucher, (Object) orderExtInfo.free_shipping_voucher) || !equals((Object) this.last_change_address_time, (Object) orderExtInfo.last_change_address_time) || !equals((Object) this.admin_fee, (Object) orderExtInfo.admin_fee) || !equals((Object) this.channel_payee_account_id, (Object) orderExtInfo.channel_payee_account_id) || !equals((Object) this.buyer_user_location_snapshot_id, (Object) orderExtInfo.buyer_user_location_snapshot_id) || !equals((Object) this.seller_user_location_snapshot_id, (Object) orderExtInfo.seller_user_location_snapshot_id) || !equals((Object) this.is_slash_price, (Object) orderExtInfo.is_slash_price) || !equals((Object) this.is_ship_from_overseas, (Object) orderExtInfo.is_ship_from_overseas) || !equals((Object) this.actual_buyer_paid_shipping_fee, (Object) orderExtInfo.actual_buyer_paid_shipping_fee) || !equals((Object) this.jko_seller_info, (Object) orderExtInfo.jko_seller_info) || !equals((Object) this.post_return_completed_steps_not_executed, (Object) orderExtInfo.post_return_completed_steps_not_executed) || !equals((Object) this.using_wallet, (Object) orderExtInfo.using_wallet) || !equals((Object) this.service_fee_info, (Object) orderExtInfo.service_fee_info) || !equals((Object) this.cdt_with_ext, (Object) orderExtInfo.cdt_with_ext) || !equals((Object) this.fe_receive_time, (Object) orderExtInfo.fe_receive_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<String> list = this.item_image;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.item_name;
        int i3 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.item_price;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.order_price;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.buy_count;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.item_count;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.total_count;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.seller_userid;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.days_to_ship;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.days_to_delivery;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.days_to_confirm;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.days_extended;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.days_to_pay;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.cancel_reason;
        int hashCode14 = (hashCode13 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Long l3 = this.first_itemid;
        int hashCode15 = (hashCode14 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Boolean bool = this.first_item_return;
        int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num11 = this.release_time;
        int hashCode17 = (hashCode16 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.cancel_userid;
        int hashCode18 = (hashCode17 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.batchid;
        int hashCode19 = (hashCode18 + (num13 != null ? num13.hashCode() : 0)) * 37;
        String str2 = this.payment_channel_name;
        int hashCode20 = (hashCode19 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num14 = this.seller_due_date;
        int hashCode21 = (hashCode20 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.payby_date;
        int hashCode22 = (hashCode21 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Long l4 = this.price_before_discount;
        int hashCode23 = (hashCode22 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num16 = this.discount_percentage;
        int hashCode24 = (hashCode23 + (num16 != null ? num16.hashCode() : 0)) * 37;
        PromotionInfo promotionInfo = this.promotion_info;
        int hashCode25 = (hashCode24 + (promotionInfo != null ? promotionInfo.hashCode() : 0)) * 37;
        Long l5 = this.item_price_before_discount;
        int hashCode26 = (hashCode25 + (l5 != null ? l5.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.buyer_address;
        int hashCode27 = (hashCode26 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress2 = this.seller_address;
        int hashCode28 = (hashCode27 + (buyerAddress2 != null ? buyerAddress2.hashCode() : 0)) * 37;
        OrderLogisticsInfo orderLogisticsInfo = this.logistics_info;
        int hashCode29 = (hashCode28 + (orderLogisticsInfo != null ? orderLogisticsInfo.hashCode() : 0)) * 37;
        Integer num17 = this.arrange_pickup_by_date;
        int hashCode30 = (hashCode29 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.ship_by_date;
        int hashCode31 = (hashCode30 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Long l6 = this.discount_shipping_fee;
        int hashCode32 = (hashCode31 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.origin_shipping_fee;
        int hashCode33 = (hashCode32 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.carrier_shipping_fee;
        int hashCode34 = (hashCode33 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Integer num19 = this.cod_process_by_date;
        int hashCode35 = (hashCode34 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.days_toship_extended;
        int hashCode36 = (hashCode35 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.is_from_webcheckout;
        int hashCode37 = (hashCode36 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Boolean bool2 = this.buyer_confirm_order;
        int hashCode38 = (hashCode37 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        CartPriceInfo cartPriceInfo = this.cart_price_info;
        int hashCode39 = (hashCode38 + (cartPriceInfo != null ? cartPriceInfo.hashCode() : 0)) * 37;
        Shop shop = this.shop_snapshot;
        int hashCode40 = (hashCode39 + (shop != null ? shop.hashCode() : 0)) * 37;
        Long l9 = this.payment_flag;
        int hashCode41 = (hashCode40 + (l9 != null ? l9.hashCode() : 0)) * 37;
        String str3 = this.model_name;
        int hashCode42 = (hashCode41 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l10 = this.escrow_shipping_fee;
        int hashCode43 = (hashCode42 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Long l11 = this.modelid;
        int hashCode44 = (hashCode43 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Long l12 = this.snapshotid;
        int hashCode45 = (hashCode44 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Long l13 = this.rebate_shipping_fee;
        int hashCode46 = (hashCode45 + (l13 != null ? l13.hashCode() : 0)) * 37;
        Long l14 = this.shipping_fee_max_discount;
        int hashCode47 = (hashCode46 + (l14 != null ? l14.hashCode() : 0)) * 37;
        f fVar = this.trans_detail_shipping_fee;
        int hashCode48 = (hashCode47 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num22 = this.days_can_extend;
        int hashCode49 = (hashCode48 + (num22 != null ? num22.hashCode() : 0)) * 37;
        f fVar2 = this.seller_note;
        int hashCode50 = (hashCode49 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Long l15 = this.shop_snapshot_id;
        int hashCode51 = (hashCode50 + (l15 != null ? l15.hashCode() : 0)) * 37;
        Integer num23 = this.buyer_is_rated;
        int hashCode52 = (hashCode51 + (num23 != null ? num23.hashCode() : 0)) * 37;
        Integer num24 = this.rate_by_date;
        int hashCode53 = (hashCode52 + (num24 != null ? num24.hashCode() : 0)) * 37;
        Integer num25 = this.seller_is_rated;
        int hashCode54 = (hashCode53 + (num25 != null ? num25.hashCode() : 0)) * 37;
        Long l16 = this.buyer_rate_cmtid;
        int hashCode55 = (hashCode54 + (l16 != null ? l16.hashCode() : 0)) * 37;
        Long l17 = this.seller_rate_cmtid;
        int hashCode56 = (hashCode55 + (l17 != null ? l17.hashCode() : 0)) * 37;
        Long l18 = this.detail_flag;
        int hashCode57 = (hashCode56 + (l18 != null ? l18.hashCode() : 0)) * 37;
        List<OrderDetailedStatus> list2 = this.detailed_statuses;
        int hashCode58 = (hashCode57 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Long l19 = this.escrow_to_seller;
        int hashCode59 = (hashCode58 + (l19 != null ? l19.hashCode() : 0)) * 37;
        Long l20 = this.contractual_carrier_shipping_fee;
        int hashCode60 = (hashCode59 + (l20 != null ? l20.hashCode() : 0)) * 37;
        CoinInfo coinInfo = this.coin_info;
        int hashCode61 = (hashCode60 + (coinInfo != null ? coinInfo.hashCode() : 0)) * 37;
        Boolean bool3 = this.not_stats;
        int hashCode62 = (hashCode61 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        String str4 = this.payer_veri_fail_reason;
        int hashCode63 = (hashCode62 + (str4 != null ? str4.hashCode() : 0)) * 37;
        List<FraudInfo> list3 = this.fraud_info;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i4 = (hashCode63 + i2) * 37;
        Boolean bool4 = this.first_item_is_wholesale;
        int hashCode64 = (i4 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.is_ad_order;
        int hashCode65 = (hashCode64 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        CardPromotionOrderInfo cardPromotionOrderInfo = this.card_promotion_info;
        int hashCode66 = (hashCode65 + (cardPromotionOrderInfo != null ? cardPromotionOrderInfo.hashCode() : 0)) * 37;
        Long l21 = this.comm_fee;
        int hashCode67 = (hashCode66 + (l21 != null ? l21.hashCode() : 0)) * 37;
        CardTxnFeeOrderInfo cardTxnFeeOrderInfo = this.card_txn_fee_info;
        int hashCode68 = (hashCode67 + (cardTxnFeeOrderInfo != null ? cardTxnFeeOrderInfo.hashCode() : 0)) * 37;
        Long l22 = this.estimated_escrow;
        int hashCode69 = (hashCode68 + (l22 != null ? l22.hashCode() : 0)) * 37;
        Long l23 = this.rebate_price;
        int hashCode70 = (hashCode69 + (l23 != null ? l23.hashCode() : 0)) * 37;
        Long l24 = this.wallet_transaction_id;
        int hashCode71 = (hashCode70 + (l24 != null ? l24.hashCode() : 0)) * 37;
        Integer num26 = this.buyercancel_pending_time;
        int hashCode72 = (hashCode71 + (num26 != null ? num26.hashCode() : 0)) * 37;
        Boolean bool6 = this.is_buyercancel_toship;
        int hashCode73 = (hashCode72 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Boolean bool7 = this.official_shop;
        int hashCode74 = (hashCode73 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Integer num27 = this.buyer_cancel_reason;
        int hashCode75 = (hashCode74 + (num27 != null ? num27.hashCode() : 0)) * 37;
        Boolean bool8 = this.instant_buyercancel_toship;
        int hashCode76 = (hashCode75 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Integer num28 = this.first_item_free_return_day;
        int hashCode77 = (hashCode76 + (num28 != null ? num28.hashCode() : 0)) * 37;
        Integer num29 = this.ratecancel_by_date;
        int hashCode78 = (hashCode77 + (num29 != null ? num29.hashCode() : 0)) * 37;
        OrderTaxInfo orderTaxInfo = this.tax_info;
        int hashCode79 = (hashCode78 + (orderTaxInfo != null ? orderTaxInfo.hashCode() : 0)) * 37;
        OrderDropshippingInfo orderDropshippingInfo = this.dropshipping_info;
        int hashCode80 = (hashCode79 + (orderDropshippingInfo != null ? orderDropshippingInfo.hashCode() : 0)) * 37;
        Boolean bool9 = this.first_item_is_bundle;
        int hashCode81 = (hashCode80 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        Integer num30 = this.auto_cancel_arrange_ship_date;
        int hashCode82 = (hashCode81 + (num30 != null ? num30.hashCode() : 0)) * 37;
        Integer num31 = this.auto_cancel_3pl_ack_date;
        int hashCode83 = (hashCode82 + (num31 != null ? num31.hashCode() : 0)) * 37;
        Integer num32 = this.db_version;
        int hashCode84 = (hashCode83 + (num32 != null ? num32.hashCode() : 0)) * 37;
        CardTxnFeeOrderInfo cardTxnFeeOrderInfo2 = this.buyer_txn_fee_info;
        int hashCode85 = (hashCode84 + (cardTxnFeeOrderInfo2 != null ? cardTxnFeeOrderInfo2.hashCode() : 0)) * 37;
        Long l25 = this.order_ext_data_ref;
        int hashCode86 = (hashCode85 + (l25 != null ? l25.hashCode() : 0)) * 37;
        Long l26 = this.group_buy_groupid;
        int hashCode87 = (hashCode86 + (l26 != null ? l26.hashCode() : 0)) * 37;
        Long l27 = this.group_shipping_id;
        int hashCode88 = (hashCode87 + (l27 != null ? l27.hashCode() : 0)) * 37;
        Integer num33 = this.group_buy_payment_end_time;
        int hashCode89 = (hashCode88 + (num33 != null ? num33.hashCode() : 0)) * 37;
        Long l28 = this.bank_transfer_time;
        int hashCode90 = (hashCode89 + (l28 != null ? l28.hashCode() : 0)) * 37;
        Boolean bool10 = this.is_group_buy_ongoing;
        int hashCode91 = (hashCode90 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
        LogisticsVoucherInfo logisticsVoucherInfo = this.free_shipping_voucher;
        int hashCode92 = (hashCode91 + (logisticsVoucherInfo != null ? logisticsVoucherInfo.hashCode() : 0)) * 37;
        Integer num34 = this.last_change_address_time;
        int hashCode93 = (hashCode92 + (num34 != null ? num34.hashCode() : 0)) * 37;
        CardTxnFeeOrderInfo cardTxnFeeOrderInfo3 = this.admin_fee;
        int hashCode94 = (hashCode93 + (cardTxnFeeOrderInfo3 != null ? cardTxnFeeOrderInfo3.hashCode() : 0)) * 37;
        Long l29 = this.channel_payee_account_id;
        int hashCode95 = (hashCode94 + (l29 != null ? l29.hashCode() : 0)) * 37;
        Long l30 = this.buyer_user_location_snapshot_id;
        int hashCode96 = (hashCode95 + (l30 != null ? l30.hashCode() : 0)) * 37;
        Long l31 = this.seller_user_location_snapshot_id;
        int hashCode97 = (hashCode96 + (l31 != null ? l31.hashCode() : 0)) * 37;
        Boolean bool11 = this.is_slash_price;
        int hashCode98 = (hashCode97 + (bool11 != null ? bool11.hashCode() : 0)) * 37;
        Boolean bool12 = this.is_ship_from_overseas;
        int hashCode99 = (hashCode98 + (bool12 != null ? bool12.hashCode() : 0)) * 37;
        Long l32 = this.actual_buyer_paid_shipping_fee;
        int hashCode100 = (hashCode99 + (l32 != null ? l32.hashCode() : 0)) * 37;
        JkoAccountSeller jkoAccountSeller = this.jko_seller_info;
        int hashCode101 = (hashCode100 + (jkoAccountSeller != null ? jkoAccountSeller.hashCode() : 0)) * 37;
        Boolean bool13 = this.post_return_completed_steps_not_executed;
        int hashCode102 = (hashCode101 + (bool13 != null ? bool13.hashCode() : 0)) * 37;
        Boolean bool14 = this.using_wallet;
        int hashCode103 = (hashCode102 + (bool14 != null ? bool14.hashCode() : 0)) * 37;
        ServiceFeeOrderInfo serviceFeeOrderInfo = this.service_fee_info;
        int hashCode104 = (hashCode103 + (serviceFeeOrderInfo != null ? serviceFeeOrderInfo.hashCode() : 0)) * 37;
        Integer num35 = this.cdt_with_ext;
        int hashCode105 = (hashCode104 + (num35 != null ? num35.hashCode() : 0)) * 37;
        Integer num36 = this.fe_receive_time;
        if (num36 != null) {
            i3 = num36.hashCode();
        }
        int i5 = hashCode105 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<OrderExtInfo> {
        public Long actual_buyer_paid_shipping_fee;
        public CardTxnFeeOrderInfo admin_fee;
        public Integer arrange_pickup_by_date;
        public Integer auto_cancel_3pl_ack_date;
        public Integer auto_cancel_arrange_ship_date;
        public Long bank_transfer_time;
        public Integer batchid;
        public Integer buy_count;
        public BuyerAddress buyer_address;
        public Integer buyer_cancel_reason;
        public Boolean buyer_confirm_order;
        public Integer buyer_is_rated;
        public Long buyer_rate_cmtid;
        public CardTxnFeeOrderInfo buyer_txn_fee_info;
        public Long buyer_user_location_snapshot_id;
        public Integer buyercancel_pending_time;
        public Integer cancel_reason;
        public Integer cancel_userid;
        public CardPromotionOrderInfo card_promotion_info;
        public CardTxnFeeOrderInfo card_txn_fee_info;
        public Long carrier_shipping_fee;
        public CartPriceInfo cart_price_info;
        public Integer cdt_with_ext;
        public Long channel_payee_account_id;
        public Integer cod_process_by_date;
        public CoinInfo coin_info;
        public Long comm_fee;
        public Long contractual_carrier_shipping_fee;
        public Integer days_can_extend;
        public Integer days_extended;
        public Integer days_to_confirm;
        public Integer days_to_delivery;
        public Integer days_to_pay;
        public Integer days_to_ship;
        public Integer days_toship_extended;
        public Integer db_version;
        public Long detail_flag;
        public List<OrderDetailedStatus> detailed_statuses;
        public Integer discount_percentage;
        public Long discount_shipping_fee;
        public OrderDropshippingInfo dropshipping_info;
        public Long escrow_shipping_fee;
        public Long escrow_to_seller;
        public Long estimated_escrow;
        public Integer fe_receive_time;
        public Integer first_item_free_return_day;
        public Boolean first_item_is_bundle;
        public Boolean first_item_is_wholesale;
        public Boolean first_item_return;
        public Long first_itemid;
        public List<FraudInfo> fraud_info;
        public LogisticsVoucherInfo free_shipping_voucher;
        public Long group_buy_groupid;
        public Integer group_buy_payment_end_time;
        public Long group_shipping_id;
        public Boolean instant_buyercancel_toship;
        public Boolean is_ad_order;
        public Boolean is_buyercancel_toship;
        public Integer is_from_webcheckout;
        public Boolean is_group_buy_ongoing;
        public Boolean is_ship_from_overseas;
        public Boolean is_slash_price;
        public Integer item_count;
        public List<String> item_image;
        public String item_name;
        public Long item_price;
        public Long item_price_before_discount;
        public JkoAccountSeller jko_seller_info;
        public Integer last_change_address_time;
        public OrderLogisticsInfo logistics_info;
        public String model_name;
        public Long modelid;
        public Boolean not_stats;
        public Boolean official_shop;
        public Long order_ext_data_ref;
        public Long order_price;
        public Long origin_shipping_fee;
        public Integer payby_date;
        public String payer_veri_fail_reason;
        public String payment_channel_name;
        public Long payment_flag;
        public Boolean post_return_completed_steps_not_executed;
        public Long price_before_discount;
        public PromotionInfo promotion_info;
        public Integer rate_by_date;
        public Integer ratecancel_by_date;
        public Long rebate_price;
        public Long rebate_shipping_fee;
        public Integer release_time;
        public BuyerAddress seller_address;
        public Integer seller_due_date;
        public Integer seller_is_rated;
        public f seller_note;
        public Long seller_rate_cmtid;
        public Long seller_user_location_snapshot_id;
        public Integer seller_userid;
        public ServiceFeeOrderInfo service_fee_info;
        public Integer ship_by_date;
        public Long shipping_fee_max_discount;
        public Shop shop_snapshot;
        public Long shop_snapshot_id;
        public Long snapshotid;
        public OrderTaxInfo tax_info;
        public Integer total_count;
        public f trans_detail_shipping_fee;
        public Boolean using_wallet;
        public Long wallet_transaction_id;

        public Builder() {
        }

        public Builder(OrderExtInfo orderExtInfo) {
            super(orderExtInfo);
            if (orderExtInfo != null) {
                this.item_image = OrderExtInfo.copyOf(orderExtInfo.item_image);
                this.item_name = orderExtInfo.item_name;
                this.item_price = orderExtInfo.item_price;
                this.order_price = orderExtInfo.order_price;
                this.buy_count = orderExtInfo.buy_count;
                this.item_count = orderExtInfo.item_count;
                this.total_count = orderExtInfo.total_count;
                this.seller_userid = orderExtInfo.seller_userid;
                this.days_to_ship = orderExtInfo.days_to_ship;
                this.days_to_delivery = orderExtInfo.days_to_delivery;
                this.days_to_confirm = orderExtInfo.days_to_confirm;
                this.days_extended = orderExtInfo.days_extended;
                this.days_to_pay = orderExtInfo.days_to_pay;
                this.cancel_reason = orderExtInfo.cancel_reason;
                this.first_itemid = orderExtInfo.first_itemid;
                this.first_item_return = orderExtInfo.first_item_return;
                this.release_time = orderExtInfo.release_time;
                this.cancel_userid = orderExtInfo.cancel_userid;
                this.batchid = orderExtInfo.batchid;
                this.payment_channel_name = orderExtInfo.payment_channel_name;
                this.seller_due_date = orderExtInfo.seller_due_date;
                this.payby_date = orderExtInfo.payby_date;
                this.price_before_discount = orderExtInfo.price_before_discount;
                this.discount_percentage = orderExtInfo.discount_percentage;
                this.promotion_info = orderExtInfo.promotion_info;
                this.item_price_before_discount = orderExtInfo.item_price_before_discount;
                this.buyer_address = orderExtInfo.buyer_address;
                this.seller_address = orderExtInfo.seller_address;
                this.logistics_info = orderExtInfo.logistics_info;
                this.arrange_pickup_by_date = orderExtInfo.arrange_pickup_by_date;
                this.ship_by_date = orderExtInfo.ship_by_date;
                this.discount_shipping_fee = orderExtInfo.discount_shipping_fee;
                this.origin_shipping_fee = orderExtInfo.origin_shipping_fee;
                this.carrier_shipping_fee = orderExtInfo.carrier_shipping_fee;
                this.cod_process_by_date = orderExtInfo.cod_process_by_date;
                this.days_toship_extended = orderExtInfo.days_toship_extended;
                this.is_from_webcheckout = orderExtInfo.is_from_webcheckout;
                this.buyer_confirm_order = orderExtInfo.buyer_confirm_order;
                this.cart_price_info = orderExtInfo.cart_price_info;
                this.shop_snapshot = orderExtInfo.shop_snapshot;
                this.payment_flag = orderExtInfo.payment_flag;
                this.model_name = orderExtInfo.model_name;
                this.escrow_shipping_fee = orderExtInfo.escrow_shipping_fee;
                this.modelid = orderExtInfo.modelid;
                this.snapshotid = orderExtInfo.snapshotid;
                this.rebate_shipping_fee = orderExtInfo.rebate_shipping_fee;
                this.shipping_fee_max_discount = orderExtInfo.shipping_fee_max_discount;
                this.trans_detail_shipping_fee = orderExtInfo.trans_detail_shipping_fee;
                this.days_can_extend = orderExtInfo.days_can_extend;
                this.seller_note = orderExtInfo.seller_note;
                this.shop_snapshot_id = orderExtInfo.shop_snapshot_id;
                this.buyer_is_rated = orderExtInfo.buyer_is_rated;
                this.rate_by_date = orderExtInfo.rate_by_date;
                this.seller_is_rated = orderExtInfo.seller_is_rated;
                this.buyer_rate_cmtid = orderExtInfo.buyer_rate_cmtid;
                this.seller_rate_cmtid = orderExtInfo.seller_rate_cmtid;
                this.detail_flag = orderExtInfo.detail_flag;
                this.detailed_statuses = OrderExtInfo.copyOf(orderExtInfo.detailed_statuses);
                this.escrow_to_seller = orderExtInfo.escrow_to_seller;
                this.contractual_carrier_shipping_fee = orderExtInfo.contractual_carrier_shipping_fee;
                this.coin_info = orderExtInfo.coin_info;
                this.not_stats = orderExtInfo.not_stats;
                this.payer_veri_fail_reason = orderExtInfo.payer_veri_fail_reason;
                this.fraud_info = OrderExtInfo.copyOf(orderExtInfo.fraud_info);
                this.first_item_is_wholesale = orderExtInfo.first_item_is_wholesale;
                this.is_ad_order = orderExtInfo.is_ad_order;
                this.card_promotion_info = orderExtInfo.card_promotion_info;
                this.comm_fee = orderExtInfo.comm_fee;
                this.card_txn_fee_info = orderExtInfo.card_txn_fee_info;
                this.estimated_escrow = orderExtInfo.estimated_escrow;
                this.rebate_price = orderExtInfo.rebate_price;
                this.wallet_transaction_id = orderExtInfo.wallet_transaction_id;
                this.buyercancel_pending_time = orderExtInfo.buyercancel_pending_time;
                this.is_buyercancel_toship = orderExtInfo.is_buyercancel_toship;
                this.official_shop = orderExtInfo.official_shop;
                this.buyer_cancel_reason = orderExtInfo.buyer_cancel_reason;
                this.instant_buyercancel_toship = orderExtInfo.instant_buyercancel_toship;
                this.first_item_free_return_day = orderExtInfo.first_item_free_return_day;
                this.ratecancel_by_date = orderExtInfo.ratecancel_by_date;
                this.tax_info = orderExtInfo.tax_info;
                this.dropshipping_info = orderExtInfo.dropshipping_info;
                this.first_item_is_bundle = orderExtInfo.first_item_is_bundle;
                this.auto_cancel_arrange_ship_date = orderExtInfo.auto_cancel_arrange_ship_date;
                this.auto_cancel_3pl_ack_date = orderExtInfo.auto_cancel_3pl_ack_date;
                this.db_version = orderExtInfo.db_version;
                this.buyer_txn_fee_info = orderExtInfo.buyer_txn_fee_info;
                this.order_ext_data_ref = orderExtInfo.order_ext_data_ref;
                this.group_buy_groupid = orderExtInfo.group_buy_groupid;
                this.group_shipping_id = orderExtInfo.group_shipping_id;
                this.group_buy_payment_end_time = orderExtInfo.group_buy_payment_end_time;
                this.bank_transfer_time = orderExtInfo.bank_transfer_time;
                this.is_group_buy_ongoing = orderExtInfo.is_group_buy_ongoing;
                this.free_shipping_voucher = orderExtInfo.free_shipping_voucher;
                this.last_change_address_time = orderExtInfo.last_change_address_time;
                this.admin_fee = orderExtInfo.admin_fee;
                this.channel_payee_account_id = orderExtInfo.channel_payee_account_id;
                this.buyer_user_location_snapshot_id = orderExtInfo.buyer_user_location_snapshot_id;
                this.seller_user_location_snapshot_id = orderExtInfo.seller_user_location_snapshot_id;
                this.is_slash_price = orderExtInfo.is_slash_price;
                this.is_ship_from_overseas = orderExtInfo.is_ship_from_overseas;
                this.actual_buyer_paid_shipping_fee = orderExtInfo.actual_buyer_paid_shipping_fee;
                this.jko_seller_info = orderExtInfo.jko_seller_info;
                this.post_return_completed_steps_not_executed = orderExtInfo.post_return_completed_steps_not_executed;
                this.using_wallet = orderExtInfo.using_wallet;
                this.service_fee_info = orderExtInfo.service_fee_info;
                this.cdt_with_ext = orderExtInfo.cdt_with_ext;
                this.fe_receive_time = orderExtInfo.fe_receive_time;
            }
        }

        public Builder item_image(List<String> list) {
            this.item_image = checkForNulls(list);
            return this;
        }

        public Builder item_name(String str) {
            this.item_name = str;
            return this;
        }

        public Builder item_price(Long l) {
            this.item_price = l;
            return this;
        }

        public Builder order_price(Long l) {
            this.order_price = l;
            return this;
        }

        public Builder buy_count(Integer num) {
            this.buy_count = num;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder seller_userid(Integer num) {
            this.seller_userid = num;
            return this;
        }

        public Builder days_to_ship(Integer num) {
            this.days_to_ship = num;
            return this;
        }

        public Builder days_to_delivery(Integer num) {
            this.days_to_delivery = num;
            return this;
        }

        public Builder days_to_confirm(Integer num) {
            this.days_to_confirm = num;
            return this;
        }

        public Builder days_extended(Integer num) {
            this.days_extended = num;
            return this;
        }

        public Builder days_to_pay(Integer num) {
            this.days_to_pay = num;
            return this;
        }

        public Builder cancel_reason(Integer num) {
            this.cancel_reason = num;
            return this;
        }

        public Builder first_itemid(Long l) {
            this.first_itemid = l;
            return this;
        }

        public Builder first_item_return(Boolean bool) {
            this.first_item_return = bool;
            return this;
        }

        public Builder release_time(Integer num) {
            this.release_time = num;
            return this;
        }

        public Builder cancel_userid(Integer num) {
            this.cancel_userid = num;
            return this;
        }

        public Builder batchid(Integer num) {
            this.batchid = num;
            return this;
        }

        public Builder payment_channel_name(String str) {
            this.payment_channel_name = str;
            return this;
        }

        public Builder seller_due_date(Integer num) {
            this.seller_due_date = num;
            return this;
        }

        public Builder payby_date(Integer num) {
            this.payby_date = num;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder discount_percentage(Integer num) {
            this.discount_percentage = num;
            return this;
        }

        public Builder promotion_info(PromotionInfo promotionInfo) {
            this.promotion_info = promotionInfo;
            return this;
        }

        public Builder item_price_before_discount(Long l) {
            this.item_price_before_discount = l;
            return this;
        }

        public Builder buyer_address(BuyerAddress buyerAddress) {
            this.buyer_address = buyerAddress;
            return this;
        }

        public Builder seller_address(BuyerAddress buyerAddress) {
            this.seller_address = buyerAddress;
            return this;
        }

        public Builder logistics_info(OrderLogisticsInfo orderLogisticsInfo) {
            this.logistics_info = orderLogisticsInfo;
            return this;
        }

        public Builder arrange_pickup_by_date(Integer num) {
            this.arrange_pickup_by_date = num;
            return this;
        }

        public Builder ship_by_date(Integer num) {
            this.ship_by_date = num;
            return this;
        }

        public Builder discount_shipping_fee(Long l) {
            this.discount_shipping_fee = l;
            return this;
        }

        public Builder origin_shipping_fee(Long l) {
            this.origin_shipping_fee = l;
            return this;
        }

        public Builder carrier_shipping_fee(Long l) {
            this.carrier_shipping_fee = l;
            return this;
        }

        public Builder cod_process_by_date(Integer num) {
            this.cod_process_by_date = num;
            return this;
        }

        public Builder days_toship_extended(Integer num) {
            this.days_toship_extended = num;
            return this;
        }

        public Builder is_from_webcheckout(Integer num) {
            this.is_from_webcheckout = num;
            return this;
        }

        public Builder buyer_confirm_order(Boolean bool) {
            this.buyer_confirm_order = bool;
            return this;
        }

        public Builder cart_price_info(CartPriceInfo cartPriceInfo) {
            this.cart_price_info = cartPriceInfo;
            return this;
        }

        public Builder shop_snapshot(Shop shop) {
            this.shop_snapshot = shop;
            return this;
        }

        public Builder payment_flag(Long l) {
            this.payment_flag = l;
            return this;
        }

        public Builder model_name(String str) {
            this.model_name = str;
            return this;
        }

        public Builder escrow_shipping_fee(Long l) {
            this.escrow_shipping_fee = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public Builder rebate_shipping_fee(Long l) {
            this.rebate_shipping_fee = l;
            return this;
        }

        public Builder shipping_fee_max_discount(Long l) {
            this.shipping_fee_max_discount = l;
            return this;
        }

        public Builder trans_detail_shipping_fee(f fVar) {
            this.trans_detail_shipping_fee = fVar;
            return this;
        }

        public Builder days_can_extend(Integer num) {
            this.days_can_extend = num;
            return this;
        }

        public Builder seller_note(f fVar) {
            this.seller_note = fVar;
            return this;
        }

        public Builder shop_snapshot_id(Long l) {
            this.shop_snapshot_id = l;
            return this;
        }

        public Builder buyer_is_rated(Integer num) {
            this.buyer_is_rated = num;
            return this;
        }

        public Builder rate_by_date(Integer num) {
            this.rate_by_date = num;
            return this;
        }

        public Builder seller_is_rated(Integer num) {
            this.seller_is_rated = num;
            return this;
        }

        public Builder buyer_rate_cmtid(Long l) {
            this.buyer_rate_cmtid = l;
            return this;
        }

        public Builder seller_rate_cmtid(Long l) {
            this.seller_rate_cmtid = l;
            return this;
        }

        public Builder detail_flag(Long l) {
            this.detail_flag = l;
            return this;
        }

        public Builder detailed_statuses(List<OrderDetailedStatus> list) {
            this.detailed_statuses = checkForNulls(list);
            return this;
        }

        public Builder escrow_to_seller(Long l) {
            this.escrow_to_seller = l;
            return this;
        }

        public Builder contractual_carrier_shipping_fee(Long l) {
            this.contractual_carrier_shipping_fee = l;
            return this;
        }

        public Builder coin_info(CoinInfo coinInfo) {
            this.coin_info = coinInfo;
            return this;
        }

        public Builder not_stats(Boolean bool) {
            this.not_stats = bool;
            return this;
        }

        public Builder payer_veri_fail_reason(String str) {
            this.payer_veri_fail_reason = str;
            return this;
        }

        public Builder fraud_info(List<FraudInfo> list) {
            this.fraud_info = checkForNulls(list);
            return this;
        }

        public Builder first_item_is_wholesale(Boolean bool) {
            this.first_item_is_wholesale = bool;
            return this;
        }

        public Builder is_ad_order(Boolean bool) {
            this.is_ad_order = bool;
            return this;
        }

        public Builder card_promotion_info(CardPromotionOrderInfo cardPromotionOrderInfo) {
            this.card_promotion_info = cardPromotionOrderInfo;
            return this;
        }

        public Builder comm_fee(Long l) {
            this.comm_fee = l;
            return this;
        }

        public Builder card_txn_fee_info(CardTxnFeeOrderInfo cardTxnFeeOrderInfo) {
            this.card_txn_fee_info = cardTxnFeeOrderInfo;
            return this;
        }

        public Builder estimated_escrow(Long l) {
            this.estimated_escrow = l;
            return this;
        }

        public Builder rebate_price(Long l) {
            this.rebate_price = l;
            return this;
        }

        public Builder wallet_transaction_id(Long l) {
            this.wallet_transaction_id = l;
            return this;
        }

        public Builder buyercancel_pending_time(Integer num) {
            this.buyercancel_pending_time = num;
            return this;
        }

        public Builder is_buyercancel_toship(Boolean bool) {
            this.is_buyercancel_toship = bool;
            return this;
        }

        public Builder official_shop(Boolean bool) {
            this.official_shop = bool;
            return this;
        }

        public Builder buyer_cancel_reason(Integer num) {
            this.buyer_cancel_reason = num;
            return this;
        }

        public Builder instant_buyercancel_toship(Boolean bool) {
            this.instant_buyercancel_toship = bool;
            return this;
        }

        public Builder first_item_free_return_day(Integer num) {
            this.first_item_free_return_day = num;
            return this;
        }

        public Builder ratecancel_by_date(Integer num) {
            this.ratecancel_by_date = num;
            return this;
        }

        public Builder tax_info(OrderTaxInfo orderTaxInfo) {
            this.tax_info = orderTaxInfo;
            return this;
        }

        public Builder dropshipping_info(OrderDropshippingInfo orderDropshippingInfo) {
            this.dropshipping_info = orderDropshippingInfo;
            return this;
        }

        public Builder first_item_is_bundle(Boolean bool) {
            this.first_item_is_bundle = bool;
            return this;
        }

        public Builder auto_cancel_arrange_ship_date(Integer num) {
            this.auto_cancel_arrange_ship_date = num;
            return this;
        }

        public Builder auto_cancel_3pl_ack_date(Integer num) {
            this.auto_cancel_3pl_ack_date = num;
            return this;
        }

        public Builder db_version(Integer num) {
            this.db_version = num;
            return this;
        }

        public Builder buyer_txn_fee_info(CardTxnFeeOrderInfo cardTxnFeeOrderInfo) {
            this.buyer_txn_fee_info = cardTxnFeeOrderInfo;
            return this;
        }

        public Builder order_ext_data_ref(Long l) {
            this.order_ext_data_ref = l;
            return this;
        }

        public Builder group_buy_groupid(Long l) {
            this.group_buy_groupid = l;
            return this;
        }

        public Builder group_shipping_id(Long l) {
            this.group_shipping_id = l;
            return this;
        }

        public Builder group_buy_payment_end_time(Integer num) {
            this.group_buy_payment_end_time = num;
            return this;
        }

        public Builder bank_transfer_time(Long l) {
            this.bank_transfer_time = l;
            return this;
        }

        public Builder is_group_buy_ongoing(Boolean bool) {
            this.is_group_buy_ongoing = bool;
            return this;
        }

        public Builder free_shipping_voucher(LogisticsVoucherInfo logisticsVoucherInfo) {
            this.free_shipping_voucher = logisticsVoucherInfo;
            return this;
        }

        public Builder last_change_address_time(Integer num) {
            this.last_change_address_time = num;
            return this;
        }

        public Builder admin_fee(CardTxnFeeOrderInfo cardTxnFeeOrderInfo) {
            this.admin_fee = cardTxnFeeOrderInfo;
            return this;
        }

        public Builder channel_payee_account_id(Long l) {
            this.channel_payee_account_id = l;
            return this;
        }

        public Builder buyer_user_location_snapshot_id(Long l) {
            this.buyer_user_location_snapshot_id = l;
            return this;
        }

        public Builder seller_user_location_snapshot_id(Long l) {
            this.seller_user_location_snapshot_id = l;
            return this;
        }

        public Builder is_slash_price(Boolean bool) {
            this.is_slash_price = bool;
            return this;
        }

        public Builder is_ship_from_overseas(Boolean bool) {
            this.is_ship_from_overseas = bool;
            return this;
        }

        public Builder actual_buyer_paid_shipping_fee(Long l) {
            this.actual_buyer_paid_shipping_fee = l;
            return this;
        }

        public Builder jko_seller_info(JkoAccountSeller jkoAccountSeller) {
            this.jko_seller_info = jkoAccountSeller;
            return this;
        }

        public Builder post_return_completed_steps_not_executed(Boolean bool) {
            this.post_return_completed_steps_not_executed = bool;
            return this;
        }

        public Builder using_wallet(Boolean bool) {
            this.using_wallet = bool;
            return this;
        }

        public Builder service_fee_info(ServiceFeeOrderInfo serviceFeeOrderInfo) {
            this.service_fee_info = serviceFeeOrderInfo;
            return this;
        }

        public Builder cdt_with_ext(Integer num) {
            this.cdt_with_ext = num;
            return this;
        }

        public Builder fe_receive_time(Integer num) {
            this.fe_receive_time = num;
            return this;
        }

        public OrderExtInfo build() {
            return new OrderExtInfo(this);
        }
    }
}
