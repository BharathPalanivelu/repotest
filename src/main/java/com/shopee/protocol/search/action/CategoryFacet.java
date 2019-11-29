package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CategoryFacet extends Message {
    public static final String DEFAULT_BRAND = "";
    public static final Integer DEFAULT_BRANDID = 0;
    public static final Integer DEFAULT_CATID = 0;
    public static final Integer DEFAULT_COUNT = 0;
    public static final String DEFAULT_HASHTAG = "";
    public static final Integer DEFAULT_SHOPTYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String brand;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer brandid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String hashtag;
    @ProtoField(tag = 4)
    public final BriefItem items;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer shoptype;

    public CategoryFacet(Integer num, Integer num2, String str, BriefItem briefItem, String str2, Integer num3, Integer num4) {
        this.catid = num;
        this.count = num2;
        this.hashtag = str;
        this.items = briefItem;
        this.brand = str2;
        this.brandid = num3;
        this.shoptype = num4;
    }

    private CategoryFacet(Builder builder) {
        this(builder.catid, builder.count, builder.hashtag, builder.items, builder.brand, builder.brandid, builder.shoptype);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryFacet)) {
            return false;
        }
        CategoryFacet categoryFacet = (CategoryFacet) obj;
        if (!equals((Object) this.catid, (Object) categoryFacet.catid) || !equals((Object) this.count, (Object) categoryFacet.count) || !equals((Object) this.hashtag, (Object) categoryFacet.hashtag) || !equals((Object) this.items, (Object) categoryFacet.items) || !equals((Object) this.brand, (Object) categoryFacet.brand) || !equals((Object) this.brandid, (Object) categoryFacet.brandid) || !equals((Object) this.shoptype, (Object) categoryFacet.shoptype)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.catid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.count;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.hashtag;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        BriefItem briefItem = this.items;
        int hashCode4 = (hashCode3 + (briefItem != null ? briefItem.hashCode() : 0)) * 37;
        String str2 = this.brand;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.brandid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.shoptype;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CategoryFacet> {
        public String brand;
        public Integer brandid;
        public Integer catid;
        public Integer count;
        public String hashtag;
        public BriefItem items;
        public Integer shoptype;

        public Builder() {
        }

        public Builder(CategoryFacet categoryFacet) {
            super(categoryFacet);
            if (categoryFacet != null) {
                this.catid = categoryFacet.catid;
                this.count = categoryFacet.count;
                this.hashtag = categoryFacet.hashtag;
                this.items = categoryFacet.items;
                this.brand = categoryFacet.brand;
                this.brandid = categoryFacet.brandid;
                this.shoptype = categoryFacet.shoptype;
            }
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder items(BriefItem briefItem) {
            this.items = briefItem;
            return this;
        }

        public Builder brand(String str) {
            this.brand = str;
            return this;
        }

        public Builder brandid(Integer num) {
            this.brandid = num;
            return this;
        }

        public Builder shoptype(Integer num) {
            this.shoptype = num;
            return this;
        }

        public CategoryFacet build() {
            return new CategoryFacet(this);
        }
    }
}
