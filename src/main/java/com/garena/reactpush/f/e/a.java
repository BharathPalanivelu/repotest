package com.garena.reactpush.f.e;

import android.content.Context;
import com.garena.reactpush.b.b;
import com.garena.reactpush.c.b;
import com.garena.reactpush.c.c;
import com.garena.reactpush.d.d;
import com.garena.reactpush.d.h;
import com.garena.reactpush.data.BundleState;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactPack;
import java.io.File;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final int f8521a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8522b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b f8523c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8524d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f8525e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f8526f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final OkHttpClient f8527g;
    private d h;
    /* access modifiers changed from: private */
    public boolean i = false;

    public a(OkHttpClient okHttpClient, float f2, b bVar, int i2, String str, int i3, int i4) {
        this.f8521a = i2;
        this.f8527g = okHttpClient;
        this.f8522b = i3;
        this.f8524d = i4;
        this.f8523c = bVar;
        this.f8525e = com.garena.reactpush.b.a(f2);
        this.f8526f = str;
        this.h = new d(bVar, this.f8525e, this.f8526f);
    }

    public boolean a(Context context, boolean z) {
        try {
            BundleState c2 = this.f8523c.c();
            if (!c2.isAppUpdate(this.f8522b) && c2.isSyncLocalSucccess()) {
                if (!z) {
                    return true;
                }
            }
            boolean a2 = this.h.a(context.getResources().openRawResource(this.f8521a), (Manifest) com.garena.reactpush.b.f6698a.a(c.a(context, this.f8524d), Manifest.class));
            c2.setAppVersion(this.f8522b);
            c2.clearTimestamps();
            c2.setNeedImageZipDownload(true);
            this.f8523c.a(c2);
            return a2;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b() {
        final BundleState c2 = this.f8523c.c();
        if (c2.isNeedImageZipDownload() && !this.i) {
            this.i = true;
            com.garena.reactpush.b.f6701d.a("Image Zip Pack. [Downloading=true]");
            new Thread(new Runnable() {
                public void run() {
                    ReactPack reactPack = a.this.f8523c.a().getPacks().get("image");
                    if (reactPack != null) {
                        String packURL = reactPack.getPackURL(a.this.f8525e);
                        String c2 = a.this.f8526f;
                        new com.garena.reactpush.c.h(a.this.f8527g, c2.concat("drawable-" + a.this.f8525e).concat(".zip"), a.this.f8526f, packURL, new b.a() {
                            public void a(Call call, Exception exc) {
                                com.garena.reactpush.b.f6701d.a("Image Zip Pack. [Failed=true]");
                                c2.setNeedImageZipDownload(true);
                                a.this.f8523c.a(c2);
                                boolean unused = a.this.i = false;
                            }

                            public void a(File file) {
                                com.garena.reactpush.b.f6701d.a("Image Zip Pack. [Downloaded=true]");
                                c2.setNeedImageZipDownload(false);
                                a.this.f8523c.a(c2);
                                boolean unused = a.this.i = false;
                            }
                        }).a();
                    }
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
