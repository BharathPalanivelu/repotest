package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CollectionItemId extends Message {
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public CollectionItemId(Integer num, Integer num2, Long l) {
        this.collection_id = num;
        this.shopid = num2;
        this.itemid = l;
    }

    private CollectionItemId(Builder builder) {
        this(builder.collection_id, builder.shopid, builder.itemid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionItemId)) {
            return false;
        }
        CollectionItemId collectionItemId = (CollectionItemId) obj;
        if (!equals((Object) this.collection_id, (Object) collectionItemId.collection_id) || !equals((Object) this.shopid, (Object) collectionItemId.shopid) || !equals((Object) this.itemid, (Object) collectionItemId.itemid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.collection_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CollectionItemId> {
        public Integer collection_id;
        public Long itemid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(CollectionItemId collectionItemId) {
            super(collectionItemId);
            if (collectionItemId != null) {
                this.collection_id = collectionItemId.collection_id;
                this.shopid = collectionItemId.shopid;
                this.itemid = collectionItemId.itemid;
            }
        }

        public Builder collection_id(Integer num) {
            this.collection_id = num;
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

        public CollectionItemId build() {
            return new CollectionItemId(this);
        }
    }
}
