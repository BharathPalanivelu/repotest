package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderRequestInfo extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_SELLER_TXN_FEE_RULE_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final JkoSellerInfo jko_seller_info;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer seller_txn_fee_rule_id;

    public OrderRequestInfo(Long l, Integer num, JkoSellerInfo jkoSellerInfo) {
        this.orderid = l;
        this.seller_txn_fee_rule_id = num;
        this.jko_seller_info = jkoSellerInfo;
    }

    private OrderRequestInfo(Builder builder) {
        this(builder.orderid, builder.seller_txn_fee_rule_id, builder.jko_seller_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderRequestInfo)) {
            return false;
        }
        OrderRequestInfo orderRequestInfo = (OrderRequestInfo) obj;
        if (!equals((Object) this.orderid, (Object) orderRequestInfo.orderid) || !equals((Object) this.seller_txn_fee_rule_id, (Object) orderRequestInfo.seller_txn_fee_rule_id) || !equals((Object) this.jko_seller_info, (Object) orderRequestInfo.jko_seller_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.orderid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.seller_txn_fee_rule_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        JkoSellerInfo jkoSellerInfo = this.jko_seller_info;
        if (jkoSellerInfo != null) {
            i2 = jkoSellerInfo.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderRequestInfo> {
        public JkoSellerInfo jko_seller_info;
        public Long orderid;
        public Integer seller_txn_fee_rule_id;

        public Builder() {
        }

        public Builder(OrderRequestInfo orderRequestInfo) {
            super(orderRequestInfo);
            if (orderRequestInfo != null) {
                this.orderid = orderRequestInfo.orderid;
                this.seller_txn_fee_rule_id = orderRequestInfo.seller_txn_fee_rule_id;
                this.jko_seller_info = orderRequestInfo.jko_seller_info;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder seller_txn_fee_rule_id(Integer num) {
            this.seller_txn_fee_rule_id = num;
            return this;
        }

        public Builder jko_seller_info(JkoSellerInfo jkoSellerInfo) {
            this.jko_seller_info = jkoSellerInfo;
            return this;
        }

        public OrderRequestInfo build() {
            return new OrderRequestInfo(this);
        }
    }
}
