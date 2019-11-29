package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerAddress;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseAddress extends Message {
    public static final List<BuyerAddress> DEFAULT_ADDRESS = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<TaxAddressInfo> DEFAULT_TAX_INFO = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = BuyerAddress.class, tag = 3)
    public final List<BuyerAddress> address;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = TaxAddressInfo.class, tag = 4)
    public final List<TaxAddressInfo> tax_info;

    public ResponseAddress(String str, Integer num, List<BuyerAddress> list, List<TaxAddressInfo> list2) {
        this.requestid = str;
        this.errcode = num;
        this.address = immutableCopyOf(list);
        this.tax_info = immutableCopyOf(list2);
    }

    private ResponseAddress(Builder builder) {
        this(builder.requestid, builder.errcode, builder.address, builder.tax_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAddress)) {
            return false;
        }
        ResponseAddress responseAddress = (ResponseAddress) obj;
        if (!equals((Object) this.requestid, (Object) responseAddress.requestid) || !equals((Object) this.errcode, (Object) responseAddress.errcode) || !equals((List<?>) this.address, (List<?>) responseAddress.address) || !equals((List<?>) this.tax_info, (List<?>) responseAddress.tax_info)) {
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
        List<BuyerAddress> list = this.address;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<TaxAddressInfo> list2 = this.tax_info;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode2 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseAddress> {
        public List<BuyerAddress> address;
        public Integer errcode;
        public String requestid;
        public List<TaxAddressInfo> tax_info;

        public Builder() {
        }

        public Builder(ResponseAddress responseAddress) {
            super(responseAddress);
            if (responseAddress != null) {
                this.requestid = responseAddress.requestid;
                this.errcode = responseAddress.errcode;
                this.address = ResponseAddress.copyOf(responseAddress.address);
                this.tax_info = ResponseAddress.copyOf(responseAddress.tax_info);
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

        public Builder address(List<BuyerAddress> list) {
            this.address = checkForNulls(list);
            return this;
        }

        public Builder tax_info(List<TaxAddressInfo> list) {
            this.tax_info = checkForNulls(list);
            return this;
        }

        public ResponseAddress build() {
            checkRequiredFields();
            return new ResponseAddress(this);
        }
    }
}
