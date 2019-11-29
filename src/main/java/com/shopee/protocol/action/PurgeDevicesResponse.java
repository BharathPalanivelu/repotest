package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PurgeDevicesResponse extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Integer> DEFAULT_FAILED_USERIDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> failed_userids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PurgeDevicesResponse(String str, List<Integer> list, String str2, Integer num) {
        this.requestid = str;
        this.failed_userids = immutableCopyOf(list);
        this.debug_msg = str2;
        this.errcode = num;
    }

    private PurgeDevicesResponse(Builder builder) {
        this(builder.requestid, builder.failed_userids, builder.debug_msg, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PurgeDevicesResponse)) {
            return false;
        }
        PurgeDevicesResponse purgeDevicesResponse = (PurgeDevicesResponse) obj;
        if (!equals((Object) this.requestid, (Object) purgeDevicesResponse.requestid) || !equals((List<?>) this.failed_userids, (List<?>) purgeDevicesResponse.failed_userids) || !equals((Object) this.debug_msg, (Object) purgeDevicesResponse.debug_msg) || !equals((Object) this.errcode, (Object) purgeDevicesResponse.errcode)) {
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
        List<Integer> list = this.failed_userids;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PurgeDevicesResponse> {
        public String debug_msg;
        public Integer errcode;
        public List<Integer> failed_userids;
        public String requestid;

        public Builder() {
        }

        public Builder(PurgeDevicesResponse purgeDevicesResponse) {
            super(purgeDevicesResponse);
            if (purgeDevicesResponse != null) {
                this.requestid = purgeDevicesResponse.requestid;
                this.failed_userids = PurgeDevicesResponse.copyOf(purgeDevicesResponse.failed_userids);
                this.debug_msg = purgeDevicesResponse.debug_msg;
                this.errcode = purgeDevicesResponse.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder failed_userids(List<Integer> list) {
            this.failed_userids = checkForNulls(list);
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public PurgeDevicesResponse build() {
            return new PurgeDevicesResponse(this);
        }
    }
}
