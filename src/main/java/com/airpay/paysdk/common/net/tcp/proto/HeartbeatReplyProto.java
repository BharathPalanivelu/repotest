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

public final class HeartbeatReplyProto extends Message<HeartbeatReplyProto, Builder> {
    public static final ProtoAdapter<HeartbeatReplyProto> ADAPTER = new a();
    public static final Integer DEFAULT_TIMESTAMP = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer timestamp;

    public HeartbeatReplyProto(PacketHeaderProto packetHeaderProto, Integer num) {
        this(packetHeaderProto, num, f.f32736b);
    }

    public HeartbeatReplyProto(PacketHeaderProto packetHeaderProto, Integer num, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.timestamp = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.timestamp = this.timestamp;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartbeatReplyProto)) {
            return false;
        }
        HeartbeatReplyProto heartbeatReplyProto = (HeartbeatReplyProto) obj;
        if (!unknownFields().equals(heartbeatReplyProto.unknownFields()) || !this.header.equals(heartbeatReplyProto.header) || !Internal.equals(this.timestamp, heartbeatReplyProto.timestamp)) {
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
        Integer num = this.timestamp;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.timestamp != null) {
            sb.append(", timestamp=");
            sb.append(this.timestamp);
        }
        StringBuilder replace = sb.replace(0, 2, "HeartbeatReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<HeartbeatReplyProto, Builder> {
        public PacketHeaderProto header;
        public Integer timestamp;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public HeartbeatReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new HeartbeatReplyProto(packetHeaderProto, this.timestamp, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class a extends ProtoAdapter<HeartbeatReplyProto> {
        a() {
            super(FieldEncoding.LENGTH_DELIMITED, HeartbeatReplyProto.class);
        }

        /* renamed from: a */
        public int encodedSize(HeartbeatReplyProto heartbeatReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, heartbeatReplyProto.header) + (heartbeatReplyProto.timestamp != null ? ProtoAdapter.UINT32.encodedSizeWithTag(3, heartbeatReplyProto.timestamp) : 0) + heartbeatReplyProto.unknownFields().h();
        }

        /* renamed from: a */
        public void encode(ProtoWriter protoWriter, HeartbeatReplyProto heartbeatReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, heartbeatReplyProto.header);
            if (heartbeatReplyProto.timestamp != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, heartbeatReplyProto.timestamp);
            }
            protoWriter.writeBytes(heartbeatReplyProto.unknownFields());
        }

        /* renamed from: a */
        public HeartbeatReplyProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.timestamp(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        /* renamed from: b */
        public HeartbeatReplyProto redact(HeartbeatReplyProto heartbeatReplyProto) {
            Builder newBuilder = heartbeatReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
