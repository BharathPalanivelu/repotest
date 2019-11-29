package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.d;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.ui.product.attributes.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private d f17302a = b.f().I();

    public DBAttributeCache a(int i, List<u> list) {
        String b2 = b(i, list);
        DBAttributeCache a2 = this.f17302a.a(b2);
        if (a2 != null) {
            return a2;
        }
        DBAttributeCache dBAttributeCache = new DBAttributeCache();
        dBAttributeCache.a(b2);
        dBAttributeCache.a(DBAttributeCache.b(DBAttributeCache.b(b2.getBytes())));
        dBAttributeCache.c((byte[]) null);
        return dBAttributeCache;
    }

    public void a(DBAttributeCache dBAttributeCache) {
        this.f17302a.a(dBAttributeCache);
    }

    public static String b(int i, List<u> list) {
        ArrayList<u> arrayList = new ArrayList<>(list);
        Collections.sort(arrayList, new Comparator<u>() {
            /* renamed from: a */
            public int compare(u uVar, u uVar2) {
                return uVar.a() - uVar2.a();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("_");
        for (u uVar : arrayList) {
            sb.append(uVar.a());
            sb.append("_");
            sb.append(uVar.b());
        }
        return sb.toString();
    }

    public DBAttributeCache a(byte[] bArr) {
        return this.f17302a.a(bArr);
    }
}
