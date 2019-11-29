package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.OrderItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseOrder extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<OrderItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5)
    public final OrderInfo info;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItem.class, tag = 4)
    public final List<OrderItem> items;
    @ProtoField(tag = 3)
    public final Order order;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseOrder(String str, Integer num, Order order2, List<OrderItem> list, OrderInfo orderInfo) {
        this.requestid = str;
        this.errcode = num;
        this.order = order2;
        this.items = immutableCopyOf(list);
        this.info = orderInfo;
    }

    private ResponseOrder(Builder builder) {
        this(builder.requestid, builder.errcode, builder.order, builder.items, builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseOrder)) {
            return false;
        }
        ResponseOrder responseOrder = (ResponseOrder) obj;
        if (!equals((Object) this.requestid, (Object) responseOrder.requestid) || !equals((Object) this.errcode, (Object) responseOrder.errcode) || !equals((Object) this.order, (Object) responseOrder.order) || !equals((List<?>) this.items, (List<?>) responseOrder.items) || !equals((Object) this.info, (Object) responseOrder.info)) {
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
        Order order2 = this.order;
        int hashCode3 = (hashCode2 + (order2 != null ? order2.hashCode() : 0)) * 37;
        List<OrderItem> list = this.items;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        OrderInfo orderInfo = this.info;
        if (orderInfo != null) {
            i2 = orderInfo.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseOrder> {
        public Integer errcode;
        public OrderInfo info;
        public List<OrderItem> items;
        public Order order;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseOrder responseOrder) {
            super(responseOrder);
            if (responseOrder != null) {
                this.requestid = responseOrder.requestid;
                this.errcode = responseOrder.errcode;
                this.order = responseOrder.order;
                this.items = ResponseOrder.copyOf(responseOrder.items);
                this.info = responseOrder.info;
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

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder items(List<OrderItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder info(OrderInfo orderInfo) {
            this.info = orderInfo;
            return this;
        }

        public ResponseOrder build() {
            checkRequiredFields();
            return new ResponseOrder(this);
        }
    }
}
