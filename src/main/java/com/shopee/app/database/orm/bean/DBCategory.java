package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_category")
public class DBCategory {
    @DatabaseField(columnName = "catid", id = true)
    private int catId;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "display_name")
    private String displayName;
    @DatabaseField(columnName = "image")
    private String image;
    @DatabaseField(columnName = "is_default_subcategory")
    private int isDefaultSubCategory;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "parent_id")
    private int parentCategory;
    @DatabaseField(columnName = "sort_weight")
    private int sortWeight;
    @DatabaseField(columnName = "status")
    private int status;

    public int a() {
        return this.catId;
    }

    public void a(int i) {
        this.catId = i;
    }

    public void a(String str) {
        this.name = str;
    }

    public void b(String str) {
        this.image = str;
    }

    public void c(String str) {
        this.country = str;
    }

    public int b() {
        return this.status;
    }

    public void b(int i) {
        this.status = i;
    }

    public void c(int i) {
        this.sortWeight = i;
    }

    public void d(String str) {
        this.displayName = str;
    }

    public String c() {
        return this.displayName;
    }

    public int d() {
        return this.parentCategory;
    }

    public void d(int i) {
        this.parentCategory = i;
    }

    public boolean e() {
        return this.isDefaultSubCategory == 1;
    }

    public void e(int i) {
        this.isDefaultSubCategory = i;
    }

    public String toString() {
        return "DBCategory{catId=" + this.catId + ", name='" + this.name + '\'' + ", image='" + this.image + '\'' + ", country='" + this.country + '\'' + ", status=" + this.status + ", sortWeight=" + this.sortWeight + ", displayName='" + this.displayName + '\'' + ", parentCategory=" + this.parentCategory + ", isDefaultSubCategory=" + this.isDefaultSubCategory + '}';
    }
}
