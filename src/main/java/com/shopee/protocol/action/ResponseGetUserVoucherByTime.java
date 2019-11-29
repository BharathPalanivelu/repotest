package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetUserVoucherByTime extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Long> DEFAULT_PROMOTIONIDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> promotionids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetUserVoucherByTime(String str, Integer num, List<Long> list) {
        this.requestid = str;
        this.errcode = num;
        this.promotionids = immutableCopyOf(list);
    }

    private ResponseGetUserVoucherByTime(Builder builder) {
        this(builder.requestid, builder.errcode, builder.promotionids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetUserVoucherByTime)) {
            return false;
        }
        ResponseGetUserVoucherByTime responseGetUserVoucherByTime = (ResponseGetUserVoucherByTime) obj;
        if (!equals((Object) this.requestid, (Object) responseGetUserVoucherByTime.requestid) || !equals((Object) this.errcode, (Object) responseGetUserVoucherByTime.errcode) || !equals((List<?>) this.promotionids, (List<?>) responseGetUserVoucherByTime.promotionids)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Long> list = this.promotionids;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetUserVoucherByTime> {
        public Integer errcode;
        public List<Long> promotionids;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetUserVoucherByTime responseGetUserVoucherByTime) {
            super(responseGetUserVoucherByTime);
            if (responseGetUserVoucherByTime != null) {
                this.requestid = responseGetUserVoucherByTime.requestid;
                this.errcode = responseGetUserVoucherByTime.errcode;
                this.promotionids = ResponseGetUserVoucherByTime.copyOf(responseGetUserVoucherByTime.promotionids);
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

        public Builder promotionids(List<Long> list) {
            this.promotionids = checkForNulls(list);
            return this;
        }

        public ResponseGetUserVoucherByTime build() {
            return new ResponseGetUserVoucherByTime(this);
        }
    }
}
