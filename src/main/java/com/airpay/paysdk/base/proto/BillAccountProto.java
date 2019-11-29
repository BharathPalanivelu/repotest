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

public final class BillAccountProto extends Message<BillAccountProto, Builder> {
    public static final ProtoAdapter<BillAccountProto> ADAPTER = new ProtoAdapter_BillAccountProto();
    public static final String DEFAULT_ACCOUNT_NO = "";
    public static final Integer DEFAULT_CHANNEL_ID = 0;
    public static final String DEFAULT_COMMENT = "";
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Integer DEFAULT_FLAG = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_LAST_PAID_BILL_ID = 0L;
    public static final Integer DEFAULT_LAST_PAYMENT_TIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_NEXT_BILL_ID = 0L;
    public static final Integer DEFAULT_NEXT_PAYMENT_TIME = 0;
    public static final Integer DEFAULT_OUTSTANDING_BILL_QUERY_TIME = 0;
    public static final Integer DEFAULT_OUTSTANDING_BILL_READ_TIME = 0;
    public static final String DEFAULT_TOPUP_ACCOUNT_ID = "";
    public static final Integer DEFAULT_TOPUP_BIND_TIME = 0;
    public static final Integer DEFAULT_TOPUP_CHANNEL_ID = 0;
    public static final Integer DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 17)
    public final String account_no;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 10)
    public final List<String> barcodes;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 18)
    public final String comment;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer create_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 9)
    public final String extra_data;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer flag;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 1)
    public final Long id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 11)
    public final Long last_paid_bill_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer last_payment_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String name;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 13)
    public final Long next_bill_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 12)
    public final Integer next_payment_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 19)
    public final Integer outstanding_bill_query_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer outstanding_bill_read_time;
    @WireField(adapter = "com.airpay.protocol.protobuf.BillRefProto#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<BillRefProto> refs;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 16)
    public final String topup_account_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 14)
    public final Integer topup_bind_time;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 15)
    public final Integer topup_channel_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer update_time;

    public BillAccountProto(Long l, Integer num, String str, List<BillRefProto> list, Integer num2, Integer num3, Integer num4, Integer num5, String str2, List<String> list2, Long l2, Integer num6, Long l3, Integer num7, Integer num8, String str3, String str4, String str5, Integer num9, Integer num10) {
        this(l, num, str, list, num2, num3, num4, num5, str2, list2, l2, num6, l3, num7, num8, str3, str4, str5, num9, num10, f.f32736b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillAccountProto(Long l, Integer num, String str, List<BillRefProto> list, Integer num2, Integer num3, Integer num4, Integer num5, String str2, List<String> list2, Long l2, Integer num6, Long l3, Integer num7, Integer num8, String str3, String str4, String str5, Integer num9, Integer num10, f fVar) {
        super(ADAPTER, fVar);
        this.id = l;
        this.channel_id = num;
        this.name = str;
        List<BillRefProto> list3 = list;
        this.refs = Internal.immutableCopyOf("refs", list);
        this.flag = num2;
        this.create_time = num3;
        this.update_time = num4;
        this.last_payment_time = num5;
        this.extra_data = str2;
        List<String> list4 = list2;
        this.barcodes = Internal.immutableCopyOf("barcodes", list2);
        this.last_paid_bill_id = l2;
        this.next_payment_time = num6;
        this.next_bill_id = l3;
        this.topup_bind_time = num7;
        this.topup_channel_id = num8;
        this.topup_account_id = str3;
        this.account_no = str4;
        this.comment = str5;
        this.outstanding_bill_query_time = num9;
        this.outstanding_bill_read_time = num10;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.channel_id = this.channel_id;
        builder.name = this.name;
        builder.refs = Internal.copyOf("refs", this.refs);
        builder.flag = this.flag;
        builder.create_time = this.create_time;
        builder.update_time = this.update_time;
        builder.last_payment_time = this.last_payment_time;
        builder.extra_data = this.extra_data;
        builder.barcodes = Internal.copyOf("barcodes", this.barcodes);
        builder.last_paid_bill_id = this.last_paid_bill_id;
        builder.next_payment_time = this.next_payment_time;
        builder.next_bill_id = this.next_bill_id;
        builder.topup_bind_time = this.topup_bind_time;
        builder.topup_channel_id = this.topup_channel_id;
        builder.topup_account_id = this.topup_account_id;
        builder.account_no = this.account_no;
        builder.comment = this.comment;
        builder.outstanding_bill_query_time = this.outstanding_bill_query_time;
        builder.outstanding_bill_read_time = this.outstanding_bill_read_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BillAccountProto)) {
            return false;
        }
        BillAccountProto billAccountProto = (BillAccountProto) obj;
        if (!unknownFields().equals(billAccountProto.unknownFields()) || !Internal.equals(this.id, billAccountProto.id) || !Internal.equals(this.channel_id, billAccountProto.channel_id) || !Internal.equals(this.name, billAccountProto.name) || !this.refs.equals(billAccountProto.refs) || !Internal.equals(this.flag, billAccountProto.flag) || !Internal.equals(this.create_time, billAccountProto.create_time) || !Internal.equals(this.update_time, billAccountProto.update_time) || !Internal.equals(this.last_payment_time, billAccountProto.last_payment_time) || !Internal.equals(this.extra_data, billAccountProto.extra_data) || !this.barcodes.equals(billAccountProto.barcodes) || !Internal.equals(this.last_paid_bill_id, billAccountProto.last_paid_bill_id) || !Internal.equals(this.next_payment_time, billAccountProto.next_payment_time) || !Internal.equals(this.next_bill_id, billAccountProto.next_bill_id) || !Internal.equals(this.topup_bind_time, billAccountProto.topup_bind_time) || !Internal.equals(this.topup_channel_id, billAccountProto.topup_channel_id) || !Internal.equals(this.topup_account_id, billAccountProto.topup_account_id) || !Internal.equals(this.account_no, billAccountProto.account_no) || !Internal.equals(this.comment, billAccountProto.comment) || !Internal.equals(this.outstanding_bill_query_time, billAccountProto.outstanding_bill_query_time) || !Internal.equals(this.outstanding_bill_read_time, billAccountProto.outstanding_bill_read_time)) {
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
        Long l = this.id;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.channel_id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode4 = (((hashCode3 + (str != null ? str.hashCode() : 0)) * 37) + this.refs.hashCode()) * 37;
        Integer num2 = this.flag;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.create_time;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.update_time;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.last_payment_time;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.extra_data;
        int hashCode9 = (((hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.barcodes.hashCode()) * 37;
        Long l2 = this.last_paid_bill_id;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num6 = this.next_payment_time;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l3 = this.next_bill_id;
        int hashCode12 = (hashCode11 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num7 = this.topup_bind_time;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.topup_channel_id;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str3 = this.topup_account_id;
        int hashCode15 = (hashCode14 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.account_no;
        int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.comment;
        int hashCode17 = (hashCode16 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num9 = this.outstanding_bill_query_time;
        int hashCode18 = (hashCode17 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.outstanding_bill_read_time;
        if (num10 != null) {
            i2 = num10.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.channel_id != null) {
            sb.append(", channel_id=");
            sb.append(this.channel_id);
        }
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (!this.refs.isEmpty()) {
            sb.append(", refs=");
            sb.append(this.refs);
        }
        if (this.flag != null) {
            sb.append(", flag=");
            sb.append(this.flag);
        }
        if (this.create_time != null) {
            sb.append(", create_time=");
            sb.append(this.create_time);
        }
        if (this.update_time != null) {
            sb.append(", update_time=");
            sb.append(this.update_time);
        }
        if (this.last_payment_time != null) {
            sb.append(", last_payment_time=");
            sb.append(this.last_payment_time);
        }
        if (this.extra_data != null) {
            sb.append(", extra_data=");
            sb.append(this.extra_data);
        }
        if (!this.barcodes.isEmpty()) {
            sb.append(", barcodes=");
            sb.append(this.barcodes);
        }
        if (this.last_paid_bill_id != null) {
            sb.append(", last_paid_bill_id=");
            sb.append(this.last_paid_bill_id);
        }
        if (this.next_payment_time != null) {
            sb.append(", next_payment_time=");
            sb.append(this.next_payment_time);
        }
        if (this.next_bill_id != null) {
            sb.append(", next_bill_id=");
            sb.append(this.next_bill_id);
        }
        if (this.topup_bind_time != null) {
            sb.append(", topup_bind_time=");
            sb.append(this.topup_bind_time);
        }
        if (this.topup_channel_id != null) {
            sb.append(", topup_channel_id=");
            sb.append(this.topup_channel_id);
        }
        if (this.topup_account_id != null) {
            sb.append(", topup_account_id=");
            sb.append(this.topup_account_id);
        }
        if (this.account_no != null) {
            sb.append(", account_no=");
            sb.append(this.account_no);
        }
        if (this.comment != null) {
            sb.append(", comment=");
            sb.append(this.comment);
        }
        if (this.outstanding_bill_query_time != null) {
            sb.append(", outstanding_bill_query_time=");
            sb.append(this.outstanding_bill_query_time);
        }
        if (this.outstanding_bill_read_time != null) {
            sb.append(", outstanding_bill_read_time=");
            sb.append(this.outstanding_bill_read_time);
        }
        StringBuilder replace = sb.replace(0, 2, "BillAccountProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BillAccountProto, Builder> {
        public String account_no;
        public List<String> barcodes = Internal.newMutableList();
        public Integer channel_id;
        public String comment;
        public Integer create_time;
        public String extra_data;
        public Integer flag;
        public Long id;
        public Long last_paid_bill_id;
        public Integer last_payment_time;
        public String name;
        public Long next_bill_id;
        public Integer next_payment_time;
        public Integer outstanding_bill_query_time;
        public Integer outstanding_bill_read_time;
        public List<BillRefProto> refs = Internal.newMutableList();
        public String topup_account_id;
        public Integer topup_bind_time;
        public Integer topup_channel_id;
        public Integer update_time;

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder channel_id(Integer num) {
            this.channel_id = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder refs(List<BillRefProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.refs = list;
            return this;
        }

        public Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder update_time(Integer num) {
            this.update_time = num;
            return this;
        }

        public Builder last_payment_time(Integer num) {
            this.last_payment_time = num;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public Builder barcodes(List<String> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.barcodes = list;
            return this;
        }

        public Builder last_paid_bill_id(Long l) {
            this.last_paid_bill_id = l;
            return this;
        }

        public Builder next_payment_time(Integer num) {
            this.next_payment_time = num;
            return this;
        }

        public Builder next_bill_id(Long l) {
            this.next_bill_id = l;
            return this;
        }

        public Builder topup_bind_time(Integer num) {
            this.topup_bind_time = num;
            return this;
        }

        public Builder topup_channel_id(Integer num) {
            this.topup_channel_id = num;
            return this;
        }

        public Builder topup_account_id(String str) {
            this.topup_account_id = str;
            return this;
        }

        public Builder account_no(String str) {
            this.account_no = str;
            return this;
        }

        public Builder comment(String str) {
            this.comment = str;
            return this;
        }

        public Builder outstanding_bill_query_time(Integer num) {
            this.outstanding_bill_query_time = num;
            return this;
        }

        public Builder outstanding_bill_read_time(Integer num) {
            this.outstanding_bill_read_time = num;
            return this;
        }

        public BillAccountProto build() {
            return new BillAccountProto(this.id, this.channel_id, this.name, this.refs, this.flag, this.create_time, this.update_time, this.last_payment_time, this.extra_data, this.barcodes, this.last_paid_bill_id, this.next_payment_time, this.next_bill_id, this.topup_bind_time, this.topup_channel_id, this.topup_account_id, this.account_no, this.comment, this.outstanding_bill_query_time, this.outstanding_bill_read_time, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BillAccountProto extends ProtoAdapter<BillAccountProto> {
        ProtoAdapter_BillAccountProto() {
            super(FieldEncoding.LENGTH_DELIMITED, BillAccountProto.class);
        }

        public int encodedSize(BillAccountProto billAccountProto) {
            int i = 0;
            int encodedSizeWithTag = (billAccountProto.id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(1, billAccountProto.id) : 0) + (billAccountProto.channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, billAccountProto.channel_id) : 0) + (billAccountProto.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, billAccountProto.name) : 0) + BillRefProto.ADAPTER.asRepeated().encodedSizeWithTag(4, billAccountProto.refs) + (billAccountProto.flag != null ? ProtoAdapter.UINT32.encodedSizeWithTag(5, billAccountProto.flag) : 0) + (billAccountProto.create_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(6, billAccountProto.create_time) : 0) + (billAccountProto.update_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(7, billAccountProto.update_time) : 0) + (billAccountProto.last_payment_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(8, billAccountProto.last_payment_time) : 0) + (billAccountProto.extra_data != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, billAccountProto.extra_data) : 0) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(10, billAccountProto.barcodes) + (billAccountProto.last_paid_bill_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(11, billAccountProto.last_paid_bill_id) : 0) + (billAccountProto.next_payment_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(12, billAccountProto.next_payment_time) : 0) + (billAccountProto.next_bill_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(13, billAccountProto.next_bill_id) : 0) + (billAccountProto.topup_bind_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(14, billAccountProto.topup_bind_time) : 0) + (billAccountProto.topup_channel_id != null ? ProtoAdapter.UINT32.encodedSizeWithTag(15, billAccountProto.topup_channel_id) : 0) + (billAccountProto.topup_account_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(16, billAccountProto.topup_account_id) : 0) + (billAccountProto.account_no != null ? ProtoAdapter.STRING.encodedSizeWithTag(17, billAccountProto.account_no) : 0) + (billAccountProto.comment != null ? ProtoAdapter.STRING.encodedSizeWithTag(18, billAccountProto.comment) : 0) + (billAccountProto.outstanding_bill_query_time != null ? ProtoAdapter.UINT32.encodedSizeWithTag(19, billAccountProto.outstanding_bill_query_time) : 0);
            if (billAccountProto.outstanding_bill_read_time != null) {
                i = ProtoAdapter.UINT32.encodedSizeWithTag(20, billAccountProto.outstanding_bill_read_time);
            }
            return encodedSizeWithTag + i + billAccountProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, BillAccountProto billAccountProto) throws IOException {
            if (billAccountProto.id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, billAccountProto.id);
            }
            if (billAccountProto.channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, billAccountProto.channel_id);
            }
            if (billAccountProto.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, billAccountProto.name);
            }
            BillRefProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, billAccountProto.refs);
            if (billAccountProto.flag != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 5, billAccountProto.flag);
            }
            if (billAccountProto.create_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 6, billAccountProto.create_time);
            }
            if (billAccountProto.update_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 7, billAccountProto.update_time);
            }
            if (billAccountProto.last_payment_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 8, billAccountProto.last_payment_time);
            }
            if (billAccountProto.extra_data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, billAccountProto.extra_data);
            }
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 10, billAccountProto.barcodes);
            if (billAccountProto.last_paid_bill_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 11, billAccountProto.last_paid_bill_id);
            }
            if (billAccountProto.next_payment_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 12, billAccountProto.next_payment_time);
            }
            if (billAccountProto.next_bill_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 13, billAccountProto.next_bill_id);
            }
            if (billAccountProto.topup_bind_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 14, billAccountProto.topup_bind_time);
            }
            if (billAccountProto.topup_channel_id != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 15, billAccountProto.topup_channel_id);
            }
            if (billAccountProto.topup_account_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, billAccountProto.topup_account_id);
            }
            if (billAccountProto.account_no != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, billAccountProto.account_no);
            }
            if (billAccountProto.comment != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, billAccountProto.comment);
            }
            if (billAccountProto.outstanding_bill_query_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 19, billAccountProto.outstanding_bill_query_time);
            }
            if (billAccountProto.outstanding_bill_read_time != null) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 20, billAccountProto.outstanding_bill_read_time);
            }
            protoWriter.writeBytes(billAccountProto.unknownFields());
        }

        public BillAccountProto decode(ProtoReader protoReader) throws IOException {
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
                            builder.channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 3:
                            builder.name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.refs.add(BillRefProto.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.flag(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 6:
                            builder.create_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 7:
                            builder.update_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 8:
                            builder.last_payment_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 9:
                            builder.extra_data(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.barcodes.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.last_paid_bill_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 12:
                            builder.next_payment_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 13:
                            builder.next_bill_id(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 14:
                            builder.topup_bind_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 15:
                            builder.topup_channel_id(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 16:
                            builder.topup_account_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            builder.account_no(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 18:
                            builder.comment(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            builder.outstanding_bill_query_time(ProtoAdapter.UINT32.decode(protoReader));
                            break;
                        case 20:
                            builder.outstanding_bill_read_time(ProtoAdapter.UINT32.decode(protoReader));
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

        public BillAccountProto redact(BillAccountProto billAccountProto) {
            Builder newBuilder = billAccountProto.newBuilder();
            Internal.redactElements(newBuilder.refs, BillRefProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
