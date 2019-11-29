package com.garena.videolib.uploader;

import com.garena.videolib.a.a;
import com.garena.videolib.a.c;
import okhttp3.OkHttpClient;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final c f8730a;

    /* renamed from: b  reason: collision with root package name */
    private final a f8731b;

    /* renamed from: c  reason: collision with root package name */
    private final OkHttpClient f8732c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.a.f f8733d;

    public f(OkHttpClient okHttpClient, com.google.a.f fVar, c cVar, a aVar) {
        this.f8732c = okHttpClient;
        this.f8733d = fVar;
        this.f8730a = cVar;
        this.f8731b = aVar;
    }

    public void a(d dVar) {
        new a(this.f8732c, this.f8733d, this.f8730a, this.f8731b, dVar).a();
    }

    public void a(String str, b bVar) {
        new c(this.f8730a, this.f8731b, str, bVar, this.f8732c, this.f8733d).a();
    }
}
