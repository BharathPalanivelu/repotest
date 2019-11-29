package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetTransactionList extends Message {
    public static final Integer DEFAULT_BEGIN_TIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_LIST_TYPE = 0;
    public static final Boolean DEFAULT_NEED_TOTAL = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_TRANSACTION_ID = 0L;
    public static final List<Integer> DEFAULT_TRANSACTION_TYPE_LIST = Collections.emptyList();
    public static final Integer DEFAULT_WALLET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer begin_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer list_type;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean need_total;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long transaction_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT32)
    public final List<Integer> transaction_type_list;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer wallet_type;

    public GetTransactionList(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Long l, List<Integer> list, Boolean bool, Integer num6) {
        this.requestid = str;
        this.token = str2;
        this.begin_time = num;
        this.end_time = num2;
        this.list_type = num3;
        this.offset = num4;
        this.limit = num5;
        this.transaction_id = l;
        this.transaction_type_list = immutableCopyOf(list);
        this.need_total = bool;
        this.wallet_type = num6;
    }

    private GetTransactionList(Builder builder) {
        this(builder.requestid, builder.token, builder.begin_time, builder.end_time, builder.list_type, builder.offset, builder.limit, builder.transaction_id, builder.transaction_type_list, builder.need_total, builder.wallet_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTransactionList)) {
            return false;
        }
        GetTransactionList getTransactionList = (GetTransactionList) obj;
        if (!equals((Object) this.requestid, (Object) getTransactionList.requestid) || !equals((Object) this.token, (Object) getTransactionList.token) || !equals((Object) this.begin_time, (Object) getTransactionList.begin_time) || !equals((Object) this.end_time, (Object) getTransactionList.end_time) || !equals((Object) this.list_type, (Object) getTransactionList.list_type) || !equals((Object) this.offset, (Object) getTransactionList.offset) || !equals((Object) this.limit, (Object) getTransactionList.limit) || !equals((Object) this.transaction_id, (Object) getTransactionList.transaction_id) || !equals((List<?>) this.transaction_type_list, (List<?>) getTransactionList.transaction_type_list) || !equals((Object) this.need_total, (Object) getTransactionList.need_total) || !equals((Object) this.wallet_type, (Object) getTransactionList.wallet_type)) {
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
        Integer num = this.begin_time;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.list_type;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.offset;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.limit;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l = this.transaction_id;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        List<Integer> list = this.transaction_type_list;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.need_total;
        int hashCode10 = (hashCode9 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num6 = this.wallet_type;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetTransactionList> {
        public Integer begin_time;
        public Integer end_time;
        public Integer limit;
        public Integer list_type;
        public Boolean need_total;
        public Integer offset;
        public String requestid;
        public String token;
        public Long transaction_id;
        public List<Integer> transaction_type_list;
        public Integer wallet_type;

        public Builder() {
        }

        public Builder(GetTransactionList getTransactionList) {
            super(getTransactionList);
            if (getTransactionList != null) {
                this.requestid = getTransactionList.requestid;
                this.token = getTransactionList.token;
                this.begin_time = getTransactionList.begin_time;
                this.end_time = getTransactionList.end_time;
                this.list_type = getTransactionList.list_type;
                this.offset = getTransactionList.offset;
                this.limit = getTransactionList.limit;
                this.transaction_id = getTransactionList.transaction_id;
                this.transaction_type_list = GetTransactionList.copyOf(getTransactionList.transaction_type_list);
                this.need_total = getTransactionList.need_total;
                this.wallet_type = getTransactionList.wallet_type;
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

        public Builder begin_time(Integer num) {
            this.begin_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
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

        public Builder transaction_id(Long l) {
            this.transaction_id = l;
            return this;
        }

        public Builder transaction_type_list(List<Integer> list) {
            this.transaction_type_list = checkForNulls(list);
            return this;
        }

        public Builder need_total(Boolean bool) {
            this.need_total = bool;
            return this;
        }

        public Builder wallet_type(Integer num) {
            this.wallet_type = num;
            return this;
        }

        public GetTransactionList build() {
            return new GetTransactionList(this);
        }
    }
}
