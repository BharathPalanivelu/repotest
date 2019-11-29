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
import java.util.List;

public final class BankAccountListGetReplyProto extends Message<BankAccountListGetReplyProto, Builder> {
    public static final ProtoAdapter<BankAccountListGetReplyProto> ADAPTER = new ProtoAdapter_BankAccountListGetReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.BankAccountProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<BankAccountProto> bank_accounts;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public BankAccountListGetReplyProto(PacketHeaderProto packetHeaderProto, List<BankAccountProto> list) {
        this(packetHeaderProto, list, f.f32736b);
    }

    public BankAccountListGetReplyProto(PacketHeaderProto packetHeaderProto, List<BankAccountProto> list, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.bank_accounts = Internal.immutableCopyOf("bank_accounts", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.bank_accounts = Internal.copyOf("bank_accounts", this.bank_accounts);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankAccountListGetReplyProto)) {
            return false;
        }
        BankAccountListGetReplyProto bankAccountListGetReplyProto = (BankAccountListGetReplyProto) obj;
        if (!unknownFields().equals(bankAccountListGetReplyProto.unknownFields()) || !this.header.equals(bankAccountListGetReplyProto.header) || !this.bank_accounts.equals(bankAccountListGetReplyProto.bank_accounts)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.bank_accounts.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.bank_accounts.isEmpty()) {
            sb.append(", bank_accounts=");
            sb.append(this.bank_accounts);
        }
        StringBuilder replace = sb.replace(0, 2, "BankAccountListGetReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BankAccountListGetReplyProto, Builder> {
        public List<BankAccountProto> bank_accounts = Internal.newMutableList();
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder bank_accounts(List<BankAccountProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.bank_accounts = list;
            return this;
        }

        public BankAccountListGetReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new BankAccountListGetReplyProto(packetHeaderProto, this.bank_accounts, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_BankAccountListGetReplyProto extends ProtoAdapter<BankAccountListGetReplyProto> {
        ProtoAdapter_BankAccountListGetReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, BankAccountListGetReplyProto.class);
        }

        public int encodedSize(BankAccountListGetReplyProto bankAccountListGetReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, bankAccountListGetReplyProto.header) + BankAccountProto.ADAPTER.asRepeated().encodedSizeWithTag(2, bankAccountListGetReplyProto.bank_accounts) + bankAccountListGetReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, BankAccountListGetReplyProto bankAccountListGetReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, bankAccountListGetReplyProto.header);
            BankAccountProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, bankAccountListGetReplyProto.bank_accounts);
            protoWriter.writeBytes(bankAccountListGetReplyProto.unknownFields());
        }

        public BankAccountListGetReplyProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.header(PacketHeaderProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.bank_accounts.add(BankAccountProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public BankAccountListGetReplyProto redact(BankAccountListGetReplyProto bankAccountListGetReplyProto) {
            Builder newBuilder = bankAccountListGetReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.bank_accounts, BankAccountProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
