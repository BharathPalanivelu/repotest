package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class RootAttribute extends Message {
    public static final f DEFAULT_ALIAS = f.f32736b;
    public static final Long DEFAULT_ATTRID = 0L;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REMARKS = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f alias;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long attrid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String remarks;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public RootAttribute(Long l, String str, f fVar, String str2, Integer num) {
        this.attrid = l;
        this.name = str;
        this.alias = fVar;
        this.remarks = str2;
        this.status = num;
    }

    private RootAttribute(Builder builder) {
        this(builder.attrid, builder.name, builder.alias, builder.remarks, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RootAttribute)) {
            return false;
        }
        RootAttribute rootAttribute = (RootAttribute) obj;
        if (!equals((Object) this.attrid, (Object) rootAttribute.attrid) || !equals((Object) this.name, (Object) rootAttribute.name) || !equals((Object) this.alias, (Object) rootAttribute.alias) || !equals((Object) this.remarks, (Object) rootAttribute.remarks) || !equals((Object) this.status, (Object) rootAttribute.status)) {
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
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.alias;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.remarks;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RootAttribute> {
        public f alias;
        public Long attrid;
        public String name;
        public String remarks;
        public Integer status;

        public Builder() {
        }

        public Builder(RootAttribute rootAttribute) {
            super(rootAttribute);
            if (rootAttribute != null) {
                this.attrid = rootAttribute.attrid;
                this.name = rootAttribute.name;
                this.alias = rootAttribute.alias;
                this.remarks = rootAttribute.remarks;
                this.status = rootAttribute.status;
            }
        }

        public Builder attrid(Long l) {
            this.attrid = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder alias(f fVar) {
            this.alias = fVar;
            return this;
        }

        public Builder remarks(String str) {
            this.remarks = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public RootAttribute build() {
            return new RootAttribute(this);
        }
    }
}
