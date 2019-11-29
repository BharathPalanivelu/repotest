package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.AttributeAlias;
import com.shopee.protocol.shop.CountryCat;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexSpuAttribute extends Message {
    public static final List<AttrValuePair> DEFAULT_ATTR_IDS = Collections.emptyList();
    public static final List<CountryCat> DEFAULT_CATS = Collections.emptyList();
    public static final String DEFAULT_COVER_IMG = "";
    public static final List<CountryLabel> DEFAULT_LABELS = Collections.emptyList();
    public static final Long DEFAULT_RELEASE_DATE = 0L;
    public static final List<CountrySearchTerms> DEFAULT_SEARCH_TERMS = Collections.emptyList();
    public static final String DEFAULT_SELLING_POINT = "";
    public static final Long DEFAULT_SPUID = 0L;
    public static final String DEFAULT_SPU_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final AttributeAlias alias;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttrValuePair.class, tag = 8)
    public final List<AttrValuePair> attr_ids;
    @ProtoField(label = Message.Label.REPEATED, messageType = CountryCat.class, tag = 11)
    public final List<CountryCat> cats;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String cover_img;
    @ProtoField(label = Message.Label.REPEATED, messageType = CountryLabel.class, tag = 10)
    public final List<CountryLabel> labels;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long release_date;
    @ProtoField(label = Message.Label.REPEATED, messageType = CountrySearchTerms.class, tag = 9)
    public final List<CountrySearchTerms> search_terms;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String selling_point;
    @ProtoField(tag = 7)
    public final AttributeAlias selling_point_alias;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String spu_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long spuid;

    public SearchIndexSpuAttribute(Long l, String str, String str2, Long l2, AttributeAlias attributeAlias, String str3, AttributeAlias attributeAlias2, List<AttrValuePair> list, List<CountrySearchTerms> list2, List<CountryLabel> list3, List<CountryCat> list4) {
        this.spuid = l;
        this.spu_name = str;
        this.cover_img = str2;
        this.release_date = l2;
        this.alias = attributeAlias;
        this.selling_point = str3;
        this.selling_point_alias = attributeAlias2;
        this.attr_ids = immutableCopyOf(list);
        this.search_terms = immutableCopyOf(list2);
        this.labels = immutableCopyOf(list3);
        this.cats = immutableCopyOf(list4);
    }

    private SearchIndexSpuAttribute(Builder builder) {
        this(builder.spuid, builder.spu_name, builder.cover_img, builder.release_date, builder.alias, builder.selling_point, builder.selling_point_alias, builder.attr_ids, builder.search_terms, builder.labels, builder.cats);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexSpuAttribute)) {
            return false;
        }
        SearchIndexSpuAttribute searchIndexSpuAttribute = (SearchIndexSpuAttribute) obj;
        if (!equals((Object) this.spuid, (Object) searchIndexSpuAttribute.spuid) || !equals((Object) this.spu_name, (Object) searchIndexSpuAttribute.spu_name) || !equals((Object) this.cover_img, (Object) searchIndexSpuAttribute.cover_img) || !equals((Object) this.release_date, (Object) searchIndexSpuAttribute.release_date) || !equals((Object) this.alias, (Object) searchIndexSpuAttribute.alias) || !equals((Object) this.selling_point, (Object) searchIndexSpuAttribute.selling_point) || !equals((Object) this.selling_point_alias, (Object) searchIndexSpuAttribute.selling_point_alias) || !equals((List<?>) this.attr_ids, (List<?>) searchIndexSpuAttribute.attr_ids) || !equals((List<?>) this.search_terms, (List<?>) searchIndexSpuAttribute.search_terms) || !equals((List<?>) this.labels, (List<?>) searchIndexSpuAttribute.labels) || !equals((List<?>) this.cats, (List<?>) searchIndexSpuAttribute.cats)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.spuid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.spu_name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.cover_img;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.release_date;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        AttributeAlias attributeAlias = this.alias;
        int hashCode5 = (hashCode4 + (attributeAlias != null ? attributeAlias.hashCode() : 0)) * 37;
        String str3 = this.selling_point;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        AttributeAlias attributeAlias2 = this.selling_point_alias;
        if (attributeAlias2 != null) {
            i2 = attributeAlias2.hashCode();
        }
        int i3 = (hashCode6 + i2) * 37;
        List<AttrValuePair> list = this.attr_ids;
        int i4 = 1;
        int hashCode7 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<CountrySearchTerms> list2 = this.search_terms;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<CountryLabel> list3 = this.labels;
        int hashCode9 = (hashCode8 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<CountryCat> list4 = this.cats;
        if (list4 != null) {
            i4 = list4.hashCode();
        }
        int i5 = hashCode9 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchIndexSpuAttribute> {
        public AttributeAlias alias;
        public List<AttrValuePair> attr_ids;
        public List<CountryCat> cats;
        public String cover_img;
        public List<CountryLabel> labels;
        public Long release_date;
        public List<CountrySearchTerms> search_terms;
        public String selling_point;
        public AttributeAlias selling_point_alias;
        public String spu_name;
        public Long spuid;

        public Builder() {
        }

        public Builder(SearchIndexSpuAttribute searchIndexSpuAttribute) {
            super(searchIndexSpuAttribute);
            if (searchIndexSpuAttribute != null) {
                this.spuid = searchIndexSpuAttribute.spuid;
                this.spu_name = searchIndexSpuAttribute.spu_name;
                this.cover_img = searchIndexSpuAttribute.cover_img;
                this.release_date = searchIndexSpuAttribute.release_date;
                this.alias = searchIndexSpuAttribute.alias;
                this.selling_point = searchIndexSpuAttribute.selling_point;
                this.selling_point_alias = searchIndexSpuAttribute.selling_point_alias;
                this.attr_ids = SearchIndexSpuAttribute.copyOf(searchIndexSpuAttribute.attr_ids);
                this.search_terms = SearchIndexSpuAttribute.copyOf(searchIndexSpuAttribute.search_terms);
                this.labels = SearchIndexSpuAttribute.copyOf(searchIndexSpuAttribute.labels);
                this.cats = SearchIndexSpuAttribute.copyOf(searchIndexSpuAttribute.cats);
            }
        }

        public Builder spuid(Long l) {
            this.spuid = l;
            return this;
        }

        public Builder spu_name(String str) {
            this.spu_name = str;
            return this;
        }

        public Builder cover_img(String str) {
            this.cover_img = str;
            return this;
        }

        public Builder release_date(Long l) {
            this.release_date = l;
            return this;
        }

        public Builder alias(AttributeAlias attributeAlias) {
            this.alias = attributeAlias;
            return this;
        }

        public Builder selling_point(String str) {
            this.selling_point = str;
            return this;
        }

        public Builder selling_point_alias(AttributeAlias attributeAlias) {
            this.selling_point_alias = attributeAlias;
            return this;
        }

        public Builder attr_ids(List<AttrValuePair> list) {
            this.attr_ids = checkForNulls(list);
            return this;
        }

        public Builder search_terms(List<CountrySearchTerms> list) {
            this.search_terms = checkForNulls(list);
            return this;
        }

        public Builder labels(List<CountryLabel> list) {
            this.labels = checkForNulls(list);
            return this;
        }

        public Builder cats(List<CountryCat> list) {
            this.cats = checkForNulls(list);
            return this;
        }

        public SearchIndexSpuAttribute build() {
            return new SearchIndexSpuAttribute(this);
        }
    }
}
