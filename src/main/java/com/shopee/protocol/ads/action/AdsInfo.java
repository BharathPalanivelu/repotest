package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsInfo extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long campaignid;

    public AdsInfo(Long l, Long l2) {
        this.adsid = l;
        this.campaignid = l2;
    }

    private AdsInfo(Builder builder) {
        this(builder.adsid, builder.campaignid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsInfo)) {
            return false;
        }
        AdsInfo adsInfo = (AdsInfo) obj;
        if (!equals((Object) this.adsid, (Object) adsInfo.adsid) || !equals((Object) this.campaignid, (Object) adsInfo.campaignid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.adsid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.campaignid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsInfo> {
        public Long adsid;
        public Long campaignid;

        public Builder() {
        }

        public Builder(AdsInfo adsInfo) {
            super(adsInfo);
            if (adsInfo != null) {
                this.adsid = adsInfo.adsid;
                this.campaignid = adsInfo.campaignid;
            }
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public AdsInfo build() {
            return new AdsInfo(this);
        }
    }
}
