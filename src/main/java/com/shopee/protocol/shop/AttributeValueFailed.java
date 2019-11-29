package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeValueFailed extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String value;

    public AttributeValueFailed(Integer num, Integer num2, String str, Integer num3, Integer num4, String str2) {
        this.id = num;
        this.attr_id = num2;
        this.value = str;
        this.mtime = num3;
        this.status = num4;
        this.country = str2;
    }

    private AttributeValueFailed(Builder builder) {
        this(builder.id, builder.attr_id, builder.value, builder.mtime, builder.status, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeValueFailed)) {
            return false;
        }
        AttributeValueFailed attributeValueFailed = (AttributeValueFailed) obj;
        if (!equals((Object) this.id, (Object) attributeValueFailed.id) || !equals((Object) this.attr_id, (Object) attributeValueFailed.attr_id) || !equals((Object) this.value, (Object) attributeValueFailed.value) || !equals((Object) this.mtime, (Object) attributeValueFailed.mtime) || !equals((Object) this.status, (Object) attributeValueFailed.status) || !equals((Object) this.country, (Object) attributeValueFailed.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.attr_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.value;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeValueFailed> {
        public Integer attr_id;
        public String country;
        public Integer id;
        public Integer mtime;
        public Integer status;
        public String value;

        public Builder() {
        }

        public Builder(AttributeValueFailed attributeValueFailed) {
            super(attributeValueFailed);
            if (attributeValueFailed != null) {
                this.id = attributeValueFailed.id;
                this.attr_id = attributeValueFailed.attr_id;
                this.value = attributeValueFailed.value;
                this.mtime = attributeValueFailed.mtime;
                this.status = attributeValueFailed.status;
                this.country = attributeValueFailed.country;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder attr_id(Integer num) {
            this.attr_id = num;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public AttributeValueFailed build() {
            return new AttributeValueFailed(this);
        }
    }
}
