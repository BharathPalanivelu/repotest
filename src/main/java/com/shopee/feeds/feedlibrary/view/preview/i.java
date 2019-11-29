package com.shopee.feeds.feedlibrary.view.preview;

import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.feeds.feedlibrary.view.preview.e;
import com.shopee.feeds.feedlibrary.view.preview.g;

public class i implements f {

    /* renamed from: a  reason: collision with root package name */
    g.b f28692a;

    /* renamed from: b  reason: collision with root package name */
    private g f28693b;

    public void a(g.b bVar) {
        this.f28692a = bVar;
    }

    public void a(FrameLayout frameLayout) {
        this.f28693b = new g(frameLayout.getContext(), false);
        this.f28693b.setVideoSizeChangeCallBack(new g.b() {
            public void a(int i, int i2) {
                if (i.this.f28692a != null) {
                    i.this.f28692a.a(i, i2);
                }
            }

            public void a(boolean z) {
                if (i.this.f28692a != null) {
                    i.this.f28692a.a(z);
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(this.f28693b, layoutParams);
    }

    public Pair<Float, Float> c() {
        return new Pair<>(Float.valueOf(this.f28693b.getRatioWidth().floatValue()), Float.valueOf(this.f28693b.getRatioHeight().floatValue()));
    }

    public void a() {
        this.f28693b.setVisibility(8);
        this.f28693b.b();
    }

    public void b(FrameLayout frameLayout) {
        frameLayout.removeView(this.f28693b);
        this.f28693b = null;
    }

    /* renamed from: com.shopee.feeds.feedlibrary.view.preview.i$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28695a = new int[e.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.shopee.feeds.feedlibrary.view.preview.e$a[] r0 = com.shopee.feeds.feedlibrary.view.preview.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28695a = r0
                int[] r0 = f28695a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.shopee.feeds.feedlibrary.view.preview.e$a r1 = com.shopee.feeds.feedlibrary.view.preview.e.a.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f28695a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.shopee.feeds.feedlibrary.view.preview.e$a r1 = com.shopee.feeds.feedlibrary.view.preview.e.a.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.view.preview.i.AnonymousClass2.<clinit>():void");
        }
    }

    public void a(a aVar, e.a aVar2, Pair<Float, Float> pair) {
        int i = AnonymousClass2.f28695a[aVar2.ordinal()];
        if (i == 1) {
            this.f28693b.a();
        } else if (i == 2) {
            this.f28693b.setRatioToVideo(false);
        }
        this.f28693b.setVisibility(0);
        this.f28693b.setVideoPath(aVar.h());
        this.f28693b.d();
    }

    public View d() {
        return this.f28693b;
    }

    public void a(e.a aVar) {
        int i = AnonymousClass2.f28695a[aVar.ordinal()];
        if (i == 1) {
            this.f28693b.a();
        } else if (i == 2) {
            this.f28693b.setRatioToVideo(true);
        }
    }

    public boolean b() {
        return this.f28693b.f();
    }

    public void e() {
        g gVar = this.f28693b;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void f() {
        g gVar = this.f28693b;
        if (gVar != null) {
            gVar.e();
        }
    }

    public void g() {
        g gVar = this.f28693b;
        if (gVar != null) {
            gVar.d();
        }
    }
}
