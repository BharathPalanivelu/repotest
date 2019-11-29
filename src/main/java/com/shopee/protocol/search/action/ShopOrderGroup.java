package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopOrderGroup extends Message {
    public static final Integer DEFAULT_CUSTOMER_TYPE = 0;
    public static final List<ShopOrder> DEFAULT_SHOPORDERS = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer customer_type;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopOrder.class, tag = 2)
    public final List<ShopOrder> shoporders;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total;

    public ShopOrderGroup(Integer num, List<ShopOrder> list, Integer num2) {
        this.customer_type = num;
        this.shoporders = immutableCopyOf(list);
        this.total = num2;
    }

    private ShopOrderGroup(Builder builder) {
        this(builder.customer_type, builder.shoporders, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopOrderGroup)) {
            return false;
        }
        ShopOrderGroup shopOrderGroup = (ShopOrderGroup) obj;
        if (!equals((Object) this.customer_type, (Object) shopOrderGroup.customer_type) || !equals((List<?>) this.shoporders, (List<?>) shopOrderGroup.shoporders) || !equals((Object) this.total, (Object) shopOrderGroup.total)) {
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
        List<ShopOrder> list = this.shoporders;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopOrderGroup> {
        public Integer customer_type;
        public List<ShopOrder> shoporders;
        public Integer total;

        public Builder() {
        }

        public Builder(ShopOrderGroup shopOrderGroup) {
            super(shopOrderGroup);
            if (shopOrderGroup != null) {
                this.customer_type = shopOrderGroup.customer_type;
                this.shoporders = ShopOrderGroup.copyOf(shopOrderGroup.shoporders);
                this.total = shopOrderGroup.total;
            }
        }

        public Builder customer_type(Integer num) {
            this.customer_type = num;
            return this;
        }

        public Builder shoporders(List<ShopOrder> list) {
            this.shoporders = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public ShopOrderGroup build() {
            return new ShopOrderGroup(this);
        }
    }
}
