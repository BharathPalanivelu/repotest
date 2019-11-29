package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetBuyerCmtList extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_HIDDEN = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean need_hidden;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetBuyerCmtList(String str, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool) {
        this.requestid = str;
        this.userid = num;
        this.offset = num2;
        this.limit = num3;
        this.type = num4;
        this.need_hidden = bool;
    }

    private GetBuyerCmtList(Builder builder) {
        this(builder.requestid, builder.userid, builder.offset, builder.limit, builder.type, builder.need_hidden);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetBuyerCmtList)) {
            return false;
        }
        GetBuyerCmtList getBuyerCmtList = (GetBuyerCmtList) obj;
        if (!equals((Object) this.requestid, (Object) getBuyerCmtList.requestid) || !equals((Object) this.userid, (Object) getBuyerCmtList.userid) || !equals((Object) this.offset, (Object) getBuyerCmtList.offset) || !equals((Object) this.limit, (Object) getBuyerCmtList.limit) || !equals((Object) this.type, (Object) getBuyerCmtList.type) || !equals((Object) this.need_hidden, (Object) getBuyerCmtList.need_hidden)) {
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
        Integer num4 = this.type;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.need_hidden;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetBuyerCmtList> {
        public Integer limit;
        public Boolean need_hidden;
        public Integer offset;
        public String requestid;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetBuyerCmtList getBuyerCmtList) {
            super(getBuyerCmtList);
            if (getBuyerCmtList != null) {
                this.requestid = getBuyerCmtList.requestid;
                this.userid = getBuyerCmtList.userid;
                this.offset = getBuyerCmtList.offset;
                this.limit = getBuyerCmtList.limit;
                this.type = getBuyerCmtList.type;
                this.need_hidden = getBuyerCmtList.need_hidden;
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

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder need_hidden(Boolean bool) {
            this.need_hidden = bool;
            return this;
        }

        public GetBuyerCmtList build() {
            return new GetBuyerCmtList(this);
        }
    }
}
