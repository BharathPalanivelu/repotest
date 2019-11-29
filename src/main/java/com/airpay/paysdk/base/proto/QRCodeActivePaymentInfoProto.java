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

public final class QRCodeActivePaymentInfoProto extends Message<QRCodeActivePaymentInfoProto, Builder> {
    public static final ProtoAdapter<QRCodeActivePaymentInfoProto> ADAPTER = new ProtoAdapter_QRCodeActivePaymentInfoProto();
    public static final Integer DEFAULT_FLAG = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer flag;
    @WireField(adapter = "com.airpay.protocol.protobuf.ShoppingCartProto#ADAPTER", tag = 1)
    public final ShoppingCartProto shopping_cart;

    public QRCodeActivePaymentInfoProto(ShoppingCartProto shoppingCartProto, Integer num) {
        this(shoppingCartProto, num, f.f32736b);
    }

    public QRCodeActivePaymentInfoProto(ShoppingCartProto shoppingCartProto, Integer num, f fVar) {
        super(ADAPTER, fVar);
        this.shopping_cart = shoppingCartProto;
        this.flag = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.shopping_cart = this.shopping_cart;
        builder.flag = this.flag;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QRCodeActivePaymentInfoProto)) {
            return false;
        }
        QRCodeActivePaymentInfoProto qRCodeActivePaymentInfoProto = (QRCodeActivePaymentInfoProto) obj;
        if (!unknownFields().equals(qRCodeActivePaymentInfoProto.unknownFields()) || !Internal.equals(this.shopping_cart, qRCodeActivePaymentInfoProto.shopping_cart) || !Internal.equals(this.flag, qRCodeActivePaymentInfoProto.flag)) {
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
        ShoppingCartProto shoppingCartProto = this.shopping_cart;
        int i2 = 0;
        int hashCode2 = (hashCode + (shoppingCartProto != null ? shoppingCartProto.hashCode() : 0)) * 37;
        Integer num = this.flag;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.shopping_cart != null) {
            sb.append(", shopping_cart=");
            sb.append(this.shopping_cart);
        }
        if (this.flag != null) {
            sb.append(", flag=");
            sb.append(this.flag);
        }
        StringBuilder replace = sb.replace(0, 2, "QRCodeActivePaymentInfoProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<QRCodeActivePaymentInfoProto, Builder> {
        public Integer flag;
        public ShoppingCartProto shopping_cart;

        public Builder shopping_cart(ShoppingCartProto shoppingCartProto) {
            this.shopping_cart = shoppingCartProto;
            return this;
        }

        public Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        public QRCodeActivePaymentInfoProto build() {
            return new QRCodeActivePaymentInfoProto(this.shopping_cart, this.flag, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_QRCodeActivePaymentInfoProto extends ProtoAdapter<QRCodeActivePaymentInfoProto> {
        ProtoAdapter_QRCodeActivePaymentInfoProto() {
            super(FieldEncoding.LENGTH_DELIMITED, QRCodeActivePaymentInfoProto.class);
        }

        public int encodedSize(QRCodeActivePaymentInfoProto qRCodeActivePaymentInfoProto) {
            int i = 0;
            int encodedSizeWithTag = qRCodeActivePaymentInfoProto.shopping_cart != null ? ShoppingCartProto.ADAPTER.encodedSizeWithTag(1, qRCodeActivePaymentInfoProto.shopping_cart) : 0;
            if (qRCodeActivePaymentInfoProto.flag != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(2, qRCodeActivePaymentInfoProto.flag);
            }
            return encodedSizeWithTag + i + qRCodeActivePaymentInfoProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, QRCodeActivePaymentInfoProto qRCodeActivePaymentInfoProto) throws IOException {
            if (qRCodeActivePaymentInfoProto.shopping_cart != null) {
                ShoppingCartProto.ADAPTER.encodeWithTag(protoWriter, 1, qRCodeActivePaymentInfoProto.shopping_cart);
            }
            if (qRCodeActivePaymentInfoProto.flag != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, qRCodeActivePaymentInfoProto.flag);
            }
            protoWriter.writeBytes(qRCodeActivePaymentInfoProto.unknownFields());
        }

        public QRCodeActivePaymentInfoProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.shopping_cart(ShoppingCartProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.flag(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public QRCodeActivePaymentInfoProto redact(QRCodeActivePaymentInfoProto qRCodeActivePaymentInfoProto) {
            Builder newBuilder = qRCodeActivePaymentInfoProto.newBuilder();
            if (newBuilder.shopping_cart != null) {
                newBuilder.shopping_cart = ShoppingCartProto.ADAPTER.redact(newBuilder.shopping_cart);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
