package com.airpay.paysdk.common.net.tcp.proto;

import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import e.f;
import java.io.IOException;

public final class BasicPacketProto extends Message<BasicPacketProto, Builder> {
    public static final ProtoAdapter<BasicPacketProto> ADAPTER = new a();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public BasicPacketProto(PacketHeaderProto packetHeaderProto) {
        this(packetHeaderProto, f.f32736b);
    }

    public BasicPacketProto(PacketHeaderProto packetHeaderProto, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BasicPacketProto)) {
            return false;
        }
        BasicPacketProto basicPacketProto = (BasicPacketProto) obj;
        if (!unknownFields().equals(basicPacketProto.unknownFields()) || !this.header.equals(basicPacketProto.header)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (unknownFields().hashCode() * 37) + this.header.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        StringBuilder replace = sb.replace(0, 2, "BasicPacketProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BasicPacketProto, Builder> {
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public BasicPacketProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new BasicPacketProto(packetHeaderProto, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class a extends ProtoAdapter<BasicPacketProto> {
        a() {
            super(FieldEncoding.LENGTH_DELIMITED, BasicPacketProto.class);
        }

        /* renamed from: a */
        public int encodedSize(BasicPacketProto basicPacketProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, basicPacketProto.header) + basicPacketProto.unknownFields().h();
        }

        /* renamed from: a */
        public void encode(ProtoWriter protoWriter, BasicPacketProto basicPacketProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, basicPacketProto.header);
            protoWriter.writeBytes(basicPacketProto.unknownFields());
        }

        /* renamed from: a */
        public BasicPacketProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                }
            }
        }

        /* renamed from: b */
        public BasicPacketProto redact(BasicPacketProto basicPacketProto) {
            Builder newBuilder = basicPacketProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
