package org.greenrobot.eventbus;

final class k {

    /* renamed from: a  reason: collision with root package name */
    private j f34021a;

    /* renamed from: b  reason: collision with root package name */
    private j f34022b;

    k() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(j jVar) {
        if (jVar != null) {
            try {
                if (this.f34022b != null) {
                    this.f34022b.f34020c = jVar;
                    this.f34022b = jVar;
                } else if (this.f34021a == null) {
                    this.f34022b = jVar;
                    this.f34021a = jVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized j a() {
        j jVar;
        jVar = this.f34021a;
        if (this.f34021a != null) {
            this.f34021a = this.f34021a.f34020c;
            if (this.f34021a == null) {
                this.f34022b = null;
            }
        }
        return jVar;
    }

    /* access modifiers changed from: package-private */
    public synchronized j a(int i) throws InterruptedException {
        if (this.f34021a == null) {
            wait((long) i);
        }
        return a();
    }
}
