package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseOrdersnHint extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<OrdersnHint> DEFAULT_HINT = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrdersnHint.class, tag = 3)
    public final List<OrdersnHint> hint;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseOrdersnHint(String str, Integer num, List<OrdersnHint> list) {
        this.requestid = str;
        this.errcode = num;
        this.hint = immutableCopyOf(list);
    }

    private ResponseOrdersnHint(Builder builder) {
        this(builder.requestid, builder.errcode, builder.hint);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseOrdersnHint)) {
            return false;
        }
        ResponseOrdersnHint responseOrdersnHint = (ResponseOrdersnHint) obj;
        if (!equals((Object) this.requestid, (Object) responseOrdersnHint.requestid) || !equals((Object) this.errcode, (Object) responseOrdersnHint.errcode) || !equals((List<?>) this.hint, (List<?>) responseOrdersnHint.hint)) {
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
        List<OrdersnHint> list = this.hint;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseOrdersnHint> {
        public Integer errcode;
        public List<OrdersnHint> hint;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseOrdersnHint responseOrdersnHint) {
            super(responseOrdersnHint);
            if (responseOrdersnHint != null) {
                this.requestid = responseOrdersnHint.requestid;
                this.errcode = responseOrdersnHint.errcode;
                this.hint = ResponseOrdersnHint.copyOf(responseOrdersnHint.hint);
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

        public Builder hint(List<OrdersnHint> list) {
            this.hint = checkForNulls(list);
            return this;
        }

        public ResponseOrdersnHint build() {
            checkRequiredFields();
            return new ResponseOrdersnHint(this);
        }
    }
}
