package com.shopee.app.ui.customer.list;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.z;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class e extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ListView f21414a;

    /* renamed from: b  reason: collision with root package name */
    d f21415b;

    /* renamed from: c  reason: collision with root package name */
    bc f21416c;

    /* renamed from: d  reason: collision with root package name */
    r f21417d;

    /* renamed from: e  reason: collision with root package name */
    ak f21418e;

    /* renamed from: f  reason: collision with root package name */
    b f21419f;

    /* renamed from: g  reason: collision with root package name */
    private p f21420g;

    public interface a {
        void a(e eVar);
    }

    public e(Context context) {
        super(context);
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21416c.a(this.f21415b);
        this.f21415b.a(this);
        this.f21414a.setAdapter(this.f21419f);
        this.f21414a.setEmptyView(findViewById(R.id.emptyView));
        this.f21420g = new p(this.f21414a);
        this.f21420g.a((p.a) this.f21415b);
        this.f21415b.e();
    }

    public void b() {
        this.f21417d.a();
    }

    public void c() {
        this.f21417d.b();
    }

    public void a(List<UserBriefInfo> list) {
        if (list != null) {
            this.f21419f.a(list);
            this.f21419f.notifyDataSetChanged();
        }
    }

    public void a(UserBriefInfo userBriefInfo) {
        this.f21418e.a(userBriefInfo.getUserId(), userBriefInfo.getShopId(), "", userBriefInfo.getUserName());
    }

    public void d() {
        this.f21420g.c();
    }

    public void e() {
        this.f21420g.b();
    }

    public void f() {
        this.f21420g.d();
    }

    public static class b extends z<UserBriefInfo> {
        protected b() {
        }

        /* access modifiers changed from: protected */
        public n<UserBriefInfo> a(Context context, int i) {
            return c.a(context);
        }
    }
}
