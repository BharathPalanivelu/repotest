package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class ResponseQuickReplyList extends Message {
    public static final List<String> DEFAULT_CONTENT = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Boolean DEFAULT_IS_ON = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_on;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseQuickReplyList(String str, Integer num, List<String> list, f fVar, Boolean bool) {
        this.requestid = str;
        this.errcode = num;
        this.content = immutableCopyOf(list);
        this.extinfo = fVar;
        this.is_on = bool;
    }

    private ResponseQuickReplyList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.content, builder.extinfo, builder.is_on);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseQuickReplyList)) {
            return false;
        }
        ResponseQuickReplyList responseQuickReplyList = (ResponseQuickReplyList) obj;
        if (!equals((Object) this.requestid, (Object) responseQuickReplyList.requestid) || !equals((Object) this.errcode, (Object) responseQuickReplyList.errcode) || !equals((List<?>) this.content, (List<?>) responseQuickReplyList.content) || !equals((Object) this.extinfo, (Object) responseQuickReplyList.extinfo) || !equals((Object) this.is_on, (Object) responseQuickReplyList.is_on)) {
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
        List<String> list = this.content;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        f fVar = this.extinfo;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Boolean bool = this.is_on;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseQuickReplyList> {
        public List<String> content;
        public Integer errcode;
        public f extinfo;
        public Boolean is_on;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseQuickReplyList responseQuickReplyList) {
            super(responseQuickReplyList);
            if (responseQuickReplyList != null) {
                this.requestid = responseQuickReplyList.requestid;
                this.errcode = responseQuickReplyList.errcode;
                this.content = ResponseQuickReplyList.copyOf(responseQuickReplyList.content);
                this.extinfo = responseQuickReplyList.extinfo;
                this.is_on = responseQuickReplyList.is_on;
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

        public Builder content(List<String> list) {
            this.content = checkForNulls(list);
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder is_on(Boolean bool) {
            this.is_on = bool;
            return this;
        }

        public ResponseQuickReplyList build() {
            checkRequiredFields();
            return new ResponseQuickReplyList(this);
        }
    }
}
