package com.shopee.app.ui.gallery.a;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import java.util.List;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f21853a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21854b = new g() {
        public void onEvent(a aVar) {
            b.this.f21853a.a((List<GalleryAlbumInfo>) (List) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f21853a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("VIDEO_GALLERY_ALBUM_LOCAL_LOAD", (e) this.f21854b, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("VIDEO_GALLERY_ALBUM_LOCAL_LOAD", this.f21854b, b.a.NETWORK_BUS);
    }
}
