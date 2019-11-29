package com.shopee.feeds.feedlibrary.view.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.garena.cropimage.library.CropImageView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.DownloadImgEvent;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.preview.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f28656a;

    /* renamed from: b  reason: collision with root package name */
    private final FrameLayout f28657b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f28658c = b.SINGLE;

    /* renamed from: d  reason: collision with root package name */
    private a f28659d = a.CENTER_CROP;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d f28660e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f28661f;

    /* renamed from: g  reason: collision with root package name */
    private Pair<Float, Float> f28662g;
    private ImageView h;
    /* access modifiers changed from: private */
    public ImageView i;
    /* access modifiers changed from: private */
    public ImageView j;
    private LinkedHashMap<String, a> k;
    /* access modifiers changed from: private */
    public int l;

    public enum a {
        CENTER_CROP,
        CENTER_INSIDE
    }

    public enum b {
        SINGLE,
        MULTIPLE
    }

    public e(Context context, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.f28656a = context;
        this.k = new LinkedHashMap<>();
        this.f28660e = new d();
        this.f28660e.a((d.a) new d.a() {
            public void a(Bitmap bitmap) {
                if (bitmap != null && e.this.i != null && e.this.f28658c == b.SINGLE) {
                    if (bitmap.getWidth() != bitmap.getHeight() || e.this.i == null) {
                        e.this.i.setVisibility(0);
                    } else {
                        e.this.i.setVisibility(8);
                    }
                }
            }

            public void a(int i, int i2) {
                if (i != 0 && i2 != 0) {
                    if (i == i2) {
                        e.this.i.setVisibility(8);
                    } else {
                        e.this.i.setVisibility(0);
                    }
                }
            }

            public void a(boolean z) {
                if (!e.this.f28661f.i().contains("video")) {
                    return;
                }
                if (e.this.f28660e.a()) {
                    e.this.j.setVisibility(0);
                    e.this.f28660e.a(e.this.f28661f);
                    return;
                }
                e.this.j.setVisibility(8);
                e.this.f28660e.c(e.this.f28661f);
            }

            public void b(boolean z) {
                if (!z) {
                    e.this.f();
                    u.a(e.this.f28656a, com.garena.android.appkit.tools.b.e(c.g.feeds_product_failed_to_load));
                    return;
                }
                e eVar = e.this;
                eVar.a(eVar.l);
            }
        });
        this.f28657b = frameLayout;
        this.h = imageView;
        this.i = imageView2;
        this.j = imageView3;
    }

    public void a(b bVar) {
        this.f28662g = a(this.f28661f, this.f28658c);
        this.f28660e.a(this.f28658c, bVar, this.f28657b);
        if (this.f28658c == b.MULTIPLE && bVar == b.SINGLE) {
            this.k.clear();
        }
        this.f28658c = bVar;
    }

    public void a(a aVar) {
        this.f28659d = aVar;
        g(this.f28661f);
    }

    /* renamed from: com.shopee.feeds.feedlibrary.view.preview.e$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28667a = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.shopee.feeds.feedlibrary.view.preview.e$b[] r0 = com.shopee.feeds.feedlibrary.view.preview.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28667a = r0
                int[] r0 = f28667a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.shopee.feeds.feedlibrary.view.preview.e$b r1 = com.shopee.feeds.feedlibrary.view.preview.e.b.SINGLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f28667a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.shopee.feeds.feedlibrary.view.preview.e$b r1 = com.shopee.feeds.feedlibrary.view.preview.e.b.MULTIPLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.view.preview.e.AnonymousClass4.<clinit>():void");
        }
    }

    public List<a> a() {
        int i2 = AnonymousClass4.f28667a[this.f28658c.ordinal()];
        if (i2 == 1) {
            return Collections.singletonList(this.f28661f);
        }
        if (i2 != 2) {
            return Collections.emptyList();
        }
        return new ArrayList(this.k.values());
    }

    public void a(a aVar) {
        int i2 = AnonymousClass4.f28667a[this.f28658c.ordinal()];
        if (i2 == 1 || i2 != 2 || this.k.containsKey(aVar.d())) {
            e(this.f28661f);
            f(aVar);
            this.f28661f = aVar;
            h(this.f28661f);
            return;
        }
        a("Cannot show media, if not added first.");
    }

    public void b(a aVar) {
        if (AnonymousClass4.f28667a[this.f28658c.ordinal()] != 2) {
            a("Cannot add media in single mode!");
        } else {
            this.k.put(aVar.d(), aVar);
        }
    }

    public void c(a aVar) {
        if (AnonymousClass4.f28667a[this.f28658c.ordinal()] != 2) {
            a("Cannot remove media in single mode!");
        } else {
            this.k.remove(aVar.d());
        }
    }

    public void d(a aVar) {
        this.f28661f = aVar;
    }

    public void a(int i2) {
        try {
            this.l = i2;
            if (c()) {
                f();
                u.a(this.f28656a, com.garena.android.appkit.tools.b.e(c.g.feeds_operation_failed));
                return;
            }
            int i3 = AnonymousClass4.f28667a[this.f28658c.ordinal()];
            if (i3 == 1) {
                View d2 = this.f28660e.a(this.f28661f, this.f28657b, this.f28658c).d();
                if (d2 instanceof CropImageView) {
                    this.f28661f.a(((CropImageView) d2).getParams().b());
                    ((CropImageView) d2).setCropImageCallback(new CropImageView.c() {
                        public void a(CropImageView.g gVar) {
                            if (gVar.equals(CropImageView.g.SUCCESS)) {
                                org.greenrobot.eventbus.c.a().c(e.this.f28661f);
                                return;
                            }
                            e.this.f();
                            u.a(e.this.f28656a, com.garena.android.appkit.tools.b.e(c.g.feeds_operation_failed));
                        }
                    });
                    ((CropImageView) d2).a();
                } else if (d2 instanceof g) {
                    ((g) d2).getCropVideoParam();
                }
            } else if (i3 == 2) {
                for (final a next : this.k.values()) {
                    View d3 = this.f28660e.a(next, this.f28657b, this.f28658c).d();
                    if (d3 instanceof CropImageView) {
                        next.a(((CropImageView) d3).getParams().b());
                        ((CropImageView) d3).setCropImageCallback(new CropImageView.c() {
                            public void a(CropImageView.g gVar) {
                                if (gVar.equals(CropImageView.g.SUCCESS)) {
                                    org.greenrobot.eventbus.c.a().c(next);
                                    return;
                                }
                                e.this.f();
                                u.a(e.this.f28656a, com.garena.android.appkit.tools.b.e(c.g.feeds_operation_failed));
                            }
                        });
                        ((CropImageView) d3).b();
                    }
                }
            }
        } catch (Exception e2) {
            f();
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        DownloadImgEvent downloadImgEvent = new DownloadImgEvent();
        downloadImgEvent.setState(2);
        downloadImgEvent.setType(this.l);
        org.greenrobot.eventbus.c.a().c(downloadImgEvent);
    }

    public void b(int i2) {
        this.l = i2;
        int i3 = AnonymousClass4.f28667a[this.f28658c.ordinal()];
        if (i3 == 1) {
            this.f28660e.a(this.f28656a, this.f28661f);
        } else if (i3 == 2) {
            this.f28660e.a(this.f28656a, this.k);
        }
    }

    private void a(String str) {
        Toast.makeText(this.f28656a, str, 0).show();
    }

    private void e(a aVar) {
        if (aVar != null) {
            this.f28660e.a(aVar, this.f28657b, this.f28658c).a();
        }
    }

    private void f(a aVar) {
        if (aVar != null) {
            this.f28660e.a(aVar, this.f28657b, this.f28658c).a(aVar, this.f28659d, this.f28662g);
        }
    }

    private void g(a aVar) {
        if (aVar != null) {
            this.f28660e.a(this.f28661f, this.f28657b, this.f28658c).a(this.f28659d);
        }
    }

    private void h(a aVar) {
        if (aVar != null) {
            if (aVar.i().contains("video")) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public void b() {
        if (this.f28660e != null) {
            a aVar = this.f28661f;
            if (aVar != null && aVar.i().contains("video")) {
                this.j.setVisibility(0);
                this.f28660e.a(this.f28661f);
            }
        }
    }

    public void a(boolean z) {
        if (this.f28660e != null) {
            a aVar = this.f28661f;
            if (aVar != null && aVar.i().contains("video") && z) {
                this.j.setVisibility(8);
                this.f28660e.b(this.f28661f);
            }
        }
    }

    private Pair<Float, Float> a(a aVar, b bVar) {
        if (aVar != null && bVar == b.SINGLE) {
            Pair<Float, Float> c2 = this.f28660e.a(aVar, this.f28657b, bVar).c();
            ((ContainerLayout) this.f28657b).a(((Float) c2.first).floatValue(), ((Float) c2.second).floatValue());
            return c2;
        } else if (aVar == null || bVar != b.MULTIPLE) {
            return null;
        } else {
            ((ContainerLayout) this.f28657b).a(1.0f, 1.0f);
            return null;
        }
    }

    public boolean c() {
        if (AnonymousClass4.f28667a[this.f28658c.ordinal()] != 1) {
            return false;
        }
        View d2 = this.f28660e.a(this.f28661f, this.f28657b, this.f28658c).d();
        if (!(d2 instanceof CropImageView) || ((CropImageView) d2).getImageView().getDrawable() != null) {
            return false;
        }
        return true;
    }

    public HashMap<String, String> d() {
        return this.f28660e.b();
    }

    public HashMap<String, OriginImageInfo> e() {
        return this.f28660e.c();
    }
}
