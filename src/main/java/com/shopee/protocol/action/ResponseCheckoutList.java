package com.shopee.protocol.action;

import com.shopee.protocol.shop.Checkout;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCheckoutList extends Message {
    public static final List<Checkout> DEFAULT_CHECKOUT = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Checkout.class, tag = 3)
    public final List<Checkout> checkout;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCheckoutList(String str, Integer num, List<Checkout> list) {
        this.requestid = str;
        this.errcode = num;
        this.checkout = immutableCopyOf(list);
    }

    private ResponseCheckoutList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.checkout);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCheckoutList)) {
            return false;
        }
        ResponseCheckoutList responseCheckoutList = (ResponseCheckoutList) obj;
        if (!equals((Object) this.requestid, (Object) responseCheckoutList.requestid) || !equals((Object) this.errcode, (Object) responseCheckoutList.errcode) || !equals((List<?>) this.checkout, (List<?>) responseCheckoutList.checkout)) {
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
        List<Checkout> list = this.checkout;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseCheckoutList> {
        public List<Checkout> checkout;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCheckoutList responseCheckoutList) {
            super(responseCheckoutList);
            if (responseCheckoutList != null) {
                this.requestid = responseCheckoutList.requestid;
                this.errcode = responseCheckoutList.errcode;
                this.checkout = ResponseCheckoutList.copyOf(responseCheckoutList.checkout);
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

        public Builder checkout(List<Checkout> list) {
            this.checkout = checkForNulls(list);
            return this;
        }

        public ResponseCheckoutList build() {
            checkRequiredFields();
            return new ResponseCheckoutList(this);
        }
    }
}
