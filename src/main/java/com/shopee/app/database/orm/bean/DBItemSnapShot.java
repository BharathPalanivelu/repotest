package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.tools.b;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.id.R;

@DatabaseTable(tableName = "sp_item_snapshot")
public class DBItemSnapShot {
    @DatabaseField(columnName = "brand")
    private String brand;
    @DatabaseField(columnName = "cTime")
    private int cTime;
    @DatabaseField(columnName = "catId")
    private int catId;
    @DatabaseField(columnName = "cmtCount")
    private int cmtCount;
    @DatabaseField(columnName = "collectAddress")
    private String collectAddress;
    @DatabaseField(columnName = "condition")
    private int condition;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "extended_info", dataType = DataType.BYTE_ARRAY)
    private byte[] extended_info;
    @DatabaseField(columnName = "item_id")
    private long id;
    @DatabaseField(columnName = "images")
    private String images;
    @DatabaseField(columnName = "likedCount")
    private int likedCount;
    @DatabaseField(columnName = "mTime")
    private int mTime;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "offerCount")
    private int offerCount;
    @DatabaseField(columnName = "pop")
    private int pop;
    @DatabaseField(columnName = "price")
    private long price;
    @DatabaseField(columnName = "priceMax")
    private long priceMax;
    @DatabaseField(columnName = "priceMin")
    private long priceMin;
    @DatabaseField(columnName = "ratingBad")
    private int ratingBad;
    @DatabaseField(columnName = "ratingGood")
    private int ratingGood;
    @DatabaseField(columnName = "ratingNormal")
    private int ratingNormal;
    @DatabaseField(columnName = "recommend")
    private int recommend;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "snapshotId", id = true)
    private long snapshotId;
    @DatabaseField(columnName = "sold")
    private int sold;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "stock")
    private int stock;

    public static DBItemSnapShot a(Integer num, Long l) {
        DBItemSnapShot dBItemSnapShot = new DBItemSnapShot();
        dBItemSnapShot.a(num.intValue());
        dBItemSnapShot.a(l);
        dBItemSnapShot.a(b.e(R.string.sp_deleted_item));
        dBItemSnapShot.b("");
        dBItemSnapShot.c("");
        return dBItemSnapShot;
    }

    public void a(Long l) {
        this.id = l.longValue();
    }

    public Long a() {
        return Long.valueOf(this.id);
    }

    public int b() {
        return this.shopId;
    }

    public void a(int i) {
        this.shopId = i;
    }

    public String c() {
        return this.name;
    }

    public void a(String str) {
        this.name = str;
    }

    public void b(String str) {
        this.description = str;
    }

    public String d() {
        return this.images;
    }

    public void c(String str) {
        this.images = str;
    }

    public long e() {
        return this.price;
    }

    public void a(long j) {
        this.price = j;
    }

    public void d(String str) {
        this.currency = str;
    }

    public int f() {
        return this.stock;
    }

    public void b(int i) {
        this.stock = i;
    }

    public int g() {
        return this.status;
    }

    public void c(int i) {
        this.status = i;
    }

    public void d(int i) {
        this.cTime = i;
    }

    public void e(int i) {
        this.mTime = i;
    }

    public int h() {
        return this.sold;
    }

    public void f(int i) {
        this.sold = i;
    }

    public void b(long j) {
        this.priceMin = j;
    }

    public void c(long j) {
        this.priceMax = j;
    }

    public void g(int i) {
        this.recommend = i;
    }

    public void e(String str) {
        this.collectAddress = str;
    }

    public void h(int i) {
        this.catId = i;
    }

    public void i(int i) {
        this.pop = i;
    }

    public int i() {
        return this.likedCount;
    }

    public void j(int i) {
        this.likedCount = i;
    }

    public void k(int i) {
        this.offerCount = i;
    }

    public void f(String str) {
        this.brand = str;
    }

    public void l(int i) {
        this.condition = i;
    }

    public void m(int i) {
        this.ratingGood = i;
    }

    public void n(int i) {
        this.ratingNormal = i;
    }

    public void o(int i) {
        this.ratingBad = i;
    }

    public void p(int i) {
        this.cmtCount = i;
    }

    public void g(String str) {
        this.country = str;
    }

    public long j() {
        return this.snapshotId;
    }

    public void d(long j) {
        this.snapshotId = j;
    }

    public void a(byte[] bArr) {
        this.extended_info = bArr;
    }

    public byte[] k() {
        return this.extended_info;
    }
}
