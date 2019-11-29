package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.StandardProduct;
import com.shopee.protocol.shop.StandardProductSearchData;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SearchSpuJob extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final String DEFAULT_SOURCE = "";
    public static final Long DEFAULT_SPUID = 0L;
    public static final String DEFAULT_TERM = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5)
    public final StandardProductSearchData data;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 4)
    public final StandardProduct spu;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long spuid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String term;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public SearchSpuJob(Integer num, Long l, String str, StandardProduct standardProduct, StandardProductSearchData standardProductSearchData, String str2, String str3, f fVar) {
        this.type = num;
        this.spuid = l;
        this.country = str;
        this.spu = standardProduct;
        this.data = standardProductSearchData;
        this.term = str2;
        this.source = str3;
        this.raw_ctx = fVar;
    }

    private SearchSpuJob(Builder builder) {
        this(builder.type, builder.spuid, builder.country, builder.spu, builder.data, builder.term, builder.source, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchSpuJob)) {
            return false;
        }
        SearchSpuJob searchSpuJob = (SearchSpuJob) obj;
        if (!equals((Object) this.type, (Object) searchSpuJob.type) || !equals((Object) this.spuid, (Object) searchSpuJob.spuid) || !equals((Object) this.country, (Object) searchSpuJob.country) || !equals((Object) this.spu, (Object) searchSpuJob.spu) || !equals((Object) this.data, (Object) searchSpuJob.data) || !equals((Object) this.term, (Object) searchSpuJob.term) || !equals((Object) this.source, (Object) searchSpuJob.source) || !equals((Object) this.raw_ctx, (Object) searchSpuJob.raw_ctx)) {
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
        Long l = this.spuid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        StandardProduct standardProduct = this.spu;
        int hashCode4 = (hashCode3 + (standardProduct != null ? standardProduct.hashCode() : 0)) * 37;
        StandardProductSearchData standardProductSearchData = this.data;
        int hashCode5 = (hashCode4 + (standardProductSearchData != null ? standardProductSearchData.hashCode() : 0)) * 37;
        String str2 = this.term;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.source;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchSpuJob> {
        public String country;
        public StandardProductSearchData data;
        public f raw_ctx;
        public String source;
        public StandardProduct spu;
        public Long spuid;
        public String term;
        public Integer type;

        public Builder() {
        }

        public Builder(SearchSpuJob searchSpuJob) {
            super(searchSpuJob);
            if (searchSpuJob != null) {
                this.type = searchSpuJob.type;
                this.spuid = searchSpuJob.spuid;
                this.country = searchSpuJob.country;
                this.spu = searchSpuJob.spu;
                this.data = searchSpuJob.data;
                this.term = searchSpuJob.term;
                this.source = searchSpuJob.source;
                this.raw_ctx = searchSpuJob.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder spuid(Long l) {
            this.spuid = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
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

        public Builder term(String str) {
            this.term = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public SearchSpuJob build() {
            return new SearchSpuJob(this);
        }
    }
}
