package com.shopee.app.ui.home.follow;

import android.app.Activity;
import android.content.Context;
import android.view.ViewTreeObserver;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.ui.a.a;
import com.shopee.app.ui.common.b;
import com.shopee.app.ui.common.f;
import com.shopee.app.ui.home.e;
import com.shopee.app.ui.home.follow.a.c;
import com.shopee.app.ui.webview.g;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bl;
import com.shopee.app.util.i;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class FollowTab extends a implements SwipeRefreshLayout.b {

    /* renamed from: a  reason: collision with root package name */
    g f22197a;

    /* renamed from: b  reason: collision with root package name */
    b f22198b;

    /* renamed from: c  reason: collision with root package name */
    a f22199c;

    /* renamed from: d  reason: collision with root package name */
    bc f22200d;

    /* renamed from: e  reason: collision with root package name */
    Activity f22201e;

    /* renamed from: f  reason: collision with root package name */
    ak f22202f;

    /* renamed from: g  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f22203g;
    private boolean h = false;

    public FollowTab(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f22200d.a(this.f22199c);
        this.f22199c.a(this);
        this.f22197a.setTag(R.id.home_web_tag, 1);
        this.f22198b.a(R.string.sp_already_a_user_follow, R.drawable.ic_no_user);
        this.f22197a.setOnRefreshListener(this);
        this.f22203g = new c(this, new com.shopee.app.ui.home.follow.a.b(this.f22201e, this.f22197a));
        j();
    }

    private boolean i() {
        if (this.h) {
            return false;
        }
        this.h = true;
        this.f22199c.g();
        return true;
    }

    public void a() {
        super.a();
        i();
        this.f22197a.setDetachable(true);
        this.f22197a.getPresenter().c();
        this.f22197a.c(1);
        this.f22199c.e();
        j();
    }

    public void b() {
        super.b();
        com.garena.android.uikit.a.c cVar = (com.garena.android.uikit.a.c) this.f22201e.findViewById(R.id.sp_home_tab_view);
        this.f22197a.getPresenter().d();
        this.f22197a.d(1);
        this.f22199c.f();
        k();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f22198b.setVisibility(8);
        this.f22197a.setVisibility(0);
        g gVar = this.f22197a;
        gVar.b(new WebPageModel(i.f7040c + "timeline/"));
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f22198b.setVisibility(8);
        this.f22197a.setVisibility(0);
        this.f22197a.b(new WebPageModel(bl.f7034a.c()));
    }

    public void g() {
        if (!i()) {
            this.f22197a.b();
        }
    }

    public void h() {
        if (!i()) {
            this.f22197a.onRefresh();
        }
    }

    public void a(boolean z) {
        f fVar = (f) this.f22201e.findViewById(R.id.sp_bottom_navigation_layout).findViewWithTag("TAB:1");
        if (fVar != null) {
            fVar.setNumberDot(z ? 1 : 0);
        }
    }

    public void onRefresh() {
        this.f22199c.h();
    }

    private void j() {
        this.f22201e.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.f22203g);
    }

    private void k() {
        this.f22201e.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f22203g);
    }
}
