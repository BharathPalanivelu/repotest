package com.shopee.app.database.orm.bean;

import android.util.Base64;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Arrays;

@DatabaseTable(tableName = "sp_AttributeCache")
public class DBAttributeCache {
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;
    @DatabaseField(columnName = "request_key", uniqueIndex = true)
    private String requestKey;
    @DatabaseField(columnName = "response_value", dataType = DataType.BYTE_ARRAY)
    private byte[] responseValue = null;
    @DatabaseField(columnName = "signature", index = true)
    private String signature;

    public static String c() {
        return "CREATE TABLE `sp_AttributeCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT , `request_key` VARCHAR , `response_value` BLOB , `signature` VARCHAR );";
    }

    public static String d() {
        return "CREATE INDEX `sp_AttributeCache_signature_idx` ON `sp_AttributeCache` ( `signature` );";
    }

    public static String e() {
        return "CREATE UNIQUE INDEX `sp_AttributeCache_request_key_idx` ON `sp_AttributeCache` ( `request_key` );";
    }

    public void a(String str) {
        this.requestKey = str;
    }

    public byte[] a() {
        return b(this.signature);
    }

    public void a(byte[] bArr) {
        this.signature = b(bArr);
    }

    public byte[] b() {
        return this.responseValue;
    }

    public static byte[] b(String str) {
        return Base64.decode(str, 2);
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public String toString() {
        return "DBAttributeCache{id=" + this.id + ", requestKey='" + this.requestKey + '\'' + ", signature='" + this.signature + '\'' + ", responseValue=" + Arrays.toString(this.responseValue) + '}';
    }

    public void c(byte[] bArr) {
        this.responseValue = bArr;
    }
}
