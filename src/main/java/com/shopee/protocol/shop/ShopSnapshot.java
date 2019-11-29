package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShopSnapshot extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final f DEFAULT_SNAPSHOT = f.f32736b;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f snapshot;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long snapshotid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public ShopSnapshot(Long l, Integer num, Integer num2, f fVar, Integer num3) {
        this.snapshotid = l;
        this.shopid = num;
        this.ctime = num2;
        this.snapshot = fVar;
        this.status = num3;
    }

    private ShopSnapshot(Builder builder) {
        this(builder.snapshotid, builder.shopid, builder.ctime, builder.snapshot, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopSnapshot)) {
            return false;
        }
        ShopSnapshot shopSnapshot = (ShopSnapshot) obj;
        if (!equals((Object) this.snapshotid, (Object) shopSnapshot.snapshotid) || !equals((Object) this.shopid, (Object) shopSnapshot.shopid) || !equals((Object) this.ctime, (Object) shopSnapshot.ctime) || !equals((Object) this.snapshot, (Object) shopSnapshot.snapshot) || !equals((Object) this.status, (Object) shopSnapshot.status)) {
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
        Integer num2 = this.ctime;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.snapshot;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopSnapshot> {
        public Integer ctime;
        public Integer shopid;
        public f snapshot;
        public Long snapshotid;
        public Integer status;

        public Builder() {
        }

        public Builder(ShopSnapshot shopSnapshot) {
            super(shopSnapshot);
            if (shopSnapshot != null) {
                this.snapshotid = shopSnapshot.snapshotid;
                this.shopid = shopSnapshot.shopid;
                this.ctime = shopSnapshot.ctime;
                this.snapshot = shopSnapshot.snapshot;
                this.status = shopSnapshot.status;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder snapshot(f fVar) {
            this.snapshot = fVar;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public ShopSnapshot build() {
            return new ShopSnapshot(this);
        }
    }
}
