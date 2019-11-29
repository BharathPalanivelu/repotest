package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import e.f;
import java.io.IOException;

public final class PaymentConfirmDetailReplyProto extends Message<PaymentConfirmDetailReplyProto, Builder> {
    public static final ProtoAdapter<PaymentConfirmDetailReplyProto> ADAPTER = new ProtoAdapter_PaymentConfirmDetailReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PaymentConfirmDetailProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final PaymentConfirmDetailProto detail;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public PaymentConfirmDetailReplyProto(PacketHeaderProto packetHeaderProto, PaymentConfirmDetailProto paymentConfirmDetailProto) {
        this(packetHeaderProto, paymentConfirmDetailProto, f.f32736b);
    }

    public PaymentConfirmDetailReplyProto(PacketHeaderProto packetHeaderProto, PaymentConfirmDetailProto paymentConfirmDetailProto, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.detail = paymentConfirmDetailProto;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.detail = this.detail;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentConfirmDetailReplyProto)) {
            return false;
        }
        PaymentConfirmDetailReplyProto paymentConfirmDetailReplyProto = (PaymentConfirmDetailReplyProto) obj;
        if (!unknownFields().equals(paymentConfirmDetailReplyProto.unknownFields()) || !this.header.equals(paymentConfirmDetailReplyProto.header) || !this.detail.equals(paymentConfirmDetailReplyProto.detail)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.detail.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        sb.append(", detail=");
        sb.append(this.detail);
        StringBuilder replace = sb.replace(0, 2, "PaymentConfirmDetailReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentConfirmDetailReplyProto, Builder> {
        public PaymentConfirmDetailProto detail;
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder detail(PaymentConfirmDetailProto paymentConfirmDetailProto) {
            this.detail = paymentConfirmDetailProto;
            return this;
        }

        public PaymentConfirmDetailReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                PaymentConfirmDetailProto paymentConfirmDetailProto = this.detail;
                if (paymentConfirmDetailProto != null) {
                    return new PaymentConfirmDetailReplyProto(packetHeaderProto, paymentConfirmDetailProto, super.buildUnknownFields());
                }
            }
            throw Internal.missingRequiredFields(this.header, "header", this.detail, ProductAction.ACTION_DETAIL);
        }
    }

    private static final class ProtoAdapter_PaymentConfirmDetailReplyProto extends ProtoAdapter<PaymentConfirmDetailReplyProto> {
        ProtoAdapter_PaymentConfirmDetailReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentConfirmDetailReplyProto.class);
        }

        public int encodedSize(PaymentConfirmDetailReplyProto paymentConfirmDetailReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentConfirmDetailReplyProto.header) + PaymentConfirmDetailProto.ADAPTER.encodedSizeWithTag(2, paymentConfirmDetailReplyProto.detail) + paymentConfirmDetailReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentConfirmDetailReplyProto paymentConfirmDetailReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentConfirmDetailReplyProto.header);
            PaymentConfirmDetailProto.ADAPTER.encodeWithTag(protoWriter, 2, paymentConfirmDetailReplyProto.detail);
            protoWriter.writeBytes(paymentConfirmDetailReplyProto.unknownFields());
        }

        public PaymentConfirmDetailReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.detail(PaymentConfirmDetailProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public PaymentConfirmDetailReplyProto redact(PaymentConfirmDetailReplyProto paymentConfirmDetailReplyProto) {
            Builder newBuilder = paymentConfirmDetailReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.detail = PaymentConfirmDetailProto.ADAPTER.redact(newBuilder.detail);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
