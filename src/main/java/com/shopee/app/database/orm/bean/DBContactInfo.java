package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_contact_list")
public class DBContactInfo {

    /* renamed from: a  reason: collision with root package name */
    int f6955a;
    @DatabaseField(columnName = "autoid", generatedId = true)
    private int autoId;
    @DatabaseField(columnName = "CONTACT_NAME")
    private String contactName;
    @DatabaseField(columnName = "CONTACT_TYPE")
    private int contactType;
    @DatabaseField(columnName = "FOLLOWED")
    private boolean follow;
    @DatabaseField(columnName = "PORTRAIT")
    private String portrait;
    @DatabaseField(columnName = "SHOP_ID")
    private int shopId;
    @DatabaseField(columnName = "USER_ID")
    private int userId;
    @DatabaseField(columnName = "USERNAME")
    private String username;

    public String a() {
        return this.username;
    }

    public void a(String str) {
        this.username = str;
    }

    public String b() {
        return this.portrait;
    }

    public void b(String str) {
        this.portrait = str;
    }

    public String c() {
        return this.contactName;
    }

    public void c(String str) {
        this.contactName = str;
    }

    public void a(int i) {
        this.userId = i;
    }

    public int d() {
        return this.shopId;
    }

    public void b(int i) {
        this.shopId = i;
    }

    public int e() {
        return this.contactType;
    }

    public void c(int i) {
        this.contactType = i;
    }

    public boolean f() {
        return this.follow;
    }

    public void a(boolean z) {
        this.follow = z;
    }

    public int g() {
        return this.f6955a;
    }

    public void d(int i) {
        this.f6955a = i;
    }
}
