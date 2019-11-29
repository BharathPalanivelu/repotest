package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSetCoinReject extends Message {
    public static final List<CoinRejectRespData> DEFAULT_DATA = Collections.emptyList();
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CoinRejectRespData.class, tag = 4)
    public final List<CoinRejectRespData> data;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetCoinReject(String str, Integer num, String str2, List<CoinRejectRespData> list) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.data = immutableCopyOf(list);
    }

    private ResponseSetCoinReject(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetCoinReject)) {
            return false;
        }
        ResponseSetCoinReject responseSetCoinReject = (ResponseSetCoinReject) obj;
        if (!equals((Object) this.requestid, (Object) responseSetCoinReject.requestid) || !equals((Object) this.errcode, (Object) responseSetCoinReject.errcode) || !equals((Object) this.debug_msg, (Object) responseSetCoinReject.debug_msg) || !equals((List<?>) this.data, (List<?>) responseSetCoinReject.data)) {
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
        int i3 = (hashCode2 + i2) * 37;
        List<CoinRejectRespData> list = this.data;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseSetCoinReject> {
        public List<CoinRejectRespData> data;
        public String debug_msg;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetCoinReject responseSetCoinReject) {
            super(responseSetCoinReject);
            if (responseSetCoinReject != null) {
                this.requestid = responseSetCoinReject.requestid;
                this.errcode = responseSetCoinReject.errcode;
                this.debug_msg = responseSetCoinReject.debug_msg;
                this.data = ResponseSetCoinReject.copyOf(responseSetCoinReject.data);
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

        public Builder data(List<CoinRejectRespData> list) {
            this.data = checkForNulls(list);
            return this;
        }

        public ResponseSetCoinReject build() {
            return new ResponseSetCoinReject(this);
        }
    }
}
