package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ChatOrderInfo extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_CURRENCY = "";
    public static final Boolean DEFAULT_HAS_REQUEST_REFUND = false;
    public static final List<String> DEFAULT_ITEM_IMAGE = Collections.emptyList();
    public static final Integer DEFAULT_LIST_TYPE = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDERSN = "";
    public static final String DEFAULT_ORDER_STATUS = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_TOTAL_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean has_request_refund;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.STRING)
    public final List<String> item_image;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer list_type;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String order_status;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String ordersn;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long total_price;

    public ChatOrderInfo(Integer num, Long l, Long l2, String str, Long l3, String str2, String str3, List<String> list, Integer num2, Boolean bool) {
        this.shopid = num;
        this.orderid = l;
        this.checkoutid = l2;
        this.ordersn = str;
        this.total_price = l3;
        this.currency = str2;
        this.order_status = str3;
        this.item_image = immutableCopyOf(list);
        this.list_type = num2;
        this.has_request_refund = bool;
    }

    private ChatOrderInfo(Builder builder) {
        this(builder.shopid, builder.orderid, builder.checkoutid, builder.ordersn, builder.total_price, builder.currency, builder.order_status, builder.item_image, builder.list_type, builder.has_request_refund);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatOrderInfo)) {
            return false;
        }
        ChatOrderInfo chatOrderInfo = (ChatOrderInfo) obj;
        if (!equals((Object) this.shopid, (Object) chatOrderInfo.shopid) || !equals((Object) this.orderid, (Object) chatOrderInfo.orderid) || !equals((Object) this.checkoutid, (Object) chatOrderInfo.checkoutid) || !equals((Object) this.ordersn, (Object) chatOrderInfo.ordersn) || !equals((Object) this.total_price, (Object) chatOrderInfo.total_price) || !equals((Object) this.currency, (Object) chatOrderInfo.currency) || !equals((Object) this.order_status, (Object) chatOrderInfo.order_status) || !equals((List<?>) this.item_image, (List<?>) chatOrderInfo.item_image) || !equals((Object) this.list_type, (Object) chatOrderInfo.list_type) || !equals((Object) this.has_request_refund, (Object) chatOrderInfo.has_request_refund)) {
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
        Long l2 = this.checkoutid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.ordersn;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.total_price;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.currency;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.order_status;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<String> list = this.item_image;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.list_type;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.has_request_refund;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatOrderInfo> {
        public Long checkoutid;
        public String currency;
        public Boolean has_request_refund;
        public List<String> item_image;
        public Integer list_type;
        public String order_status;
        public Long orderid;
        public String ordersn;
        public Integer shopid;
        public Long total_price;

        public Builder() {
        }

        public Builder(ChatOrderInfo chatOrderInfo) {
            super(chatOrderInfo);
            if (chatOrderInfo != null) {
                this.shopid = chatOrderInfo.shopid;
                this.orderid = chatOrderInfo.orderid;
                this.checkoutid = chatOrderInfo.checkoutid;
                this.ordersn = chatOrderInfo.ordersn;
                this.total_price = chatOrderInfo.total_price;
                this.currency = chatOrderInfo.currency;
                this.order_status = chatOrderInfo.order_status;
                this.item_image = ChatOrderInfo.copyOf(chatOrderInfo.item_image);
                this.list_type = chatOrderInfo.list_type;
                this.has_request_refund = chatOrderInfo.has_request_refund;
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

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder ordersn(String str) {
            this.ordersn = str;
            return this;
        }

        public Builder total_price(Long l) {
            this.total_price = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder order_status(String str) {
            this.order_status = str;
            return this;
        }

        public Builder item_image(List<String> list) {
            this.item_image = checkForNulls(list);
            return this;
        }

        public Builder list_type(Integer num) {
            this.list_type = num;
            return this;
        }

        public Builder has_request_refund(Boolean bool) {
            this.has_request_refund = bool;
            return this;
        }

        public ChatOrderInfo build() {
            return new ChatOrderInfo(this);
        }
    }
}
