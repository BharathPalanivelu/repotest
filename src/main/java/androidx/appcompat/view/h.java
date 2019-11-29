package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ac;
import java.util.ArrayList;
import java.util.Iterator;

public class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<aa> f774a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ab f775b;

    /* renamed from: c  reason: collision with root package name */
    private long f776c = -1;

    /* renamed from: d  reason: collision with root package name */
    private Interpolator f777d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f778e;

    /* renamed from: f  reason: collision with root package name */
    private final ac f779f = new ac() {

        /* renamed from: b  reason: collision with root package name */
        private boolean f781b = false;

        /* renamed from: c  reason: collision with root package name */
        private int f782c = 0;

        public void a(View view) {
            if (!this.f781b) {
                this.f781b = true;
                if (h.this.f775b != null) {
                    h.this.f775b.a((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f782c = 0;
            this.f781b = false;
            h.this.b();
        }

        public void b(View view) {
            int i = this.f782c + 1;
            this.f782c = i;
            if (i == h.this.f774a.size()) {
                if (h.this.f775b != null) {
                    h.this.f775b.b((View) null);
                }
                a();
            }
        }
    };

    public h a(aa aaVar) {
        if (!this.f778e) {
            this.f774a.add(aaVar);
        }
        return this;
    }

    public h a(aa aaVar, aa aaVar2) {
        this.f774a.add(aaVar);
        aaVar2.b(aaVar.a());
        this.f774a.add(aaVar2);
        return this;
    }

    public void a() {
        if (!this.f778e) {
            Iterator<aa> it = this.f774a.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                long j = this.f776c;
                if (j >= 0) {
                    next.a(j);
                }
                Interpolator interpolator = this.f777d;
                if (interpolator != null) {
                    next.a(interpolator);
                }
                if (this.f775b != null) {
                    next.a((ab) this.f779f);
                }
                next.c();
            }
            this.f778e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f778e = false;
    }

    public void c() {
        if (this.f778e) {
            Iterator<aa> it = this.f774a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f778e = false;
        }
    }

    public h a(long j) {
        if (!this.f778e) {
            this.f776c = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.f778e) {
            this.f777d = interpolator;
        }
        return this;
    }

    public h a(ab abVar) {
        if (!this.f778e) {
            this.f775b = abVar;
        }
        return this;
    }
}
