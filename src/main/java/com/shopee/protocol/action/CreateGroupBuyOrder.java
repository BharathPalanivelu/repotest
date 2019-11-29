package com.shopee.protocol.action;

import com.shopee.protocol.shop.CheckoutPaymentInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CreateGroupBuyOrder extends Message {
    public static final Integer DEFAULT_BUYER_ADDRESS_ID = 0;
    public static final Integer DEFAULT_BUYER_TXN_FEE_RULE_ID = 0;
    public static final String DEFAULT_CARD_BIN_NUMBER = "";
    public static final Integer DEFAULT_CARD_TXN_FEE_RULE_ID = 0;
    public static final String DEFAULT_CREDIT_CARD_ID = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final Integer DEFAULT_FRAUD_CHECK_SKIP_REASON = 0;
    public static final Long DEFAULT_GROUP_BUY_CAMPAIGNID = 0L;
    public static final Long DEFAULT_GROUP_BUY_GROUPID = 0L;
    public static final Integer DEFAULT_PAYMENT_CARD = 0;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final Integer DEFAULT_PAYMENT_STATUS = 0;
    public static final Integer DEFAULT_PAY_BY_DATE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_UNIQUE_CODE = 0L;
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    public static final Boolean DEFAULT_USE_COINS = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10)
    public final BackendParam bparam;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer buyer_address_id;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer buyer_txn_fee_rule_id;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String card_bin_number;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer card_txn_fee_rule_id;
    @ProtoField(tag = 11)
    public final CheckoutPaymentInfo checkout_payment_info;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String credit_card_id;
    @ProtoField(tag = 18, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 15, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer fraud_check_skip_reason;
    @ProtoField(tag = 25, type = Message.Datatype.INT64)
    public final Long group_buy_campaignid;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long group_buy_groupid;
    @ProtoField(tag = 2)
    public final OrderWithItems order;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
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
    @ProtoField(tag = 30, type = Message.Datatype.BOOL)
    public final Boolean use_coins;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer user_agent_type;

    public CreateGroupBuyOrder(String str, OrderWithItems orderWithItems, Integer num, String str2, Integer num2, Integer num3, Long l, Integer num4, BackendParam backendParam, CheckoutPaymentInfo checkoutPaymentInfo, f fVar, f fVar2, String str3, Integer num5, Integer num6, Long l2, Long l3, Integer num7, Integer num8, Integer num9, String str4, Boolean bool) {
        this.requestid = str;
        this.order = orderWithItems;
        this.payment_method = num;
        this.token = str2;
        this.payment_card = num2;
        this.payment_status = num3;
        this.unique_code = l;
        this.buyer_address_id = num4;
        this.bparam = backendParam;
        this.checkout_payment_info = checkoutPaymentInfo;
        this.deviceid = fVar;
        this.device_fingerprint = fVar2;
        this.card_bin_number = str3;
        this.card_txn_fee_rule_id = num5;
        this.buyer_txn_fee_rule_id = num6;
        this.group_buy_groupid = l2;
        this.group_buy_campaignid = l3;
        this.user_agent_type = num7;
        this.pay_by_date = num8;
        this.fraud_check_skip_reason = num9;
        this.credit_card_id = str4;
        this.use_coins = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CreateGroupBuyOrder(com.shopee.protocol.action.CreateGroupBuyOrder.Builder r26) {
        /*
            r25 = this;
            r0 = r26
            r1 = r25
            java.lang.String r2 = r0.requestid
            com.shopee.protocol.action.OrderWithItems r3 = r0.order
            java.lang.Integer r4 = r0.payment_method
            java.lang.String r5 = r0.token
            java.lang.Integer r6 = r0.payment_card
            java.lang.Integer r7 = r0.payment_status
            java.lang.Long r8 = r0.unique_code
            java.lang.Integer r9 = r0.buyer_address_id
            com.shopee.protocol.action.BackendParam r10 = r0.bparam
            com.shopee.protocol.shop.CheckoutPaymentInfo r11 = r0.checkout_payment_info
            e.f r12 = r0.deviceid
            e.f r13 = r0.device_fingerprint
            java.lang.String r14 = r0.card_bin_number
            java.lang.Integer r15 = r0.card_txn_fee_rule_id
            r24 = r1
            java.lang.Integer r1 = r0.buyer_txn_fee_rule_id
            r16 = r1
            java.lang.Long r1 = r0.group_buy_groupid
            r17 = r1
            java.lang.Long r1 = r0.group_buy_campaignid
            r18 = r1
            java.lang.Integer r1 = r0.user_agent_type
            r19 = r1
            java.lang.Integer r1 = r0.pay_by_date
            r20 = r1
            java.lang.Integer r1 = r0.fraud_check_skip_reason
            r21 = r1
            java.lang.String r1 = r0.credit_card_id
            r22 = r1
            java.lang.Boolean r1 = r0.use_coins
            r23 = r1
            r1 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.setBuilder(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.CreateGroupBuyOrder.<init>(com.shopee.protocol.action.CreateGroupBuyOrder$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateGroupBuyOrder)) {
            return false;
        }
        CreateGroupBuyOrder createGroupBuyOrder = (CreateGroupBuyOrder) obj;
        if (!equals((Object) this.requestid, (Object) createGroupBuyOrder.requestid) || !equals((Object) this.order, (Object) createGroupBuyOrder.order) || !equals((Object) this.payment_method, (Object) createGroupBuyOrder.payment_method) || !equals((Object) this.token, (Object) createGroupBuyOrder.token) || !equals((Object) this.payment_card, (Object) createGroupBuyOrder.payment_card) || !equals((Object) this.payment_status, (Object) createGroupBuyOrder.payment_status) || !equals((Object) this.unique_code, (Object) createGroupBuyOrder.unique_code) || !equals((Object) this.buyer_address_id, (Object) createGroupBuyOrder.buyer_address_id) || !equals((Object) this.bparam, (Object) createGroupBuyOrder.bparam) || !equals((Object) this.checkout_payment_info, (Object) createGroupBuyOrder.checkout_payment_info) || !equals((Object) this.deviceid, (Object) createGroupBuyOrder.deviceid) || !equals((Object) this.device_fingerprint, (Object) createGroupBuyOrder.device_fingerprint) || !equals((Object) this.card_bin_number, (Object) createGroupBuyOrder.card_bin_number) || !equals((Object) this.card_txn_fee_rule_id, (Object) createGroupBuyOrder.card_txn_fee_rule_id) || !equals((Object) this.buyer_txn_fee_rule_id, (Object) createGroupBuyOrder.buyer_txn_fee_rule_id) || !equals((Object) this.group_buy_groupid, (Object) createGroupBuyOrder.group_buy_groupid) || !equals((Object) this.group_buy_campaignid, (Object) createGroupBuyOrder.group_buy_campaignid) || !equals((Object) this.user_agent_type, (Object) createGroupBuyOrder.user_agent_type) || !equals((Object) this.pay_by_date, (Object) createGroupBuyOrder.pay_by_date) || !equals((Object) this.fraud_check_skip_reason, (Object) createGroupBuyOrder.fraud_check_skip_reason) || !equals((Object) this.credit_card_id, (Object) createGroupBuyOrder.credit_card_id) || !equals((Object) this.use_coins, (Object) createGroupBuyOrder.use_coins)) {
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
        OrderWithItems orderWithItems = this.order;
        int hashCode2 = (hashCode + (orderWithItems != null ? orderWithItems.hashCode() : 0)) * 37;
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
        Integer num4 = this.buyer_address_id;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode9 = (hashCode8 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        CheckoutPaymentInfo checkoutPaymentInfo = this.checkout_payment_info;
        int hashCode10 = (hashCode9 + (checkoutPaymentInfo != null ? checkoutPaymentInfo.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode11 = (hashCode10 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.device_fingerprint;
        int hashCode12 = (hashCode11 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        String str3 = this.card_bin_number;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num5 = this.card_txn_fee_rule_id;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.buyer_txn_fee_rule_id;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.group_buy_groupid;
        int hashCode16 = (hashCode15 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.group_buy_campaignid;
        int hashCode17 = (hashCode16 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num7 = this.user_agent_type;
        int hashCode18 = (hashCode17 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.pay_by_date;
        int hashCode19 = (hashCode18 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.fraud_check_skip_reason;
        int hashCode20 = (hashCode19 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str4 = this.credit_card_id;
        int hashCode21 = (hashCode20 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.use_coins;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode21 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreateGroupBuyOrder> {
        public BackendParam bparam;
        public Integer buyer_address_id;
        public Integer buyer_txn_fee_rule_id;
        public String card_bin_number;
        public Integer card_txn_fee_rule_id;
        public CheckoutPaymentInfo checkout_payment_info;
        public String credit_card_id;
        public f device_fingerprint;
        public f deviceid;
        public Integer fraud_check_skip_reason;
        public Long group_buy_campaignid;
        public Long group_buy_groupid;
        public OrderWithItems order;
        public Integer pay_by_date;
        public Integer payment_card;
        public Integer payment_method;
        public Integer payment_status;
        public String requestid;
        public String token;
        public Long unique_code;
        public Boolean use_coins;
        public Integer user_agent_type;

        public Builder() {
        }

        public Builder(CreateGroupBuyOrder createGroupBuyOrder) {
            super(createGroupBuyOrder);
            if (createGroupBuyOrder != null) {
                this.requestid = createGroupBuyOrder.requestid;
                this.order = createGroupBuyOrder.order;
                this.payment_method = createGroupBuyOrder.payment_method;
                this.token = createGroupBuyOrder.token;
                this.payment_card = createGroupBuyOrder.payment_card;
                this.payment_status = createGroupBuyOrder.payment_status;
                this.unique_code = createGroupBuyOrder.unique_code;
                this.buyer_address_id = createGroupBuyOrder.buyer_address_id;
                this.bparam = createGroupBuyOrder.bparam;
                this.checkout_payment_info = createGroupBuyOrder.checkout_payment_info;
                this.deviceid = createGroupBuyOrder.deviceid;
                this.device_fingerprint = createGroupBuyOrder.device_fingerprint;
                this.card_bin_number = createGroupBuyOrder.card_bin_number;
                this.card_txn_fee_rule_id = createGroupBuyOrder.card_txn_fee_rule_id;
                this.buyer_txn_fee_rule_id = createGroupBuyOrder.buyer_txn_fee_rule_id;
                this.group_buy_groupid = createGroupBuyOrder.group_buy_groupid;
                this.group_buy_campaignid = createGroupBuyOrder.group_buy_campaignid;
                this.user_agent_type = createGroupBuyOrder.user_agent_type;
                this.pay_by_date = createGroupBuyOrder.pay_by_date;
                this.fraud_check_skip_reason = createGroupBuyOrder.fraud_check_skip_reason;
                this.credit_card_id = createGroupBuyOrder.credit_card_id;
                this.use_coins = createGroupBuyOrder.use_coins;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder order(OrderWithItems orderWithItems) {
            this.order = orderWithItems;
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

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
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

        public Builder buyer_txn_fee_rule_id(Integer num) {
            this.buyer_txn_fee_rule_id = num;
            return this;
        }

        public Builder group_buy_groupid(Long l) {
            this.group_buy_groupid = l;
            return this;
        }

        public Builder group_buy_campaignid(Long l) {
            this.group_buy_campaignid = l;
            return this;
        }

        public Builder user_agent_type(Integer num) {
            this.user_agent_type = num;
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

        public Builder use_coins(Boolean bool) {
            this.use_coins = bool;
            return this;
        }

        public CreateGroupBuyOrder build() {
            return new CreateGroupBuyOrder(this);
        }
    }
}
