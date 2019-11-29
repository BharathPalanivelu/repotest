package com.shopee.protocol.action;

import com.shopee.protocol.shop.CardPromotionOrderInfo;
import com.shopee.protocol.shop.CartPriceInfo;
import com.shopee.protocol.shop.CoinInfo;
import com.shopee.protocol.shop.PromotionInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseValidateVoucher extends Message {
    public static final Long DEFAULT_ADMIN_FEE = 0L;
    public static final List<BundleDealStats> DEFAULT_BUNDLE_DEALS = Collections.emptyList();
    public static final Long DEFAULT_BUYER_TXN_FEE = 0L;
    public static final Integer DEFAULT_CARD_PROMOTION_TIER_NO = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Long DEFAULT_GROUP_BUY_DISCOUNT = 0L;
    public static final Integer DEFAULT_INVALID_CARD_PROMOTION_CODE = 0;
    public static final Integer DEFAULT_INVALID_MESSAGE_CODE = 0;
    public static final Integer DEFAULT_INVALID_PRICERULE_CODE = 0;
    public static final List<OrderWithItems> DEFAULT_ORDERS = Collections.emptyList();
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Long DEFAULT_PRICE_DISCOUNT = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<ShopOrderTax> DEFAULT_TAX_DETAILS = Collections.emptyList();
    public static final Long DEFAULT_VOUCHER_VALUE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long admin_fee;
    @ProtoField(label = Message.Label.REPEATED, messageType = BundleDealStats.class, tag = 18)
    public final List<BundleDealStats> bundle_deals;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long buyer_txn_fee;
    @ProtoField(tag = 13)
    public final CardPromotionOrderInfo card_promotion_info;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer card_promotion_tier_no;
    @ProtoField(tag = 12)
    public final CoinInfo coin_info;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 20, type = Message.Datatype.INT64)
    public final Long group_buy_discount;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer invalid_card_promotion_code;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer invalid_message_code;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer invalid_pricerule_code;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderWithItems.class, tag = 17)
    public final List<OrderWithItems> orders;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long price_discount;
    @ProtoField(tag = 9)
    public final PromotionInfo promotion_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10)
    public final CartPriceInfo rule_info;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopOrderTax.class, tag = 16)
    public final List<ShopOrderTax> tax_details;
    @ProtoField(tag = 21)
    public final VoucherInfo voucher_info;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long voucher_value;

    public ResponseValidateVoucher(String str, Integer num, Long l, Long l2, Integer num2, String str2, Integer num3, Long l3, PromotionInfo promotionInfo, CartPriceInfo cartPriceInfo, Integer num4, CoinInfo coinInfo, CardPromotionOrderInfo cardPromotionOrderInfo, Integer num5, Integer num6, List<ShopOrderTax> list, List<OrderWithItems> list2, List<BundleDealStats> list3, Long l4, Long l5, VoucherInfo voucherInfo, Long l6) {
        this.requestid = str;
        this.errcode = num;
        this.price_before_discount = l;
        this.price_discount = l2;
        this.discount_percentage = num2;
        this.currency = str2;
        this.invalid_message_code = num3;
        this.voucher_value = l3;
        this.promotion_info = promotionInfo;
        this.rule_info = cartPriceInfo;
        this.invalid_pricerule_code = num4;
        this.coin_info = coinInfo;
        this.card_promotion_info = cardPromotionOrderInfo;
        this.invalid_card_promotion_code = num5;
        this.card_promotion_tier_no = num6;
        this.tax_details = immutableCopyOf(list);
        this.orders = immutableCopyOf(list2);
        this.bundle_deals = immutableCopyOf(list3);
        this.buyer_txn_fee = l4;
        this.group_buy_discount = l5;
        this.voucher_info = voucherInfo;
        this.admin_fee = l6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ResponseValidateVoucher(com.shopee.protocol.action.ResponseValidateVoucher.Builder r26) {
        /*
            r25 = this;
            r0 = r26
            r1 = r25
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.errcode
            java.lang.Long r4 = r0.price_before_discount
            java.lang.Long r5 = r0.price_discount
            java.lang.Integer r6 = r0.discount_percentage
            java.lang.String r7 = r0.currency
            java.lang.Integer r8 = r0.invalid_message_code
            java.lang.Long r9 = r0.voucher_value
            com.shopee.protocol.shop.PromotionInfo r10 = r0.promotion_info
            com.shopee.protocol.shop.CartPriceInfo r11 = r0.rule_info
            java.lang.Integer r12 = r0.invalid_pricerule_code
            com.shopee.protocol.shop.CoinInfo r13 = r0.coin_info
            com.shopee.protocol.shop.CardPromotionOrderInfo r14 = r0.card_promotion_info
            java.lang.Integer r15 = r0.invalid_card_promotion_code
            r24 = r1
            java.lang.Integer r1 = r0.card_promotion_tier_no
            r16 = r1
            java.util.List<com.shopee.protocol.action.ShopOrderTax> r1 = r0.tax_details
            r17 = r1
            java.util.List<com.shopee.protocol.action.OrderWithItems> r1 = r0.orders
            r18 = r1
            java.util.List<com.shopee.protocol.action.BundleDealStats> r1 = r0.bundle_deals
            r19 = r1
            java.lang.Long r1 = r0.buyer_txn_fee
            r20 = r1
            java.lang.Long r1 = r0.group_buy_discount
            r21 = r1
            com.shopee.protocol.action.VoucherInfo r1 = r0.voucher_info
            r22 = r1
            java.lang.Long r1 = r0.admin_fee
            r23 = r1
            r1 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.setBuilder(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.ResponseValidateVoucher.<init>(com.shopee.protocol.action.ResponseValidateVoucher$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseValidateVoucher)) {
            return false;
        }
        ResponseValidateVoucher responseValidateVoucher = (ResponseValidateVoucher) obj;
        if (!equals((Object) this.requestid, (Object) responseValidateVoucher.requestid) || !equals((Object) this.errcode, (Object) responseValidateVoucher.errcode) || !equals((Object) this.price_before_discount, (Object) responseValidateVoucher.price_before_discount) || !equals((Object) this.price_discount, (Object) responseValidateVoucher.price_discount) || !equals((Object) this.discount_percentage, (Object) responseValidateVoucher.discount_percentage) || !equals((Object) this.currency, (Object) responseValidateVoucher.currency) || !equals((Object) this.invalid_message_code, (Object) responseValidateVoucher.invalid_message_code) || !equals((Object) this.voucher_value, (Object) responseValidateVoucher.voucher_value) || !equals((Object) this.promotion_info, (Object) responseValidateVoucher.promotion_info) || !equals((Object) this.rule_info, (Object) responseValidateVoucher.rule_info) || !equals((Object) this.invalid_pricerule_code, (Object) responseValidateVoucher.invalid_pricerule_code) || !equals((Object) this.coin_info, (Object) responseValidateVoucher.coin_info) || !equals((Object) this.card_promotion_info, (Object) responseValidateVoucher.card_promotion_info) || !equals((Object) this.invalid_card_promotion_code, (Object) responseValidateVoucher.invalid_card_promotion_code) || !equals((Object) this.card_promotion_tier_no, (Object) responseValidateVoucher.card_promotion_tier_no) || !equals((List<?>) this.tax_details, (List<?>) responseValidateVoucher.tax_details) || !equals((List<?>) this.orders, (List<?>) responseValidateVoucher.orders) || !equals((List<?>) this.bundle_deals, (List<?>) responseValidateVoucher.bundle_deals) || !equals((Object) this.buyer_txn_fee, (Object) responseValidateVoucher.buyer_txn_fee) || !equals((Object) this.group_buy_discount, (Object) responseValidateVoucher.group_buy_discount) || !equals((Object) this.voucher_info, (Object) responseValidateVoucher.voucher_info) || !equals((Object) this.admin_fee, (Object) responseValidateVoucher.admin_fee)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.price_before_discount;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.price_discount;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.discount_percentage;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.currency;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.invalid_message_code;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l3 = this.voucher_value;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        PromotionInfo promotionInfo = this.promotion_info;
        int hashCode9 = (hashCode8 + (promotionInfo != null ? promotionInfo.hashCode() : 0)) * 37;
        CartPriceInfo cartPriceInfo = this.rule_info;
        int hashCode10 = (hashCode9 + (cartPriceInfo != null ? cartPriceInfo.hashCode() : 0)) * 37;
        Integer num4 = this.invalid_pricerule_code;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        CoinInfo coinInfo = this.coin_info;
        int hashCode12 = (hashCode11 + (coinInfo != null ? coinInfo.hashCode() : 0)) * 37;
        CardPromotionOrderInfo cardPromotionOrderInfo = this.card_promotion_info;
        int hashCode13 = (hashCode12 + (cardPromotionOrderInfo != null ? cardPromotionOrderInfo.hashCode() : 0)) * 37;
        Integer num5 = this.invalid_card_promotion_code;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.card_promotion_tier_no;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        List<ShopOrderTax> list = this.tax_details;
        int i3 = 1;
        int hashCode16 = (hashCode15 + (list != null ? list.hashCode() : 1)) * 37;
        List<OrderWithItems> list2 = this.orders;
        int hashCode17 = (hashCode16 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<BundleDealStats> list3 = this.bundle_deals;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode17 + i3) * 37;
        Long l4 = this.buyer_txn_fee;
        int hashCode18 = (i4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.group_buy_discount;
        int hashCode19 = (hashCode18 + (l5 != null ? l5.hashCode() : 0)) * 37;
        VoucherInfo voucherInfo = this.voucher_info;
        int hashCode20 = (hashCode19 + (voucherInfo != null ? voucherInfo.hashCode() : 0)) * 37;
        Long l6 = this.admin_fee;
        if (l6 != null) {
            i2 = l6.hashCode();
        }
        int i5 = hashCode20 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseValidateVoucher> {
        public Long admin_fee;
        public List<BundleDealStats> bundle_deals;
        public Long buyer_txn_fee;
        public CardPromotionOrderInfo card_promotion_info;
        public Integer card_promotion_tier_no;
        public CoinInfo coin_info;
        public String currency;
        public Integer discount_percentage;
        public Integer errcode;
        public Long group_buy_discount;
        public Integer invalid_card_promotion_code;
        public Integer invalid_message_code;
        public Integer invalid_pricerule_code;
        public List<OrderWithItems> orders;
        public Long price_before_discount;
        public Long price_discount;
        public PromotionInfo promotion_info;
        public String requestid;
        public CartPriceInfo rule_info;
        public List<ShopOrderTax> tax_details;
        public VoucherInfo voucher_info;
        public Long voucher_value;

        public Builder() {
        }

        public Builder(ResponseValidateVoucher responseValidateVoucher) {
            super(responseValidateVoucher);
            if (responseValidateVoucher != null) {
                this.requestid = responseValidateVoucher.requestid;
                this.errcode = responseValidateVoucher.errcode;
                this.price_before_discount = responseValidateVoucher.price_before_discount;
                this.price_discount = responseValidateVoucher.price_discount;
                this.discount_percentage = responseValidateVoucher.discount_percentage;
                this.currency = responseValidateVoucher.currency;
                this.invalid_message_code = responseValidateVoucher.invalid_message_code;
                this.voucher_value = responseValidateVoucher.voucher_value;
                this.promotion_info = responseValidateVoucher.promotion_info;
                this.rule_info = responseValidateVoucher.rule_info;
                this.invalid_pricerule_code = responseValidateVoucher.invalid_pricerule_code;
                this.coin_info = responseValidateVoucher.coin_info;
                this.card_promotion_info = responseValidateVoucher.card_promotion_info;
                this.invalid_card_promotion_code = responseValidateVoucher.invalid_card_promotion_code;
                this.card_promotion_tier_no = responseValidateVoucher.card_promotion_tier_no;
                this.tax_details = ResponseValidateVoucher.copyOf(responseValidateVoucher.tax_details);
                this.orders = ResponseValidateVoucher.copyOf(responseValidateVoucher.orders);
                this.bundle_deals = ResponseValidateVoucher.copyOf(responseValidateVoucher.bundle_deals);
                this.buyer_txn_fee = responseValidateVoucher.buyer_txn_fee;
                this.group_buy_discount = responseValidateVoucher.group_buy_discount;
                this.voucher_info = responseValidateVoucher.voucher_info;
                this.admin_fee = responseValidateVoucher.admin_fee;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder price_discount(Long l) {
            this.price_discount = l;
            return this;
        }

        public Builder discount_percentage(Integer num) {
            this.discount_percentage = num;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder invalid_message_code(Integer num) {
            this.invalid_message_code = num;
            return this;
        }

        public Builder voucher_value(Long l) {
            this.voucher_value = l;
            return this;
        }

        public Builder promotion_info(PromotionInfo promotionInfo) {
            this.promotion_info = promotionInfo;
            return this;
        }

        public Builder rule_info(CartPriceInfo cartPriceInfo) {
            this.rule_info = cartPriceInfo;
            return this;
        }

        public Builder invalid_pricerule_code(Integer num) {
            this.invalid_pricerule_code = num;
            return this;
        }

        public Builder coin_info(CoinInfo coinInfo) {
            this.coin_info = coinInfo;
            return this;
        }

        public Builder card_promotion_info(CardPromotionOrderInfo cardPromotionOrderInfo) {
            this.card_promotion_info = cardPromotionOrderInfo;
            return this;
        }

        public Builder invalid_card_promotion_code(Integer num) {
            this.invalid_card_promotion_code = num;
            return this;
        }

        public Builder card_promotion_tier_no(Integer num) {
            this.card_promotion_tier_no = num;
            return this;
        }

        public Builder tax_details(List<ShopOrderTax> list) {
            this.tax_details = checkForNulls(list);
            return this;
        }

        public Builder orders(List<OrderWithItems> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder bundle_deals(List<BundleDealStats> list) {
            this.bundle_deals = checkForNulls(list);
            return this;
        }

        public Builder buyer_txn_fee(Long l) {
            this.buyer_txn_fee = l;
            return this;
        }

        public Builder group_buy_discount(Long l) {
            this.group_buy_discount = l;
            return this;
        }

        public Builder voucher_info(VoucherInfo voucherInfo) {
            this.voucher_info = voucherInfo;
            return this;
        }

        public Builder admin_fee(Long l) {
            this.admin_fee = l;
            return this;
        }

        public ResponseValidateVoucher build() {
            checkRequiredFields();
            return new ResponseValidateVoucher(this);
        }
    }
}
