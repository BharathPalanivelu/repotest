package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class QueryOTPHistoryRequest extends Message {
    public static final List<String> DEFAULT_PHONE = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SEND_TIME_END = 0;
    public static final Integer DEFAULT_SEND_TIME_START = 0;
    public static final List<Integer> DEFAULT_USER_ID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final Pagination page;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer send_time_end;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer send_time_start;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.UINT32)
    public final List<Integer> user_id;

    public QueryOTPHistoryRequest(String str, Integer num, Integer num2, List<Integer> list, List<String> list2, Pagination pagination) {
        this.requestid = str;
        this.send_time_start = num;
        this.send_time_end = num2;
        this.user_id = immutableCopyOf(list);
        this.phone = immutableCopyOf(list2);
        this.page = pagination;
    }

    private QueryOTPHistoryRequest(Builder builder) {
        this(builder.requestid, builder.send_time_start, builder.send_time_end, builder.user_id, builder.phone, builder.page);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryOTPHistoryRequest)) {
            return false;
        }
        QueryOTPHistoryRequest queryOTPHistoryRequest = (QueryOTPHistoryRequest) obj;
        if (!equals((Object) this.requestid, (Object) queryOTPHistoryRequest.requestid) || !equals((Object) this.send_time_start, (Object) queryOTPHistoryRequest.send_time_start) || !equals((Object) this.send_time_end, (Object) queryOTPHistoryRequest.send_time_end) || !equals((List<?>) this.user_id, (List<?>) queryOTPHistoryRequest.user_id) || !equals((List<?>) this.phone, (List<?>) queryOTPHistoryRequest.phone) || !equals((Object) this.page, (Object) queryOTPHistoryRequest.page)) {
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
        Integer num = this.send_time_start;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.send_time_end;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<Integer> list = this.user_id;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        List<String> list2 = this.phone;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode4 + i3) * 37;
        Pagination pagination = this.page;
        if (pagination != null) {
            i2 = pagination.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<QueryOTPHistoryRequest> {
        public Pagination page;
        public List<String> phone;
        public String requestid;
        public Integer send_time_end;
        public Integer send_time_start;
        public List<Integer> user_id;

        public Builder() {
        }

        public Builder(QueryOTPHistoryRequest queryOTPHistoryRequest) {
            super(queryOTPHistoryRequest);
            if (queryOTPHistoryRequest != null) {
                this.requestid = queryOTPHistoryRequest.requestid;
                this.send_time_start = queryOTPHistoryRequest.send_time_start;
                this.send_time_end = queryOTPHistoryRequest.send_time_end;
                this.user_id = QueryOTPHistoryRequest.copyOf(queryOTPHistoryRequest.user_id);
                this.phone = QueryOTPHistoryRequest.copyOf(queryOTPHistoryRequest.phone);
                this.page = queryOTPHistoryRequest.page;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder send_time_start(Integer num) {
            this.send_time_start = num;
            return this;
        }

        public Builder send_time_end(Integer num) {
            this.send_time_end = num;
            return this;
        }

        public Builder user_id(List<Integer> list) {
            this.user_id = checkForNulls(list);
            return this;
        }

        public Builder phone(List<String> list) {
            this.phone = checkForNulls(list);
            return this;
        }

        public Builder page(Pagination pagination) {
            this.page = pagination;
            return this;
        }

        public QueryOTPHistoryRequest build() {
            return new QueryOTPHistoryRequest(this);
        }
    }
}
