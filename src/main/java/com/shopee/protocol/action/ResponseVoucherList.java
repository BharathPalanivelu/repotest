package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseVoucherList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<VoucherResult> DEFAULT_VOUCHERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherResult.class, tag = 3)
    public final List<VoucherResult> vouchers;

    public ResponseVoucherList(String str, Integer num, List<VoucherResult> list) {
        this.requestid = str;
        this.errcode = num;
        this.vouchers = immutableCopyOf(list);
    }

    private ResponseVoucherList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.vouchers);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseVoucherList)) {
            return false;
        }
        ResponseVoucherList responseVoucherList = (ResponseVoucherList) obj;
        if (!equals((Object) this.requestid, (Object) responseVoucherList.requestid) || !equals((Object) this.errcode, (Object) responseVoucherList.errcode) || !equals((List<?>) this.vouchers, (List<?>) responseVoucherList.vouchers)) {
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
        List<VoucherResult> list = this.vouchers;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseVoucherList> {
        public Integer errcode;
        public String requestid;
        public List<VoucherResult> vouchers;

        public Builder() {
        }

        public Builder(ResponseVoucherList responseVoucherList) {
            super(responseVoucherList);
            if (responseVoucherList != null) {
                this.requestid = responseVoucherList.requestid;
                this.errcode = responseVoucherList.errcode;
                this.vouchers = ResponseVoucherList.copyOf(responseVoucherList.vouchers);
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

        public Builder vouchers(List<VoucherResult> list) {
            this.vouchers = checkForNulls(list);
            return this;
        }

        public ResponseVoucherList build() {
            return new ResponseVoucherList(this);
        }
    }
}
