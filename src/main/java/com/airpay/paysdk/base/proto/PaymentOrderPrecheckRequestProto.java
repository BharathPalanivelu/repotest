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

public final class PaymentOrderPrecheckRequestProto extends Message<PaymentOrderPrecheckRequestProto, Builder> {
    public static final ProtoAdapter<PaymentOrderPrecheckRequestProto> ADAPTER = new ProtoAdapter_PaymentOrderPrecheckRequestProto();
    public static final String DEFAULT_ACCOUNT_ID = "";
    public static final Long DEFAULT_BANK_ACCOUNT_ID = 0L;
    public static final String DEFAULT_CURRENCY = "";
    public static final Long DEFAULT_CURRENCY_AMOUNT = 0L;
    public static final Long DEFAULT_EVENT_ID = 0L;
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Integer DEFAULT_ITEM_AMOUNT = 0;
    public static final String DEFAULT_ITEM_ID = "";
    public static final Integer DEFAULT_PAYMENT_CHANNEL_ID = 0;
    public static final String DEFAULT_PAYMENT_CHANNEL_TXN_ID = "";
    public static final Long DEFAULT_PAYMENT_PAYABLE_AMOUNT = 0L;
    public static final Integer DEFAULT_TOPUP_CHANNEL_ID = 0;
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
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 13)
    public final String extra_data;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer item_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String item_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer payment_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 15)
    public final String payment_channel_txn_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 12)
    public final Long payment_payable_amount;
    @WireField(adapter = "com.airpay.protocol.protobuf.ShoppingCartProto#ADAPTER", tag = 30)
    public final ShoppingCartProto shopping_cart;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer topup_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 11)
    public final Long topup_payable_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 14)
    public final Long welcome_gift_id;

    public PaymentOrderPrecheckRequestProto(PacketHeaderProto packetHeaderProto, ShoppingCartProto shoppingCartProto, Integer num, String str, Integer num2, String str2, String str3, Long l, Integer num3, Long l2, Long l3, Long l4, Long l5, String str4, Long l6, String str5) {
        this(packetHeaderProto, shoppingCartProto, num, str, num2, str2, str3, l, num3, l2, l3, l4, l5, str4, l6, str5, f.f32736b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentOrderPrecheckRequestProto(PacketHeaderProto packetHeaderProto, ShoppingCartProto shoppingCartProto, Integer num, String str, Integer num2, String str2, String str3, Long l, Integer num3, Long l2, Long l3, Long l4, Long l5, String str4, Long l6, String str5, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.shopping_cart = shoppingCartProto;
        this.payment_channel_id = num;
        this.item_id = str;
        this.item_amount = num2;
        this.account_id = str2;
        this.currency = str3;
        this.currency_amount = l;
        this.topup_channel_id = num3;
        this.bank_account_id = l2;
        this.event_id = l3;
        this.topup_payable_amount = l4;
        this.payment_payable_amount = l5;
        this.extra_data = str4;
        this.welcome_gift_id = l6;
        this.payment_channel_txn_id = str5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
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
        builder.extra_data = this.extra_data;
        builder.welcome_gift_id = this.welcome_gift_id;
        builder.payment_channel_txn_id = this.payment_channel_txn_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderPrecheckRequestProto)) {
            return false;
        }
        PaymentOrderPrecheckRequestProto paymentOrderPrecheckRequestProto = (PaymentOrderPrecheckRequestProto) obj;
        if (!unknownFields().equals(paymentOrderPrecheckRequestProto.unknownFields()) || !this.header.equals(paymentOrderPrecheckRequestProto.header) || !Internal.equals(this.shopping_cart, paymentOrderPrecheckRequestProto.shopping_cart) || !Internal.equals(this.payment_channel_id, paymentOrderPrecheckRequestProto.payment_channel_id) || !Internal.equals(this.item_id, paymentOrderPrecheckRequestProto.item_id) || !Internal.equals(this.item_amount, paymentOrderPrecheckRequestProto.item_amount) || !Internal.equals(this.account_id, paymentOrderPrecheckRequestProto.account_id) || !Internal.equals(this.currency, paymentOrderPrecheckRequestProto.currency) || !Internal.equals(this.currency_amount, paymentOrderPrecheckRequestProto.currency_amount) || !Internal.equals(this.topup_channel_id, paymentOrderPrecheckRequestProto.topup_channel_id) || !Internal.equals(this.bank_account_id, paymentOrderPrecheckRequestProto.bank_account_id) || !Internal.equals(this.event_id, paymentOrderPrecheckRequestProto.event_id) || !Internal.equals(this.topup_payable_amount, paymentOrderPrecheckRequestProto.topup_payable_amount) || !Internal.equals(this.payment_payable_amount, paymentOrderPrecheckRequestProto.payment_payable_amount) || !Internal.equals(this.extra_data, paymentOrderPrecheckRequestProto.extra_data) || !Internal.equals(this.welcome_gift_id, paymentOrderPrecheckRequestProto.welcome_gift_id) || !Internal.equals(this.payment_channel_txn_id, paymentOrderPrecheckRequestProto.payment_channel_txn_id)) {
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
        ShoppingCartProto shoppingCartProto = this.shopping_cart;
        int i2 = 0;
        int hashCode2 = (hashCode + (shoppingCartProto != null ? shoppingCartProto.hashCode() : 0)) * 37;
        Integer num = this.payment_channel_id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.item_id;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.item_amount;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.account_id;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.currency;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.currency_amount;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.topup_channel_id;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.bank_account_id;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.event_id;
        int hashCode11 = (hashCode10 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.topup_payable_amount;
        int hashCode12 = (hashCode11 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.payment_payable_amount;
        int hashCode13 = (hashCode12 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str4 = this.extra_data;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l6 = this.welcome_gift_id;
        int hashCode15 = (hashCode14 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str5 = this.payment_channel_txn_id;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
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
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (this.welcome_gift_id != null) {
            sb.append(", welcome_gift_id=");
            sb.append(this.welcome_gift_id);
        }
        if (this.payment_channel_txn_id != null) {
            sb.append(", payment_channel_txn_id=");
            sb.append(this.payment_channel_txn_id);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderPrecheckRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderPrecheckRequestProto, Builder> {
        public String account_id;
        public Long bank_account_id;
        public String currency;
        public Long currency_amount;
        public Long event_id;
        public String extra_data;
        public PacketHeaderProto header;
        public Integer item_amount;
        public String item_id;
        public Integer payment_channel_id;
        public String payment_channel_txn_id;
        public Long payment_payable_amount;
        public ShoppingCartProto shopping_cart;
        public Integer topup_channel_id;
        public Long topup_payable_amount;
        public Long welcome_gift_id;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
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

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder welcome_gift_id(Long l) {
            this.welcome_gift_id = l;
            return this;
        }

        public Builder payment_channel_txn_id(String str) {
            this.payment_channel_txn_id = str;
            return this;
        }

        public PaymentOrderPrecheckRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderPrecheckRequestProto(packetHeaderProto, this.shopping_cart, this.payment_channel_id, this.item_id, this.item_amount, this.account_id, this.currency, this.currency_amount, this.topup_channel_id, this.bank_account_id, this.event_id, this.topup_payable_amount, this.payment_payable_amount, this.extra_data, this.welcome_gift_id, this.payment_channel_txn_id, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderPrecheckRequestProto extends ProtoAdapter<PaymentOrderPrecheckRequestProto> {
        ProtoAdapter_PaymentOrderPrecheckRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderPrecheckRequestProto.class);
        }

        public int encodedSize(PaymentOrderPrecheckRequestProto paymentOrderPrecheckRequestProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderPrecheckRequestProto.header) + (paymentOrderPrecheckRequestProto.shopping_cart != null ? ShoppingCartProto.ADAPTER.encodedSizeWithTag(30, paymentOrderPrecheckRequestProto.shopping_cart) : 0) + (paymentOrderPrecheckRequestProto.payment_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, paymentOrderPrecheckRequestProto.payment_channel_id) : 0) + (paymentOrderPrecheckRequestProto.item_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, paymentOrderPrecheckRequestProto.item_id) : 0) + (paymentOrderPrecheckRequestProto.item_amount != null ? ProtoAdapter.UINT32.encodedSizeWithTag(4, paymentOrderPrecheckRequestProto.item_amount) : 0) + (paymentOrderPrecheckRequestProto.account_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, paymentOrderPrecheckRequestProto.account_id) : 0) + (paymentOrderPrecheckRequestProto.currency != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, paymentOrderPrecheckRequestProto.currency) : 0) + (paymentOrderPrecheckRequestProto.currency_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(7, paymentOrderPrecheckRequestProto.currency_amount) : 0) + (paymentOrderPrecheckRequestProto.topup_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(8, paymentOrderPrecheckRequestProto.topup_channel_id) : 0) + (paymentOrderPrecheckRequestProto.bank_account_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(9, paymentOrderPrecheckRequestProto.bank_account_id) : 0) + (paymentOrderPrecheckRequestProto.event_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(10, paymentOrderPrecheckRequestProto.event_id) : 0) + (paymentOrderPrecheckRequestProto.topup_payable_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(11, paymentOrderPrecheckRequestProto.topup_payable_amount) : 0) + (paymentOrderPrecheckRequestProto.payment_payable_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(12, paymentOrderPrecheckRequestProto.payment_payable_amount) : 0) + (paymentOrderPrecheckRequestProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, paymentOrderPrecheckRequestProto.extra_data) : 0) + (paymentOrderPrecheckRequestProto.welcome_gift_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(14, paymentOrderPrecheckRequestProto.welcome_gift_id) : 0);
            if (paymentOrderPrecheckRequestProto.payment_channel_txn_id != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(15, paymentOrderPrecheckRequestProto.payment_channel_txn_id);
            }
            return encodedSizeWithTag + i + paymentOrderPrecheckRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderPrecheckRequestProto paymentOrderPrecheckRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderPrecheckRequestProto.header);
            if (paymentOrderPrecheckRequestProto.shopping_cart != null) {
                ShoppingCartProto.ADAPTER.encodeWithTag(protoWriter, 30, paymentOrderPrecheckRequestProto.shopping_cart);
            }
            if (paymentOrderPrecheckRequestProto.payment_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, paymentOrderPrecheckRequestProto.payment_channel_id);
            }
            if (paymentOrderPrecheckRequestProto.item_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, paymentOrderPrecheckRequestProto.item_id);
            }
            if (paymentOrderPrecheckRequestProto.item_amount != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, paymentOrderPrecheckRequestProto.item_amount);
            }
            if (paymentOrderPrecheckRequestProto.account_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, paymentOrderPrecheckRequestProto.account_id);
            }
            if (paymentOrderPrecheckRequestProto.currency != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, paymentOrderPrecheckRequestProto.currency);
            }
            if (paymentOrderPrecheckRequestProto.currency_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 7, paymentOrderPrecheckRequestProto.currency_amount);
            }
            if (paymentOrderPrecheckRequestProto.topup_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 8, paymentOrderPrecheckRequestProto.topup_channel_id);
            }
            if (paymentOrderPrecheckRequestProto.bank_account_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 9, paymentOrderPrecheckRequestProto.bank_account_id);
            }
            if (paymentOrderPrecheckRequestProto.event_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 10, paymentOrderPrecheckRequestProto.event_id);
            }
            if (paymentOrderPrecheckRequestProto.topup_payable_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 11, paymentOrderPrecheckRequestProto.topup_payable_amount);
            }
            if (paymentOrderPrecheckRequestProto.payment_payable_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 12, paymentOrderPrecheckRequestProto.payment_payable_amount);
            }
            if (paymentOrderPrecheckRequestProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, paymentOrderPrecheckRequestProto.extra_data);
            }
            if (paymentOrderPrecheckRequestProto.welcome_gift_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 14, paymentOrderPrecheckRequestProto.welcome_gift_id);
            }
            if (paymentOrderPrecheckRequestProto.payment_channel_txn_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, paymentOrderPrecheckRequestProto.payment_channel_txn_id);
            }
            protoWriter.writeBytes(paymentOrderPrecheckRequestProto.unknownFields());
        }

        public PaymentOrderPrecheckRequestProto decode(ProtoReader protoReader) throws IOException {
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
                            builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            builder.welcome_gift_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 15:
                            builder.payment_channel_txn_id(ProtoAdapter.STRING.decode(protoReader));
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

        public PaymentOrderPrecheckRequestProto redact(PaymentOrderPrecheckRequestProto paymentOrderPrecheckRequestProto) {
            Builder newBuilder = paymentOrderPrecheckRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            if (newBuilder.shopping_cart != null) {
                newBuilder.shopping_cart = ShoppingCartProto.ADAPTER.redact(newBuilder.shopping_cart);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
