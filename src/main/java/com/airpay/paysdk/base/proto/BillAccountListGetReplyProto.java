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

public final class BillAccountListGetReplyProto extends Message<BillAccountListGetReplyProto, Builder> {
    public static final ProtoAdapter<BillAccountListGetReplyProto> ADAPTER = new ProtoAdapter_BillAccountListGetReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.BillAccountProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<BillAccountProto> bill_accounts;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public BillAccountListGetReplyProto(PacketHeaderProto packetHeaderProto, List<BillAccountProto> list) {
        this(packetHeaderProto, list, f.f32736b);
    }

    public BillAccountListGetReplyProto(PacketHeaderProto packetHeaderProto, List<BillAccountProto> list, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.bill_accounts = Internal.immutableCopyOf("bill_accounts", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.bill_accounts = Internal.copyOf("bill_accounts", this.bill_accounts);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BillAccountListGetReplyProto)) {
            return false;
        }
        BillAccountListGetReplyProto billAccountListGetReplyProto = (BillAccountListGetReplyProto) obj;
        if (!unknownFields().equals(billAccountListGetReplyProto.unknownFields()) || !this.header.equals(billAccountListGetReplyProto.header) || !this.bill_accounts.equals(billAccountListGetReplyProto.bill_accounts)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.bill_accounts.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.bill_accounts.isEmpty()) {
            sb.append(", bill_accounts=");
            sb.append(this.bill_accounts);
        }
        StringBuilder replace = sb.replace(0, 2, "BillAccountListGetReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BillAccountListGetReplyProto, Builder> {
        public List<BillAccountProto> bill_accounts = Internal.newMutableList();
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder bill_accounts(List<BillAccountProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.bill_accounts = list;
            return this;
        }

        public BillAccountListGetReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new BillAccountListGetReplyProto(packetHeaderProto, this.bill_accounts, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_BillAccountListGetReplyProto extends ProtoAdapter<BillAccountListGetReplyProto> {
        ProtoAdapter_BillAccountListGetReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, BillAccountListGetReplyProto.class);
        }

        public int encodedSize(BillAccountListGetReplyProto billAccountListGetReplyProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, billAccountListGetReplyProto.header) + BillAccountProto.ADAPTER.asRepeated().encodedSizeWithTag(2, billAccountListGetReplyProto.bill_accounts) + billAccountListGetReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, BillAccountListGetReplyProto billAccountListGetReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, billAccountListGetReplyProto.header);
            BillAccountProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, billAccountListGetReplyProto.bill_accounts);
            protoWriter.writeBytes(billAccountListGetReplyProto.unknownFields());
        }

        public BillAccountListGetReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.bill_accounts.add(BillAccountProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public BillAccountListGetReplyProto redact(BillAccountListGetReplyProto billAccountListGetReplyProto) {
            Builder newBuilder = billAccountListGetReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            Internal.redactElements(newBuilder.bill_accounts, BillAccountProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
