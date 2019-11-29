package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.OrderItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OrderWithItems extends Message {
    public static final List<Integer> DEFAULT_CARRIER_ID = Collections.emptyList();
    public static final List<OrderItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_SELLER_TXN_FEE_RULE_ID = 0;
    public static final String DEFAULT_TAX_ADDRESS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> carrier_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItem.class, tag = 2)
    public final List<OrderItem> items;
    @ProtoField(tag = 6)
    public final JkoSellerInfo jko_seller_info;
    @ProtoField(tag = 1)
    public final Order order;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer seller_txn_fee_rule_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String tax_address;

    public OrderWithItems(Order order2, List<OrderItem> list, List<Integer> list2, String str, Integer num, JkoSellerInfo jkoSellerInfo) {
        this.order = order2;
        this.items = immutableCopyOf(list);
        this.carrier_id = immutableCopyOf(list2);
        this.tax_address = str;
        this.seller_txn_fee_rule_id = num;
        this.jko_seller_info = jkoSellerInfo;
    }

    private OrderWithItems(Builder builder) {
        this(builder.order, builder.items, builder.carrier_id, builder.tax_address, builder.seller_txn_fee_rule_id, builder.jko_seller_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderWithItems)) {
            return false;
        }
        OrderWithItems orderWithItems = (OrderWithItems) obj;
        if (!equals((Object) this.order, (Object) orderWithItems.order) || !equals((List<?>) this.items, (List<?>) orderWithItems.items) || !equals((List<?>) this.carrier_id, (List<?>) orderWithItems.carrier_id) || !equals((Object) this.tax_address, (Object) orderWithItems.tax_address) || !equals((Object) this.seller_txn_fee_rule_id, (Object) orderWithItems.seller_txn_fee_rule_id) || !equals((Object) this.jko_seller_info, (Object) orderWithItems.jko_seller_info)) {
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
        List<OrderItem> list = this.items;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.carrier_id;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 37;
        String str = this.tax_address;
        int hashCode3 = (i4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.seller_txn_fee_rule_id;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        JkoSellerInfo jkoSellerInfo = this.jko_seller_info;
        if (jkoSellerInfo != null) {
            i2 = jkoSellerInfo.hashCode();
        }
        int i5 = hashCode4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<OrderWithItems> {
        public List<Integer> carrier_id;
        public List<OrderItem> items;
        public JkoSellerInfo jko_seller_info;
        public Order order;
        public Integer seller_txn_fee_rule_id;
        public String tax_address;

        public Builder() {
        }

        public Builder(OrderWithItems orderWithItems) {
            super(orderWithItems);
            if (orderWithItems != null) {
                this.order = orderWithItems.order;
                this.items = OrderWithItems.copyOf(orderWithItems.items);
                this.carrier_id = OrderWithItems.copyOf(orderWithItems.carrier_id);
                this.tax_address = orderWithItems.tax_address;
                this.seller_txn_fee_rule_id = orderWithItems.seller_txn_fee_rule_id;
                this.jko_seller_info = orderWithItems.jko_seller_info;
            }
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder items(List<OrderItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder carrier_id(List<Integer> list) {
            this.carrier_id = checkForNulls(list);
            return this;
        }

        public Builder tax_address(String str) {
            this.tax_address = str;
            return this;
        }

        public Builder seller_txn_fee_rule_id(Integer num) {
            this.seller_txn_fee_rule_id = num;
            return this;
        }

        public Builder jko_seller_info(JkoSellerInfo jkoSellerInfo) {
            this.jko_seller_info = jkoSellerInfo;
            return this;
        }

        public OrderWithItems build() {
            return new OrderWithItems(this);
        }
    }
}
