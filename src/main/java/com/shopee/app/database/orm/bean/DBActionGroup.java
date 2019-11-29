package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_action_group")
public class DBActionGroup {
    @DatabaseField(columnName = "content")
    private String content;
    @DatabaseField(columnName = "id", id = true)
    private long id;

    public String a() {
        return this.content;
    }

    public void a(long j) {
        this.id = j;
    }

    public void a(String str) {
        this.content = str;
    }
}
