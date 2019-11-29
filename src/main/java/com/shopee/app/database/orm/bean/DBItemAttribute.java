package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_ItemAttribute")
public class DBItemAttribute {
    @DatabaseField(columnName = "attrId", id = true)
    private int attrId;
    @DatabaseField(columnName = "attrType")
    private int attrType;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "ctime")
    private int ctime;
    @DatabaseField(columnName = "displayName")
    private String displayName;
    @DatabaseField(columnName = "extinfo", dataType = DataType.BYTE_ARRAY)
    private byte[] extinfo;
    @DatabaseField(columnName = "inputType")
    private int inputType;
    @DatabaseField(columnName = "mandatory")
    private int mandatory;
    @DatabaseField(columnName = "mtime")
    private int mtime;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "validateType")
    private int validateType;

    public static String m() {
        return "CREATE TABLE `sp_ItemAttribute` (`attrId` INTEGER , `attrType` INTEGER , `country` VARCHAR , `ctime` INTEGER , `displayName` VARCHAR , `extinfo` BLOB , `inputType` INTEGER , `mandatory` INTEGER , `mtime` INTEGER , `name` VARCHAR , `status` INTEGER , `validateType` INTEGER , PRIMARY KEY (`attrId`) );";
    }

    public final int a() {
        return this.attrId;
    }

    public void a(int i) {
        this.attrId = i;
    }

    public final String b() {
        return this.name;
    }

    public void a(String str) {
        this.name = str;
    }

    public final int c() {
        return this.inputType;
    }

    public void b(int i) {
        this.inputType = i;
    }

    public final int d() {
        return this.attrType;
    }

    public void c(int i) {
        this.attrType = i;
    }

    public final int e() {
        return this.status;
    }

    public void d(int i) {
        this.status = i;
    }

    public final int f() {
        return this.validateType;
    }

    public void e(int i) {
        this.validateType = i;
    }

    public final byte[] g() {
        return this.extinfo;
    }

    public void a(byte[] bArr) {
        this.extinfo = bArr;
    }

    public final int h() {
        return this.mandatory;
    }

    public void f(int i) {
        this.mandatory = i;
    }

    public final String i() {
        return this.country;
    }

    public void b(String str) {
        this.country = str;
    }

    public final int j() {
        return this.ctime;
    }

    public void g(int i) {
        this.ctime = i;
    }

    public final int k() {
        return this.mtime;
    }

    public void h(int i) {
        this.mtime = i;
    }

    public final String l() {
        return this.displayName;
    }

    public void c(String str) {
        this.displayName = str;
    }
}
