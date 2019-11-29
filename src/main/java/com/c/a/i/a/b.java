package com.c.a.i.a;

public abstract class b {
    /* access modifiers changed from: package-private */
    public abstract void a(boolean z);

    public abstract void b();

    public static b a() {
        return new a();
    }

    private b() {
    }

    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f6242a;

        a() {
            super();
        }

        public void b() {
            if (this.f6242a) {
                throw new IllegalStateException("Already released");
            }
        }

        public void a(boolean z) {
            this.f6242a = z;
        }
    }
}
