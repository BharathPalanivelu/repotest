package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSyncDpData extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSyncDpData(String str, Integer num, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
    }

    private ResponseSyncDpData(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSyncDpData)) {
            return false;
        }
        ResponseSyncDpData responseSyncDpData = (ResponseSyncDpData) obj;
        if (!equals((Object) this.requestid, (Object) responseSyncDpData.requestid) || !equals((Object) this.errcode, (Object) responseSyncDpData.errcode) || !equals((Object) this.debug_msg, (Object) responseSyncDpData.debug_msg)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSyncDpData> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSyncDpData responseSyncDpData) {
            super(responseSyncDpData);
            if (responseSyncDpData != null) {
                this.requestid = responseSyncDpData.requestid;
                this.errcode = responseSyncDpData.errcode;
                this.debug_msg = responseSyncDpData.debug_msg;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseSyncDpData build() {
            return new ResponseSyncDpData(this);
        }
    }
}
