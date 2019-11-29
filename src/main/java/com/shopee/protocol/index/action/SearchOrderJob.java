package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.Order;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class SearchOrderJob extends Message {
    public static final String DEFAULT_CUSTOMER_NAME = "";
    public static final List<Item> DEFAULT_ITEMS = Collections.emptyList();
    public static final Long DEFAULT_ORDERID = 0L;
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String customer_name;
    @ProtoField(label = Message.Label.REPEATED, messageType = Item.class, tag = 7)
    public final List<Item> items;
    @ProtoField(tag = 5)
    public final Order order;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public SearchOrderJob(Integer num, Long l, Integer num2, Integer num3, Order order2, String str, List<Item> list, String str2, f fVar) {
        this.type = num;
        this.orderid = l;
        this.shopid = num2;
        this.userid = num3;
        this.order = order2;
        this.source = str;
        this.items = immutableCopyOf(list);
        this.customer_name = str2;
        this.raw_ctx = fVar;
    }

    private SearchOrderJob(Builder builder) {
        this(builder.type, builder.orderid, builder.shopid, builder.userid, builder.order, builder.source, builder.items, builder.customer_name, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrderJob)) {
            return false;
        }
        SearchOrderJob searchOrderJob = (SearchOrderJob) obj;
        if (!equals((Object) this.type, (Object) searchOrderJob.type) || !equals((Object) this.orderid, (Object) searchOrderJob.orderid) || !equals((Object) this.shopid, (Object) searchOrderJob.shopid) || !equals((Object) this.userid, (Object) searchOrderJob.userid) || !equals((Object) this.order, (Object) searchOrderJob.order) || !equals((Object) this.source, (Object) searchOrderJob.source) || !equals((List<?>) this.items, (List<?>) searchOrderJob.items) || !equals((Object) this.customer_name, (Object) searchOrderJob.customer_name) || !equals((Object) this.raw_ctx, (Object) searchOrderJob.raw_ctx)) {
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
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Order order2 = this.order;
        int hashCode5 = (hashCode4 + (order2 != null ? order2.hashCode() : 0)) * 37;
        String str = this.source;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        List<Item> list = this.items;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.customer_name;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchOrderJob> {
        public String customer_name;
        public List<Item> items;
        public Order order;
        public Long orderid;
        public f raw_ctx;
        public Integer shopid;
        public String source;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(SearchOrderJob searchOrderJob) {
            super(searchOrderJob);
            if (searchOrderJob != null) {
                this.type = searchOrderJob.type;
                this.orderid = searchOrderJob.orderid;
                this.shopid = searchOrderJob.shopid;
                this.userid = searchOrderJob.userid;
                this.order = searchOrderJob.order;
                this.source = searchOrderJob.source;
                this.items = SearchOrderJob.copyOf(searchOrderJob.items);
                this.customer_name = searchOrderJob.customer_name;
                this.raw_ctx = searchOrderJob.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
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

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public SearchOrderJob build() {
            return new SearchOrderJob(this);
        }
    }
}
