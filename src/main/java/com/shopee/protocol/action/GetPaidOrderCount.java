package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetPaidOrderCount extends Message {
    public static final Long DEFAULT_AMOUNT_MIN = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TIME_END = 0;
    public static final Integer DEFAULT_TIME_START = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long amount_min;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer time_end;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer time_start;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetPaidOrderCount(String str, Integer num, Integer num2, Integer num3, Long l) {
        this.requestid = str;
        this.userid = num;
        this.time_start = num2;
        this.time_end = num3;
        this.amount_min = l;
    }

    private GetPaidOrderCount(Builder builder) {
        this(builder.requestid, builder.userid, builder.time_start, builder.time_end, builder.amount_min);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetPaidOrderCount)) {
            return false;
        }
        GetPaidOrderCount getPaidOrderCount = (GetPaidOrderCount) obj;
        if (!equals((Object) this.requestid, (Object) getPaidOrderCount.requestid) || !equals((Object) this.userid, (Object) getPaidOrderCount.userid) || !equals((Object) this.time_start, (Object) getPaidOrderCount.time_start) || !equals((Object) this.time_end, (Object) getPaidOrderCount.time_end) || !equals((Object) this.amount_min, (Object) getPaidOrderCount.amount_min)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.time_start;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.time_end;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.amount_min;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetPaidOrderCount> {
        public Long amount_min;
        public String requestid;
        public Integer time_end;
        public Integer time_start;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetPaidOrderCount getPaidOrderCount) {
            super(getPaidOrderCount);
            if (getPaidOrderCount != null) {
                this.requestid = getPaidOrderCount.requestid;
                this.userid = getPaidOrderCount.userid;
                this.time_start = getPaidOrderCount.time_start;
                this.time_end = getPaidOrderCount.time_end;
                this.amount_min = getPaidOrderCount.amount_min;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder time_start(Integer num) {
            this.time_start = num;
            return this;
        }

        public Builder time_end(Integer num) {
            this.time_end = num;
            return this;
        }

        public Builder amount_min(Long l) {
            this.amount_min = l;
            return this;
        }

        public GetPaidOrderCount build() {
            return new GetPaidOrderCount(this);
        }
    }
}
