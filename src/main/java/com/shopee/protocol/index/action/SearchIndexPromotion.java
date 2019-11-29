package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Promotion;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexPromotion extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Promotion promotion;

    public SearchIndexPromotion(Promotion promotion2) {
        this.promotion = promotion2;
    }

    private SearchIndexPromotion(Builder builder) {
        this(builder.promotion);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexPromotion)) {
            return false;
        }
        return equals((Object) this.promotion, (Object) ((SearchIndexPromotion) obj).promotion);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Promotion promotion2 = this.promotion;
            i = promotion2 != null ? promotion2.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchIndexPromotion> {
        public Promotion promotion;

        public Builder() {
        }

        public Builder(SearchIndexPromotion searchIndexPromotion) {
            super(searchIndexPromotion);
            if (searchIndexPromotion != null) {
                this.promotion = searchIndexPromotion.promotion;
            }
        }

        public Builder promotion(Promotion promotion2) {
            this.promotion = promotion2;
            return this;
        }

        public SearchIndexPromotion build() {
            return new SearchIndexPromotion(this);
        }
    }
}
