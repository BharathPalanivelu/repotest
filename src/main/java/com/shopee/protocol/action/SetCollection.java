package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetCollection extends Message {
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final List<CollectionItemData> DEFAULT_COLLECTION_ITEMS = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final List<ShopItemId> DEFAULT_IDLIST = Collections.emptyList();
    public static final String DEFAULT_IMAGE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PAGE_TEMPLATE_IMAGE = "";
    public static final String DEFAULT_PAGE_TEMPLATE_SUBTITLE = "";
    public static final String DEFAULT_PRODUCT_OVERLAY_IMAGE = "";
    public static final Boolean DEFAULT_RECOMMEND_TOGGLE = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SOLD = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = CollectionItemData.class, tag = 10)
    public final List<CollectionItemData> collection_items;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 8)
    public final List<ShopItemId> idlist;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String page_template_image;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String page_template_subtitle;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String product_overlay_image;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean recommend_toggle;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer sold;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;

    public SetCollection(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, List<ShopItemId> list, String str6, List<CollectionItemData> list2, Boolean bool, Integer num3, String str7, String str8) {
        this.requestid = str;
        this.collection_id = num;
        this.name = str2;
        this.description = str3;
        this.image = str4;
        this.country = str5;
        this.status = num2;
        this.idlist = immutableCopyOf(list);
        this.product_overlay_image = str6;
        this.collection_items = immutableCopyOf(list2);
        this.recommend_toggle = bool;
        this.sold = num3;
        this.page_template_image = str7;
        this.page_template_subtitle = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SetCollection(com.shopee.protocol.action.SetCollection.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.collection_id
            java.lang.String r4 = r0.name
            java.lang.String r5 = r0.description
            java.lang.String r6 = r0.image
            java.lang.String r7 = r0.country
            java.lang.Integer r8 = r0.status
            java.util.List<com.shopee.protocol.action.ShopItemId> r9 = r0.idlist
            java.lang.String r10 = r0.product_overlay_image
            java.util.List<com.shopee.protocol.action.CollectionItemData> r11 = r0.collection_items
            java.lang.Boolean r12 = r0.recommend_toggle
            java.lang.Integer r13 = r0.sold
            java.lang.String r14 = r0.page_template_image
            java.lang.String r15 = r0.page_template_subtitle
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SetCollection.<init>(com.shopee.protocol.action.SetCollection$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCollection)) {
            return false;
        }
        SetCollection setCollection = (SetCollection) obj;
        if (!equals((Object) this.requestid, (Object) setCollection.requestid) || !equals((Object) this.collection_id, (Object) setCollection.collection_id) || !equals((Object) this.name, (Object) setCollection.name) || !equals((Object) this.description, (Object) setCollection.description) || !equals((Object) this.image, (Object) setCollection.image) || !equals((Object) this.country, (Object) setCollection.country) || !equals((Object) this.status, (Object) setCollection.status) || !equals((List<?>) this.idlist, (List<?>) setCollection.idlist) || !equals((Object) this.product_overlay_image, (Object) setCollection.product_overlay_image) || !equals((List<?>) this.collection_items, (List<?>) setCollection.collection_items) || !equals((Object) this.recommend_toggle, (Object) setCollection.recommend_toggle) || !equals((Object) this.sold, (Object) setCollection.sold) || !equals((Object) this.page_template_image, (Object) setCollection.page_template_image) || !equals((Object) this.page_template_subtitle, (Object) setCollection.page_template_subtitle)) {
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
        Integer num = this.collection_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.image;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<ShopItemId> list = this.idlist;
        int i3 = 1;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        String str6 = this.product_overlay_image;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<CollectionItemData> list2 = this.collection_items;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode9 + i3) * 37;
        Boolean bool = this.recommend_toggle;
        int hashCode10 = (i4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.sold;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str7 = this.page_template_image;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.page_template_subtitle;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i5 = hashCode12 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SetCollection> {
        public Integer collection_id;
        public List<CollectionItemData> collection_items;
        public String country;
        public String description;
        public List<ShopItemId> idlist;
        public String image;
        public String name;
        public String page_template_image;
        public String page_template_subtitle;
        public String product_overlay_image;
        public Boolean recommend_toggle;
        public String requestid;
        public Integer sold;
        public Integer status;

        public Builder() {
        }

        public Builder(SetCollection setCollection) {
            super(setCollection);
            if (setCollection != null) {
                this.requestid = setCollection.requestid;
                this.collection_id = setCollection.collection_id;
                this.name = setCollection.name;
                this.description = setCollection.description;
                this.image = setCollection.image;
                this.country = setCollection.country;
                this.status = setCollection.status;
                this.idlist = SetCollection.copyOf(setCollection.idlist);
                this.product_overlay_image = setCollection.product_overlay_image;
                this.collection_items = SetCollection.copyOf(setCollection.collection_items);
                this.recommend_toggle = setCollection.recommend_toggle;
                this.sold = setCollection.sold;
                this.page_template_image = setCollection.page_template_image;
                this.page_template_subtitle = setCollection.page_template_subtitle;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
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

        public Builder idlist(List<ShopItemId> list) {
            this.idlist = checkForNulls(list);
            return this;
        }

        public Builder product_overlay_image(String str) {
            this.product_overlay_image = str;
            return this;
        }

        public Builder collection_items(List<CollectionItemData> list) {
            this.collection_items = checkForNulls(list);
            return this;
        }

        public Builder recommend_toggle(Boolean bool) {
            this.recommend_toggle = bool;
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

        public SetCollection build() {
            return new SetCollection(this);
        }
    }
}
