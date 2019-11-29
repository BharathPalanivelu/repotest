package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Category extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_HAS_ACTIVE_CHILDS = 0;
    public static final String DEFAULT_IMAGE = "";
    public static final Integer DEFAULT_IS_ADULT = 0;
    public static final Integer DEFAULT_IS_DEFAULT_SUBCAT = 0;
    public static final Integer DEFAULT_MAX_ESTIMATED_DAYS = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_PARENT_CATEGORY = 0;
    public static final Integer DEFAULT_SORT_WEIGHT = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USAGE_SORT_WEIGHT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String display_name;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer has_active_childs;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer is_adult;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer is_default_subcat;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer max_estimated_days;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer parent_category;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer sort_weight;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer usage_sort_weight;

    public Category(Integer num, String str, String str2, String str3, Integer num2, Integer num3, String str4, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, f fVar) {
        this.catid = num;
        this.name = str;
        this.image = str2;
        this.country = str3;
        this.status = num2;
        this.sort_weight = num3;
        this.display_name = str4;
        this.usage_sort_weight = num4;
        this.parent_category = num5;
        this.is_default_subcat = num6;
        this.is_adult = num7;
        this.max_estimated_days = num8;
        this.has_active_childs = num9;
        this.extinfo = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Category(com.shopee.protocol.shop.Category.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.catid
            java.lang.String r3 = r0.name
            java.lang.String r4 = r0.image
            java.lang.String r5 = r0.country
            java.lang.Integer r6 = r0.status
            java.lang.Integer r7 = r0.sort_weight
            java.lang.String r8 = r0.display_name
            java.lang.Integer r9 = r0.usage_sort_weight
            java.lang.Integer r10 = r0.parent_category
            java.lang.Integer r11 = r0.is_default_subcat
            java.lang.Integer r12 = r0.is_adult
            java.lang.Integer r13 = r0.max_estimated_days
            java.lang.Integer r14 = r0.has_active_childs
            e.f r15 = r0.extinfo
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Category.<init>(com.shopee.protocol.shop.Category$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        if (!equals((Object) this.catid, (Object) category.catid) || !equals((Object) this.name, (Object) category.name) || !equals((Object) this.image, (Object) category.image) || !equals((Object) this.country, (Object) category.country) || !equals((Object) this.status, (Object) category.status) || !equals((Object) this.sort_weight, (Object) category.sort_weight) || !equals((Object) this.display_name, (Object) category.display_name) || !equals((Object) this.usage_sort_weight, (Object) category.usage_sort_weight) || !equals((Object) this.parent_category, (Object) category.parent_category) || !equals((Object) this.is_default_subcat, (Object) category.is_default_subcat) || !equals((Object) this.is_adult, (Object) category.is_adult) || !equals((Object) this.max_estimated_days, (Object) category.max_estimated_days) || !equals((Object) this.has_active_childs, (Object) category.has_active_childs) || !equals((Object) this.extinfo, (Object) category.extinfo)) {
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
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.image;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.sort_weight;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str4 = this.display_name;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.usage_sort_weight;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.parent_category;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.is_default_subcat;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.is_adult;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.max_estimated_days;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.has_active_childs;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Category> {
        public Integer catid;
        public String country;
        public String display_name;
        public f extinfo;
        public Integer has_active_childs;
        public String image;
        public Integer is_adult;
        public Integer is_default_subcat;
        public Integer max_estimated_days;
        public String name;
        public Integer parent_category;
        public Integer sort_weight;
        public Integer status;
        public Integer usage_sort_weight;

        public Builder() {
        }

        public Builder(Category category) {
            super(category);
            if (category != null) {
                this.catid = category.catid;
                this.name = category.name;
                this.image = category.image;
                this.country = category.country;
                this.status = category.status;
                this.sort_weight = category.sort_weight;
                this.display_name = category.display_name;
                this.usage_sort_weight = category.usage_sort_weight;
                this.parent_category = category.parent_category;
                this.is_default_subcat = category.is_default_subcat;
                this.is_adult = category.is_adult;
                this.max_estimated_days = category.max_estimated_days;
                this.has_active_childs = category.has_active_childs;
                this.extinfo = category.extinfo;
            }
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder image(String str) {
            this.image = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder sort_weight(Integer num) {
            this.sort_weight = num;
            return this;
        }

        public Builder display_name(String str) {
            this.display_name = str;
            return this;
        }

        public Builder usage_sort_weight(Integer num) {
            this.usage_sort_weight = num;
            return this;
        }

        public Builder parent_category(Integer num) {
            this.parent_category = num;
            return this;
        }

        public Builder is_default_subcat(Integer num) {
            this.is_default_subcat = num;
            return this;
        }

        public Builder is_adult(Integer num) {
            this.is_adult = num;
            return this;
        }

        public Builder max_estimated_days(Integer num) {
            this.max_estimated_days = num;
            return this;
        }

        public Builder has_active_childs(Integer num) {
            this.has_active_childs = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
