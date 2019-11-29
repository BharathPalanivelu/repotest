package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderCntUpdateTask extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_NEW_VAL = 0;
    public static final Long DEFAULT_OBJECT_ID = 0L;
    public static final Integer DEFAULT_OLD_VAL = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_val;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long object_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer old_val;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public OrderCntUpdateTask(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l2) {
        this.id = l;
        this.userid = num;
        this.shopid = num2;
        this.type = num3;
        this.old_val = num4;
        this.new_val = num5;
        this.ctime = num6;
        this.object_id = l2;
    }

    private OrderCntUpdateTask(Builder builder) {
        this(builder.id, builder.userid, builder.shopid, builder.type, builder.old_val, builder.new_val, builder.ctime, builder.object_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderCntUpdateTask)) {
            return false;
        }
        OrderCntUpdateTask orderCntUpdateTask = (OrderCntUpdateTask) obj;
        if (!equals((Object) this.id, (Object) orderCntUpdateTask.id) || !equals((Object) this.userid, (Object) orderCntUpdateTask.userid) || !equals((Object) this.shopid, (Object) orderCntUpdateTask.shopid) || !equals((Object) this.type, (Object) orderCntUpdateTask.type) || !equals((Object) this.old_val, (Object) orderCntUpdateTask.old_val) || !equals((Object) this.new_val, (Object) orderCntUpdateTask.new_val) || !equals((Object) this.ctime, (Object) orderCntUpdateTask.ctime) || !equals((Object) this.object_id, (Object) orderCntUpdateTask.object_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.type;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.old_val;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.new_val;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.object_id;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderCntUpdateTask> {
        public Integer ctime;
        public Long id;
        public Integer new_val;
        public Long object_id;
        public Integer old_val;
        public Integer shopid;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(OrderCntUpdateTask orderCntUpdateTask) {
            super(orderCntUpdateTask);
            if (orderCntUpdateTask != null) {
                this.id = orderCntUpdateTask.id;
                this.userid = orderCntUpdateTask.userid;
                this.shopid = orderCntUpdateTask.shopid;
                this.type = orderCntUpdateTask.type;
                this.old_val = orderCntUpdateTask.old_val;
                this.new_val = orderCntUpdateTask.new_val;
                this.ctime = orderCntUpdateTask.ctime;
                this.object_id = orderCntUpdateTask.object_id;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder old_val(Integer num) {
            this.old_val = num;
            return this;
        }

        public Builder new_val(Integer num) {
            this.new_val = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder object_id(Long l) {
            this.object_id = l;
            return this;
        }

        public OrderCntUpdateTask build() {
            return new OrderCntUpdateTask(this);
        }
    }
}
