package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetAddressTax extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final List<String> DEFAULT_TAX_ADDRESS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> tax_address;

    public GetAddressTax(String str, List<String> list) {
        this.requestid = str;
        this.tax_address = immutableCopyOf(list);
    }

    private GetAddressTax(Builder builder) {
        this(builder.requestid, builder.tax_address);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAddressTax)) {
            return false;
        }
        GetAddressTax getAddressTax = (GetAddressTax) obj;
        if (!equals((Object) this.requestid, (Object) getAddressTax.requestid) || !equals((List<?>) this.tax_address, (List<?>) getAddressTax.tax_address)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<String> list = this.tax_address;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetAddressTax> {
        public String requestid;
        public List<String> tax_address;

        public Builder() {
        }

        public Builder(GetAddressTax getAddressTax) {
            super(getAddressTax);
            if (getAddressTax != null) {
                this.requestid = getAddressTax.requestid;
                this.tax_address = GetAddressTax.copyOf(getAddressTax.tax_address);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder tax_address(List<String> list) {
            this.tax_address = checkForNulls(list);
            return this;
        }

        public GetAddressTax build() {
            return new GetAddressTax(this);
        }
    }
}
