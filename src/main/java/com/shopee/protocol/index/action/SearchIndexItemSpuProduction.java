package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.SpuProductionItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexItemSpuProduction extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final SpuProductionItem spu_item;

    public SearchIndexItemSpuProduction(SpuProductionItem spuProductionItem) {
        this.spu_item = spuProductionItem;
    }

    private SearchIndexItemSpuProduction(Builder builder) {
        this(builder.spu_item);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemSpuProduction)) {
            return false;
        }
        return equals((Object) this.spu_item, (Object) ((SearchIndexItemSpuProduction) obj).spu_item);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            SpuProductionItem spuProductionItem = this.spu_item;
            i = spuProductionItem != null ? spuProductionItem.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemSpuProduction> {
        public SpuProductionItem spu_item;

        public Builder() {
        }

        public Builder(SearchIndexItemSpuProduction searchIndexItemSpuProduction) {
            super(searchIndexItemSpuProduction);
            if (searchIndexItemSpuProduction != null) {
                this.spu_item = searchIndexItemSpuProduction.spu_item;
            }
        }

        public Builder spu_item(SpuProductionItem spuProductionItem) {
            this.spu_item = spuProductionItem;
            return this;
        }

        public SearchIndexItemSpuProduction build() {
            return new SearchIndexItemSpuProduction(this);
        }
    }
}
