package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexSpuAttributeValue extends Message {
    public static final String DEFAULT_VALUE = "";
    public static final List<LanguageValue> DEFAULT_VALUE_ALIAS = Collections.emptyList();
    public static final Long DEFAULT_VALUE_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;
    @ProtoField(label = Message.Label.REPEATED, messageType = LanguageValue.class, tag = 3)
    public final List<LanguageValue> value_alias;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long value_id;

    public SearchIndexSpuAttributeValue(Long l, String str, List<LanguageValue> list) {
        this.value_id = l;
        this.value = str;
        this.value_alias = immutableCopyOf(list);
    }

    private SearchIndexSpuAttributeValue(Builder builder) {
        this(builder.value_id, builder.value, builder.value_alias);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexSpuAttributeValue)) {
            return false;
        }
        SearchIndexSpuAttributeValue searchIndexSpuAttributeValue = (SearchIndexSpuAttributeValue) obj;
        if (!equals((Object) this.value_id, (Object) searchIndexSpuAttributeValue.value_id) || !equals((Object) this.value, (Object) searchIndexSpuAttributeValue.value) || !equals((List<?>) this.value_alias, (List<?>) searchIndexSpuAttributeValue.value_alias)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.value_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.value;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<LanguageValue> list = this.value_alias;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SearchIndexSpuAttributeValue> {
        public String value;
        public List<LanguageValue> value_alias;
        public Long value_id;

        public Builder() {
        }

        public Builder(SearchIndexSpuAttributeValue searchIndexSpuAttributeValue) {
            super(searchIndexSpuAttributeValue);
            if (searchIndexSpuAttributeValue != null) {
                this.value_id = searchIndexSpuAttributeValue.value_id;
                this.value = searchIndexSpuAttributeValue.value;
                this.value_alias = SearchIndexSpuAttributeValue.copyOf(searchIndexSpuAttributeValue.value_alias);
            }
        }

        public Builder value_id(Long l) {
            this.value_id = l;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Builder value_alias(List<LanguageValue> list) {
            this.value_alias = checkForNulls(list);
            return this;
        }

        public SearchIndexSpuAttributeValue build() {
            return new SearchIndexSpuAttributeValue(this);
        }
    }
}
