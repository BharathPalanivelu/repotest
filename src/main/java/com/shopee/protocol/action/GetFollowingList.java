package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetFollowingList extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetFollowingList(String str, Integer num, Integer num2, Integer num3, String str2) {
        this.requestid = str;
        this.userid = num;
        this.offset = num2;
        this.limit = num3;
        this.token = str2;
    }

    private GetFollowingList(Builder builder) {
        this(builder.requestid, builder.userid, builder.offset, builder.limit, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetFollowingList)) {
            return false;
        }
        GetFollowingList getFollowingList = (GetFollowingList) obj;
        if (!equals((Object) this.requestid, (Object) getFollowingList.requestid) || !equals((Object) this.userid, (Object) getFollowingList.userid) || !equals((Object) this.offset, (Object) getFollowingList.offset) || !equals((Object) this.limit, (Object) getFollowingList.limit) || !equals((Object) this.token, (Object) getFollowingList.token)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetFollowingList> {
        public Integer limit;
        public Integer offset;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetFollowingList getFollowingList) {
            super(getFollowingList);
            if (getFollowingList != null) {
                this.requestid = getFollowingList.requestid;
                this.userid = getFollowingList.userid;
                this.offset = getFollowingList.offset;
                this.limit = getFollowingList.limit;
                this.token = getFollowingList.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetFollowingList build() {
            return new GetFollowingList(this);
        }
    }
}
