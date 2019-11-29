package com.android.b;

import android.os.Handler;
import java.util.concurrent.Executor;

public class e implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f4600a;

    public e(final Handler handler) {
        this.f4600a = new Executor() {
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void a(l<?> lVar, n<?> nVar) {
        a(lVar, nVar, (Runnable) null);
    }

    public void a(l<?> lVar, n<?> nVar, Runnable runnable) {
        lVar.markDelivered();
        lVar.addMarker("post-response");
        this.f4600a.execute(new a(lVar, nVar, runnable));
    }

    public void a(l<?> lVar, s sVar) {
        lVar.addMarker("post-error");
        this.f4600a.execute(new a(lVar, n.a(sVar), (Runnable) null));
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final l f4604b;

        /* renamed from: c  reason: collision with root package name */
        private final n f4605c;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f4606d;

        public a(l lVar, n nVar, Runnable runnable) {
            this.f4604b = lVar;
            this.f4605c = nVar;
            this.f4606d = runnable;
        }

        public void run() {
            if (this.f4604b.isCanceled()) {
                this.f4604b.finish("canceled-at-delivery");
                return;
            }
            if (this.f4605c.a()) {
                this.f4604b.deliverResponse(this.f4605c.f4626a);
            } else {
                this.f4604b.deliverError(this.f4605c.f4628c);
            }
            if (this.f4605c.f4629d) {
                this.f4604b.addMarker("intermediate-response");
            } else {
                this.f4604b.finish("done");
            }
            Runnable runnable = this.f4606d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
