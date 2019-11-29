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

public final class BillAccountListGetRequestProto extends Message<BillAccountListGetRequestProto, Builder> {
    public static final ProtoAdapter<BillAccountListGetRequestProto> ADAPTER = new ProtoAdapter_BillAccountListGetRequestProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", label = WireField.Label.REPEATED, tag = 2)
    public final List<Long> bill_account_id_list;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;

    public BillAccountListGetRequestProto(PacketHeaderProto packetHeaderProto, List<Long> list) {
        this(packetHeaderProto, list, f.f32736b);
    }

    public BillAccountListGetRequestProto(PacketHeaderProto packetHeaderProto, List<Long> list, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.bill_account_id_list = Internal.immutableCopyOf("bill_account_id_list", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.bill_account_id_list = Internal.copyOf("bill_account_id_list", this.bill_account_id_list);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BillAccountListGetRequestProto)) {
            return false;
        }
        BillAccountListGetRequestProto billAccountListGetRequestProto = (BillAccountListGetRequestProto) obj;
        if (!unknownFields().equals(billAccountListGetRequestProto.unknownFields()) || !this.header.equals(billAccountListGetRequestProto.header) || !this.bill_account_id_list.equals(billAccountListGetRequestProto.bill_account_id_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.bill_account_id_list.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (!this.bill_account_id_list.isEmpty()) {
            sb.append(", bill_account_id_list=");
            sb.append(this.bill_account_id_list);
        }
        StringBuilder replace = sb.replace(0, 2, "BillAccountListGetRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BillAccountListGetRequestProto, Builder> {
        public List<Long> bill_account_id_list = Internal.newMutableList();
        public PacketHeaderProto header;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder bill_account_id_list(List<Long> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.bill_account_id_list = list;
            return this;
        }

        public BillAccountListGetRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new BillAccountListGetRequestProto(packetHeaderProto, this.bill_account_id_list, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_BillAccountListGetRequestProto extends ProtoAdapter<BillAccountListGetRequestProto> {
        ProtoAdapter_BillAccountListGetRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, BillAccountListGetRequestProto.class);
        }

        public int encodedSize(BillAccountListGetRequestProto billAccountListGetRequestProto) {
            return PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, billAccountListGetRequestProto.header) + ProtoAdapter.UINT64.asRepeated().encodedSizeWithTag(2, billAccountListGetRequestProto.bill_account_id_list) + billAccountListGetRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, BillAccountListGetRequestProto billAccountListGetRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, billAccountListGetRequestProto.header);
            ProtoAdapter.UINT64.asRepeated().encodeWithTag(protoWriter, 2, billAccountListGetRequestProto.bill_account_id_list);
            protoWriter.writeBytes(billAccountListGetRequestProto.unknownFields());
        }

        public BillAccountListGetRequestProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.bill_account_id_list.add(ProtoAdapter.UINT64.decode(protoReader));
                }
            }
        }

        public BillAccountListGetRequestProto redact(BillAccountListGetRequestProto billAccountListGetRequestProto) {
            Builder newBuilder = billAccountListGetRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
