package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderDetailedStatus extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public OrderDetailedStatus(Integer num, String str, Integer num2) {
        this.type = num;
        this.description = str;
        this.ctime = num2;
    }

    private OrderDetailedStatus(Builder builder) {
        this(builder.type, builder.description, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderDetailedStatus)) {
            return false;
        }
        OrderDetailedStatus orderDetailedStatus = (OrderDetailedStatus) obj;
        if (!equals((Object) this.type, (Object) orderDetailedStatus.type) || !equals((Object) this.description, (Object) orderDetailedStatus.description) || !equals((Object) this.ctime, (Object) orderDetailedStatus.ctime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderDetailedStatus> {
        public Integer ctime;
        public String description;
        public Integer type;

        public Builder() {
        }

        public Builder(OrderDetailedStatus orderDetailedStatus) {
            super(orderDetailedStatus);
            if (orderDetailedStatus != null) {
                this.type = orderDetailedStatus.type;
                this.description = orderDetailedStatus.description;
                this.ctime = orderDetailedStatus.ctime;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public OrderDetailedStatus build() {
            return new OrderDetailedStatus(this);
        }
    }
}
