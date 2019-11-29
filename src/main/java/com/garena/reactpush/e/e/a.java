package com.garena.reactpush.e.e;

import android.content.Context;
import com.garena.reactpush.b.b;
import com.garena.reactpush.c.b;
import com.garena.reactpush.c.c;
import com.garena.reactpush.d.d;
import com.garena.reactpush.d.h;
import com.garena.reactpush.data.BundleState;
import com.garena.reactpush.data.Manifest;
import java.io.File;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final int f8454a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8455b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b f8456c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8457d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f8458e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f8459f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final OkHttpClient f8460g;
    private d h;
    /* access modifiers changed from: private */
    public boolean i = false;

    public a(OkHttpClient okHttpClient, float f2, b bVar, int i2, String str, int i3, int i4) {
        this.f8454a = i2;
        this.f8460g = okHttpClient;
        this.f8455b = i3;
        this.f8457d = i4;
        this.f8456c = bVar;
        this.f8458e = com.garena.reactpush.b.a(f2);
        this.f8459f = str;
        this.h = new d(bVar, this.f8458e, this.f8459f);
    }

    public boolean a(Context context, boolean z) {
        try {
            BundleState c2 = this.f8456c.c();
            if (!c2.isAppUpdate(this.f8455b) && c2.isSyncLocalSucccess()) {
                if (!z) {
                    return true;
                }
            }
            boolean a2 = this.h.a(context.getResources().openRawResource(this.f8454a), (Manifest) com.garena.reactpush.b.f6698a.a(c.a(context, this.f8457d), Manifest.class));
            c2.setAppVersion(this.f8455b);
            c2.setNeedImageZipDownload(true);
            this.f8456c.a(c2);
            return a2;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b() {
        final BundleState c2 = this.f8456c.c();
        if (c2.isNeedImageZipDownload() && !this.i) {
            this.i = true;
            com.garena.reactpush.b.f6701d.a("Image Zip Pack. [Downloading=true]");
            new Thread(new Runnable() {
                public void run() {
                    String drawableZip = a.this.f8456c.a().getBundles().get(0).getDrawableZip(a.this.f8458e);
                    String c2 = a.this.f8459f;
                    new com.garena.reactpush.c.h(a.this.f8460g, c2.concat("drawable-" + a.this.f8458e).concat(".zip"), a.this.f8459f, drawableZip, new b.a() {
                        public void a(Call call, Exception exc) {
                            com.garena.reactpush.b.f6701d.a("Image Zip Pack. [Failed=true]");
                            c2.setNeedImageZipDownload(true);
                            a.this.f8456c.a(c2);
                            boolean unused = a.this.i = false;
                        }

                        public void a(File file) {
                            com.garena.reactpush.b.f6701d.a("Image Zip Pack. [Downloaded=true]");
                            c2.setNeedImageZipDownload(false);
                            a.this.f8456c.a(c2);
                            boolean unused = a.this.i = false;
                        }
                    }).a();
                }
            }).start();
        }
    }

    public boolean a(Context context) {
        return a(context, true);
    }

    public void a() {
        b();
    }
}
