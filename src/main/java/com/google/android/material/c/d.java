package com.google.android.material.c;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.c.c;

public interface d extends c.a {
    void a();

    void b();

    int getCircularRevealScrimColor();

    C0216d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(C0216d dVar);

    /* renamed from: com.google.android.material.c.d$d  reason: collision with other inner class name */
    public static class C0216d {

        /* renamed from: a  reason: collision with root package name */
        public float f13273a;

        /* renamed from: b  reason: collision with root package name */
        public float f13274b;

        /* renamed from: c  reason: collision with root package name */
        public float f13275c;

        private C0216d() {
        }

        public C0216d(float f2, float f3, float f4) {
            this.f13273a = f2;
            this.f13274b = f3;
            this.f13275c = f4;
        }

        public C0216d(C0216d dVar) {
            this(dVar.f13273a, dVar.f13274b, dVar.f13275c);
        }

        public void a(float f2, float f3, float f4) {
            this.f13273a = f2;
            this.f13274b = f3;
            this.f13275c = f4;
        }

        public void a(C0216d dVar) {
            a(dVar.f13273a, dVar.f13274b, dVar.f13275c);
        }

        public boolean a() {
            return this.f13275c == Float.MAX_VALUE;
        }
    }

    public static class b extends Property<d, C0216d> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, C0216d> f13271a = new b("circularReveal");

        private b(String str) {
            super(C0216d.class, str);
        }

        /* renamed from: a */
        public C0216d get(d dVar) {
            return dVar.getRevealInfo();
        }

        /* renamed from: a */
        public void set(d dVar, C0216d dVar2) {
            dVar.setRevealInfo(dVar2);
        }
    }

    public static class a implements TypeEvaluator<C0216d> {

        /* renamed from: a  reason: collision with root package name */
        public static final TypeEvaluator<C0216d> f13269a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final C0216d f13270b = new C0216d();

        /* renamed from: a */
        public C0216d evaluate(float f2, C0216d dVar, C0216d dVar2) {
            this.f13270b.a(com.google.android.material.e.a.a(dVar.f13273a, dVar2.f13273a, f2), com.google.android.material.e.a.a(dVar.f13274b, dVar2.f13274b, f2), com.google.android.material.e.a.a(dVar.f13275c, dVar2.f13275c, f2));
            return this.f13270b;
        }
    }

    public static class c extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, Integer> f13272a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        /* renamed from: a */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }
}
