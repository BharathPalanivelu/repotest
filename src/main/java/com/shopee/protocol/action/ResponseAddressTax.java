package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseAddressTax extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Boolean> DEFAULT_IS_ADDRESS_TAXABLE = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.BOOL)
    public final List<Boolean> is_address_taxable;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseAddressTax(String str, List<Boolean> list, Integer num) {
        this.requestid = str;
        this.is_address_taxable = immutableCopyOf(list);
        this.errcode = num;
    }

    private ResponseAddressTax(Builder builder) {
        this(builder.requestid, builder.is_address_taxable, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAddressTax)) {
            return false;
        }
        ResponseAddressTax responseAddressTax = (ResponseAddressTax) obj;
        if (!equals((Object) this.requestid, (Object) responseAddressTax.requestid) || !equals((List<?>) this.is_address_taxable, (List<?>) responseAddressTax.is_address_taxable) || !equals((Object) this.errcode, (Object) responseAddressTax.errcode)) {
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
        List<Boolean> list = this.is_address_taxable;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseAddressTax> {
        public Integer errcode;
        public List<Boolean> is_address_taxable;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseAddressTax responseAddressTax) {
            super(responseAddressTax);
            if (responseAddressTax != null) {
                this.requestid = responseAddressTax.requestid;
                this.is_address_taxable = ResponseAddressTax.copyOf(responseAddressTax.is_address_taxable);
                this.errcode = responseAddressTax.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder is_address_taxable(List<Boolean> list) {
            this.is_address_taxable = checkForNulls(list);
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseAddressTax build() {
            return new ResponseAddressTax(this);
        }
    }
}
