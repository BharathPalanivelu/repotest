package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_activity_item2")
public class DBActivityItem {
    @DatabaseField(columnName = "accType")
    private int accType;
    @DatabaseField(columnName = "activityId", id = true)
    private int activityId;
    @DatabaseField(columnName = "activityInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] activityInfo;
    @DatabaseField(columnName = "comment")
    private String comment;
    @DatabaseField(columnName = "commentId")
    private long commentId;
    @DatabaseField(columnName = "contactName")
    private String contactName;
    @DatabaseField(columnName = "createTime")
    private int createTime;
    @DatabaseField(columnName = "feedId")
    private long feed;
    @DatabaseField(columnName = "fromUserId")
    private int fromUserId;
    @DatabaseField(columnName = "itemId")
    private long itemId;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "type")
    private int type;
    @DatabaseField(columnName = "updateType")
    private int updateType;

    public long a() {
        return this.feed;
    }

    public void a(long j) {
        this.feed = j;
    }

    public void a(String str) {
        this.contactName = str;
    }

    public String b() {
        return this.contactName;
    }

    public void a(int i) {
        this.accType = i;
    }

    public int c() {
        return this.accType;
    }

    public int d() {
        return this.activityId;
    }

    public void b(int i) {
        this.activityId = i;
    }

    public int e() {
        return this.type;
    }

    public void c(int i) {
        this.type = i;
    }

    public int f() {
        return this.createTime;
    }

    public void d(int i) {
        this.createTime = i;
    }

    public int g() {
        return this.fromUserId;
    }

    public void e(int i) {
        this.fromUserId = i;
    }

    public int h() {
        return this.shopId;
    }

    public void f(int i) {
        this.shopId = i;
    }

    public long i() {
        return this.itemId;
    }

    public void b(long j) {
        this.itemId = j;
    }

    public long j() {
        return this.commentId;
    }

    public void c(long j) {
        this.commentId = j;
    }

    public int k() {
        return this.updateType;
    }

    public void g(int i) {
        this.updateType = i;
    }

    public void b(String str) {
        this.comment = str;
    }

    public String l() {
        return this.comment;
    }

    public void a(byte[] bArr) {
        this.activityInfo = bArr;
    }

    public byte[] m() {
        return this.activityInfo;
    }
}
