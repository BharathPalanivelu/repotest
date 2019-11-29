package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActDidPlaceOrder extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final List<Long> DEFAULT_ORDER_ITEMIDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> order_itemids;

    public ActDidPlaceOrder(Long l, List<Long> list) {
        this.checkoutid = l;
        this.order_itemids = immutableCopyOf(list);
    }

    private ActDidPlaceOrder(Builder builder) {
        this(builder.checkoutid, builder.order_itemids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActDidPlaceOrder)) {
            return false;
        }
        ActDidPlaceOrder actDidPlaceOrder = (ActDidPlaceOrder) obj;
        if (!equals((Object) this.checkoutid, (Object) actDidPlaceOrder.checkoutid) || !equals((List<?>) this.order_itemids, (List<?>) actDidPlaceOrder.order_itemids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.checkoutid;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<Long> list = this.order_itemids;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ActDidPlaceOrder> {
        public Long checkoutid;
        public List<Long> order_itemids;

        public Builder() {
        }

        public Builder(ActDidPlaceOrder actDidPlaceOrder) {
            super(actDidPlaceOrder);
            if (actDidPlaceOrder != null) {
                this.checkoutid = actDidPlaceOrder.checkoutid;
                this.order_itemids = ActDidPlaceOrder.copyOf(actDidPlaceOrder.order_itemids);
            }
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder order_itemids(List<Long> list) {
            this.order_itemids = checkForNulls(list);
            return this;
        }

        public ActDidPlaceOrder build() {
            return new ActDidPlaceOrder(this);
        }
    }
}
