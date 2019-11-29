package com.shopee.protocol.action;

import com.shopee.protocol.shop.Return;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseReturnList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Return> DEFAULT_RETURNS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Return.class, tag = 3)
    public final List<Return> returns;

    public ResponseReturnList(String str, Integer num, List<Return> list) {
        this.requestid = str;
        this.errcode = num;
        this.returns = immutableCopyOf(list);
    }

    private ResponseReturnList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.returns);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseReturnList)) {
            return false;
        }
        ResponseReturnList responseReturnList = (ResponseReturnList) obj;
        if (!equals((Object) this.requestid, (Object) responseReturnList.requestid) || !equals((Object) this.errcode, (Object) responseReturnList.errcode) || !equals((List<?>) this.returns, (List<?>) responseReturnList.returns)) {
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
        List<Return> list = this.returns;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseReturnList> {
        public Integer errcode;
        public String requestid;
        public List<Return> returns;

        public Builder() {
        }

        public Builder(ResponseReturnList responseReturnList) {
            super(responseReturnList);
            if (responseReturnList != null) {
                this.requestid = responseReturnList.requestid;
                this.errcode = responseReturnList.errcode;
                this.returns = ResponseReturnList.copyOf(responseReturnList.returns);
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

        public Builder returns(List<Return> list) {
            this.returns = checkForNulls(list);
            return this;
        }

        public ResponseReturnList build() {
            checkRequiredFields();
            return new ResponseReturnList(this);
        }
    }
}
