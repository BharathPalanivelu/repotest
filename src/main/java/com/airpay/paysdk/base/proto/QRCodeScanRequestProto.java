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

public final class QRCodeScanRequestProto extends Message<QRCodeScanRequestProto, Builder> {
    public static final ProtoAdapter<QRCodeScanRequestProto> ADAPTER = new ProtoAdapter_QRCodeScanRequestProto();
    public static final String DEFAULT_QR_CODE = "";
    public static final String DEFAULT_SOURCE_INFO = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String qr_code;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String source_info;

    public QRCodeScanRequestProto(PacketHeaderProto packetHeaderProto, String str, String str2) {
        this(packetHeaderProto, str, str2, f.f32736b);
    }

    public QRCodeScanRequestProto(PacketHeaderProto packetHeaderProto, String str, String str2, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.qr_code = str;
        this.source_info = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.qr_code = this.qr_code;
        builder.source_info = this.source_info;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QRCodeScanRequestProto)) {
            return false;
        }
        QRCodeScanRequestProto qRCodeScanRequestProto = (QRCodeScanRequestProto) obj;
        if (!unknownFields().equals(qRCodeScanRequestProto.unknownFields()) || !this.header.equals(qRCodeScanRequestProto.header) || !Internal.equals(this.qr_code, qRCodeScanRequestProto.qr_code) || !Internal.equals(this.source_info, qRCodeScanRequestProto.source_info)) {
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
        String str = this.qr_code;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.source_info;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.qr_code != null) {
            sb.append(", qr_code=");
            sb.append(this.qr_code);
        }
        if (this.source_info != null) {
            sb.append(", source_info=");
            sb.append(this.source_info);
        }
        StringBuilder replace = sb.replace(0, 2, "QRCodeScanRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<QRCodeScanRequestProto, Builder> {
        public PacketHeaderProto header;
        public String qr_code;
        public String source_info;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder qr_code(String str) {
            this.qr_code = str;
            return this;
        }

        public Builder source_info(String str) {
            this.source_info = str;
            return this;
        }

        public QRCodeScanRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new QRCodeScanRequestProto(packetHeaderProto, this.qr_code, this.source_info, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_QRCodeScanRequestProto extends ProtoAdapter<QRCodeScanRequestProto> {
        ProtoAdapter_QRCodeScanRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, QRCodeScanRequestProto.class);
        }

        public int encodedSize(QRCodeScanRequestProto qRCodeScanRequestProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, qRCodeScanRequestProto.header) + (qRCodeScanRequestProto.qr_code != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, qRCodeScanRequestProto.qr_code) : 0);
            if (qRCodeScanRequestProto.source_info != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, qRCodeScanRequestProto.source_info);
            }
            return encodedSizeWithTag + i + qRCodeScanRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, QRCodeScanRequestProto qRCodeScanRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, qRCodeScanRequestProto.header);
            if (qRCodeScanRequestProto.qr_code != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, qRCodeScanRequestProto.qr_code);
            }
            if (qRCodeScanRequestProto.source_info != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, qRCodeScanRequestProto.source_info);
            }
            protoWriter.writeBytes(qRCodeScanRequestProto.unknownFields());
        }

        public QRCodeScanRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.qr_code(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.source_info(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public QRCodeScanRequestProto redact(QRCodeScanRequestProto qRCodeScanRequestProto) {
            Builder newBuilder = qRCodeScanRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
