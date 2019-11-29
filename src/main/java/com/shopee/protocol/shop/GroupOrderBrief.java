package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GroupOrderBrief extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_ORDER_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer order_status;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public GroupOrderBrief(Integer num, Long l, Integer num2) {
        this.userid = num;
        this.orderid = l;
        this.order_status = num2;
    }

    private GroupOrderBrief(Builder builder) {
        this(builder.userid, builder.orderid, builder.order_status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupOrderBrief)) {
            return false;
        }
        GroupOrderBrief groupOrderBrief = (GroupOrderBrief) obj;
        if (!equals((Object) this.userid, (Object) groupOrderBrief.userid) || !equals((Object) this.orderid, (Object) groupOrderBrief.orderid) || !equals((Object) this.order_status, (Object) groupOrderBrief.order_status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.order_status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupOrderBrief> {
        public Integer order_status;
        public Long orderid;
        public Integer userid;

        public Builder() {
        }

        public Builder(GroupOrderBrief groupOrderBrief) {
            super(groupOrderBrief);
            if (groupOrderBrief != null) {
                this.userid = groupOrderBrief.userid;
                this.orderid = groupOrderBrief.orderid;
                this.order_status = groupOrderBrief.order_status;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder order_status(Integer num) {
            this.order_status = num;
            return this;
        }

        public GroupOrderBrief build() {
            return new GroupOrderBrief(this);
        }
    }
}
