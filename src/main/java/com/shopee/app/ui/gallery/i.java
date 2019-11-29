package com.shopee.app.ui.gallery;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import java.util.List;

public final class i implements com.garena.android.appkit.b.i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h f21914a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21915b = new g() {
        public void onEvent(a aVar) {
            i.this.f21914a.a((List<GalleryAlbumInfo>) (List) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f21916c = new g() {
        public void onEvent(a aVar) {
            i.this.f21914a.b((List) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public i(h hVar) {
        this.f21914a = hVar;
    }

    public void a() {
        b.a("GALLERY_ALBUM_LOCAL_LOAD", (e) this.f21915b, b.a.NETWORK_BUS);
        b.a("INSTAGRAM_IMAGE", (e) this.f21916c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("GALLERY_ALBUM_LOCAL_LOAD", this.f21915b, b.a.NETWORK_BUS);
        b.b("INSTAGRAM_IMAGE", this.f21916c, b.a.NETWORK_BUS);
    }
}
