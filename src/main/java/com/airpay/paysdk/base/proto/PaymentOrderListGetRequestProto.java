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

public final class PaymentOrderListGetRequestProto extends Message<PaymentOrderListGetRequestProto, Builder> {
    public static final ProtoAdapter<PaymentOrderListGetRequestProto> ADAPTER = new ProtoAdapter_PaymentOrderListGetRequestProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", label = WireField.Label.REPEATED, tag = 2)
    public final List<Long> order_id_list;

    public PaymentOrderListGetRequestProto(PacketHeaderProto packetHeaderProto, List<Long> list) {
        this(packetHeaderProto, list, f.f32736b);
    }

    public PaymentOrderListGetRequestProto(PacketHeaderProto packetHeaderProto, List<Long> list, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.order_id_list = Internal.immutableCopyOf("order_id_list", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.order_id_list = Internal.copyOf("order_id_list", this.order_id_list);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderListGetRequestProto)) {
            return false;
        }
        PaymentOrderListGetRequestProto paymentOrderListGetRequestProto = (PaymentOrderListGetRequestProto) obj;
        if (!unknownFields().equals(paymentOrderListGetRequestProto.unknownFields()) || !this.header.equals(paymentOrderListGetRequestProto.header) || !this.order_id_list.equals(paymentOrderListGetRequestProto.order_id_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.order_id_list.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.order_id_list.isEmpty()) {
            sb.append(", order_id_list=");
            sb.append(this.order_id_list);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderListGetRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderListGetRequestProto, Builder> {
        public PacketHeaderProto header;
        public List<Long> order_id_list = Internal.newMutableList();

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder order_id_list(List<Long> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.order_id_list = list;
            return this;
        }

        public PaymentOrderListGetRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderListGetRequestProto(packetHeaderProto, this.order_id_list, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderListGetRequestProto extends ProtoAdapter<PaymentOrderListGetRequestProto> {
        ProtoAdapter_PaymentOrderListGetRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderListGetRequestProto.class);
        }

        public int encodedSize(PaymentOrderListGetRequestProto paymentOrderListGetRequestProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderListGetRequestProto.header) + ProtoAdapter.UINT64.asRepeated().encodedSizeWithTag(2, paymentOrderListGetRequestProto.order_id_list) + paymentOrderListGetRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderListGetRequestProto paymentOrderListGetRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderListGetRequestProto.header);
            ProtoAdapter.UINT64.asRepeated().encodeWithTag(protoWriter, 2, paymentOrderListGetRequestProto.order_id_list);
            protoWriter.writeBytes(paymentOrderListGetRequestProto.unknownFields());
        }

        public PaymentOrderListGetRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.order_id_list.add(ProtoAdapter.UINT64.decode(protoReader));
                }
            }
        }

        public PaymentOrderListGetRequestProto redact(PaymentOrderListGetRequestProto paymentOrderListGetRequestProto) {
            Builder newBuilder = paymentOrderListGetRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
