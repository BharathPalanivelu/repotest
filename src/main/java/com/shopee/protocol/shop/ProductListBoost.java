package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ProductListBoost extends Message {
    public static final Double DEFAULT_BOOST_VALUE = Double.valueOf(0.0d);
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double boost_value;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;

    public ProductListBoost(Integer num, Integer num2, Long l, Double d2, String str, Integer num3, Integer num4) {
        this.id = num;
        this.shopid = num2;
        this.itemid = l;
        this.boost_value = d2;
        this.country = str;
        this.mtime = num3;
        this.status = num4;
    }

    private ProductListBoost(Builder builder) {
        this(builder.id, builder.shopid, builder.itemid, builder.boost_value, builder.country, builder.mtime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductListBoost)) {
            return false;
        }
        ProductListBoost productListBoost = (ProductListBoost) obj;
        if (!equals((Object) this.id, (Object) productListBoost.id) || !equals((Object) this.shopid, (Object) productListBoost.shopid) || !equals((Object) this.itemid, (Object) productListBoost.itemid) || !equals((Object) this.boost_value, (Object) productListBoost.boost_value) || !equals((Object) this.country, (Object) productListBoost.country) || !equals((Object) this.mtime, (Object) productListBoost.mtime) || !equals((Object) this.status, (Object) productListBoost.status)) {
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
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Double d2 = this.boost_value;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ProductListBoost> {
        public Double boost_value;
        public String country;
        public Integer id;
        public Long itemid;
        public Integer mtime;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(ProductListBoost productListBoost) {
            super(productListBoost);
            if (productListBoost != null) {
                this.id = productListBoost.id;
                this.shopid = productListBoost.shopid;
                this.itemid = productListBoost.itemid;
                this.boost_value = productListBoost.boost_value;
                this.country = productListBoost.country;
                this.mtime = productListBoost.mtime;
                this.status = productListBoost.status;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder boost_value(Double d2) {
            this.boost_value = d2;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
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

        public ProductListBoost build() {
            return new ProductListBoost(this);
        }
    }
}
