package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Attribute;
import com.shopee.protocol.shop.AttributeValueV2;
import com.shopee.protocol.shop.RootAttribute;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexAttr extends Message {
    public static final Long DEFAULT_DATA_TYPE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final Attribute attr;
    @ProtoField(tag = 4)
    public final AttributeValueV2 attr_value;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long data_type;
    @ProtoField(tag = 2)
    public final RootAttribute root_attr;

    public SearchIndexAttr(Long l, RootAttribute rootAttribute, Attribute attribute, AttributeValueV2 attributeValueV2) {
        this.data_type = l;
        this.root_attr = rootAttribute;
        this.attr = attribute;
        this.attr_value = attributeValueV2;
    }

    private SearchIndexAttr(Builder builder) {
        this(builder.data_type, builder.root_attr, builder.attr, builder.attr_value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexAttr)) {
            return false;
        }
        SearchIndexAttr searchIndexAttr = (SearchIndexAttr) obj;
        if (!equals((Object) this.data_type, (Object) searchIndexAttr.data_type) || !equals((Object) this.root_attr, (Object) searchIndexAttr.root_attr) || !equals((Object) this.attr, (Object) searchIndexAttr.attr) || !equals((Object) this.attr_value, (Object) searchIndexAttr.attr_value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.data_type;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        RootAttribute rootAttribute = this.root_attr;
        int hashCode2 = (hashCode + (rootAttribute != null ? rootAttribute.hashCode() : 0)) * 37;
        Attribute attribute = this.attr;
        int hashCode3 = (hashCode2 + (attribute != null ? attribute.hashCode() : 0)) * 37;
        AttributeValueV2 attributeValueV2 = this.attr_value;
        if (attributeValueV2 != null) {
            i2 = attributeValueV2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexAttr> {
        public Attribute attr;
        public AttributeValueV2 attr_value;
        public Long data_type;
        public RootAttribute root_attr;

        public Builder() {
        }

        public Builder(SearchIndexAttr searchIndexAttr) {
            super(searchIndexAttr);
            if (searchIndexAttr != null) {
                this.data_type = searchIndexAttr.data_type;
                this.root_attr = searchIndexAttr.root_attr;
                this.attr = searchIndexAttr.attr;
                this.attr_value = searchIndexAttr.attr_value;
            }
        }

        public Builder data_type(Long l) {
            this.data_type = l;
            return this;
        }

        public Builder root_attr(RootAttribute rootAttribute) {
            this.root_attr = rootAttribute;
            return this;
        }

        public Builder attr(Attribute attribute) {
            this.attr = attribute;
            return this;
        }

        public Builder attr_value(AttributeValueV2 attributeValueV2) {
            this.attr_value = attributeValueV2;
            return this;
        }

        public SearchIndexAttr build() {
            return new SearchIndexAttr(this);
        }
    }
}
