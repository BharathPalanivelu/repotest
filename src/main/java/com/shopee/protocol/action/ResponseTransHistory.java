package com.shopee.protocol.action;

import com.shopee.protocol.shop.TransHistory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseTransHistory extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<TransHistory> DEFAULT_HISTORY = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_SUM_INCOME = 0L;
    public static final List<FeeInfo> DEFAULT_TOTAL_FEELIST = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL_NUMBER = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = TransHistory.class, tag = 3)
    public final List<TransHistory> history;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long sum_income;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeeInfo.class, tag = 6)
    public final List<FeeInfo> total_feelist;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total_number;

    public ResponseTransHistory(String str, Integer num, List<TransHistory> list, Integer num2, Long l, List<FeeInfo> list2) {
        this.requestid = str;
        this.errcode = num;
        this.history = immutableCopyOf(list);
        this.total_number = num2;
        this.sum_income = l;
        this.total_feelist = immutableCopyOf(list2);
    }

    private ResponseTransHistory(Builder builder) {
        this(builder.requestid, builder.errcode, builder.history, builder.total_number, builder.sum_income, builder.total_feelist);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseTransHistory)) {
            return false;
        }
        ResponseTransHistory responseTransHistory = (ResponseTransHistory) obj;
        if (!equals((Object) this.requestid, (Object) responseTransHistory.requestid) || !equals((Object) this.errcode, (Object) responseTransHistory.errcode) || !equals((List<?>) this.history, (List<?>) responseTransHistory.history) || !equals((Object) this.total_number, (Object) responseTransHistory.total_number) || !equals((Object) this.sum_income, (Object) responseTransHistory.sum_income) || !equals((List<?>) this.total_feelist, (List<?>) responseTransHistory.total_feelist)) {
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
        List<TransHistory> list = this.history;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total_number;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.sum_income;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i4 = (hashCode4 + i2) * 37;
        List<FeeInfo> list2 = this.total_feelist;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseTransHistory> {
        public Integer errcode;
        public List<TransHistory> history;
        public String requestid;
        public Long sum_income;
        public List<FeeInfo> total_feelist;
        public Integer total_number;

        public Builder() {
        }

        public Builder(ResponseTransHistory responseTransHistory) {
            super(responseTransHistory);
            if (responseTransHistory != null) {
                this.requestid = responseTransHistory.requestid;
                this.errcode = responseTransHistory.errcode;
                this.history = ResponseTransHistory.copyOf(responseTransHistory.history);
                this.total_number = responseTransHistory.total_number;
                this.sum_income = responseTransHistory.sum_income;
                this.total_feelist = ResponseTransHistory.copyOf(responseTransHistory.total_feelist);
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

        public Builder history(List<TransHistory> list) {
            this.history = checkForNulls(list);
            return this;
        }

        public Builder total_number(Integer num) {
            this.total_number = num;
            return this;
        }

        public Builder sum_income(Long l) {
            this.sum_income = l;
            return this;
        }

        public Builder total_feelist(List<FeeInfo> list) {
            this.total_feelist = checkForNulls(list);
            return this;
        }

        public ResponseTransHistory build() {
            checkRequiredFields();
            return new ResponseTransHistory(this);
        }
    }
}
