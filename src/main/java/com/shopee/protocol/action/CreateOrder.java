package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.OrderItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CreateOrder extends Message {
    public static final List<OrderItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItem.class, tag = 3)
    public final List<OrderItem> items;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Order order;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public CreateOrder(String str, Order order2, List<OrderItem> list, String str2) {
        this.requestid = str;
        this.order = order2;
        this.items = immutableCopyOf(list);
        this.token = str2;
    }

    private CreateOrder(Builder builder) {
        this(builder.requestid, builder.order, builder.items, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateOrder)) {
            return false;
        }
        CreateOrder createOrder = (CreateOrder) obj;
        if (!equals((Object) this.requestid, (Object) createOrder.requestid) || !equals((Object) this.order, (Object) createOrder.order) || !equals((List<?>) this.items, (List<?>) createOrder.items) || !equals((Object) this.token, (Object) createOrder.token)) {
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
        Order order2 = this.order;
        int hashCode2 = (hashCode + (order2 != null ? order2.hashCode() : 0)) * 37;
        List<OrderItem> list = this.items;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreateOrder> {
        public List<OrderItem> items;
        public Order order;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(CreateOrder createOrder) {
            super(createOrder);
            if (createOrder != null) {
                this.requestid = createOrder.requestid;
                this.order = createOrder.order;
                this.items = CreateOrder.copyOf(createOrder.items);
                this.token = createOrder.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public CreateOrder build() {
            checkRequiredFields();
            return new CreateOrder(this);
        }
    }
}
