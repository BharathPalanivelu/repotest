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

public final class ChannelListGetReplyProto extends Message<ChannelListGetReplyProto, Builder> {
    public static final ProtoAdapter<ChannelListGetReplyProto> ADAPTER = new ProtoAdapter_ChannelListGetReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.ChannelInfoProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<ChannelInfoProto> channels;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public ChannelListGetReplyProto(PacketHeaderProto packetHeaderProto, List<ChannelInfoProto> list) {
        this(packetHeaderProto, list, f.f32736b);
    }

    public ChannelListGetReplyProto(PacketHeaderProto packetHeaderProto, List<ChannelInfoProto> list, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.channels = Internal.immutableCopyOf("channels", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.channels = Internal.copyOf("channels", this.channels);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelListGetReplyProto)) {
            return false;
        }
        ChannelListGetReplyProto channelListGetReplyProto = (ChannelListGetReplyProto) obj;
        if (!unknownFields().equals(channelListGetReplyProto.unknownFields()) || !this.header.equals(channelListGetReplyProto.header) || !this.channels.equals(channelListGetReplyProto.channels)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.channels.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.channels.isEmpty()) {
            sb.append(", channels=");
            sb.append(this.channels);
        }
        StringBuilder replace = sb.replace(0, 2, "ChannelListGetReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ChannelListGetReplyProto, Builder> {
        public List<ChannelInfoProto> channels = Internal.newMutableList();
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder channels(List<ChannelInfoProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.channels = list;
            return this;
        }

        public ChannelListGetReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new ChannelListGetReplyProto(packetHeaderProto, this.channels, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_ChannelListGetReplyProto extends ProtoAdapter<ChannelListGetReplyProto> {
        ProtoAdapter_ChannelListGetReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ChannelListGetReplyProto.class);
        }

        public int encodedSize(ChannelListGetReplyProto channelListGetReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, channelListGetReplyProto.header) + ChannelInfoProto.ADAPTER.asRepeated().encodedSizeWithTag(2, channelListGetReplyProto.channels) + channelListGetReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, ChannelListGetReplyProto channelListGetReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, channelListGetReplyProto.header);
            ChannelInfoProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, channelListGetReplyProto.channels);
            protoWriter.writeBytes(channelListGetReplyProto.unknownFields());
        }

        public ChannelListGetReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.channels.add(ChannelInfoProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public ChannelListGetReplyProto redact(ChannelListGetReplyProto channelListGetReplyProto) {
            Builder newBuilder = channelListGetReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.channels, ChannelInfoProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
