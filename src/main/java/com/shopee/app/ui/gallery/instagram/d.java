package com.shopee.app.ui.gallery.instagram;

import android.content.Intent;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.cc;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.instagram.e;
import com.shopee.app.instagram.h;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.gallery.GalleryData;
import com.shopee.app.ui.gallery.f;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class d extends q<f> implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private final e f21937a;

    /* renamed from: c  reason: collision with root package name */
    private n f21938c;

    /* renamed from: d  reason: collision with root package name */
    private List<GalleryItemInfo> f21939d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Boolean> f21940e;

    /* renamed from: f  reason: collision with root package name */
    private final cc f21941f;

    /* renamed from: g  reason: collision with root package name */
    private int f21942g;
    private i h;

    public d(n nVar, e eVar, cc ccVar) {
        this.f21938c = nVar;
        this.f21941f = ccVar;
        this.f21937a = eVar;
        this.f21940e = new HashMap<>();
        this.h = b.a(this);
    }

    public void a(int i) {
        this.f21942g = i;
        if (this.f21937a.a()) {
            ((f) this.f19220b).c();
            h();
            return;
        }
        this.f21937a.a(((f) this.f19220b).getContext());
    }

    private void h() {
        this.f21941f.e();
    }

    public void a(Intent intent) {
        this.f21937a.a(intent);
        a(this.f21942g);
    }

    public int e() {
        int i = 0;
        for (Boolean booleanValue : this.f21940e.values()) {
            if (booleanValue.booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public void a() {
        this.h.a();
    }

    public void b() {
        this.h.b();
    }

    public boolean a(GalleryItemInfo galleryItemInfo, boolean z) {
        int e2 = (z ? 1 : -1) + e();
        if (e2 <= this.f21942g || !z) {
            this.f21940e.put(galleryItemInfo.getPath(), Boolean.valueOf(z));
            ((f) this.f19220b).a(e2);
            ((f) this.f19220b).b(e2);
            return true;
        }
        ((f) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_maximum_images_reached));
        return false;
    }

    public boolean a(String str) {
        if (this.f21940e.containsKey(str)) {
            return this.f21940e.get(str).booleanValue();
        }
        return false;
    }

    public void a(ArrayList<GalleryData> arrayList) {
        this.f21940e.clear();
        Iterator<GalleryData> it = arrayList.iterator();
        while (it.hasNext()) {
            GalleryData next = it.next();
            this.f21940e.put(next.f21838b, Boolean.valueOf(next.f21837a));
        }
        ((f) this.f19220b).b();
        ((f) this.f19220b).a(this.f21939d);
    }

    public ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String next : this.f21940e.keySet()) {
            if (this.f21940e.get(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a(List<h> list) {
        ((f) this.f19220b).d();
        this.f21939d = new ArrayList();
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (h next : list) {
                hashMap.put(next.c(), next);
                this.f21939d.add(GalleryItemInfo.newGalleryImage(next.c(), next.a(), next.b(), 0));
            }
            ((f) this.f19220b).a(this.f21939d, (HashMap<String, h>) hashMap, list);
        }
    }

    public void g() {
        this.f21941f.f();
    }
}
