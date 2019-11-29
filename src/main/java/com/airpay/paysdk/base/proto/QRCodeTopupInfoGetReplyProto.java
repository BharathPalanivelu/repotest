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

public final class QRCodeTopupInfoGetReplyProto extends Message<QRCodeTopupInfoGetReplyProto, Builder> {
    public static final ProtoAdapter<QRCodeTopupInfoGetReplyProto> ADAPTER = new ProtoAdapter_QRCodeTopupInfoGetReplyProto();
    public static final Integer DEFAULT_ALLOW_TOPUP_METHOD = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer allow_topup_method;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.protocol.protobuf.TopupInfoProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<TopupInfoProto> topup_options;

    public QRCodeTopupInfoGetReplyProto(PacketHeaderProto packetHeaderProto, List<TopupInfoProto> list, Integer num) {
        this(packetHeaderProto, list, num, f.f32736b);
    }

    public QRCodeTopupInfoGetReplyProto(PacketHeaderProto packetHeaderProto, List<TopupInfoProto> list, Integer num, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.topup_options = Internal.immutableCopyOf("topup_options", list);
        this.allow_topup_method = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.topup_options = Internal.copyOf("topup_options", this.topup_options);
        builder.allow_topup_method = this.allow_topup_method;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QRCodeTopupInfoGetReplyProto)) {
            return false;
        }
        QRCodeTopupInfoGetReplyProto qRCodeTopupInfoGetReplyProto = (QRCodeTopupInfoGetReplyProto) obj;
        if (!unknownFields().equals(qRCodeTopupInfoGetReplyProto.unknownFields()) || !this.header.equals(qRCodeTopupInfoGetReplyProto.header) || !this.topup_options.equals(qRCodeTopupInfoGetReplyProto.topup_options) || !Internal.equals(this.allow_topup_method, qRCodeTopupInfoGetReplyProto.allow_topup_method)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.topup_options.hashCode()) * 37;
        Integer num = this.allow_topup_method;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.topup_options.isEmpty()) {
            sb.append(", topup_options=");
            sb.append(this.topup_options);
        }
        if (this.allow_topup_method != null) {
            sb.append(", allow_topup_method=");
            sb.append(this.allow_topup_method);
        }
        StringBuilder replace = sb.replace(0, 2, "QRCodeTopupInfoGetReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<QRCodeTopupInfoGetReplyProto, Builder> {
        public Integer allow_topup_method;
        public PacketHeaderProto header;
        public List<TopupInfoProto> topup_options = Internal.newMutableList();

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder topup_options(List<TopupInfoProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.topup_options = list;
            return this;
        }

        public Builder allow_topup_method(Integer num) {
            this.allow_topup_method = num;
            return this;
        }

        public QRCodeTopupInfoGetReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new QRCodeTopupInfoGetReplyProto(packetHeaderProto, this.topup_options, this.allow_topup_method, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_QRCodeTopupInfoGetReplyProto extends ProtoAdapter<QRCodeTopupInfoGetReplyProto> {
        ProtoAdapter_QRCodeTopupInfoGetReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, QRCodeTopupInfoGetReplyProto.class);
        }

        public int encodedSize(QRCodeTopupInfoGetReplyProto qRCodeTopupInfoGetReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, qRCodeTopupInfoGetReplyProto.header) + TopupInfoProto.ADAPTER.asRepeated().encodedSizeWithTag(2, qRCodeTopupInfoGetReplyProto.topup_options) + (qRCodeTopupInfoGetReplyProto.allow_topup_method != null ? ProtoAdapter.UINT32.encodedSizeWithTag(3, qRCodeTopupInfoGetReplyProto.allow_topup_method) : 0) + qRCodeTopupInfoGetReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, QRCodeTopupInfoGetReplyProto qRCodeTopupInfoGetReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, qRCodeTopupInfoGetReplyProto.header);
            TopupInfoProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, qRCodeTopupInfoGetReplyProto.topup_options);
            if (qRCodeTopupInfoGetReplyProto.allow_topup_method != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, qRCodeTopupInfoGetReplyProto.allow_topup_method);
            }
            protoWriter.writeBytes(qRCodeTopupInfoGetReplyProto.unknownFields());
        }

        public QRCodeTopupInfoGetReplyProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.topup_options.add(TopupInfoProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.allow_topup_method(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public QRCodeTopupInfoGetReplyProto redact(QRCodeTopupInfoGetReplyProto qRCodeTopupInfoGetReplyProto) {
            Builder newBuilder = qRCodeTopupInfoGetReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.topup_options, TopupInfoProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
