package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Shop extends Message {
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final String DEFAULT_COLLECT_ADDRESS = "";
    public static final f DEFAULT_CONTACTS = f.f32736b;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_COVER = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Integer DEFAULT_ESCROW_OPTION = 0;
    public static final f DEFAULT_ESCROW_PAYMENT = f.f32736b;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_FLAG = 0L;
    public static final Integer DEFAULT_FOLLOWER_COUNT = 0;
    public static final String DEFAULT_IMAGES = "";
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final Double DEFAULT_LATITUDE;
    public static final Double DEFAULT_LONGITUDE;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final f DEFAULT_PAYMENT = f.f32736b;
    public static final String DEFAULT_PLACE = "";
    public static final Integer DEFAULT_POP = 0;
    public static final Integer DEFAULT_RATING_BAD = 0;
    public static final Integer DEFAULT_RATING_GOOD = 0;
    public static final Integer DEFAULT_RATING_NORMAL = 0;
    public static final f DEFAULT_SHIPMENT = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOLD_TOTAL = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String collect_address;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f contacts;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String cover;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer escrow_option;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f escrow_payment;
    @ProtoField(tag = 26, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 28, type = Message.Datatype.INT64)
    public final Long flag;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer follower_count;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String images;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(tag = 16, type = Message.Datatype.DOUBLE)
    public final Double latitude;
    @ProtoField(tag = 17, type = Message.Datatype.DOUBLE)
    public final Double longitude;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f payment;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String place;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer pop;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer rating_bad;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer rating_good;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer rating_normal;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f shipment;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer sold_total;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
    }

    public Shop(Integer num, Integer num2, String str, String str2, String str3, f fVar, Integer num3, Integer num4, Integer num5, String str4, f fVar2, f fVar3, Integer num6, f fVar4, String str5, Double d2, Double d3, String str6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, f fVar5, String str7, Long l, Integer num14) {
        this.shopid = num;
        this.userid = num2;
        this.name = str;
        this.description = str2;
        this.images = str3;
        this.contacts = fVar;
        this.ctime = num3;
        this.mtime = num4;
        this.status = num5;
        this.collect_address = str4;
        this.payment = fVar2;
        this.shipment = fVar3;
        this.escrow_option = num6;
        this.escrow_payment = fVar4;
        this.cover = str5;
        this.latitude = d2;
        this.longitude = d3;
        this.place = str6;
        this.pop = num7;
        this.rating_good = num8;
        this.rating_normal = num9;
        this.rating_bad = num10;
        this.sold_total = num11;
        this.item_count = num12;
        this.follower_count = num13;
        this.extinfo = fVar5;
        this.country = str7;
        this.flag = l;
        this.cb_option = num14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Shop(com.shopee.protocol.shop.Shop.Builder r33) {
        /*
            r32 = this;
            r0 = r33
            r1 = r32
            java.lang.Integer r2 = r0.shopid
            java.lang.Integer r3 = r0.userid
            java.lang.String r4 = r0.name
            java.lang.String r5 = r0.description
            java.lang.String r6 = r0.images
            e.f r7 = r0.contacts
            java.lang.Integer r8 = r0.ctime
            java.lang.Integer r9 = r0.mtime
            java.lang.Integer r10 = r0.status
            java.lang.String r11 = r0.collect_address
            e.f r12 = r0.payment
            e.f r13 = r0.shipment
            java.lang.Integer r14 = r0.escrow_option
            e.f r15 = r0.escrow_payment
            r31 = r1
            java.lang.String r1 = r0.cover
            r16 = r1
            java.lang.Double r1 = r0.latitude
            r17 = r1
            java.lang.Double r1 = r0.longitude
            r18 = r1
            java.lang.String r1 = r0.place
            r19 = r1
            java.lang.Integer r1 = r0.pop
            r20 = r1
            java.lang.Integer r1 = r0.rating_good
            r21 = r1
            java.lang.Integer r1 = r0.rating_normal
            r22 = r1
            java.lang.Integer r1 = r0.rating_bad
            r23 = r1
            java.lang.Integer r1 = r0.sold_total
            r24 = r1
            java.lang.Integer r1 = r0.item_count
            r25 = r1
            java.lang.Integer r1 = r0.follower_count
            r26 = r1
            e.f r1 = r0.extinfo
            r27 = r1
            java.lang.String r1 = r0.country
            r28 = r1
            java.lang.Long r1 = r0.flag
            r29 = r1
            java.lang.Integer r1 = r0.cb_option
            r30 = r1
            r1 = r31
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r32.setBuilder(r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Shop.<init>(com.shopee.protocol.shop.Shop$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Shop)) {
            return false;
        }
        Shop shop = (Shop) obj;
        if (!equals((Object) this.shopid, (Object) shop.shopid) || !equals((Object) this.userid, (Object) shop.userid) || !equals((Object) this.name, (Object) shop.name) || !equals((Object) this.description, (Object) shop.description) || !equals((Object) this.images, (Object) shop.images) || !equals((Object) this.contacts, (Object) shop.contacts) || !equals((Object) this.ctime, (Object) shop.ctime) || !equals((Object) this.mtime, (Object) shop.mtime) || !equals((Object) this.status, (Object) shop.status) || !equals((Object) this.collect_address, (Object) shop.collect_address) || !equals((Object) this.payment, (Object) shop.payment) || !equals((Object) this.shipment, (Object) shop.shipment) || !equals((Object) this.escrow_option, (Object) shop.escrow_option) || !equals((Object) this.escrow_payment, (Object) shop.escrow_payment) || !equals((Object) this.cover, (Object) shop.cover) || !equals((Object) this.latitude, (Object) shop.latitude) || !equals((Object) this.longitude, (Object) shop.longitude) || !equals((Object) this.place, (Object) shop.place) || !equals((Object) this.pop, (Object) shop.pop) || !equals((Object) this.rating_good, (Object) shop.rating_good) || !equals((Object) this.rating_normal, (Object) shop.rating_normal) || !equals((Object) this.rating_bad, (Object) shop.rating_bad) || !equals((Object) this.sold_total, (Object) shop.sold_total) || !equals((Object) this.item_count, (Object) shop.item_count) || !equals((Object) this.follower_count, (Object) shop.follower_count) || !equals((Object) this.extinfo, (Object) shop.extinfo) || !equals((Object) this.country, (Object) shop.country) || !equals((Object) this.flag, (Object) shop.flag) || !equals((Object) this.cb_option, (Object) shop.cb_option)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.images;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar = this.contacts;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.collect_address;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        f fVar2 = this.payment;
        int hashCode11 = (hashCode10 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.shipment;
        int hashCode12 = (hashCode11 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num6 = this.escrow_option;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar4 = this.escrow_payment;
        int hashCode14 = (hashCode13 + (fVar4 != null ? fVar4.hashCode() : 0)) * 37;
        String str5 = this.cover;
        int hashCode15 = (hashCode14 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Double d2 = this.latitude;
        int hashCode16 = (hashCode15 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.longitude;
        int hashCode17 = (hashCode16 + (d3 != null ? d3.hashCode() : 0)) * 37;
        String str6 = this.place;
        int hashCode18 = (hashCode17 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num7 = this.pop;
        int hashCode19 = (hashCode18 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.rating_good;
        int hashCode20 = (hashCode19 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.rating_normal;
        int hashCode21 = (hashCode20 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.rating_bad;
        int hashCode22 = (hashCode21 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.sold_total;
        int hashCode23 = (hashCode22 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.item_count;
        int hashCode24 = (hashCode23 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.follower_count;
        int hashCode25 = (hashCode24 + (num13 != null ? num13.hashCode() : 0)) * 37;
        f fVar5 = this.extinfo;
        int hashCode26 = (hashCode25 + (fVar5 != null ? fVar5.hashCode() : 0)) * 37;
        String str7 = this.country;
        int hashCode27 = (hashCode26 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Long l = this.flag;
        int hashCode28 = (hashCode27 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num14 = this.cb_option;
        if (num14 != null) {
            i2 = num14.hashCode();
        }
        int i3 = hashCode28 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Shop> {
        public Integer cb_option;
        public String collect_address;
        public f contacts;
        public String country;
        public String cover;
        public Integer ctime;
        public String description;
        public Integer escrow_option;
        public f escrow_payment;
        public f extinfo;
        public Long flag;
        public Integer follower_count;
        public String images;
        public Integer item_count;
        public Double latitude;
        public Double longitude;
        public Integer mtime;
        public String name;
        public f payment;
        public String place;
        public Integer pop;
        public Integer rating_bad;
        public Integer rating_good;
        public Integer rating_normal;
        public f shipment;
        public Integer shopid;
        public Integer sold_total;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(Shop shop) {
            super(shop);
            if (shop != null) {
                this.shopid = shop.shopid;
                this.userid = shop.userid;
                this.name = shop.name;
                this.description = shop.description;
                this.images = shop.images;
                this.contacts = shop.contacts;
                this.ctime = shop.ctime;
                this.mtime = shop.mtime;
                this.status = shop.status;
                this.collect_address = shop.collect_address;
                this.payment = shop.payment;
                this.shipment = shop.shipment;
                this.escrow_option = shop.escrow_option;
                this.escrow_payment = shop.escrow_payment;
                this.cover = shop.cover;
                this.latitude = shop.latitude;
                this.longitude = shop.longitude;
                this.place = shop.place;
                this.pop = shop.pop;
                this.rating_good = shop.rating_good;
                this.rating_normal = shop.rating_normal;
                this.rating_bad = shop.rating_bad;
                this.sold_total = shop.sold_total;
                this.item_count = shop.item_count;
                this.follower_count = shop.follower_count;
                this.extinfo = shop.extinfo;
                this.country = shop.country;
                this.flag = shop.flag;
                this.cb_option = shop.cb_option;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public Builder contacts(f fVar) {
            this.contacts = fVar;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder collect_address(String str) {
            this.collect_address = str;
            return this;
        }

        public Builder payment(f fVar) {
            this.payment = fVar;
            return this;
        }

        public Builder shipment(f fVar) {
            this.shipment = fVar;
            return this;
        }

        public Builder escrow_option(Integer num) {
            this.escrow_option = num;
            return this;
        }

        public Builder escrow_payment(f fVar) {
            this.escrow_payment = fVar;
            return this;
        }

        public Builder cover(String str) {
            this.cover = str;
            return this;
        }

        public Builder latitude(Double d2) {
            this.latitude = d2;
            return this;
        }

        public Builder longitude(Double d2) {
            this.longitude = d2;
            return this;
        }

        public Builder place(String str) {
            this.place = str;
            return this;
        }

        public Builder pop(Integer num) {
            this.pop = num;
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

        public Builder sold_total(Integer num) {
            this.sold_total = num;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Builder follower_count(Integer num) {
            this.follower_count = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder flag(Long l) {
            this.flag = l;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Shop build() {
            return new Shop(this);
        }
    }
}
