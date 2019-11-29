package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckoutOrder extends Message {
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_DAYS_TO_PAY = 0;
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDERSN = "";
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer days_to_pay;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String ordersn;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public CheckoutOrder(Integer num, Long l, Integer num2, List<String> list, Integer num3, Long l2, String str, Integer num4, String str2) {
        this.shopid = num;
        this.orderid = l;
        this.item_count = num2;
        this.images = immutableCopyOf(list);
        this.status = num3;
        this.price = l2;
        this.currency = str;
        this.days_to_pay = num4;
        this.ordersn = str2;
    }

    private CheckoutOrder(Builder builder) {
        this(builder.shopid, builder.orderid, builder.item_count, builder.images, builder.status, builder.price, builder.currency, builder.days_to_pay, builder.ordersn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutOrder)) {
            return false;
        }
        CheckoutOrder checkoutOrder = (CheckoutOrder) obj;
        if (!equals((Object) this.shopid, (Object) checkoutOrder.shopid) || !equals((Object) this.orderid, (Object) checkoutOrder.orderid) || !equals((Object) this.item_count, (Object) checkoutOrder.item_count) || !equals((List<?>) this.images, (List<?>) checkoutOrder.images) || !equals((Object) this.status, (Object) checkoutOrder.status) || !equals((Object) this.price, (Object) checkoutOrder.price) || !equals((Object) this.currency, (Object) checkoutOrder.currency) || !equals((Object) this.days_to_pay, (Object) checkoutOrder.days_to_pay) || !equals((Object) this.ordersn, (Object) checkoutOrder.ordersn)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.item_count;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<String> list = this.images;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num3 = this.status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.price;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.days_to_pay;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.ordersn;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutOrder> {
        public String currency;
        public Integer days_to_pay;
        public List<String> images;
        public Integer item_count;
        public Long orderid;
        public String ordersn;
        public Long price;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(CheckoutOrder checkoutOrder) {
            super(checkoutOrder);
            if (checkoutOrder != null) {
                this.shopid = checkoutOrder.shopid;
                this.orderid = checkoutOrder.orderid;
                this.item_count = checkoutOrder.item_count;
                this.images = CheckoutOrder.copyOf(checkoutOrder.images);
                this.status = checkoutOrder.status;
                this.price = checkoutOrder.price;
                this.currency = checkoutOrder.currency;
                this.days_to_pay = checkoutOrder.days_to_pay;
                this.ordersn = checkoutOrder.ordersn;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder days_to_pay(Integer num) {
            this.days_to_pay = num;
            return this;
        }

        public Builder ordersn(String str) {
            this.ordersn = str;
            return this;
        }

        public CheckoutOrder build() {
            return new CheckoutOrder(this);
        }
    }
}
