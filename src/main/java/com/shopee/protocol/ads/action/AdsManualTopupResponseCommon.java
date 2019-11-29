package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AdsManualTopupResponseCommon extends Message {
    public static final List<ResponseCommon> DEFAULT_RESPONSES = Collections.emptyList();
    public static final List<AdsManualTopup> DEFAULT_SUMMARY = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResponseCommon.class, tag = 3)
    public final List<ResponseCommon> responses;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdsManualTopup.class, tag = 2)
    public final List<AdsManualTopup> summary;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total;

    public AdsManualTopupResponseCommon(ResponseHeader responseHeader, List<AdsManualTopup> list, List<ResponseCommon> list2, Integer num) {
        this.header = responseHeader;
        this.summary = immutableCopyOf(list);
        this.responses = immutableCopyOf(list2);
        this.total = num;
    }

    private AdsManualTopupResponseCommon(Builder builder) {
        this(builder.header, builder.summary, builder.responses, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsManualTopupResponseCommon)) {
            return false;
        }
        AdsManualTopupResponseCommon adsManualTopupResponseCommon = (AdsManualTopupResponseCommon) obj;
        if (!equals((Object) this.header, (Object) adsManualTopupResponseCommon.header) || !equals((List<?>) this.summary, (List<?>) adsManualTopupResponseCommon.summary) || !equals((List<?>) this.responses, (List<?>) adsManualTopupResponseCommon.responses) || !equals((Object) this.total, (Object) adsManualTopupResponseCommon.total)) {
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
        List<AdsManualTopup> list = this.summary;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<ResponseCommon> list2 = this.responses;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 37;
        Integer num = this.total;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<AdsManualTopupResponseCommon> {
        public ResponseHeader header;
        public List<ResponseCommon> responses;
        public List<AdsManualTopup> summary;
        public Integer total;

        public Builder() {
        }

        public Builder(AdsManualTopupResponseCommon adsManualTopupResponseCommon) {
            super(adsManualTopupResponseCommon);
            if (adsManualTopupResponseCommon != null) {
                this.header = adsManualTopupResponseCommon.header;
                this.summary = AdsManualTopupResponseCommon.copyOf(adsManualTopupResponseCommon.summary);
                this.responses = AdsManualTopupResponseCommon.copyOf(adsManualTopupResponseCommon.responses);
                this.total = adsManualTopupResponseCommon.total;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder summary(List<AdsManualTopup> list) {
            this.summary = checkForNulls(list);
            return this;
        }

        public Builder responses(List<ResponseCommon> list) {
            this.responses = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public AdsManualTopupResponseCommon build() {
            return new AdsManualTopupResponseCommon(this);
        }
    }
}
