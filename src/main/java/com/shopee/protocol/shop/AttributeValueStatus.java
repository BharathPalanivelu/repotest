package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeValueStatus extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Long DEFAULT_ITEM_ID = 0L;
    public static final Integer DEFAULT_MODEL_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOP_ID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long item_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer model_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shop_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String value;

    public AttributeValueStatus(Integer num, Long l, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, String str2) {
        this.id = num;
        this.item_id = l;
        this.shop_id = num2;
        this.model_id = num3;
        this.attr_id = num4;
        this.value = str;
        this.status = num5;
        this.mtime = num6;
        this.country = str2;
    }

    private AttributeValueStatus(Builder builder) {
        this(builder.id, builder.item_id, builder.shop_id, builder.model_id, builder.attr_id, builder.value, builder.status, builder.mtime, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeValueStatus)) {
            return false;
        }
        AttributeValueStatus attributeValueStatus = (AttributeValueStatus) obj;
        if (!equals((Object) this.id, (Object) attributeValueStatus.id) || !equals((Object) this.item_id, (Object) attributeValueStatus.item_id) || !equals((Object) this.shop_id, (Object) attributeValueStatus.shop_id) || !equals((Object) this.model_id, (Object) attributeValueStatus.model_id) || !equals((Object) this.attr_id, (Object) attributeValueStatus.attr_id) || !equals((Object) this.value, (Object) attributeValueStatus.value) || !equals((Object) this.status, (Object) attributeValueStatus.status) || !equals((Object) this.mtime, (Object) attributeValueStatus.mtime) || !equals((Object) this.country, (Object) attributeValueStatus.country)) {
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
        Long l = this.item_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shop_id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.model_id;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.attr_id;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.value;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeValueStatus> {
        public Integer attr_id;
        public String country;
        public Integer id;
        public Long item_id;
        public Integer model_id;
        public Integer mtime;
        public Integer shop_id;
        public Integer status;
        public String value;

        public Builder() {
        }

        public Builder(AttributeValueStatus attributeValueStatus) {
            super(attributeValueStatus);
            if (attributeValueStatus != null) {
                this.id = attributeValueStatus.id;
                this.item_id = attributeValueStatus.item_id;
                this.shop_id = attributeValueStatus.shop_id;
                this.model_id = attributeValueStatus.model_id;
                this.attr_id = attributeValueStatus.attr_id;
                this.value = attributeValueStatus.value;
                this.status = attributeValueStatus.status;
                this.mtime = attributeValueStatus.mtime;
                this.country = attributeValueStatus.country;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder item_id(Long l) {
            this.item_id = l;
            return this;
        }

        public Builder shop_id(Integer num) {
            this.shop_id = num;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public AttributeValueStatus build() {
            return new AttributeValueStatus(this);
        }
    }
}
