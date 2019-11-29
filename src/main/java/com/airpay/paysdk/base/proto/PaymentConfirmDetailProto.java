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

public final class PaymentConfirmDetailProto extends Message<PaymentConfirmDetailProto, Builder> {
    public static final ProtoAdapter<PaymentConfirmDetailProto> ADAPTER = new ProtoAdapter_PaymentConfirmDetailProto();
    public static final Integer DEFAULT_ALLOWED_AUTH_METHODS = 0;
    public static final String DEFAULT_PAYEE_ICON_URL = "";
    public static final String DEFAULT_PAYEE_NAME = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer allowed_auth_methods;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String payee_icon_url;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String payee_name;
    @WireField(adapter = "com.airpay.protocol.protobuf.ShoppingCartProto#ADAPTER", tag = 1)
    public final ShoppingCartProto shopping_cart;

    public PaymentConfirmDetailProto(ShoppingCartProto shoppingCartProto, String str, String str2, Integer num) {
        this(shoppingCartProto, str, str2, num, f.f32736b);
    }

    public PaymentConfirmDetailProto(ShoppingCartProto shoppingCartProto, String str, String str2, Integer num, f fVar) {
        super(ADAPTER, fVar);
        this.shopping_cart = shoppingCartProto;
        this.payee_name = str;
        this.payee_icon_url = str2;
        this.allowed_auth_methods = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.shopping_cart = this.shopping_cart;
        builder.payee_name = this.payee_name;
        builder.payee_icon_url = this.payee_icon_url;
        builder.allowed_auth_methods = this.allowed_auth_methods;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentConfirmDetailProto)) {
            return false;
        }
        PaymentConfirmDetailProto paymentConfirmDetailProto = (PaymentConfirmDetailProto) obj;
        if (!unknownFields().equals(paymentConfirmDetailProto.unknownFields()) || !Internal.equals(this.shopping_cart, paymentConfirmDetailProto.shopping_cart) || !Internal.equals(this.payee_name, paymentConfirmDetailProto.payee_name) || !Internal.equals(this.payee_icon_url, paymentConfirmDetailProto.payee_icon_url) || !Internal.equals(this.allowed_auth_methods, paymentConfirmDetailProto.allowed_auth_methods)) {
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
        String str = this.payee_name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.payee_icon_url;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.allowed_auth_methods;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.shopping_cart != null) {
            sb.append(", shopping_cart=");
            sb.append(this.shopping_cart);
        }
        if (this.payee_name != null) {
            sb.append(", payee_name=");
            sb.append(this.payee_name);
        }
        if (this.payee_icon_url != null) {
            sb.append(", payee_icon_url=");
            sb.append(this.payee_icon_url);
        }
        if (this.allowed_auth_methods != null) {
            sb.append(", allowed_auth_methods=");
            sb.append(this.allowed_auth_methods);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentConfirmDetailProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentConfirmDetailProto, Builder> {
        public Integer allowed_auth_methods;
        public String payee_icon_url;
        public String payee_name;
        public ShoppingCartProto shopping_cart;

        public Builder shopping_cart(ShoppingCartProto shoppingCartProto) {
            this.shopping_cart = shoppingCartProto;
            return this;
        }

        public Builder payee_name(String str) {
            this.payee_name = str;
            return this;
        }

        public Builder payee_icon_url(String str) {
            this.payee_icon_url = str;
            return this;
        }

        public Builder allowed_auth_methods(Integer num) {
            this.allowed_auth_methods = num;
            return this;
        }

        public PaymentConfirmDetailProto build() {
            return new PaymentConfirmDetailProto(this.shopping_cart, this.payee_name, this.payee_icon_url, this.allowed_auth_methods, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_PaymentConfirmDetailProto extends ProtoAdapter<PaymentConfirmDetailProto> {
        ProtoAdapter_PaymentConfirmDetailProto() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentConfirmDetailProto.class);
        }

        public int encodedSize(PaymentConfirmDetailProto paymentConfirmDetailProto) {
            int i = 0;
            int encodedSizeWithTag = (paymentConfirmDetailProto.shopping_cart != null ? ShoppingCartProto.ADAPTER.encodedSizeWithTag(1, paymentConfirmDetailProto.shopping_cart) : 0) + (paymentConfirmDetailProto.payee_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, paymentConfirmDetailProto.payee_name) : 0) + (paymentConfirmDetailProto.payee_icon_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, paymentConfirmDetailProto.payee_icon_url) : 0);
            if (paymentConfirmDetailProto.allowed_auth_methods != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(11, paymentConfirmDetailProto.allowed_auth_methods);
            }
            return encodedSizeWithTag + i + paymentConfirmDetailProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, PaymentConfirmDetailProto paymentConfirmDetailProto) throws IOException {
            if (paymentConfirmDetailProto.shopping_cart != null) {
                ShoppingCartProto.ADAPTER.encodeWithTag(protoWriter, 1, paymentConfirmDetailProto.shopping_cart);
            }
            if (paymentConfirmDetailProto.payee_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, paymentConfirmDetailProto.payee_name);
            }
            if (paymentConfirmDetailProto.payee_icon_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, paymentConfirmDetailProto.payee_icon_url);
            }
            if (paymentConfirmDetailProto.allowed_auth_methods != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 11, paymentConfirmDetailProto.allowed_auth_methods);
            }
            protoWriter.writeBytes(paymentConfirmDetailProto.unknownFields());
        }

        public PaymentConfirmDetailProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.shopping_cart(ShoppingCartProto.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.payee_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.payee_icon_url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 11) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.allowed_auth_methods(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public PaymentConfirmDetailProto redact(PaymentConfirmDetailProto paymentConfirmDetailProto) {
            Builder newBuilder = paymentConfirmDetailProto.newBuilder();
            if (newBuilder.shopping_cart != null) {
                newBuilder.shopping_cart = ShoppingCartProto.ADAPTER.redact(newBuilder.shopping_cart);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
