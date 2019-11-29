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

public final class PaymentOrderExecuteRequestProto extends Message<PaymentOrderExecuteRequestProto, Builder> {
    public static final ProtoAdapter<PaymentOrderExecuteRequestProto> ADAPTER = new ProtoAdapter_PaymentOrderExecuteRequestProto();
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Long DEFAULT_ORDER_ID = 0L;
    public static final String DEFAULT_PAYMENT_PASSWORD = "";
    public static final String DEFAULT_SECURE_TOKEN = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String extra_data;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 2)
    public final Long order_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String payment_password;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 5)
    public final String secure_token;

    public PaymentOrderExecuteRequestProto(PacketHeaderProto packetHeaderProto, Long l, String str, String str2, String str3) {
        this(packetHeaderProto, l, str, str2, str3, f.f32736b);
    }

    public PaymentOrderExecuteRequestProto(PacketHeaderProto packetHeaderProto, Long l, String str, String str2, String str3, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.order_id = l;
        this.payment_password = str;
        this.extra_data = str2;
        this.secure_token = str3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.order_id = this.order_id;
        builder.payment_password = this.payment_password;
        builder.extra_data = this.extra_data;
        builder.secure_token = this.secure_token;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderExecuteRequestProto)) {
            return false;
        }
        PaymentOrderExecuteRequestProto paymentOrderExecuteRequestProto = (PaymentOrderExecuteRequestProto) obj;
        if (!unknownFields().equals(paymentOrderExecuteRequestProto.unknownFields()) || !this.header.equals(paymentOrderExecuteRequestProto.header) || !Internal.equals(this.order_id, paymentOrderExecuteRequestProto.order_id) || !Internal.equals(this.payment_password, paymentOrderExecuteRequestProto.payment_password) || !Internal.equals(this.extra_data, paymentOrderExecuteRequestProto.extra_data) || !Internal.equals(this.secure_token, paymentOrderExecuteRequestProto.secure_token)) {
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
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.payment_password;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.extra_data;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.secure_token;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        if (this.payment_password != null) {
            sb.append(", payment_password=");
            sb.append(this.payment_password);
        }
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (this.secure_token != null) {
            sb.append(", secure_token=");
            sb.append(this.secure_token);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderExecuteRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderExecuteRequestProto, Builder> {
        public String extra_data;
        public PacketHeaderProto header;
        public Long order_id;
        public String payment_password;
        public String secure_token;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public Builder payment_password(String str) {
            this.payment_password = str;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder secure_token(String str) {
            this.secure_token = str;
            return this;
        }

        public PaymentOrderExecuteRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderExecuteRequestProto(packetHeaderProto, this.order_id, this.payment_password, this.extra_data, this.secure_token, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderExecuteRequestProto extends ProtoAdapter<PaymentOrderExecuteRequestProto> {
        ProtoAdapter_PaymentOrderExecuteRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderExecuteRequestProto.class);
        }

        public int encodedSize(PaymentOrderExecuteRequestProto paymentOrderExecuteRequestProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderExecuteRequestProto.header) + (paymentOrderExecuteRequestProto.order_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(2, paymentOrderExecuteRequestProto.order_id) : 0) + (paymentOrderExecuteRequestProto.payment_password != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, paymentOrderExecuteRequestProto.payment_password) : 0) + (paymentOrderExecuteRequestProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, paymentOrderExecuteRequestProto.extra_data) : 0);
            if (paymentOrderExecuteRequestProto.secure_token != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(5, paymentOrderExecuteRequestProto.secure_token);
            }
            return encodedSizeWithTag + i + paymentOrderExecuteRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderExecuteRequestProto paymentOrderExecuteRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderExecuteRequestProto.header);
            if (paymentOrderExecuteRequestProto.order_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 2, paymentOrderExecuteRequestProto.order_id);
            }
            if (paymentOrderExecuteRequestProto.payment_password != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, paymentOrderExecuteRequestProto.payment_password);
            }
            if (paymentOrderExecuteRequestProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, paymentOrderExecuteRequestProto.extra_data);
            }
            if (paymentOrderExecuteRequestProto.secure_token != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, paymentOrderExecuteRequestProto.secure_token);
            }
            protoWriter.writeBytes(paymentOrderExecuteRequestProto.unknownFields());
        }

        public PaymentOrderExecuteRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.order_id(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.payment_password(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.secure_token(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public PaymentOrderExecuteRequestProto redact(PaymentOrderExecuteRequestProto paymentOrderExecuteRequestProto) {
            Builder newBuilder = paymentOrderExecuteRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
