package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackingFilter extends Message {
    public static final List<String> DEFAULT_HASHTAG = Collections.emptyList();
    public static final List<Long> DEFAULT_MATCH_ID = Collections.emptyList();
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> hashtag;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> match_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer match_type;

    public TrackingFilter(Integer num, List<Long> list, List<String> list2) {
        this.match_type = num;
        this.match_id = immutableCopyOf(list);
        this.hashtag = immutableCopyOf(list2);
    }

    private TrackingFilter(Builder builder) {
        this(builder.match_type, builder.match_id, builder.hashtag);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingFilter)) {
            return false;
        }
        TrackingFilter trackingFilter = (TrackingFilter) obj;
        if (!equals((Object) this.match_type, (Object) trackingFilter.match_type) || !equals((List<?>) this.match_id, (List<?>) trackingFilter.match_id) || !equals((List<?>) this.hashtag, (List<?>) trackingFilter.hashtag)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.match_type;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<Long> list = this.match_id;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<String> list2 = this.hashtag;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingFilter> {
        public List<String> hashtag;
        public List<Long> match_id;
        public Integer match_type;

        public Builder() {
        }

        public Builder(TrackingFilter trackingFilter) {
            super(trackingFilter);
            if (trackingFilter != null) {
                this.match_type = trackingFilter.match_type;
                this.match_id = TrackingFilter.copyOf(trackingFilter.match_id);
                this.hashtag = TrackingFilter.copyOf(trackingFilter.hashtag);
            }
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public Builder match_id(List<Long> list) {
            this.match_id = checkForNulls(list);
            return this;
        }

        public Builder hashtag(List<String> list) {
            this.hashtag = checkForNulls(list);
            return this;
        }

        public TrackingFilter build() {
            return new TrackingFilter(this);
        }
    }
}
