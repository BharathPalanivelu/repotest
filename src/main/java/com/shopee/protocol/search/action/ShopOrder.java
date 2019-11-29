package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopOrder extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_SHIPPING_NAME = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String shipping_name;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public ShopOrder(Integer num, Long l, String str, Integer num2) {
        this.userid = num;
        this.orderid = l;
        this.shipping_name = str;
        this.shopid = num2;
    }

    private ShopOrder(Builder builder) {
        this(builder.userid, builder.orderid, builder.shipping_name, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopOrder)) {
            return false;
        }
        ShopOrder shopOrder = (ShopOrder) obj;
        if (!equals((Object) this.userid, (Object) shopOrder.userid) || !equals((Object) this.orderid, (Object) shopOrder.orderid) || !equals((Object) this.shipping_name, (Object) shopOrder.shipping_name) || !equals((Object) this.shopid, (Object) shopOrder.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.shipping_name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopOrder> {
        public Long orderid;
        public String shipping_name;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(ShopOrder shopOrder) {
            super(shopOrder);
            if (shopOrder != null) {
                this.userid = shopOrder.userid;
                this.orderid = shopOrder.orderid;
                this.shipping_name = shopOrder.shipping_name;
                this.shopid = shopOrder.shopid;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder shipping_name(String str) {
            this.shipping_name = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public ShopOrder build() {
            return new ShopOrder(this);
        }
    }
}
