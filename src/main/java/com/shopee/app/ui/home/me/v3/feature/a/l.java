package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.data.store.al;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.app.util.bn;
import com.shopee.arcatch.data.common_bean.Country;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class l extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final l f22570b = new l();

    private l() {
        super("activity", "wallet");
    }

    public boolean a(i iVar) {
        j.b(iVar, "data");
        if (!(iVar instanceof b.a)) {
            return false;
        }
        return bn.a(iVar.j(), iVar.j().getBuyerWalletProvider(), iVar.n().a());
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22571b;

        public void a(MeFeature meFeature) {
        }

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.l$a$a  reason: collision with other inner class name */
        static final class C0337a extends k implements d.d.a.a<p> {
            final /* synthetic */ al $loginStore;
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;
            final /* synthetic */ int $provider;
            final /* synthetic */ boolean $rnNewWallet;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0337a(int i, boolean z, al alVar, i iVar, MeFeature meFeature) {
                super(0);
                this.$provider = i;
                this.$rnNewWallet = z;
                this.$loginStore = alVar;
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                if (this.$provider > 0 && this.$rnNewWallet) {
                    this.$loginStore.u();
                }
                this.$metaData.k().b(this.$provider, this.$rnNewWallet);
                d h = this.$metaData.h();
                if (h != null) {
                    d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22571b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            String str;
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            if (iVar instanceof b.a) {
                int buyerWalletProvider = iVar.j().getBuyerWalletProvider();
                boolean a2 = iVar.n().a();
                String a3 = bn.a(buyerWalletProvider, a2);
                boolean isLoggedIn = iVar.j().isLoggedIn();
                al l = iVar.l();
                setIcon(bn.b(buyerWalletProvider, a2));
                setShowNewLabel(isLoggedIn && l.t() && a2 && getUser().getBuyerWalletProvider() > 0);
                setText(a3);
                if (isLoggedIn) {
                    b.a aVar = (b.a) iVar;
                    if (aVar.d() > 0 && j.a((Object) "ID", (Object) Country.COUNTRY_VN)) {
                        str = bn.a(aVar.d(), getUser().getBuyerWalletProvider(), a2);
                        setValue(str);
                        f.a(this, iVar, new C0337a(buyerWalletProvider, a2, l, iVar, meFeature));
                    }
                }
                if (isLoggedIn) {
                    b.a aVar2 = (b.a) iVar;
                    if (aVar2.c() > 0) {
                        str = bn.a(aVar2.c(), getUser().getBuyerWalletProvider(), a2);
                        setValue(str);
                        f.a(this, iVar, new C0337a(buyerWalletProvider, a2, l, iVar, meFeature));
                    }
                }
                str = "";
                setValue(str);
                f.a(this, iVar, new C0337a(buyerWalletProvider, a2, l, iVar, meFeature));
            }
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
