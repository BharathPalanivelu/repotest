package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetUserVoucherByTime extends Message {
    public static final Integer DEFAULT_CTIME_GT = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime_gt;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetUserVoucherByTime(String str, String str2, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.ctime_gt = num;
    }

    private GetUserVoucherByTime(Builder builder) {
        this(builder.requestid, builder.token, builder.ctime_gt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUserVoucherByTime)) {
            return false;
        }
        GetUserVoucherByTime getUserVoucherByTime = (GetUserVoucherByTime) obj;
        if (!equals((Object) this.requestid, (Object) getUserVoucherByTime.requestid) || !equals((Object) this.token, (Object) getUserVoucherByTime.token) || !equals((Object) this.ctime_gt, (Object) getUserVoucherByTime.ctime_gt)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ctime_gt;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetUserVoucherByTime> {
        public Integer ctime_gt;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetUserVoucherByTime getUserVoucherByTime) {
            super(getUserVoucherByTime);
            if (getUserVoucherByTime != null) {
                this.requestid = getUserVoucherByTime.requestid;
                this.token = getUserVoucherByTime.token;
                this.ctime_gt = getUserVoucherByTime.ctime_gt;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder ctime_gt(Integer num) {
            this.ctime_gt = num;
            return this;
        }

        public GetUserVoucherByTime build() {
            return new GetUserVoucherByTime(this);
        }
    }
}
