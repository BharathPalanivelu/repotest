package com.airpay.paysdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.base.proto.OrderProto;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.pay.b.a;

public class BPOrderInfo implements Parcelable {
    public static final Parcelable.Creator<BPOrderInfo> CREATOR = new Parcelable.Creator<BPOrderInfo>() {
        public BPOrderInfo createFromParcel(Parcel parcel) {
            return new BPOrderInfo(parcel);
        }

        public BPOrderInfo[] newArray(int i) {
            return new BPOrderInfo[i];
        }
    };
    public static final String FIELD_CREATE_TIME = "create_time";
    public static final String FIELD_EXPIRED_TIME = "expired_time";
    public static final String FIELD_ORDER_ID = "order_id";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_UPDATE_TIME = "update_time";
    private int allowed;
    private long base_amount;
    private long cash_amount;
    private long channel_amount;
    private int create_time;
    private String currency;
    private long currency_amount;
    private String disclaimer;
    private long event_id;
    private int expired_time;
    private String extra_data;
    private long fee_amount;
    private String fee_amount_desc;
    private int item_amount;
    private String item_id;
    private String item_image;
    private String item_name;
    private int mPaymentCompletionTime;
    private int mStatusLabel;
    private ChannelInfo mTopupChannel;
    private long msg_id;
    private long order_id;
    private OrderProto originalData;
    private String payment_account_id;
    private long payment_cash_amount;
    private int payment_channel_id;
    private String payment_channel_txn_id;
    private long payment_payable_amount;
    private long payment_txn_id;
    private long rebate_amount;
    private long refund_order_id;
    private int refund_status;
    private int status;
    private String topup_account_id;
    private long topup_cash_amount;
    private int topup_channel_id;
    private String topup_channel_txn_id;
    private long topup_payable_amount;
    private long topup_txn_id;
    private long total_amount;
    private int type;
    private int update_time;
    private int valid_time;

    public static String getFieldOrderId() {
        return FIELD_ORDER_ID;
    }

    public int describeContents() {
        return 0;
    }

    public BPOrderInfo() {
        this.order_id = -1;
        this.type = -1;
        this.status = -1;
        this.currency_amount = -1;
        this.create_time = -1;
        this.expired_time = -1;
        this.valid_time = -1;
        this.update_time = -1;
        this.topup_channel_id = -1;
        this.payment_channel_id = -1;
        this.item_amount = -1;
        this.topup_txn_id = -1;
        this.payment_txn_id = -1;
        this.event_id = -1;
        this.topup_payable_amount = -1;
        this.payment_payable_amount = -1;
        this.msg_id = -1;
        this.payment_cash_amount = 0;
        this.topup_cash_amount = 0;
        this.mStatusLabel = -1;
        this.mPaymentCompletionTime = -1;
        this.mTopupChannel = null;
    }

