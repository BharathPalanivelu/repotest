package com.shopee.feeds.feedlibrary.view.preview;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.widget.FrameLayout;
import com.garena.cropimage.library.CropImageView;
import com.garena.cropimage.library.CropTouchImageView;
import com.garena.cropimage.library.a;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.preview.e;

public class h implements f {

    /* renamed from: b  reason: collision with root package name */
    private static final int f28688b = Color.parseColor("#EAEAEA");

    /* renamed from: a  reason: collision with root package name */
    CropImageView.f f28689a;

    /* renamed from: c  reason: collision with root package name */
    private CropImageView f28690c;

    public void a(CropImageView.f fVar) {
        this.f28689a = fVar;
    }

    public void a(FrameLayout frameLayout) {
        this.f28690c = new CropImageView(frameLayout.getContext());
        this.f28690c.getCropFrame().a(false);
        this.f28690c.setParams(e());
        frameLayout.addView(this.f28690c);
    }

    public void a() {
        this.f28690c.setVisibility(8);
    }

    public void b(FrameLayout frameLayout) {
        frameLayout.removeView(this.f28690c);
        this.f28690c = null;
    }

    public void a(a aVar, e.a aVar2, Pair<Float, Float> pair) {
        this.f28690c.setBitmapLoader((CropImageView.a) null);
        this.f28690c.setVisibility(0);
        this.f28690c.getImageView().b();
        a params = this.f28690c.getParams();
        params.a(aVar2 == e.a.CENTER_CROP ? a.C0129a.CENTER_CROP : a.C0129a.CENTER_INSIDE);
        params.a(aVar.h());
        this.f28690c.setParams(params);
        CropImageView cropImageView = this.f28690c;
        cropImageView.setBitmapLoader(j.a(cropImageView.getContext(), aVar));
        this.f28690c.setImageLoadCallback(new CropImageView.f() {
            public void a(Bitmap bitmap) {
                if (h.this.f28689a != null) {
                    h.this.f28689a.a(bitmap);
                }
            }

            public void a() {
                u.a(b.b().f27287b, com.garena.android.appkit.tools.b.e(c.g.feeds_product_failed_to_load));
            }
        });
    }

    public void a(e.a aVar) {
        a.C0129a aVar2 = aVar == e.a.CENTER_CROP ? a.C0129a.CENTER_CROP : a.C0129a.CENTER_INSIDE;
        this.f28690c.getParams().a(aVar2);
        this.f28690c.getImageView().a(aVar2);
    }

    /* renamed from: b */
    public CropImageView d() {
        return this.f28690c;
    }

    public Pair<Float, Float> c() {
        float[] fArr = new float[9];
        CropTouchImageView imageView = this.f28690c.getImageView();
        Drawable drawable = imageView.getDrawable();
        imageView.getImageMatrix().getValues(fArr);
        if (drawable == null) {
            return new Pair<>(Float.valueOf(1.0f), Float.valueOf(1.0f));
        }
        int intrinsicHeight = (int) (((float) drawable.getIntrinsicHeight()) * fArr[4]);
        int width = this.f28690c.getCropFrame().getWidth();
        int height = this.f28690c.getCropFrame().getHeight();
        return new Pair<>(Float.valueOf((float) Math.min(width, (int) (((float) drawable.getIntrinsicWidth()) * fArr[0]))), Float.valueOf((float) Math.min(intrinsicHeight, height)));
    }

    private a e() {
        a params = this.f28690c.getParams();
        params.a(f28688b).a(2200, 2200).b(j.a(this.f28690c.getContext())).b(1, 1);
        return params;
    }

    public void a(String str) {
        if (!d.a(str)) {
            this.f28690c.getParams().a(str);
        }
    }
}
