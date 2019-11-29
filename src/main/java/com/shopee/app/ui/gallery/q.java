package com.shopee.app.ui.gallery;

import android.os.Bundle;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.aq;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.ui.gallery.c;
import com.shopee.app.ui.gallery.f;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q extends com.shopee.app.ui.a.q<v> implements c.b, f.a {

    /* renamed from: a  reason: collision with root package name */
    private n f21991a;

    /* renamed from: c  reason: collision with root package name */
    private aq f21992c;

    /* renamed from: d  reason: collision with root package name */
    private List<GalleryAlbumInfo> f21993d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Boolean> f21994e;

    /* renamed from: f  reason: collision with root package name */
    private int f21995f;

    /* renamed from: g  reason: collision with root package name */
    private long f21996g = -1;
    private i h;

    public q(n nVar, aq aqVar) {
        this.f21991a = nVar;
        this.f21992c = aqVar;
        this.f21994e = new HashMap<>();
        this.f21993d = new ArrayList();
        this.h = b.a(this);
    }

    public void a() {
        this.h.a();
    }

    public void b() {
        this.h.b();
    }

    public void a(int i) {
        this.f21995f = i;
        this.f21992c.e();
    }

    public void a(List<GalleryData> list) {
        this.f21994e.clear();
        if (list != null) {
            for (GalleryData next : list) {
                this.f21994e.put(next.f21838b, Boolean.valueOf(next.f21837a));
            }
        }
        ((v) this.f19220b).b();
        for (GalleryAlbumInfo next2 : this.f21993d) {
            if (next2.getId() == this.f21996g) {
                a(next2);
            }
        }
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String next : this.f21994e.keySet()) {
            if (this.f21994e.get(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<GalleryData> f() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.f21994e.keySet()) {
            if (this.f21994e.get(next).booleanValue()) {
                arrayList.add(new GalleryData(next, true, Integer.MAX_VALUE, Integer.MAX_VALUE));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b(List<GalleryAlbumInfo> list) {
        this.f21993d = list;
        for (GalleryAlbumInfo next : this.f21993d) {
            if (next.getId() == this.f21996g) {
                a(next);
            }
        }
        ((v) this.f19220b).b(this.f21993d);
    }

    public void a(GalleryAlbumInfo galleryAlbumInfo) {
        this.f21996g = galleryAlbumInfo.getId();
        ((v) this.f19220b).setSelectedAlbum(galleryAlbumInfo.getName());
        ((v) this.f19220b).a((List<GalleryItemInfo>) galleryAlbumInfo.getImageList());
    }

    public long g() {
        return this.f21996g;
    }

    public boolean a(GalleryItemInfo galleryItemInfo, boolean z) {
        int h2 = (z ? 1 : -1) + h();
        if (h2 <= this.f21995f || !z) {
            this.f21994e.put(galleryItemInfo.getPath(), Boolean.valueOf(z));
            ((v) this.f19220b).b(h2);
            ((v) this.f19220b).a(h2);
            return true;
        }
        ((v) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_maximum_images_reached));
        return false;
    }

    public int h() {
        int i = 0;
        for (Boolean booleanValue : this.f21994e.values()) {
            if (booleanValue.booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public boolean a(String str) {
        if (this.f21994e.containsKey(str)) {
            return this.f21994e.get(str).booleanValue();
        }
        return false;
    }

    public Bundle i() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", this.f21994e);
        bundle.putLong("album", this.f21996g);
        return bundle;
    }

    public void a(Bundle bundle) {
        this.f21994e = (HashMap) bundle.getSerializable("map");
        this.f21996g = bundle.getLong("album");
        ((v) this.f19220b).b();
        this.f21992c.e();
    }
}
