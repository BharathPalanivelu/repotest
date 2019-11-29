package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetSearchShopCustomer extends Message {
    public static final List<Integer> DEFAULT_CUSTOMER_TYPE = Collections.emptyList();
    public static final String DEFAULT_FILTER = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT32)
    public final List<Integer> customer_type;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String filter;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public GetSearchShopCustomer(String str, Integer num, Integer num2, Integer num3, String str2, String str3, List<Integer> list) {
        this.requestid = str;
        this.shopid = num;
        this.offset = num2;
        this.limit = num3;
        this.token = str2;
        this.filter = str3;
        this.customer_type = immutableCopyOf(list);
    }

    private GetSearchShopCustomer(Builder builder) {
        this(builder.requestid, builder.shopid, builder.offset, builder.limit, builder.token, builder.filter, builder.customer_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSearchShopCustomer)) {
            return false;
        }
        GetSearchShopCustomer getSearchShopCustomer = (GetSearchShopCustomer) obj;
        if (!equals((Object) this.requestid, (Object) getSearchShopCustomer.requestid) || !equals((Object) this.shopid, (Object) getSearchShopCustomer.shopid) || !equals((Object) this.offset, (Object) getSearchShopCustomer.offset) || !equals((Object) this.limit, (Object) getSearchShopCustomer.limit) || !equals((Object) this.token, (Object) getSearchShopCustomer.token) || !equals((Object) this.filter, (Object) getSearchShopCustomer.filter) || !equals((List<?>) this.customer_type, (List<?>) getSearchShopCustomer.customer_type)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.filter;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode5 + i2) * 37;
        List<Integer> list = this.customer_type;
        int hashCode6 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    public static final class Builder extends Message.Builder<GetSearchShopCustomer> {
        public List<Integer> customer_type;
        public String filter;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(GetSearchShopCustomer getSearchShopCustomer) {
            super(getSearchShopCustomer);
            if (getSearchShopCustomer != null) {
                this.requestid = getSearchShopCustomer.requestid;
                this.shopid = getSearchShopCustomer.shopid;
                this.offset = getSearchShopCustomer.offset;
                this.limit = getSearchShopCustomer.limit;
                this.token = getSearchShopCustomer.token;
                this.filter = getSearchShopCustomer.filter;
                this.customer_type = GetSearchShopCustomer.copyOf(getSearchShopCustomer.customer_type);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder filter(String str) {
            this.filter = str;
            return this;
        }

        public Builder customer_type(List<Integer> list) {
            this.customer_type = checkForNulls(list);
            return this;
        }

        public GetSearchShopCustomer build() {
            return new GetSearchShopCustomer(this);
        }
    }
}
