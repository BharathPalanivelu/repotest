package com.shopee.feeds.feedlibrary.view.preview;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Pair;
import android.widget.FrameLayout;
import com.garena.cropimage.library.CropImageView;
import com.garena.cropimage.library.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.preview.e;

public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f28634a = Color.parseColor("#EAEAEA");

    /* renamed from: b  reason: collision with root package name */
    private CropImageView f28635b;

    public void a(e.a aVar) {
    }

    public Pair<Float, Float> c() {
        return null;
    }

    public void a(FrameLayout frameLayout) {
        this.f28635b = new CropImageView(frameLayout.getContext());
        this.f28635b.getCropFrame().a(false);
        this.f28635b.setParams(e());
        frameLayout.addView(this.f28635b);
    }

    public void a() {
        this.f28635b.setVisibility(8);
    }

    public void b(FrameLayout frameLayout) {
        frameLayout.removeView(this.f28635b);
        this.f28635b = null;
    }

    public void a(a aVar, e.a aVar2, Pair<Float, Float> pair) {
        this.f28635b.setBitmapLoader((CropImageView.a) null);
        this.f28635b.setVisibility(0);
        this.f28635b.getImageView().b();
        a params = this.f28635b.getParams();
        float floatValue = ((Float) pair.first).floatValue();
        float floatValue2 = ((Float) pair.second).floatValue();
        if (pair != null) {
            params = params.b((int) floatValue, (int) floatValue2);
        }
        params.a(aVar.h());
        this.f28635b.setParams(params);
        CropImageView cropImageView = this.f28635b;
        cropImageView.setBitmapLoader(j.a(cropImageView.getContext(), aVar));
        this.f28635b.setImageLoadCallback(new CropImageView.f() {
            public void a(Bitmap bitmap) {
            }

            public void a() {
                u.a(com.shopee.feeds.feedlibrary.b.b().f27287b, com.garena.android.appkit.tools.b.e(c.g.feeds_product_failed_to_load));
            }
        });
    }

    /* renamed from: b */
    public CropImageView d() {
        return this.f28635b;
    }

    private a e() {
        a params = this.f28635b.getParams();
        params.a(f28634a).a(2200, 2200).b(j.a(this.f28635b.getContext()));
        return params;
    }

    public void a(String str) {
        if (!d.a(str)) {
            this.f28635b.getParams().a(str);
        }
    }
}
