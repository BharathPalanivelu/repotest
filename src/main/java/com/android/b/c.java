package com.android.b;

import android.os.Process;
import com.android.b.b;
import java.util.concurrent.BlockingQueue;

public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4588a = t.f4631b;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<l<?>> f4589b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<l<?>> f4590c;

    /* renamed from: d  reason: collision with root package name */
    private final b f4591d;

    /* renamed from: e  reason: collision with root package name */
    private final o f4592e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f4593f = false;

    public c(BlockingQueue<l<?>> blockingQueue, BlockingQueue<l<?>> blockingQueue2, b bVar, o oVar) {
        this.f4589b = blockingQueue;
        this.f4590c = blockingQueue2;
        this.f4591d = bVar;
        this.f4592e = oVar;
    }

    public void a() {
        this.f4593f = true;
        interrupt();
    }

    public void run() {
        if (f4588a) {
            t.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f4591d.a();
        while (true) {
            try {
                final l take = this.f4589b.take();
                take.addMarker("cache-queue-take");
                if (take.isCanceled()) {
                    take.finish("cache-discard-canceled");
                } else {
                    b.a a2 = this.f4591d.a(take.getCacheKey());
                    if (a2 == null) {
                        take.addMarker("cache-miss");
                        this.f4590c.put(take);
                    } else if (a2.a()) {
                        take.addMarker("cache-hit-expired");
                        take.setCacheEntry(a2);
                        this.f4590c.put(take);
                    } else {
                        take.addMarker("cache-hit");
                        n parseNetworkResponse = take.parseNetworkResponse(new i(a2.f4582a, a2.f4587f));
                        take.addMarker("cache-hit-parsed");
                        if (!a2.b()) {
                            this.f4592e.a((l<?>) take, (n<?>) parseNetworkResponse);
                        } else {
                            take.addMarker("cache-hit-refresh-needed");
                            take.setCacheEntry(a2);
                            parseNetworkResponse.f4629d = true;
                            this.f4592e.a(take, parseNetworkResponse, new Runnable() {
                                public void run() {
                                    try {
                                        c.this.f4590c.put(take);
                                    } catch (InterruptedException unused) {
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.f4593f) {
                    return;
                }
            }
        }
    }
}
