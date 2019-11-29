package com.shopee.app.data.viewmodel;

import android.content.Context;
import android.text.SpannedString;
import com.a.a.f;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.d.b.a.d.h;
import com.shopee.app.util.au;
import com.shopee.id.R;
import java.util.List;

public class CheckoutItem {
    public static final int BTN_DISABLE = 1;
    public static final int BTN_GONE = 2;
    public static final int BTN_NORMAL = 0;
    private long actualPrice;
    private int cTime;
    private long checkoutId;
    private List<CheckoutOrderInfo> checkoutOrderList;
    private int checkoutOrderType;
    private String checkoutSn;
    private String country;
    private String currency;
    private int discountPercentage;
    private boolean divider;
    private boolean isUnread;
    private int logisticsStatus;
    private int mTime;
    private List<OrderDetail> orderDetailList;
    private long paidAmount;
    private int payByDate;
    private int paymentCard;
    private String paymentChannelName;
    private int paymentStatus;
    private int paymentType;
    private long priceBeforeDiscount;
    private String promDescription;
    private String promUrl;
    private int receiptProcessByDate;
    private int receiptProcessWorkDays;
    private int receiptRejectTime;
    private int receiptUploadTime;
    private String remark;
    private int status;
    private boolean supportChangePaymentMethod = true;
    private long totalPrice;
    private long uniqueCode;
    private int userId;

    public long getCheckoutId() {
        return this.checkoutId;
    }

