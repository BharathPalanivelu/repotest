package com.modiface.mfemakeupkit.video;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f15426a;

    g(j jVar) {
        this.f15426a = jVar;
    }

    public void run() {
        this.f15426a.f15432d.b().removeMessages(52);
        this.f15426a.f15432d.b().removeMessages(51);
        this.f15426a.j();
        this.f15426a.h();
        Long unused = this.f15426a.l = Long.valueOf(System.nanoTime());
    }
}
