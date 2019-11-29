package com.shopee.app.ui.home.me.tracking;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.MeFeatureRecyclerView;
import com.shopee.app.ui.home.me.v3.feature.a.f;
import com.shopee.app.ui.home.me.v3.feature.e;
import d.d.b.j;
import d.d.b.k;
import d.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class d implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f22425a = new b();

    /* renamed from: b  reason: collision with root package name */
    private List<WeakReference<View>> f22426b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final c f22427c = new c();

    /* renamed from: d  reason: collision with root package name */
    private List<WeakReference<View>> f22428d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.app.tracking.c.a f22429e = this.f22425a;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerViewImpressionObserver f22430f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final b f22431g;

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

    public d(b bVar) {
        j.b(bVar, "biTrackerV3");
        this.f22431g = bVar;
    }

    public final void a(MeFeatureRecyclerView meFeatureRecyclerView) {
        j.b(meFeatureRecyclerView, "featureRecyclerView");
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22430f;
        if (recyclerViewImpressionObserver != null) {
            if (recyclerViewImpressionObserver != null) {
                recyclerViewImpressionObserver.onStop();
            }
            this.f22430f = null;
        }
        this.f22430f = new MeTabTrackSession$initWithRecyclerView$1(this, meFeatureRecyclerView, meFeatureRecyclerView, this.f22431g, (Info.InfoBuilder) null);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver2 = this.f22430f;
        if (recyclerViewImpressionObserver2 != null) {
            recyclerViewImpressionObserver2.a((d.d.a.b<? super Integer, ? extends com.shopee.app.tracking.impression.a>) new a(meFeatureRecyclerView));
        }
    }

    public void a() {
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22430f;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStart();
        }
    }

    public void b() {
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.f22430f;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStop();
        }
    }

    public void a(View view) {
        j.b(view, "view");
        a(view.getId());
    }

    public void a(int i) {
        Info.InfoBuilder a2 = this.f22429e.a(i);
        if (a2 != null) {
            b bVar = this.f22431g;
            String targetType = a2.getTargetType();
            if (targetType == null) {
                targetType = "";
            }
            String pageSection = a2.getPageSection();
            if (pageSection == null) {
                pageSection = "";
            }
            String pageType = a2.getPageType();
            if (pageType == null) {
                pageType = "";
            }
            b.a(bVar, targetType, pageSection, (o) null, pageType, 4, (Object) null);
        }
    }

    public final void a(ShopDetail shopDetail) {
        o oVar = new o();
        oVar.a("is_seller", shopDetail != null ? Boolean.valueOf(shopDetail.isSeller()) : null);
        this.f22431g.a("selling_button", "", oVar, "me");
    }

    public final void b(int i) {
        if (i != 1) {
            a("buying");
        } else {
            a("post");
        }
    }

    public static /* synthetic */ void a(d dVar, MeFeature meFeature, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        dVar.a(meFeature, str);
    }

    public final void a(MeFeature meFeature, String str) {
        j.b(meFeature, "meFeature");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            this.f22431g.a("click", this.f22425a.a(meFeature.getName()), meFeature.getTrackingImpressionData());
        } else {
            this.f22431g.a("click", Info.InfoBuilder.Companion.builder().withTargetType(str).withPageType("me"), meFeature.getTrackingImpressionData());
        }
    }

    private final void a(String str) {
        o oVar = new o();
        oVar.a("tab_name", str);
        this.f22431g.a("tab", "", oVar, "me");
    }

    /* access modifiers changed from: private */
    public final void a(o oVar) {
        for (String a2 : f.f22554b.b()) {
            this.f22431g.a(this.f22425a.a(a2), (List<o>) d.a.j.a(oVar));
        }
    }

    /* access modifiers changed from: private */
    public final void b(o oVar) {
        l a2 = oVar.a("sub_features");
        if (a2 instanceof i) {
            for (l lVar : (i) a2) {
                if (lVar instanceof o) {
                    this.f22431g.a(Info.InfoBuilder.Companion.builder().withPageType("me").withTargetType("self_design_circle"), (List<o>) d.a.j.a((o) lVar));
                }
            }
        }
    }
}
