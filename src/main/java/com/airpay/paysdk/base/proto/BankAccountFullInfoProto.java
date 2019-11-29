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

public final class BankAccountFullInfoProto extends Message<BankAccountFullInfoProto, Builder> {
    public static final ProtoAdapter<BankAccountFullInfoProto> ADAPTER = new ProtoAdapter_BankAccountFullInfoProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.BankAccountProto#ADAPTER", tag = 1)
    public final BankAccountProto bank_account;
    @WireField(adapter = "com.airpay.protocol.protobuf.ChannelInfoProto#ADAPTER", tag = 2)
    public final ChannelInfoProto channel;

    public BankAccountFullInfoProto(BankAccountProto bankAccountProto, ChannelInfoProto channelInfoProto) {
        this(bankAccountProto, channelInfoProto, f.f32736b);
    }

    public BankAccountFullInfoProto(BankAccountProto bankAccountProto, ChannelInfoProto channelInfoProto, f fVar) {
        super(ADAPTER, fVar);
        this.bank_account = bankAccountProto;
        this.channel = channelInfoProto;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.bank_account = this.bank_account;
        builder.channel = this.channel;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankAccountFullInfoProto)) {
            return false;
        }
        BankAccountFullInfoProto bankAccountFullInfoProto = (BankAccountFullInfoProto) obj;
        if (!unknownFields().equals(bankAccountFullInfoProto.unknownFields()) || !Internal.equals(this.bank_account, bankAccountFullInfoProto.bank_account) || !Internal.equals(this.channel, bankAccountFullInfoProto.channel)) {
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
        BankAccountProto bankAccountProto = this.bank_account;
        int i2 = 0;
        int hashCode2 = (hashCode + (bankAccountProto != null ? bankAccountProto.hashCode() : 0)) * 37;
        ChannelInfoProto channelInfoProto = this.channel;
        if (channelInfoProto != null) {
            i2 = channelInfoProto.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bank_account != null) {
            sb.append(", bank_account=");
            sb.append(this.bank_account);
        }
        if (this.channel != null) {
            sb.append(", channel=");
            sb.append(this.channel);
        }
        StringBuilder replace = sb.replace(0, 2, "BankAccountFullInfoProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BankAccountFullInfoProto, Builder> {
        public BankAccountProto bank_account;
        public ChannelInfoProto channel;

        public Builder bank_account(BankAccountProto bankAccountProto) {
            this.bank_account = bankAccountProto;
            return this;
        }

        public Builder channel(ChannelInfoProto channelInfoProto) {
            this.channel = channelInfoProto;
            return this;
        }

        public BankAccountFullInfoProto build() {
            return new BankAccountFullInfoProto(this.bank_account, this.channel, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BankAccountFullInfoProto extends ProtoAdapter<BankAccountFullInfoProto> {
        ProtoAdapter_BankAccountFullInfoProto() {
            super(FieldEncoding.LENGTH_DELIMITED, BankAccountFullInfoProto.class);
        }

        public int encodedSize(BankAccountFullInfoProto bankAccountFullInfoProto) {
            int i = 0;
            int encodedSizeWithTag = bankAccountFullInfoProto.bank_account != null ? BankAccountProto.ADAPTER.encodedSizeWithTag(1, bankAccountFullInfoProto.bank_account) : 0;
            if (bankAccountFullInfoProto.channel != null) {
                i = ChannelInfoProto.ADAPTER.encodedSizeWithTag(2, bankAccountFullInfoProto.channel);
            }
            return encodedSizeWithTag + i + bankAccountFullInfoProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, BankAccountFullInfoProto bankAccountFullInfoProto) throws IOException {
            if (bankAccountFullInfoProto.bank_account != null) {
                BankAccountProto.ADAPTER.encodeWithTag(protoWriter, 1, bankAccountFullInfoProto.bank_account);
            }
            if (bankAccountFullInfoProto.channel != null) {
                ChannelInfoProto.ADAPTER.encodeWithTag(protoWriter, 2, bankAccountFullInfoProto.channel);
            }
            protoWriter.writeBytes(bankAccountFullInfoProto.unknownFields());
        }

        public BankAccountFullInfoProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.bank_account(BankAccountProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.channel(ChannelInfoProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public BankAccountFullInfoProto redact(BankAccountFullInfoProto bankAccountFullInfoProto) {
            Builder newBuilder = bankAccountFullInfoProto.newBuilder();
            if (newBuilder.bank_account != null) {
                newBuilder.bank_account = BankAccountProto.ADAPTER.redact(newBuilder.bank_account);
            }
            if (newBuilder.channel != null) {
                newBuilder.channel = ChannelInfoProto.ADAPTER.redact(newBuilder.channel);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
