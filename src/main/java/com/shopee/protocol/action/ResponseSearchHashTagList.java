package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchHashTagList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<HashTagSearchInfo> DEFAULT_ITEM = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = HashTagSearchInfo.class, tag = 3)
    public final List<HashTagSearchInfo> item;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSearchHashTagList(String str, Integer num, List<HashTagSearchInfo> list) {
        this.requestid = str;
        this.errcode = num;
        this.item = immutableCopyOf(list);
    }

    private ResponseSearchHashTagList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.item);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchHashTagList)) {
            return false;
        }
        ResponseSearchHashTagList responseSearchHashTagList = (ResponseSearchHashTagList) obj;
        if (!equals((Object) this.requestid, (Object) responseSearchHashTagList.requestid) || !equals((Object) this.errcode, (Object) responseSearchHashTagList.errcode) || !equals((List<?>) this.item, (List<?>) responseSearchHashTagList.item)) {
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
        List<HashTagSearchInfo> list = this.item;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSearchHashTagList> {
        public Integer errcode;
        public List<HashTagSearchInfo> item;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSearchHashTagList responseSearchHashTagList) {
            super(responseSearchHashTagList);
            if (responseSearchHashTagList != null) {
                this.requestid = responseSearchHashTagList.requestid;
                this.errcode = responseSearchHashTagList.errcode;
                this.item = ResponseSearchHashTagList.copyOf(responseSearchHashTagList.item);
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

        public Builder item(List<HashTagSearchInfo> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public ResponseSearchHashTagList build() {
            checkRequiredFields();
            return new ResponseSearchHashTagList(this);
        }
    }
}
