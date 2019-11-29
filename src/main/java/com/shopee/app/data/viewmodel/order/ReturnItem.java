package com.shopee.app.data.viewmodel.order;

import android.text.TextUtils;
import com.shopee.protocol.shop.BankAccountInfo;

public class ReturnItem {
    private int acceptedDate;
    private long amountBeforeDiscount;
    private BankAccountInfo bankInfo;
    private int cTime;
    private int deliveryDoneDate;
    private int distinctItemCount;
    private boolean firstItemBundle;
    private String firstItemImage;
    private String firstItemName;
    private int freeReturnRefundPeriod;
    private boolean groupBuyItem;
    private boolean inComplete;
    private boolean isFirstItemWholesale;
    private boolean isOfficialShop;
    private boolean isSelling;
    private boolean isUnread;
    private long itemPrice;
    private int judgingTime;
    private int logisticStatus;
    private String logisticStatusDes;
    private int mRequestDate;
    private int mReturnSellerDueDate;
    private int mReturnShipDueDate;
    private int mTime;
    private String modelName;
    private boolean nonReceipt;
    private long orderId;
    private long orderPaymentFlag;
    private long orderPrice;
    private int paymentMethod;
    private int quantity;
    private long refundAmount;
    private long returnId;
    private String returnSN;
    private int sellerDueDay;
    private int sellerId;
    private int shopId;
    private boolean shopeeHandle;
    private int status;
    private boolean supportedShippingMethod;
    private int totalReturnItemCount;
    private String trackingNumber;
    private String userAvatar;
    private int userId;
    private String userName;

    public int getAcceptedDate() {
        return this.acceptedDate;
    }

    public void setAcceptedDate(int i) {
        this.acceptedDate = i;
    }

    public int getLogisticStatus() {
        return this.logisticStatus;
    }

    public void setLogisticStatus(int i) {
        this.logisticStatus = i;
    }

    public boolean isSupportedShippingMethod() {
        return this.supportedShippingMethod;
    }

    public void setSupportedShippingMethod(boolean z) {
        this.supportedShippingMethod = z;
    }

    public boolean isNonReceipt() {
        return this.nonReceipt;
    }

    public void setNonReceipt(boolean z) {
        this.nonReceipt = z;
    }

    public int getFreeReturnRefundPeriod() {
        return this.freeReturnRefundPeriod;
    }

    public void setFreeReturnRefundPeriod(int i) {
        this.freeReturnRefundPeriod = i;
    }

    public int getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(int i) {
        this.sellerId = i;
    }

    public boolean isOfficialShop() {
        return this.isOfficialShop;
    }

    public void setOfficialShop(boolean z) {
        this.isOfficialShop = z;
    }

    public void setReturnId(long j) {
        this.returnId = j;
    }

    public long getReturnId() {
        return this.returnId;
    }

    public String getReturnSN() {
        return this.returnSN;
    }

