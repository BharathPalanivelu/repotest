package com.shopee.app.ui.home.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.afollestad.materialdialogs.f;
import com.garena.android.uikit.a.a.a;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.h.q;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.common.b;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class m extends a implements SwipeRefreshLayout.b {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f22079a;

    /* renamed from: b  reason: collision with root package name */
    b f22080b;

    /* renamed from: c  reason: collision with root package name */
    View f22081c;

    /* renamed from: d  reason: collision with root package name */
    p f22082d;

    /* renamed from: e  reason: collision with root package name */
    k f22083e;

    /* renamed from: f  reason: collision with root package name */
    r f22084f;

    /* renamed from: g  reason: collision with root package name */
    ak f22085g;
    Activity h;
    bc i;
    com.shopee.app.ui.actionbar.a j;
    ActivityCounter k;
    com.shopee.app.tracking.trackingv3.b l;
    com.shopee.app.a.a.a m;
    private ae n;
    private View o;
    private final int p;
    private RecyclerViewImpressionObserver q;
    private a.b r = new a.b("ACTION_REQUIRED_READ_ALL_ACTIVE", com.garena.android.appkit.tools.b.e(R.string.sp_label_read_all)) {
        public void a() {
            com.shopee.app.ui.dialog.a.a(m.this.getContext(), 0, (int) R.string.sp_label_read_all_activity, (int) R.string.sp_label_read_all_cancel, (int) R.string.sp_label_read_all_confirm, (f.b) new f.b() {
                public void onPositive(f fVar) {
                    m.this.f22083e.i();
                }
            });
        }
    };
    private a.b s = new a.b("ACTION_REQUIRED_READ_ALL_INACTIVE", com.garena.android.appkit.tools.b.e(R.string.sp_label_read_all), R.color.black26) {
        public void a() {
        }
    };

    public m(Context context, int i2) {
        super(context);
        ((e) ((x) context).b()).a(this);
        this.p = i2;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.i.a(this.f22083e);
        this.f22083e.a(this);
        this.f22080b.a(R.string.sp_already_a_user_activity, R.drawable.ic_no_activity);
        this.f22079a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f22079a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.n = new ae(this.f22079a, this.f22082d);
        this.n.a((ae.a) this.f22083e);
        this.f22082d.setHasStableIds(true);
        this.q = com.shopee.app.tracking.a.a.a(this.f22079a, this.l, 3, this.p);
        this.f22082d.a(this.q);
        this.m.a(this.q);
        this.f22079a.setAdapter(this.f22082d);
        this.f22083e.a(this.p);
    }

    public void a(List<ActivityItemInfo> list) {
        this.f22082d.a(list);
        this.f22082d.notifyItemRangeChanged(0, list.size());
        int i2 = 0;
        for (ActivityItemInfo activityItemType : list) {
            if (activityItemType.getActivityItemType() == 1) {
                i2++;
            }
        }
        if (this.f22083e.f()) {
            int i3 = 8;
            if (this.o != null) {
                this.o.setVisibility(i2 < 1 ? 0 : 8);
            }
            if (i2 >= 1) {
                i3 = 0;
            }
            this.f22079a.setVisibility(i3);
            if (i2 < 1) {
                this.n.a(com.garena.android.appkit.tools.b.a(R.color.background));
                return;
            }
            m();
            this.n.a(com.garena.android.appkit.tools.b.a(R.color.white));
        }
    }

    public void e() {
        this.o = findViewById(R.id.emptyView);
    }

    public void a(ActivityItemInfo activityItemInfo) {
        com.shopee.app.tracking.a.a.a(this.l, 3, this.p, activityItemInfo);
        this.f22083e.f(activityItemInfo.getActivityId());
        switch (activityItemInfo.getType()) {
            case 0:
                this.f22085g.b(activityItemInfo.getShopId());
                return;
            case 1:
                this.f22085g.b(activityItemInfo.getShopId(), activityItemInfo.getItemId());
                return;
            case 2:
                int updateType = activityItemInfo.getUpdateType();
                if (updateType == 0) {
                    return;
                }
                if (updateType == 1 || updateType == 2) {
                    this.f22085g.b(activityItemInfo.getShopId(), activityItemInfo.getItemId());
                    return;
                }
                return;
            case 3:
                this.f22085g.b(activityItemInfo.getItemId(), activityItemInfo.getShopId(), 1);
                return;
            case 4:
                this.f22085g.b(activityItemInfo.getItemId(), activityItemInfo.getShopId(), 1);
                return;
            case 5:
                this.f22085g.b(activityItemInfo.getShopId());
                return;
            case 6:
                this.f22085g.b(activityItemInfo.getShopId(), activityItemInfo.getItemId());
                return;
            case 7:
                this.f22085g.n(activityItemInfo.getRedirectUrl());
                return;
            case 8:
                this.f22085g.c(activityItemInfo.getFeedId(), activityItemInfo.getShopId());
                return;
            case 9:
                this.f22085g.c(activityItemInfo.getFeedId(), activityItemInfo.getShopId());
                return;
            default:
                return;
        }
    }

    public void f() {
        this.f22084f.a();
    }

    public void g() {
        this.f22084f.b();
    }

    public void a() {
        this.f22083e.g();
        com.shopee.app.tracking.a.a.a(this.l, 3, this.p);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.q;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStart();
        }
    }

    public void b() {
        this.f22083e.h();
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.q;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStop();
        }
    }

    public void h() {
        this.f22080b.setVisibility(0);
        this.f22079a.setVisibility(8);
    }

    public void i() {
        this.f22080b.setVisibility(8);
        this.f22079a.setVisibility(0);
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void j() {
        this.n.c();
    }

    public void k() {
        this.n.b();
    }

    public void l() {
        this.f22081c.setVisibility(0);
    }

    public void m() {
        this.f22081c.setVisibility(8);
    }

    public void onRefresh() {
        this.f22083e.e();
        this.f22083e.a(this.p);
    }

    public void a(int i2) {
        this.f22082d.d(i2);
        this.f22082d.notifyDataSetChanged();
    }

    public void b(int i2) {
        this.f22082d.e(i2);
        this.f22082d.notifyDataSetChanged();
    }
}
