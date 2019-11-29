package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCustomOrders extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SHIPPING_NAME = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String shipping_name;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetCustomOrders(String str, Integer num, Integer num2, Integer num3, String str2, String str3) {
        this.requestid = str;
        this.userid = num;
        this.offset = num2;
        this.limit = num3;
        this.token = str2;
        this.shipping_name = str3;
    }

    private GetCustomOrders(Builder builder) {
        this(builder.requestid, builder.userid, builder.offset, builder.limit, builder.token, builder.shipping_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCustomOrders)) {
            return false;
        }
        GetCustomOrders getCustomOrders = (GetCustomOrders) obj;
        if (!equals((Object) this.requestid, (Object) getCustomOrders.requestid) || !equals((Object) this.userid, (Object) getCustomOrders.userid) || !equals((Object) this.offset, (Object) getCustomOrders.offset) || !equals((Object) this.limit, (Object) getCustomOrders.limit) || !equals((Object) this.token, (Object) getCustomOrders.token) || !equals((Object) this.shipping_name, (Object) getCustomOrders.shipping_name)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.shipping_name;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCustomOrders> {
        public Integer limit;
        public Integer offset;
        public String requestid;
        public String shipping_name;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetCustomOrders getCustomOrders) {
            super(getCustomOrders);
            if (getCustomOrders != null) {
                this.requestid = getCustomOrders.requestid;
                this.userid = getCustomOrders.userid;
                this.offset = getCustomOrders.offset;
                this.limit = getCustomOrders.limit;
                this.token = getCustomOrders.token;
                this.shipping_name = getCustomOrders.shipping_name;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public Builder shipping_name(String str) {
            this.shipping_name = str;
            return this;
        }

        public GetCustomOrders build() {
            return new GetCustomOrders(this);
        }
    }
}
