package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import com.tencent.ijk.media.player.IjkMediaMeta;
import e.f;
import java.io.IOException;
import java.util.List;

public final class SdkLoginForShopeeRequestProto extends Message<SdkLoginForShopeeRequestProto, Builder> {
    public static final ProtoAdapter<SdkLoginForShopeeRequestProto> ADAPTER = new ProtoAdapter_SdkLoginForShopeeRequestProto();
    public static final String DEFAULT_DEVICE_KEY = "";
    public static final String DEFAULT_DEVICE_OS_VERSION = "";
    public static final Integer DEFAULT_DEVICE_TYPE = 0;
    public static final String DEFAULT_LANGUAGE = "";
    public static final f DEFAULT_NOTIFY_KEY = f.f32736b;
    public static final Integer DEFAULT_NOTIFY_TYPE = 0;
    public static final String DEFAULT_SESSION_KEY = "";
    public static final String DEFAULT_SHOPEE_VERSION = "";
    public static final Integer DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.AttributeProto#ADAPTER", label = WireField.Label.REPEATED, tag = 10)
    public final List<AttributeProto> device_attributes;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String device_key;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 9)
    public final String device_os_version;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer device_type;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 5)
    public final String language;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BYTES", tag = 6)
    public final f notify_key;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer notify_type;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String session_key;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 11)
    public final String shopee_version;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer version;

    public SdkLoginForShopeeRequestProto(PacketHeaderProto packetHeaderProto, String str, String str2, Integer num, String str3, f fVar, Integer num2, Integer num3, String str4, List<AttributeProto> list, String str5) {
        this(packetHeaderProto, str, str2, num, str3, fVar, num2, num3, str4, list, str5, f.f32736b);
    }

    public SdkLoginForShopeeRequestProto(PacketHeaderProto packetHeaderProto, String str, String str2, Integer num, String str3, f fVar, Integer num2, Integer num3, String str4, List<AttributeProto> list, String str5, f fVar2) {
        super(ADAPTER, fVar2);
        this.header = packetHeaderProto;
        this.session_key = str;
        this.device_key = str2;
        this.device_type = num;
        this.language = str3;
        this.notify_key = fVar;
        this.version = num2;
        this.notify_type = num3;
        this.device_os_version = str4;
        this.device_attributes = Internal.immutableCopyOf("device_attributes", list);
        this.shopee_version = str5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.session_key = this.session_key;
        builder.device_key = this.device_key;
        builder.device_type = this.device_type;
        builder.language = this.language;
        builder.notify_key = this.notify_key;
        builder.version = this.version;
        builder.notify_type = this.notify_type;
        builder.device_os_version = this.device_os_version;
        builder.device_attributes = Internal.copyOf("device_attributes", this.device_attributes);
        builder.shopee_version = this.shopee_version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkLoginForShopeeRequestProto)) {
            return false;
        }
        SdkLoginForShopeeRequestProto sdkLoginForShopeeRequestProto = (SdkLoginForShopeeRequestProto) obj;
        if (!unknownFields().equals(sdkLoginForShopeeRequestProto.unknownFields()) || !this.header.equals(sdkLoginForShopeeRequestProto.header) || !this.session_key.equals(sdkLoginForShopeeRequestProto.session_key) || !this.device_key.equals(sdkLoginForShopeeRequestProto.device_key) || !this.device_type.equals(sdkLoginForShopeeRequestProto.device_type) || !this.language.equals(sdkLoginForShopeeRequestProto.language) || !Internal.equals(this.notify_key, sdkLoginForShopeeRequestProto.notify_key) || !Internal.equals(this.version, sdkLoginForShopeeRequestProto.version) || !Internal.equals(this.notify_type, sdkLoginForShopeeRequestProto.notify_type) || !Internal.equals(this.device_os_version, sdkLoginForShopeeRequestProto.device_os_version) || !this.device_attributes.equals(sdkLoginForShopeeRequestProto.device_attributes) || !Internal.equals(this.shopee_version, sdkLoginForShopeeRequestProto.shopee_version)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((((((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.session_key.hashCode()) * 37) + this.device_key.hashCode()) * 37) + this.device_type.hashCode()) * 37) + this.language.hashCode()) * 37;
        f fVar = this.notify_key;
        int i2 = 0;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.version;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.notify_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.device_os_version;
        int hashCode5 = (((hashCode4 + (str != null ? str.hashCode() : 0)) * 37) + this.device_attributes.hashCode()) * 37;
        String str2 = this.shopee_version;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        sb.append(", session_key=");
        sb.append(this.session_key);
        sb.append(", device_key=");
        sb.append(this.device_key);
        sb.append(", device_type=");
        sb.append(this.device_type);
        sb.append(", language=");
        sb.append(this.language);
        if (this.notify_key != null) {
            sb.append(", notify_key=");
            sb.append(this.notify_key);
        }
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.notify_type != null) {
            sb.append(", notify_type=");
            sb.append(this.notify_type);
        }
        if (this.device_os_version != null) {
            sb.append(", device_os_version=");
            sb.append(this.device_os_version);
        }
        if (!this.device_attributes.isEmpty()) {
            sb.append(", device_attributes=");
            sb.append(this.device_attributes);
        }
        if (this.shopee_version != null) {
            sb.append(", shopee_version=");
            sb.append(this.shopee_version);
        }
        StringBuilder replace = sb.replace(0, 2, "SdkLoginForShopeeRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SdkLoginForShopeeRequestProto, Builder> {
        public List<AttributeProto> device_attributes = Internal.newMutableList();
        public String device_key;
        public String device_os_version;
        public Integer device_type;
        public PacketHeaderProto header;
        public String language;
        public f notify_key;
        public Integer notify_type;
        public String session_key;
        public String shopee_version;
        public Integer version;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder session_key(String str) {
            this.session_key = str;
            return this;
        }

        public Builder device_key(String str) {
            this.device_key = str;
            return this;
        }

        public Builder device_type(Integer num) {
            this.device_type = num;
            return this;
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder notify_key(f fVar) {
            this.notify_key = fVar;
            return this;
        }

        public Builder version(Integer num) {
            this.version = num;
            return this;
        }

        public Builder notify_type(Integer num) {
            this.notify_type = num;
            return this;
        }

        public Builder device_os_version(String str) {
            this.device_os_version = str;
            return this;
        }

        public Builder device_attributes(List<AttributeProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.device_attributes = list;
            return this;
        }

        public Builder shopee_version(String str) {
            this.shopee_version = str;
            return this;
        }

        public SdkLoginForShopeeRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                String str = this.session_key;
                if (str != null) {
                    String str2 = this.device_key;
                    if (str2 != null) {
                        Integer num = this.device_type;
                        if (num != null) {
                            String str3 = this.language;
                            if (str3 != null) {
                                return new SdkLoginForShopeeRequestProto(packetHeaderProto, str, str2, num, str3, this.notify_key, this.version, this.notify_type, this.device_os_version, this.device_attributes, this.shopee_version, super.buildUnknownFields());
                            }
                        }
                    }
                }
            }
            throw Internal.missingRequiredFields(this.header, "header", this.session_key, "session_key", this.device_key, "device_key", this.device_type, "device_type", this.language, IjkMediaMeta.IJKM_KEY_LANGUAGE);
        }
    }

    private static final class ProtoAdapter_SdkLoginForShopeeRequestProto extends ProtoAdapter<SdkLoginForShopeeRequestProto> {
        ProtoAdapter_SdkLoginForShopeeRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkLoginForShopeeRequestProto.class);
        }

        public int encodedSize(SdkLoginForShopeeRequestProto sdkLoginForShopeeRequestProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, sdkLoginForShopeeRequestProto.header) + ProtoAdapter.STRING.encodedSizeWithTag(2, sdkLoginForShopeeRequestProto.session_key) + ProtoAdapter.STRING.encodedSizeWithTag(3, sdkLoginForShopeeRequestProto.device_key) + ProtoAdapter.UINT32.encodedSizeWithTag(4, sdkLoginForShopeeRequestProto.device_type) + ProtoAdapter.STRING.encodedSizeWithTag(5, sdkLoginForShopeeRequestProto.language) + (sdkLoginForShopeeRequestProto.notify_key != null ? ProtoAdapter.BYTES.encodedSizeWithTag(6, sdkLoginForShopeeRequestProto.notify_key) : 0) + (sdkLoginForShopeeRequestProto.version != null ? ProtoAdapter.UINT32.encodedSizeWithTag(7, sdkLoginForShopeeRequestProto.version) : 0) + (sdkLoginForShopeeRequestProto.notify_type != null ? ProtoAdapter.UINT32.encodedSizeWithTag(8, sdkLoginForShopeeRequestProto.notify_type) : 0) + (sdkLoginForShopeeRequestProto.device_os_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, sdkLoginForShopeeRequestProto.device_os_version) : 0) + AttributeProto.ADAPTER.asRepeated().encodedSizeWithTag(10, sdkLoginForShopeeRequestProto.device_attributes);
            if (sdkLoginForShopeeRequestProto.shopee_version != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(11, sdkLoginForShopeeRequestProto.shopee_version);
            }
            return encodedSizeWithTag + i + sdkLoginForShopeeRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, SdkLoginForShopeeRequestProto sdkLoginForShopeeRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, sdkLoginForShopeeRequestProto.header);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, sdkLoginForShopeeRequestProto.session_key);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, sdkLoginForShopeeRequestProto.device_key);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, sdkLoginForShopeeRequestProto.device_type);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, sdkLoginForShopeeRequestProto.language);
            if (sdkLoginForShopeeRequestProto.notify_key != null) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 6, sdkLoginForShopeeRequestProto.notify_key);
            }
            if (sdkLoginForShopeeRequestProto.version != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 7, sdkLoginForShopeeRequestProto.version);
            }
            if (sdkLoginForShopeeRequestProto.notify_type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 8, sdkLoginForShopeeRequestProto.notify_type);
            }
            if (sdkLoginForShopeeRequestProto.device_os_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, sdkLoginForShopeeRequestProto.device_os_version);
            }
            AttributeProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 10, sdkLoginForShopeeRequestProto.device_attributes);
            if (sdkLoginForShopeeRequestProto.shopee_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, sdkLoginForShopeeRequestProto.shopee_version);
            }
            protoWriter.writeBytes(sdkLoginForShopeeRequestProto.unknownFields());
        }

        public SdkLoginForShopeeRequestProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.session_key(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.device_key(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.device_type(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 5:
                            builder.language(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.notify_key(ProtoAdapter.BYTES.decode(protoReader));
                            break;
                        case 7:
                            builder.version(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 8:
                            builder.notify_type(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 9:
                            builder.device_os_version(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.device_attributes.add(AttributeProto.ADAPTER.decode(protoReader));
                            break;
                        case 11:
                            builder.shopee_version(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public SdkLoginForShopeeRequestProto redact(SdkLoginForShopeeRequestProto sdkLoginForShopeeRequestProto) {
            Builder newBuilder = sdkLoginForShopeeRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.device_attributes, AttributeProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
