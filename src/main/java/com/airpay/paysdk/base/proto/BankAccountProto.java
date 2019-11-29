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

public final class BankAccountProto extends Message<BankAccountProto, Builder> {
    public static final ProtoAdapter<BankAccountProto> ADAPTER = new ProtoAdapter_BankAccountProto();
    public static final String DEFAULT_ACCOUNT_NO = "";
    public static final Integer DEFAULT_BIND_TIME = 0;
    public static final Integer DEFAULT_CHANNEL_ID = 0;
    public static final String DEFAULT_CVV = "";
    public static final Integer DEFAULT_EXPIRY_DATE = 0;
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Integer DEFAULT_FLAG = 0;
    public static final String DEFAULT_IC_NO = "";
    public static final Integer DEFAULT_IC_TYPE = 0;
    public static final Integer DEFAULT_IC_VERIFIED = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_MOBILE_NO = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String account_no;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer bind_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 11)
    public final String cvv;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer expiry_date;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 12)
    public final String extra_data;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer flag;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 8)
    public final String ic_no;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 14)
    public final Integer ic_type;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer ic_verified;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 7)
    public final String mobile_no;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer type;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer update_time;

    public BankAccountProto(Long l, Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, String str3, Integer num5, Integer num6, String str4, String str5, Integer num7, Integer num8) {
        this(l, num, num2, str, num3, num4, str2, str3, num5, num6, str4, str5, num7, num8, f.f32736b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankAccountProto(Long l, Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, String str3, Integer num5, Integer num6, String str4, String str5, Integer num7, Integer num8, f fVar) {
        super(ADAPTER, fVar);
        this.id = l;
        this.type = num;
        this.channel_id = num2;
        this.account_no = str;
        this.flag = num3;
        this.bind_time = num4;
        this.mobile_no = str2;
        this.ic_no = str3;
        this.ic_verified = num5;
        this.expiry_date = num6;
        this.cvv = str4;
        this.extra_data = str5;
        this.update_time = num7;
        this.ic_type = num8;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.type = this.type;
        builder.channel_id = this.channel_id;
        builder.account_no = this.account_no;
        builder.flag = this.flag;
        builder.bind_time = this.bind_time;
        builder.mobile_no = this.mobile_no;
        builder.ic_no = this.ic_no;
        builder.ic_verified = this.ic_verified;
        builder.expiry_date = this.expiry_date;
        builder.cvv = this.cvv;
        builder.extra_data = this.extra_data;
        builder.update_time = this.update_time;
        builder.ic_type = this.ic_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankAccountProto)) {
            return false;
        }
        BankAccountProto bankAccountProto = (BankAccountProto) obj;
        if (!unknownFields().equals(bankAccountProto.unknownFields()) || !this.id.equals(bankAccountProto.id) || !Internal.equals(this.type, bankAccountProto.type) || !Internal.equals(this.channel_id, bankAccountProto.channel_id) || !Internal.equals(this.account_no, bankAccountProto.account_no) || !Internal.equals(this.flag, bankAccountProto.flag) || !Internal.equals(this.bind_time, bankAccountProto.bind_time) || !Internal.equals(this.mobile_no, bankAccountProto.mobile_no) || !Internal.equals(this.ic_no, bankAccountProto.ic_no) || !Internal.equals(this.ic_verified, bankAccountProto.ic_verified) || !Internal.equals(this.expiry_date, bankAccountProto.expiry_date) || !Internal.equals(this.cvv, bankAccountProto.cvv) || !Internal.equals(this.extra_data, bankAccountProto.extra_data) || !Internal.equals(this.update_time, bankAccountProto.update_time) || !Internal.equals(this.ic_type, bankAccountProto.ic_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37;
        Integer num = this.type;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.channel_id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.account_no;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.flag;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.bind_time;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.mobile_no;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.ic_no;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num5 = this.ic_verified;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.expiry_date;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str4 = this.cvv;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.extra_data;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num7 = this.update_time;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.ic_type;
        if (num8 != null) {
            i2 = num8.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id=");
        sb.append(this.id);
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.channel_id != null) {
            sb.append(", channel_id=");
            sb.append(this.channel_id);
        }
        if (this.account_no != null) {
            sb.append(", account_no=");
            sb.append(this.account_no);
        }
        if (this.flag != null) {
            sb.append(", flag=");
            sb.append(this.flag);
        }
        if (this.bind_time != null) {
            sb.append(", bind_time=");
            sb.append(this.bind_time);
        }
        if (this.mobile_no != null) {
            sb.append(", mobile_no=");
            sb.append(this.mobile_no);
        }
        if (this.ic_no != null) {
            sb.append(", ic_no=");
            sb.append(this.ic_no);
        }
        if (this.ic_verified != null) {
            sb.append(", ic_verified=");
            sb.append(this.ic_verified);
        }
        if (this.expiry_date != null) {
            sb.append(", expiry_date=");
            sb.append(this.expiry_date);
        }
        if (this.cvv != null) {
            sb.append(", cvv=");
            sb.append(this.cvv);
        }
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (this.update_time != null) {
            sb.append(", update_time=");
            sb.append(this.update_time);
        }
        if (this.ic_type != null) {
            sb.append(", ic_type=");
            sb.append(this.ic_type);
        }
        StringBuilder replace = sb.replace(0, 2, "BankAccountProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BankAccountProto, Builder> {
        public String account_no;
        public Integer bind_time;
        public Integer channel_id;
        public String cvv;
        public Integer expiry_date;
        public String extra_data;
        public Integer flag;
        public String ic_no;
        public Integer ic_type;
        public Integer ic_verified;
        public Long id;
        public String mobile_no;
        public Integer type;
        public Integer update_time;

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder channel_id(Integer num) {
            this.channel_id = num;
            return this;
        }

        public Builder account_no(String str) {
            this.account_no = str;
            return this;
        }

        public Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        public Builder bind_time(Integer num) {
            this.bind_time = num;
            return this;
        }

        public Builder mobile_no(String str) {
            this.mobile_no = str;
            return this;
        }

        public Builder ic_no(String str) {
            this.ic_no = str;
            return this;
        }

        public Builder ic_verified(Integer num) {
            this.ic_verified = num;
            return this;
        }

        public Builder expiry_date(Integer num) {
            this.expiry_date = num;
            return this;
        }

        public Builder cvv(String str) {
            this.cvv = str;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder update_time(Integer num) {
            this.update_time = num;
            return this;
        }

        public Builder ic_type(Integer num) {
            this.ic_type = num;
            return this;
        }

        public BankAccountProto build() {
            Long l = this.id;
            if (l != null) {
                return new BankAccountProto(l, this.type, this.channel_id, this.account_no, this.flag, this.bind_time, this.mobile_no, this.ic_no, this.ic_verified, this.expiry_date, this.cvv, this.extra_data, this.update_time, this.ic_type, super.buildUnknownFields());
            }
            throw Internal.missingRequiredFields(l, "id");
        }
    }

    private static final class ProtoAdapter_BankAccountProto extends ProtoAdapter<BankAccountProto> {
        ProtoAdapter_BankAccountProto() {
            super(FieldEncoding.LENGTH_DELIMITED, BankAccountProto.class);
        }

        public int encodedSize(BankAccountProto bankAccountProto) {
            int i = 0;
            int encodedSizeWithTag = ProtoAdapter.UINT64.encodedSizeWithTag(1, bankAccountProto.id) + (bankAccountProto.type != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, bankAccountProto.type) : 0) + (bankAccountProto.channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(3, bankAccountProto.channel_id) : 0) + (bankAccountProto.account_no != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, bankAccountProto.account_no) : 0) + (bankAccountProto.flag != null ? ProtoAdapter.UINT32.encodedSizeWithTag(5, bankAccountProto.flag) : 0) + (bankAccountProto.bind_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(6, bankAccountProto.bind_time) : 0) + (bankAccountProto.mobile_no != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, bankAccountProto.mobile_no) : 0) + (bankAccountProto.ic_no != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, bankAccountProto.ic_no) : 0) + (bankAccountProto.ic_verified != null ? ProtoAdapter.UINT32.encodedSizeWithTag(9, bankAccountProto.ic_verified) : 0) + (bankAccountProto.expiry_date != null ? ProtoAdapter.UINT32.encodedSizeWithTag(10, bankAccountProto.expiry_date) : 0) + (bankAccountProto.cvv != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, bankAccountProto.cvv) : 0) + (bankAccountProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, bankAccountProto.extra_data) : 0) + (bankAccountProto.update_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(13, bankAccountProto.update_time) : 0);
            if (bankAccountProto.ic_type != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(14, bankAccountProto.ic_type);
            }
            return encodedSizeWithTag + i + bankAccountProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, BankAccountProto bankAccountProto) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, bankAccountProto.id);
            if (bankAccountProto.type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, bankAccountProto.type);
            }
            if (bankAccountProto.channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, bankAccountProto.channel_id);
            }
            if (bankAccountProto.account_no != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, bankAccountProto.account_no);
            }
            if (bankAccountProto.flag != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 5, bankAccountProto.flag);
            }
            if (bankAccountProto.bind_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 6, bankAccountProto.bind_time);
            }
            if (bankAccountProto.mobile_no != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, bankAccountProto.mobile_no);
            }
            if (bankAccountProto.ic_no != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, bankAccountProto.ic_no);
            }
            if (bankAccountProto.ic_verified != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 9, bankAccountProto.ic_verified);
            }
            if (bankAccountProto.expiry_date != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 10, bankAccountProto.expiry_date);
            }
            if (bankAccountProto.cvv != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, bankAccountProto.cvv);
            }
            if (bankAccountProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, bankAccountProto.extra_data);
            }
            if (bankAccountProto.update_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 13, bankAccountProto.update_time);
            }
            if (bankAccountProto.ic_type != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 14, bankAccountProto.ic_type);
            }
            protoWriter.writeBytes(bankAccountProto.unknownFields());
        }

        public BankAccountProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 2:
                            builder.type(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 3:
                            builder.channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 4:
                            builder.account_no(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.flag(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 6:
                            builder.bind_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 7:
                            builder.mobile_no(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.ic_no(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.ic_verified(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 10:
                            builder.expiry_date(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 11:
                            builder.cvv(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 12:
                            builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.update_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 14:
                            builder.ic_type(ProtoAdapter.UINT32.decode(protoReader));
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

        public BankAccountProto redact(BankAccountProto bankAccountProto) {
            Builder newBuilder = bankAccountProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
