package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsReportRequest extends Message {
    public static final String DEFAULT_BODY = "";
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Integer DEFAULT_INDEX = 0;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Long DEFAULT_START_TIME = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String body;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer index;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long start_time;

    public AdsReportRequest(RequestHeader requestHeader, String str, Integer num, Integer num2, Long l, Long l2) {
        this.header = requestHeader;
        this.body = str;
        this.index = num;
        this.placement = num2;
        this.start_time = l;
        this.end_time = l2;
    }

    private AdsReportRequest(Builder builder) {
        this(builder.header, builder.body, builder.index, builder.placement, builder.start_time, builder.end_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsReportRequest)) {
            return false;
        }
        AdsReportRequest adsReportRequest = (AdsReportRequest) obj;
        if (!equals((Object) this.header, (Object) adsReportRequest.header) || !equals((Object) this.body, (Object) adsReportRequest.body) || !equals((Object) this.index, (Object) adsReportRequest.index) || !equals((Object) this.placement, (Object) adsReportRequest.placement) || !equals((Object) this.start_time, (Object) adsReportRequest.start_time) || !equals((Object) this.end_time, (Object) adsReportRequest.end_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        String str = this.body;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.index;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.placement;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.start_time;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.end_time;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsReportRequest> {
        public String body;
        public Long end_time;
        public RequestHeader header;
        public Integer index;
        public Integer placement;
        public Long start_time;

        public Builder() {
        }

        public Builder(AdsReportRequest adsReportRequest) {
            super(adsReportRequest);
            if (adsReportRequest != null) {
                this.header = adsReportRequest.header;
                this.body = adsReportRequest.body;
                this.index = adsReportRequest.index;
                this.placement = adsReportRequest.placement;
                this.start_time = adsReportRequest.start_time;
                this.end_time = adsReportRequest.end_time;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder body(String str) {
            this.body = str;
            return this;
        }

        public Builder index(Integer num) {
            this.index = num;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder end_time(Long l) {
            this.end_time = l;
            return this;
        }

        public AdsReportRequest build() {
            return new AdsReportRequest(this);
        }
    }
}
