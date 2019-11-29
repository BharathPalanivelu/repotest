package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ItemSnapshot extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final f DEFAULT_SNAPSHOT = f.f32736b;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f snapshot;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long snapshotid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public ItemSnapshot(Long l, Integer num, Long l2, Integer num2, Integer num3, f fVar) {
        this.snapshotid = l;
        this.shopid = num;
        this.itemid = l2;
        this.status = num2;
        this.ctime = num3;
        this.snapshot = fVar;
    }

    private ItemSnapshot(Builder builder) {
        this(builder.snapshotid, builder.shopid, builder.itemid, builder.status, builder.ctime, builder.snapshot);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemSnapshot)) {
            return false;
        }
        ItemSnapshot itemSnapshot = (ItemSnapshot) obj;
        if (!equals((Object) this.snapshotid, (Object) itemSnapshot.snapshotid) || !equals((Object) this.shopid, (Object) itemSnapshot.shopid) || !equals((Object) this.itemid, (Object) itemSnapshot.itemid) || !equals((Object) this.status, (Object) itemSnapshot.status) || !equals((Object) this.ctime, (Object) itemSnapshot.ctime) || !equals((Object) this.snapshot, (Object) itemSnapshot.snapshot)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.snapshotid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar = this.snapshot;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemSnapshot> {
        public Integer ctime;
        public Long itemid;
        public Integer shopid;
        public f snapshot;
        public Long snapshotid;
        public Integer status;

        public Builder() {
        }

        public Builder(ItemSnapshot itemSnapshot) {
            super(itemSnapshot);
            if (itemSnapshot != null) {
                this.snapshotid = itemSnapshot.snapshotid;
                this.shopid = itemSnapshot.shopid;
                this.itemid = itemSnapshot.itemid;
                this.status = itemSnapshot.status;
                this.ctime = itemSnapshot.ctime;
                this.snapshot = itemSnapshot.snapshot;
            }
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder snapshot(f fVar) {
            this.snapshot = fVar;
            return this;
        }

        public ItemSnapshot build() {
            return new ItemSnapshot(this);
        }
    }
}
