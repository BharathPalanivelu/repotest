package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class StandardProduct extends Message {
    public static final f DEFAULT_ALT_NAME = f.f32736b;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_RELEASE_DATE = 0L;
    public static final Long DEFAULT_SPUID = 0L;
    public static final String DEFAULT_SPU_COVER_IMG = "";
    public static final String DEFAULT_SPU_NAME = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f alt_name;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long release_date;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String spu_cover_img;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String spu_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long spuid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public StandardProduct(Long l, String str, String str2, Long l2, Integer num, f fVar, f fVar2) {
        this.spuid = l;
        this.spu_name = str;
        this.spu_cover_img = str2;
        this.release_date = l2;
        this.status = num;
        this.extinfo = fVar;
        this.alt_name = fVar2;
    }

    private StandardProduct(Builder builder) {
        this(builder.spuid, builder.spu_name, builder.spu_cover_img, builder.release_date, builder.status, builder.extinfo, builder.alt_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardProduct)) {
            return false;
        }
        StandardProduct standardProduct = (StandardProduct) obj;
        if (!equals((Object) this.spuid, (Object) standardProduct.spuid) || !equals((Object) this.spu_name, (Object) standardProduct.spu_name) || !equals((Object) this.spu_cover_img, (Object) standardProduct.spu_cover_img) || !equals((Object) this.release_date, (Object) standardProduct.release_date) || !equals((Object) this.status, (Object) standardProduct.status) || !equals((Object) this.extinfo, (Object) standardProduct.extinfo) || !equals((Object) this.alt_name, (Object) standardProduct.alt_name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.spuid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.spu_name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.spu_cover_img;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.release_date;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.alt_name;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StandardProduct> {
        public f alt_name;
        public f extinfo;
        public Long release_date;
        public String spu_cover_img;
        public String spu_name;
        public Long spuid;
        public Integer status;

        public Builder() {
        }

        public Builder(StandardProduct standardProduct) {
            super(standardProduct);
            if (standardProduct != null) {
                this.spuid = standardProduct.spuid;
                this.spu_name = standardProduct.spu_name;
                this.spu_cover_img = standardProduct.spu_cover_img;
                this.release_date = standardProduct.release_date;
                this.status = standardProduct.status;
                this.extinfo = standardProduct.extinfo;
                this.alt_name = standardProduct.alt_name;
            }
        }

        public Builder spuid(Long l) {
            this.spuid = l;
            return this;
        }

        public Builder spu_name(String str) {
            this.spu_name = str;
            return this;
        }

        public Builder spu_cover_img(String str) {
            this.spu_cover_img = str;
            return this;
        }

        public Builder release_date(Long l) {
            this.release_date = l;
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

        public Builder alt_name(f fVar) {
            this.alt_name = fVar;
            return this;
        }

        public StandardProduct build() {
            return new StandardProduct(this);
        }
    }
}
