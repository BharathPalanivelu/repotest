package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetMultiOrders extends Message {
    public static final List<Long> DEFAULT_ORDERID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetMultiOrders(String str, List<Long> list, String str2) {
        this.requestid = str;
        this.orderid = immutableCopyOf(list);
        this.token = str2;
    }

    private GetMultiOrders(Builder builder) {
        this(builder.requestid, builder.orderid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetMultiOrders)) {
            return false;
        }
        GetMultiOrders getMultiOrders = (GetMultiOrders) obj;
        if (!equals((Object) this.requestid, (Object) getMultiOrders.requestid) || !equals((List<?>) this.orderid, (List<?>) getMultiOrders.orderid) || !equals((Object) this.token, (Object) getMultiOrders.token)) {
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
        List<Long> list = this.orderid;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetMultiOrders> {
        public List<Long> orderid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetMultiOrders getMultiOrders) {
            super(getMultiOrders);
            if (getMultiOrders != null) {
                this.requestid = getMultiOrders.requestid;
                this.orderid = GetMultiOrders.copyOf(getMultiOrders.orderid);
                this.token = getMultiOrders.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orderid(List<Long> list) {
            this.orderid = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetMultiOrders build() {
            return new GetMultiOrders(this);
        }
    }
}
