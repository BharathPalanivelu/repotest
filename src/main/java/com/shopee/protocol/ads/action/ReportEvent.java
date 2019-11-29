package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReportEvent extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final String DEFAULT_ALGO = "";
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_EVENT_TYPE = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_ORDER_AMOUNT = 0L;
    public static final Long DEFAULT_ORDER_GMV = 0L;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Long DEFAULT_POSITION = 0L;
    public static final Long DEFAULT_PRICE = 0L;
    public static final String DEFAULT_QUERY = "";
    public static final Integer DEFAULT_RANKING = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String algo;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer event_type;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer match_type;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long order_amount;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long order_gmv;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long position;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String query;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ranking;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long timestamp;

    public ReportEvent(Integer num, Long l, Long l2, Integer num2, String str, Long l3, Long l4, Long l5, Integer num3, String str2, Long l6, Long l7, String str3, Long l8, Long l9, Integer num4, Long l10, Integer num5, String str4) {
        this.event_type = num;
        this.timestamp = l;
        this.itemid = l2;
        this.shopid = num2;
        this.keyword = str;
        this.campaignid = l3;
        this.adsid = l4;
        this.price = l5;
        this.ranking = num3;
        this.country = str2;
        this.position = l6;
        this.orderid = l7;
        this.query = str3;
        this.order_amount = l8;
        this.order_gmv = l9;
        this.match_type = num4;
        this.modelid = l10;
        this.placement = num5;
        this.algo = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ReportEvent(com.shopee.protocol.ads.action.ReportEvent.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.Integer r2 = r0.event_type
            java.lang.Long r3 = r0.timestamp
            java.lang.Long r4 = r0.itemid
            java.lang.Integer r5 = r0.shopid
            java.lang.String r6 = r0.keyword
            java.lang.Long r7 = r0.campaignid
            java.lang.Long r8 = r0.adsid
            java.lang.Long r9 = r0.price
            java.lang.Integer r10 = r0.ranking
            java.lang.String r11 = r0.country
            java.lang.Long r12 = r0.position
            java.lang.Long r13 = r0.orderid
            java.lang.String r14 = r0.query
            java.lang.Long r15 = r0.order_amount
            r21 = r1
            java.lang.Long r1 = r0.order_gmv
            r16 = r1
            java.lang.Integer r1 = r0.match_type
            r17 = r1
            java.lang.Long r1 = r0.modelid
            r18 = r1
            java.lang.Integer r1 = r0.placement
            r19 = r1
            java.lang.String r1 = r0.algo
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.ads.action.ReportEvent.<init>(com.shopee.protocol.ads.action.ReportEvent$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReportEvent)) {
            return false;
        }
        ReportEvent reportEvent = (ReportEvent) obj;
        if (!equals((Object) this.event_type, (Object) reportEvent.event_type) || !equals((Object) this.timestamp, (Object) reportEvent.timestamp) || !equals((Object) this.itemid, (Object) reportEvent.itemid) || !equals((Object) this.shopid, (Object) reportEvent.shopid) || !equals((Object) this.keyword, (Object) reportEvent.keyword) || !equals((Object) this.campaignid, (Object) reportEvent.campaignid) || !equals((Object) this.adsid, (Object) reportEvent.adsid) || !equals((Object) this.price, (Object) reportEvent.price) || !equals((Object) this.ranking, (Object) reportEvent.ranking) || !equals((Object) this.country, (Object) reportEvent.country) || !equals((Object) this.position, (Object) reportEvent.position) || !equals((Object) this.orderid, (Object) reportEvent.orderid) || !equals((Object) this.query, (Object) reportEvent.query) || !equals((Object) this.order_amount, (Object) reportEvent.order_amount) || !equals((Object) this.order_gmv, (Object) reportEvent.order_gmv) || !equals((Object) this.match_type, (Object) reportEvent.match_type) || !equals((Object) this.modelid, (Object) reportEvent.modelid) || !equals((Object) this.placement, (Object) reportEvent.placement) || !equals((Object) this.algo, (Object) reportEvent.algo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.event_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.timestamp;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.keyword;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.campaignid;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.adsid;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.price;
        int hashCode8 = (hashCode7 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num3 = this.ranking;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l6 = this.position;
        int hashCode11 = (hashCode10 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.orderid;
        int hashCode12 = (hashCode11 + (l7 != null ? l7.hashCode() : 0)) * 37;
        String str3 = this.query;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l8 = this.order_amount;
        int hashCode14 = (hashCode13 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.order_gmv;
        int hashCode15 = (hashCode14 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Integer num4 = this.match_type;
        int hashCode16 = (hashCode15 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l10 = this.modelid;
        int hashCode17 = (hashCode16 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Integer num5 = this.placement;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.algo;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReportEvent> {
        public Long adsid;
        public String algo;
        public Long campaignid;
        public String country;
        public Integer event_type;
        public Long itemid;
        public String keyword;
        public Integer match_type;
        public Long modelid;
        public Long order_amount;
        public Long order_gmv;
        public Long orderid;
        public Integer placement;
        public Long position;
        public Long price;
        public String query;
        public Integer ranking;
        public Integer shopid;
        public Long timestamp;

        public Builder() {
        }

        public Builder(ReportEvent reportEvent) {
            super(reportEvent);
            if (reportEvent != null) {
                this.event_type = reportEvent.event_type;
                this.timestamp = reportEvent.timestamp;
                this.itemid = reportEvent.itemid;
                this.shopid = reportEvent.shopid;
                this.keyword = reportEvent.keyword;
                this.campaignid = reportEvent.campaignid;
                this.adsid = reportEvent.adsid;
                this.price = reportEvent.price;
                this.ranking = reportEvent.ranking;
                this.country = reportEvent.country;
                this.position = reportEvent.position;
                this.orderid = reportEvent.orderid;
                this.query = reportEvent.query;
                this.order_amount = reportEvent.order_amount;
                this.order_gmv = reportEvent.order_gmv;
                this.match_type = reportEvent.match_type;
                this.modelid = reportEvent.modelid;
                this.placement = reportEvent.placement;
                this.algo = reportEvent.algo;
            }
        }

        public Builder event_type(Integer num) {
            this.event_type = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
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

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder ranking(Integer num) {
            this.ranking = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder position(Long l) {
            this.position = l;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder query(String str) {
            this.query = str;
            return this;
        }

        public Builder order_amount(Long l) {
            this.order_amount = l;
            return this;
        }

        public Builder order_gmv(Long l) {
            this.order_gmv = l;
            return this;
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public Builder algo(String str) {
            this.algo = str;
            return this;
        }

        public ReportEvent build() {
            return new ReportEvent(this);
        }
    }
}
