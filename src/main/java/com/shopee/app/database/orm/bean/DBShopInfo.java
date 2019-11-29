package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class DBShopInfo {
    @DatabaseField(columnName = "collectAddress")
    private String collectAddress;
    @DatabaseField(columnName = "contacts", dataType = DataType.BYTE_ARRAY)
    private byte[] contacts;
    @DatabaseField(columnName = "cover")
    private String cover;
    @DatabaseField(columnName = "cTime")
    private int ctime;
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "escrowOption")
    private int escrowOption;
    @DatabaseField(columnName = "escrowPayment", dataType = DataType.BYTE_ARRAY)
    private byte[] escrowPayment;
    @DatabaseField(columnName = "ext_info", dataType = DataType.BYTE_ARRAY)
    private byte[] extInfo;
    @DatabaseField(columnName = "followed")
    private boolean followed;
    @DatabaseField(columnName = "followerCount")
    private int followerCount;
    @DatabaseField(columnName = "images")
    private String images;
    @DatabaseField(columnName = "itemCount")
    private int itemCount;
    @DatabaseField(columnName = "latitude")
    private double latitude;
    @DatabaseField(columnName = "longitude")
    private double longitude;
    @DatabaseField(columnName = "max_image_count")
    private int maxImageCount;
    @DatabaseField(columnName = "mTime")
    private int mtime;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "payment", dataType = DataType.BYTE_ARRAY)
    private byte[] payment;
    @DatabaseField(columnName = "place")
    private String place;
    @DatabaseField(columnName = "pop")
    private int pop;
    @DatabaseField(columnName = "ratingBad")
    private int ratingBad;
    @DatabaseField(columnName = "ratingGood")
    private int ratingGood;
    @DatabaseField(columnName = "ratingNormal")
    private int ratingNormal;
    @DatabaseField(columnName = "score")
    private int score;
    @DatabaseField(columnName = "shipment", dataType = DataType.BYTE_ARRAY)
    private byte[] shipment;
    @DatabaseField(columnName = "shopId", id = true)
    private int shopId;
    @DatabaseField(columnName = "soldTotal")
    private int soldTotal;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "userId")
    private int userId;

    public byte[] a() {
        return this.extInfo;
    }

    public void a(byte[] bArr) {
        this.extInfo = bArr;
    }

    public int b() {
        return this.shopId;
    }

    public void a(int i) {
        this.shopId = i;
    }

    public int c() {
        return this.userId;
    }

    public void b(int i) {
        this.userId = i;
    }

    public String d() {
        return this.name;
    }

    public void a(String str) {
        this.name = str;
    }

    public String e() {
        return this.description;
    }

    public void b(String str) {
        this.description = str;
    }

    public String f() {
        return this.images;
    }

    public void c(String str) {
        this.images = str;
    }

    public int g() {
        return this.ctime;
    }

    public void c(int i) {
        this.ctime = i;
    }

    public void d(int i) {
        this.mtime = i;
    }

    public void e(int i) {
        this.status = i;
    }

    public void d(String str) {
        this.collectAddress = str;
    }

    public void f(int i) {
        this.escrowOption = i;
    }

    public String h() {
        return this.cover;
    }

    public void e(String str) {
        this.cover = str;
    }

    public double i() {
        return this.latitude;
    }

    public void a(double d2) {
        this.latitude = d2;
    }

    public double j() {
        return this.longitude;
    }

    public void b(double d2) {
        this.longitude = d2;
    }

    public String k() {
        return this.place;
    }

    public void f(String str) {
        this.place = str;
    }

    public void g(int i) {
        this.pop = i;
    }

    public int l() {
        return this.ratingGood;
    }

    public void h(int i) {
        this.ratingGood = i;
    }

    public int m() {
        return this.ratingNormal;
    }

    public void i(int i) {
        this.ratingNormal = i;
    }

    public int n() {
        return this.ratingBad;
    }

    public void j(int i) {
        this.ratingBad = i;
    }

    public void k(int i) {
        this.soldTotal = i;
    }

    public int o() {
        return this.itemCount;
    }

    public void l(int i) {
        this.itemCount = i;
    }

    public int p() {
        return this.followerCount;
    }

    public void m(int i) {
        this.followerCount = i;
    }

    public void b(byte[] bArr) {
        this.contacts = bArr;
    }

    public byte[] q() {
        return this.payment;
    }

    public void c(byte[] bArr) {
        this.payment = bArr;
    }

    public void d(byte[] bArr) {
        this.shipment = bArr;
    }

    public void e(byte[] bArr) {
        this.escrowPayment = bArr;
    }

    public int r() {
        return this.score;
    }

    public void n(int i) {
        this.score = i;
    }

    public int s() {
        return this.maxImageCount;
    }

    public void o(int i) {
        this.maxImageCount = i;
    }

    public boolean t() {
        return this.followed;
    }

    public void a(boolean z) {
        this.followed = z;
    }
}
