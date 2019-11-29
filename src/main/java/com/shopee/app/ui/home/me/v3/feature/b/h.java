package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.tracking.seller.b;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class h extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final h f22605b = new h();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private h() {
        super("others", "my_shipping");
    }

    public static final class a extends OptionRow implements com.shopee.app.ui.home.me.v3.feature.h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22606b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.b.h$a$a  reason: collision with other inner class name */
        static final class C0348a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0348a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().Q();
                b i = this.$metaData.i();
                if (i != null) {
                    b.a(i, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22606b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            f.a(this, iVar, new C0348a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22606b.getResources().getDrawable(R.drawable.ic_me_shipping));
            setText(this.f22606b.getString(R.string.sp_label_my_logistics));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
