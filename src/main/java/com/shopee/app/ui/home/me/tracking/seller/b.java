package com.shopee.app.ui.home.me.tracking.seller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.tracking.trackingv3.model.TrackingEvent;
import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.MeFeatureRecyclerView;
import com.shopee.app.ui.home.me.v3.feature.e;
import d.d.b.j;
import d.d.b.k;
import d.m;
import java.util.List;

public final class b implements com.shopee.app.ui.home.me.tracking.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f22437a = new a();

    /* renamed from: b  reason: collision with root package name */
    private RecyclerViewImpressionObserver f22438b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.shopee.app.tracking.trackingv3.b f22439c;

    static final class a extends k implements d.d.a.b<Integer, com.shopee.app.tracking.impression.a> {
        final /* synthetic */ MeFeatureRecyclerView $featureRecyclerView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MeFeatureRecyclerView meFeatureRecyclerView) {
            super(1);
            this.$featureRecyclerView = meFeatureRecyclerView;
        }

        public /* synthetic */ Object a(Object obj) {
            return a(((Number) obj).intValue());
        }

        public final com.shopee.app.tracking.impression.a a(int i) {
            RecyclerView.a adapter = this.$featureRecyclerView.getAdapter();
            if (adapter != null) {
                e eVar = (e) adapter;
                if (i < 0 || i >= eVar.getItemCount()) {
                    return null;
                }
                return (com.shopee.app.tracking.impression.a) eVar.a(i);
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.me.v3.feature.MeFeatureAdapter");
        }
    }

    public b(com.shopee.app.tracking.trackingv3.b bVar) {
        j.b(bVar, "biTrackerV3");
        this.f22439c = bVar;
    }

    public final void a(MeFeatureRecyclerView meFeatureRecyclerView) {
        j.b(meFeatureRecyclerView, "featureRecyclerView");
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22438b;
        if (recyclerViewImpressionObserver != null) {
            if (recyclerViewImpressionObserver != null) {
                recyclerViewImpressionObserver.onStop();
            }
            this.f22438b = null;
        }
        this.f22438b = new SellerTrackSession$initWithRecyclerView$1(this, meFeatureRecyclerView, meFeatureRecyclerView, this.f22439c, (Info.InfoBuilder) null);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver2 = this.f22438b;
        if (recyclerViewImpressionObserver2 != null) {
            recyclerViewImpressionObserver2.a((d.d.a.b<? super Integer, ? extends com.shopee.app.tracking.impression.a>) new a(meFeatureRecyclerView));
        }
    }

    public void a() {
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22438b;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStart();
        }
    }

    public void b() {
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22438b;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStop();
        }
    }

    public void a(View view) {
        j.b(view, "view");
        a(view.getId());
    }

    public void a(int i) {
        Info.InfoBuilder b2 = this.f22437a.b(i);
        if (b2 != null) {
            b2.withOperation("click");
            UserActionV3.Companion.create(new TrackingEvent("", b2.build())).log();
        }
    }

    public static /* synthetic */ void a(b bVar, MeFeature meFeature, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        bVar.a(meFeature, str);
    }

    public final void a(MeFeature meFeature, String str) {
        j.b(meFeature, "meFeature");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            this.f22439c.a("click", this.f22437a.a(meFeature.getName()), meFeature.getTrackingImpressionData());
        } else {
            this.f22439c.a("click", Info.InfoBuilder.Companion.builder().withTargetType(str).withPageType("seller"), meFeature.getTrackingImpressionData());
        }
    }

    /* access modifiers changed from: private */
    public final void a(o oVar) {
        this.f22439c.a(this.f22437a.a("to_ship"), (List<o>) d.a.j.a(oVar));
        this.f22439c.a(this.f22437a.a("to_cancel"), (List<o>) d.a.j.a(oVar));
        this.f22439c.a(this.f22437a.a("return_and_refund"), (List<o>) d.a.j.a(oVar));
        this.f22439c.a(this.f22437a.a("more"), (List<o>) d.a.j.a(oVar));
    }

    /* access modifiers changed from: private */
    public final void b(o oVar) {
        l a2 = oVar.a("sub_features");
        if (a2 instanceof i) {
            for (l lVar : (i) a2) {
                if (lVar instanceof o) {
                    this.f22439c.a(Info.InfoBuilder.Companion.builder().withPageType("me").withTargetType("self_design_circle"), (List<o>) d.a.j.a((o) lVar));
                }
            }
        }
    }
}
