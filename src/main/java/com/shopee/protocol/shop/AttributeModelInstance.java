package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class AttributeModelInstance extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_INSTANCE_ID = 0;
    public static final Integer DEFAULT_MODEL_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer instance_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer model_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;

    public AttributeModelInstance(Integer num, Integer num2, f fVar, String str, String str2, Integer num3, Integer num4, Integer num5) {
        this.instance_id = num;
        this.model_id = num2;
        this.extinfo = fVar;
        this.country = str;
        this.name = str2;
        this.ctime = num3;
        this.mtime = num4;
        this.status = num5;
    }

    private AttributeModelInstance(Builder builder) {
        this(builder.instance_id, builder.model_id, builder.extinfo, builder.country, builder.name, builder.ctime, builder.mtime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeModelInstance)) {
            return false;
        }
        AttributeModelInstance attributeModelInstance = (AttributeModelInstance) obj;
        if (!equals((Object) this.instance_id, (Object) attributeModelInstance.instance_id) || !equals((Object) this.model_id, (Object) attributeModelInstance.model_id) || !equals((Object) this.extinfo, (Object) attributeModelInstance.extinfo) || !equals((Object) this.country, (Object) attributeModelInstance.country) || !equals((Object) this.name, (Object) attributeModelInstance.name) || !equals((Object) this.ctime, (Object) attributeModelInstance.ctime) || !equals((Object) this.mtime, (Object) attributeModelInstance.mtime) || !equals((Object) this.status, (Object) attributeModelInstance.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.instance_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.model_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeModelInstance> {
        public String country;
        public Integer ctime;
        public f extinfo;
        public Integer instance_id;
        public Integer model_id;
        public Integer mtime;
        public String name;
        public Integer status;

        public Builder() {
        }

        public Builder(AttributeModelInstance attributeModelInstance) {
            super(attributeModelInstance);
            if (attributeModelInstance != null) {
                this.instance_id = attributeModelInstance.instance_id;
                this.model_id = attributeModelInstance.model_id;
                this.extinfo = attributeModelInstance.extinfo;
                this.country = attributeModelInstance.country;
                this.name = attributeModelInstance.name;
                this.ctime = attributeModelInstance.ctime;
                this.mtime = attributeModelInstance.mtime;
                this.status = attributeModelInstance.status;
            }
        }

        public Builder instance_id(Integer num) {
            this.instance_id = num;
            return this;
        }

        public Builder model_id(Integer num) {
            this.model_id = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
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

        public AttributeModelInstance build() {
            return new AttributeModelInstance(this);
        }
    }
}
