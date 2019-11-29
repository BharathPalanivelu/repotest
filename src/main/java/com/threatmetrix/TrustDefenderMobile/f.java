package com.threatmetrix.TrustDefenderMobile;

import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.Method;

class f extends af {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f32571a = a(Display.class, "getWidth", new Class[0]);

    /* renamed from: b  reason: collision with root package name */
    private static final Method f32572b = a(Display.class, "getHeight", new Class[0]);

    /* renamed from: c  reason: collision with root package name */
    private static final Method f32573c = a(Display.class, "getSize", Point.class);

    /* renamed from: d  reason: collision with root package name */
    private static final String f32574d = "com.threatmetrix.TrustDefenderMobile.f";

    /* renamed from: e  reason: collision with root package name */
    private final Display f32575e;

    public f(Display display) {
        this.f32575e = display;
    }

    public int a() {
        if (f32573c != null) {
            Point point = new Point();
            a((Object) this.f32575e, f32573c, point);
            return point.x;
        }
        Method method = f32571a;
        if (method != null) {
            Integer num = (Integer) a((Object) this.f32575e, method, new Object[0]);
            if (num != null) {
                return num.intValue();
            }
        }
        Log.w(f32574d, "unable to get display width");
        return 0;
    }

    public int b() {
        if (f32573c != null) {
            Point point = new Point();
            a((Object) this.f32575e, f32573c, point);
            return point.y;
        }
        Method method = f32572b;
        if (method != null) {
            Integer num = (Integer) a((Object) this.f32575e, method, new Object[0]);
            if (num != null) {
                return num.intValue();
            }
        }
        Log.w(f32574d, "unable to get display height");
        return 0;
    }
}
