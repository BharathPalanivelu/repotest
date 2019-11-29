package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchOrderResult extends Message {
    public static final List<Long> DEFAULT_ORDERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> orderid;

    public ResponseSearchOrderResult(ResponseHeader responseHeader, List<Long> list) {
        this.header = responseHeader;
        this.orderid = immutableCopyOf(list);
    }

    private ResponseSearchOrderResult(Builder builder) {
        this(builder.header, builder.orderid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchOrderResult)) {
            return false;
        }
        ResponseSearchOrderResult responseSearchOrderResult = (ResponseSearchOrderResult) obj;
        if (!equals((Object) this.header, (Object) responseSearchOrderResult.header) || !equals((List<?>) this.orderid, (List<?>) responseSearchOrderResult.orderid)) {
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
        List<Long> list = this.orderid;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSearchOrderResult> {
        public ResponseHeader header;
        public List<Long> orderid;

        public Builder() {
        }

        public Builder(ResponseSearchOrderResult responseSearchOrderResult) {
            super(responseSearchOrderResult);
            if (responseSearchOrderResult != null) {
                this.header = responseSearchOrderResult.header;
                this.orderid = ResponseSearchOrderResult.copyOf(responseSearchOrderResult.orderid);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder orderid(List<Long> list) {
            this.orderid = checkForNulls(list);
            return this;
        }

        public ResponseSearchOrderResult build() {
            return new ResponseSearchOrderResult(this);
        }
    }
}
