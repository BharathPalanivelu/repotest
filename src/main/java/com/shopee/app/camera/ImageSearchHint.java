package com.shopee.app.camera;

import a.h;
import a.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.h.l;
import com.squareup.a.af;
import com.squareup.a.w;
import d.d.b.j;
import d.p;
import java.io.File;
import java.util.Date;
import java.util.concurrent.Callable;

public final class ImageSearchHint extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private final long f15922a = 600000;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f15923b = 4000;

    /* renamed from: c  reason: collision with root package name */
    private String f15924c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f15925d = new a(this);

    /* renamed from: e  reason: collision with root package name */
    private final af f15926e = new e(this);

    static final class d<TTaskResult, TContinuationResult> implements h<TResult, TContinuationResult> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f15930a = new d();

        d() {
        }

        public /* synthetic */ Object then(k kVar) {
            a(kVar);
            return p.f32714a;
        }

        public final void a(k<Object> kVar) {
            j.a((Object) kVar, "it");
            if (kVar.e()) {
                com.garena.android.appkit.d.a.a(kVar.g());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageSearchHint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.b(context, "context");
        j.b(attributeSet, "attributeSet");
    }

    public final String getImage() {
        return this.f15924c;
    }

    public final void setImage(String str) {
        this.f15924c = str;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageSearchHint f15927a;

        a(ImageSearchHint imageSearchHint) {
            this.f15927a = imageSearchHint;
        }

        public final void run() {
            this.f15927a.setVisibility(8);
        }
    }

    public final Runnable getHide() {
        return this.f15925d;
    }

    public static final class e implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageSearchHint f15931a;

        public void a(Drawable drawable) {
        }

        e(ImageSearchHint imageSearchHint) {
            this.f15931a = imageSearchHint;
        }

        public void b(Drawable drawable) {
            this.f15931a.setVisibility(8);
        }

        public void a(Bitmap bitmap, w.d dVar) {
            this.f15931a.setImageBitmap(bitmap);
            this.f15931a.setVisibility(0);
            ImageSearchHint imageSearchHint = this.f15931a;
            imageSearchHint.removeCallbacks(imageSearchHint.getHide());
            ImageSearchHint imageSearchHint2 = this.f15931a;
            imageSearchHint2.postDelayed(imageSearchHint2.getHide(), this.f15931a.f15923b);
        }
    }

    public final af getTarget() {
        return this.f15926e;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f15925d);
    }

    public final void a() {
        if (Build.VERSION.SDK_INT < 23 || getContext().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            k.a(new b(this)).a(new c(this), k.f377b).a(d.f15930a);
            return;
        }
        com.garena.android.appkit.d.a.a("image_search image search hint not shown [no permission]", new Object[0]);
        setVisibility(8);
    }

    static final class b<V> implements Callable<TResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageSearchHint f15928a;

        b(ImageSearchHint imageSearchHint) {
            this.f15928a = imageSearchHint;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A[SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.shopee.app.data.viewmodel.GalleryItemInfo call() {
            /*
                r10 = this;
                com.shopee.app.h.b.a.a r0 = new com.shopee.app.h.b.a.a
                com.shopee.app.application.ar r1 = com.shopee.app.application.ar.f()
                r0.<init>(r1)
                r0.a()
                java.util.List r0 = r0.b()
                java.lang.String r1 = "albums"
                d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.Iterator r0 = r0.iterator()
            L_0x001b:
                boolean r1 = r0.hasNext()
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0040
                java.lang.Object r1 = r0.next()
                r5 = r1
                com.shopee.app.data.viewmodel.GalleryAlbumInfo r5 = (com.shopee.app.data.viewmodel.GalleryAlbumInfo) r5
                java.lang.String r6 = "album"
                d.d.b.j.a((java.lang.Object) r5, (java.lang.String) r6)
                long r5 = r5.getId()
                r7 = -1
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 != 0) goto L_0x003c
                r5 = 1
                goto L_0x003d
            L_0x003c:
                r5 = 0
            L_0x003d:
                if (r5 == 0) goto L_0x001b
                goto L_0x0041
            L_0x0040:
                r1 = r3
            L_0x0041:
                com.shopee.app.data.viewmodel.GalleryAlbumInfo r1 = (com.shopee.app.data.viewmodel.GalleryAlbumInfo) r1
                if (r1 == 0) goto L_0x0089
                java.util.ArrayList r0 = r1.getImageList()
                if (r0 == 0) goto L_0x0089
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.Iterator r0 = r0.iterator()
            L_0x0051:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x007f
                java.lang.Object r1 = r0.next()
                com.shopee.app.data.viewmodel.GalleryItemInfo r1 = (com.shopee.app.data.viewmodel.GalleryItemInfo) r1
                com.shopee.app.util.w$a r5 = com.shopee.app.util.w.f26533a
                boolean r5 = r5.a(r1)
                if (r5 == 0) goto L_0x007b
                java.io.File r5 = new java.io.File
                java.lang.String r6 = "image"
                d.d.b.j.a((java.lang.Object) r1, (java.lang.String) r6)
                java.lang.String r6 = r1.getPath()
                r5.<init>(r6)
                boolean r5 = r5.exists()
                if (r5 == 0) goto L_0x007b
                r5 = 1
                goto L_0x007c
            L_0x007b:
                r5 = 0
            L_0x007c:
                if (r5 == 0) goto L_0x0051
                goto L_0x008a
            L_0x007f:
                java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
                java.lang.String r1 = "Collection contains no element matching the predicate."
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x0089:
                r1 = r3
            L_0x008a:
                if (r1 == 0) goto L_0x00d7
                java.lang.String r0 = r1.getPath()
                if (r0 == 0) goto L_0x00d7
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = d.h.m.a(r0)
                r0 = r0 ^ r4
                if (r0 != r4) goto L_0x00d7
                com.shopee.app.camera.ImageSearchHint r0 = r10.f15928a
                java.lang.String r4 = r1.getPath()
                java.lang.String r5 = "this.path"
                d.d.b.j.a((java.lang.Object) r4, (java.lang.String) r5)
                long r5 = r1.getCreateTime()
                boolean r0 = r0.a(r4, r5)
                if (r0 == 0) goto L_0x00d7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "image_search image search hint ready to show "
                r0.append(r3)
                java.lang.String r3 = r1.getPath()
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                java.lang.Object[] r2 = new java.lang.Object[r2]
                com.garena.android.appkit.d.a.b(r0, r2)
                java.lang.String r0 = r1.getPath()
                java.lang.String r2 = "this?.path"
                d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r2)
                com.shopee.app.camera.a.a(r0)
                return r1
            L_0x00d7:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.camera.ImageSearchHint.b.call():com.shopee.app.data.viewmodel.GalleryItemInfo");
        }
    }

    static final class c<TTaskResult, TContinuationResult> implements h<GalleryItemInfo, Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageSearchHint f15929a;

        c(ImageSearchHint imageSearchHint) {
            this.f15929a = imageSearchHint;
        }

        /* renamed from: a */
        public final Void then(k<GalleryItemInfo> kVar) {
            j.a((Object) kVar, "task");
            if (!kVar.c() || kVar.f() == null) {
                if (kVar.e()) {
                    com.garena.android.appkit.d.a.a(kVar.g());
                }
                this.f15929a.setVisibility(8);
            } else {
                GalleryItemInfo f2 = kVar.f();
                Uri fromFile = Uri.fromFile(new File(f2 != null ? f2.getPath() : null));
                l.b b2 = l.b(fromFile);
                float f3 = ((float) b2.f17679b) / ((float) b2.f17678a);
                int i = b.a.t;
                float f4 = ((float) b.a.t) * f3;
                this.f15929a.setImage(fromFile.toString());
                w.a(this.f15929a.getContext()).a(fromFile).b(i, (int) f4).f().d().a(this.f15929a.getTarget());
            }
            return null;
        }
    }

    public final boolean a(String str, long j) {
        j.b(str, "image");
        if ((new Date().getTime() / ((long) 1000)) - j > this.f15922a / 1000) {
            com.garena.android.appkit.d.a.a("image_search image search hint not shown [photo too old] " + j + ' ' + str, new Object[0]);
            return false;
        } else if (j.a((Object) str, (Object) a.a())) {
            com.garena.android.appkit.d.a.a("image_search image search hint not shown [photo have been seen before] " + j + ' ' + str, new Object[0]);
            return false;
        } else if (!j.a((Object) str, (Object) a.b())) {
            return true;
        } else {
            com.garena.android.appkit.d.a.a("image_search image search hint not shown [photo taken by image search] " + j + ' ' + str, new Object[0]);
            return false;
        }
    }
}
