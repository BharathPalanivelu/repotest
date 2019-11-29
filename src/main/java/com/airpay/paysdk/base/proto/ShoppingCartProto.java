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
import java.util.List;

public final class ShoppingCartProto extends Message<ShoppingCartProto, Builder> {
    public static final ProtoAdapter<ShoppingCartProto> ADAPTER = new ProtoAdapter_ShoppingCartProto();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.protocol.protobuf.OrderProto#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<OrderProto> orders;

    public ShoppingCartProto(List<OrderProto> list) {
        this(list, f.f32736b);
    }

    public ShoppingCartProto(List<OrderProto> list, f fVar) {
        super(ADAPTER, fVar);
        this.orders = Internal.immutableCopyOf("orders", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.orders = Internal.copyOf("orders", this.orders);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShoppingCartProto)) {
            return false;
        }
        ShoppingCartProto shoppingCartProto = (ShoppingCartProto) obj;
        if (!unknownFields().equals(shoppingCartProto.unknownFields()) || !this.orders.equals(shoppingCartProto.orders)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (unknownFields().hashCode() * 37) + this.orders.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.orders.isEmpty()) {
            sb.append(", orders=");
            sb.append(this.orders);
        }
        StringBuilder replace = sb.replace(0, 2, "ShoppingCartProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ShoppingCartProto, Builder> {
        public List<OrderProto> orders = Internal.newMutableList();

        public Builder orders(List<OrderProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.orders = list;
            return this;
        }

        public ShoppingCartProto build() {
            return new ShoppingCartProto(this.orders, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_ShoppingCartProto extends ProtoAdapter<ShoppingCartProto> {
        ProtoAdapter_ShoppingCartProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ShoppingCartProto.class);
        }

        public int encodedSize(ShoppingCartProto shoppingCartProto) {
            return OrderProto.ADAPTER.asRepeated().encodedSizeWithTag(1, shoppingCartProto.orders) + shoppingCartProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, ShoppingCartProto shoppingCartProto) throws IOException {
            OrderProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, shoppingCartProto.orders);
            protoWriter.writeBytes(shoppingCartProto.unknownFields());
        }

        public ShoppingCartProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.orders.add(OrderProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public ShoppingCartProto redact(ShoppingCartProto shoppingCartProto) {
            Builder newBuilder = shoppingCartProto.newBuilder();
            Internal.redactElements(newBuilder.orders, OrderProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
