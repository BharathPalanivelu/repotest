package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class StandardProductExtInfo extends Message {
    public static final List<CountryCat> DEFAULT_CATS = Collections.emptyList();
    public static final Long DEFAULT_REFERENCE_SPU_ID = 0L;
    public static final String DEFAULT_SELLING_POINT = "";
    public static final List<SPUSynonym> DEFAULT_SYNONYMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final AttributeAlias alias;
    @ProtoField(label = Message.Label.REPEATED, messageType = CountryCat.class, tag = 5)
    public final List<CountryCat> cats;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long reference_spu_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String selling_point;
    @ProtoField(tag = 4)
    public final AttributeAlias selling_point_alias;
    @ProtoField(label = Message.Label.REPEATED, messageType = SPUSynonym.class, tag = 6)
    public final List<SPUSynonym> synonyms;

    public StandardProductExtInfo(Long l, AttributeAlias attributeAlias, String str, AttributeAlias attributeAlias2, List<CountryCat> list, List<SPUSynonym> list2) {
        this.reference_spu_id = l;
        this.alias = attributeAlias;
        this.selling_point = str;
        this.selling_point_alias = attributeAlias2;
        this.cats = immutableCopyOf(list);
        this.synonyms = immutableCopyOf(list2);
    }

    private StandardProductExtInfo(Builder builder) {
        this(builder.reference_spu_id, builder.alias, builder.selling_point, builder.selling_point_alias, builder.cats, builder.synonyms);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardProductExtInfo)) {
            return false;
        }
        StandardProductExtInfo standardProductExtInfo = (StandardProductExtInfo) obj;
        if (!equals((Object) this.reference_spu_id, (Object) standardProductExtInfo.reference_spu_id) || !equals((Object) this.alias, (Object) standardProductExtInfo.alias) || !equals((Object) this.selling_point, (Object) standardProductExtInfo.selling_point) || !equals((Object) this.selling_point_alias, (Object) standardProductExtInfo.selling_point_alias) || !equals((List<?>) this.cats, (List<?>) standardProductExtInfo.cats) || !equals((List<?>) this.synonyms, (List<?>) standardProductExtInfo.synonyms)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.reference_spu_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        AttributeAlias attributeAlias = this.alias;
        int hashCode2 = (hashCode + (attributeAlias != null ? attributeAlias.hashCode() : 0)) * 37;
        String str = this.selling_point;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        AttributeAlias attributeAlias2 = this.selling_point_alias;
        if (attributeAlias2 != null) {
            i2 = attributeAlias2.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<CountryCat> list = this.cats;
        int i4 = 1;
        int hashCode4 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<SPUSynonym> list2 = this.synonyms;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode4 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<StandardProductExtInfo> {
        public AttributeAlias alias;
        public List<CountryCat> cats;
        public Long reference_spu_id;
        public String selling_point;
        public AttributeAlias selling_point_alias;
        public List<SPUSynonym> synonyms;

        public Builder() {
        }

        public Builder(StandardProductExtInfo standardProductExtInfo) {
            super(standardProductExtInfo);
            if (standardProductExtInfo != null) {
                this.reference_spu_id = standardProductExtInfo.reference_spu_id;
                this.alias = standardProductExtInfo.alias;
                this.selling_point = standardProductExtInfo.selling_point;
                this.selling_point_alias = standardProductExtInfo.selling_point_alias;
                this.cats = StandardProductExtInfo.copyOf(standardProductExtInfo.cats);
                this.synonyms = StandardProductExtInfo.copyOf(standardProductExtInfo.synonyms);
            }
        }

        public Builder reference_spu_id(Long l) {
            this.reference_spu_id = l;
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

        public Builder cats(List<CountryCat> list) {
            this.cats = checkForNulls(list);
            return this;
        }

        public Builder synonyms(List<SPUSynonym> list) {
            this.synonyms = checkForNulls(list);
            return this;
        }

        public StandardProductExtInfo build() {
            return new StandardProductExtInfo(this);
        }
    }
}
