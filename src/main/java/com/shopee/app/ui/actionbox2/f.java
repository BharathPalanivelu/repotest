package com.shopee.app.ui.actionbox2;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.afollestad.materialdialogs.f;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.ui.a.w;
import com.shopee.app.ui.a.x;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.common.b;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.id.R;
import com.shopee.navigator.e;
import java.util.List;

public class f extends com.garena.android.uikit.a.a.a implements x.a<ActionContentInfo>, x.b<ActionContentInfo, ActionContentInfo> {
    private a A = new a();
    private RecyclerViewImpressionObserver B;

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f19417a;

    /* renamed from: b  reason: collision with root package name */
    b f19418b;

    /* renamed from: c  reason: collision with root package name */
    View f19419c;

    /* renamed from: d  reason: collision with root package name */
    View f19420d;

    /* renamed from: e  reason: collision with root package name */
    TextView f19421e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f19422f;

    /* renamed from: g  reason: collision with root package name */
    d f19423g;
    i h;
    ak i;
    e j;
    SettingConfigStore k;
    Activity l;
    com.shopee.app.ui.actionbar.a m;
    r n;
    bc o;
    ActivityCounter p;
    MeCounter q;
    ActionRequiredCounter r;
    com.shopee.app.tracking.a s;
    m t;
    com.shopee.app.data.store.b u;
    com.shopee.app.tracking.trackingv3.b v;
    com.shopee.app.a.a.a w;
    private final int x;
    private ae y;
    /* access modifiers changed from: private */
    public a z;

    /* renamed from: b */
    public void a(View view, ActionContentInfo actionContentInfo) {
    }

    public f(Context context, int i2) {
        super(context);
        this.x = i2;
        ((com.shopee.app.ui.home.e) ((com.shopee.app.util.x) context).b()).a(this);
    }

    public void d() {
        this.o.a(this.f19423g);
        this.f19423g.a(this);
        this.f19418b.a(R.string.sp_already_a_user_me, R.drawable.ic_no_activity);
        if (this.t.a()) {
            this.f19418b.setVisibility(8);
            this.f19417a.setVisibility(0);
        } else {
            this.f19418b.setVisibility(0);
            this.f19417a.setVisibility(8);
        }
        this.f19417a.setLayoutManager(new LinearLayoutManager(getContext()));
        ((s) this.f19417a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.B = com.shopee.app.tracking.a.a.a(this.f19417a, this.v, this.x, -1);
        this.h = new j(this.B);
        this.w.a(this.B);
        o();
        this.h.a(this);
        this.h.a(this);
        this.y = new ae(this.f19417a, this.h);
        this.y.a((ae.a) this.f19423g);
        p();
        g();
        a(this.q);
        this.f19417a.setAdapter(this.h);
        this.f19423g.a(this.x);
    }

    private void o() {
        if (this.x == 4) {
            this.z = b.a(getContext());
            this.h.a((w.a) new w.a() {
                public View a() {
                    return f.this.z;
                }
            });
        }
    }

    private void p() {
        switch (this.x) {
            case 1:
                this.f19421e.setText(R.string.sp_no_shopee_promotion_yet);
                this.f19422f.setImageResource(R.drawable.ic_no_activity);
                return;
            case 2:
                this.f19421e.setText(R.string.Sp_no_sellerinfo_yet);
                this.f19422f.setImageResource(R.drawable.ic_no_product);
                return;
            case 4:
                this.f19421e.setText(R.string.sp_no_notification);
                this.f19422f.setImageResource(R.drawable.ic_no_activity);
                return;
            case 6:
                this.f19421e.setText(R.string.sp_no_shopee_updates_yet);
                this.f19422f.setImageResource(R.drawable.ic_no_activity);
                return;
            case 7:
                this.f19421e.setText(R.string.sp_label_empty_ratings);
                this.f19422f.setImageResource(R.drawable.ic_no_activity);
                return;
            case 8:
                this.f19421e.setText(R.string.sp_no_wallet_yet);
                this.f19422f.setImageResource(R.drawable.ic_no_activity);
                return;
            case 9:
                this.f19421e.setText(R.string.sp_paid_ads);
                this.f19422f.setImageResource(R.drawable.ic_no_product);
                return;
            case 10:
                this.f19421e.setText(R.string.sp_no_social_updates_yet);
                this.f19422f.setImageResource(R.drawable.ic_no_activity);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        int i2 = 0;
        if (this.x != 4) {
            this.f19420d.setVisibility(this.h.b() ? 0 : 8);
            RecyclerView recyclerView = this.f19417a;
            if (this.h.b()) {
                i2 = 8;
            }
            recyclerView.setVisibility(i2);
            return;
        }
        if (this.h.b()) {
            i2 = 8;
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.setReadAllViewVisibility(i2);
        }
        if (this.h.b()) {
            this.f19417a.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
        } else {
            this.f19417a.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.transparent));
        }
    }

