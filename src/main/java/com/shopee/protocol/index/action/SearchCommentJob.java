package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class SearchCommentJob extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final List<Integer> DEFAULT_FILTER = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final Double DEFAULT_SCORE;
    public static final Double DEFAULT_SCOREV2;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> filter;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double score;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double scoreV2;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_SCORE = valueOf;
        DEFAULT_SCOREV2 = valueOf;
    }

    public SearchCommentJob(Integer num, Long l, Long l2, Long l3, Double d2, List<Integer> list, String str, f fVar, Double d3) {
        this.type = num;
        this.itemid = l;
        this.cmtid = l2;
        this.ctime = l3;
        this.score = d2;
        this.filter = immutableCopyOf(list);
        this.source = str;
        this.raw_ctx = fVar;
        this.scoreV2 = d3;
    }

    private SearchCommentJob(Builder builder) {
        this(builder.type, builder.itemid, builder.cmtid, builder.ctime, builder.score, builder.filter, builder.source, builder.raw_ctx, builder.scoreV2);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCommentJob)) {
            return false;
        }
        SearchCommentJob searchCommentJob = (SearchCommentJob) obj;
        if (!equals((Object) this.type, (Object) searchCommentJob.type) || !equals((Object) this.itemid, (Object) searchCommentJob.itemid) || !equals((Object) this.cmtid, (Object) searchCommentJob.cmtid) || !equals((Object) this.ctime, (Object) searchCommentJob.ctime) || !equals((Object) this.score, (Object) searchCommentJob.score) || !equals((List<?>) this.filter, (List<?>) searchCommentJob.filter) || !equals((Object) this.source, (Object) searchCommentJob.source) || !equals((Object) this.raw_ctx, (Object) searchCommentJob.raw_ctx) || !equals((Object) this.scoreV2, (Object) searchCommentJob.scoreV2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.cmtid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.ctime;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Double d2 = this.score;
        int hashCode5 = (hashCode4 + (d2 != null ? d2.hashCode() : 0)) * 37;
        List<Integer> list = this.filter;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.source;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Double d3 = this.scoreV2;
        if (d3 != null) {
            i2 = d3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchCommentJob> {
        public Long cmtid;
        public Long ctime;
        public List<Integer> filter;
        public Long itemid;
        public f raw_ctx;
        public Double score;
        public Double scoreV2;
        public String source;
        public Integer type;

        public Builder() {
        }

        public Builder(SearchCommentJob searchCommentJob) {
            super(searchCommentJob);
            if (searchCommentJob != null) {
                this.type = searchCommentJob.type;
                this.itemid = searchCommentJob.itemid;
                this.cmtid = searchCommentJob.cmtid;
                this.ctime = searchCommentJob.ctime;
                this.score = searchCommentJob.score;
                this.filter = SearchCommentJob.copyOf(searchCommentJob.filter);
                this.source = searchCommentJob.source;
                this.raw_ctx = searchCommentJob.raw_ctx;
                this.scoreV2 = searchCommentJob.scoreV2;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder score(Double d2) {
            this.score = d2;
            return this;
        }

        public Builder filter(List<Integer> list) {
            this.filter = checkForNulls(list);
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public Builder scoreV2(Double d2) {
            this.scoreV2 = d2;
            return this;
        }

        public SearchCommentJob build() {
            return new SearchCommentJob(this);
        }
    }
}
