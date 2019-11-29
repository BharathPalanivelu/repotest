package io.a.a.a.a.a;

import android.content.Context;

public abstract class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f33049a;

    /* access modifiers changed from: protected */
    public abstract T a(Context context);

    /* access modifiers changed from: protected */
    public abstract void a(Context context, T t);

    public a(c<T> cVar) {
        this.f33049a = cVar;
    }

    public final synchronized T a(Context context, d<T> dVar) throws Exception {
        T a2;
        a2 = a(context);
        if (a2 == null) {
            a2 = this.f33049a != null ? this.f33049a.a(context, dVar) : dVar.b(context);
            b(context, a2);
        }
        return a2;
    }

    private void b(Context context, T t) {
        if (t != null) {
            a(context, t);
            return;
        }
        throw new NullPointerException();
    }
}
