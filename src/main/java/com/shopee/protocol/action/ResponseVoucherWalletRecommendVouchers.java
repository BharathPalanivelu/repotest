package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseVoucherWalletRecommendVouchers extends Message {
    public static final List<VoucherWalletVoucher> DEFAULT_ADDON_VOUCHERS = Collections.emptyList();
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<VoucherWalletVoucher> DEFAULT_FREESHIPPING_VOUCHERS = Collections.emptyList();
    public static final List<VoucherWalletVoucher> DEFAULT_OTHER_VOUCHERS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<VoucherWalletVoucher> DEFAULT_VALID_VOUCHERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherWalletVoucher.class, tag = 4)
    public final List<VoucherWalletVoucher> addon_vouchers;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherWalletVoucher.class, tag = 7)
    public final List<VoucherWalletVoucher> freeshipping_vouchers;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherWalletVoucher.class, tag = 5)
    public final List<VoucherWalletVoucher> other_vouchers;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherWalletVoucher.class, tag = 3)
    public final List<VoucherWalletVoucher> valid_vouchers;

    public ResponseVoucherWalletRecommendVouchers(String str, Integer num, List<VoucherWalletVoucher> list, List<VoucherWalletVoucher> list2, List<VoucherWalletVoucher> list3, String str2, List<VoucherWalletVoucher> list4) {
        this.requestid = str;
        this.errcode = num;
        this.valid_vouchers = immutableCopyOf(list);
        this.addon_vouchers = immutableCopyOf(list2);
        this.other_vouchers = immutableCopyOf(list3);
        this.debug_msg = str2;
        this.freeshipping_vouchers = immutableCopyOf(list4);
    }

    private ResponseVoucherWalletRecommendVouchers(Builder builder) {
        this(builder.requestid, builder.errcode, builder.valid_vouchers, builder.addon_vouchers, builder.other_vouchers, builder.debug_msg, builder.freeshipping_vouchers);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseVoucherWalletRecommendVouchers)) {
            return false;
        }
        ResponseVoucherWalletRecommendVouchers responseVoucherWalletRecommendVouchers = (ResponseVoucherWalletRecommendVouchers) obj;
        if (!equals((Object) this.requestid, (Object) responseVoucherWalletRecommendVouchers.requestid) || !equals((Object) this.errcode, (Object) responseVoucherWalletRecommendVouchers.errcode) || !equals((List<?>) this.valid_vouchers, (List<?>) responseVoucherWalletRecommendVouchers.valid_vouchers) || !equals((List<?>) this.addon_vouchers, (List<?>) responseVoucherWalletRecommendVouchers.addon_vouchers) || !equals((List<?>) this.other_vouchers, (List<?>) responseVoucherWalletRecommendVouchers.other_vouchers) || !equals((Object) this.debug_msg, (Object) responseVoucherWalletRecommendVouchers.debug_msg) || !equals((List<?>) this.freeshipping_vouchers, (List<?>) responseVoucherWalletRecommendVouchers.freeshipping_vouchers)) {
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
        List<VoucherWalletVoucher> list = this.valid_vouchers;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<VoucherWalletVoucher> list2 = this.addon_vouchers;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<VoucherWalletVoucher> list3 = this.other_vouchers;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 1)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i4 = (hashCode5 + i2) * 37;
        List<VoucherWalletVoucher> list4 = this.freeshipping_vouchers;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseVoucherWalletRecommendVouchers> {
        public List<VoucherWalletVoucher> addon_vouchers;
        public String debug_msg;
        public Integer errcode;
        public List<VoucherWalletVoucher> freeshipping_vouchers;
        public List<VoucherWalletVoucher> other_vouchers;
        public String requestid;
        public List<VoucherWalletVoucher> valid_vouchers;

        public Builder() {
        }

        public Builder(ResponseVoucherWalletRecommendVouchers responseVoucherWalletRecommendVouchers) {
            super(responseVoucherWalletRecommendVouchers);
            if (responseVoucherWalletRecommendVouchers != null) {
                this.requestid = responseVoucherWalletRecommendVouchers.requestid;
                this.errcode = responseVoucherWalletRecommendVouchers.errcode;
                this.valid_vouchers = ResponseVoucherWalletRecommendVouchers.copyOf(responseVoucherWalletRecommendVouchers.valid_vouchers);
                this.addon_vouchers = ResponseVoucherWalletRecommendVouchers.copyOf(responseVoucherWalletRecommendVouchers.addon_vouchers);
                this.other_vouchers = ResponseVoucherWalletRecommendVouchers.copyOf(responseVoucherWalletRecommendVouchers.other_vouchers);
                this.debug_msg = responseVoucherWalletRecommendVouchers.debug_msg;
                this.freeshipping_vouchers = ResponseVoucherWalletRecommendVouchers.copyOf(responseVoucherWalletRecommendVouchers.freeshipping_vouchers);
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

        public Builder valid_vouchers(List<VoucherWalletVoucher> list) {
            this.valid_vouchers = checkForNulls(list);
            return this;
        }

        public Builder addon_vouchers(List<VoucherWalletVoucher> list) {
            this.addon_vouchers = checkForNulls(list);
            return this;
        }

        public Builder other_vouchers(List<VoucherWalletVoucher> list) {
            this.other_vouchers = checkForNulls(list);
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder freeshipping_vouchers(List<VoucherWalletVoucher> list) {
            this.freeshipping_vouchers = checkForNulls(list);
            return this;
        }

        public ResponseVoucherWalletRecommendVouchers build() {
            return new ResponseVoucherWalletRecommendVouchers(this);
        }
    }
}
