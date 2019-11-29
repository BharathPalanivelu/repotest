package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
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

public final class d extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final d f22550b = new d();

    private d() {
        super("order", "my_groups");
    }

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        if (iVar instanceof b.a) {
            return iVar.o().a("group_buy");
        }
        return false;
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22551b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.d$a$a  reason: collision with other inner class name */
        static final class C0332a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0332a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().o();
                com.shopee.app.ui.home.me.tracking.d h = this.$metaData.h();
                if (h != null) {
                    com.shopee.app.ui.home.me.tracking.d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22551b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            String str;
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            if (iVar instanceof b.a) {
                b.a aVar = (b.a) iVar;
                if (aVar.b() <= 0) {
                    str = "";
                } else if (aVar.b() == 1) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_1_on_going_groups);
                } else {
                    str = com.garena.android.appkit.tools.b.a(R.string.sp_x_on_going_groups, Integer.valueOf(aVar.b()));
                }
                setValue(str);
            }
            f.a(this, iVar, new C0332a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22551b.getResources().getDrawable(R.drawable.ic_me_mygroups));
            setText(this.f22551b.getResources().getString(R.string.sp_my_groups));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
