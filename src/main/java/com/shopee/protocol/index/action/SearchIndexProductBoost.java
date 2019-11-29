package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ProductListBoost;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexProductBoost extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final Item item;
    @ProtoField(tag = 1)
    public final ProductListBoost product_boost;

    public SearchIndexProductBoost(ProductListBoost productListBoost, Item item2) {
        this.product_boost = productListBoost;
        this.item = item2;
    }

    private SearchIndexProductBoost(Builder builder) {
        this(builder.product_boost, builder.item);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexProductBoost)) {
            return false;
        }
        SearchIndexProductBoost searchIndexProductBoost = (SearchIndexProductBoost) obj;
        if (!equals((Object) this.product_boost, (Object) searchIndexProductBoost.product_boost) || !equals((Object) this.item, (Object) searchIndexProductBoost.item)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ProductListBoost productListBoost = this.product_boost;
        int i2 = 0;
        int hashCode = (productListBoost != null ? productListBoost.hashCode() : 0) * 37;
        Item item2 = this.item;
        if (item2 != null) {
            i2 = item2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexProductBoost> {
        public Item item;
        public ProductListBoost product_boost;

        public Builder() {
        }

        public Builder(SearchIndexProductBoost searchIndexProductBoost) {
            super(searchIndexProductBoost);
            if (searchIndexProductBoost != null) {
                this.product_boost = searchIndexProductBoost.product_boost;
                this.item = searchIndexProductBoost.item;
            }
        }

        public Builder product_boost(ProductListBoost productListBoost) {
            this.product_boost = productListBoost;
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public SearchIndexProductBoost build() {
            return new SearchIndexProductBoost(this);
        }
    }
}
