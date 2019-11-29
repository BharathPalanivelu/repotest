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

public final class ActionProto extends Message<ActionProto, Builder> {
    public static final ProtoAdapter<ActionProto> ADAPTER = new ProtoAdapter_ActionProto();
    public static final Integer DEFAULT_CMD = 0;
    public static final f DEFAULT_DATA = f.f32736b;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer cmd;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BYTES", tag = 3)
    public final f data;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public ActionProto(PacketHeaderProto packetHeaderProto, Integer num, f fVar) {
        this(packetHeaderProto, num, fVar, f.f32736b);
    }

    public ActionProto(PacketHeaderProto packetHeaderProto, Integer num, f fVar, f fVar2) {
        super(ADAPTER, fVar2);
        this.header = packetHeaderProto;
        this.cmd = num;
        this.data = fVar;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.cmd = this.cmd;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionProto)) {
            return false;
        }
        ActionProto actionProto = (ActionProto) obj;
        if (!unknownFields().equals(actionProto.unknownFields()) || !this.header.equals(actionProto.header) || !Internal.equals(this.cmd, actionProto.cmd) || !Internal.equals(this.data, actionProto.data)) {
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
        Integer num = this.cmd;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.data;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.cmd != null) {
            sb.append(", cmd=");
            sb.append(this.cmd);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "ActionProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ActionProto, Builder> {
        public Integer cmd;
        public f data;
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder cmd(Integer num) {
            this.cmd = num;
            return this;
        }

        public Builder data(f fVar) {
            this.data = fVar;
            return this;
        }

        public ActionProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new ActionProto(packetHeaderProto, this.cmd, this.data, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_ActionProto extends ProtoAdapter<ActionProto> {
        ProtoAdapter_ActionProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ActionProto.class);
        }

        public int encodedSize(ActionProto actionProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, actionProto.header) + (actionProto.cmd != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, actionProto.cmd) : 0);
            if (actionProto.data != null) {
                i = ProtoAdapter.BYTES.encodedSizeWithTag(3, actionProto.data);
            }
            return encodedSizeWithTag + i + actionProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, ActionProto actionProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, actionProto.header);
            if (actionProto.cmd != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, actionProto.cmd);
            }
            if (actionProto.data != null) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 3, actionProto.data);
            }
            protoWriter.writeBytes(actionProto.unknownFields());
        }

        public ActionProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.cmd(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(ProtoAdapter.BYTES.decode(protoReader));
                }
            }
        }

        public ActionProto redact(ActionProto actionProto) {
            Builder newBuilder = actionProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
