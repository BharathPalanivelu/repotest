package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class ResultItem extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final String DEFAULT_ADS_KEYWORD = "";
    public static final String DEFAULT_ATTR_BRAND = "";
    public static final Integer DEFAULT_ATTR_BRAND_ID = 0;
    public static final Double DEFAULT_ATTR_SCORE;
    public static final Integer DEFAULT_ATTR_VIDEO = 0;
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_DEBUGINFO = f.f32736b;
    public static final String DEFAULT_DEDUCTION_INFO = "";
    public static final Double DEFAULT_DISTANCE;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_JSON_DATA = "";
    public static final String DEFAULT_KEYWORD = "";
    public static final List<Integer> DEFAULT_LOGISTICID = Collections.emptyList();
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    public static final Integer DEFAULT_OFFICIAL_SHOP = 0;
    public static final Integer DEFAULT_PREFERRED_SHOP = 0;
    public static final List<Integer> DEFAULT_SBS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String ads_keyword;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String attr_brand;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer attr_brand_id;
    @ProtoField(tag = 15, type = Message.Datatype.DOUBLE)
    public final Double attr_score;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer attr_video;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f debuginfo;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String deduction_info;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double distance;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT32)
    public final List<Integer> logisticid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer match_type;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer official_shop;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer preferred_shop;
    @ProtoField(label = Message.Label.REPEATED, tag = 18, type = Message.Datatype.INT32)
    public final List<Integer> sbs;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_DISTANCE = valueOf;
        DEFAULT_ATTR_SCORE = valueOf;
    }

    public ResultItem(Long l, Integer num, Double d2, Integer num2, Long l2, Long l3, String str, String str2, f fVar, List<Integer> list, Integer num3, String str3, String str4, Integer num4, Double d3, Integer num5, Integer num6, List<Integer> list2, String str5, Integer num7) {
        this.itemid = l;
        this.shopid = num;
        this.distance = d2;
        this.ctime = num2;
        this.campaignid = l2;
        this.adsid = l3;
        this.ads_keyword = str;
        this.keyword = str2;
        this.debuginfo = fVar;
        this.logisticid = immutableCopyOf(list);
        this.match_type = num3;
        this.deduction_info = str3;
        this.attr_brand = str4;
        this.attr_brand_id = num4;
        this.attr_score = d3;
        this.official_shop = num5;
        this.preferred_shop = num6;
        this.sbs = immutableCopyOf(list2);
        this.json_data = str5;
        this.attr_video = num7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ResultItem(com.shopee.protocol.search.action.ResultItem.Builder r24) {
        /*
            r23 = this;
            r0 = r24
            r1 = r23
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.shopid
            java.lang.Double r4 = r0.distance
            java.lang.Integer r5 = r0.ctime
            java.lang.Long r6 = r0.campaignid
            java.lang.Long r7 = r0.adsid
            java.lang.String r8 = r0.ads_keyword
            java.lang.String r9 = r0.keyword
            e.f r10 = r0.debuginfo
            java.util.List<java.lang.Integer> r11 = r0.logisticid
            java.lang.Integer r12 = r0.match_type
            java.lang.String r13 = r0.deduction_info
            java.lang.String r14 = r0.attr_brand
            java.lang.Integer r15 = r0.attr_brand_id
            r22 = r1
            java.lang.Double r1 = r0.attr_score
            r16 = r1
            java.lang.Integer r1 = r0.official_shop
            r17 = r1
            java.lang.Integer r1 = r0.preferred_shop
            r18 = r1
            java.util.List<java.lang.Integer> r1 = r0.sbs
            r19 = r1
            java.lang.String r1 = r0.json_data
            r20 = r1
            java.lang.Integer r1 = r0.attr_video
            r21 = r1
            r1 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r23.setBuilder(r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.search.action.ResultItem.<init>(com.shopee.protocol.search.action.ResultItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResultItem)) {
            return false;
        }
        ResultItem resultItem = (ResultItem) obj;
        if (!equals((Object) this.itemid, (Object) resultItem.itemid) || !equals((Object) this.shopid, (Object) resultItem.shopid) || !equals((Object) this.distance, (Object) resultItem.distance) || !equals((Object) this.ctime, (Object) resultItem.ctime) || !equals((Object) this.campaignid, (Object) resultItem.campaignid) || !equals((Object) this.adsid, (Object) resultItem.adsid) || !equals((Object) this.ads_keyword, (Object) resultItem.ads_keyword) || !equals((Object) this.keyword, (Object) resultItem.keyword) || !equals((Object) this.debuginfo, (Object) resultItem.debuginfo) || !equals((List<?>) this.logisticid, (List<?>) resultItem.logisticid) || !equals((Object) this.match_type, (Object) resultItem.match_type) || !equals((Object) this.deduction_info, (Object) resultItem.deduction_info) || !equals((Object) this.attr_brand, (Object) resultItem.attr_brand) || !equals((Object) this.attr_brand_id, (Object) resultItem.attr_brand_id) || !equals((Object) this.attr_score, (Object) resultItem.attr_score) || !equals((Object) this.official_shop, (Object) resultItem.official_shop) || !equals((Object) this.preferred_shop, (Object) resultItem.preferred_shop) || !equals((List<?>) this.sbs, (List<?>) resultItem.sbs) || !equals((Object) this.json_data, (Object) resultItem.json_data) || !equals((Object) this.attr_video, (Object) resultItem.attr_video)) {
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
        Double d2 = this.distance;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.campaignid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.adsid;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str = this.ads_keyword;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.keyword;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.debuginfo;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        List<Integer> list = this.logisticid;
        int i3 = 1;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num3 = this.match_type;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.deduction_info;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.attr_brand;
        int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.attr_brand_id;
        int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Double d3 = this.attr_score;
        int hashCode15 = (hashCode14 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Integer num5 = this.official_shop;
        int hashCode16 = (hashCode15 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.preferred_shop;
        int hashCode17 = (hashCode16 + (num6 != null ? num6.hashCode() : 0)) * 37;
        List<Integer> list2 = this.sbs;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode17 + i3) * 37;
        String str5 = this.json_data;
        int hashCode18 = (i4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num7 = this.attr_video;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i5 = hashCode18 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResultItem> {
        public String ads_keyword;
        public Long adsid;
        public String attr_brand;
        public Integer attr_brand_id;
        public Double attr_score;
        public Integer attr_video;
        public Long campaignid;
        public Integer ctime;
        public f debuginfo;
        public String deduction_info;
        public Double distance;
        public Long itemid;
        public String json_data;
        public String keyword;
        public List<Integer> logisticid;
        public Integer match_type;
        public Integer official_shop;
        public Integer preferred_shop;
        public List<Integer> sbs;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ResultItem resultItem) {
            super(resultItem);
            if (resultItem != null) {
                this.itemid = resultItem.itemid;
                this.shopid = resultItem.shopid;
                this.distance = resultItem.distance;
                this.ctime = resultItem.ctime;
                this.campaignid = resultItem.campaignid;
                this.adsid = resultItem.adsid;
                this.ads_keyword = resultItem.ads_keyword;
                this.keyword = resultItem.keyword;
                this.debuginfo = resultItem.debuginfo;
                this.logisticid = ResultItem.copyOf(resultItem.logisticid);
                this.match_type = resultItem.match_type;
                this.deduction_info = resultItem.deduction_info;
                this.attr_brand = resultItem.attr_brand;
                this.attr_brand_id = resultItem.attr_brand_id;
                this.attr_score = resultItem.attr_score;
                this.official_shop = resultItem.official_shop;
                this.preferred_shop = resultItem.preferred_shop;
                this.sbs = ResultItem.copyOf(resultItem.sbs);
                this.json_data = resultItem.json_data;
                this.attr_video = resultItem.attr_video;
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

        public Builder distance(Double d2) {
            this.distance = d2;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder ads_keyword(String str) {
            this.ads_keyword = str;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder debuginfo(f fVar) {
            this.debuginfo = fVar;
            return this;
        }

        public Builder logisticid(List<Integer> list) {
            this.logisticid = checkForNulls(list);
            return this;
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public Builder deduction_info(String str) {
            this.deduction_info = str;
            return this;
        }

        public Builder attr_brand(String str) {
            this.attr_brand = str;
            return this;
        }

        public Builder attr_brand_id(Integer num) {
            this.attr_brand_id = num;
            return this;
        }

        public Builder attr_score(Double d2) {
            this.attr_score = d2;
            return this;
        }

        public Builder official_shop(Integer num) {
            this.official_shop = num;
            return this;
        }

        public Builder preferred_shop(Integer num) {
            this.preferred_shop = num;
            return this;
        }

        public Builder sbs(List<Integer> list) {
            this.sbs = checkForNulls(list);
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public Builder attr_video(Integer num) {
            this.attr_video = num;
            return this;
        }

        public ResultItem build() {
            return new ResultItem(this);
        }
    }
}
