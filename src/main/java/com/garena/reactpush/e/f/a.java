package com.garena.reactpush.e.f;

import com.garena.reactpush.c.d;
import com.garena.reactpush.d.e;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.data.ReactBundle;
import com.garena.reactpush.e.b.b;
import java.io.File;
import okhttp3.Call;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private Manifest f8464a;

    /* renamed from: b  reason: collision with root package name */
    private Manifest f8465b;

    /* renamed from: c  reason: collision with root package name */
    private com.garena.reactpush.b.b f8466c;

    /* renamed from: d  reason: collision with root package name */
    private final e f8467d;

    public a(Manifest manifest, Manifest manifest2, com.garena.reactpush.b.b bVar, e eVar) {
        this.f8464a = manifest;
        this.f8465b = manifest2;
        this.f8466c = bVar;
        this.f8467d = eVar;
    }

    public void a(ReactBundle reactBundle, File file) {
        a(reactBundle);
    }

    public void a(ReactBundle reactBundle, ReactBundle reactBundle2, File file) {
        a(reactBundle, reactBundle2);
    }

    public void a(ReactBundle reactBundle, String str, ReactAsset reactAsset, File file) {
        a(reactBundle, str, (ReactAsset) null, reactAsset);
    }

    public void a(ReactBundle reactBundle, String str, ReactAsset reactAsset, ReactAsset reactAsset2, File file) {
        a(reactBundle, str, reactAsset, reactAsset2);
    }

    public void a(Call call, Exception exc) {
        com.garena.reactpush.b.f6701d.b("Sync Failed");
        this.f8467d.a(exc);
    }

    public void a(boolean z) {
        a(this.f8465b.getManifestVersion());
        com.garena.reactpush.b.f6701d.b("Sync Complete");
        this.f8467d.a(z);
    }

    private synchronized void a(ReactBundle reactBundle) {
        d dVar = com.garena.reactpush.b.f6701d;
        dVar.b("Manifest Bundle Changed: " + reactBundle.getName() + " [" + reactBundle.getMd5() + "]");
        this.f8464a.getBundles().add(reactBundle);
        this.f8466c.a(this.f8464a);
    }

    private synchronized void a(ReactBundle reactBundle, ReactBundle reactBundle2) {
        if (reactBundle == null) {
            this.f8464a.getBundles().add(reactBundle2);
        } else {
            reactBundle.update(reactBundle2);
        }
        d dVar = com.garena.reactpush.b.f6701d;
        dVar.b("Manifest Bundle Changed: " + reactBundle2.getName() + " [" + reactBundle2.getMd5() + "]");
        this.f8466c.a(this.f8464a);
    }

    private synchronized void a(ReactBundle reactBundle, String str, ReactAsset reactAsset, ReactAsset reactAsset2) {
        if (reactAsset == null) {
            reactBundle.addAsset(str, reactAsset2);
        } else {
            reactAsset.update(reactAsset2);
        }
        d dVar = com.garena.reactpush.b.f6701d;
        dVar.b("Manifest Asset Changed: " + reactAsset2.getPath() + " [" + reactAsset2.getMd5() + "]");
        this.f8466c.a(this.f8464a);
    }

    private synchronized void a(long j) {
        this.f8464a.setUpdatedTime(j);
        this.f8466c.a(this.f8464a);
    }
}
