package org.greenrobot.eventbus;

class a implements Runnable, l {

    /* renamed from: a  reason: collision with root package name */
    private final k f33981a = new k();

    /* renamed from: b  reason: collision with root package name */
    private final c f33982b;

    a(c cVar) {
        this.f33982b = cVar;
    }

    public void a(q qVar, Object obj) {
        this.f33981a.a(j.a(qVar, obj));
        this.f33982b.b().execute(this);
    }

    public void run() {
        j a2 = this.f33981a.a();
        if (a2 != null) {
            this.f33982b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
