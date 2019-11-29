package com.garena.sticker.e;

import android.text.TextUtils;
import com.garena.sticker.d.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8687a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8688b;

    /* renamed from: c  reason: collision with root package name */
    private String f8689c;

    /* renamed from: d  reason: collision with root package name */
    private String f8690d;

    /* renamed from: e  reason: collision with root package name */
    private String f8691e;

    public b(String str, String str2, String str3, String str4, String str5) {
        this.f8687a = str;
        this.f8688b = str2;
        this.f8689c = str3;
        this.f8690d = str4;
        this.f8691e = str5;
    }

    public String a() {
        return a.a(this.f8688b, this.f8687a, a.a(1.0f), this.f8689c);
    }

    public String b() {
        return this.f8690d;
    }

    public String c() {
        return this.f8688b;
    }

    public String d() {
        return this.f8687a;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f8690d);
    }

    public String f() {
        return this.f8689c;
    }
}
