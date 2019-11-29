package com.squareup.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.internal.ServerProtocol;
import com.squareup.a.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class i {

    /* renamed from: a  reason: collision with root package name */
    final b f30555a = new b();

    /* renamed from: b  reason: collision with root package name */
    final Context f30556b;

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f30557c;

    /* renamed from: d  reason: collision with root package name */
    final j f30558d;

    /* renamed from: e  reason: collision with root package name */
    final Map<String, c> f30559e;

    /* renamed from: f  reason: collision with root package name */
    final Map<Object, a> f30560f;

    /* renamed from: g  reason: collision with root package name */
    final Map<Object, a> f30561g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final d k;
    final ad l;
    final List<c> m;
    final c n;
    final boolean o;
    boolean p;

    i(Context context, ExecutorService executorService, Handler handler, j jVar, d dVar, ad adVar) {
        this.f30555a.start();
        aj.a(this.f30555a.getLooper());
        this.f30556b = context;
        this.f30557c = executorService;
        this.f30559e = new LinkedHashMap();
        this.f30560f = new WeakHashMap();
        this.f30561g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new a(this.f30555a.getLooper(), this);
        this.f30558d = jVar;
        this.j = handler;
        this.k = dVar;
        this.l = adVar;
        this.m = new ArrayList(4);
        this.p = aj.d(this.f30556b);
        this.o = aj.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new c(this);
        this.n.a();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(11, obj));
    }

    /* access modifiers changed from: package-private */
    public void b(Object obj) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(12, obj));
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    /* access modifiers changed from: package-private */
    public void b(c cVar) {
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(5, cVar), 500);
    }

    /* access modifiers changed from: package-private */
    public void c(c cVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    /* access modifiers changed from: package-private */
    public void a(NetworkInfo networkInfo) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* access modifiers changed from: package-private */
    public void c(a aVar) {
        a(aVar, true);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, boolean z) {
        if (this.h.contains(aVar.l())) {
            this.f30561g.put(aVar.d(), aVar);
            if (aVar.j().l) {
                String a2 = aVar.f30490b.a();
                aj.a("Dispatcher", "paused", a2, "because tag '" + aVar.l() + "' is paused");
                return;
            }
            return;
        }
        c cVar = this.f30559e.get(aVar.e());
        if (cVar != null) {
            cVar.a(aVar);
        } else if (!this.f30557c.isShutdown()) {
            c a3 = c.a(aVar.j(), this, this.k, this.l, aVar);
            a3.n = this.f30557c.submit(a3);
            this.f30559e.put(aVar.e(), a3);
            if (z) {
                this.f30560f.remove(aVar.d());
            }
            if (aVar.j().l) {
                aj.a("Dispatcher", "enqueued", aVar.f30490b.a());
            }
        } else if (aVar.j().l) {
            aj.a("Dispatcher", "ignored", aVar.f30490b.a(), "because shut down");
        }
    }

    /* access modifiers changed from: package-private */
    public void d(a aVar) {
        String e2 = aVar.e();
        c cVar = this.f30559e.get(e2);
        if (cVar != null) {
            cVar.b(aVar);
            if (cVar.b()) {
                this.f30559e.remove(e2);
                if (aVar.j().l) {
                    aj.a("Dispatcher", "canceled", aVar.c().a());
                }
            }
        }
        if (this.h.contains(aVar.l())) {
            this.f30561g.remove(aVar.d());
            if (aVar.j().l) {
                aj.a("Dispatcher", "canceled", aVar.c().a(), "because paused request got canceled");
            }
        }
        a remove = this.f30560f.remove(aVar.d());
        if (remove != null && remove.j().l) {
            aj.a("Dispatcher", "canceled", remove.c().a(), "from replaying");
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Object obj) {
        if (this.h.add(obj)) {
            Iterator<c> it = this.f30559e.values().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean z = next.j().l;
                a i2 = next.i();
                List<a> k2 = next.k();
                boolean z2 = k2 != null && !k2.isEmpty();
                if (i2 != null || z2) {
                    if (i2 != null && i2.l().equals(obj)) {
                        next.b(i2);
                        this.f30561g.put(i2.d(), i2);
                        if (z) {
                            aj.a("Dispatcher", "paused", i2.f30490b.a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = k2.size() - 1; size >= 0; size--) {
                            a aVar = k2.get(size);
                            if (aVar.l().equals(obj)) {
                                next.b(aVar);
                                this.f30561g.put(aVar.d(), aVar);
                                if (z) {
                                    aj.a("Dispatcher", "paused", aVar.f30490b.a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.b()) {
                        it.remove();
                        if (z) {
                            aj.a("Dispatcher", "canceled", aj.a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Object obj) {
        if (this.h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<a> it = this.f30561g.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.l().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(c cVar) {
        if (!cVar.c()) {
            boolean z = false;
            if (this.f30557c.isShutdown()) {
                a(cVar, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.o) {
                networkInfo = ((ConnectivityManager) aj.a(this.f30556b, "connectivity")).getActiveNetworkInfo();
            }
            if (cVar.a(this.p, networkInfo)) {
                if (cVar.j().l) {
                    aj.a("Dispatcher", "retrying", aj.a(cVar));
                }
                if (cVar.l() instanceof t.a) {
                    cVar.i |= s.NO_CACHE.index;
                }
                cVar.n = this.f30557c.submit(cVar);
                return;
            }
            if (this.o && cVar.d()) {
                z = true;
            }
            a(cVar, z);
            if (z) {
                f(cVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(c cVar) {
        if (r.b(cVar.g())) {
            this.k.a(cVar.f(), cVar.e());
        }
        this.f30559e.remove(cVar.f());
        g(cVar);
        if (cVar.j().l) {
            aj.a("Dispatcher", "batched", aj.a(cVar), "for completion");
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        a((List<c>) arrayList);
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar, boolean z) {
        if (cVar.j().l) {
            String a2 = aj.a(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            aj.a("Dispatcher", "batched", a2, sb.toString());
        }
        this.f30559e.remove(cVar.f());
        g(cVar);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        this.p = z;
    }

    /* access modifiers changed from: package-private */
    public void b(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f30557c;
        if (executorService instanceof y) {
            ((y) executorService).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            b();
        }
    }

    private void b() {
        if (!this.f30560f.isEmpty()) {
            Iterator<a> it = this.f30560f.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                it.remove();
                if (next.j().l) {
                    aj.a("Dispatcher", "replaying", next.c().a());
                }
                a(next, false);
            }
        }
    }

    private void f(c cVar) {
        a i2 = cVar.i();
        if (i2 != null) {
            e(i2);
        }
        List<a> k2 = cVar.k();
        if (k2 != null) {
            int size = k2.size();
            for (int i3 = 0; i3 < size; i3++) {
                e(k2.get(i3));
            }
        }
    }

    private void e(a aVar) {
        Object d2 = aVar.d();
        if (d2 != null) {
            aVar.k = true;
            this.f30560f.put(d2, aVar);
        }
    }

    private void g(c cVar) {
        if (!cVar.c()) {
            this.m.add(cVar);
            if (!this.i.hasMessages(7)) {
                this.i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void a(List<c> list) {
        if (list != null && !list.isEmpty() && list.get(0).j().l) {
            StringBuilder sb = new StringBuilder();
            for (c next : list) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(aj.a(next));
            }
            aj.a("Dispatcher", "delivered", sb.toString());
        }
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final i f30562a;

        public a(Looper looper, i iVar) {
            super(looper);
            this.f30562a = iVar;
        }

        public void handleMessage(final Message message) {
            boolean z = false;
            switch (message.what) {
                case 1:
                    this.f30562a.c((a) message.obj);
                    return;
                case 2:
                    this.f30562a.d((a) message.obj);
                    return;
                case 4:
                    this.f30562a.e((c) message.obj);
                    return;
                case 5:
                    this.f30562a.d((c) message.obj);
                    return;
                case 6:
                    this.f30562a.a((c) message.obj, false);
                    return;
                case 7:
                    this.f30562a.a();
                    return;
                case 9:
                    this.f30562a.b((NetworkInfo) message.obj);
                    return;
                case 10:
                    i iVar = this.f30562a;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    iVar.b(z);
                    return;
                case 11:
                    this.f30562a.c(message.obj);
                    return;
                case 12:
                    this.f30562a.d(message.obj);
                    return;
                default:
                    w.f7153a.post(new Runnable() {
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    return;
            }
        }
    }

    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final i f30565a;

        c(i iVar) {
            this.f30565a = iVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f30565a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f30565a.f30556b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra(ServerProtocol.DIALOG_PARAM_STATE)) {
                        this.f30565a.a(intent.getBooleanExtra(ServerProtocol.DIALOG_PARAM_STATE, false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f30565a.a(((ConnectivityManager) aj.a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }
}
