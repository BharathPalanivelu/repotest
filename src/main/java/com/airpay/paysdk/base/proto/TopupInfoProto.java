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

public final class TopupInfoProto extends Message<TopupInfoProto, Builder> {
    public static final ProtoAdapter<TopupInfoProto> ADAPTER = new ProtoAdapter_TopupInfoProto();
    public static final Long DEFAULT_DATA = 0L;
    public static final String DEFAULT_MESSAGE = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 2)
    public final Long data;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String message;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer type;

    public TopupInfoProto(Integer num, Long l, String str) {
        this(num, l, str, f.f32736b);
    }

    public TopupInfoProto(Integer num, Long l, String str, f fVar) {
        super(ADAPTER, fVar);
        this.type = num;
        this.data = l;
        this.message = str;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.data = this.data;
        builder.message = this.message;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopupInfoProto)) {
            return false;
        }
        TopupInfoProto topupInfoProto = (TopupInfoProto) obj;
        if (!unknownFields().equals(topupInfoProto.unknownFields()) || !Internal.equals(this.type, topupInfoProto.type) || !Internal.equals(this.data, topupInfoProto.data) || !Internal.equals(this.message, topupInfoProto.message)) {
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
        Integer num = this.type;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.data;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.message;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        if (this.message != null) {
            sb.append(", message=");
            sb.append(this.message);
        }
        StringBuilder replace = sb.replace(0, 2, "TopupInfoProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<TopupInfoProto, Builder> {
        public Long data;
        public String message;
        public Integer type;

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder data(Long l) {
            this.data = l;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public TopupInfoProto build() {
            return new TopupInfoProto(this.type, this.data, this.message, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_TopupInfoProto extends ProtoAdapter<TopupInfoProto> {
        ProtoAdapter_TopupInfoProto() {
            super(FieldEncoding.LENGTH_DELIMITED, TopupInfoProto.class);
        }

        public int encodedSize(TopupInfoProto topupInfoProto) {
            int i = 0;
            int encodedSizeWithTag = (topupInfoProto.type != null ? ProtoAdapter.UINT32.encodedSizeWithTag(1, topupInfoProto.type) : 0) + (topupInfoProto.data != null ? ProtoAdapter.UINT64.encodedSizeWithTag(2, topupInfoProto.data) : 0);
            if (topupInfoProto.message != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, topupInfoProto.message);
            }
            return encodedSizeWithTag + i + topupInfoProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, TopupInfoProto topupInfoProto) throws IOException {
            if (topupInfoProto.type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, topupInfoProto.type);
            }
            if (topupInfoProto.data != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 2, topupInfoProto.data);
            }
            if (topupInfoProto.message != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, topupInfoProto.message);
            }
            protoWriter.writeBytes(topupInfoProto.unknownFields());
        }

        public TopupInfoProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.type(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.data(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.message(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public TopupInfoProto redact(TopupInfoProto topupInfoProto) {
            Builder newBuilder = topupInfoProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
