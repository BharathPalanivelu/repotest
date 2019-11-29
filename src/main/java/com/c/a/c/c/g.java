package com.c.a.c.c;

import android.net.Uri;
import android.text.TextUtils;
import com.c.a.c.h;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class g implements h {

    /* renamed from: b  reason: collision with root package name */
    private final h f5922b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f5923c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5924d;

    /* renamed from: e  reason: collision with root package name */
    private String f5925e;

    /* renamed from: f  reason: collision with root package name */
    private URL f5926f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f5927g;
    private int h;

    public g(URL url) {
        this(url, h.f5929b);
    }

    public g(String str) {
        this(str, h.f5929b);
    }

    public g(URL url, h hVar) {
        this.f5923c = (URL) com.c.a.i.h.a(url);
        this.f5924d = null;
        this.f5922b = (h) com.c.a.i.h.a(hVar);
    }

    public g(String str, h hVar) {
        this.f5923c = null;
        this.f5924d = com.c.a.i.h.a(str);
        this.f5922b = (h) com.c.a.i.h.a(hVar);
    }

    public URL a() throws MalformedURLException {
        return d();
    }

    private URL d() throws MalformedURLException {
        if (this.f5926f == null) {
            this.f5926f = new URL(e());
        }
        return this.f5926f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f5925e)) {
            String str = this.f5924d;
            if (TextUtils.isEmpty(str)) {
                str = this.f5923c.toString();
            }
            this.f5925e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f5925e;
    }

    public Map<String, String> b() {
        return this.f5922b.a();
    }

    public String c() {
        String str = this.f5924d;
        return str != null ? str : this.f5923c.toString();
    }

    public String toString() {
        return c();
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    private byte[] f() {
        if (this.f5927g == null) {
            this.f5927g = c().getBytes(f6107a);
        }
        return this.f5927g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!c().equals(gVar.c()) || !this.f5922b.equals(gVar.f5922b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.h == 0) {
            this.h = c().hashCode();
            this.h = (this.h * 31) + this.f5922b.hashCode();
        }
        return this.h;
    }
}
