package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemCIR extends Message {
    public static final Double DEFAULT_CIR = Double.valueOf(0.0d);
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double cir;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer status;

    public ItemCIR(Long l, Integer num, Long l2, Long l3, Double d2) {
        this.itemid = l;
        this.status = num;
        this.ctime = l2;
        this.mtime = l3;
        this.cir = d2;
    }

    private ItemCIR(Builder builder) {
        this(builder.itemid, builder.status, builder.ctime, builder.mtime, builder.cir);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemCIR)) {
            return false;
        }
        ItemCIR itemCIR = (ItemCIR) obj;
        if (!equals((Object) this.itemid, (Object) itemCIR.itemid) || !equals((Object) this.status, (Object) itemCIR.status) || !equals((Object) this.ctime, (Object) itemCIR.ctime) || !equals((Object) this.mtime, (Object) itemCIR.mtime) || !equals((Object) this.cir, (Object) itemCIR.cir)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Double d2 = this.cir;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemCIR> {
        public Double cir;
        public Long ctime;
        public Long itemid;
        public Long mtime;
        public Integer status;

        public Builder() {
        }

        public Builder(ItemCIR itemCIR) {
            super(itemCIR);
            if (itemCIR != null) {
                this.itemid = itemCIR.itemid;
                this.status = itemCIR.status;
                this.ctime = itemCIR.ctime;
                this.mtime = itemCIR.mtime;
                this.cir = itemCIR.cir;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder cir(Double d2) {
            this.cir = d2;
            return this;
        }

        public ItemCIR build() {
            return new ItemCIR(this);
        }
    }
}
