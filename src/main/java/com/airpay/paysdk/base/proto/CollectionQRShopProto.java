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

public final class CollectionQRShopProto extends Message<CollectionQRShopProto, Builder> {
    public static final ProtoAdapter<CollectionQRShopProto> ADAPTER = new ProtoAdapter_CollectionQRShopProto();
    public static final Long DEFAULT_ADDRESS_BOOK_ID = 0L;
    public static final Long DEFAULT_BANK_ACCOUNT_ID = 0L;
    public static final String DEFAULT_COLLECTION_QR_TOKEN = "";
    public static final String DEFAULT_LATITUDE = "";
    public static final String DEFAULT_LOCATE_DETAIL = "";
    public static final String DEFAULT_LONGITUDE = "";
    public static final Long DEFAULT_OWNER_ID = 0L;
    public static final String DEFAULT_OWNER_NAME = "";
    public static final Long DEFAULT_SHOP_CATEGORY_ID = 0L;
    public static final String DEFAULT_SHOP_ERROR = "";
    public static final String DEFAULT_SHOP_ICON = "";
    public static final Long DEFAULT_SHOP_ID = 0L;
    public static final String DEFAULT_SHOP_NAME = "";
    public static final String DEFAULT_SHOP_PHOTO = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 12)
    public final Long address_book_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 14)
    public final Long bank_account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String collection_qr_token;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 10)
    public final String latitude;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 9)
    public final String locate_detail;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 11)
    public final String longitude;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 7)
    public final Long owner_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String owner_name;
    @WireField(adapter = "com.airpay.protocol.protobuf.CollectionQRPaymentOptionProto#ADAPTER", tag = 6)
    public final CollectionQRPaymentOptionProto payment_options;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 13)
    public final Long shop_category_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 8)
    public final String shop_error;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 5)
    public final String shop_icon;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 1)
    public final Long shop_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String shop_name;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 15)
    public final String shop_photo;

    public CollectionQRShopProto(Long l, String str, String str2, String str3, String str4, CollectionQRPaymentOptionProto collectionQRPaymentOptionProto, Long l2, String str5, String str6, String str7, String str8, Long l3, Long l4, Long l5, String str9) {
        this(l, str, str2, str3, str4, collectionQRPaymentOptionProto, l2, str5, str6, str7, str8, l3, l4, l5, str9, f.f32736b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionQRShopProto(Long l, String str, String str2, String str3, String str4, CollectionQRPaymentOptionProto collectionQRPaymentOptionProto, Long l2, String str5, String str6, String str7, String str8, Long l3, Long l4, Long l5, String str9, f fVar) {
        super(ADAPTER, fVar);
        this.shop_id = l;
        this.collection_qr_token = str;
        this.shop_name = str2;
        this.owner_name = str3;
        this.shop_icon = str4;
        this.payment_options = collectionQRPaymentOptionProto;
        this.owner_id = l2;
        this.shop_error = str5;
        this.locate_detail = str6;
        this.latitude = str7;
        this.longitude = str8;
        this.address_book_id = l3;
        this.shop_category_id = l4;
        this.bank_account_id = l5;
        this.shop_photo = str9;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.shop_id = this.shop_id;
        builder.collection_qr_token = this.collection_qr_token;
        builder.shop_name = this.shop_name;
        builder.owner_name = this.owner_name;
        builder.shop_icon = this.shop_icon;
        builder.payment_options = this.payment_options;
        builder.owner_id = this.owner_id;
        builder.shop_error = this.shop_error;
        builder.locate_detail = this.locate_detail;
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.address_book_id = this.address_book_id;
        builder.shop_category_id = this.shop_category_id;
        builder.bank_account_id = this.bank_account_id;
        builder.shop_photo = this.shop_photo;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionQRShopProto)) {
            return false;
        }
        CollectionQRShopProto collectionQRShopProto = (CollectionQRShopProto) obj;
        if (!unknownFields().equals(collectionQRShopProto.unknownFields()) || !Internal.equals(this.shop_id, collectionQRShopProto.shop_id) || !Internal.equals(this.collection_qr_token, collectionQRShopProto.collection_qr_token) || !Internal.equals(this.shop_name, collectionQRShopProto.shop_name) || !Internal.equals(this.owner_name, collectionQRShopProto.owner_name) || !Internal.equals(this.shop_icon, collectionQRShopProto.shop_icon) || !Internal.equals(this.payment_options, collectionQRShopProto.payment_options) || !Internal.equals(this.owner_id, collectionQRShopProto.owner_id) || !Internal.equals(this.shop_error, collectionQRShopProto.shop_error) || !Internal.equals(this.locate_detail, collectionQRShopProto.locate_detail) || !Internal.equals(this.latitude, collectionQRShopProto.latitude) || !Internal.equals(this.longitude, collectionQRShopProto.longitude) || !Internal.equals(this.address_book_id, collectionQRShopProto.address_book_id) || !Internal.equals(this.shop_category_id, collectionQRShopProto.shop_category_id) || !Internal.equals(this.bank_account_id, collectionQRShopProto.bank_account_id) || !Internal.equals(this.shop_photo, collectionQRShopProto.shop_photo)) {
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
        Long l = this.shop_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.collection_qr_token;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.shop_name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.owner_name;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.shop_icon;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        CollectionQRPaymentOptionProto collectionQRPaymentOptionProto = this.payment_options;
        int hashCode7 = (hashCode6 + (collectionQRPaymentOptionProto != null ? collectionQRPaymentOptionProto.hashCode() : 0)) * 37;
        Long l2 = this.owner_id;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str5 = this.shop_error;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.locate_detail;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.latitude;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.longitude;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Long l3 = this.address_book_id;
        int hashCode13 = (hashCode12 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.shop_category_id;
        int hashCode14 = (hashCode13 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.bank_account_id;
        int hashCode15 = (hashCode14 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str9 = this.shop_photo;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.shop_id != null) {
            sb.append(", shop_id=");
            sb.append(this.shop_id);
        }
        if (this.collection_qr_token != null) {
            sb.append(", collection_qr_token=");
            sb.append(this.collection_qr_token);
        }
        if (this.shop_name != null) {
            sb.append(", shop_name=");
            sb.append(this.shop_name);
        }
        if (this.owner_name != null) {
            sb.append(", owner_name=");
            sb.append(this.owner_name);
        }
        if (this.shop_icon != null) {
            sb.append(", shop_icon=");
            sb.append(this.shop_icon);
        }
        if (this.payment_options != null) {
            sb.append(", payment_options=");
            sb.append(this.payment_options);
        }
        if (this.owner_id != null) {
            sb.append(", owner_id=");
            sb.append(this.owner_id);
        }
        if (this.shop_error != null) {
            sb.append(", shop_error=");
            sb.append(this.shop_error);
        }
        if (this.locate_detail != null) {
            sb.append(", locate_detail=");
            sb.append(this.locate_detail);
        }
        if (this.latitude != null) {
            sb.append(", latitude=");
            sb.append(this.latitude);
        }
        if (this.longitude != null) {
            sb.append(", longitude=");
            sb.append(this.longitude);
        }
        if (this.address_book_id != null) {
            sb.append(", address_book_id=");
            sb.append(this.address_book_id);
        }
        if (this.shop_category_id != null) {
            sb.append(", shop_category_id=");
            sb.append(this.shop_category_id);
        }
        if (this.bank_account_id != null) {
            sb.append(", bank_account_id=");
            sb.append(this.bank_account_id);
        }
        if (this.shop_photo != null) {
            sb.append(", shop_photo=");
            sb.append(this.shop_photo);
        }
        StringBuilder replace = sb.replace(0, 2, "CollectionQRShopProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CollectionQRShopProto, Builder> {
        public Long address_book_id;
        public Long bank_account_id;
        public String collection_qr_token;
        public String latitude;
        public String locate_detail;
        public String longitude;
        public Long owner_id;
        public String owner_name;
        public CollectionQRPaymentOptionProto payment_options;
        public Long shop_category_id;
        public String shop_error;
        public String shop_icon;
        public Long shop_id;
        public String shop_name;
        public String shop_photo;

        public Builder shop_id(Long l) {
            this.shop_id = l;
            return this;
        }

        public Builder collection_qr_token(String str) {
            this.collection_qr_token = str;
            return this;
        }

        public Builder shop_name(String str) {
            this.shop_name = str;
            return this;
        }

        public Builder owner_name(String str) {
            this.owner_name = str;
            return this;
        }

        public Builder shop_icon(String str) {
            this.shop_icon = str;
            return this;
        }

        public Builder payment_options(CollectionQRPaymentOptionProto collectionQRPaymentOptionProto) {
            this.payment_options = collectionQRPaymentOptionProto;
            return this;
        }

        public Builder owner_id(Long l) {
            this.owner_id = l;
            return this;
        }

        public Builder shop_error(String str) {
            this.shop_error = str;
            return this;
        }

        public Builder locate_detail(String str) {
            this.locate_detail = str;
            return this;
        }

        public Builder latitude(String str) {
            this.latitude = str;
            return this;
        }

        public Builder longitude(String str) {
            this.longitude = str;
            return this;
        }

        public Builder address_book_id(Long l) {
            this.address_book_id = l;
            return this;
        }

        public Builder shop_category_id(Long l) {
            this.shop_category_id = l;
            return this;
        }

        public Builder bank_account_id(Long l) {
            this.bank_account_id = l;
            return this;
        }

        public Builder shop_photo(String str) {
            this.shop_photo = str;
            return this;
        }

        public CollectionQRShopProto build() {
            return new CollectionQRShopProto(this.shop_id, this.collection_qr_token, this.shop_name, this.owner_name, this.shop_icon, this.payment_options, this.owner_id, this.shop_error, this.locate_detail, this.latitude, this.longitude, this.address_book_id, this.shop_category_id, this.bank_account_id, this.shop_photo, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_CollectionQRShopProto extends ProtoAdapter<CollectionQRShopProto> {
        ProtoAdapter_CollectionQRShopProto() {
            super(FieldEncoding.LENGTH_DELIMITED, CollectionQRShopProto.class);
        }

        public int encodedSize(CollectionQRShopProto collectionQRShopProto) {
            int i = 0;
            int encodedSizeWithTag = (collectionQRShopProto.shop_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(1, collectionQRShopProto.shop_id) : 0) + (collectionQRShopProto.collection_qr_token != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, collectionQRShopProto.collection_qr_token) : 0) + (collectionQRShopProto.shop_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, collectionQRShopProto.shop_name) : 0) + (collectionQRShopProto.owner_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, collectionQRShopProto.owner_name) : 0) + (collectionQRShopProto.shop_icon != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, collectionQRShopProto.shop_icon) : 0) + (collectionQRShopProto.payment_options != null ? CollectionQRPaymentOptionProto.ADAPTER.encodedSizeWithTag(6, collectionQRShopProto.payment_options) : 0) + (collectionQRShopProto.owner_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(7, collectionQRShopProto.owner_id) : 0) + (collectionQRShopProto.shop_error != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, collectionQRShopProto.shop_error) : 0) + (collectionQRShopProto.locate_detail != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, collectionQRShopProto.locate_detail) : 0) + (collectionQRShopProto.latitude != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, collectionQRShopProto.latitude) : 0) + (collectionQRShopProto.longitude != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, collectionQRShopProto.longitude) : 0) + (collectionQRShopProto.address_book_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(12, collectionQRShopProto.address_book_id) : 0) + (collectionQRShopProto.shop_category_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(13, collectionQRShopProto.shop_category_id) : 0) + (collectionQRShopProto.bank_account_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(14, collectionQRShopProto.bank_account_id) : 0);
            if (collectionQRShopProto.shop_photo != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(15, collectionQRShopProto.shop_photo);
            }
            return encodedSizeWithTag + i + collectionQRShopProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, CollectionQRShopProto collectionQRShopProto) throws IOException {
            if (collectionQRShopProto.shop_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, collectionQRShopProto.shop_id);
            }
            if (collectionQRShopProto.collection_qr_token != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, collectionQRShopProto.collection_qr_token);
            }
            if (collectionQRShopProto.shop_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, collectionQRShopProto.shop_name);
            }
            if (collectionQRShopProto.owner_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, collectionQRShopProto.owner_name);
            }
            if (collectionQRShopProto.shop_icon != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, collectionQRShopProto.shop_icon);
            }
            if (collectionQRShopProto.payment_options != null) {
                CollectionQRPaymentOptionProto.ADAPTER.encodeWithTag(protoWriter, 6, collectionQRShopProto.payment_options);
            }
            if (collectionQRShopProto.owner_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 7, collectionQRShopProto.owner_id);
            }
            if (collectionQRShopProto.shop_error != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, collectionQRShopProto.shop_error);
            }
            if (collectionQRShopProto.locate_detail != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, collectionQRShopProto.locate_detail);
            }
            if (collectionQRShopProto.latitude != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, collectionQRShopProto.latitude);
            }
            if (collectionQRShopProto.longitude != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, collectionQRShopProto.longitude);
            }
            if (collectionQRShopProto.address_book_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 12, collectionQRShopProto.address_book_id);
            }
            if (collectionQRShopProto.shop_category_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 13, collectionQRShopProto.shop_category_id);
            }
            if (collectionQRShopProto.bank_account_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 14, collectionQRShopProto.bank_account_id);
            }
            if (collectionQRShopProto.shop_photo != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, collectionQRShopProto.shop_photo);
            }
            protoWriter.writeBytes(collectionQRShopProto.unknownFields());
        }

        public CollectionQRShopProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.shop_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 2:
                            builder.collection_qr_token(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.shop_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.owner_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.shop_icon(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.payment_options(CollectionQRPaymentOptionProto.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            builder.owner_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 8:
                            builder.shop_error(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.locate_detail(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.latitude(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.longitude(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 12:
                            builder.address_book_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 13:
                            builder.shop_category_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 14:
                            builder.bank_account_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 15:
                            builder.shop_photo(ProtoAdapter.STRING.decode(protoReader));
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

        public CollectionQRShopProto redact(CollectionQRShopProto collectionQRShopProto) {
            Builder newBuilder = collectionQRShopProto.newBuilder();
            if (newBuilder.payment_options != null) {
                newBuilder.payment_options = CollectionQRPaymentOptionProto.ADAPTER.redact(newBuilder.payment_options);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
