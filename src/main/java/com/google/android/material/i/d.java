package com.google.android.material.i;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f13336a;

    /* renamed from: b  reason: collision with root package name */
    public float f13337b;

    /* renamed from: c  reason: collision with root package name */
    public float f13338c;

    /* renamed from: d  reason: collision with root package name */
    public float f13339d;

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f13340e;

    public static abstract class c {

        /* renamed from: g  reason: collision with root package name */
        protected final Matrix f13349g = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public void a(float f2, float f3) {
        this.f13336a = f2;
        this.f13337b = f3;
        this.f13338c = f2;
        this.f13339d = f3;
        this.f13340e.clear();
    }

    public void b(float f2, float f3) {
        b bVar = new b();
        float unused = bVar.f13347a = f2;
        float unused2 = bVar.f13348b = f3;
        this.f13340e.add(bVar);
        this.f13338c = f2;
        this.f13339d = f3;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        a aVar = new a(f2, f3, f4, f5);
        aVar.f13345e = f6;
        aVar.f13346f = f7;
        this.f13340e.add(aVar);
        double d2 = (double) (f6 + f7);
        this.f13338c = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2))));
        this.f13339d = ((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.f13340e.size();
        for (int i = 0; i < size; i++) {
            this.f13340e.get(i).a(matrix, path);
        }
    }

    public static class b extends c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public float f13347a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f13348b;

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f13349g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f13347a, this.f13348b);
            path.transform(matrix);
        }
    }

    public static class a extends c {
        private static final RectF h = new RectF();

        /* renamed from: a  reason: collision with root package name */
        public float f13341a;

        /* renamed from: b  reason: collision with root package name */
        public float f13342b;

        /* renamed from: c  reason: collision with root package name */
        public float f13343c;

        /* renamed from: d  reason: collision with root package name */
        public float f13344d;

        /* renamed from: e  reason: collision with root package name */
        public float f13345e;

        /* renamed from: f  reason: collision with root package name */
        public float f13346f;

        public a(float f2, float f3, float f4, float f5) {
            this.f13341a = f2;
            this.f13342b = f3;
            this.f13343c = f4;
            this.f13344d = f5;
        }

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f13349g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(this.f13341a, this.f13342b, this.f13343c, this.f13344d);
            path.arcTo(h, this.f13345e, this.f13346f, false);
            path.transform(matrix);
        }
    }
}
