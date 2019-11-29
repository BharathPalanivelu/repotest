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
import com.shopee.id.R;
import com.shopee.protocol.shop.WalletProvider;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class q extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final q f22580b = new q();

    private q() {
        super("activity", "airpay_vn_wallet");
    }

    public boolean a(i iVar) {
        j.b(iVar, "data");
        if (!(iVar instanceof b.a)) {
            return false;
        }
        int buyerWalletProvider = iVar.j().getBuyerWalletProvider();
        if (!j.a((Object) "ID", (Object) Country.COUNTRY_VN) || !iVar.n().a() || buyerWalletProvider != WalletProvider.AIRPAY_WALLET.getValue()) {
            return false;
        }
        return true;
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22581b;

        public void a(MeFeature meFeature) {
        }

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.q$a$a  reason: collision with other inner class name */
        static final class C0342a extends k implements d.d.a.a<p> {
            final /* synthetic */ int $airpayProvider;
            final /* synthetic */ al $loginStore;
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;
            final /* synthetic */ boolean $rnNewWallet;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0342a(int i, boolean z, al alVar, i iVar, MeFeature meFeature) {
                super(0);
                this.$airpayProvider = i;
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
                if (this.$airpayProvider > 0 && this.$rnNewWallet) {
                    this.$loginStore.u();
                }
                this.$metaData.k().aq();
                d h = this.$metaData.h();
                if (h != null) {
                    d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22581b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            String str;
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            if (iVar instanceof b.a) {
                int value = WalletProvider.AIRPAY_WALLET.getValue();
                boolean a2 = iVar.n().a();
                boolean isLoggedIn = iVar.j().isLoggedIn();
                al l = iVar.l();
                setIcon(com.garena.android.appkit.tools.b.f(R.drawable.ic_me_airpaywallet));
                setText(com.garena.android.appkit.tools.b.e(R.string.sp_my_airpay_wallet));
                setShowNewLabel(isLoggedIn && l.t() && a2 && getUser().getBuyerWalletProvider() > 0);
                if (isLoggedIn) {
                    b.a aVar = (b.a) iVar;
                    if (aVar.c() > 0) {
                        str = bn.a(aVar.c(), getUser().getBuyerWalletProvider(), a2);
                        setValue(str);
                        f.a(this, iVar, new C0342a(value, a2, l, iVar, meFeature));
                    }
                }
                str = "";
                setValue(str);
                f.a(this, iVar, new C0342a(value, a2, l, iVar, meFeature));
            }
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
