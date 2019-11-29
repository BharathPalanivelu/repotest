package com.shopee.protocol.action;

import com.shopee.protocol.shop.Checkout;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetCheckout extends Message {
    public static final Integer DEFAULT_BUYER_TXN_FEE_RULE_ID = 0;
    public static final Integer DEFAULT_CANCEL_REASON = 0;
    public static final Integer DEFAULT_CARD_TXN_FEE_RULE_ID = 0;
    public static final Boolean DEFAULT_DONOT_CREATE_FRAUDREFUND = false;
    public static final Boolean DEFAULT_IS_CHANGE_PAYMENT_METHOD = false;
    public static final List<OrderRequestInfo> DEFAULT_ORDERS = Collections.emptyList();
    public static final Long DEFAULT_PAIDBY_WALLET_AMOUNT = 0L;
    public static final String DEFAULT_REJECT_REASON = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_RUN_BY_TOOLS = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer buyer_txn_fee_rule_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer cancel_reason;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer card_txn_fee_rule_id;
    @ProtoField(tag = 3)
    public final Checkout checkout;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean donot_create_fraudrefund;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean is_change_payment_method;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderRequestInfo.class, tag = 11)
    public final List<OrderRequestInfo> orders;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long paidby_wallet_amount;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String reject_reason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean run_by_tools;

    public SetCheckout(String str, BackendParam backendParam, Checkout checkout2, Integer num, Boolean bool, String str2, Integer num2, Long l, Boolean bool2, Integer num3, List<OrderRequestInfo> list, Boolean bool3) {
        this.requestid = str;
        this.bparam = backendParam;
        this.checkout = checkout2;
        this.cancel_reason = num;
        this.run_by_tools = bool;
        this.reject_reason = str2;
        this.card_txn_fee_rule_id = num2;
        this.paidby_wallet_amount = l;
        this.donot_create_fraudrefund = bool2;
        this.buyer_txn_fee_rule_id = num3;
        this.orders = immutableCopyOf(list);
        this.is_change_payment_method = bool3;
    }

    private SetCheckout(Builder builder) {
        this(builder.requestid, builder.bparam, builder.checkout, builder.cancel_reason, builder.run_by_tools, builder.reject_reason, builder.card_txn_fee_rule_id, builder.paidby_wallet_amount, builder.donot_create_fraudrefund, builder.buyer_txn_fee_rule_id, builder.orders, builder.is_change_payment_method);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCheckout)) {
            return false;
        }
        SetCheckout setCheckout = (SetCheckout) obj;
        if (!equals((Object) this.requestid, (Object) setCheckout.requestid) || !equals((Object) this.bparam, (Object) setCheckout.bparam) || !equals((Object) this.checkout, (Object) setCheckout.checkout) || !equals((Object) this.cancel_reason, (Object) setCheckout.cancel_reason) || !equals((Object) this.run_by_tools, (Object) setCheckout.run_by_tools) || !equals((Object) this.reject_reason, (Object) setCheckout.reject_reason) || !equals((Object) this.card_txn_fee_rule_id, (Object) setCheckout.card_txn_fee_rule_id) || !equals((Object) this.paidby_wallet_amount, (Object) setCheckout.paidby_wallet_amount) || !equals((Object) this.donot_create_fraudrefund, (Object) setCheckout.donot_create_fraudrefund) || !equals((Object) this.buyer_txn_fee_rule_id, (Object) setCheckout.buyer_txn_fee_rule_id) || !equals((List<?>) this.orders, (List<?>) setCheckout.orders) || !equals((Object) this.is_change_payment_method, (Object) setCheckout.is_change_payment_method)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Checkout checkout2 = this.checkout;
        int hashCode3 = (hashCode2 + (checkout2 != null ? checkout2.hashCode() : 0)) * 37;
        Integer num = this.cancel_reason;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.run_by_tools;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.reject_reason;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.card_txn_fee_rule_id;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.paidby_wallet_amount;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool2 = this.donot_create_fraudrefund;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num3 = this.buyer_txn_fee_rule_id;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<OrderRequestInfo> list = this.orders;
        int hashCode11 = (hashCode10 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool3 = this.is_change_payment_method;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCheckout> {
        public BackendParam bparam;
        public Integer buyer_txn_fee_rule_id;
        public Integer cancel_reason;
        public Integer card_txn_fee_rule_id;
        public Checkout checkout;
        public Boolean donot_create_fraudrefund;
        public Boolean is_change_payment_method;
        public List<OrderRequestInfo> orders;
        public Long paidby_wallet_amount;
        public String reject_reason;
        public String requestid;
        public Boolean run_by_tools;

        public Builder() {
        }

        public Builder(SetCheckout setCheckout) {
            super(setCheckout);
            if (setCheckout != null) {
                this.requestid = setCheckout.requestid;
                this.bparam = setCheckout.bparam;
                this.checkout = setCheckout.checkout;
                this.cancel_reason = setCheckout.cancel_reason;
                this.run_by_tools = setCheckout.run_by_tools;
                this.reject_reason = setCheckout.reject_reason;
                this.card_txn_fee_rule_id = setCheckout.card_txn_fee_rule_id;
                this.paidby_wallet_amount = setCheckout.paidby_wallet_amount;
                this.donot_create_fraudrefund = setCheckout.donot_create_fraudrefund;
                this.buyer_txn_fee_rule_id = setCheckout.buyer_txn_fee_rule_id;
                this.orders = SetCheckout.copyOf(setCheckout.orders);
                this.is_change_payment_method = setCheckout.is_change_payment_method;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder checkout(Checkout checkout2) {
            this.checkout = checkout2;
            return this;
        }

        public Builder cancel_reason(Integer num) {
            this.cancel_reason = num;
            return this;
        }

        public Builder run_by_tools(Boolean bool) {
            this.run_by_tools = bool;
            return this;
        }

        public Builder reject_reason(String str) {
            this.reject_reason = str;
            return this;
        }

        public Builder card_txn_fee_rule_id(Integer num) {
            this.card_txn_fee_rule_id = num;
            return this;
        }

        public Builder paidby_wallet_amount(Long l) {
            this.paidby_wallet_amount = l;
            return this;
        }

        public Builder donot_create_fraudrefund(Boolean bool) {
            this.donot_create_fraudrefund = bool;
            return this;
        }

        public Builder buyer_txn_fee_rule_id(Integer num) {
            this.buyer_txn_fee_rule_id = num;
            return this;
        }

        public Builder orders(List<OrderRequestInfo> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder is_change_payment_method(Boolean bool) {
            this.is_change_payment_method = bool;
            return this;
        }

        public SetCheckout build() {
            return new SetCheckout(this);
        }
    }
}
