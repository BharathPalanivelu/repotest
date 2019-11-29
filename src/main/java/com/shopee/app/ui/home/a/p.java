package com.shopee.app.ui.home.a;

import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.tracking.impression.a;
import d.d.a.b;

public class p extends d {

    /* renamed from: c  reason: collision with root package name */
    private RecyclerViewImpressionObserver f22089c;

    public p(j jVar) {
        super(jVar);
    }

    public void a(RecyclerViewImpressionObserver recyclerViewImpressionObserver) {
        this.f22089c = recyclerViewImpressionObserver;
        this.f22089c.a((b<? super Integer, ? extends a>) new b<Integer, a>() {
            public a a(Integer num) {
                if (num == null || p.this.d() == null || num.intValue() < 0 || p.this.d().size() > num.intValue() || p.this.d().size() <= num.intValue()) {
                    return null;
                }
                return (a) p.this.d().get(num.intValue());
            }
        });
    }

    public void onViewAttachedToWindow(RecyclerView.w wVar) {
        super.onViewAttachedToWindow(wVar);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22089c;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.b(wVar.getAdapterPosition());
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.w wVar) {
        super.onViewDetachedFromWindow(wVar);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22089c;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.c(wVar.getAdapterPosition());
        }
    }
}
