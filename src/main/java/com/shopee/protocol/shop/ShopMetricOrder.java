package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopMetricOrder extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_ORDER_PICKUP_TIME = 0;
    public static final Integer DEFAULT_ORDER_SHIP_BY_TIME = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer order_pickup_time;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer order_ship_by_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    public ShopMetricOrder(Long l, Integer num, Integer num2, Integer num3, Integer num4) {
        this.orderid = l;
        this.order_pickup_time = num;
        this.order_ship_by_time = num2;
        this.type = num3;
        this.ctime = num4;
    }

    private ShopMetricOrder(Builder builder) {
        this(builder.orderid, builder.order_pickup_time, builder.order_ship_by_time, builder.type, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopMetricOrder)) {
            return false;
        }
        ShopMetricOrder shopMetricOrder = (ShopMetricOrder) obj;
        if (!equals((Object) this.orderid, (Object) shopMetricOrder.orderid) || !equals((Object) this.order_pickup_time, (Object) shopMetricOrder.order_pickup_time) || !equals((Object) this.order_ship_by_time, (Object) shopMetricOrder.order_ship_by_time) || !equals((Object) this.type, (Object) shopMetricOrder.type) || !equals((Object) this.ctime, (Object) shopMetricOrder.ctime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.orderid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.order_pickup_time;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.order_ship_by_time;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.type;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopMetricOrder> {
        public Integer ctime;
        public Integer order_pickup_time;
        public Integer order_ship_by_time;
        public Long orderid;
        public Integer type;

        public Builder() {
        }

        public Builder(ShopMetricOrder shopMetricOrder) {
            super(shopMetricOrder);
            if (shopMetricOrder != null) {
                this.orderid = shopMetricOrder.orderid;
                this.order_pickup_time = shopMetricOrder.order_pickup_time;
                this.order_ship_by_time = shopMetricOrder.order_ship_by_time;
                this.type = shopMetricOrder.type;
                this.ctime = shopMetricOrder.ctime;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder order_pickup_time(Integer num) {
            this.order_pickup_time = num;
            return this;
        }

        public Builder order_ship_by_time(Integer num) {
            this.order_ship_by_time = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public ShopMetricOrder build() {
            return new ShopMetricOrder(this);
        }
    }
}
