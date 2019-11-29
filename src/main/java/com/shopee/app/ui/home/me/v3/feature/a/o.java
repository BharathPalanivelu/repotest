package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class o extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final o f22576b = new o();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private o() {
        super("activity", "shopee_coins");
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22577b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.o$a$a  reason: collision with other inner class name */
        static final class C0340a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0340a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().aj();
                d h = this.$metaData.h();
                if (h != null) {
                    d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22577b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            String str;
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            if (iVar instanceof b.a) {
                if (iVar.j().isLoggedIn()) {
                    b.a aVar = (b.a) iVar;
                    if (aVar.e() != null) {
                        str = com.garena.android.appkit.tools.b.a(R.string.sp_x_coins, aVar.e());
                        setValue(str);
                        setShowTitleDrawable(false);
                    }
                }
                str = "";
                setValue(str);
                setShowTitleDrawable(false);
            }
            f.a(this, iVar, new C0340a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22577b.getResources().getDrawable(R.drawable.ic_me_coins));
            setText(this.f22577b.getResources().getString(R.string.sp_shopee_coins));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
