package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetFollowerList extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public GetFollowerList(String str, Integer num, Integer num2, Integer num3) {
        this.requestid = str;
        this.shopid = num;
        this.offset = num2;
        this.limit = num3;
    }

    private GetFollowerList(Builder builder) {
        this(builder.requestid, builder.shopid, builder.offset, builder.limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetFollowerList)) {
            return false;
        }
        GetFollowerList getFollowerList = (GetFollowerList) obj;
        if (!equals((Object) this.requestid, (Object) getFollowerList.requestid) || !equals((Object) this.shopid, (Object) getFollowerList.shopid) || !equals((Object) this.offset, (Object) getFollowerList.offset) || !equals((Object) this.limit, (Object) getFollowerList.limit)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetFollowerList> {
        public Integer limit;
        public Integer offset;
        public String requestid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(GetFollowerList getFollowerList) {
            super(getFollowerList);
            if (getFollowerList != null) {
                this.requestid = getFollowerList.requestid;
                this.shopid = getFollowerList.shopid;
                this.offset = getFollowerList.offset;
                this.limit = getFollowerList.limit;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public GetFollowerList build() {
            return new GetFollowerList(this);
        }
    }
}
