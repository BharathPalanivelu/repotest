package com.garena.reactpush.f.d;

import com.garena.reactpush.b.b;
import com.garena.reactpush.c.c;
import com.garena.reactpush.d.e;
import com.garena.reactpush.data.AssetDiff;
import com.garena.reactpush.data.BundleDiff;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ManifestDiff;
import java.io.File;
import java.io.IOException;
import java.io.SyncFailedException;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f8497a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f8498b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8499c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b f8500d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final e f8501e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f8502f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Manifest f8503g;
    /* access modifiers changed from: private */
    public Manifest h;
    private ManifestDiff i;
    /* access modifiers changed from: private */
    public com.garena.reactpush.f.f.b j;

    public a(OkHttpClient okHttpClient, String str, b bVar, e eVar, Map<String, String> map) {
        this.f8497a = okHttpClient;
        this.f8498b = str;
        this.f8499c = str.concat(c.f8353b);
        this.f8500d = bVar;
        this.f8501e = eVar;
        this.f8502f = map;
    }

    public void a(Manifest manifest, Manifest manifest2, ManifestDiff manifestDiff) {
        if (manifestDiff.isEmpty()) {
            this.f8501e.a(false);
            return;
        }
        this.f8503g = manifest;
        this.h = manifest2;
        this.i = manifestDiff;
        a();
    }

    private void a() {
        final List<BundleDiff> bundleDiffList = this.i.getBundleDiffList();
        final List<AssetDiff> assetDiffList = this.i.getAssetDiffList();
        new com.garena.reactpush.f.b.b(this.f8497a, this.f8499c, new c() {
            public void a(boolean z) {
                if (new com.garena.reactpush.f.f.c(a.this.f8503g, a.this.f8498b.concat(c.f8353b), a.this.f8498b, a.this.f8500d).a((List<BundleDiff>) bundleDiffList)) {
                    a.this.d();
                    a.this.f8501e.a(true);
                    a aVar = a.this;
                    aVar.a(assetDiffList, aVar.h.getAssetsBaseURL());
                    return;
                }
                a.this.f8501e.a((Exception) new SyncFailedException("Failed to update bundles"));
            }

            public void a(Exception exc) {
                a.this.f8501e.a(exc);
            }
        }).a(bundleDiffList);
    }

    /* access modifiers changed from: private */
    public void a(List<AssetDiff> list, String str) {
        new File(this.f8498b.concat(c.f8356e)).delete();
        AnonymousClass2 r6 = new com.garena.reactpush.f.f.b() {
            public void a(int i, int i2) {
                if (i2 == 0) {
                    a.this.b();
                }
                if (a.this.j != null) {
                    a.this.j.a(i, i2);
                }
            }
        };
        new com.garena.reactpush.f.b.a(this.f8497a, this.f8498b, new com.garena.reactpush.f.f.a(this.f8503g, this.f8500d), r6, this.f8502f).a(list, str);
    }

    /* access modifiers changed from: private */
    public void b() {
        try {
            new File(this.f8498b.concat(c.f8356e)).createNewFile();
            c();
        } catch (IOException unused) {
        }
    }

    private synchronized void c() {
        this.f8503g.update(this.h);
        this.f8500d.a(this.f8503g);
    }

    /* access modifiers changed from: private */
    public synchronized void d() {
        this.f8503g.setUpdatedTime(this.h.getManifestVersion());
        this.f8500d.a(this.f8503g);
    }
}
