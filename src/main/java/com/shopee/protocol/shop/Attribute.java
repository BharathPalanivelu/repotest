package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Attribute extends Message {
    public static final Long DEFAULT_ATTRID = 0L;
    public static final Long DEFAULT_ATTR_TYPE_FLAG = 0L;
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_PARENT_ATTR_ID = 0L;
    public static final Long DEFAULT_PARENT_VID = 0L;
    public static final Long DEFAULT_ROOT_ATTRID = 0L;
    public static final Long DEFAULT_SORTING = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long attr_type_flag;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long attrid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long parent_attr_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long parent_vid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long root_attrid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long sorting;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;

    public Attribute(Long l, Long l2, Long l3, Long l4, Integer num, Long l5, Long l6, Integer num2, f fVar, String str) {
        this.attrid = l;
        this.root_attrid = l2;
        this.parent_attr_id = l3;
        this.parent_vid = l4;
        this.catid = num;
        this.attr_type_flag = l5;
        this.sorting = l6;
        this.status = num2;
        this.extinfo = fVar;
        this.country = str;
    }

    private Attribute(Builder builder) {
        this(builder.attrid, builder.root_attrid, builder.parent_attr_id, builder.parent_vid, builder.catid, builder.attr_type_flag, builder.sorting, builder.status, builder.extinfo, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (!equals((Object) this.attrid, (Object) attribute.attrid) || !equals((Object) this.root_attrid, (Object) attribute.root_attrid) || !equals((Object) this.parent_attr_id, (Object) attribute.parent_attr_id) || !equals((Object) this.parent_vid, (Object) attribute.parent_vid) || !equals((Object) this.catid, (Object) attribute.catid) || !equals((Object) this.attr_type_flag, (Object) attribute.attr_type_flag) || !equals((Object) this.sorting, (Object) attribute.sorting) || !equals((Object) this.status, (Object) attribute.status) || !equals((Object) this.extinfo, (Object) attribute.extinfo) || !equals((Object) this.country, (Object) attribute.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.attrid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.root_attrid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.parent_attr_id;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.parent_vid;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.catid;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Long l5 = this.attr_type_flag;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.sorting;
        int hashCode7 = (hashCode6 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Attribute> {
        public Long attr_type_flag;
        public Long attrid;
        public Integer catid;
        public String country;
        public f extinfo;
        public Long parent_attr_id;
        public Long parent_vid;
        public Long root_attrid;
        public Long sorting;
        public Integer status;

        public Builder() {
        }

        public Builder(Attribute attribute) {
            super(attribute);
            if (attribute != null) {
                this.attrid = attribute.attrid;
                this.root_attrid = attribute.root_attrid;
                this.parent_attr_id = attribute.parent_attr_id;
                this.parent_vid = attribute.parent_vid;
                this.catid = attribute.catid;
                this.attr_type_flag = attribute.attr_type_flag;
                this.sorting = attribute.sorting;
                this.status = attribute.status;
                this.extinfo = attribute.extinfo;
                this.country = attribute.country;
            }
        }

        public Builder attrid(Long l) {
            this.attrid = l;
            return this;
        }

        public Builder root_attrid(Long l) {
            this.root_attrid = l;
            return this;
        }

        public Builder parent_attr_id(Long l) {
            this.parent_attr_id = l;
            return this;
        }

        public Builder parent_vid(Long l) {
            this.parent_vid = l;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder attr_type_flag(Long l) {
            this.attr_type_flag = l;
            return this;
        }

        public Builder sorting(Long l) {
            this.sorting = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Attribute build() {
            return new Attribute(this);
        }
    }
}
