package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class RecommendKeyword extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final f DEFAULT_DEBUGINFO = f.f32736b;
    public static final Boolean DEFAULT_IS_DEFAULT = false;
    public static final Boolean DEFAULT_IS_RESERVED = false;
    public static final String DEFAULT_KEYWORD = "";
    public static final Long DEFAULT_RECOMMEND_PRICE = 0L;
    public static final Integer DEFAULT_RELEVANCE = 0;
    public static final Integer DEFAULT_SEARCH_VOLUME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f debuginfo;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_default;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_reserved;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long recommend_price;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer relevance;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer search_volume;

    public RecommendKeyword(String str, Integer num, Long l, Integer num2, Boolean bool, f fVar, String str2, Boolean bool2) {
        this.keyword = str;
        this.search_volume = num;
        this.recommend_price = l;
        this.relevance = num2;
        this.is_default = bool;
        this.debuginfo = fVar;
        this.algorithm = str2;
        this.is_reserved = bool2;
    }

    private RecommendKeyword(Builder builder) {
        this(builder.keyword, builder.search_volume, builder.recommend_price, builder.relevance, builder.is_default, builder.debuginfo, builder.algorithm, builder.is_reserved);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecommendKeyword)) {
            return false;
        }
        RecommendKeyword recommendKeyword = (RecommendKeyword) obj;
        if (!equals((Object) this.keyword, (Object) recommendKeyword.keyword) || !equals((Object) this.search_volume, (Object) recommendKeyword.search_volume) || !equals((Object) this.recommend_price, (Object) recommendKeyword.recommend_price) || !equals((Object) this.relevance, (Object) recommendKeyword.relevance) || !equals((Object) this.is_default, (Object) recommendKeyword.is_default) || !equals((Object) this.debuginfo, (Object) recommendKeyword.debuginfo) || !equals((Object) this.algorithm, (Object) recommendKeyword.algorithm) || !equals((Object) this.is_reserved, (Object) recommendKeyword.is_reserved)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keyword;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.search_volume;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.recommend_price;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.relevance;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.is_default;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        f fVar = this.debuginfo;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.algorithm;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_reserved;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RecommendKeyword> {
        public String algorithm;
        public f debuginfo;
        public Boolean is_default;
        public Boolean is_reserved;
        public String keyword;
        public Long recommend_price;
        public Integer relevance;
        public Integer search_volume;

        public Builder() {
        }

        public Builder(RecommendKeyword recommendKeyword) {
            super(recommendKeyword);
            if (recommendKeyword != null) {
                this.keyword = recommendKeyword.keyword;
                this.search_volume = recommendKeyword.search_volume;
                this.recommend_price = recommendKeyword.recommend_price;
                this.relevance = recommendKeyword.relevance;
                this.is_default = recommendKeyword.is_default;
                this.debuginfo = recommendKeyword.debuginfo;
                this.algorithm = recommendKeyword.algorithm;
                this.is_reserved = recommendKeyword.is_reserved;
            }
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder search_volume(Integer num) {
            this.search_volume = num;
            return this;
        }

        public Builder recommend_price(Long l) {
            this.recommend_price = l;
            return this;
        }

        public Builder relevance(Integer num) {
            this.relevance = num;
            return this;
        }

        public Builder is_default(Boolean bool) {
            this.is_default = bool;
            return this;
        }

        public Builder debuginfo(f fVar) {
            this.debuginfo = fVar;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder is_reserved(Boolean bool) {
            this.is_reserved = bool;
            return this;
        }

        public RecommendKeyword build() {
            return new RecommendKeyword(this);
        }
    }
}
