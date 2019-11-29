package com.shopee.protocol.action;

import com.shopee.protocol.shop.SimpleAction;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseActionIdList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<SimpleAction> DEFAULT_SIMPLE_ACTION_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = SimpleAction.class, tag = 3)
    public final List<SimpleAction> simple_action_list;

    public ResponseActionIdList(String str, Integer num, List<SimpleAction> list) {
        this.requestid = str;
        this.errcode = num;
        this.simple_action_list = immutableCopyOf(list);
    }

    private ResponseActionIdList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.simple_action_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseActionIdList)) {
            return false;
        }
        ResponseActionIdList responseActionIdList = (ResponseActionIdList) obj;
        if (!equals((Object) this.requestid, (Object) responseActionIdList.requestid) || !equals((Object) this.errcode, (Object) responseActionIdList.errcode) || !equals((List<?>) this.simple_action_list, (List<?>) responseActionIdList.simple_action_list)) {
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
        List<SimpleAction> list = this.simple_action_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseActionIdList> {
        public Integer errcode;
        public String requestid;
        public List<SimpleAction> simple_action_list;

        public Builder() {
        }

        public Builder(ResponseActionIdList responseActionIdList) {
            super(responseActionIdList);
            if (responseActionIdList != null) {
                this.requestid = responseActionIdList.requestid;
                this.errcode = responseActionIdList.errcode;
                this.simple_action_list = ResponseActionIdList.copyOf(responseActionIdList.simple_action_list);
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

        public Builder simple_action_list(List<SimpleAction> list) {
            this.simple_action_list = checkForNulls(list);
            return this;
        }

        public ResponseActionIdList build() {
            checkRequiredFields();
            return new ResponseActionIdList(this);
        }
    }
}
