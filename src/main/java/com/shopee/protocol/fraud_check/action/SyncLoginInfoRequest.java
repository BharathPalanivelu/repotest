package com.shopee.protocol.fraud_check.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SyncLoginInfoRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SHOPEE_DF = "";
    public static final String DEFAULT_TONGDUN_BLACKBOX = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String shopee_df;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tongdun_blackbox;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer user_agent_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public SyncLoginInfoRequest(String str, String str2, String str3, Integer num, String str4, Integer num2) {
        this.requestid = str;
        this.shopee_df = str2;
        this.tongdun_blackbox = str3;
        this.userid = num;
        this.country = str4;
        this.user_agent_type = num2;
    }

    private SyncLoginInfoRequest(Builder builder) {
        this(builder.requestid, builder.shopee_df, builder.tongdun_blackbox, builder.userid, builder.country, builder.user_agent_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SyncLoginInfoRequest)) {
            return false;
        }
        SyncLoginInfoRequest syncLoginInfoRequest = (SyncLoginInfoRequest) obj;
        if (!equals((Object) this.requestid, (Object) syncLoginInfoRequest.requestid) || !equals((Object) this.shopee_df, (Object) syncLoginInfoRequest.shopee_df) || !equals((Object) this.tongdun_blackbox, (Object) syncLoginInfoRequest.tongdun_blackbox) || !equals((Object) this.userid, (Object) syncLoginInfoRequest.userid) || !equals((Object) this.country, (Object) syncLoginInfoRequest.country) || !equals((Object) this.user_agent_type, (Object) syncLoginInfoRequest.user_agent_type)) {
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
        String str2 = this.shopee_df;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.tongdun_blackbox;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.user_agent_type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SyncLoginInfoRequest> {
        public String country;
        public String requestid;
        public String shopee_df;
        public String tongdun_blackbox;
        public Integer user_agent_type;
        public Integer userid;

        public Builder() {
        }

        public Builder(SyncLoginInfoRequest syncLoginInfoRequest) {
            super(syncLoginInfoRequest);
            if (syncLoginInfoRequest != null) {
                this.requestid = syncLoginInfoRequest.requestid;
                this.shopee_df = syncLoginInfoRequest.shopee_df;
                this.tongdun_blackbox = syncLoginInfoRequest.tongdun_blackbox;
                this.userid = syncLoginInfoRequest.userid;
                this.country = syncLoginInfoRequest.country;
                this.user_agent_type = syncLoginInfoRequest.user_agent_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopee_df(String str) {
            this.shopee_df = str;
            return this;
        }

        public Builder tongdun_blackbox(String str) {
            this.tongdun_blackbox = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder user_agent_type(Integer num) {
            this.user_agent_type = num;
            return this;
        }

        public SyncLoginInfoRequest build() {
            return new SyncLoginInfoRequest(this);
        }
    }
}
