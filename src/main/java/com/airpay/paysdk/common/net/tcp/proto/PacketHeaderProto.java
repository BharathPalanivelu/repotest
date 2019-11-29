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

public final class PacketHeaderProto extends Message<PacketHeaderProto, Builder> {
    public static final ProtoAdapter<PacketHeaderProto> ADAPTER = new a();
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_LOG_ID = 0;
    public static final String DEFAULT_MESSAGE = "";
    public static final Integer DEFAULT_RESULT = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer log_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String message;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer result;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer source;

    public PacketHeaderProto(Integer num, Integer num2, String str, Integer num3, Integer num4) {
        this(num, num2, str, num3, num4, f.f32736b);
    }

    public PacketHeaderProto(Integer num, Integer num2, String str, Integer num3, Integer num4, f fVar) {
        super(ADAPTER, fVar);
        this.id = num;
        this.result = num2;
        this.message = str;
        this.log_id = num3;
        this.source = num4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.result = this.result;
        builder.message = this.message;
        builder.log_id = this.log_id;
        builder.source = this.source;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PacketHeaderProto)) {
            return false;
        }
        PacketHeaderProto packetHeaderProto = (PacketHeaderProto) obj;
        if (!unknownFields().equals(packetHeaderProto.unknownFields()) || !Internal.equals(this.id, packetHeaderProto.id) || !Internal.equals(this.result, packetHeaderProto.result) || !Internal.equals(this.message, packetHeaderProto.message) || !Internal.equals(this.log_id, packetHeaderProto.log_id) || !Internal.equals(this.source, packetHeaderProto.source)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.id;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.result;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.message;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.log_id;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.source;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.result != null) {
            sb.append(", result=");
            sb.append(this.result);
        }
        if (this.message != null) {
            sb.append(", message=");
            sb.append(this.message);
        }
        if (this.log_id != null) {
            sb.append(", log_id=");
            sb.append(this.log_id);
        }
        if (this.source != null) {
            sb.append(", source=");
            sb.append(this.source);
        }
        StringBuilder replace = sb.replace(0, 2, "PacketHeaderProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PacketHeaderProto, Builder> {
        public Integer id;
        public Integer log_id;
        public String message;
        public Integer result;
        public Integer source;

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder result(Integer num) {
            this.result = num;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder log_id(Integer num) {
            this.log_id = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public PacketHeaderProto build() {
            return new PacketHeaderProto(this.id, this.result, this.message, this.log_id, this.source, super.buildUnknownFields());
        }
    }

    private static final class a extends ProtoAdapter<PacketHeaderProto> {
        a() {
            super(FieldEncoding.LENGTH_DELIMITED, PacketHeaderProto.class);
        }

        /* renamed from: a */
        public int encodedSize(PacketHeaderProto packetHeaderProto) {
            int i = 0;
            int encodedSizeWithTag = (packetHeaderProto.id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(1, packetHeaderProto.id) : 0) + (packetHeaderProto.result != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, packetHeaderProto.result) : 0) + (packetHeaderProto.message != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, packetHeaderProto.message) : 0) + (packetHeaderProto.log_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(4, packetHeaderProto.log_id) : 0);
            if (packetHeaderProto.source != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(5, packetHeaderProto.source);
            }
            return encodedSizeWithTag + i + packetHeaderProto.unknownFields().h();
        }

        /* renamed from: a */
        public void encode(ProtoWriter protoWriter, PacketHeaderProto packetHeaderProto) throws IOException {
            if (packetHeaderProto.id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, packetHeaderProto.id);
            }
            if (packetHeaderProto.result != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, packetHeaderProto.result);
            }
            if (packetHeaderProto.message != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, packetHeaderProto.message);
            }
            if (packetHeaderProto.log_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, packetHeaderProto.log_id);
            }
            if (packetHeaderProto.source != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 5, packetHeaderProto.source);
            }
            protoWriter.writeBytes(packetHeaderProto.unknownFields());
        }

        /* renamed from: a */
        public PacketHeaderProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.id(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.result(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.message(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.log_id(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.source(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        /* renamed from: b */
        public PacketHeaderProto redact(PacketHeaderProto packetHeaderProto) {
            Builder newBuilder = packetHeaderProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
