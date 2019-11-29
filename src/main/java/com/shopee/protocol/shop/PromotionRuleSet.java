package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PromotionRuleSet extends Message {
    public static final Boolean DEFAULT_BACKEND_CREATED = false;
    public static final List<Integer> DEFAULT_BANKS = Collections.emptyList();
    public static final List<Integer> DEFAULT_CARRIERS = Collections.emptyList();
    public static final List<Integer> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final Long DEFAULT_CLAIM_START_TIME = 0L;
    public static final List<String> DEFAULT_CREDIT_CARD_BINS = Collections.emptyList();
    public static final List<VoucherCustomisedLabel> DEFAULT_CUSTOMISED_LABELS = Collections.emptyList();
    public static final List<VoucherCustomisedLabel> DEFAULT_CUSTOMISED_PRODUCT_SCOPE_TAGS = Collections.emptyList();
    public static final List<PromotionDelayedNoti> DEFAULT_DELAY_INFO = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISABLE_CATEGORIES = Collections.emptyList();
    public static final List<PromotionItem> DEFAULT_DISABLE_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_DISABLE_NEW_USER_DISPATCH = 0;
    public static final List<Long> DEFAULT_DISABLE_PRODUCT_LABELS = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISABLE_SHOPIDS = Collections.emptyList();
    public static final List<Integer> DEFAULT_DISPLAY_LABELS = Collections.emptyList();
    public static final List<Integer> DEFAULT_EXCLUDE_SHOP_TYPES = Collections.emptyList();
    public static final Boolean DEFAULT_HIDE = false;
    public static final String DEFAULT_ICON_HASH = "";
    public static final String DEFAULT_ICON_TEXT = "";
    public static final Boolean DEFAULT_IS_SELLER_ABSORBED = false;
    public static final List<PromotionItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Boolean DEFAULT_NON_CLAIMABLE = false;
    public static final Boolean DEFAULT_NOT_SHOW_PRODUCT_SCOPE_TAG = false;
    public static final List<Integer> DEFAULT_PAYMENT_METHOD = Collections.emptyList();
    public static final List<Long> DEFAULT_PRODUCT_LABELS = Collections.emptyList();
    public static final Long DEFAULT_PROMOTION_FRAUD_CHECK = 0L;
    public static final Integer DEFAULT_PURPOSE = 0;
    public static final Boolean DEFAULT_PUSH_EXISTSING_USER = false;
    public static final List<PromotionRule> DEFAULT_RULES = Collections.emptyList();
    public static final List<Long> DEFAULT_SHIPPING_PROMOTION_RULES = Collections.emptyList();
    public static final List<Integer> DEFAULT_SHOPIDS = Collections.emptyList();
    public static final List<Integer> DEFAULT_SHOP_TYPES = Collections.emptyList();
    public static final List<Long> DEFAULT_SPM_CHANNELS = Collections.emptyList();
    public static final String DEFAULT_SUCCESS_SHOW_MESSAGE = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USAGE_LIMIT_PER_USER = 0;
    public static final String DEFAULT_USAGE_TERM_PRODUCT = "";
    public static final List<Integer> DEFAULT_USER_AGENT_TYPES = Collections.emptyList();
    public static final String DEFAULT_USE_LINK = "";
    public static final Integer DEFAULT_VALID_DAYS = 0;
    public static final Long DEFAULT_VOUCHER_LANDING_PAGE = 0L;
    public static final List<Integer> DEFAULT_VOUCHER_PAYMENT_TYPES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 20, type = Message.Datatype.BOOL)
    public final Boolean backend_created;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT32)
    public final List<Integer> banks;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.INT32)
    public final List<Integer> carriers;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> categories;
    @ProtoField(tag = 2)
    public final PromotionUsers choose_users;
    @ProtoField(tag = 35, type = Message.Datatype.INT64)
    public final Long claim_start_time;
    @ProtoField(tag = 25)
    public final CoinCashbackVoucher coin_cashback_voucher;
    @ProtoField(label = Message.Label.REPEATED, tag = 23, type = Message.Datatype.STRING)
    public final List<String> credit_card_bins;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherCustomisedLabel.class, tag = 43)
    public final List<VoucherCustomisedLabel> customised_labels;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherCustomisedLabel.class, tag = 46)
    public final List<VoucherCustomisedLabel> customised_product_scope_tags;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromotionDelayedNoti.class, tag = 6)
    public final List<PromotionDelayedNoti> delay_info;
    @ProtoField(label = Message.Label.REPEATED, tag = 13, type = Message.Datatype.INT32)
    public final List<Integer> disable_categories;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromotionItem.class, tag = 15)
    public final List<PromotionItem> disable_items;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer disable_new_user_dispatch;
    @ProtoField(label = Message.Label.REPEATED, tag = 33, type = Message.Datatype.INT64)
    public final List<Long> disable_product_labels;
    @ProtoField(label = Message.Label.REPEATED, tag = 14, type = Message.Datatype.INT32)
    public final List<Integer> disable_shopids;
    @ProtoField(label = Message.Label.REPEATED, tag = 36, type = Message.Datatype.INT32)
    public final List<Integer> display_labels;
    @ProtoField(tag = 34)
    public final DigitalPurchaseVoucherRule dp_voucher_rule;
    @ProtoField(label = Message.Label.REPEATED, tag = 19, type = Message.Datatype.INT32)
    public final List<Integer> exclude_shop_types;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean hide;
    @ProtoField(tag = 38, type = Message.Datatype.STRING)
    public final String icon_hash;
    @ProtoField(tag = 39, type = Message.Datatype.STRING)
    public final String icon_text;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean is_seller_absorbed;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromotionItem.class, tag = 5)
    public final List<PromotionItem> items;
    @ProtoField(tag = 44, type = Message.Datatype.BOOL)
    public final Boolean non_claimable;
    @ProtoField(tag = 45, type = Message.Datatype.BOOL)
    public final Boolean not_show_product_scope_tag;
    @ProtoField(label = Message.Label.REPEATED, tag = 27, type = Message.Datatype.INT32)
    public final List<Integer> payment_method;
    @ProtoField(label = Message.Label.REPEATED, tag = 32, type = Message.Datatype.INT64)
    public final List<Long> product_labels;
    @ProtoField(tag = 26, type = Message.Datatype.INT64)
    public final Long promotion_fraud_check;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer purpose;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean push_existsing_user;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromotionRule.class, tag = 1)
    public final List<PromotionRule> rules;
    @ProtoField(label = Message.Label.REPEATED, tag = 37, type = Message.Datatype.INT64)
    public final List<Long> shipping_promotion_rules;
    @ProtoField(label = Message.Label.REPEATED, tag = 18, type = Message.Datatype.INT32)
    public final List<Integer> shop_types;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> shopids;
    @ProtoField(label = Message.Label.REPEATED, tag = 29, type = Message.Datatype.INT64)
    public final List<Long> spm_channels;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String success_show_message;
    @ProtoField(tag = 41, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer usage_limit_per_user;
    @ProtoField(tag = 42, type = Message.Datatype.STRING)
    public final String usage_term_product;
    @ProtoField(tag = 40, type = Message.Datatype.STRING)
    public final String use_link;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT32)
    public final List<Integer> user_agent_types;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer valid_days;
    @ProtoField(tag = 31, type = Message.Datatype.INT64)
    public final Long voucher_landing_page;
    @ProtoField(label = Message.Label.REPEATED, tag = 30, type = Message.Datatype.INT32)
    public final List<Integer> voucher_payment_types;

    public PromotionRuleSet(List<PromotionRule> list, PromotionUsers promotionUsers, List<Integer> list2, List<Integer> list3, List<PromotionItem> list4, List<PromotionDelayedNoti> list5, Boolean bool, List<Integer> list6, List<Integer> list7, List<Integer> list8, Integer num, String str, List<Integer> list9, List<Integer> list10, List<PromotionItem> list11, Integer num2, Boolean bool2, List<Integer> list12, List<Integer> list13, Boolean bool3, Boolean bool4, Integer num3, List<String> list14, Integer num4, CoinCashbackVoucher coinCashbackVoucher, Long l, List<Integer> list15, Integer num5, List<Long> list16, List<Integer> list17, Long l2, List<Long> list18, List<Long> list19, DigitalPurchaseVoucherRule digitalPurchaseVoucherRule, Long l3, List<Integer> list20, List<Long> list21, String str2, String str3, String str4, String str5, String str6, List<VoucherCustomisedLabel> list22, Boolean bool5, Boolean bool6, List<VoucherCustomisedLabel> list23) {
        this.rules = immutableCopyOf(list);
        this.choose_users = promotionUsers;
        this.categories = immutableCopyOf(list2);
        this.shopids = immutableCopyOf(list3);
        this.items = immutableCopyOf(list4);
        this.delay_info = immutableCopyOf(list5);
        this.push_existsing_user = bool;
        this.carriers = immutableCopyOf(list6);
        this.banks = immutableCopyOf(list7);
        this.user_agent_types = immutableCopyOf(list8);
        this.disable_new_user_dispatch = num;
        this.success_show_message = str;
        this.disable_categories = immutableCopyOf(list9);
        this.disable_shopids = immutableCopyOf(list10);
        this.disable_items = immutableCopyOf(list11);
        this.valid_days = num2;
        this.is_seller_absorbed = bool2;
        this.shop_types = immutableCopyOf(list12);
        this.exclude_shop_types = immutableCopyOf(list13);
        this.backend_created = bool3;
        this.hide = bool4;
        this.purpose = num3;
        this.credit_card_bins = immutableCopyOf(list14);
        this.type = num4;
        this.coin_cashback_voucher = coinCashbackVoucher;
        this.promotion_fraud_check = l;
        this.payment_method = immutableCopyOf(list15);
        this.usage_limit_per_user = num5;
        this.spm_channels = immutableCopyOf(list16);
        this.voucher_payment_types = immutableCopyOf(list17);
        this.voucher_landing_page = l2;
        this.product_labels = immutableCopyOf(list18);
        this.disable_product_labels = immutableCopyOf(list19);
        this.dp_voucher_rule = digitalPurchaseVoucherRule;
        this.claim_start_time = l3;
        this.display_labels = immutableCopyOf(list20);
        this.shipping_promotion_rules = immutableCopyOf(list21);
        this.icon_hash = str2;
        this.icon_text = str3;
        this.use_link = str4;
        this.title = str5;
        this.usage_term_product = str6;
        this.customised_labels = immutableCopyOf(list22);
        this.non_claimable = bool5;
        this.not_show_product_scope_tag = bool6;
        this.customised_product_scope_tags = immutableCopyOf(list23);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PromotionRuleSet(com.shopee.protocol.shop.PromotionRuleSet.Builder r50) {
        /*
            r49 = this;
            r0 = r50
            r1 = r49
            java.util.List<com.shopee.protocol.shop.PromotionRule> r2 = r0.rules
            com.shopee.protocol.shop.PromotionUsers r3 = r0.choose_users
            java.util.List<java.lang.Integer> r4 = r0.categories
            java.util.List<java.lang.Integer> r5 = r0.shopids
            java.util.List<com.shopee.protocol.shop.PromotionItem> r6 = r0.items
            java.util.List<com.shopee.protocol.shop.PromotionDelayedNoti> r7 = r0.delay_info
            java.lang.Boolean r8 = r0.push_existsing_user
            java.util.List<java.lang.Integer> r9 = r0.carriers
            java.util.List<java.lang.Integer> r10 = r0.banks
            java.util.List<java.lang.Integer> r11 = r0.user_agent_types
            java.lang.Integer r12 = r0.disable_new_user_dispatch
            java.lang.String r13 = r0.success_show_message
            java.util.List<java.lang.Integer> r14 = r0.disable_categories
            java.util.List<java.lang.Integer> r15 = r0.disable_shopids
            r48 = r1
            java.util.List<com.shopee.protocol.shop.PromotionItem> r1 = r0.disable_items
            r16 = r1
            java.lang.Integer r1 = r0.valid_days
            r17 = r1
            java.lang.Boolean r1 = r0.is_seller_absorbed
            r18 = r1
            java.util.List<java.lang.Integer> r1 = r0.shop_types
            r19 = r1
            java.util.List<java.lang.Integer> r1 = r0.exclude_shop_types
            r20 = r1
            java.lang.Boolean r1 = r0.backend_created
            r21 = r1
            java.lang.Boolean r1 = r0.hide
            r22 = r1
            java.lang.Integer r1 = r0.purpose
            r23 = r1
            java.util.List<java.lang.String> r1 = r0.credit_card_bins
            r24 = r1
            java.lang.Integer r1 = r0.type
            r25 = r1
            com.shopee.protocol.shop.CoinCashbackVoucher r1 = r0.coin_cashback_voucher
            r26 = r1
            java.lang.Long r1 = r0.promotion_fraud_check
            r27 = r1
            java.util.List<java.lang.Integer> r1 = r0.payment_method
            r28 = r1
            java.lang.Integer r1 = r0.usage_limit_per_user
            r29 = r1
            java.util.List<java.lang.Long> r1 = r0.spm_channels
            r30 = r1
            java.util.List<java.lang.Integer> r1 = r0.voucher_payment_types
            r31 = r1
            java.lang.Long r1 = r0.voucher_landing_page
            r32 = r1
            java.util.List<java.lang.Long> r1 = r0.product_labels
            r33 = r1
            java.util.List<java.lang.Long> r1 = r0.disable_product_labels
            r34 = r1
            com.shopee.protocol.shop.DigitalPurchaseVoucherRule r1 = r0.dp_voucher_rule
            r35 = r1
            java.lang.Long r1 = r0.claim_start_time
            r36 = r1
            java.util.List<java.lang.Integer> r1 = r0.display_labels
            r37 = r1
            java.util.List<java.lang.Long> r1 = r0.shipping_promotion_rules
            r38 = r1
            java.lang.String r1 = r0.icon_hash
            r39 = r1
            java.lang.String r1 = r0.icon_text
            r40 = r1
            java.lang.String r1 = r0.use_link
            r41 = r1
            java.lang.String r1 = r0.title
            r42 = r1
            java.lang.String r1 = r0.usage_term_product
            r43 = r1
            java.util.List<com.shopee.protocol.shop.VoucherCustomisedLabel> r1 = r0.customised_labels
            r44 = r1
            java.lang.Boolean r1 = r0.non_claimable
            r45 = r1
            java.lang.Boolean r1 = r0.not_show_product_scope_tag
            r46 = r1
            java.util.List<com.shopee.protocol.shop.VoucherCustomisedLabel> r1 = r0.customised_product_scope_tags
            r47 = r1
            r1 = r48
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47)
            r49.setBuilder(r50)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.PromotionRuleSet.<init>(com.shopee.protocol.shop.PromotionRuleSet$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromotionRuleSet)) {
            return false;
        }
        PromotionRuleSet promotionRuleSet = (PromotionRuleSet) obj;
        if (!equals((List<?>) this.rules, (List<?>) promotionRuleSet.rules) || !equals((Object) this.choose_users, (Object) promotionRuleSet.choose_users) || !equals((List<?>) this.categories, (List<?>) promotionRuleSet.categories) || !equals((List<?>) this.shopids, (List<?>) promotionRuleSet.shopids) || !equals((List<?>) this.items, (List<?>) promotionRuleSet.items) || !equals((List<?>) this.delay_info, (List<?>) promotionRuleSet.delay_info) || !equals((Object) this.push_existsing_user, (Object) promotionRuleSet.push_existsing_user) || !equals((List<?>) this.carriers, (List<?>) promotionRuleSet.carriers) || !equals((List<?>) this.banks, (List<?>) promotionRuleSet.banks) || !equals((List<?>) this.user_agent_types, (List<?>) promotionRuleSet.user_agent_types) || !equals((Object) this.disable_new_user_dispatch, (Object) promotionRuleSet.disable_new_user_dispatch) || !equals((Object) this.success_show_message, (Object) promotionRuleSet.success_show_message) || !equals((List<?>) this.disable_categories, (List<?>) promotionRuleSet.disable_categories) || !equals((List<?>) this.disable_shopids, (List<?>) promotionRuleSet.disable_shopids) || !equals((List<?>) this.disable_items, (List<?>) promotionRuleSet.disable_items) || !equals((Object) this.valid_days, (Object) promotionRuleSet.valid_days) || !equals((Object) this.is_seller_absorbed, (Object) promotionRuleSet.is_seller_absorbed) || !equals((List<?>) this.shop_types, (List<?>) promotionRuleSet.shop_types) || !equals((List<?>) this.exclude_shop_types, (List<?>) promotionRuleSet.exclude_shop_types) || !equals((Object) this.backend_created, (Object) promotionRuleSet.backend_created) || !equals((Object) this.hide, (Object) promotionRuleSet.hide) || !equals((Object) this.purpose, (Object) promotionRuleSet.purpose) || !equals((List<?>) this.credit_card_bins, (List<?>) promotionRuleSet.credit_card_bins) || !equals((Object) this.type, (Object) promotionRuleSet.type) || !equals((Object) this.coin_cashback_voucher, (Object) promotionRuleSet.coin_cashback_voucher) || !equals((Object) this.promotion_fraud_check, (Object) promotionRuleSet.promotion_fraud_check) || !equals((List<?>) this.payment_method, (List<?>) promotionRuleSet.payment_method) || !equals((Object) this.usage_limit_per_user, (Object) promotionRuleSet.usage_limit_per_user) || !equals((List<?>) this.spm_channels, (List<?>) promotionRuleSet.spm_channels) || !equals((List<?>) this.voucher_payment_types, (List<?>) promotionRuleSet.voucher_payment_types) || !equals((Object) this.voucher_landing_page, (Object) promotionRuleSet.voucher_landing_page) || !equals((List<?>) this.product_labels, (List<?>) promotionRuleSet.product_labels) || !equals((List<?>) this.disable_product_labels, (List<?>) promotionRuleSet.disable_product_labels) || !equals((Object) this.dp_voucher_rule, (Object) promotionRuleSet.dp_voucher_rule) || !equals((Object) this.claim_start_time, (Object) promotionRuleSet.claim_start_time) || !equals((List<?>) this.display_labels, (List<?>) promotionRuleSet.display_labels) || !equals((List<?>) this.shipping_promotion_rules, (List<?>) promotionRuleSet.shipping_promotion_rules) || !equals((Object) this.icon_hash, (Object) promotionRuleSet.icon_hash) || !equals((Object) this.icon_text, (Object) promotionRuleSet.icon_text) || !equals((Object) this.use_link, (Object) promotionRuleSet.use_link) || !equals((Object) this.title, (Object) promotionRuleSet.title) || !equals((Object) this.usage_term_product, (Object) promotionRuleSet.usage_term_product) || !equals((List<?>) this.customised_labels, (List<?>) promotionRuleSet.customised_labels) || !equals((Object) this.non_claimable, (Object) promotionRuleSet.non_claimable) || !equals((Object) this.not_show_product_scope_tag, (Object) promotionRuleSet.not_show_product_scope_tag) || !equals((List<?>) this.customised_product_scope_tags, (List<?>) promotionRuleSet.customised_product_scope_tags)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<PromotionRule> list = this.rules;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        PromotionUsers promotionUsers = this.choose_users;
        int i3 = 0;
        int hashCode2 = (hashCode + (promotionUsers != null ? promotionUsers.hashCode() : 0)) * 37;
        List<Integer> list2 = this.categories;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.shopids;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<PromotionItem> list4 = this.items;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<PromotionDelayedNoti> list5 = this.delay_info;
        int hashCode6 = (hashCode5 + (list5 != null ? list5.hashCode() : 1)) * 37;
        Boolean bool = this.push_existsing_user;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<Integer> list6 = this.carriers;
        int hashCode8 = (hashCode7 + (list6 != null ? list6.hashCode() : 1)) * 37;
        List<Integer> list7 = this.banks;
        int hashCode9 = (hashCode8 + (list7 != null ? list7.hashCode() : 1)) * 37;
        List<Integer> list8 = this.user_agent_types;
        int hashCode10 = (hashCode9 + (list8 != null ? list8.hashCode() : 1)) * 37;
        Integer num = this.disable_new_user_dispatch;
        int hashCode11 = (hashCode10 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.success_show_message;
        int hashCode12 = (hashCode11 + (str != null ? str.hashCode() : 0)) * 37;
        List<Integer> list9 = this.disable_categories;
        int hashCode13 = (hashCode12 + (list9 != null ? list9.hashCode() : 1)) * 37;
        List<Integer> list10 = this.disable_shopids;
        int hashCode14 = (hashCode13 + (list10 != null ? list10.hashCode() : 1)) * 37;
        List<PromotionItem> list11 = this.disable_items;
        int hashCode15 = (hashCode14 + (list11 != null ? list11.hashCode() : 1)) * 37;
        Integer num2 = this.valid_days;
        int hashCode16 = (hashCode15 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_seller_absorbed;
        int hashCode17 = (hashCode16 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        List<Integer> list12 = this.shop_types;
        int hashCode18 = (hashCode17 + (list12 != null ? list12.hashCode() : 1)) * 37;
        List<Integer> list13 = this.exclude_shop_types;
        int hashCode19 = (hashCode18 + (list13 != null ? list13.hashCode() : 1)) * 37;
        Boolean bool3 = this.backend_created;
        int hashCode20 = (hashCode19 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.hide;
        int hashCode21 = (hashCode20 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num3 = this.purpose;
        int hashCode22 = (hashCode21 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<String> list14 = this.credit_card_bins;
        int hashCode23 = (hashCode22 + (list14 != null ? list14.hashCode() : 1)) * 37;
        Integer num4 = this.type;
        int hashCode24 = (hashCode23 + (num4 != null ? num4.hashCode() : 0)) * 37;
        CoinCashbackVoucher coinCashbackVoucher = this.coin_cashback_voucher;
        int hashCode25 = (hashCode24 + (coinCashbackVoucher != null ? coinCashbackVoucher.hashCode() : 0)) * 37;
        Long l = this.promotion_fraud_check;
        int hashCode26 = (hashCode25 + (l != null ? l.hashCode() : 0)) * 37;
        List<Integer> list15 = this.payment_method;
        int hashCode27 = (hashCode26 + (list15 != null ? list15.hashCode() : 1)) * 37;
        Integer num5 = this.usage_limit_per_user;
        int hashCode28 = (hashCode27 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<Long> list16 = this.spm_channels;
        int hashCode29 = (hashCode28 + (list16 != null ? list16.hashCode() : 1)) * 37;
        List<Integer> list17 = this.voucher_payment_types;
        int hashCode30 = (hashCode29 + (list17 != null ? list17.hashCode() : 1)) * 37;
        Long l2 = this.voucher_landing_page;
        int hashCode31 = (hashCode30 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<Long> list18 = this.product_labels;
        int hashCode32 = (hashCode31 + (list18 != null ? list18.hashCode() : 1)) * 37;
        List<Long> list19 = this.disable_product_labels;
        int hashCode33 = (hashCode32 + (list19 != null ? list19.hashCode() : 1)) * 37;
        DigitalPurchaseVoucherRule digitalPurchaseVoucherRule = this.dp_voucher_rule;
        int hashCode34 = (hashCode33 + (digitalPurchaseVoucherRule != null ? digitalPurchaseVoucherRule.hashCode() : 0)) * 37;
        Long l3 = this.claim_start_time;
        int hashCode35 = (hashCode34 + (l3 != null ? l3.hashCode() : 0)) * 37;
        List<Integer> list20 = this.display_labels;
        int hashCode36 = (hashCode35 + (list20 != null ? list20.hashCode() : 1)) * 37;
        List<Long> list21 = this.shipping_promotion_rules;
        int hashCode37 = (hashCode36 + (list21 != null ? list21.hashCode() : 1)) * 37;
        String str2 = this.icon_hash;
        int hashCode38 = (hashCode37 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.icon_text;
        int hashCode39 = (hashCode38 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.use_link;
        int hashCode40 = (hashCode39 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.title;
        int hashCode41 = (hashCode40 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.usage_term_product;
        int hashCode42 = (hashCode41 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<VoucherCustomisedLabel> list22 = this.customised_labels;
        int hashCode43 = (hashCode42 + (list22 != null ? list22.hashCode() : 1)) * 37;
        Boolean bool5 = this.non_claimable;
        int hashCode44 = (hashCode43 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.not_show_product_scope_tag;
        if (bool6 != null) {
            i3 = bool6.hashCode();
        }
        int i4 = (hashCode44 + i3) * 37;
        List<VoucherCustomisedLabel> list23 = this.customised_product_scope_tags;
        if (list23 != null) {
            i2 = list23.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<PromotionRuleSet> {
        public Boolean backend_created;
        public List<Integer> banks;
        public List<Integer> carriers;
        public List<Integer> categories;
        public PromotionUsers choose_users;
        public Long claim_start_time;
        public CoinCashbackVoucher coin_cashback_voucher;
        public List<String> credit_card_bins;
        public List<VoucherCustomisedLabel> customised_labels;
        public List<VoucherCustomisedLabel> customised_product_scope_tags;
        public List<PromotionDelayedNoti> delay_info;
        public List<Integer> disable_categories;
        public List<PromotionItem> disable_items;
        public Integer disable_new_user_dispatch;
        public List<Long> disable_product_labels;
        public List<Integer> disable_shopids;
        public List<Integer> display_labels;
        public DigitalPurchaseVoucherRule dp_voucher_rule;
        public List<Integer> exclude_shop_types;
        public Boolean hide;
        public String icon_hash;
        public String icon_text;
        public Boolean is_seller_absorbed;
        public List<PromotionItem> items;
        public Boolean non_claimable;
        public Boolean not_show_product_scope_tag;
        public List<Integer> payment_method;
        public List<Long> product_labels;
        public Long promotion_fraud_check;
        public Integer purpose;
        public Boolean push_existsing_user;
        public List<PromotionRule> rules;
        public List<Long> shipping_promotion_rules;
        public List<Integer> shop_types;
        public List<Integer> shopids;
        public List<Long> spm_channels;
        public String success_show_message;
        public String title;
        public Integer type;
        public Integer usage_limit_per_user;
        public String usage_term_product;
        public String use_link;
        public List<Integer> user_agent_types;
        public Integer valid_days;
        public Long voucher_landing_page;
        public List<Integer> voucher_payment_types;

        public Builder() {
        }

        public Builder(PromotionRuleSet promotionRuleSet) {
            super(promotionRuleSet);
            if (promotionRuleSet != null) {
                this.rules = PromotionRuleSet.copyOf(promotionRuleSet.rules);
                this.choose_users = promotionRuleSet.choose_users;
                this.categories = PromotionRuleSet.copyOf(promotionRuleSet.categories);
                this.shopids = PromotionRuleSet.copyOf(promotionRuleSet.shopids);
                this.items = PromotionRuleSet.copyOf(promotionRuleSet.items);
                this.delay_info = PromotionRuleSet.copyOf(promotionRuleSet.delay_info);
                this.push_existsing_user = promotionRuleSet.push_existsing_user;
                this.carriers = PromotionRuleSet.copyOf(promotionRuleSet.carriers);
                this.banks = PromotionRuleSet.copyOf(promotionRuleSet.banks);
                this.user_agent_types = PromotionRuleSet.copyOf(promotionRuleSet.user_agent_types);
                this.disable_new_user_dispatch = promotionRuleSet.disable_new_user_dispatch;
                this.success_show_message = promotionRuleSet.success_show_message;
                this.disable_categories = PromotionRuleSet.copyOf(promotionRuleSet.disable_categories);
                this.disable_shopids = PromotionRuleSet.copyOf(promotionRuleSet.disable_shopids);
                this.disable_items = PromotionRuleSet.copyOf(promotionRuleSet.disable_items);
                this.valid_days = promotionRuleSet.valid_days;
                this.is_seller_absorbed = promotionRuleSet.is_seller_absorbed;
                this.shop_types = PromotionRuleSet.copyOf(promotionRuleSet.shop_types);
                this.exclude_shop_types = PromotionRuleSet.copyOf(promotionRuleSet.exclude_shop_types);
                this.backend_created = promotionRuleSet.backend_created;
                this.hide = promotionRuleSet.hide;
                this.purpose = promotionRuleSet.purpose;
                this.credit_card_bins = PromotionRuleSet.copyOf(promotionRuleSet.credit_card_bins);
                this.type = promotionRuleSet.type;
                this.coin_cashback_voucher = promotionRuleSet.coin_cashback_voucher;
                this.promotion_fraud_check = promotionRuleSet.promotion_fraud_check;
                this.payment_method = PromotionRuleSet.copyOf(promotionRuleSet.payment_method);
                this.usage_limit_per_user = promotionRuleSet.usage_limit_per_user;
                this.spm_channels = PromotionRuleSet.copyOf(promotionRuleSet.spm_channels);
                this.voucher_payment_types = PromotionRuleSet.copyOf(promotionRuleSet.voucher_payment_types);
                this.voucher_landing_page = promotionRuleSet.voucher_landing_page;
                this.product_labels = PromotionRuleSet.copyOf(promotionRuleSet.product_labels);
                this.disable_product_labels = PromotionRuleSet.copyOf(promotionRuleSet.disable_product_labels);
                this.dp_voucher_rule = promotionRuleSet.dp_voucher_rule;
                this.claim_start_time = promotionRuleSet.claim_start_time;
                this.display_labels = PromotionRuleSet.copyOf(promotionRuleSet.display_labels);
                this.shipping_promotion_rules = PromotionRuleSet.copyOf(promotionRuleSet.shipping_promotion_rules);
                this.icon_hash = promotionRuleSet.icon_hash;
                this.icon_text = promotionRuleSet.icon_text;
                this.use_link = promotionRuleSet.use_link;
                this.title = promotionRuleSet.title;
                this.usage_term_product = promotionRuleSet.usage_term_product;
                this.customised_labels = PromotionRuleSet.copyOf(promotionRuleSet.customised_labels);
                this.non_claimable = promotionRuleSet.non_claimable;
                this.not_show_product_scope_tag = promotionRuleSet.not_show_product_scope_tag;
                this.customised_product_scope_tags = PromotionRuleSet.copyOf(promotionRuleSet.customised_product_scope_tags);
            }
        }

        public Builder rules(List<PromotionRule> list) {
            this.rules = checkForNulls(list);
            return this;
        }

        public Builder choose_users(PromotionUsers promotionUsers) {
            this.choose_users = promotionUsers;
            return this;
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

        public Builder delay_info(List<PromotionDelayedNoti> list) {
            this.delay_info = checkForNulls(list);
            return this;
        }

        public Builder push_existsing_user(Boolean bool) {
            this.push_existsing_user = bool;
            return this;
        }

        public Builder carriers(List<Integer> list) {
            this.carriers = checkForNulls(list);
            return this;
        }

        public Builder banks(List<Integer> list) {
            this.banks = checkForNulls(list);
            return this;
        }

        public Builder user_agent_types(List<Integer> list) {
            this.user_agent_types = checkForNulls(list);
            return this;
        }

        public Builder disable_new_user_dispatch(Integer num) {
            this.disable_new_user_dispatch = num;
            return this;
        }

        public Builder success_show_message(String str) {
            this.success_show_message = str;
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

        public Builder valid_days(Integer num) {
            this.valid_days = num;
            return this;
        }

        public Builder is_seller_absorbed(Boolean bool) {
            this.is_seller_absorbed = bool;
            return this;
        }

        public Builder shop_types(List<Integer> list) {
            this.shop_types = checkForNulls(list);
            return this;
        }

        public Builder exclude_shop_types(List<Integer> list) {
            this.exclude_shop_types = checkForNulls(list);
            return this;
        }

        public Builder backend_created(Boolean bool) {
            this.backend_created = bool;
            return this;
        }

        public Builder hide(Boolean bool) {
            this.hide = bool;
            return this;
        }

        public Builder purpose(Integer num) {
            this.purpose = num;
            return this;
        }

        public Builder credit_card_bins(List<String> list) {
            this.credit_card_bins = checkForNulls(list);
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder coin_cashback_voucher(CoinCashbackVoucher coinCashbackVoucher) {
            this.coin_cashback_voucher = coinCashbackVoucher;
            return this;
        }

        public Builder promotion_fraud_check(Long l) {
            this.promotion_fraud_check = l;
            return this;
        }

        public Builder payment_method(List<Integer> list) {
            this.payment_method = checkForNulls(list);
            return this;
        }

        public Builder usage_limit_per_user(Integer num) {
            this.usage_limit_per_user = num;
            return this;
        }

        public Builder spm_channels(List<Long> list) {
            this.spm_channels = checkForNulls(list);
            return this;
        }

        public Builder voucher_payment_types(List<Integer> list) {
            this.voucher_payment_types = checkForNulls(list);
            return this;
        }

        public Builder voucher_landing_page(Long l) {
            this.voucher_landing_page = l;
            return this;
        }

        public Builder product_labels(List<Long> list) {
            this.product_labels = checkForNulls(list);
            return this;
        }

        public Builder disable_product_labels(List<Long> list) {
            this.disable_product_labels = checkForNulls(list);
            return this;
        }

        public Builder dp_voucher_rule(DigitalPurchaseVoucherRule digitalPurchaseVoucherRule) {
            this.dp_voucher_rule = digitalPurchaseVoucherRule;
            return this;
        }

        public Builder claim_start_time(Long l) {
            this.claim_start_time = l;
            return this;
        }

        public Builder display_labels(List<Integer> list) {
            this.display_labels = checkForNulls(list);
            return this;
        }

        public Builder shipping_promotion_rules(List<Long> list) {
            this.shipping_promotion_rules = checkForNulls(list);
            return this;
        }

        public Builder icon_hash(String str) {
            this.icon_hash = str;
            return this;
        }

        public Builder icon_text(String str) {
            this.icon_text = str;
            return this;
        }

        public Builder use_link(String str) {
            this.use_link = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder usage_term_product(String str) {
            this.usage_term_product = str;
            return this;
        }

        public Builder customised_labels(List<VoucherCustomisedLabel> list) {
            this.customised_labels = checkForNulls(list);
            return this;
        }

        public Builder non_claimable(Boolean bool) {
            this.non_claimable = bool;
            return this;
        }

        public Builder not_show_product_scope_tag(Boolean bool) {
            this.not_show_product_scope_tag = bool;
            return this;
        }

        public Builder customised_product_scope_tags(List<VoucherCustomisedLabel> list) {
            this.customised_product_scope_tags = checkForNulls(list);
            return this;
        }

        public PromotionRuleSet build() {
            return new PromotionRuleSet(this);
        }
    }
}
