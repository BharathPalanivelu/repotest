package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetAdsManualTopupSummaryRequest extends Message {
    public static final List<Long> DEFAULT_IDS = Collections.emptyList();
    public static final List<Long> DEFAULT_SHOPIDS = Collections.emptyList();
    public static final List<String> DEFAULT_SHOPNAMES = Collections.emptyList();
    public static final List<AdsManualTopupStatus> DEFAULT_STATUS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final Header header;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> ids;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> shopids;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> shopnames;
    @ProtoField(enumType = AdsManualTopupStatus.class, label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.ENUM)
    public final List<AdsManualTopupStatus> status;

    public GetAdsManualTopupSummaryRequest(List<Long> list, List<String> list2, List<AdsManualTopupStatus> list3, List<Long> list4, Header header2) {
        this.shopids = immutableCopyOf(list);
        this.shopnames = immutableCopyOf(list2);
        this.status = immutableCopyOf(list3);
        this.ids = immutableCopyOf(list4);
        this.header = header2;
    }

    private GetAdsManualTopupSummaryRequest(Builder builder) {
        this(builder.shopids, builder.shopnames, builder.status, builder.ids, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAdsManualTopupSummaryRequest)) {
            return false;
        }
        GetAdsManualTopupSummaryRequest getAdsManualTopupSummaryRequest = (GetAdsManualTopupSummaryRequest) obj;
        if (!equals((List<?>) this.shopids, (List<?>) getAdsManualTopupSummaryRequest.shopids) || !equals((List<?>) this.shopnames, (List<?>) getAdsManualTopupSummaryRequest.shopnames) || !equals((List<?>) this.status, (List<?>) getAdsManualTopupSummaryRequest.status) || !equals((List<?>) this.ids, (List<?>) getAdsManualTopupSummaryRequest.ids) || !equals((Object) this.header, (Object) getAdsManualTopupSummaryRequest.header)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.shopids;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<String> list2 = this.shopnames;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<AdsManualTopupStatus> list3 = this.status;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Long> list4 = this.ids;
        if (list4 != null) {
            i2 = list4.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        Header header2 = this.header;
        int hashCode4 = i3 + (header2 != null ? header2.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<GetAdsManualTopupSummaryRequest> {
        public Header header;
        public List<Long> ids;
        public List<Long> shopids;
        public List<String> shopnames;
        public List<AdsManualTopupStatus> status;

        public Builder() {
        }

        public Builder(GetAdsManualTopupSummaryRequest getAdsManualTopupSummaryRequest) {
            super(getAdsManualTopupSummaryRequest);
            if (getAdsManualTopupSummaryRequest != null) {
                this.shopids = GetAdsManualTopupSummaryRequest.copyOf(getAdsManualTopupSummaryRequest.shopids);
                this.shopnames = GetAdsManualTopupSummaryRequest.copyOf(getAdsManualTopupSummaryRequest.shopnames);
                this.status = GetAdsManualTopupSummaryRequest.copyOf(getAdsManualTopupSummaryRequest.status);
                this.ids = GetAdsManualTopupSummaryRequest.copyOf(getAdsManualTopupSummaryRequest.ids);
                this.header = getAdsManualTopupSummaryRequest.header;
            }
        }

        public Builder shopids(List<Long> list) {
            this.shopids = checkForNulls(list);
            return this;
        }

        public Builder shopnames(List<String> list) {
            this.shopnames = checkForNulls(list);
            return this;
        }

        public Builder status(List<AdsManualTopupStatus> list) {
            this.status = checkForNulls(list);
            return this;
        }

        public Builder ids(List<Long> list) {
            this.ids = checkForNulls(list);
            return this;
        }

        public Builder header(Header header2) {
            this.header = header2;
            return this;
        }

        public GetAdsManualTopupSummaryRequest build() {
            return new GetAdsManualTopupSummaryRequest(this);
        }
    }
}
