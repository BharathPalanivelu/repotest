package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StockChangeTask extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    public static final Integer DEFAULT_STOCK_AMOUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long snapshotid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer stock_amount;

    public StockChangeTask(Long l, Long l2, Long l3, Long l4, Long l5, Integer num, Integer num2, Integer num3) {
        this.id = l;
        this.orderid = l2;
        this.itemid = l3;
        this.modelid = l4;
        this.snapshotid = l5;
        this.shopid = num;
        this.stock_amount = num2;
        this.ctime = num3;
    }

    private StockChangeTask(Builder builder) {
        this(builder.id, builder.orderid, builder.itemid, builder.modelid, builder.snapshotid, builder.shopid, builder.stock_amount, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StockChangeTask)) {
            return false;
        }
        StockChangeTask stockChangeTask = (StockChangeTask) obj;
        if (!equals((Object) this.id, (Object) stockChangeTask.id) || !equals((Object) this.orderid, (Object) stockChangeTask.orderid) || !equals((Object) this.itemid, (Object) stockChangeTask.itemid) || !equals((Object) this.modelid, (Object) stockChangeTask.modelid) || !equals((Object) this.snapshotid, (Object) stockChangeTask.snapshotid) || !equals((Object) this.shopid, (Object) stockChangeTask.shopid) || !equals((Object) this.stock_amount, (Object) stockChangeTask.stock_amount) || !equals((Object) this.ctime, (Object) stockChangeTask.ctime)) {
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
        Long l2 = this.orderid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.itemid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.modelid;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.snapshotid;
        int hashCode5 = (hashCode4 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.stock_amount;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StockChangeTask> {
        public Integer ctime;
        public Long id;
        public Long itemid;
        public Long modelid;
        public Long orderid;
        public Integer shopid;
        public Long snapshotid;
        public Integer stock_amount;

        public Builder() {
        }

        public Builder(StockChangeTask stockChangeTask) {
            super(stockChangeTask);
            if (stockChangeTask != null) {
                this.id = stockChangeTask.id;
                this.orderid = stockChangeTask.orderid;
                this.itemid = stockChangeTask.itemid;
                this.modelid = stockChangeTask.modelid;
                this.snapshotid = stockChangeTask.snapshotid;
                this.shopid = stockChangeTask.shopid;
                this.stock_amount = stockChangeTask.stock_amount;
                this.ctime = stockChangeTask.ctime;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder stock_amount(Integer num) {
            this.stock_amount = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public StockChangeTask build() {
            return new StockChangeTask(this);
        }
    }
}
