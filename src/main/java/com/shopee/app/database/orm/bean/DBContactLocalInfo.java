package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_local_contact_list")
public class DBContactLocalInfo {
    @DatabaseField(columnName = "CONTACT_KEY", id = true)
    private String contactKey;
    @DatabaseField(columnName = "CONTACT_NAME")
    private String contactName;

    public String a() {
        return this.contactName;
    }

    public void a(String str) {
        this.contactName = str;
    }

    public String b() {
        return this.contactKey;
    }

    public void b(String str) {
        this.contactKey = str;
    }
}
