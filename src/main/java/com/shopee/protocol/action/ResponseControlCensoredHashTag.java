package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseControlCensoredHashTag extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<String> DEFAULT_HASHTAG_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> hashtag_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseControlCensoredHashTag(String str, Integer num, List<String> list) {
        this.requestid = str;
        this.errcode = num;
        this.hashtag_list = immutableCopyOf(list);
    }

    private ResponseControlCensoredHashTag(Builder builder) {
        this(builder.requestid, builder.errcode, builder.hashtag_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseControlCensoredHashTag)) {
            return false;
        }
        ResponseControlCensoredHashTag responseControlCensoredHashTag = (ResponseControlCensoredHashTag) obj;
        if (!equals((Object) this.requestid, (Object) responseControlCensoredHashTag.requestid) || !equals((Object) this.errcode, (Object) responseControlCensoredHashTag.errcode) || !equals((List<?>) this.hashtag_list, (List<?>) responseControlCensoredHashTag.hashtag_list)) {
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
        List<String> list = this.hashtag_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseControlCensoredHashTag> {
        public Integer errcode;
        public List<String> hashtag_list;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseControlCensoredHashTag responseControlCensoredHashTag) {
            super(responseControlCensoredHashTag);
            if (responseControlCensoredHashTag != null) {
                this.requestid = responseControlCensoredHashTag.requestid;
                this.errcode = responseControlCensoredHashTag.errcode;
                this.hashtag_list = ResponseControlCensoredHashTag.copyOf(responseControlCensoredHashTag.hashtag_list);
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

        public Builder hashtag_list(List<String> list) {
            this.hashtag_list = checkForNulls(list);
            return this;
        }

        public ResponseControlCensoredHashTag build() {
            checkRequiredFields();
            return new ResponseControlCensoredHashTag(this);
        }
    }
}
