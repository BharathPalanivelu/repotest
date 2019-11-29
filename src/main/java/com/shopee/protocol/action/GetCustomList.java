package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCustomList extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCustomList(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.offset = num;
        this.limit = num2;
    }

    private GetCustomList(Builder builder) {
        this(builder.requestid, builder.offset, builder.limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCustomList)) {
            return false;
        }
        GetCustomList getCustomList = (GetCustomList) obj;
        if (!equals((Object) this.requestid, (Object) getCustomList.requestid) || !equals((Object) this.offset, (Object) getCustomList.offset) || !equals((Object) this.limit, (Object) getCustomList.limit)) {
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
        Integer num = this.offset;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCustomList> {
        public Integer limit;
        public Integer offset;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCustomList getCustomList) {
            super(getCustomList);
            if (getCustomList != null) {
                this.requestid = getCustomList.requestid;
                this.offset = getCustomList.offset;
                this.limit = getCustomList.limit;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public GetCustomList build() {
            return new GetCustomList(this);
        }
    }
}
