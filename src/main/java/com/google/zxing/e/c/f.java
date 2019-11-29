package com.google.zxing.e.c;

import com.google.zxing.e.a.h;
import com.google.zxing.e.a.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private h f14698a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.zxing.e.a.f f14699b;

    /* renamed from: c  reason: collision with root package name */
    private j f14700c;

    /* renamed from: d  reason: collision with root package name */
    private int f14701d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f14702e;

    public static boolean b(int i) {
        return i >= 0 && i < 8;
    }

    public b a() {
        return this.f14702e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f14698a);
        sb.append("\n ecLevel: ");
        sb.append(this.f14699b);
        sb.append("\n version: ");
        sb.append(this.f14700c);
        sb.append("\n maskPattern: ");
        sb.append(this.f14701d);
        if (this.f14702e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f14702e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(h hVar) {
        this.f14698a = hVar;
    }

    public void a(com.google.zxing.e.a.f fVar) {
        this.f14699b = fVar;
    }

    public void a(j jVar) {
        this.f14700c = jVar;
    }

    public void a(int i) {
        this.f14701d = i;
    }

    public void a(b bVar) {
        this.f14702e = bVar;
    }
}
