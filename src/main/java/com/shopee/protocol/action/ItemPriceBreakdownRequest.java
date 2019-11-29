package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemPriceBreakdownRequest extends Message {
    public static final List<OrderItemBatch> DEFAULT_BATCHES = Collections.emptyList();
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItemBatch.class, tag = 5)
    public final List<OrderItemBatch> batches;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public ItemPriceBreakdownRequest(String str, Long l, BackendParam backendParam, String str2, List<OrderItemBatch> list) {
        this.requestid = str;
        this.orderid = l;
        this.bparam = backendParam;
        this.token = str2;
        this.batches = immutableCopyOf(list);
    }

    private ItemPriceBreakdownRequest(Builder builder) {
        this(builder.requestid, builder.orderid, builder.bparam, builder.token, builder.batches);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemPriceBreakdownRequest)) {
            return false;
        }
        ItemPriceBreakdownRequest itemPriceBreakdownRequest = (ItemPriceBreakdownRequest) obj;
        if (!equals((Object) this.requestid, (Object) itemPriceBreakdownRequest.requestid) || !equals((Object) this.orderid, (Object) itemPriceBreakdownRequest.orderid) || !equals((Object) this.bparam, (Object) itemPriceBreakdownRequest.bparam) || !equals((Object) this.token, (Object) itemPriceBreakdownRequest.token) || !equals((List<?>) this.batches, (List<?>) itemPriceBreakdownRequest.batches)) {
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
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<OrderItemBatch> list = this.batches;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<ItemPriceBreakdownRequest> {
        public List<OrderItemBatch> batches;
        public BackendParam bparam;
        public Long orderid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ItemPriceBreakdownRequest itemPriceBreakdownRequest) {
            super(itemPriceBreakdownRequest);
            if (itemPriceBreakdownRequest != null) {
                this.requestid = itemPriceBreakdownRequest.requestid;
                this.orderid = itemPriceBreakdownRequest.orderid;
                this.bparam = itemPriceBreakdownRequest.bparam;
                this.token = itemPriceBreakdownRequest.token;
                this.batches = ItemPriceBreakdownRequest.copyOf(itemPriceBreakdownRequest.batches);
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder batches(List<OrderItemBatch> list) {
            this.batches = checkForNulls(list);
            return this;
        }

        public ItemPriceBreakdownRequest build() {
            return new ItemPriceBreakdownRequest(this);
        }
    }
}
