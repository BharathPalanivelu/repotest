package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.g.c;
import com.shopee.app.h.b.a;
import com.shopee.app.h.l;
import com.shopee.app.h.r;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class dj extends a {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f16813c;

    /* access modifiers changed from: protected */
    public String d() {
        return "SaveImageToGalleryInteractor";
    }

    protected dj(n nVar) {
        super(nVar);
    }

    public void a(ImageView imageView) {
        this.f16813c = imageView;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f16813c != null) {
            Bitmap a2 = a.a().a(this.f16813c.getDrawable());
            String a3 = c.a(l.a().a(a2, 80));
            l a4 = l.a();
            if (!a4.a(a2, "Shopee_" + a3 + ".jpg")) {
                this.f16402a.a("ON_IMAGE_SAVED_ALBUM_FAIL", new com.garena.android.appkit.b.a());
            }
            r.a().a(b.e(R.string.sp_save_image_into_camera));
        }
    }
}
