package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sp_chat_message")
public class DBChatMessage {
    @DatabaseField(columnName = "chatId")
    private long chatId;
    @DatabaseField(columnName = "content", dataType = DataType.BYTE_ARRAY)
    private byte[] content;
    @DatabaseField(columnName = "errorContent")
    private String errorContent;
    @DatabaseField(columnName = "fromUser")
    private int fromUser;
    @DatabaseField(columnName = "id", generatedId = true)
    private long id;
    @DatabaseField(columnName = "itemId")
    private long itemId;
    @DatabaseField(columnName = "chat_message_id", index = true)
    private long messageId;
    @DatabaseField(columnName = "modelid")
    private long modelid;
    @DatabaseField(columnName = "opt")
    private int opt;
    @DatabaseField(columnName = "orderId")
    private long orderId;
    @DatabaseField(columnName = "pChatId")
    private long pChatId;
    @DatabaseField(columnName = "requestId")
    private String requestId;
    @DatabaseField(columnName = "scam_option")
    private int scamOption;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "textContent")
    private String textContent;
    @DatabaseField(columnName = "timestamp")
    private int timestamp;
    @DatabaseField(columnName = "toUser")
    private int toUser;
    @DatabaseField(columnName = "type")
    private int type;

    public static String A() {
        return "alter table sp_chat_message ADD scam_option INTEGER;";
    }

    public static String v() {
        return "alter table sp_chat_message ADD modelid INTEGER;";
    }

    public static String w() {
        return "alter table sp_chat_message ADD pChatId INTEGER;";
    }

    public static String x() {
        return "alter table sp_chat_message ADD textContent VARCHAR;";
    }

    public static String y() {
        return "alter table sp_chat_message ADD opt INTEGER;";
    }

    public static String z() {
        return "alter table sp_chat_message ADD errorContent VARCHAR;";
    }

    public long a() {
        return this.id;
    }

    public long b() {
        return this.messageId;
    }

    public void a(long j) {
        this.messageId = j;
    }

    public byte[] c() {
        return this.content;
    }

    public void a(byte[] bArr) {
        this.content = bArr;
    }

    public int d() {
        return this.fromUser;
    }

    public int e() {
        return this.toUser;
    }

    public int f() {
        return this.timestamp;
    }

    public void a(int i) {
        this.timestamp = i;
    }

    public int g() {
        return this.type;
    }

    public void b(int i) {
        this.type = i;
    }

    public int h() {
        return this.shopId;
    }

    public void c(int i) {
        this.shopId = i;
    }

    public long i() {
        return this.itemId;
    }

    public void b(long j) {
        this.itemId = j;
    }

    public long j() {
        return this.chatId;
    }

    public void c(long j) {
        this.chatId = j;
    }

    public void d(int i) {
        this.fromUser = i;
    }

    public void e(int i) {
        this.toUser = i;
    }

    public int k() {
        return this.status;
    }

    public void f(int i) {
        this.status = i;
    }

    public String l() {
        return this.requestId;
    }

    public void a(String str) {
        this.requestId = str;
    }

    public long m() {
        return this.orderId;
    }

    public void d(long j) {
        this.orderId = j;
    }

    public final long n() {
        return this.modelid;
    }

    public void e(long j) {
        this.modelid = j;
    }

    public final long o() {
        return this.pChatId;
    }

    public void f(long j) {
        this.pChatId = j;
    }

    public final String p() {
        return this.textContent;
    }

    public int q() {
        return this.opt;
    }

    public void g(int i) {
        this.opt = i;
    }

    public void b(String str) {
        this.textContent = str;
    }

    public String r() {
        return this.errorContent;
    }

    public void c(String str) {
        this.errorContent = str;
    }

    public int s() {
        return this.scamOption;
    }

    public void h(int i) {
        this.scamOption = i;
    }

    public boolean t() {
        return (this.scamOption & 1) == 1;
    }

    public boolean u() {
        return ((this.scamOption >> 1) & 1) == 1;
    }
}
