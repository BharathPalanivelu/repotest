package com.shopee.app.ui.home.me.tracking.seller;

import androidx.recyclerview.widget.RecyclerView;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.ui.home.me.v3.feature.MeFeatureRecyclerView;
import com.shopee.app.ui.home.me.v3.feature.b.e;
import d.d.b.j;
import java.util.List;

public final class SellerTrackSession$initWithRecyclerView$1 extends RecyclerViewImpressionObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f22432a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MeFeatureRecyclerView f22433b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SellerTrackSession$initWithRecyclerView$1(b bVar, MeFeatureRecyclerView meFeatureRecyclerView, RecyclerView recyclerView, b bVar2, Info.InfoBuilder infoBuilder) {
        super(recyclerView, bVar2, infoBuilder);
        this.f22432a = bVar;
        this.f22433b = meFeatureRecyclerView;
    }

    public void a(List<o> list) {
        j.b(list, "trackingImpressions");
        for (o oVar : list) {
            l c2 = oVar.c("system_name");
            if (c2 != null) {
                String c3 = c2.c();
                if (j.a((Object) c3, (Object) e.f22597b.getName())) {
                    this.f22432a.a(oVar);
                } else if (oVar.b("sub_features")) {
                    this.f22432a.b(oVar);
                }
                b a2 = this.f22432a.f22439c;
                a b2 = this.f22432a.f22437a;
                j.a((Object) c3, "name");
                a2.a(b2.a(c3), (List<o>) d.a.j.a(oVar));
            }
        }
    }
}
