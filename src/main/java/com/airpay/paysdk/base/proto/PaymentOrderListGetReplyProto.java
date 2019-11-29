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
import java.util.List;

public final class PaymentOrderListGetReplyProto extends Message<PaymentOrderListGetReplyProto, Builder> {
    public static final ProtoAdapter<PaymentOrderListGetReplyProto> ADAPTER = new ProtoAdapter_PaymentOrderListGetReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.protocol.protobuf.OrderProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<OrderProto> orders;

    public PaymentOrderListGetReplyProto(PacketHeaderProto packetHeaderProto, List<OrderProto> list) {
        this(packetHeaderProto, list, f.f32736b);
    }

    public PaymentOrderListGetReplyProto(PacketHeaderProto packetHeaderProto, List<OrderProto> list, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.orders = Internal.immutableCopyOf("orders", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.orders = Internal.copyOf("orders", this.orders);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderListGetReplyProto)) {
            return false;
        }
        PaymentOrderListGetReplyProto paymentOrderListGetReplyProto = (PaymentOrderListGetReplyProto) obj;
        if (!unknownFields().equals(paymentOrderListGetReplyProto.unknownFields()) || !this.header.equals(paymentOrderListGetReplyProto.header) || !this.orders.equals(paymentOrderListGetReplyProto.orders)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.orders.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.orders.isEmpty()) {
            sb.append(", orders=");
            sb.append(this.orders);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderListGetReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderListGetReplyProto, Builder> {
        public PacketHeaderProto header;
        public List<OrderProto> orders = Internal.newMutableList();

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder orders(List<OrderProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.orders = list;
            return this;
        }

        public PaymentOrderListGetReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderListGetReplyProto(packetHeaderProto, this.orders, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderListGetReplyProto extends ProtoAdapter<PaymentOrderListGetReplyProto> {
        ProtoAdapter_PaymentOrderListGetReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderListGetReplyProto.class);
        }

        public int encodedSize(PaymentOrderListGetReplyProto paymentOrderListGetReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderListGetReplyProto.header) + OrderProto.ADAPTER.asRepeated().encodedSizeWithTag(2, paymentOrderListGetReplyProto.orders) + paymentOrderListGetReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderListGetReplyProto paymentOrderListGetReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderListGetReplyProto.header);
            OrderProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, paymentOrderListGetReplyProto.orders);
            protoWriter.writeBytes(paymentOrderListGetReplyProto.unknownFields());
        }

        public PaymentOrderListGetReplyProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.orders.add(OrderProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public PaymentOrderListGetReplyProto redact(PaymentOrderListGetReplyProto paymentOrderListGetReplyProto) {
            Builder newBuilder = paymentOrderListGetReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.orders, OrderProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
