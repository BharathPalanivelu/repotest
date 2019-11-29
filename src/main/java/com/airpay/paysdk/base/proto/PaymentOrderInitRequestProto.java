package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import e.f;
import java.io.IOException;

public final class PaymentOrderInitRequestProto extends Message<PaymentOrderInitRequestProto, Builder> {
    public static final ProtoAdapter<PaymentOrderInitRequestProto> ADAPTER = new ProtoAdapter_PaymentOrderInitRequestProto();
    public static final String DEFAULT_ACCOUNT_ID = "";
    public static final Long DEFAULT_BANK_ACCOUNT_ID = 0L;
    public static final String DEFAULT_CURRENCY = "";
    public static final Long DEFAULT_CURRENCY_AMOUNT = 0L;
    public static final Long DEFAULT_EVENT_ID = 0L;
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Integer DEFAULT_GIFT_TYPE = 0;
    public static final Integer DEFAULT_ITEM_AMOUNT = 0;
    public static final String DEFAULT_ITEM_ID = "";
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_PAYMENT_CHANNEL_ID = 0;
    public static final String DEFAULT_PAYMENT_CHANNEL_TXN_ID = "";
    public static final Long DEFAULT_PAYMENT_PAYABLE_AMOUNT = 0L;
    public static final Long DEFAULT_TOPUP_CASH_AMOUNT = 0L;
    public static final Integer DEFAULT_TOPUP_CHANNEL_ID = 0;
    public static final String DEFAULT_TOPUP_CHANNEL_TXN_ID = "";
    public static final Long DEFAULT_TOPUP_PAYABLE_AMOUNT = 0L;
    public static final Long DEFAULT_WELCOME_GIFT_ID = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 5)
    public final String account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 9)
    public final Long bank_account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 6)
    public final String currency;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 7)
    public final Long currency_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 10)
    public final Long event_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 15)
    public final String extra_data;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 17)
    public final Integer gift_type;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer item_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String item_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 14)
    public final String key;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer payment_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 13)
    public final String payment_channel_txn_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 12)
    public final Long payment_payable_amount;
    @WireField(adapter = "com.airpay.protocol.protobuf.ShoppingCartProto#ADAPTER", tag = 30)
    public final ShoppingCartProto shopping_cart;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 16)
    public final Long topup_cash_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer topup_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 18)
    public final String topup_channel_txn_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 11)
    public final Long topup_payable_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 19)
    public final Long welcome_gift_id;

    public PaymentOrderInitRequestProto(PacketHeaderProto packetHeaderProto, Integer num, ShoppingCartProto shoppingCartProto, Integer num2, String str, Integer num3, String str2, String str3, Long l, Integer num4, Long l2, Long l3, Long l4, Long l5, String str4, String str5, String str6, Long l6, String str7, Long l7) {
        this(packetHeaderProto, num, shoppingCartProto, num2, str, num3, str2, str3, l, num4, l2, l3, l4, l5, str4, str5, str6, l6, str7, l7, f.f32736b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentOrderInitRequestProto(PacketHeaderProto packetHeaderProto, Integer num, ShoppingCartProto shoppingCartProto, Integer num2, String str, Integer num3, String str2, String str3, Long l, Integer num4, Long l2, Long l3, Long l4, Long l5, String str4, String str5, String str6, Long l6, String str7, Long l7, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.gift_type = num;
        this.shopping_cart = shoppingCartProto;
        this.payment_channel_id = num2;
        this.item_id = str;
        this.item_amount = num3;
        this.account_id = str2;
        this.currency = str3;
        this.currency_amount = l;
        this.topup_channel_id = num4;
        this.bank_account_id = l2;
        this.event_id = l3;
        this.topup_payable_amount = l4;
        this.payment_payable_amount = l5;
        this.payment_channel_txn_id = str4;
        this.key = str5;
        this.extra_data = str6;
        this.topup_cash_amount = l6;
        this.topup_channel_txn_id = str7;
        this.welcome_gift_id = l7;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.gift_type = this.gift_type;
        builder.shopping_cart = this.shopping_cart;
        builder.payment_channel_id = this.payment_channel_id;
        builder.item_id = this.item_id;
        builder.item_amount = this.item_amount;
        builder.account_id = this.account_id;
        builder.currency = this.currency;
        builder.currency_amount = this.currency_amount;
        builder.topup_channel_id = this.topup_channel_id;
        builder.bank_account_id = this.bank_account_id;
        builder.event_id = this.event_id;
        builder.topup_payable_amount = this.topup_payable_amount;
        builder.payment_payable_amount = this.payment_payable_amount;
        builder.payment_channel_txn_id = this.payment_channel_txn_id;
        builder.key = this.key;
        builder.extra_data = this.extra_data;
        builder.topup_cash_amount = this.topup_cash_amount;
        builder.topup_channel_txn_id = this.topup_channel_txn_id;
        builder.welcome_gift_id = this.welcome_gift_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderInitRequestProto)) {
            return false;
        }
        PaymentOrderInitRequestProto paymentOrderInitRequestProto = (PaymentOrderInitRequestProto) obj;
        if (!unknownFields().equals(paymentOrderInitRequestProto.unknownFields()) || !this.header.equals(paymentOrderInitRequestProto.header) || !Internal.equals(this.gift_type, paymentOrderInitRequestProto.gift_type) || !Internal.equals(this.shopping_cart, paymentOrderInitRequestProto.shopping_cart) || !Internal.equals(this.payment_channel_id, paymentOrderInitRequestProto.payment_channel_id) || !Internal.equals(this.item_id, paymentOrderInitRequestProto.item_id) || !Internal.equals(this.item_amount, paymentOrderInitRequestProto.item_amount) || !Internal.equals(this.account_id, paymentOrderInitRequestProto.account_id) || !Internal.equals(this.currency, paymentOrderInitRequestProto.currency) || !Internal.equals(this.currency_amount, paymentOrderInitRequestProto.currency_amount) || !Internal.equals(this.topup_channel_id, paymentOrderInitRequestProto.topup_channel_id) || !Internal.equals(this.bank_account_id, paymentOrderInitRequestProto.bank_account_id) || !Internal.equals(this.event_id, paymentOrderInitRequestProto.event_id) || !Internal.equals(this.topup_payable_amount, paymentOrderInitRequestProto.topup_payable_amount) || !Internal.equals(this.payment_payable_amount, paymentOrderInitRequestProto.payment_payable_amount) || !Internal.equals(this.payment_channel_txn_id, paymentOrderInitRequestProto.payment_channel_txn_id) || !Internal.equals(this.key, paymentOrderInitRequestProto.key) || !Internal.equals(this.extra_data, paymentOrderInitRequestProto.extra_data) || !Internal.equals(this.topup_cash_amount, paymentOrderInitRequestProto.topup_cash_amount) || !Internal.equals(this.topup_channel_txn_id, paymentOrderInitRequestProto.topup_channel_txn_id) || !Internal.equals(this.welcome_gift_id, paymentOrderInitRequestProto.welcome_gift_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37;
        Integer num = this.gift_type;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        ShoppingCartProto shoppingCartProto = this.shopping_cart;
        int hashCode3 = (hashCode2 + (shoppingCartProto != null ? shoppingCartProto.hashCode() : 0)) * 37;
        Integer num2 = this.payment_channel_id;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.item_id;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.item_amount;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.account_id;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.currency;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.currency_amount;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num4 = this.topup_channel_id;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.bank_account_id;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.event_id;
        int hashCode12 = (hashCode11 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.topup_payable_amount;
        int hashCode13 = (hashCode12 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.payment_payable_amount;
        int hashCode14 = (hashCode13 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str4 = this.payment_channel_txn_id;
        int hashCode15 = (hashCode14 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.key;
        int hashCode16 = (hashCode15 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.extra_data;
        int hashCode17 = (hashCode16 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Long l6 = this.topup_cash_amount;
        int hashCode18 = (hashCode17 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str7 = this.topup_channel_txn_id;
        int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Long l7 = this.welcome_gift_id;
        if (l7 != null) {
            i2 = l7.hashCode();
        }
        int i3 = hashCode19 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.gift_type != null) {
            sb.append(", gift_type=");
            sb.append(this.gift_type);
        }
        if (this.shopping_cart != null) {
            sb.append(", shopping_cart=");
            sb.append(this.shopping_cart);
        }
        if (this.payment_channel_id != null) {
            sb.append(", payment_channel_id=");
            sb.append(this.payment_channel_id);
        }
        if (this.item_id != null) {
            sb.append(", item_id=");
            sb.append(this.item_id);
        }
        if (this.item_amount != null) {
            sb.append(", item_amount=");
            sb.append(this.item_amount);
        }
        if (this.account_id != null) {
            sb.append(", account_id=");
            sb.append(this.account_id);
        }
        if (this.currency != null) {
            sb.append(", currency=");
            sb.append(this.currency);
        }
        if (this.currency_amount != null) {
            sb.append(", currency_amount=");
            sb.append(this.currency_amount);
        }
        if (this.topup_channel_id != null) {
            sb.append(", topup_channel_id=");
            sb.append(this.topup_channel_id);
        }
        if (this.bank_account_id != null) {
            sb.append(", bank_account_id=");
            sb.append(this.bank_account_id);
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
        if (this.payment_channel_txn_id != null) {
            sb.append(", payment_channel_txn_id=");
            sb.append(this.payment_channel_txn_id);
        }
        if (this.key != null) {
            sb.append(", key=");
            sb.append(this.key);
        }
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (this.topup_cash_amount != null) {
            sb.append(", topup_cash_amount=");
            sb.append(this.topup_cash_amount);
        }
        if (this.topup_channel_txn_id != null) {
            sb.append(", topup_channel_txn_id=");
            sb.append(this.topup_channel_txn_id);
        }
        if (this.welcome_gift_id != null) {
            sb.append(", welcome_gift_id=");
            sb.append(this.welcome_gift_id);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderInitRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderInitRequestProto, Builder> {
        public String account_id;
        public Long bank_account_id;
        public String currency;
        public Long currency_amount;
        public Long event_id;
        public String extra_data;
        public Integer gift_type;
        public PacketHeaderProto header;
        public Integer item_amount;
        public String item_id;
        public String key;
        public Integer payment_channel_id;
        public String payment_channel_txn_id;
        public Long payment_payable_amount;
        public ShoppingCartProto shopping_cart;
        public Long topup_cash_amount;
        public Integer topup_channel_id;
        public String topup_channel_txn_id;
        public Long topup_payable_amount;
        public Long welcome_gift_id;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder gift_type(Integer num) {
            this.gift_type = num;
            return this;
        }

        public Builder shopping_cart(ShoppingCartProto shoppingCartProto) {
            this.shopping_cart = shoppingCartProto;
            return this;
        }

        public Builder payment_channel_id(Integer num) {
            this.payment_channel_id = num;
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

        public Builder account_id(String str) {
            this.account_id = str;
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

        public Builder topup_channel_id(Integer num) {
            this.topup_channel_id = num;
            return this;
        }

        public Builder bank_account_id(Long l) {
            this.bank_account_id = l;
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

        public Builder payment_channel_txn_id(String str) {
            this.payment_channel_txn_id = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder topup_cash_amount(Long l) {
            this.topup_cash_amount = l;
            return this;
        }

        public Builder topup_channel_txn_id(String str) {
            this.topup_channel_txn_id = str;
            return this;
        }

        public Builder welcome_gift_id(Long l) {
            this.welcome_gift_id = l;
            return this;
        }

        public PaymentOrderInitRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderInitRequestProto(packetHeaderProto, this.gift_type, this.shopping_cart, this.payment_channel_id, this.item_id, this.item_amount, this.account_id, this.currency, this.currency_amount, this.topup_channel_id, this.bank_account_id, this.event_id, this.topup_payable_amount, this.payment_payable_amount, this.payment_channel_txn_id, this.key, this.extra_data, this.topup_cash_amount, this.topup_channel_txn_id, this.welcome_gift_id, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderInitRequestProto extends ProtoAdapter<PaymentOrderInitRequestProto> {
        ProtoAdapter_PaymentOrderInitRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderInitRequestProto.class);
        }

        public int encodedSize(PaymentOrderInitRequestProto paymentOrderInitRequestProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderInitRequestProto.header) + (paymentOrderInitRequestProto.gift_type != null ? ProtoAdapter.UINT32.encodedSizeWithTag(17, paymentOrderInitRequestProto.gift_type) : 0) + (paymentOrderInitRequestProto.shopping_cart != null ? ShoppingCartProto.ADAPTER.encodedSizeWithTag(30, paymentOrderInitRequestProto.shopping_cart) : 0) + (paymentOrderInitRequestProto.payment_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, paymentOrderInitRequestProto.payment_channel_id) : 0) + (paymentOrderInitRequestProto.item_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, paymentOrderInitRequestProto.item_id) : 0) + (paymentOrderInitRequestProto.item_amount != null ? ProtoAdapter.UINT32.encodedSizeWithTag(4, paymentOrderInitRequestProto.item_amount) : 0) + (paymentOrderInitRequestProto.account_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, paymentOrderInitRequestProto.account_id) : 0) + (paymentOrderInitRequestProto.currency != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, paymentOrderInitRequestProto.currency) : 0) + (paymentOrderInitRequestProto.currency_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(7, paymentOrderInitRequestProto.currency_amount) : 0) + (paymentOrderInitRequestProto.topup_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(8, paymentOrderInitRequestProto.topup_channel_id) : 0) + (paymentOrderInitRequestProto.bank_account_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(9, paymentOrderInitRequestProto.bank_account_id) : 0) + (paymentOrderInitRequestProto.event_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(10, paymentOrderInitRequestProto.event_id) : 0) + (paymentOrderInitRequestProto.topup_payable_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(11, paymentOrderInitRequestProto.topup_payable_amount) : 0) + (paymentOrderInitRequestProto.payment_payable_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(12, paymentOrderInitRequestProto.payment_payable_amount) : 0) + (paymentOrderInitRequestProto.payment_channel_txn_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, paymentOrderInitRequestProto.payment_channel_txn_id) : 0) + (paymentOrderInitRequestProto.key != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, paymentOrderInitRequestProto.key) : 0) + (paymentOrderInitRequestProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(15, paymentOrderInitRequestProto.extra_data) : 0) + (paymentOrderInitRequestProto.topup_cash_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(16, paymentOrderInitRequestProto.topup_cash_amount) : 0) + (paymentOrderInitRequestProto.topup_channel_txn_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(18, paymentOrderInitRequestProto.topup_channel_txn_id) : 0);
            if (paymentOrderInitRequestProto.welcome_gift_id != null) {
                i = ProtoAdapter.UINT64.encodedSizeWithTag(19, paymentOrderInitRequestProto.welcome_gift_id);
            }
            return encodedSizeWithTag + i + paymentOrderInitRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderInitRequestProto paymentOrderInitRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderInitRequestProto.header);
            if (paymentOrderInitRequestProto.gift_type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 17, paymentOrderInitRequestProto.gift_type);
            }
            if (paymentOrderInitRequestProto.shopping_cart != null) {
                ShoppingCartProto.ADAPTER.encodeWithTag(protoWriter, 30, paymentOrderInitRequestProto.shopping_cart);
            }
            if (paymentOrderInitRequestProto.payment_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, paymentOrderInitRequestProto.payment_channel_id);
            }
            if (paymentOrderInitRequestProto.item_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, paymentOrderInitRequestProto.item_id);
            }
            if (paymentOrderInitRequestProto.item_amount != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, paymentOrderInitRequestProto.item_amount);
            }
            if (paymentOrderInitRequestProto.account_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, paymentOrderInitRequestProto.account_id);
            }
            if (paymentOrderInitRequestProto.currency != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, paymentOrderInitRequestProto.currency);
            }
            if (paymentOrderInitRequestProto.currency_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 7, paymentOrderInitRequestProto.currency_amount);
            }
            if (paymentOrderInitRequestProto.topup_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 8, paymentOrderInitRequestProto.topup_channel_id);
            }
            if (paymentOrderInitRequestProto.bank_account_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 9, paymentOrderInitRequestProto.bank_account_id);
            }
            if (paymentOrderInitRequestProto.event_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 10, paymentOrderInitRequestProto.event_id);
            }
            if (paymentOrderInitRequestProto.topup_payable_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 11, paymentOrderInitRequestProto.topup_payable_amount);
            }
            if (paymentOrderInitRequestProto.payment_payable_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 12, paymentOrderInitRequestProto.payment_payable_amount);
            }
            if (paymentOrderInitRequestProto.payment_channel_txn_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, paymentOrderInitRequestProto.payment_channel_txn_id);
            }
            if (paymentOrderInitRequestProto.key != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, paymentOrderInitRequestProto.key);
            }
            if (paymentOrderInitRequestProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, paymentOrderInitRequestProto.extra_data);
            }
            if (paymentOrderInitRequestProto.topup_cash_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 16, paymentOrderInitRequestProto.topup_cash_amount);
            }
            if (paymentOrderInitRequestProto.topup_channel_txn_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, paymentOrderInitRequestProto.topup_channel_txn_id);
            }
            if (paymentOrderInitRequestProto.welcome_gift_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 19, paymentOrderInitRequestProto.welcome_gift_id);
            }
            protoWriter.writeBytes(paymentOrderInitRequestProto.unknownFields());
        }

        public PaymentOrderInitRequestProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 30) {
                    switch (nextTag) {
                        case 1:
                            builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.payment_channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 3:
                            builder.item_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.item_amount(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 5:
                            builder.account_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.currency(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.currency_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 8:
                            builder.topup_channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 9:
                            builder.bank_account_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 10:
                            builder.event_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 11:
                            builder.topup_payable_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 12:
                            builder.payment_payable_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 13:
                            builder.payment_channel_txn_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            builder.key(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 15:
                            builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            builder.topup_cash_amount(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 17:
                            builder.gift_type(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 18:
                            builder.topup_channel_txn_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            builder.welcome_gift_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    builder.shopping_cart(ShoppingCartProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public PaymentOrderInitRequestProto redact(PaymentOrderInitRequestProto paymentOrderInitRequestProto) {
            Builder newBuilder = paymentOrderInitRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            if (newBuilder.shopping_cart != null) {
                newBuilder.shopping_cart = ShoppingCartProto.ADAPTER.redact(newBuilder.shopping_cart);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
