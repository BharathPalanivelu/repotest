package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UpdateItemImage extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_IMAGEMD5 = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String imagemd5;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public UpdateItemImage(Integer num, Long l, Integer num2, String str, Integer num3, String str2, f fVar) {
        this.type = num;
        this.itemid = l;
        this.shopid = num2;
        this.imagemd5 = str;
        this.status = num3;
        this.country = str2;
        this.raw_ctx = fVar;
    }

    private UpdateItemImage(Builder builder) {
        this(builder.type, builder.itemid, builder.shopid, builder.imagemd5, builder.status, builder.country, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateItemImage)) {
            return false;
        }
        UpdateItemImage updateItemImage = (UpdateItemImage) obj;
        if (!equals((Object) this.type, (Object) updateItemImage.type) || !equals((Object) this.itemid, (Object) updateItemImage.itemid) || !equals((Object) this.shopid, (Object) updateItemImage.shopid) || !equals((Object) this.imagemd5, (Object) updateItemImage.imagemd5) || !equals((Object) this.status, (Object) updateItemImage.status) || !equals((Object) this.country, (Object) updateItemImage.country) || !equals((Object) this.raw_ctx, (Object) updateItemImage.raw_ctx)) {
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
        String str = this.imagemd5;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdateItemImage> {
        public String country;
        public String imagemd5;
        public Long itemid;
        public f raw_ctx;
        public Integer shopid;
        public Integer status;
        public Integer type;

        public Builder() {
        }

        public Builder(UpdateItemImage updateItemImage) {
            super(updateItemImage);
            if (updateItemImage != null) {
                this.type = updateItemImage.type;
                this.itemid = updateItemImage.itemid;
                this.shopid = updateItemImage.shopid;
                this.imagemd5 = updateItemImage.imagemd5;
                this.status = updateItemImage.status;
                this.country = updateItemImage.country;
                this.raw_ctx = updateItemImage.raw_ctx;
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

        public Builder imagemd5(String str) {
            this.imagemd5 = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public UpdateItemImage build() {
            return new UpdateItemImage(this);
        }
    }
}
