package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private EdgeEffect f1912a;

    @Deprecated
    public d(Context context) {
        this.f1912a = new EdgeEffect(context);
    }

    @Deprecated
    public void a(int i, int i2) {
        this.f1912a.setSize(i, i2);
    }

    @Deprecated
    public boolean a() {
        return this.f1912a.isFinished();
    }

    @Deprecated
    public void b() {
        this.f1912a.finish();
    }

    @Deprecated
    public boolean a(float f2) {
        this.f1912a.onPull(f2);
        return true;
    }

    public static void a(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }

    @Deprecated
    public boolean c() {
        this.f1912a.onRelease();
        return this.f1912a.isFinished();
    }

    @Deprecated
    public boolean a(Canvas canvas) {
        return this.f1912a.draw(canvas);
    }
}
