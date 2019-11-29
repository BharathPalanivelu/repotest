package com.modiface.mfemakeupkit.video;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f15427a;

    h(j jVar) {
        this.f15427a = jVar;
    }

    public void run() {
        if (this.f15427a.j.getAndSet(false)) {
            if (this.f15427a.l != null) {
                j jVar = this.f15427a;
                long unused = jVar.k = jVar.k + Math.max(0, System.nanoTime() - this.f15427a.l.longValue());
                Long unused2 = this.f15427a.l = null;
            }
            this.f15427a.g();
            if (!this.f15427a.f15435g.e()) {
                this.f15427a.i.a(false);
            }
            if (!this.f15427a.f15432d.b().hasMessages(51)) {
                this.f15427a.f15432d.b().sendEmptyMessage(51);
            }
        }
    }
}
