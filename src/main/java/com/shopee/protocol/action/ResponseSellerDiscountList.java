package com.shopee.protocol.action;

import com.shopee.protocol.shop.SellerDiscount;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSellerDiscountList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<SellerDiscount> DEFAULT_SELLER_DISCOUNT = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = SellerDiscount.class, tag = 3)
    public final List<SellerDiscount> seller_discount;

    public ResponseSellerDiscountList(String str, Integer num, List<SellerDiscount> list) {
        this.requestid = str;
        this.errcode = num;
        this.seller_discount = immutableCopyOf(list);
    }

    private ResponseSellerDiscountList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.seller_discount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSellerDiscountList)) {
            return false;
        }
        ResponseSellerDiscountList responseSellerDiscountList = (ResponseSellerDiscountList) obj;
        if (!equals((Object) this.requestid, (Object) responseSellerDiscountList.requestid) || !equals((Object) this.errcode, (Object) responseSellerDiscountList.errcode) || !equals((List<?>) this.seller_discount, (List<?>) responseSellerDiscountList.seller_discount)) {
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
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<SellerDiscount> list = this.seller_discount;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSellerDiscountList> {
        public Integer errcode;
        public String requestid;
        public List<SellerDiscount> seller_discount;

        public Builder() {
        }

        public Builder(ResponseSellerDiscountList responseSellerDiscountList) {
            super(responseSellerDiscountList);
            if (responseSellerDiscountList != null) {
                this.requestid = responseSellerDiscountList.requestid;
                this.errcode = responseSellerDiscountList.errcode;
                this.seller_discount = ResponseSellerDiscountList.copyOf(responseSellerDiscountList.seller_discount);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder seller_discount(List<SellerDiscount> list) {
            this.seller_discount = checkForNulls(list);
            return this;
        }

        public ResponseSellerDiscountList build() {
            return new ResponseSellerDiscountList(this);
        }
    }
}
