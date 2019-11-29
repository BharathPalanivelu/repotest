package com.garena.reactpush.d;

import com.garena.reactpush.b.b;
import com.garena.reactpush.c.c;
import com.garena.reactpush.c.f;
import com.garena.reactpush.data.BundleState;
import com.garena.reactpush.data.Manifest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final b f8363a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8364b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8365c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public g f8366d;

    public d(b bVar, String str, String str2) {
        this.f8365c = str;
        this.f8363a = bVar;
        this.f8364b = str2;
    }

    public boolean a(InputStream inputStream, Manifest manifest) {
        boolean z;
        BundleState c2 = this.f8363a.c();
        this.f8363a.b();
        c2.setSyncLocalStarted();
        this.f8363a.a(c2);
        try {
            File file = new File(this.f8364b.concat(c.f8355d));
            File file2 = new File(this.f8364b.concat(c.f8356e));
            file.delete();
            file2.delete();
            a();
            c.a(inputStream, this.f8364b);
            b();
            file.createNewFile();
            file2.createNewFile();
            c2.setSyncLocalSuccess();
            this.f8363a.a(manifest);
            d();
            z = true;
            c();
        } catch (IOException e2) {
            c2.setSyncLocalError();
            a((Exception) e2);
            z = false;
        }
        this.f8363a.a(c2);
        return z;
    }

    private void a() {
        for (String str : new String[]{"drawable-" + this.f8365c, "strings"}) {
            String str2 = this.f8364b + str;
            String str3 = this.f8364b + str + "_bk";
            File file = new File(str2);
            if (file.exists()) {
                file.renameTo(new File(str3));
            }
        }
    }

    private void b() {
        String str = this.f8364b + "drawable-" + this.f8365c;
        File file = new File(this.f8364b + "drawable-hdpi");
        if (file.exists()) {
            file.renameTo(new File(str));
        }
    }

    private void c() {
        for (String str : new String[]{"drawable-" + this.f8365c, "strings"}) {
            c.a(this.f8364b + str + "_bk");
        }
    }

    private void d() {
        if (this.f8366d != null) {
            f.a(new Runnable() {
                public void run() {
                    if (d.this.f8366d != null) {
                        d.this.f8366d.a();
                    }
                }
            });
        }
    }

    private void a(final Exception exc) {
        if (this.f8366d != null) {
            f.a(new Runnable() {
                public void run() {
                    if (d.this.f8366d != null) {
                        d.this.f8366d.a(exc);
                    }
                }
            });
        }
    }
}
