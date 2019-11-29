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

public final class CashCurrentGetReplyProto extends Message<CashCurrentGetReplyProto, Builder> {
    public static final ProtoAdapter<CashCurrentGetReplyProto> ADAPTER = new ProtoAdapter_CashCurrentGetReplyProto();
    public static final Long DEFAULT_CASH_BALANCE = 0L;
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 3)
    public final Long cash_balance;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String currency;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer update_time;

    public CashCurrentGetReplyProto(PacketHeaderProto packetHeaderProto, String str, Long l, Integer num) {
        this(packetHeaderProto, str, l, num, f.f32736b);
    }

    public CashCurrentGetReplyProto(PacketHeaderProto packetHeaderProto, String str, Long l, Integer num, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.currency = str;
        this.cash_balance = l;
        this.update_time = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.currency = this.currency;
        builder.cash_balance = this.cash_balance;
        builder.update_time = this.update_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CashCurrentGetReplyProto)) {
            return false;
        }
        CashCurrentGetReplyProto cashCurrentGetReplyProto = (CashCurrentGetReplyProto) obj;
        if (!unknownFields().equals(cashCurrentGetReplyProto.unknownFields()) || !this.header.equals(cashCurrentGetReplyProto.header) || !Internal.equals(this.currency, cashCurrentGetReplyProto.currency) || !Internal.equals(this.cash_balance, cashCurrentGetReplyProto.cash_balance) || !Internal.equals(this.update_time, cashCurrentGetReplyProto.update_time)) {
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
        String str = this.currency;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.cash_balance;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.update_time;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.currency != null) {
            sb.append(", currency=");
            sb.append(this.currency);
        }
        if (this.cash_balance != null) {
            sb.append(", cash_balance=");
            sb.append(this.cash_balance);
        }
        if (this.update_time != null) {
            sb.append(", update_time=");
            sb.append(this.update_time);
        }
        StringBuilder replace = sb.replace(0, 2, "CashCurrentGetReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CashCurrentGetReplyProto, Builder> {
        public Long cash_balance;
        public String currency;
        public PacketHeaderProto header;
        public Integer update_time;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder cash_balance(Long l) {
            this.cash_balance = l;
            return this;
        }

        public Builder update_time(Integer num) {
            this.update_time = num;
            return this;
        }

        public CashCurrentGetReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new CashCurrentGetReplyProto(packetHeaderProto, this.currency, this.cash_balance, this.update_time, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_CashCurrentGetReplyProto extends ProtoAdapter<CashCurrentGetReplyProto> {
        ProtoAdapter_CashCurrentGetReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, CashCurrentGetReplyProto.class);
        }

        public int encodedSize(CashCurrentGetReplyProto cashCurrentGetReplyProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, cashCurrentGetReplyProto.header) + (cashCurrentGetReplyProto.currency != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, cashCurrentGetReplyProto.currency) : 0) + (cashCurrentGetReplyProto.cash_balance != null ? ProtoAdapter.UINT64.encodedSizeWithTag(3, cashCurrentGetReplyProto.cash_balance) : 0);
            if (cashCurrentGetReplyProto.update_time != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(4, cashCurrentGetReplyProto.update_time);
            }
            return encodedSizeWithTag + i + cashCurrentGetReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, CashCurrentGetReplyProto cashCurrentGetReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, cashCurrentGetReplyProto.header);
            if (cashCurrentGetReplyProto.currency != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, cashCurrentGetReplyProto.currency);
            }
            if (cashCurrentGetReplyProto.cash_balance != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 3, cashCurrentGetReplyProto.cash_balance);
            }
            if (cashCurrentGetReplyProto.update_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, cashCurrentGetReplyProto.update_time);
            }
            protoWriter.writeBytes(cashCurrentGetReplyProto.unknownFields());
        }

        public CashCurrentGetReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.currency(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.cash_balance(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.update_time(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public CashCurrentGetReplyProto redact(CashCurrentGetReplyProto cashCurrentGetReplyProto) {
            Builder newBuilder = cashCurrentGetReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
