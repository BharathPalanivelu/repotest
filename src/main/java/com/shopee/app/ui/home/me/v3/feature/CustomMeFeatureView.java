package com.shopee.app.ui.home.me.v3.feature;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.data.store.be;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.k;
import com.shopee.navigator.NavigationPath;
import com.shopee.navigator.e;
import d.d.b.j;
import d.d.b.k;
import d.m;
import d.p;
import java.util.HashMap;

public class CustomMeFeatureView extends OptionRow implements h {

    /* renamed from: b  reason: collision with root package name */
    private HashMap f22538b;

    public CustomMeFeatureView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public CustomMeFeatureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public View a(int i) {
        if (this.f22538b == null) {
            this.f22538b = new HashMap();
        }
        View view = (View) this.f22538b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f22538b.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void a(MeFeature meFeature) {
    }

    static final class a extends k implements d.d.a.b<View, p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;
        final /* synthetic */ CustomMeFeatureView this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CustomMeFeatureView customMeFeatureView, i iVar, MeFeature meFeature) {
            super(1);
            this.this$0 = customMeFeatureView;
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj) {
            a((View) obj);
            return p.f32714a;
        }

        public final void a(View view) {
            this.this$0.b(this.$metaData, this.$meFeature);
        }
    }

    static final class b extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;
        final /* synthetic */ CustomMeFeatureView this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CustomMeFeatureView customMeFeatureView, i iVar, MeFeature meFeature) {
            super(0);
            this.this$0 = customMeFeatureView;
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.this$0.b(this.$metaData, this.$meFeature);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomMeFeatureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomMeFeatureView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.shopee.app.ui.home.me.v3.feature.i r9, com.shopee.app.ui.home.me.v3.feature.MeFeature r10) {
        /*
            r8 = this;
            java.lang.String r0 = "metaData"
            d.d.b.j.b(r9, r0)
            java.lang.String r0 = "meFeature"
            d.d.b.j.b(r10, r0)
            java.lang.String r0 = r10.getRedirectUrl()
            java.lang.String r1 = "arrow"
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x004b
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 != 0) goto L_0x004b
            int r0 = r10.getNonLoginAccess()
            if (r0 != r2) goto L_0x0032
            com.shopee.app.ui.home.me.v3.feature.CustomMeFeatureView$a r0 = new com.shopee.app.ui.home.me.v3.feature.CustomMeFeatureView$a
            r0.<init>(r8, r9, r10)
            d.d.a.b r0 = (d.d.a.b) r0
            com.shopee.app.e.b.a((android.view.View) r8, (d.d.a.b<? super android.view.View, d.p>) r0)
            goto L_0x003c
        L_0x0032:
            com.shopee.app.ui.home.me.v3.feature.CustomMeFeatureView$b r0 = new com.shopee.app.ui.home.me.v3.feature.CustomMeFeatureView$b
            r0.<init>(r8, r9, r10)
            d.d.a.a r0 = (d.d.a.a) r0
            com.shopee.app.ui.home.me.v3.feature.f.a(r8, r9, r0)
        L_0x003c:
            int r0 = com.shopee.app.a.C0250a.arrow
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r3)
            goto L_0x005a
        L_0x004b:
            int r0 = com.shopee.app.a.C0250a.arrow
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 4
            r0.setVisibility(r1)
        L_0x005a:
            int r0 = r10.getNewBadge()
            if (r0 == 0) goto L_0x0085
            long r0 = r10.getNewBadgeEndTime()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r6
            long r4 = r4 / r6
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0080
            com.shopee.app.data.store.be r9 = r9.m()
            java.lang.String r0 = r10.getName()
            boolean r9 = r9.b((java.lang.String) r0)
            if (r9 != 0) goto L_0x0080
            r9 = 1
            goto L_0x0081
        L_0x0080:
            r9 = 0
        L_0x0081:
            r8.setShowNewLabel(r9)
            goto L_0x0088
        L_0x0085:
            r8.setShowNewLabel(r3)
        L_0x0088:
            java.lang.String r9 = r10.getDisplayName()
            r8.setText(r9)
            java.lang.String r9 = r10.getIcon()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x009f
            boolean r9 = d.h.m.a(r9)
            if (r9 == 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r2 = 0
        L_0x009f:
            if (r2 != 0) goto L_0x00bd
            android.content.Context r9 = r8.getContext()
            com.shopee.app.util.z$c r9 = com.shopee.app.util.z.d((android.content.Context) r9)
            java.lang.String r10 = r10.getIcon()
            com.shopee.app.util.z$c r9 = r9.a((java.lang.String) r10)
            int r10 = com.shopee.app.a.C0250a.icon_view
            android.view.View r10 = r8.a((int) r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r9.a((android.widget.ImageView) r10)
            goto L_0x00cf
        L_0x00bd:
            int r9 = com.shopee.app.a.C0250a.icon_view
            android.view.View r9 = r8.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            java.lang.String r10 = "icon_view"
            d.d.b.j.a((java.lang.Object) r9, (java.lang.String) r10)
            r10 = 8
            r9.setVisibility(r10)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.me.v3.feature.CustomMeFeatureView.a(com.shopee.app.ui.home.me.v3.feature.i, com.shopee.app.ui.home.me.v3.feature.MeFeature):void");
    }

    /* access modifiers changed from: private */
    public final void b(i iVar, MeFeature meFeature) {
        NavigationPath a2 = NavigationPath.a(meFeature.getRedirectUrl());
        e q = iVar.q();
        Context context = getContext();
        if (context != null) {
            q.a((Activity) context, a2);
            iVar.m().c(meFeature != null ? meFeature.getName() : null);
            setShowNewLabel(false);
            if (iVar instanceof b.a) {
                d h = iVar.h();
                if (h != null) {
                    h.a(meFeature, "self_design_button");
                }
            } else if (iVar instanceof k.a) {
                com.shopee.app.ui.home.me.tracking.seller.b i = iVar.i();
                if (i != null) {
                    i.a(meFeature, "self_design_button");
                }
            }
            a(iVar.m(), meFeature);
            return;
        }
        throw new m("null cannot be cast to non-null type android.app.Activity");
    }

    public final void a(be beVar, MeFeature meFeature) {
        j.b(beVar, "uiSettingStore");
        j.b(meFeature, "meFeature");
        beVar.c(meFeature.getName());
        setShowNewLabel(false);
    }
}
