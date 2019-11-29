package com.shopee.app.database.orm.bean;

import android.text.TextUtils;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.util.af;
import java.util.Arrays;
import java.util.List;

@DatabaseTable(tableName = "sp_ModelAttrIdMap")
public class DBModelAttrIdMap {
    @DatabaseField(columnName = "attrId")
    private String attrIds;
    @DatabaseField(columnName = "modelId", id = true)
    private int modelId;

    public static String b() {
        return "CREATE TABLE `sp_ModelAttrIdMap` (`attrId` VARCHAR , `modelId` INTEGER , PRIMARY KEY (`modelId`) );";
    }

    public void a(int i) {
        this.modelId = i;
    }

    public final List<Integer> a() {
        return af.a(Arrays.asList(TextUtils.split(this.attrIds, ",")), new af.b<Integer, String>() {
            /* renamed from: a */
            public Integer map(String str) {
                return Integer.valueOf(str);
            }
        });
    }

    public String toString() {
        return "DBModelAttrIdMap{modelId=" + this.modelId + ", attrIds='" + this.attrIds + '\'' + '}';
    }

    public void a(List<Integer> list) {
        this.attrIds = TextUtils.join(",", list);
    }
}
