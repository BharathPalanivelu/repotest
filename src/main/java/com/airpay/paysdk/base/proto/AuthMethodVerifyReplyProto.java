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

public final class AuthMethodVerifyReplyProto extends Message<AuthMethodVerifyReplyProto, Builder> {
    public static final ProtoAdapter<AuthMethodVerifyReplyProto> ADAPTER = new ProtoAdapter_AuthMethodVerifyReplyProto();
    public static final String DEFAULT_SECURE_TOKEN = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String secure_token;
    @WireField(adapter = "com.airpay.protocol.protobuf.VerifyLimitProto#ADAPTER", tag = 3)
    public final VerifyLimitProto verify_limit;

    public AuthMethodVerifyReplyProto(PacketHeaderProto packetHeaderProto, String str, VerifyLimitProto verifyLimitProto) {
        this(packetHeaderProto, str, verifyLimitProto, f.f32736b);
    }

    public AuthMethodVerifyReplyProto(PacketHeaderProto packetHeaderProto, String str, VerifyLimitProto verifyLimitProto, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.secure_token = str;
        this.verify_limit = verifyLimitProto;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.secure_token = this.secure_token;
        builder.verify_limit = this.verify_limit;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthMethodVerifyReplyProto)) {
            return false;
        }
        AuthMethodVerifyReplyProto authMethodVerifyReplyProto = (AuthMethodVerifyReplyProto) obj;
        if (!unknownFields().equals(authMethodVerifyReplyProto.unknownFields()) || !this.header.equals(authMethodVerifyReplyProto.header) || !Internal.equals(this.secure_token, authMethodVerifyReplyProto.secure_token) || !Internal.equals(this.verify_limit, authMethodVerifyReplyProto.verify_limit)) {
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
        String str = this.secure_token;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        VerifyLimitProto verifyLimitProto = this.verify_limit;
        if (verifyLimitProto != null) {
            i2 = verifyLimitProto.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.secure_token != null) {
            sb.append(", secure_token=");
            sb.append(this.secure_token);
        }
        if (this.verify_limit != null) {
            sb.append(", verify_limit=");
            sb.append(this.verify_limit);
        }
        StringBuilder replace = sb.replace(0, 2, "AuthMethodVerifyReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AuthMethodVerifyReplyProto, Builder> {
        public PacketHeaderProto header;
        public String secure_token;
        public VerifyLimitProto verify_limit;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder secure_token(String str) {
            this.secure_token = str;
            return this;
        }

        public Builder verify_limit(VerifyLimitProto verifyLimitProto) {
            this.verify_limit = verifyLimitProto;
            return this;
        }

        public AuthMethodVerifyReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new AuthMethodVerifyReplyProto(packetHeaderProto, this.secure_token, this.verify_limit, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_AuthMethodVerifyReplyProto extends ProtoAdapter<AuthMethodVerifyReplyProto> {
        ProtoAdapter_AuthMethodVerifyReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, AuthMethodVerifyReplyProto.class);
        }

        public int encodedSize(AuthMethodVerifyReplyProto authMethodVerifyReplyProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, authMethodVerifyReplyProto.header) + (authMethodVerifyReplyProto.secure_token != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, authMethodVerifyReplyProto.secure_token) : 0);
            if (authMethodVerifyReplyProto.verify_limit != null) {
                i = VerifyLimitProto.ADAPTER.encodedSizeWithTag(3, authMethodVerifyReplyProto.verify_limit);
            }
            return encodedSizeWithTag + i + authMethodVerifyReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, AuthMethodVerifyReplyProto authMethodVerifyReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, authMethodVerifyReplyProto.header);
            if (authMethodVerifyReplyProto.secure_token != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, authMethodVerifyReplyProto.secure_token);
            }
            if (authMethodVerifyReplyProto.verify_limit != null) {
                VerifyLimitProto.ADAPTER.encodeWithTag(protoWriter, 3, authMethodVerifyReplyProto.verify_limit);
            }
            protoWriter.writeBytes(authMethodVerifyReplyProto.unknownFields());
        }

        public AuthMethodVerifyReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.secure_token(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.verify_limit(VerifyLimitProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public AuthMethodVerifyReplyProto redact(AuthMethodVerifyReplyProto authMethodVerifyReplyProto) {
            Builder newBuilder = authMethodVerifyReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            if (newBuilder.verify_limit != null) {
                newBuilder.verify_limit = VerifyLimitProto.ADAPTER.redact(newBuilder.verify_limit);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
