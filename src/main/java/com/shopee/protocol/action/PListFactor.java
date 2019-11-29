package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PListFactor extends Message {
    public static final Double DEFAULT_BOOST;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_HT_CNT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIKE3 = 0;
    public static final Integer DEFAULT_LIKE30 = 0;
    public static final Integer DEFAULT_PARENT_CATEGORY = 0;
    public static final Double DEFAULT_RANDOM;
    public static final Integer DEFAULT_SALE3 = 0;
    public static final Integer DEFAULT_SALE30 = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SHOP_DUPLICATE_SCORE = 0;
    public static final Double DEFAULT_SHOP_SCORE;
    public static final Integer DEFAULT_SUB_CATEGORY = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double boost;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer ht_cnt;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer like3;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer like30;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer parent_category;
    @ProtoField(tag = 10, type = Message.Datatype.DOUBLE)
    public final Double random;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer sale3;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer sale30;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer shop_duplicate_score;
    @ProtoField(tag = 14, type = Message.Datatype.DOUBLE)
    public final Double shop_score;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer sub_category;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_RANDOM = valueOf;
        DEFAULT_BOOST = valueOf;
        DEFAULT_SHOP_SCORE = valueOf;
    }

    public PListFactor(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str, Double d2, Double d3, Integer num8, Integer num9, Double d4, Integer num10) {
        this.itemid = l;
        this.shopid = num;
        this.sale3 = num2;
        this.sale30 = num3;
        this.like3 = num4;
        this.like30 = num5;
        this.parent_category = num6;
        this.sub_category = num7;
        this.country = str;
        this.random = d2;
        this.boost = d3;
        this.ctime = num8;
        this.ht_cnt = num9;
        this.shop_score = d4;
        this.shop_duplicate_score = num10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PListFactor(com.shopee.protocol.action.PListFactor.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.shopid
            java.lang.Integer r4 = r0.sale3
            java.lang.Integer r5 = r0.sale30
            java.lang.Integer r6 = r0.like3
            java.lang.Integer r7 = r0.like30
            java.lang.Integer r8 = r0.parent_category
            java.lang.Integer r9 = r0.sub_category
            java.lang.String r10 = r0.country
            java.lang.Double r11 = r0.random
            java.lang.Double r12 = r0.boost
            java.lang.Integer r13 = r0.ctime
            java.lang.Integer r14 = r0.ht_cnt
            java.lang.Double r15 = r0.shop_score
            java.lang.Integer r1 = r0.shop_duplicate_score
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.PListFactor.<init>(com.shopee.protocol.action.PListFactor$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListFactor)) {
            return false;
        }
        PListFactor pListFactor = (PListFactor) obj;
        if (!equals((Object) this.itemid, (Object) pListFactor.itemid) || !equals((Object) this.shopid, (Object) pListFactor.shopid) || !equals((Object) this.sale3, (Object) pListFactor.sale3) || !equals((Object) this.sale30, (Object) pListFactor.sale30) || !equals((Object) this.like3, (Object) pListFactor.like3) || !equals((Object) this.like30, (Object) pListFactor.like30) || !equals((Object) this.parent_category, (Object) pListFactor.parent_category) || !equals((Object) this.sub_category, (Object) pListFactor.sub_category) || !equals((Object) this.country, (Object) pListFactor.country) || !equals((Object) this.random, (Object) pListFactor.random) || !equals((Object) this.boost, (Object) pListFactor.boost) || !equals((Object) this.ctime, (Object) pListFactor.ctime) || !equals((Object) this.ht_cnt, (Object) pListFactor.ht_cnt) || !equals((Object) this.shop_score, (Object) pListFactor.shop_score) || !equals((Object) this.shop_duplicate_score, (Object) pListFactor.shop_duplicate_score)) {
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
        Integer num2 = this.sale3;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.sale30;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.like3;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.like30;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.parent_category;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.sub_category;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        Double d2 = this.random;
        int hashCode10 = (hashCode9 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.boost;
        int hashCode11 = (hashCode10 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Integer num8 = this.ctime;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.ht_cnt;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Double d4 = this.shop_score;
        int hashCode14 = (hashCode13 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num10 = this.shop_duplicate_score;
        if (num10 != null) {
            i2 = num10.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListFactor> {
        public Double boost;
        public String country;
        public Integer ctime;
        public Integer ht_cnt;
        public Long itemid;
        public Integer like3;
        public Integer like30;
        public Integer parent_category;
        public Double random;
        public Integer sale3;
        public Integer sale30;
        public Integer shop_duplicate_score;
        public Double shop_score;
        public Integer shopid;
        public Integer sub_category;

        public Builder() {
        }

        public Builder(PListFactor pListFactor) {
            super(pListFactor);
            if (pListFactor != null) {
                this.itemid = pListFactor.itemid;
                this.shopid = pListFactor.shopid;
                this.sale3 = pListFactor.sale3;
                this.sale30 = pListFactor.sale30;
                this.like3 = pListFactor.like3;
                this.like30 = pListFactor.like30;
                this.parent_category = pListFactor.parent_category;
                this.sub_category = pListFactor.sub_category;
                this.country = pListFactor.country;
                this.random = pListFactor.random;
                this.boost = pListFactor.boost;
                this.ctime = pListFactor.ctime;
                this.ht_cnt = pListFactor.ht_cnt;
                this.shop_score = pListFactor.shop_score;
                this.shop_duplicate_score = pListFactor.shop_duplicate_score;
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

        public Builder sale3(Integer num) {
            this.sale3 = num;
            return this;
        }

        public Builder sale30(Integer num) {
            this.sale30 = num;
            return this;
        }

        public Builder like3(Integer num) {
            this.like3 = num;
            return this;
        }

        public Builder like30(Integer num) {
            this.like30 = num;
            return this;
        }

        public Builder parent_category(Integer num) {
            this.parent_category = num;
            return this;
        }

        public Builder sub_category(Integer num) {
            this.sub_category = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder random(Double d2) {
            this.random = d2;
            return this;
        }

        public Builder boost(Double d2) {
            this.boost = d2;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder ht_cnt(Integer num) {
            this.ht_cnt = num;
            return this;
        }

        public Builder shop_score(Double d2) {
            this.shop_score = d2;
            return this;
        }

        public Builder shop_duplicate_score(Integer num) {
            this.shop_duplicate_score = num;
            return this;
        }

        public PListFactor build() {
            return new PListFactor(this);
        }
    }
}
