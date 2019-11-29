package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.d.a;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.network.f;
import com.shopee.protocol.shop.BundleOrderItemDetailInfo;
import com.shopee.protocol.shop.OrderItem;
import com.shopee.protocol.shop.OrderItemExtInfo;
import com.shopee.protocol.shop.ReturnInfo;
import java.io.IOException;

@DatabaseTable(tableName = "sp_return_item")
public class DBReturnItem {
    @DatabaseField(columnName = "byteReturnInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] byteReturnInfo;
    @DatabaseField(columnName = "ctime")
    private int ctime;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "ext")
    private String ext;
    @DatabaseField(columnName = "mtime")
    private int mtime;
    @DatabaseField(columnName = "orderId")
    private long orderId;
    private ReturnFirstItem orderItem;
    @DatabaseField(columnName = "reason")
    private int reason;
    @DatabaseField(columnName = "refund", dataType = DataType.BYTE_ARRAY)
    private byte[] refund;
    @DatabaseField(columnName = "amount")
    private long refundAmount;
    @DatabaseField(columnName = "refundExtInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] refundExtInfo;
    private ReturnInfo returnExtInfo = null;
    @DatabaseField(columnName = "returnId", id = true)
    private long returnId;
    @DatabaseField(columnName = "returnSN")
    private String returnSN;
    private int sellerDueDay;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "status")
    private int status;
    private int totalReturnItemCount = 0;
    @DatabaseField(columnName = "userId")
    private int userId;

    public DBReturnItem() {
        s();
    }

    public String a() {
        return this.ext;
    }

    public void a(String str) {
        this.ext = str;
    }

    public long b() {
        return this.returnId;
    }

    public void a(long j) {
        this.returnId = j;
    }

    public long c() {
        return this.orderId;
    }

    public void b(long j) {
        this.orderId = j;
    }

    public int d() {
        return this.shopId;
    }

    public void a(int i) {
        this.shopId = i;
    }

    public int e() {
        return this.userId;
    }

    public void b(int i) {
        this.userId = i;
    }

    public long f() {
        return this.refundAmount;
    }

    public void c(long j) {
        this.refundAmount = j;
    }

    public void b(String str) {
        this.currency = str;
    }

    public String g() {
        return this.returnSN;
    }

    public void c(String str) {
        this.returnSN = str;
    }

    public int h() {
        return this.reason;
    }

    public void c(int i) {
        this.reason = i;
    }

    public int i() {
        return this.status;
    }

    public void d(int i) {
        this.status = i;
    }

    public int j() {
        return this.ctime;
    }

    public void e(int i) {
        this.ctime = i;
    }

    public int k() {
        return this.mtime;
    }

    public void f(int i) {
        this.mtime = i;
    }

    public void a(byte[] bArr) {
        this.byteReturnInfo = bArr;
        s();
    }

    public ReturnInfo l() {
        if (this.returnExtInfo == null) {
            s();
        }
        return this.returnExtInfo;
    }

    public int m() {
        if (this.returnExtInfo == null) {
            s();
        }
        ReturnInfo returnInfo = this.returnExtInfo;
        if (returnInfo == null) {
            return 0;
        }
        return returnInfo.item.size();
    }

    public ReturnFirstItem n() {
        if (this.returnExtInfo == null) {
            s();
        }
        return this.orderItem;
    }

    public int o() {
        if (this.returnExtInfo == null) {
            s();
        }
        return this.totalReturnItemCount;
    }

    public int p() {
        return this.sellerDueDay;
    }

