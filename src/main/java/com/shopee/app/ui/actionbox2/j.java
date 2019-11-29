package com.shopee.app.ui.actionbox2;

import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.tracking.impression.a;
import com.shopee.app.ui.a.w;
import d.d.a.b;

public class j extends i {

    /* renamed from: d  reason: collision with root package name */
    private RecyclerViewImpressionObserver f19448d;

    public j(RecyclerViewImpressionObserver recyclerViewImpressionObserver) {
        this.f19448d = recyclerViewImpressionObserver;
        this.f19448d.a((b<? super Integer, ? extends a>) new b<Integer, a>() {
            public a a(Integer num) {
                if (num == null || j.this.f4656a.isEmpty() || num.intValue() < 0 || num.intValue() >= j.this.f4656a.size()) {
                    return null;
                }
                com.b.a.a.a aVar = (com.b.a.a.a) j.this.f4656a.get(num.intValue());
                return (a) (aVar.d() ? aVar.a() : aVar.b());
            }
        });
    }

    public void a(w.a aVar) {
        super.a(aVar);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f19448d;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.a(aVar == null ? 0 : 1);
        }
    }

    public void onViewAttachedToWindow(RecyclerView.w wVar) {
        super.onViewAttachedToWindow(wVar);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f19448d;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.b(wVar.getAdapterPosition());
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.w wVar) {
        super.onViewDetachedFromWindow(wVar);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f19448d;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.c(wVar.getAdapterPosition());
        }
    }
}
