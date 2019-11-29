package com.shopee.app.ui.chat2.order;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.uikit.a.a.b;
import com.garena.android.uikit.a.c;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.id.R;

public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    c f20661a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f20662b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f20663c;

    /* renamed from: d  reason: collision with root package name */
    private a f20664d;

    public d(Context context, int i, int i2) {
        super(context);
        this.f20662b = i;
        this.f20663c = i2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20664d = new a();
        this.f20661a.setTabIndicator(new ap(this.f20664d.b()));
        this.f20661a.setAdapter(this.f20664d);
        this.f20661a.a();
    }

    private class a extends com.garena.android.uikit.a.a {
        public View a(Context context) {
            return null;
        }

        public int b() {
            return 2;
        }

        private a() {
        }

        public b d(Context context, int i) {
            ao aoVar = new ao(context);
            if (i == 0) {
                aoVar.setTitle(com.garena.android.appkit.tools.b.e(R.string.sp_purchases));
            } else if (i == 1) {
                aoVar.setTitle(com.garena.android.appkit.tools.b.e(R.string.sp_sales));
            }
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (i == 0) {
                return g.a(context, 0, d.this.f20663c);
            }
            if (i != 1) {
                return null;
            }
            return g.a(context, d.this.f20662b, 0);
        }
    }
}
