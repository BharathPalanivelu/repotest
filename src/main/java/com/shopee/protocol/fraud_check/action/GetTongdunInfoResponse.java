package com.shopee.protocol.fraud_check.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetTongdunInfoResponse extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Boolean DEFAULT_IS_EMULATOR = false;
    public static final String DEFAULT_RAW_TONGDUN_INFO = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TONGDUN_DF = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean is_emulator;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String raw_tongdun_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tongdun_df;

    public GetTongdunInfoResponse(String str, Integer num, String str2, Boolean bool, String str3) {
        this.requestid = str;
        this.errcode = num;
        this.tongdun_df = str2;
        this.is_emulator = bool;
        this.raw_tongdun_info = str3;
    }

    private GetTongdunInfoResponse(Builder builder) {
        this(builder.requestid, builder.errcode, builder.tongdun_df, builder.is_emulator, builder.raw_tongdun_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTongdunInfoResponse)) {
            return false;
        }
        GetTongdunInfoResponse getTongdunInfoResponse = (GetTongdunInfoResponse) obj;
        if (!equals((Object) this.requestid, (Object) getTongdunInfoResponse.requestid) || !equals((Object) this.errcode, (Object) getTongdunInfoResponse.errcode) || !equals((Object) this.tongdun_df, (Object) getTongdunInfoResponse.tongdun_df) || !equals((Object) this.is_emulator, (Object) getTongdunInfoResponse.is_emulator) || !equals((Object) this.raw_tongdun_info, (Object) getTongdunInfoResponse.raw_tongdun_info)) {
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
        String str2 = this.tongdun_df;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.is_emulator;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.raw_tongdun_info;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetTongdunInfoResponse> {
        public Integer errcode;
        public Boolean is_emulator;
        public String raw_tongdun_info;
        public String requestid;
        public String tongdun_df;

        public Builder() {
        }

        public Builder(GetTongdunInfoResponse getTongdunInfoResponse) {
            super(getTongdunInfoResponse);
            if (getTongdunInfoResponse != null) {
                this.requestid = getTongdunInfoResponse.requestid;
                this.errcode = getTongdunInfoResponse.errcode;
                this.tongdun_df = getTongdunInfoResponse.tongdun_df;
                this.is_emulator = getTongdunInfoResponse.is_emulator;
                this.raw_tongdun_info = getTongdunInfoResponse.raw_tongdun_info;
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

        public Builder tongdun_df(String str) {
            this.tongdun_df = str;
            return this;
        }

        public Builder is_emulator(Boolean bool) {
            this.is_emulator = bool;
            return this;
        }

        public Builder raw_tongdun_info(String str) {
            this.raw_tongdun_info = str;
            return this;
        }

        public GetTongdunInfoResponse build() {
            return new GetTongdunInfoResponse(this);
        }
    }
}
