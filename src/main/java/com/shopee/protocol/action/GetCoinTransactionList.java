package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetCoinTransactionList extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_LIST_TYPE = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final List<CoinTransOrderid> DEFAULT_TRANS_ORDERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer list_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, messageType = CoinTransOrderid.class, tag = 7)
    public final List<CoinTransOrderid> trans_orderid;

    public GetCoinTransactionList(String str, String str2, Integer num, Integer num2, Integer num3, BackendParam backendParam, List<CoinTransOrderid> list) {
        this.requestid = str;
        this.token = str2;
        this.list_type = num;
        this.offset = num2;
        this.limit = num3;
        this.bparam = backendParam;
        this.trans_orderid = immutableCopyOf(list);
    }

    private GetCoinTransactionList(Builder builder) {
        this(builder.requestid, builder.token, builder.list_type, builder.offset, builder.limit, builder.bparam, builder.trans_orderid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCoinTransactionList)) {
            return false;
        }
        GetCoinTransactionList getCoinTransactionList = (GetCoinTransactionList) obj;
        if (!equals((Object) this.requestid, (Object) getCoinTransactionList.requestid) || !equals((Object) this.token, (Object) getCoinTransactionList.token) || !equals((Object) this.list_type, (Object) getCoinTransactionList.list_type) || !equals((Object) this.offset, (Object) getCoinTransactionList.offset) || !equals((Object) this.limit, (Object) getCoinTransactionList.limit) || !equals((Object) this.bparam, (Object) getCoinTransactionList.bparam) || !equals((List<?>) this.trans_orderid, (List<?>) getCoinTransactionList.trans_orderid)) {
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
        Integer num = this.list_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = (hashCode5 + i2) * 37;
        List<CoinTransOrderid> list = this.trans_orderid;
        int hashCode6 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    public static final class Builder extends Message.Builder<GetCoinTransactionList> {
        public BackendParam bparam;
        public Integer limit;
        public Integer list_type;
        public Integer offset;
        public String requestid;
        public String token;
        public List<CoinTransOrderid> trans_orderid;

        public Builder() {
        }

        public Builder(GetCoinTransactionList getCoinTransactionList) {
            super(getCoinTransactionList);
            if (getCoinTransactionList != null) {
                this.requestid = getCoinTransactionList.requestid;
                this.token = getCoinTransactionList.token;
                this.list_type = getCoinTransactionList.list_type;
                this.offset = getCoinTransactionList.offset;
                this.limit = getCoinTransactionList.limit;
                this.bparam = getCoinTransactionList.bparam;
                this.trans_orderid = GetCoinTransactionList.copyOf(getCoinTransactionList.trans_orderid);
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

        public Builder list_type(Integer num) {
            this.list_type = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder trans_orderid(List<CoinTransOrderid> list) {
            this.trans_orderid = checkForNulls(list);
            return this;
        }

        public GetCoinTransactionList build() {
            return new GetCoinTransactionList(this);
        }
    }
}
