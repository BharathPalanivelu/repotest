package com.garena.videolib.a;

import java.io.File;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f8697a;

    /* renamed from: b  reason: collision with root package name */
    private File f8698b;

    /* renamed from: c  reason: collision with root package name */
    private String f8699c;

    /* renamed from: d  reason: collision with root package name */
    private String f8700d;

    /* renamed from: e  reason: collision with root package name */
    private long f8701e;

    public c(String str) {
        File file = new File(str);
        this.f8698b = file;
        this.f8699c = String.valueOf(file.length());
        this.f8697a = file.getName();
        this.f8700d = str;
    }

    public File a() {
        return this.f8698b;
    }

    public String b() {
        return this.f8699c;
    }

    public String c() {
        return this.f8700d;
    }

    public long d() {
        return this.f8701e;
    }

    public void a(long j) {
        this.f8701e = j;
    }
}
