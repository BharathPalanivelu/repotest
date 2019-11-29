package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.tools.b;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.id.R;

@DatabaseTable(tableName = "sp_item_detail")
public class DBItemDetail {
    @DatabaseField(columnName = "brand")
    private String brand;
    @DatabaseField(columnName = "cTime")
    private int cTime;
    @DatabaseField(columnName = "catId")
    private int catId;
    @DatabaseField(columnName = "cmtCount")
    private int cmtCount;
    @DatabaseField(columnName = "condition")
    private int condition;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "collectAddress")
    private String extData;
    @DatabaseField(columnName = "extended_info", dataType = DataType.BYTE_ARRAY)
    private byte[] extendedInfo;
    @DatabaseField(columnName = "item_id", id = true)
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
    @DatabaseField(columnName = "sold")
    private int sold;
    @DatabaseField(columnName = "status", defaultValue = "1")
    private int status;
    @DatabaseField(columnName = "stock")
    private int stock;
    @DatabaseField(columnName = "viewCount")
    private long viewCount = -1;

    public static String u() {
        return "alter table sp_item_detail ADD viewCount INTEGER;";
    }

    public static DBItemDetail a(int i, long j, int i2) {
        DBItemDetail dBItemDetail = new DBItemDetail();
        dBItemDetail.a(i);
        dBItemDetail.a(j);
        dBItemDetail.a(b.e(i2));
        dBItemDetail.b("");
        dBItemDetail.c("");
        dBItemDetail.c((int) ItemDetail.FAKE_STATUS);
        return dBItemDetail;
    }

    public static DBItemDetail a(int i, long j) {
        return a(i, j, R.string.sp_deleted_item);
    }

    public void a(long j) {
        this.id = j;
    }

    public long a() {
        return this.id;
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

    public String g() {
        return this.images;
    }

    public void c(String str) {
        this.images = str;
    }

    public long h() {
        return this.price;
    }

    public void b(long j) {
        this.price = j;
    }

    public void d(String str) {
        this.currency = str;
    }

    public int i() {
        return this.stock;
    }

    public void b(int i) {
        this.stock = i;
    }

    public int j() {
        return this.status;
    }

    public void c(int i) {
        this.status = i;
    }

    public void d(int i) {
        this.cTime = i;
    }

    public int k() {
        return this.mTime;
    }

    public void e(int i) {
        this.mTime = i;
    }

    public int l() {
        return this.sold;
    }

    public void f(int i) {
        this.sold = i;
    }

    public void c(long j) {
        this.priceMin = j;
    }

    public void d(long j) {
        this.priceMax = j;
    }

    public void g(int i) {
        this.recommend = i;
    }

    public String m() {
        return this.extData;
    }

    public void e(String str) {
        this.extData = str;
    }

    public int n() {
        return this.catId;
    }

    public void h(int i) {
        this.catId = i;
    }

    public void i(int i) {
        this.pop = i;
    }

    public int o() {
        return this.likedCount;
    }

    public void j(int i) {
        this.likedCount = i;
    }

    public void k(int i) {
        this.offerCount = i;
    }

    public String p() {
        return this.brand;
    }

    public void f(String str) {
        this.brand = str;
    }

    public int q() {
        return this.condition;
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

    public int r() {
        return this.cmtCount;
    }

    public void p(int i) {
        this.cmtCount = i;
    }

    public void g(String str) {
        this.country = str;
    }

    public byte[] s() {
        return this.extendedInfo;
    }

    public long t() {
        return this.viewCount;
    }

    public void e(long j) {
        this.viewCount = j;
    }

    public void a(byte[] bArr) {
        this.extendedInfo = bArr;
    }
}
