package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetWhiteListUsersRequest extends Message {
    public static final List<Long> DEFAULT_IDS = Collections.emptyList();
    public static final List<Integer> DEFAULT_STATUSES = Collections.emptyList();
    public static final List<Integer> DEFAULT_TYPES = Collections.emptyList();
    public static final List<Long> DEFAULT_USERIDS = Collections.emptyList();
    public static final List<String> DEFAULT_USERNAMES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Header header;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> ids;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> statuses;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> types;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> userids;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.STRING)
    public final List<String> usernames;

    public GetWhiteListUsersRequest(Header header2, List<Long> list, List<Long> list2, List<String> list3, List<Integer> list4, List<Integer> list5) {
        this.header = header2;
        this.ids = immutableCopyOf(list);
        this.userids = immutableCopyOf(list2);
        this.usernames = immutableCopyOf(list3);
        this.types = immutableCopyOf(list4);
        this.statuses = immutableCopyOf(list5);
    }

    private GetWhiteListUsersRequest(Builder builder) {
        this(builder.header, builder.ids, builder.userids, builder.usernames, builder.types, builder.statuses);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetWhiteListUsersRequest)) {
            return false;
        }
        GetWhiteListUsersRequest getWhiteListUsersRequest = (GetWhiteListUsersRequest) obj;
        if (!equals((Object) this.header, (Object) getWhiteListUsersRequest.header) || !equals((List<?>) this.ids, (List<?>) getWhiteListUsersRequest.ids) || !equals((List<?>) this.userids, (List<?>) getWhiteListUsersRequest.userids) || !equals((List<?>) this.usernames, (List<?>) getWhiteListUsersRequest.usernames) || !equals((List<?>) this.types, (List<?>) getWhiteListUsersRequest.types) || !equals((List<?>) this.statuses, (List<?>) getWhiteListUsersRequest.statuses)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Header header2 = this.header;
        int hashCode = (header2 != null ? header2.hashCode() : 0) * 37;
        List<Long> list = this.ids;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.userids;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<String> list3 = this.usernames;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Integer> list4 = this.types;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<Integer> list5 = this.statuses;
        if (list5 != null) {
            i2 = list5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetWhiteListUsersRequest> {
        public Header header;
        public List<Long> ids;
        public List<Integer> statuses;
        public List<Integer> types;
        public List<Long> userids;
        public List<String> usernames;

        public Builder() {
        }

        public Builder(GetWhiteListUsersRequest getWhiteListUsersRequest) {
            super(getWhiteListUsersRequest);
            if (getWhiteListUsersRequest != null) {
                this.header = getWhiteListUsersRequest.header;
                this.ids = GetWhiteListUsersRequest.copyOf(getWhiteListUsersRequest.ids);
                this.userids = GetWhiteListUsersRequest.copyOf(getWhiteListUsersRequest.userids);
                this.usernames = GetWhiteListUsersRequest.copyOf(getWhiteListUsersRequest.usernames);
                this.types = GetWhiteListUsersRequest.copyOf(getWhiteListUsersRequest.types);
                this.statuses = GetWhiteListUsersRequest.copyOf(getWhiteListUsersRequest.statuses);
            }
        }

        public Builder header(Header header2) {
            this.header = header2;
            return this;
        }

        public Builder ids(List<Long> list) {
            this.ids = checkForNulls(list);
            return this;
        }

        public Builder userids(List<Long> list) {
            this.userids = checkForNulls(list);
            return this;
        }

        public Builder usernames(List<String> list) {
            this.usernames = checkForNulls(list);
            return this;
        }

        public Builder types(List<Integer> list) {
            this.types = checkForNulls(list);
            return this;
        }

        public Builder statuses(List<Integer> list) {
            this.statuses = checkForNulls(list);
            return this;
        }

        public GetWhiteListUsersRequest build() {
            return new GetWhiteListUsersRequest(this);
        }
    }
}
