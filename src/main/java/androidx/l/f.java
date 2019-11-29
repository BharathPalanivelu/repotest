package androidx.l;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.o;
import androidx.l.n;
import java.util.ArrayList;
import java.util.List;

public class f extends o {
    public boolean a(Object obj) {
        return obj instanceof n;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((n) obj).clone();
        }
        return null;
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        r rVar = new r();
        rVar.a((n) obj);
        return rVar;
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        r rVar = (r) obj;
        List<View> g2 = rVar.g();
        g2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(g2, arrayList.get(i));
        }
        g2.add(view);
        arrayList.add(view);
        a((Object) rVar, arrayList);
    }

    public void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((n) obj).a((n.b) new n.b() {
            });
        }
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        n nVar = (n) obj;
        if (nVar != null) {
            int i = 0;
            if (nVar instanceof r) {
                r rVar = (r) nVar;
                int q = rVar.q();
                while (i < q) {
                    a((Object) rVar.b(i), arrayList);
                    i++;
                }
            } else if (!a(nVar) && a((List) nVar.g())) {
                int size = arrayList.size();
                while (i < size) {
                    nVar.b(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    private static boolean a(n nVar) {
        return !a((List) nVar.f()) || !a((List) nVar.h()) || !a((List) nVar.i());
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        r rVar = new r();
        if (obj != null) {
            rVar.a((n) obj);
        }
        if (obj2 != null) {
            rVar.a((n) obj2);
        }
        if (obj3 != null) {
            rVar.a((n) obj3);
        }
        return rVar;
    }

    public void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((n) obj).a((n.c) new n.c() {
            public void b(n nVar) {
            }

            public void c(n nVar) {
            }

            public void d(n nVar) {
            }

            public void a(n nVar) {
                nVar.b((n.c) this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        n nVar3 = (n) obj3;
        if (nVar != null && nVar2 != null) {
            nVar = new r().a(nVar).a(nVar2).a(1);
        } else if (nVar == null) {
            nVar = nVar2 != null ? nVar2 : null;
        }
        if (nVar3 == null) {
            return nVar;
        }
        r rVar = new r();
        if (nVar != null) {
            rVar.a(nVar);
        }
        rVar.a(nVar3);
        return rVar;
    }

    public void a(ViewGroup viewGroup, Object obj) {
        p.a(viewGroup, (n) obj);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((n) obj).a((n.c) new n.c() {
            public void a(n nVar) {
            }

            public void b(n nVar) {
            }

            public void c(n nVar) {
            }

            public void d(n nVar) {
                Object obj = obj5;
                if (obj != null) {
                    f.this.b(obj, (ArrayList<View>) arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    f.this.b(obj2, (ArrayList<View>) arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    f.this.b(obj3, (ArrayList<View>) arrayList6, (ArrayList<View>) null);
                }
            }
        });
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        r rVar = (r) obj;
        if (rVar != null) {
            rVar.g().clear();
            rVar.g().addAll(arrayList2);
            b((Object) rVar, arrayList, arrayList2);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i;
        n nVar = (n) obj;
        int i2 = 0;
        if (nVar instanceof r) {
            r rVar = (r) nVar;
            int q = rVar.q();
            while (i2 < q) {
                b((Object) rVar.b(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!a(nVar)) {
            List<View> g2 = nVar.g();
            if (g2.size() == arrayList.size() && g2.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    nVar.b(arrayList2.get(i2));
                    i2++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    nVar.c(arrayList.get(size));
                }
            }
        }
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((n) obj).b(view);
        }
    }

    public void c(Object obj, View view) {
        if (obj != null) {
            ((n) obj).c(view);
        }
    }

    public void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((n) obj).a((n.b) new n.b() {
            });
        }
    }
}
