package com.shopee.arcatch.page.cameraview.common;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class GraphicOverlay extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Object f26965a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f26966b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private int f26967c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f26968d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f26969e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f26970f = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f26971g = 0;

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public <T extends a> T a(String str) {
        for (int i = 0; i < this.f26966b.size(); i++) {
            T t = (a) this.f26966b.get(i);
            if (t != null && t.b().equals(str)) {
                return t;
            }
        }
        return null;
    }

    public void a() {
        synchronized (this.f26965a) {
            this.f26966b.clear();
        }
        postInvalidate();
    }

    public void a(a aVar) {
        synchronized (this.f26965a) {
            this.f26966b.add(aVar);
        }
    }

    public void a(int i, int i2, int i3) {
        synchronized (this.f26965a) {
            this.f26967c = i;
            this.f26969e = i2;
            this.f26971g = i3;
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.f26965a) {
            if (!(this.f26967c == 0 || this.f26969e == 0)) {
                this.f26968d = ((float) canvas.getWidth()) / ((float) this.f26967c);
                this.f26970f = ((float) canvas.getHeight()) / ((float) this.f26969e);
            }
            for (a a2 : this.f26966b) {
                a2.a(canvas);
            }
        }
    }

    public float a(float f2) {
        if (this.f26971g == 1) {
            return ((float) getWidth()) - (f2 * this.f26968d);
        }
        return f2 * this.f26968d;
    }

    public float b(float f2) {
        return f2 * this.f26970f;
    }

    public float c(float f2) {
        return f2 * this.f26968d;
    }

    public float d(float f2) {
        return f2 * this.f26970f;
    }

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private GraphicOverlay f26972a;

        public abstract void a(Canvas canvas);

        public abstract String b();

        public a(GraphicOverlay graphicOverlay) {
            this.f26972a = graphicOverlay;
        }

        public float a(float f2) {
            return f2 * this.f26972a.f26968d;
        }

        public float b(float f2) {
            return f2 * this.f26972a.f26970f;
        }

        public float c(float f2) {
            if (this.f26972a.f26971g == 1) {
                return ((float) this.f26972a.getWidth()) - a(f2);
            }
            return a(f2);
        }

        public float d(float f2) {
            return b(f2);
        }
    }
}
