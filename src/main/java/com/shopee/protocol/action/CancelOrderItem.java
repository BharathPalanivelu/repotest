package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CancelOrderItem extends Message {
    public static final List<OrderItemIds> DEFAULT_ITEMS = Collections.emptyList();
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PARCELID = 0L;
    public static final Integer DEFAULT_REASON = 0;
    public static final Long DEFAULT_REFUND_SHIPPING_FEE = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_RESTOCK = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItemIds.class, tag = 6)
    public final List<OrderItemIds> items;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long parcelid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer reason;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long refund_shipping_fee;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean restock;

    public CancelOrderItem(String str, Long l, BackendParam backendParam, Long l2, Long l3, List<OrderItemIds> list, Integer num, Boolean bool) {
        this.requestid = str;
        this.orderid = l;
        this.bparam = backendParam;
        this.parcelid = l2;
        this.refund_shipping_fee = l3;
        this.items = immutableCopyOf(list);
        this.reason = num;
        this.restock = bool;
    }

    private CancelOrderItem(Builder builder) {
        this(builder.requestid, builder.orderid, builder.bparam, builder.parcelid, builder.refund_shipping_fee, builder.items, builder.reason, builder.restock);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelOrderItem)) {
            return false;
        }
        CancelOrderItem cancelOrderItem = (CancelOrderItem) obj;
        if (!equals((Object) this.requestid, (Object) cancelOrderItem.requestid) || !equals((Object) this.orderid, (Object) cancelOrderItem.orderid) || !equals((Object) this.bparam, (Object) cancelOrderItem.bparam) || !equals((Object) this.parcelid, (Object) cancelOrderItem.parcelid) || !equals((Object) this.refund_shipping_fee, (Object) cancelOrderItem.refund_shipping_fee) || !equals((List<?>) this.items, (List<?>) cancelOrderItem.items) || !equals((Object) this.reason, (Object) cancelOrderItem.reason) || !equals((Object) this.restock, (Object) cancelOrderItem.restock)) {
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
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Long l2 = this.parcelid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.refund_shipping_fee;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        List<OrderItemIds> list = this.items;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.reason;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.restock;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CancelOrderItem> {
        public BackendParam bparam;
        public List<OrderItemIds> items;
        public Long orderid;
        public Long parcelid;
        public Integer reason;
        public Long refund_shipping_fee;
        public String requestid;
        public Boolean restock;

        public Builder() {
        }

        public Builder(CancelOrderItem cancelOrderItem) {
            super(cancelOrderItem);
            if (cancelOrderItem != null) {
                this.requestid = cancelOrderItem.requestid;
                this.orderid = cancelOrderItem.orderid;
                this.bparam = cancelOrderItem.bparam;
                this.parcelid = cancelOrderItem.parcelid;
                this.refund_shipping_fee = cancelOrderItem.refund_shipping_fee;
                this.items = CancelOrderItem.copyOf(cancelOrderItem.items);
                this.reason = cancelOrderItem.reason;
                this.restock = cancelOrderItem.restock;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder parcelid(Long l) {
            this.parcelid = l;
            return this;
        }

        public Builder refund_shipping_fee(Long l) {
            this.refund_shipping_fee = l;
            return this;
        }

        public Builder items(List<OrderItemIds> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder reason(Integer num) {
            this.reason = num;
            return this;
        }

        public Builder restock(Boolean bool) {
            this.restock = bool;
            return this;
        }

        public CancelOrderItem build() {
            return new CancelOrderItem(this);
        }
    }
}
