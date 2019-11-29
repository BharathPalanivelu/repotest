package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StandardProductAttribute extends Message {
    public static final Long DEFAULT_ATTR_ID = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_SPU_ID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_VALUEID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long attr_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long spu_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long valueid;

    public StandardProductAttribute(Long l, Long l2, Long l3, Long l4, Integer num) {
        this.id = l;
        this.spu_id = l2;
        this.attr_id = l3;
        this.valueid = l4;
        this.status = num;
    }

    private StandardProductAttribute(Builder builder) {
        this(builder.id, builder.spu_id, builder.attr_id, builder.valueid, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardProductAttribute)) {
            return false;
        }
        StandardProductAttribute standardProductAttribute = (StandardProductAttribute) obj;
        if (!equals((Object) this.id, (Object) standardProductAttribute.id) || !equals((Object) this.spu_id, (Object) standardProductAttribute.spu_id) || !equals((Object) this.attr_id, (Object) standardProductAttribute.attr_id) || !equals((Object) this.valueid, (Object) standardProductAttribute.valueid) || !equals((Object) this.status, (Object) standardProductAttribute.status)) {
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
        Long l2 = this.spu_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.attr_id;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.valueid;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StandardProductAttribute> {
        public Long attr_id;
        public Long id;
        public Long spu_id;
        public Integer status;
        public Long valueid;

        public Builder() {
        }

        public Builder(StandardProductAttribute standardProductAttribute) {
            super(standardProductAttribute);
            if (standardProductAttribute != null) {
                this.id = standardProductAttribute.id;
                this.spu_id = standardProductAttribute.spu_id;
                this.attr_id = standardProductAttribute.attr_id;
                this.valueid = standardProductAttribute.valueid;
                this.status = standardProductAttribute.status;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder spu_id(Long l) {
            this.spu_id = l;
            return this;
        }

        public Builder attr_id(Long l) {
            this.attr_id = l;
            return this;
        }

        public Builder valueid(Long l) {
            this.valueid = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public StandardProductAttribute build() {
            return new StandardProductAttribute(this);
        }
    }
}