    public BPOrderInfo(OrderProto orderProto) {
        long j = -1;
        this.order_id = -1;
        int i = -1;
        this.type = -1;
        this.status = -1;
        this.currency_amount = -1;
        this.create_time = -1;
        this.expired_time = -1;
        this.valid_time = -1;
        this.update_time = -1;
        this.topup_channel_id = -1;
        this.payment_channel_id = -1;
        this.item_amount = -1;
        this.topup_txn_id = -1;
        this.payment_txn_id = -1;
        this.event_id = -1;
        this.topup_payable_amount = -1;
        this.payment_payable_amount = -1;
        this.msg_id = -1;
        long j2 = 0;
        this.payment_cash_amount = 0;
        this.topup_cash_amount = 0;
        this.mStatusLabel = -1;
        this.mPaymentCompletionTime = -1;
        this.mTopupChannel = null;
        this.order_id = orderProto.order_id != null ? orderProto.order_id.longValue() : -1;
        this.type = orderProto.type != null ? orderProto.type.intValue() : -1;
        this.status = orderProto.status != null ? orderProto.status.intValue() : -1;
        this.currency = orderProto.currency;
        this.currency_amount = orderProto.currency_amount != null ? orderProto.currency_amount.longValue() : -1;
        this.create_time = orderProto.create_time != null ? orderProto.create_time.intValue() : -1;
        this.expired_time = orderProto.expired_time != null ? orderProto.expired_time.intValue() : -1;
        this.valid_time = orderProto.valid_time != null ? orderProto.valid_time.intValue() : -1;
        this.update_time = orderProto.update_time != null ? orderProto.update_time.intValue() : -1;
        this.topup_channel_id = orderProto.topup_channel_id != null ? orderProto.topup_channel_id.intValue() : -1;
        this.topup_channel_txn_id = orderProto.topup_channel_txn_id;
        this.topup_account_id = orderProto.topup_account_id;
        this.payment_channel_id = orderProto.payment_channel_id != null ? orderProto.payment_channel_id.intValue() : -1;
        this.payment_channel_txn_id = orderProto.payment_channel_txn_id;
        this.payment_account_id = orderProto.payment_account_id;
        this.item_id = orderProto.item_id;
        this.item_amount = orderProto.item_amount != null ? orderProto.item_amount.intValue() : i;
        this.item_name = orderProto.item_name;
        this.item_image = orderProto.item_image;
        this.topup_txn_id = orderProto.topup_txn_id != null ? orderProto.topup_txn_id.longValue() : -1;
        this.payment_txn_id = orderProto.payment_txn_id != null ? orderProto.payment_txn_id.longValue() : -1;
        this.extra_data = orderProto.extra_data;
        this.event_id = orderProto.event_id != null ? orderProto.event_id.longValue() : -1;
        this.topup_payable_amount = orderProto.topup_payable_amount != null ? orderProto.topup_payable_amount.longValue() : -1;
        this.payment_payable_amount = orderProto.payment_payable_amount != null ? orderProto.payment_payable_amount.longValue() : j;
        this.payment_cash_amount = orderProto.payment_cash_amount != null ? orderProto.payment_cash_amount.longValue() : 0;
        this.topup_cash_amount = orderProto.topup_cash_amount != null ? orderProto.topup_cash_amount.longValue() : j2;
        if (orderProto.order_refund != null) {
            this.refund_order_id = orderProto.order_refund.order_id.longValue();
            this.refund_status = orderProto.order_refund.status.intValue();
            this.allowed = orderProto.order_refund.allowed.booleanValue() ? 1 : 0;
            this.disclaimer = orderProto.order_refund.disclaimer;
            this.total_amount = orderProto.order_refund.total_amount.longValue();
            this.base_amount = orderProto.order_refund.base_amount.longValue();
            this.fee_amount = orderProto.order_refund.fee_amount.longValue();
            this.fee_amount_desc = orderProto.order_refund.fee_amount_desc;
            this.rebate_amount = orderProto.order_refund.rebate_amount.longValue();
            this.channel_amount = orderProto.order_refund.channel_amount.longValue();
            this.cash_amount = orderProto.order_refund.cash_amount.longValue();
        }
        this.originalData = orderProto;
    }

    protected BPOrderInfo(Parcel parcel) {
        this.order_id = -1;
        this.type = -1;
        this.status = -1;
        this.currency_amount = -1;
        this.create_time = -1;
        this.expired_time = -1;
        this.valid_time = -1;
        this.update_time = -1;
        this.topup_channel_id = -1;
        this.payment_channel_id = -1;
        this.item_amount = -1;
        this.topup_txn_id = -1;
        this.payment_txn_id = -1;
        this.event_id = -1;
        this.topup_payable_amount = -1;
        this.payment_payable_amount = -1;
        this.msg_id = -1;
        this.payment_cash_amount = 0;
        this.topup_cash_amount = 0;
        this.mStatusLabel = -1;
        this.mPaymentCompletionTime = -1;
        this.mTopupChannel = null;
        this.order_id = parcel.readLong();
        this.type = parcel.readInt();
        this.status = parcel.readInt();
        this.currency = parcel.readString();
        this.currency_amount = parcel.readLong();
        this.create_time = parcel.readInt();
        this.expired_time = parcel.readInt();
        this.valid_time = parcel.readInt();
        this.update_time = parcel.readInt();
        this.topup_channel_id = parcel.readInt();
        this.topup_channel_txn_id = parcel.readString();
        this.topup_account_id = parcel.readString();
        this.payment_channel_id = parcel.readInt();
        this.payment_channel_txn_id = parcel.readString();
        this.payment_account_id = parcel.readString();
        this.item_id = parcel.readString();
        this.item_amount = parcel.readInt();
        this.item_name = parcel.readString();
        this.item_image = parcel.readString();
        this.topup_txn_id = parcel.readLong();
        this.payment_txn_id = parcel.readLong();
        this.extra_data = parcel.readString();
        this.event_id = parcel.readLong();
        this.topup_payable_amount = parcel.readLong();
        this.payment_payable_amount = parcel.readLong();
        this.msg_id = parcel.readLong();
        this.payment_cash_amount = parcel.readLong();
        this.topup_cash_amount = parcel.readLong();
        this.mStatusLabel = parcel.readInt();
        this.mPaymentCompletionTime = parcel.readInt();
        this.refund_order_id = parcel.readLong();
        this.refund_status = parcel.readInt();
        this.allowed = parcel.readInt();
        this.disclaimer = parcel.readString();
        this.total_amount = parcel.readLong();
        this.base_amount = parcel.readLong();
        this.fee_amount = parcel.readLong();
        this.fee_amount_desc = parcel.readString();
        this.rebate_amount = parcel.readLong();
        this.channel_amount = parcel.readLong();
        this.cash_amount = parcel.readLong();
        this.originalData = (OrderProto) parcel.readSerializable();
    }

