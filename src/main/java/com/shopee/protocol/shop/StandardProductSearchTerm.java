package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class StandardProductSearchTerm extends Message {
    public static final f DEFAULT_CATS = f.f32736b;
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_SEARCH_TERM = "";
    public static final Long DEFAULT_SPU_ID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f cats;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String search_term;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long spu_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public StandardProductSearchTerm(Long l, Long l2, String str, String str2, f fVar, Integer num) {
        this.id = l;
        this.spu_id = l2;
        this.search_term = str;
        this.country = str2;
        this.cats = fVar;
        this.status = num;
    }

    private StandardProductSearchTerm(Builder builder) {
        this(builder.id, builder.spu_id, builder.search_term, builder.country, builder.cats, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardProductSearchTerm)) {
            return false;
        }
        StandardProductSearchTerm standardProductSearchTerm = (StandardProductSearchTerm) obj;
        if (!equals((Object) this.id, (Object) standardProductSearchTerm.id) || !equals((Object) this.spu_id, (Object) standardProductSearchTerm.spu_id) || !equals((Object) this.search_term, (Object) standardProductSearchTerm.search_term) || !equals((Object) this.country, (Object) standardProductSearchTerm.country) || !equals((Object) this.cats, (Object) standardProductSearchTerm.cats) || !equals((Object) this.status, (Object) standardProductSearchTerm.status)) {
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
        String str = this.search_term;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.cats;
        int hashCode5 = (hashCode4 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StandardProductSearchTerm> {
        public f cats;
        public String country;
        public Long id;
        public String search_term;
        public Long spu_id;
        public Integer status;

        public Builder() {
        }

        public Builder(StandardProductSearchTerm standardProductSearchTerm) {
            super(standardProductSearchTerm);
            if (standardProductSearchTerm != null) {
                this.id = standardProductSearchTerm.id;
                this.spu_id = standardProductSearchTerm.spu_id;
                this.search_term = standardProductSearchTerm.search_term;
                this.country = standardProductSearchTerm.country;
                this.cats = standardProductSearchTerm.cats;
                this.status = standardProductSearchTerm.status;
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

        public Builder search_term(String str) {
            this.search_term = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder cats(f fVar) {
            this.cats = fVar;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public StandardProductSearchTerm build() {
            return new StandardProductSearchTerm(this);
        }
    }
}
