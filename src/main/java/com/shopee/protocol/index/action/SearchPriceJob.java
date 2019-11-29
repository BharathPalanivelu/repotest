package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SearchPriceJob extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_DISCOUNT = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MAX_PRICE = 0L;
    public static final Long DEFAULT_MIN_PRICE = 0L;
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STOCK = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long discount;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long max_price;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long min_price;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer stock;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public SearchPriceJob(Integer num, Long l, Integer num2, String str, Integer num3, Long l2, Long l3, Long l4, f fVar) {
        this.type = num;
        this.itemid = l;
        this.shopid = num2;
        this.country = str;
        this.stock = num3;
        this.min_price = l2;
        this.max_price = l3;
        this.discount = l4;
        this.raw_ctx = fVar;
    }

    private SearchPriceJob(Builder builder) {
        this(builder.type, builder.itemid, builder.shopid, builder.country, builder.stock, builder.min_price, builder.max_price, builder.discount, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchPriceJob)) {
            return false;
        }
        SearchPriceJob searchPriceJob = (SearchPriceJob) obj;
        if (!equals((Object) this.type, (Object) searchPriceJob.type) || !equals((Object) this.itemid, (Object) searchPriceJob.itemid) || !equals((Object) this.shopid, (Object) searchPriceJob.shopid) || !equals((Object) this.country, (Object) searchPriceJob.country) || !equals((Object) this.stock, (Object) searchPriceJob.stock) || !equals((Object) this.min_price, (Object) searchPriceJob.min_price) || !equals((Object) this.max_price, (Object) searchPriceJob.max_price) || !equals((Object) this.discount, (Object) searchPriceJob.discount) || !equals((Object) this.raw_ctx, (Object) searchPriceJob.raw_ctx)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.stock;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.min_price;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.max_price;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.discount;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchPriceJob> {
        public String country;
        public Long discount;
        public Long itemid;
        public Long max_price;
        public Long min_price;
        public f raw_ctx;
        public Integer shopid;
        public Integer stock;
        public Integer type;

        public Builder() {
        }

        public Builder(SearchPriceJob searchPriceJob) {
            super(searchPriceJob);
            if (searchPriceJob != null) {
                this.type = searchPriceJob.type;
                this.itemid = searchPriceJob.itemid;
                this.shopid = searchPriceJob.shopid;
                this.country = searchPriceJob.country;
                this.stock = searchPriceJob.stock;
                this.min_price = searchPriceJob.min_price;
                this.max_price = searchPriceJob.max_price;
                this.discount = searchPriceJob.discount;
                this.raw_ctx = searchPriceJob.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public Builder min_price(Long l) {
            this.min_price = l;
            return this;
        }

        public Builder max_price(Long l) {
            this.max_price = l;
            return this;
        }

        public Builder discount(Long l) {
            this.discount = l;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public SearchPriceJob build() {
            return new SearchPriceJob(this);
        }
    }
}
