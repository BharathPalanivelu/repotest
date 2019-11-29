package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.k;
import d.p;

public final class j extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final j f22566b = new j();

    public boolean a(i iVar) {
        d.d.b.j.b(iVar, "metaData");
        return true;
    }

    private j() {
        super("miscellaneous", "account_setting");
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22567b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.j$a$a  reason: collision with other inner class name */
        static final class C0335a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0335a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().R();
                d h = this.$metaData.h();
                if (h != null) {
                    d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22567b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            d.d.b.j.b(iVar, "metaData");
            d.d.b.j.b(meFeature, "meFeature");
            f.a(this, iVar, new C0335a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22567b.getResources().getDrawable(R.drawable.ic_me_account));
            setText(this.f22567b.getResources().getString(R.string.sp_account_settings));
        }
    }

    public View a(Context context) {
        d.d.b.j.b(context, "context");
        return new a(context, context);
    }
}
