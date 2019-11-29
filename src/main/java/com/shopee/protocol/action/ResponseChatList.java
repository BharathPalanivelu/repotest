package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseChatList extends Message {
    public static final List<Chat> DEFAULT_CHAT = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_NEXT_TIMESTAMP = 0;
    public static final Long DEFAULT_NEXT_TIMESTAMP_NANO = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Chat.class, tag = 3)
    public final List<Chat> chat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer next_timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long next_timestamp_nano;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseChatList(String str, Integer num, List<Chat> list, Integer num2, Long l) {
        this.requestid = str;
        this.errcode = num;
        this.chat = immutableCopyOf(list);
        this.next_timestamp = num2;
        this.next_timestamp_nano = l;
    }

    private ResponseChatList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.chat, builder.next_timestamp, builder.next_timestamp_nano);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseChatList)) {
            return false;
        }
        ResponseChatList responseChatList = (ResponseChatList) obj;
        if (!equals((Object) this.requestid, (Object) responseChatList.requestid) || !equals((Object) this.errcode, (Object) responseChatList.errcode) || !equals((List<?>) this.chat, (List<?>) responseChatList.chat) || !equals((Object) this.next_timestamp, (Object) responseChatList.next_timestamp) || !equals((Object) this.next_timestamp_nano, (Object) responseChatList.next_timestamp_nano)) {
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
        List<Chat> list = this.chat;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.next_timestamp;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.next_timestamp_nano;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseChatList> {
        public List<Chat> chat;
        public Integer errcode;
        public Integer next_timestamp;
        public Long next_timestamp_nano;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseChatList responseChatList) {
            super(responseChatList);
            if (responseChatList != null) {
                this.requestid = responseChatList.requestid;
                this.errcode = responseChatList.errcode;
                this.chat = ResponseChatList.copyOf(responseChatList.chat);
                this.next_timestamp = responseChatList.next_timestamp;
                this.next_timestamp_nano = responseChatList.next_timestamp_nano;
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

        public Builder chat(List<Chat> list) {
            this.chat = checkForNulls(list);
            return this;
        }

        public Builder next_timestamp(Integer num) {
            this.next_timestamp = num;
            return this;
        }

        public Builder next_timestamp_nano(Long l) {
            this.next_timestamp_nano = l;
            return this;
        }

        public ResponseChatList build() {
            checkRequiredFields();
            return new ResponseChatList(this);
        }
    }
}
