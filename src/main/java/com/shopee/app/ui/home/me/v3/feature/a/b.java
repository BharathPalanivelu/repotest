package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final b f22546b = new b();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private b() {
        super("miscellaneous", "help_center");
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22547b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.b$a$a  reason: collision with other inner class name */
        static final class C0330a extends k implements d.d.a.b<View, p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0330a(i iVar, MeFeature meFeature) {
                super(1);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* bridge */ /* synthetic */ Object a(Object obj) {
                a((View) obj);
                return p.f32714a;
            }

            public final void a(View view) {
                this.$metaData.k().ae();
                d h = this.$metaData.h();
                if (h != null) {
                    d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22547b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            com.shopee.app.e.b.a((View) this, (d.d.a.b<? super View, p>) new C0330a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22547b.getResources().getDrawable(R.drawable.ic_me_help));
            setText(this.f22547b.getResources().getString(R.string.sp_help_centre));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
