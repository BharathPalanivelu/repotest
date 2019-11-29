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

public final class PaymentOrderExecuteReplyProto extends Message<PaymentOrderExecuteReplyProto, Builder> {
    public static final ProtoAdapter<PaymentOrderExecuteReplyProto> ADAPTER = new ProtoAdapter_PaymentOrderExecuteReplyProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.protocol.protobuf.OrderProto#ADAPTER", tag = 2)
    public final OrderProto order;
    @WireField(adapter = "com.airpay.protocol.protobuf.ShoppingCartProto#ADAPTER", tag = 3)
    public final ShoppingCartProto shopping_cart;

    public PaymentOrderExecuteReplyProto(PacketHeaderProto packetHeaderProto, ShoppingCartProto shoppingCartProto, OrderProto orderProto) {
        this(packetHeaderProto, shoppingCartProto, orderProto, f.f32736b);
    }

    public PaymentOrderExecuteReplyProto(PacketHeaderProto packetHeaderProto, ShoppingCartProto shoppingCartProto, OrderProto orderProto, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.shopping_cart = shoppingCartProto;
        this.order = orderProto;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.shopping_cart = this.shopping_cart;
        builder.order = this.order;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderExecuteReplyProto)) {
            return false;
        }
        PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto = (PaymentOrderExecuteReplyProto) obj;
        if (!unknownFields().equals(paymentOrderExecuteReplyProto.unknownFields()) || !this.header.equals(paymentOrderExecuteReplyProto.header) || !Internal.equals(this.shopping_cart, paymentOrderExecuteReplyProto.shopping_cart) || !Internal.equals(this.order, paymentOrderExecuteReplyProto.order)) {
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
        ShoppingCartProto shoppingCartProto = this.shopping_cart;
        int i2 = 0;
        int hashCode2 = (hashCode + (shoppingCartProto != null ? shoppingCartProto.hashCode() : 0)) * 37;
        OrderProto orderProto = this.order;
        if (orderProto != null) {
            i2 = orderProto.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.shopping_cart != null) {
            sb.append(", shopping_cart=");
            sb.append(this.shopping_cart);
        }
        if (this.order != null) {
            sb.append(", order=");
            sb.append(this.order);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderExecuteReplyProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderExecuteReplyProto, Builder> {
        public PacketHeaderProto header;
        public OrderProto order;
        public ShoppingCartProto shopping_cart;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder shopping_cart(ShoppingCartProto shoppingCartProto) {
            this.shopping_cart = shoppingCartProto;
            return this;
        }

        public Builder order(OrderProto orderProto) {
            this.order = orderProto;
            return this;
        }

        public PaymentOrderExecuteReplyProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderExecuteReplyProto(packetHeaderProto, this.shopping_cart, this.order, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderExecuteReplyProto extends ProtoAdapter<PaymentOrderExecuteReplyProto> {
        ProtoAdapter_PaymentOrderExecuteReplyProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderExecuteReplyProto.class);
        }

        public int encodedSize(PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderExecuteReplyProto.header) + (paymentOrderExecuteReplyProto.shopping_cart != null ? ShoppingCartProto.ADAPTER.encodedSizeWithTag(3, paymentOrderExecuteReplyProto.shopping_cart) : 0);
            if (paymentOrderExecuteReplyProto.order != null) {
                i = OrderProto.ADAPTER.encodedSizeWithTag(2, paymentOrderExecuteReplyProto.order);
            }
            return encodedSizeWithTag + i + paymentOrderExecuteReplyProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderExecuteReplyProto.header);
            if (paymentOrderExecuteReplyProto.shopping_cart != null) {
                ShoppingCartProto.ADAPTER.encodeWithTag(protoWriter, 3, paymentOrderExecuteReplyProto.shopping_cart);
            }
            if (paymentOrderExecuteReplyProto.order != null) {
                OrderProto.ADAPTER.encodeWithTag(protoWriter, 2, paymentOrderExecuteReplyProto.order);
            }
            protoWriter.writeBytes(paymentOrderExecuteReplyProto.unknownFields());
        }

        public PaymentOrderExecuteReplyProto decode(ProtoReader protoReader) throws IOException {
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
                    builder.order(OrderProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.shopping_cart(ShoppingCartProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public PaymentOrderExecuteReplyProto redact(PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) {
            Builder newBuilder = paymentOrderExecuteReplyProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            if (newBuilder.shopping_cart != null) {
                newBuilder.shopping_cart = ShoppingCartProto.ADAPTER.redact(newBuilder.shopping_cart);
            }
            if (newBuilder.order != null) {
                newBuilder.order = OrderProto.ADAPTER.redact(newBuilder.order);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
