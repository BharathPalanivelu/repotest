package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.d.a;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.d.b.b;
import com.shopee.app.network.f;
import com.shopee.protocol.shop.CheckoutInfo;
import com.shopee.protocol.shop.CheckoutOrder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "sp_checkout_item")
public class DBCheckoutItem {
    @DatabaseField(columnName = "actualPrice")
    private long actualPrice;
    @DatabaseField(columnName = "cTime")
    private int cTime;
    @DatabaseField(columnName = "checkoutId", id = true)
    private long checkoutId;
    @DatabaseField(columnName = "checkoutInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] checkoutInfo;
    private List<DBCheckoutOrder> checkoutOrderList;
    @DatabaseField(columnName = "checkoutSn")
    private String checkoutSn;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "logisticsStatus")
    private int logisticsStatus;
    @DatabaseField(columnName = "mTIME")
    private int mTime;
    @DatabaseField(columnName = "paidAmount")
    private long paidAmount;
    @DatabaseField(columnName = "paymentStatus")
    private int paymentStatus;
    @DatabaseField(columnName = "paymentType")
    private int paymentType;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "totalPrice")
    private long totalPrice;
    @DatabaseField(columnName = "userId")
    private int userId;

    public long a() {
        return this.checkoutId;
    }

    public void a(long j) {
        this.checkoutId = j;
    }

    public int b() {
        return this.userId;
    }

    public void a(int i) {
        this.userId = i;
    }

    public int c() {
        return this.status;
    }

    public void b(int i) {
        this.status = i;
    }

    public long d() {
        return this.totalPrice;
    }

    public void b(long j) {
        this.totalPrice = j;
    }

    public long e() {
        return this.paidAmount;
    }

    public void c(long j) {
        this.paidAmount = j;
    }

    public String f() {
        return this.currency;
    }

    public void a(String str) {
        this.currency = str;
    }

    public int g() {
        return this.cTime;
    }

    public void c(int i) {
        this.cTime = i;
    }

    public int h() {
        return this.mTime;
    }

    public void d(int i) {
        this.mTime = i;
    }

    public List<DBCheckoutOrder> i() {
        if (this.checkoutOrderList == null) {
            q();
        }
        List<DBCheckoutOrder> list = this.checkoutOrderList;
        return list == null ? new ArrayList() : list;
    }

    public void a(byte[] bArr) {
        this.checkoutInfo = bArr;
        q();
    }

    public CheckoutInfo j() {
        try {
            return (CheckoutInfo) f.f18486a.parseFrom(this.checkoutInfo, 0, this.checkoutInfo.length, CheckoutInfo.class);
        } catch (IOException e2) {
            a.a(e2);
            return null;
        }
    }

    private void q() {
        ArrayList arrayList = new ArrayList();
        if (this.checkoutInfo == null) {
            this.checkoutOrderList = arrayList;
            return;
        }
        try {
            CheckoutInfo checkoutInfo2 = (CheckoutInfo) f.f18486a.parseFrom(this.checkoutInfo, 0, this.checkoutInfo.length, CheckoutInfo.class);
            if (checkoutInfo2.order != null) {
                for (CheckoutOrder a2 : checkoutInfo2.order) {
                    DBCheckoutOrder dBCheckoutOrder = new DBCheckoutOrder();
                    b.a(a2, dBCheckoutOrder);
                    arrayList.add(dBCheckoutOrder);
                }
            }
            this.checkoutOrderList = arrayList;
        } catch (IOException e2) {
            a.a(e2);
        }
    }

    public String k() {
        return this.country;
    }

    public void b(String str) {
        this.country = str;
    }

    public int l() {
        return this.paymentStatus;
    }

    public void e(int i) {
        this.paymentStatus = i;
    }

    public String m() {
        return this.checkoutSn;
    }

    public void c(String str) {
        this.checkoutSn = str;
    }

    public void d(long j) {
        this.actualPrice = j;
    }

    public long n() {
        return this.actualPrice;
    }

    public void f(int i) {
        this.paymentType = i;
    }

    public int o() {
        return this.paymentType;
    }

    public void g(int i) {
        this.logisticsStatus = i;
    }

    public int p() {
        return this.logisticsStatus;
    }
}
