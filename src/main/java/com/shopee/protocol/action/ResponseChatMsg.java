package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseChatMsg extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ChatMsg> DEFAULT_MSG = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ChatMsg.class, tag = 3)
    public final List<ChatMsg> msg;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseChatMsg(String str, Integer num, List<ChatMsg> list) {
        this.requestid = str;
        this.errcode = num;
        this.msg = immutableCopyOf(list);
    }

    private ResponseChatMsg(Builder builder) {
        this(builder.requestid, builder.errcode, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseChatMsg)) {
            return false;
        }
        ResponseChatMsg responseChatMsg = (ResponseChatMsg) obj;
        if (!equals((Object) this.requestid, (Object) responseChatMsg.requestid) || !equals((Object) this.errcode, (Object) responseChatMsg.errcode) || !equals((List<?>) this.msg, (List<?>) responseChatMsg.msg)) {
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
        List<ChatMsg> list = this.msg;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseChatMsg> {
        public Integer errcode;
        public List<ChatMsg> msg;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseChatMsg responseChatMsg) {
            super(responseChatMsg);
            if (responseChatMsg != null) {
                this.requestid = responseChatMsg.requestid;
                this.errcode = responseChatMsg.errcode;
                this.msg = ResponseChatMsg.copyOf(responseChatMsg.msg);
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

        public Builder msg(List<ChatMsg> list) {
            this.msg = checkForNulls(list);
            return this;
        }

        public ResponseChatMsg build() {
            checkRequiredFields();
            return new ResponseChatMsg(this);
        }
    }
}
