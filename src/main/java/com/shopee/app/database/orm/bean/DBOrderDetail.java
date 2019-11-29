package com.shopee.app.database.orm.bean;

import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.shopee.app.d.b.b;
import com.shopee.app.d.b.c;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.shop.CoinInfo;
import com.shopee.protocol.shop.OrderExtInfo;
import java.io.IOException;
import java.util.List;

public class DBOrderDetail {
    @DatabaseField(columnName = "firstItemName")

    /* renamed from: a  reason: collision with root package name */
    public String f6956a;
    @DatabaseField(columnName = "actualCarrier")
    private String actualCarrier;
    @DatabaseField(columnName = "actualPrice")
    private long actualPrice;
    @DatabaseField(columnName = "status")

    /* renamed from: b  reason: collision with root package name */
    public int f6957b;
    @DatabaseField(columnName = "createTime")

    /* renamed from: c  reason: collision with root package name */
    public int f6958c;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "payTime")

    /* renamed from: d  reason: collision with root package name */
    public int f6959d;
    @DatabaseField(columnName = "reviseTime")

    /* renamed from: e  reason: collision with root package name */
    public int f6960e;
    @DatabaseField(columnName = "escrowFee")
    private long escrowFee;
    @DatabaseField(columnName = "extInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] extInfo;
    @DatabaseField(columnName = "deliveryTime")

    /* renamed from: f  reason: collision with root package name */
    public int f6961f;
    @DatabaseField(columnName = "firstBuyCount")
    private int firstBuyCount;
    @DatabaseField(columnName = "firstItemImage")
    private String firstItemImage;
    @DatabaseField(columnName = "firstItemPrice")
    private long firstItemPrice;
    @DatabaseField(columnName = "firstOrderPrice")
    private long firstOrderPrice;
    @DatabaseField(columnName = "completeTime")

    /* renamed from: g  reason: collision with root package name */
    public int f6962g;
    @DatabaseField(columnName = "cancelTime")
    public int h;
    @DatabaseField(columnName = "checkoutId")
    public long i;
    @DatabaseField(columnName = "images")
    private String images;
    @DatabaseField(columnName = "orderInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] info;
    @DatabaseField(columnName = "isRated")
    private boolean isRated;
    @DatabaseField(columnName = "distinctItemCount")
    public int j;
    @DatabaseField(columnName = "listType")
    private int listType;
    @DatabaseField(columnName = "logisticsStatus")
    private int logisticsStatus;
    @DatabaseField(columnName = "orderId", id = true)
    private long orderId;
    @DatabaseField(columnName = "orderSn")
    private String orderSn;
    @DatabaseField(columnName = "orderType")
    private int orderType;
    @DatabaseField(columnName = "paidAmount")
    private long paidAmount;
    @DatabaseField(columnName = "paymentMethod")
    private int paymentMethod;
    @DatabaseField(columnName = "pickupTime")
    private int pickupTime;
    @DatabaseField(columnName = "remark")
    private String remark;
    @DatabaseField(columnName = "sellerUserId")
    private int sellerUserId;
    @DatabaseField(columnName = "shippingAddress")
    private String shippingAddress;
    @DatabaseField(columnName = "shippingCarrier")
    private String shippingCarrier;
    @DatabaseField(columnName = "shippingConfirmTime")
    private int shippingConfirmTime;
    @DatabaseField(columnName = "shippingFee")
    private long shippingFee;
    @DatabaseField(columnName = "shippingMethod")
    private int shippingMethod;
    @DatabaseField(columnName = "shippingName")
    private String shippingName;
    @DatabaseField(columnName = "shippingPhone")
    private String shippingPhone;
    @DatabaseField(columnName = "shippingTraceNo")
    private String shippingTraceNo;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "statusExt")
    private int statusExt;
    @DatabaseField(columnName = "totalCount")
    private int totalCount;
    @DatabaseField(columnName = "totalPrice")
    private long totalPrice;
    @DatabaseField(columnName = "userId")
    private int userId;

    public long a() {
        return this.orderId;
    }

    public void a(long j2) {
        this.orderId = j2;
    }

    public int b() {
        return this.shopId;
    }

    public void a(int i2) {
        this.shopId = i2;
    }

    public int c() {
        return this.userId;
    }

    public void b(int i2) {
        this.userId = i2;
    }

    public String d() {
        return this.orderSn;
    }

    public void a(String str) {
        this.orderSn = str;
    }

    public long e() {
        return this.totalPrice;
    }

    public void b(long j2) {
        this.totalPrice = j2;
    }

    public void c(long j2) {
        this.actualPrice = j2;
    }

    public void d(long j2) {
        this.paidAmount = j2;
    }

    public String f() {
        return this.currency;
    }

    public void b(String str) {
        this.currency = str;
    }

    public int g() {
        return this.shippingMethod;
    }

    public void c(int i2) {
        this.shippingMethod = i2;
    }

    public String h() {
        return this.shippingName;
    }

    public void c(String str) {
        this.shippingName = str;
    }

    public String i() {
        return this.shippingPhone;
    }

    public void d(String str) {
        this.shippingPhone = str;
    }

    public String j() {
        return this.shippingAddress;
    }

    public void e(String str) {
        this.shippingAddress = str;
    }

    public long k() {
        return this.shippingFee;
    }

    public void e(long j2) {
        this.shippingFee = j2;
    }

    public String l() {
        return this.shippingCarrier;
    }

    public void f(String str) {
        this.shippingCarrier = str;
    }

    public String m() {
        return this.shippingTraceNo;
    }

    public void g(String str) {
        this.shippingTraceNo = str;
    }

    public String n() {
        return this.actualCarrier;
    }

    public void h(String str) {
        this.actualCarrier = str;
    }

    public int o() {
        return this.orderType;
    }

    public void d(int i2) {
        this.orderType = i2;
    }

    public int p() {
        return this.paymentMethod;
    }

    public void e(int i2) {
        this.paymentMethod = i2;
    }

    public void f(long j2) {
        this.escrowFee = j2;
    }

    public String q() {
        return this.remark;
    }

    public void i(String str) {
        this.remark = str;
    }

    public String r() {
        return this.firstItemImage;
    }

    public void a(List<String> list) {
        if (af.a(list)) {
            this.firstItemImage = "";
            this.images = "";
            return;
        }
        for (String next : list) {
            if (!TextUtils.isEmpty(this.images)) {
                this.images += ',';
            } else {
                this.images = next;
            }
        }
        this.firstItemImage = list.get(0);
    }

    public String s() {
        return this.f6956a;
    }

    public void j(String str) {
        this.f6956a = str;
    }

    public int t() {
        return this.f6957b;
    }

    public void f(int i2) {
        this.f6957b = i2;
    }

    public int u() {
        return this.f6958c;
    }

    public void g(int i2) {
        this.f6958c = i2;
    }

    public int v() {
        return this.f6959d;
    }

    public void h(int i2) {
        this.f6959d = i2;
    }

    public void i(int i2) {
        this.f6960e = i2;
    }

    public int w() {
        return this.f6961f;
    }

    public void j(int i2) {
        this.f6961f = i2;
    }

    public int x() {
        return this.f6962g;
    }

    public void k(int i2) {
        this.f6962g = i2;
    }

    public int y() {
        return this.h;
    }

    public void l(int i2) {
        this.h = i2;
    }

    public Long z() {
        return Long.valueOf(this.i);
    }

    public void a(Long l) {
        this.i = l.longValue();
    }

    public int A() {
        return this.j;
    }

    public void m(int i2) {
        this.j = i2;
    }

    public void g(long j2) {
        this.firstItemPrice = j2;
    }

    public long B() {
        return this.firstItemPrice;
    }

    public void n(int i2) {
        this.firstBuyCount = i2;
    }

    public int C() {
        return this.firstBuyCount;
    }

    public void o(int i2) {
        this.totalCount = i2;
    }

    public int D() {
        return this.totalCount;
    }

    public void p(int i2) {
        this.sellerUserId = i2;
    }

    public int E() {
        return this.sellerUserId;
    }

    public void a(Boolean bool) {
        this.isRated = bool.booleanValue();
    }

    public Boolean F() {
        return Boolean.valueOf(this.isRated);
    }

    public void a(OrderExtInfo orderExtInfo) {
        this.extInfo = orderExtInfo.toByteArray();
    }

    public byte[] G() {
        return this.extInfo;
    }

    public void a(OrderInfo orderInfo) {
        this.info = orderInfo.toByteArray();
    }

    public byte[] H() {
        return this.info;
    }

    public void h(long j2) {
        this.firstOrderPrice = j2;
    }

    public long I() {
        return this.firstOrderPrice;
    }

    public int J() {
        return this.statusExt;
    }

    public void q(int i2) {
        this.statusExt = i2;
    }

    public void r(int i2) {
        this.logisticsStatus = i2;
    }

    public int K() {
        return this.logisticsStatus;
    }

    public void s(int i2) {
        this.shippingConfirmTime = i2;
    }

    public int L() {
        return this.shippingConfirmTime;
    }

    public void t(int i2) {
        this.pickupTime = i2;
    }

    public int M() {
        return this.pickupTime;
    }

    public int N() {
        return this.listType;
    }

    public void u(int i2) {
        this.listType = i2;
    }

    public long O() {
        byte[] G = G();
        if (G != null) {
            OrderExtInfo a2 = c.a(G);
            if (a2.coin_info != null) {
                try {
                    return b.a(((CoinInfo) f.f18486a.parseFrom(a2.coin_info.toByteArray(), CoinInfo.class)).coin_earn);
                } catch (IOException e2) {
                    a.a(e2);
                }
            }
        }
        return 0;
    }
}
