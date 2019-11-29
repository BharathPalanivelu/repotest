package com.squareup.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;
import com.squareup.a.a;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class w {

    /* renamed from: a  reason: collision with root package name */
    static final Handler f7153a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                if (i == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i2 < size) {
                        c cVar = (c) list.get(i2);
                        cVar.f30536b.a(cVar);
                        i2++;
                    }
                } else if (i == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i2 < size2) {
                        a aVar = (a) list2.get(i2);
                        aVar.f30489a.c(aVar);
                        i2++;
                    }
                } else {
                    throw new AssertionError("Unknown handler message received: " + message.what);
                }
            } else {
                a aVar2 = (a) message.obj;
                if (aVar2.j().l) {
                    aj.a("Main", "canceled", aVar2.f30490b.a(), "target got garbage collected");
                }
                aVar2.f30489a.c(aVar2.d());
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static volatile w f7154b = null;

    /* renamed from: c  reason: collision with root package name */
    final Context f7155c;

    /* renamed from: d  reason: collision with root package name */
    final i f7156d;

    /* renamed from: e  reason: collision with root package name */
    final d f7157e;

    /* renamed from: f  reason: collision with root package name */
    final ad f7158f;

    /* renamed from: g  reason: collision with root package name */
    final Map<Object, a> f7159g;
    final Map<ImageView, h> h;
    final ReferenceQueue<Object> i;
    final Bitmap.Config j;
    boolean k;
    volatile boolean l;
    boolean m;
    private final c n;
    private final f o;
    private final b p;
    private final List<ab> q;

    public interface c {
        void a(w wVar, Uri uri, Exception exc);
    }

    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final f f30589a = new f() {
            public z a(z zVar) {
                return zVar;
            }
        };

        z a(z zVar);
    }

    w(Context context, i iVar, d dVar, c cVar, f fVar, List<ab> list, ad adVar, Bitmap.Config config, boolean z, boolean z2) {
        this.f7155c = context;
        this.f7156d = iVar;
        this.f7157e = dVar;
        this.n = cVar;
        this.o = fVar;
        this.j = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ac(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new f(context));
        arrayList.add(new q(context));
        arrayList.add(new g(context));
        arrayList.add(new b(context));
        arrayList.add(new l(context));
        arrayList.add(new t(iVar.f30558d, adVar));
        this.q = Collections.unmodifiableList(arrayList);
        this.f7158f = adVar;
        this.f7159g = new WeakHashMap();
        this.h = new WeakHashMap();
        this.k = z;
        this.l = z2;
        this.i = new ReferenceQueue<>();
        this.p = new b(this.i, f7153a);
        this.p.start();
    }

    public void a(ImageView imageView) {
        if (imageView != null) {
            c((Object) imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void a(af afVar) {
        if (afVar != null) {
            c((Object) afVar);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    public void a(Object obj) {
        if (obj != null) {
            this.f7156d.a(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public void b(Object obj) {
        if (obj != null) {
            this.f7156d.b(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public aa a(Uri uri) {
        return new aa(this, uri, 0);
    }

    public aa a(String str) {
        if (str == null) {
            return new aa(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public aa a(File file) {
        if (file == null) {
            return new aa(this, (Uri) null, 0);
        }
        return a(Uri.fromFile(file));
    }

    public aa a(int i2) {
        if (i2 != 0) {
            return new aa(this, (Uri) null, i2);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public void b(Uri uri) {
        if (uri != null) {
            this.f7157e.b(uri.toString());
        }
    }

    public void b(String str) {
        if (str != null) {
            b(Uri.parse(str));
        }
    }

    public void a(boolean z) {
        this.l = z;
    }

    /* access modifiers changed from: package-private */
    public List<ab> a() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public z a(z zVar) {
        z a2 = this.o.a(zVar);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("Request transformer " + this.o.getClass().getCanonicalName() + " returned null for " + zVar);
    }

    /* access modifiers changed from: package-private */
    public void a(ImageView imageView, h hVar) {
        if (this.h.containsKey(imageView)) {
            c((Object) imageView);
        }
        this.h.put(imageView, hVar);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        Object d2 = aVar.d();
        if (!(d2 == null || this.f7159g.get(d2) == aVar)) {
            c(d2);
            this.f7159g.put(d2, aVar);
        }
        b(aVar);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f7156d.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public Bitmap c(String str) {
        Bitmap a2 = this.f7157e.a(str);
        if (a2 != null) {
            this.f7158f.a();
        } else {
            this.f7158f.b();
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        a i2 = cVar.i();
        List<a> k2 = cVar.k();
        boolean z = true;
        boolean z2 = k2 != null && !k2.isEmpty();
        if (i2 == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = cVar.h().f30601d;
            Exception l2 = cVar.l();
            Bitmap e2 = cVar.e();
            d m2 = cVar.m();
            if (i2 != null) {
                a(e2, m2, i2);
            }
            if (z2) {
                int size = k2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    a(e2, m2, k2.get(i3));
                }
            }
            c cVar2 = this.n;
            if (cVar2 != null && l2 != null) {
                cVar2.a(this, uri, l2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(a aVar) {
        Bitmap c2 = r.a(aVar.f30493e) ? c(aVar.e()) : null;
        if (c2 != null) {
            a(c2, d.MEMORY, aVar);
            if (this.l) {
                String a2 = aVar.f30490b.a();
                aj.a("Main", ChatFileTransferEvent.COMPLETED, a2, "from " + d.MEMORY);
                return;
            }
            return;
        }
        a(aVar);
        if (this.l) {
            aj.a("Main", "resumed", aVar.f30490b.a());
        }
    }

    private void a(Bitmap bitmap, d dVar, a aVar) {
        if (!aVar.f()) {
            if (!aVar.g()) {
                this.f7159g.remove(aVar.d());
            }
            if (bitmap == null) {
                aVar.a();
                if (this.l) {
                    aj.a("Main", "errored", aVar.f30490b.a());
                }
            } else if (dVar != null) {
                aVar.a(bitmap, dVar);
                if (this.l) {
                    String a2 = aVar.f30490b.a();
                    aj.a("Main", ChatFileTransferEvent.COMPLETED, a2, "from " + dVar);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(Object obj) {
        aj.b();
        a remove = this.f7159g.remove(obj);
        if (remove != null) {
            remove.b();
            this.f7156d.b(remove);
        }
        if (obj instanceof ImageView) {
            h remove2 = this.h.remove((ImageView) obj);
            if (remove2 != null) {
                remove2.a();
            }
        }
    }

    private static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final ReferenceQueue<Object> f30585a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f30586b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f30585a = referenceQueue;
            this.f30586b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0477a aVar = (a.C0477a) this.f30585a.remove(1000);
                    Message obtainMessage = this.f30586b.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f30496a;
                        this.f30586b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f30586b.post(new Runnable() {
                        public void run() {
                            throw new RuntimeException(e2);
                        }
                    });
                    return;
                }
            }
        }
    }

    public static w a(Context context) {
        if (context != null) {
            if (f7154b == null) {
                synchronized (w.class) {
                    if (f7154b == null) {
                        f7154b = new a(context).a();
                    }
                }
            }
            return f7154b;
        }
        throw new IllegalArgumentException("context == null");
    }

    public static void a(w wVar) {
        if (wVar != null) {
            synchronized (w.class) {
                if (f7154b == null) {
                    f7154b = wVar;
                } else {
                    throw new IllegalStateException("Singleton instance already exists.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Picasso must not be null.");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7160a;

        /* renamed from: b  reason: collision with root package name */
        private j f7161b;

        /* renamed from: c  reason: collision with root package name */
        private ExecutorService f7162c;

        /* renamed from: d  reason: collision with root package name */
        private d f7163d;

        /* renamed from: e  reason: collision with root package name */
        private c f7164e;

        /* renamed from: f  reason: collision with root package name */
        private f f7165f;

        /* renamed from: g  reason: collision with root package name */
        private List<ab> f7166g;
        private Bitmap.Config h;
        private boolean i;
        private boolean j;

        public a(Context context) {
            if (context != null) {
                this.f7160a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public a a(d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            } else if (this.f7163d == null) {
                this.f7163d = dVar;
                return this;
            } else {
                throw new IllegalStateException("Memory cache already set.");
            }
        }

        public a a(ab abVar) {
            if (abVar != null) {
                if (this.f7166g == null) {
                    this.f7166g = new ArrayList();
                }
                if (!this.f7166g.contains(abVar)) {
                    this.f7166g.add(abVar);
                    return this;
                }
                throw new IllegalStateException("RequestHandler already registered.");
            }
            throw new IllegalArgumentException("RequestHandler must not be null.");
        }

        public w a() {
            Context context = this.f7160a;
            if (this.f7161b == null) {
                this.f7161b = aj.a(context);
            }
            if (this.f7163d == null) {
                this.f7163d = new o(context);
            }
            if (this.f7162c == null) {
                this.f7162c = new y();
            }
            if (this.f7165f == null) {
                this.f7165f = f.f30589a;
            }
            ad adVar = new ad(this.f7163d);
            Context context2 = context;
            return new w(context2, new i(context2, this.f7162c, w.f7153a, this.f7161b, this.f7163d, adVar), this.f7163d, this.f7164e, this.f7165f, this.f7166g, adVar, this.h, this.i, this.j);
        }
    }

    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        final int debugColor;

        private d(int i) {
            this.debugColor = i;
        }
    }
}
