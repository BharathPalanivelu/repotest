package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CategoryPath extends Message {
    public static final List<Integer> DEFAULT_CATID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> catid;

    public CategoryPath(List<Integer> list) {
        this.catid = immutableCopyOf(list);
    }

    private CategoryPath(Builder builder) {
        this(builder.catid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryPath)) {
            return false;
        }
        return equals((List<?>) this.catid, (List<?>) ((CategoryPath) obj).catid);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Integer> list = this.catid;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CategoryPath> {
        public List<Integer> catid;

        public Builder() {
        }

        public Builder(CategoryPath categoryPath) {
            super(categoryPath);
            if (categoryPath != null) {
                this.catid = CategoryPath.copyOf(categoryPath.catid);
            }
        }

        public Builder catid(List<Integer> list) {
            this.catid = checkForNulls(list);
            return this;
        }

        public CategoryPath build() {
            return new CategoryPath(this);
        }
    }
}
