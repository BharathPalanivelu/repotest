package com.shopee.app.ui.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class y<T> extends w {

    /* renamed from: c  reason: collision with root package name */
    private final s<T> f19247c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a<T> f19248d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<T> f19249e = new ArrayList();

    public interface a<T> {
        void a(View view, T t, int i);
    }

    public long c(int i) {
        return -1;
    }

    public y(s<T> sVar) {
        this.f19247c = sVar;
    }

    public void a(List<T> list) {
        this.f19249e = list;
    }

    public List<T> d() {
        return this.f19249e;
    }

    public T a(int i) {
        if (!b() && !c()) {
            return this.f19249e.get(i);
        }
        if (b() && i == 0) {
            return null;
        }
        if (c() && i == getItemCount() - 1) {
            return null;
        }
        if (b()) {
            i--;
        }
        return this.f19249e.get(i);
    }

    public T b(int i) {
        return this.f19249e.get(i);
    }

    public void a(a<T> aVar) {
        this.f19248d = aVar;
    }

    @Deprecated
    public long getItemId(int i) {
        if (!b() && !c()) {
            return c(i);
        }
        if (b() && i == 0) {
            return Clock.MAX_TIME;
        }
        if (c() && i == getItemCount() - 1) {
            return Long.MIN_VALUE;
        }
        if (b()) {
            i--;
        }
        return c(i);
    }

    public int getItemViewType(int i) {
        if (!b() && !c()) {
            return this.f19247c.a(a(i), i);
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
        return this.f19247c.a(b(i), i);
    }

    public void onBindViewHolder(final RecyclerView.w wVar, int i) {
        if (b() || c()) {
            if (b() && i == 0) {
                return;
            }
            if (!c() || i != getItemCount() - 1) {
                if (b()) {
                    i--;
                }
                if (wVar.itemView instanceof n) {
                    ((n) wVar.itemView).a(this.f19249e.get(i));
                    if (this.f19248d != null) {
                        wVar.itemView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                if (y.this.f19248d != null) {
                                    int adapterPosition = wVar.getAdapterPosition();
                                    if (adapterPosition != -1) {
                                        if (y.this.b()) {
                                            adapterPosition--;
                                        }
                                        y.this.f19248d.a(wVar.itemView, y.this.f19249e.get(adapterPosition), adapterPosition);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        } else if (wVar.itemView instanceof n) {
            ((n) wVar.itemView).a(this.f19249e.get(i));
            if (this.f19248d != null) {
                wVar.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (y.this.f19248d != null) {
                            int adapterPosition = wVar.getAdapterPosition();
                            if (adapterPosition != -1) {
                                if (y.this.b()) {
                                    adapterPosition--;
                                }
                                y.this.f19248d.a(wVar.itemView, y.this.f19249e.get(adapterPosition), adapterPosition);
                            }
                        }
                    }
                });
            }
        }
    }

    public int getItemCount() {
        return this.f19249e.size() + (b() ? 1 : 0) + (c() ? 1 : 0);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == -99) {
            return new RecyclerView.w(this.f19224a.a()) {
            };
        }
        if (i != -98) {
            return new RecyclerView.w(this.f19247c.a(viewGroup.getContext(), i)) {
            };
        }
        return new RecyclerView.w(this.f19225b.a()) {
        };
    }
}
