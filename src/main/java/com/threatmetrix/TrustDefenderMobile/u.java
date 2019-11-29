package com.threatmetrix.TrustDefenderMobile;

import android.os.StatFs;
import java.lang.reflect.Method;

class u extends af {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f32615a = a(StatFs.class, "getBlockSize", new Class[0]);

    /* renamed from: b  reason: collision with root package name */
    private static final Method f32616b = a(StatFs.class, "getBlockSizeLong", new Class[0]);

    /* renamed from: c  reason: collision with root package name */
    private static final Method f32617c = a(StatFs.class, "getAvailableBlocks", new Class[0]);

    /* renamed from: d  reason: collision with root package name */
    private static final Method f32618d = a(StatFs.class, "getAvailableBlocksLong", new Class[0]);

    /* renamed from: e  reason: collision with root package name */
    private static final Method f32619e = a(StatFs.class, "getBlockCount", new Class[0]);

    /* renamed from: f  reason: collision with root package name */
    private static final Method f32620f = a(StatFs.class, "getBlockCountLong", new Class[0]);

    /* renamed from: g  reason: collision with root package name */
    private static final String f32621g = "com.threatmetrix.TrustDefenderMobile.u";
    private final StatFs h;

    public u(String str) {
        this.h = new StatFs(str);
    }

    public long a() {
        Method method = f32620f;
        if (method != null) {
            Long l = (Long) a((Object) this.h, method, new Object[0]);
            if (l != null) {
                return l.longValue();
            }
        }
        Method method2 = f32619e;
        if (method2 == null) {
            return 0;
        }
        Integer num = (Integer) a((Object) this.h, method2, new Object[0]);
        if (num != null) {
            return (long) num.intValue();
        }
        return 0;
    }

    public long b() {
        Method method = f32616b;
        if (method != null) {
            Long l = (Long) a((Object) this.h, method, new Object[0]);
            if (l != null) {
                return l.longValue();
            }
        }
        Method method2 = f32615a;
        if (method2 == null) {
            return 0;
        }
        Integer num = (Integer) a((Object) this.h, method2, new Object[0]);
        if (num != null) {
            return (long) num.intValue();
        }
        return 0;
    }

    public long c() {
        Method method = f32618d;
        if (method != null) {
            Long l = (Long) a((Object) this.h, method, new Object[0]);
            if (l != null) {
                return l.longValue();
            }
        }
        Method method2 = f32617c;
        if (method2 == null) {
            return 0;
        }
        Integer num = (Integer) a((Object) this.h, method2, new Object[0]);
        if (num != null) {
            return (long) num.intValue();
        }
        return 0;
    }
}
