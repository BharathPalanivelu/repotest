package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.id.R;

@DatabaseTable(tableName = "sp_user_brief")
public class DBUserBrief {
    @DatabaseField(columnName = "cacheTime")
    private int cacheTime = a.a();
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "followed")
    private boolean followed;
    @DatabaseField(columnName = "nickname")
    private String nickname;
    @DatabaseField(columnName = "phone")
    private String phone;
    @DatabaseField(columnName = "portrait")
    private String portrait;
    @DatabaseField(columnName = "products")
    private int products;
    @DatabaseField(columnName = "score")
    private int score;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "shopeeVerified")
    private int shopeeVerified;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "userId", id = true)
    private int userId;
    @DatabaseField(columnName = "userName")
    private String userName;

    public static String m() {
        return "alter table sp_user_brief ADD cacheTime INTEGER;";
    }

    public static String n() {
        return "alter table sp_user_brief ADD status INTEGER;";
    }

    public static String o() {
        return "alter table sp_user_brief ADD shopeeVerified INTEGER;";
    }

    public static DBUserBrief a(int i) {
        DBUserBrief dBUserBrief = new DBUserBrief();
        dBUserBrief.a(b.e(R.string.sp_label_deleted_user));
        dBUserBrief.c(i);
        dBUserBrief.c(b.e(R.string.sp_label_deleted_user));
        dBUserBrief.d(0);
        return dBUserBrief;
    }

    public static DBUserBrief b(int i) {
        DBUserBrief dBUserBrief = new DBUserBrief();
        dBUserBrief.a(b.e(R.string.sp_user_name_placeholder));
        dBUserBrief.c(i);
        dBUserBrief.c(b.e(R.string.sp_user_name_placeholder));
        dBUserBrief.d(0);
        return dBUserBrief;
    }

    public int a() {
        return this.userId;
    }

    public void c(int i) {
        this.userId = i;
    }

    public int b() {
        return this.shopId;
    }

    public void d(int i) {
        this.shopId = i;
    }

    public String c() {
        return this.userName;
    }

    public void a(String str) {
        this.userName = str;
    }

    public String d() {
        return this.portrait;
    }

    public void b(String str) {
        this.portrait = str;
    }

    public int e() {
        return this.score;
    }

    public void e(int i) {
        this.score = i;
    }

    public int f() {
        return this.products;
    }

    public void f(int i) {
        this.products = i;
    }

    public String g() {
        return this.nickname;
    }

    public void c(String str) {
        this.nickname = str;
    }

    public boolean h() {
        return this.followed;
    }

    public void a(boolean z) {
        this.followed = z;
    }

    public String i() {
        return this.phone;
    }

    public void g(int i) {
        this.status = i;
    }

    public int j() {
        return this.status;
    }

    public void h(int i) {
        this.shopeeVerified = i;
    }

    public int k() {
        return this.shopeeVerified;
    }

    public int l() {
        return this.cacheTime;
    }
}
