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

public final class QRCodeGetRequestProto extends Message<QRCodeGetRequestProto, Builder> {
    public static final ProtoAdapter<QRCodeGetRequestProto> ADAPTER = new ProtoAdapter_QRCodeGetRequestProto();
    public static final String DEFAULT_SECURE_TOKEN = "";
    public static final String DEFAULT_TOPUP_ACCOUNT_ID = "";
    public static final Integer DEFAULT_TOPUP_CHANNEL_ID = 0;
    public static final Boolean DEFAULT_USE_CASH = false;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String secure_token;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 5)
    public final String topup_account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer topup_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean use_cash;

    public QRCodeGetRequestProto(PacketHeaderProto packetHeaderProto, String str, Boolean bool, Integer num, String str2) {
        this(packetHeaderProto, str, bool, num, str2, f.f32736b);
    }

    public QRCodeGetRequestProto(PacketHeaderProto packetHeaderProto, String str, Boolean bool, Integer num, String str2, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.secure_token = str;
        this.use_cash = bool;
        this.topup_channel_id = num;
        this.topup_account_id = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.secure_token = this.secure_token;
        builder.use_cash = this.use_cash;
        builder.topup_channel_id = this.topup_channel_id;
        builder.topup_account_id = this.topup_account_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QRCodeGetRequestProto)) {
            return false;
        }
        QRCodeGetRequestProto qRCodeGetRequestProto = (QRCodeGetRequestProto) obj;
        if (!unknownFields().equals(qRCodeGetRequestProto.unknownFields()) || !this.header.equals(qRCodeGetRequestProto.header) || !Internal.equals(this.secure_token, qRCodeGetRequestProto.secure_token) || !Internal.equals(this.use_cash, qRCodeGetRequestProto.use_cash) || !Internal.equals(this.topup_channel_id, qRCodeGetRequestProto.topup_channel_id) || !Internal.equals(this.topup_account_id, qRCodeGetRequestProto.topup_account_id)) {
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
        String str = this.secure_token;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.use_cash;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.topup_channel_id;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.topup_account_id;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.secure_token != null) {
            sb.append(", secure_token=");
            sb.append(this.secure_token);
        }
        if (this.use_cash != null) {
            sb.append(", use_cash=");
            sb.append(this.use_cash);
        }
        if (this.topup_channel_id != null) {
            sb.append(", topup_channel_id=");
            sb.append(this.topup_channel_id);
        }
        if (this.topup_account_id != null) {
            sb.append(", topup_account_id=");
            sb.append(this.topup_account_id);
        }
        StringBuilder replace = sb.replace(0, 2, "QRCodeGetRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<QRCodeGetRequestProto, Builder> {
        public PacketHeaderProto header;
        public String secure_token;
        public String topup_account_id;
        public Integer topup_channel_id;
        public Boolean use_cash;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder secure_token(String str) {
            this.secure_token = str;
            return this;
        }

        public Builder use_cash(Boolean bool) {
            this.use_cash = bool;
            return this;
        }

        public Builder topup_channel_id(Integer num) {
            this.topup_channel_id = num;
            return this;
        }

        public Builder topup_account_id(String str) {
            this.topup_account_id = str;
            return this;
        }

        public QRCodeGetRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new QRCodeGetRequestProto(packetHeaderProto, this.secure_token, this.use_cash, this.topup_channel_id, this.topup_account_id, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_QRCodeGetRequestProto extends ProtoAdapter<QRCodeGetRequestProto> {
        ProtoAdapter_QRCodeGetRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, QRCodeGetRequestProto.class);
        }

        public int encodedSize(QRCodeGetRequestProto qRCodeGetRequestProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, qRCodeGetRequestProto.header) + (qRCodeGetRequestProto.secure_token != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, qRCodeGetRequestProto.secure_token) : 0) + (qRCodeGetRequestProto.use_cash != null ? ProtoAdapter.BOOL.encodedSizeWithTag(3, qRCodeGetRequestProto.use_cash) : 0) + (qRCodeGetRequestProto.topup_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(4, qRCodeGetRequestProto.topup_channel_id) : 0);
            if (qRCodeGetRequestProto.topup_account_id != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(5, qRCodeGetRequestProto.topup_account_id);
            }
            return encodedSizeWithTag + i + qRCodeGetRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, QRCodeGetRequestProto qRCodeGetRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, qRCodeGetRequestProto.header);
            if (qRCodeGetRequestProto.secure_token != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, qRCodeGetRequestProto.secure_token);
            }
            if (qRCodeGetRequestProto.use_cash != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, qRCodeGetRequestProto.use_cash);
            }
            if (qRCodeGetRequestProto.topup_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, qRCodeGetRequestProto.topup_channel_id);
            }
            if (qRCodeGetRequestProto.topup_account_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, qRCodeGetRequestProto.topup_account_id);
            }
            protoWriter.writeBytes(qRCodeGetRequestProto.unknownFields());
        }

        public QRCodeGetRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.secure_token(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.use_cash(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.topup_channel_id(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.topup_account_id(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public QRCodeGetRequestProto redact(QRCodeGetRequestProto qRCodeGetRequestProto) {
            Builder newBuilder = qRCodeGetRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
