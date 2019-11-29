package com.airbnb.lottie.f;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.a.j;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.c.f;
import java.util.List;

public class e {
    public static double a(double d2, double d3, double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i, int i2, float f2) {
        return (int) (((float) i) + (f2 * ((float) (i2 - i))));
    }

    public static boolean c(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(l lVar, Path path) {
        path.reset();
        PointF a2 = lVar.a();
        path.moveTo(a2.x, a2.y);
        PointF pointF = new PointF(a2.x, a2.y);
        for (int i = 0; i < lVar.c().size(); i++) {
            a aVar = lVar.c().get(i);
            PointF a3 = aVar.a();
            PointF b2 = aVar.b();
            PointF c2 = aVar.c();
            if (!a3.equals(pointF) || !b2.equals(c2)) {
                path.cubicTo(a3.x, a3.y, b2.x, b2.y, c2.x, c2.y);
            } else {
                path.lineTo(c2.x, c2.y);
            }
            pointF.set(c2.x, c2.y);
        }
        if (lVar.b()) {
            path.close();
        }
    }

    static int a(float f2, float f3) {
        return a((int) f2, (int) f3);
    }

    private static int a(int i, int i2) {
        return i - (i2 * b(i, i2));
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static void a(com.airbnb.lottie.c.e eVar, int i, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2, j jVar) {
        if (eVar.c(jVar.b(), i)) {
            list.add(eVar2.a(jVar.b()).a((f) jVar));
        }
    }
}
