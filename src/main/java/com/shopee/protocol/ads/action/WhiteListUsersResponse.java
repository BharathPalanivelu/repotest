package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class WhiteListUsersResponse extends Message {
    public static final List<ResponseCommon> DEFAULT_RESPONSES = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL = 0;
    public static final List<WhitelistUserModel> DEFAULT_WHITELISTUSERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResponseCommon.class, tag = 3)
    public final List<ResponseCommon> responses;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total;
    @ProtoField(label = Message.Label.REPEATED, messageType = WhitelistUserModel.class, tag = 2)
    public final List<WhitelistUserModel> whiteListUsers;

    public WhiteListUsersResponse(ResponseHeader responseHeader, List<WhitelistUserModel> list, List<ResponseCommon> list2, Integer num) {
        this.header = responseHeader;
        this.whiteListUsers = immutableCopyOf(list);
        this.responses = immutableCopyOf(list2);
        this.total = num;
    }

    private WhiteListUsersResponse(Builder builder) {
        this(builder.header, builder.whiteListUsers, builder.responses, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WhiteListUsersResponse)) {
            return false;
        }
        WhiteListUsersResponse whiteListUsersResponse = (WhiteListUsersResponse) obj;
        if (!equals((Object) this.header, (Object) whiteListUsersResponse.header) || !equals((List<?>) this.whiteListUsers, (List<?>) whiteListUsersResponse.whiteListUsers) || !equals((List<?>) this.responses, (List<?>) whiteListUsersResponse.responses) || !equals((Object) this.total, (Object) whiteListUsersResponse.total)) {
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
        List<WhitelistUserModel> list = this.whiteListUsers;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<ResponseCommon> list2 = this.responses;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 37;
        Integer num = this.total;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<WhiteListUsersResponse> {
        public ResponseHeader header;
        public List<ResponseCommon> responses;
        public Integer total;
        public List<WhitelistUserModel> whiteListUsers;

        public Builder() {
        }

        public Builder(WhiteListUsersResponse whiteListUsersResponse) {
            super(whiteListUsersResponse);
            if (whiteListUsersResponse != null) {
                this.header = whiteListUsersResponse.header;
                this.whiteListUsers = WhiteListUsersResponse.copyOf(whiteListUsersResponse.whiteListUsers);
                this.responses = WhiteListUsersResponse.copyOf(whiteListUsersResponse.responses);
                this.total = whiteListUsersResponse.total;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder whiteListUsers(List<WhitelistUserModel> list) {
            this.whiteListUsers = checkForNulls(list);
            return this;
        }

        public Builder responses(List<ResponseCommon> list) {
            this.responses = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public WhiteListUsersResponse build() {
            return new WhiteListUsersResponse(this);
        }
    }
}
