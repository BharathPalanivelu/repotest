package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CategoryNameInfo extends Message {
    public static final String DEFAULT_LANG = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String Lang;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String Name;

    public CategoryNameInfo(String str, String str2) {
        this.Lang = str;
        this.Name = str2;
    }

    private CategoryNameInfo(Builder builder) {
        this(builder.Lang, builder.Name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryNameInfo)) {
            return false;
        }
        CategoryNameInfo categoryNameInfo = (CategoryNameInfo) obj;
        if (!equals((Object) this.Lang, (Object) categoryNameInfo.Lang) || !equals((Object) this.Name, (Object) categoryNameInfo.Name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.Lang;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.Name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CategoryNameInfo> {
        public String Lang;
        public String Name;

        public Builder() {
        }

        public Builder(CategoryNameInfo categoryNameInfo) {
            super(categoryNameInfo);
            if (categoryNameInfo != null) {
                this.Lang = categoryNameInfo.Lang;
                this.Name = categoryNameInfo.Name;
            }
        }

        public Builder Lang(String str) {
            this.Lang = str;
            return this;
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public CategoryNameInfo build() {
            return new CategoryNameInfo(this);
        }
    }
}
