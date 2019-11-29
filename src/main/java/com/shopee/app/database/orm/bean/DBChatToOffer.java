package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_chat_to_offer")
public class DBChatToOffer {
    @DatabaseField(columnName = "buyCount")
    private int buyCount;
    @DatabaseField(columnName = "chatId", id = true)
    private long chatId;
    @DatabaseField(columnName = "flag")
    private int flag;
    @DatabaseField(columnName = "itemId")
    private long itemId;
    @DatabaseField(columnName = "lastMsgId")
    private long lastMsgId;
    @DatabaseField(columnName = "lastMsgTime")
    private int lastMsgTime;
    @DatabaseField(columnName = "modelid")
    private long modelid;
    @DatabaseField(columnName = "offerPrice")
    private long offerPrice;
    @DatabaseField(columnName = "offerStatus")
    private int offerStatus;
    @DatabaseField(columnName = "orderId")
    private long orderId;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "userId")
    private int userId;

    public static String i() {
        return "alter table sp_chat_to_offer ADD modelid INTEGER;";
    }

    public void a(long j) {
        this.chatId = j;
    }

    public long a() {
        return this.chatId;
    }

    public int b() {
        return this.userId;
    }

    public void a(int i) {
        this.userId = i;
    }

    public int c() {
        return this.shopId;
    }

    public void b(int i) {
        this.shopId = i;
    }

    public long d() {
        return this.itemId;
    }

    public void b(long j) {
        this.itemId = j;
    }

    public int e() {
        return this.buyCount;
    }

    public void c(int i) {
        this.buyCount = i;
    }

    public long f() {
        return this.offerPrice;
    }

    public void c(long j) {
        this.offerPrice = j;
    }

    public int g() {
        return this.offerStatus;
    }

    public void d(int i) {
        this.offerStatus = i;
    }

    public void d(long j) {
        this.lastMsgId = j;
    }

    public void e(int i) {
        this.lastMsgTime = i;
    }

    public void e(long j) {
        this.orderId = j;
    }

    public void f(int i) {
        this.flag = i;
    }

    public final long h() {
        return this.modelid;
    }

    public void f(long j) {
        this.modelid = j;
    }
}
