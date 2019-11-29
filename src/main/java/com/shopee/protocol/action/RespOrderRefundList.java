package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RespOrderRefundList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<OrderWithRefunds> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderWithRefunds.class, tag = 3)
    public final List<OrderWithRefunds> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public RespOrderRefundList(String str, Integer num, List<OrderWithRefunds> list) {
        this.requestid = str;
        this.errcode = num;
        this.items = immutableCopyOf(list);
    }

    private RespOrderRefundList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RespOrderRefundList)) {
            return false;
        }
        RespOrderRefundList respOrderRefundList = (RespOrderRefundList) obj;
        if (!equals((Object) this.requestid, (Object) respOrderRefundList.requestid) || !equals((Object) this.errcode, (Object) respOrderRefundList.errcode) || !equals((List<?>) this.items, (List<?>) respOrderRefundList.items)) {
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
        List<OrderWithRefunds> list = this.items;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<RespOrderRefundList> {
        public Integer errcode;
        public List<OrderWithRefunds> items;
        public String requestid;

        public Builder() {
        }

        public Builder(RespOrderRefundList respOrderRefundList) {
            super(respOrderRefundList);
            if (respOrderRefundList != null) {
                this.requestid = respOrderRefundList.requestid;
                this.errcode = respOrderRefundList.errcode;
                this.items = RespOrderRefundList.copyOf(respOrderRefundList.items);
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

        public Builder items(List<OrderWithRefunds> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public RespOrderRefundList build() {
            return new RespOrderRefundList(this);
        }
    }
}
