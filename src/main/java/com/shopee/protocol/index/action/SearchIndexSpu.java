package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.StandardProduct;
import com.shopee.protocol.shop.StandardProductSearchData;
import com.shopee.protocol.shop.StandardProductSearchTerm;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexSpu extends Message {
    public static final Long DEFAULT_DATA_TYPE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final StandardProductSearchData data;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long data_type;
    @ProtoField(tag = 2)
    public final StandardProduct spu;
    @ProtoField(tag = 4)
    public final StandardProductSearchTerm term;

    public SearchIndexSpu(Long l, StandardProduct standardProduct, StandardProductSearchData standardProductSearchData, StandardProductSearchTerm standardProductSearchTerm) {
        this.data_type = l;
        this.spu = standardProduct;
        this.data = standardProductSearchData;
        this.term = standardProductSearchTerm;
    }

    private SearchIndexSpu(Builder builder) {
        this(builder.data_type, builder.spu, builder.data, builder.term);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexSpu)) {
            return false;
        }
        SearchIndexSpu searchIndexSpu = (SearchIndexSpu) obj;
        if (!equals((Object) this.data_type, (Object) searchIndexSpu.data_type) || !equals((Object) this.spu, (Object) searchIndexSpu.spu) || !equals((Object) this.data, (Object) searchIndexSpu.data) || !equals((Object) this.term, (Object) searchIndexSpu.term)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.data_type;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        StandardProduct standardProduct = this.spu;
        int hashCode2 = (hashCode + (standardProduct != null ? standardProduct.hashCode() : 0)) * 37;
        StandardProductSearchData standardProductSearchData = this.data;
        int hashCode3 = (hashCode2 + (standardProductSearchData != null ? standardProductSearchData.hashCode() : 0)) * 37;
        StandardProductSearchTerm standardProductSearchTerm = this.term;
        if (standardProductSearchTerm != null) {
            i2 = standardProductSearchTerm.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexSpu> {
        public StandardProductSearchData data;
        public Long data_type;
        public StandardProduct spu;
        public StandardProductSearchTerm term;

        public Builder() {
        }

        public Builder(SearchIndexSpu searchIndexSpu) {
            super(searchIndexSpu);
            if (searchIndexSpu != null) {
                this.data_type = searchIndexSpu.data_type;
                this.spu = searchIndexSpu.spu;
                this.data = searchIndexSpu.data;
                this.term = searchIndexSpu.term;
            }
        }

        public Builder data_type(Long l) {
            this.data_type = l;
            return this;
        }

        public Builder spu(StandardProduct standardProduct) {
            this.spu = standardProduct;
            return this;
        }

        public Builder data(StandardProductSearchData standardProductSearchData) {
            this.data = standardProductSearchData;
            return this;
        }

        public Builder term(StandardProductSearchTerm standardProductSearchTerm) {
            this.term = standardProductSearchTerm;
            return this;
        }

        public SearchIndexSpu build() {
            return new SearchIndexSpu(this);
        }
    }
}
