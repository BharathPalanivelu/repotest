package com.shopee.app.database.orm.bean;

import android.text.TextUtils;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.util.af;
import java.util.Arrays;
import java.util.List;

@DatabaseTable(tableName = "sp_action_content")
public class DBActionContent {
    @DatabaseField(columnName = "actionAppPath")
    private String actionAppPath;
    @DatabaseField(columnName = "actionCate")
    private int actionCate;
    @DatabaseField(columnName = "actionReactivePath")
    private String actionReactivePath;
    @DatabaseField(columnName = "actionRequiredUrl")
    private String actionRequiredUrl;
    @DatabaseField(columnName = "actionType")
    private int actionType;
    @DatabaseField(columnName = "apprl")
    private String appRL;
    @DatabaseField(columnName = "content", dataType = DataType.BYTE_ARRAY)
    private byte[] content;
    @DatabaseField(columnName = "createTime")
    private int createTime;
    @DatabaseField(columnName = "id", id = true)
    private long id;
    @DatabaseField(columnName = "idInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] idInfo;
    @DatabaseField(columnName = "image")
    private String images;
    @DatabaseField(columnName = "itemCount")
    private int itemCount;
    @DatabaseField(columnName = "avatarImage")
    private String mAvatarImage;
    @DatabaseField(columnName = "groupId")
    private long mGroupId;
    @DatabaseField(columnName = "groupedCount")
    private int mGroupedCount;
    @DatabaseField(columnName = "redirectType")
    private int redirectType;
    @DatabaseField(columnName = "title")
    private String title;

    public static String n() {
        return "alter table sp_action_content ADD actionReactivePath VARCHAR;";
    }

    public static String r() {
        return "alter table sp_action_content ADD apprl VARCHAR;";
    }

    public void a(long j) {
        this.mGroupId = j;
    }

    public long a() {
        return this.mGroupId;
    }

    public long b() {
        return this.id;
    }

    public void b(long j) {
        this.id = j;
    }

    public byte[] c() {
        return this.content;
    }

    public void a(byte[] bArr) {
        this.content = bArr;
    }

    public int d() {
        return this.redirectType;
    }

    public void a(int i) {
        this.redirectType = i;
    }

    public List<String> e() {
        return af.a(Arrays.asList(this.images.split(";")), new af.a<String>() {
            /* renamed from: a */
            public boolean shouldInclude(String str) {
                return !TextUtils.isEmpty(str);
            }
        });
    }

    public void a(List<String> list) {
        if (list.size() <= 0) {
            this.images = "";
            return;
        }
        int i = 0;
        for (String next : list) {
            if (i != 0) {
                this.images += ";" + next;
            } else {
                this.images = next;
            }
            i++;
        }
    }

    public int f() {
        return this.createTime;
    }

    public void b(int i) {
        this.createTime = i;
    }

    public String g() {
        return this.title;
    }

    public void a(String str) {
        this.title = str;
    }

    public void c(int i) {
        this.itemCount = i;
    }

    public void d(int i) {
        this.actionType = i;
    }

    public int h() {
        return this.actionType;
    }

    public byte[] i() {
        return this.idInfo;
    }

    public void b(byte[] bArr) {
        this.idInfo = bArr;
    }

    public void b(String str) {
        this.actionRequiredUrl = str;
    }

    public String j() {
        return this.actionRequiredUrl;
    }

    public void e(int i) {
        this.actionCate = i;
    }

    public int k() {
        return this.actionCate;
    }

    public void c(String str) {
        this.actionAppPath = str;
    }

    public String l() {
        return this.actionAppPath;
    }

    public void d(String str) {
        this.actionReactivePath = str;
    }

    public String m() {
        return this.actionReactivePath;
    }

    public int o() {
        return this.mGroupedCount;
    }

    public void f(int i) {
        this.mGroupedCount = i;
    }

    public String p() {
        return this.mAvatarImage;
    }

    public void e(String str) {
        this.mAvatarImage = str;
    }

    public void f(String str) {
        this.appRL = str;
    }

    public String q() {
        return this.appRL;
    }
}
