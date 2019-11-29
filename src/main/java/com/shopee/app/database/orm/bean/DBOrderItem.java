package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_order_item")
public class DBOrderItem {

    /* renamed from: a  reason: collision with root package name */
    public static String f6963a = "sp_order_item";
    @DatabaseField(columnName = "amount")
    private int amount;
    @DatabaseField(columnName = "chatId")
    private long chatId;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "id", generatedId = true)
    private long id;
    @DatabaseField(columnName = "itemId")
    private long itemId;
    @DatabaseField(columnName = "itemPrice")
    private long itemPrice;
    @DatabaseField(columnName = "modelId")
    private long modelId;
    @DatabaseField(columnName = "orderId")
    private long orderId;
    @DatabaseField(columnName = "orderPrice")
    private long orderPrice;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "snapshotId")
    private long snapshotId;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "userId")
    private int userId;

    public long a() {
        return this.orderId;
    }

    public void a(long j) {
        this.orderId = j;
    }

    public int b() {
        return this.userId;
    }

    public void a(int i) {
        this.userId = i;
    }

    public int c() {
        return this.shopId;
    }

    public void b(int i) {
        this.shopId = i;
    }

    public long d() {
        return this.itemId;
    }

    public void b(long j) {
        this.itemId = j;
    }

    public long e() {
        return this.modelId;
    }

    public void c(long j) {
        this.modelId = j;
    }

    public int f() {
        return this.amount;
    }

    public void c(int i) {
        this.amount = i;
    }

    public String g() {
        return this.currency;
    }

    public void a(String str) {
        this.currency = str;
    }

    public int h() {
        return this.status;
    }

    public void d(int i) {
        this.status = i;
    }

    public long i() {
        return this.chatId;
    }

    public void d(long j) {
        this.chatId = j;
    }

    public long j() {
        return this.id;
    }

    public void e(long j) {
        this.itemPrice = j;
    }

    public long k() {
        return this.itemPrice;
    }

    public void f(long j) {
        this.orderPrice = j;
    }

    public long l() {
        return this.orderPrice;
    }

    public long m() {
        return this.snapshotId;
    }

    public void g(long j) {
        this.snapshotId = j;
    }
}
