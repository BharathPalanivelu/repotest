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

public final class CashCurrentGetRequestProto extends Message<CashCurrentGetRequestProto, Builder> {
    public static final ProtoAdapter<CashCurrentGetRequestProto> ADAPTER = new ProtoAdapter_CashCurrentGetRequestProto();
    public static final String DEFAULT_CURRENCY = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String currency;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public CashCurrentGetRequestProto(PacketHeaderProto packetHeaderProto, String str) {
        this(packetHeaderProto, str, f.f32736b);
    }

    public CashCurrentGetRequestProto(PacketHeaderProto packetHeaderProto, String str, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.currency = str;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.currency = this.currency;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CashCurrentGetRequestProto)) {
            return false;
        }
        CashCurrentGetRequestProto cashCurrentGetRequestProto = (CashCurrentGetRequestProto) obj;
        if (!unknownFields().equals(cashCurrentGetRequestProto.unknownFields()) || !this.header.equals(cashCurrentGetRequestProto.header) || !Internal.equals(this.currency, cashCurrentGetRequestProto.currency)) {
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
        String str = this.currency;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.currency != null) {
            sb.append(", currency=");
            sb.append(this.currency);
        }
        StringBuilder replace = sb.replace(0, 2, "CashCurrentGetRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CashCurrentGetRequestProto, Builder> {
        public String currency;
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public CashCurrentGetRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new CashCurrentGetRequestProto(packetHeaderProto, this.currency, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_CashCurrentGetRequestProto extends ProtoAdapter<CashCurrentGetRequestProto> {
        ProtoAdapter_CashCurrentGetRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, CashCurrentGetRequestProto.class);
        }

        public int encodedSize(CashCurrentGetRequestProto cashCurrentGetRequestProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, cashCurrentGetRequestProto.header) + (cashCurrentGetRequestProto.currency != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, cashCurrentGetRequestProto.currency) : 0) + cashCurrentGetRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, CashCurrentGetRequestProto cashCurrentGetRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, cashCurrentGetRequestProto.header);
            if (cashCurrentGetRequestProto.currency != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, cashCurrentGetRequestProto.currency);
            }
            protoWriter.writeBytes(cashCurrentGetRequestProto.unknownFields());
        }

        public CashCurrentGetRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.currency(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public CashCurrentGetRequestProto redact(CashCurrentGetRequestProto cashCurrentGetRequestProto) {
            Builder newBuilder = cashCurrentGetRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
