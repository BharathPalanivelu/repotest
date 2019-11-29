package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseUserBriefList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TOTAL = 0;
    public static final List<UserBrief> DEFAULT_USER = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserBrief.class, tag = 3)
    public final List<UserBrief> user;

    public ResponseUserBriefList(String str, Integer num, List<UserBrief> list, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.user = immutableCopyOf(list);
        this.total = num2;
    }

    private ResponseUserBriefList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.user, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUserBriefList)) {
            return false;
        }
        ResponseUserBriefList responseUserBriefList = (ResponseUserBriefList) obj;
        if (!equals((Object) this.requestid, (Object) responseUserBriefList.requestid) || !equals((Object) this.errcode, (Object) responseUserBriefList.errcode) || !equals((List<?>) this.user, (List<?>) responseUserBriefList.user) || !equals((Object) this.total, (Object) responseUserBriefList.total)) {
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
        List<UserBrief> list = this.user;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseUserBriefList> {
        public Integer errcode;
        public String requestid;
        public Integer total;
        public List<UserBrief> user;

        public Builder() {
        }

        public Builder(ResponseUserBriefList responseUserBriefList) {
            super(responseUserBriefList);
            if (responseUserBriefList != null) {
                this.requestid = responseUserBriefList.requestid;
                this.errcode = responseUserBriefList.errcode;
                this.user = ResponseUserBriefList.copyOf(responseUserBriefList.user);
                this.total = responseUserBriefList.total;
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

        public Builder user(List<UserBrief> list) {
            this.user = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public ResponseUserBriefList build() {
            checkRequiredFields();
            return new ResponseUserBriefList(this);
        }
    }
}
