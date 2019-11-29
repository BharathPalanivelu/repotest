package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemModelId extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long snapshotid;

    public ItemModelId(Long l, Long l2, Long l3) {
        this.itemid = l;
        this.modelid = l2;
        this.snapshotid = l3;
    }

    private ItemModelId(Builder builder) {
        this(builder.itemid, builder.modelid, builder.snapshotid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemModelId)) {
            return false;
        }
        ItemModelId itemModelId = (ItemModelId) obj;
        if (!equals((Object) this.itemid, (Object) itemModelId.itemid) || !equals((Object) this.modelid, (Object) itemModelId.modelid) || !equals((Object) this.snapshotid, (Object) itemModelId.snapshotid)) {
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
        Long l2 = this.modelid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.snapshotid;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemModelId> {
        public Long itemid;
        public Long modelid;
        public Long snapshotid;

        public Builder() {
        }

        public Builder(ItemModelId itemModelId) {
            super(itemModelId);
            if (itemModelId != null) {
                this.itemid = itemModelId.itemid;
                this.modelid = itemModelId.modelid;
                this.snapshotid = itemModelId.snapshotid;
            }
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

        public ItemModelId build() {
            return new ItemModelId(this);
        }
    }
}
