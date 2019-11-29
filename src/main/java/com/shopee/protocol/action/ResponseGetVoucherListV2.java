package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetVoucherListV2 extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<VoucherWalletVoucher> DEFAULT_VOUCHERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherWalletVoucher.class, tag = 4)
    public final List<VoucherWalletVoucher> vouchers;

    public ResponseGetVoucherListV2(String str, Integer num, String str2, List<VoucherWalletVoucher> list) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.vouchers = immutableCopyOf(list);
    }

    private ResponseGetVoucherListV2(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.vouchers);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetVoucherListV2)) {
            return false;
        }
        ResponseGetVoucherListV2 responseGetVoucherListV2 = (ResponseGetVoucherListV2) obj;
        if (!equals((Object) this.requestid, (Object) responseGetVoucherListV2.requestid) || !equals((Object) this.errcode, (Object) responseGetVoucherListV2.errcode) || !equals((Object) this.debug_msg, (Object) responseGetVoucherListV2.debug_msg) || !equals((List<?>) this.vouchers, (List<?>) responseGetVoucherListV2.vouchers)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<VoucherWalletVoucher> list = this.vouchers;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseGetVoucherListV2> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;
        public List<VoucherWalletVoucher> vouchers;

        public Builder() {
        }

        public Builder(ResponseGetVoucherListV2 responseGetVoucherListV2) {
            super(responseGetVoucherListV2);
            if (responseGetVoucherListV2 != null) {
                this.requestid = responseGetVoucherListV2.requestid;
                this.errcode = responseGetVoucherListV2.errcode;
                this.debug_msg = responseGetVoucherListV2.debug_msg;
                this.vouchers = ResponseGetVoucherListV2.copyOf(responseGetVoucherListV2.vouchers);
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder vouchers(List<VoucherWalletVoucher> list) {
            this.vouchers = checkForNulls(list);
            return this;
        }

        public ResponseGetVoucherListV2 build() {
            return new ResponseGetVoucherListV2(this);
        }
    }
}
