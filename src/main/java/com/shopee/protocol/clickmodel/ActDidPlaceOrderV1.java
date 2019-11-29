package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActDidPlaceOrderV1 extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final List<String> DEFAULT_ORDER_ITEMIDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> order_itemids;

    public ActDidPlaceOrderV1(Long l, List<String> list) {
        this.checkoutid = l;
        this.order_itemids = immutableCopyOf(list);
    }

    private ActDidPlaceOrderV1(Builder builder) {
        this(builder.checkoutid, builder.order_itemids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActDidPlaceOrderV1)) {
            return false;
        }
        ActDidPlaceOrderV1 actDidPlaceOrderV1 = (ActDidPlaceOrderV1) obj;
        if (!equals((Object) this.checkoutid, (Object) actDidPlaceOrderV1.checkoutid) || !equals((List<?>) this.order_itemids, (List<?>) actDidPlaceOrderV1.order_itemids)) {
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
        List<String> list = this.order_itemids;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ActDidPlaceOrderV1> {
        public Long checkoutid;
        public List<String> order_itemids;

        public Builder() {
        }

        public Builder(ActDidPlaceOrderV1 actDidPlaceOrderV1) {
            super(actDidPlaceOrderV1);
            if (actDidPlaceOrderV1 != null) {
                this.checkoutid = actDidPlaceOrderV1.checkoutid;
                this.order_itemids = ActDidPlaceOrderV1.copyOf(actDidPlaceOrderV1.order_itemids);
            }
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder order_itemids(List<String> list) {
            this.order_itemids = checkForNulls(list);
            return this;
        }

        public ActDidPlaceOrderV1 build() {
            return new ActDidPlaceOrderV1(this);
        }
    }
}
