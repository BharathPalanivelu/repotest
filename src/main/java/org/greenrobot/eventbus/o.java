package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class o {

    /* renamed from: a  reason: collision with root package name */
    final Method f34027a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f34028b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f34029c;

    /* renamed from: d  reason: collision with root package name */
    final int f34030d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f34031e;

    /* renamed from: f  reason: collision with root package name */
    String f34032f;

    public o(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f34027a = method;
        this.f34028b = threadMode;
        this.f34029c = cls;
        this.f34030d = i;
        this.f34031e = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f34032f.equals(oVar.f34032f);
    }

    private synchronized void a() {
        if (this.f34032f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f34027a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f34027a.getName());
            sb.append('(');
            sb.append(this.f34029c.getName());
            this.f34032f = sb.toString();
        }
    }

    public int hashCode() {
        return this.f34027a.hashCode();
    }
}
