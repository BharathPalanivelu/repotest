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

public final class AttributeProto extends Message<AttributeProto, Builder> {
    public static final ProtoAdapter<AttributeProto> ADAPTER = new ProtoAdapter_AttributeProto();
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 1)
    public final String key;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String value;

    public AttributeProto(String str, String str2) {
        this(str, str2, f.f32736b);
    }

    public AttributeProto(String str, String str2, f fVar) {
        super(ADAPTER, fVar);
        this.key = str;
        this.value = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.key = this.key;
        builder.value = this.value;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeProto)) {
            return false;
        }
        AttributeProto attributeProto = (AttributeProto) obj;
        if (!unknownFields().equals(attributeProto.unknownFields()) || !Internal.equals(this.key, attributeProto.key) || !Internal.equals(this.value, attributeProto.value)) {
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
        String str = this.key;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.key != null) {
            sb.append(", key=");
            sb.append(this.key);
        }
        if (this.value != null) {
            sb.append(", value=");
            sb.append(this.value);
        }
        StringBuilder replace = sb.replace(0, 2, "AttributeProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AttributeProto, Builder> {
        public String key;
        public String value;

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public AttributeProto build() {
            return new AttributeProto(this.key, this.value, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_AttributeProto extends ProtoAdapter<AttributeProto> {
        ProtoAdapter_AttributeProto() {
            super(FieldEncoding.LENGTH_DELIMITED, AttributeProto.class);
        }

        public int encodedSize(AttributeProto attributeProto) {
            int i = 0;
            int encodedSizeWithTag = attributeProto.key != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, attributeProto.key) : 0;
            if (attributeProto.value != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, attributeProto.value);
            }
            return encodedSizeWithTag + i + attributeProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, AttributeProto attributeProto) throws IOException {
            if (attributeProto.key != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, attributeProto.key);
            }
            if (attributeProto.value != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, attributeProto.value);
            }
            protoWriter.writeBytes(attributeProto.unknownFields());
        }

        public AttributeProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.key(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.value(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public AttributeProto redact(AttributeProto attributeProto) {
            Builder newBuilder = attributeProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
