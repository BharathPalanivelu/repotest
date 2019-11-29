package com.shopee.app.h.a;

import com.beetalklib.network.file.a.i;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.h.h;
import com.shopee.app.h.n;
import com.shopee.app.h.p;
import com.shopee.app.util.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f17601a;

    /* renamed from: b  reason: collision with root package name */
    private final p f17602b = ar.f().e().serverManager();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public h f17603c = new h("file_upload");

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f17604d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f17605e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, List<String>> f17606f = new HashMap();

    public static c a() {
        if (f17601a == null) {
            synchronized (c.class) {
                if (f17601a == null) {
                    f17601a = new c();
                }
            }
        }
        return f17601a;
    }

    private c() {
    }

    private class a implements i {

        /* renamed from: b  reason: collision with root package name */
        private String f17608b;

        private a(String str) {
            this.f17608b = str;
        }

        public void a() {
            com.garena.android.appkit.d.a.e("file-uploading onFinish for %s", this.f17608b);
            synchronized (c.this.f17606f) {
                List<String> list = (List) c.this.f17606f.get(this.f17608b);
                com.garena.android.appkit.d.a.e("remove onSuccess:" + this.f17608b, new Object[0]);
                if (list != null) {
                    com.garena.android.appkit.b.c cVar = new com.garena.android.appkit.b.c(0);
                    for (String str : list) {
                        c.this.f17603c.a(str);
                        b.a("file_upload", (com.garena.android.appkit.b.a) new n(str, cVar), b.a.NETWORK_BUS);
                    }
                    c.this.f17606f.remove(this.f17608b);
                } else {
                    com.garena.android.appkit.d.a.a("Error in removing onSuccess:" + this.f17608b, new Object[0]);
                }
            }
            c.this.a(this.f17608b, true);
        }

        public void a(int i) {
            com.garena.android.appkit.d.a.e("file-uploading onError for %s %d", this.f17608b, Integer.valueOf(i));
            synchronized (c.this.f17606f) {
                List<String> list = (List) c.this.f17606f.get(this.f17608b);
                com.garena.android.appkit.d.a.e("remove onError:" + this.f17608b, new Object[0]);
                if (list != null) {
                    com.garena.android.appkit.b.c cVar = new com.garena.android.appkit.b.c(2);
                    for (String str : list) {
                        c.this.f17603c.a(str);
                        b.a("file_upload", (com.garena.android.appkit.b.a) new n(str, cVar), b.a.NETWORK_BUS);
                    }
                    c.this.f17606f.remove(this.f17608b);
                } else {
                    com.garena.android.appkit.d.a.a("Error in removing onError:" + this.f17608b, new Object[0]);
                }
            }
            c.this.a(this.f17608b, false);
        }

        public void a(int i, int i2) {
            com.garena.android.appkit.d.a.e("file-uploading onUploading for %s %d %d", this.f17608b, Integer.valueOf(i2), Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        String remove = this.f17605e.remove(str);
        if (z) {
            this.f17604d.add(remove);
        }
    }

    public void a(String str, byte[] bArr, String str2, com.shopee.app.network.c cVar) {
        String a2 = com.shopee.app.g.c.a(bArr);
        if (this.f17604d.contains(a2)) {
            b.a("file_upload", (com.garena.android.appkit.b.a) new n(str2, new com.garena.android.appkit.b.c(0)), b.a.NETWORK_BUS);
            return;
        }
        this.f17605e.put(str, a2);
        synchronized (this.f17606f) {
            List list = this.f17606f.get(str);
            if (list == null) {
                list = new ArrayList();
                com.garena.android.appkit.d.a.e("putting file:" + str, new Object[0]);
                this.f17606f.put(str, list);
            }
            list.add(str2);
        }
        this.f17603c.a(cVar, str2);
        String str3 = str;
        byte[] bArr2 = bArr;
        g.f17615a.a(this.f17602b.c(), str3, bArr2, l.x.toString(), (i) new a(str));
    }
}
