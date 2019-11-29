package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetOrderList extends Message {
    public static final Integer DEFAULT_FILTER_SHOPID = 0;
    public static final Integer DEFAULT_FILTER_USERID = 0;
    public static final Boolean DEFAULT_GET_ORDER_COUNT = false;
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SORT_OPTIONS = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12)
    public final BackendParam bparam;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer filter_shopid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer filter_userid;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean get_order_count;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer sort_options;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public GetOrderList(String str, Boolean bool, Integer num, Integer num2, Integer num3, String str2, Integer num4, Integer num5, Boolean bool2, Integer num6, Boolean bool3, BackendParam backendParam) {
        this.requestid = str;
        this.is_seller = bool;
        this.type = num;
        this.offset = num2;
        this.limit = num3;
        this.token = str2;
        this.filter_shopid = num4;
        this.filter_userid = num5;
        this.get_order_count = bool2;
        this.sort_options = num6;
        this.is_group_buy = bool3;
        this.bparam = backendParam;
    }

    private GetOrderList(Builder builder) {
        this(builder.requestid, builder.is_seller, builder.type, builder.offset, builder.limit, builder.token, builder.filter_shopid, builder.filter_userid, builder.get_order_count, builder.sort_options, builder.is_group_buy, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOrderList)) {
            return false;
        }
        GetOrderList getOrderList = (GetOrderList) obj;
        if (!equals((Object) this.requestid, (Object) getOrderList.requestid) || !equals((Object) this.is_seller, (Object) getOrderList.is_seller) || !equals((Object) this.type, (Object) getOrderList.type) || !equals((Object) this.offset, (Object) getOrderList.offset) || !equals((Object) this.limit, (Object) getOrderList.limit) || !equals((Object) this.token, (Object) getOrderList.token) || !equals((Object) this.filter_shopid, (Object) getOrderList.filter_shopid) || !equals((Object) this.filter_userid, (Object) getOrderList.filter_userid) || !equals((Object) this.get_order_count, (Object) getOrderList.get_order_count) || !equals((Object) this.sort_options, (Object) getOrderList.sort_options) || !equals((Object) this.is_group_buy, (Object) getOrderList.is_group_buy) || !equals((Object) this.bparam, (Object) getOrderList.bparam)) {
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
        Boolean bool = this.is_seller;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.filter_shopid;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.filter_userid;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool2 = this.get_order_count;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num6 = this.sort_options;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_group_buy;
        int hashCode11 = (hashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetOrderList> {
        public BackendParam bparam;
        public Integer filter_shopid;
        public Integer filter_userid;
        public Boolean get_order_count;
        public Boolean is_group_buy;
        public Boolean is_seller;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public Integer sort_options;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(GetOrderList getOrderList) {
            super(getOrderList);
            if (getOrderList != null) {
                this.requestid = getOrderList.requestid;
                this.is_seller = getOrderList.is_seller;
                this.type = getOrderList.type;
                this.offset = getOrderList.offset;
                this.limit = getOrderList.limit;
                this.token = getOrderList.token;
                this.filter_shopid = getOrderList.filter_shopid;
                this.filter_userid = getOrderList.filter_userid;
                this.get_order_count = getOrderList.get_order_count;
                this.sort_options = getOrderList.sort_options;
                this.is_group_buy = getOrderList.is_group_buy;
                this.bparam = getOrderList.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
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

        public Builder filter_shopid(Integer num) {
            this.filter_shopid = num;
            return this;
        }

        public Builder filter_userid(Integer num) {
            this.filter_userid = num;
            return this;
        }

        public Builder get_order_count(Boolean bool) {
            this.get_order_count = bool;
            return this;
        }

        public Builder sort_options(Integer num) {
            this.sort_options = num;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public GetOrderList build() {
            return new GetOrderList(this);
        }
    }
}
