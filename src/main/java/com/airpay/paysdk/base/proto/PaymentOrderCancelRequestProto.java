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

public final class PaymentOrderCancelRequestProto extends Message<PaymentOrderCancelRequestProto, Builder> {
    public static final ProtoAdapter<PaymentOrderCancelRequestProto> ADAPTER = new ProtoAdapter_PaymentOrderCancelRequestProto();
    public static final Long DEFAULT_ORDER_ID = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 4)
    public final Long order_id;

    public PaymentOrderCancelRequestProto(PacketHeaderProto packetHeaderProto, Long l) {
        this(packetHeaderProto, l, f.f32736b);
    }

    public PaymentOrderCancelRequestProto(PacketHeaderProto packetHeaderProto, Long l, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.order_id = l;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.order_id = this.order_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderCancelRequestProto)) {
            return false;
        }
        PaymentOrderCancelRequestProto paymentOrderCancelRequestProto = (PaymentOrderCancelRequestProto) obj;
        if (!unknownFields().equals(paymentOrderCancelRequestProto.unknownFields()) || !this.header.equals(paymentOrderCancelRequestProto.header) || !Internal.equals(this.order_id, paymentOrderCancelRequestProto.order_id)) {
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
        Long l = this.order_id;
        int hashCode2 = hashCode + (l != null ? l.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderCancelRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderCancelRequestProto, Builder> {
        public PacketHeaderProto header;
        public Long order_id;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public PaymentOrderCancelRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderCancelRequestProto(packetHeaderProto, this.order_id, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderCancelRequestProto extends ProtoAdapter<PaymentOrderCancelRequestProto> {
        ProtoAdapter_PaymentOrderCancelRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderCancelRequestProto.class);
        }

        public int encodedSize(PaymentOrderCancelRequestProto paymentOrderCancelRequestProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderCancelRequestProto.header) + (paymentOrderCancelRequestProto.order_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(4, paymentOrderCancelRequestProto.order_id) : 0) + paymentOrderCancelRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderCancelRequestProto paymentOrderCancelRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderCancelRequestProto.header);
            if (paymentOrderCancelRequestProto.order_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 4, paymentOrderCancelRequestProto.order_id);
            }
            protoWriter.writeBytes(paymentOrderCancelRequestProto.unknownFields());
        }

        public PaymentOrderCancelRequestProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.order_id(ProtoAdapter.UINT64.decode(protoReader));
                }
            }
        }

        public PaymentOrderCancelRequestProto redact(PaymentOrderCancelRequestProto paymentOrderCancelRequestProto) {
            Builder newBuilder = paymentOrderCancelRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
