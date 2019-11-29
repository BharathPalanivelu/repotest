package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopCustomerGroup extends Message {
    public static final List<ShopCustomer> DEFAULT_CUSTOMERS = Collections.emptyList();
    public static final Integer DEFAULT_CUSTOMER_TYPE = 0;
    public static final Integer DEFAULT_TOTAL = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer customer_type;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopCustomer.class, tag = 2)
    public final List<ShopCustomer> customers;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total;

    public ShopCustomerGroup(Integer num, List<ShopCustomer> list, Integer num2) {
        this.customer_type = num;
        this.customers = immutableCopyOf(list);
        this.total = num2;
    }

    private ShopCustomerGroup(Builder builder) {
        this(builder.customer_type, builder.customers, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCustomerGroup)) {
            return false;
        }
        ShopCustomerGroup shopCustomerGroup = (ShopCustomerGroup) obj;
        if (!equals((Object) this.customer_type, (Object) shopCustomerGroup.customer_type) || !equals((List<?>) this.customers, (List<?>) shopCustomerGroup.customers) || !equals((Object) this.total, (Object) shopCustomerGroup.total)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.customer_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<ShopCustomer> list = this.customers;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCustomerGroup> {
        public Integer customer_type;
        public List<ShopCustomer> customers;
        public Integer total;

        public Builder() {
        }

        public Builder(ShopCustomerGroup shopCustomerGroup) {
            super(shopCustomerGroup);
            if (shopCustomerGroup != null) {
                this.customer_type = shopCustomerGroup.customer_type;
                this.customers = ShopCustomerGroup.copyOf(shopCustomerGroup.customers);
                this.total = shopCustomerGroup.total;
            }
        }

        public Builder customer_type(Integer num) {
            this.customer_type = num;
            return this;
        }

        public Builder customers(List<ShopCustomer> list) {
            this.customers = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public ShopCustomerGroup build() {
            return new ShopCustomerGroup(this);
        }
    }
}
