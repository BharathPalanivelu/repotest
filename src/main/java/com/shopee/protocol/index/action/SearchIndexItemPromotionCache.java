package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexItemPromotionCache extends Message {
    public static final List<Long> DEFAULT_DISABLE_PROMOTION_ID = Collections.emptyList();
    public static final List<Long> DEFAULT_ENABLE_PROMOTION_ID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> disable_promotion_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> enable_promotion_id;

    public SearchIndexItemPromotionCache(List<Long> list, List<Long> list2) {
        this.enable_promotion_id = immutableCopyOf(list);
        this.disable_promotion_id = immutableCopyOf(list2);
    }

    private SearchIndexItemPromotionCache(Builder builder) {
        this(builder.enable_promotion_id, builder.disable_promotion_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemPromotionCache)) {
            return false;
        }
        SearchIndexItemPromotionCache searchIndexItemPromotionCache = (SearchIndexItemPromotionCache) obj;
        if (!equals((List<?>) this.enable_promotion_id, (List<?>) searchIndexItemPromotionCache.enable_promotion_id) || !equals((List<?>) this.disable_promotion_id, (List<?>) searchIndexItemPromotionCache.disable_promotion_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.enable_promotion_id;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Long> list2 = this.disable_promotion_id;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemPromotionCache> {
        public List<Long> disable_promotion_id;
        public List<Long> enable_promotion_id;

        public Builder() {
        }

        public Builder(SearchIndexItemPromotionCache searchIndexItemPromotionCache) {
            super(searchIndexItemPromotionCache);
            if (searchIndexItemPromotionCache != null) {
                this.enable_promotion_id = SearchIndexItemPromotionCache.copyOf(searchIndexItemPromotionCache.enable_promotion_id);
                this.disable_promotion_id = SearchIndexItemPromotionCache.copyOf(searchIndexItemPromotionCache.disable_promotion_id);
            }
        }

        public Builder enable_promotion_id(List<Long> list) {
            this.enable_promotion_id = checkForNulls(list);
            return this;
        }

        public Builder disable_promotion_id(List<Long> list) {
            this.disable_promotion_id = checkForNulls(list);
            return this;
        }

        public SearchIndexItemPromotionCache build() {
            return new SearchIndexItemPromotionCache(this);
        }
    }
}
