package com.shopee.app.ui.product.add.a;

import android.widget.LinearLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.product.b.d;
import com.shopee.app.ui.product.common.ProductImageControl;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.g;
import com.shopee.app.util.w;
import com.shopee.id.R;
import d.d.b.j;
import d.m;
import java.util.List;

public final class c extends e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ProductImageControl f23962a;

    /* renamed from: b  reason: collision with root package name */
    private final d f23963b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ProductImageControl productImageControl, LinearLayout linearLayout, d dVar) {
        super(linearLayout);
        j.b(productImageControl, "productImageControl");
        j.b(linearLayout, "addProductLayout");
        j.b(dVar, "validatorProvider");
        this.f23962a = productImageControl;
        this.f23963b = dVar;
        this.f23962a.setDataSetChangeListener(new ProductImageControl.a(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f23964a;

            {
                this.f23964a = r1;
            }

            public final void a(List<MediaData> list) {
                c cVar = this.f23964a;
                cVar.a(cVar.f23962a.getImagesCount());
            }
        });
        f();
    }

    /* renamed from: a */
    public ProductImageControl b() {
        return this.f23962a;
    }

    public e.C0408e d() {
        return e.C0408e.IMAGE_COUNT;
    }

    public void e() {
        super.e();
        f();
    }

    public void c() {
        a(this.f23962a.getImagesCount());
    }

    public final void a(int i) {
        b(com.shopee.app.util.q.a.a(this.f23963b.b(), new e.c(i), false, 2, (Object) null));
    }

    private final void f() {
        try {
            g a2 = this.f23963b.b().a(e.C0408e.IMAGE_COUNT);
            if (a2 != null) {
                com.shopee.app.ui.product.b.a.e eVar = (com.shopee.app.ui.product.b.a.e) a2;
                w.a(this.f23962a.getImageFilterCode(), (w.a) new a(eVar.b(), eVar.c()));
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.product.validator.config.ImagesValidatorConfig");
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            w.b(this.f23962a.getImageFilterCode());
        }
    }

    public static final class a implements w.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f23965a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23966b;

        a(int i, int i2) {
            this.f23965a = i;
            this.f23966b = i2;
        }

        public boolean a(GalleryItemInfo galleryItemInfo) {
            j.b(galleryItemInfo, "item");
            return (galleryItemInfo.getWidth() >= this.f23965a && galleryItemInfo.getHeight() >= this.f23966b) || (galleryItemInfo.getWidth() == 0 && galleryItemInfo.getHeight() == 0);
        }

        public String a() {
            String a2 = b.a(R.string.error_image_resolution, Integer.valueOf(this.f23965a), Integer.valueOf(this.f23966b));
            j.a((Object) a2, "BBAppResource.string(R.s…ion, minWidth, minHeight)");
            return a2;
        }
    }
}
