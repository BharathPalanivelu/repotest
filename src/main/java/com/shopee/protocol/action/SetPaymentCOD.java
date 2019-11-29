package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetPaymentCOD extends Message {
    public static final Integer DEFAULT_BUYER_TXN_FEE_RULE_ID = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final List<OrderRequestInfo> DEFAULT_ORDERS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer buyer_txn_fee_rule_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderRequestInfo.class, tag = 5)
    public final List<OrderRequestInfo> orders;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public SetPaymentCOD(String str, String str2, Long l, Integer num, List<OrderRequestInfo> list) {
        this.requestid = str;
        this.token = str2;
        this.checkoutid = l;
        this.buyer_txn_fee_rule_id = num;
        this.orders = immutableCopyOf(list);
    }

    private SetPaymentCOD(Builder builder) {
        this(builder.requestid, builder.token, builder.checkoutid, builder.buyer_txn_fee_rule_id, builder.orders);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetPaymentCOD)) {
            return false;
        }
        SetPaymentCOD setPaymentCOD = (SetPaymentCOD) obj;
        if (!equals((Object) this.requestid, (Object) setPaymentCOD.requestid) || !equals((Object) this.token, (Object) setPaymentCOD.token) || !equals((Object) this.checkoutid, (Object) setPaymentCOD.checkoutid) || !equals((Object) this.buyer_txn_fee_rule_id, (Object) setPaymentCOD.buyer_txn_fee_rule_id) || !equals((List<?>) this.orders, (List<?>) setPaymentCOD.orders)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.checkoutid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.buyer_txn_fee_rule_id;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<OrderRequestInfo> list = this.orders;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<SetPaymentCOD> {
        public Integer buyer_txn_fee_rule_id;
        public Long checkoutid;
        public List<OrderRequestInfo> orders;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetPaymentCOD setPaymentCOD) {
            super(setPaymentCOD);
            if (setPaymentCOD != null) {
                this.requestid = setPaymentCOD.requestid;
                this.token = setPaymentCOD.token;
                this.checkoutid = setPaymentCOD.checkoutid;
                this.buyer_txn_fee_rule_id = setPaymentCOD.buyer_txn_fee_rule_id;
                this.orders = SetPaymentCOD.copyOf(setPaymentCOD.orders);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
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

        public SetPaymentCOD build() {
            return new SetPaymentCOD(this);
        }
    }
}
