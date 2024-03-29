package com.shopee.protocol.action;

import com.appsflyer.BuildConfig;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.squareup.wire.ProtoEnum;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.qalsdk.im_open.http;
import tencent.tls.platform.TLSErrInfo;

public enum Command implements ProtoEnum {
    CMD_ADD_ITEM(1),
    CMD_EDIT_ITEM(2),
    CMD_DEL_ITEM(3),
    CMD_GET_ITEM_DETAIL(4),
    CMD_GET_ITEM_LIST(5),
    CMD_SET_ACCOUNT(6),
    CMD_UPDATE_SHOP(7),
    CMD_GET_SHOP(8),
    CMD_GET_TXN_FEE_RULE_LIST(9),
    CMD_GET_ORDER_DETAIL(10),
    CMD_GET_ORDER_LIST(11),
    CMD_REGISTER(12),
    CMD_LOGIN(13),
    CMD_RESET_PASSWORD(14),
    CMD_SEND_VCODE(15),
    CMD_CHECK_VCODE(16),
    CMD_PAY_ORDER(17),
    CMD_ACTION_GET_IDLIST(18),
    CMD_CANCEL_ORDER(19),
    CMD_BUYER_CANCEL_ORDER(20),
    CMD_UPDATE_CANCEL_PENDING_ORDER(21),
    CMD_EDIT_ITEM_MODEL(22),
    CMD_GET_ITEM_PROMO(23),
    CMD_NOTIFICATION(24),
    CMD_GET_SNAPSHOT(25),
    CMD_REPORT_USER(26),
    CMD_GET_MIN_APPVERSION(27),
    CMD_GET_GROUP_BUY_GROUP(28),
    CMD_REPORT_ITEM(29),
    CMD_GET_CUSTOM_LIST(30),
    CMD_GET_SEARCH_CUSTOMER(31),
    CMD_GET_CUSTOM_ORDERS(32),
    CMD_CHANGE_ORDER_INFO(33),
    CMD_CHAT_COUNTS(34),
    CMD_SET_CHAT_LAST_READ(35),
    CMD_SET_PROMO_REMINDER(36),
    CMD_GET_LIKED_LIST(37),
    CMD_CHECK_PASSWORD(38),
    CMD_GET_USER_BRIEF(39),
    CMD_FOLLOW_SHOP(40),
    CMD_UNFOLLOW_SHOP(41),
    CMD_GET_FOLLOWING_LIST(42),
    CMD_ADD_ADDRESS(43),
    CMD_EDIT_ADDRESS(44),
    CMD_DEL_ADDRESS(45),
    CMD_GET_ADDRESS(46),
    CMD_GET_PROMO_REMINDER(47),
    CMD_CONFIRM_DELIVERY(48),
    CMD_VALIDATE_GROUP_BUY_ORDER(49),
    CMD_GET_SHOP_BALANCE(50),
    CMD_GET_TRANS_HISTORY(51),
    CMD_GET_TRANS_DETAIL(52),
    CMD_SET_COLLECTION(53),
    CMD_GET_COLLECTION_ITEM(54),
    CMD_GET_GROUP_BUY_CAMPAIGN(55),
    CMD_GET_COLLECTION(56),
    CMD_GET_ORDER_ITEMS_PRICE_BREAKDOWN(57),
    CMD_GET_MULTI_ORDERS(58),
    CMD_CHAT_MSG(59),
    CMD_CHAT_RECV(60),
    CMD_MSG_ACK(61),
    CMD_MSG_SEND(62),
    CMD_GET_USER_INFO(63),
    CMD_SET_CATEGORY(64),
    CMD_GET_CATEGORY_LIST(65),
    CMD_SEARCH_HINT(66),
    CMD_SET_USER_INFO(67),
    CMD_CART_REMOVE_ITEM(68),
    CMD_GET_ITEMCMT_LIST(69),
    CMD_GET_COIN_EARN_RULES(70),
    CMD_GET_CHATLIST(71),
    CMD_GET_CHATMSGID(72),
    CMD_GET_CHATMSG(73),
    CMD_CHAT_READY(74),
    CMD_MAKE_OFFER(75),
    CMD_OFFER_REPLY(76),
    CMD_FACEBOOK_LOGIN(77),
    CMD_ADD_ITEM_COMMENT(78),
    CMD_SEND_VMAIL(79),
    CMD_GET_FOLLOWER_LIST(80),
    CMD_LIKE_ITEM(81),
    CMD_UNLIKE_ITEM(82),
    CMD_CANCEL_ORDER_ITEM(83),
    CMD_CART_ADD_ITEM(84),
    CMD_VOUCHER_WALLET_SAVE_VOUCHER(85),
    CMD_CART_GET_ALL_ORDERS(86),
    CMD_CART_CHECKOUT(87),
    CMD_CART_CLEAR_ORDER(88),
    CMD_CANCEL_OFFER(89),
    CMD_SEARCH_USER(90),
    CMD_VERIFY_EMAIL(91),
    CMD_BIND_ACCOUNT(92),
    CMD_ACCOUNT_EXIST(93),
    CMD_GET_ITEM_BATCH(94),
    CMD_GET_ACTIVITY_LIST(95),
    CMD_REMOVE_ACTIVITY(96),
    CMD_GET_RETURN(97),
    CMD_GET_REC_USER_LIST(98),
    CMD_DEL_ITEM_COMMENT(99),
    CMD_SEARCH_MY_CUSTOMER(100),
    CMD_RATE_ORDER(101),
    CMD_GET_SHOPID(102),
    CMD_MARK_USER_REPORT(103),
    CMD_CART_BUY_AGAIN(104),
    CMD_ACTION_GET_CONTENT(105),
    CMD_REQUEST_RETURN(106),
    CMD_CANCEL_RETURN(107),
    CMD_CONFIRM_RETURN(108),
    CMD_FOLLOW_ALL_CONTACTS(109),
    CMD_UPDATE_CONTACTS(110),
    CMD_GET_CONTACTS(111),
    CMD_GET_CHECKOUT_ORDER(112),
    CMD_SET_ORDER(113),
    CMD_SET_RETURN(114),
    CMD_SET_REFUND(115),
    CMD_SET_CHECKOUT(116),
    CMD_VOUCHER_WALLET_GET_VOUCHERS(117),
    CMD_GET_ONLINE_USERNUM(118),
    CMD_VOUCHER_WALLET_RECOMMEND_VOUCHERS(119),
    CMD_GET_RETURN_LIST(120),
    CMD_GET_CHECKOUT(121),
    CMD_SHIP_ORDER(122),
    CMD_EXTEND_ORDER(123),
    CMD_CANCEL_CHECKOUT(124),
    CMD_GET_CHAT_QUICKREPLY(125),
    CMD_SET_CHAT_QUICKREPLY(126),
    CMD_GET_REFERRAL_RULE(127),
    CMD_GET_PENALTY_INFO(128),
    CMD_TRIGGER_NOTI(129),
    CMD_GET_REFERRAL_CODE(130),
    CMD_UNBIND_ACCOUNT(131),
    CMD_UPDATE_REFUND(132),
    CMD_RECORD_REFERRAL(133),
    CMD_PREVIEW_SET_CHECKOUT(134),
    CMD_GET_SHOP_FLASH_SALE(135),
    CMD_ARCHIVE_CHAT(136),
    CMD_GET_REFUND(137),
    CMD_GET_REFERRAL_LIST(138),
    CMD_CREATE_MULTI_ORDER(139),
    CMD_GET_UNPAID_ORDERS(140),
    CMD_GET_UNPAID_ORDER(141),
    CMD_GET_REFUND_BY_ORDER(142),
    CMD_GET_RETURNREFUND_LIST(143),
    CMD_REMOVE_FOLLOWER(IjkMediaMeta.FF_PROFILE_H264_HIGH_444),
    CMD_SET_PAYMENT_COD(145),
    CMD_CHECK_FOLLOW(146),
    CMD_GET_LIKED_IDLIST(147),
    CMD_CREATE_PROMOTION(148),
    CMD_SET_PROMOTION(149),
    CMD_DISTRIBUTE_VOUCHER(150),
    CMD_VALIDATE_VOUCHER(151),
    CMD_GENERATE_VOUCHER(152),
    CMD_CACULATE_REFUND(153),
    CMD_EDIT_PUBLICVOUCHER(154),
    CMD_UPDATE_BANKACCOUNT_ID(155),
    CMD_TRIGGER_CUSTOMIZED_NOTI(156),
    CMD_TRIGGER_CUSTOMIZED_ACTIVITY(157),
    CMD_REGISTER_DEVICE(158),
    CMD_PUSH_MESSAGE(159),
    CMD_GET_BUNDLE_DEAL_USAGE(160),
    CMD_SET_ORDER_LOGISTICS(161),
    CMD_SET_BUNDLE_DEAL(162),
    CMD_SET_BUNDLE_DEAL_ITEM(163),
    CMD_GET_BUNDLE_DEAL(164),
    CMD_LOGOUT(165),
    CMD_GET_CART_BUNDLE_DEAL_INFO(166),
    CMD_REVISE_PRICE(167),
    CMD_CART_ADD_ITEM_BATCH(168),
    CMD_VCODE_LOGIN(169),
    CMD_VALIDATE_FREE_SHIPPING_VOUCHER(170),
    CMD_VCODE_APP_LOGIN(171),
    CMD_GET_ORDER_REFUNDS(172),
    CMD_GET_TIMELINE(173),
    CMD_GET_USER_VOUCHER(174),
    CMD_GET_USER_VOUCHER_BY_TIME(181),
    CMD_SET_LIKE_ITEM_COMMENT(175),
    CMD_GET_WELCOME_PACKAGE(176),
    CMD_CHANGE_ORDER_ADDRESS(177),
    CMD_GET_EXTRACTED_HASHTAG(178),
    CMD_GET_REC_USERS(179),
    CMD_GET_COLLECTION_ITEM_DATA(180),
    CMD_GET_ITEM_PROMOTION_CAMPAIGN(182),
    CMD_GET_SLASH_PRICE_ITEM_LIST(183),
    CMD_GET_SLASH_PRICE_RULE(184),
    CMD_GET_SLASH_PRICE_ACTIVITY_LIST(185),
    CMD_GET_SLASH_PRICE_HISTORY(186),
    CMD_CHECK_ITEMS_LIKED(187),
    CMD_SET_SHADOW_CHECKOUT(188),
    CMD_GET_USER_LAST_SEEN(189),
    CMD_START_SLASH_PRICE_ACTIVITY(FacebookRequestErrorClassification.EC_INVALID_TOKEN),
    CMD_ADD_FEED_COMMENT(191),
    CMD_GET_FEED_COMMENT(JfifUtil.MARKER_SOFn),
    CMD_LIKE_FEED(193),
    CMD_VALIDATE_VOUCHER_V2(194),
    CMD_GET_CENTRAL_SESSION(195),
    CMD_BOOST_ITEM(196),
    CMD_SET_SHOP_BOOST(BuildConfig.VERSION_CODE),
    CMD_GET_SHOP_BOOST(198),
    CMD_CHECK_SELLER_PROMOTION(199),
    CMD_CHECK_TOKEN(200),
    CMD_GET_PCHATLIST(DanmaKuEntity.MESSAGE_PUBLIC),
    CMD_CREATE_REFUND(202),
    CMD_GET_OFFER(203),
    CMD_GET_OFFER_COUNT(http.No_Content),
    CMD_GET_RECENT_ITEMS(205),
    CMD_BLOCK_USER(http.Partial_Content),
    CMD_GET_BLOCK_USER_LIST(207),
    CMD_CHECK_USER_BLOCKED(JfifUtil.MARKER_RST0),
    CMD_GET_OFFER_LIST(209),
    CMD_CLEAR_CHAT_MSG(210),
    CMD_SET_CENTRAL_SESSION(211),
    CMD_GET_CHAT_ITEMS(212),
    CMD_SET_SELLER_PROMOTION_ITEM(213),
    CMD_SET_SELLER_PROMOTION_INFO(ModuleDescriptor.MODULE_VERSION),
    CMD_BATCH_SET_ITEMFLAG(JfifUtil.MARKER_RST7),
    CMD_RATE_BUYER(216),
    CMD_GET_BUYERCMT_LIST(JfifUtil.MARKER_EOI),
    CMD_GET_ITEMCMT(JfifUtil.MARKER_SOS),
    CMD_GET_SUBCATEGORY(219),
    CMD_SET_SHOP_COLLECTION(220),
    CMD_GET_SHOP_CLIST(221),
    CMD_GET_USERCMT(222),
    CMD_SET_DEVICE_RECORD(223),
    CMD_CREATE_WITHDRAWAL(224),
    CMD_SET_WITHDRAWAL(JfifUtil.MARKER_APP1),
    CMD_GET_WALLET(226),
    CMD_GET_WITHDRAWAL(227),
    CMD_GET_TRANSACTION_LIST(228),
    CMD_DEL_USER_COMMENT(TLSErrInfo.LOGIN_NO_ACCOUNT),
    CMD_GET_COIN(230),
    CMD_GET_COIN_TRANSACTION_LIST(231),
    CMD_SET_COIN_RULE(232),
    CMD_STOP_SLASH_PRICE_ACTIVITY(233),
    CMD_SLASH_PRICE(234),
    CMD_GET_ATTRIBUTE_MODEL(237),
    CMD_MATCH_ATTRIBUTE(238),
    CMD_SET_USER_COIN(239),
    CMD_GET_ITEM_SCORES(240),
    CMD_SET_CARD_PROMOTION(241),
    CMD_GET_CARD_PROMOTION(242),
    CMD_CHECK_CAPTCHA(243),
    CMD_GET_VOUCHER_LIST_V2(IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE),
    CMD_WALLET_COMPENSATE(245),
    CMD_PAYBY_WALLET_CHECK(246),
    CMD_GET_FLASH_SALE(247),
    CMD_WALLET_TOPUP_GETLIST(248),
    CMD_LINE_LOGIN(249),
    CMD_WALLET_TOPUP_ADD(250),
    CMD_GET_PROMOTION(251),
    CMD_GET_ADDRESS_TAX(252),
    CMD_GET_VOUCHER_LIST(253),
    CMD_PROTO_EXT(254),
    CMD_LONG_CMD(255);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
