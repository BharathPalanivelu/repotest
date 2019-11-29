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

public final class SdkLoginForShopeeReplyProto extends Message<SdkLoginForShopeeReplyProto, Builder> {
    public static final ProtoAdapter<SdkLoginForShopeeReplyProto> ADAPTER = new ProtoAdapter_SdkLoginForShopeeReplyProto();
    public static final Integer DEFAULT_EXPIRY_TIME = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Long DEFAULT_UID = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer expiry_time;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer timestamp;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long uid;

    public SdkLoginForShopeeReplyProto(PacketHeaderProto packetHeaderProto, Long l, Integer num, Integer num2) {
        this(packetHeaderProto, l, num, num2, f.f32736b);
    }

    public SdkLoginForShopeeReplyProto(PacketHeaderProto packetHeaderProto, Long l, Integer num, Integer num2, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.uid = l;
        this.timestamp = num;
        this.expiry_time = num2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.uid = this.uid;
        builder.timestamp = this.timestamp;
        builder.expiry_time = this.expiry_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkLoginForShopeeReplyProto)) {
            return false;
        }
        SdkLoginForShopeeReplyProto sdkLoginForShopeeReplyProto = (SdkLoginForShopeeReplyProto) obj;
        if (!unknownFields().equals(sdkLoginForShopeeReplyProto.unknownFields()) || !this.header.equals(sdkLoginForShopeeReplyProto.header) || !this.uid.equals(sdkLoginForShopeeReplyProto.uid) || !Internal.equals(this.timestamp, sdkLoginForShopeeReplyProto.timestamp) || !Internal.equals(this.expiry_time, sdkLoginForShopeeReplyProto.expiry_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.uid.hashCode()) * 37;
        Integer num = this.timestamp;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.expiry_time;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        sb.append(", uid=");
        sb.append(this.uid);
        if (this.timestamp != null) {
            sb.append(", timestamp=");
            sb.append(this.timestamp);
        }
        if (this.expiry_time != null) {
            sb.append(", expiry_time=");
            sb.append(this.expiry_time);
        }
        StringBuilder replace = sb.replace(0, 2, "SdkLoginForShopeeReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SdkLoginForShopeeReplyProto, Builder> {
        public Integer expiry_time;
        public PacketHeaderProto header;
        public Integer timestamp;
        public Long uid;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder uid(Long l) {
            this.uid = l;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder expiry_time(Integer num) {
            this.expiry_time = num;
            return this;
        }

        public SdkLoginForShopeeReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                Long l = this.uid;
                if (l != null) {
                    return new SdkLoginForShopeeReplyProto(packetHeaderProto, l, this.timestamp, this.expiry_time, super.buildUnknownFields());
                }
            }
            throw Internal.missingRequiredFields(this.header, "header", this.uid, "uid");
        }
    }

    private static final class ProtoAdapter_SdkLoginForShopeeReplyProto extends ProtoAdapter<SdkLoginForShopeeReplyProto> {
        ProtoAdapter_SdkLoginForShopeeReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkLoginForShopeeReplyProto.class);
        }

        public int encodedSize(SdkLoginForShopeeReplyProto sdkLoginForShopeeReplyProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, sdkLoginForShopeeReplyProto.header) + ProtoAdapter.UINT64.encodedSizeWithTag(2, sdkLoginForShopeeReplyProto.uid) + (sdkLoginForShopeeReplyProto.timestamp != null ? ProtoAdapter.UINT32.encodedSizeWithTag(3, sdkLoginForShopeeReplyProto.timestamp) : 0);
            if (sdkLoginForShopeeReplyProto.expiry_time != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(4, sdkLoginForShopeeReplyProto.expiry_time);
            }
            return encodedSizeWithTag + i + sdkLoginForShopeeReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, SdkLoginForShopeeReplyProto sdkLoginForShopeeReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, sdkLoginForShopeeReplyProto.header);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 2, sdkLoginForShopeeReplyProto.uid);
            if (sdkLoginForShopeeReplyProto.timestamp != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, sdkLoginForShopeeReplyProto.timestamp);
            }
            if (sdkLoginForShopeeReplyProto.expiry_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, sdkLoginForShopeeReplyProto.expiry_time);
            }
            protoWriter.writeBytes(sdkLoginForShopeeReplyProto.unknownFields());
        }

        public SdkLoginForShopeeReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.uid(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.timestamp(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.expiry_time(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public SdkLoginForShopeeReplyProto redact(SdkLoginForShopeeReplyProto sdkLoginForShopeeReplyProto) {
            Builder newBuilder = sdkLoginForShopeeReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