    private void r() {
        if (this.x == 4) {
            a aVar = this.z;
            if (aVar != null) {
                aVar.r();
            }
        }
    }

    public void a(List<ActionContentInfo> list) {
        a aVar = this.A;
        aVar.f19429b = list;
        if (!aVar.f19428a) {
            a aVar2 = this.A;
            aVar2.f19428a = true;
            postDelayed(aVar2, 200);
        }
    }

    public void a(int i2, String str) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.a(i2, str);
        }
    }

    public void a(String str) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    public void e() {
        this.n.a();
    }

    public void f() {
        this.n.b();
    }

    public void g() {
        r();
        int count = this.r.getCount() + this.p.getCount();
        View findViewById = this.l.findViewById(R.id.sp_bottom_navigation_layout);
        if (findViewById != null) {
            com.shopee.app.ui.common.f fVar = (com.shopee.app.ui.common.f) findViewById.findViewWithTag("TAB:3");
            if (fVar != null) {
                fVar.setNumber(Integer.valueOf(count));
            }
        }
    }

    public void h() {
        this.y.c();
    }

    public void i() {
        this.y.b();
    }

    public void j() {
        this.f19419c.setVisibility(0);
    }

    public void k() {
        this.f19419c.setVisibility(8);
    }

    public void l() {
        if (this.x == 4) {
            com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_label_read_all_order_actions, (int) R.string.sp_label_read_all_cancel, (int) R.string.sp_label_read_all_confirm, (f.b) new f.b() {
                public void onPositive(com.afollestad.materialdialogs.f fVar) {
                    f.this.f19423g.l();
                }
            });
        }
    }

    public void m() {
        this.f19423g.c();
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.B;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStart();
        }
    }

    public void n() {
        this.f19423g.d();
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.B;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStop();
        }
    }

    public void a() {
        this.f19423g.c();
        com.shopee.app.tracking.a.a.a(this.v, this.x, -1);
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.B;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStart();
        }
    }

    public void b() {
        this.f19423g.d();
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = this.B;
        if (recyclerViewImpressionObserver != null) {
            recyclerViewImpressionObserver.onStop();
        }
    }

    public void a(ActionContentInfo actionContentInfo, boolean z2, int i2) {
        com.shopee.app.tracking.a.a.a(this.v, this.x, -1, actionContentInfo, z2, i2, this.z != null);
        this.f19423g.a(actionContentInfo, z2);
        this.f19423g.e(actionContentInfo.getUnreadId());
    }

    public void a(View view, ActionContentInfo actionContentInfo, int i2, int i3) {
        this.f19423g.e(actionContentInfo.getUnreadId());
        this.f19423g.f();
        this.s.a(actionContentInfo.getId());
        this.s.a(actionContentInfo.getId(), actionContentInfo.getActionType(), actionContentInfo.getActionCategory(), actionContentInfo.isUnread(), i2);
        com.shopee.app.tracking.a.a.a(this.v, this.x, -1, actionContentInfo, i3, this.z != null);
        com.shopee.app.g.a.a(actionContentInfo, this.i, this.j, this.k);
    }

    public void a(View view, ActionContentInfo actionContentInfo, int i2, int i3, int i4) {
        this.s.a(actionContentInfo.getId());
        this.s.a(actionContentInfo.getId(), actionContentInfo.getActionType(), actionContentInfo.getActionCategory(), actionContentInfo.isUnread(), i2);
        com.shopee.app.tracking.a.a.a(this.v, this.x, -1, actionContentInfo, i4, this.z != null);
        com.shopee.app.g.a.a(actionContentInfo, this.i, this.j, this.k);
    }

    /* renamed from: a */
    public void b(View view, final ActionContentInfo actionContentInfo) {
        com.shopee.app.ui.dialog.a.a(getContext(), new CharSequence[]{com.garena.android.appkit.tools.b.e(R.string.sp_view_delete)}, (a.c) new a.c() {
            public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                f.this.f19423g.a(actionContentInfo.getId(), actionContentInfo.getGroupId());
            }
        });
    }

    public void a(MeCounter meCounter) {
        com.shopee.app.ui.actionbar.a aVar = this.m;
        if (aVar != null) {
            aVar.a("ACTION_BAR_CART", meCounter.getCartCount());
        }
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f19428a;

        /* renamed from: b  reason: collision with root package name */
        public List<ActionContentInfo> f19429b;

        private a() {
            this.f19428a = false;
        }

        public void run() {
            f.this.h.a(this.f19429b);
            f.this.q();
            this.f19428a = false;
        }
    }
}
