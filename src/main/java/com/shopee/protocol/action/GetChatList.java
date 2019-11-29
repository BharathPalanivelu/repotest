package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetChatList extends Message {
    public static final List<Long> DEFAULT_CHATID = Collections.emptyList();
    public static final Integer DEFAULT_LAST_TIMESTAMP = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> chatid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer last_timestamp;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetChatList(String str, Integer num, List<Long> list) {
        this.requestid = str;
        this.last_timestamp = num;
        this.chatid = immutableCopyOf(list);
    }

    private GetChatList(Builder builder) {
        this(builder.requestid, builder.last_timestamp, builder.chatid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetChatList)) {
            return false;
        }
        GetChatList getChatList = (GetChatList) obj;
        if (!equals((Object) this.requestid, (Object) getChatList.requestid) || !equals((Object) this.last_timestamp, (Object) getChatList.last_timestamp) || !equals((List<?>) this.chatid, (List<?>) getChatList.chatid)) {
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
        Integer num = this.last_timestamp;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Long> list = this.chatid;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetChatList> {
        public List<Long> chatid;
        public Integer last_timestamp;
        public String requestid;

        public Builder() {
        }

        public Builder(GetChatList getChatList) {
            super(getChatList);
            if (getChatList != null) {
                this.requestid = getChatList.requestid;
                this.last_timestamp = getChatList.last_timestamp;
                this.chatid = GetChatList.copyOf(getChatList.chatid);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder last_timestamp(Integer num) {
            this.last_timestamp = num;
            return this;
        }

        public Builder chatid(List<Long> list) {
            this.chatid = checkForNulls(list);
            return this;
        }

        public GetChatList build() {
            return new GetChatList(this);
        }
    }
}
