package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchOrderBuyer extends Message {
    public static final List<ShopOrder> DEFAULT_SHOPORDERS = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopOrder.class, tag = 2)
    public final List<ShopOrder> shoporders;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total;

    public ResponseSearchOrderBuyer(ResponseHeader responseHeader, List<ShopOrder> list, Integer num) {
        this.header = responseHeader;
        this.shoporders = immutableCopyOf(list);
        this.total = num;
    }

    private ResponseSearchOrderBuyer(Builder builder) {
        this(builder.header, builder.shoporders, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchOrderBuyer)) {
            return false;
        }
        ResponseSearchOrderBuyer responseSearchOrderBuyer = (ResponseSearchOrderBuyer) obj;
        if (!equals((Object) this.header, (Object) responseSearchOrderBuyer.header) || !equals((List<?>) this.shoporders, (List<?>) responseSearchOrderBuyer.shoporders) || !equals((Object) this.total, (Object) responseSearchOrderBuyer.total)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<ShopOrder> list = this.shoporders;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.total;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSearchOrderBuyer> {
        public ResponseHeader header;
        public List<ShopOrder> shoporders;
        public Integer total;

        public Builder() {
        }

        public Builder(ResponseSearchOrderBuyer responseSearchOrderBuyer) {
            super(responseSearchOrderBuyer);
            if (responseSearchOrderBuyer != null) {
                this.header = responseSearchOrderBuyer.header;
                this.shoporders = ResponseSearchOrderBuyer.copyOf(responseSearchOrderBuyer.shoporders);
                this.total = responseSearchOrderBuyer.total;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder shoporders(List<ShopOrder> list) {
            this.shoporders = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public ResponseSearchOrderBuyer build() {
            return new ResponseSearchOrderBuyer(this);
        }
    }
}
