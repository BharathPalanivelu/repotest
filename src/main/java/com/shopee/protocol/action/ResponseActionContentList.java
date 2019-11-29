package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseActionContentList extends Message {
    public static final List<ActionContent> DEFAULT_ACTION_CONTENT_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ActionContent.class, tag = 3)
    public final List<ActionContent> action_content_list;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseActionContentList(String str, Integer num, List<ActionContent> list) {
        this.requestid = str;
        this.errcode = num;
        this.action_content_list = immutableCopyOf(list);
    }

    private ResponseActionContentList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.action_content_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseActionContentList)) {
            return false;
        }
        ResponseActionContentList responseActionContentList = (ResponseActionContentList) obj;
        if (!equals((Object) this.requestid, (Object) responseActionContentList.requestid) || !equals((Object) this.errcode, (Object) responseActionContentList.errcode) || !equals((List<?>) this.action_content_list, (List<?>) responseActionContentList.action_content_list)) {
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
        List<ActionContent> list = this.action_content_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseActionContentList> {
        public List<ActionContent> action_content_list;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseActionContentList responseActionContentList) {
            super(responseActionContentList);
            if (responseActionContentList != null) {
                this.requestid = responseActionContentList.requestid;
                this.errcode = responseActionContentList.errcode;
                this.action_content_list = ResponseActionContentList.copyOf(responseActionContentList.action_content_list);
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

        public Builder action_content_list(List<ActionContent> list) {
            this.action_content_list = checkForNulls(list);
            return this;
        }

        public ResponseActionContentList build() {
            checkRequiredFields();
            return new ResponseActionContentList(this);
        }
    }
}
