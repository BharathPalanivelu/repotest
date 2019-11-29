package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UpdateCancelPendingOrder extends Message {
    public static final Boolean DEFAULT_IS_ACCEPT = false;
    public static final Boolean DEFAULT_IS_BUYER_RECALL = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SELLER_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_accept;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_buyer_recall;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.INT32)
    public final Integer seller_shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public UpdateCancelPendingOrder(String str, String str2, Long l, BackendParam backendParam, Boolean bool, Boolean bool2, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.orderid = l;
        this.bparam = backendParam;
        this.is_accept = bool;
        this.is_buyer_recall = bool2;
        this.seller_shopid = num;
    }

    private UpdateCancelPendingOrder(Builder builder) {
        this(builder.requestid, builder.token, builder.orderid, builder.bparam, builder.is_accept, builder.is_buyer_recall, builder.seller_shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateCancelPendingOrder)) {
            return false;
        }
        UpdateCancelPendingOrder updateCancelPendingOrder = (UpdateCancelPendingOrder) obj;
        if (!equals((Object) this.requestid, (Object) updateCancelPendingOrder.requestid) || !equals((Object) this.token, (Object) updateCancelPendingOrder.token) || !equals((Object) this.orderid, (Object) updateCancelPendingOrder.orderid) || !equals((Object) this.bparam, (Object) updateCancelPendingOrder.bparam) || !equals((Object) this.is_accept, (Object) updateCancelPendingOrder.is_accept) || !equals((Object) this.is_buyer_recall, (Object) updateCancelPendingOrder.is_buyer_recall) || !equals((Object) this.seller_shopid, (Object) updateCancelPendingOrder.seller_shopid)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool = this.is_accept;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_buyer_recall;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num = this.seller_shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdateCancelPendingOrder> {
        public BackendParam bparam;
        public Boolean is_accept;
        public Boolean is_buyer_recall;
        public Long orderid;
        public String requestid;
        public Integer seller_shopid;
        public String token;

        public Builder() {
        }

        public Builder(UpdateCancelPendingOrder updateCancelPendingOrder) {
            super(updateCancelPendingOrder);
            if (updateCancelPendingOrder != null) {
                this.requestid = updateCancelPendingOrder.requestid;
                this.token = updateCancelPendingOrder.token;
                this.orderid = updateCancelPendingOrder.orderid;
                this.bparam = updateCancelPendingOrder.bparam;
                this.is_accept = updateCancelPendingOrder.is_accept;
                this.is_buyer_recall = updateCancelPendingOrder.is_buyer_recall;
                this.seller_shopid = updateCancelPendingOrder.seller_shopid;
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder is_accept(Boolean bool) {
            this.is_accept = bool;
            return this;
        }

        public Builder is_buyer_recall(Boolean bool) {
            this.is_buyer_recall = bool;
            return this;
        }

        public Builder seller_shopid(Integer num) {
            this.seller_shopid = num;
            return this;
        }

        public UpdateCancelPendingOrder build() {
            checkRequiredFields();
            return new UpdateCancelPendingOrder(this);
        }
    }
}
