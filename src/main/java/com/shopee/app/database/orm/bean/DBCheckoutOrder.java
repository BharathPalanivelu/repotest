package com.shopee.app.database.orm.bean;

import java.util.List;

public class DBCheckoutOrder {
    private String currency;
    private int daysToPay;
    private long id;
    private List<String> images;
    private int itemCount;
    private long orderId;
    private long price;
    private int shopId;
    private int status;

    public int a() {
        return this.shopId;
    }

    public void a(int i) {
        this.shopId = i;
    }

    public long b() {
        return this.orderId;
    }

    public void a(long j) {
        this.orderId = j;
    }

    public int c() {
        return this.itemCount;
    }

    public void b(int i) {
        this.itemCount = i;
    }

    public List<String> d() {
        return this.images;
    }

    public void a(List<String> list) {
        this.images = list;
    }

    public void c(int i) {
        this.status = i;
    }

    public int e() {
        return this.status;
    }

    public void b(long j) {
        this.price = j;
    }

    public long f() {
        return this.price;
    }

    public void a(String str) {
        this.currency = str;
    }

    public String g() {
        return this.currency;
    }

    public void d(int i) {
        this.daysToPay = i;
    }

    public int h() {
        return this.daysToPay;
    }

    public boolean i() {
        return this.status == 1;
    }
}
