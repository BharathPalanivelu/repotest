package com.shopee.app.h;

import android.util.SparseArray;
import com.beetalklib.network.a.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.c;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class h {

    /* renamed from: d  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f17650d;

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<a> f17651a = new SparseArray<>(100);

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, Integer> f17652b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f17653c = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private String f17654e;

    public h(String str) {
        this.f17654e = str;
        if (f17650d == null) {
            f17650d = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("timeout-handler-" + System.currentTimeMillis());
                    thread.setPriority(8);
                    return thread;
                }
            });
        }
    }

    public int a(com.beetalklib.network.a.b.a aVar, String str) {
        b bVar = new b(aVar, str, this.f17654e);
        if (aVar.c() == a.C0096a.REQUEST_NO_RESPONSE) {
            return -1;
        }
        if (this.f17652b.containsKey(str)) {
            return this.f17652b.get(str).intValue();
        }
        int incrementAndGet = this.f17653c.incrementAndGet();
        this.f17651a.append(incrementAndGet, new a(bVar));
        if (str != null) {
            this.f17652b.put(str, Integer.valueOf(incrementAndGet));
        }
        f17650d.schedule(bVar, aVar.b(), TimeUnit.MILLISECONDS);
        com.beetalklib.network.c.a.b("receipt add with success %d", Integer.valueOf(incrementAndGet));
        return incrementAndGet;
    }

    public void a(String str) {
        com.beetalklib.network.c.a.b("receipt ack with request ID %s", str);
        if (this.f17652b.containsKey(str)) {
            int intValue = this.f17652b.get(str).intValue();
            this.f17652b.remove(str);
            com.beetalklib.network.c.a.b("receipt ack with request ID to receipt %s %d", str, Integer.valueOf(intValue));
            a(intValue);
        }
    }

    private void a(int i) {
        a aVar = this.f17651a.get(i);
        if (aVar != null) {
            com.beetalklib.network.c.a.b("receipt ack with success %d", Integer.valueOf(i));
            aVar.f17656a.f17657a = true;
            f17650d.remove(aVar.f17656a);
            this.f17651a.remove(i);
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f17657a;

        /* renamed from: c  reason: collision with root package name */
        private com.beetalklib.network.a.b.a f17659c;

        /* renamed from: d  reason: collision with root package name */
        private String f17660d;

        /* renamed from: e  reason: collision with root package name */
        private String f17661e;

        private b(com.beetalklib.network.a.b.a aVar, String str, String str2) {
            this.f17659c = aVar;
            this.f17660d = str;
            this.f17661e = str2;
            this.f17657a = false;
        }

        public void run() {
            if (!this.f17657a) {
                String str = this.f17660d;
                if (str != null) {
                    com.garena.android.appkit.b.b.a(this.f17661e, (com.garena.android.appkit.b.a) new n(str, new c(this.f17659c.a())), b.a.NETWORK_BUS);
                    h.this.a(this.f17660d);
                }
            }
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        protected b f17656a;

        protected a(b bVar) {
            this.f17656a = bVar;
        }
    }
}
