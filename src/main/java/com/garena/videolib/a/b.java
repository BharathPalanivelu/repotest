package com.garena.videolib.a;

import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private long f8694a;

    /* renamed from: b  reason: collision with root package name */
    private String f8695b;

    /* renamed from: c  reason: collision with root package name */
    private List<c> f8696c = new ArrayList();

    public b() {
    }

    public b(long j, String str) {
        this.f8694a = j;
        this.f8695b = str;
    }

    public String a() {
        return this.f8695b;
    }

    public List<c> b() {
        return this.f8696c;
    }

    public void a(c cVar) {
        this.f8696c.add(cVar);
    }

    public long c() {
        return this.f8694a;
    }
}
