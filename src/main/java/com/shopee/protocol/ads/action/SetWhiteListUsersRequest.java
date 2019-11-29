package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetWhiteListUsersRequest extends Message {
    public static final List<WhitelistUserModel> DEFAULT_WHITELISTUSERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final Header header;
    @ProtoField(label = Message.Label.REPEATED, messageType = WhitelistUserModel.class, tag = 1)
    public final List<WhitelistUserModel> whiteListUsers;

    public SetWhiteListUsersRequest(List<WhitelistUserModel> list, Header header2) {
        this.whiteListUsers = immutableCopyOf(list);
        this.header = header2;
    }

    private SetWhiteListUsersRequest(Builder builder) {
        this(builder.whiteListUsers, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetWhiteListUsersRequest)) {
            return false;
        }
        SetWhiteListUsersRequest setWhiteListUsersRequest = (SetWhiteListUsersRequest) obj;
        if (!equals((List<?>) this.whiteListUsers, (List<?>) setWhiteListUsersRequest.whiteListUsers) || !equals((Object) this.header, (Object) setWhiteListUsersRequest.header)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<WhitelistUserModel> list = this.whiteListUsers;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Header header2 = this.header;
        int hashCode2 = hashCode + (header2 != null ? header2.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetWhiteListUsersRequest> {
        public Header header;
        public List<WhitelistUserModel> whiteListUsers;

        public Builder() {
        }

        public Builder(SetWhiteListUsersRequest setWhiteListUsersRequest) {
            super(setWhiteListUsersRequest);
            if (setWhiteListUsersRequest != null) {
                this.whiteListUsers = SetWhiteListUsersRequest.copyOf(setWhiteListUsersRequest.whiteListUsers);
                this.header = setWhiteListUsersRequest.header;
            }
        }

        public Builder whiteListUsers(List<WhitelistUserModel> list) {
            this.whiteListUsers = checkForNulls(list);
            return this;
        }

        public Builder header(Header header2) {
            this.header = header2;
            return this;
        }

        public SetWhiteListUsersRequest build() {
            return new SetWhiteListUsersRequest(this);
        }
    }
}
