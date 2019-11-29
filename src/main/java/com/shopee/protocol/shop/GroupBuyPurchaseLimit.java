package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GroupBuyPurchaseLimit extends Message {
    public static final Integer DEFAULT_AMOUNT = 0;
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_ORDER_STATUS = 0;
    public static final Integer DEFAULT_PAYMENT_END_TIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer order_status;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer payment_end_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public GroupBuyPurchaseLimit(Long l, Long l2, Long l3, Integer num, Long l4, Integer num2, Integer num3, Integer num4) {
        this.orderid = l;
        this.campaignid = l2;
        this.groupid = l3;
        this.userid = num;
        this.itemid = l4;
        this.amount = num2;
        this.order_status = num3;
        this.payment_end_time = num4;
    }

    private GroupBuyPurchaseLimit(Builder builder) {
        this(builder.orderid, builder.campaignid, builder.groupid, builder.userid, builder.itemid, builder.amount, builder.order_status, builder.payment_end_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyPurchaseLimit)) {
            return false;
        }
        GroupBuyPurchaseLimit groupBuyPurchaseLimit = (GroupBuyPurchaseLimit) obj;
        if (!equals((Object) this.orderid, (Object) groupBuyPurchaseLimit.orderid) || !equals((Object) this.campaignid, (Object) groupBuyPurchaseLimit.campaignid) || !equals((Object) this.groupid, (Object) groupBuyPurchaseLimit.groupid) || !equals((Object) this.userid, (Object) groupBuyPurchaseLimit.userid) || !equals((Object) this.itemid, (Object) groupBuyPurchaseLimit.itemid) || !equals((Object) this.amount, (Object) groupBuyPurchaseLimit.amount) || !equals((Object) this.order_status, (Object) groupBuyPurchaseLimit.order_status) || !equals((Object) this.payment_end_time, (Object) groupBuyPurchaseLimit.payment_end_time)) {
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
        Long l2 = this.campaignid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.groupid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l4 = this.itemid;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.amount;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.order_status;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.payment_end_time;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupBuyPurchaseLimit> {
        public Integer amount;
        public Long campaignid;
        public Long groupid;
        public Long itemid;
        public Integer order_status;
        public Long orderid;
        public Integer payment_end_time;
        public Integer userid;

        public Builder() {
        }

        public Builder(GroupBuyPurchaseLimit groupBuyPurchaseLimit) {
            super(groupBuyPurchaseLimit);
            if (groupBuyPurchaseLimit != null) {
                this.orderid = groupBuyPurchaseLimit.orderid;
                this.campaignid = groupBuyPurchaseLimit.campaignid;
                this.groupid = groupBuyPurchaseLimit.groupid;
                this.userid = groupBuyPurchaseLimit.userid;
                this.itemid = groupBuyPurchaseLimit.itemid;
                this.amount = groupBuyPurchaseLimit.amount;
                this.order_status = groupBuyPurchaseLimit.order_status;
                this.payment_end_time = groupBuyPurchaseLimit.payment_end_time;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder amount(Integer num) {
            this.amount = num;
            return this;
        }

        public Builder order_status(Integer num) {
            this.order_status = num;
            return this;
        }

        public Builder payment_end_time(Integer num) {
            this.payment_end_time = num;
            return this;
        }

        public GroupBuyPurchaseLimit build() {
            return new GroupBuyPurchaseLimit(this);
        }
    }
}
