package com.shopee.app.database.orm.bean.chatP2P;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.d.b.b;
import com.shopee.protocol.action.Chat;

@DatabaseTable(tableName = "sp_Chat")
public class DBChat {
    @DatabaseField(columnName = "archive")
    private int archive;
    @DatabaseField(columnName = "buyCount")
    private int buyCount;
    @DatabaseField(columnName = "chatId")
    private long chatId;
    @DatabaseField(columnName = "itemId")
    private long itemId;
    @DatabaseField(columnName = "lastMsgId")
    private long lastMsgId;
    @DatabaseField(columnName = "lastMsgRequestId")
    private String lastMsgReqId;
    @DatabaseField(columnName = "lastMsgRequestTime")
    private int lastMsgReqTime;
    @DatabaseField(columnName = "lastMsgTime")
    private int lastMsgTime;
    @DatabaseField(columnName = "modelId")
    private long modelId;
    @DatabaseField(columnName = "offerPrice")
    private long offerPrice;
    @DatabaseField(columnName = "offerStatus")
    private int offerStatus;
    @DatabaseField(columnName = "orderId")
    private long orderId;
    @DatabaseField(columnName = "pChatId", id = true)
    private long pChatId;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "userId")
    private int userId;

    public static String p() {
        return "alter table sp_Chat ADD lastMsgRequestId VARCHAR;";
    }

    public static String q() {
        return "alter table sp_Chat ADD lastMsgRequestTime INTEGER;";
    }

    public static String r() {
        return "CREATE TABLE `sp_Chat` (`pChatId` BIGINT , `orderId` BIGINT , `chatId` BIGINT , `itemId` BIGINT , `lastMsgId` BIGINT , `offerPrice` BIGINT , `modelId` BIGINT , `lastMsgTime` INTEGER , `offerStatus` INTEGER , `buyCount` INTEGER , `archive` INTEGER , `shopId` INTEGER , `userId` INTEGER );";
    }

    public final long a() {
        return this.chatId;
    }

    public void a(long j) {
        this.chatId = j;
    }

    public final int b() {
        return this.userId;
    }

    public void a(int i) {
        this.userId = i;
    }

    public final int c() {
        return this.shopId;
    }

    public void b(int i) {
        this.shopId = i;
    }

    public final long d() {
        return this.itemId;
    }

    public void b(long j) {
        this.itemId = j;
    }

    public final int e() {
        return this.buyCount;
    }

    public void c(int i) {
        this.buyCount = i;
    }

    public final long f() {
        return this.offerPrice;
    }

    public void c(long j) {
        this.offerPrice = j;
    }

    public final int g() {
        return this.offerStatus;
    }

    public void d(int i) {
        this.offerStatus = i;
    }

    public final long h() {
        return this.lastMsgId;
    }

    public void d(long j) {
        this.lastMsgId = j;
    }

    public final int i() {
        return this.lastMsgTime;
    }

    public void e(int i) {
        this.lastMsgTime = i;
    }

    public final long j() {
        return this.orderId;
    }

    public void e(long j) {
        this.orderId = j;
    }

    public final int k() {
        return this.archive;
    }

    public void f(int i) {
        this.archive = i;
    }

    public final long l() {
        return this.modelId;
    }

    public void f(long j) {
        this.modelId = j;
    }

    public final long m() {
        return this.pChatId;
    }

    public void g(long j) {
        this.pChatId = j;
    }

    public String n() {
        return this.lastMsgReqId;
    }

    public void a(String str) {
        this.lastMsgReqId = str;
    }

    public void g(int i) {
        this.lastMsgReqTime = i;
    }

    public int o() {
        return this.lastMsgReqTime;
    }

    public static void a(Chat chat, DBChat dBChat) {
        dBChat.a(b.a(chat.chatid));
        dBChat.a(b.a(chat.userid));
        dBChat.b(b.a(chat.shopid));
        dBChat.b(b.a(chat.itemid));
        dBChat.c(b.a(chat.buy_count));
        dBChat.c(b.a(chat.offer_price));
        dBChat.d(b.a(chat.offer_status));
        dBChat.d(b.a(chat.last_msgid));
        dBChat.e(b.a(chat.last_msg_time));
        dBChat.e(b.a(chat.orderid));
        dBChat.f(b.a(chat.archive));
        dBChat.f(b.a(chat.modelid));
        dBChat.g(b.a(chat.pchatid));
    }
}
