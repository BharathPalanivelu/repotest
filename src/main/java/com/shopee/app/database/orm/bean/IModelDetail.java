package com.shopee.app.database.orm.bean;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.shopee.app.network.f;
import com.shopee.protocol.shop.ItemModelExtInfo;
import java.util.List;

public abstract class IModelDetail {
    @DatabaseField(columnName = "currency")
    private String currency;
    @DatabaseField(columnName = "extinfo", dataType = DataType.BYTE_ARRAY)
    private byte[] extinfo;
    @DatabaseField(columnName = "item_id", index = true)
    private long itemId;
    @DatabaseField(columnName = "model_id", id = true)
    private long modelId;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "price")
    private long price;
    @DatabaseField(columnName = "priceBeforeDiscount")
    private long priceBeforeDiscount;
    @DatabaseField(columnName = "promotionid")
    private long promotionid;
    @DatabaseField(columnName = "rebatePrice")
    private long rebatePrice;
    @DatabaseField(columnName = "sold")
    private int sold;
    @DatabaseField(columnName = "status", defaultValue = "1")
    private int status;
    @DatabaseField(columnName = "stock")
    private int stock;

    public long f() {
        return this.modelId;
    }

    public void a(long j) {
        this.modelId = j;
    }

    public long g() {
        return this.itemId;
    }

    public void b(long j) {
        this.itemId = j;
    }

    public String h() {
        return this.name;
    }

    public void a(String str) {
        this.name = str;
    }

    public long i() {
        return this.price;
    }

    public void c(long j) {
        this.price = j;
    }

    public String j() {
        return this.currency;
    }

    public void b(String str) {
        this.currency = str;
    }

    public int k() {
        return this.stock;
    }

    public void a(int i) {
        this.stock = i;
    }

    public int l() {
        return this.status;
    }

    public void b(int i) {
        this.status = i;
    }

    public final long m() {
        return this.priceBeforeDiscount;
    }

    public void d(long j) {
        this.priceBeforeDiscount = j;
    }

    public final long n() {
        return this.promotionid;
    }

    public void e(long j) {
        this.promotionid = j;
    }

    public final long o() {
        return this.rebatePrice;
    }

    public void f(long j) {
        this.rebatePrice = j;
    }

    public final int p() {
        return this.sold;
    }

    public void c(int i) {
        this.sold = i;
    }

    public void a(byte[] bArr) {
        this.extinfo = bArr;
    }

    public final List<Integer> q() {
        if (this.extinfo == null) {
            return null;
        }
        try {
            return ((ItemModelExtInfo) f.f18486a.parseFrom(this.extinfo, ItemModelExtInfo.class)).tier_index;
        } catch (Exception unused) {
            return null;
        }
    }
}
