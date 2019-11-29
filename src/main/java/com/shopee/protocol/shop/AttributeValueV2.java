package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class AttributeValueV2 extends Message {
    public static final f DEFAULT_ALIAS = f.f32736b;
    public static final Integer DEFAULT_APPROVAL_STATUS = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_VALUE = "";
    public static final Long DEFAULT_VALUEID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f alias;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer approval_status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long valueid;

    public AttributeValueV2(Long l, String str, f fVar, Integer num, Integer num2) {
        this.valueid = l;
        this.value = str;
        this.alias = fVar;
        this.approval_status = num;
        this.status = num2;
    }

    private AttributeValueV2(Builder builder) {
        this(builder.valueid, builder.value, builder.alias, builder.approval_status, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeValueV2)) {
            return false;
        }
        AttributeValueV2 attributeValueV2 = (AttributeValueV2) obj;
        if (!equals((Object) this.valueid, (Object) attributeValueV2.valueid) || !equals((Object) this.value, (Object) attributeValueV2.value) || !equals((Object) this.alias, (Object) attributeValueV2.alias) || !equals((Object) this.approval_status, (Object) attributeValueV2.approval_status) || !equals((Object) this.status, (Object) attributeValueV2.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.valueid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.value;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.alias;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.approval_status;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttributeValueV2> {
        public f alias;
        public Integer approval_status;
        public Integer status;
        public String value;
        public Long valueid;

        public Builder() {
        }

        public Builder(AttributeValueV2 attributeValueV2) {
            super(attributeValueV2);
            if (attributeValueV2 != null) {
                this.valueid = attributeValueV2.valueid;
                this.value = attributeValueV2.value;
                this.alias = attributeValueV2.alias;
                this.approval_status = attributeValueV2.approval_status;
                this.status = attributeValueV2.status;
            }
        }

        public Builder valueid(Long l) {
            this.valueid = l;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Builder alias(f fVar) {
            this.alias = fVar;
            return this;
        }

        public Builder approval_status(Integer num) {
            this.approval_status = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public AttributeValueV2 build() {
            return new AttributeValueV2(this);
        }
    }
}
