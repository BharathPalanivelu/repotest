package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f12024a;

    /* renamed from: b  reason: collision with root package name */
    public final long f12025b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f12026c;

    /* renamed from: d  reason: collision with root package name */
    public final String f12027d;

    /* renamed from: e  reason: collision with root package name */
    public final long f12028e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f12029f;

    /* renamed from: g  reason: collision with root package name */
    private final f f12030g;

    public abstract f d();

    public abstract d e();

    public abstract String f();

    public static g a(String str, long j, Format format, String str2, h hVar, List<d> list) {
        return a(str, j, format, str2, hVar, list, (String) null);
    }

    public static g a(String str, long j, Format format, String str2, h hVar, List<d> list, String str3) {
        h hVar2 = hVar;
        if (hVar2 instanceof h.e) {
            return new b(str, j, format, str2, (h.e) hVar2, list, str3, -1);
        } else if (hVar2 instanceof h.a) {
            return new a(str, j, format, str2, (h.a) hVar2, list);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    private g(String str, long j, Format format, String str2, h hVar, List<d> list) {
        List<d> list2;
        this.f12024a = str;
        this.f12025b = j;
        this.f12026c = format;
        this.f12027d = str2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.f12029f = list2;
        this.f12030g = hVar.a(this);
        this.f12028e = hVar.a();
    }

    public f c() {
        return this.f12030g;
    }

    public static class b extends g {

        /* renamed from: g  reason: collision with root package name */
        public final Uri f12032g;
        public final long h;
        private final String i;
        private final f j;
        private final i k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, long j2, Format format, String str2, h.e eVar, List<d> list, String str3, long j3) {
            super(str, j2, format, str2, eVar, list);
            String str4;
            String str5 = str;
            this.f12032g = Uri.parse(str2);
            this.j = eVar.b();
            i iVar = null;
            if (str3 != null) {
                str4 = str3;
            } else if (str5 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".");
                sb.append(format.f8953a);
                sb.append(".");
                long j4 = j2;
                sb.append(j2);
                str4 = sb.toString();
            } else {
                str4 = null;
            }
            this.i = str4;
            this.h = j3;
            this.k = this.j == null ? new i(new f((String) null, 0, j3)) : iVar;
        }

        public f d() {
            return this.j;
        }

        public d e() {
            return this.k;
        }

        public String f() {
            return this.i;
        }
    }

    public static class a extends g implements d {

        /* renamed from: g  reason: collision with root package name */
        private final h.a f12031g;

        public f d() {
            return null;
        }

        public d e() {
            return this;
        }

        public String f() {
            return null;
        }

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.f12031g = aVar;
        }

        public f b(int i) {
            return this.f12031g.a((g) this, i);
        }

        public int a(long j, long j2) {
            return this.f12031g.a(j, j2);
        }

        public long a(int i) {
            return this.f12031g.a(i);
        }

        public long a(int i, long j) {
            return this.f12031g.a(i, j);
        }

        public int a() {
            return this.f12031g.b();
        }

        public int a(long j) {
            return this.f12031g.a(j);
        }

        public boolean b() {
            return this.f12031g.c();
        }
    }
}
