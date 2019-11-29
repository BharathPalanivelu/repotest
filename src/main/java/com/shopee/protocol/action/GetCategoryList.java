package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetCategoryList extends Message {
    public static final List<Integer> DEFAULT_CATIDS = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LEVELS = 0;
    public static final Integer DEFAULT_NEED_SUBCATEGORY = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> catids;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer levels;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer need_subcategory;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCategoryList(String str, String str2, Integer num, List<Integer> list, Integer num2) {
        this.requestid = str;
        this.country = str2;
        this.need_subcategory = num;
        this.catids = immutableCopyOf(list);
        this.levels = num2;
    }

    private GetCategoryList(Builder builder) {
        this(builder.requestid, builder.country, builder.need_subcategory, builder.catids, builder.levels);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCategoryList)) {
            return false;
        }
        GetCategoryList getCategoryList = (GetCategoryList) obj;
        if (!equals((Object) this.requestid, (Object) getCategoryList.requestid) || !equals((Object) this.country, (Object) getCategoryList.country) || !equals((Object) this.need_subcategory, (Object) getCategoryList.need_subcategory) || !equals((List<?>) this.catids, (List<?>) getCategoryList.catids) || !equals((Object) this.levels, (Object) getCategoryList.levels)) {
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
        Integer num = this.need_subcategory;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        List<Integer> list = this.catids;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.levels;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCategoryList> {
        public List<Integer> catids;
        public String country;
        public Integer levels;
        public Integer need_subcategory;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCategoryList getCategoryList) {
            super(getCategoryList);
            if (getCategoryList != null) {
                this.requestid = getCategoryList.requestid;
                this.country = getCategoryList.country;
                this.need_subcategory = getCategoryList.need_subcategory;
                this.catids = GetCategoryList.copyOf(getCategoryList.catids);
                this.levels = getCategoryList.levels;
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

        public Builder need_subcategory(Integer num) {
            this.need_subcategory = num;
            return this;
        }

        public Builder catids(List<Integer> list) {
            this.catids = checkForNulls(list);
            return this;
        }

        public Builder levels(Integer num) {
            this.levels = num;
            return this;
        }

        public GetCategoryList build() {
            checkRequiredFields();
            return new GetCategoryList(this);
        }
    }
}
