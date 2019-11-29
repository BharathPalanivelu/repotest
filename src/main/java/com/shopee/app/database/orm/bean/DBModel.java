package com.shopee.app.database.orm.bean;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_model")
public class DBModel extends IModelDetail {
    public static String a() {
        return "alter table sp_model ADD priceBeforeDiscount INTEGER;";
    }

    public static String b() {
        return "alter table sp_model ADD promotionid INTEGER;";
    }

    public static String c() {
        return "alter table sp_model ADD rebatePrice INTEGER;";
    }

    public static String d() {
        return "alter table sp_model ADD sold INTEGER;";
    }

    public static String e() {
        return "alter table sp_model ADD extinfo BLOB;";
    }
}
