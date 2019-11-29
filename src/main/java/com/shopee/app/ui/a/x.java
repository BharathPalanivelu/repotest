package com.shopee.app.ui.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.b.a.a.b;
import com.b.a.c;
import com.shopee.app.ui.a.w;
import java.util.ArrayList;
import java.util.List;

public abstract class x<P extends com.b.a.a.b<C>, C> extends com.b.a.b<P, C, c, com.b.a.a> implements l {

    /* renamed from: b  reason: collision with root package name */
    protected w.a f19226b;

    /* renamed from: c  reason: collision with root package name */
    protected w.a f19227c;

    /* renamed from: d  reason: collision with root package name */
    private a<P> f19228d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b<P, C> f19229e;

    public interface a<P> {
        void a(P p, boolean z, int i);
    }

    public interface b<P, C> {
        void a(View view, C c2);

        void a(View view, P p, int i, int i2);

        void a(View view, C c2, int i, int i2, int i3);

        void b(View view, P p);
    }

    /* access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract c a(ViewGroup viewGroup, a<P> aVar);

    /* access modifiers changed from: protected */
    public abstract void a(c cVar, P p);

    /* access modifiers changed from: protected */
    public abstract P b(long j);

    public boolean b(int i) {
        return i != 1;
    }

    public x() {
        super(new ArrayList());
    }

    public void a(List<P> list) {
        ArrayList arrayList = new ArrayList(list);
        if (c()) {
            arrayList.add(0, b(-99));
        }
        if (d()) {
            arrayList.add(b(-98));
        }
        a(arrayList, true);
    }

    public void a(w.a aVar) {
        this.f19226b = aVar;
    }

    public boolean b() {
        int i = d() ? 1 : 0;
        if (c()) {
            i++;
        }
        if (getItemCount() - i == 0) {
            return true;
        }
        return false;
    }

    public void b(w.a aVar) {
        this.f19227c = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return this.f19226b != null;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return this.f19227c != null;
    }

    public int a(int i) {
        if (!c() && !d()) {
            return super.getItemViewType(i);
        }
        if (c() && i == 0) {
            return -99;
        }
        if (d() && i == a().size() - 1) {
            return -98;
        }
        if (c()) {
            i--;
        }
        return super.a(i);
    }

    public c a(ViewGroup viewGroup, int i) {
        if (i == -99) {
            return new c(this.f19226b.a()) {
            };
        }
        if (i != -98) {
            return a(viewGroup, this.f19228d);
        }
        return new c(this.f19227c.a()) {
        };
    }

    public com.b.a.a b(ViewGroup viewGroup, int i) {
        return new com.b.a.a(a(viewGroup));
    }

    public void a(c cVar, int i, P p) {
        if (!c() && !d()) {
            a(cVar, p);
            a((RecyclerView.w) cVar, p, i);
            if (cVar.itemView instanceof n) {
                ((n) cVar.itemView).a(p);
            }
        } else if (c() && i == 0) {
        } else {
            if (!d() || i != a().size() - 1) {
                boolean c2 = c();
                a(cVar, p);
                a((RecyclerView.w) cVar, p, i);
                if (cVar.itemView instanceof n) {
                    ((n) cVar.itemView).a(p);
                }
            }
        }
    }

    public void a(com.b.a.a aVar, int i, int i2, C c2) {
        a((RecyclerView.w) aVar, c2, i, i2);
        if (aVar.itemView instanceof n) {
            ((n) aVar.itemView).a(c2);
        }
    }

    private void a(final RecyclerView.w wVar, final P p, final int i) {
        if (this.f19229e != null) {
            wVar.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (x.this.f19229e != null) {
                        x.this.f19229e.a(wVar.itemView, p, i, wVar.getAdapterPosition());
                    }
                }
            });
            wVar.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (x.this.f19229e == null) {
                        return true;
                    }
                    x.this.f19229e.b(wVar.itemView, p);
                    return true;
                }
            });
        }
    }

    private void a(final RecyclerView.w wVar, final C c2, int i, int i2) {
        if (this.f19229e != null) {
            final RecyclerView.w wVar2 = wVar;
            final C c3 = c2;
            final int i3 = i;
            final int i4 = i2;
            wVar.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (x.this.f19229e != null) {
                        x.this.f19229e.a(wVar2.itemView, c3, i3, i4, wVar2.getAdapterPosition());
                    }
                }
            });
            wVar.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (x.this.f19229e == null) {
                        return true;
                    }
                    x.this.f19229e.a(wVar.itemView, c2);
                    return true;
                }
            });
        }
    }

    public void a(a<P> aVar) {
        this.f19228d = aVar;
    }

    public void a(b<P, C> bVar) {
        this.f19229e = bVar;
    }
}
