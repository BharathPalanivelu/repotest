package com.shopee.app.ui.home.me.tracking;

import androidx.recyclerview.widget.RecyclerView;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.ui.home.me.v3.feature.MeFeatureRecyclerView;
import com.shopee.app.ui.home.me.v3.feature.a.f;
import d.d.b.j;
import java.util.List;

public final class MeTabTrackSession$initWithRecyclerView$1 extends RecyclerViewImpressionObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f22420a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MeFeatureRecyclerView f22421b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeTabTrackSession$initWithRecyclerView$1(d dVar, MeFeatureRecyclerView meFeatureRecyclerView, RecyclerView recyclerView, b bVar, Info.InfoBuilder infoBuilder) {
        super(recyclerView, bVar, infoBuilder);
        this.f22420a = dVar;
        this.f22421b = meFeatureRecyclerView;
    }

    public void a(List<o> list) {
        j.b(list, "trackingImpressions");
        for (o oVar : list) {
            l c2 = oVar.c("system_name");
            if (c2 != null) {
                String c3 = c2.c();
                if (j.a((Object) c3, (Object) f.f22554b.getName())) {
                    this.f22420a.a(oVar);
                } else if (oVar.b("sub_features")) {
                    this.f22420a.b(oVar);
                }
                b a2 = this.f22420a.f22431g;
                b b2 = this.f22420a.f22425a;
                j.a((Object) c3, "name");
                a2.a(b2.a(c3), (List<o>) d.a.j.a(oVar));
            }
        }
    }
}
