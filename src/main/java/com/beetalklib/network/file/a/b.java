package com.beetalklib.network.file.a;

import com.beetalklib.network.c.a;
import com.beetalklib.network.d.c;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f5539a;

    /* renamed from: b  reason: collision with root package name */
    private List<h> f5540b;

    public b(int i) {
        this.f5539a = i;
        this.f5540b = new ArrayList(i);
    }

    public h a(String str, int i) {
        for (h next : this.f5540b) {
            if (next.a(str, i) && !next.b()) {
                return next;
            }
        }
        b();
        if (this.f5540b.size() >= this.f5539a) {
            return null;
        }
        a.b("new-connection-created", new Object[0]);
        h hVar = new h(str, i);
        this.f5540b.add(hVar);
        return hVar;
    }

    public void a(int i) {
        this.f5539a = i;
        b();
    }

    private void b() {
        ArrayList<h> arrayList = new ArrayList<>();
        if (this.f5540b.size() >= this.f5539a) {
            for (int size = this.f5540b.size() - 1; size >= 0; size--) {
                h hVar = this.f5540b.get(size);
                if (!hVar.b()) {
                    arrayList.add(hVar);
                }
                if (this.f5540b.size() - arrayList.size() < this.f5539a) {
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            for (h c2 : arrayList) {
                c2.c();
            }
            a.b("clean connection pool by %d", Integer.valueOf(arrayList.size()));
            this.f5540b.removeAll(arrayList);
        }
    }

    public void a() {
        List<h> list = this.f5540b;
        if (list != null) {
            for (h next : list) {
                c d2 = next.d();
                if (d2 instanceof f) {
                    ((f) d2).a();
                }
                next.c();
            }
        }
    }
}
