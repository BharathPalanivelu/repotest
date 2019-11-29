package com.shopee.protocol.action;

import com.shopee.protocol.shop.CheckoutPaymentInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class UseVoucher extends Message {
    public static final String DEFAULT_CARD_BIN_NUMBER = "";
    public static final Boolean DEFAULT_CHECK_VOUCHER_PAYMENT_CRITERIA = false;
    public static final List<DPItem> DEFAULT_DP_ITEMS = Collections.emptyList();
    public static final Boolean DEFAULT_IS_NEW_USER = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    public static final Integer DEFAULT_VOUCHER_MARKET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String card_bin_number;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean check_voucher_payment_criteria;
    @ProtoField(tag = 11)
    public final CheckoutPaymentInfo checkout_payment_info;
    @ProtoField(label = Message.Label.REPEATED, messageType = DPItem.class, tag = 9)
    public final List<DPItem> dp_items;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_new_user;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer user_agent_type;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String voucher_code;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer voucher_market_type;

    public UseVoucher(String str, BackendParam backendParam, Long l, String str2, Long l2, Integer num, Integer num2, Boolean bool, List<DPItem> list, Boolean bool2, CheckoutPaymentInfo checkoutPaymentInfo, String str3) {
        this.requestid = str;
        this.bparam = backendParam;
        this.promotionid = l;
        this.voucher_code = str2;
        this.orderid = l2;
        this.voucher_market_type = num;
        this.user_agent_type = num2;
        this.is_new_user = bool;
        this.dp_items = immutableCopyOf(list);
        this.check_voucher_payment_criteria = bool2;
        this.checkout_payment_info = checkoutPaymentInfo;
        this.card_bin_number = str3;
    }

    private UseVoucher(Builder builder) {
        this(builder.requestid, builder.bparam, builder.promotionid, builder.voucher_code, builder.orderid, builder.voucher_market_type, builder.user_agent_type, builder.is_new_user, builder.dp_items, builder.check_voucher_payment_criteria, builder.checkout_payment_info, builder.card_bin_number);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UseVoucher)) {
            return false;
        }
        UseVoucher useVoucher = (UseVoucher) obj;
        if (!equals((Object) this.requestid, (Object) useVoucher.requestid) || !equals((Object) this.bparam, (Object) useVoucher.bparam) || !equals((Object) this.promotionid, (Object) useVoucher.promotionid) || !equals((Object) this.voucher_code, (Object) useVoucher.voucher_code) || !equals((Object) this.orderid, (Object) useVoucher.orderid) || !equals((Object) this.voucher_market_type, (Object) useVoucher.voucher_market_type) || !equals((Object) this.user_agent_type, (Object) useVoucher.user_agent_type) || !equals((Object) this.is_new_user, (Object) useVoucher.is_new_user) || !equals((List<?>) this.dp_items, (List<?>) useVoucher.dp_items) || !equals((Object) this.check_voucher_payment_criteria, (Object) useVoucher.check_voucher_payment_criteria) || !equals((Object) this.checkout_payment_info, (Object) useVoucher.checkout_payment_info) || !equals((Object) this.card_bin_number, (Object) useVoucher.card_bin_number)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.voucher_code;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.voucher_market_type;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.user_agent_type;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.is_new_user;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<DPItem> list = this.dp_items;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool2 = this.check_voucher_payment_criteria;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        CheckoutPaymentInfo checkoutPaymentInfo = this.checkout_payment_info;
        int hashCode11 = (hashCode10 + (checkoutPaymentInfo != null ? checkoutPaymentInfo.hashCode() : 0)) * 37;
        String str3 = this.card_bin_number;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UseVoucher> {
        public BackendParam bparam;
        public String card_bin_number;
        public Boolean check_voucher_payment_criteria;
        public CheckoutPaymentInfo checkout_payment_info;
        public List<DPItem> dp_items;
        public Boolean is_new_user;
        public Long orderid;
        public Long promotionid;
        public String requestid;
        public Integer user_agent_type;
        public String voucher_code;
        public Integer voucher_market_type;

        public Builder() {
        }

        public Builder(UseVoucher useVoucher) {
            super(useVoucher);
            if (useVoucher != null) {
                this.requestid = useVoucher.requestid;
                this.bparam = useVoucher.bparam;
                this.promotionid = useVoucher.promotionid;
                this.voucher_code = useVoucher.voucher_code;
                this.orderid = useVoucher.orderid;
                this.voucher_market_type = useVoucher.voucher_market_type;
                this.user_agent_type = useVoucher.user_agent_type;
                this.is_new_user = useVoucher.is_new_user;
                this.dp_items = UseVoucher.copyOf(useVoucher.dp_items);
                this.check_voucher_payment_criteria = useVoucher.check_voucher_payment_criteria;
                this.checkout_payment_info = useVoucher.checkout_payment_info;
                this.card_bin_number = useVoucher.card_bin_number;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder voucher_market_type(Integer num) {
            this.voucher_market_type = num;
            return this;
        }

        public Builder user_agent_type(Integer num) {
            this.user_agent_type = num;
            return this;
        }

        public Builder is_new_user(Boolean bool) {
            this.is_new_user = bool;
            return this;
        }

        public Builder dp_items(List<DPItem> list) {
            this.dp_items = checkForNulls(list);
            return this;
        }

        public Builder check_voucher_payment_criteria(Boolean bool) {
            this.check_voucher_payment_criteria = bool;
            return this;
        }

        public Builder checkout_payment_info(CheckoutPaymentInfo checkoutPaymentInfo) {
            this.checkout_payment_info = checkoutPaymentInfo;
            return this;
        }

        public Builder card_bin_number(String str) {
            this.card_bin_number = str;
            return this;
        }

        public UseVoucher build() {
            return new UseVoucher(this);
        }
    }
}
