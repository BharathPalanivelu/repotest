package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeQC extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;

    public AttributeQC(Integer num, Integer num2, Integer num3, String str) {
        this.attr_id = num;
        this.mtime = num2;
        this.status = num3;
        this.country = str;
    }

    private AttributeQC(Builder builder) {
        this(builder.attr_id, builder.mtime, builder.status, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeQC)) {
            return false;
        }
        AttributeQC attributeQC = (AttributeQC) obj;
        if (!equals((Object) this.attr_id, (Object) attributeQC.attr_id) || !equals((Object) this.mtime, (Object) attributeQC.mtime) || !equals((Object) this.status, (Object) attributeQC.status) || !equals((Object) this.country, (Object) attributeQC.country)) {
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
        Integer num2 = this.mtime;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeQC> {
        public Integer attr_id;
        public String country;
        public Integer mtime;
        public Integer status;

        public Builder() {
        }

        public Builder(AttributeQC attributeQC) {
            super(attributeQC);
            if (attributeQC != null) {
                this.attr_id = attributeQC.attr_id;
                this.mtime = attributeQC.mtime;
                this.status = attributeQC.status;
                this.country = attributeQC.country;
            }
        }

        public Builder attr_id(Integer num) {
            this.attr_id = num;
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

        public AttributeQC build() {
            return new AttributeQC(this);
        }
    }
}
