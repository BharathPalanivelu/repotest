package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class DBTransaction {
    @DatabaseField(columnName = "amount")
    private long amount;
    @DatabaseField(columnName = "autoid", generatedId = true)
    private int autoId;
    @DatabaseField(columnName = "cTime")
    private int cTime;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "customName")
    private String customName;
    @DatabaseField(columnName = "extinfo", dataType = DataType.BYTE_ARRAY)
    private byte[] extInfo;
    @DatabaseField(columnName = "hisType")
    private int hisType;
    @DatabaseField(columnName = "image")
    private String image;
    @DatabaseField(columnName = "mTime")
    private int mTime;
    @DatabaseField(columnName = "orderId")
    private long orderId;
    @DatabaseField(columnName = "releaseTime")
    private int releaseTime;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "transId")
    private int transId;
    @DatabaseField(columnName = "transType")
    private int transType;
    @DatabaseField(columnName = "userId")
    private int userId;
    @DatabaseField(columnName = "withdrawBankAcc")
    private String withdrawBankAcc;
    @DatabaseField(columnName = "withdrawName")
    private String withdrawName;
    @DatabaseField(columnName = "withdrawTransfee")
    private long withdrawTransfee;

    public byte[] a() {
        return this.extInfo;
    }

    public void a(byte[] bArr) {
        this.extInfo = bArr;
    }

    public void a(int i) {
        this.transId = i;
    }

    public void b(int i) {
        this.userId = i;
    }

    public int b() {
        return this.shopId;
    }

    public void c(int i) {
        this.shopId = i;
    }

    public long c() {
        return this.orderId;
    }

    public void a(long j) {
        this.orderId = j;
    }

    public void a(String str) {
        this.image = str;
    }

    public String d() {
        return this.customName;
    }

    public void b(String str) {
        this.customName = str;
    }

    public void c(String str) {
        this.withdrawName = str;
    }

    public void d(String str) {
        this.withdrawBankAcc = str;
    }

    public long e() {
        return this.amount;
    }

    public void b(long j) {
        this.amount = j;
    }

    public void e(String str) {
        this.currency = str;
    }

    public void c(long j) {
        this.withdrawTransfee = j;
    }

    public void d(int i) {
        this.transType = i;
    }

    public int f() {
        return this.status;
    }

    public void e(int i) {
        this.status = i;
    }

    public void f(int i) {
        this.cTime = i;
    }

    public int g() {
        return this.mTime;
    }

    public void g(int i) {
        this.mTime = i;
    }

    public void h(int i) {
        this.hisType = i;
    }

    public void i(int i) {
        this.releaseTime = i;
    }

    public int h() {
        return this.releaseTime;
    }
}
