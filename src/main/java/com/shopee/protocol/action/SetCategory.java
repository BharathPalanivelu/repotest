package com.shopee.protocol.action;

import com.shopee.protocol.shop.Category;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetCategory extends Message {
    public static final List<Category> DEFAULT_CATEGORY = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Category.class, tag = 2)
    public final List<Category> category;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetCategory(String str, List<Category> list) {
        this.requestid = str;
        this.category = immutableCopyOf(list);
    }

    private SetCategory(Builder builder) {
        this(builder.requestid, builder.category);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCategory)) {
            return false;
        }
        SetCategory setCategory = (SetCategory) obj;
        if (!equals((Object) this.requestid, (Object) setCategory.requestid) || !equals((List<?>) this.category, (List<?>) setCategory.category)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<Category> list = this.category;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetCategory> {
        public List<Category> category;
        public String requestid;

        public Builder() {
        }

        public Builder(SetCategory setCategory) {
            super(setCategory);
            if (setCategory != null) {
                this.requestid = setCategory.requestid;
                this.category = SetCategory.copyOf(setCategory.category);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder category(List<Category> list) {
            this.category = checkForNulls(list);
            return this;
        }

        public SetCategory build() {
            return new SetCategory(this);
        }
    }
}
