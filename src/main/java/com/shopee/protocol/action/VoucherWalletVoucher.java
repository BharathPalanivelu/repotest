package com.shopee.protocol.action;

import com.shopee.protocol.shop.VoucherCustomisedLabel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class VoucherWalletVoucher extends Message {
    public static final Long DEFAULT_CLAIM_START_TIME = 0L;
    public static final Long DEFAULT_COIN_CAP = 0L;
    public static final Long DEFAULT_COIN_EARNED = 0L;
    public static final Integer DEFAULT_COIN_PERCENTAGE = 0;
    public static final Integer DEFAULT_COIN_PERCENTAGE_REAL = 0;
    public static final Integer DEFAULT_COLLECT_TIME = 0;
    public static final Long DEFAULT_CURRENT_SPEND = 0L;
    public static final List<VoucherCustomisedLabel> DEFAULT_CUSTOMISED_LABELS = Collections.emptyList();
    public static final List<VoucherCustomisedLabel> DEFAULT_CUSTOMISED_PRODUCT_SCOPE_TAGS = Collections.emptyList();
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_DISCOUNT_CAP = 0L;
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Long DEFAULT_DISCOUNT_VALUE = 0L;
    public static final List<Integer> DEFAULT_DISPLAY_LABELS = Collections.emptyList();
    public static final Integer DEFAULT_DP_CATEGORY_ID = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final String DEFAULT_ICON_HASH = "";
    public static final String DEFAULT_ICON_TEXT = "";
    public static final Long DEFAULT_MIN_SPEND = 0L;
    public static final Boolean DEFAULT_NOT_SHOW_PRODUCT_SCOPE_TAG = false;
    public static final Integer DEFAULT_PLATFORM_TYPE = 0;
    public static final Boolean DEFAULT_PRODUCT_LIMIT = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_REMAINING_CLAIM_COUNT = 0;
    public static final Integer DEFAULT_REWARD_TYPE = 0;
    public static final List<Long> DEFAULT_SHIPPING_PROMOTION_RULES = Collections.emptyList();
    public static final Integer DEFAULT_SHOP_ID = 0;
    public static final List<Integer> DEFAULT_SHOP_TYPES = Collections.emptyList();
    public static final String DEFAULT_SIGNATURE = "";
    public static final Boolean DEFAULT_SINGLE_SHOP = false;
    public static final List<Long> DEFAULT_SPM_CHANNELS = Collections.emptyList();
    public static final Integer DEFAULT_START_TIME = 0;
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_USAGE_LIMIT = 0;
    public static final Integer DEFAULT_USED_COUNT = 0;
    public static final Long DEFAULT_USED_PRICE = 0L;
    public static final String DEFAULT_USE_LINK = "";
    public static final Integer DEFAULT_USE_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    public static final Integer DEFAULT_VOUCHER_MARKET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 29, type = Message.Datatype.INT64)
    public final Long claim_start_time;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long coin_cap;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long coin_earned;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer coin_percentage;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer coin_percentage_real;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer collect_time;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long current_spend;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherCustomisedLabel.class, tag = 38)
    public final List<VoucherCustomisedLabel> customised_labels;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherCustomisedLabel.class, tag = 40)
    public final List<VoucherCustomisedLabel> customised_product_scope_tags;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 23, type = Message.Datatype.INT64)
    public final Long discount_cap;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long discount_value;
    @ProtoField(label = Message.Label.REPEATED, tag = 31, type = Message.Datatype.INT32)
    public final List<Integer> display_labels;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer dp_category_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String icon_hash;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String icon_text;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long min_spend;
    @ProtoField(tag = 39, type = Message.Datatype.BOOL)
    public final Boolean not_show_product_scope_tag;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer platform_type;
    @ProtoField(tag = 20, type = Message.Datatype.BOOL)
    public final Boolean product_limit;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer remaining_claim_count;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer reward_type;
    @ProtoField(label = Message.Label.REPEATED, tag = 32, type = Message.Datatype.INT64)
    public final List<Long> shipping_promotion_rules;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer shop_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 37, type = Message.Datatype.INT32)
    public final List<Integer> shop_types;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 18, type = Message.Datatype.BOOL)
    public final Boolean single_shop;
    @ProtoField(label = Message.Label.REPEATED, tag = 25, type = Message.Datatype.INT64)
    public final List<Long> spm_channels;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 36, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer usage_limit;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String use_link;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer use_type;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer used_count;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long used_price;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String voucher_code;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer voucher_market_type;

    public VoucherWalletVoucher(Long l, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Long l2, Integer num8, Long l3, Integer num9, Long l4, Long l5, Long l6, Integer num10, Boolean bool, Integer num11, Boolean bool2, String str2, Integer num12, Long l7, Long l8, List<Long> list, Integer num13, Integer num14, Integer num15, Long l9, String str3, List<Integer> list2, List<Long> list3, String str4, String str5, String str6, String str7, List<Integer> list4, List<VoucherCustomisedLabel> list5, Boolean bool3, List<VoucherCustomisedLabel> list6) {
        this.promotionid = l;
        this.voucher_code = str;
        this.collect_time = num;
        this.use_type = num2;
        this.usage_limit = num3;
        this.used_count = num4;
        this.start_time = num5;
        this.end_time = num6;
        this.reward_type = num7;
        this.discount_value = l2;
        this.discount_percentage = num8;
        this.used_price = l3;
        this.coin_percentage = num9;
        this.coin_earned = l4;
        this.min_spend = l5;
        this.current_spend = l6;
        this.platform_type = num10;
        this.single_shop = bool;
        this.shop_id = num11;
        this.product_limit = bool2;
        this.description = str2;
        this.coin_percentage_real = num12;
        this.discount_cap = l7;
        this.coin_cap = l8;
        this.spm_channels = immutableCopyOf(list);
        this.voucher_market_type = num13;
        this.dp_category_id = num14;
        this.remaining_claim_count = num15;
        this.claim_start_time = l9;
        this.signature = str3;
        this.display_labels = immutableCopyOf(list2);
        this.shipping_promotion_rules = immutableCopyOf(list3);
        this.icon_hash = str4;
        this.icon_text = str5;
        this.use_link = str6;
        this.title = str7;
        this.shop_types = immutableCopyOf(list4);
        this.customised_labels = immutableCopyOf(list5);
        this.not_show_product_scope_tag = bool3;
        this.customised_product_scope_tags = immutableCopyOf(list6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private VoucherWalletVoucher(com.shopee.protocol.action.VoucherWalletVoucher.Builder r44) {
        /*
            r43 = this;
            r0 = r44
            r1 = r43
            java.lang.Long r2 = r0.promotionid
            java.lang.String r3 = r0.voucher_code
            java.lang.Integer r4 = r0.collect_time
            java.lang.Integer r5 = r0.use_type
            java.lang.Integer r6 = r0.usage_limit
            java.lang.Integer r7 = r0.used_count
            java.lang.Integer r8 = r0.start_time
            java.lang.Integer r9 = r0.end_time
            java.lang.Integer r10 = r0.reward_type
            java.lang.Long r11 = r0.discount_value
            java.lang.Integer r12 = r0.discount_percentage
            java.lang.Long r13 = r0.used_price
            java.lang.Integer r14 = r0.coin_percentage
            java.lang.Long r15 = r0.coin_earned
            r42 = r1
            java.lang.Long r1 = r0.min_spend
            r16 = r1
            java.lang.Long r1 = r0.current_spend
            r17 = r1
            java.lang.Integer r1 = r0.platform_type
            r18 = r1
            java.lang.Boolean r1 = r0.single_shop
            r19 = r1
            java.lang.Integer r1 = r0.shop_id
            r20 = r1
            java.lang.Boolean r1 = r0.product_limit
            r21 = r1
            java.lang.String r1 = r0.description
            r22 = r1
            java.lang.Integer r1 = r0.coin_percentage_real
            r23 = r1
            java.lang.Long r1 = r0.discount_cap
            r24 = r1
            java.lang.Long r1 = r0.coin_cap
            r25 = r1
            java.util.List<java.lang.Long> r1 = r0.spm_channels
            r26 = r1
            java.lang.Integer r1 = r0.voucher_market_type
            r27 = r1
            java.lang.Integer r1 = r0.dp_category_id
            r28 = r1
            java.lang.Integer r1 = r0.remaining_claim_count
            r29 = r1
            java.lang.Long r1 = r0.claim_start_time
            r30 = r1
            java.lang.String r1 = r0.signature
            r31 = r1
            java.util.List<java.lang.Integer> r1 = r0.display_labels
            r32 = r1
            java.util.List<java.lang.Long> r1 = r0.shipping_promotion_rules
            r33 = r1
            java.lang.String r1 = r0.icon_hash
            r34 = r1
            java.lang.String r1 = r0.icon_text
            r35 = r1
            java.lang.String r1 = r0.use_link
            r36 = r1
            java.lang.String r1 = r0.title
            r37 = r1
            java.util.List<java.lang.Integer> r1 = r0.shop_types
            r38 = r1
            java.util.List<com.shopee.protocol.shop.VoucherCustomisedLabel> r1 = r0.customised_labels
            r39 = r1
            java.lang.Boolean r1 = r0.not_show_product_scope_tag
            r40 = r1
            java.util.List<com.shopee.protocol.shop.VoucherCustomisedLabel> r1 = r0.customised_product_scope_tags
            r41 = r1
            r1 = r42
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            r43.setBuilder(r44)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.VoucherWalletVoucher.<init>(com.shopee.protocol.action.VoucherWalletVoucher$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherWalletVoucher)) {
            return false;
        }
        VoucherWalletVoucher voucherWalletVoucher = (VoucherWalletVoucher) obj;
        if (!equals((Object) this.promotionid, (Object) voucherWalletVoucher.promotionid) || !equals((Object) this.voucher_code, (Object) voucherWalletVoucher.voucher_code) || !equals((Object) this.collect_time, (Object) voucherWalletVoucher.collect_time) || !equals((Object) this.use_type, (Object) voucherWalletVoucher.use_type) || !equals((Object) this.usage_limit, (Object) voucherWalletVoucher.usage_limit) || !equals((Object) this.used_count, (Object) voucherWalletVoucher.used_count) || !equals((Object) this.start_time, (Object) voucherWalletVoucher.start_time) || !equals((Object) this.end_time, (Object) voucherWalletVoucher.end_time) || !equals((Object) this.reward_type, (Object) voucherWalletVoucher.reward_type) || !equals((Object) this.discount_value, (Object) voucherWalletVoucher.discount_value) || !equals((Object) this.discount_percentage, (Object) voucherWalletVoucher.discount_percentage) || !equals((Object) this.used_price, (Object) voucherWalletVoucher.used_price) || !equals((Object) this.coin_percentage, (Object) voucherWalletVoucher.coin_percentage) || !equals((Object) this.coin_earned, (Object) voucherWalletVoucher.coin_earned) || !equals((Object) this.min_spend, (Object) voucherWalletVoucher.min_spend) || !equals((Object) this.current_spend, (Object) voucherWalletVoucher.current_spend) || !equals((Object) this.platform_type, (Object) voucherWalletVoucher.platform_type) || !equals((Object) this.single_shop, (Object) voucherWalletVoucher.single_shop) || !equals((Object) this.shop_id, (Object) voucherWalletVoucher.shop_id) || !equals((Object) this.product_limit, (Object) voucherWalletVoucher.product_limit) || !equals((Object) this.description, (Object) voucherWalletVoucher.description) || !equals((Object) this.coin_percentage_real, (Object) voucherWalletVoucher.coin_percentage_real) || !equals((Object) this.discount_cap, (Object) voucherWalletVoucher.discount_cap) || !equals((Object) this.coin_cap, (Object) voucherWalletVoucher.coin_cap) || !equals((List<?>) this.spm_channels, (List<?>) voucherWalletVoucher.spm_channels) || !equals((Object) this.voucher_market_type, (Object) voucherWalletVoucher.voucher_market_type) || !equals((Object) this.dp_category_id, (Object) voucherWalletVoucher.dp_category_id) || !equals((Object) this.remaining_claim_count, (Object) voucherWalletVoucher.remaining_claim_count) || !equals((Object) this.claim_start_time, (Object) voucherWalletVoucher.claim_start_time) || !equals((Object) this.signature, (Object) voucherWalletVoucher.signature) || !equals((List<?>) this.display_labels, (List<?>) voucherWalletVoucher.display_labels) || !equals((List<?>) this.shipping_promotion_rules, (List<?>) voucherWalletVoucher.shipping_promotion_rules) || !equals((Object) this.icon_hash, (Object) voucherWalletVoucher.icon_hash) || !equals((Object) this.icon_text, (Object) voucherWalletVoucher.icon_text) || !equals((Object) this.use_link, (Object) voucherWalletVoucher.use_link) || !equals((Object) this.title, (Object) voucherWalletVoucher.title) || !equals((List<?>) this.shop_types, (List<?>) voucherWalletVoucher.shop_types) || !equals((List<?>) this.customised_labels, (List<?>) voucherWalletVoucher.customised_labels) || !equals((Object) this.not_show_product_scope_tag, (Object) voucherWalletVoucher.not_show_product_scope_tag) || !equals((List<?>) this.customised_product_scope_tags, (List<?>) voucherWalletVoucher.customised_product_scope_tags)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.promotionid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.voucher_code;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.collect_time;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.use_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.usage_limit;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.used_count;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.start_time;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_time;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.reward_type;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l2 = this.discount_value;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num8 = this.discount_percentage;
        int hashCode11 = (hashCode10 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l3 = this.used_price;
        int hashCode12 = (hashCode11 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num9 = this.coin_percentage;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Long l4 = this.coin_earned;
        int hashCode14 = (hashCode13 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.min_spend;
        int hashCode15 = (hashCode14 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.current_spend;
        int hashCode16 = (hashCode15 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num10 = this.platform_type;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Boolean bool = this.single_shop;
        int hashCode18 = (hashCode17 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num11 = this.shop_id;
        int hashCode19 = (hashCode18 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Boolean bool2 = this.product_limit;
        int hashCode20 = (hashCode19 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode21 = (hashCode20 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num12 = this.coin_percentage_real;
        int hashCode22 = (hashCode21 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Long l7 = this.discount_cap;
        int hashCode23 = (hashCode22 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.coin_cap;
        int hashCode24 = (hashCode23 + (l8 != null ? l8.hashCode() : 0)) * 37;
        List<Long> list = this.spm_channels;
        int i3 = 1;
        int hashCode25 = (hashCode24 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num13 = this.voucher_market_type;
        int hashCode26 = (hashCode25 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.dp_category_id;
        int hashCode27 = (hashCode26 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.remaining_claim_count;
        int hashCode28 = (hashCode27 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Long l9 = this.claim_start_time;
        int hashCode29 = (hashCode28 + (l9 != null ? l9.hashCode() : 0)) * 37;
        String str3 = this.signature;
        int hashCode30 = (hashCode29 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<Integer> list2 = this.display_labels;
        int hashCode31 = (hashCode30 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Long> list3 = this.shipping_promotion_rules;
        int hashCode32 = (hashCode31 + (list3 != null ? list3.hashCode() : 1)) * 37;
        String str4 = this.icon_hash;
        int hashCode33 = (hashCode32 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.icon_text;
        int hashCode34 = (hashCode33 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.use_link;
        int hashCode35 = (hashCode34 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.title;
        int hashCode36 = (hashCode35 + (str7 != null ? str7.hashCode() : 0)) * 37;
        List<Integer> list4 = this.shop_types;
        int hashCode37 = (hashCode36 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<VoucherCustomisedLabel> list5 = this.customised_labels;
        int hashCode38 = (hashCode37 + (list5 != null ? list5.hashCode() : 1)) * 37;
        Boolean bool3 = this.not_show_product_scope_tag;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        int i4 = (hashCode38 + i2) * 37;
        List<VoucherCustomisedLabel> list6 = this.customised_product_scope_tags;
        if (list6 != null) {
            i3 = list6.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<VoucherWalletVoucher> {
        public Long claim_start_time;
        public Long coin_cap;
        public Long coin_earned;
        public Integer coin_percentage;
        public Integer coin_percentage_real;
        public Integer collect_time;
        public Long current_spend;
        public List<VoucherCustomisedLabel> customised_labels;
        public List<VoucherCustomisedLabel> customised_product_scope_tags;
        public String description;
        public Long discount_cap;
        public Integer discount_percentage;
        public Long discount_value;
        public List<Integer> display_labels;
        public Integer dp_category_id;
        public Integer end_time;
        public String icon_hash;
        public String icon_text;
        public Long min_spend;
        public Boolean not_show_product_scope_tag;
        public Integer platform_type;
        public Boolean product_limit;
        public Long promotionid;
        public Integer remaining_claim_count;
        public Integer reward_type;
        public List<Long> shipping_promotion_rules;
        public Integer shop_id;
        public List<Integer> shop_types;
        public String signature;
        public Boolean single_shop;
        public List<Long> spm_channels;
        public Integer start_time;
        public String title;
        public Integer usage_limit;
        public String use_link;
        public Integer use_type;
        public Integer used_count;
        public Long used_price;
        public String voucher_code;
        public Integer voucher_market_type;

        public Builder() {
        }

        public Builder(VoucherWalletVoucher voucherWalletVoucher) {
            super(voucherWalletVoucher);
            if (voucherWalletVoucher != null) {
                this.promotionid = voucherWalletVoucher.promotionid;
                this.voucher_code = voucherWalletVoucher.voucher_code;
                this.collect_time = voucherWalletVoucher.collect_time;
                this.use_type = voucherWalletVoucher.use_type;
                this.usage_limit = voucherWalletVoucher.usage_limit;
                this.used_count = voucherWalletVoucher.used_count;
                this.start_time = voucherWalletVoucher.start_time;
                this.end_time = voucherWalletVoucher.end_time;
                this.reward_type = voucherWalletVoucher.reward_type;
                this.discount_value = voucherWalletVoucher.discount_value;
                this.discount_percentage = voucherWalletVoucher.discount_percentage;
                this.used_price = voucherWalletVoucher.used_price;
                this.coin_percentage = voucherWalletVoucher.coin_percentage;
                this.coin_earned = voucherWalletVoucher.coin_earned;
                this.min_spend = voucherWalletVoucher.min_spend;
                this.current_spend = voucherWalletVoucher.current_spend;
                this.platform_type = voucherWalletVoucher.platform_type;
                this.single_shop = voucherWalletVoucher.single_shop;
                this.shop_id = voucherWalletVoucher.shop_id;
                this.product_limit = voucherWalletVoucher.product_limit;
                this.description = voucherWalletVoucher.description;
                this.coin_percentage_real = voucherWalletVoucher.coin_percentage_real;
                this.discount_cap = voucherWalletVoucher.discount_cap;
                this.coin_cap = voucherWalletVoucher.coin_cap;
                this.spm_channels = VoucherWalletVoucher.copyOf(voucherWalletVoucher.spm_channels);
                this.voucher_market_type = voucherWalletVoucher.voucher_market_type;
                this.dp_category_id = voucherWalletVoucher.dp_category_id;
                this.remaining_claim_count = voucherWalletVoucher.remaining_claim_count;
                this.claim_start_time = voucherWalletVoucher.claim_start_time;
                this.signature = voucherWalletVoucher.signature;
                this.display_labels = VoucherWalletVoucher.copyOf(voucherWalletVoucher.display_labels);
                this.shipping_promotion_rules = VoucherWalletVoucher.copyOf(voucherWalletVoucher.shipping_promotion_rules);
                this.icon_hash = voucherWalletVoucher.icon_hash;
                this.icon_text = voucherWalletVoucher.icon_text;
                this.use_link = voucherWalletVoucher.use_link;
                this.title = voucherWalletVoucher.title;
                this.shop_types = VoucherWalletVoucher.copyOf(voucherWalletVoucher.shop_types);
                this.customised_labels = VoucherWalletVoucher.copyOf(voucherWalletVoucher.customised_labels);
                this.not_show_product_scope_tag = voucherWalletVoucher.not_show_product_scope_tag;
                this.customised_product_scope_tags = VoucherWalletVoucher.copyOf(voucherWalletVoucher.customised_product_scope_tags);
            }
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder collect_time(Integer num) {
            this.collect_time = num;
            return this;
        }

        public Builder use_type(Integer num) {
            this.use_type = num;
            return this;
        }

        public Builder usage_limit(Integer num) {
            this.usage_limit = num;
            return this;
        }

        public Builder used_count(Integer num) {
            this.used_count = num;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder reward_type(Integer num) {
            this.reward_type = num;
            return this;
        }

        public Builder discount_value(Long l) {
            this.discount_value = l;
            return this;
        }

        public Builder discount_percentage(Integer num) {
            this.discount_percentage = num;
            return this;
        }

        public Builder used_price(Long l) {
            this.used_price = l;
            return this;
        }

        public Builder coin_percentage(Integer num) {
            this.coin_percentage = num;
            return this;
        }

        public Builder coin_earned(Long l) {
            this.coin_earned = l;
            return this;
        }

        public Builder min_spend(Long l) {
            this.min_spend = l;
            return this;
        }

        public Builder current_spend(Long l) {
            this.current_spend = l;
            return this;
        }

        public Builder platform_type(Integer num) {
            this.platform_type = num;
            return this;
        }

        public Builder single_shop(Boolean bool) {
            this.single_shop = bool;
            return this;
        }

        public Builder shop_id(Integer num) {
            this.shop_id = num;
            return this;
        }

        public Builder product_limit(Boolean bool) {
            this.product_limit = bool;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder coin_percentage_real(Integer num) {
            this.coin_percentage_real = num;
            return this;
        }

        public Builder discount_cap(Long l) {
            this.discount_cap = l;
            return this;
        }

        public Builder coin_cap(Long l) {
            this.coin_cap = l;
            return this;
        }

        public Builder spm_channels(List<Long> list) {
            this.spm_channels = checkForNulls(list);
            return this;
        }

        public Builder voucher_market_type(Integer num) {
            this.voucher_market_type = num;
            return this;
        }

        public Builder dp_category_id(Integer num) {
            this.dp_category_id = num;
            return this;
        }

        public Builder remaining_claim_count(Integer num) {
            this.remaining_claim_count = num;
            return this;
        }

        public Builder claim_start_time(Long l) {
            this.claim_start_time = l;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
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

        public Builder shop_types(List<Integer> list) {
            this.shop_types = checkForNulls(list);
            return this;
        }

        public Builder customised_labels(List<VoucherCustomisedLabel> list) {
            this.customised_labels = checkForNulls(list);
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

        public VoucherWalletVoucher build() {
            return new VoucherWalletVoucher(this);
        }
    }
}
