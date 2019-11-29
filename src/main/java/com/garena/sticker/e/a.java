package com.garena.sticker.e;

import java.util.List;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f8682a;

    /* renamed from: b  reason: collision with root package name */
    private String f8683b;

    /* renamed from: c  reason: collision with root package name */
    private List<b> f8684c;

    /* renamed from: d  reason: collision with root package name */
    private long f8685d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8686e;

    public a(String str, List<b> list, long j, boolean z, String str2) {
        this.f8683b = str;
        this.f8685d = j;
        this.f8682a = str2;
        this.f8686e = z;
        this.f8684c = list;
    }

    public String a() {
        return com.garena.sticker.d.a.a(this.f8683b, this.f8682a);
    }

    public String b() {
        return com.garena.sticker.d.a.b(this.f8683b, this.f8682a);
    }

    public List<b> c() {
        return this.f8684c;
    }

    public String d() {
        return this.f8683b;
    }

    public String e() {
        return String.format(Locale.ENGLISH, "%.1f", new Object[]{Float.valueOf((((float) this.f8685d) * 1.0f) / 1048576.0f)});
    }

    public boolean f() {
        return this.f8686e;
    }
}
