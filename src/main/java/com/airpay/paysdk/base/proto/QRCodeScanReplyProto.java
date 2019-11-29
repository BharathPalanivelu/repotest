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

public final class QRCodeScanReplyProto extends Message<QRCodeScanReplyProto, Builder> {
    public static final ProtoAdapter<QRCodeScanReplyProto> ADAPTER = new ProtoAdapter_QRCodeScanReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.ActionProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<ActionProto> actions;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public QRCodeScanReplyProto(PacketHeaderProto packetHeaderProto, List<ActionProto> list) {
        this(packetHeaderProto, list, f.f32736b);
    }

    public QRCodeScanReplyProto(PacketHeaderProto packetHeaderProto, List<ActionProto> list, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.actions = Internal.immutableCopyOf("actions", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.actions = Internal.copyOf("actions", this.actions);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QRCodeScanReplyProto)) {
            return false;
        }
        QRCodeScanReplyProto qRCodeScanReplyProto = (QRCodeScanReplyProto) obj;
        if (!unknownFields().equals(qRCodeScanReplyProto.unknownFields()) || !this.header.equals(qRCodeScanReplyProto.header) || !this.actions.equals(qRCodeScanReplyProto.actions)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.actions.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.actions.isEmpty()) {
            sb.append(", actions=");
            sb.append(this.actions);
        }
        StringBuilder replace = sb.replace(0, 2, "QRCodeScanReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<QRCodeScanReplyProto, Builder> {
        public List<ActionProto> actions = Internal.newMutableList();
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder actions(List<ActionProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.actions = list;
            return this;
        }

        public QRCodeScanReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new QRCodeScanReplyProto(packetHeaderProto, this.actions, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_QRCodeScanReplyProto extends ProtoAdapter<QRCodeScanReplyProto> {
        ProtoAdapter_QRCodeScanReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, QRCodeScanReplyProto.class);
        }

        public int encodedSize(QRCodeScanReplyProto qRCodeScanReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, qRCodeScanReplyProto.header) + ActionProto.ADAPTER.asRepeated().encodedSizeWithTag(2, qRCodeScanReplyProto.actions) + qRCodeScanReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, QRCodeScanReplyProto qRCodeScanReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, qRCodeScanReplyProto.header);
            ActionProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, qRCodeScanReplyProto.actions);
            protoWriter.writeBytes(qRCodeScanReplyProto.unknownFields());
        }

        public QRCodeScanReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.actions.add(ActionProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public QRCodeScanReplyProto redact(QRCodeScanReplyProto qRCodeScanReplyProto) {
            Builder newBuilder = qRCodeScanReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.actions, ActionProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
