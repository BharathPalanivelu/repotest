package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RequestSearchOrder extends Message {
    public static final Boolean DEFAULT_COLD_SEARCH_EXTEND = false;
    public static final List<Integer> DEFAULT_CUSTOMER_TYPE = Collections.emptyList();
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean cold_search_extend;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> customer_type;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userid;

    public RequestSearchOrder(RequestHeader requestHeader, String str, Integer num, Integer num2, List<Integer> list, Integer num3, Integer num4, Boolean bool) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.customer_type = immutableCopyOf(list);
        this.shopid = num3;
        this.userid = num4;
        this.cold_search_extend = bool;
    }

    private RequestSearchOrder(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.customer_type, builder.shopid, builder.userid, builder.cold_search_extend);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchOrder)) {
            return false;
        }
        RequestSearchOrder requestSearchOrder = (RequestSearchOrder) obj;
        if (!equals((Object) this.header, (Object) requestSearchOrder.header) || !equals((Object) this.keyword, (Object) requestSearchOrder.keyword) || !equals((Object) this.offset, (Object) requestSearchOrder.offset) || !equals((Object) this.limit, (Object) requestSearchOrder.limit) || !equals((List<?>) this.customer_type, (List<?>) requestSearchOrder.customer_type) || !equals((Object) this.shopid, (Object) requestSearchOrder.shopid) || !equals((Object) this.userid, (Object) requestSearchOrder.userid) || !equals((Object) this.cold_search_extend, (Object) requestSearchOrder.cold_search_extend)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        String str = this.keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<Integer> list = this.customer_type;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num3 = this.shopid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.userid;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.cold_search_extend;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchOrder> {
        public Boolean cold_search_extend;
        public List<Integer> customer_type;
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Integer offset;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(RequestSearchOrder requestSearchOrder) {
            super(requestSearchOrder);
            if (requestSearchOrder != null) {
                this.header = requestSearchOrder.header;
                this.keyword = requestSearchOrder.keyword;
                this.offset = requestSearchOrder.offset;
                this.limit = requestSearchOrder.limit;
                this.customer_type = RequestSearchOrder.copyOf(requestSearchOrder.customer_type);
                this.shopid = requestSearchOrder.shopid;
                this.userid = requestSearchOrder.userid;
                this.cold_search_extend = requestSearchOrder.cold_search_extend;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
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

        public Builder customer_type(List<Integer> list) {
            this.customer_type = checkForNulls(list);
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder cold_search_extend(Boolean bool) {
            this.cold_search_extend = bool;
            return this;
        }

        public RequestSearchOrder build() {
            return new RequestSearchOrder(this);
        }
    }
}
