package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CTRModel extends Message {
    public static final String DEFAULT_BRAND = "";
    public static final Integer DEFAULT_CATID = 0;
    public static final Integer DEFAULT_CMTCOUNT = 0;
    public static final Double DEFAULT_CONVR;
    public static final Double DEFAULT_CTR;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIKECOUNT = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_OFFERCOUNT = 0;
    public static final Integer DEFAULT_POSITION = 0;
    public static final Double DEFAULT_PRICE;
    public static final Integer DEFAULT_RATINGBAD = 0;
    public static final Integer DEFAULT_RATINGGOOD = 0;
    public static final Integer DEFAULT_RATINGNORMAL = 0;
    public static final Integer DEFAULT_RECOMMEND = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOLD = 0;
    public static final Integer DEFAULT_STOCK = 0;
    public static final Integer DEFAULT_SUBCAT = 0;
    public static final String DEFAULT_TAGS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String brand;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer cmtCount;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double convr;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double ctr;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer likeCount;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer offerCount;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer position;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double price;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer ratingBad;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer ratingGood;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer ratingNormal;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer recommend;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer sold;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer stock;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer subcat;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String tags;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_CTR = valueOf;
        DEFAULT_CONVR = valueOf;
        DEFAULT_PRICE = valueOf;
    }

    public CTRModel(Long l, String str, Integer num, Double d2, Double d3, Integer num2, String str2, String str3, Double d4, String str4, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13) {
        this.itemid = l;
        this.keyword = str;
        this.position = num;
        this.ctr = d2;
        this.convr = d3;
        this.shopid = num2;
        this.name = str2;
        this.tags = str3;
        this.price = d4;
        this.brand = str4;
        this.catid = num3;
        this.subcat = num4;
        this.sold = num5;
        this.offerCount = num6;
        this.recommend = num7;
        this.cmtCount = num8;
        this.likeCount = num9;
        this.ratingGood = num10;
        this.ratingNormal = num11;
        this.ratingBad = num12;
        this.stock = num13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CTRModel(com.shopee.protocol.clickmodel.CTRModel.Builder r25) {
        /*
            r24 = this;
            r0 = r25
            r1 = r24
            java.lang.Long r2 = r0.itemid
            java.lang.String r3 = r0.keyword
            java.lang.Integer r4 = r0.position
            java.lang.Double r5 = r0.ctr
            java.lang.Double r6 = r0.convr
            java.lang.Integer r7 = r0.shopid
            java.lang.String r8 = r0.name
            java.lang.String r9 = r0.tags
            java.lang.Double r10 = r0.price
            java.lang.String r11 = r0.brand
            java.lang.Integer r12 = r0.catid
            java.lang.Integer r13 = r0.subcat
            java.lang.Integer r14 = r0.sold
            java.lang.Integer r15 = r0.offerCount
            r23 = r1
            java.lang.Integer r1 = r0.recommend
            r16 = r1
            java.lang.Integer r1 = r0.cmtCount
            r17 = r1
            java.lang.Integer r1 = r0.likeCount
            r18 = r1
            java.lang.Integer r1 = r0.ratingGood
            r19 = r1
            java.lang.Integer r1 = r0.ratingNormal
            r20 = r1
            java.lang.Integer r1 = r0.ratingBad
            r21 = r1
            java.lang.Integer r1 = r0.stock
            r22 = r1
            r1 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r24.setBuilder(r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.clickmodel.CTRModel.<init>(com.shopee.protocol.clickmodel.CTRModel$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CTRModel)) {
            return false;
        }
        CTRModel cTRModel = (CTRModel) obj;
        if (!equals((Object) this.itemid, (Object) cTRModel.itemid) || !equals((Object) this.keyword, (Object) cTRModel.keyword) || !equals((Object) this.position, (Object) cTRModel.position) || !equals((Object) this.ctr, (Object) cTRModel.ctr) || !equals((Object) this.convr, (Object) cTRModel.convr) || !equals((Object) this.shopid, (Object) cTRModel.shopid) || !equals((Object) this.name, (Object) cTRModel.name) || !equals((Object) this.tags, (Object) cTRModel.tags) || !equals((Object) this.price, (Object) cTRModel.price) || !equals((Object) this.brand, (Object) cTRModel.brand) || !equals((Object) this.catid, (Object) cTRModel.catid) || !equals((Object) this.subcat, (Object) cTRModel.subcat) || !equals((Object) this.sold, (Object) cTRModel.sold) || !equals((Object) this.offerCount, (Object) cTRModel.offerCount) || !equals((Object) this.recommend, (Object) cTRModel.recommend) || !equals((Object) this.cmtCount, (Object) cTRModel.cmtCount) || !equals((Object) this.likeCount, (Object) cTRModel.likeCount) || !equals((Object) this.ratingGood, (Object) cTRModel.ratingGood) || !equals((Object) this.ratingNormal, (Object) cTRModel.ratingNormal) || !equals((Object) this.ratingBad, (Object) cTRModel.ratingBad) || !equals((Object) this.stock, (Object) cTRModel.stock)) {
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
        String str = this.keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.position;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Double d2 = this.ctr;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.convr;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.tags;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Double d4 = this.price;
        int hashCode9 = (hashCode8 + (d4 != null ? d4.hashCode() : 0)) * 37;
        String str4 = this.brand;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.catid;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.subcat;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.sold;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.offerCount;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.recommend;
        int hashCode15 = (hashCode14 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.cmtCount;
        int hashCode16 = (hashCode15 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.likeCount;
        int hashCode17 = (hashCode16 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.ratingGood;
        int hashCode18 = (hashCode17 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.ratingNormal;
        int hashCode19 = (hashCode18 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.ratingBad;
        int hashCode20 = (hashCode19 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.stock;
        if (num13 != null) {
            i2 = num13.hashCode();
        }
        int i3 = hashCode20 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CTRModel> {
        public String brand;
        public Integer catid;
        public Integer cmtCount;
        public Double convr;
        public Double ctr;
        public Long itemid;
        public String keyword;
        public Integer likeCount;
        public String name;
        public Integer offerCount;
        public Integer position;
        public Double price;
        public Integer ratingBad;
        public Integer ratingGood;
        public Integer ratingNormal;
        public Integer recommend;
        public Integer shopid;
        public Integer sold;
        public Integer stock;
        public Integer subcat;
        public String tags;

        public Builder() {
        }

        public Builder(CTRModel cTRModel) {
            super(cTRModel);
            if (cTRModel != null) {
                this.itemid = cTRModel.itemid;
                this.keyword = cTRModel.keyword;
                this.position = cTRModel.position;
                this.ctr = cTRModel.ctr;
                this.convr = cTRModel.convr;
                this.shopid = cTRModel.shopid;
                this.name = cTRModel.name;
                this.tags = cTRModel.tags;
                this.price = cTRModel.price;
                this.brand = cTRModel.brand;
                this.catid = cTRModel.catid;
                this.subcat = cTRModel.subcat;
                this.sold = cTRModel.sold;
                this.offerCount = cTRModel.offerCount;
                this.recommend = cTRModel.recommend;
                this.cmtCount = cTRModel.cmtCount;
                this.likeCount = cTRModel.likeCount;
                this.ratingGood = cTRModel.ratingGood;
                this.ratingNormal = cTRModel.ratingNormal;
                this.ratingBad = cTRModel.ratingBad;
                this.stock = cTRModel.stock;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder position(Integer num) {
            this.position = num;
            return this;
        }

        public Builder ctr(Double d2) {
            this.ctr = d2;
            return this;
        }

        public Builder convr(Double d2) {
            this.convr = d2;
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

        public Builder tags(String str) {
            this.tags = str;
            return this;
        }

        public Builder price(Double d2) {
            this.price = d2;
            return this;
        }

        public Builder brand(String str) {
            this.brand = str;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder subcat(Integer num) {
            this.subcat = num;
            return this;
        }

        public Builder sold(Integer num) {
            this.sold = num;
            return this;
        }

        public Builder offerCount(Integer num) {
            this.offerCount = num;
            return this;
        }

        public Builder recommend(Integer num) {
            this.recommend = num;
            return this;
        }

        public Builder cmtCount(Integer num) {
            this.cmtCount = num;
            return this;
        }

        public Builder likeCount(Integer num) {
            this.likeCount = num;
            return this;
        }

        public Builder ratingGood(Integer num) {
            this.ratingGood = num;
            return this;
        }

        public Builder ratingNormal(Integer num) {
            this.ratingNormal = num;
            return this;
        }

        public Builder ratingBad(Integer num) {
            this.ratingBad = num;
            return this;
        }

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public CTRModel build() {
            return new CTRModel(this);
        }
    }
}
