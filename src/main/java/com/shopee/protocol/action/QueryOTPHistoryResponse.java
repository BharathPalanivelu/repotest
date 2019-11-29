package com.shopee.protocol.action;

import com.shopee.protocol.shop.VcodeHistory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class QueryOTPHistoryResponse extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<VcodeHistory> DEFAULT_OTP_HISTORY = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = VcodeHistory.class, tag = 2)
    public final List<VcodeHistory> otp_history;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public QueryOTPHistoryResponse(String str, List<VcodeHistory> list, Integer num, String str2) {
        this.requestid = str;
        this.otp_history = immutableCopyOf(list);
        this.errcode = num;
        this.debug_msg = str2;
    }

    private QueryOTPHistoryResponse(Builder builder) {
        this(builder.requestid, builder.otp_history, builder.errcode, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryOTPHistoryResponse)) {
            return false;
        }
        QueryOTPHistoryResponse queryOTPHistoryResponse = (QueryOTPHistoryResponse) obj;
        if (!equals((Object) this.requestid, (Object) queryOTPHistoryResponse.requestid) || !equals((List<?>) this.otp_history, (List<?>) queryOTPHistoryResponse.otp_history) || !equals((Object) this.errcode, (Object) queryOTPHistoryResponse.errcode) || !equals((Object) this.debug_msg, (Object) queryOTPHistoryResponse.debug_msg)) {
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
        List<VcodeHistory> list = this.otp_history;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.errcode;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<QueryOTPHistoryResponse> {
        public String debug_msg;
        public Integer errcode;
        public List<VcodeHistory> otp_history;
        public String requestid;

        public Builder() {
        }

        public Builder(QueryOTPHistoryResponse queryOTPHistoryResponse) {
            super(queryOTPHistoryResponse);
            if (queryOTPHistoryResponse != null) {
                this.requestid = queryOTPHistoryResponse.requestid;
                this.otp_history = QueryOTPHistoryResponse.copyOf(queryOTPHistoryResponse.otp_history);
                this.errcode = queryOTPHistoryResponse.errcode;
                this.debug_msg = queryOTPHistoryResponse.debug_msg;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder otp_history(List<VcodeHistory> list) {
            this.otp_history = checkForNulls(list);
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

        public QueryOTPHistoryResponse build() {
            return new QueryOTPHistoryResponse(this);
        }
    }
}
