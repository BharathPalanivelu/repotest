package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BuyerCancelOrder extends Message {
    public static final Integer DEFAULT_BUYER_CANCEL_REASON = 0;
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SELLER_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer buyer_cancel_reason;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer seller_shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public BuyerCancelOrder(String str, String str2, Long l, Integer num, Integer num2, Boolean bool) {
        this.requestid = str;
        this.token = str2;
        this.orderid = l;
        this.seller_shopid = num;
        this.buyer_cancel_reason = num2;
        this.is_group_buy = bool;
    }

    private BuyerCancelOrder(Builder builder) {
        this(builder.requestid, builder.token, builder.orderid, builder.seller_shopid, builder.buyer_cancel_reason, builder.is_group_buy);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerCancelOrder)) {
            return false;
        }
        BuyerCancelOrder buyerCancelOrder = (BuyerCancelOrder) obj;
        if (!equals((Object) this.requestid, (Object) buyerCancelOrder.requestid) || !equals((Object) this.token, (Object) buyerCancelOrder.token) || !equals((Object) this.orderid, (Object) buyerCancelOrder.orderid) || !equals((Object) this.seller_shopid, (Object) buyerCancelOrder.seller_shopid) || !equals((Object) this.buyer_cancel_reason, (Object) buyerCancelOrder.buyer_cancel_reason) || !equals((Object) this.is_group_buy, (Object) buyerCancelOrder.is_group_buy)) {
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
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.seller_shopid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.buyer_cancel_reason;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.is_group_buy;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BuyerCancelOrder> {
        public Integer buyer_cancel_reason;
        public Boolean is_group_buy;
        public Long orderid;
        public String requestid;
        public Integer seller_shopid;
        public String token;

        public Builder() {
        }

        public Builder(BuyerCancelOrder buyerCancelOrder) {
            super(buyerCancelOrder);
            if (buyerCancelOrder != null) {
                this.requestid = buyerCancelOrder.requestid;
                this.token = buyerCancelOrder.token;
                this.orderid = buyerCancelOrder.orderid;
                this.seller_shopid = buyerCancelOrder.seller_shopid;
                this.buyer_cancel_reason = buyerCancelOrder.buyer_cancel_reason;
                this.is_group_buy = buyerCancelOrder.is_group_buy;
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

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder seller_shopid(Integer num) {
            this.seller_shopid = num;
            return this;
        }

        public Builder buyer_cancel_reason(Integer num) {
            this.buyer_cancel_reason = num;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public BuyerCancelOrder build() {
            checkRequiredFields();
            return new BuyerCancelOrder(this);
        }
    }
}
