package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetTransHistory extends Message {
    public static final Integer DEFAULT_HISTYPE = 0;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_TOTAL_FEE = false;
    public static final Boolean DEFAULT_NEED_TOTAL_NUMBER = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TIME_BEGIN = 0;
    public static final Integer DEFAULT_TIME_END = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10)
    public final BackendParam bparam;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer histype;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean need_total_fee;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean need_total_number;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer time_begin;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer time_end;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;

    public GetTransHistory(String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, String str2, Boolean bool, Boolean bool2, BackendParam backendParam) {
        this.requestid = str;
        this.histype = num;
        this.offset = num2;
        this.limit = num3;
        this.time_begin = num4;
        this.time_end = num5;
        this.token = str2;
        this.need_total_number = bool;
        this.need_total_fee = bool2;
        this.bparam = backendParam;
    }

    private GetTransHistory(Builder builder) {
        this(builder.requestid, builder.histype, builder.offset, builder.limit, builder.time_begin, builder.time_end, builder.token, builder.need_total_number, builder.need_total_fee, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTransHistory)) {
            return false;
        }
        GetTransHistory getTransHistory = (GetTransHistory) obj;
        if (!equals((Object) this.requestid, (Object) getTransHistory.requestid) || !equals((Object) this.histype, (Object) getTransHistory.histype) || !equals((Object) this.offset, (Object) getTransHistory.offset) || !equals((Object) this.limit, (Object) getTransHistory.limit) || !equals((Object) this.time_begin, (Object) getTransHistory.time_begin) || !equals((Object) this.time_end, (Object) getTransHistory.time_end) || !equals((Object) this.token, (Object) getTransHistory.token) || !equals((Object) this.need_total_number, (Object) getTransHistory.need_total_number) || !equals((Object) this.need_total_fee, (Object) getTransHistory.need_total_fee) || !equals((Object) this.bparam, (Object) getTransHistory.bparam)) {
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
        Integer num = this.histype;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.time_begin;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.time_end;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.need_total_number;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_total_fee;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetTransHistory> {
        public BackendParam bparam;
        public Integer histype;
        public Integer limit;
        public Boolean need_total_fee;
        public Boolean need_total_number;
        public Integer offset;
        public String requestid;
        public Integer time_begin;
        public Integer time_end;
        public String token;

        public Builder() {
        }

        public Builder(GetTransHistory getTransHistory) {
            super(getTransHistory);
            if (getTransHistory != null) {
                this.requestid = getTransHistory.requestid;
                this.histype = getTransHistory.histype;
                this.offset = getTransHistory.offset;
                this.limit = getTransHistory.limit;
                this.time_begin = getTransHistory.time_begin;
                this.time_end = getTransHistory.time_end;
                this.token = getTransHistory.token;
                this.need_total_number = getTransHistory.need_total_number;
                this.need_total_fee = getTransHistory.need_total_fee;
                this.bparam = getTransHistory.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder histype(Integer num) {
            this.histype = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder time_begin(Integer num) {
            this.time_begin = num;
            return this;
        }

        public Builder time_end(Integer num) {
            this.time_end = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder need_total_number(Boolean bool) {
            this.need_total_number = bool;
            return this;
        }

        public Builder need_total_fee(Boolean bool) {
            this.need_total_fee = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public GetTransHistory build() {
            return new GetTransHistory(this);
        }
    }
}
