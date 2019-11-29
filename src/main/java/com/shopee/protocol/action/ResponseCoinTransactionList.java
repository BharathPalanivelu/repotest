package com.shopee.protocol.action;

import com.shopee.protocol.shop.CoinTransaction;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCoinTransactionList extends Message {
    public static final List<CoinTransaction> DEFAULT_COIN_TRANSACTION_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CoinTransaction.class, tag = 3)
    public final List<CoinTransaction> coin_transaction_list;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCoinTransactionList(String str, Integer num, List<CoinTransaction> list) {
        this.requestid = str;
        this.errcode = num;
        this.coin_transaction_list = immutableCopyOf(list);
    }

    private ResponseCoinTransactionList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.coin_transaction_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCoinTransactionList)) {
            return false;
        }
        ResponseCoinTransactionList responseCoinTransactionList = (ResponseCoinTransactionList) obj;
        if (!equals((Object) this.requestid, (Object) responseCoinTransactionList.requestid) || !equals((Object) this.errcode, (Object) responseCoinTransactionList.errcode) || !equals((List<?>) this.coin_transaction_list, (List<?>) responseCoinTransactionList.coin_transaction_list)) {
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
        List<CoinTransaction> list = this.coin_transaction_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseCoinTransactionList> {
        public List<CoinTransaction> coin_transaction_list;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCoinTransactionList responseCoinTransactionList) {
            super(responseCoinTransactionList);
            if (responseCoinTransactionList != null) {
                this.requestid = responseCoinTransactionList.requestid;
                this.errcode = responseCoinTransactionList.errcode;
                this.coin_transaction_list = ResponseCoinTransactionList.copyOf(responseCoinTransactionList.coin_transaction_list);
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

        public Builder coin_transaction_list(List<CoinTransaction> list) {
            this.coin_transaction_list = checkForNulls(list);
            return this;
        }

        public ResponseCoinTransactionList build() {
            return new ResponseCoinTransactionList(this);
        }
    }
}
