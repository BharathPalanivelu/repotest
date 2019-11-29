package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UpdateItemSku extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_NEWSKU = "";
    public static final String DEFAULT_OLDSKU = "";
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String newSku;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String oldSku;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public UpdateItemSku(Integer num, Long l, Integer num2, String str, String str2, Integer num3, String str3, f fVar) {
        this.type = num;
        this.itemid = l;
        this.shopid = num2;
        this.newSku = str;
        this.oldSku = str2;
        this.status = num3;
        this.source = str3;
        this.raw_ctx = fVar;
    }

    private UpdateItemSku(Builder builder) {
        this(builder.type, builder.itemid, builder.shopid, builder.newSku, builder.oldSku, builder.status, builder.source, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateItemSku)) {
            return false;
        }
        UpdateItemSku updateItemSku = (UpdateItemSku) obj;
        if (!equals((Object) this.type, (Object) updateItemSku.type) || !equals((Object) this.itemid, (Object) updateItemSku.itemid) || !equals((Object) this.shopid, (Object) updateItemSku.shopid) || !equals((Object) this.newSku, (Object) updateItemSku.newSku) || !equals((Object) this.oldSku, (Object) updateItemSku.oldSku) || !equals((Object) this.status, (Object) updateItemSku.status) || !equals((Object) this.source, (Object) updateItemSku.source) || !equals((Object) this.raw_ctx, (Object) updateItemSku.raw_ctx)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.newSku;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.oldSku;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.source;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdateItemSku> {
        public Long itemid;
        public String newSku;
        public String oldSku;
        public f raw_ctx;
        public Integer shopid;
        public String source;
        public Integer status;
        public Integer type;

        public Builder() {
        }

        public Builder(UpdateItemSku updateItemSku) {
            super(updateItemSku);
            if (updateItemSku != null) {
                this.type = updateItemSku.type;
                this.itemid = updateItemSku.itemid;
                this.shopid = updateItemSku.shopid;
                this.newSku = updateItemSku.newSku;
                this.oldSku = updateItemSku.oldSku;
                this.status = updateItemSku.status;
                this.source = updateItemSku.source;
                this.raw_ctx = updateItemSku.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder newSku(String str) {
            this.newSku = str;
            return this;
        }

        public Builder oldSku(String str) {
            this.oldSku = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public UpdateItemSku build() {
            return new UpdateItemSku(this);
        }
    }
}
