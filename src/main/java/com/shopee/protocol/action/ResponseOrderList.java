package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerOrderCntInfo;
import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.SellerOrderCntInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseOrderList extends Message {
    public static final Integer DEFAULT_BUYER_TO_RATE_COUNT = 0;
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final Integer DEFAULT_GROUP_BUY_ONGOING_GROUP_CNT = 0;
    public static final Integer DEFAULT_GROUP_BUY_UNPAID_ORDER_CNT = 0;
    public static final List<OrderInfo> DEFAULT_INFO = Collections.emptyList();
    public static final Integer DEFAULT_INVALID_MESSAGE_CODE = 0;
    public static final Integer DEFAULT_INVALID_PRICERULE_CODE = 0;
    public static final List<Order> DEFAULT_ORDER = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TOTAL_ORDERS = 0;
    public static final Integer DEFAULT_WELCOME_PACKAGE_ERR = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11)
    public final BuyerOrderCntInfo buyer_ordercnt_info;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer buyer_to_rate_count;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer group_buy_ongoing_group_cnt;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer group_buy_unpaid_order_cnt;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderInfo.class, tag = 6)
    public final List<OrderInfo> info;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer invalid_message_code;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer invalid_pricerule_code;
    @ProtoField(label = Message.Label.REPEATED, messageType = Order.class, tag = 3)
    public final List<Order> order;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10)
    public final SellerOrderCntInfo seller_ordercnt_info;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total_orders;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer welcome_package_err;

    public ResponseOrderList(String str, Integer num, List<Order> list, Integer num2, Integer num3, List<OrderInfo> list2, Integer num4, String str2, String str3, SellerOrderCntInfo sellerOrderCntInfo, BuyerOrderCntInfo buyerOrderCntInfo, Integer num5, Integer num6, Integer num7, Integer num8) {
        this.requestid = str;
        this.errcode = num;
        this.order = immutableCopyOf(list);
        this.total_orders = num2;
        this.invalid_message_code = num3;
        this.info = immutableCopyOf(list2);
        this.invalid_pricerule_code = num4;
        this.err_message = str2;
        this.debug_msg = str3;
        this.seller_ordercnt_info = sellerOrderCntInfo;
        this.buyer_ordercnt_info = buyerOrderCntInfo;
        this.group_buy_unpaid_order_cnt = num5;
        this.group_buy_ongoing_group_cnt = num6;
        this.welcome_package_err = num7;
        this.buyer_to_rate_count = num8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ResponseOrderList(com.shopee.protocol.action.ResponseOrderList.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.errcode
            java.util.List<com.shopee.protocol.shop.Order> r4 = r0.order
            java.lang.Integer r5 = r0.total_orders
            java.lang.Integer r6 = r0.invalid_message_code
            java.util.List<com.shopee.protocol.action.OrderInfo> r7 = r0.info
            java.lang.Integer r8 = r0.invalid_pricerule_code
            java.lang.String r9 = r0.err_message
            java.lang.String r10 = r0.debug_msg
            com.shopee.protocol.shop.SellerOrderCntInfo r11 = r0.seller_ordercnt_info
            com.shopee.protocol.shop.BuyerOrderCntInfo r12 = r0.buyer_ordercnt_info
            java.lang.Integer r13 = r0.group_buy_unpaid_order_cnt
            java.lang.Integer r14 = r0.group_buy_ongoing_group_cnt
            java.lang.Integer r15 = r0.welcome_package_err
            java.lang.Integer r1 = r0.buyer_to_rate_count
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.ResponseOrderList.<init>(com.shopee.protocol.action.ResponseOrderList$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseOrderList)) {
            return false;
        }
        ResponseOrderList responseOrderList = (ResponseOrderList) obj;
        if (!equals((Object) this.requestid, (Object) responseOrderList.requestid) || !equals((Object) this.errcode, (Object) responseOrderList.errcode) || !equals((List<?>) this.order, (List<?>) responseOrderList.order) || !equals((Object) this.total_orders, (Object) responseOrderList.total_orders) || !equals((Object) this.invalid_message_code, (Object) responseOrderList.invalid_message_code) || !equals((List<?>) this.info, (List<?>) responseOrderList.info) || !equals((Object) this.invalid_pricerule_code, (Object) responseOrderList.invalid_pricerule_code) || !equals((Object) this.err_message, (Object) responseOrderList.err_message) || !equals((Object) this.debug_msg, (Object) responseOrderList.debug_msg) || !equals((Object) this.seller_ordercnt_info, (Object) responseOrderList.seller_ordercnt_info) || !equals((Object) this.buyer_ordercnt_info, (Object) responseOrderList.buyer_ordercnt_info) || !equals((Object) this.group_buy_unpaid_order_cnt, (Object) responseOrderList.group_buy_unpaid_order_cnt) || !equals((Object) this.group_buy_ongoing_group_cnt, (Object) responseOrderList.group_buy_ongoing_group_cnt) || !equals((Object) this.welcome_package_err, (Object) responseOrderList.welcome_package_err) || !equals((Object) this.buyer_to_rate_count, (Object) responseOrderList.buyer_to_rate_count)) {
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
        List<Order> list = this.order;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total_orders;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.invalid_message_code;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<OrderInfo> list2 = this.info;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode5 + i3) * 37;
        Integer num4 = this.invalid_pricerule_code;
        int hashCode6 = (i4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.err_message;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.debug_msg;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        SellerOrderCntInfo sellerOrderCntInfo = this.seller_ordercnt_info;
        int hashCode9 = (hashCode8 + (sellerOrderCntInfo != null ? sellerOrderCntInfo.hashCode() : 0)) * 37;
        BuyerOrderCntInfo buyerOrderCntInfo = this.buyer_ordercnt_info;
        int hashCode10 = (hashCode9 + (buyerOrderCntInfo != null ? buyerOrderCntInfo.hashCode() : 0)) * 37;
        Integer num5 = this.group_buy_unpaid_order_cnt;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.group_buy_ongoing_group_cnt;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.welcome_package_err;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.buyer_to_rate_count;
        if (num8 != null) {
            i2 = num8.hashCode();
        }
        int i5 = hashCode13 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseOrderList> {
        public BuyerOrderCntInfo buyer_ordercnt_info;
        public Integer buyer_to_rate_count;
        public String debug_msg;
        public String err_message;
        public Integer errcode;
        public Integer group_buy_ongoing_group_cnt;
        public Integer group_buy_unpaid_order_cnt;
        public List<OrderInfo> info;
        public Integer invalid_message_code;
        public Integer invalid_pricerule_code;
        public List<Order> order;
        public String requestid;
        public SellerOrderCntInfo seller_ordercnt_info;
        public Integer total_orders;
        public Integer welcome_package_err;

        public Builder() {
        }

        public Builder(ResponseOrderList responseOrderList) {
            super(responseOrderList);
            if (responseOrderList != null) {
                this.requestid = responseOrderList.requestid;
                this.errcode = responseOrderList.errcode;
                this.order = ResponseOrderList.copyOf(responseOrderList.order);
                this.total_orders = responseOrderList.total_orders;
                this.invalid_message_code = responseOrderList.invalid_message_code;
                this.info = ResponseOrderList.copyOf(responseOrderList.info);
                this.invalid_pricerule_code = responseOrderList.invalid_pricerule_code;
                this.err_message = responseOrderList.err_message;
                this.debug_msg = responseOrderList.debug_msg;
                this.seller_ordercnt_info = responseOrderList.seller_ordercnt_info;
                this.buyer_ordercnt_info = responseOrderList.buyer_ordercnt_info;
                this.group_buy_unpaid_order_cnt = responseOrderList.group_buy_unpaid_order_cnt;
                this.group_buy_ongoing_group_cnt = responseOrderList.group_buy_ongoing_group_cnt;
                this.welcome_package_err = responseOrderList.welcome_package_err;
                this.buyer_to_rate_count = responseOrderList.buyer_to_rate_count;
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

        public Builder order(List<Order> list) {
            this.order = checkForNulls(list);
            return this;
        }

        public Builder total_orders(Integer num) {
            this.total_orders = num;
            return this;
        }

        public Builder invalid_message_code(Integer num) {
            this.invalid_message_code = num;
            return this;
        }

        public Builder info(List<OrderInfo> list) {
            this.info = checkForNulls(list);
            return this;
        }

        public Builder invalid_pricerule_code(Integer num) {
            this.invalid_pricerule_code = num;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder seller_ordercnt_info(SellerOrderCntInfo sellerOrderCntInfo) {
            this.seller_ordercnt_info = sellerOrderCntInfo;
            return this;
        }

        public Builder buyer_ordercnt_info(BuyerOrderCntInfo buyerOrderCntInfo) {
            this.buyer_ordercnt_info = buyerOrderCntInfo;
            return this;
        }

        public Builder group_buy_unpaid_order_cnt(Integer num) {
            this.group_buy_unpaid_order_cnt = num;
            return this;
        }

        public Builder group_buy_ongoing_group_cnt(Integer num) {
            this.group_buy_ongoing_group_cnt = num;
            return this;
        }

        public Builder welcome_package_err(Integer num) {
            this.welcome_package_err = num;
            return this;
        }

        public Builder buyer_to_rate_count(Integer num) {
            this.buyer_to_rate_count = num;
            return this;
        }

        public ResponseOrderList build() {
            checkRequiredFields();
            return new ResponseOrderList(this);
        }
    }
}
