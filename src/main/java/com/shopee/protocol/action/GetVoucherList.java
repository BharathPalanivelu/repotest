package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetVoucherList extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public GetVoucherList(String str, Integer num) {
        this.requestid = str;
        this.shopid = num;
    }

    private GetVoucherList(Builder builder) {
        this(builder.requestid, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetVoucherList)) {
            return false;
        }
        GetVoucherList getVoucherList = (GetVoucherList) obj;
        if (!equals((Object) this.requestid, (Object) getVoucherList.requestid) || !equals((Object) this.shopid, (Object) getVoucherList.shopid)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetVoucherList> {
        public String requestid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(GetVoucherList getVoucherList) {
            super(getVoucherList);
            if (getVoucherList != null) {
                this.requestid = getVoucherList.requestid;
                this.shopid = getVoucherList.shopid;
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

        public GetVoucherList build() {
            return new GetVoucherList(this);
        }
    }
}