    public long getOrderId() {
        return this.order_id;
    }

    public void setOrderId(long j) {
        this.order_id = j;
    }

    public int getType() {
        return this.type;
    }

    public String getItemId() {
        return this.item_id;
    }

    public int getUpdateTime() {
        return this.update_time;
    }

    public long getTopupPayableAmount() {
        return this.topup_payable_amount;
    }

    public long getTopupCashAmount() {
        return this.topup_cash_amount;
    }

    public long getPaymentPayableAmount() {
        return this.payment_payable_amount;
    }

    public long getPaymentCashAmount() {
        return this.payment_cash_amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public long getCurrencyAmount() {
        return this.currency_amount;
    }

    public int getItemAmount() {
        return this.item_amount;
    }

    public long getMsgId() {
        return this.msg_id;
    }

    public void setMsgId(long j) {
        this.msg_id = j;
    }

    public String getExtraData() {
        return this.extra_data;
    }

    public int getStatusLabel() {
        if (this.mStatusLabel == -1) {
            this.mStatusLabel = f.b(this);
        }
        return this.mStatusLabel;
    }

    public OrderProto getOriginalData() {
        return this.originalData;
    }

    public void setExtraData(String str) {
        this.extra_data = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BPOrderInfo) && this.order_id == ((BPOrderInfo) obj).order_id;
    }

    public String getItemName() {
        return this.item_name;
    }

    public String getPaymentAccountId() {
        return this.payment_account_id;
    }

    public String getTopupAccountId() {
        return this.topup_account_id;
    }

    public int getTopupChannelId() {
        return this.topup_channel_id;
    }

    public int getPaymentChannelId() {
        return this.payment_channel_id;
    }

    public String getPaymentChannelTxnId() {
        return this.payment_channel_txn_id;
    }

    public String getTopupChannelTxnId() {
        return this.topup_channel_txn_id;
    }

    public long getTopupTxnId() {
        return this.topup_txn_id;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getExpiryDate() {
        return this.expired_time;
    }

    public int getCreateTime() {
        return this.create_time;
    }

    public int getValidTime() {
        return this.valid_time;
    }

    public int getTopupCompletionTime() {
        if (this.mPaymentCompletionTime == -1) {
            this.mPaymentCompletionTime = a.w(this.extra_data);
        }
        if (this.mPaymentCompletionTime <= 0) {
            this.mPaymentCompletionTime = this.valid_time;
        }
        return this.mPaymentCompletionTime;
    }

    private ChannelInfo getTopupChannel() {
        this.mTopupChannel = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(this.topup_channel_id));
        return this.mTopupChannel;
    }

    public long getRefund_order_id() {
        return this.refund_order_id;
    }

    public int getRefund_status() {
        return this.refund_status;
    }

