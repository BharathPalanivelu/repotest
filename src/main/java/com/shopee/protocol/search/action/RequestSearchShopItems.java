package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RequestSearchShopItems extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final List<Integer> DEFAULT_SHOPIDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> shopids;

    public RequestSearchShopItems(RequestHeader requestHeader, List<Integer> list, Integer num, Integer num2, String str) {
        this.header = requestHeader;
        this.shopids = immutableCopyOf(list);
        this.offset = num;
        this.limit = num2;
        this.country = str;
    }

    private RequestSearchShopItems(Builder builder) {
        this(builder.header, builder.shopids, builder.offset, builder.limit, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchShopItems)) {
            return false;
        }
        RequestSearchShopItems requestSearchShopItems = (RequestSearchShopItems) obj;
        if (!equals((Object) this.header, (Object) requestSearchShopItems.header) || !equals((List<?>) this.shopids, (List<?>) requestSearchShopItems.shopids) || !equals((Object) this.offset, (Object) requestSearchShopItems.offset) || !equals((Object) this.limit, (Object) requestSearchShopItems.limit) || !equals((Object) this.country, (Object) requestSearchShopItems.country)) {
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
        List<Integer> list = this.shopids;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchShopItems> {
        public String country;
        public RequestHeader header;
        public Integer limit;
        public Integer offset;
        public List<Integer> shopids;

        public Builder() {
        }

        public Builder(RequestSearchShopItems requestSearchShopItems) {
            super(requestSearchShopItems);
            if (requestSearchShopItems != null) {
                this.header = requestSearchShopItems.header;
                this.shopids = RequestSearchShopItems.copyOf(requestSearchShopItems.shopids);
                this.offset = requestSearchShopItems.offset;
                this.limit = requestSearchShopItems.limit;
                this.country = requestSearchShopItems.country;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder shopids(List<Integer> list) {
            this.shopids = checkForNulls(list);
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public RequestSearchShopItems build() {
            return new RequestSearchShopItems(this);
        }
    }
}
