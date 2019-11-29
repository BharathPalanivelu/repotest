package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ProductListWeight extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_WEIGHT_TYPE = 0;
    public static final Double DEFAULT_WEIGHT_VALUE = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer weight_type;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double weight_value;

    public ProductListWeight(Integer num, Integer num2, Integer num3, Double d2, Integer num4, String str) {
        this.id = num;
        this.catid = num2;
        this.weight_type = num3;
        this.weight_value = d2;
        this.mtime = num4;
        this.country = str;
    }

    private ProductListWeight(Builder builder) {
        this(builder.id, builder.catid, builder.weight_type, builder.weight_value, builder.mtime, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductListWeight)) {
            return false;
        }
        ProductListWeight productListWeight = (ProductListWeight) obj;
        if (!equals((Object) this.id, (Object) productListWeight.id) || !equals((Object) this.catid, (Object) productListWeight.catid) || !equals((Object) this.weight_type, (Object) productListWeight.weight_type) || !equals((Object) this.weight_value, (Object) productListWeight.weight_value) || !equals((Object) this.mtime, (Object) productListWeight.mtime) || !equals((Object) this.country, (Object) productListWeight.country)) {
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
        Integer num2 = this.catid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.weight_type;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Double d2 = this.weight_value;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ProductListWeight> {
        public Integer catid;
        public String country;
        public Integer id;
        public Integer mtime;
        public Integer weight_type;
        public Double weight_value;

        public Builder() {
        }

        public Builder(ProductListWeight productListWeight) {
            super(productListWeight);
            if (productListWeight != null) {
                this.id = productListWeight.id;
                this.catid = productListWeight.catid;
                this.weight_type = productListWeight.weight_type;
                this.weight_value = productListWeight.weight_value;
                this.mtime = productListWeight.mtime;
                this.country = productListWeight.country;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder weight_type(Integer num) {
            this.weight_type = num;
            return this;
        }

        public Builder weight_value(Double d2) {
            this.weight_value = d2;
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

        public ProductListWeight build() {
            return new ProductListWeight(this);
        }
    }
}
