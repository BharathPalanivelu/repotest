package com.google.android.exoplayer2.source.dash.a;

import android.net.Uri;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.source.dash.a.h;
import java.util.Collections;
import java.util.List;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f11866a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11867b;

    /* renamed from: c  reason: collision with root package name */
    public final j f11868c;

    /* renamed from: d  reason: collision with root package name */
    public final String f11869d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11870e;

    /* renamed from: f  reason: collision with root package name */
    public final List<g> f11871f;

    /* renamed from: g  reason: collision with root package name */
    private final e f11872g;

    public abstract e b();

    public abstract com.google.android.exoplayer2.source.dash.j c();

    public abstract String d();

    public static f a(String str, long j, j jVar, String str2, h hVar, List<g> list) {
        return a(str, j, jVar, str2, hVar, list, (String) null);
    }

    public static f a(String str, long j, j jVar, String str2, h hVar, List<g> list, String str3) {
        h hVar2 = hVar;
        if (hVar2 instanceof h.e) {
            return new b(str, j, jVar, str2, (h.e) hVar2, list, str3, -1);
        } else if (hVar2 instanceof h.a) {
            return new a(str, j, jVar, str2, (h.a) hVar2, list);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    private f(String str, long j, j jVar, String str2, h hVar, List<g> list) {
        List<g> list2;
        this.f11866a = str;
        this.f11867b = j;
        this.f11868c = jVar;
        this.f11869d = str2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.f11871f = list2;
        this.f11872g = hVar.a(this);
        this.f11870e = hVar.a();
    }

    public e a() {
        return this.f11872g;
    }

    public static class b extends f {

        /* renamed from: g  reason: collision with root package name */
        public final Uri f11874g;
        public final long h;
        private final String i;
        private final e j;
        private final i k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, long j2, j jVar, String str2, h.e eVar, List<g> list, String str3, long j3) {
            super(str, j2, jVar, str2, eVar, list);
            String str4;
            String str5 = str;
            this.f11874g = Uri.parse(str2);
            this.j = eVar.b();
            i iVar = null;
            if (str3 != null) {
                str4 = str3;
            } else if (str5 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".");
                sb.append(jVar.f10422a);
                sb.append(".");
                long j4 = j2;
                sb.append(j2);
                str4 = sb.toString();
            } else {
                str4 = null;
            }
            this.i = str4;
            this.h = j3;
            this.k = this.j == null ? new i(new e((String) null, 0, j3)) : iVar;
        }

        public e b() {
            return this.j;
        }

        public com.google.android.exoplayer2.source.dash.j c() {
            return this.k;
        }

        public String d() {
            return this.i;
        }
    }

    public static class a extends f implements com.google.android.exoplayer2.source.dash.j {

        /* renamed from: g  reason: collision with root package name */
        private final h.a f11873g;

        public e b() {
            return null;
        }

        public com.google.android.exoplayer2.source.dash.j c() {
            return this;
        }

        public String d() {
            return null;
        }

        public a(String str, long j, j jVar, String str2, h.a aVar, List<g> list) {
            super(str, j, jVar, str2, aVar, list);
            this.f11873g = aVar;
        }

        public e a(int i) {
            return this.f11873g.a((f) this, i);
        }

        public int a(long j, long j2) {
            return this.f11873g.a(j, j2);
        }

        public long b(int i) {
            return this.f11873g.a(i);
        }

        public long a(int i, long j) {
            return this.f11873g.a(i, j);
        }

        public int e() {
            return this.f11873g.b();
        }

        public int a(long j) {
            return this.f11873g.a(j);
        }

        public boolean f() {
            return this.f11873g.c();
        }
    }
}
