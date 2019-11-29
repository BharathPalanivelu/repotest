package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetShopCList extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public GetShopCList(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this.requestid = str;
        this.shopid = num;
        this.offset = num2;
        this.limit = num3;
        this.status = num4;
    }

    private GetShopCList(Builder builder) {
        this(builder.requestid, builder.shopid, builder.offset, builder.limit, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetShopCList)) {
            return false;
        }
        GetShopCList getShopCList = (GetShopCList) obj;
        if (!equals((Object) this.requestid, (Object) getShopCList.requestid) || !equals((Object) this.shopid, (Object) getShopCList.shopid) || !equals((Object) this.offset, (Object) getShopCList.offset) || !equals((Object) this.limit, (Object) getShopCList.limit) || !equals((Object) this.status, (Object) getShopCList.status)) {
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
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetShopCList> {
        public Integer limit;
        public Integer offset;
        public String requestid;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(GetShopCList getShopCList) {
            super(getShopCList);
            if (getShopCList != null) {
                this.requestid = getShopCList.requestid;
                this.shopid = getShopCList.shopid;
                this.offset = getShopCList.offset;
                this.limit = getShopCList.limit;
                this.status = getShopCList.status;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public GetShopCList build() {
            return new GetShopCList(this);
        }
    }
}
