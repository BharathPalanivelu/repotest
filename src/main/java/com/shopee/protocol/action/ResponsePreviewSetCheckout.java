package com.shopee.protocol.action;

import com.shopee.protocol.shop.Checkout;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponsePreviewSetCheckout extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Long DEFAULT_NEW_ADMIN_FEE = 0L;
    public static final Long DEFAULT_NEW_BUYER_TXN_FEE = 0L;
    public static final List<OrderWithItems> DEFAULT_ORDERS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final Checkout checkout;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long new_admin_fee;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long new_buyer_txn_fee;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderWithItems.class, tag = 4)
    public final List<OrderWithItems> orders;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponsePreviewSetCheckout(String str, Integer num, Checkout checkout2, List<OrderWithItems> list, Long l, Long l2) {
        this.requestid = str;
        this.errcode = num;
        this.checkout = checkout2;
        this.orders = immutableCopyOf(list);
        this.new_buyer_txn_fee = l;
        this.new_admin_fee = l2;
    }

    private ResponsePreviewSetCheckout(Builder builder) {
        this(builder.requestid, builder.errcode, builder.checkout, builder.orders, builder.new_buyer_txn_fee, builder.new_admin_fee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsePreviewSetCheckout)) {
            return false;
        }
        ResponsePreviewSetCheckout responsePreviewSetCheckout = (ResponsePreviewSetCheckout) obj;
        if (!equals((Object) this.requestid, (Object) responsePreviewSetCheckout.requestid) || !equals((Object) this.errcode, (Object) responsePreviewSetCheckout.errcode) || !equals((Object) this.checkout, (Object) responsePreviewSetCheckout.checkout) || !equals((List<?>) this.orders, (List<?>) responsePreviewSetCheckout.orders) || !equals((Object) this.new_buyer_txn_fee, (Object) responsePreviewSetCheckout.new_buyer_txn_fee) || !equals((Object) this.new_admin_fee, (Object) responsePreviewSetCheckout.new_admin_fee)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Checkout checkout2 = this.checkout;
        int hashCode3 = (hashCode2 + (checkout2 != null ? checkout2.hashCode() : 0)) * 37;
        List<OrderWithItems> list = this.orders;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.new_buyer_txn_fee;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.new_admin_fee;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponsePreviewSetCheckout> {
        public Checkout checkout;
        public Integer errcode;
        public Long new_admin_fee;
        public Long new_buyer_txn_fee;
        public List<OrderWithItems> orders;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponsePreviewSetCheckout responsePreviewSetCheckout) {
            super(responsePreviewSetCheckout);
            if (responsePreviewSetCheckout != null) {
                this.requestid = responsePreviewSetCheckout.requestid;
                this.errcode = responsePreviewSetCheckout.errcode;
                this.checkout = responsePreviewSetCheckout.checkout;
                this.orders = ResponsePreviewSetCheckout.copyOf(responsePreviewSetCheckout.orders);
                this.new_buyer_txn_fee = responsePreviewSetCheckout.new_buyer_txn_fee;
                this.new_admin_fee = responsePreviewSetCheckout.new_admin_fee;
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

        public Builder checkout(Checkout checkout2) {
            this.checkout = checkout2;
            return this;
        }

        public Builder orders(List<OrderWithItems> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder new_buyer_txn_fee(Long l) {
            this.new_buyer_txn_fee = l;
            return this;
        }

        public Builder new_admin_fee(Long l) {
            this.new_admin_fee = l;
            return this;
        }

        public ResponsePreviewSetCheckout build() {
            return new ResponsePreviewSetCheckout(this);
        }
    }
}
