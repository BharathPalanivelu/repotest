package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.tools.a.a;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_BIReport")
public class DBBIReport {
    @DatabaseField(columnName = "action")
    private String action;
    @DatabaseField(columnName = "data")
    private String data;
    @DatabaseField(columnName = "endpoint")
    private String endpoint;
    @DatabaseField(columnName = "hash")
    private String hash;
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;
    @DatabaseField(columnName = "signature")
    private String signature;
    @DatabaseField(columnName = "source")
    private String source;
    @DatabaseField(columnName = "timestamp")
    private int timestamp = a.a();
    @DatabaseField(columnName = "url")
    private String url;

    public static String c() {
        return "CREATE TABLE `sp_BIReport` (`id` INTEGER AUTO_INCREMENT , `url` VARCHAR , `action` VARCHAR , `signature` VARCHAR , `hash` VARCHAR , `data` VARCHAR , `source` VARCHAR , `endpoint` VARCHAR,  PRIMARY KEY (`id`) );";
    }

    public static String d() {
        return "alter table  sp_BIReport ADD timestamp INTEGER;";
    }

    public static String e() {
        return "create index sp_action_data on sp_BIReport (action,data);";
    }

    public final String a() {
        return this.action;
    }

    public final String b() {
        return this.data;
    }

    public int f() {
        return this.id;
    }
}
