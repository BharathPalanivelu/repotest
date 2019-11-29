package com.modiface.mfemakeupkit.a;

import com.modiface.mfemakeupkit.a.j;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j.b f15199a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f15200b;

    d(j jVar, j.b bVar) {
        this.f15200b = jVar;
        this.f15199a = bVar;
    }

    public void run() {
        this.f15200b.j.f();
        j.b bVar = this.f15199a;
        if (bVar != null) {
            bVar.a();
        }
    }
}
