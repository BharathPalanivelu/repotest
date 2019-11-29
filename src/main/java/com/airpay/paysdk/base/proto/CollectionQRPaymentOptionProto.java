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

public final class CollectionQRPaymentOptionProto extends Message<CollectionQRPaymentOptionProto, Builder> {
    public static final ProtoAdapter<CollectionQRPaymentOptionProto> ADAPTER = new ProtoAdapter_CollectionQRPaymentOptionProto();
    public static final Boolean DEFAULT_BANK_ACCOUNT = false;
    public static final String DEFAULT_BANK_ACCOUNT_FEE = "";
    public static final Boolean DEFAULT_CASH = false;
    public static final String DEFAULT_CASH_FEE = "";
    public static final Boolean DEFAULT_CREDIT_CARD = false;
    public static final String DEFAULT_CREDIT_CARD_FEE = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean bank_account;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String bank_account_fee;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean cash;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 6)
    public final String cash_fee;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean credit_card;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 5)
    public final String credit_card_fee;

    public CollectionQRPaymentOptionProto(Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, String str3) {
        this(bool, bool2, bool3, str, str2, str3, f.f32736b);
    }

    public CollectionQRPaymentOptionProto(Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, String str3, f fVar) {
        super(ADAPTER, fVar);
        this.bank_account = bool;
        this.credit_card = bool2;
        this.cash = bool3;
        this.bank_account_fee = str;
        this.credit_card_fee = str2;
        this.cash_fee = str3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.bank_account = this.bank_account;
        builder.credit_card = this.credit_card;
        builder.cash = this.cash;
        builder.bank_account_fee = this.bank_account_fee;
        builder.credit_card_fee = this.credit_card_fee;
        builder.cash_fee = this.cash_fee;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionQRPaymentOptionProto)) {
            return false;
        }
        CollectionQRPaymentOptionProto collectionQRPaymentOptionProto = (CollectionQRPaymentOptionProto) obj;
        if (!unknownFields().equals(collectionQRPaymentOptionProto.unknownFields()) || !Internal.equals(this.bank_account, collectionQRPaymentOptionProto.bank_account) || !Internal.equals(this.credit_card, collectionQRPaymentOptionProto.credit_card) || !Internal.equals(this.cash, collectionQRPaymentOptionProto.cash) || !Internal.equals(this.bank_account_fee, collectionQRPaymentOptionProto.bank_account_fee) || !Internal.equals(this.credit_card_fee, collectionQRPaymentOptionProto.credit_card_fee) || !Internal.equals(this.cash_fee, collectionQRPaymentOptionProto.cash_fee)) {
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
        Boolean bool = this.bank_account;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.credit_card;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.cash;
        int hashCode4 = (hashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        String str = this.bank_account_fee;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.credit_card_fee;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cash_fee;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bank_account != null) {
            sb.append(", bank_account=");
            sb.append(this.bank_account);
        }
        if (this.credit_card != null) {
            sb.append(", credit_card=");
            sb.append(this.credit_card);
        }
        if (this.cash != null) {
            sb.append(", cash=");
            sb.append(this.cash);
        }
        if (this.bank_account_fee != null) {
            sb.append(", bank_account_fee=");
            sb.append(this.bank_account_fee);
        }
        if (this.credit_card_fee != null) {
            sb.append(", credit_card_fee=");
            sb.append(this.credit_card_fee);
        }
        if (this.cash_fee != null) {
            sb.append(", cash_fee=");
            sb.append(this.cash_fee);
        }
        StringBuilder replace = sb.replace(0, 2, "CollectionQRPaymentOptionProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CollectionQRPaymentOptionProto, Builder> {
        public Boolean bank_account;
        public String bank_account_fee;
        public Boolean cash;
        public String cash_fee;
        public Boolean credit_card;
        public String credit_card_fee;

        public Builder bank_account(Boolean bool) {
            this.bank_account = bool;
            return this;
        }

        public Builder credit_card(Boolean bool) {
            this.credit_card = bool;
            return this;
        }

        public Builder cash(Boolean bool) {
            this.cash = bool;
            return this;
        }

        public Builder bank_account_fee(String str) {
            this.bank_account_fee = str;
            return this;
        }

        public Builder credit_card_fee(String str) {
            this.credit_card_fee = str;
            return this;
        }

        public Builder cash_fee(String str) {
            this.cash_fee = str;
            return this;
        }

        public CollectionQRPaymentOptionProto build() {
            return new CollectionQRPaymentOptionProto(this.bank_account, this.credit_card, this.cash, this.bank_account_fee, this.credit_card_fee, this.cash_fee, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_CollectionQRPaymentOptionProto extends ProtoAdapter<CollectionQRPaymentOptionProto> {
        ProtoAdapter_CollectionQRPaymentOptionProto() {
            super(FieldEncoding.LENGTH_DELIMITED, CollectionQRPaymentOptionProto.class);
        }

        public int encodedSize(CollectionQRPaymentOptionProto collectionQRPaymentOptionProto) {
            int i = 0;
            int encodedSizeWithTag = (collectionQRPaymentOptionProto.bank_account != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, collectionQRPaymentOptionProto.bank_account) : 0) + (collectionQRPaymentOptionProto.credit_card != null ? ProtoAdapter.BOOL.encodedSizeWithTag(2, collectionQRPaymentOptionProto.credit_card) : 0) + (collectionQRPaymentOptionProto.cash != null ? ProtoAdapter.BOOL.encodedSizeWithTag(3, collectionQRPaymentOptionProto.cash) : 0) + (collectionQRPaymentOptionProto.bank_account_fee != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, collectionQRPaymentOptionProto.bank_account_fee) : 0) + (collectionQRPaymentOptionProto.credit_card_fee != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, collectionQRPaymentOptionProto.credit_card_fee) : 0);
            if (collectionQRPaymentOptionProto.cash_fee != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(6, collectionQRPaymentOptionProto.cash_fee);
            }
            return encodedSizeWithTag + i + collectionQRPaymentOptionProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, CollectionQRPaymentOptionProto collectionQRPaymentOptionProto) throws IOException {
            if (collectionQRPaymentOptionProto.bank_account != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, collectionQRPaymentOptionProto.bank_account);
            }
            if (collectionQRPaymentOptionProto.credit_card != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, collectionQRPaymentOptionProto.credit_card);
            }
            if (collectionQRPaymentOptionProto.cash != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, collectionQRPaymentOptionProto.cash);
            }
            if (collectionQRPaymentOptionProto.bank_account_fee != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, collectionQRPaymentOptionProto.bank_account_fee);
            }
            if (collectionQRPaymentOptionProto.credit_card_fee != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, collectionQRPaymentOptionProto.credit_card_fee);
            }
            if (collectionQRPaymentOptionProto.cash_fee != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, collectionQRPaymentOptionProto.cash_fee);
            }
            protoWriter.writeBytes(collectionQRPaymentOptionProto.unknownFields());
        }

        public CollectionQRPaymentOptionProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.bank_account(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 2:
                            builder.credit_card(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 3:
                            builder.cash(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 4:
                            builder.bank_account_fee(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.credit_card_fee(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.cash_fee(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public CollectionQRPaymentOptionProto redact(CollectionQRPaymentOptionProto collectionQRPaymentOptionProto) {
            Builder newBuilder = collectionQRPaymentOptionProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