    private void s() {
        try {
            if (this.byteReturnInfo != null) {
                this.returnExtInfo = (ReturnInfo) f.f18486a.parseFrom(this.byteReturnInfo, ReturnInfo.class);
                if (this.returnExtInfo != null) {
                    this.sellerDueDay = b.a(this.returnExtInfo.seller_due_date);
                    if (this.returnExtInfo.item == null) {
                        return;
                    }
                    if (!this.returnExtInfo.item.isEmpty()) {
                        if (this.returnExtInfo.item.get(0) != null) {
                            OrderItem orderItem2 = this.returnExtInfo.item.get(0);
                            this.orderItem = new ReturnFirstItem(orderItem2, orderItem2.extinfo != null ? (OrderItemExtInfo) f.f18486a.parseFrom(orderItem2.extinfo.i(), OrderItemExtInfo.class) : null);
                        }
                        for (OrderItem next : this.returnExtInfo.item) {
                            OrderItemExtInfo orderItemExtInfo = next.extinfo != null ? (OrderItemExtInfo) f.f18486a.parseFrom(next.extinfo.i(), OrderItemExtInfo.class) : null;
                            ReturnFirstItem returnFirstItem = new ReturnFirstItem(next, orderItemExtInfo);
                            if (!returnFirstItem.c() || orderItemExtInfo == null) {
                                this.totalReturnItemCount += returnFirstItem.h();
                            } else {
                                for (BundleOrderItemDetailInfo bundleOrderItemDetailInfo : orderItemExtInfo.bundle_order_item.item_list) {
                                    this.totalReturnItemCount += b.a(bundleOrderItemDetailInfo.amount, 0);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e2) {
            a.a(e2);
        }
    }

    public void b(byte[] bArr) {
        this.refundExtInfo = bArr;
    }

    public byte[] q() {
        return this.refundExtInfo;
    }

    public void c(byte[] bArr) {
        this.refund = bArr;
    }

    public byte[] r() {
        return this.refund;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DBReturnItem) || this.returnId != ((DBReturnItem) obj).b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) this.returnId;
    }

    public static class ReturnFirstItem {
        private final boolean isBundle;
        private final boolean isWholesale;
        private final long itemPrice;
        private final Long modelId;
        private final long orderPrice;
        private final int quantity;
        private final int shopId;
        private final long snapshotId;

        public long a() {
            return this.snapshotId;
        }

        public int b() {
            return this.shopId;
        }

        public boolean c() {
            return this.isBundle;
        }

        public boolean d() {
            return this.isWholesale;
        }

        public Long e() {
            return this.modelId;
        }

        public long f() {
            return this.itemPrice;
        }

        public long g() {
            return this.orderPrice;
        }

        public int h() {
            return this.quantity;
        }

        public ReturnFirstItem(OrderItem orderItem, OrderItemExtInfo orderItemExtInfo) {
            this.shopId = orderItem.shopid.intValue();
            this.isWholesale = orderItemExtInfo != null && b.a(orderItemExtInfo.is_wholesale, false);
            this.isBundle = orderItemExtInfo != null && orderItemExtInfo.bundle_order_item != null && b.a(orderItemExtInfo.bundle_order_item.bundle_deal_id, 0) > 0 && orderItemExtInfo.bundle_order_item.item_list != null && orderItemExtInfo.bundle_order_item.item_list.size() > 0 && ar.f().e().settingConfigStore().isBundleEnabled();
            if (this.isBundle) {
                BundleOrderItemDetailInfo bundleOrderItemDetailInfo = orderItemExtInfo.bundle_order_item.item_list.get(0);
                this.snapshotId = b.a(bundleOrderItemDetailInfo.snapshotid);
                this.modelId = Long.valueOf(b.a(bundleOrderItemDetailInfo.modelid));
                this.itemPrice = b.a(orderItem.item_price);
                this.orderPrice = b.a(orderItem.order_price);
                this.quantity = 1;
                return;
            }
            this.snapshotId = b.a(orderItem.snapshotid);
            this.modelId = Long.valueOf(b.a(orderItem.modelid));
            this.itemPrice = b.a(orderItem.item_price);
            this.orderPrice = b.a(orderItem.order_price);
            this.quantity = b.a(orderItem.amount, 0);
        }
    }
}
