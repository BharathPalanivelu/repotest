package com.airbnb.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.b.h;
import com.airbnb.lottie.c.c;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final m f3651a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f3652b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<com.airbnb.lottie.c.c.d>> f3653c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, g> f3654d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, c> f3655e;

    /* renamed from: f  reason: collision with root package name */
    private h<com.airbnb.lottie.c.d> f3656f;

    /* renamed from: g  reason: collision with root package name */
    private androidx.b.d<com.airbnb.lottie.c.c.d> f3657g;
    private List<com.airbnb.lottie.c.c.d> h;
    private Rect i;
    private float j;
    private float k;
    private float l;

    public void a(Rect rect, float f2, float f3, float f4, List<com.airbnb.lottie.c.c.d> list, androidx.b.d<com.airbnb.lottie.c.c.d> dVar, Map<String, List<com.airbnb.lottie.c.c.d>> map, Map<String, g> map2, h<com.airbnb.lottie.c.d> hVar, Map<String, c> map3) {
        this.i = rect;
        this.j = f2;
        this.k = f3;
        this.l = f4;
        this.h = list;
        this.f3657g = dVar;
        this.f3653c = map;
        this.f3654d = map2;
        this.f3656f = hVar;
        this.f3655e = map3;
    }

    public void a(String str) {
        Log.w("LOTTIE", str);
        this.f3652b.add(str);
    }

    public void a(boolean z) {
        this.f3651a.a(z);
    }

    public m a() {
        return this.f3651a;
    }

    public com.airbnb.lottie.c.c.d a(long j2) {
        return this.f3657g.a(j2);
    }

    public Rect b() {
        return this.i;
    }

    public float c() {
        return (float) ((long) ((k() / this.l) * 1000.0f));
    }

    public float d() {
        return this.j;
    }

    public float e() {
        return this.k;
    }

    public float f() {
        return this.l;
    }

    public List<com.airbnb.lottie.c.c.d> g() {
        return this.h;
    }

    public List<com.airbnb.lottie.c.c.d> b(String str) {
        return this.f3653c.get(str);
    }

    public h<com.airbnb.lottie.c.d> h() {
        return this.f3656f;
    }

    public Map<String, c> i() {
        return this.f3655e;
    }

    public Map<String, g> j() {
        return this.f3654d;
    }

    public float k() {
        return this.k - this.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (com.airbnb.lottie.c.c.d a2 : this.h) {
            sb.append(a2.a("\t"));
        }
        return sb.toString();
    }
}