    public void setReturnSN(String str) {
        this.returnSN = str;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setRefundAmount(long j) {
        this.refundAmount = j;
    }

    public long getRefundAmount() {
        return this.refundAmount;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public void setFirstItemName(String str) {
        this.firstItemName = str;
    }

    public String getFirstItemName() {
        return this.firstItemName;
    }

    public void setFirstItemImage(String str) {
        this.firstItemImage = str;
    }

    public String getFirstItemImage() {
        return this.firstItemImage;
    }

    public void setItemPrice(long j) {
        this.itemPrice = j;
    }

    public long getItemPrice() {
        return this.itemPrice;
    }

    public void setOrderPrice(long j) {
        this.orderPrice = j;
    }

    public long getOrderPrice() {
        return this.orderPrice;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getDistinctItemCount() {
        return this.distinctItemCount;
    }

    public void setDistinctItemCount(int i) {
        this.distinctItemCount = i;
    }

    public boolean isSelling() {
        return this.isSelling;
    }

    public void setSelling(boolean z) {
        this.isSelling = z;
    }

    public void setTotalReturnItemCount(int i) {
        this.totalReturnItemCount = i;
    }

    public int getTotalReturnItemCount() {
        return this.totalReturnItemCount;
    }

    public void setCTime(int i) {
        this.cTime = i;
    }

    public int getCTime() {
        return this.cTime;
    }

    public void setMTime(int i) {
        this.mTime = i;
    }

    public int getMTime() {
        return this.mTime;
    }

    public void setSellerDueDay(int i) {
        this.sellerDueDay = i;
    }

    public int getSellerDueDay() {
        return this.sellerDueDay;
    }

    public void setBankInfo(BankAccountInfo bankAccountInfo) {
        this.bankInfo = bankAccountInfo;
    }

    public BankAccountInfo getBankInfo() {
        return this.bankInfo;
    }

    public void setJudgingTime(int i) {
        this.judgingTime = i;
    }

    public int getJudgingTime() {
        return this.judgingTime;
    }

    public boolean isNotReturnJudging() {
        return getStatus() != 4;
    }

    public boolean hasValidJudgingTime() {
        return this.judgingTime > 0;
    }

    public boolean needBankAccount() {
        long j = this.orderPaymentFlag;
        if (!(j <= 0 || (j & 2) == 0 || this.paymentMethod == 1)) {
            BankAccountInfo bankAccountInfo = this.bankInfo;
            if ((bankAccountInfo == null || !TextUtils.isEmpty(bankAccountInfo.account_number)) && this.bankInfo != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void setPaymentMethod(int i) {
        this.paymentMethod = i;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setUnread(boolean z) {
        this.isUnread = z;
    }

    public boolean isUnread() {
        return this.isUnread;
    }

    public void setAmountBeforeDiscount(long j) {
        this.amountBeforeDiscount = j;
    }

    public long getAmountBeforeDiscount() {
        return this.amountBeforeDiscount;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public String getModelName() {
        return this.modelName;
    }

    public boolean isAnOffer() {
        return this.orderPrice != this.itemPrice;
    }

    public boolean hasPromotions() {
        long j = this.amountBeforeDiscount;
        return j > 0 && j != this.itemPrice;
    }

    public void setOrderPaymentFlag(long j) {
        this.orderPaymentFlag = j;
    }

    public Long getOrderPaymentFlag() {
        return Long.valueOf(this.orderPaymentFlag);
    }

    public void isFirstItemWholesale(boolean z) {
        this.isFirstItemWholesale = z;
    }

    public boolean isFirstItemWholesale() {
        return this.isFirstItemWholesale;
    }

    public String toString() {
        return "ReturnItem{amountBeforeDiscount=" + this.amountBeforeDiscount + ", returnId=" + this.returnId + ", shopId=" + this.shopId + ", userId=" + this.userId + ", orderId=" + this.orderId + ", refundAmount=" + this.refundAmount + ", status=" + this.status + ", userName='" + this.userName + '\'' + ", userAvatar='" + this.userAvatar + '\'' + ", firstItemName='" + this.firstItemName + '\'' + ", firstItemImage='" + this.firstItemImage + '\'' + ", itemPrice=" + this.itemPrice + ", orderPrice=" + this.orderPrice + ", quantity=" + this.quantity + ", distinctItemCount=" + this.distinctItemCount + ", isSelling=" + this.isSelling + ", totalReturnItemCount=" + this.totalReturnItemCount + ", cTime=" + this.cTime + ", mTime=" + this.mTime + ", returnSN='" + this.returnSN + '\'' + ", sellerDueDay=" + this.sellerDueDay + ", returnSellerDueDate=" + this.mReturnSellerDueDate + ", returnShipDueDate=" + this.mReturnShipDueDate + ", bankInfo=" + this.bankInfo + ", judgingTime=" + this.judgingTime + ", paymentMethod=" + this.paymentMethod + ", isUnread=" + this.isUnread + ", modelName='" + this.modelName + '\'' + ", orderPaymentFlag=" + this.orderPaymentFlag + ", isFirstItemWholesale=" + this.isFirstItemWholesale + '}';
    }

    public String getLogisticStatusDes() {
        return this.logisticStatusDes;
    }

    public void setLogisticStatusDes(String str) {
        this.logisticStatusDes = str;
    }

    public int getDeliveryDoneDate() {
        return this.deliveryDoneDate;
    }

    public void setDeliveryDoneDate(int i) {
        this.deliveryDoneDate = i;
    }

    public boolean isFirstItemBundle() {
        return this.firstItemBundle;
    }

    public void setFirstItemBundle(boolean z) {
        this.firstItemBundle = z;
    }

    public void setIncompleteProduct(boolean z) {
        this.inComplete = z;
    }

    public boolean isInComplete() {
        return this.inComplete;
    }

    public void setReturnSellerDueDate(int i) {
        this.mReturnSellerDueDate = i;
    }

    public int getReturnSellerDueDate() {
        return this.mReturnSellerDueDate;
    }

    public void setReturnShipDueDate(int i) {
        this.mReturnShipDueDate = i;
    }

    public int getReturnShipDueDate() {
        return this.mReturnShipDueDate;
    }

    public void setRequestDate(int i) {
        this.mRequestDate = i;
    }

    public int getRequestDate() {
        return this.mRequestDate;
    }

    public boolean isBeforePickUpDone() {
        int i = this.logisticStatus;
        return (i == 2 || i == 11 || i == 5 || i == 6) ? false : true;
    }

    public boolean isPickupDone() {
        return this.logisticStatus == 2;
    }

    public boolean isLogisticDeliveryDone() {
        return this.logisticStatus == 5;
    }

    public boolean isLogisticRequestCreated() {
        return this.logisticStatus == 1;
    }

    public boolean isLogisticPendingArrange() {
        return this.logisticStatus == 12;
    }

    public boolean isLogisticReady() {
        return this.logisticStatus == 9;
    }

    public boolean isLogisticNotStarted() {
        return this.logisticStatus == 0;
    }

    public boolean isGroupBuyItem() {
        return this.groupBuyItem;
    }

    public void setGroupBuyItem(boolean z) {
        this.groupBuyItem = z;
    }

    public String getTrackingNumber() {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String str) {
        this.trackingNumber = str;
    }

    public boolean hasTrackingNumber() {
        return !TextUtils.isEmpty(this.trackingNumber);
    }

    public boolean isShopeeHandle() {
        return this.shopeeHandle;
    }

    public void setShopeeHandle(boolean z) {
        this.shopeeHandle = z;
    }
}
