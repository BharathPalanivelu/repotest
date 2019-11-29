package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetSubCategory extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LEVELS = 0;
    public static final Integer DEFAULT_PARENT_CATID = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer levels;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer parent_catid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetSubCategory(String str, String str2, Integer num, Integer num2) {
        this.requestid = str;
        this.country = str2;
        this.parent_catid = num;
        this.levels = num2;
    }

    private GetSubCategory(Builder builder) {
        this(builder.requestid, builder.country, builder.parent_catid, builder.levels);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSubCategory)) {
            return false;
        }
        GetSubCategory getSubCategory = (GetSubCategory) obj;
        if (!equals((Object) this.requestid, (Object) getSubCategory.requestid) || !equals((Object) this.country, (Object) getSubCategory.country) || !equals((Object) this.parent_catid, (Object) getSubCategory.parent_catid) || !equals((Object) this.levels, (Object) getSubCategory.levels)) {
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
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.parent_catid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.levels;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetSubCategory> {
        public String country;
        public Integer levels;
        public Integer parent_catid;
        public String requestid;

        public Builder() {
        }

        public Builder(GetSubCategory getSubCategory) {
            super(getSubCategory);
            if (getSubCategory != null) {
                this.requestid = getSubCategory.requestid;
                this.country = getSubCategory.country;
                this.parent_catid = getSubCategory.parent_catid;
                this.levels = getSubCategory.levels;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder parent_catid(Integer num) {
            this.parent_catid = num;
            return this;
        }

        public Builder levels(Integer num) {
            this.levels = num;
            return this;
        }

        public GetSubCategory build() {
            checkRequiredFields();
            return new GetSubCategory(this);
        }
    }
}
