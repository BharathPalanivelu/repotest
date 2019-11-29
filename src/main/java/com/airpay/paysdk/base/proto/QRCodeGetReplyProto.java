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

public final class QRCodeGetReplyProto extends Message<QRCodeGetReplyProto, Builder> {
    public static final ProtoAdapter<QRCodeGetReplyProto> ADAPTER = new ProtoAdapter_QRCodeGetReplyProto();
    public static final Integer DEFAULT_EXPIRY_TIME = 0;
    public static final String DEFAULT_QR_CODE = "";
    public static final String DEFAULT_TOPUP_ACCOUNT_ID = "";
    public static final Integer DEFAULT_TOPUP_CHANNEL_ID = 0;
    public static final Boolean DEFAULT_USE_CASH = false;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer expiry_time;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String qr_code;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 6)
    public final String topup_account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer topup_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean use_cash;

    public QRCodeGetReplyProto(PacketHeaderProto packetHeaderProto, String str, Integer num, Boolean bool, Integer num2, String str2) {
        this(packetHeaderProto, str, num, bool, num2, str2, f.f32736b);
    }

    public QRCodeGetReplyProto(PacketHeaderProto packetHeaderProto, String str, Integer num, Boolean bool, Integer num2, String str2, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.qr_code = str;
        this.expiry_time = num;
        this.use_cash = bool;
        this.topup_channel_id = num2;
        this.topup_account_id = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.qr_code = this.qr_code;
        builder.expiry_time = this.expiry_time;
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
        if (!(obj instanceof QRCodeGetReplyProto)) {
            return false;
        }
        QRCodeGetReplyProto qRCodeGetReplyProto = (QRCodeGetReplyProto) obj;
        if (!unknownFields().equals(qRCodeGetReplyProto.unknownFields()) || !this.header.equals(qRCodeGetReplyProto.header) || !Internal.equals(this.qr_code, qRCodeGetReplyProto.qr_code) || !Internal.equals(this.expiry_time, qRCodeGetReplyProto.expiry_time) || !Internal.equals(this.use_cash, qRCodeGetReplyProto.use_cash) || !Internal.equals(this.topup_channel_id, qRCodeGetReplyProto.topup_channel_id) || !Internal.equals(this.topup_account_id, qRCodeGetReplyProto.topup_account_id)) {
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
        Integer num = this.expiry_time;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.use_cash;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.topup_channel_id;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.topup_account_id;
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
        if (this.qr_code != null) {
            sb.append(", qr_code=");
            sb.append(this.qr_code);
        }
        if (this.expiry_time != null) {
            sb.append(", expiry_time=");
            sb.append(this.expiry_time);
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
        StringBuilder replace = sb.replace(0, 2, "QRCodeGetReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<QRCodeGetReplyProto, Builder> {
        public Integer expiry_time;
        public PacketHeaderProto header;
        public String qr_code;
        public String topup_account_id;
        public Integer topup_channel_id;
        public Boolean use_cash;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder qr_code(String str) {
            this.qr_code = str;
            return this;
        }

        public Builder expiry_time(Integer num) {
            this.expiry_time = num;
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

        public QRCodeGetReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new QRCodeGetReplyProto(packetHeaderProto, this.qr_code, this.expiry_time, this.use_cash, this.topup_channel_id, this.topup_account_id, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_QRCodeGetReplyProto extends ProtoAdapter<QRCodeGetReplyProto> {
        ProtoAdapter_QRCodeGetReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, QRCodeGetReplyProto.class);
        }

        public int encodedSize(QRCodeGetReplyProto qRCodeGetReplyProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, qRCodeGetReplyProto.header) + (qRCodeGetReplyProto.qr_code != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, qRCodeGetReplyProto.qr_code) : 0) + (qRCodeGetReplyProto.expiry_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(3, qRCodeGetReplyProto.expiry_time) : 0) + (qRCodeGetReplyProto.use_cash != null ? ProtoAdapter.BOOL.encodedSizeWithTag(4, qRCodeGetReplyProto.use_cash) : 0) + (qRCodeGetReplyProto.topup_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(5, qRCodeGetReplyProto.topup_channel_id) : 0);
            if (qRCodeGetReplyProto.topup_account_id != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(6, qRCodeGetReplyProto.topup_account_id);
            }
            return encodedSizeWithTag + i + qRCodeGetReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, QRCodeGetReplyProto qRCodeGetReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, qRCodeGetReplyProto.header);
            if (qRCodeGetReplyProto.qr_code != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, qRCodeGetReplyProto.qr_code);
            }
            if (qRCodeGetReplyProto.expiry_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, qRCodeGetReplyProto.expiry_time);
            }
            if (qRCodeGetReplyProto.use_cash != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, qRCodeGetReplyProto.use_cash);
            }
            if (qRCodeGetReplyProto.topup_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 5, qRCodeGetReplyProto.topup_channel_id);
            }
            if (qRCodeGetReplyProto.topup_account_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, qRCodeGetReplyProto.topup_account_id);
            }
            protoWriter.writeBytes(qRCodeGetReplyProto.unknownFields());
        }

        public QRCodeGetReplyProto decode(ProtoReader protoReader) throws IOException {
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
                            builder.qr_code(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.expiry_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 4:
                            builder.use_cash(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 5:
                            builder.topup_channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 6:
                            builder.topup_account_id(ProtoAdapter.STRING.decode(protoReader));
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

        public QRCodeGetReplyProto redact(QRCodeGetReplyProto qRCodeGetReplyProto) {
            Builder newBuilder = qRCodeGetReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
