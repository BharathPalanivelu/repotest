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

public final class ChannelListGetRequestProto extends Message<ChannelListGetRequestProto, Builder> {
    public static final ProtoAdapter<ChannelListGetRequestProto> ADAPTER = new ProtoAdapter_ChannelListGetRequestProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 2)
    public final List<Integer> channel_id_list;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 3)
    public final List<Integer> channel_type_list;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public ChannelListGetRequestProto(PacketHeaderProto packetHeaderProto, List<Integer> list, List<Integer> list2) {
        this(packetHeaderProto, list, list2, f.f32736b);
    }

    public ChannelListGetRequestProto(PacketHeaderProto packetHeaderProto, List<Integer> list, List<Integer> list2, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.channel_id_list = Internal.immutableCopyOf("channel_id_list", list);
        this.channel_type_list = Internal.immutableCopyOf("channel_type_list", list2);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.channel_id_list = Internal.copyOf("channel_id_list", this.channel_id_list);
        builder.channel_type_list = Internal.copyOf("channel_type_list", this.channel_type_list);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelListGetRequestProto)) {
            return false;
        }
        ChannelListGetRequestProto channelListGetRequestProto = (ChannelListGetRequestProto) obj;
        if (!unknownFields().equals(channelListGetRequestProto.unknownFields()) || !this.header.equals(channelListGetRequestProto.header) || !this.channel_id_list.equals(channelListGetRequestProto.channel_id_list) || !this.channel_type_list.equals(channelListGetRequestProto.channel_type_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.channel_id_list.hashCode()) * 37) + this.channel_type_list.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.channel_id_list.isEmpty()) {
            sb.append(", channel_id_list=");
            sb.append(this.channel_id_list);
        }
        if (!this.channel_type_list.isEmpty()) {
            sb.append(", channel_type_list=");
            sb.append(this.channel_type_list);
        }
        StringBuilder replace = sb.replace(0, 2, "ChannelListGetRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ChannelListGetRequestProto, Builder> {
        public List<Integer> channel_id_list = Internal.newMutableList();
        public List<Integer> channel_type_list = Internal.newMutableList();
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder channel_id_list(List<Integer> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.channel_id_list = list;
            return this;
        }

        public Builder channel_type_list(List<Integer> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.channel_type_list = list;
            return this;
        }

        public ChannelListGetRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new ChannelListGetRequestProto(packetHeaderProto, this.channel_id_list, this.channel_type_list, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_ChannelListGetRequestProto extends ProtoAdapter<ChannelListGetRequestProto> {
        ProtoAdapter_ChannelListGetRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ChannelListGetRequestProto.class);
        }

        public int encodedSize(ChannelListGetRequestProto channelListGetRequestProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, channelListGetRequestProto.header) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(2, channelListGetRequestProto.channel_id_list) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(3, channelListGetRequestProto.channel_type_list) + channelListGetRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, ChannelListGetRequestProto channelListGetRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, channelListGetRequestProto.header);
            ProtoAdapter.UINT32.asRepeated().encodeWithTag(protoWriter, 2, channelListGetRequestProto.channel_id_list);
            ProtoAdapter.UINT32.asRepeated().encodeWithTag(protoWriter, 3, channelListGetRequestProto.channel_type_list);
            protoWriter.writeBytes(channelListGetRequestProto.unknownFields());
        }

        public ChannelListGetRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.channel_id_list.add(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.channel_type_list.add(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public ChannelListGetRequestProto redact(ChannelListGetRequestProto channelListGetRequestProto) {
            Builder newBuilder = channelListGetRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
