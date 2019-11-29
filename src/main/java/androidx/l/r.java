package androidx.l;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.l.n;
import java.util.ArrayList;
import java.util.Iterator;

public class r extends n {
    int h;
    boolean i = false;
    private ArrayList<n> j = new ArrayList<>();
    private boolean k = true;
    private int l = 0;

    public r a(int i2) {
        if (i2 == 0) {
            this.k = true;
        } else if (i2 == 1) {
            this.k = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    public r a(n nVar) {
        this.j.add(nVar);
        nVar.f2508d = this;
        if (this.f2505a >= 0) {
            nVar.a(this.f2505a);
        }
        if ((this.l & 1) != 0) {
            nVar.a(d());
        }
        if ((this.l & 2) != 0) {
            nVar.a(n());
        }
        if ((this.l & 4) != 0) {
            nVar.a(l());
        }
        if ((this.l & 8) != 0) {
            nVar.a(m());
        }
        return this;
    }

    public int q() {
        return this.j.size();
    }

    public n b(int i2) {
        if (i2 < 0 || i2 >= this.j.size()) {
            return null;
        }
        return this.j.get(i2);
    }

    /* renamed from: c */
    public r a(long j2) {
        super.a(j2);
        if (this.f2505a >= 0) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.j.get(i2).a(j2);
            }
        }
        return this;
    }

    /* renamed from: d */
    public r b(long j2) {
        return (r) super.b(j2);
    }

    /* renamed from: b */
    public r a(TimeInterpolator timeInterpolator) {
        this.l |= 1;
        ArrayList<n> arrayList = this.j;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.j.get(i2).a(timeInterpolator);
            }
        }
        return (r) super.a(timeInterpolator);
    }

    /* renamed from: f */
    public r b(View view) {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            this.j.get(i2).b(view);
        }
        return (r) super.b(view);
    }

    /* renamed from: c */
    public r a(n.c cVar) {
        return (r) super.a(cVar);
    }

    /* renamed from: g */
    public r c(View view) {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            this.j.get(i2).c(view);
        }
        return (r) super.c(view);
    }

    /* renamed from: d */
    public r b(n.c cVar) {
        return (r) super.b(cVar);
    }

    public void a(h hVar) {
        super.a(hVar);
        this.l |= 4;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            this.j.get(i2).a(hVar);
        }
    }

    private void r() {
        a aVar = new a(this);
        Iterator<n> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a((n.c) aVar);
        }
        this.h = this.j.size();
    }

    static class a extends o {

        /* renamed from: a  reason: collision with root package name */
        r f2529a;

        a(r rVar) {
            this.f2529a = rVar;
        }

        public void d(n nVar) {
            if (!this.f2529a.i) {
                this.f2529a.j();
                this.f2529a.i = true;
            }
        }

        public void a(n nVar) {
            r rVar = this.f2529a;
            rVar.h--;
            if (this.f2529a.h == 0) {
                r rVar2 = this.f2529a;
                rVar2.i = false;
                rVar2.k();
            }
            nVar.b((n.c) this);
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, u uVar, u uVar2, ArrayList<t> arrayList, ArrayList<t> arrayList2) {
        long c2 = c();
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = this.j.get(i2);
            if (c2 > 0 && (this.k || i2 == 0)) {
                long c3 = nVar.c();
                if (c3 > 0) {
                    nVar.b(c3 + c2);
                } else {
                    nVar.b(c2);
                }
            }
            nVar.a(viewGroup, uVar, uVar2, arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (this.j.isEmpty()) {
            j();
            k();
            return;
        }
        r();
        if (!this.k) {
            for (int i2 = 1; i2 < this.j.size(); i2++) {
                final n nVar = this.j.get(i2);
                this.j.get(i2 - 1).a((n.c) new o() {
                    public void a(n nVar) {
                        nVar.e();
                        nVar.b((n.c) this);
                    }
                });
            }
            n nVar2 = this.j.get(0);
            if (nVar2 != null) {
                nVar2.e();
                return;
            }
            return;
        }
        Iterator<n> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public void a(t tVar) {
        if (a(tVar.f2534b)) {
            Iterator<n> it = this.j.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.a(tVar.f2534b)) {
                    next.a(tVar);
                    tVar.f2535c.add(next);
                }
            }
        }
    }

    public void b(t tVar) {
        if (a(tVar.f2534b)) {
            Iterator<n> it = this.j.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next.a(tVar.f2534b)) {
                    next.b(tVar);
                    tVar.f2535c.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(t tVar) {
        super.c(tVar);
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.get(i2).c(tVar);
        }
    }

    public void d(View view) {
        super.d(view);
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.get(i2).d(view);
        }
    }

    public void e(View view) {
        super.e(view);
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.get(i2).e(view);
        }
    }

    public void a(q qVar) {
        super.a(qVar);
        this.l |= 2;
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.get(i2).a(qVar);
        }
    }

    public void a(n.b bVar) {
        super.a(bVar);
        this.l |= 8;
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.get(i2).a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String a2 = super.a(str);
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.j.get(i2).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }

    /* renamed from: o */
    public n clone() {
        r rVar = (r) super.clone();
        rVar.j = new ArrayList<>();
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            rVar.a(this.j.get(i2).clone());
        }
        return rVar;
    }
}
