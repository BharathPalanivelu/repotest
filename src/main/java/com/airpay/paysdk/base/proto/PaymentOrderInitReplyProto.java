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

public final class PaymentOrderInitReplyProto extends Message<PaymentOrderInitReplyProto, Builder> {
    public static final ProtoAdapter<PaymentOrderInitReplyProto> ADAPTER = new ProtoAdapter_PaymentOrderInitReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.protocol.protobuf.OrderProto#ADAPTER", tag = 2)
    public final OrderProto order;

    public PaymentOrderInitReplyProto(PacketHeaderProto packetHeaderProto, OrderProto orderProto) {
        this(packetHeaderProto, orderProto, f.f32736b);
    }

    public PaymentOrderInitReplyProto(PacketHeaderProto packetHeaderProto, OrderProto orderProto, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.order = orderProto;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.order = this.order;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderInitReplyProto)) {
            return false;
        }
        PaymentOrderInitReplyProto paymentOrderInitReplyProto = (PaymentOrderInitReplyProto) obj;
        if (!unknownFields().equals(paymentOrderInitReplyProto.unknownFields()) || !this.header.equals(paymentOrderInitReplyProto.header) || !Internal.equals(this.order, paymentOrderInitReplyProto.order)) {
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
        OrderProto orderProto = this.order;
        int hashCode2 = hashCode + (orderProto != null ? orderProto.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.order != null) {
            sb.append(", order=");
            sb.append(this.order);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderInitReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderInitReplyProto, Builder> {
        public PacketHeaderProto header;
        public OrderProto order;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder order(OrderProto orderProto) {
            this.order = orderProto;
            return this;
        }

        public PaymentOrderInitReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderInitReplyProto(packetHeaderProto, this.order, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderInitReplyProto extends ProtoAdapter<PaymentOrderInitReplyProto> {
        ProtoAdapter_PaymentOrderInitReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderInitReplyProto.class);
        }

        public int encodedSize(PaymentOrderInitReplyProto paymentOrderInitReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderInitReplyProto.header) + (paymentOrderInitReplyProto.order != null ? OrderProto.ADAPTER.encodedSizeWithTag(2, paymentOrderInitReplyProto.order) : 0) + paymentOrderInitReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderInitReplyProto paymentOrderInitReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderInitReplyProto.header);
            if (paymentOrderInitReplyProto.order != null) {
                OrderProto.ADAPTER.encodeWithTag(protoWriter, 2, paymentOrderInitReplyProto.order);
            }
            protoWriter.writeBytes(paymentOrderInitReplyProto.unknownFields());
        }

        public PaymentOrderInitReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.order(OrderProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public PaymentOrderInitReplyProto redact(PaymentOrderInitReplyProto paymentOrderInitReplyProto) {
            Builder newBuilder = paymentOrderInitReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            if (newBuilder.order != null) {
                newBuilder.order = OrderProto.ADAPTER.redact(newBuilder.order);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
