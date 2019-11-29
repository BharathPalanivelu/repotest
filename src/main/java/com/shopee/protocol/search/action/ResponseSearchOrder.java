package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchOrder extends Message {
    public static final List<ShopOrderGroup> DEFAULT_SHOPORDER_GROUPS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopOrderGroup.class, tag = 2)
    public final List<ShopOrderGroup> shoporder_groups;

    public ResponseSearchOrder(ResponseHeader responseHeader, List<ShopOrderGroup> list) {
        this.header = responseHeader;
        this.shoporder_groups = immutableCopyOf(list);
    }

    private ResponseSearchOrder(Builder builder) {
        this(builder.header, builder.shoporder_groups);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchOrder)) {
            return false;
        }
        ResponseSearchOrder responseSearchOrder = (ResponseSearchOrder) obj;
        if (!equals((Object) this.header, (Object) responseSearchOrder.header) || !equals((List<?>) this.shoporder_groups, (List<?>) responseSearchOrder.shoporder_groups)) {
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
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<ShopOrderGroup> list = this.shoporder_groups;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSearchOrder> {
        public ResponseHeader header;
        public List<ShopOrderGroup> shoporder_groups;

        public Builder() {
        }

        public Builder(ResponseSearchOrder responseSearchOrder) {
            super(responseSearchOrder);
            if (responseSearchOrder != null) {
                this.header = responseSearchOrder.header;
                this.shoporder_groups = ResponseSearchOrder.copyOf(responseSearchOrder.shoporder_groups);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder shoporder_groups(List<ShopOrderGroup> list) {
            this.shoporder_groups = checkForNulls(list);
            return this;
        }

        public ResponseSearchOrder build() {
            return new ResponseSearchOrder(this);
        }
    }
}
