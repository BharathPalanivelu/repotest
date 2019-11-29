package com.android.b;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<l<?>> f4607a;

    /* renamed from: b  reason: collision with root package name */
    private final f f4608b;

    /* renamed from: c  reason: collision with root package name */
    private final b f4609c;

    /* renamed from: d  reason: collision with root package name */
    private final o f4610d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f4611e = false;

    public g(BlockingQueue<l<?>> blockingQueue, f fVar, b bVar, o oVar) {
        this.f4607a = blockingQueue;
        this.f4608b = fVar;
        this.f4609c = bVar;
        this.f4610d = oVar;
    }

    public void a() {
        this.f4611e = true;
        interrupt();
    }

    @TargetApi(14)
    private void a(l<?> lVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(lVar.getTrafficStatsTag());
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                l take = this.f4607a.take();
                try {
                    take.addMarker("network-queue-take");
                    if (take.isCanceled()) {
                        take.finish("network-discard-cancelled");
                    } else {
                        a(take);
                        i a2 = this.f4608b.a(take);
                        take.addMarker("network-http-complete");
                        if (!a2.f4615d || !take.hasHadResponseDelivered()) {
                            n parseNetworkResponse = take.parseNetworkResponse(a2);
                            take.addMarker("network-parse-complete");
                            if (take.shouldCache() && parseNetworkResponse.f4627b != null) {
                                this.f4609c.a(take.getCacheKey(), parseNetworkResponse.f4627b);
                                take.addMarker("network-cache-written");
                            }
                            take.markDelivered();
                            this.f4610d.a((l<?>) take, (n<?>) parseNetworkResponse);
                        } else {
                            take.finish("not-modified");
                        }
                    }
                } catch (s e2) {
                    a(take, e2);
                } catch (Exception e3) {
                    t.a(e3, "Unhandled exception %s", e3.toString());
                    this.f4610d.a((l<?>) take, new s((Throwable) e3));
                }
            } catch (InterruptedException unused) {
                if (this.f4611e) {
                    return;
                }
            }
        }
    }

    private void a(l<?> lVar, s sVar) {
        this.f4610d.a(lVar, lVar.parseNetworkError(sVar));
    }
}
