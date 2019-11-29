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

public final class AuthMethodVerifyRequestProto extends Message<AuthMethodVerifyRequestProto, Builder> {
    public static final ProtoAdapter<AuthMethodVerifyRequestProto> ADAPTER = new ProtoAdapter_AuthMethodVerifyRequestProto();
    public static final String DEFAULT_AUTH_KEY = "";
    public static final Integer DEFAULT_AUTH_METHOD = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String auth_key;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer auth_method;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", tag = 1)
    public final PacketHeaderProto header;

    public AuthMethodVerifyRequestProto(PacketHeaderProto packetHeaderProto, Integer num, String str) {
        this(packetHeaderProto, num, str, f.f32736b);
    }

    public AuthMethodVerifyRequestProto(PacketHeaderProto packetHeaderProto, Integer num, String str, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.auth_method = num;
        this.auth_key = str;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.auth_method = this.auth_method;
        builder.auth_key = this.auth_key;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthMethodVerifyRequestProto)) {
            return false;
        }
        AuthMethodVerifyRequestProto authMethodVerifyRequestProto = (AuthMethodVerifyRequestProto) obj;
        if (!unknownFields().equals(authMethodVerifyRequestProto.unknownFields()) || !Internal.equals(this.header, authMethodVerifyRequestProto.header) || !Internal.equals(this.auth_method, authMethodVerifyRequestProto.auth_method) || !Internal.equals(this.auth_key, authMethodVerifyRequestProto.auth_key)) {
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
        PacketHeaderProto packetHeaderProto = this.header;
        int i2 = 0;
        int hashCode2 = (hashCode + (packetHeaderProto != null ? packetHeaderProto.hashCode() : 0)) * 37;
        Integer num = this.auth_method;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.auth_key;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.header != null) {
            sb.append(", header=");
            sb.append(this.header);
        }
        if (this.auth_method != null) {
            sb.append(", auth_method=");
            sb.append(this.auth_method);
        }
        if (this.auth_key != null) {
            sb.append(", auth_key=");
            sb.append(this.auth_key);
        }
        StringBuilder replace = sb.replace(0, 2, "AuthMethodVerifyRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AuthMethodVerifyRequestProto, Builder> {
        public String auth_key;
        public Integer auth_method;
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder auth_method(Integer num) {
            this.auth_method = num;
            return this;
        }

        public Builder auth_key(String str) {
            this.auth_key = str;
            return this;
        }

        public AuthMethodVerifyRequestProto build() {
            return new AuthMethodVerifyRequestProto(this.header, this.auth_method, this.auth_key, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_AuthMethodVerifyRequestProto extends ProtoAdapter<AuthMethodVerifyRequestProto> {
        ProtoAdapter_AuthMethodVerifyRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, AuthMethodVerifyRequestProto.class);
        }

        public int encodedSize(AuthMethodVerifyRequestProto authMethodVerifyRequestProto) {
            int i = 0;
            int encodedSizeWithTag = (authMethodVerifyRequestProto.header != null ? PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, authMethodVerifyRequestProto.header) : 0) + (authMethodVerifyRequestProto.auth_method != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, authMethodVerifyRequestProto.auth_method) : 0);
            if (authMethodVerifyRequestProto.auth_key != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, authMethodVerifyRequestProto.auth_key);
            }
            return encodedSizeWithTag + i + authMethodVerifyRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, AuthMethodVerifyRequestProto authMethodVerifyRequestProto) throws IOException {
            if (authMethodVerifyRequestProto.header != null) {
                PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, authMethodVerifyRequestProto.header);
            }
            if (authMethodVerifyRequestProto.auth_method != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, authMethodVerifyRequestProto.auth_method);
            }
            if (authMethodVerifyRequestProto.auth_key != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, authMethodVerifyRequestProto.auth_key);
            }
            protoWriter.writeBytes(authMethodVerifyRequestProto.unknownFields());
        }

        public AuthMethodVerifyRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.auth_method(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.auth_key(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public AuthMethodVerifyRequestProto redact(AuthMethodVerifyRequestProto authMethodVerifyRequestProto) {
            Builder newBuilder = authMethodVerifyRequestProto.newBuilder();
            if (newBuilder.header != null) {
                newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
