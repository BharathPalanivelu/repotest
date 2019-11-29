package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SpuProductionItem extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SPUID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long spuid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;

    public SpuProductionItem(Long l, Long l2, Long l3, Long l4, Integer num, Integer num2, Integer num3, Integer num4, f fVar) {
        this.id = l;
        this.modelid = l2;
        this.itemid = l3;
        this.spuid = l4;
        this.shopid = num;
        this.ctime = num2;
        this.mtime = num3;
        this.status = num4;
        this.extinfo = fVar;
    }

    private SpuProductionItem(Builder builder) {
        this(builder.id, builder.modelid, builder.itemid, builder.spuid, builder.shopid, builder.ctime, builder.mtime, builder.status, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpuProductionItem)) {
            return false;
        }
        SpuProductionItem spuProductionItem = (SpuProductionItem) obj;
        if (!equals((Object) this.id, (Object) spuProductionItem.id) || !equals((Object) this.modelid, (Object) spuProductionItem.modelid) || !equals((Object) this.itemid, (Object) spuProductionItem.itemid) || !equals((Object) this.spuid, (Object) spuProductionItem.spuid) || !equals((Object) this.shopid, (Object) spuProductionItem.shopid) || !equals((Object) this.ctime, (Object) spuProductionItem.ctime) || !equals((Object) this.mtime, (Object) spuProductionItem.mtime) || !equals((Object) this.status, (Object) spuProductionItem.status) || !equals((Object) this.extinfo, (Object) spuProductionItem.extinfo)) {
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
        Long l2 = this.modelid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.itemid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.spuid;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SpuProductionItem> {
        public Integer ctime;
        public f extinfo;
        public Long id;
        public Long itemid;
        public Long modelid;
        public Integer mtime;
        public Integer shopid;
        public Long spuid;
        public Integer status;

        public Builder() {
        }

        public Builder(SpuProductionItem spuProductionItem) {
            super(spuProductionItem);
            if (spuProductionItem != null) {
                this.id = spuProductionItem.id;
                this.modelid = spuProductionItem.modelid;
                this.itemid = spuProductionItem.itemid;
                this.spuid = spuProductionItem.spuid;
                this.shopid = spuProductionItem.shopid;
                this.ctime = spuProductionItem.ctime;
                this.mtime = spuProductionItem.mtime;
                this.status = spuProductionItem.status;
                this.extinfo = spuProductionItem.extinfo;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder spuid(Long l) {
            this.spuid = l;
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

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public SpuProductionItem build() {
            return new SpuProductionItem(this);
        }
    }
}
