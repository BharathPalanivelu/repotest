package com.airbnb.android.react.maps;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private static s f3351a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f3352b = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f3353c = new LinkedList<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f3354d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Runnable f3355e = new Runnable() {
        public void run() {
            boolean unused = s.this.f3354d = false;
            s.this.b();
            if (s.this.f3353c.size() > 0) {
                s.this.f3352b.postDelayed(s.this.f3355e, 40);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final long f3356f = 40;

    /* renamed from: g  reason: collision with root package name */
    private LinkedList<e> f3357g = new LinkedList<>();

    private s() {
    }

    static s a() {
        if (f3351a == null) {
            synchronized (s.class) {
                f3351a = new s();
            }
        }
        return f3351a;
    }

    public void a(e eVar) {
        this.f3353c.add(eVar);
        if (!this.f3354d) {
            this.f3354d = true;
            this.f3352b.postDelayed(this.f3355e, 40);
        }
    }

    public void b(e eVar) {
        this.f3353c.remove(eVar);
    }

    public void b() {
        Iterator it = this.f3353c.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (!eVar.a()) {
                this.f3357g.add(eVar);
            }
        }
        if (this.f3357g.size() > 0) {
            this.f3353c.removeAll(this.f3357g);
            this.f3357g.clear();
        }
    }
}
