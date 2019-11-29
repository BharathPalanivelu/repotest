package com.shopee.app.ui.product.search.tracking;

import android.widget.ListView;
import com.google.a.o;
import com.shopee.app.tracking.ImpressionObserver;
import com.shopee.app.tracking.c;
import com.shopee.app.tracking.trackingv3.b;
import d.d.b.j;

public final class SearchProductImpressionObserver extends ImpressionObserver {

    /* renamed from: a  reason: collision with root package name */
    private final b f24878a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchProductImpressionObserver(ListView listView, c cVar, b bVar, b bVar2) {
        super(listView, cVar, bVar, (ImpressionObserver.b) null, (d.d.a.b<? super Integer, o>) AnonymousClass1.f24879a);
        j.b(listView, "listView");
        j.b(cVar, "biTracker");
        j.b(bVar, "biTrackerV3");
        j.b(bVar2, "trackingSession");
        this.f24878a = bVar2;
    }

    public void a(int i) {
        this.f24878a.a(i);
    }

    public void b() {
        super.b();
        this.f24878a.c();
    }
}
