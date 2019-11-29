package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class QueryAdsRecall extends Message {
    public static final Long DEFAULT_DATE = 0L;
    public static final String DEFAULT_QUERY = "";
    public static final Long DEFAULT_QUERY_VOLUME = 0L;
    public static final Integer DEFAULT_RECALL_NUM = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long date;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String query;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long query_volume;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer recall_num;

    public QueryAdsRecall(Long l, String str, Long l2, Integer num) {
        this.date = l;
        this.query = str;
        this.query_volume = l2;
        this.recall_num = num;
    }

    private QueryAdsRecall(Builder builder) {
        this(builder.date, builder.query, builder.query_volume, builder.recall_num);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryAdsRecall)) {
            return false;
        }
        QueryAdsRecall queryAdsRecall = (QueryAdsRecall) obj;
        if (!equals((Object) this.date, (Object) queryAdsRecall.date) || !equals((Object) this.query, (Object) queryAdsRecall.query) || !equals((Object) this.query_volume, (Object) queryAdsRecall.query_volume) || !equals((Object) this.recall_num, (Object) queryAdsRecall.recall_num)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.date;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.query;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.query_volume;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.recall_num;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<QueryAdsRecall> {
        public Long date;
        public String query;
        public Long query_volume;
        public Integer recall_num;

        public Builder() {
        }

        public Builder(QueryAdsRecall queryAdsRecall) {
            super(queryAdsRecall);
            if (queryAdsRecall != null) {
                this.date = queryAdsRecall.date;
                this.query = queryAdsRecall.query;
                this.query_volume = queryAdsRecall.query_volume;
                this.recall_num = queryAdsRecall.recall_num;
            }
        }

        public Builder date(Long l) {
            this.date = l;
            return this;
        }

        public Builder query(String str) {
            this.query = str;
            return this;
        }

        public Builder query_volume(Long l) {
            this.query_volume = l;
            return this;
        }

        public Builder recall_num(Integer num) {
            this.recall_num = num;
            return this;
        }

        public QueryAdsRecall build() {
            return new QueryAdsRecall(this);
        }
    }
}
