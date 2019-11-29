package com.shopee.feeds.feedlibrary.view.preview;

import a.h;
import a.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.garena.cropimage.library.CropImageView;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.view.preview.e;
import com.shopee.feeds.feedlibrary.view.preview.g;
import com.squareup.a.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

public class d {

    /* renamed from: a  reason: collision with root package name */
    boolean f28638a = false;

    /* renamed from: b  reason: collision with root package name */
    a f28639b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, f> f28640c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f28641d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, OriginImageInfo> f28642e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public h f28643f;

    /* renamed from: g  reason: collision with root package name */
    private i f28644g;

    public interface a {
        void a(int i, int i2);

        void a(Bitmap bitmap);

        void a(boolean z);

        void b(boolean z);
    }

    /* renamed from: com.shopee.feeds.feedlibrary.view.preview.d$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28655a = new int[e.b.values().length];

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
                f28655a = r0
                int[] r0 = f28655a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.shopee.feeds.feedlibrary.view.preview.e$b r1 = com.shopee.feeds.feedlibrary.view.preview.e.b.SINGLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f28655a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.shopee.feeds.feedlibrary.view.preview.e$b r1 = com.shopee.feeds.feedlibrary.view.preview.e.b.MULTIPLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.view.preview.d.AnonymousClass7.<clinit>():void");
        }
    }

    public f a(a aVar, FrameLayout frameLayout, e.b bVar) {
        int i = AnonymousClass7.f28655a[bVar.ordinal()];
        if (i == 1) {
            return a(aVar, frameLayout);
        }
        if (i != 2) {
            return null;
        }
        return b(aVar, frameLayout);
    }

    private f a(a aVar, FrameLayout frameLayout) {
        if (aVar.i().contains("video")) {
            a(frameLayout);
            return this.f28644g;
        }
        b(frameLayout);
        return this.f28643f;
    }

    public void a(e.b bVar, e.b bVar2, FrameLayout frameLayout) {
        if (bVar == e.b.SINGLE) {
            i iVar = this.f28644g;
            if (iVar != null) {
                iVar.a();
            }
            h hVar = this.f28643f;
            if (hVar != null) {
                hVar.a();
            }
        }
        if (bVar == e.b.MULTIPLE && bVar2 == e.b.SINGLE) {
            for (f next : this.f28640c.values()) {
                next.a();
                next.b(frameLayout);
            }
            this.f28640c.clear();
        }
    }

    public boolean a() {
        return this.f28644g.b();
    }

    private void a(FrameLayout frameLayout) {
        if (this.f28644g == null) {
            this.f28644g = new i();
            this.f28644g.a(frameLayout);
            this.f28644g.a((g.b) new g.b() {
                public void a(int i, int i2) {
                    if (d.this.f28639b != null) {
                        d.this.f28639b.a(i, i2);
                    }
                }

                public void a(boolean z) {
                    if (d.this.f28639b != null) {
                        d.this.f28639b.a(z);
                    }
                }
            });
        }
    }

    private void b(FrameLayout frameLayout) {
        if (this.f28643f == null) {
            this.f28643f = new h();
            this.f28643f.a(frameLayout);
            this.f28643f.a((CropImageView.f) new CropImageView.f() {
                public void a() {
                }

                public void a(Bitmap bitmap) {
                    if (d.this.f28639b != null) {
                        d.this.f28639b.a(bitmap);
                    }
                }
            });
        }
    }

    private f b(a aVar, FrameLayout frameLayout) {
        if (this.f28640c.containsKey(aVar.d())) {
            return this.f28640c.get(aVar.d());
        }
        f cVar = d(aVar) ? new c() : new b();
        cVar.a(frameLayout);
        this.f28640c.put(aVar.d(), cVar);
        return cVar;
    }

    private boolean d(a aVar) {
        return aVar.i().contains("video");
    }

    public void a(a aVar) {
        if (aVar.i().contains("video")) {
            i iVar = this.f28644g;
            if (iVar != null) {
                iVar.e();
            }
        }
    }

    public void b(a aVar) {
        if (aVar.i().contains("video")) {
            i iVar = this.f28644g;
            if (iVar != null) {
                iVar.f();
            }
        }
    }

    public void c(a aVar) {
        if (aVar.i().contains("video")) {
            i iVar = this.f28644g;
            if (iVar != null) {
                iVar.g();
            }
        }
    }

    public void a(a aVar) {
        this.f28639b = aVar;
    }

    public void a(final Context context, final LinkedHashMap<String, a> linkedHashMap) {
        HashMap<String, String> hashMap = this.f28641d;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, OriginImageInfo> hashMap2 = this.f28642e;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        this.f28638a = true;
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                Bitmap bitmap;
                if (d.this.f28640c != null && d.this.f28640c.size() > 0) {
                    for (Map.Entry entry : d.this.f28640c.entrySet()) {
                        b bVar = (b) entry.getValue();
                        try {
                            a aVar = (a) linkedHashMap.get((String) entry.getKey());
                            if (aVar != null) {
                                if (aVar.l()) {
                                    bitmap = w.a(context).a(aVar.h()).h();
                                } else {
                                    bitmap = aVar.m() ? w.a(context).a(aVar.h()).h() : null;
                                }
                                if (bitmap != null) {
                                    OriginImageInfo originImageInfo = new OriginImageInfo();
                                    originImageInfo.setOriginal_resolution(bitmap.getWidth() + " * " + bitmap.getHeight());
                                    originImageInfo.setOriginal_file_size(q.a(bitmap));
                                    d.this.f28642e.put(aVar.h(), originImageInfo);
                                    Context context = context;
                                    File file = new File(q.a(context, "feedDownLoad_" + UUID.randomUUID().toString().replace("-", "") + ".jpg"));
                                    file.createNewFile();
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    bVar.a(file.getPath());
                                    d.this.f28641d.put(aVar.h(), file.getPath());
                                } else {
                                    d.this.f28638a = false;
                                }
                            }
                        } catch (IOException e2) {
                            d.this.f28638a = false;
                            e2.printStackTrace();
                        }
                    }
                }
                return null;
            }
        }).a(new h<Object, Object>() {
            public Object then(k<Object> kVar) throws Exception {
                if (d.this.f28639b == null) {
                    return null;
                }
                d.this.f28639b.b(d.this.f28638a);
                return null;
            }
        }, k.f377b);
    }

    public void a(final Context context, final a aVar) {
        HashMap<String, String> hashMap = this.f28641d;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, OriginImageInfo> hashMap2 = this.f28642e;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        this.f28638a = true;
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                Bitmap bitmap;
                if (d.this.f28643f != null) {
                    try {
                        if (aVar.l()) {
                            bitmap = w.a(context).a(aVar.h()).h();
                        } else {
                            bitmap = aVar.m() ? w.a(context).a(aVar.h()).h() : null;
                        }
                        if (bitmap != null) {
                            OriginImageInfo originImageInfo = new OriginImageInfo();
                            originImageInfo.setOriginal_resolution(bitmap.getWidth() + " * " + bitmap.getHeight());
                            originImageInfo.setOriginal_file_size(q.a(bitmap));
                            d.this.f28642e.put(aVar.h(), originImageInfo);
                            Context context = context;
                            File file = new File(q.a(context, "feedDownLoad_" + UUID.randomUUID().toString().replace("-", "") + ".jpg"));
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            d.this.f28643f.a(file.getPath());
                            d.this.f28641d.put(aVar.h(), file.getPath());
                        } else {
                            d.this.f28638a = false;
                        }
                    } catch (IOException e2) {
                        d.this.f28638a = false;
                        e2.printStackTrace();
                    }
                }
                return null;
            }
        }).a(new h<Object, Object>() {
            public Object then(k<Object> kVar) throws Exception {
                if (d.this.f28639b == null) {
                    return null;
                }
                d.this.f28639b.b(d.this.f28638a);
                return null;
            }
        }, k.f377b);
    }

    public HashMap<String, String> b() {
        return this.f28641d;
    }

    public HashMap<String, OriginImageInfo> c() {
        return this.f28642e;
    }
}
