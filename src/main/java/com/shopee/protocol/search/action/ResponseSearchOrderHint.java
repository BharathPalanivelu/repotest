package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchOrderHint extends Message {
    public static final List<Long> DEFAULT_ITEMID = Collections.emptyList();
    public static final List<Long> DEFAULT_ORDERID = Collections.emptyList();
    public static final List<Long> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> itemid;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> orderid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> userid;

    public ResponseSearchOrderHint(ResponseHeader responseHeader, List<Long> list, List<Long> list2, List<Long> list3) {
        this.header = responseHeader;
        this.orderid = immutableCopyOf(list);
        this.userid = immutableCopyOf(list2);
        this.itemid = immutableCopyOf(list3);
    }

    private ResponseSearchOrderHint(Builder builder) {
        this(builder.header, builder.orderid, builder.userid, builder.itemid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchOrderHint)) {
            return false;
        }
        ResponseSearchOrderHint responseSearchOrderHint = (ResponseSearchOrderHint) obj;
        if (!equals((Object) this.header, (Object) responseSearchOrderHint.header) || !equals((List<?>) this.orderid, (List<?>) responseSearchOrderHint.orderid) || !equals((List<?>) this.userid, (List<?>) responseSearchOrderHint.userid) || !equals((List<?>) this.itemid, (List<?>) responseSearchOrderHint.itemid)) {
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
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.userid;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Long> list3 = this.itemid;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSearchOrderHint> {
        public ResponseHeader header;
        public List<Long> itemid;
        public List<Long> orderid;
        public List<Long> userid;

        public Builder() {
        }

        public Builder(ResponseSearchOrderHint responseSearchOrderHint) {
            super(responseSearchOrderHint);
            if (responseSearchOrderHint != null) {
                this.header = responseSearchOrderHint.header;
                this.orderid = ResponseSearchOrderHint.copyOf(responseSearchOrderHint.orderid);
                this.userid = ResponseSearchOrderHint.copyOf(responseSearchOrderHint.userid);
                this.itemid = ResponseSearchOrderHint.copyOf(responseSearchOrderHint.itemid);
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

        public Builder userid(List<Long> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public Builder itemid(List<Long> list) {
            this.itemid = checkForNulls(list);
            return this;
        }

        public ResponseSearchOrderHint build() {
            return new ResponseSearchOrderHint(this);
        }
    }
}
