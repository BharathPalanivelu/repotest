package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.ShopCollection;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexShopCollection extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ShopCollection shopcollection;

    public SearchIndexShopCollection(ShopCollection shopCollection) {
        this.shopcollection = shopCollection;
    }

    private SearchIndexShopCollection(Builder builder) {
        this(builder.shopcollection);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexShopCollection)) {
            return false;
        }
        return equals((Object) this.shopcollection, (Object) ((SearchIndexShopCollection) obj).shopcollection);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ShopCollection shopCollection = this.shopcollection;
            i = shopCollection != null ? shopCollection.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchIndexShopCollection> {
        public ShopCollection shopcollection;

        public Builder() {
        }

        public Builder(SearchIndexShopCollection searchIndexShopCollection) {
            super(searchIndexShopCollection);
            if (searchIndexShopCollection != null) {
                this.shopcollection = searchIndexShopCollection.shopcollection;
            }
        }

        public Builder shopcollection(ShopCollection shopCollection) {
            this.shopcollection = shopCollection;
            return this;
        }

        public SearchIndexShopCollection build() {
            return new SearchIndexShopCollection(this);
        }
    }
}
