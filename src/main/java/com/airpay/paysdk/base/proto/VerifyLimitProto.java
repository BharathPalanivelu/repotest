package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import e.f;
import java.io.IOException;

public final class VerifyLimitProto extends Message<VerifyLimitProto, Builder> {
    public static final ProtoAdapter<VerifyLimitProto> ADAPTER = new ProtoAdapter_VerifyLimitProto();
    public static final Integer DEFAULT_EXPIRY = 0;
    public static final Integer DEFAULT_LEFT_COUNT = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer expiry;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer left_count;

    public VerifyLimitProto(Integer num, Integer num2) {
        this(num, num2, f.f32736b);
    }

    public VerifyLimitProto(Integer num, Integer num2, f fVar) {
        super(ADAPTER, fVar);
        this.left_count = num;
        this.expiry = num2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.left_count = this.left_count;
        builder.expiry = this.expiry;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VerifyLimitProto)) {
            return false;
        }
        VerifyLimitProto verifyLimitProto = (VerifyLimitProto) obj;
        if (!unknownFields().equals(verifyLimitProto.unknownFields()) || !Internal.equals(this.left_count, verifyLimitProto.left_count) || !Internal.equals(this.expiry, verifyLimitProto.expiry)) {
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
        Integer num = this.left_count;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.expiry;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.left_count != null) {
            sb.append(", left_count=");
            sb.append(this.left_count);
        }
        if (this.expiry != null) {
            sb.append(", expiry=");
            sb.append(this.expiry);
        }
        StringBuilder replace = sb.replace(0, 2, "VerifyLimitProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<VerifyLimitProto, Builder> {
        public Integer expiry;
        public Integer left_count;

        public Builder left_count(Integer num) {
            this.left_count = num;
            return this;
        }

        public Builder expiry(Integer num) {
            this.expiry = num;
            return this;
        }

        public VerifyLimitProto build() {
            return new VerifyLimitProto(this.left_count, this.expiry, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_VerifyLimitProto extends ProtoAdapter<VerifyLimitProto> {
        ProtoAdapter_VerifyLimitProto() {
            super(FieldEncoding.LENGTH_DELIMITED, VerifyLimitProto.class);
        }

        public int encodedSize(VerifyLimitProto verifyLimitProto) {
            int i = 0;
            int encodedSizeWithTag = verifyLimitProto.left_count != null ? ProtoAdapter.UINT32.encodedSizeWithTag(1, verifyLimitProto.left_count) : 0;
            if (verifyLimitProto.expiry != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(2, verifyLimitProto.expiry);
            }
            return encodedSizeWithTag + i + verifyLimitProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, VerifyLimitProto verifyLimitProto) throws IOException {
            if (verifyLimitProto.left_count != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, verifyLimitProto.left_count);
            }
            if (verifyLimitProto.expiry != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, verifyLimitProto.expiry);
            }
            protoWriter.writeBytes(verifyLimitProto.unknownFields());
        }

        public VerifyLimitProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.left_count(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.expiry(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public VerifyLimitProto redact(VerifyLimitProto verifyLimitProto) {
            Builder newBuilder = verifyLimitProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
