package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchSetAdvertiseRequest extends Message {
    public static final Integer DEFAULT_ADS_AUDIT_EVENT = 0;
    public static final List<Advertisement> DEFAULT_ADVERTISEMENTS = Collections.emptyList();
    public static final List<Campaign> DEFAULT_CAMPAIGNS = Collections.emptyList();
    public static final List<CampaignAds> DEFAULT_CAMPAIGN_ADS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ads_audit_event;
    @ProtoField(label = Message.Label.REPEATED, messageType = Advertisement.class, tag = 2)
    public final List<Advertisement> advertisements;
    @ProtoField(label = Message.Label.REPEATED, messageType = CampaignAds.class, tag = 5)
    public final List<CampaignAds> campaign_ads;
    @ProtoField(label = Message.Label.REPEATED, messageType = Campaign.class, tag = 3)
    public final List<Campaign> campaigns;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public BatchSetAdvertiseRequest(RequestHeader requestHeader, List<Advertisement> list, List<Campaign> list2, Integer num, List<CampaignAds> list3) {
        this.header = requestHeader;
        this.advertisements = immutableCopyOf(list);
        this.campaigns = immutableCopyOf(list2);
        this.ads_audit_event = num;
        this.campaign_ads = immutableCopyOf(list3);
    }

    private BatchSetAdvertiseRequest(Builder builder) {
        this(builder.header, builder.advertisements, builder.campaigns, builder.ads_audit_event, builder.campaign_ads);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchSetAdvertiseRequest)) {
            return false;
        }
        BatchSetAdvertiseRequest batchSetAdvertiseRequest = (BatchSetAdvertiseRequest) obj;
        if (!equals((Object) this.header, (Object) batchSetAdvertiseRequest.header) || !equals((List<?>) this.advertisements, (List<?>) batchSetAdvertiseRequest.advertisements) || !equals((List<?>) this.campaigns, (List<?>) batchSetAdvertiseRequest.campaigns) || !equals((Object) this.ads_audit_event, (Object) batchSetAdvertiseRequest.ads_audit_event) || !equals((List<?>) this.campaign_ads, (List<?>) batchSetAdvertiseRequest.campaign_ads)) {
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
        List<Advertisement> list = this.advertisements;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Campaign> list2 = this.campaigns;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Integer num = this.ads_audit_event;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i4 = (hashCode3 + i2) * 37;
        List<CampaignAds> list3 = this.campaign_ads;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<BatchSetAdvertiseRequest> {
        public Integer ads_audit_event;
        public List<Advertisement> advertisements;
        public List<CampaignAds> campaign_ads;
        public List<Campaign> campaigns;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(BatchSetAdvertiseRequest batchSetAdvertiseRequest) {
            super(batchSetAdvertiseRequest);
            if (batchSetAdvertiseRequest != null) {
                this.header = batchSetAdvertiseRequest.header;
                this.advertisements = BatchSetAdvertiseRequest.copyOf(batchSetAdvertiseRequest.advertisements);
                this.campaigns = BatchSetAdvertiseRequest.copyOf(batchSetAdvertiseRequest.campaigns);
                this.ads_audit_event = batchSetAdvertiseRequest.ads_audit_event;
                this.campaign_ads = BatchSetAdvertiseRequest.copyOf(batchSetAdvertiseRequest.campaign_ads);
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder advertisements(List<Advertisement> list) {
            this.advertisements = checkForNulls(list);
            return this;
        }

        public Builder campaigns(List<Campaign> list) {
            this.campaigns = checkForNulls(list);
            return this;
        }

        public Builder ads_audit_event(Integer num) {
            this.ads_audit_event = num;
            return this;
        }

        public Builder campaign_ads(List<CampaignAds> list) {
            this.campaign_ads = checkForNulls(list);
            return this;
        }

        public BatchSetAdvertiseRequest build() {
            return new BatchSetAdvertiseRequest(this);
        }
    }
}
