package com.shopee.app.ui.chat2.offer;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.chat2.offer.a.h;
import com.shopee.app.ui.chat2.offer.b.d;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.id.R;

public class c extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f20632b = {b.e(R.string.sp_history), b.e(R.string.sp_make_an_offer)};

    /* renamed from: a  reason: collision with root package name */
    com.garena.android.uikit.a.c f20633a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final boolean f20634c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f20635d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f20636e;

    public c(Context context, int i, int i2, boolean z) {
        super(context);
        this.f20636e = i;
        this.f20635d = i2;
        this.f20634c = z;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a aVar = new a();
        this.f20633a.setAdapter(aVar);
        this.f20633a.setTabIndicator(new ap(aVar.b()));
        this.f20633a.a();
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

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            ao aoVar = new ao(context, c.f20632b[i]);
            aoVar.setTitle(c.f20632b[i]);
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (i == 0) {
                return h.a(context, c.this.f20635d);
            }
            if (i != 1) {
                return d.a(context, c.this.f20636e, c.this.f20635d, c.this.f20634c);
            }
            return d.a(context, c.this.f20636e, c.this.f20635d, c.this.f20634c);
        }
    }
}
