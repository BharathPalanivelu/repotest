package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchUser extends Message {
    public static final String DEFAULT_JSON_DATA = "";
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    public static final List<Integer> DEFAULT_USERIDS = Collections.emptyList();
    public static final List<ResultUser> DEFAULT_USERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total_count;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> userids;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultUser.class, tag = 4)
    public final List<ResultUser> users;

    public ResponseSearchUser(ResponseHeader responseHeader, List<Integer> list, Integer num, List<ResultUser> list2, String str) {
        this.header = responseHeader;
        this.userids = immutableCopyOf(list);
        this.total_count = num;
        this.users = immutableCopyOf(list2);
        this.json_data = str;
    }

    private ResponseSearchUser(Builder builder) {
        this(builder.header, builder.userids, builder.total_count, builder.users, builder.json_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchUser)) {
            return false;
        }
        ResponseSearchUser responseSearchUser = (ResponseSearchUser) obj;
        if (!equals((Object) this.header, (Object) responseSearchUser.header) || !equals((List<?>) this.userids, (List<?>) responseSearchUser.userids) || !equals((Object) this.total_count, (Object) responseSearchUser.total_count) || !equals((List<?>) this.users, (List<?>) responseSearchUser.users) || !equals((Object) this.json_data, (Object) responseSearchUser.json_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<Integer> list = this.userids;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.total_count;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        List<ResultUser> list2 = this.users;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        String str = this.json_data;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseSearchUser> {
        public ResponseHeader header;
        public String json_data;
        public Integer total_count;
        public List<Integer> userids;
        public List<ResultUser> users;

        public Builder() {
        }

        public Builder(ResponseSearchUser responseSearchUser) {
            super(responseSearchUser);
            if (responseSearchUser != null) {
                this.header = responseSearchUser.header;
                this.userids = ResponseSearchUser.copyOf(responseSearchUser.userids);
                this.total_count = responseSearchUser.total_count;
                this.users = ResponseSearchUser.copyOf(responseSearchUser.users);
                this.json_data = responseSearchUser.json_data;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder userids(List<Integer> list) {
            this.userids = checkForNulls(list);
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder users(List<ResultUser> list) {
            this.users = checkForNulls(list);
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public ResponseSearchUser build() {
            return new ResponseSearchUser(this);
        }
    }
}
