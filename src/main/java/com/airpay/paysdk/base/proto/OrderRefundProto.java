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

public final class OrderRefundProto extends Message<OrderRefundProto, Builder> {
    public static final ProtoAdapter<OrderRefundProto> ADAPTER = new ProtoAdapter_OrderRefundProto();
    public static final Boolean DEFAULT_ALLOWED = false;
    public static final Long DEFAULT_BASE_AMOUNT = 0L;
    public static final Long DEFAULT_CASH_AMOUNT = 0L;
    public static final Long DEFAULT_CHANNEL_AMOUNT = 0L;
    public static final String DEFAULT_DISCLAIMER = "";
    public static final Long DEFAULT_FEE_AMOUNT = 0L;
    public static final String DEFAULT_FEE_AMOUNT_DESC = "";
    public static final Long DEFAULT_ORDER_ID = 0L;
    public static final Long DEFAULT_REBATE_AMOUNT = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TOTAL_AMOUNT = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean allowed;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 20)
    public final Long base_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 60)
    public final Long cash_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 50)
    public final Long channel_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String disclaimer;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 30)
    public final Long fee_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 31)
    public final String fee_amount_desc;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 1)
    public final Long order_id;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 40)
    public final Long rebate_amount;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer status;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#UINT64", tag = 10)
    public final Long total_amount;

    public OrderRefundProto(Long l, Integer num, Boolean bool, String str, Long l2, Long l3, Long l4, String str2, Long l5, Long l6, Long l7) {
        this(l, num, bool, str, l2, l3, l4, str2, l5, l6, l7, f.f32736b);
    }

    public OrderRefundProto(Long l, Integer num, Boolean bool, String str, Long l2, Long l3, Long l4, String str2, Long l5, Long l6, Long l7, f fVar) {
        super(ADAPTER, fVar);
        this.order_id = l;
        this.status = num;
        this.allowed = bool;
        this.disclaimer = str;
        this.total_amount = l2;
        this.base_amount = l3;
        this.fee_amount = l4;
        this.fee_amount_desc = str2;
        this.rebate_amount = l5;
        this.channel_amount = l6;
        this.cash_amount = l7;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.order_id = this.order_id;
        builder.status = this.status;
        builder.allowed = this.allowed;
        builder.disclaimer = this.disclaimer;
        builder.total_amount = this.total_amount;
        builder.base_amount = this.base_amount;
        builder.fee_amount = this.fee_amount;
        builder.fee_amount_desc = this.fee_amount_desc;
        builder.rebate_amount = this.rebate_amount;
        builder.channel_amount = this.channel_amount;
        builder.cash_amount = this.cash_amount;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderRefundProto)) {
            return false;
        }
        OrderRefundProto orderRefundProto = (OrderRefundProto) obj;
        if (!unknownFields().equals(orderRefundProto.unknownFields()) || !Internal.equals(this.order_id, orderRefundProto.order_id) || !Internal.equals(this.status, orderRefundProto.status) || !Internal.equals(this.allowed, orderRefundProto.allowed) || !Internal.equals(this.disclaimer, orderRefundProto.disclaimer) || !Internal.equals(this.total_amount, orderRefundProto.total_amount) || !Internal.equals(this.base_amount, orderRefundProto.base_amount) || !Internal.equals(this.fee_amount, orderRefundProto.fee_amount) || !Internal.equals(this.fee_amount_desc, orderRefundProto.fee_amount_desc) || !Internal.equals(this.rebate_amount, orderRefundProto.rebate_amount) || !Internal.equals(this.channel_amount, orderRefundProto.channel_amount) || !Internal.equals(this.cash_amount, orderRefundProto.cash_amount)) {
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
        Long l = this.order_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.allowed;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.disclaimer;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.total_amount;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.base_amount;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.fee_amount;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str2 = this.fee_amount_desc;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l5 = this.rebate_amount;
        int hashCode10 = (hashCode9 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.channel_amount;
        int hashCode11 = (hashCode10 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.cash_amount;
        if (l7 != null) {
            i2 = l7.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        if (this.status != null) {
            sb.append(", status=");
            sb.append(this.status);
        }
        if (this.allowed != null) {
            sb.append(", allowed=");
            sb.append(this.allowed);
        }
        if (this.disclaimer != null) {
            sb.append(", disclaimer=");
            sb.append(this.disclaimer);
        }
        if (this.total_amount != null) {
            sb.append(", total_amount=");
            sb.append(this.total_amount);
        }
        if (this.base_amount != null) {
            sb.append(", base_amount=");
            sb.append(this.base_amount);
        }
        if (this.fee_amount != null) {
            sb.append(", fee_amount=");
            sb.append(this.fee_amount);
        }
        if (this.fee_amount_desc != null) {
            sb.append(", fee_amount_desc=");
            sb.append(this.fee_amount_desc);
        }
        if (this.rebate_amount != null) {
            sb.append(", rebate_amount=");
            sb.append(this.rebate_amount);
        }
        if (this.channel_amount != null) {
            sb.append(", channel_amount=");
            sb.append(this.channel_amount);
        }
        if (this.cash_amount != null) {
            sb.append(", cash_amount=");
            sb.append(this.cash_amount);
        }
        StringBuilder replace = sb.replace(0, 2, "OrderRefundProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OrderRefundProto, Builder> {
        public Boolean allowed;
        public Long base_amount;
        public Long cash_amount;
        public Long channel_amount;
        public String disclaimer;
        public Long fee_amount;
        public String fee_amount_desc;
        public Long order_id;
        public Long rebate_amount;
        public Integer status;
        public Long total_amount;

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder allowed(Boolean bool) {
            this.allowed = bool;
            return this;
        }

        public Builder disclaimer(String str) {
            this.disclaimer = str;
            return this;
        }

        public Builder total_amount(Long l) {
            this.total_amount = l;
            return this;
        }

        public Builder base_amount(Long l) {
            this.base_amount = l;
            return this;
        }

        public Builder fee_amount(Long l) {
            this.fee_amount = l;
            return this;
        }

        public Builder fee_amount_desc(String str) {
            this.fee_amount_desc = str;
            return this;
        }

        public Builder rebate_amount(Long l) {
            this.rebate_amount = l;
            return this;
        }

        public Builder channel_amount(Long l) {
            this.channel_amount = l;
            return this;
        }

        public Builder cash_amount(Long l) {
            this.cash_amount = l;
            return this;
        }

        public OrderRefundProto build() {
            return new OrderRefundProto(this.order_id, this.status, this.allowed, this.disclaimer, this.total_amount, this.base_amount, this.fee_amount, this.fee_amount_desc, this.rebate_amount, this.channel_amount, this.cash_amount, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_OrderRefundProto extends ProtoAdapter<OrderRefundProto> {
        ProtoAdapter_OrderRefundProto() {
            super(FieldEncoding.LENGTH_DELIMITED, OrderRefundProto.class);
        }

        public int encodedSize(OrderRefundProto orderRefundProto) {
            int i = 0;
            int encodedSizeWithTag = (orderRefundProto.order_id != null ? ProtoAdapter.UINT64.encodedSizeWithTag(1, orderRefundProto.order_id) : 0) + (orderRefundProto.status != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, orderRefundProto.status) : 0) + (orderRefundProto.allowed != null ? ProtoAdapter.BOOL.encodedSizeWithTag(3, orderRefundProto.allowed) : 0) + (orderRefundProto.disclaimer != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, orderRefundProto.disclaimer) : 0) + (orderRefundProto.total_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(10, orderRefundProto.total_amount) : 0) + (orderRefundProto.base_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(20, orderRefundProto.base_amount) : 0) + (orderRefundProto.fee_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(30, orderRefundProto.fee_amount) : 0) + (orderRefundProto.fee_amount_desc != null ? ProtoAdapter.STRING.encodedSizeWithTag(31, orderRefundProto.fee_amount_desc) : 0) + (orderRefundProto.rebate_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(40, orderRefundProto.rebate_amount) : 0) + (orderRefundProto.channel_amount != null ? ProtoAdapter.UINT64.encodedSizeWithTag(50, orderRefundProto.channel_amount) : 0);
            if (orderRefundProto.cash_amount != null) {
                i = ProtoAdapter.UINT64.encodedSizeWithTag(60, orderRefundProto.cash_amount);
            }
            return encodedSizeWithTag + i + orderRefundProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, OrderRefundProto orderRefundProto) throws IOException {
            if (orderRefundProto.order_id != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, orderRefundProto.order_id);
            }
            if (orderRefundProto.status != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, orderRefundProto.status);
            }
            if (orderRefundProto.allowed != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, orderRefundProto.allowed);
            }
            if (orderRefundProto.disclaimer != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, orderRefundProto.disclaimer);
            }
            if (orderRefundProto.total_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 10, orderRefundProto.total_amount);
            }
            if (orderRefundProto.base_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 20, orderRefundProto.base_amount);
            }
            if (orderRefundProto.fee_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 30, orderRefundProto.fee_amount);
            }
            if (orderRefundProto.fee_amount_desc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 31, orderRefundProto.fee_amount_desc);
            }
            if (orderRefundProto.rebate_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 40, orderRefundProto.rebate_amount);
            }
            if (orderRefundProto.channel_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 50, orderRefundProto.channel_amount);
            }
            if (orderRefundProto.cash_amount != null) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 60, orderRefundProto.cash_amount);
            }
            protoWriter.writeBytes(orderRefundProto.unknownFields());
        }

        public OrderRefundProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.order_id(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.status(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.allowed(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.disclaimer(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 10) {
                    builder.total_amount(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 20) {
                    builder.base_amount(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 40) {
                    builder.rebate_amount(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 50) {
                    builder.channel_amount(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 60) {
                    builder.cash_amount(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 30) {
                    builder.fee_amount(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag != 31) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.fee_amount_desc(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public OrderRefundProto redact(OrderRefundProto orderRefundProto) {
            Builder newBuilder = orderRefundProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
