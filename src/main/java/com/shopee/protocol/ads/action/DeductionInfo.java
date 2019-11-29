package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DeductionInfo extends Message {
    public static final String DEFAULT_ALGO_NAME = "";
    public static final Long DEFAULT_BIDPRICE = 0L;
    public static final Long DEFAULT_NEXT_ADSID = 0L;
    public static final String DEFAULT_NEXT_ADS_KEYWORD = "";
    public static final Double DEFAULT_NEXT_SCORE;
    public static final Double DEFAULT_QUALITY;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String algo_name;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long bidprice;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String next_ads_keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long next_adsid;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double next_score;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double quality;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_QUALITY = valueOf;
        DEFAULT_NEXT_SCORE = valueOf;
    }

    public DeductionInfo(Double d2, Long l, Double d3, Long l2, String str, String str2) {
        this.quality = d2;
        this.bidprice = l;
        this.next_score = d3;
        this.next_adsid = l2;
        this.next_ads_keyword = str;
        this.algo_name = str2;
    }

    private DeductionInfo(Builder builder) {
        this(builder.quality, builder.bidprice, builder.next_score, builder.next_adsid, builder.next_ads_keyword, builder.algo_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeductionInfo)) {
            return false;
        }
        DeductionInfo deductionInfo = (DeductionInfo) obj;
        if (!equals((Object) this.quality, (Object) deductionInfo.quality) || !equals((Object) this.bidprice, (Object) deductionInfo.bidprice) || !equals((Object) this.next_score, (Object) deductionInfo.next_score) || !equals((Object) this.next_adsid, (Object) deductionInfo.next_adsid) || !equals((Object) this.next_ads_keyword, (Object) deductionInfo.next_ads_keyword) || !equals((Object) this.algo_name, (Object) deductionInfo.algo_name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d2 = this.quality;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 37;
        Long l = this.bidprice;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Double d3 = this.next_score;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Long l2 = this.next_adsid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.next_ads_keyword;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.algo_name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeductionInfo> {
        public String algo_name;
        public Long bidprice;
        public String next_ads_keyword;
        public Long next_adsid;
        public Double next_score;
        public Double quality;

        public Builder() {
        }

        public Builder(DeductionInfo deductionInfo) {
            super(deductionInfo);
            if (deductionInfo != null) {
                this.quality = deductionInfo.quality;
                this.bidprice = deductionInfo.bidprice;
                this.next_score = deductionInfo.next_score;
                this.next_adsid = deductionInfo.next_adsid;
                this.next_ads_keyword = deductionInfo.next_ads_keyword;
                this.algo_name = deductionInfo.algo_name;
            }
        }

        public Builder quality(Double d2) {
            this.quality = d2;
            return this;
        }

        public Builder bidprice(Long l) {
            this.bidprice = l;
            return this;
        }

        public Builder next_score(Double d2) {
            this.next_score = d2;
            return this;
        }

        public Builder next_adsid(Long l) {
            this.next_adsid = l;
            return this;
        }

        public Builder next_ads_keyword(String str) {
            this.next_ads_keyword = str;
            return this;
        }

        public Builder algo_name(String str) {
            this.algo_name = str;
            return this;
        }

        public DeductionInfo build() {
            return new DeductionInfo(this);
        }
    }
}
