package com.bca.xco.widget.d.a.a;

public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected final String f4771a;

    /* access modifiers changed from: protected */
    public abstract void a();

    public b(String str, Object... objArr) {
        this.f4771a = c.a(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f4771a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
