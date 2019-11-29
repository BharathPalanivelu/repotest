package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttributeValueRelation extends Message {
    public static final Long DEFAULT_ATTRID = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ROOT_ATTRID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_VALUEID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long attrid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long root_attrid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long valueid;

    public AttributeValueRelation(Long l, Long l2, Long l3, Long l4, Integer num) {
        this.id = l;
        this.root_attrid = l2;
        this.attrid = l3;
        this.valueid = l4;
        this.status = num;
    }

    private AttributeValueRelation(Builder builder) {
        this(builder.id, builder.root_attrid, builder.attrid, builder.valueid, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeValueRelation)) {
            return false;
        }
        AttributeValueRelation attributeValueRelation = (AttributeValueRelation) obj;
        if (!equals((Object) this.id, (Object) attributeValueRelation.id) || !equals((Object) this.root_attrid, (Object) attributeValueRelation.root_attrid) || !equals((Object) this.attrid, (Object) attributeValueRelation.attrid) || !equals((Object) this.valueid, (Object) attributeValueRelation.valueid) || !equals((Object) this.status, (Object) attributeValueRelation.status)) {
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
        Long l2 = this.root_attrid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.attrid;
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

    public static final class Builder extends Message.Builder<AttributeValueRelation> {
        public Long attrid;
        public Long id;
        public Long root_attrid;
        public Integer status;
        public Long valueid;

        public Builder() {
        }

        public Builder(AttributeValueRelation attributeValueRelation) {
            super(attributeValueRelation);
            if (attributeValueRelation != null) {
                this.id = attributeValueRelation.id;
                this.root_attrid = attributeValueRelation.root_attrid;
                this.attrid = attributeValueRelation.attrid;
                this.valueid = attributeValueRelation.valueid;
                this.status = attributeValueRelation.status;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder root_attrid(Long l) {
            this.root_attrid = l;
            return this;
        }

        public Builder attrid(Long l) {
            this.attrid = l;
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

        public AttributeValueRelation build() {
            return new AttributeValueRelation(this);
        }
    }
}
