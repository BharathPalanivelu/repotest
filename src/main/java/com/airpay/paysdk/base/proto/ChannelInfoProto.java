package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.qalsdk.util.BaseApplication;
import e.f;
import java.io.IOException;

public final class ChannelInfoProto extends Message<ChannelInfoProto, Builder> {
    public static final ProtoAdapter<ChannelInfoProto> ADAPTER = new ProtoAdapter_ChannelInfoProto();
    public static final Integer DEFAULT_AVAILABILITY = 0;
    public static final Integer DEFAULT_CHANNEL_ID = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Float DEFAULT_DISCOUNT = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Long DEFAULT_FLAG = 0L;
    public static final Integer DEFAULT_GATEWAY = 0;
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_MESSAGE = "";
    public static final Integer DEFAULT_MIN_VERSION_ANDROID = 0;
    public static final Integer DEFAULT_MIN_VERSION_IOS = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_PRIORITY = 0;
    public static final Long DEFAULT_TXN_MAX = 0L;
    public static final Long DEFAULT_TXN_MIN = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer availability;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", label = WireField.Label.REQUIRED, tag = 1)
    public final Integer channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 7)
    public final String currency;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String description;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#FLOAT", tag = 8)
    public final Float discount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 9)
    public final String extra_data;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 17)
    public final Long flag;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 14)
    public final Integer gateway;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String icon;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 12)
    public final String message;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer min_version_android;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 15)
    public final Integer min_version_ios;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String name;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer priority;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 11)
    public final Long txn_max;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 10)
    public final Long txn_min;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer type;

    public ChannelInfoProto(Integer num, String str, String str2, String str3, Integer num2, Integer num3, String str4, Float f2, String str5, Long l, Long l2, String str6, Integer num4, Integer num5, Integer num6, Integer num7, Long l3) {
        this(num, str, str2, str3, num2, num3, str4, f2, str5, l, l2, str6, num4, num5, num6, num7, l3, f.f32736b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelInfoProto(Integer num, String str, String str2, String str3, Integer num2, Integer num3, String str4, Float f2, String str5, Long l, Long l2, String str6, Integer num4, Integer num5, Integer num6, Integer num7, Long l3, f fVar) {
        super(ADAPTER, fVar);
        this.channel_id = num;
        this.name = str;
        this.description = str2;
        this.icon = str3;
        this.type = num2;
        this.priority = num3;
        this.currency = str4;
        this.discount = f2;
        this.extra_data = str5;
        this.txn_min = l;
        this.txn_max = l2;
        this.message = str6;
        this.availability = num4;
        this.gateway = num5;
        this.min_version_ios = num6;
        this.min_version_android = num7;
        this.flag = l3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.channel_id = this.channel_id;
        builder.name = this.name;
        builder.description = this.description;
        builder.icon = this.icon;
        builder.type = this.type;
        builder.priority = this.priority;
        builder.currency = this.currency;
        builder.discount = this.discount;
        builder.extra_data = this.extra_data;
        builder.txn_min = this.txn_min;
        builder.txn_max = this.txn_max;
        builder.message = this.message;
        builder.availability = this.availability;
        builder.gateway = this.gateway;
        builder.min_version_ios = this.min_version_ios;
        builder.min_version_android = this.min_version_android;
        builder.flag = this.flag;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelInfoProto)) {
            return false;
        }
        ChannelInfoProto channelInfoProto = (ChannelInfoProto) obj;
        if (!unknownFields().equals(channelInfoProto.unknownFields()) || !this.channel_id.equals(channelInfoProto.channel_id) || !Internal.equals(this.name, channelInfoProto.name) || !Internal.equals(this.description, channelInfoProto.description) || !Internal.equals(this.icon, channelInfoProto.icon) || !Internal.equals(this.type, channelInfoProto.type) || !Internal.equals(this.priority, channelInfoProto.priority) || !Internal.equals(this.currency, channelInfoProto.currency) || !Internal.equals(this.discount, channelInfoProto.discount) || !Internal.equals(this.extra_data, channelInfoProto.extra_data) || !Internal.equals(this.txn_min, channelInfoProto.txn_min) || !Internal.equals(this.txn_max, channelInfoProto.txn_max) || !Internal.equals(this.message, channelInfoProto.message) || !Internal.equals(this.availability, channelInfoProto.availability) || !Internal.equals(this.gateway, channelInfoProto.gateway) || !Internal.equals(this.min_version_ios, channelInfoProto.min_version_ios) || !Internal.equals(this.min_version_android, channelInfoProto.min_version_android) || !Internal.equals(this.flag, channelInfoProto.flag)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.channel_id.hashCode()) * 37;
        String str = this.name;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.icon;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.priority;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.currency;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Float f2 = this.discount;
        int hashCode8 = (hashCode7 + (f2 != null ? f2.hashCode() : 0)) * 37;
        String str5 = this.extra_data;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l = this.txn_min;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.txn_max;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str6 = this.message;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num3 = this.availability;
        int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.gateway;
        int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.min_version_ios;
        int hashCode15 = (hashCode14 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.min_version_android;
        int hashCode16 = (hashCode15 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l3 = this.flag;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channel_id=");
        sb.append(this.channel_id);
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.description != null) {
            sb.append(", description=");
            sb.append(this.description);
        }
        if (this.icon != null) {
            sb.append(", icon=");
            sb.append(this.icon);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.priority != null) {
            sb.append(", priority=");
            sb.append(this.priority);
        }
        if (this.currency != null) {
            sb.append(", currency=");
            sb.append(this.currency);
        }
        if (this.discount != null) {
            sb.append(", discount=");
            sb.append(this.discount);
        }
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (this.txn_min != null) {
            sb.append(", txn_min=");
            sb.append(this.txn_min);
        }
        if (this.txn_max != null) {
            sb.append(", txn_max=");
            sb.append(this.txn_max);
        }
        if (this.message != null) {
            sb.append(", message=");
            sb.append(this.message);
        }
        if (this.availability != null) {
            sb.append(", availability=");
            sb.append(this.availability);
        }
        if (this.gateway != null) {
            sb.append(", gateway=");
            sb.append(this.gateway);
        }
        if (this.min_version_ios != null) {
            sb.append(", min_version_ios=");
            sb.append(this.min_version_ios);
        }
        if (this.min_version_android != null) {
            sb.append(", min_version_android=");
            sb.append(this.min_version_android);
        }
        if (this.flag != null) {
            sb.append(", flag=");
            sb.append(this.flag);
        }
        StringBuilder replace = sb.replace(0, 2, "ChannelInfoProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ChannelInfoProto, Builder> {
        public Integer availability;
        public Integer channel_id;
        public String currency;
        public String description;
        public Float discount;
        public String extra_data;
        public Long flag;
        public Integer gateway;
        public String icon;
        public String message;
        public Integer min_version_android;
        public Integer min_version_ios;
        public String name;
        public Integer priority;
        public Long txn_max;
        public Long txn_min;
        public Integer type;

        public Builder channel_id(Integer num) {
            this.channel_id = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder priority(Integer num) {
            this.priority = num;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder discount(Float f2) {
            this.discount = f2;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder txn_min(Long l) {
            this.txn_min = l;
            return this;
        }

        public Builder txn_max(Long l) {
            this.txn_max = l;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder availability(Integer num) {
            this.availability = num;
            return this;
        }

        public Builder gateway(Integer num) {
            this.gateway = num;
            return this;
        }

        public Builder min_version_ios(Integer num) {
            this.min_version_ios = num;
            return this;
        }

        public Builder min_version_android(Integer num) {
            this.min_version_android = num;
            return this;
        }

        public Builder flag(Long l) {
            this.flag = l;
            return this;
        }

        public ChannelInfoProto build() {
            Integer num = this.channel_id;
            if (num != null) {
                return new ChannelInfoProto(num, this.name, this.description, this.icon, this.type, this.priority, this.currency, this.discount, this.extra_data, this.txn_min, this.txn_max, this.message, this.availability, this.gateway, this.min_version_ios, this.min_version_android, this.flag, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(num, BaseApplication.DATA_KEY_CHANNEL_ID);
        }
    }

    private static final class ProtoAdapter_ChannelInfoProto extends ProtoAdapter<ChannelInfoProto> {
        ProtoAdapter_ChannelInfoProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ChannelInfoProto.class);
        }

        public int encodedSize(ChannelInfoProto channelInfoProto) {
            int i = 0;
            int encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(1, channelInfoProto.channel_id) + (channelInfoProto.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, channelInfoProto.name) : 0) + (channelInfoProto.description != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, channelInfoProto.description) : 0) + (channelInfoProto.icon != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, channelInfoProto.icon) : 0) + (channelInfoProto.type != null ? ProtoAdapter.UINT32.encodedSizeWithTag(5, channelInfoProto.type) : 0) + (channelInfoProto.priority != null ? ProtoAdapter.UINT32.encodedSizeWithTag(6, channelInfoProto.priority) : 0) + (channelInfoProto.currency != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, channelInfoProto.currency) : 0) + (channelInfoProto.discount != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(8, channelInfoProto.discount) : 0) + (channelInfoProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, channelInfoProto.extra_data) : 0) + (channelInfoProto.txn_min != null ? ProtoAdapter.UINT64.encodedSizeWithTag(10, channelInfoProto.txn_min) : 0) + (channelInfoProto.txn_max != null ? ProtoAdapter.UINT64.encodedSizeWithTag(11, channelInfoProto.txn_max) : 0) + (channelInfoProto.message != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, channelInfoProto.message) : 0) + (channelInfoProto.availability != null ? ProtoAdapter.UINT32.encodedSizeWithTag(13, channelInfoProto.availability) : 0) + (channelInfoProto.gateway != null ? ProtoAdapter.UINT32.encodedSizeWithTag(14, channelInfoProto.gateway) : 0) + (channelInfoProto.min_version_ios != null ? ProtoAdapter.UINT32.encodedSizeWithTag(15, channelInfoProto.min_version_ios) : 0) + (channelInfoProto.min_version_android != null ? ProtoAdapter.UINT32.encodedSizeWithTag(16, channelInfoProto.min_version_android) : 0);
            if (channelInfoProto.flag != null) {
                i = ProtoAdapter.UINT64.encodedSizeWithTag(17, channelInfoProto.flag);
            }
            return encodedSizeWithTag + i + channelInfoProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, ChannelInfoProto channelInfoProto) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, channelInfoProto.channel_id);
            if (channelInfoProto.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, channelInfoProto.name);
            }
            if (channelInfoProto.description != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, channelInfoProto.description);
            }
            if (channelInfoProto.icon != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, channelInfoProto.icon);
            }
            if (channelInfoProto.type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 5, channelInfoProto.type);
            }
            if (channelInfoProto.priority != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 6, channelInfoProto.priority);
            }
            if (channelInfoProto.currency != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, channelInfoProto.currency);
            }
            if (channelInfoProto.discount != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 8, channelInfoProto.discount);
            }
            if (channelInfoProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, channelInfoProto.extra_data);
            }
            if (channelInfoProto.txn_min != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 10, channelInfoProto.txn_min);
            }
            if (channelInfoProto.txn_max != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 11, channelInfoProto.txn_max);
            }
            if (channelInfoProto.message != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, channelInfoProto.message);
            }
            if (channelInfoProto.availability != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 13, channelInfoProto.availability);
            }
            if (channelInfoProto.gateway != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 14, channelInfoProto.gateway);
            }
            if (channelInfoProto.min_version_ios != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 15, channelInfoProto.min_version_ios);
            }
            if (channelInfoProto.min_version_android != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 16, channelInfoProto.min_version_android);
            }
            if (channelInfoProto.flag != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 17, channelInfoProto.flag);
            }
            protoWriter.writeBytes(channelInfoProto.unknownFields());
        }

        public ChannelInfoProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 2:
                            builder.name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.description(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.icon(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.type(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 6:
                            builder.priority(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 7:
                            builder.currency(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.discount(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 9:
                            builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.txn_min(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 11:
                            builder.txn_max(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 12:
                            builder.message(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.availability(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 14:
                            builder.gateway(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 15:
                            builder.min_version_ios(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 16:
                            builder.min_version_android(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 17:
                            builder.flag(ProtoAdapter.UINT64.decode(protoReader));
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

        public ChannelInfoProto redact(ChannelInfoProto channelInfoProto) {
            Builder newBuilder = channelInfoProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
