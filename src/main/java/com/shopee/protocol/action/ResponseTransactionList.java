package com.shopee.protocol.action;

import com.shopee.protocol.shop.PocketBreakdown;
import com.shopee.protocol.shop.WalletTransaction;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseTransactionList extends Message {
    public static final List<PocketBreakdown> DEFAULT_BREAKDOWN_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_TOTAL_AMOUNT = 0L;
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    public static final List<WalletTransaction> DEFAULT_TRANSACTION_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = PocketBreakdown.class, tag = 6)
    public final List<PocketBreakdown> breakdown_list;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long total_amount;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer total_count;
    @ProtoField(label = Message.Label.REPEATED, messageType = WalletTransaction.class, tag = 3)
    public final List<WalletTransaction> transaction_list;

    public ResponseTransactionList(String str, Integer num, List<WalletTransaction> list, Long l, Integer num2, List<PocketBreakdown> list2) {
        this.requestid = str;
        this.errcode = num;
        this.transaction_list = immutableCopyOf(list);
        this.total_amount = l;
        this.total_count = num2;
        this.breakdown_list = immutableCopyOf(list2);
    }

    private ResponseTransactionList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.transaction_list, builder.total_amount, builder.total_count, builder.breakdown_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseTransactionList)) {
            return false;
        }
        ResponseTransactionList responseTransactionList = (ResponseTransactionList) obj;
        if (!equals((Object) this.requestid, (Object) responseTransactionList.requestid) || !equals((Object) this.errcode, (Object) responseTransactionList.errcode) || !equals((List<?>) this.transaction_list, (List<?>) responseTransactionList.transaction_list) || !equals((Object) this.total_amount, (Object) responseTransactionList.total_amount) || !equals((Object) this.total_count, (Object) responseTransactionList.total_count) || !equals((List<?>) this.breakdown_list, (List<?>) responseTransactionList.breakdown_list)) {
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
        List<WalletTransaction> list = this.transaction_list;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.total_amount;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.total_count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i4 = (hashCode4 + i2) * 37;
        List<PocketBreakdown> list2 = this.breakdown_list;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseTransactionList> {
        public List<PocketBreakdown> breakdown_list;
        public Integer errcode;
        public String requestid;
        public Long total_amount;
        public Integer total_count;
        public List<WalletTransaction> transaction_list;

        public Builder() {
        }

        public Builder(ResponseTransactionList responseTransactionList) {
            super(responseTransactionList);
            if (responseTransactionList != null) {
                this.requestid = responseTransactionList.requestid;
                this.errcode = responseTransactionList.errcode;
                this.transaction_list = ResponseTransactionList.copyOf(responseTransactionList.transaction_list);
                this.total_amount = responseTransactionList.total_amount;
                this.total_count = responseTransactionList.total_count;
                this.breakdown_list = ResponseTransactionList.copyOf(responseTransactionList.breakdown_list);
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

        public Builder transaction_list(List<WalletTransaction> list) {
            this.transaction_list = checkForNulls(list);
            return this;
        }

        public Builder total_amount(Long l) {
            this.total_amount = l;
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder breakdown_list(List<PocketBreakdown> list) {
            this.breakdown_list = checkForNulls(list);
            return this;
        }

        public ResponseTransactionList build() {
            return new ResponseTransactionList(this);
        }
    }
}
