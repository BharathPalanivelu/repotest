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

public final class PaymentPasswordResetInitReplyProto extends Message<PaymentPasswordResetInitReplyProto, Builder> {
    public static final ProtoAdapter<PaymentPasswordResetInitReplyProto> ADAPTER = new ProtoAdapter_PaymentPasswordResetInitReplyProto();
    public static final Long DEFAULT_BANK_ACCOUNT_ID = 0L;
    public static final Integer DEFAULT_ID_TYPE = 0;
    public static final Integer DEFAULT_RESET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 2)
    public final Long bank_account_id;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer id_type;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer reset_type;

    public PaymentPasswordResetInitReplyProto(PacketHeaderProto packetHeaderProto, Long l, Integer num, Integer num2) {
        this(packetHeaderProto, l, num, num2, f.f32736b);
    }

    public PaymentPasswordResetInitReplyProto(PacketHeaderProto packetHeaderProto, Long l, Integer num, Integer num2, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.bank_account_id = l;
        this.reset_type = num;
        this.id_type = num2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.bank_account_id = this.bank_account_id;
        builder.reset_type = this.reset_type;
        builder.id_type = this.id_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentPasswordResetInitReplyProto)) {
            return false;
        }
        PaymentPasswordResetInitReplyProto paymentPasswordResetInitReplyProto = (PaymentPasswordResetInitReplyProto) obj;
        if (!unknownFields().equals(paymentPasswordResetInitReplyProto.unknownFields()) || !this.header.equals(paymentPasswordResetInitReplyProto.header) || !Internal.equals(this.bank_account_id, paymentPasswordResetInitReplyProto.bank_account_id) || !Internal.equals(this.reset_type, paymentPasswordResetInitReplyProto.reset_type) || !Internal.equals(this.id_type, paymentPasswordResetInitReplyProto.id_type)) {
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
        Long l = this.bank_account_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.reset_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.id_type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.bank_account_id != null) {
            sb.append(", bank_account_id=");
            sb.append(this.bank_account_id);
        }
        if (this.reset_type != null) {
            sb.append(", reset_type=");
            sb.append(this.reset_type);
        }
        if (this.id_type != null) {
            sb.append(", id_type=");
            sb.append(this.id_type);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentPasswordResetInitReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentPasswordResetInitReplyProto, Builder> {
        public Long bank_account_id;
        public PacketHeaderProto header;
        public Integer id_type;
        public Integer reset_type;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder bank_account_id(Long l) {
            this.bank_account_id = l;
            return this;
        }

        public Builder reset_type(Integer num) {
            this.reset_type = num;
            return this;
        }

        public Builder id_type(Integer num) {
            this.id_type = num;
            return this;
        }

        public PaymentPasswordResetInitReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentPasswordResetInitReplyProto(packetHeaderProto, this.bank_account_id, this.reset_type, this.id_type, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentPasswordResetInitReplyProto extends ProtoAdapter<PaymentPasswordResetInitReplyProto> {
        ProtoAdapter_PaymentPasswordResetInitReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentPasswordResetInitReplyProto.class);
        }

        public int encodedSize(PaymentPasswordResetInitReplyProto paymentPasswordResetInitReplyProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentPasswordResetInitReplyProto.header) + (paymentPasswordResetInitReplyProto.bank_account_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(2, paymentPasswordResetInitReplyProto.bank_account_id) : 0) + (paymentPasswordResetInitReplyProto.reset_type != null ? ProtoAdapter.UINT32.encodedSizeWithTag(3, paymentPasswordResetInitReplyProto.reset_type) : 0);
            if (paymentPasswordResetInitReplyProto.id_type != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(4, paymentPasswordResetInitReplyProto.id_type);
            }
            return encodedSizeWithTag + i + paymentPasswordResetInitReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentPasswordResetInitReplyProto paymentPasswordResetInitReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentPasswordResetInitReplyProto.header);
            if (paymentPasswordResetInitReplyProto.bank_account_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 2, paymentPasswordResetInitReplyProto.bank_account_id);
            }
            if (paymentPasswordResetInitReplyProto.reset_type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, paymentPasswordResetInitReplyProto.reset_type);
            }
            if (paymentPasswordResetInitReplyProto.id_type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, paymentPasswordResetInitReplyProto.id_type);
            }
            protoWriter.writeBytes(paymentPasswordResetInitReplyProto.unknownFields());
        }

        public PaymentPasswordResetInitReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.bank_account_id(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.reset_type(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.id_type(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public PaymentPasswordResetInitReplyProto redact(PaymentPasswordResetInitReplyProto paymentPasswordResetInitReplyProto) {
            Builder newBuilder = paymentPasswordResetInitReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
