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

public final class PaymentOrderActionRequestProto extends Message<PaymentOrderActionRequestProto, Builder> {
    public static final ProtoAdapter<PaymentOrderActionRequestProto> ADAPTER = new ProtoAdapter_PaymentOrderActionRequestProto();
    public static final String DEFAULT_SECURE_TOKEN = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.PacketHeaderProto#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final PacketHeaderProto header;
    @WireField(adapter = "com.airpay.protocol.protobuf.OrderProto#ADAPTER", tag = 2)
    public final OrderProto order;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String secure_token;
    @WireField(adapter = "com.airpay.protocol.protobuf.ShoppingCartProto#ADAPTER", tag = 3)
    public final ShoppingCartProto shopping_cart;

    public PaymentOrderActionRequestProto(PacketHeaderProto packetHeaderProto, OrderProto orderProto, ShoppingCartProto shoppingCartProto, String str) {
        this(packetHeaderProto, orderProto, shoppingCartProto, str, f.f32736b);
    }

    public PaymentOrderActionRequestProto(PacketHeaderProto packetHeaderProto, OrderProto orderProto, ShoppingCartProto shoppingCartProto, String str, f fVar) {
        super(ADAPTER, fVar);
        this.header = packetHeaderProto;
        this.order = orderProto;
        this.shopping_cart = shoppingCartProto;
        this.secure_token = str;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.order = this.order;
        builder.shopping_cart = this.shopping_cart;
        builder.secure_token = this.secure_token;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOrderActionRequestProto)) {
            return false;
        }
        PaymentOrderActionRequestProto paymentOrderActionRequestProto = (PaymentOrderActionRequestProto) obj;
        if (!unknownFields().equals(paymentOrderActionRequestProto.unknownFields()) || !this.header.equals(paymentOrderActionRequestProto.header) || !Internal.equals(this.order, paymentOrderActionRequestProto.order) || !Internal.equals(this.shopping_cart, paymentOrderActionRequestProto.shopping_cart) || !Internal.equals(this.secure_token, paymentOrderActionRequestProto.secure_token)) {
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
        OrderProto orderProto = this.order;
        int i2 = 0;
        int hashCode2 = (hashCode + (orderProto != null ? orderProto.hashCode() : 0)) * 37;
        ShoppingCartProto shoppingCartProto = this.shopping_cart;
        int hashCode3 = (hashCode2 + (shoppingCartProto != null ? shoppingCartProto.hashCode() : 0)) * 37;
        String str = this.secure_token;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=");
        sb.append(this.header);
        if (this.order != null) {
            sb.append(", order=");
            sb.append(this.order);
        }
        if (this.shopping_cart != null) {
            sb.append(", shopping_cart=");
            sb.append(this.shopping_cart);
        }
        if (this.secure_token != null) {
            sb.append(", secure_token=");
            sb.append(this.secure_token);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentOrderActionRequestProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentOrderActionRequestProto, Builder> {
        public PacketHeaderProto header;
        public OrderProto order;
        public String secure_token;
        public ShoppingCartProto shopping_cart;

        public Builder header(PacketHeaderProto packetHeaderProto) {
            this.header = packetHeaderProto;
            return this;
        }

        public Builder order(OrderProto orderProto) {
            this.order = orderProto;
            return this;
        }

        public Builder shopping_cart(ShoppingCartProto shoppingCartProto) {
            this.shopping_cart = shoppingCartProto;
            return this;
        }

        public Builder secure_token(String str) {
            this.secure_token = str;
            return this;
        }

        public PaymentOrderActionRequestProto build() {
            PacketHeaderProto packetHeaderProto = this.header;
            if (packetHeaderProto != null) {
                return new PaymentOrderActionRequestProto(packetHeaderProto, this.order, this.shopping_cart, this.secure_token, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(packetHeaderProto, "header");
        }
    }

    private static final class ProtoAdapter_PaymentOrderActionRequestProto extends ProtoAdapter<PaymentOrderActionRequestProto> {
        ProtoAdapter_PaymentOrderActionRequestProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentOrderActionRequestProto.class);
        }

        public int encodedSize(PaymentOrderActionRequestProto paymentOrderActionRequestProto) {
            int i = 0;
            int encodedSizeWithTag = PacketHeaderProto.ADAPTER.encodedSizeWithTag(1, paymentOrderActionRequestProto.header) + (paymentOrderActionRequestProto.order != null ? OrderProto.ADAPTER.encodedSizeWithTag(2, paymentOrderActionRequestProto.order) : 0) + (paymentOrderActionRequestProto.shopping_cart != null ? ShoppingCartProto.ADAPTER.encodedSizeWithTag(3, paymentOrderActionRequestProto.shopping_cart) : 0);
            if (paymentOrderActionRequestProto.secure_token != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, paymentOrderActionRequestProto.secure_token);
            }
            return encodedSizeWithTag + i + paymentOrderActionRequestProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentOrderActionRequestProto paymentOrderActionRequestProto) throws IOException {
            PacketHeaderProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentOrderActionRequestProto.header);
            if (paymentOrderActionRequestProto.order != null) {
                OrderProto.ADAPTER.encodeWithTag(protoWriter, 2, paymentOrderActionRequestProto.order);
            }
            if (paymentOrderActionRequestProto.shopping_cart != null) {
                ShoppingCartProto.ADAPTER.encodeWithTag(protoWriter, 3, paymentOrderActionRequestProto.shopping_cart);
            }
            if (paymentOrderActionRequestProto.secure_token != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, paymentOrderActionRequestProto.secure_token);
            }
            protoWriter.writeBytes(paymentOrderActionRequestProto.unknownFields());
        }

        public PaymentOrderActionRequestProto decode(ProtoReader protoReader) throws IOException {
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
                } else if (nextTag == 3) {
                    builder.shopping_cart(ShoppingCartProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.secure_token(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public PaymentOrderActionRequestProto redact(PaymentOrderActionRequestProto paymentOrderActionRequestProto) {
            Builder newBuilder = paymentOrderActionRequestProto.newBuilder();
            newBuilder.header = PacketHeaderProto.ADAPTER.redact(newBuilder.header);
            if (newBuilder.order != null) {
                newBuilder.order = OrderProto.ADAPTER.redact(newBuilder.order);
            }
            if (newBuilder.shopping_cart != null) {
                newBuilder.shopping_cart = ShoppingCartProto.ADAPTER.redact(newBuilder.shopping_cart);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
