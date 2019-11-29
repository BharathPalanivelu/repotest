package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SubCategory extends Message {
    public static final Integer DEFAULT_PARENT_CATEGORY = 0;
    public static final Integer DEFAULT_SUB_CATEGORY = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer parent_category;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer sub_category;

    public SubCategory(Integer num, Integer num2) {
        this.parent_category = num;
        this.sub_category = num2;
    }

    private SubCategory(Builder builder) {
        this(builder.parent_category, builder.sub_category);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubCategory)) {
            return false;
        }
        SubCategory subCategory = (SubCategory) obj;
        if (!equals((Object) this.parent_category, (Object) subCategory.parent_category) || !equals((Object) this.sub_category, (Object) subCategory.sub_category)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.parent_category;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.sub_category;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SubCategory> {
        public Integer parent_category;
        public Integer sub_category;

        public Builder() {
        }

        public Builder(SubCategory subCategory) {
            super(subCategory);
            if (subCategory != null) {
                this.parent_category = subCategory.parent_category;
                this.sub_category = subCategory.sub_category;
            }
        }

        public Builder parent_category(Integer num) {
            this.parent_category = num;
            return this;
        }

        public Builder sub_category(Integer num) {
            this.sub_category = num;
            return this;
        }

        public SubCategory build() {
            return new SubCategory(this);
        }
    }
}
