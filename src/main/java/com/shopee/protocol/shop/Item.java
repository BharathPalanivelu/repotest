package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Item extends Message {
    public static final String DEFAULT_BRAND = "";
    public static final Integer DEFAULT_CATID = 0;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final Integer DEFAULT_CMT_COUNT = 0;
    public static final String DEFAULT_COLLECT_ADDRESS = "";
    public static final Integer DEFAULT_CONDITION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_FLAG = 0;
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
    public static final String DEFAULT_SKU = "";
    public static final Integer DEFAULT_SOLD = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOCK = 0;
    public static final Integer DEFAULT_STOCKOUT_TIME = 0;
    public static final Integer DEFAULT_TOUCH_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String brand;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer cmt_count;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String collect_address;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer condition;
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
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer flag;
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
    @ProtoField(tag = 36, type = Message.Datatype.STRING)
    public final String sku;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer sold;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer stock;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer stockout_time;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer touch_time;

    public Item(Long l, Integer num, String str, String str2, String str3, Long l2, String str4, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l3, Long l4, Integer num7, String str5, Integer num8, Integer num9, Integer num10, Integer num11, String str6, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, String str7, Integer num17, f fVar, Integer num18, Integer num19, Integer num20, Integer num21, String str8) {
        this.itemid = l;
        this.shopid = num;
        this.name = str;
        this.description = str2;
        this.images = str3;
        this.price = l2;
        this.currency = str4;
        this.stock = num2;
        this.status = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.sold = num6;
        this.price_min = l3;
        this.price_max = l4;
        this.recommend = num7;
        this.collect_address = str5;
        this.catid = num8;
        this.pop = num9;
        this.liked_count = num10;
        this.offer_count = num11;
        this.brand = str6;
        this.condition = num12;
        this.rating_good = num13;
        this.rating_normal = num14;
        this.rating_bad = num15;
        this.cmt_count = num16;
        this.country = str7;
        this.option = num17;
        this.extinfo = fVar;
        this.stockout_time = num18;
        this.touch_time = num19;
        this.flag = num20;
        this.cb_option = num21;
        this.sku = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Item(com.shopee.protocol.shop.Item.Builder r38) {
        /*
            r37 = this;
            r0 = r38
            r1 = r37
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.shopid
            java.lang.String r4 = r0.name
            java.lang.String r5 = r0.description
            java.lang.String r6 = r0.images
            java.lang.Long r7 = r0.price
            java.lang.String r8 = r0.currency
            java.lang.Integer r9 = r0.stock
            java.lang.Integer r10 = r0.status
            java.lang.Integer r11 = r0.ctime
            java.lang.Integer r12 = r0.mtime
            java.lang.Integer r13 = r0.sold
            java.lang.Long r14 = r0.price_min
            java.lang.Long r15 = r0.price_max
            r36 = r1
            java.lang.Integer r1 = r0.recommend
            r16 = r1
            java.lang.String r1 = r0.collect_address
            r17 = r1
            java.lang.Integer r1 = r0.catid
            r18 = r1
            java.lang.Integer r1 = r0.pop
            r19 = r1
            java.lang.Integer r1 = r0.liked_count
            r20 = r1
            java.lang.Integer r1 = r0.offer_count
            r21 = r1
            java.lang.String r1 = r0.brand
            r22 = r1
            java.lang.Integer r1 = r0.condition
            r23 = r1
            java.lang.Integer r1 = r0.rating_good
            r24 = r1
            java.lang.Integer r1 = r0.rating_normal
            r25 = r1
            java.lang.Integer r1 = r0.rating_bad
            r26 = r1
            java.lang.Integer r1 = r0.cmt_count
            r27 = r1
            java.lang.String r1 = r0.country
            r28 = r1
            java.lang.Integer r1 = r0.option
            r29 = r1
            e.f r1 = r0.extinfo
            r30 = r1
            java.lang.Integer r1 = r0.stockout_time
            r31 = r1
            java.lang.Integer r1 = r0.touch_time
            r32 = r1
            java.lang.Integer r1 = r0.flag
            r33 = r1
            java.lang.Integer r1 = r0.cb_option
            r34 = r1
            java.lang.String r1 = r0.sku
            r35 = r1
            r1 = r36
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            r37.setBuilder(r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Item.<init>(com.shopee.protocol.shop.Item$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        if (!equals((Object) this.itemid, (Object) item.itemid) || !equals((Object) this.shopid, (Object) item.shopid) || !equals((Object) this.name, (Object) item.name) || !equals((Object) this.description, (Object) item.description) || !equals((Object) this.images, (Object) item.images) || !equals((Object) this.price, (Object) item.price) || !equals((Object) this.currency, (Object) item.currency) || !equals((Object) this.stock, (Object) item.stock) || !equals((Object) this.status, (Object) item.status) || !equals((Object) this.ctime, (Object) item.ctime) || !equals((Object) this.mtime, (Object) item.mtime) || !equals((Object) this.sold, (Object) item.sold) || !equals((Object) this.price_min, (Object) item.price_min) || !equals((Object) this.price_max, (Object) item.price_max) || !equals((Object) this.recommend, (Object) item.recommend) || !equals((Object) this.collect_address, (Object) item.collect_address) || !equals((Object) this.catid, (Object) item.catid) || !equals((Object) this.pop, (Object) item.pop) || !equals((Object) this.liked_count, (Object) item.liked_count) || !equals((Object) this.offer_count, (Object) item.offer_count) || !equals((Object) this.brand, (Object) item.brand) || !equals((Object) this.condition, (Object) item.condition) || !equals((Object) this.rating_good, (Object) item.rating_good) || !equals((Object) this.rating_normal, (Object) item.rating_normal) || !equals((Object) this.rating_bad, (Object) item.rating_bad) || !equals((Object) this.cmt_count, (Object) item.cmt_count) || !equals((Object) this.country, (Object) item.country) || !equals((Object) this.option, (Object) item.option) || !equals((Object) this.extinfo, (Object) item.extinfo) || !equals((Object) this.stockout_time, (Object) item.stockout_time) || !equals((Object) this.touch_time, (Object) item.touch_time) || !equals((Object) this.flag, (Object) item.flag) || !equals((Object) this.cb_option, (Object) item.cb_option) || !equals((Object) this.sku, (Object) item.sku)) {
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
        Integer num4 = this.ctime;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.sold;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l3 = this.price_min;
        int hashCode13 = (hashCode12 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.price_max;
        int hashCode14 = (hashCode13 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num7 = this.recommend;
        int hashCode15 = (hashCode14 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str5 = this.collect_address;
        int hashCode16 = (hashCode15 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num8 = this.catid;
        int hashCode17 = (hashCode16 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.pop;
        int hashCode18 = (hashCode17 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.liked_count;
        int hashCode19 = (hashCode18 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.offer_count;
        int hashCode20 = (hashCode19 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str6 = this.brand;
        int hashCode21 = (hashCode20 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num12 = this.condition;
        int hashCode22 = (hashCode21 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.rating_good;
        int hashCode23 = (hashCode22 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.rating_normal;
        int hashCode24 = (hashCode23 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.rating_bad;
        int hashCode25 = (hashCode24 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.cmt_count;
        int hashCode26 = (hashCode25 + (num16 != null ? num16.hashCode() : 0)) * 37;
        String str7 = this.country;
        int hashCode27 = (hashCode26 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num17 = this.option;
        int hashCode28 = (hashCode27 + (num17 != null ? num17.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode29 = (hashCode28 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num18 = this.stockout_time;
        int hashCode30 = (hashCode29 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.touch_time;
        int hashCode31 = (hashCode30 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.flag;
        int hashCode32 = (hashCode31 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.cb_option;
        int hashCode33 = (hashCode32 + (num21 != null ? num21.hashCode() : 0)) * 37;
        String str8 = this.sku;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode33 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Item> {
        public String brand;
        public Integer catid;
        public Integer cb_option;
        public Integer cmt_count;
        public String collect_address;
        public Integer condition;
        public String country;
        public Integer ctime;
        public String currency;
        public String description;
        public f extinfo;
        public Integer flag;
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
        public String sku;
        public Integer sold;
        public Integer status;
        public Integer stock;
        public Integer stockout_time;
        public Integer touch_time;

        public Builder() {
        }

        public Builder(Item item) {
            super(item);
            if (item != null) {
                this.itemid = item.itemid;
                this.shopid = item.shopid;
                this.name = item.name;
                this.description = item.description;
                this.images = item.images;
                this.price = item.price;
                this.currency = item.currency;
                this.stock = item.stock;
                this.status = item.status;
                this.ctime = item.ctime;
                this.mtime = item.mtime;
                this.sold = item.sold;
                this.price_min = item.price_min;
                this.price_max = item.price_max;
                this.recommend = item.recommend;
                this.collect_address = item.collect_address;
                this.catid = item.catid;
                this.pop = item.pop;
                this.liked_count = item.liked_count;
                this.offer_count = item.offer_count;
                this.brand = item.brand;
                this.condition = item.condition;
                this.rating_good = item.rating_good;
                this.rating_normal = item.rating_normal;
                this.rating_bad = item.rating_bad;
                this.cmt_count = item.cmt_count;
                this.country = item.country;
                this.option = item.option;
                this.extinfo = item.extinfo;
                this.stockout_time = item.stockout_time;
                this.touch_time = item.touch_time;
                this.flag = item.flag;
                this.cb_option = item.cb_option;
                this.sku = item.sku;
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

        public Builder collect_address(String str) {
            this.collect_address = str;
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

        public Builder touch_time(Integer num) {
            this.touch_time = num;
            return this;
        }

        public Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Builder sku(String str) {
            this.sku = str;
            return this;
        }

        public Item build() {
            checkRequiredFields();
            return new Item(this);
        }
    }
}
