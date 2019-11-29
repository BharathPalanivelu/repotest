package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.d.a;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.d.b.b;
import com.shopee.app.network.f;
import com.shopee.app.ui.common.e;
import com.shopee.protocol.shop.CommentTagInfo;
import com.shopee.protocol.shop.CommentTagInfoList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "sp_item_comment2")
public class DBItemComment {
    @DatabaseField(columnName = "cTime")
    private int cTime;
    @DatabaseField(columnName = "cmtId")
    private long cmtId;
    @DatabaseField(columnName = "comment")
    private String comment;
    @DatabaseField(columnName = "editable")
    private int editable;
    @DatabaseField(columnName = "extra_info", dataType = DataType.BYTE_ARRAY)
    private byte[] extraInfo;
    @DatabaseField(columnName = "id", generatedId = true)
    private long id;
    @DatabaseField(columnName = "itemId")
    private long itemId;
    @DatabaseField(columnName = "mTime")
    private int mTime;
    @DatabaseField(columnName = "mentioned", dataType = DataType.BYTE_ARRAY)
    private byte[] mentioned;
    @DatabaseField(columnName = "modelId")
    private long modelId;
    @DatabaseField(columnName = "orderId")
    private long orderId;
    @DatabaseField(columnName = "rating")
    private int rating;
    @DatabaseField(columnName = "rating_star2")
    private int ratingStar;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "userId")
    private int userId;

    public int a() {
        return this.ratingStar;
    }

    public void a(int i) {
        this.ratingStar = i;
    }

    public long b() {
        return this.id;
    }

    public long c() {
        return this.cmtId;
    }

    public void a(long j) {
        this.cmtId = j;
    }

    public int d() {
        return this.userId;
    }

    public void b(int i) {
        this.userId = i;
    }

    public long e() {
        return this.orderId;
    }

    public void b(long j) {
        this.orderId = j;
    }

    public int f() {
        return this.shopId;
    }

    public void c(int i) {
        this.shopId = i;
    }

    public long g() {
        return this.itemId;
    }

    public void c(long j) {
        this.itemId = j;
    }

    public long h() {
        return this.modelId;
    }

    public void d(long j) {
        this.modelId = j;
    }

    public int i() {
        return this.rating;
    }

    public void d(int i) {
        this.rating = i;
    }

    public String j() {
        return this.comment;
    }

    public void a(String str) {
        this.comment = str;
    }

    public int k() {
        return this.cTime;
    }

    public void e(int i) {
        this.cTime = i;
    }

    public int l() {
        return this.status;
    }

    public void f(int i) {
        this.status = i;
    }

    public List<e> m() {
        ArrayList arrayList = new ArrayList();
        try {
            List<CommentTagInfo> list = ((CommentTagInfoList) f.f18486a.parseFrom(this.mentioned, 0, this.mentioned.length, CommentTagInfoList.class)).tags;
            if (list != null && list.size() > 0) {
                for (CommentTagInfo next : list) {
                    if ((next.type == null ? 0 : next.type.intValue()) == 0) {
                        e eVar = new e();
                        b.a(eVar, next);
                        arrayList.add(eVar);
                    }
                }
            }
        } catch (IOException e2) {
            a.a(e2);
        }
        return arrayList;
    }

    public void a(byte[] bArr) {
        this.mentioned = bArr;
    }

    public int n() {
        return this.mTime;
    }

    public void g(int i) {
        this.mTime = i;
    }

    public int o() {
        return this.editable;
    }

    public void h(int i) {
        this.editable = i;
    }

    public byte[] p() {
        return this.extraInfo;
    }

    public void b(byte[] bArr) {
        this.extraInfo = bArr;
    }
}
