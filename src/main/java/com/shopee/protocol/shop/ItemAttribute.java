package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ItemAttribute extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final Integer DEFAULT_ATTR_TYPE = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_INPUT_TYPE = 0;
    public static final Integer DEFAULT_MANDATORY = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_VALIDATE_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer attr_type;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String display_name;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer input_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mandatory;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer validate_type;

    public ItemAttribute(Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, f fVar, Integer num6, String str2, Integer num7, Integer num8, String str3) {
        this.attr_id = num;
        this.name = str;
        this.input_type = num2;
        this.attr_type = num3;
        this.status = num4;
        this.validate_type = num5;
        this.extinfo = fVar;
        this.mandatory = num6;
        this.country = str2;
        this.ctime = num7;
        this.mtime = num8;
        this.display_name = str3;
    }

    private ItemAttribute(Builder builder) {
        this(builder.attr_id, builder.name, builder.input_type, builder.attr_type, builder.status, builder.validate_type, builder.extinfo, builder.mandatory, builder.country, builder.ctime, builder.mtime, builder.display_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemAttribute)) {
            return false;
        }
        ItemAttribute itemAttribute = (ItemAttribute) obj;
        if (!equals((Object) this.attr_id, (Object) itemAttribute.attr_id) || !equals((Object) this.name, (Object) itemAttribute.name) || !equals((Object) this.input_type, (Object) itemAttribute.input_type) || !equals((Object) this.attr_type, (Object) itemAttribute.attr_type) || !equals((Object) this.status, (Object) itemAttribute.status) || !equals((Object) this.validate_type, (Object) itemAttribute.validate_type) || !equals((Object) this.extinfo, (Object) itemAttribute.extinfo) || !equals((Object) this.mandatory, (Object) itemAttribute.mandatory) || !equals((Object) this.country, (Object) itemAttribute.country) || !equals((Object) this.ctime, (Object) itemAttribute.ctime) || !equals((Object) this.mtime, (Object) itemAttribute.mtime) || !equals((Object) this.display_name, (Object) itemAttribute.display_name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.attr_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.input_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.attr_type;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.validate_type;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode7 = (hashCode6 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num6 = this.mandatory;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num7 = this.ctime;
        int hashCode10 = (hashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.mtime;
        int hashCode11 = (hashCode10 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str3 = this.display_name;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemAttribute> {
        public Integer attr_id;
        public Integer attr_type;
        public String country;
        public Integer ctime;
        public String display_name;
        public f extinfo;
        public Integer input_type;
        public Integer mandatory;
        public Integer mtime;
        public String name;
        public Integer status;
        public Integer validate_type;

        public Builder() {
        }

        public Builder(ItemAttribute itemAttribute) {
            super(itemAttribute);
            if (itemAttribute != null) {
                this.attr_id = itemAttribute.attr_id;
                this.name = itemAttribute.name;
                this.input_type = itemAttribute.input_type;
                this.attr_type = itemAttribute.attr_type;
                this.status = itemAttribute.status;
                this.validate_type = itemAttribute.validate_type;
                this.extinfo = itemAttribute.extinfo;
                this.mandatory = itemAttribute.mandatory;
                this.country = itemAttribute.country;
                this.ctime = itemAttribute.ctime;
                this.mtime = itemAttribute.mtime;
                this.display_name = itemAttribute.display_name;
            }
        }

        public Builder attr_id(Integer num) {
            this.attr_id = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder input_type(Integer num) {
            this.input_type = num;
            return this;
        }

        public Builder attr_type(Integer num) {
            this.attr_type = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder validate_type(Integer num) {
            this.validate_type = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder mandatory(Integer num) {
            this.mandatory = num;
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

        public Builder display_name(String str) {
            this.display_name = str;
            return this;
        }

        public ItemAttribute build() {
            return new ItemAttribute(this);
        }
    }
}
