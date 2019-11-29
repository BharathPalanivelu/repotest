package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.Order;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexOrder extends Message {
    public static final String DEFAULT_CUSTOMER_NAME = "";
    public static final List<Item> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String customer_name;
    @ProtoField(label = Message.Label.REPEATED, messageType = Item.class, tag = 2)
    public final List<Item> items;
    @ProtoField(tag = 1)
    public final Order order;

    public SearchIndexOrder(Order order2, List<Item> list, String str) {
        this.order = order2;
        this.items = immutableCopyOf(list);
        this.customer_name = str;
    }

    private SearchIndexOrder(Builder builder) {
        this(builder.order, builder.items, builder.customer_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexOrder)) {
            return false;
        }
        SearchIndexOrder searchIndexOrder = (SearchIndexOrder) obj;
        if (!equals((Object) this.order, (Object) searchIndexOrder.order) || !equals((List<?>) this.items, (List<?>) searchIndexOrder.items) || !equals((Object) this.customer_name, (Object) searchIndexOrder.customer_name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Order order2 = this.order;
        int i2 = 0;
        int hashCode = (order2 != null ? order2.hashCode() : 0) * 37;
        List<Item> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.customer_name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexOrder> {
        public String customer_name;
        public List<Item> items;
        public Order order;

        public Builder() {
        }

        public Builder(SearchIndexOrder searchIndexOrder) {
            super(searchIndexOrder);
            if (searchIndexOrder != null) {
                this.order = searchIndexOrder.order;
                this.items = SearchIndexOrder.copyOf(searchIndexOrder.items);
                this.customer_name = searchIndexOrder.customer_name;
            }
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder items(List<Item> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder customer_name(String str) {
            this.customer_name = str;
            return this;
        }

        public SearchIndexOrder build() {
            return new SearchIndexOrder(this);
        }
    }
}
