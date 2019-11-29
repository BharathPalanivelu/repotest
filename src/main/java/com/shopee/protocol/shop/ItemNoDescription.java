package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ItemNoDescription extends Message {
    public static final String DEFAULT_BRAND = "";
    public static final Integer DEFAULT_CATID = 0;
    public static final Integer DEFAULT_CMT_COUNT = 0;
    public static final Integer DEFAULT_CONDITION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_IMAGES = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIKED_COUNT = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_OFFER_COUNT = 0;
    public static final Integer DEFAULT_OPTION = 0;
    public static final Integer DEFAULT_POP = 0;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Long DEFAULT_PRICE_MAX = 0L;
    public static final Long DEFAULT_PRICE_MIN = 0L;
    public static final Integer DEFAULT_RATING_BAD = 0;
    public static final Integer DEFAULT_RATING_GOOD = 0;
    public static final Integer DEFAULT_RATING_NORMAL = 0;
    public static final Integer DEFAULT_RECOMMEND = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOLD = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOCK = 0;
    public static final Integer DEFAULT_STOCKOUT_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String brand;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer cmt_count;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer condition;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 31, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String images;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer liked_count;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer offer_count;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer option;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer pop;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long price_max;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long price_min;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer rating_bad;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer rating_good;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer rating_normal;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer recommend;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer sold;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer stock;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer stockout_time;

    public ItemNoDescription(Long l, Integer num, String str, String str2, Long l2, String str3, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l3, Long l4, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, String str4, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, String str5, Integer num17, f fVar, Integer num18) {
        this.itemid = l;
        this.shopid = num;
        this.name = str;
        this.images = str2;
        this.price = l2;
        this.currency = str3;
        this.stock = num2;
        this.status = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.sold = num6;
        this.price_min = l3;
        this.price_max = l4;
        this.recommend = num7;
        this.catid = num8;
        this.pop = num9;
        this.liked_count = num10;
        this.offer_count = num11;
        this.brand = str4;
        this.condition = num12;
        this.rating_good = num13;
        this.rating_normal = num14;
        this.rating_bad = num15;
        this.cmt_count = num16;
        this.country = str5;
        this.option = num17;
        this.extinfo = fVar;
        this.stockout_time = num18;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ItemNoDescription(com.shopee.protocol.shop.ItemNoDescription.Builder r32) {
        /*
            r31 = this;
            r0 = r32
            r1 = r31
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.shopid
            java.lang.String r4 = r0.name
            java.lang.String r5 = r0.images
            java.lang.Long r6 = r0.price
            java.lang.String r7 = r0.currency
            java.lang.Integer r8 = r0.stock
            java.lang.Integer r9 = r0.status
            java.lang.Integer r10 = r0.ctime
            java.lang.Integer r11 = r0.mtime
            java.lang.Integer r12 = r0.sold
            java.lang.Long r13 = r0.price_min
            java.lang.Long r14 = r0.price_max
            java.lang.Integer r15 = r0.recommend
            r30 = r1
            java.lang.Integer r1 = r0.catid
            r16 = r1
            java.lang.Integer r1 = r0.pop
            r17 = r1
            java.lang.Integer r1 = r0.liked_count
            r18 = r1
            java.lang.Integer r1 = r0.offer_count
            r19 = r1
            java.lang.String r1 = r0.brand
            r20 = r1
            java.lang.Integer r1 = r0.condition
            r21 = r1
            java.lang.Integer r1 = r0.rating_good
            r22 = r1
            java.lang.Integer r1 = r0.rating_normal
            r23 = r1
            java.lang.Integer r1 = r0.rating_bad
            r24 = r1
            java.lang.Integer r1 = r0.cmt_count
            r25 = r1
            java.lang.String r1 = r0.country
            r26 = r1
            java.lang.Integer r1 = r0.option
            r27 = r1
            e.f r1 = r0.extinfo
            r28 = r1
            java.lang.Integer r1 = r0.stockout_time
            r29 = r1
            r1 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r31.setBuilder(r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ItemNoDescription.<init>(com.shopee.protocol.shop.ItemNoDescription$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemNoDescription)) {
            return false;
        }
        ItemNoDescription itemNoDescription = (ItemNoDescription) obj;
        if (!equals((Object) this.itemid, (Object) itemNoDescription.itemid) || !equals((Object) this.shopid, (Object) itemNoDescription.shopid) || !equals((Object) this.name, (Object) itemNoDescription.name) || !equals((Object) this.images, (Object) itemNoDescription.images) || !equals((Object) this.price, (Object) itemNoDescription.price) || !equals((Object) this.currency, (Object) itemNoDescription.currency) || !equals((Object) this.stock, (Object) itemNoDescription.stock) || !equals((Object) this.status, (Object) itemNoDescription.status) || !equals((Object) this.ctime, (Object) itemNoDescription.ctime) || !equals((Object) this.mtime, (Object) itemNoDescription.mtime) || !equals((Object) this.sold, (Object) itemNoDescription.sold) || !equals((Object) this.price_min, (Object) itemNoDescription.price_min) || !equals((Object) this.price_max, (Object) itemNoDescription.price_max) || !equals((Object) this.recommend, (Object) itemNoDescription.recommend) || !equals((Object) this.catid, (Object) itemNoDescription.catid) || !equals((Object) this.pop, (Object) itemNoDescription.pop) || !equals((Object) this.liked_count, (Object) itemNoDescription.liked_count) || !equals((Object) this.offer_count, (Object) itemNoDescription.offer_count) || !equals((Object) this.brand, (Object) itemNoDescription.brand) || !equals((Object) this.condition, (Object) itemNoDescription.condition) || !equals((Object) this.rating_good, (Object) itemNoDescription.rating_good) || !equals((Object) this.rating_normal, (Object) itemNoDescription.rating_normal) || !equals((Object) this.rating_bad, (Object) itemNoDescription.rating_bad) || !equals((Object) this.cmt_count, (Object) itemNoDescription.cmt_count) || !equals((Object) this.country, (Object) itemNoDescription.country) || !equals((Object) this.option, (Object) itemNoDescription.option) || !equals((Object) this.extinfo, (Object) itemNoDescription.extinfo) || !equals((Object) this.stockout_time, (Object) itemNoDescription.stockout_time)) {
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
        String str2 = this.images;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.price;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str3 = this.currency;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.stock;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.sold;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l3 = this.price_min;
        int hashCode12 = (hashCode11 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.price_max;
        int hashCode13 = (hashCode12 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num7 = this.recommend;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.catid;
        int hashCode15 = (hashCode14 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.pop;
        int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.liked_count;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.offer_count;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str4 = this.brand;
        int hashCode19 = (hashCode18 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num12 = this.condition;
        int hashCode20 = (hashCode19 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.rating_good;
        int hashCode21 = (hashCode20 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.rating_normal;
        int hashCode22 = (hashCode21 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.rating_bad;
        int hashCode23 = (hashCode22 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.cmt_count;
        int hashCode24 = (hashCode23 + (num16 != null ? num16.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode25 = (hashCode24 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num17 = this.option;
        int hashCode26 = (hashCode25 + (num17 != null ? num17.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode27 = (hashCode26 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num18 = this.stockout_time;
        if (num18 != null) {
            i2 = num18.hashCode();
        }
        int i3 = hashCode27 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemNoDescription> {
        public String brand;
        public Integer catid;
        public Integer cmt_count;
        public Integer condition;
        public String country;
        public Integer ctime;
        public String currency;
        public f extinfo;
        public String images;
        public Long itemid;
        public Integer liked_count;
        public Integer mtime;
        public String name;
        public Integer offer_count;
        public Integer option;
        public Integer pop;
        public Long price;
        public Long price_max;
        public Long price_min;
        public Integer rating_bad;
        public Integer rating_good;
        public Integer rating_normal;
        public Integer recommend;
        public Integer shopid;
        public Integer sold;
        public Integer status;
        public Integer stock;
        public Integer stockout_time;

        public Builder() {
        }

        public Builder(ItemNoDescription itemNoDescription) {
            super(itemNoDescription);
            if (itemNoDescription != null) {
                this.itemid = itemNoDescription.itemid;
                this.shopid = itemNoDescription.shopid;
                this.name = itemNoDescription.name;
                this.images = itemNoDescription.images;
                this.price = itemNoDescription.price;
                this.currency = itemNoDescription.currency;
                this.stock = itemNoDescription.stock;
                this.status = itemNoDescription.status;
                this.ctime = itemNoDescription.ctime;
                this.mtime = itemNoDescription.mtime;
                this.sold = itemNoDescription.sold;
                this.price_min = itemNoDescription.price_min;
                this.price_max = itemNoDescription.price_max;
                this.recommend = itemNoDescription.recommend;
                this.catid = itemNoDescription.catid;
                this.pop = itemNoDescription.pop;
                this.liked_count = itemNoDescription.liked_count;
                this.offer_count = itemNoDescription.offer_count;
                this.brand = itemNoDescription.brand;
                this.condition = itemNoDescription.condition;
                this.rating_good = itemNoDescription.rating_good;
                this.rating_normal = itemNoDescription.rating_normal;
                this.rating_bad = itemNoDescription.rating_bad;
                this.cmt_count = itemNoDescription.cmt_count;
                this.country = itemNoDescription.country;
                this.option = itemNoDescription.option;
                this.extinfo = itemNoDescription.extinfo;
                this.stockout_time = itemNoDescription.stockout_time;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder sold(Integer num) {
            this.sold = num;
            return this;
        }

        public Builder price_min(Long l) {
            this.price_min = l;
            return this;
        }

        public Builder price_max(Long l) {
            this.price_max = l;
            return this;
        }

        public Builder recommend(Integer num) {
            this.recommend = num;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder pop(Integer num) {
            this.pop = num;
            return this;
        }

        public Builder liked_count(Integer num) {
            this.liked_count = num;
            return this;
        }

        public Builder offer_count(Integer num) {
            this.offer_count = num;
            return this;
        }

        public Builder brand(String str) {
            this.brand = str;
            return this;
        }

        public Builder condition(Integer num) {
            this.condition = num;
            return this;
        }

        public Builder rating_good(Integer num) {
            this.rating_good = num;
            return this;
        }

        public Builder rating_normal(Integer num) {
            this.rating_normal = num;
            return this;
        }

        public Builder rating_bad(Integer num) {
            this.rating_bad = num;
            return this;
        }

        public Builder cmt_count(Integer num) {
            this.cmt_count = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder option(Integer num) {
            this.option = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder stockout_time(Integer num) {
            this.stockout_time = num;
            return this;
        }

        public ItemNoDescription build() {
            checkRequiredFields();
            return new ItemNoDescription(this);
        }
    }
}
