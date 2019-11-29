package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeValuePending extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final Integer DEFAULT_COUNT = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MODEL_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer model_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String value;

    public AttributeValuePending(Integer num, Integer num2, Integer num3, String str, Integer num4, Integer num5, Integer num6, String str2) {
        this.id = num;
        this.model_id = num2;
        this.attr_id = num3;
        this.value = str;
        this.count = num4;
        this.mtime = num5;
        this.status = num6;
        this.country = str2;
    }

    private AttributeValuePending(Builder builder) {
        this(builder.id, builder.model_id, builder.attr_id, builder.value, builder.count, builder.mtime, builder.status, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeValuePending)) {
            return false;
        }
        AttributeValuePending attributeValuePending = (AttributeValuePending) obj;
        if (!equals((Object) this.id, (Object) attributeValuePending.id) || !equals((Object) this.model_id, (Object) attributeValuePending.model_id) || !equals((Object) this.attr_id, (Object) attributeValuePending.attr_id) || !equals((Object) this.value, (Object) attributeValuePending.value) || !equals((Object) this.count, (Object) attributeValuePending.count) || !equals((Object) this.mtime, (Object) attributeValuePending.mtime) || !equals((Object) this.status, (Object) attributeValuePending.status) || !equals((Object) this.country, (Object) attributeValuePending.country)) {
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
        Integer num2 = this.model_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.attr_id;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.value;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.count;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeValuePending> {
        public Integer attr_id;
        public Integer count;
        public String country;
        public Integer id;
        public Integer model_id;
        public Integer mtime;
        public Integer status;
        public String value;

        public Builder() {
        }

        public Builder(AttributeValuePending attributeValuePending) {
            super(attributeValuePending);
            if (attributeValuePending != null) {
                this.id = attributeValuePending.id;
                this.model_id = attributeValuePending.model_id;
                this.attr_id = attributeValuePending.attr_id;
                this.value = attributeValuePending.value;
                this.count = attributeValuePending.count;
                this.mtime = attributeValuePending.mtime;
                this.status = attributeValuePending.status;
                this.country = attributeValuePending.country;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder model_id(Integer num) {
            this.model_id = num;
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

        public Builder count(Integer num) {
            this.count = num;
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

        public AttributeValuePending build() {
            return new AttributeValuePending(this);
        }
    }
}