    public int getAllowed() {
        return this.allowed;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public long getTotal_amount() {
        return this.total_amount;
    }

    public long getBase_amount() {
        return this.base_amount;
    }

    public long getFee_amount() {
        return this.fee_amount;
    }

    public String getFee_amount_desc() {
        return this.fee_amount_desc;
    }

    public long getRebate_amount() {
        return this.rebate_amount;
    }

    public long getChannel_amount() {
        return this.channel_amount;
    }

    public long getCash_amount() {
        return this.cash_amount;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.order_id);
        parcel.writeInt(this.type);
        parcel.writeInt(this.status);
        parcel.writeString(this.currency);
        parcel.writeLong(this.currency_amount);
        parcel.writeInt(this.create_time);
        parcel.writeInt(this.expired_time);
        parcel.writeInt(this.valid_time);
        parcel.writeInt(this.update_time);
        parcel.writeInt(this.topup_channel_id);
        parcel.writeString(this.topup_channel_txn_id);
        parcel.writeString(this.topup_account_id);
        parcel.writeInt(this.payment_channel_id);
        parcel.writeString(this.payment_channel_txn_id);
        parcel.writeString(this.payment_account_id);
        parcel.writeString(this.item_id);
        parcel.writeInt(this.item_amount);
        parcel.writeString(this.item_name);
        parcel.writeString(this.item_image);
        parcel.writeLong(this.topup_txn_id);
        parcel.writeLong(this.payment_txn_id);
        parcel.writeString(this.extra_data);
        parcel.writeLong(this.event_id);
        parcel.writeLong(this.topup_payable_amount);
        parcel.writeLong(this.payment_payable_amount);
        parcel.writeLong(this.msg_id);
        parcel.writeLong(this.payment_cash_amount);
        parcel.writeLong(this.topup_cash_amount);
        parcel.writeInt(this.mStatusLabel);
        parcel.writeInt(this.mPaymentCompletionTime);
        parcel.writeLong(this.refund_order_id);
        parcel.writeInt(this.refund_status);
        parcel.writeInt(this.allowed);
        parcel.writeString(this.disclaimer);
        parcel.writeLong(this.total_amount);
        parcel.writeLong(this.base_amount);
        parcel.writeLong(this.fee_amount);
        parcel.writeString(this.fee_amount_desc);
        parcel.writeLong(this.rebate_amount);
        parcel.writeLong(this.channel_amount);
        parcel.writeLong(this.cash_amount);
        parcel.writeSerializable(this.originalData);
    }

    public String toString() {
        return "BPOrderInfo{order_id=" + this.order_id + ", type=" + this.type + ", status=" + this.status + ", currency='" + this.currency + '\'' + ", currency_amount=" + this.currency_amount + ", create_time=" + this.create_time + ", expired_time=" + this.expired_time + ", valid_time=" + this.valid_time + ", update_time=" + this.update_time + ", topup_channel_id=" + this.topup_channel_id + ", topup_channel_txn_id='" + this.topup_channel_txn_id + '\'' + ", topup_account_id='" + this.topup_account_id + '\'' + ", payment_channel_id=" + this.payment_channel_id + ", payment_channel_txn_id='" + this.payment_channel_txn_id + '\'' + ", payment_account_id='" + this.payment_account_id + '\'' + ", item_id='" + this.item_id + '\'' + ", item_amount=" + this.item_amount + ", item_name='" + this.item_name + '\'' + ", item_image='" + this.item_image + '\'' + ", topup_txn_id=" + this.topup_txn_id + ", payment_txn_id=" + this.payment_txn_id + ", extra_data='" + this.extra_data + '\'' + ", event_id=" + this.event_id + ", topup_payable_amount=" + this.topup_payable_amount + ", payment_payable_amount=" + this.payment_payable_amount + ", msg_id=" + this.msg_id + ", payment_cash_amount=" + this.payment_cash_amount + ", topup_cash_amount=" + this.topup_cash_amount + ", mStatusLabel=" + this.mStatusLabel + ", mPaymentCompletionTime=" + this.mPaymentCompletionTime + ", mTopupChannel=" + this.mTopupChannel + ", refund_order_id=" + this.refund_order_id + ", refund_status=" + this.refund_status + ", allowed=" + this.allowed + ", disclaimer='" + this.disclaimer + '\'' + ", total_amount=" + this.total_amount + ", base_amount=" + this.base_amount + ", fee_amount=" + this.fee_amount + ", fee_amount_desc='" + this.fee_amount_desc + '\'' + ", rebate_amount=" + this.rebate_amount + ", channel_amount=" + this.channel_amount + ", cash_amount=" + this.cash_amount + ", originalData=" + this.originalData + '}';
    }
}
