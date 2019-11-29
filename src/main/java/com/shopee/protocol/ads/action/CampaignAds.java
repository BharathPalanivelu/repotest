package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CampaignAds extends Message {
    public static final List<Advertisement> DEFAULT_ADVERTISEMENTS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Advertisement.class, tag = 1)
    public final List<Advertisement> advertisements;
    @ProtoField(tag = 2)
    public final Campaign campaign;

    public CampaignAds(List<Advertisement> list, Campaign campaign2) {
        this.advertisements = immutableCopyOf(list);
        this.campaign = campaign2;
    }

    private CampaignAds(Builder builder) {
        this(builder.advertisements, builder.campaign);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CampaignAds)) {
            return false;
        }
        CampaignAds campaignAds = (CampaignAds) obj;
        if (!equals((List<?>) this.advertisements, (List<?>) campaignAds.advertisements) || !equals((Object) this.campaign, (Object) campaignAds.campaign)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Advertisement> list = this.advertisements;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Campaign campaign2 = this.campaign;
        int hashCode2 = hashCode + (campaign2 != null ? campaign2.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CampaignAds> {
        public List<Advertisement> advertisements;
        public Campaign campaign;

        public Builder() {
        }

        public Builder(CampaignAds campaignAds) {
            super(campaignAds);
            if (campaignAds != null) {
                this.advertisements = CampaignAds.copyOf(campaignAds.advertisements);
                this.campaign = campaignAds.campaign;
            }
        }

        public Builder advertisements(List<Advertisement> list) {
            this.advertisements = checkForNulls(list);
            return this;
        }

        public Builder campaign(Campaign campaign2) {
            this.campaign = campaign2;
            return this;
        }

        public CampaignAds build() {
            return new CampaignAds(this);
        }
    }
}
