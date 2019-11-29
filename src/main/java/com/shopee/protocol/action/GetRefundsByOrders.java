package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetRefundsByOrders extends Message {
    public static final List<Long> DEFAULT_ORDERIDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> orderids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetRefundsByOrders(String str, List<Long> list, String str2) {
        this.requestid = str;
        this.orderids = immutableCopyOf(list);
        this.token = str2;
    }

    private GetRefundsByOrders(Builder builder) {
        this(builder.requestid, builder.orderids, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetRefundsByOrders)) {
            return false;
        }
        GetRefundsByOrders getRefundsByOrders = (GetRefundsByOrders) obj;
        if (!equals((Object) this.requestid, (Object) getRefundsByOrders.requestid) || !equals((List<?>) this.orderids, (List<?>) getRefundsByOrders.orderids) || !equals((Object) this.token, (Object) getRefundsByOrders.token)) {
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
        List<Long> list = this.orderids;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetRefundsByOrders> {
        public List<Long> orderids;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetRefundsByOrders getRefundsByOrders) {
            super(getRefundsByOrders);
            if (getRefundsByOrders != null) {
                this.requestid = getRefundsByOrders.requestid;
                this.orderids = GetRefundsByOrders.copyOf(getRefundsByOrders.orderids);
                this.token = getRefundsByOrders.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orderids(List<Long> list) {
            this.orderids = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetRefundsByOrders build() {
            return new GetRefundsByOrders(this);
        }
    }
}
