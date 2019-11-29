package com.shopee.protocol.action;

import com.shopee.protocol.shop.CheckoutPaymentInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class VoucherWalletRecommendVouchers extends Message {
    public static final String DEFAULT_CARD_BIN_NUMBER = "";
    public static final Boolean DEFAULT_CHECK_VOUCHER_PAYMENT_CRITERIA = false;
    public static final List<DPItem> DEFAULT_DP_ITEMS = Collections.emptyList();
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Boolean DEFAULT_IS_NEW_USER = false;
    public static final Boolean DEFAULT_IS_SLASH_PRICE = false;
    public static final List<OrderWithItems> DEFAULT_ORDERS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    public static final Integer DEFAULT_VOUCHER_MARKET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String card_bin_number;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean check_voucher_payment_criteria;
    @ProtoField(tag = 11)
    public final CheckoutPaymentInfo checkout_payment_info;
    @ProtoField(label = Message.Label.REPEATED, messageType = DPItem.class, tag = 9)
    public final List<DPItem> dp_items;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_new_user;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_slash_price;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderWithItems.class, tag = 3)
    public final List<OrderWithItems> orders;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer user_agent_type;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer voucher_market_type;

    public VoucherWalletRecommendVouchers(String str, String str2, List<OrderWithItems> list, Integer num, Boolean bool, Boolean bool2, Integer num2, Boolean bool3, List<DPItem> list2, Boolean bool4, CheckoutPaymentInfo checkoutPaymentInfo, String str3) {
        this.requestid = str;
        this.token = str2;
        this.orders = immutableCopyOf(list);
        this.user_agent_type = num;
        this.is_group_buy = bool;
        this.is_slash_price = bool2;
        this.voucher_market_type = num2;
        this.is_new_user = bool3;
        this.dp_items = immutableCopyOf(list2);
        this.check_voucher_payment_criteria = bool4;
        this.checkout_payment_info = checkoutPaymentInfo;
        this.card_bin_number = str3;
    }

    private VoucherWalletRecommendVouchers(Builder builder) {
        this(builder.requestid, builder.token, builder.orders, builder.user_agent_type, builder.is_group_buy, builder.is_slash_price, builder.voucher_market_type, builder.is_new_user, builder.dp_items, builder.check_voucher_payment_criteria, builder.checkout_payment_info, builder.card_bin_number);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherWalletRecommendVouchers)) {
            return false;
        }
        VoucherWalletRecommendVouchers voucherWalletRecommendVouchers = (VoucherWalletRecommendVouchers) obj;
        if (!equals((Object) this.requestid, (Object) voucherWalletRecommendVouchers.requestid) || !equals((Object) this.token, (Object) voucherWalletRecommendVouchers.token) || !equals((List<?>) this.orders, (List<?>) voucherWalletRecommendVouchers.orders) || !equals((Object) this.user_agent_type, (Object) voucherWalletRecommendVouchers.user_agent_type) || !equals((Object) this.is_group_buy, (Object) voucherWalletRecommendVouchers.is_group_buy) || !equals((Object) this.is_slash_price, (Object) voucherWalletRecommendVouchers.is_slash_price) || !equals((Object) this.voucher_market_type, (Object) voucherWalletRecommendVouchers.voucher_market_type) || !equals((Object) this.is_new_user, (Object) voucherWalletRecommendVouchers.is_new_user) || !equals((List<?>) this.dp_items, (List<?>) voucherWalletRecommendVouchers.dp_items) || !equals((Object) this.check_voucher_payment_criteria, (Object) voucherWalletRecommendVouchers.check_voucher_payment_criteria) || !equals((Object) this.checkout_payment_info, (Object) voucherWalletRecommendVouchers.checkout_payment_info) || !equals((Object) this.card_bin_number, (Object) voucherWalletRecommendVouchers.card_bin_number)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<OrderWithItems> list = this.orders;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.user_agent_type;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.is_group_buy;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_slash_price;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num2 = this.voucher_market_type;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_new_user;
        int hashCode8 = (hashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        List<DPItem> list2 = this.dp_items;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode8 + i3) * 37;
        Boolean bool4 = this.check_voucher_payment_criteria;
        int hashCode9 = (i4 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        CheckoutPaymentInfo checkoutPaymentInfo = this.checkout_payment_info;
        int hashCode10 = (hashCode9 + (checkoutPaymentInfo != null ? checkoutPaymentInfo.hashCode() : 0)) * 37;
        String str3 = this.card_bin_number;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i5 = hashCode10 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<VoucherWalletRecommendVouchers> {
        public String card_bin_number;
        public Boolean check_voucher_payment_criteria;
        public CheckoutPaymentInfo checkout_payment_info;
        public List<DPItem> dp_items;
        public Boolean is_group_buy;
        public Boolean is_new_user;
        public Boolean is_slash_price;
        public List<OrderWithItems> orders;
        public String requestid;
        public String token;
        public Integer user_agent_type;
        public Integer voucher_market_type;

        public Builder() {
        }

        public Builder(VoucherWalletRecommendVouchers voucherWalletRecommendVouchers) {
            super(voucherWalletRecommendVouchers);
            if (voucherWalletRecommendVouchers != null) {
                this.requestid = voucherWalletRecommendVouchers.requestid;
                this.token = voucherWalletRecommendVouchers.token;
                this.orders = VoucherWalletRecommendVouchers.copyOf(voucherWalletRecommendVouchers.orders);
                this.user_agent_type = voucherWalletRecommendVouchers.user_agent_type;
                this.is_group_buy = voucherWalletRecommendVouchers.is_group_buy;
                this.is_slash_price = voucherWalletRecommendVouchers.is_slash_price;
                this.voucher_market_type = voucherWalletRecommendVouchers.voucher_market_type;
                this.is_new_user = voucherWalletRecommendVouchers.is_new_user;
                this.dp_items = VoucherWalletRecommendVouchers.copyOf(voucherWalletRecommendVouchers.dp_items);
                this.check_voucher_payment_criteria = voucherWalletRecommendVouchers.check_voucher_payment_criteria;
                this.checkout_payment_info = voucherWalletRecommendVouchers.checkout_payment_info;
                this.card_bin_number = voucherWalletRecommendVouchers.card_bin_number;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder orders(List<OrderWithItems> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder user_agent_type(Integer num) {
            this.user_agent_type = num;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public Builder is_slash_price(Boolean bool) {
            this.is_slash_price = bool;
            return this;
        }

        public Builder voucher_market_type(Integer num) {
            this.voucher_market_type = num;
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

        public VoucherWalletRecommendVouchers build() {
            return new VoucherWalletRecommendVouchers(this);
        }
    }
}
