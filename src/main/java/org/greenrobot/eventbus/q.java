package org.greenrobot.eventbus;

final class q {

    /* renamed from: a  reason: collision with root package name */
    final Object f34045a;

    /* renamed from: b  reason: collision with root package name */
    final o f34046b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f34047c = true;

    q(Object obj, o oVar) {
        this.f34045a = obj;
        this.f34046b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f34045a != qVar.f34045a || !this.f34046b.equals(qVar.f34046b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f34045a.hashCode() + this.f34046b.f34032f.hashCode();
    }
}
