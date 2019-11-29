package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class AttributeModel extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_IS_STANDARD = 0;
    public static final Integer DEFAULT_MODEL_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer is_standard;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer model_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;

    public AttributeModel(Integer num, String str, Integer num2, f fVar, Integer num3, String str2, Integer num4, Integer num5, Integer num6) {
        this.model_id = num;
        this.name = str;
        this.catid = num2;
        this.extinfo = fVar;
        this.is_standard = num3;
        this.country = str2;
        this.ctime = num4;
        this.mtime = num5;
        this.status = num6;
    }

    private AttributeModel(Builder builder) {
        this(builder.model_id, builder.name, builder.catid, builder.extinfo, builder.is_standard, builder.country, builder.ctime, builder.mtime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeModel)) {
            return false;
        }
        AttributeModel attributeModel = (AttributeModel) obj;
        if (!equals((Object) this.model_id, (Object) attributeModel.model_id) || !equals((Object) this.name, (Object) attributeModel.name) || !equals((Object) this.catid, (Object) attributeModel.catid) || !equals((Object) this.extinfo, (Object) attributeModel.extinfo) || !equals((Object) this.is_standard, (Object) attributeModel.is_standard) || !equals((Object) this.country, (Object) attributeModel.country) || !equals((Object) this.ctime, (Object) attributeModel.ctime) || !equals((Object) this.mtime, (Object) attributeModel.mtime) || !equals((Object) this.status, (Object) attributeModel.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.model_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.catid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num3 = this.is_standard;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeModel> {
        public Integer catid;
        public String country;
        public Integer ctime;
        public f extinfo;
        public Integer is_standard;
        public Integer model_id;
        public Integer mtime;
        public String name;
        public Integer status;

        public Builder() {
        }

        public Builder(AttributeModel attributeModel) {
            super(attributeModel);
            if (attributeModel != null) {
                this.model_id = attributeModel.model_id;
                this.name = attributeModel.name;
                this.catid = attributeModel.catid;
                this.extinfo = attributeModel.extinfo;
                this.is_standard = attributeModel.is_standard;
                this.country = attributeModel.country;
                this.ctime = attributeModel.ctime;
                this.mtime = attributeModel.mtime;
                this.status = attributeModel.status;
            }
        }

        public Builder model_id(Integer num) {
            this.model_id = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder is_standard(Integer num) {
            this.is_standard = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
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

        public AttributeModel build() {
            return new AttributeModel(this);
        }
    }
}
