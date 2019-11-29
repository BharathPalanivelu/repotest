package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetRecUserList extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetRecUserList(String str, Integer num, String str2) {
        this.requestid = str;
        this.limit = num;
        this.country = str2;
    }

    private GetRecUserList(Builder builder) {
        this(builder.requestid, builder.limit, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetRecUserList)) {
            return false;
        }
        GetRecUserList getRecUserList = (GetRecUserList) obj;
        if (!equals((Object) this.requestid, (Object) getRecUserList.requestid) || !equals((Object) this.limit, (Object) getRecUserList.limit) || !equals((Object) this.country, (Object) getRecUserList.country)) {
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
        Integer num = this.limit;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetRecUserList> {
        public String country;
        public Integer limit;
        public String requestid;

        public Builder() {
        }

        public Builder(GetRecUserList getRecUserList) {
            super(getRecUserList);
            if (getRecUserList != null) {
                this.requestid = getRecUserList.requestid;
                this.limit = getRecUserList.limit;
                this.country = getRecUserList.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public GetRecUserList build() {
            return new GetRecUserList(this);
        }
    }
}
