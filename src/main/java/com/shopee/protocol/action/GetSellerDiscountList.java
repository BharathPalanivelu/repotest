package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetSellerDiscountList extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetSellerDiscountList(String str, Integer num, String str2) {
        this.requestid = str;
        this.shopid = num;
        this.token = str2;
    }

    private GetSellerDiscountList(Builder builder) {
        this(builder.requestid, builder.shopid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSellerDiscountList)) {
            return false;
        }
        GetSellerDiscountList getSellerDiscountList = (GetSellerDiscountList) obj;
        if (!equals((Object) this.requestid, (Object) getSellerDiscountList.requestid) || !equals((Object) this.shopid, (Object) getSellerDiscountList.shopid) || !equals((Object) this.token, (Object) getSellerDiscountList.token)) {
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
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetSellerDiscountList> {
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(GetSellerDiscountList getSellerDiscountList) {
            super(getSellerDiscountList);
            if (getSellerDiscountList != null) {
                this.requestid = getSellerDiscountList.requestid;
                this.shopid = getSellerDiscountList.shopid;
                this.token = getSellerDiscountList.token;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetSellerDiscountList build() {
            return new GetSellerDiscountList(this);
        }
    }
}
