package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopCustomer extends Message {
    public static final String DEFAULT_SHIPPING_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final Order order;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String shipping_name;
    @ProtoField(tag = 1)
    public final UserBrief user;

    public ShopCustomer(UserBrief userBrief, Order order2, String str) {
        this.user = userBrief;
        this.order = order2;
        this.shipping_name = str;
    }

    private ShopCustomer(Builder builder) {
        this(builder.user, builder.order, builder.shipping_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCustomer)) {
            return false;
        }
        ShopCustomer shopCustomer = (ShopCustomer) obj;
        if (!equals((Object) this.user, (Object) shopCustomer.user) || !equals((Object) this.order, (Object) shopCustomer.order) || !equals((Object) this.shipping_name, (Object) shopCustomer.shipping_name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        UserBrief userBrief = this.user;
        int i2 = 0;
        int hashCode = (userBrief != null ? userBrief.hashCode() : 0) * 37;
        Order order2 = this.order;
        int hashCode2 = (hashCode + (order2 != null ? order2.hashCode() : 0)) * 37;
        String str = this.shipping_name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCustomer> {
        public Order order;
        public String shipping_name;
        public UserBrief user;

        public Builder() {
        }

        public Builder(ShopCustomer shopCustomer) {
            super(shopCustomer);
            if (shopCustomer != null) {
                this.user = shopCustomer.user;
                this.order = shopCustomer.order;
                this.shipping_name = shopCustomer.shipping_name;
            }
        }

        public Builder user(UserBrief userBrief) {
            this.user = userBrief;
            return this;
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder shipping_name(String str) {
            this.shipping_name = str;
            return this;
        }

        public ShopCustomer build() {
            return new ShopCustomer(this);
        }
    }
}
