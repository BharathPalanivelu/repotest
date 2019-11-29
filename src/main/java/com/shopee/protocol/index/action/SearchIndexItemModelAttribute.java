package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexItemModelAttribute extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<ItemModel> DEFAULT_MODELS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 2)
    public final List<ItemModel> models;

    public SearchIndexItemModelAttribute(Long l, List<ItemModel> list) {
        this.itemid = l;
        this.models = immutableCopyOf(list);
    }

    private SearchIndexItemModelAttribute(Builder builder) {
        this(builder.itemid, builder.models);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemModelAttribute)) {
            return false;
        }
        SearchIndexItemModelAttribute searchIndexItemModelAttribute = (SearchIndexItemModelAttribute) obj;
        if (!equals((Object) this.itemid, (Object) searchIndexItemModelAttribute.itemid) || !equals((List<?>) this.models, (List<?>) searchIndexItemModelAttribute.models)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<ItemModel> list = this.models;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemModelAttribute> {
        public Long itemid;
        public List<ItemModel> models;

        public Builder() {
        }

        public Builder(SearchIndexItemModelAttribute searchIndexItemModelAttribute) {
            super(searchIndexItemModelAttribute);
            if (searchIndexItemModelAttribute != null) {
                this.itemid = searchIndexItemModelAttribute.itemid;
                this.models = SearchIndexItemModelAttribute.copyOf(searchIndexItemModelAttribute.models);
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder models(List<ItemModel> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public SearchIndexItemModelAttribute build() {
            return new SearchIndexItemModelAttribute(this);
        }
    }
}
