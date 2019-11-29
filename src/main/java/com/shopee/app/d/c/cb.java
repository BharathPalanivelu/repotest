package com.shopee.app.d.c;

import com.garena.videolib.a.b;
import com.garena.videolib.a.c;
import com.garena.videolib.b.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class cb extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f16667c = new a(ar.f());

    /* access modifiers changed from: protected */
    public String d() {
        return "GetVideoGalleryInteractor";
    }

    public cb(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<b> a2 = this.f16667c.a();
        ArrayList<GalleryAlbumInfo> arrayList = new ArrayList<>();
        for (b next : a2) {
            GalleryAlbumInfo galleryAlbumInfo = new GalleryAlbumInfo();
            galleryAlbumInfo.setName(next.a());
            for (c next2 : next.b()) {
                galleryAlbumInfo.addVideo(next2.c(), next2.d());
            }
            galleryAlbumInfo.setId(next.c());
            arrayList.add(galleryAlbumInfo);
        }
        if (!arrayList.isEmpty()) {
            GalleryAlbumInfo galleryAlbumInfo2 = new GalleryAlbumInfo();
            galleryAlbumInfo2.setName("All Videos");
            for (GalleryAlbumInfo imageList : arrayList) {
                for (GalleryItemInfo next3 : imageList.getImageList()) {
                    galleryAlbumInfo2.addVideo(next3.getPath(), next3.getVideoTime());
                }
            }
            galleryAlbumInfo2.setId(-1);
            arrayList.add(0, galleryAlbumInfo2);
        }
        this.f16402a.a().aM.a(arrayList).a();
    }

    public void e() {
        a();
    }
}
