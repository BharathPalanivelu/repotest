package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetReturnList extends Message {
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_RETURN_SUB_LIST_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer return_sub_list_type;

    public GetReturnList(String str, Boolean bool, Integer num, Integer num2, Integer num3) {
        this.requestid = str;
        this.is_seller = bool;
        this.offset = num;
        this.limit = num2;
        this.return_sub_list_type = num3;
    }

    private GetReturnList(Builder builder) {
        this(builder.requestid, builder.is_seller, builder.offset, builder.limit, builder.return_sub_list_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetReturnList)) {
            return false;
        }
        GetReturnList getReturnList = (GetReturnList) obj;
        if (!equals((Object) this.requestid, (Object) getReturnList.requestid) || !equals((Object) this.is_seller, (Object) getReturnList.is_seller) || !equals((Object) this.offset, (Object) getReturnList.offset) || !equals((Object) this.limit, (Object) getReturnList.limit) || !equals((Object) this.return_sub_list_type, (Object) getReturnList.return_sub_list_type)) {
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
        Boolean bool = this.is_seller;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.return_sub_list_type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetReturnList> {
        public Boolean is_seller;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public Integer return_sub_list_type;

        public Builder() {
        }

        public Builder(GetReturnList getReturnList) {
            super(getReturnList);
            if (getReturnList != null) {
                this.requestid = getReturnList.requestid;
                this.is_seller = getReturnList.is_seller;
                this.offset = getReturnList.offset;
                this.limit = getReturnList.limit;
                this.return_sub_list_type = getReturnList.return_sub_list_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
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

        public Builder return_sub_list_type(Integer num) {
            this.return_sub_list_type = num;
            return this;
        }

        public GetReturnList build() {
            return new GetReturnList(this);
        }
    }
}
