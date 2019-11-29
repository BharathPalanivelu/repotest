package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetAdsReportRequest extends Message {
    public static final List<TrackingPlacement> DEFAULT_PLACEMENT = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final ESAggOption agg_opt;
    @ProtoField(tag = 3)
    public final ESFilterOption filter_opt;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(enumType = TrackingPlacement.class, label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.ENUM)
    public final List<TrackingPlacement> placement;

    public GetAdsReportRequest(RequestHeader requestHeader, List<TrackingPlacement> list, ESFilterOption eSFilterOption, ESAggOption eSAggOption) {
        this.header = requestHeader;
        this.placement = immutableCopyOf(list);
        this.filter_opt = eSFilterOption;
        this.agg_opt = eSAggOption;
    }

    private GetAdsReportRequest(Builder builder) {
        this(builder.header, builder.placement, builder.filter_opt, builder.agg_opt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAdsReportRequest)) {
            return false;
        }
        GetAdsReportRequest getAdsReportRequest = (GetAdsReportRequest) obj;
        if (!equals((Object) this.header, (Object) getAdsReportRequest.header) || !equals((List<?>) this.placement, (List<?>) getAdsReportRequest.placement) || !equals((Object) this.filter_opt, (Object) getAdsReportRequest.filter_opt) || !equals((Object) this.agg_opt, (Object) getAdsReportRequest.agg_opt)) {
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
        List<TrackingPlacement> list = this.placement;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        ESFilterOption eSFilterOption = this.filter_opt;
        int hashCode3 = (hashCode2 + (eSFilterOption != null ? eSFilterOption.hashCode() : 0)) * 37;
        ESAggOption eSAggOption = this.agg_opt;
        if (eSAggOption != null) {
            i2 = eSAggOption.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetAdsReportRequest> {
        public ESAggOption agg_opt;
        public ESFilterOption filter_opt;
        public RequestHeader header;
        public List<TrackingPlacement> placement;

        public Builder() {
        }

        public Builder(GetAdsReportRequest getAdsReportRequest) {
            super(getAdsReportRequest);
            if (getAdsReportRequest != null) {
                this.header = getAdsReportRequest.header;
                this.placement = GetAdsReportRequest.copyOf(getAdsReportRequest.placement);
                this.filter_opt = getAdsReportRequest.filter_opt;
                this.agg_opt = getAdsReportRequest.agg_opt;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder placement(List<TrackingPlacement> list) {
            this.placement = checkForNulls(list);
            return this;
        }

        public Builder filter_opt(ESFilterOption eSFilterOption) {
            this.filter_opt = eSFilterOption;
            return this;
        }

        public Builder agg_opt(ESAggOption eSAggOption) {
            this.agg_opt = eSAggOption;
            return this;
        }

        public GetAdsReportRequest build() {
            return new GetAdsReportRequest(this);
        }
    }
}
