package com.shopee.protocol.action;

import com.shopee.protocol.shop.TransHisExtInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderInfo extends Message {
    public static final Boolean DEFAULT_IS_GROUP_BUY_ONGOING = false;
    public static final Integer DEFAULT_LIST_TYPE = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_RELEASE_TIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SUB_LIST_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy_ongoing;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer list_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer release_time;
    @ProtoField(tag = 5)
    public final TransHisExtInfo release_time_range;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer sub_list_type;

    public OrderInfo(Long l, Integer num, Integer num2, Integer num3, TransHisExtInfo transHisExtInfo, Integer num4, Boolean bool) {
        this.orderid = l;
        this.shopid = num;
        this.list_type = num2;
        this.release_time = num3;
        this.release_time_range = transHisExtInfo;
        this.sub_list_type = num4;
        this.is_group_buy_ongoing = bool;
    }

    private OrderInfo(Builder builder) {
        this(builder.orderid, builder.shopid, builder.list_type, builder.release_time, builder.release_time_range, builder.sub_list_type, builder.is_group_buy_ongoing);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderInfo)) {
            return false;
        }
        OrderInfo orderInfo = (OrderInfo) obj;
        if (!equals((Object) this.orderid, (Object) orderInfo.orderid) || !equals((Object) this.shopid, (Object) orderInfo.shopid) || !equals((Object) this.list_type, (Object) orderInfo.list_type) || !equals((Object) this.release_time, (Object) orderInfo.release_time) || !equals((Object) this.release_time_range, (Object) orderInfo.release_time_range) || !equals((Object) this.sub_list_type, (Object) orderInfo.sub_list_type) || !equals((Object) this.is_group_buy_ongoing, (Object) orderInfo.is_group_buy_ongoing)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.list_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.release_time;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        TransHisExtInfo transHisExtInfo = this.release_time_range;
        int hashCode5 = (hashCode4 + (transHisExtInfo != null ? transHisExtInfo.hashCode() : 0)) * 37;
        Integer num4 = this.sub_list_type;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.is_group_buy_ongoing;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderInfo> {
        public Boolean is_group_buy_ongoing;
        public Integer list_type;
        public Long orderid;
        public Integer release_time;
        public TransHisExtInfo release_time_range;
        public Integer shopid;
        public Integer sub_list_type;

        public Builder() {
        }

        public Builder(OrderInfo orderInfo) {
            super(orderInfo);
            if (orderInfo != null) {
                this.orderid = orderInfo.orderid;
                this.shopid = orderInfo.shopid;
                this.list_type = orderInfo.list_type;
                this.release_time = orderInfo.release_time;
                this.release_time_range = orderInfo.release_time_range;
                this.sub_list_type = orderInfo.sub_list_type;
                this.is_group_buy_ongoing = orderInfo.is_group_buy_ongoing;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder list_type(Integer num) {
            this.list_type = num;
            return this;
        }

        public Builder release_time(Integer num) {
            this.release_time = num;
            return this;
        }

        public Builder release_time_range(TransHisExtInfo transHisExtInfo) {
            this.release_time_range = transHisExtInfo;
            return this;
        }

        public Builder sub_list_type(Integer num) {
            this.sub_list_type = num;
            return this;
        }

        public Builder is_group_buy_ongoing(Boolean bool) {
            this.is_group_buy_ongoing = bool;
            return this;
        }

        public OrderInfo build() {
            return new OrderInfo(this);
        }
    }
}
