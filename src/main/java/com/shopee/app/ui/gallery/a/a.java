package com.shopee.app.ui.gallery.a;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.cb;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.gallery.c;
import com.shopee.app.ui.gallery.f;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a extends q<c> implements c.b, f.a {

    /* renamed from: a  reason: collision with root package name */
    private n f21847a;

    /* renamed from: c  reason: collision with root package name */
    private cb f21848c;

    /* renamed from: d  reason: collision with root package name */
    private List<GalleryAlbumInfo> f21849d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Boolean> f21850e;

    /* renamed from: f  reason: collision with root package name */
    private long f21851f = -1;

    /* renamed from: g  reason: collision with root package name */
    private i f21852g;
    private int h;

    public a(n nVar, cb cbVar) {
        this.f21847a = nVar;
        this.f21848c = cbVar;
        this.f21850e = new HashMap<>();
        this.f21849d = new ArrayList();
        this.f21852g = b.a(this);
    }

    public void a() {
        this.f21852g.a();
    }

    public void b() {
        this.f21852g.b();
    }

    public void a(int i) {
        this.h = i;
        this.f21848c.e();
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String next : this.f21850e.keySet()) {
            if (this.f21850e.get(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a(List<GalleryAlbumInfo> list) {
        this.f21849d = list;
        for (GalleryAlbumInfo next : this.f21849d) {
            if (next.getId() == this.f21851f) {
                a(next);
            }
        }
        ((c) this.f19220b).b(this.f21849d);
    }

    public void a(GalleryAlbumInfo galleryAlbumInfo) {
        this.f21851f = galleryAlbumInfo.getId();
        ((c) this.f19220b).setSelectedAlbum(galleryAlbumInfo.getName());
        ((c) this.f19220b).a((List<GalleryItemInfo>) galleryAlbumInfo.getImageList());
    }

    public boolean a(GalleryItemInfo galleryItemInfo, boolean z) {
        int f2 = (z ? 1 : -1) + f();
        if (galleryItemInfo.getVideoTime() < 3001) {
            ((c) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_minimum_video_duration_error));
            return false;
        } else if (this.h == 0 && z) {
            ((c) this.f19220b).a(galleryItemInfo);
            return false;
        } else if (f2 <= this.h || !z) {
            this.f21850e.put(galleryItemInfo.getPath(), Boolean.valueOf(z));
            ((c) this.f19220b).a(f2);
            ((c) this.f19220b).b(f2);
            return true;
        } else {
            ((c) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_maximum_images_reached));
            return false;
        }
    }

    public int f() {
        int i = 0;
        for (Boolean booleanValue : this.f21850e.values()) {
            if (booleanValue.booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public boolean a(String str) {
        if (this.f21850e.containsKey(str)) {
            return this.f21850e.get(str).booleanValue();
        }
        return false;
    }

    public void a(GalleryItemInfo galleryItemInfo, int i) {
        this.h = i;
        a(galleryItemInfo, true);
        ((c) this.f19220b).m.notifyDataSetChanged();
    }
}
