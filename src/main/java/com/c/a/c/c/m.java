package com.c.a.c.c;

import com.c.a.i.e;
import com.c.a.i.i;
import java.util.Queue;

public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final e<a<A>, B> f5943a;

    public m() {
        this(250);
    }

    public m(int i) {
        this.f5943a = new e<a<A>, B>(i) {
            /* access modifiers changed from: protected */
            public void a(a<A> aVar, B b2) {
                aVar.a();
            }
        };
    }

    public B a(A a2, int i, int i2) {
        a a3 = a.a(a2, i, i2);
        B b2 = this.f5943a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f5943a.b(a.a(a2, i, i2), b2);
    }

    static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<a<?>> f5945a = i.a(0);

        /* renamed from: b  reason: collision with root package name */
        private int f5946b;

        /* renamed from: c  reason: collision with root package name */
        private int f5947c;

        /* renamed from: d  reason: collision with root package name */
        private A f5948d;

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> poll;
            synchronized (f5945a) {
                poll = f5945a.poll();
            }
            if (poll == null) {
                poll = new a<>();
            }
            poll.b(a2, i, i2);
            return poll;
        }

        private a() {
        }

        private void b(A a2, int i, int i2) {
            this.f5948d = a2;
            this.f5947c = i;
            this.f5946b = i2;
        }

        public void a() {
            synchronized (f5945a) {
                f5945a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5947c == aVar.f5947c && this.f5946b == aVar.f5946b && this.f5948d.equals(aVar.f5948d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f5946b * 31) + this.f5947c) * 31) + this.f5948d.hashCode();
        }
    }
}
