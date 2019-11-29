package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexSpuAttributeKey extends Message {
    public static final Long DEFAULT_ATTR_ID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_SORTING = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long attr_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long sorting;

    public SearchIndexSpuAttributeKey(Long l, Long l2, String str) {
        this.attr_id = l;
        this.sorting = l2;
        this.country = str;
    }

    private SearchIndexSpuAttributeKey(Builder builder) {
        this(builder.attr_id, builder.sorting, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexSpuAttributeKey)) {
            return false;
        }
        SearchIndexSpuAttributeKey searchIndexSpuAttributeKey = (SearchIndexSpuAttributeKey) obj;
        if (!equals((Object) this.attr_id, (Object) searchIndexSpuAttributeKey.attr_id) || !equals((Object) this.sorting, (Object) searchIndexSpuAttributeKey.sorting) || !equals((Object) this.country, (Object) searchIndexSpuAttributeKey.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.attr_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.sorting;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexSpuAttributeKey> {
        public Long attr_id;
        public String country;
        public Long sorting;

        public Builder() {
        }

        public Builder(SearchIndexSpuAttributeKey searchIndexSpuAttributeKey) {
            super(searchIndexSpuAttributeKey);
            if (searchIndexSpuAttributeKey != null) {
                this.attr_id = searchIndexSpuAttributeKey.attr_id;
                this.sorting = searchIndexSpuAttributeKey.sorting;
                this.country = searchIndexSpuAttributeKey.country;
            }
        }

        public Builder attr_id(Long l) {
            this.attr_id = l;
            return this;
        }

        public Builder sorting(Long l) {
            this.sorting = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SearchIndexSpuAttributeKey build() {
            return new SearchIndexSpuAttributeKey(this);
        }
    }
}
