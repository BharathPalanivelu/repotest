package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCartAllOrders extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<ShopOrder> DEFAULT_SHOPORDERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopOrder.class, tag = 3)
    public final List<ShopOrder> shoporders;

    public ResponseCartAllOrders(String str, Integer num, List<ShopOrder> list) {
        this.requestid = str;
        this.errcode = num;
        this.shoporders = immutableCopyOf(list);
    }

    private ResponseCartAllOrders(Builder builder) {
        this(builder.requestid, builder.errcode, builder.shoporders);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCartAllOrders)) {
            return false;
        }
        ResponseCartAllOrders responseCartAllOrders = (ResponseCartAllOrders) obj;
        if (!equals((Object) this.requestid, (Object) responseCartAllOrders.requestid) || !equals((Object) this.errcode, (Object) responseCartAllOrders.errcode) || !equals((List<?>) this.shoporders, (List<?>) responseCartAllOrders.shoporders)) {
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
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ShopOrder> list = this.shoporders;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseCartAllOrders> {
        public Integer errcode;
        public String requestid;
        public List<ShopOrder> shoporders;

        public Builder() {
        }

        public Builder(ResponseCartAllOrders responseCartAllOrders) {
            super(responseCartAllOrders);
            if (responseCartAllOrders != null) {
                this.requestid = responseCartAllOrders.requestid;
                this.errcode = responseCartAllOrders.errcode;
                this.shoporders = ResponseCartAllOrders.copyOf(responseCartAllOrders.shoporders);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder shoporders(List<ShopOrder> list) {
            this.shoporders = checkForNulls(list);
            return this;
        }

        public ResponseCartAllOrders build() {
            checkRequiredFields();
            return new ResponseCartAllOrders(this);
        }
    }
}
