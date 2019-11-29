package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseUnpaidOrders extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<UnpaidOrder> DEFAULT_UNPAID_ORDERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = UnpaidOrder.class, tag = 3)
    public final List<UnpaidOrder> unpaid_orders;

    public ResponseUnpaidOrders(String str, Integer num, List<UnpaidOrder> list) {
        this.requestid = str;
        this.errcode = num;
        this.unpaid_orders = immutableCopyOf(list);
    }

    private ResponseUnpaidOrders(Builder builder) {
        this(builder.requestid, builder.errcode, builder.unpaid_orders);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUnpaidOrders)) {
            return false;
        }
        ResponseUnpaidOrders responseUnpaidOrders = (ResponseUnpaidOrders) obj;
        if (!equals((Object) this.requestid, (Object) responseUnpaidOrders.requestid) || !equals((Object) this.errcode, (Object) responseUnpaidOrders.errcode) || !equals((List<?>) this.unpaid_orders, (List<?>) responseUnpaidOrders.unpaid_orders)) {
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
        List<UnpaidOrder> list = this.unpaid_orders;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseUnpaidOrders> {
        public Integer errcode;
        public String requestid;
        public List<UnpaidOrder> unpaid_orders;

        public Builder() {
        }

        public Builder(ResponseUnpaidOrders responseUnpaidOrders) {
            super(responseUnpaidOrders);
            if (responseUnpaidOrders != null) {
                this.requestid = responseUnpaidOrders.requestid;
                this.errcode = responseUnpaidOrders.errcode;
                this.unpaid_orders = ResponseUnpaidOrders.copyOf(responseUnpaidOrders.unpaid_orders);
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

        public Builder unpaid_orders(List<UnpaidOrder> list) {
            this.unpaid_orders = checkForNulls(list);
            return this;
        }

        public ResponseUnpaidOrders build() {
            checkRequiredFields();
            return new ResponseUnpaidOrders(this);
        }
    }
}
