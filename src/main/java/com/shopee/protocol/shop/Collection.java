package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Collection extends Message {
    public static final String DEFAULT_CLUSTER_ID = "";
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final Integer DEFAULT_COLLECTION_TYPE = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DATA = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_IMAGE = "";
    public static final f DEFAULT_LONG_TAIL_CONDITION = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PAGE_TEMPLATE_IMAGE = "";
    public static final String DEFAULT_PAGE_TEMPLATE_SUBTITLE = "";
    public static final String DEFAULT_PRODUCT_OVERLAY_IMAGE = "";
    public static final Boolean DEFAULT_RECOMMEND_TOGGLE = false;
    public static final Integer DEFAULT_SOLD = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String cluster_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer collection_type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f long_tail_condition;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String page_template_image;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String page_template_subtitle;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String product_overlay_image;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean recommend_toggle;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer sold;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public Collection(Integer num, String str, String str2, String str3, String str4, Integer num2, Integer num3, Integer num4, String str5, f fVar, String str6, String str7, Boolean bool, Integer num5, Integer num6, String str8, String str9) {
        this.collection_id = num;
        this.name = str;
        this.description = str2;
        this.image = str3;
        this.country = str4;
        this.status = num2;
        this.ctime = num3;
        this.mtime = num4;
        this.data = str5;
        this.long_tail_condition = fVar;
        this.product_overlay_image = str6;
        this.cluster_id = str7;
        this.recommend_toggle = bool;
        this.collection_type = num5;
        this.sold = num6;
        this.page_template_image = str8;
        this.page_template_subtitle = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Collection(com.shopee.protocol.shop.Collection.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.Integer r2 = r0.collection_id
            java.lang.String r3 = r0.name
            java.lang.String r4 = r0.description
            java.lang.String r5 = r0.image
            java.lang.String r6 = r0.country
            java.lang.Integer r7 = r0.status
            java.lang.Integer r8 = r0.ctime
            java.lang.Integer r9 = r0.mtime
            java.lang.String r10 = r0.data
            e.f r11 = r0.long_tail_condition
            java.lang.String r12 = r0.product_overlay_image
            java.lang.String r13 = r0.cluster_id
            java.lang.Boolean r14 = r0.recommend_toggle
            java.lang.Integer r15 = r0.collection_type
            r19 = r1
            java.lang.Integer r1 = r0.sold
            r16 = r1
            java.lang.String r1 = r0.page_template_image
            r17 = r1
            java.lang.String r1 = r0.page_template_subtitle
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Collection.<init>(com.shopee.protocol.shop.Collection$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Collection)) {
            return false;
        }
        Collection collection = (Collection) obj;
        if (!equals((Object) this.collection_id, (Object) collection.collection_id) || !equals((Object) this.name, (Object) collection.name) || !equals((Object) this.description, (Object) collection.description) || !equals((Object) this.image, (Object) collection.image) || !equals((Object) this.country, (Object) collection.country) || !equals((Object) this.status, (Object) collection.status) || !equals((Object) this.ctime, (Object) collection.ctime) || !equals((Object) this.mtime, (Object) collection.mtime) || !equals((Object) this.data, (Object) collection.data) || !equals((Object) this.long_tail_condition, (Object) collection.long_tail_condition) || !equals((Object) this.product_overlay_image, (Object) collection.product_overlay_image) || !equals((Object) this.cluster_id, (Object) collection.cluster_id) || !equals((Object) this.recommend_toggle, (Object) collection.recommend_toggle) || !equals((Object) this.collection_type, (Object) collection.collection_type) || !equals((Object) this.sold, (Object) collection.sold) || !equals((Object) this.page_template_image, (Object) collection.page_template_image) || !equals((Object) this.page_template_subtitle, (Object) collection.page_template_subtitle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.collection_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.image;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str5 = this.data;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        f fVar = this.long_tail_condition;
        int hashCode10 = (hashCode9 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str6 = this.product_overlay_image;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.cluster_id;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool = this.recommend_toggle;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num5 = this.collection_type;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.sold;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str8 = this.page_template_image;
        int hashCode16 = (hashCode15 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.page_template_subtitle;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Collection> {
        public String cluster_id;
        public Integer collection_id;
        public Integer collection_type;
        public String country;
        public Integer ctime;
        public String data;
        public String description;
        public String image;
        public f long_tail_condition;
        public Integer mtime;
        public String name;
        public String page_template_image;
        public String page_template_subtitle;
        public String product_overlay_image;
        public Boolean recommend_toggle;
        public Integer sold;
        public Integer status;

        public Builder() {
        }

        public Builder(Collection collection) {
            super(collection);
            if (collection != null) {
                this.collection_id = collection.collection_id;
                this.name = collection.name;
                this.description = collection.description;
                this.image = collection.image;
                this.country = collection.country;
                this.status = collection.status;
                this.ctime = collection.ctime;
                this.mtime = collection.mtime;
                this.data = collection.data;
                this.long_tail_condition = collection.long_tail_condition;
                this.product_overlay_image = collection.product_overlay_image;
                this.cluster_id = collection.cluster_id;
                this.recommend_toggle = collection.recommend_toggle;
                this.collection_type = collection.collection_type;
                this.sold = collection.sold;
                this.page_template_image = collection.page_template_image;
                this.page_template_subtitle = collection.page_template_subtitle;
            }
        }

        public Builder collection_id(Integer num) {
            this.collection_id = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder data(String str) {
            this.data = str;
            return this;
        }

        public Builder long_tail_condition(f fVar) {
            this.long_tail_condition = fVar;
            return this;
        }

        public Builder product_overlay_image(String str) {
            this.product_overlay_image = str;
            return this;
        }

        public Builder cluster_id(String str) {
            this.cluster_id = str;
            return this;
        }

        public Builder recommend_toggle(Boolean bool) {
            this.recommend_toggle = bool;
            return this;
        }

        public Builder collection_type(Integer num) {
            this.collection_type = num;
            return this;
        }

        public Builder sold(Integer num) {
            this.sold = num;
            return this;
        }

        public Builder page_template_image(String str) {
            this.page_template_image = str;
            return this;
        }

        public Builder page_template_subtitle(String str) {
            this.page_template_subtitle = str;
            return this;
        }

        public Collection build() {
            return new Collection(this);
        }
    }
}
