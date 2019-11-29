package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import e.f;
import java.io.IOException;

public final class OrderProto extends Message<OrderProto, Builder> {
    public static final ProtoAdapter<OrderProto> ADAPTER = new ProtoAdapter_OrderProto();
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Long DEFAULT_CURRENCY_AMOUNT = 0L;
    public static final Long DEFAULT_EVENT_ID = 0L;
    public static final Integer DEFAULT_EXPIRED_TIME = 0;
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Integer DEFAULT_ITEM_AMOUNT = 0;
    public static final String DEFAULT_ITEM_ID = "";
    public static final String DEFAULT_ITEM_IMAGE = "";
    public static final String DEFAULT_ITEM_NAME = "";
    public static final Long DEFAULT_ORDER_ID = 0L;
    public static final String DEFAULT_PAYMENT_ACCOUNT_ID = "";
    public static final Long DEFAULT_PAYMENT_CASH_AMOUNT = 0L;
    public static final Integer DEFAULT_PAYMENT_CHANNEL_ID = 0;
    public static final String DEFAULT_PAYMENT_CHANNEL_TXN_ID = "";
    public static final Long DEFAULT_PAYMENT_PAYABLE_AMOUNT = 0L;
    public static final Long DEFAULT_PAYMENT_TXN_ID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOPUP_ACCOUNT_ID = "";
    public static final Long DEFAULT_TOPUP_CASH_AMOUNT = 0L;
    public static final Integer DEFAULT_TOPUP_CHANNEL_ID = 0;
    public static final String DEFAULT_TOPUP_CHANNEL_TXN_ID = "";
    public static final Long DEFAULT_TOPUP_PAYABLE_AMOUNT = 0L;
    public static final Long DEFAULT_TOPUP_TXN_ID = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_UPDATE_TIME = 0;
    public static final Integer DEFAULT_VALID_TIME = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer create_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String currency;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 5)
    public final Long currency_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 23)
    public final Long event_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer expired_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 22)
    public final String extra_data;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 17)
    public final Integer item_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 16)
    public final String item_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 19)
    public final String item_image;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 18)
    public final String item_name;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 1)
    public final Long order_id;
    @WireField(adapter = "com.airpay.protocol.protobuf.OrderRefundProto#ADAPTER", tag = 28)
    public final OrderRefundProto order_refund;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 15)
    public final String payment_account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 27)
    public final Long payment_cash_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer payment_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 14)
    public final String payment_channel_txn_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 25)
    public final Long payment_payable_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 21)
    public final Long payment_txn_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer status;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 12)
    public final String topup_account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 26)
    public final Long topup_cash_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer topup_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 11)
    public final String topup_channel_txn_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 24)
    public final Long topup_payable_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 20)
    public final Long topup_txn_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer type;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer update_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer valid_time;

    public OrderProto(Long l, Integer num, Integer num2, String str, Long l2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str2, String str3, Integer num8, String str4, String str5, String str6, Integer num9, String str7, String str8, Long l3, Long l4, String str9, Long l5, Long l6, Long l7, Long l8, Long l9, OrderRefundProto orderRefundProto) {
        this(l, num, num2, str, l2, num3, num4, num5, num6, num7, str2, str3, num8, str4, str5, str6, num9, str7, str8, l3, l4, str9, l5, l6, l7, l8, l9, orderRefundProto, f.f32736b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderProto(Long l, Integer num, Integer num2, String str, Long l2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str2, String str3, Integer num8, String str4, String str5, String str6, Integer num9, String str7, String str8, Long l3, Long l4, String str9, Long l5, Long l6, Long l7, Long l8, Long l9, OrderRefundProto orderRefundProto, f fVar) {
        super(ADAPTER, fVar);
        this.order_id = l;
        this.type = num;
        this.status = num2;
        this.currency = str;
        this.currency_amount = l2;
        this.create_time = num3;
        this.expired_time = num4;
        this.valid_time = num5;
        this.update_time = num6;
        this.topup_channel_id = num7;
        this.topup_channel_txn_id = str2;
        this.topup_account_id = str3;
        this.payment_channel_id = num8;
        this.payment_channel_txn_id = str4;
        this.payment_account_id = str5;
        this.item_id = str6;
        this.item_amount = num9;
        this.item_name = str7;
        this.item_image = str8;
        this.topup_txn_id = l3;
        this.payment_txn_id = l4;
        this.extra_data = str9;
        this.event_id = l5;
        this.topup_payable_amount = l6;
        this.payment_payable_amount = l7;
        this.topup_cash_amount = l8;
        this.payment_cash_amount = l9;
        this.order_refund = orderRefundProto;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.order_id = this.order_id;
        builder.type = this.type;
        builder.status = this.status;
        builder.currency = this.currency;
        builder.currency_amount = this.currency_amount;
        builder.create_time = this.create_time;
        builder.expired_time = this.expired_time;
        builder.valid_time = this.valid_time;
        builder.update_time = this.update_time;
        builder.topup_channel_id = this.topup_channel_id;
        builder.topup_channel_txn_id = this.topup_channel_txn_id;
        builder.topup_account_id = this.topup_account_id;
        builder.payment_channel_id = this.payment_channel_id;
        builder.payment_channel_txn_id = this.payment_channel_txn_id;
        builder.payment_account_id = this.payment_account_id;
        builder.item_id = this.item_id;
        builder.item_amount = this.item_amount;
        builder.item_name = this.item_name;
        builder.item_image = this.item_image;
        builder.topup_txn_id = this.topup_txn_id;
        builder.payment_txn_id = this.payment_txn_id;
        builder.extra_data = this.extra_data;
        builder.event_id = this.event_id;
        builder.topup_payable_amount = this.topup_payable_amount;
        builder.payment_payable_amount = this.payment_payable_amount;
        builder.topup_cash_amount = this.topup_cash_amount;
        builder.payment_cash_amount = this.payment_cash_amount;
        builder.order_refund = this.order_refund;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderProto)) {
            return false;
        }
        OrderProto orderProto = (OrderProto) obj;
        if (!unknownFields().equals(orderProto.unknownFields()) || !Internal.equals(this.order_id, orderProto.order_id) || !Internal.equals(this.type, orderProto.type) || !Internal.equals(this.status, orderProto.status) || !Internal.equals(this.currency, orderProto.currency) || !Internal.equals(this.currency_amount, orderProto.currency_amount) || !Internal.equals(this.create_time, orderProto.create_time) || !Internal.equals(this.expired_time, orderProto.expired_time) || !Internal.equals(this.valid_time, orderProto.valid_time) || !Internal.equals(this.update_time, orderProto.update_time) || !Internal.equals(this.topup_channel_id, orderProto.topup_channel_id) || !Internal.equals(this.topup_channel_txn_id, orderProto.topup_channel_txn_id) || !Internal.equals(this.topup_account_id, orderProto.topup_account_id) || !Internal.equals(this.payment_channel_id, orderProto.payment_channel_id) || !Internal.equals(this.payment_channel_txn_id, orderProto.payment_channel_txn_id) || !Internal.equals(this.payment_account_id, orderProto.payment_account_id) || !Internal.equals(this.item_id, orderProto.item_id) || !Internal.equals(this.item_amount, orderProto.item_amount) || !Internal.equals(this.item_name, orderProto.item_name) || !Internal.equals(this.item_image, orderProto.item_image) || !Internal.equals(this.topup_txn_id, orderProto.topup_txn_id) || !Internal.equals(this.payment_txn_id, orderProto.payment_txn_id) || !Internal.equals(this.extra_data, orderProto.extra_data) || !Internal.equals(this.event_id, orderProto.event_id) || !Internal.equals(this.topup_payable_amount, orderProto.topup_payable_amount) || !Internal.equals(this.payment_payable_amount, orderProto.payment_payable_amount) || !Internal.equals(this.topup_cash_amount, orderProto.topup_cash_amount) || !Internal.equals(this.payment_cash_amount, orderProto.payment_cash_amount) || !Internal.equals(this.order_refund, orderProto.order_refund)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l = this.order_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.currency_amount;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.create_time;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.expired_time;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.valid_time;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.update_time;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.topup_channel_id;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str2 = this.topup_channel_txn_id;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.topup_account_id;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num8 = this.payment_channel_id;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str4 = this.payment_channel_txn_id;
        int hashCode15 = (hashCode14 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.payment_account_id;
        int hashCode16 = (hashCode15 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.item_id;
        int hashCode17 = (hashCode16 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num9 = this.item_amount;
        int hashCode18 = (hashCode17 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str7 = this.item_name;
        int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.item_image;
        int hashCode20 = (hashCode19 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Long l3 = this.topup_txn_id;
        int hashCode21 = (hashCode20 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.payment_txn_id;
        int hashCode22 = (hashCode21 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str9 = this.extra_data;
        int hashCode23 = (hashCode22 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Long l5 = this.event_id;
        int hashCode24 = (hashCode23 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.topup_payable_amount;
        int hashCode25 = (hashCode24 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.payment_payable_amount;
        int hashCode26 = (hashCode25 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.topup_cash_amount;
        int hashCode27 = (hashCode26 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.payment_cash_amount;
        int hashCode28 = (hashCode27 + (l9 != null ? l9.hashCode() : 0)) * 37;
        OrderRefundProto orderRefundProto = this.order_refund;
        if (orderRefundProto != null) {
            i2 = orderRefundProto.hashCode();
        }
        int i3 = hashCode28 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.status != null) {
            sb.append(", status=");
            sb.append(this.status);
        }
        if (this.currency != null) {
            sb.append(", currency=");
            sb.append(this.currency);
        }
        if (this.currency_amount != null) {
            sb.append(", currency_amount=");
            sb.append(this.currency_amount);
        }
        if (this.create_time != null) {
            sb.append(", create_time=");
            sb.append(this.create_time);
        }
        if (this.expired_time != null) {
            sb.append(", expired_time=");
            sb.append(this.expired_time);
        }
        if (this.valid_time != null) {
            sb.append(", valid_time=");
            sb.append(this.valid_time);
        }
        if (this.update_time != null) {
            sb.append(", update_time=");
            sb.append(this.update_time);
        }
        if (this.topup_channel_id != null) {
            sb.append(", topup_channel_id=");
            sb.append(this.topup_channel_id);
        }
        if (this.topup_channel_txn_id != null) {
            sb.append(", topup_channel_txn_id=");
            sb.append(this.topup_channel_txn_id);
        }
        if (this.topup_account_id != null) {
            sb.append(", topup_account_id=");
            sb.append(this.topup_account_id);
        }
        if (this.payment_channel_id != null) {
            sb.append(", payment_channel_id=");
            sb.append(this.payment_channel_id);
        }
        if (this.payment_channel_txn_id != null) {
            sb.append(", payment_channel_txn_id=");
            sb.append(this.payment_channel_txn_id);
        }
        if (this.payment_account_id != null) {
            sb.append(", payment_account_id=");
            sb.append(this.payment_account_id);
        }
        if (this.item_id != null) {
            sb.append(", item_id=");
            sb.append(this.item_id);
        }
        if (this.item_amount != null) {
            sb.append(", item_amount=");
            sb.append(this.item_amount);
        }
        if (this.item_name != null) {
            sb.append(", item_name=");
            sb.append(this.item_name);
        }
        if (this.item_image != null) {
            sb.append(", item_image=");
            sb.append(this.item_image);
        }
        if (this.topup_txn_id != null) {
            sb.append(", topup_txn_id=");
            sb.append(this.topup_txn_id);
        }
        if (this.payment_txn_id != null) {
            sb.append(", payment_txn_id=");
            sb.append(this.payment_txn_id);
        }
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (this.event_id != null) {
            sb.append(", event_id=");
            sb.append(this.event_id);
        }
        if (this.topup_payable_amount != null) {
            sb.append(", topup_payable_amount=");
            sb.append(this.topup_payable_amount);
        }
        if (this.payment_payable_amount != null) {
            sb.append(", payment_payable_amount=");
            sb.append(this.payment_payable_amount);
        }
        if (this.topup_cash_amount != null) {
            sb.append(", topup_cash_amount=");
            sb.append(this.topup_cash_amount);
        }
        if (this.payment_cash_amount != null) {
            sb.append(", payment_cash_amount=");
            sb.append(this.payment_cash_amount);
        }
        if (this.order_refund != null) {
            sb.append(", order_refund=");
            sb.append(this.order_refund);
        }
        StringBuilder replace = sb.replace(0, 2, "OrderProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OrderProto, Builder> {
        public Integer create_time;
        public String currency;
        public Long currency_amount;
        public Long event_id;
        public Integer expired_time;
        public String extra_data;
        public Integer item_amount;
        public String item_id;
        public String item_image;
        public String item_name;
        public Long order_id;
        public OrderRefundProto order_refund;
        public String payment_account_id;
        public Long payment_cash_amount;
        public Integer payment_channel_id;
        public String payment_channel_txn_id;
        public Long payment_payable_amount;
        public Long payment_txn_id;
        public Integer status;
        public String topup_account_id;
        public Long topup_cash_amount;
        public Integer topup_channel_id;
        public String topup_channel_txn_id;
        public Long topup_payable_amount;
        public Long topup_txn_id;
        public Integer type;
        public Integer update_time;
        public Integer valid_time;

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder currency_amount(Long l) {
            this.currency_amount = l;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder expired_time(Integer num) {
            this.expired_time = num;
            return this;
        }

        public Builder valid_time(Integer num) {
            this.valid_time = num;
            return this;
        }

        public Builder update_time(Integer num) {
            this.update_time = num;
            return this;
        }

        public Builder topup_channel_id(Integer num) {
            this.topup_channel_id = num;
            return this;
        }

        public Builder topup_channel_txn_id(String str) {
            this.topup_channel_txn_id = str;
            return this;
        }

        public Builder topup_account_id(String str) {
            this.topup_account_id = str;
            return this;
        }

        public Builder payment_channel_id(Integer num) {
            this.payment_channel_id = num;
            return this;
        }

        public Builder payment_channel_txn_id(String str) {
            this.payment_channel_txn_id = str;
            return this;
        }

        public Builder payment_account_id(String str) {
            this.payment_account_id = str;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public Builder item_amount(Integer num) {
            this.item_amount = num;
            return this;
        }

        public Builder item_name(String str) {
            this.item_name = str;
            return this;
        }

        public Builder item_image(String str) {
            this.item_image = str;
            return this;
        }

        public Builder topup_txn_id(Long l) {
            this.topup_txn_id = l;
            return this;
        }

        public Builder payment_txn_id(Long l) {
            this.payment_txn_id = l;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder event_id(Long l) {
            this.event_id = l;
            return this;
        }

        public Builder topup_payable_amount(Long l) {
            this.topup_payable_amount = l;
            return this;
        }

        public Builder payment_payable_amount(Long l) {
            this.payment_payable_amount = l;
            return this;
        }

        public Builder topup_cash_amount(Long l) {
            this.topup_cash_amount = l;
            return this;
        }

        public Builder payment_cash_amount(Long l) {
            this.payment_cash_amount = l;
            return this;
        }

        public Builder order_refund(OrderRefundProto orderRefundProto) {
            this.order_refund = orderRefundProto;
            return this;
        }

        public OrderProto build() {
            return new OrderProto(this.order_id, this.type, this.status, this.currency, this.currency_amount, this.create_time, this.expired_time, this.valid_time, this.update_time, this.topup_channel_id, this.topup_channel_txn_id, this.topup_account_id, this.payment_channel_id, this.payment_channel_txn_id, this.payment_account_id, this.item_id, this.item_amount, this.item_name, this.item_image, this.topup_txn_id, this.payment_txn_id, this.extra_data, this.event_id, this.topup_payable_amount, this.payment_payable_amount, this.topup_cash_amount, this.payment_cash_amount, this.order_refund, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_OrderProto extends ProtoAdapter<OrderProto> {
        ProtoAdapter_OrderProto() {
            super(FieldEncoding.LENGTH_DELIMITED, OrderProto.class);
        }

        public int encodedSize(OrderProto orderProto) {
            int i = 0;
            int encodedSizeWithTag = (orderProto.order_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(1, orderProto.order_id) : 0) + (orderProto.type != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, orderProto.type) : 0) + (orderProto.status != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, orderProto.status) : 0) + (orderProto.currency != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, orderProto.currency) : 0) + (orderProto.currency_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(5, orderProto.currency_amount) : 0) + (orderProto.create_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(6, orderProto.create_time) : 0) + (orderProto.expired_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(7, orderProto.expired_time) : 0) + (orderProto.valid_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(8, orderProto.valid_time) : 0) + (orderProto.update_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(9, orderProto.update_time) : 0) + (orderProto.topup_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(10, orderProto.topup_channel_id) : 0) + (orderProto.topup_channel_txn_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, orderProto.topup_channel_txn_id) : 0) + (orderProto.topup_account_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, orderProto.topup_account_id) : 0) + (orderProto.payment_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(13, orderProto.payment_channel_id) : 0) + (orderProto.payment_channel_txn_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, orderProto.payment_channel_txn_id) : 0) + (orderProto.payment_account_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(15, orderProto.payment_account_id) : 0) + (orderProto.item_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(16, orderProto.item_id) : 0) + (orderProto.item_amount != null ? ProtoAdapter.UINT32.encodedSizeWithTag(17, orderProto.item_amount) : 0) + (orderProto.item_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(18, orderProto.item_name) : 0) + (orderProto.item_image != null ? ProtoAdapter.STRING.encodedSizeWithTag(19, orderProto.item_image) : 0) + (orderProto.topup_txn_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(20, orderProto.topup_txn_id) : 0) + (orderProto.payment_txn_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(21, orderProto.payment_txn_id) : 0) + (orderProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(22, orderProto.extra_data) : 0) + (orderProto.event_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(23, orderProto.event_id) : 0) + (orderProto.topup_payable_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(24, orderProto.topup_payable_amount) : 0) + (orderProto.payment_payable_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(25, orderProto.payment_payable_amount) : 0) + (orderProto.topup_cash_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(26, orderProto.topup_cash_amount) : 0) + (orderProto.payment_cash_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(27, orderProto.payment_cash_amount) : 0);
            if (orderProto.order_refund != null) {
                i = OrderRefundProto.ADAPTER.encodedSizeWithTag(28, orderProto.order_refund);
            }
            return encodedSizeWithTag + i + orderProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, OrderProto orderProto) throws IOException {
            if (orderProto.order_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, orderProto.order_id);
            }
            if (orderProto.type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, orderProto.type);
            }
            if (orderProto.status != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, orderProto.status);
            }
            if (orderProto.currency != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, orderProto.currency);
            }
            if (orderProto.currency_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 5, orderProto.currency_amount);
            }
            if (orderProto.create_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 6, orderProto.create_time);
            }
            if (orderProto.expired_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 7, orderProto.expired_time);
            }
            if (orderProto.valid_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 8, orderProto.valid_time);
            }
            if (orderProto.update_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 9, orderProto.update_time);
            }
            if (orderProto.topup_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 10, orderProto.topup_channel_id);
            }
            if (orderProto.topup_channel_txn_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, orderProto.topup_channel_txn_id);
            }
            if (orderProto.topup_account_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, orderProto.topup_account_id);
            }
            if (orderProto.payment_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 13, orderProto.payment_channel_id);
            }
            if (orderProto.payment_channel_txn_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, orderProto.payment_channel_txn_id);
            }
            if (orderProto.payment_account_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, orderProto.payment_account_id);
            }
            if (orderProto.item_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, orderProto.item_id);
            }
            if (orderProto.item_amount != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 17, orderProto.item_amount);
            }
            if (orderProto.item_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, orderProto.item_name);
            }
            if (orderProto.item_image != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 19, orderProto.item_image);
            }
            if (orderProto.topup_txn_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 20, orderProto.topup_txn_id);
            }
            if (orderProto.payment_txn_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 21, orderProto.payment_txn_id);
            }
            if (orderProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 22, orderProto.extra_data);
            }
            if (orderProto.event_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 23, orderProto.event_id);
            }
            if (orderProto.topup_payable_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 24, orderProto.topup_payable_amount);
            }
            if (orderProto.payment_payable_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 25, orderProto.payment_payable_amount);
            }
            if (orderProto.topup_cash_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 26, orderProto.topup_cash_amount);
            }
            if (orderProto.payment_cash_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 27, orderProto.payment_cash_amount);
            }
            if (orderProto.order_refund != null) {
                OrderRefundProto.ADAPTER.encodeWithTag(protoWriter, 28, orderProto.order_refund);
            }
            protoWriter.writeBytes(orderProto.unknownFields());
        }

        public OrderProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.order_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 2:
                            builder.type(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 3:
                            builder.status(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 4:
                            builder.currency(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.currency_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 6:
                            builder.create_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 7:
                            builder.expired_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 8:
                            builder.valid_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 9:
                            builder.update_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 10:
                            builder.topup_channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 11:
                            builder.topup_channel_txn_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 12:
                            builder.topup_account_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.payment_channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 14:
                            builder.payment_channel_txn_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 15:
                            builder.payment_account_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            builder.item_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            builder.item_amount(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 18:
                            builder.item_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            builder.item_image(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 20:
                            builder.topup_txn_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 21:
                            builder.payment_txn_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 22:
                            builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 23:
                            builder.event_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 24:
                            builder.topup_payable_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 25:
                            builder.payment_payable_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 26:
                            builder.topup_cash_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 27:
                            builder.payment_cash_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 28:
                            builder.order_refund(OrderRefundProto.ADAPTER.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public OrderProto redact(OrderProto orderProto) {
            Builder newBuilder = orderProto.newBuilder();
            if (newBuilder.order_refund != null) {
                newBuilder.order_refund = OrderRefundProto.ADAPTER.redact(newBuilder.order_refund);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
