package com.shopee.app.ui.gallery;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.aq;
import com.shopee.app.d.c.cc;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class h extends q<j> {

    /* renamed from: a  reason: collision with root package name */
    private final n f21908a;

    /* renamed from: c  reason: collision with root package name */
    private final cc f21909c;

    /* renamed from: d  reason: collision with root package name */
    private aq f21910d;

    /* renamed from: e  reason: collision with root package name */
    private List<GalleryAlbumInfo> f21911e;

    /* renamed from: f  reason: collision with root package name */
    private long f21912f;

    /* renamed from: g  reason: collision with root package name */
    private i f21913g = b.a(this);

    public h(n nVar, cc ccVar, aq aqVar) {
        this.f21908a = nVar;
        this.f21910d = aqVar;
        this.f21909c = ccVar;
    }

    public void a() {
        this.f21913g.a();
    }

    public void a(long j) {
        this.f21912f = j;
        long j2 = this.f21912f;
        if (j2 == -99) {
            ((j) this.f19220b).d();
        } else if (j2 == -98) {
            this.f21909c.e();
        } else {
            this.f21910d.e();
        }
    }

    public void b() {
        this.f21913g.b();
    }

    /* access modifiers changed from: package-private */
    public void a(List<GalleryAlbumInfo> list) {
        this.f21911e = list;
        for (GalleryAlbumInfo next : this.f21911e) {
            if (next.getId() == this.f21912f) {
                ((j) this.f19220b).setImageList(next.getPathList());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<com.shopee.app.instagram.h> list) {
        this.f21911e = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.shopee.app.instagram.h next : list) {
                arrayList.add(GalleryItemInfo.newGalleryImage(next.c(), next.a(), next.b(), 0));
            }
            ((j) this.f19220b).setImageList(arrayList);
        }
    }
}
