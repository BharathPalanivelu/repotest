package com.c.a.c.b.b;

import com.c.a.i.h;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f5725a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f5726b = new b();

    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f5725a.get(str);
            if (aVar == null) {
                aVar = this.f5726b.a();
                this.f5725a.put(str, aVar);
            }
            aVar.f5728b++;
        }
        aVar.f5727a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) h.a(this.f5725a.get(str));
            if (aVar.f5728b >= 1) {
                aVar.f5728b--;
                if (aVar.f5728b == 0) {
                    a remove = this.f5725a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f5726b.a(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f5728b);
            }
        }
        aVar.f5727a.unlock();
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f5727a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f5728b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f5729a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public a a() {
            a poll;
            synchronized (this.f5729a) {
                poll = this.f5729a.poll();
            }
            return poll == null ? new a() : poll;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            synchronized (this.f5729a) {
                if (this.f5729a.size() < 10) {
                    this.f5729a.offer(aVar);
                }
            }
        }
    }
}
