package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

final class j {

    /* renamed from: d  reason: collision with root package name */
    private static final List<j> f34017d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f34018a;

    /* renamed from: b  reason: collision with root package name */
    q f34019b;

    /* renamed from: c  reason: collision with root package name */
    j f34020c;

    private j(Object obj, q qVar) {
        this.f34018a = obj;
        this.f34019b = qVar;
    }

    static j a(q qVar, Object obj) {
        synchronized (f34017d) {
            int size = f34017d.size();
            if (size <= 0) {
                return new j(obj, qVar);
            }
            j remove = f34017d.remove(size - 1);
            remove.f34018a = obj;
            remove.f34019b = qVar;
            remove.f34020c = null;
            return remove;
        }
    }

    static void a(j jVar) {
        jVar.f34018a = null;
        jVar.f34019b = null;
        jVar.f34020c = null;
        synchronized (f34017d) {
            if (f34017d.size() < 10000) {
                f34017d.add(jVar);
            }
        }
    }
}
