package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetPenaltyInfo extends Message {
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_HISTORICAL_LOGID = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_TRANSIFY = false;
    public static final Integer DEFAULT_OFFENCE_TYPE = 0;
    public static final Long DEFAULT_OFFSET = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SHOP_PERFORMANCE_TYPE = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long historical_logid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean need_transify;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer offence_type;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer shop_performance_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    public GetPenaltyInfo(String str, Integer num, BackendParam backendParam, Integer num2, String str2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Long l2, Integer num7, Boolean bool) {
        this.requestid = str;
        this.shopid = num;
        this.bparam = backendParam;
        this.type = num2;
        this.token = str2;
        this.offset = l;
        this.limit = num3;
        this.start_time = num4;
        this.end_time = num5;
        this.offence_type = num6;
        this.historical_logid = l2;
        this.shop_performance_type = num7;
        this.need_transify = bool;
    }

    private GetPenaltyInfo(Builder builder) {
        this(builder.requestid, builder.shopid, builder.bparam, builder.type, builder.token, builder.offset, builder.limit, builder.start_time, builder.end_time, builder.offence_type, builder.historical_logid, builder.shop_performance_type, builder.need_transify);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetPenaltyInfo)) {
            return false;
        }
        GetPenaltyInfo getPenaltyInfo = (GetPenaltyInfo) obj;
        if (!equals((Object) this.requestid, (Object) getPenaltyInfo.requestid) || !equals((Object) this.shopid, (Object) getPenaltyInfo.shopid) || !equals((Object) this.bparam, (Object) getPenaltyInfo.bparam) || !equals((Object) this.type, (Object) getPenaltyInfo.type) || !equals((Object) this.token, (Object) getPenaltyInfo.token) || !equals((Object) this.offset, (Object) getPenaltyInfo.offset) || !equals((Object) this.limit, (Object) getPenaltyInfo.limit) || !equals((Object) this.start_time, (Object) getPenaltyInfo.start_time) || !equals((Object) this.end_time, (Object) getPenaltyInfo.end_time) || !equals((Object) this.offence_type, (Object) getPenaltyInfo.offence_type) || !equals((Object) this.historical_logid, (Object) getPenaltyInfo.historical_logid) || !equals((Object) this.shop_performance_type, (Object) getPenaltyInfo.shop_performance_type) || !equals((Object) this.need_transify, (Object) getPenaltyInfo.need_transify)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.offset;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.start_time;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.end_time;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.offence_type;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.historical_logid;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num7 = this.shop_performance_type;
        int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Boolean bool = this.need_transify;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetPenaltyInfo> {
        public BackendParam bparam;
        public Integer end_time;
        public Long historical_logid;
        public Integer limit;
        public Boolean need_transify;
        public Integer offence_type;
        public Long offset;
        public String requestid;
        public Integer shop_performance_type;
        public Integer shopid;
        public Integer start_time;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(GetPenaltyInfo getPenaltyInfo) {
            super(getPenaltyInfo);
            if (getPenaltyInfo != null) {
                this.requestid = getPenaltyInfo.requestid;
                this.shopid = getPenaltyInfo.shopid;
                this.bparam = getPenaltyInfo.bparam;
                this.type = getPenaltyInfo.type;
                this.token = getPenaltyInfo.token;
                this.offset = getPenaltyInfo.offset;
                this.limit = getPenaltyInfo.limit;
                this.start_time = getPenaltyInfo.start_time;
                this.end_time = getPenaltyInfo.end_time;
                this.offence_type = getPenaltyInfo.offence_type;
                this.historical_logid = getPenaltyInfo.historical_logid;
                this.shop_performance_type = getPenaltyInfo.shop_performance_type;
                this.need_transify = getPenaltyInfo.need_transify;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder offset(Long l) {
            this.offset = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder offence_type(Integer num) {
            this.offence_type = num;
            return this;
        }

        public Builder historical_logid(Long l) {
            this.historical_logid = l;
            return this;
        }

        public Builder shop_performance_type(Integer num) {
            this.shop_performance_type = num;
            return this;
        }

        public Builder need_transify(Boolean bool) {
            this.need_transify = bool;
            return this;
        }

        public GetPenaltyInfo build() {
            return new GetPenaltyInfo(this);
        }
    }
}
