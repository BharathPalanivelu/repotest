package com.shopee.app.data.viewmodel;

import android.text.TextUtils;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.database.orm.bean.DBRefund;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.app.network.f;
import com.shopee.app.util.au;
import com.shopee.id.R;
import com.shopee.protocol.shop.LogisticsOrderFlag;
import com.shopee.protocol.shop.RefundExtInfo;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetail {
    public static final int BTN_DISABLE = 1;
    public static final int BTN_GONE = 2;
    public static final int BTN_NORMAL = 0;
    public static final int RATE_BY_BUYER = 1;
    public static final int RATE_BY_SELLER = 1;
    public static final int RATE_BY_SYSTEM = 2;
    public static final int RATE_INVALID = -1;
    public static final int RATE_NONE = 0;
    private int CODProcessByDate;
    private String actualCarrier;
    private int arrangePickupByDate;
    private int autoCancellationLayer1Date;
    private int autoCancellationLayer2Date;
    private boolean bundleItem;
    private long buyerRateCmdID;
    private int buyerRated;
    private int cancelDueDate;
    private int cancelReason;
    private int cancelTime;
    private int cancelUserId;
    private long carrierShippingFee;
    private long checkoutId;
    private long coinEarn;
    private int completeTime;
    private int createTime;
    private String creditCarPromotionDesc;
    private int creditCardPercentage;
    private long creditCardPromotionValue;
    private String currency;
    private int daysExtended;
    private int daysToConfirm;
    private int daysToDelivery;
    private int daysToPay;
    private int daysToShip;
    private int daysToShipExtended;
    private String deliverFailReason;
    private String deliveryStatusDes;
    private int deliveryStatusModetime;
    private int deliveryTime;
    private int discountPercentage;
    private long discountShippingFee;
    private int distinctItemCount;
    private boolean divider;
    private int firstBuyCount;
    private String firstItemImage;
    private String firstItemName;
    private long firstItemPrice;
    private long firstItemPriceBeforeDiscount;
    private boolean firstItemReturn;
    private long firstItemSnapshotId;
    private long firstItemVariantId;
    private String firstItemVariantName;
    private long firstItemVariantOrderPrice;
    private long firstItemVariantPrice;
    private long firstItemVariantPriceBeforeDiscount;
    private long firstOrderPrice;
    private int freeReturnRefundPeriod;
    private boolean groupBuyItem;
    private List<String> images;
    private boolean isFirstItemWholesale;
    private boolean isOfficialShop;
    private boolean isRated;
    private List<Item> itemList;
    private List<OrderItemInfo> items;
    private int listType;
    private long logisticFlag;
    private long logisticsID;
    private int logisticsModTime;
    private int logisticsStatus;
    private String logisticsStatusDesc;
    private int mExpectedReceiveTime;
    private long orderId;
    private int orderStatus;
    private int orderType;
    private long originShippingFee;
    private CheckoutItem partialCheckout;
    private int payByDay;
    private int payTime;
    private String paymentChannelName;
    private long paymentFlag;
    private int paymentMethod;
    private int pickupAttempts;
    private int pickupCutoffTime;
    private String pickupDateDesc;
    private String pickupFailReason;
    private int pickupTime;
    private String portrait;
    private long priceBeforeDiscount;
    private String promDescription;
    private String promUrl;
    private int rateByDate;
    private List<DBRefund> refunds;
    private int releaseTime;
    private String remark;
    private DBReturnItem returnItem;
    private int sellerDueDate;
    private int sellerId;
    private long sellerRateCmdId;
    private int sellerRated;
    private boolean selling;
    private String serialNumber;
    private int shipByDate;
    private String shippingAddress;
    private String shippingCarrier;
    private int shippingConfirmTime;
    private long shippingFee;
    private int shippingMethod;
    private String shippingName;
    private String shippingPhone;
    private String shippingTraceNo;
    private int shopId;
    private int showRatingStatus = -1;
    private int statusExt;
    private int totalCount;
    private long totalPrice;
    private boolean unread;
    private int userId;
    private String username;

    public boolean isOfficialShop() {
        return this.isOfficialShop;
    }

    public void setOfficialShop(boolean z) {
        this.isOfficialShop = z;
    }

    public int getExpectedReceiveTime() {
        return this.mExpectedReceiveTime;
    }

    public void setExpectedReceiveTime(int i) {
        this.mExpectedReceiveTime = i;
    }

    public int getCancelDueDate() {
        return this.cancelDueDate;
    }

    public void setCancelDueDate(int i) {
        this.cancelDueDate = i;
    }

    public int getShowRating() {
        return this.showRatingStatus;
    }

    public void setShowRating(int i) {
        this.showRatingStatus = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getUserName() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public void setItemList(List<Item> list) {
        this.itemList = list;
    }

    public long getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(long j) {
        this.totalPrice = j;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public void setShippingCarrier(String str) {
        this.shippingCarrier = str;
    }

    public String getShippingTraceNo() {
        return this.shippingTraceNo;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setShippingTraceNo(String str) {
        this.shippingTraceNo = str;
    }

    public boolean ratingIsNotDefaultOrShown() {
        return (getShowRating() == -1 || getShowRating() == 3) ? false : true;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setShippingPhone(String str) {
        this.shippingPhone = str;
    }

    public String getShippingPhone() {
        return this.shippingPhone;
    }

    public void setShippingAddress(String str) {
        this.shippingAddress = str;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setItems(List<OrderItemInfo> list) {
        this.items = list;
    }

    public List<OrderItemInfo> getItems() {
        List<OrderItemInfo> list = this.items;
        return list == null ? new ArrayList() : list;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(int i) {
        this.createTime = i;
    }

    public boolean isSelling() {
        return this.selling;
    }

    public void setSelling(boolean z) {
        this.selling = z;
    }

    public int getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(int i) {
        this.sellerId = i;
    }

    public boolean isComplete() {
        return this.orderStatus == 4;
    }

    public boolean isCancelled() {
        return this.orderStatus == 5;
    }

    private boolean isShipmentSet() {
        return !TextUtils.isEmpty(getActualCarrier()) || !TextUtils.isEmpty(getShippingTraceNo());
    }

    public boolean isRated() {
        return this.isRated;
    }

    public void setRated(boolean z) {
        this.isRated = z;
    }

    public boolean isDivider() {
        return this.divider;
    }

    public void setDivider(boolean z) {
        this.divider = z;
    }

    public void setFirstOrderPrice(long j) {
        this.firstOrderPrice = j;
    }

    public long getFirstOrderPrice() {
        return this.firstOrderPrice;
    }

    public String getActualCarrier() {
        return this.actualCarrier;
    }

    public void setActualCarrier(String str) {
        this.actualCarrier = str;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }

    private int getOrderType() {
        return this.orderType;
    }

    public boolean isEscrow() {
        return this.orderType == 2;
    }

    public boolean isSimple() {
        return this.orderType == 1;
    }

    public void setDaysToShip(int i) {
        this.daysToShip = i;
    }

    public int getDaysToShip() {
        return this.daysToShip;
    }

    public void setDaysToDelivery(int i) {
        this.daysToDelivery = i;
    }

    public int getDaysToDelivery() {
        return this.daysToDelivery;
    }

    public void setDaysToConfirm(int i) {
        this.daysToConfirm = i;
    }

    public int getDaysToConfirm() {
        return this.daysToConfirm;
    }

    public void setDaysExtended(int i) {
        this.daysExtended = i;
    }

    public int getDaysExtended() {
        return this.daysExtended;
    }

    public boolean isEscrowExtended() {
        return this.daysExtended > 0;
    }

    public void setDaysToPay(int i) {
        this.daysToPay = i;
    }

    public int getDaysToPay() {
        return this.daysToPay;
    }

    public void setReleaseTime(int i) {
        this.releaseTime = i;
    }

    public int getReleaseTime() {
        return this.releaseTime;
    }

    public void setFirstItemReturn(boolean z) {
        this.firstItemReturn = z;
    }

    public boolean isFirstItemReturn() {
        return this.firstItemReturn;
    }

    public boolean isReturnProcessed() {
        int i = this.statusExt;
        return i == 9 || i == 8;
    }

    public boolean isReturnProcessing() {
        return this.statusExt == 9;
    }

    public void setStatusExt(int i) {
        this.statusExt = i;
    }

    public int getStatusExt() {
        return this.statusExt;
    }

    public void setPaymentMethod(int i) {
        this.paymentMethod = i;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setCancelUserId(int i) {
        this.cancelUserId = i;
    }

    public int getCancelUserId() {
        return this.cancelUserId;
    }

    public void setUnread(boolean z) {
        this.unread = z;
    }

    public boolean isUnread() {
        return this.unread;
    }

    public void setPaymentChannelName(String str) {
        this.paymentChannelName = str;
    }

    public String getPaymentChannelName() {
        return this.paymentChannelName;
    }

    public void setPayByDay(int i) {
        this.payByDay = i;
    }

    public int getPayByDay() {
        return this.payByDay;
    }

    public String getReleaseDateString() {
        return a.c(getReleaseTime(), "ID");
    }

    public void setCancelReason(int i) {
        this.cancelReason = i;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public List<String> getImages() {
        return this.images;
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

    public boolean isAnOffer() {
        return this.firstOrderPrice != this.firstItemPrice;
    }

    public boolean firstItemHasPromotion() {
        long j = this.firstItemPriceBeforeDiscount;
        return j > 0 && j != this.firstItemPrice;
    }

    public boolean hasPromotion() {
        return hasCreditCardPromotion() || hasVoucherPromotion();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r0 == (r4 + r2)) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasVoucherPromotion() {
        /*
            r9 = this;
            long r0 = r9.priceBeforeDiscount
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0016
            long r4 = r9.totalPrice
            long r6 = r9.creditCardPromotionValue
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0011
            r2 = r6
        L_0x0011:
            long r4 = r4 + r2
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x001a
        L_0x0016:
            int r0 = r9.discountPercentage
            if (r0 <= 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.data.viewmodel.OrderDetail.hasVoucherPromotion():boolean");
    }

    public boolean isFirstItemHasPromotion() {
        return this.firstItemPriceBeforeDiscount > 0;
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

    public String getDiscount() {
        long j = this.priceBeforeDiscount;
        long j2 = j > 0 ? j - this.totalPrice : 0;
        long j3 = this.creditCardPromotionValue;
        if (j3 > 0) {
            j2 -= j3;
        }
        if (j2 <= 0) {
            return "";
        }
        String str = "-" + au.b(j2);
        if (this.discountPercentage <= 0 || this.creditCardPromotionValue > 0) {
            return str;
        }
        return "-" + this.discountPercentage + "% [ " + str + " ] ";
    }

    public long getTotalPayment() {
        return this.totalPrice;
    }

    public void setFirstItemPriceBeforeDiscount(long j) {
        this.firstItemPriceBeforeDiscount = j;
    }

    public long getFirstItemPriceBeforeDiscount() {
        long j = this.firstItemPriceBeforeDiscount;
        if (j > 0) {
            return j;
        }
        return this.firstItemPrice;
    }

    public void setLogisticsStatus(int i) {
        this.logisticsStatus = i;
    }

    public int getLogisticsStatus() {
        return this.logisticsStatus;
    }

    public void setShippingConfirmTime(int i) {
        this.shippingConfirmTime = i;
    }

    public int getShippingConfirmTime() {
        return this.shippingConfirmTime;
    }

    public void setPickupTime(int i) {
        this.pickupTime = i;
    }

    public int getPickupTime() {
        return this.pickupTime;
    }

    public void setShippingMethod(int i) {
        this.shippingMethod = i;
    }

    public int getShippingMethod() {
        return this.shippingMethod;
    }

    public void setArrangePickupByDate(int i) {
        this.arrangePickupByDate = i;
    }

    public int getArrangePickupByDate() {
        return this.arrangePickupByDate;
    }

    public void setShipByDate(int i) {
        this.shipByDate = i;
    }

    public int getShipByDate() {
        return this.shipByDate;
    }

    public void setDiscountShippingFee(long j) {
        this.discountShippingFee = j;
    }

    public long getDiscountShippingFee() {
        return this.discountShippingFee;
    }

    public void setOriginShippingFee(long j) {
        this.originShippingFee = j;
    }

    public long getOriginShippingFee() {
        return this.originShippingFee;
    }

    public void setCarrierShippingFee(long j) {
        this.carrierShippingFee = j;
    }

    public long getCarrierShippingFee() {
        return this.carrierShippingFee;
    }

    public void setCODProcessByDate(int i) {
        this.CODProcessByDate = i;
    }

    public int getCODProcessByDate() {
        return this.CODProcessByDate;
    }

    public void setLogisticsID(long j) {
        this.logisticsID = j;
    }

    public long getLogisticsID() {
        return this.logisticsID;
    }

    public void setPickupCutoffTime(int i) {
        this.pickupCutoffTime = i;
    }

    public int getPickupCutoffTime() {
        return this.pickupCutoffTime;
    }

    public String getPickupFailReason() {
        return this.pickupFailReason;
    }

    public void setPickupFailReason(String str) {
        this.pickupFailReason = str;
    }

    public void setDeliverFailReason(String str) {
        this.deliverFailReason = str;
    }

    public String getDeliverFailReason() {
        return this.deliverFailReason;
    }

    public void setDeliveryTime(int i) {
        this.deliveryTime = i;
    }

    public int getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setSellerDueDate(int i) {
        this.sellerDueDate = i;
    }

    public int getSellerDueDate() {
        return this.sellerDueDate;
    }

    public void setListType(int i) {
        this.listType = i;
    }

    public int getListType() {
        return this.listType;
    }

    public void setLogisticsStatusDesc(String str) {
        this.logisticsStatusDesc = str;
    }

    public String getLogisticsStatusDesc() {
        return this.logisticsStatusDesc;
    }

    public void setLogisticsModTime(int i) {
        this.logisticsModTime = i;
    }

    public int getLogisticsModTime() {
        return this.logisticsModTime;
    }

    public DBReturnItem getReturnItem() {
        return this.returnItem;
    }

    public void setReturnItem(DBReturnItem dBReturnItem) {
        this.returnItem = dBReturnItem;
    }

    public void setLogisticFlag(long j) {
        this.logisticFlag = j;
    }

    public long getLogisticFlag() {
        return this.logisticFlag;
    }

    public void setPickupAttempts(int i) {
        this.pickupAttempts = i;
    }

    public void setCreditCardPromotionValue(long j) {
        this.creditCardPromotionValue = j;
    }

    public long getCreditCardPromotionValue() {
        return this.creditCardPromotionValue;
    }

    public void setCreditCarPromotionDesc(String str) {
        this.creditCarPromotionDesc = str;
    }

    public String getCreditCarPromotionDesc() {
        return this.creditCarPromotionDesc;
    }

    public void setCreditCardPercentage(int i) {
        this.creditCardPercentage = i;
    }

    public int getCreditCardPercentage() {
        return this.creditCardPercentage;
    }

    public void setPaymentFlag(long j) {
        this.paymentFlag = j;
    }

    public long getPaymentFlag() {
        return this.paymentFlag;
    }

    public void setCompleteTime(int i) {
        this.completeTime = i;
    }

    public int getCompleteTime() {
        return this.completeTime;
    }

    public void setPayTime(int i) {
        this.payTime = i;
    }

    public int getPayTime() {
        return this.payTime;
    }

    public void setCancelTime(int i) {
        this.cancelTime = i;
    }

    public int getCancelTime() {
        return this.cancelTime;
    }

    public void setFirstItemVariantName(String str) {
        this.firstItemVariantName = str;
    }

    public String getFirstItemVariantName() {
        return this.firstItemVariantName;
    }

    public void setPickupDateDesc(String str) {
        this.pickupDateDesc = str;
    }

    public String getPickupDateDesc() {
        return this.pickupDateDesc;
    }

    public void setFirstItemSnapshotId(long j) {
        this.firstItemSnapshotId = j;
    }

    public void setFirstItemVariantId(long j) {
        this.firstItemVariantId = j;
    }

    public long getFirstItemVariantId() {
        return this.firstItemVariantId;
    }

    public long getFirstItemSnapshotId() {
        return this.firstItemSnapshotId;
    }

    public long getFirstItemVariantOrderPrice() {
        return this.firstItemVariantOrderPrice;
    }

    public void setFirstItemVariantOrderPrice(long j) {
        this.firstItemVariantOrderPrice = j;
    }

    public long getFirstItemVariantPrice() {
        return this.firstItemVariantPrice;
    }

    public void setFirstItemVariantPrice(long j) {
        this.firstItemVariantPrice = j;
    }

    public long getFirstItemVariantPriceBeforeDiscount() {
        return this.firstItemVariantPriceBeforeDiscount;
    }

    public void setFirstItemVariantPriceBeforeDiscount(long j) {
        this.firstItemVariantPriceBeforeDiscount = j;
    }

    public boolean logisticsNotStarted() {
        return this.logisticsStatus == 0;
    }

    public boolean logisticsCreated() {
        return this.logisticsStatus == 1;
    }

    public boolean logisticsReady() {
        return this.logisticsStatus == 9;
    }

    public boolean isCODPaymentMethod() {
        return this.paymentMethod == 6;
    }

    public boolean noCODPaymentMethod() {
        return this.paymentMethod != 6;
    }

    public boolean isNonSupported3PL() {
        return this.shippingMethod <= 0;
    }

    public boolean isSupported3PL() {
        return this.shippingMethod >= 1;
    }

    public boolean isGHTK24h() {
        return this.shippingMethod == 50017;
    }

    public boolean noPickupTime() {
        return this.pickupTime <= 0;
    }

    public boolean beforePickupCutoffTime() {
        return a.a() < this.pickupCutoffTime;
    }

    public boolean afterPickupCutoffTime() {
        return a.a() >= this.pickupCutoffTime;
    }

    public boolean logisticsRetry() {
        return this.logisticsStatus == 3;
    }

    public boolean logisticsPickupDone() {
        return this.logisticsStatus == 2;
    }

    public boolean logisticsDeliveryDone() {
        return this.logisticsStatus == 5;
    }

    public boolean logisticsPickupFailed() {
        return this.logisticsStatus == 4;
    }

    public boolean logisticsDeliveryFailed() {
        return this.logisticsStatus == 6;
    }

    public void setDaysToShipExtended(int i) {
        this.daysToShipExtended = i;
    }

    public boolean isShippingExtended() {
        return this.daysToShipExtended > 0;
    }

    public boolean returnRequested() {
        return this.statusExt == 9;
    }

    public boolean isNoDeliveryTime() {
        return this.deliveryTime <= 0;
    }

    public boolean logisticsHasTracking() {
        long j = this.logisticFlag;
        return j >= 0 && (j & 2) != 0;
    }

    public boolean logisticsReleaseIncludeShipping() {
        long j = this.logisticFlag;
        return j >= 0 && (j & 4) != 0;
    }

    public boolean logisticsManual() {
        long j = this.logisticFlag;
        return j >= 0 && (j & 1) != 0;
    }

    public boolean logisticsAutoConsign() {
        long j = this.logisticFlag;
        return j >= 0 && (j & 8) != 0;
    }

    public boolean logisticsArrangeConsign() {
        long j = this.logisticFlag;
        return j >= 0 && (j & 16) != 0;
    }

    public void setRefunds(List<DBRefund> list) {
        this.refunds = list;
    }

    public List<DBRefund> getRefunds() {
        return this.refunds;
    }

    public boolean needBankAccount() {
        if ((this.paymentFlag & 1) == 0) {
            return false;
        }
        List<DBRefund> list = this.refunds;
        if (list != null && !list.isEmpty()) {
            for (DBRefund next : this.refunds) {
                if (!(next.a() == 1 || next.b() == null)) {
                    try {
                        if (TextUtils.isEmpty(((RefundExtInfo) f.f18486a.parseFrom(next.b(), RefundExtInfo.class)).bank_account.account_number)) {
                            return true;
                        }
                    } catch (IOException e2) {
                        com.garena.android.appkit.d.a.a(e2);
                    }
                }
            }
        }
        return false;
    }

    public void setShippingFee(long j) {
        this.shippingFee = j;
    }

    public long getShippingFee() {
        return this.shippingFee;
    }

    public boolean hasShipping() {
        return !TextUtils.isEmpty(getActualCarrier());
    }

    public boolean hasCreditCardPromotion() {
        return this.creditCardPromotionValue > 0 || !TextUtils.isEmpty(this.creditCarPromotionDesc);
    }

    public String getCreditCardDiscount() {
        String str = "-" + au.b(this.creditCardPromotionValue);
        if (this.creditCardPercentage <= 0) {
            return str;
        }
        return "-" + this.creditCardPercentage + "% [ " + str + " ] ";
    }

    private String getTimeString(int i) {
        return i <= 0 ? "" : a.a(i, "ID");
    }

    public String getCompleteTimeString() {
        return getTimeString(this.completeTime);
    }

    public String getCancelTimeString() {
        return getTimeString(this.cancelTime);
    }

    public String getDeliveryTimeString() {
        return getTimeString(this.deliveryTime);
    }

    public String getPayTimeString() {
        return getTimeString(this.payTime);
    }

    public String getCreateTimeString() {
        return getTimeString(this.createTime);
    }

    public String getLatestTransactionTime() {
        if (this.completeTime > 0) {
            return b.e(R.string.sp_order_status_complete_time) + ": " + getCompleteTimeString();
        } else if (this.cancelTime > 0) {
            return b.e(R.string.sp_order_status_cancel_time) + ": " + getCancelTimeString();
        } else if (this.deliveryTime > 0) {
            return b.e(R.string.sp_order_status_deliver_time) + ": " + getDeliveryTimeString();
        } else if (this.payTime > 0) {
            return b.e(R.string.sp_order_status_payment_time) + ": " + getPayTimeString();
        } else if (this.createTime <= 0) {
            return "";
        } else {
            return b.e(R.string.sp_order_status_order_time) + ": " + getCreateTimeString();
        }
    }

    public String getPickupTimeString() {
        if (this.pickupTime <= 0 && TextUtils.isEmpty(this.pickupDateDesc)) {
            return "";
        }
        if (!TextUtils.isEmpty(this.pickupDateDesc)) {
            return this.pickupDateDesc;
        }
        return a.c(this.pickupTime, "ID");
    }

    public boolean isFirstItemVariant() {
        return this.firstItemVariantId > 0;
    }

    public boolean isFirstItemVariantIsAnOffer() {
        if (isFirstItemVariant()) {
            long j = this.firstItemVariantOrderPrice;
            return j > 0 && j != this.firstItemVariantPrice;
        }
    }

    public boolean firstItemVariantHasPromotion() {
        return hasFirstItemVariantPromotion();
    }

    private boolean hasFirstItemVariantPromotion() {
        if (isFirstItemVariant()) {
            long j = this.firstItemVariantPriceBeforeDiscount;
            return j > 0 && j != this.firstItemVariantPrice;
        }
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public CheckoutItem getCheckoutItem() {
        return this.partialCheckout;
    }

    public void setCheckoutItem(CheckoutItem checkoutItem) {
        this.partialCheckout = checkoutItem;
    }

    public boolean hasCODDelay(int i) {
        return a.a() - this.createTime < i;
    }

    public void setDeliveryStatusDes(String str) {
        this.deliveryStatusDes = str;
    }

    public String getDeliveryStatusDes() {
        return this.deliveryStatusDes;
    }

    public void setDeliveryStatusModetime(int i) {
        this.deliveryStatusModetime = i;
    }

    public int getDeliveryStatusModetime() {
        return this.deliveryStatusModetime;
    }

    public boolean hasSellerRated() {
        return this.sellerRated == 1;
    }

    public boolean noSellerRated() {
        int i = this.sellerRated;
        return i == 0 || i == -1;
    }

    public boolean hasSellerRatedBySystem() {
        return this.sellerRated == 2;
    }

    public void setSellerRated(int i) {
        this.sellerRated = i;
    }

    public boolean hasBuyerRated() {
        return this.buyerRated == 1;
    }

    public boolean noBuyerRated() {
        int i = this.buyerRated;
        return i == 0 || i == -1;
    }

    public boolean hasBuyerRatedBySystem() {
        return this.buyerRated == 2;
    }

    public void setSellerRateCmdId(long j) {
        this.sellerRateCmdId = j;
    }

    public long getSellerRateCmdId() {
        return this.sellerRateCmdId;
    }

    public void setBuyerRated(int i) {
        this.buyerRated = i;
    }

    public void setBuyerRateCmdID(long j) {
        this.buyerRateCmdID = j;
    }

    public long getBuyerRateCmdID() {
        return this.buyerRateCmdID;
    }

    public void setRateByDate(int i) {
        this.rateByDate = i;
    }

    public int getRateByDate() {
        return this.rateByDate;
    }

    public boolean beforeRateByDate() {
        return a.a() <= this.rateByDate;
    }

    public boolean afterRateByDate() {
        return a.a() > this.rateByDate;
    }

    public void setCoinEarn(long j) {
        this.coinEarn = j;
    }

    public long getCoinEarn() {
        return this.coinEarn;
    }

    public boolean supportPickup() {
        long j = this.logisticFlag;
        return j >= 0 && (j & 16) != 0;
    }

    public boolean supportShopeeGeneratingTrackingNumber() {
        long j = this.logisticFlag;
        return j >= 0 && (j & IjkMediaMeta.AV_CH_TOP_CENTER) != 0;
    }

    public boolean supportDropOff() {
        long j = this.logisticFlag;
        return j >= 0 && (j & 8) != 0;
    }

    public boolean shipmentArraged() {
        return this.logisticsID > 0;
    }

    public void isFirstItemWholesale(boolean z) {
        this.isFirstItemWholesale = z;
    }

    public String toString() {
        return "OrderDetail{orderId=" + this.orderId + ", userId=" + this.userId + ", portrait='" + this.portrait + '\'' + ", username='" + this.username + '\'' + ", orderStatus=" + this.orderStatus + ", firstItemName='" + this.firstItemName + '\'' + ", firstItemImage='" + this.firstItemImage + '\'' + ", firstItemPrice=" + this.firstItemPrice + ", firstOrderPrice=" + this.firstOrderPrice + ", firstBuyCount=" + this.firstBuyCount + ", distinctItemCount=" + this.distinctItemCount + ", totalCount=" + this.totalCount + ", itemList=" + this.itemList + ", totalPrice=" + this.totalPrice + ", shippingName='" + this.shippingName + '\'' + ", actualCarrier='" + this.actualCarrier + '\'' + ", shippingCarrier='" + this.shippingCarrier + '\'' + ", shippingTraceNo='" + this.shippingTraceNo + '\'' + ", remark='" + this.remark + '\'' + ", shippingPhone='" + this.shippingPhone + '\'' + ", shippingAddress='" + this.shippingAddress + '\'' + ", items=" + this.items + ", shopId=" + this.shopId + ", createTime=" + this.createTime + ", selling=" + this.selling + ", isRated=" + this.isRated + ", sellerId=" + this.sellerId + ", divider=" + this.divider + ", serialNumber='" + this.serialNumber + '\'' + ", orderType=" + this.orderType + ", checkoutId=" + this.checkoutId + ", daysToShip=" + this.daysToShip + ", daysToDelivery=" + this.daysToDelivery + ", daysToConfirm=" + this.daysToConfirm + ", daysExtended=" + this.daysExtended + ", daysToPay=" + this.daysToPay + ", releaseTime=" + this.releaseTime + ", firstItemReturn=" + this.firstItemReturn + ", statusExt=" + this.statusExt + ", paymentMethod=" + this.paymentMethod + ", cancelUserId=" + this.cancelUserId + ", paymentChannelName='" + this.paymentChannelName + '\'' + ", unread=" + this.unread + ", cancelReason=" + this.cancelReason + ", payByDay=" + this.payByDay + ", images=" + this.images + ", priceBeforeDiscount=" + this.priceBeforeDiscount + ", discountPercentage=" + this.discountPercentage + ", promDescription='" + this.promDescription + '\'' + ", promUrl='" + this.promUrl + '\'' + ", firstItemPriceBeforeDiscount=" + this.firstItemPriceBeforeDiscount + ", logisticsStatus=" + this.logisticsStatus + ", shippingConfirmTime=" + this.shippingConfirmTime + ", pickupTime=" + this.pickupTime + ", shippingMethod=" + this.shippingMethod + ", arrangePickupByDate=" + this.arrangePickupByDate + ", shipByDate=" + this.shipByDate + ", discountShippingFee=" + this.discountShippingFee + ", originShippingFee=" + this.originShippingFee + ", carrierShippingFee=" + this.carrierShippingFee + ", CODProcessByDate=" + this.CODProcessByDate + ", logisticsID=" + this.logisticsID + ", pickupCutoffTime=" + this.pickupCutoffTime + ", pickupFailReason='" + this.pickupFailReason + '\'' + ", deliverFailReason='" + this.deliverFailReason + '\'' + ", daysToShipExtended=" + this.daysToShipExtended + ", deliveryTime=" + this.deliveryTime + ", listType=" + this.listType + ", sellerDueDate=" + this.sellerDueDate + ", logisticsStatusDesc='" + this.logisticsStatusDesc + '\'' + ", logisticsModTime=" + this.logisticsModTime + ", returnItem=" + this.returnItem + ", refunds=" + this.refunds + ", shippingFee=" + this.shippingFee + ", showRatingStatus=" + this.showRatingStatus + ", logisticFlag=" + this.logisticFlag + ", pickupAttempts=" + this.pickupAttempts + ", creditCardPromotionValue=" + this.creditCardPromotionValue + ", creditCarPromotionDesc='" + this.creditCarPromotionDesc + '\'' + ", creditCardPercentage=" + this.creditCardPercentage + ", completeTime=" + this.completeTime + ", payTime=" + this.payTime + ", cancelTime=" + this.cancelTime + ", paymentFlag=" + this.paymentFlag + ", firstItemVariantName='" + this.firstItemVariantName + '\'' + ", pickupDateDesc='" + this.pickupDateDesc + '\'' + ", firstItemSnapshotId=" + this.firstItemSnapshotId + ", firstItemVariantId=" + this.firstItemVariantId + ", firstItemVariantOrderPrice=" + this.firstItemVariantOrderPrice + ", firstItemVariantPrice=" + this.firstItemVariantPrice + ", firstItemVariantPriceBeforeDiscount=" + this.firstItemVariantPriceBeforeDiscount + ", currency='" + this.currency + '\'' + ", partialCheckout=" + this.partialCheckout + ", deliveryStatusDes='" + this.deliveryStatusDes + '\'' + ", deliveryStatusModetime=" + this.deliveryStatusModetime + ", sellerRated=" + this.sellerRated + ", sellerRateCmdId=" + this.sellerRateCmdId + ", buyerRated=" + this.buyerRated + ", buyerRateCmdID=" + this.buyerRateCmdID + ", rateByDate=" + this.rateByDate + ", coinEarn=" + this.coinEarn + ", isFirstItemWholesale=" + this.isFirstItemWholesale + '}';
    }

    public boolean isFirstItemWholesale() {
        return this.isFirstItemWholesale;
    }

    public boolean isBuyerSelfCollect() {
        return (this.logisticFlag & ((long) LogisticsOrderFlag.IS_SELF_COLLECT.getValue())) != 0;
    }

    public boolean isCancelPending() {
        return this.statusExt == 16;
    }

    public int getFreeReturnRefundPeriod() {
        return this.freeReturnRefundPeriod;
    }

    public void setFreeReturnRefundPeriod(int i) {
        this.freeReturnRefundPeriod = i;
    }

    public boolean isBundleItem() {
        return this.bundleItem;
    }

    public void setBundleItem(boolean z) {
        this.bundleItem = z;
    }

    public int getAutoCancellationLayer1Date() {
        return this.autoCancellationLayer1Date;
    }

    public void setAutoCancellationLayer1Date(int i) {
        this.autoCancellationLayer1Date = i;
    }

    public int getAutoCancellationLayer2Date() {
        return this.autoCancellationLayer2Date;
    }

    public void setAutoCancellationLayer2Date(int i) {
        this.autoCancellationLayer2Date = i;
    }

    public boolean isGroupBuyItem() {
        return this.groupBuyItem;
    }

    public void setGroupBuyItem(boolean z) {
        this.groupBuyItem = z;
    }

    public static class Item {
        private String itemIcon;
        private String itemName;
        private long itemPrice;
        private int itemQuantity;

        public String getItemIcon() {
            return this.itemIcon;
        }

        public void setItemIcon(String str) {
            this.itemIcon = str;
        }

        public String getItemName() {
            return this.itemName;
        }

        public void setItemName(String str) {
            this.itemName = str;
        }

        public long getItemPrice() {
            return this.itemPrice;
        }

        public void setItemPrice(long j) {
            this.itemPrice = j;
        }

        public int getItemQuantity() {
            return this.itemQuantity;
        }

        public void setItemQuantity(int i) {
            this.itemQuantity = i;
        }

        public String getItemPriceString() {
            return au.b(this.itemPrice);
        }
    }

    public String getPaymentMethodWording() {
        int i;
        if (hasPromotion() && getTotalPayment() <= 0) {
            i = R.string.sp_free_from_promotion;
        } else if (isPayOffline()) {
            i = R.string.sp_offline_payment;
        } else if (isPayBankTransfer()) {
            i = R.string.sp_bank_transfer;
        } else if (isPayCyberSource()) {
            i = R.string.sp_credit_card;
        } else if (isCODPaymentMethod()) {
            i = R.string.sp_label_cod;
        } else if (!isPayNone()) {
            return getPaymentChannelName();
        } else {
            i = 0;
        }
        if (i == 0) {
            return "";
        }
        return b.e(i);
    }

    private boolean isPayBankTransfer() {
        return this.paymentMethod == 2;
    }

    private boolean isPayCyberSource() {
        return this.paymentMethod == 1;
    }

    private boolean isPayNone() {
        return this.paymentMethod == 0;
    }

    public boolean isPayOffline() {
        return this.paymentMethod == 3;
    }

    public boolean isPaymentUnsupported() {
        int i = this.paymentMethod;
        return i <= 0 || i > 6;
    }

    public String getFirstItemName() {
        return this.firstItemName;
    }

    public void setFirstItemName(String str) {
        this.firstItemName = str;
    }

    public String getFirstItemImage() {
        return this.firstItemImage;
    }

    public void setFirstItemImage(String str) {
        this.firstItemImage = str;
    }

    public long getFirstItemPrice() {
        return this.firstItemPrice;
    }

    public void setFirstItemPrice(long j) {
        this.firstItemPrice = j;
    }

    public int getFirstBuyCount() {
        return this.firstBuyCount;
    }

    public void setFirstBuyCount(int i) {
        this.firstBuyCount = i;
    }

    public int getDistinctItemCount() {
        return this.distinctItemCount;
    }

    public void setDistinctItemCount(int i) {
        this.distinctItemCount = i;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public boolean isUnPaid() {
        return this.orderStatus == 1;
    }

    public boolean isPaid() {
        return this.orderStatus == 2;
    }

    public boolean isShipped() {
        return this.orderStatus == 3;
    }

    public boolean listToReceive() {
        return this.listType == 8;
    }

    public boolean listToShip() {
        return this.listType == 7;
    }

    public String getShippingName() {
        return this.shippingName;
    }

    public void setShippingName(String str) {
        this.shippingName = str;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public long getCheckoutId() {
        return this.checkoutId;
    }

    public void setCheckoutId(long j) {
        this.checkoutId = j;
    }

    public boolean isSellerCancelled() {
        return isCancelled() && this.sellerId == this.cancelUserId;
    }

    public boolean isBuyerCancelled() {
        if (isCancelled()) {
            int i = this.sellerId;
            int i2 = this.cancelUserId;
            return i != i2 && i2 > 0;
        }
    }

    public boolean isBackendCancelled() {
        return isCancelled() && this.cancelUserId <= 0;
    }

    public boolean isBackendCancelledUnderPaid() {
        return isBackendCancelled() && this.cancelReason == 101;
    }

    public boolean isBackendCancelledUnPaid() {
        return isBackendCancelled() && this.cancelReason == 100;
    }

    public boolean isBackendCancelledPaymentRejected() {
        return isBackendCancelled() && this.cancelReason == 102;
    }

    public boolean isCancelledPickupFailed() {
        return this.cancelReason == 201;
    }

    public boolean isCancelledDeliveryFailed() {
        return this.cancelReason == 202;
    }

    public boolean isCancelledCODRejected() {
        return this.cancelReason == 203;
    }
}
