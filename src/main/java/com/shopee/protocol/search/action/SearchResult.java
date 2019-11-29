package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class SearchResult extends Message {
    public static final String DEFAULT_SCROLLID = "";
    public static final Boolean DEFAULT_TIMEDOUT = false;
    public static final Long DEFAULT_TOOKINMILLIS = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final SearchAggregations Aggregations;
    @ProtoField(tag = 6)
    public final ErrorDetails Error;
    @ProtoField(tag = 3)
    public final SearchHits Hits;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String ScrollId;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean TimedOut;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long TookInMillis;

    public SearchResult(Long l, String str, SearchHits searchHits, SearchAggregations searchAggregations, Boolean bool, ErrorDetails errorDetails) {
        this.TookInMillis = l;
        this.ScrollId = str;
        this.Hits = searchHits;
        this.Aggregations = searchAggregations;
        this.TimedOut = bool;
        this.Error = errorDetails;
    }

    private SearchResult(Builder builder) {
        this(builder.TookInMillis, builder.ScrollId, builder.Hits, builder.Aggregations, builder.TimedOut, builder.Error);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) obj;
        if (!equals((Object) this.TookInMillis, (Object) searchResult.TookInMillis) || !equals((Object) this.ScrollId, (Object) searchResult.ScrollId) || !equals((Object) this.Hits, (Object) searchResult.Hits) || !equals((Object) this.Aggregations, (Object) searchResult.Aggregations) || !equals((Object) this.TimedOut, (Object) searchResult.TimedOut) || !equals((Object) this.Error, (Object) searchResult.Error)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.TookInMillis;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.ScrollId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        SearchHits searchHits = this.Hits;
        int hashCode3 = (hashCode2 + (searchHits != null ? searchHits.hashCode() : 0)) * 37;
        SearchAggregations searchAggregations = this.Aggregations;
        int hashCode4 = (hashCode3 + (searchAggregations != null ? searchAggregations.hashCode() : 0)) * 37;
        Boolean bool = this.TimedOut;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        ErrorDetails errorDetails = this.Error;
        if (errorDetails != null) {
            i2 = errorDetails.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchResult> {
        public SearchAggregations Aggregations;
        public ErrorDetails Error;
        public SearchHits Hits;
        public String ScrollId;
        public Boolean TimedOut;
        public Long TookInMillis;

        public Builder() {
        }

        public Builder(SearchResult searchResult) {
            super(searchResult);
            if (searchResult != null) {
                this.TookInMillis = searchResult.TookInMillis;
                this.ScrollId = searchResult.ScrollId;
                this.Hits = searchResult.Hits;
                this.Aggregations = searchResult.Aggregations;
                this.TimedOut = searchResult.TimedOut;
                this.Error = searchResult.Error;
            }
        }

        public Builder TookInMillis(Long l) {
            this.TookInMillis = l;
            return this;
        }

        public Builder ScrollId(String str) {
            this.ScrollId = str;
            return this;
        }

        public Builder Hits(SearchHits searchHits) {
            this.Hits = searchHits;
            return this;
        }

        public Builder Aggregations(SearchAggregations searchAggregations) {
            this.Aggregations = searchAggregations;
            return this;
        }

        public Builder TimedOut(Boolean bool) {
            this.TimedOut = bool;
            return this;
        }

        public Builder Error(ErrorDetails errorDetails) {
            this.Error = errorDetails;
            return this;
        }

        public SearchResult build() {
            return new SearchResult(this);
        }
    }

    public static final class SearchHit extends Message {
        public static final List<NamedVariant> DEFAULT_FIELDS = Collections.emptyList();
        public static final List<HighlightEntry> DEFAULT_HIGHLIGHT = Collections.emptyList();
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_INDEX = "";
        public static final String DEFAULT_PARENT = "";
        public static final String DEFAULT_ROUTING = "";
        public static final Double DEFAULT_SCORE = Double.valueOf(0.0d);
        public static final f DEFAULT_SOURCE = f.f32736b;
        public static final Long DEFAULT_TIMESTAMP = 0L;
        public static final Long DEFAULT_TTL = 0L;
        public static final String DEFAULT_TYPE = "";
        public static final String DEFAULT_UID = "";
        public static final Long DEFAULT_VERSION = 0L;
        private static final long serialVersionUID = 0;
        @ProtoField(label = Message.Label.REPEATED, messageType = NamedVariant.class, tag = 12)
        public final List<NamedVariant> Fields;
        @ProtoField(label = Message.Label.REPEATED, messageType = HighlightEntry.class, tag = 13)
        public final List<HighlightEntry> Highlight;
        @ProtoField(tag = 4, type = Message.Datatype.STRING)
        public final String Id;
        @ProtoField(tag = 2, type = Message.Datatype.STRING)
        public final String Index;
        @ProtoField(tag = 9, type = Message.Datatype.STRING)
        public final String Parent;
        @ProtoField(tag = 8, type = Message.Datatype.STRING)
        public final String Routing;
        @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
        public final Double Score;
        @ProtoField(tag = 11, type = Message.Datatype.BYTES)
        public final f Source;
        @ProtoField(tag = 7, type = Message.Datatype.INT64)
        public final Long TTL;
        @ProtoField(tag = 6, type = Message.Datatype.INT64)
        public final Long Timestamp;
        @ProtoField(tag = 3, type = Message.Datatype.STRING)
        public final String Type;
        @ProtoField(tag = 5, type = Message.Datatype.STRING)
        public final String Uid;
        @ProtoField(tag = 10, type = Message.Datatype.INT64)
        public final Long Version;

        public SearchHit(Double d2, String str, String str2, String str3, String str4, Long l, Long l2, String str5, String str6, Long l3, f fVar, List<NamedVariant> list, List<HighlightEntry> list2) {
            this.Score = d2;
            this.Index = str;
            this.Type = str2;
            this.Id = str3;
            this.Uid = str4;
            this.Timestamp = l;
            this.TTL = l2;
            this.Routing = str5;
            this.Parent = str6;
            this.Version = l3;
            this.Source = fVar;
            this.Fields = immutableCopyOf(list);
            this.Highlight = immutableCopyOf(list2);
        }

        private SearchHit(Builder builder) {
            this(builder.Score, builder.Index, builder.Type, builder.Id, builder.Uid, builder.Timestamp, builder.TTL, builder.Routing, builder.Parent, builder.Version, builder.Source, builder.Fields, builder.Highlight);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SearchHit)) {
                return false;
            }
            SearchHit searchHit = (SearchHit) obj;
            if (!equals((Object) this.Score, (Object) searchHit.Score) || !equals((Object) this.Index, (Object) searchHit.Index) || !equals((Object) this.Type, (Object) searchHit.Type) || !equals((Object) this.Id, (Object) searchHit.Id) || !equals((Object) this.Uid, (Object) searchHit.Uid) || !equals((Object) this.Timestamp, (Object) searchHit.Timestamp) || !equals((Object) this.TTL, (Object) searchHit.TTL) || !equals((Object) this.Routing, (Object) searchHit.Routing) || !equals((Object) this.Parent, (Object) searchHit.Parent) || !equals((Object) this.Version, (Object) searchHit.Version) || !equals((Object) this.Source, (Object) searchHit.Source) || !equals((List<?>) this.Fields, (List<?>) searchHit.Fields) || !equals((List<?>) this.Highlight, (List<?>) searchHit.Highlight)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            Double d2 = this.Score;
            int i2 = 0;
            int hashCode = (d2 != null ? d2.hashCode() : 0) * 37;
            String str = this.Index;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.Type;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.Id;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.Uid;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
            Long l = this.Timestamp;
            int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
            Long l2 = this.TTL;
            int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
            String str5 = this.Routing;
            int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.Parent;
            int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
            Long l3 = this.Version;
            int hashCode10 = (hashCode9 + (l3 != null ? l3.hashCode() : 0)) * 37;
            f fVar = this.Source;
            if (fVar != null) {
                i2 = fVar.hashCode();
            }
            int i3 = (hashCode10 + i2) * 37;
            List<NamedVariant> list = this.Fields;
            int i4 = 1;
            int hashCode11 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
            List<HighlightEntry> list2 = this.Highlight;
            if (list2 != null) {
                i4 = list2.hashCode();
            }
            int i5 = hashCode11 + i4;
            this.hashCode = i5;
            return i5;
        }

        public static final class Builder extends Message.Builder<SearchHit> {
            public List<NamedVariant> Fields;
            public List<HighlightEntry> Highlight;
            public String Id;
            public String Index;
            public String Parent;
            public String Routing;
            public Double Score;
            public f Source;
            public Long TTL;
            public Long Timestamp;
            public String Type;
            public String Uid;
            public Long Version;

            public Builder() {
            }

            public Builder(SearchHit searchHit) {
                super(searchHit);
                if (searchHit != null) {
                    this.Score = searchHit.Score;
                    this.Index = searchHit.Index;
                    this.Type = searchHit.Type;
                    this.Id = searchHit.Id;
                    this.Uid = searchHit.Uid;
                    this.Timestamp = searchHit.Timestamp;
                    this.TTL = searchHit.TTL;
                    this.Routing = searchHit.Routing;
                    this.Parent = searchHit.Parent;
                    this.Version = searchHit.Version;
                    this.Source = searchHit.Source;
                    this.Fields = SearchHit.copyOf(searchHit.Fields);
                    this.Highlight = SearchHit.copyOf(searchHit.Highlight);
                }
            }

            public Builder Score(Double d2) {
                this.Score = d2;
                return this;
            }

            public Builder Index(String str) {
                this.Index = str;
                return this;
            }

            public Builder Type(String str) {
                this.Type = str;
                return this;
            }

            public Builder Id(String str) {
                this.Id = str;
                return this;
            }

            public Builder Uid(String str) {
                this.Uid = str;
                return this;
            }

            public Builder Timestamp(Long l) {
                this.Timestamp = l;
                return this;
            }

            public Builder TTL(Long l) {
                this.TTL = l;
                return this;
            }

            public Builder Routing(String str) {
                this.Routing = str;
                return this;
            }

            public Builder Parent(String str) {
                this.Parent = str;
                return this;
            }

            public Builder Version(Long l) {
                this.Version = l;
                return this;
            }

            public Builder Source(f fVar) {
                this.Source = fVar;
                return this;
            }

            public Builder Fields(List<NamedVariant> list) {
                this.Fields = checkForNulls(list);
                return this;
            }

            public Builder Highlight(List<HighlightEntry> list) {
                this.Highlight = checkForNulls(list);
                return this;
            }

            public SearchHit build() {
                return new SearchHit(this);
            }
        }
    }

    public static final class SearchHits extends Message {
        public static final List<SearchHit> DEFAULT_HITS = Collections.emptyList();
        public static final Double DEFAULT_MAXSCORE = Double.valueOf(0.0d);
        public static final Long DEFAULT_TOTALHITS = 0L;
        private static final long serialVersionUID = 0;
        @ProtoField(label = Message.Label.REPEATED, messageType = SearchHit.class, tag = 3)
        public final List<SearchHit> Hits;
        @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
        public final Double MaxScore;
        @ProtoField(tag = 1, type = Message.Datatype.INT64)
        public final Long TotalHits;

        public SearchHits(Long l, Double d2, List<SearchHit> list) {
            this.TotalHits = l;
            this.MaxScore = d2;
            this.Hits = immutableCopyOf(list);
        }

        private SearchHits(Builder builder) {
            this(builder.TotalHits, builder.MaxScore, builder.Hits);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SearchHits)) {
                return false;
            }
            SearchHits searchHits = (SearchHits) obj;
            if (!equals((Object) this.TotalHits, (Object) searchHits.TotalHits) || !equals((Object) this.MaxScore, (Object) searchHits.MaxScore) || !equals((List<?>) this.Hits, (List<?>) searchHits.Hits)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            Long l = this.TotalHits;
            int i2 = 0;
            int hashCode = (l != null ? l.hashCode() : 0) * 37;
            Double d2 = this.MaxScore;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            int i3 = (hashCode + i2) * 37;
            List<SearchHit> list = this.Hits;
            int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public static final class Builder extends Message.Builder<SearchHits> {
            public List<SearchHit> Hits;
            public Double MaxScore;
            public Long TotalHits;

            public Builder() {
            }

            public Builder(SearchHits searchHits) {
                super(searchHits);
                if (searchHits != null) {
                    this.TotalHits = searchHits.TotalHits;
                    this.MaxScore = searchHits.MaxScore;
                    this.Hits = SearchHits.copyOf(searchHits.Hits);
                }
            }

            public Builder TotalHits(Long l) {
                this.TotalHits = l;
                return this;
            }

            public Builder MaxScore(Double d2) {
                this.MaxScore = d2;
                return this;
            }

            public Builder Hits(List<SearchHit> list) {
                this.Hits = checkForNulls(list);
                return this;
            }

            public SearchHits build() {
                return new SearchHits(this);
            }
        }
    }

    public static final class SearchAggregations extends Message {
        public static final List<NamedVariant> DEFAULT_FIELDS = Collections.emptyList();
        private static final long serialVersionUID = 0;
        @ProtoField(label = Message.Label.REPEATED, messageType = NamedVariant.class, tag = 1)
        public final List<NamedVariant> Fields;

        public SearchAggregations(List<NamedVariant> list) {
            this.Fields = immutableCopyOf(list);
        }

        private SearchAggregations(Builder builder) {
            this(builder.Fields);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SearchAggregations)) {
                return false;
            }
            return equals((List<?>) this.Fields, (List<?>) ((SearchAggregations) obj).Fields);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                List<NamedVariant> list = this.Fields;
                i = list != null ? list.hashCode() : 1;
                this.hashCode = i;
            }
            return i;
        }

        public static final class Builder extends Message.Builder<SearchAggregations> {
            public List<NamedVariant> Fields;

            public Builder() {
            }

            public Builder(SearchAggregations searchAggregations) {
                super(searchAggregations);
                if (searchAggregations != null) {
                    this.Fields = SearchAggregations.copyOf(searchAggregations.Fields);
                }
            }

            public Builder Fields(List<NamedVariant> list) {
                this.Fields = checkForNulls(list);
                return this;
            }

            public SearchAggregations build() {
                return new SearchAggregations(this);
            }
        }
    }

    public static final class ErrorDetails extends Message {
        public static final String DEFAULT_INDEX = "";
        public static final String DEFAULT_PHASE = "";
        public static final String DEFAULT_REASON = "";
        public static final String DEFAULT_RESOURCEID = "";
        public static final String DEFAULT_RESOURCETYPE = "";
        public static final String DEFAULT_TYPE = "";
        private static final long serialVersionUID = 0;
        @ProtoField(tag = 5, type = Message.Datatype.STRING)
        public final String Index;
        @ProtoField(tag = 6, type = Message.Datatype.STRING)
        public final String Phase;
        @ProtoField(tag = 2, type = Message.Datatype.STRING)
        public final String Reason;
        @ProtoField(tag = 4, type = Message.Datatype.STRING)
        public final String ResourceId;
        @ProtoField(tag = 3, type = Message.Datatype.STRING)
        public final String ResourceType;
        @ProtoField(tag = 1, type = Message.Datatype.STRING)
        public final String Type;

        public ErrorDetails(String str, String str2, String str3, String str4, String str5, String str6) {
            this.Type = str;
            this.Reason = str2;
            this.ResourceType = str3;
            this.ResourceId = str4;
            this.Index = str5;
            this.Phase = str6;
        }

        private ErrorDetails(Builder builder) {
            this(builder.Type, builder.Reason, builder.ResourceType, builder.ResourceId, builder.Index, builder.Phase);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ErrorDetails)) {
                return false;
            }
            ErrorDetails errorDetails = (ErrorDetails) obj;
            if (!equals((Object) this.Type, (Object) errorDetails.Type) || !equals((Object) this.Reason, (Object) errorDetails.Reason) || !equals((Object) this.ResourceType, (Object) errorDetails.ResourceType) || !equals((Object) this.ResourceId, (Object) errorDetails.ResourceId) || !equals((Object) this.Index, (Object) errorDetails.Index) || !equals((Object) this.Phase, (Object) errorDetails.Phase)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            String str = this.Type;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 37;
            String str2 = this.Reason;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.ResourceType;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.ResourceId;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.Index;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.Phase;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            int i3 = hashCode5 + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<ErrorDetails> {
            public String Index;
            public String Phase;
            public String Reason;
            public String ResourceId;
            public String ResourceType;
            public String Type;

            public Builder() {
            }

            public Builder(ErrorDetails errorDetails) {
                super(errorDetails);
                if (errorDetails != null) {
                    this.Type = errorDetails.Type;
                    this.Reason = errorDetails.Reason;
                    this.ResourceType = errorDetails.ResourceType;
                    this.ResourceId = errorDetails.ResourceId;
                    this.Index = errorDetails.Index;
                    this.Phase = errorDetails.Phase;
                }
            }

            public Builder Type(String str) {
                this.Type = str;
                return this;
            }

            public Builder Reason(String str) {
                this.Reason = str;
                return this;
            }

            public Builder ResourceType(String str) {
                this.ResourceType = str;
                return this;
            }

            public Builder ResourceId(String str) {
                this.ResourceId = str;
                return this;
            }

            public Builder Index(String str) {
                this.Index = str;
                return this;
            }

            public Builder Phase(String str) {
                this.Phase = str;
                return this;
            }

            public ErrorDetails build() {
                return new ErrorDetails(this);
            }
        }
    }
}
