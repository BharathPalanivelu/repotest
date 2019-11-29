package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.data.store.setting.ShopeeCreditConfigs;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;

public final class p extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final p f22578b = new p();

    private p() {
        super("activity", "credit_entrance");
    }

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        if (!(iVar instanceof b.a)) {
            return false;
        }
        boolean a2 = iVar.o().a("shopee_kredit");
        ShopeeCreditConfigs shopeeCreditConfigs = iVar.p().getShopeeCreditConfigs();
        j.a((Object) shopeeCreditConfigs, "metaData.settingConfigStore.shopeeCreditConfigs");
        boolean isEnabled = shopeeCreditConfigs.isEnabled();
        if (!iVar.j().isLoggedIn() || !a2 || !isEnabled) {
            return false;
        }
        return true;
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22579b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.p$a$a  reason: collision with other inner class name */
        static final class C0341a extends k implements d.d.a.a<d.p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0341a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return d.p.f32714a;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x001b, code lost:
                if (r1 != null) goto L_0x0020;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a() {
                /*
                    r4 = this;
                    com.shopee.app.ui.home.me.v3.feature.i r0 = r4.$metaData
                    com.shopee.app.data.store.al r0 = r0.l()
                    r0.w()
                    com.shopee.app.ui.home.me.v3.feature.i r0 = r4.$metaData
                    com.shopee.app.util.ak r0 = r0.k()
                    com.shopee.app.ui.home.me.v3.feature.i r1 = r4.$metaData
                    com.shopee.app.ui.home.me.v3.feature.b$a r1 = (com.shopee.app.ui.home.me.v3.feature.b.a) r1
                    com.shopee.app.network.http.data.kredit.CreditData r1 = r1.g()
                    if (r1 == 0) goto L_0x001e
                    java.lang.String r1 = r1.partnersLink
                    if (r1 == 0) goto L_0x001e
                    goto L_0x0020
                L_0x001e:
                    java.lang.String r1 = ""
                L_0x0020:
                    r0.x(r1)
                    com.shopee.app.ui.home.me.v3.feature.i r0 = r4.$metaData
                    com.shopee.app.ui.home.me.tracking.d r0 = r0.h()
                    if (r0 == 0) goto L_0x0032
                    com.shopee.app.ui.home.me.v3.feature.MeFeature r1 = r4.$meFeature
                    r2 = 2
                    r3 = 0
                    com.shopee.app.ui.home.me.tracking.d.a(r0, r1, r3, r2, r3)
                L_0x0032:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.me.v3.feature.a.p.a.C0341a.a():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22579b = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
            if (r0 != null) goto L_0x003d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.shopee.app.ui.home.me.v3.feature.i r4, com.shopee.app.ui.home.me.v3.feature.MeFeature r5) {
            /*
                r3 = this;
                java.lang.String r0 = "metaData"
                d.d.b.j.b(r4, r0)
                java.lang.String r0 = "meFeature"
                d.d.b.j.b(r5, r0)
                boolean r0 = r4 instanceof com.shopee.app.ui.home.me.v3.feature.b.a
                if (r0 == 0) goto L_0x0083
                com.shopee.app.data.store.SettingConfigStore r0 = r4.p()
                com.shopee.app.data.store.setting.ShopeeCreditConfigs r0 = r0.getShopeeCreditConfigs()
                java.lang.String r1 = "metaData.settingConfigStore.shopeeCreditConfigs"
                d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.String r0 = r0.getTitle()
                r3.setText(r0)
                com.shopee.app.data.store.al r0 = r4.l()
                boolean r0 = r0.v()
                r3.setShowNewLabel(r0)
                r0 = r4
                com.shopee.app.ui.home.me.v3.feature.b$a r0 = (com.shopee.app.ui.home.me.v3.feature.b.a) r0
                com.shopee.app.network.http.data.kredit.CreditData r0 = r0.g()
                if (r0 == 0) goto L_0x003b
                java.lang.String r0 = r0.displayText
                if (r0 == 0) goto L_0x003b
                goto L_0x003d
            L_0x003b:
                java.lang.String r0 = ""
            L_0x003d:
                r3.setValue(r0)
                r0 = 0
                r2 = r4
                com.shopee.app.ui.home.me.v3.feature.b$a r2 = (com.shopee.app.ui.home.me.v3.feature.b.a) r2     // Catch:{ Exception -> 0x0052 }
                com.shopee.app.network.http.data.kredit.CreditData r2 = r2.g()     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0052
                java.lang.String r2 = r2.displayColor     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0052
                int r0 = android.graphics.Color.parseColor(r2)     // Catch:{ Exception -> 0x0052 }
            L_0x0052:
                r3.setValueColor(r0)
                android.content.Context r0 = r3.f22579b
                com.squareup.a.w r0 = com.squareup.a.w.a((android.content.Context) r0)
                com.shopee.app.data.store.SettingConfigStore r2 = r4.p()
                com.shopee.app.data.store.setting.ShopeeCreditConfigs r2 = r2.getShopeeCreditConfigs()
                d.d.b.j.a((java.lang.Object) r2, (java.lang.String) r1)
                java.lang.String r1 = r2.getLogo()
                com.squareup.a.aa r0 = r0.a((java.lang.String) r1)
                int r1 = com.shopee.app.a.C0250a.icon_view
                android.view.View r1 = r3.a((int) r1)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r0.a((android.widget.ImageView) r1)
                com.shopee.app.ui.home.me.v3.feature.a.p$a$a r0 = new com.shopee.app.ui.home.me.v3.feature.a.p$a$a
                r0.<init>(r4, r5)
                d.d.a.a r0 = (d.d.a.a) r0
                com.shopee.app.ui.home.me.v3.feature.f.a(r3, r4, r0)
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.me.v3.feature.a.p.a.a(com.shopee.app.ui.home.me.v3.feature.i, com.shopee.app.ui.home.me.v3.feature.MeFeature):void");
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22579b.getResources().getDrawable(R.drawable.me_page_option_place_holder));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
