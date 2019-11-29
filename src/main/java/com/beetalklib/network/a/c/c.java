package com.beetalklib.network.a.c;

import android.util.SparseArray;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f5492a;

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<a> f5493b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<b> f5494c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private e f5495d = new e();

    /* renamed from: e  reason: collision with root package name */
    private ScheduledThreadPoolExecutor f5496e = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("data-handler-" + System.currentTimeMillis());
            thread.setPriority(9);
            return thread;
        }
    });

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<d> f5497f = new SparseArray<>(100);

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, Integer> f5498g = new HashMap<>();
    private AtomicInteger h = new AtomicInteger(0);

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f5492a == null) {
                f5492a = new c();
            }
            cVar = f5492a;
        }
        return cVar;
    }

    private c() {
    }

    public void a(a aVar) {
        int a2 = aVar.a();
        if (this.f5493b.get(a2) != null) {
            com.beetalklib.network.c.a.a(String.format("Error for register:%d", new Object[]{Integer.valueOf(a2)}), new Object[0]);
        }
        com.beetalklib.network.c.a.b("Register command:%d", Integer.valueOf(a2));
        this.f5493b.put(a2, aVar);
    }

    public void a(b bVar) {
        int b2 = bVar.b();
        if (this.f5494c.get(b2) != null) {
            com.beetalklib.network.c.a.a(String.format("Error for register:%d", new Object[]{Integer.valueOf(b2)}), new Object[0]);
        }
        com.beetalklib.network.c.a.b("Register command:%d", Integer.valueOf(b2));
        this.f5494c.put(b2, bVar);
    }

    public void a(int i, final byte[] bArr, final int i2) {
        final a aVar = this.f5493b.get(i);
        if (aVar == null) {
            final f a2 = this.f5495d.a(i);
            if (a2 == null) {
                com.beetalklib.network.c.a.a("No processor for command:%d", Integer.valueOf(i));
            } else if (bArr != null && bArr.length != 0) {
                com.beetalklib.network.c.a.b("Dispatch to sub-command:%d", Integer.valueOf(i));
                this.f5496e.execute(new Runnable() {
                    public void run() {
                        a2.a(bArr, i2);
                    }
                });
            }
        } else {
            com.beetalklib.network.c.a.b("Handle command:%d", Integer.valueOf(i));
            this.f5496e.execute(new Runnable() {
                public void run() {
                    aVar.a(bArr, i2);
                }
            });
        }
    }

    public void b(int i, final byte[] bArr, final int i2) {
        final b bVar = this.f5494c.get(i);
        this.f5496e.execute(new Runnable() {
            public void run() {
                bVar.b(bArr, i2);
            }
        });
    }

    private void a(int i) {
        d dVar = this.f5497f.get(i);
        if (dVar != null) {
            com.beetalklib.network.c.a.b("receipt ack with success %d", Integer.valueOf(i));
            dVar.f5516a.f5512a = true;
            this.f5496e.remove(dVar.f5516a);
            this.f5497f.remove(i);
        }
    }

    public void a(String str) {
        com.beetalklib.network.c.a.b("receipt ack with request ID %s", str);
        if (this.f5498g.containsKey(str)) {
            int intValue = this.f5498g.get(str).intValue();
            this.f5498g.remove(str);
            com.beetalklib.network.c.a.b("receipt ack with request ID to receipt %s %d", str, Integer.valueOf(intValue));
            a(intValue);
        }
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f5512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f5513b;

        /* renamed from: c  reason: collision with root package name */
        private com.beetalklib.network.a.b.a f5514c;

        /* renamed from: d  reason: collision with root package name */
        private String f5515d;

        public void run() {
            if (!this.f5512a) {
                String str = this.f5515d;
                if (str != null) {
                    try {
                        byte[] bytes = str.getBytes("UTF-8");
                        c.a().b(this.f5514c.a(), bytes, bytes.length);
                        this.f5513b.a(this.f5515d);
                    } catch (UnsupportedEncodingException e2) {
                        com.beetalklib.network.c.a.a(e2);
                    }
                } else {
                    c.a().b(this.f5514c.a(), (byte[]) null, 0);
                }
            }
        }
    }
}
