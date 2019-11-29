package com.shopee.app.d.c;

import com.shopee.app.data.store.m;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.network.d.s;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class x extends a {

    /* renamed from: c  reason: collision with root package name */
    private final m f17135c;

    /* renamed from: d  reason: collision with root package name */
    private List<Integer> f17136d = new ArrayList();

    /* access modifiers changed from: protected */
    public String d() {
        return "GetAttributeModelInteractor";
    }

    protected x(n nVar, m mVar) {
        super(nVar);
        this.f17135c = mVar;
    }

    public void a(int i) {
        this.f17136d.clear();
        this.f17136d.add(Integer.valueOf(i));
        DBCategory a2 = this.f17135c.a(i);
        while (a2 != null) {
            int d2 = a2.d();
            if (d2 == 0) {
                break;
            }
            DBCategory a3 = this.f17135c.a(d2);
            this.f17136d.add(0, Integer.valueOf(d2));
            a2 = a3;
        }
        Collections.reverse(this.f17136d);
        a();
    }

    public void a(List<Integer> list) {
        this.f17136d.clear();
        this.f17136d.addAll(list);
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        new s().a(this.f17136d);
    }
}
