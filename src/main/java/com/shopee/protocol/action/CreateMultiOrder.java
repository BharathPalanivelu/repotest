package com.shopee.protocol.action;

import com.shopee.protocol.shop.CheckoutPaymentInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class CreateMultiOrder extends Message {
    public static final Integer DEFAULT_BUYER_ADDRESS_ID = 0;
    public static final Integer DEFAULT_BUYER_TXN_FEE_RULE_ID = 0;
    public static final Integer DEFAULT_CARD_BANK_ID = 0;
    public static final String DEFAULT_CARD_BIN_NUMBER = "";
    public static final Integer DEFAULT_CARD_TXN_FEE_RULE_ID = 0;
    public static final Integer DEFAULT_CART_PRICE_RULEID = 0;
    public static final Boolean DEFAULT_CHECK_VOUCHER_PAYMENT_CRITERIA = false;
    public static final String DEFAULT_CREDIT_CARD_ID = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final Integer DEFAULT_FRAUD_CHECK_SKIP_REASON = 0;
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Boolean DEFAULT_IS_SHADOW = false;
    public static final Boolean DEFAULT_IS_SLASH_PRICE = false;
    public static final Boolean DEFAULT_NEED_COIN_INFO = false;
    public static final Boolean DEFAULT_NEED_ORDER_DETAILS = false;
    public static final Boolean DEFAULT_NEED_TAX_INFO = false;
    public static final List<OrderWithItems> DEFAULT_ORDERS = Collections.emptyList();
    public static final Integer DEFAULT_PAYMENT_CARD = 0;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final Integer DEFAULT_PAYMENT_STATUS = 0;
    public static final Integer DEFAULT_PAY_BY_DATE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_UNIQUE_CODE = 0L;
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    public static final Boolean DEFAULT_USE_COIN = false;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10)
    public final BackendParam bparam;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer buyer_address_id;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer buyer_txn_fee_rule_id;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer card_bank_id;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String card_bin_number;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer card_txn_fee_rule_id;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer cart_price_ruleid;
    @ProtoField(tag = 26, type = Message.Datatype.BOOL)
    public final Boolean check_voucher_payment_criteria;
    @ProtoField(tag = 11)
    public final CheckoutPaymentInfo checkout_payment_info;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String credit_card_id;
    @ProtoField(tag = 18, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 15, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer fraud_check_skip_reason;
    @ProtoField(tag = 24, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean is_shadow;
    @ProtoField(tag = 27, type = Message.Datatype.BOOL)
    public final Boolean is_slash_price;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean need_coin_info;
    @ProtoField(tag = 22, type = Message.Datatype.BOOL)
    public final Boolean need_order_details;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean need_tax_info;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderWithItems.class, tag = 2)
    public final List<OrderWithItems> orders;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer pay_by_date;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer payment_card;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer payment_method;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer payment_status;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long unique_code;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean use_coin;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer user_agent_type;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String voucher_code;

    public CreateMultiOrder(String str, List<OrderWithItems> list, Integer num, String str2, Integer num2, Integer num3, Long l, String str3, Integer num4, BackendParam backendParam, CheckoutPaymentInfo checkoutPaymentInfo, Integer num5, Boolean bool, Integer num6, f fVar, Boolean bool2, Boolean bool3, f fVar2, String str4, Integer num7, Boolean bool4, Boolean bool5, Integer num8, Boolean bool6, Integer num9, Boolean bool7, Boolean bool8, Integer num10, Integer num11, String str5) {
        this.requestid = str;
        this.orders = immutableCopyOf(list);
        this.payment_method = num;
        this.token = str2;
        this.payment_card = num2;
        this.payment_status = num3;
        this.unique_code = l;
        this.voucher_code = str3;
        this.buyer_address_id = num4;
        this.bparam = backendParam;
        this.checkout_payment_info = checkoutPaymentInfo;
        this.cart_price_ruleid = num5;
        this.is_shadow = bool;
        this.user_agent_type = num6;
        this.deviceid = fVar;
        this.need_coin_info = bool2;
        this.use_coin = bool3;
        this.device_fingerprint = fVar2;
        this.card_bin_number = str4;
        this.card_txn_fee_rule_id = num7;
        this.need_tax_info = bool4;
        this.need_order_details = bool5;
        this.buyer_txn_fee_rule_id = num8;
        this.is_group_buy = bool6;
        this.card_bank_id = num9;
        this.check_voucher_payment_criteria = bool7;
        this.is_slash_price = bool8;
        this.pay_by_date = num10;
        this.fraud_check_skip_reason = num11;
        this.credit_card_id = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CreateMultiOrder(com.shopee.protocol.action.CreateMultiOrder.Builder r34) {
        /*
            r33 = this;
            r0 = r34
            r1 = r33
            java.lang.String r2 = r0.requestid
            java.util.List<com.shopee.protocol.action.OrderWithItems> r3 = r0.orders
            java.lang.Integer r4 = r0.payment_method
            java.lang.String r5 = r0.token
            java.lang.Integer r6 = r0.payment_card
            java.lang.Integer r7 = r0.payment_status
            java.lang.Long r8 = r0.unique_code
            java.lang.String r9 = r0.voucher_code
            java.lang.Integer r10 = r0.buyer_address_id
            com.shopee.protocol.action.BackendParam r11 = r0.bparam
            com.shopee.protocol.shop.CheckoutPaymentInfo r12 = r0.checkout_payment_info
            java.lang.Integer r13 = r0.cart_price_ruleid
            java.lang.Boolean r14 = r0.is_shadow
            java.lang.Integer r15 = r0.user_agent_type
            r32 = r1
            e.f r1 = r0.deviceid
            r16 = r1
            java.lang.Boolean r1 = r0.need_coin_info
            r17 = r1
            java.lang.Boolean r1 = r0.use_coin
            r18 = r1
            e.f r1 = r0.device_fingerprint
            r19 = r1
            java.lang.String r1 = r0.card_bin_number
            r20 = r1
            java.lang.Integer r1 = r0.card_txn_fee_rule_id
            r21 = r1
            java.lang.Boolean r1 = r0.need_tax_info
            r22 = r1
            java.lang.Boolean r1 = r0.need_order_details
            r23 = r1
            java.lang.Integer r1 = r0.buyer_txn_fee_rule_id
            r24 = r1
            java.lang.Boolean r1 = r0.is_group_buy
            r25 = r1
            java.lang.Integer r1 = r0.card_bank_id
            r26 = r1
            java.lang.Boolean r1 = r0.check_voucher_payment_criteria
            r27 = r1
            java.lang.Boolean r1 = r0.is_slash_price
            r28 = r1
            java.lang.Integer r1 = r0.pay_by_date
            r29 = r1
            java.lang.Integer r1 = r0.fraud_check_skip_reason
            r30 = r1
            java.lang.String r1 = r0.credit_card_id
            r31 = r1
            r1 = r32
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r33.setBuilder(r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.CreateMultiOrder.<init>(com.shopee.protocol.action.CreateMultiOrder$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateMultiOrder)) {
            return false;
        }
        CreateMultiOrder createMultiOrder = (CreateMultiOrder) obj;
        if (!equals((Object) this.requestid, (Object) createMultiOrder.requestid) || !equals((List<?>) this.orders, (List<?>) createMultiOrder.orders) || !equals((Object) this.payment_method, (Object) createMultiOrder.payment_method) || !equals((Object) this.token, (Object) createMultiOrder.token) || !equals((Object) this.payment_card, (Object) createMultiOrder.payment_card) || !equals((Object) this.payment_status, (Object) createMultiOrder.payment_status) || !equals((Object) this.unique_code, (Object) createMultiOrder.unique_code) || !equals((Object) this.voucher_code, (Object) createMultiOrder.voucher_code) || !equals((Object) this.buyer_address_id, (Object) createMultiOrder.buyer_address_id) || !equals((Object) this.bparam, (Object) createMultiOrder.bparam) || !equals((Object) this.checkout_payment_info, (Object) createMultiOrder.checkout_payment_info) || !equals((Object) this.cart_price_ruleid, (Object) createMultiOrder.cart_price_ruleid) || !equals((Object) this.is_shadow, (Object) createMultiOrder.is_shadow) || !equals((Object) this.user_agent_type, (Object) createMultiOrder.user_agent_type) || !equals((Object) this.deviceid, (Object) createMultiOrder.deviceid) || !equals((Object) this.need_coin_info, (Object) createMultiOrder.need_coin_info) || !equals((Object) this.use_coin, (Object) createMultiOrder.use_coin) || !equals((Object) this.device_fingerprint, (Object) createMultiOrder.device_fingerprint) || !equals((Object) this.card_bin_number, (Object) createMultiOrder.card_bin_number) || !equals((Object) this.card_txn_fee_rule_id, (Object) createMultiOrder.card_txn_fee_rule_id) || !equals((Object) this.need_tax_info, (Object) createMultiOrder.need_tax_info) || !equals((Object) this.need_order_details, (Object) createMultiOrder.need_order_details) || !equals((Object) this.buyer_txn_fee_rule_id, (Object) createMultiOrder.buyer_txn_fee_rule_id) || !equals((Object) this.is_group_buy, (Object) createMultiOrder.is_group_buy) || !equals((Object) this.card_bank_id, (Object) createMultiOrder.card_bank_id) || !equals((Object) this.check_voucher_payment_criteria, (Object) createMultiOrder.check_voucher_payment_criteria) || !equals((Object) this.is_slash_price, (Object) createMultiOrder.is_slash_price) || !equals((Object) this.pay_by_date, (Object) createMultiOrder.pay_by_date) || !equals((Object) this.fraud_check_skip_reason, (Object) createMultiOrder.fraud_check_skip_reason) || !equals((Object) this.credit_card_id, (Object) createMultiOrder.credit_card_id)) {
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
        List<OrderWithItems> list = this.orders;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.payment_method;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.payment_card;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.payment_status;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.unique_code;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        String str3 = this.voucher_code;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.buyer_address_id;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode10 = (hashCode9 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        CheckoutPaymentInfo checkoutPaymentInfo = this.checkout_payment_info;
        int hashCode11 = (hashCode10 + (checkoutPaymentInfo != null ? checkoutPaymentInfo.hashCode() : 0)) * 37;
        Integer num5 = this.cart_price_ruleid;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool = this.is_shadow;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num6 = this.user_agent_type;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode15 = (hashCode14 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_coin_info;
        int hashCode16 = (hashCode15 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.use_coin;
        int hashCode17 = (hashCode16 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        f fVar2 = this.device_fingerprint;
        int hashCode18 = (hashCode17 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        String str4 = this.card_bin_number;
        int hashCode19 = (hashCode18 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num7 = this.card_txn_fee_rule_id;
        int hashCode20 = (hashCode19 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Boolean bool4 = this.need_tax_info;
        int hashCode21 = (hashCode20 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.need_order_details;
        int hashCode22 = (hashCode21 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Integer num8 = this.buyer_txn_fee_rule_id;
        int hashCode23 = (hashCode22 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Boolean bool6 = this.is_group_buy;
        int hashCode24 = (hashCode23 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num9 = this.card_bank_id;
        int hashCode25 = (hashCode24 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Boolean bool7 = this.check_voucher_payment_criteria;
        int hashCode26 = (hashCode25 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.is_slash_price;
        int hashCode27 = (hashCode26 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Integer num10 = this.pay_by_date;
        int hashCode28 = (hashCode27 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.fraud_check_skip_reason;
        int hashCode29 = (hashCode28 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str5 = this.credit_card_id;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode29 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreateMultiOrder> {
        public BackendParam bparam;
        public Integer buyer_address_id;
        public Integer buyer_txn_fee_rule_id;
        public Integer card_bank_id;
        public String card_bin_number;
        public Integer card_txn_fee_rule_id;
        public Integer cart_price_ruleid;
        public Boolean check_voucher_payment_criteria;
        public CheckoutPaymentInfo checkout_payment_info;
        public String credit_card_id;
        public f device_fingerprint;
        public f deviceid;
        public Integer fraud_check_skip_reason;
        public Boolean is_group_buy;
        public Boolean is_shadow;
        public Boolean is_slash_price;
        public Boolean need_coin_info;
        public Boolean need_order_details;
        public Boolean need_tax_info;
        public List<OrderWithItems> orders;
        public Integer pay_by_date;
        public Integer payment_card;
        public Integer payment_method;
        public Integer payment_status;
        public String requestid;
        public String token;
        public Long unique_code;
        public Boolean use_coin;
        public Integer user_agent_type;
        public String voucher_code;

        public Builder() {
        }

        public Builder(CreateMultiOrder createMultiOrder) {
            super(createMultiOrder);
            if (createMultiOrder != null) {
                this.requestid = createMultiOrder.requestid;
                this.orders = CreateMultiOrder.copyOf(createMultiOrder.orders);
                this.payment_method = createMultiOrder.payment_method;
                this.token = createMultiOrder.token;
                this.payment_card = createMultiOrder.payment_card;
                this.payment_status = createMultiOrder.payment_status;
                this.unique_code = createMultiOrder.unique_code;
                this.voucher_code = createMultiOrder.voucher_code;
                this.buyer_address_id = createMultiOrder.buyer_address_id;
                this.bparam = createMultiOrder.bparam;
                this.checkout_payment_info = createMultiOrder.checkout_payment_info;
                this.cart_price_ruleid = createMultiOrder.cart_price_ruleid;
                this.is_shadow = createMultiOrder.is_shadow;
                this.user_agent_type = createMultiOrder.user_agent_type;
                this.deviceid = createMultiOrder.deviceid;
                this.need_coin_info = createMultiOrder.need_coin_info;
                this.use_coin = createMultiOrder.use_coin;
                this.device_fingerprint = createMultiOrder.device_fingerprint;
                this.card_bin_number = createMultiOrder.card_bin_number;
                this.card_txn_fee_rule_id = createMultiOrder.card_txn_fee_rule_id;
                this.need_tax_info = createMultiOrder.need_tax_info;
                this.need_order_details = createMultiOrder.need_order_details;
                this.buyer_txn_fee_rule_id = createMultiOrder.buyer_txn_fee_rule_id;
                this.is_group_buy = createMultiOrder.is_group_buy;
                this.card_bank_id = createMultiOrder.card_bank_id;
                this.check_voucher_payment_criteria = createMultiOrder.check_voucher_payment_criteria;
                this.is_slash_price = createMultiOrder.is_slash_price;
                this.pay_by_date = createMultiOrder.pay_by_date;
                this.fraud_check_skip_reason = createMultiOrder.fraud_check_skip_reason;
                this.credit_card_id = createMultiOrder.credit_card_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orders(List<OrderWithItems> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder payment_method(Integer num) {
            this.payment_method = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder payment_card(Integer num) {
            this.payment_card = num;
            return this;
        }

        public Builder payment_status(Integer num) {
            this.payment_status = num;
            return this;
        }

        public Builder unique_code(Long l) {
            this.unique_code = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder buyer_address_id(Integer num) {
            this.buyer_address_id = num;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder checkout_payment_info(CheckoutPaymentInfo checkoutPaymentInfo) {
            this.checkout_payment_info = checkoutPaymentInfo;
            return this;
        }

        public Builder cart_price_ruleid(Integer num) {
            this.cart_price_ruleid = num;
            return this;
        }

        public Builder is_shadow(Boolean bool) {
            this.is_shadow = bool;
            return this;
        }

        public Builder user_agent_type(Integer num) {
            this.user_agent_type = num;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder need_coin_info(Boolean bool) {
            this.need_coin_info = bool;
            return this;
        }

        public Builder use_coin(Boolean bool) {
            this.use_coin = bool;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder card_bin_number(String str) {
            this.card_bin_number = str;
            return this;
        }

        public Builder card_txn_fee_rule_id(Integer num) {
            this.card_txn_fee_rule_id = num;
            return this;
        }

        public Builder need_tax_info(Boolean bool) {
            this.need_tax_info = bool;
            return this;
        }

        public Builder need_order_details(Boolean bool) {
            this.need_order_details = bool;
            return this;
        }

        public Builder buyer_txn_fee_rule_id(Integer num) {
            this.buyer_txn_fee_rule_id = num;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public Builder card_bank_id(Integer num) {
            this.card_bank_id = num;
            return this;
        }

        public Builder check_voucher_payment_criteria(Boolean bool) {
            this.check_voucher_payment_criteria = bool;
            return this;
        }

        public Builder is_slash_price(Boolean bool) {
            this.is_slash_price = bool;
            return this;
        }

        public Builder pay_by_date(Integer num) {
            this.pay_by_date = num;
            return this;
        }

        public Builder fraud_check_skip_reason(Integer num) {
            this.fraud_check_skip_reason = num;
            return this;
        }

        public Builder credit_card_id(String str) {
            this.credit_card_id = str;
            return this;
        }

        public CreateMultiOrder build() {
            return new CreateMultiOrder(this);
        }
    }
}
