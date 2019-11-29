package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetLikedList extends Message {
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
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetLikedList(String str, String str2, Integer num, Integer num2, Integer num3) {
        this.requestid = str;
        this.token = str2;
        this.offset = num;
        this.limit = num2;
        this.userid = num3;
    }

    private GetLikedList(Builder builder) {
        this(builder.requestid, builder.token, builder.offset, builder.limit, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetLikedList)) {
            return false;
        }
        GetLikedList getLikedList = (GetLikedList) obj;
        if (!equals((Object) this.requestid, (Object) getLikedList.requestid) || !equals((Object) this.token, (Object) getLikedList.token) || !equals((Object) this.offset, (Object) getLikedList.offset) || !equals((Object) this.limit, (Object) getLikedList.limit) || !equals((Object) this.userid, (Object) getLikedList.userid)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetLikedList> {
        public Integer limit;
        public Integer offset;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetLikedList getLikedList) {
            super(getLikedList);
            if (getLikedList != null) {
                this.requestid = getLikedList.requestid;
                this.token = getLikedList.token;
                this.offset = getLikedList.offset;
                this.limit = getLikedList.limit;
                this.userid = getLikedList.userid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public GetLikedList build() {
            return new GetLikedList(this);
        }
    }
}
