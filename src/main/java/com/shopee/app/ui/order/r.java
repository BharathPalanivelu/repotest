package com.shopee.app.ui.order;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.w;
import java.util.ArrayList;
import java.util.List;

public abstract class r<T> extends w {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<T> f23745c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b<T> f23746d;

    public interface b<T> {
        void a(View view, T t);

        void a(View view, T t, int i);
    }

    public long a(int i) {
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract View a(ViewGroup viewGroup);

    public void a(List<T> list) {
        this.f23745c = list;
    }

    public T b(int i) {
        return this.f23745c.get(i);
    }

    @Deprecated
    public long getItemId(int i) {
        if (!b() && !c()) {
            return a(i);
        }
        if (b() && i == 0) {
            return -99;
        }
        if (c() && i == getItemCount() - 1) {
            return -98;
        }
        if (b()) {
            i--;
        }
        return a(i);
    }

    public int getItemViewType(int i) {
        if (!b() && !c()) {
            return super.getItemViewType(i);
        }
        if (b() && i == 0) {
            return -99;
        }
        if (c() && i == getItemCount() - 1) {
            return -98;
        }
        if (b()) {
            i--;
        }
        return super.getItemViewType(i);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == -99) {
            return new RecyclerView.w(this.f19224a.a()) {
            };
        }
        if (i != -98) {
            return new RecyclerView.w(a(viewGroup)) {
            };
        }
        return new RecyclerView.w(this.f19225b.a()) {
        };
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        if (b() || c()) {
            if (b() && i == 0) {
                return;
            }
            if (!c() || i != getItemCount() - 1) {
                if (b()) {
                    i--;
                }
                if (wVar.itemView instanceof n) {
                    a(wVar, i);
                }
            }
        } else if (wVar.itemView instanceof n) {
            a(wVar, i);
        }
    }

    private void a(final RecyclerView.w wVar, int i) {
        ((n) wVar.itemView).a(this.f23745c.get(i));
        if (this.f23746d != null) {
            wVar.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (r.this.f23746d != null) {
                        int adapterPosition = wVar.getAdapterPosition();
                        if (adapterPosition != -1) {
                            if (r.this.b()) {
                                adapterPosition--;
                            }
                            r.this.f23746d.a(wVar.itemView, r.this.f23745c.get(adapterPosition), adapterPosition);
                        }
                    }
                }
            });
            wVar.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (r.this.f23746d == null) {
                        return true;
                    }
                    int adapterPosition = wVar.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return true;
                    }
                    if (r.this.b()) {
                        adapterPosition--;
                    }
                    r.this.f23746d.a(wVar.itemView, r.this.f23745c.get(adapterPosition));
                    return true;
                }
            });
        }
    }

    public int getItemCount() {
        return this.f23745c.size() + (b() ? 1 : 0) + (c() ? 1 : 0);
    }

    public List<Object> d() {
        ArrayList arrayList = new ArrayList();
        if (b()) {
            arrayList.add(new a(-99));
        }
        arrayList.addAll(this.f23745c);
        if (c()) {
            arrayList.add(new a(-98));
        }
        return arrayList;
    }

    public void a(b<T> bVar) {
        this.f23746d = bVar;
    }

    public class a {

        /* renamed from: b  reason: collision with root package name */
        private long f23755b;

        public a(long j) {
            this.f23755b = j;
        }

        public long a() {
            return this.f23755b;
        }
    }
}
