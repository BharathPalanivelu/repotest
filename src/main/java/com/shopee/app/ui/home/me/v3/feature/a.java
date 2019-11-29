package com.shopee.app.ui.home.me.v3.feature;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.a;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.k;
import com.shopee.app.util.z;
import com.shopee.id.R;
import com.shopee.navigator.NavigationPath;
import d.d.b.j;
import d.d.b.k;
import d.m;
import d.p;
import d.q;
import java.util.HashMap;

public final class a extends LinearLayout implements h {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f22543a;

    public View a(int i) {
        if (this.f22543a == null) {
            this.f22543a = new HashMap();
        }
        View view = (View) this.f22543a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f22543a.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void a(MeFeature meFeature) {
    }

    /* renamed from: com.shopee.app.ui.home.me.v3.feature.a$a  reason: collision with other inner class name */
    static final class C0327a extends k implements d.d.a.b<View, p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0327a(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(1);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj) {
            a((View) obj);
            return p.f32714a;
        }

        public final void a(View view) {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(0), this.$meFeature$inlined);
        }
    }

    static final class b extends k implements d.d.a.b<View, p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(1);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj) {
            a((View) obj);
            return p.f32714a;
        }

        public final void a(View view) {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(1), this.$meFeature$inlined);
        }
    }

    static final class c extends k implements d.d.a.b<View, p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(1);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj) {
            a((View) obj);
            return p.f32714a;
        }

        public final void a(View view) {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(2), this.$meFeature$inlined);
        }
    }

    static final class d extends k implements d.d.a.b<View, p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(1);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj) {
            a((View) obj);
            return p.f32714a;
        }

        public final void a(View view) {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(3), this.$meFeature$inlined);
        }
    }

    static final class e extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(0);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(0), this.$meFeature$inlined);
        }
    }

    static final class f extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(0);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(1), this.$meFeature$inlined);
        }
    }

    static final class g extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(0);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(2), this.$meFeature$inlined);
        }
    }

    static final class h extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature$inlined;
        final /* synthetic */ i $metaData$inlined;
        final /* synthetic */ m $this_apply;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(m mVar, a aVar, MeFeature meFeature, i iVar) {
            super(0);
            this.$this_apply = mVar;
            this.this$0 = aVar;
            this.$meFeature$inlined = meFeature;
            this.$metaData$inlined = iVar;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.this$0.a(this.$metaData$inlined, this.$this_apply.b().get(3), this.$meFeature$inlined);
        }
    }

    public a(Context context) {
        super(context);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.inflate(context, R.layout.view_option_row_with_sub, this);
    }

    public void a(i iVar, MeFeature meFeature) {
        j.b(iVar, "metaData");
        j.b(meFeature, "meFeature");
        ((CustomMeFeatureView) a(a.C0250a.customMeFeatureView)).a(iVar, meFeature);
        b(iVar, meFeature);
    }

    private final void b(i iVar, MeFeature meFeature) {
        m subFeatures = meFeature.getSubFeatures();
        if (subFeatures != null) {
            boolean z = false;
            boolean z2 = subFeatures.b().size() == 4;
            if (!q.f32715a || z2) {
                z.d(getContext()).a(subFeatures.b().get(0).getIcon()).a((ImageView) a(a.C0250a.imageFeature1));
                z.d(getContext()).a(subFeatures.b().get(1).getIcon()).a((ImageView) a(a.C0250a.imageFeature2));
                z.d(getContext()).a(subFeatures.b().get(2).getIcon()).a((ImageView) a(a.C0250a.imageFeature3));
                z.d(getContext()).a(subFeatures.b().get(3).getIcon()).a((ImageView) a(a.C0250a.imageFeature4));
                RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.textFeature1);
                j.a((Object) robotoTextView, "textFeature1");
                robotoTextView.setText(subFeatures.b().get(0).getDisplayName());
                RobotoTextView robotoTextView2 = (RobotoTextView) a(a.C0250a.textFeature2);
                j.a((Object) robotoTextView2, "textFeature2");
                robotoTextView2.setText(subFeatures.b().get(1).getDisplayName());
                RobotoTextView robotoTextView3 = (RobotoTextView) a(a.C0250a.textFeature3);
                j.a((Object) robotoTextView3, "textFeature3");
                robotoTextView3.setText(subFeatures.b().get(2).getDisplayName());
                RobotoTextView robotoTextView4 = (RobotoTextView) a(a.C0250a.textFeature4);
                j.a((Object) robotoTextView4, "textFeature4");
                robotoTextView4.setText(subFeatures.b().get(3).getDisplayName());
                if (meFeature.getNonLoginAccess() == 1) {
                    LinearLayout linearLayout = (LinearLayout) a(a.C0250a.subFeature1);
                    j.a((Object) linearLayout, "subFeature1");
                    com.shopee.app.e.b.a((View) linearLayout, (d.d.a.b<? super View, p>) new C0327a(subFeatures, this, meFeature, iVar));
                    LinearLayout linearLayout2 = (LinearLayout) a(a.C0250a.subFeature2);
                    j.a((Object) linearLayout2, "subFeature2");
                    com.shopee.app.e.b.a((View) linearLayout2, (d.d.a.b<? super View, p>) new b(subFeatures, this, meFeature, iVar));
                    LinearLayout linearLayout3 = (LinearLayout) a(a.C0250a.subFeature3);
                    j.a((Object) linearLayout3, "subFeature3");
                    com.shopee.app.e.b.a((View) linearLayout3, (d.d.a.b<? super View, p>) new c(subFeatures, this, meFeature, iVar));
                    LinearLayout linearLayout4 = (LinearLayout) a(a.C0250a.subFeature4);
                    j.a((Object) linearLayout4, "subFeature4");
                    com.shopee.app.e.b.a((View) linearLayout4, (d.d.a.b<? super View, p>) new d(subFeatures, this, meFeature, iVar));
                } else {
                    LinearLayout linearLayout5 = (LinearLayout) a(a.C0250a.subFeature1);
                    j.a((Object) linearLayout5, "subFeature1");
                    f.a(linearLayout5, iVar, new e(subFeatures, this, meFeature, iVar));
                    LinearLayout linearLayout6 = (LinearLayout) a(a.C0250a.subFeature2);
                    j.a((Object) linearLayout6, "subFeature2");
                    f.a(linearLayout6, iVar, new f(subFeatures, this, meFeature, iVar));
                    LinearLayout linearLayout7 = (LinearLayout) a(a.C0250a.subFeature3);
                    j.a((Object) linearLayout7, "subFeature3");
                    f.a(linearLayout7, iVar, new g(subFeatures, this, meFeature, iVar));
                    LinearLayout linearLayout8 = (LinearLayout) a(a.C0250a.subFeature4);
                    j.a((Object) linearLayout8, "subFeature4");
                    f.a(linearLayout8, iVar, new h(subFeatures, this, meFeature, iVar));
                }
                CharSequence a2 = subFeatures.a();
                if (a2 == null || a2.length() == 0) {
                    z = true;
                }
                if (!z) {
                    ((CustomMeFeatureView) a(a.C0250a.customMeFeatureView)).setValue(subFeatures.a());
                    return;
                }
                return;
            }
            throw new AssertionError("Assertion failed");
        }
    }

    /* access modifiers changed from: private */
    public final void a(i iVar, MeFeature meFeature, MeFeature meFeature2) {
        NavigationPath a2 = NavigationPath.a(meFeature.getRedirectUrl());
        com.shopee.navigator.e q = iVar.q();
        Context context = getContext();
        if (context != null) {
            q.a((Activity) context, a2);
            ((CustomMeFeatureView) a(a.C0250a.customMeFeatureView)).a(iVar.m(), meFeature2);
            if (iVar instanceof b.a) {
                com.shopee.app.ui.home.me.tracking.d h2 = iVar.h();
                if (h2 != null) {
                    h2.a(meFeature, "self_design_circle");
                }
            } else if (iVar instanceof k.a) {
                com.shopee.app.ui.home.me.tracking.seller.b i = iVar.i();
                if (i != null) {
                    i.a(meFeature, "self_design_circle");
                }
            }
        } else {
            throw new m("null cannot be cast to non-null type android.app.Activity");
        }
    }
}
