package com.shopee.app.tracking.impression;

import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.places.model.PlaceFields;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.tracking.trackingv3.model.Info;
import d.d.a.b;
import d.d.b.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecyclerViewImpressionObserver implements g {

    /* renamed from: a  reason: collision with root package name */
    private final List<o> f6991a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Long> f6992b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private b<? super Integer, ? extends a> f6993c;

    /* renamed from: d  reason: collision with root package name */
    private o f6994d;

    /* renamed from: e  reason: collision with root package name */
    private int f6995e;

    /* renamed from: f  reason: collision with root package name */
    private final RecyclerView f6996f;

    /* renamed from: g  reason: collision with root package name */
    private final com.shopee.app.tracking.trackingv3.b f6997g;
    private final Info.InfoBuilder h;

    public RecyclerViewImpressionObserver(RecyclerView recyclerView, com.shopee.app.tracking.trackingv3.b bVar, Info.InfoBuilder infoBuilder) {
        j.b(recyclerView, "recyclerView");
        this.f6996f = recyclerView;
        this.f6997g = bVar;
        this.h = infoBuilder;
    }

    public final void a(o oVar) {
        this.f6994d = oVar;
    }

    public final void a(int i) {
        this.f6995e = i;
    }

    public final void a(b<? super Integer, ? extends a> bVar) {
        this.f6993c = bVar;
    }

    public final void b(int i) {
        b<? super Integer, ? extends a> bVar = this.f6993c;
        a aVar = bVar != null ? (a) bVar.a(Integer.valueOf(i)) : null;
        if (aVar != null) {
            this.f6992b.put(aVar.getTrackingImpressionId(), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void c(int i) {
        b<? super Integer, ? extends a> bVar = this.f6993c;
        a aVar = bVar != null ? (a) bVar.a(Integer.valueOf(i)) : null;
        if (aVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l = this.f6992b.get(aVar.getTrackingImpressionId());
            if (l == null) {
                l = Long.valueOf(System.currentTimeMillis());
            }
            j.a((Object) l, "startTimeMap[item.getTra…ystem.currentTimeMillis()");
            if (currentTimeMillis - l.longValue() >= 1000) {
                a(aVar, i);
            }
            this.f6992b.remove(aVar.getTrackingImpressionId());
        }
    }

    @androidx.lifecycle.o(a = e.a.ON_START)
    public final void onStart() {
        a();
    }

    @androidx.lifecycle.o(a = e.a.ON_STOP)
    public final void onStop() {
        b();
        a(this.f6991a);
        this.f6992b.clear();
    }

    private final void a() {
        RecyclerView.i layoutManager = this.f6996f.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int n = linearLayoutManager.n();
            int p = linearLayoutManager.p();
            if (n <= p) {
                while (true) {
                    b(n);
                    if (n != p) {
                        n++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void b() {
        RecyclerView.i layoutManager = this.f6996f.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int n = linearLayoutManager.n();
            int p = linearLayoutManager.p();
            if (n <= p) {
                while (true) {
                    c(n);
                    if (n != p) {
                        n++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void a(a aVar, int i) {
        if (i - this.f6995e >= 0) {
            o trackingImpressionData = aVar.getTrackingImpressionData();
            trackingImpressionData.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i - this.f6995e));
            o oVar = this.f6994d;
            if (oVar != null) {
                Set<Map.Entry<String, l>> a2 = oVar.a();
                j.a((Object) a2, "additionalItemInfo.entrySet()");
                for (Map.Entry entry : a2) {
                    trackingImpressionData.a((String) entry.getKey(), (l) entry.getValue());
                }
            }
            this.f6991a.add(trackingImpressionData);
        }
    }

    public void a(List<o> list) {
        j.b(list, "trackingImpressions");
        com.shopee.app.tracking.trackingv3.b bVar = this.f6997g;
        if (bVar != null) {
            Info.InfoBuilder infoBuilder = this.h;
            if (infoBuilder != null) {
                bVar.a(infoBuilder, list);
            }
        }
    }
}
