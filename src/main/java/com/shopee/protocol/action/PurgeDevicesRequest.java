package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PurgeDevicesRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_USERIDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> userids;

    public PurgeDevicesRequest(String str, List<Integer> list, String str2) {
        this.requestid = str;
        this.userids = immutableCopyOf(list);
        this.country = str2;
    }

    private PurgeDevicesRequest(Builder builder) {
        this(builder.requestid, builder.userids, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PurgeDevicesRequest)) {
            return false;
        }
        PurgeDevicesRequest purgeDevicesRequest = (PurgeDevicesRequest) obj;
        if (!equals((Object) this.requestid, (Object) purgeDevicesRequest.requestid) || !equals((List<?>) this.userids, (List<?>) purgeDevicesRequest.userids) || !equals((Object) this.country, (Object) purgeDevicesRequest.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<Integer> list = this.userids;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PurgeDevicesRequest> {
        public String country;
        public String requestid;
        public List<Integer> userids;

        public Builder() {
        }

        public Builder(PurgeDevicesRequest purgeDevicesRequest) {
            super(purgeDevicesRequest);
            if (purgeDevicesRequest != null) {
                this.requestid = purgeDevicesRequest.requestid;
                this.userids = PurgeDevicesRequest.copyOf(purgeDevicesRequest.userids);
                this.country = purgeDevicesRequest.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userids(List<Integer> list) {
            this.userids = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public PurgeDevicesRequest build() {
            return new PurgeDevicesRequest(this);
        }
    }
}
