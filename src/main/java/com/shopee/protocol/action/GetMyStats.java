package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetMyStats extends Message {
    public static final Integer DEFAULT_BEGIN_DATE = 0;
    public static final Integer DEFAULT_END_DATE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer begin_date;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer end_date;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetMyStats(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.begin_date = num;
        this.end_date = num2;
    }

    private GetMyStats(Builder builder) {
        this(builder.requestid, builder.begin_date, builder.end_date);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetMyStats)) {
            return false;
        }
        GetMyStats getMyStats = (GetMyStats) obj;
        if (!equals((Object) this.requestid, (Object) getMyStats.requestid) || !equals((Object) this.begin_date, (Object) getMyStats.begin_date) || !equals((Object) this.end_date, (Object) getMyStats.end_date)) {
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
        Integer num = this.begin_date;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_date;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetMyStats> {
        public Integer begin_date;
        public Integer end_date;
        public String requestid;

        public Builder() {
        }

        public Builder(GetMyStats getMyStats) {
            super(getMyStats);
            if (getMyStats != null) {
                this.requestid = getMyStats.requestid;
                this.begin_date = getMyStats.begin_date;
                this.end_date = getMyStats.end_date;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder begin_date(Integer num) {
            this.begin_date = num;
            return this;
        }

        public Builder end_date(Integer num) {
            this.end_date = num;
            return this;
        }

        public GetMyStats build() {
            return new GetMyStats(this);
        }
    }
}
