package com.shopee.app.h.a;

import android.text.TextUtils;
import com.beetalklib.network.file.a.c;
import com.garena.android.appkit.f.f;
import com.shopee.app.application.ar;
import com.shopee.app.h.p;
import com.shopee.app.util.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f17579a = new a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<com.beetalklib.a.a.b>> f17580b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Set<String>> f17581c = new HashMap();

    public static a a() {
        return f17579a;
    }

    private a() {
    }

    /* access modifiers changed from: private */
    public synchronized void b(String str) {
        g.a().a(str);
    }

    /* access modifiers changed from: protected */
    public synchronized void a(String str, String str2) {
        Set set;
        boolean z = false;
        if (this.f17581c.containsKey(str)) {
            set = this.f17581c.get(str);
        } else {
            set = new HashSet();
            z = true;
        }
        set.add(str2);
        if (z) {
            this.f17581c.put(str, set);
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean c(String str) {
        return this.f17581c.containsKey(str);
    }

    private String d(String str) {
        if (!this.f17581c.containsKey(str)) {
            return ar.f().e().serverManager().c();
        }
        Set set = this.f17581c.get(str);
        p serverManager = ar.f().e().serverManager();
        serverManager.f();
        return serverManager.c();
    }

    /* renamed from: com.shopee.app.h.a.a$a  reason: collision with other inner class name */
    private class C0260a implements c {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f17585b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f17586c;

        private C0260a(String str) {
            this.f17585b = str;
        }

        public void a(final int i) {
            com.garena.android.appkit.d.a.e("download-fail for %s %d", this.f17585b, Integer.valueOf(i));
            if ((i == 16 || i == 34) && !a.this.c(this.f17585b)) {
                a.this.a(this.f17585b, this.f17586c);
                com.garena.android.appkit.d.a.e("download-fail engage an retry %s %d", this.f17585b, Integer.valueOf(i));
                a.this.a(this.f17585b);
                return;
            }
            synchronized (a.this.f17580b) {
                final List list = (List) a.this.f17580b.get(this.f17585b);
                if (list != null) {
                    f.a().a(new Runnable() {
                        public void run() {
                            for (com.beetalklib.a.a.b bVar : list) {
                                if (bVar instanceof d) {
                                    ((d) bVar).a(C0260a.this.f17586c);
                                }
                                bVar.onError(i);
                            }
                            list.clear();
                        }
                    });
                }
            }
        }

        public void a(final byte[] bArr) {
            com.garena.android.appkit.d.a.e("download-complete for %s", this.f17585b);
            com.garena.android.appkit.f.b.a().a(new Runnable() {
                public void run() {
                    synchronized (a.this.f17580b) {
                        List<com.beetalklib.a.a.b> list = (List) a.this.f17580b.get(C0260a.this.f17585b);
                        if (list != null) {
                            for (com.beetalklib.a.a.b onFinish : list) {
                                onFinish.onFinish(bArr, bArr.length);
                            }
                            list.clear();
                        }
                    }
                }
            });
        }
    }

    private class b implements com.beetalklib.a.a.b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f17593b;

        private b(String str) {
            this.f17593b = str;
        }

        public void onError(final int i) {
            com.garena.android.appkit.d.a.e("download-fail for %s %d", this.f17593b, Integer.valueOf(i));
            synchronized (a.this.f17580b) {
                final List list = (List) a.this.f17580b.get(this.f17593b);
                if (list != null) {
                    f.a().a(new Runnable() {
                        public void run() {
                            for (com.beetalklib.a.a.b onError : list) {
                                onError.onError(i);
                            }
                            list.clear();
                        }
                    });
                }
            }
            a.this.b(this.f17593b);
        }

        public void onFinish(final byte[] bArr, final int i) {
            com.garena.android.appkit.d.a.e("download-complete for %s", this.f17593b);
            com.garena.android.appkit.f.b.a().a(new Runnable() {
                public void run() {
                    synchronized (a.this.f17580b) {
                        List<com.beetalklib.a.a.b> list = (List) a.this.f17580b.get(b.this.f17593b);
                        if (list != null) {
                            for (com.beetalklib.a.a.b onFinish : list) {
                                onFinish.onFinish(bArr, i);
                            }
                            list.clear();
                        }
                    }
                }
            });
            a.this.b(this.f17593b);
        }
    }

    private void b(String str, final com.beetalklib.a.a.b bVar) {
        if (TextUtils.isEmpty(str)) {
            com.garena.android.appkit.f.b.a().a(new Runnable() {
                public void run() {
                    bVar.onError(1000);
                }
            });
            return;
        }
        synchronized (this.f17580b) {
            List list = this.f17580b.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f17580b.put(str, list);
            }
            list.add(bVar);
        }
        a(str);
    }

    private void b(String str, String str2, com.beetalklib.a.a.b bVar) {
        synchronized (this.f17580b) {
            List list = this.f17580b.get(str2);
            if (list == null) {
                list = new ArrayList();
                this.f17580b.put(str2, list);
            }
            list.add(bVar);
            g.a().a(str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public int a(String str) {
        C0260a aVar = new C0260a(str);
        String d2 = d(str);
        String unused = aVar.f17586c = d2;
        g.f17615a.a(d2, str, l.x.toString(), aVar);
        return 1;
    }

    /* access modifiers changed from: protected */
    public int b(String str, String str2) {
        return com.beetalklib.a.b.b.a().a(str, new b(str2));
    }

    public void a(String str, com.beetalklib.a.a.b bVar) {
        com.garena.android.appkit.d.a.e("start internal file:%s", str);
        b(str, bVar);
    }

    public void a(String str, String str2, com.beetalklib.a.a.b bVar) {
        com.garena.android.appkit.d.a.e("start download external file:%s", str2);
        b(str, str2, bVar);
    }
}
