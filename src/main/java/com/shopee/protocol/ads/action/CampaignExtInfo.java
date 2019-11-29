package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CampaignExtInfo extends Message {
    public static final List<Integer> DEFAULT_TARGET_PLATFORM = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> target_platform;

    public CampaignExtInfo(List<Integer> list) {
        this.target_platform = immutableCopyOf(list);
    }

    private CampaignExtInfo(Builder builder) {
        this(builder.target_platform);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CampaignExtInfo)) {
            return false;
        }
        return equals((List<?>) this.target_platform, (List<?>) ((CampaignExtInfo) obj).target_platform);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Integer> list = this.target_platform;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CampaignExtInfo> {
        public List<Integer> target_platform;

        public Builder() {
        }

        public Builder(CampaignExtInfo campaignExtInfo) {
            super(campaignExtInfo);
            if (campaignExtInfo != null) {
                this.target_platform = CampaignExtInfo.copyOf(campaignExtInfo.target_platform);
            }
        }

        public Builder target_platform(List<Integer> list) {
            this.target_platform = checkForNulls(list);
            return this;
        }

        public CampaignExtInfo build() {
            return new CampaignExtInfo(this);
        }
    }
}
