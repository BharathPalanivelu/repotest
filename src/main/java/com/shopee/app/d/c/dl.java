package com.shopee.app.d.c;

import android.util.Pair;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.h.l;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.squareup.a.r;
import com.squareup.a.w;

public class dl extends a {

    /* renamed from: c  reason: collision with root package name */
    private String f16815c;

    /* renamed from: d  reason: collision with root package name */
    private String f16816d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f16817e;

    /* access modifiers changed from: protected */
    public String d() {
        return "SaveWebImageToGalleryInteractor";
    }

    protected dl(n nVar) {
        super(nVar);
    }

    public void a(String str, String str2, Boolean bool) {
        this.f16815c = str;
        this.f16816d = str2;
        this.f16817e = bool;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        Boolean bool = false;
        try {
            bool = Boolean.valueOf(l.a().a(w.a(ar.a()).a(this.f16815c).a(r.NO_STORE, r.NO_CACHE).h(), this.f16816d));
            if (bool.booleanValue() && !this.f16817e.booleanValue()) {
                com.shopee.app.h.r.a().a(b.e(R.string.sp_save_image_into_camera));
            }
        } catch (Throwable th) {
            a.a(th);
        }
        this.f16402a.a("WEB_IMAGE_SAVE", new com.garena.android.appkit.b.a(new Pair(this.f16817e, bool)));
    }
}
