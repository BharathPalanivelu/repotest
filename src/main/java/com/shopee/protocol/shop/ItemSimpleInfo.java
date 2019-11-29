package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ItemSimpleInfo extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final Integer DEFAULT_CMT_COUNT = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_IMAGES = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIKED_COUNT = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_OPTION = 0;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOLD = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOCK = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer cmt_count;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 31, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String images;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer liked_count;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer option;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer sold;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer stock;

    public ItemSimpleInfo(Long l, Integer num, String str, String str2, String str3, Long l2, String str4, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str5, f fVar) {
        this.itemid = l;
        this.shopid = num;
        this.name = str;
        this.description = str2;
        this.images = str3;
        this.price = l2;
        this.currency = str4;
        this.stock = num2;
        this.status = num3;
        this.liked_count = num4;
        this.cmt_count = num5;
        this.option = num6;
        this.ctime = num7;
        this.sold = num8;
        this.catid = num9;
        this.country = str5;
        this.extinfo = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ItemSimpleInfo(com.shopee.protocol.shop.ItemSimpleInfo.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.shopid
            java.lang.String r4 = r0.name
            java.lang.String r5 = r0.description
            java.lang.String r6 = r0.images
            java.lang.Long r7 = r0.price
            java.lang.String r8 = r0.currency
            java.lang.Integer r9 = r0.stock
            java.lang.Integer r10 = r0.status
            java.lang.Integer r11 = r0.liked_count
            java.lang.Integer r12 = r0.cmt_count
            java.lang.Integer r13 = r0.option
            java.lang.Integer r14 = r0.ctime
            java.lang.Integer r15 = r0.sold
            r19 = r1
            java.lang.Integer r1 = r0.catid
            r16 = r1
            java.lang.String r1 = r0.country
            r17 = r1
            e.f r1 = r0.extinfo
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ItemSimpleInfo.<init>(com.shopee.protocol.shop.ItemSimpleInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemSimpleInfo)) {
            return false;
        }
        ItemSimpleInfo itemSimpleInfo = (ItemSimpleInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemSimpleInfo.itemid) || !equals((Object) this.shopid, (Object) itemSimpleInfo.shopid) || !equals((Object) this.name, (Object) itemSimpleInfo.name) || !equals((Object) this.description, (Object) itemSimpleInfo.description) || !equals((Object) this.images, (Object) itemSimpleInfo.images) || !equals((Object) this.price, (Object) itemSimpleInfo.price) || !equals((Object) this.currency, (Object) itemSimpleInfo.currency) || !equals((Object) this.stock, (Object) itemSimpleInfo.stock) || !equals((Object) this.status, (Object) itemSimpleInfo.status) || !equals((Object) this.liked_count, (Object) itemSimpleInfo.liked_count) || !equals((Object) this.cmt_count, (Object) itemSimpleInfo.cmt_count) || !equals((Object) this.option, (Object) itemSimpleInfo.option) || !equals((Object) this.ctime, (Object) itemSimpleInfo.ctime) || !equals((Object) this.sold, (Object) itemSimpleInfo.sold) || !equals((Object) this.catid, (Object) itemSimpleInfo.catid) || !equals((Object) this.country, (Object) itemSimpleInfo.country) || !equals((Object) this.extinfo, (Object) itemSimpleInfo.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.images;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l2 = this.price;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.currency;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.stock;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.liked_count;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.cmt_count;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.option;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.ctime;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.sold;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.catid;
        int hashCode15 = (hashCode14 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode16 = (hashCode15 + (str5 != null ? str5.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemSimpleInfo> {
        public Integer catid;
        public Integer cmt_count;
        public String country;
        public Integer ctime;
        public String currency;
        public String description;
        public f extinfo;
        public String images;
        public Long itemid;
        public Integer liked_count;
        public String name;
        public Integer option;
        public Long price;
        public Integer shopid;
        public Integer sold;
        public Integer status;
        public Integer stock;

        public Builder() {
        }

        public Builder(ItemSimpleInfo itemSimpleInfo) {
            super(itemSimpleInfo);
            if (itemSimpleInfo != null) {
                this.itemid = itemSimpleInfo.itemid;
                this.shopid = itemSimpleInfo.shopid;
                this.name = itemSimpleInfo.name;
                this.description = itemSimpleInfo.description;
                this.images = itemSimpleInfo.images;
                this.price = itemSimpleInfo.price;
                this.currency = itemSimpleInfo.currency;
                this.stock = itemSimpleInfo.stock;
                this.status = itemSimpleInfo.status;
                this.liked_count = itemSimpleInfo.liked_count;
                this.cmt_count = itemSimpleInfo.cmt_count;
                this.option = itemSimpleInfo.option;
                this.ctime = itemSimpleInfo.ctime;
                this.sold = itemSimpleInfo.sold;
                this.catid = itemSimpleInfo.catid;
                this.country = itemSimpleInfo.country;
                this.extinfo = itemSimpleInfo.extinfo;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public Builder images(String str) {
            this.images = str;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder liked_count(Integer num) {
            this.liked_count = num;
            return this;
        }

        public Builder cmt_count(Integer num) {
            this.cmt_count = num;
            return this;
        }

        public Builder option(Integer num) {
            this.option = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder sold(Integer num) {
            this.sold = num;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public ItemSimpleInfo build() {
            checkRequiredFields();
            return new ItemSimpleInfo(this);
        }
    }
}
