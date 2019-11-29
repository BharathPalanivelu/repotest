package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemPriceBreakdownResponse extends Message {
    public static final List<OrderItemBatchInfo> DEFAULT_BATCHES = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItemBatchInfo.class, tag = 3)
    public final List<OrderItemBatchInfo> batches;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ItemPriceBreakdownResponse(String str, Integer num, List<OrderItemBatchInfo> list) {
        this.requestid = str;
        this.errcode = num;
        this.batches = immutableCopyOf(list);
    }

    private ItemPriceBreakdownResponse(Builder builder) {
        this(builder.requestid, builder.errcode, builder.batches);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemPriceBreakdownResponse)) {
            return false;
        }
        ItemPriceBreakdownResponse itemPriceBreakdownResponse = (ItemPriceBreakdownResponse) obj;
        if (!equals((Object) this.requestid, (Object) itemPriceBreakdownResponse.requestid) || !equals((Object) this.errcode, (Object) itemPriceBreakdownResponse.errcode) || !equals((List<?>) this.batches, (List<?>) itemPriceBreakdownResponse.batches)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<OrderItemBatchInfo> list = this.batches;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ItemPriceBreakdownResponse> {
        public List<OrderItemBatchInfo> batches;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ItemPriceBreakdownResponse itemPriceBreakdownResponse) {
            super(itemPriceBreakdownResponse);
            if (itemPriceBreakdownResponse != null) {
                this.requestid = itemPriceBreakdownResponse.requestid;
                this.errcode = itemPriceBreakdownResponse.errcode;
                this.batches = ItemPriceBreakdownResponse.copyOf(itemPriceBreakdownResponse.batches);
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

        public Builder batches(List<OrderItemBatchInfo> list) {
            this.batches = checkForNulls(list);
            return this;
        }

        public ItemPriceBreakdownResponse build() {
            checkRequiredFields();
            return new ItemPriceBreakdownResponse(this);
        }
    }
}
