package com.otaliastudios.cameraview;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

class q {

    /* renamed from: a  reason: collision with root package name */
    private int f15668a;

    /* renamed from: b  reason: collision with root package name */
    private int f15669b = -1;

    /* renamed from: c  reason: collision with root package name */
    private a f15670c;

    /* renamed from: d  reason: collision with root package name */
    private LinkedBlockingQueue<p> f15671d = new LinkedBlockingQueue<>(this.f15668a);

    interface a {
        void a(byte[] bArr);
    }

    q(int i, a aVar) {
        this.f15668a = i;
        this.f15670c = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Iterator<p> it = this.f15671d.iterator();
        while (it.hasNext()) {
            p next = it.next();
            next.b();
            next.a();
        }
        this.f15671d.clear();
        this.f15669b = -1;
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar) {
        byte[] c2 = pVar.c();
        if (!this.f15671d.offer(pVar)) {
            pVar.b();
        }
        if (c2 != null) {
            a aVar = this.f15670c;
            if (aVar != null && c2.length == this.f15669b) {
                aVar.a(c2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public p a(byte[] bArr, long j, int i, af afVar, int i2) {
        p poll = this.f15671d.poll();
        if (poll == null) {
            poll = new p(this);
        }
        poll.a(bArr, j, i, afVar, i2);
        return poll;
    }

    /* access modifiers changed from: package-private */
    public int a(int i, af afVar) {
        this.f15669b = b(i, afVar);
        for (int i2 = 0; i2 < this.f15668a; i2++) {
            this.f15670c.a(new byte[this.f15669b]);
        }
        return this.f15669b;
    }

    private int b(int i, af afVar) {
        double b2 = (double) ((long) (afVar.b() * afVar.a() * i));
        Double.isNaN(b2);
        return (int) Math.ceil(b2 / 8.0d);
    }
}