    public void setCheckoutId(long j) {
        this.checkoutId = j;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(long j) {
        this.totalPrice = j;
    }

    public long getPaidAmount() {
        return this.paidAmount;
    }

    public void setPaidAmount(long j) {
        this.paidAmount = j;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public int getcTime() {
        return this.cTime;
    }

    public void setcTime(int i) {
        this.cTime = i;
    }

    public int getmTime() {
        return this.mTime;
    }

    public void setmTime(int i) {
        this.mTime = i;
    }

    public List<CheckoutOrderInfo> getCheckoutOrderList() {
        return this.checkoutOrderList;
    }

    public void setCheckoutOrderList(List<CheckoutOrderInfo> list) {
        this.checkoutOrderList = list;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public int getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(int i) {
        this.paymentStatus = i;
    }

    public void setOrderDetailList(List<OrderDetail> list) {
        this.orderDetailList = list;
    }

    public List<OrderDetail> getOrderDetailList() {
        return this.orderDetailList;
    }

    public String dueDate() {
        int i = 0;
        int daysToPay = getCheckoutOrderList().get(0).getDaysToPay();
        int i2 = getcTime() + (86400 * daysToPay);
        int a2 = a.a(i2 - a.b(a.a()));
        if (a2 <= daysToPay) {
            i = a2;
        }
        if (i < 1) {
            return "Today";
        }
        if (i < 2) {
            return "Tomorrow";
        }
        return a.c(i2, "ID");
    }

    private int daysToPay() {
        int daysToPay = getCheckoutOrderList().get(0).getDaysToPay();
        int a2 = a.a((getcTime() + (86400 * daysToPay)) - a.b(a.a()));
        if (a2 <= daysToPay) {
            return a2;
        }
        return 0;
    }

    public String getPayDeadlineDateString() {
        return a.c(getcTime() + (getCheckoutOrderList().get(0).getDaysToPay() * 86400), "ID");
    }

    public PaymentInternalInfo getPaymentInfo(Context context) {
        f fVar;
        int i;
        String str;
        int i2;
        int i3;
        String str2;
        f fVar2;
        boolean z;
        int i4;
        String str3;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        f fVar3;
        int i7;
        String str4;
        int i8;
        int i9;
        int i10;
        String str5;
        int i11;
        f fVar4;
        f fVar5;
        f fVar6;
        Context context2 = context;
        int i12 = this.status;
        int i13 = this.paymentStatus;
        int daysToPay = getcTime() + (getCheckoutOrderList().get(0).getDaysToPay() * 86400);
        if (i12 == 1 && i13 == 0) {
            String e2 = b.e(R.string.sp_label_pay);
            f a2 = f.a(context2, (int) R.string.sp_pending_my_payment);
            a2.a().a().d().a().c().a((Object) a.c(daysToPay, "ID")).b();
            str = e2;
            fVar = a2;
            i3 = 0;
            i2 = 0;
            i = 2;
        } else {
            i3 = 2;
            i2 = 1;
            str = null;
            i = 0;
            fVar = null;
        }
        if (i12 == 1 && i13 == 100) {
            str = b.e(R.string.sp_upload_receipt);
            fVar = f.a(context2, (int) R.string.sp_pending_bank_trans_upload);
            fVar.a().a().d().a().c().a((Object) a.c(daysToPay, "ID")).b();
            str2 = "Pay by " + a.c(daysToPay, "ID") + " with Bank Transfer";
            i3 = 0;
            i2 = 1;
        } else {
            str2 = null;
        }
        if (i12 == 1 && i13 == 101) {
            str = b.e(R.string.sp_pending_review);
            f a3 = f.a(context);
            a3.a((int) R.string.sp_checkout_payment_verified_message).b();
            fVar2 = a3;
            i3 = 1;
            i2 = 1;
            i = 1;
            z = true;
        } else {
            fVar2 = fVar;
            z = false;
        }
        if (i12 == 1 && i13 == 103) {
            str = b.e(R.string.sp_check_info);
            int daysToPay2 = daysToPay();
            if (daysToPay2 < 2) {
                fVar6 = f.a(context2, (int) R.string.sp_checkout_remind_payment_1);
                fVar6.a().a().d().a().c().a((Object) Integer.valueOf(daysToPay2)).a((com.a.a.a) new com.a.a.a() {
                    public SpannedString format(Object obj) {
                        if (((Integer) obj).intValue() < 1) {
                            return new SpannedString(b.e(R.string.sp_label_today));
                        }
                        return new SpannedString(b.e(R.string.sp_label_tomorrow));
                    }
                }).b();
            } else {
                fVar6 = f.a(context2, (int) R.string.sp_checkout_remind_payment_2);
                fVar6.a((Object) b.a(R.string.sp_label_shipping_days, Integer.toString(daysToPay2)) + " (" + a.c(daysToPay, "ID") + SQLBuilder.PARENTHESES_RIGHT).a().d().a().c().b();
            }
            fVar2 = fVar6;
            i4 = 0;
            i3 = 0;
            i2 = 2;
            z = false;
        } else {
            i4 = i;
        }
        if (i12 == 1 && i13 == 200) {
            str = b.e(R.string.sp_contact_seller);
            String e3 = b.e(R.string.action_buyer_offline_unpaid_summary_text);
            f a4 = f.a(context);
            a4.a((int) R.string.sp_offline_contact_seller).b();
            str3 = e3;
            fVar2 = a4;
            i4 = 2;
            i3 = 0;
        } else {
            str3 = str2;
        }
        if (i12 == 1 && i13 == 102) {
            str = b.e(R.string.sp_upload_receipt);
            int daysToPay3 = daysToPay();
            if (daysToPay3 < 2) {
                fVar5 = f.a(context2, (int) R.string.sp_checkout_remind_upload_2);
                fVar5.a().a().d().a().c().a((Object) Integer.valueOf(daysToPay3)).a((com.a.a.a) new com.a.a.a() {
                    public SpannedString format(Object obj) {
                        if (((Integer) obj).intValue() < 1) {
                            return new SpannedString(b.e(R.string.sp_label_today));
                        }
                        return new SpannedString(b.e(R.string.sp_label_tomorrow));
                    }
                }).b();
            } else {
                fVar5 = f.a(context2, (int) R.string.sp_checkout_remind_upload_2);
                fVar5.a((Object) b.a(R.string.sp_label_shipping_days, Integer.toString(daysToPay3)) + " (" + a.c(daysToPay, "ID") + SQLBuilder.PARENTHESES_RIGHT).a().d().a().c().b();
            }
            fVar2 = fVar5;
            i4 = 2;
            i3 = 0;
            i2 = 1;
        }
        if (i12 == 3 && i13 == 102) {
            str = b.e(R.string.sp_upload_receipt);
            int daysToPay4 = daysToPay();
            if (daysToPay4 < 2) {
                f a5 = f.a(context2, (int) R.string.sp_checkout_remind_upload_2);
                a5.a().a().d().a().c().a((Object) Integer.valueOf(daysToPay4)).a((com.a.a.a) new com.a.a.a() {
                    public SpannedString format(Object obj) {
                        if (((Integer) obj).intValue() < 1) {
                            return new SpannedString(b.e(R.string.sp_label_today));
                        }
                        return new SpannedString(b.e(R.string.sp_label_tomorrow));
                    }
                }).b();
                fVar4 = a5;
                i5 = 0;
            } else {
                f a6 = f.a(context2, (int) R.string.sp_checkout_remind_upload_2);
                StringBuilder sb = new StringBuilder();
                i5 = 0;
                sb.append(b.a(R.string.sp_label_shipping_days, Integer.toString(daysToPay4)));
                sb.append(" (");
                sb.append(a.c(daysToPay, "ID"));
                sb.append(SQLBuilder.PARENTHESES_RIGHT);
                a6.a((Object) sb.toString()).a().d().a().c().b();
                fVar4 = a6;
            }
            z2 = true;
            i6 = 3;
            i4 = 1;
            i2 = 1;
        } else {
            z2 = z;
            i6 = 3;
            i5 = i3;
        }
        if (i12 == i6 && i13 == 101) {
            str4 = b.e(R.string.sp_pending_review);
            f a7 = f.a(context);
            a7.a((int) R.string.sp_checkout_payment_verified_message).b();
            fVar3 = a7;
            i8 = 1;
            i7 = 1;
            z3 = true;
        } else {
            z3 = z2;
            i8 = i4;
            str4 = str;
            i7 = i5;
            fVar3 = fVar2;
        }
        if (i12 == 5 && i13 == 100) {
            str4 = null;
            i7 = 2;
            i2 = 1;
            i9 = 2;
        } else {
            i9 = i8;
        }
        if (i12 == 5 && i13 == 101) {
            i11 = 2;
            str5 = null;
            i10 = 1;
        } else {
            str5 = str4;
            i11 = i7;
            i10 = i2;
        }
        return new PaymentInternalInfo(i11, str5, i10, fVar3, i9, z3, str3);
    }

    public void setCheckoutSn(String str) {
        this.checkoutSn = str;
    }

    public String getCheckoutSn() {
        return this.checkoutSn;
    }

    public void setDivider(boolean z) {
        this.divider = z;
    }

    public boolean isDivider() {
        return this.divider;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getPaymentMethod() {
        int i;
        if (isPayOffline()) {
            i = R.string.sp_offline_payment;
        } else if (isPayBankTransfer()) {
            i = R.string.sp_bank_transfer;
        } else if (isPayCyberSource()) {
            i = R.string.sp_credit_card;
        } else if (isPayNone()) {
            i = 0;
        } else if (!isCOD()) {
            return getPaymentChannelName();
        } else {
            i = R.string.sp_label_cod;
        }
        if (i == 0) {
            return b.e(R.string.sp_label_condition_not_set);
        }
        return b.e(i);
    }

    public boolean isPaymentUnsupported() {
        int i = this.paymentType;
        return (i == 1 || i == 2 || i == 3 || i == 6) ? false : true;
    }

    private boolean isPayNone() {
        return this.paymentType == 0;
    }

    private boolean isPayCyberSource() {
        return this.paymentType == 1;
    }

    private boolean isPayBankTransfer() {
        return this.paymentType == 2;
    }

    public boolean isPayOffline() {
        return this.paymentType == 3;
    }

    public boolean isCOD() {
        return this.paymentType == 6;
    }

    public void setActualPrice(long j) {
        this.actualPrice = j;
    }

    public long getActualPrice() {
        return this.actualPrice;
    }

    public void setPaymentType(int i) {
        this.paymentType = i;
    }

    public int getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentChannelName(String str) {
        this.paymentChannelName = str;
    }

    public String getPaymentChannelName() {
        return this.paymentChannelName;
    }

    public int getTotalCount() {
        int i = 0;
        for (OrderDetail totalCount : getOrderDetailList()) {
            i += totalCount.getTotalCount();
        }
        return i;
    }

    public void setPayByDate(int i) {
        this.payByDate = i;
    }

    public int getPayByDate() {
        return this.payByDate;
    }

    public void setReceiptUploadTime(int i) {
        this.receiptUploadTime = i;
    }

    public int getReceiptUploadTime() {
        return this.receiptUploadTime;
    }

    public void setReceiptProcessByDate(int i) {
        this.receiptProcessByDate = i;
    }

    public int getReceiptProcessByDate() {
        return this.receiptProcessByDate;
    }

    public void setReceiptRejectTime(int i) {
        this.receiptRejectTime = i;
    }

    public void setReceiptProcessWorkDays(int i) {
        this.receiptProcessWorkDays = i;
    }

    public int getReceiptProcessWorkDays() {
        return this.receiptProcessWorkDays;
    }

    public void setCheckoutOrderType(int i) {
        this.checkoutOrderType = i;
    }

    public int getCheckoutOrderType() {
        return this.checkoutOrderType;
    }

    public boolean isEscrow() {
        return this.checkoutOrderType == 2;
    }

    public boolean isSimple() {
        return this.checkoutOrderType == 1;
    }

    public void setUniqueCode(long j) {
        this.uniqueCode = j;
    }

    public long getUniqueCode() {
        return this.uniqueCode;
    }

    public boolean hasValidUniqueCode() {
        long j = this.uniqueCode;
        if (j == 0) {
            return false;
        }
        double d2 = (double) j;
        Double.isNaN(d2);
        if (Math.abs(d2 / 100000.0d) >= 0.01d) {
            return true;
        }
        return false;
    }

    public boolean isUnderPaid() {
        return getStatus() == 3;
    }

    public boolean hasPromotion() {
        long j = this.priceBeforeDiscount;
        return (j > 0 && j != this.totalPrice) || this.discountPercentage > 0;
    }

    public void setPaymentCard(int i) {
        this.paymentCard = i;
    }

    public int getPaymentCard() {
        return this.paymentCard;
    }

    public long getPayable() {
        return (this.totalPrice - getPaidAmount()) + getUniqueCode();
    }

    public void setUnread(boolean z) {
        this.isUnread = z;
    }

    public boolean isUnread() {
        return this.isUnread;
    }

    public void setPriceBeforeDiscount(long j) {
        this.priceBeforeDiscount = j;
    }

    public long getPriceBeforeDiscount() {
        long j = this.priceBeforeDiscount;
        if (j > 0) {
            return j;
        }
        return this.totalPrice;
    }

    public void setDiscountPercentage(int i) {
        this.discountPercentage = i;
    }

    public int getDiscountPercentage() {
        return this.discountPercentage;
    }

    public String getDiscount() {
        long j = this.priceBeforeDiscount;
        long j2 = 0;
        if (j > 0) {
            j2 = j - this.totalPrice;
        }
        String str = "-" + au.b(j2);
        if (this.discountPercentage <= 0) {
            return str;
        }
        return "-" + this.discountPercentage + "% [ " + str + " ] ";
    }

    public void setPromDescription(String str) {
        this.promDescription = str;
    }

    public String getPromDescription() {
        return this.promDescription;
    }

    public void setPromUrl(String str) {
        this.promUrl = str;
    }

    public String getPromUrl() {
        return this.promUrl;
    }

    public void setSupportChangePayment(boolean z) {
        this.supportChangePaymentMethod = z;
    }

    public boolean isSupportChangePayment() {
        return this.supportChangePaymentMethod;
    }

    public boolean logisticsNotStarted() {
        return this.logisticsStatus == 0;
    }

    private String getTimeString(int i) {
        return a.a(i, "ID");
    }

    public String getCreateTimeString() {
        return getTimeString(this.cTime);
    }

    public String getLatestTransactionTime() {
        if (this.cTime <= 0) {
            return "";
        }
        return b.e(R.string.sp_order_status_order_time) + ": " + getCreateTimeString();
    }

    public void setLogisticsStatus(int i) {
        this.logisticsStatus = i;
    }

    public static class PaymentInternalInfo {
        public int btnStatus;
        public String btnString;
        public int checkoutRedirectType;
        public boolean greyOutCancel;
        public final String shortText;
        public int showChangePayment;
        public final f textie;

        public PaymentInternalInfo(int i, String str, int i2, f fVar, int i3, boolean z, String str2) {
            this.btnStatus = i;
            this.shortText = str2;
            this.btnString = str;
            this.checkoutRedirectType = i2;
            this.textie = fVar;
            this.showChangePayment = i3;
            this.greyOutCancel = z;
        }
    }

    public String toString() {
        return "CheckoutItem{ actualPrice=" + this.actualPrice + ",\n cTime=" + this.cTime + ",\n checkoutId=" + this.checkoutId + ",\n checkoutOrderList=" + this.checkoutOrderList + ",\n checkoutOrderType=" + this.checkoutOrderType + ",\n checkoutSn='" + this.checkoutSn + '\'' + ",\n country='" + this.country + '\'' + ",\n currency='" + this.currency + '\'' + ",\n discountPercentage=" + this.discountPercentage + ",\n divider=" + this.divider + ",\n isUnread=" + this.isUnread + ",\n logisticsStatus=" + this.logisticsStatus + ",\n mTime=" + this.mTime + ",\n orderDetailList=" + this.orderDetailList + ",\n paidAmount=" + this.paidAmount + ",\n payByDate=" + this.payByDate + ",\n paymentCard=" + this.paymentCard + ",\n paymentChannelName='" + this.paymentChannelName + '\'' + ",\n paymentStatus=" + this.paymentStatus + ",\n paymentType=" + this.paymentType + ",\n priceBeforeDiscount=" + this.priceBeforeDiscount + ",\n promDescription='" + this.promDescription + '\'' + ",\n promUrl='" + this.promUrl + '\'' + ",\n receiptProcessByDate=" + this.receiptProcessByDate + ",\n receiptProcessWorkDays=" + this.receiptProcessWorkDays + ",\n receiptRejectTime=" + this.receiptRejectTime + ",\n receiptUploadTime=" + this.receiptUploadTime + ",\n remark='" + this.remark + '\'' + ",\n status=" + this.status + ",\n supportChangePaymentMethod=" + this.supportChangePaymentMethod + ",\n totalPrice=" + this.totalPrice + ",\n uniqueCode=" + this.uniqueCode + ",\n userId=" + this.userId + "} \n logic: " + h.a(this).getClass().getSimpleName();
    }
}
