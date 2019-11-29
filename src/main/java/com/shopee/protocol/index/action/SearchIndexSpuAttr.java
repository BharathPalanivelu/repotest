package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.StandardProductAttribute;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexSpuAttr extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final StandardProductAttribute spu_attr;

    public SearchIndexSpuAttr(StandardProductAttribute standardProductAttribute) {
        this.spu_attr = standardProductAttribute;
    }

    private SearchIndexSpuAttr(Builder builder) {
        this(builder.spu_attr);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexSpuAttr)) {
            return false;
        }
        return equals((Object) this.spu_attr, (Object) ((SearchIndexSpuAttr) obj).spu_attr);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            StandardProductAttribute standardProductAttribute = this.spu_attr;
            i = standardProductAttribute != null ? standardProductAttribute.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchIndexSpuAttr> {
        public StandardProductAttribute spu_attr;

        public Builder() {
        }

        public Builder(SearchIndexSpuAttr searchIndexSpuAttr) {
            super(searchIndexSpuAttr);
            if (searchIndexSpuAttr != null) {
                this.spu_attr = searchIndexSpuAttr.spu_attr;
            }
        }

        public Builder spu_attr(StandardProductAttribute standardProductAttribute) {
            this.spu_attr = standardProductAttribute;
            return this;
        }

        public SearchIndexSpuAttr build() {
            return new SearchIndexSpuAttr(this);
        }
    }
}
