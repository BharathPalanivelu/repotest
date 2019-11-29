package com.squareup.a;

import android.net.NetworkInfo;
import com.squareup.a.aj;
import com.squareup.a.w;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class y extends ThreadPoolExecutor {
    y() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new aj.d());
    }

    /* access modifiers changed from: package-private */
    public void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            a(3);
            return;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    a(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            a(3);
                            return;
                        default:
                            a(3);
                            return;
                    }
            }
            a(2);
        } else if (type == 1 || type == 6 || type == 9) {
            a(4);
        } else {
            a(3);
        }
    }

    private void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }

    private static final class a extends FutureTask<c> implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        private final c f30597a;

        public a(c cVar) {
            super(cVar, (Object) null);
            this.f30597a = cVar;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            w.e n = this.f30597a.n();
            w.e n2 = aVar.f30597a.n();
            return n == n2 ? this.f30597a.f30535a - aVar.f30597a.f30535a : n2.ordinal() - n.ordinal();
        }
    }
}
