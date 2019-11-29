package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_refund")
public class DBRefund {
    @DatabaseField(columnName = "amount")
    private long amount;
    @DatabaseField(columnName = "bankAccountId")
    private int bankAccountId;
    @DatabaseField(columnName = "checkoutId")
    private long checkoutId;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "ctime", index = true)
    private int ctime;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "extInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] extInfo;
    @DatabaseField(columnName = "mtime")
    private int mtime;
    @DatabaseField(columnName = "orderId", index = true)
    private long orderId;
    @DatabaseField(columnName = "paymentMethod")
    private int paymentMethod;
    @DatabaseField(columnName = "reason")
    private String reason;
    @DatabaseField(columnName = "refundId", id = true)
    private long refundId;
    @DatabaseField(columnName = "refundSN")
    private String refundSN;
    @DatabaseField(columnName = "returnId")
    private long returnId;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "userId")
    private int userId;

    public void a(long j) {
        this.refundId = j;
    }

    public void a(int i) {
        this.userId = i;
    }

    public void b(int i) {
        this.status = i;
    }

    public void b(long j) {
        this.amount = j;
    }

    public void a(String str) {
        this.currency = str;
    }

    public void b(String str) {
        this.reason = str;
    }

    public void c(int i) {
        this.ctime = i;
    }

    public void d(int i) {
        this.mtime = i;
    }

    public void c(long j) {
        this.orderId = j;
    }

    public void e(int i) {
        this.shopId = i;
    }

    public void c(String str) {
        this.country = str;
    }

    public void d(String str) {
        this.refundSN = str;
    }

    public void d(long j) {
        this.checkoutId = j;
    }

    public int a() {
        return this.paymentMethod;
    }

    public void f(int i) {
        this.paymentMethod = i;
    }

    public byte[] b() {
        return this.extInfo;
    }

    public void a(byte[] bArr) {
        this.extInfo = bArr;
    }

    public void g(int i) {
        this.bankAccountId = i;
    }
}
