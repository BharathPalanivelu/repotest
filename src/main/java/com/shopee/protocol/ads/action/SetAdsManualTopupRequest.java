package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetAdsManualTopupRequest extends Message {
    public static final List<AdsManualTopup> DEFAULT_DATA = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdsManualTopup.class, tag = 2)
    public final List<AdsManualTopup> data;
    @ProtoField(tag = 1)
    public final Header header;

    public SetAdsManualTopupRequest(Header header2, List<AdsManualTopup> list) {
        this.header = header2;
        this.data = immutableCopyOf(list);
    }

    private SetAdsManualTopupRequest(Builder builder) {
        this(builder.header, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAdsManualTopupRequest)) {
            return false;
        }
        SetAdsManualTopupRequest setAdsManualTopupRequest = (SetAdsManualTopupRequest) obj;
        if (!equals((Object) this.header, (Object) setAdsManualTopupRequest.header) || !equals((List<?>) this.data, (List<?>) setAdsManualTopupRequest.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Header header2 = this.header;
        int hashCode = (header2 != null ? header2.hashCode() : 0) * 37;
        List<AdsManualTopup> list = this.data;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetAdsManualTopupRequest> {
        public List<AdsManualTopup> data;
        public Header header;

        public Builder() {
        }

        public Builder(SetAdsManualTopupRequest setAdsManualTopupRequest) {
            super(setAdsManualTopupRequest);
            if (setAdsManualTopupRequest != null) {
                this.header = setAdsManualTopupRequest.header;
                this.data = SetAdsManualTopupRequest.copyOf(setAdsManualTopupRequest.data);
            }
        }

        public Builder header(Header header2) {
            this.header = header2;
            return this;
        }

        public Builder data(List<AdsManualTopup> list) {
            this.data = checkForNulls(list);
            return this;
        }

        public SetAdsManualTopupRequest build() {
            return new SetAdsManualTopupRequest(this);
        }
    }
}
