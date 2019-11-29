package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.app.d.c.aj;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class p extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialTabView f24563a;

    /* renamed from: b  reason: collision with root package name */
    a f24564b;

    /* renamed from: c  reason: collision with root package name */
    i f24565c;

    /* renamed from: d  reason: collision with root package name */
    bc f24566d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24567e;

    /* renamed from: f  reason: collision with root package name */
    private final long f24568f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24569g;

    interface b {
        void a(p pVar);
    }

    public p(Context context, int i, long j, int i2) {
        super(context);
        this.f24567e = i;
        this.f24568f = j;
        this.f24569g = i2;
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24566d.a(this.f24565c);
        this.f24565c.a(this);
        this.f24564b = new a(this.f24567e, this.f24568f);
        this.f24563a.setAdapter(this.f24564b);
        if (this.f24564b.b() <= 1) {
            this.f24563a.setShadowOffset(0);
        } else {
            this.f24563a.setTabIndicator(new ap(this.f24564b.b()));
        }
        this.f24563a.setSelectedIndex(this.f24569g);
        this.f24563a.a();
        this.f24565c.a(this.f24567e, this.f24568f);
    }

    public void a(aj.b bVar) {
        this.f24564b.a(bVar.f16472c, bVar.f16473d);
        this.f24563a.a();
    }

    private static class a extends com.garena.android.uikit.a.a {

        /* renamed from: c  reason: collision with root package name */
        private final int f24570c;

        /* renamed from: d  reason: collision with root package name */
        private final long f24571d;

        /* renamed from: e  reason: collision with root package name */
        private int f24572e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f24573f = 0;

        public View a(Context context) {
            return null;
        }

        public int b() {
            return 1;
        }

        a(int i, long j) {
            this.f24570c = i;
            this.f24571d = j;
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            ao aoVar = new ao(context);
            if (i != 0) {
                aoVar.setTitle(com.garena.android.appkit.tools.b.a(R.string.sp_label_buyer_rating_only, Integer.valueOf(this.f24573f)));
            } else {
                aoVar.setTitle(com.garena.android.appkit.tools.b.a(R.string.sp_label_view_all, Integer.valueOf(this.f24572e)));
            }
            if (b() <= 1) {
                aoVar.setVisibility(8);
            }
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (i != 0) {
                return n.a(context, this.f24570c, this.f24571d, 0);
            }
            return n.a(context, this.f24570c, this.f24571d, 10);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            this.f24572e = i;
            this.f24573f = i2;
        }
    }
}
