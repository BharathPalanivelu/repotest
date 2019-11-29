package com.shopee.app.database.orm.bean.chatP2P;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.d.b.b;
import com.shopee.protocol.shop.Offer;

@DatabaseTable(tableName = "sp_Offer")
public class DBOffer {
    @DatabaseField(columnName = "buyCount")
    private int buyCount;
    @DatabaseField(columnName = "buyerUserId")
    private int buyerUserId;
    @DatabaseField(columnName = "chatId")
    private long chatId;
    @DatabaseField(columnName = "ctime")
    private int ctime;
    @DatabaseField(columnName = "itemId")
    private long itemId;
    @DatabaseField(columnName = "modelId")
    private long modelId;
    @DatabaseField(columnName = "mtime")
    private int mtime;
    @DatabaseField(columnName = "offerId", id = true)
    private long offerId;
    @DatabaseField(columnName = "offerPrice")
    private long offerPrice;
    @DatabaseField(columnName = "offerStatus")
    private int offerStatus;
    @DatabaseField(columnName = "pchatId")
    private long pchatId;
    @DatabaseField(columnName = "sellerUserId")
    private int sellerUserId;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "snapshotId")
    private long snapshotId;

    public static String o() {
        return "CREATE TABLE `sp_Offer` (`pchatId` BIGINT , `offerPrice` BIGINT , `chatId` BIGINT , `offerId` BIGINT , `itemId` BIGINT , `snapshotId` BIGINT , `modelId` BIGINT , `mtime` INTEGER , `ctime` INTEGER , `buyerUserId` INTEGER , `offerStatus` INTEGER , `buyCount` INTEGER , `sellerUserId` INTEGER , `shopId` INTEGER , PRIMARY KEY (`offerId`) );";
    }

    public final long a() {
        return this.offerId;
    }

    public void a(long j) {
        this.offerId = j;
    }

    public final long b() {
        return this.pchatId;
    }

    public void b(long j) {
        this.pchatId = j;
    }

    public final long c() {
        return this.chatId;
    }

    public void c(long j) {
        this.chatId = j;
    }

    public final int d() {
        return this.buyerUserId;
    }

    public void a(int i) {
        this.buyerUserId = i;
    }

    public final int e() {
        return this.sellerUserId;
    }

    public void b(int i) {
        this.sellerUserId = i;
    }

    public final int f() {
        return this.shopId;
    }

    public void c(int i) {
        this.shopId = i;
    }

    public final long g() {
        return this.itemId;
    }

    public void d(long j) {
        this.itemId = j;
    }

    public final long h() {
        return this.modelId;
    }

    public void e(long j) {
        this.modelId = j;
    }

    public final int i() {
        return this.buyCount;
    }

    public void d(int i) {
        this.buyCount = i;
    }

    public final long j() {
        return this.offerPrice;
    }

    public void f(long j) {
        this.offerPrice = j;
    }

    public final int k() {
        return this.offerStatus;
    }

    public void e(int i) {
        this.offerStatus = i;
    }

    public final int l() {
        return this.ctime;
    }

    public void f(int i) {
        this.ctime = i;
    }

    public final int m() {
        return this.mtime;
    }

    public void g(int i) {
        this.mtime = i;
    }

    public long n() {
        return this.snapshotId;
    }

    public void g(long j) {
        this.snapshotId = j;
    }

    public static void a(Offer offer, DBOffer dBOffer) {
        dBOffer.a(b.a(offer.offerid));
        dBOffer.b(b.a(offer.pchatid));
        dBOffer.c(b.a(offer.chatid));
        dBOffer.a(b.a(offer.buyer_userid));
        dBOffer.b(b.a(offer.seller_userid));
        dBOffer.c(b.a(offer.shopid));
        dBOffer.d(b.a(offer.itemid));
        dBOffer.e(b.a(offer.modelid));
        dBOffer.d(b.a(offer.buy_count));
        dBOffer.f(b.a(offer.offer_price));
        dBOffer.e(b.a(offer.offer_status));
        dBOffer.f(b.a(offer.ctime));
        dBOffer.g(b.a(offer.mtime));
        dBOffer.g(b.a(offer.snapshotid));
    }
}
