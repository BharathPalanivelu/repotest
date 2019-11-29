package com.shopee.app.ui.activity;

import android.content.Context;
import android.view.View;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.actionbox2.g;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.ui.common.f;
import com.shopee.app.ui.home.a.n;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends MaterialTabView implements r {

    /* renamed from: a  reason: collision with root package name */
    ActivityCounter f19460a;

    /* renamed from: b  reason: collision with root package name */
    ActionRequiredCounter f19461b;

    /* renamed from: d  reason: collision with root package name */
    private i f19462d = b.a(this);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ao f19463e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ao f19464f;

    public d(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
        a aVar = new a();
        setTabIndicator(new ap(aVar.b()));
        setAdapter(aVar);
        a();
        e();
        this.f19462d.a();
    }

    public void b() {
        super.b();
        this.f19462d.c();
    }

    public void c() {
        super.c();
        this.f19462d.d();
    }

    public void d() {
        super.d();
        this.f19462d.b();
    }

    private void e() {
        f badgeView = this.f19463e.getBadgeView();
        if (badgeView != null) {
            badgeView.setNumber(Integer.valueOf(this.f19461b.getCount(2)));
        }
        f badgeView2 = this.f19464f.getBadgeView();
        if (badgeView2 != null) {
            badgeView2.setNumber(Integer.valueOf(this.f19460a.getCount()));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ActivityCounter activityCounter) {
        e();
    }

    /* access modifiers changed from: package-private */
    public void a(ActionRequiredCounter actionRequiredCounter) {
        e();
    }

    private class a extends com.garena.android.uikit.a.a {

        /* renamed from: d  reason: collision with root package name */
        private int[] f19466d;

        public View a(Context context) {
            return null;
        }

        public int b() {
            return 2;
        }

        private a() {
            this.f19466d = new int[]{R.string.sp_label_seller_info, R.string.sp_activities};
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            if (i == 0) {
                d dVar = d.this;
                ao unused = dVar.f19463e = new ao(context, "TAB_POS_" + i);
                d.this.f19463e.setTitle(this.f19466d[i]);
                return d.this.f19463e;
            } else if (i != 1) {
                return null;
            } else {
                d dVar2 = d.this;
                ao unused2 = dVar2.f19464f = new ao(context, "TAB_POS_" + i);
                d.this.f19464f.setTitle(this.f19466d[i]);
                return d.this.f19464f;
            }
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (i == 0) {
                return g.a(context, 2);
            }
            if (i != 1) {
                return n.a(context, -1);
            }
            return n.a(context, -1);
        }
    }
}
