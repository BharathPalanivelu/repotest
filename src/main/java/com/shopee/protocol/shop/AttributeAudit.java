package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeAudit extends Message {
    public static final Integer DEFAULT_AUDIT_TYPE = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DATA = "";
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_OBJECT_ID = 0;
    public static final Integer DEFAULT_OBJECT_TYPE = 0;
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer audit_type;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer object_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer object_type;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer timestamp;

    public AttributeAudit(Long l, Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, Integer num5, String str3) {
        this.id = l;
        this.object_id = num;
        this.timestamp = num2;
        this.operator = str;
        this.data = str2;
        this.audit_type = num3;
        this.status = num4;
        this.object_type = num5;
        this.country = str3;
    }

    private AttributeAudit(Builder builder) {
        this(builder.id, builder.object_id, builder.timestamp, builder.operator, builder.data, builder.audit_type, builder.status, builder.object_type, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeAudit)) {
            return false;
        }
        AttributeAudit attributeAudit = (AttributeAudit) obj;
        if (!equals((Object) this.id, (Object) attributeAudit.id) || !equals((Object) this.object_id, (Object) attributeAudit.object_id) || !equals((Object) this.timestamp, (Object) attributeAudit.timestamp) || !equals((Object) this.operator, (Object) attributeAudit.operator) || !equals((Object) this.data, (Object) attributeAudit.data) || !equals((Object) this.audit_type, (Object) attributeAudit.audit_type) || !equals((Object) this.status, (Object) attributeAudit.status) || !equals((Object) this.object_type, (Object) attributeAudit.object_type) || !equals((Object) this.country, (Object) attributeAudit.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.object_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.timestamp;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.operator;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.data;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.audit_type;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.object_type;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeAudit> {
        public Integer audit_type;
        public String country;
        public String data;
        public Long id;
        public Integer object_id;
        public Integer object_type;
        public String operator;
        public Integer status;
        public Integer timestamp;

        public Builder() {
        }

        public Builder(AttributeAudit attributeAudit) {
            super(attributeAudit);
            if (attributeAudit != null) {
                this.id = attributeAudit.id;
                this.object_id = attributeAudit.object_id;
                this.timestamp = attributeAudit.timestamp;
                this.operator = attributeAudit.operator;
                this.data = attributeAudit.data;
                this.audit_type = attributeAudit.audit_type;
                this.status = attributeAudit.status;
                this.object_type = attributeAudit.object_type;
                this.country = attributeAudit.country;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder object_id(Integer num) {
            this.object_id = num;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder data(String str) {
            this.data = str;
            return this;
        }

        public Builder audit_type(Integer num) {
            this.audit_type = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder object_type(Integer num) {
            this.object_type = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public AttributeAudit build() {
            return new AttributeAudit(this);
        }
    }
}
