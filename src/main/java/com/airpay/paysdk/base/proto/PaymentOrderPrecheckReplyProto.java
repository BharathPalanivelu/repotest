package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import com.facebook.places.model.PlaceFields;
import e.f;
import java.io.IOException;
import java.util.List;

public final class PaymentOrderPrecheckReplyProto extends Message<PaymentOrderPrecheckReplyProto, Builder> {
    public static final ProtoAdapter<PaymentOrderPrecheckReplyProto> ADAPTER = new ProtoAdapter_PaymentOrderPrecheckReplyProto();
    public static final String DEFAULT_ADD_BANK_CARD_MESSAGE = "";
    public static final Integer DEFAULT_ALLOWED_AUTH_METHODS = 0;
    public static final Boolean DEFAULT_ALLOW_PARTIAL_PAYMENT = false;
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Boolean DEFAULT_SHOW_ADD_BANK_CARD = false;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 8)
    public final String add_bank_card_message;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean allow_partial_payment;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer allowed_auth_methods;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String extra_data;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.protocol.protobuf.TopupInfoProto#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<TopupInfoProto> payment_options;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean show_add_bank_card;
    @WireField(adapter = "com.airpay.protocol.protobuf.TopupInfoProto#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<TopupInfoProto> unavailable_payment_options;

    public PaymentOrderPrecheckReplyProto(PacketHeaderProto packetHeaderProto, String str, Integer num, List<TopupInfoProto> list, Boolean bool, List<TopupInfoProto> list2, Boolean bool2, String str2) {
        this(packetHeaderProto, str, num, list, bool, list2, bool2, str2, f.f32736b);
    }

    public PaymentOrderPrecheckReplyProto(PacketHeaderProto packetHeaderProto, String str, Integer num, List<TopupInfoProto> list, Boolean bool, List<TopupInfoProto> list2, Boolean bool2, String str2, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.extra_data = str;
        this.allowed_auth_methods = num;
        this.payment_options = Internal.immutableCopyOf(PlaceFields.PAYMENT_OPTIONS, list);
        this.allow_partial_payment = bool;
        this.unavailable_payment_options = Internal.immutableCopyOf("unavailable_payment_options", list2);
        this.show_add_bank_card = bool2;
        this.add_bank_card_message = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.extra_data = this.extra_data;
        builder.allowed_auth_methods = this.allowed_auth_methods;
        builder.payment_options = Internal.copyOf(PlaceFields.PAYMENT_OPTIONS, this.payment_options);
        builder.allow_partial_payment = this.allow_partial_payment;
        builder.unavailable_payment_options = Internal.copyOf("unavailable_payment_options", this.unavailable_payment_options);
        builder.show_add_bank_card = this.show_add_bank_card;
        builder.add_bank_card_message = this.add_bank_card_message;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderPrecheckReplyProto)) {
            return false;
        }
        PaymentOrderPrecheckReplyProto paymentOrderPrecheckReplyProto = (PaymentOrderPrecheckReplyProto) obj;
        if (!unknownFields().equals(paymentOrderPrecheckReplyProto.unknownFields()) || !this.header.equals(paymentOrderPrecheckReplyProto.header) || !Internal.equals(this.extra_data, paymentOrderPrecheckReplyProto.extra_data) || !Internal.equals(this.allowed_auth_methods, paymentOrderPrecheckReplyProto.allowed_auth_methods) || !this.payment_options.equals(paymentOrderPrecheckReplyProto.payment_options) || !Internal.equals(this.allow_partial_payment, paymentOrderPrecheckReplyProto.allow_partial_payment) || !this.unavailable_payment_options.equals(paymentOrderPrecheckReplyProto.unavailable_payment_options) || !Internal.equals(this.show_add_bank_card, paymentOrderPrecheckReplyProto.show_add_bank_card) || !Internal.equals(this.add_bank_card_message, paymentOrderPrecheckReplyProto.add_bank_card_message)) {
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
        String str = this.extra_data;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.allowed_auth_methods;
        int hashCode3 = (((hashCode2 + (num != null ? num.hashCode() : 0)) * 37) + this.payment_options.hashCode()) * 37;
        Boolean bool = this.allow_partial_payment;
        int hashCode4 = (((hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37) + this.unavailable_payment_options.hashCode()) * 37;
        Boolean bool2 = this.show_add_bank_card;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str2 = this.add_bank_card_message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (this.allowed_auth_methods != null) {
            sb.append(", allowed_auth_methods=");
            sb.append(this.allowed_auth_methods);
        }
        if (!this.payment_options.isEmpty()) {
            sb.append(", payment_options=");
            sb.append(this.payment_options);
        }
        if (this.allow_partial_payment != null) {
            sb.append(", allow_partial_payment=");
            sb.append(this.allow_partial_payment);
        }
        if (!this.unavailable_payment_options.isEmpty()) {
            sb.append(", unavailable_payment_options=");
            sb.append(this.unavailable_payment_options);
        }
        if (this.show_add_bank_card != null) {
            sb.append(", show_add_bank_card=");
            sb.append(this.show_add_bank_card);
        }
        if (this.add_bank_card_message != null) {
            sb.append(", add_bank_card_message=");
            sb.append(this.add_bank_card_message);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderPrecheckReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderPrecheckReplyProto, Builder> {
        public String add_bank_card_message;
        public Boolean allow_partial_payment;
        public Integer allowed_auth_methods;
        public String extra_data;
        public PacketHeaderProto header;
        public List<TopupInfoProto> payment_options = Internal.newMutableList();
        public Boolean show_add_bank_card;
        public List<TopupInfoProto> unavailable_payment_options = Internal.newMutableList();

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder allowed_auth_methods(Integer num) {
            this.allowed_auth_methods = num;
            return this;
        }

        public Builder payment_options(List<TopupInfoProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.payment_options = list;
            return this;
        }

        public Builder allow_partial_payment(Boolean bool) {
            this.allow_partial_payment = bool;
            return this;
        }

        public Builder unavailable_payment_options(List<TopupInfoProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.unavailable_payment_options = list;
            return this;
        }

        public Builder show_add_bank_card(Boolean bool) {
            this.show_add_bank_card = bool;
            return this;
        }

        public Builder add_bank_card_message(String str) {
            this.add_bank_card_message = str;
            return this;
        }

        public PaymentOrderPrecheckReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderPrecheckReplyProto(packetHeaderProto, this.extra_data, this.allowed_auth_methods, this.payment_options, this.allow_partial_payment, this.unavailable_payment_options, this.show_add_bank_card, this.add_bank_card_message, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderPrecheckReplyProto extends ProtoAdapter<PaymentOrderPrecheckReplyProto> {
        ProtoAdapter_PaymentOrderPrecheckReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderPrecheckReplyProto.class);
        }

        public int encodedSize(PaymentOrderPrecheckReplyProto paymentOrderPrecheckReplyProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderPrecheckReplyProto.header) + (paymentOrderPrecheckReplyProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, paymentOrderPrecheckReplyProto.extra_data) : 0) + (paymentOrderPrecheckReplyProto.allowed_auth_methods != null ? ProtoAdapter.UINT32.encodedSizeWithTag(3, paymentOrderPrecheckReplyProto.allowed_auth_methods) : 0) + TopupInfoProto.ADAPTER.asRepeated().encodedSizeWithTag(4, paymentOrderPrecheckReplyProto.payment_options) + (paymentOrderPrecheckReplyProto.allow_partial_payment != null ? ProtoAdapter.BOOL.encodedSizeWithTag(5, paymentOrderPrecheckReplyProto.allow_partial_payment) : 0) + TopupInfoProto.ADAPTER.asRepeated().encodedSizeWithTag(6, paymentOrderPrecheckReplyProto.unavailable_payment_options) + (paymentOrderPrecheckReplyProto.show_add_bank_card != null ? ProtoAdapter.BOOL.encodedSizeWithTag(7, paymentOrderPrecheckReplyProto.show_add_bank_card) : 0);
            if (paymentOrderPrecheckReplyProto.add_bank_card_message != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(8, paymentOrderPrecheckReplyProto.add_bank_card_message);
            }
            return encodedSizeWithTag + i + paymentOrderPrecheckReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderPrecheckReplyProto paymentOrderPrecheckReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderPrecheckReplyProto.header);
            if (paymentOrderPrecheckReplyProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, paymentOrderPrecheckReplyProto.extra_data);
            }
            if (paymentOrderPrecheckReplyProto.allowed_auth_methods != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, paymentOrderPrecheckReplyProto.allowed_auth_methods);
            }
            TopupInfoProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, paymentOrderPrecheckReplyProto.payment_options);
            if (paymentOrderPrecheckReplyProto.allow_partial_payment != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, paymentOrderPrecheckReplyProto.allow_partial_payment);
            }
            TopupInfoProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, paymentOrderPrecheckReplyProto.unavailable_payment_options);
            if (paymentOrderPrecheckReplyProto.show_add_bank_card != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 7, paymentOrderPrecheckReplyProto.show_add_bank_card);
            }
            if (paymentOrderPrecheckReplyProto.add_bank_card_message != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, paymentOrderPrecheckReplyProto.add_bank_card_message);
            }
            protoWriter.writeBytes(paymentOrderPrecheckReplyProto.unknownFields());
        }

        public PaymentOrderPrecheckReplyProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.allowed_auth_methods(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 4:
                            builder.payment_options.add(TopupInfoProto.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.allow_partial_payment(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 6:
                            builder.unavailable_payment_options.add(TopupInfoProto.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            builder.show_add_bank_card(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 8:
                            builder.add_bank_card_message(ProtoAdapter.STRING.decode(protoReader));
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

        public PaymentOrderPrecheckReplyProto redact(PaymentOrderPrecheckReplyProto paymentOrderPrecheckReplyProto) {
            Builder newBuilder = paymentOrderPrecheckReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.payment_options, TopupInfoProto.ADAPTER);
            Internal.redactElements(newBuilder.unavailable_payment_options, TopupInfoProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
