package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class IdInfo extends Message {
    public static final Integer DEFAULT_BUYER_ID = 0;
    public static final Long DEFAULT_CHECKOUT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_REFUND_ID = 0L;
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_TASKID = 0;
    public static final Long DEFAULT_TRANSACTION_ID = 0L;
    public static final Long DEFAULT_WITHDRAWAL_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer buyer_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long checkout_id;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long refund_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer taskid;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long transaction_id;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long withdrawal_id;

    public IdInfo(Long l, Long l2, Long l3, Long l4, Integer num, Long l5, Integer num2, Integer num3, Long l6, Long l7) {
        this.orderid = l;
        this.checkout_id = l2;
        this.refund_id = l3;
        this.return_id = l4;
        this.shopid = num;
        this.itemid = l5;
        this.buyer_id = num2;
        this.taskid = num3;
        this.withdrawal_id = l6;
        this.transaction_id = l7;
    }

    private IdInfo(Builder builder) {
        this(builder.orderid, builder.checkout_id, builder.refund_id, builder.return_id, builder.shopid, builder.itemid, builder.buyer_id, builder.taskid, builder.withdrawal_id, builder.transaction_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IdInfo)) {
            return false;
        }
        IdInfo idInfo = (IdInfo) obj;
        if (!equals((Object) this.orderid, (Object) idInfo.orderid) || !equals((Object) this.checkout_id, (Object) idInfo.checkout_id) || !equals((Object) this.refund_id, (Object) idInfo.refund_id) || !equals((Object) this.return_id, (Object) idInfo.return_id) || !equals((Object) this.shopid, (Object) idInfo.shopid) || !equals((Object) this.itemid, (Object) idInfo.itemid) || !equals((Object) this.buyer_id, (Object) idInfo.buyer_id) || !equals((Object) this.taskid, (Object) idInfo.taskid) || !equals((Object) this.withdrawal_id, (Object) idInfo.withdrawal_id) || !equals((Object) this.transaction_id, (Object) idInfo.transaction_id)) {
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
        Long l2 = this.checkout_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.refund_id;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.return_id;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Long l5 = this.itemid;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num2 = this.buyer_id;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.taskid;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l6 = this.withdrawal_id;
        int hashCode9 = (hashCode8 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.transaction_id;
        if (l7 != null) {
            i2 = l7.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<IdInfo> {
        public Integer buyer_id;
        public Long checkout_id;
        public Long itemid;
        public Long orderid;
        public Long refund_id;
        public Long return_id;
        public Integer shopid;
        public Integer taskid;
        public Long transaction_id;
        public Long withdrawal_id;

        public Builder() {
        }

        public Builder(IdInfo idInfo) {
            super(idInfo);
            if (idInfo != null) {
                this.orderid = idInfo.orderid;
                this.checkout_id = idInfo.checkout_id;
                this.refund_id = idInfo.refund_id;
                this.return_id = idInfo.return_id;
                this.shopid = idInfo.shopid;
                this.itemid = idInfo.itemid;
                this.buyer_id = idInfo.buyer_id;
                this.taskid = idInfo.taskid;
                this.withdrawal_id = idInfo.withdrawal_id;
                this.transaction_id = idInfo.transaction_id;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder checkout_id(Long l) {
            this.checkout_id = l;
            return this;
        }

        public Builder refund_id(Long l) {
            this.refund_id = l;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder buyer_id(Integer num) {
            this.buyer_id = num;
            return this;
        }

        public Builder taskid(Integer num) {
            this.taskid = num;
            return this;
        }

        public Builder withdrawal_id(Long l) {
            this.withdrawal_id = l;
            return this;
        }

        public Builder transaction_id(Long l) {
            this.transaction_id = l;
            return this;
        }

        public IdInfo build() {
            return new IdInfo(this);
        }
    }
}
