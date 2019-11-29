package org.greenrobot.eventbus;

import android.os.Looper;

public interface h {
    l a(c cVar);

    boolean a();

    public static class a implements h {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f34014a;

        public a(Looper looper) {
            this.f34014a = looper;
        }

        public boolean a() {
            return this.f34014a == Looper.myLooper();
        }

        public l a(c cVar) {
            return new f(cVar, this.f34014a, 10);
        }
    }
}
