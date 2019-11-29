package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetSellerDiscountItemList extends Message {
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetSellerDiscountItemList(String str, Long l, String str2) {
        this.requestid = str;
        this.promotionid = l;
        this.token = str2;
    }

    private GetSellerDiscountItemList(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSellerDiscountItemList)) {
            return false;
        }
        GetSellerDiscountItemList getSellerDiscountItemList = (GetSellerDiscountItemList) obj;
        if (!equals((Object) this.requestid, (Object) getSellerDiscountItemList.requestid) || !equals((Object) this.promotionid, (Object) getSellerDiscountItemList.promotionid) || !equals((Object) this.token, (Object) getSellerDiscountItemList.token)) {
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
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetSellerDiscountItemList> {
        public Long promotionid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetSellerDiscountItemList getSellerDiscountItemList) {
            super(getSellerDiscountItemList);
            if (getSellerDiscountItemList != null) {
                this.requestid = getSellerDiscountItemList.requestid;
                this.promotionid = getSellerDiscountItemList.promotionid;
                this.token = getSellerDiscountItemList.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetSellerDiscountItemList build() {
            return new GetSellerDiscountItemList(this);
        }
    }
}
