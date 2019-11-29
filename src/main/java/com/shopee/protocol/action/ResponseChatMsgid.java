package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseChatMsgid extends Message {
    public static final Long DEFAULT_CHATID = 0L;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Long> DEFAULT_MSGID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> msgid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public ResponseChatMsgid(String str, Integer num, List<Long> list, Long l, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.msgid = immutableCopyOf(list);
        this.chatid = l;
        this.userid = num2;
    }

    private ResponseChatMsgid(Builder builder) {
        this(builder.requestid, builder.errcode, builder.msgid, builder.chatid, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseChatMsgid)) {
            return false;
        }
        ResponseChatMsgid responseChatMsgid = (ResponseChatMsgid) obj;
        if (!equals((Object) this.requestid, (Object) responseChatMsgid.requestid) || !equals((Object) this.errcode, (Object) responseChatMsgid.errcode) || !equals((List<?>) this.msgid, (List<?>) responseChatMsgid.msgid) || !equals((Object) this.chatid, (Object) responseChatMsgid.chatid) || !equals((Object) this.userid, (Object) responseChatMsgid.userid)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<Long> list = this.msgid;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.chatid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseChatMsgid> {
        public Long chatid;
        public Integer errcode;
        public List<Long> msgid;
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(ResponseChatMsgid responseChatMsgid) {
            super(responseChatMsgid);
            if (responseChatMsgid != null) {
                this.requestid = responseChatMsgid.requestid;
                this.errcode = responseChatMsgid.errcode;
                this.msgid = ResponseChatMsgid.copyOf(responseChatMsgid.msgid);
                this.chatid = responseChatMsgid.chatid;
                this.userid = responseChatMsgid.userid;
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

        public Builder msgid(List<Long> list) {
            this.msgid = checkForNulls(list);
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public ResponseChatMsgid build() {
            checkRequiredFields();
            return new ResponseChatMsgid(this);
        }
    }
}
