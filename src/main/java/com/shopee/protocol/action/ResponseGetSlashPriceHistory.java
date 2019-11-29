package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetSlashPriceHistory extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<SlashPriceHistoryResponse> DEFAULT_HISTORIES = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = SlashPriceHistoryResponse.class, tag = 3)
    public final List<SlashPriceHistoryResponse> histories;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetSlashPriceHistory(String str, Integer num, List<SlashPriceHistoryResponse> list) {
        this.requestid = str;
        this.errcode = num;
        this.histories = immutableCopyOf(list);
    }

    private ResponseGetSlashPriceHistory(Builder builder) {
        this(builder.requestid, builder.errcode, builder.histories);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetSlashPriceHistory)) {
            return false;
        }
        ResponseGetSlashPriceHistory responseGetSlashPriceHistory = (ResponseGetSlashPriceHistory) obj;
        if (!equals((Object) this.requestid, (Object) responseGetSlashPriceHistory.requestid) || !equals((Object) this.errcode, (Object) responseGetSlashPriceHistory.errcode) || !equals((List<?>) this.histories, (List<?>) responseGetSlashPriceHistory.histories)) {
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
        List<SlashPriceHistoryResponse> list = this.histories;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetSlashPriceHistory> {
        public Integer errcode;
        public List<SlashPriceHistoryResponse> histories;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetSlashPriceHistory responseGetSlashPriceHistory) {
            super(responseGetSlashPriceHistory);
            if (responseGetSlashPriceHistory != null) {
                this.requestid = responseGetSlashPriceHistory.requestid;
                this.errcode = responseGetSlashPriceHistory.errcode;
                this.histories = ResponseGetSlashPriceHistory.copyOf(responseGetSlashPriceHistory.histories);
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

        public Builder histories(List<SlashPriceHistoryResponse> list) {
            this.histories = checkForNulls(list);
            return this;
        }

        public ResponseGetSlashPriceHistory build() {
            return new ResponseGetSlashPriceHistory(this);
        }
    }
}
