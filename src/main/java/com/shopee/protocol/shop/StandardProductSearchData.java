package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StandardProductSearchData extends Message {
    public static final Long DEFAULT_AVERAGE_PRICE = 0L;
    public static final Long DEFAULT_CALC_AVERAGE_PRICE = 0L;
    public static final Long DEFAULT_CALC_SELLER_COUNT = 0L;
    public static final Long DEFAULT_CALC_SOLD_COUNT = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_NUM_OF_SELLER = 0L;
    public static final Long DEFAULT_SOLD = 0L;
    public static final Long DEFAULT_SPU_ID = 0L;
    public static final Integer DEFAULT_SPU_LABEL = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long average_price;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long calc_average_price;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long calc_seller_count;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long calc_sold_count;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long num_of_seller;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long sold;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long spu_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer spu_label;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;

    public StandardProductSearchData(Long l, Long l2, Long l3, Long l4, Integer num, Long l5, String str, Integer num2, Long l6, Long l7, Long l8) {
        this.id = l;
        this.spu_id = l2;
        this.average_price = l3;
        this.sold = l4;
        this.spu_label = num;
        this.num_of_seller = l5;
        this.country = str;
        this.status = num2;
        this.calc_average_price = l6;
        this.calc_sold_count = l7;
        this.calc_seller_count = l8;
    }

    private StandardProductSearchData(Builder builder) {
        this(builder.id, builder.spu_id, builder.average_price, builder.sold, builder.spu_label, builder.num_of_seller, builder.country, builder.status, builder.calc_average_price, builder.calc_sold_count, builder.calc_seller_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardProductSearchData)) {
            return false;
        }
        StandardProductSearchData standardProductSearchData = (StandardProductSearchData) obj;
        if (!equals((Object) this.id, (Object) standardProductSearchData.id) || !equals((Object) this.spu_id, (Object) standardProductSearchData.spu_id) || !equals((Object) this.average_price, (Object) standardProductSearchData.average_price) || !equals((Object) this.sold, (Object) standardProductSearchData.sold) || !equals((Object) this.spu_label, (Object) standardProductSearchData.spu_label) || !equals((Object) this.num_of_seller, (Object) standardProductSearchData.num_of_seller) || !equals((Object) this.country, (Object) standardProductSearchData.country) || !equals((Object) this.status, (Object) standardProductSearchData.status) || !equals((Object) this.calc_average_price, (Object) standardProductSearchData.calc_average_price) || !equals((Object) this.calc_sold_count, (Object) standardProductSearchData.calc_sold_count) || !equals((Object) this.calc_seller_count, (Object) standardProductSearchData.calc_seller_count)) {
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
        Long l3 = this.average_price;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.sold;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.spu_label;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Long l5 = this.num_of_seller;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l6 = this.calc_average_price;
        int hashCode9 = (hashCode8 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.calc_sold_count;
        int hashCode10 = (hashCode9 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.calc_seller_count;
        if (l8 != null) {
            i2 = l8.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StandardProductSearchData> {
        public Long average_price;
        public Long calc_average_price;
        public Long calc_seller_count;
        public Long calc_sold_count;
        public String country;
        public Long id;
        public Long num_of_seller;
        public Long sold;
        public Long spu_id;
        public Integer spu_label;
        public Integer status;

        public Builder() {
        }

        public Builder(StandardProductSearchData standardProductSearchData) {
            super(standardProductSearchData);
            if (standardProductSearchData != null) {
                this.id = standardProductSearchData.id;
                this.spu_id = standardProductSearchData.spu_id;
                this.average_price = standardProductSearchData.average_price;
                this.sold = standardProductSearchData.sold;
                this.spu_label = standardProductSearchData.spu_label;
                this.num_of_seller = standardProductSearchData.num_of_seller;
                this.country = standardProductSearchData.country;
                this.status = standardProductSearchData.status;
                this.calc_average_price = standardProductSearchData.calc_average_price;
                this.calc_sold_count = standardProductSearchData.calc_sold_count;
                this.calc_seller_count = standardProductSearchData.calc_seller_count;
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

        public Builder average_price(Long l) {
            this.average_price = l;
            return this;
        }

        public Builder sold(Long l) {
            this.sold = l;
            return this;
        }

        public Builder spu_label(Integer num) {
            this.spu_label = num;
            return this;
        }

        public Builder num_of_seller(Long l) {
            this.num_of_seller = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder calc_average_price(Long l) {
            this.calc_average_price = l;
            return this;
        }

        public Builder calc_sold_count(Long l) {
            this.calc_sold_count = l;
            return this;
        }

        public Builder calc_seller_count(Long l) {
            this.calc_seller_count = l;
            return this;
        }

        public StandardProductSearchData build() {
            return new StandardProductSearchData(this);
        }
    }
}
