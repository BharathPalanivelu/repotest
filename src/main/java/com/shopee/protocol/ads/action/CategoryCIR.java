package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CategoryCIR extends Message {
    public static final Long DEFAULT_CATEGORYID = 0L;
    public static final Integer DEFAULT_CATEGORY_LEVEL = 0;
    public static final Double DEFAULT_CIR;
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Double DEFAULT_VARIANCE;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer category_level;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long categoryid;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double cir;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double variance;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_CIR = valueOf;
        DEFAULT_VARIANCE = valueOf;
    }

    public CategoryCIR(Long l, Integer num, Integer num2, Long l2, Long l3, Double d2, Double d3) {
        this.categoryid = l;
        this.category_level = num;
        this.status = num2;
        this.ctime = l2;
        this.mtime = l3;
        this.cir = d2;
        this.variance = d3;
    }

    private CategoryCIR(Builder builder) {
        this(builder.categoryid, builder.category_level, builder.status, builder.ctime, builder.mtime, builder.cir, builder.variance);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryCIR)) {
            return false;
        }
        CategoryCIR categoryCIR = (CategoryCIR) obj;
        if (!equals((Object) this.categoryid, (Object) categoryCIR.categoryid) || !equals((Object) this.category_level, (Object) categoryCIR.category_level) || !equals((Object) this.status, (Object) categoryCIR.status) || !equals((Object) this.ctime, (Object) categoryCIR.ctime) || !equals((Object) this.mtime, (Object) categoryCIR.mtime) || !equals((Object) this.cir, (Object) categoryCIR.cir) || !equals((Object) this.variance, (Object) categoryCIR.variance)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.categoryid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.category_level;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Double d2 = this.cir;
        int hashCode6 = (hashCode5 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.variance;
        if (d3 != null) {
            i2 = d3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CategoryCIR> {
        public Integer category_level;
        public Long categoryid;
        public Double cir;
        public Long ctime;
        public Long mtime;
        public Integer status;
        public Double variance;

        public Builder() {
        }

        public Builder(CategoryCIR categoryCIR) {
            super(categoryCIR);
            if (categoryCIR != null) {
                this.categoryid = categoryCIR.categoryid;
                this.category_level = categoryCIR.category_level;
                this.status = categoryCIR.status;
                this.ctime = categoryCIR.ctime;
                this.mtime = categoryCIR.mtime;
                this.cir = categoryCIR.cir;
                this.variance = categoryCIR.variance;
            }
        }

        public Builder categoryid(Long l) {
            this.categoryid = l;
            return this;
        }

        public Builder category_level(Integer num) {
            this.category_level = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder cir(Double d2) {
            this.cir = d2;
            return this;
        }

        public Builder variance(Double d2) {
            this.variance = d2;
            return this;
        }

        public CategoryCIR build() {
            return new CategoryCIR(this);
        }
    }
}
