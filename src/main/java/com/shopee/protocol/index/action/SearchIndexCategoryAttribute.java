package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexCategoryAttribute extends Message {
    public static final List<Integer> DEFAULT_BLOCK_BUYER_PLATFORM = Collections.emptyList();
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final Integer DEFAULT_IS_ADULT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> block_buyer_platform;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String display_name;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer is_adult;

    public SearchIndexCategoryAttribute(Integer num, String str, Integer num2, List<Integer> list) {
        this.catid = num;
        this.display_name = str;
        this.is_adult = num2;
        this.block_buyer_platform = immutableCopyOf(list);
    }

    private SearchIndexCategoryAttribute(Builder builder) {
        this(builder.catid, builder.display_name, builder.is_adult, builder.block_buyer_platform);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexCategoryAttribute)) {
            return false;
        }
        SearchIndexCategoryAttribute searchIndexCategoryAttribute = (SearchIndexCategoryAttribute) obj;
        if (!equals((Object) this.catid, (Object) searchIndexCategoryAttribute.catid) || !equals((Object) this.display_name, (Object) searchIndexCategoryAttribute.display_name) || !equals((Object) this.is_adult, (Object) searchIndexCategoryAttribute.is_adult) || !equals((List<?>) this.block_buyer_platform, (List<?>) searchIndexCategoryAttribute.block_buyer_platform)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.catid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.display_name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.is_adult;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<Integer> list = this.block_buyer_platform;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<SearchIndexCategoryAttribute> {
        public List<Integer> block_buyer_platform;
        public Integer catid;
        public String display_name;
        public Integer is_adult;

        public Builder() {
        }

        public Builder(SearchIndexCategoryAttribute searchIndexCategoryAttribute) {
            super(searchIndexCategoryAttribute);
            if (searchIndexCategoryAttribute != null) {
                this.catid = searchIndexCategoryAttribute.catid;
                this.display_name = searchIndexCategoryAttribute.display_name;
                this.is_adult = searchIndexCategoryAttribute.is_adult;
                this.block_buyer_platform = SearchIndexCategoryAttribute.copyOf(searchIndexCategoryAttribute.block_buyer_platform);
            }
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder display_name(String str) {
            this.display_name = str;
            return this;
        }

        public Builder is_adult(Integer num) {
            this.is_adult = num;
            return this;
        }

        public Builder block_buyer_platform(List<Integer> list) {
            this.block_buyer_platform = checkForNulls(list);
            return this;
        }

        public SearchIndexCategoryAttribute build() {
            return new SearchIndexCategoryAttribute(this);
        }
    }
}
