package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AdsResponseCommon extends Message {
    public static final Long DEFAULT_ACCOUNTID = 0L;
    public static final Long DEFAULT_ADSID = 0L;
    public static final List<AdsId> DEFAULT_ADS_IDS = Collections.emptyList();
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_ERR_MESSAGE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long accountid;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdsId.class, tag = 6)
    public final List<AdsId> ads_ids;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public AdsResponseCommon(ResponseHeader responseHeader, String str, Long l, Long l2, Long l3, List<AdsId> list) {
        this.header = responseHeader;
        this.err_message = str;
        this.accountid = l;
        this.adsid = l2;
        this.campaignid = l3;
        this.ads_ids = immutableCopyOf(list);
    }

    private AdsResponseCommon(Builder builder) {
        this(builder.header, builder.err_message, builder.accountid, builder.adsid, builder.campaignid, builder.ads_ids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsResponseCommon)) {
            return false;
        }
        AdsResponseCommon adsResponseCommon = (AdsResponseCommon) obj;
        if (!equals((Object) this.header, (Object) adsResponseCommon.header) || !equals((Object) this.err_message, (Object) adsResponseCommon.err_message) || !equals((Object) this.accountid, (Object) adsResponseCommon.accountid) || !equals((Object) this.adsid, (Object) adsResponseCommon.adsid) || !equals((Object) this.campaignid, (Object) adsResponseCommon.campaignid) || !equals((List<?>) this.ads_ids, (List<?>) adsResponseCommon.ads_ids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        String str = this.err_message;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.accountid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.adsid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.campaignid;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = (hashCode4 + i2) * 37;
        List<AdsId> list = this.ads_ids;
        int hashCode5 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    public static final class Builder extends Message.Builder<AdsResponseCommon> {
        public Long accountid;
        public List<AdsId> ads_ids;
        public Long adsid;
        public Long campaignid;
        public String err_message;
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(AdsResponseCommon adsResponseCommon) {
            super(adsResponseCommon);
            if (adsResponseCommon != null) {
                this.header = adsResponseCommon.header;
                this.err_message = adsResponseCommon.err_message;
                this.accountid = adsResponseCommon.accountid;
                this.adsid = adsResponseCommon.adsid;
                this.campaignid = adsResponseCommon.campaignid;
                this.ads_ids = AdsResponseCommon.copyOf(adsResponseCommon.ads_ids);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder accountid(Long l) {
            this.accountid = l;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder ads_ids(List<AdsId> list) {
            this.ads_ids = checkForNulls(list);
            return this;
        }

        public AdsResponseCommon build() {
            return new AdsResponseCommon(this);
        }
    }
}
